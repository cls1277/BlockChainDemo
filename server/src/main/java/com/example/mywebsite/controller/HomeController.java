package com.example.mywebsite.controller;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mywebsite.entity.*;
import com.example.mywebsite.mapper.ChainMapper;
import com.example.mywebsite.mapper.MoneyMapper;
import com.example.mywebsite.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author cls1277
 * @date 2022-10-02 18:26
 */
@RestController
public class HomeController {
    @Autowired
    private MoneyMapper moneyMapper;

    @PostMapping("/iot")
    public String IOT(@RequestBody String text) {
        text += "\n";
        System.out.println(text);
        String filePath = "E:\\cls1277\\IOT\\data.txt";
        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter(filePath, true);
            fwriter.write(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return "IOT";
    }

    @PostMapping("/getbanlance")
    public int isCorrect(@RequestBody User user) {
        String username = user.getUsername();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        Money money1 = moneyMapper.selectOne(wrapper);
        if(money1==null) {
            System.out.println("error");
        } else {
            return money1.getBalance();
        }
        return 1277;
    }

    @Autowired
    private ChainMapper chainMapper;

    @PostMapping("/getChain")
    public List getChain() {
        List<Chain> chains = chainMapper.selectList(null);
        if(chains==null) {
            System.out.println("error");
            return null;
        }
        for(Chain chain : chains) {
            System.out.println("chain = " + chain);
        }
        return chains;
    }

    @PostMapping("/addChain")
    public Chain addChain(@RequestBody Chain chain) {
        int insert = chainMapper.insert(chain);
        if (insert > 0) {
            System.out.println("success");
            return chain;
        } else {
            System.out.println("fail");
            return null;
        }
    }

    private static final int MAX = 2147483647;
    private static final int DIFF = 4;

    public String getHash(Chain chain) {
        int det = 0;
        String std = "";
        for(int i=0; i<DIFF; i++) {
            std += '0';
        }
        for(int i=0; i<MAX; i++) {
            det += 1;
            String data = "";
            data += String.valueOf(det);
            data += chain.getPrehash();
            data += chain.getCount();
            data += chain.getBlocktime();
            data += chain.getUsername();
            data += chain.getMessage();
            data = Sha256Utils.getSha256Str(data);
            String substr = data.substring(0, DIFF);
            if(substr.equals(std)) {
                return data;
            }
        }
        return "error";
    }

    public String myDecode(String val, String privateKey) throws Exception {
        byte[] vaBase64 = Base64Utils.decode(val);
        byte[] decryptByPrivateKey = RSAUtils.decryptByPrivateKey(vaBase64, privateKey);
        return new String(decryptByPrivateKey);
    }

//    public boolean isCorrect(String )

    @PostMapping("/update")
    public Form updateForm(@RequestBody Form form) throws Exception {
        //?????????????????????????????????

        System.out.println("form = " + form);

        QueryWrapper getpri1 = new QueryWrapper();
        getpri1.eq("username", form.getUsername());
        Money getpri = moneyMapper.selectOne(getpri1);
        String pri = getpri.getPrivatekey();
//        System.out.println(pri);
        pri = pri.substring("-----BEGIN PRIVATE KEY-----".length()+1);
        pri = StringUtils.getBack(pri, "-----END PRIVATE KEY-----");

//        System.out.println("---");
//        System.out.println(pri);
//        System.out.println("---");

        String decode = myDecode(form.getKkey(), pri);
//        System.out.println("decode = " + decode);
        if(!decode.equals(form.getPredata())) {
            System.out.println("Warning:?????????????????????");
            return null;
        }

        //????????????????????????form.money?????????Status??????Spent
        //???????????????????????????
        //???????????????????????????Spent????????????
        int cc = chainMapper.selectCount(null).intValue();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("blockid", cc);
        Chain it = chainMapper.selectOne(wrapper);
        if(it==null) {
            System.out.println("error");
            return null;
        } else {
            // it?????????????????????
            // it1?????????????????????
            // it3???????????????
            QueryWrapper wrapper1 = new QueryWrapper();
            wrapper1.eq("blockid", form.getMoney());
            Chain it1 = chainMapper.selectOne(wrapper1);
            if(it1==null) {
                System.out.println("error");
                return null;
            }

            //?????????????????????????????????
            Chain it2 = it1;
            it2.setStatus("Spent");
//            it2.setMessage(form.getCount()+"???????????????"+form.getMsg());
            chainMapper.update(it2, wrapper1);

            String pre = it.getNowhash();

            if(form.getCount() > 0) {
                int count = form.getCount();
                String prehash = pre;
                cc += 1;
                int blockid = cc;
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                String blocktime = df.format(System.currentTimeMillis());
                String username = form.getUsername();
                String status = "Spent";
                String message = count+"????????????:"+form.getMsg();
                String nowhash = "";
                Chain chain = new Chain(blockid, blocktime, prehash, nowhash, username, count, status, message);
                nowhash = getHash(chain);
                pre = nowhash;
                chain.setNowhash(nowhash);
                chainMapper.insert(chain);
            }

            //?????????????????????
            int count = it1.getCount() - form.getCount();
            if(count > 0) {
                String prehash = pre;
                cc += 1;
                int blockid = cc;
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                String blocktime = df.format(System.currentTimeMillis());
                String username = form.getUsername();
                String status = "UnSpent";
                String message = "????????????";
                String nowhash = "";
                Chain chain = new Chain(blockid, blocktime, prehash, nowhash, username, count, status, message);
                nowhash = getHash(chain);
                pre = nowhash;
                chain.setNowhash(nowhash);
                chainMapper.insert(chain);
            }

            //?????????????????????
            QueryWrapper wrapper2 = new QueryWrapper();
            wrapper2.eq("username", form.getUsername());
            Money money = moneyMapper.selectOne(wrapper2);
            money.setBalance(money.getBalance()-form.getCount());
            moneyMapper.update(money, wrapper2);
        }
        return form;
    }

    private static int payid = 0;

    @PostMapping("/payforit")
    public String payforit(@RequestBody PaymentManagement paymentManagement) throws AlipayApiException {
        payid += 1;
        String test = MyAlipayUtil.createOrderForm(String.valueOf(payid), paymentManagement.getAmount(), paymentManagement.getName());
        return test;
    }
}
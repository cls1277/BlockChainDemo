package com.example.mywebsite.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mywebsite.entity.Money;
import com.example.mywebsite.mapper.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cls1277
 * @date 2022-10-04 10:27
 */
@RestController
public class ChainController {

    @Autowired
    private MoneyMapper moneyMapper;

    @GetMapping("/test")
    public String test() {
        System.out.println("success");
        return "test success";
    }

    @GetMapping("/getpublickey")
    public String getPublic(@RequestParam Money money) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", money.getUsername());
        Money money1 = moneyMapper.selectOne(wrapper);
        return money1.getPublickey();
    }

    @GetMapping("/getprivatekey")
    public String getPrivate(@RequestParam Money money) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", money.getUsername());
        Money money1 = moneyMapper.selectOne(wrapper);
        return money1.getPrivatekey();
    }

    @GetMapping("/getallkey")
    public Money getKey(@RequestParam String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        Money money1 = moneyMapper.selectOne(wrapper);
        return money1;
    }
}

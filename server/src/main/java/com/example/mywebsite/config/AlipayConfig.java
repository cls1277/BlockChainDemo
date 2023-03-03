package com.example.mywebsite.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author cls1277
 * @date 2022-10-04 16:58
 */
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000121676409";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCVQ+zbDAFL5Cs2Y/AuFJ7VRWVtpNkRo8PKEdL8L0KBffFNvwwqAnrg5dt02mwhyrvr/ICrlAc72gURYQDbUcgZdUJ8fggf2+nJULeE4jhrHZdTZuJEnwImnKGRPqFaUfv4TFBPj+P1abo1H5NiFkKYX8/1/itS48fr7jhjboL+PGnCvI/og6TaBNRvdu7+04AiXAe5LBuznPw9nKnAD8GvpDyBvDVJJ4ek15RuGEs0imOjuwtEIPCiLmJ+SJnGmWwkXDSlQochhu91r0AJQolvLevT1eMToH0CBMJWPRrq+4uZeURwma0sa67mFw4izD4SZEAHNgYXoLFqr2wTBNiRAgMBAAECggEAGSDjSgkeWsFhyPlQIOHVz3+sUKYU6RRRzL3tcAkgwB4MtpL4IEZkm2H27RgsZg/0TQkoPDpicWAFxGQ5ObLt5eNIux6YjYx/MiYFjzhqWRYVOLQ0WWsPeKKbzJDnpwXwTl/CkXJe5RzUfUcAj93Bfld68iXE82JncL+c/JhJMzWEczqZCNgOTjpzCSrLHTDOaE2zMp2HPXoyY13z2S/0X3POraQD+AsG75bKPtZJJnU1n54kJQnmrXOBw6StVkYVeTUFh7+44Y1rVA7hjY5GWpoRvboq0ZeGoXgiYKIV9MgnVkvjq5RMJT6KP718cLR6b8UA31gS5ubAyLx31jToQQKBgQDSyrWbBiETkfpjE0EV9d1jV6A9e4bneipzVtWNUyT7GlIION1Ux025mDKF9qmwrqIwuJ61QSvTiHlQma9SV/dRqtuoIs/HkSzojLWYhWvDbQ3qP+ffN3vMNyzFZc7FBlRCcALW1Xjp3nZgwihI8ypaXni6ACDbAGTurDy3m6mdSQKBgQC1RywBfx631qEv9aIhVhcjy/X4x2iZzrnjMebNLv4XRjeuFzMo5kwUqlbpiSuMAP3AsYaofpUm9B0tYprJpjHmJRPlDtgtfm6QhETRerNv7Xbk1XsN3baQPQ4OC5dSXo9iQd32E2nn0Ewkn5yIwr32QnJRmpAdrg/MUMLV0RDJCQKBgC6vjMdX9S1zcGRPGGQ3vx/IgYn8eOV9rjc7bTLOzmr66l490e978OABMHdxKSYjl3J5AVWdqIpCOLQ8RZNUPkeNMvcrNp+5rJuYxoOQUUzIM4PFQaKzlCynr7fMk54Zh8HrMwXH4+7QQaGufuOhT6kSMWTosF4w2SnvZcc4p7lZAoGATJsCBrPgmFG0Fh9YX3wRFUiI7pPeKTlKJq+c2FKmf9FlkEUvknYX6pe9WL1l0KlOkpKy1BuCDk8U0Wwc+2AnMBm1GZQ3WKpYMOwkZN3UXFVea/+nG8n472VNvjO5w85AC4bINMgpdhP5SXTF4qlhO2MDCmclxdUbyfzLCS5rSHkCgYABE3TshGz3G9SFfg09IUPJbEuoXZwyNZemr4zk4DOe/kPRC7+rP01PHxovV2ZIgO9Wm2/eID5CFyf30vNMc1/Hh7m8hwoROB8qGGO/d4t7B18jSwngIFuqT+aTm/OQAYz9OFL8D+thiQvG+/BW7FvDVNaZy77z8xxhFf5RRMuJ4A==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlUPs2wwBS+QrNmPwLhSe1UVlbaTZEaPDyhHS/C9CgX3xTb8MKgJ64OXbdNpsIcq76/yAq5QHO9oFEWEA21HIGXVCfH4IH9vpyVC3hOI4ax2XU2biRJ8CJpyhkT6hWlH7+ExQT4/j9Wm6NR+TYhZCmF/P9f4rUuPH6+44Y26C/jxpwryP6IOk2gTUb3bu/tOAIlwHuSwbs5z8PZypwA/Br6Q8gbw1SSeHpNeUbhhLNIpjo7sLRCDwoi5ifkiZxplsJFw0pUKHIYbvda9ACUKJby3r09XjE6B9AgTCVj0a6vuLmXlEcJmtLGuu5hcOIsw+EmRABzYGF6Cxaq9sEwTYkQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://150.158.93.128/";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://150.158.93.128/";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

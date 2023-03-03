package com.example.mywebsite.entity;

/**
 * @author cls1277
 * @date 2022-10-03 12:54
 */
public class Form {
    private int count;
    private String msg;
    private int money;
    private String username;
    private String kkey;
    private String predata;

    public Form(int count, String msg, int money, String username, String kkey, String predata) {
        this.count = count;
        this.msg = msg;
        this.money = money;
        this.username = username;
        this.kkey = kkey;
        this.predata = predata;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKkey() {
        return kkey;
    }

    public void setKkey(String kkey) {
        this.kkey = kkey;
    }

    @Override
    public String toString() {
        return "Form{" +
                "count=" + count +
                ", msg='" + msg + '\'' +
                ", money=" + money +
                ", username='" + username + '\'' +
                ", kkey='" + kkey + '\'' +
                ", predata='" + predata + '\'' +
                '}';
    }

    public String getPredata() {
        return predata;
    }

    public void setPredata(String predata) {
        this.predata = predata;
    }

    public Form() {
    }
}

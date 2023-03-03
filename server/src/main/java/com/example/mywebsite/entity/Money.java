package com.example.mywebsite.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author cls1277
 * @date 2022-10-03 0:06
 */
@TableName("money")
public class Money {
//    @TableId("username")
    private String username;
    private int balance;
    private String publickey;
    private String privatekey;

    public Money(String username) {
        this.username = username;
    }

    public Money(String username, int balance, String publickey, String privatekey) {
        this.username = username;
        this.balance = balance;
        this.publickey = publickey;
        this.privatekey = privatekey;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    @Override
    public String toString() {
        return "Money{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                ", publickey='" + publickey + '\'' +
                ", privatekey='" + privatekey + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Money() {
    }
}

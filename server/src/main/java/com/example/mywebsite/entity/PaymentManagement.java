package com.example.mywebsite.entity;

/**
 * @author cls1277
 * @date 2022-10-04 17:11
 */
public class PaymentManagement {
    private String id;
    private String amount;
    private String name;

    @Override
    public String toString() {
        return "PaymentManagement{" +
                "id='" + id + '\'' +
                ", amount='" + amount + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentManagement(String id, String amount, String name) {
        this.id = id;
        this.amount = amount;
        this.name = name;
    }

    public PaymentManagement() {
    }
}

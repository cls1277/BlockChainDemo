package com.example.mywebsite.entity;

/**
 * @author cls1277
 * @date 2022-10-03 9:08
 */
public class Chain {
    private int blockid;
    private String blocktime;
    private String prehash;
    private String nowhash;
    private String username;
    private int count;
    private String status;
    private String message;

    @Override
    public String toString() {
        return "Chain{" +
                "blockid=" + blockid +
                ", blocktime='" + blocktime + '\'' +
                ", prehash='" + prehash + '\'' +
                ", nowhash='" + nowhash + '\'' +
                ", username='" + username + '\'' +
                ", count=" + count +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public int getBlockid() {
        return blockid;
    }

    public void setBlockid(int blockid) {
        this.blockid = blockid;
    }

    public String getBlocktime() {
        return blocktime;
    }

    public void setBlocktime(String blocktime) {
        this.blocktime = blocktime;
    }

    public String getPrehash() {
        return prehash;
    }

    public void setPrehash(String prehash) {
        this.prehash = prehash;
    }

    public String getNowhash() {
        return nowhash;
    }

    public void setNowhash(String nowhash) {
        this.nowhash = nowhash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Chain(int blockid, String blocktime, String prehash, String nowhash, String username, int count, String status, String message) {
        this.blockid = blockid;
        this.blocktime = blocktime;
        this.prehash = prehash;
        this.nowhash = nowhash;
        this.username = username;
        this.count = count;
        this.status = status;
        this.message = message;
    }

    public Chain() {
    }
}

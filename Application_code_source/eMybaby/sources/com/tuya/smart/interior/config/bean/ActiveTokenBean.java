package com.tuya.smart.interior.config.bean;

public class ActiveTokenBean {
    public String key;
    public String secret;
    public String token;

    public ActiveTokenBean() {
    }

    public ActiveTokenBean(String str) {
        this.token = str.substring(2, 10);
        this.secret = str.substring(10);
    }

    public String getKey() {
        return this.key;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getToken() {
        return this.token;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}

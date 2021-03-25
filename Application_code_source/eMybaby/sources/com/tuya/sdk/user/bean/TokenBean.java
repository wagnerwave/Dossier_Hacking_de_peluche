package com.tuya.sdk.user.bean;

public class TokenBean {
    public String exponent;
    public String pExponent;
    public String publicKey;
    public String token;

    public String getExponent() {
        return this.exponent;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getToken() {
        return this.token;
    }

    public String getpExponent() {
        return this.pExponent;
    }

    public void setExponent(String str) {
        this.exponent = str;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setpExponent(String str) {
        this.pExponent = str;
    }
}

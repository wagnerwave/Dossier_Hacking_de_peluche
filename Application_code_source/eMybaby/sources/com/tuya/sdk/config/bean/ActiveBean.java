package com.tuya.sdk.config.bean;

public class ActiveBean {
    public String httpUrl;
    public String mqUrl;
    public String timeZone;
    public String token;
    public String uid;

    public String getHttpUrl() {
        return this.httpUrl;
    }

    public String getMqUrl() {
        return this.mqUrl;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getToken() {
        return this.token;
    }

    public String getUid() {
        return this.uid;
    }

    public void setHttpUrl(String str) {
        this.httpUrl = str;
    }

    public void setMqUrl(String str) {
        this.mqUrl = str;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}

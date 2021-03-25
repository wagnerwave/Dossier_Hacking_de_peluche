package com.tuya.sdk.mqttprotocol.bean;

public class PublishBean {
    public String data;
    public String gwId;
    public int protocol;
    public String pv;
    public String sign;
    public long t;

    public String getData() {
        return this.data;
    }

    public String getGwId() {
        return this.gwId;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public String getPv() {
        return this.pv;
    }

    public String getSign() {
        return this.sign;
    }

    public long getT() {
        return this.t;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }

    public void setPv(String str) {
        this.pv = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setT(long j) {
        this.t = j;
    }
}

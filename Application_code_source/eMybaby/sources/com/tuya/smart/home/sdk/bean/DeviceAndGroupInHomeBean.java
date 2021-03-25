package com.tuya.smart.home.sdk.bean;

public class DeviceAndGroupInHomeBean {
    public String bizId;
    public int bizType;

    public String getBizId() {
        return this.bizId;
    }

    public int getBizType() {
        return this.bizType;
    }

    public void setBizId(String str) {
        this.bizId = str;
    }

    public void setBizType(int i) {
        this.bizType = i;
    }
}

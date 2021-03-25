package com.tuya.sdk.device.bean;

public class RomUpdateConfirmEventBean {
    public String devId;
    public String gwId;

    public RomUpdateConfirmEventBean(String str, String str2) {
        this.gwId = str;
        this.devId = str2;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getGwId() {
        return this.gwId;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }
}

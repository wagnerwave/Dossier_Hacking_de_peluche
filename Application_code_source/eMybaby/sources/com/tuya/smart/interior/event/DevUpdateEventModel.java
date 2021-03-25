package com.tuya.smart.interior.event;

public class DevUpdateEventModel {
    public String devId;
    public String gwId;

    public DevUpdateEventModel(String str, String str2) {
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

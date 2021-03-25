package com.tuya.smart.interior.device.bean;

public class DpResp {
    public String devId;
    public String dps;
    public String gwId;

    public String getDevId() {
        return this.devId;
    }

    public String getDps() {
        return this.dps;
    }

    public String getGwId() {
        return this.gwId;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDps(String str) {
        this.dps = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }
}

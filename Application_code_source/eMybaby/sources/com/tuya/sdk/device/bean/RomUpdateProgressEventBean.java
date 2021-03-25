package com.tuya.sdk.device.bean;

public class RomUpdateProgressEventBean {
    public String devId;
    public String gwId;
    public String progress;

    public String getDevId() {
        return this.devId;
    }

    public String getGwId() {
        return this.gwId;
    }

    public String getProgress() {
        return this.progress;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setProgress(String str) {
        this.progress = str;
    }
}

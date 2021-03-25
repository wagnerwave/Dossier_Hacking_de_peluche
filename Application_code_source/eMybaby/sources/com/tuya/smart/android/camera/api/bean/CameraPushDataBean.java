package com.tuya.smart.android.camera.api.bean;

public class CameraPushDataBean {
    public String devId;
    public String edata;
    public String etype;
    public Integer timestamp;

    public String getDevId() {
        return this.devId;
    }

    public String getEdata() {
        return this.edata;
    }

    public String getEtype() {
        return this.etype;
    }

    public Integer getTimestamp() {
        return this.timestamp;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setEdata(String str) {
        this.edata = str;
    }

    public void setEtype(String str) {
        this.etype = str;
    }

    public void setTimestamp(Integer num) {
        this.timestamp = num;
    }
}

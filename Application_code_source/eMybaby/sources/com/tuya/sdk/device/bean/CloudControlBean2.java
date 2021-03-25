package com.tuya.sdk.device.bean;

import java.util.Map;

public class CloudControlBean2 {
    public String cid;
    public int ctype = -1;
    public String devId;
    public Map<String, Object> dps;
    public String mbid;

    public String getCid() {
        return this.cid;
    }

    public int getCtype() {
        return this.ctype;
    }

    public String getDevId() {
        return this.devId;
    }

    public Map<String, Object> getDps() {
        return this.dps;
    }

    public String getMbid() {
        return this.mbid;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setCtype(int i) {
        this.ctype = i;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDps(Map<String, Object> map) {
        this.dps = map;
    }

    public void setMbid(String str) {
        this.mbid = str;
    }
}

package com.tuya.sdk.hardwareprotocol.bean;

public class HDpResponse {
    public String cid;
    public int ctype;
    public String devId;
    public String dps;
    public String mbid;
    public int s = -1;
    public long t;

    public String getCid() {
        return this.cid;
    }

    public int getCtype() {
        return this.ctype;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getDps() {
        return this.dps;
    }

    public String getMbid() {
        return this.mbid;
    }

    public int getS() {
        return this.s;
    }

    public long getT() {
        return this.t;
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

    public void setDps(String str) {
        this.dps = str;
    }

    public void setMbid(String str) {
        this.mbid = str;
    }

    public void setS(int i) {
        this.s = i;
    }

    public void setT(long j) {
        this.t = j;
    }
}

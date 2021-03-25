package com.tuya.smart.home.sdk.bean;

public class WarnMessageBean {
    public String devId;
    public long lastProdWarnId;
    public long latestWarnTime;
    public String productId;
    public String uid;
    public int warnLevel;

    public String getDevId() {
        return this.devId;
    }

    public long getLastProdWarnId() {
        return this.lastProdWarnId;
    }

    public long getLatestWarnTime() {
        return this.latestWarnTime;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getUid() {
        return this.uid;
    }

    public int getWarnLevel() {
        return this.warnLevel;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setLastProdWarnId(long j) {
        this.lastProdWarnId = j;
    }

    public void setLatestWarnTime(long j) {
        this.latestWarnTime = j;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setWarnLevel(int i) {
        this.warnLevel = i;
    }
}

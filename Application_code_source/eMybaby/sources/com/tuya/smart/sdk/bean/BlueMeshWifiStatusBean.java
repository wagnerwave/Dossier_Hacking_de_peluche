package com.tuya.smart.sdk.bean;

public class BlueMeshWifiStatusBean {
    public String bv;
    public Boolean isOnline;
    public String pv;
    public String verSw;

    public String getBv() {
        return this.bv;
    }

    public Boolean getIsOnline() {
        return this.isOnline;
    }

    public String getPv() {
        return this.pv;
    }

    public String getVerSw() {
        return this.verSw;
    }

    public void setBv(String str) {
        this.bv = str;
    }

    public void setIsOnline(Boolean bool) {
        this.isOnline = bool;
    }

    public void setPv(String str) {
        this.pv = str;
    }

    public void setVerSw(String str) {
        this.verSw = str;
    }
}

package com.tuya.smart.sdk.bean;

public class BluetoothStatusBean {
    public Boolean isOnline;
    public String verSw;

    public Boolean getIsOnline() {
        return this.isOnline;
    }

    public String getVerSw() {
        return this.verSw;
    }

    public void setIsOnline(Boolean bool) {
        this.isOnline = bool;
    }

    public void setVerSw(String str) {
        this.verSw = str;
    }
}

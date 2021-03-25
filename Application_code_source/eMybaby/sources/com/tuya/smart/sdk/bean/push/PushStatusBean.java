package com.tuya.smart.sdk.bean.push;

public class PushStatusBean {
    public String deviceId;
    public String isPushEnable;

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getIsPushEnable() {
        return this.isPushEnable;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setIsPushEnable(String str) {
        this.isPushEnable = str;
    }
}

package com.tuya.smart.home.sdk.bean;

public class DeviceShareBean {
    public String devId;
    public String deviceName;
    public String homeName;
    public String iconUrl;
    public String room;
    public boolean share;
    public boolean tempShare;

    public String getDevId() {
        return this.devId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getHomeName() {
        return this.homeName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getRoom() {
        return this.room;
    }

    public boolean isShare() {
        return this.share;
    }

    public boolean isTempShare() {
        return this.tempShare;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setHomeName(String str) {
        this.homeName = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setRoom(String str) {
        this.room = str;
    }

    public void setShare(boolean z) {
        this.share = z;
    }

    public void setTempShare(boolean z) {
        this.tempShare = z;
    }
}

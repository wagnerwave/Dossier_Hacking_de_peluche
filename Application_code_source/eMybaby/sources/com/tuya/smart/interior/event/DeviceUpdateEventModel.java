package com.tuya.smart.interior.event;

public class DeviceUpdateEventModel {
    public static final int MODE_ADD = 0;
    public static final int MODE_DEL = 1;
    public static final int MODE_UPDATE = 2;
    public String devId;
    public long homeId;
    public String meshId;
    public int mode;

    public DeviceUpdateEventModel(long j, String str, int i) {
        this.devId = str;
        this.homeId = j;
        this.mode = i;
    }

    public DeviceUpdateEventModel(String str, String str2, int i) {
        this.meshId = str;
        this.devId = str2;
        this.mode = i;
    }

    public String getDevId() {
        return this.devId;
    }

    public long getHomeId() {
        return this.homeId;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public int getMode() {
        return this.mode;
    }
}

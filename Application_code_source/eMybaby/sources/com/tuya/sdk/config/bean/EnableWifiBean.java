package com.tuya.sdk.config.bean;

public class EnableWifiBean {
    public static final int TYPE_ZIGBEE = 0;
    public short time;
    public int type;

    public short getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public void setTime(short s) {
        this.time = s;
    }

    public void setType(int i) {
        this.type = i;
    }
}

package com.tuya.smart.home.sdk.bean;

public class DeviceAndGroupInRoomBean {
    public String id;
    public int type;

    public String getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}

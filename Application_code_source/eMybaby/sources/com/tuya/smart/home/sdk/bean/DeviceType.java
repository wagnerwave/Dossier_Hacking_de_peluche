package com.tuya.smart.home.sdk.bean;

public enum DeviceType {
    DEVICE(1),
    DEVICE_GROUP(2),
    MESH(3);
    
    public int type;

    /* access modifiers changed from: public */
    DeviceType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}

package com.tuya.sdk.device.utils;

public enum Types {
    LOCATION(2),
    MESH(3),
    ROOM(4),
    GROUP(5),
    DEVICE(6);
    
    public int nCode;

    /* access modifiers changed from: public */
    Types(int i) {
        this.nCode = i;
    }

    public String toString() {
        return String.valueOf(this.nCode);
    }
}

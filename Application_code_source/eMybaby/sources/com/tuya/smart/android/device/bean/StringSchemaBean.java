package com.tuya.smart.android.device.bean;

import java.io.Serializable;

public class StringSchemaBean implements Serializable {
    public static final String type = "string";
    public int maxlen;

    public int getMaxlen() {
        return this.maxlen;
    }

    public void setMaxlen(int i) {
        this.maxlen = i;
    }
}

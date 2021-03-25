package com.tuya.smart.android.device.bean;

import java.io.Serializable;

public class BitmapSchemaBean implements Serializable {
    public static final String type = "bitmap";
    public int maxlen;

    public int getMaxlen() {
        return this.maxlen;
    }

    public void setMaxlen(int i) {
        this.maxlen = i;
    }
}

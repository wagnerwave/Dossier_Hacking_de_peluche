package com.tuya.sdk.sigmesh.bean;

import com.alibaba.fastjson.JSON;

public class Reps {
    public boolean success = false;

    public void parseRep(byte[] bArr) {
    }

    public boolean success() {
        return this.success;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + JSON.toJSONString(this);
    }
}

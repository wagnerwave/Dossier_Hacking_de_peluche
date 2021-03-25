package com.tuya.sdk.hardwareprotocol.bean;

public class HRequest {
    public byte[] data;
    public String devId;
    public long t;
    public int type;

    public byte[] getData() {
        return this.data;
    }

    public String getDevId() {
        return this.devId;
    }

    public long getT() {
        return this.t;
    }

    public int getType() {
        return this.type;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setT(long j) {
        this.t = j;
    }

    public void setType(int i) {
        this.type = i;
    }
}

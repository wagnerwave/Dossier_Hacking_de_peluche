package com.tuya.smart.android.sweeper.bean;

public class SweeperByteData {
    public byte[] data;
    public String devId;
    public int type = -1;

    public byte[] getData() {
        return this.data;
    }

    public String getDevId() {
        return this.devId;
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

    public void setType(int i) {
        this.type = i;
    }
}

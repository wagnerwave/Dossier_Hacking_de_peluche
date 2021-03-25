package com.tuya.smart.home.sdk.bean;

public class TransferDataBean {
    public byte[] data;
    public String devId;

    public TransferDataBean(byte[] bArr) {
        this.data = bArr;
    }

    public TransferDataBean(byte[] bArr, String str) {
        this.data = bArr;
        this.devId = str;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getDevId() {
        return this.devId;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDevId(String str) {
        this.devId = str;
    }
}

package com.tuya.smart.android.blemesh.bean;

public class DpsParseBean {
    public byte opCode;
    public byte[] params;

    public byte getOpCode() {
        return this.opCode;
    }

    public byte[] getParams() {
        byte[] bArr = this.params;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public void setOpCode(byte b2) {
        this.opCode = b2;
    }

    public void setParams(byte[] bArr) {
        this.params = (byte[]) bArr.clone();
    }
}

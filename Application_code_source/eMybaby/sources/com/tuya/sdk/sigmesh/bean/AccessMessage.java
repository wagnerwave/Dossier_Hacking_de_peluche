package com.tuya.sdk.sigmesh.bean;

import android.util.SparseArray;

public final class AccessMessage extends Message {
    public byte[] accessPdu;
    public SparseArray<byte[]> lowerTransportAccessPdu = new SparseArray<>();
    public byte[] transportPdu;

    public AccessMessage() {
        this.ctl = 0;
    }

    public final byte[] getAccessPdu() {
        return this.accessPdu;
    }

    public int getCtl() {
        return this.ctl;
    }

    public final SparseArray<byte[]> getLowerTransportAccessPdu() {
        return this.lowerTransportAccessPdu;
    }

    public final byte[] getUpperTransportPdu() {
        return this.transportPdu;
    }

    public final void setAccessPdu(byte[] bArr) {
        this.accessPdu = bArr;
    }

    public final void setLowerTransportAccessPdu(SparseArray<byte[]> sparseArray) {
        this.lowerTransportAccessPdu = sparseArray;
    }

    public final void setUpperTransportPdu(byte[] bArr) {
        this.transportPdu = bArr;
    }
}

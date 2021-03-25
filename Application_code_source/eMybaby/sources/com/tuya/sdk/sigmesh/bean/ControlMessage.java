package com.tuya.sdk.sigmesh.bean;

import android.util.SparseArray;
import com.tuya.sdk.sigmesh.control.TransportControlMessage;

public final class ControlMessage extends Message {
    public SparseArray<byte[]> lowerTransportControlPdu = new SparseArray<>();
    public TransportControlMessage transportControlMessage;
    public byte[] transportControlPdu;

    public ControlMessage() {
        this.ctl = 1;
    }

    public int getCtl() {
        return this.ctl;
    }

    public SparseArray<byte[]> getLowerTransportControlPdu() {
        return this.lowerTransportControlPdu;
    }

    public TransportControlMessage getTransportControlMessage() {
        return this.transportControlMessage;
    }

    public byte[] getTransportControlPdu() {
        return this.transportControlPdu;
    }

    public void setLowerTransportControlPdu(SparseArray<byte[]> sparseArray) {
        this.lowerTransportControlPdu = sparseArray;
    }

    public void setTransportControlMessage(TransportControlMessage transportControlMessage2) {
        this.transportControlMessage = transportControlMessage2;
    }

    public void setTransportControlPdu(byte[] bArr) {
        this.transportControlPdu = bArr;
    }
}

package com.tuya.smart.android.blemesh.builder;

import com.tuya.smart.android.blemesh.api.MeshUpgradeListener;

public class TuyaBlueMeshOtaBuilder {
    public byte[] data;
    public String devId;
    public MeshUpgradeListener mListener;
    public String mNodeId;
    public String mac;
    public String meshId;
    public String productKey;
    public int timeOut = 100;
    public String version;

    public TuyaBlueMeshOtaBuilder bulid() {
        return this;
    }

    public byte[] getData() {
        byte[] bArr = this.data;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public String getNodeId() {
        return this.mNodeId;
    }

    public String getProductKey() {
        return this.productKey;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public MeshUpgradeListener getTuyaBlueMeshActivatorListener() {
        return this.mListener;
    }

    public String getVersion() {
        return this.version;
    }

    public TuyaBlueMeshOtaBuilder setData(byte[] bArr) {
        this.data = (byte[]) bArr.clone();
        return this;
    }

    public TuyaBlueMeshOtaBuilder setDevId(String str) {
        this.devId = str;
        return this;
    }

    public TuyaBlueMeshOtaBuilder setMac(String str) {
        this.mac = str;
        return this;
    }

    public TuyaBlueMeshOtaBuilder setMeshId(String str) {
        this.meshId = str;
        return this;
    }

    public TuyaBlueMeshOtaBuilder setNodeId(String str) {
        this.mNodeId = str;
        return this;
    }

    public TuyaBlueMeshOtaBuilder setProductKey(String str) {
        this.productKey = str;
        return this;
    }

    public TuyaBlueMeshOtaBuilder setTimeOut(int i) {
        this.timeOut = i;
        return this;
    }

    public TuyaBlueMeshOtaBuilder setTuyaBlueMeshActivatorListener(MeshUpgradeListener meshUpgradeListener) {
        this.mListener = meshUpgradeListener;
        return this;
    }

    public TuyaBlueMeshOtaBuilder setVersion(String str) {
        this.version = str;
        return this;
    }
}

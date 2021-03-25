package com.tuya.sdk.device.bean;

import a.a.a.a.a;

public class OtaProgressEventBean {
    public String cid;
    public String devId;
    public int firmwareType = -1;
    public String meshId;
    public String progress;

    public String getCid() {
        return this.cid;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getFirmwareType() {
        return this.firmwareType;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public String getProgress() {
        return this.progress;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setFirmwareType(int i) {
        this.firmwareType = i;
    }

    public void setMeshId(String str) {
        this.meshId = str;
    }

    public void setProgress(String str) {
        this.progress = str;
    }

    public String toString() {
        StringBuilder n = a.n("cid: ");
        n.append(this.cid);
        n.append(" progress:");
        n.append(this.progress);
        n.append(" firmwareType: ");
        n.append(this.firmwareType);
        return n.toString();
    }
}

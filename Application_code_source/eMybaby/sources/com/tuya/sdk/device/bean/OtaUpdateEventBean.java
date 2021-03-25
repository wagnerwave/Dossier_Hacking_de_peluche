package com.tuya.sdk.device.bean;

import a.a.a.a.a;
import com.tuya.sdk.device.enums.RomUpdateEnum;

public class OtaUpdateEventBean {
    public String devId;
    public int firmwareType;
    public RomUpdateEnum status;

    public OtaUpdateEventBean(String str, RomUpdateEnum romUpdateEnum, int i) {
        this.devId = str;
        this.status = romUpdateEnum;
        this.firmwareType = i;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getFirmwareType() {
        return this.firmwareType;
    }

    public RomUpdateEnum getStatus() {
        return this.status;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setFirmwareType(int i) {
        this.firmwareType = i;
    }

    public void setStatus(RomUpdateEnum romUpdateEnum) {
        this.status = romUpdateEnum;
    }

    public String toString() {
        StringBuilder n = a.n("devId: ");
        n.append(this.devId);
        n.append(" romupdateEnum: ");
        n.append(this.status);
        n.append(" firmwareType: ");
        n.append(this.firmwareType);
        return n.toString();
    }
}

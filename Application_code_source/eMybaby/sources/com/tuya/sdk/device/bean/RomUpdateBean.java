package com.tuya.sdk.device.bean;

import com.tuya.sdk.device.enums.RomDevTypeEnum;
import com.tuya.sdk.device.enums.RomUpdateEnum;

public class RomUpdateBean {
    public String devId;
    public String gwId;
    public RomUpdateEnum status;
    public RomDevTypeEnum type;

    public RomUpdateBean(String str, String str2, RomUpdateEnum romUpdateEnum, RomDevTypeEnum romDevTypeEnum) {
        this.gwId = str;
        this.devId = str2;
        this.status = romUpdateEnum;
        this.type = romDevTypeEnum;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getGwId() {
        return this.gwId;
    }

    public RomUpdateEnum getStatus() {
        return this.status;
    }

    public RomDevTypeEnum getType() {
        return this.type;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setStatus(RomUpdateEnum romUpdateEnum) {
        this.status = romUpdateEnum;
    }

    public void setType(RomDevTypeEnum romDevTypeEnum) {
        this.type = romDevTypeEnum;
    }
}

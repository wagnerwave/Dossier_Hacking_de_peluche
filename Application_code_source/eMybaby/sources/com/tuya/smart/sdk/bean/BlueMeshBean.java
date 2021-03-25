package com.tuya.smart.sdk.bean;

import com.tuya.smart.sdk.api.IStorageCache;

public class BlueMeshBean implements IStorageCache {
    public String code;
    public long endTime;
    public String localKey;
    public String meshId;
    public String name;
    public String password;
    public String pv;
    public long resptime;
    public boolean share;
    public long startTime;
    public boolean tempShare;

    public String getCode() {
        return this.code;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public Object getKey() {
        return this.meshId;
    }

    public String getLocalKey() {
        return this.localKey;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPv() {
        return this.pv;
    }

    public long getResptime() {
        return this.resptime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public boolean isShare() {
        return this.share;
    }

    public boolean isTempShare() {
        return this.tempShare;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setLocalKey(String str) {
        this.localKey = str;
    }

    public void setMeshId(String str) {
        this.meshId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPv(String str) {
        this.pv = str;
    }

    public void setResptime(long j) {
        this.resptime = j;
    }

    public void setShare(boolean z) {
        this.share = z;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setTempShare(boolean z) {
        this.tempShare = z;
    }
}

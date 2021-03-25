package com.tuya.smart.sdk.bean;

public class BlueMeshShareBean {
    public long endTime;
    public String id;
    public String name;
    public boolean share;
    public long startTime;
    public boolean tempShare;

    public long getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
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

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
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

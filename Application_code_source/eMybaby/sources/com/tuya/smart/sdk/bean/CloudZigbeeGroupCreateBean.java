package com.tuya.smart.sdk.bean;

public class CloudZigbeeGroupCreateBean {
    public long groupId;
    public String localId;

    public long getGroupId() {
        return this.groupId;
    }

    public String getLocalId() {
        return this.localId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setLocalId(String str) {
        this.localId = str;
    }
}

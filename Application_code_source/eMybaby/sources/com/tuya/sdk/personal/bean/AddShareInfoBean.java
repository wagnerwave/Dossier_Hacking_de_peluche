package com.tuya.sdk.personal.bean;

public class AddShareInfoBean {
    public String receiverName;
    public long relationId;

    public String getReceiverName() {
        return this.receiverName;
    }

    public long getRelationId() {
        return this.relationId;
    }

    public void setReceiverName(String str) {
        this.receiverName = str;
    }

    public void setRelationId(long j) {
        this.relationId = j;
    }
}

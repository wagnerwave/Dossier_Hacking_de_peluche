package com.tuya.sdk.home.bean;

public class DeviceSortResponseBean {
    public String bizId;
    public int bizType;
    public int displayOrder;
    public int homeDisplayOrder;
    public String roomId;

    public String getBizId() {
        return this.bizId;
    }

    public int getBizType() {
        return this.bizType;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public int getHomeDisplayOrder() {
        return this.homeDisplayOrder;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setBizId(String str) {
        this.bizId = str;
    }

    public void setBizType(int i) {
        this.bizType = i;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setHomeDisplayOrder(int i) {
        this.homeDisplayOrder = i;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}

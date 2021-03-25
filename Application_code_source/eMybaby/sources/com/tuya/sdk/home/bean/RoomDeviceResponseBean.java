package com.tuya.sdk.home.bean;

public class RoomDeviceResponseBean {
    public int displayOrder;
    public String id;
    public int type;

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public String getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}

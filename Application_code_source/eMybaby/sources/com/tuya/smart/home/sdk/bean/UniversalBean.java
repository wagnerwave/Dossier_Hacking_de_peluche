package com.tuya.smart.home.sdk.bean;

public class UniversalBean {
    public int displayOrder;
    public String iconUrl;
    public String id;
    public String name;
    public int type;

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}

package com.tuya.smart.sdk.bean;

public class DpBean {
    public int dpId;
    public String name;
    public String value;

    public int getDpId() {
        return this.dpId;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setDpId(int i) {
        this.dpId = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}

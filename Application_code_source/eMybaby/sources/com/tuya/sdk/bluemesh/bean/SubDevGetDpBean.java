package com.tuya.sdk.bluemesh.bean;

import java.util.List;

public class SubDevGetDpBean {
    public String devId;
    public List<Integer> dpId;

    public String getDevId() {
        return this.devId;
    }

    public List<Integer> getDpId() {
        return this.dpId;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDpId(List<Integer> list) {
        this.dpId = list;
    }
}

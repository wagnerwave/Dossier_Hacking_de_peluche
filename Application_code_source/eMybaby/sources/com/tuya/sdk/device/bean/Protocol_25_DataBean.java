package com.tuya.sdk.device.bean;

import java.util.List;

public class Protocol_25_DataBean {
    public String devId;
    public List<String> offline;
    public List<String> online;

    public String getDevId() {
        return this.devId;
    }

    public List<String> getOffline() {
        return this.offline;
    }

    public List<String> getOnline() {
        return this.online;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setOffline(List<String> list) {
        this.offline = list;
    }

    public void setOnline(List<String> list) {
        this.online = list;
    }
}

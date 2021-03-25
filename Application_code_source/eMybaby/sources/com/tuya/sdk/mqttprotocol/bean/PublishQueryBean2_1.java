package com.tuya.sdk.mqttprotocol.bean;

import java.util.Map;

public class PublishQueryBean2_1 {
    public Map<String, Object> data;
    public int protocol;
    public long t;

    public Map<String, Object> getData() {
        return this.data;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public long getT() {
        return this.t;
    }

    public void setData(Map<String, Object> map) {
        this.data = map;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }

    public void setT(long j) {
        this.t = j;
    }
}

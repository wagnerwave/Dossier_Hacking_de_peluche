package com.tuya.sdk.mqttprotocol.bean;

public class PublishBean2_2 {
    public Object data;
    public int protocol;
    public long t;

    public Object getData() {
        return this.data;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public long getT() {
        return this.t;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }

    public void setT(long j) {
        this.t = j;
    }
}

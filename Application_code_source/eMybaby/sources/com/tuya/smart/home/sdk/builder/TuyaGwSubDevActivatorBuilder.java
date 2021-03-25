package com.tuya.smart.home.sdk.builder;

import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;

public class TuyaGwSubDevActivatorBuilder {
    public String devId;
    public ITuyaSmartActivatorListener mListener;
    public long timeOut = 100000;

    public String getDevId() {
        return this.devId;
    }

    public ITuyaSmartActivatorListener getListener() {
        return this.mListener;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public TuyaGwSubDevActivatorBuilder setDevId(String str) {
        this.devId = str;
        return this;
    }

    public TuyaGwSubDevActivatorBuilder setListener(ITuyaSmartActivatorListener iTuyaSmartActivatorListener) {
        this.mListener = iTuyaSmartActivatorListener;
        return this;
    }

    public TuyaGwSubDevActivatorBuilder setTimeOut(long j) {
        this.timeOut = j * 1000;
        return this;
    }
}

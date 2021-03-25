package com.tuya.smart.home.sdk.builder;

import android.content.Context;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;

public class TuyaQRCodeActivatorBuilder {
    public long homeId;
    public Context mContext;
    public ITuyaSmartActivatorListener mListener;
    public long timeOut = 100000;
    public String uuid;

    public Context getContext() {
        return this.mContext;
    }

    public long getHomeId() {
        return this.homeId;
    }

    public ITuyaSmartActivatorListener getListener() {
        return this.mListener;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public String getUuid() {
        return this.uuid;
    }

    public TuyaQRCodeActivatorBuilder setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public TuyaQRCodeActivatorBuilder setHomeId(long j) {
        this.homeId = j;
        return this;
    }

    public TuyaQRCodeActivatorBuilder setListener(ITuyaSmartActivatorListener iTuyaSmartActivatorListener) {
        this.mListener = iTuyaSmartActivatorListener;
        return this;
    }

    public TuyaQRCodeActivatorBuilder setTimeOut(long j) {
        this.timeOut = j * 1000;
        return this;
    }

    public TuyaQRCodeActivatorBuilder setUuid(String str) {
        this.uuid = str;
        return this;
    }
}

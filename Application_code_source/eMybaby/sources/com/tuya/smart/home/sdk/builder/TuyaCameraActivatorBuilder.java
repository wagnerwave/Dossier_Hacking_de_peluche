package com.tuya.smart.home.sdk.builder;

import android.content.Context;
import com.tuya.smart.sdk.api.ITuyaSmartCameraActivatorListener;

public class TuyaCameraActivatorBuilder {
    public Context mContext;
    public ITuyaSmartCameraActivatorListener mListener;
    public String password;
    public String ssid;
    public long timeOut = 100000;
    public String token;

    public Context getContext() {
        return this.mContext;
    }

    public ITuyaSmartCameraActivatorListener getListener() {
        return this.mListener;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSsid() {
        return this.ssid;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public String getToken() {
        return this.token;
    }

    public TuyaCameraActivatorBuilder setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public TuyaCameraActivatorBuilder setListener(ITuyaSmartCameraActivatorListener iTuyaSmartCameraActivatorListener) {
        this.mListener = iTuyaSmartCameraActivatorListener;
        return this;
    }

    public TuyaCameraActivatorBuilder setPassword(String str) {
        this.password = str;
        return this;
    }

    public TuyaCameraActivatorBuilder setSsid(String str) {
        this.ssid = str;
        return this;
    }

    public TuyaCameraActivatorBuilder setTimeOut(long j) {
        this.timeOut = j * 1000;
        return this;
    }

    public TuyaCameraActivatorBuilder setToken(String str) {
        this.token = str;
        return this;
    }
}

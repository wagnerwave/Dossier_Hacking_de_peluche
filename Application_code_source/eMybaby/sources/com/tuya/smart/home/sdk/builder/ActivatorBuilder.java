package com.tuya.smart.home.sdk.builder;

import android.content.Context;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.enums.ActivatorModelEnum;

public class ActivatorBuilder {
    public Context mContext;
    public ITuyaSmartActivatorListener mListener;
    public ActivatorModelEnum mModel;
    public String password;
    public String ssid;
    public long timeOut = 100000;
    public String token;

    public ActivatorModelEnum getActivatorModel() {
        return this.mModel;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ITuyaSmartActivatorListener getListener() {
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

    public ActivatorBuilder setActivatorModel(ActivatorModelEnum activatorModelEnum) {
        this.mModel = activatorModelEnum;
        return this;
    }

    public ActivatorBuilder setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public ActivatorBuilder setListener(ITuyaSmartActivatorListener iTuyaSmartActivatorListener) {
        this.mListener = iTuyaSmartActivatorListener;
        return this;
    }

    public ActivatorBuilder setPassword(String str) {
        this.password = str;
        return this;
    }

    public ActivatorBuilder setSsid(String str) {
        this.ssid = str;
        return this;
    }

    public ActivatorBuilder setTimeOut(long j) {
        this.timeOut = j * 1000;
        return this;
    }

    public ActivatorBuilder setToken(String str) {
        this.token = str;
        return this;
    }
}

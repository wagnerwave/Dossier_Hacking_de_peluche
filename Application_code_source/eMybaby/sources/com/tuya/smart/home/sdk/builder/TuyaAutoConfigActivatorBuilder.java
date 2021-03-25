package com.tuya.smart.home.sdk.builder;

import android.content.Context;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import java.util.List;

public class TuyaAutoConfigActivatorBuilder {
    public Context context;
    public List<String> devIds;
    public ITuyaSmartActivatorListener mListener;
    public long timeOut = 100000;
    public String token;

    public Context getContext() {
        return this.context;
    }

    public List<String> getDevIds() {
        return this.devIds;
    }

    public ITuyaSmartActivatorListener getListener() {
        return this.mListener;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public String getToken() {
        return this.token;
    }

    public TuyaAutoConfigActivatorBuilder setContext(Context context2) {
        this.context = context2;
        return this;
    }

    public TuyaAutoConfigActivatorBuilder setDevIds(List<String> list) {
        this.devIds = list;
        return this;
    }

    public TuyaAutoConfigActivatorBuilder setListener(ITuyaSmartActivatorListener iTuyaSmartActivatorListener) {
        this.mListener = iTuyaSmartActivatorListener;
        return this;
    }

    public TuyaAutoConfigActivatorBuilder setTimeOut(long j) {
        this.timeOut = j;
        return this;
    }

    public TuyaAutoConfigActivatorBuilder setToken(String str) {
        this.token = str;
        return this;
    }
}

package com.tuya.smart.home.sdk.builder;

import android.content.Context;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;

public class TuyaGwActivatorBuilder {
    public HgwBean hgwBean;
    public Context mContext;
    public ITuyaSmartActivatorListener mListener;
    public long timeOut = 100000;
    public String token;

    public Context getContext() {
        return this.mContext;
    }

    public HgwBean getHgwBean() {
        return this.hgwBean;
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

    public TuyaGwActivatorBuilder setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public TuyaGwActivatorBuilder setHgwBean(HgwBean hgwBean2) {
        this.hgwBean = hgwBean2;
        return this;
    }

    public TuyaGwActivatorBuilder setListener(ITuyaSmartActivatorListener iTuyaSmartActivatorListener) {
        this.mListener = iTuyaSmartActivatorListener;
        return this;
    }

    public TuyaGwActivatorBuilder setTimeOut(long j) {
        this.timeOut = j * 1000;
        return this;
    }

    public TuyaGwActivatorBuilder setToken(String str) {
        this.token = str;
        return this;
    }
}

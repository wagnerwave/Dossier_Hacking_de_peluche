package com.tuya.smart.android.network.bean;

import com.tuya.smart.android.network.http.BusinessResponse;

public class ApiResponeBean extends BusinessResponse {

    /* renamed from: a  reason: collision with root package name */
    public String f4800a;

    public String getA() {
        return this.f4800a;
    }

    public String getApi() {
        return getA();
    }

    public void setA(String str) {
        this.f4800a = str;
    }

    public void setApi(String str) {
        setA(this.f4800a);
    }
}

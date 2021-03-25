package com.tuya.smart.android.network.bean;

import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.common.oo000o0o0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiBean {

    /* renamed from: a  reason: collision with root package name */
    public String f4799a;
    public TuyaApiParams apiParams;
    public String et = TuyaApiParams.ET_VERSION;
    public JSONObject params;
    public String requestId;
    public String sign = initSign();
    public long t;
    public String v;

    public ApiBean(TuyaApiParams tuyaApiParams) {
        this.apiParams = tuyaApiParams;
        this.f4799a = tuyaApiParams.getApiName();
        this.v = tuyaApiParams.getApiVersion();
        this.params = tuyaApiParams.getPostData();
    }

    private String initSign() {
        Map<String, String> urlParams = this.apiParams.getUrlParams();
        urlParams.put("time", String.valueOf(getT()));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(urlParams);
        this.requestId = urlParams.get(TuyaApiParams.KEY_REQUEST_ID);
        concurrentHashMap.putAll(this.apiParams.getRequestBody());
        return oo000o0o0.O000000o(concurrentHashMap, this.apiParams);
    }

    public String getA() {
        return this.f4799a;
    }

    public String getEt() {
        return this.et;
    }

    public JSONObject getParams() {
        return this.params;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSign() {
        return this.sign;
    }

    public long getT() {
        if (this.t == 0) {
            this.t = TimeStampManager.instance().getCurrentTimeStamp();
        }
        return this.t;
    }

    public String getV() {
        return this.v;
    }

    public void setA(String str) {
        this.f4799a = str;
    }

    public void setEt(String str) {
        this.et = str;
    }

    public void setParams(JSONObject jSONObject) {
        this.params = jSONObject;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setT(long j) {
        this.t = j;
    }

    public void setV(String str) {
        this.v = str;
    }
}

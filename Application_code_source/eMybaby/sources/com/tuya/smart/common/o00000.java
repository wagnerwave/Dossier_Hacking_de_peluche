package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.ArrayList;
import java.util.List;

public class o00000 extends Business {
    public static final String O000000o = "tuya.m.device.get";
    public static final String O00000Oo = "tuya.m.device.ref.info.list";
    public static final String O00000o0 = "tuya.m.device.sub.list";
    public String O00000o;
    public String O00000oO;

    public String O000000o() {
        return this.O00000o;
    }

    public void O000000o(String str) {
        this.O00000o = str;
    }

    public void O000000o(String str, Business.ResultListener<ArrayList<DeviceRespBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.sub.list", "1.1");
        apiParams.putPostData("meshId", str);
        apiParams.setSessionRequire(true);
        apiParams.setBizDM(this.O00000oO);
        apiParams.setCtId(this.O00000o);
        asyncArrayList(apiParams, DeviceRespBean.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<DeviceRespBean> resultListener) {
        ApiParams D = a.D("tuya.m.device.sub.get", "1.1", "meshId", str);
        D.putPostData("devId", str2);
        D.setSessionRequire(true);
        asyncRequest(D, DeviceRespBean.class, resultListener);
    }

    public void O000000o(List<String> list, Business.ResultListener<ArrayList<ProductBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.ref.info.list", GwBroadcastMonitorService.mVersion);
        apiParams.putPostData("productIds", list);
        apiParams.setSessionRequire(true);
        apiParams.putPostData("zigbeeGroup", Boolean.TRUE);
        asyncArrayList(apiParams, ProductBean.class, resultListener);
    }

    public String O00000Oo() {
        return this.O00000oO;
    }

    public void O00000Oo(String str) {
        this.O00000oO = str;
    }

    public void O00000Oo(String str, Business.ResultListener<DeviceRespBean> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "3.1");
        apiParams.putPostData("devId", str);
        apiParams.setSessionRequire(true);
        apiParams.setBizDM(this.O00000oO);
        apiParams.setCtId(this.O00000o);
        asyncRequest(apiParams, DeviceRespBean.class, resultListener);
    }

    public void O00000o0(String str, Business.ResultListener<Object> resultListener) {
        asyncRequest(a.F("tuya.m.device.dp.get", "1.0", true, "devId", str), Object.class, resultListener);
    }
}

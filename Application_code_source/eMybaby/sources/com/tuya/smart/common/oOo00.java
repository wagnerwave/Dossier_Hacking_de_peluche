package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.sdk.config.bean.GwBindResultBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.device.bean.DeviceInfoBean;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import com.tuya.smart.interior.config.bean.ConfigDevResp;
import com.tuya.smart.interior.device.bean.GwDevResp;
import java.util.ArrayList;
import java.util.Map;

public class oOo00 extends Business {
    public static final String O000000o = "s.m.gw.list.token";
    public static final String O00000Oo = "s.m.gw.user.bind";
    public static final String O00000o = "s.m.gw.get";
    public static final String O00000o0 = "s.m.product.map.get";
    public static final String O00000oO = "s.m.gw.token.create";
    public static final String O00000oo = "s.m.dev.list.token";
    public static final String O0000O0o = "tuya.m.device.list.token";
    public static final String O0000OOo = "s.m.gw.location.update";
    public static final String O0000Oo = "s.m.dev.list";
    public static final String O0000Oo0 = "tuya.m.device.token.create";
    public String O0000OoO;

    public String O000000o() {
        return this.O0000OoO;
    }

    public void O000000o(long j, Business.ResultListener<ActiveTokenBean> resultListener) {
        O000000o(j, (String) null, resultListener);
    }

    public void O000000o(long j, String str, Business.ResultListener<ActiveTokenBean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oO, "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        if (!TextUtils.isEmpty(str)) {
            apiParams.putPostData("productKey", str);
        }
        apiParams.putPostData("timeZone", TyCommonUtil.getTimeZone());
        asyncRequest(apiParams, ActiveTokenBean.class, resultListener);
    }

    public void O000000o(Business.ResultListener<ActiveTokenBean> resultListener) {
        asyncRequest(a.E(O0000Oo0, "2.0", true), ActiveTokenBean.class, resultListener);
    }

    public void O000000o(String str) {
        this.O0000OoO = str;
    }

    public void O000000o(String str, long j, Business.ResultListener<ActiveTokenBean> resultListener) {
        ApiParams F = a.F("tuya.m.device.qrcode.token.create", "1.0", true, "uuid", str);
        F.setGid(j);
        asyncRequest(F, ActiveTokenBean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<ArrayList<GwDevResp>> resultListener) {
        asyncArrayList(a.F(O000000o, "1.0", true, "token", str), GwDevResp.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<GwDevResp> resultListener) {
        ApiParams F = a.F(O00000o, "1.0", true, o0ooo00oo.O00000o0, str);
        if (!TextUtils.isEmpty(str2)) {
            F.putPostData("token", str2);
        }
        F.setCtId(this.O0000OoO);
        F.setBizDM("device_config_add");
        asyncRequest(F, GwDevResp.class, resultListener);
    }

    public void O000000o(ArrayList<String> arrayList, Business.ResultListener<Map<String, DeviceInfoBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o0, "1.0");
        apiParams.putPostData("ids", arrayList);
        apiParams.setSessionRequire(true);
        asyncHashMap(apiParams, DeviceInfoBean.class, resultListener);
    }

    public void O000000o(ArrayList<String> arrayList, String str, Business.ResultListener<ArrayList<GwBindResultBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "1.0");
        apiParams.setSessionRequire(true);
        apiParams.putPostData("gwIds", arrayList);
        apiParams.putPostData("token", str);
        asyncArrayList(apiParams, GwBindResultBean.class, resultListener);
    }

    public void O00000Oo(String str) {
        asyncRequest(a.F("s.m.gw.location.update", "1.0", true, o0ooo00oo.O00000o0, str));
    }

    public void O00000Oo(String str, long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D("tuya.m.device.user.group.bind", "1.0", "devId", str);
        D.putPostData("groupId", Long.valueOf(j));
        D.setCtId(this.O0000OoO);
        D.setBizDM("device_config_add");
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<ArrayList<GwDevResp>> resultListener) {
        asyncArrayList(a.F(O00000oo, "2.0", true, "token", str), GwDevResp.class, resultListener);
    }

    public void O00000o(String str, Business.ResultListener<ArrayList<GwDevResp>> resultListener) {
        asyncArrayList(a.F("s.m.dev.list", "2.0", true, o0ooo00oo.O00000o0, str), GwDevResp.class, resultListener);
    }

    public void O00000o0(String str, Business.ResultListener<ConfigDevResp> resultListener) {
        ApiParams F = a.F(O0000O0o, GwBroadcastMonitorService.mVersion, true, "token", str);
        F.setCtId(this.O0000OoO);
        F.setBizDM("device_config_add");
        asyncRequest(F, ConfigDevResp.class, resultListener);
    }
}

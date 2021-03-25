package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.network.Business;

public class o0O0000O extends Business {
    public static final String O000000o = "USER_NOT_EXIST_NEED_CODE";
    public static final String O00000Oo = "s.m.menu.get";
    public static final String O00000o = "b.m.app.check";
    public static final String O00000o0 = "s.m.user.update";
    public static final String O00000oO = "s.m.msggroup.list";
    public static final String O00000oo = "s.m.msg.list";
    public static final String O0000O0o = "s.m.user.bind.mobile";
    public static final String O0000OOo = "tuya.m.user.bind.mobile.sendcode";
    public static final String O0000Oo = "tuya.m.category.scheme";
    public static final String O0000Oo0 = "s.m.dev.list.group.list.experience";
    public static final String O0000OoO = "tuya.m.device.update";
    public static final String O0000Ooo = "tuya.m.device.push.status.switch";
    public static final String O0000o = "tuya.m.device.exist";
    public static final String O0000o0 = "s.m.camera.bind.thirdparty";
    public static final String O0000o00 = "tuya.m.device.push.status.get";
    public static final String O0000o0O = "tuya.m.camera.hardware.upgrade.get";
    public static final String O0000o0o = "tuya.m.user.info.get";
    public static final String O0000oO0 = "tuya.p.weather.city.info.aggregate";

    public void O000000o(String str, int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F("tuya.m.device.push.status.switch", "1.0", true, "deviceId", str);
        F.putPostData("status", Integer.valueOf(i));
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<Boolean> resultListener) {
        asyncRequest(a.F(O00000o0, "1.0", true, "nickname", str), Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.user.bind.mobile.sendcode", "1.0", str);
        apiParams.setSessionRequire(true);
        apiParams.setShouldCache(false);
        apiParams.putPostData(o00ooo0o00.O000OOo0, str);
        apiParams.putPostData(o00ooo0o00.O000OOoO, str2);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D("s.m.user.bind.mobile", "1.0", o00ooo0o00.O000OOo0, str);
        D.putPostData(o00ooo0o00.O000OOoO, str2);
        D.putPostData("code", str3);
        D.setSessionRequire(true);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, Business.ResultListener<JSONObject> resultListener) {
        if (TextUtils.isEmpty(str4)) {
            str4 = "1.0";
        }
        ApiParams apiParams = new ApiParams(str3, str4);
        if (!TextUtils.isEmpty(str5)) {
            JSONObject parseObject = JSON.parseObject(str5);
            for (String next : parseObject.keySet()) {
                Object obj = parseObject.get(next);
                if (obj != null) {
                    apiParams.putPostData(next, obj);
                }
            }
        }
        apiParams.setIsN4H5Request(true);
        apiParams.putPostData(o0ooo00oo.O00000o0, str);
        apiParams.putPostData("devId", str2);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, JSONObject.class, resultListener);
    }

    public void O00000Oo(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O0000OoO, "1.0", true, "devId", str);
        F.putPostData("softVer", str2);
        F.putPostData("protocolVer", str3);
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, String str3, String str4, String str5, Business.ResultListener<String> resultListener) {
        if (TextUtils.isEmpty(str4)) {
            str4 = "1.0";
        }
        ApiParams apiParams = new ApiParams(str3, str4);
        if (!TextUtils.isEmpty(str5)) {
            JSONObject parseObject = JSON.parseObject(str5);
            for (String next : parseObject.keySet()) {
                Object obj = parseObject.get(next);
                if (obj != null) {
                    apiParams.putPostData(next, obj);
                }
            }
        }
        apiParams.setIsN4H5Request(true);
        apiParams.setSessionRequire(true);
        apiParams.putPostData(o0ooo00oo.O00000o0, str);
        apiParams.putPostData("devId", str2);
        asyncRequest(apiParams, String.class, resultListener);
    }
}

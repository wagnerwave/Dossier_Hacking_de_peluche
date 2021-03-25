package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.roomorama.caldroid.CaldroidFragment;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.device.bean.AlarmTimerBean;
import com.tuya.smart.android.device.bean.DataPointStatBean;
import com.tuya.smart.android.device.bean.DevLocationBean;
import com.tuya.smart.android.device.enums.DataPointTypeEnum;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.interior.device.bean.DevResp;
import com.tuya.smart.interior.device.bean.DpResp;
import com.tuya.smart.sdk.bean.DpBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class o000 extends Business {
    public static final String O000000o = "tuya.m.device.dp.publish";
    public static final String O00000Oo = "m.smart.datapoint.stat.oneday";
    public static final String O00000o = "s.m.dev.get";
    public static final String O00000o0 = "s.m.dev.dp.get";
    public static final String O00000oO = "s.m.dev.list";
    public static final String O00000oo = "s.m.gw.reset";
    public static final String O0000O0o = "s.m.gw.location.update";
    public static final String O0000OOo = "s.m.gw.name.update";
    public static final String O0000Oo = "s.m.dev.linkage.location.report";
    public static final String O0000Oo0 = "s.m.dev.linkage.location.get";
    public static final String O0000OoO = "s.m.linkage.timer.add.v2";
    public static final String O0000Ooo = "s.m.linkage.timer.update.v2";
    public static final String O0000o = "s.m.gw.list.by.ids";
    public static final String O0000o0 = "s.m.linkage.timer.get.v2";
    public static final String O0000o00 = "s.m.linkage.timer.remove";
    public static final String O0000o0O = "s.m.linkage.timer.status";
    public static final String O0000o0o = "s.m.gw.production.get";
    public static final String O0000oO = "s.m.dev.property.get";
    public static final String O0000oO0 = "s.m.dev.property.save";
    public static final String O0000oOO = "m.smart.datapoint.stat";
    public static final String O0000oOo = "tuya.m.device.sub.name.update";
    public static final String O0000oo0 = "s.m.dev.dp.get";

    public void O000000o(long j, int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O0000o0O, "1.0", true);
        E.putPostData("id", Long.valueOf(j));
        E.putPostData("status", Integer.valueOf(i));
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O000000o(long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O0000o00, "1.0", true);
        E.putPostData("id", Long.valueOf(j));
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O000000o(Business.ResultListener<ArrayList<DevLocationBean>> resultListener) {
        asyncArrayList(a.E(O0000Oo0, "1.0", true), DevLocationBean.class, resultListener);
    }

    public void O000000o(o0o0o0ooo0 o0o0o0ooo0, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O000000o, "1.0", true);
        E.putPostData(o0ooo00oo.O00000o0, o0o0o0ooo0.O000000o());
        E.putPostData("devId", o0o0o0ooo0.O00000Oo());
        E.putPostData("dps", o0o0o0ooo0.O00000o0());
        if (!TextUtils.isEmpty(o0o0o0ooo0.O00000o())) {
            E.putPostData("pcc", o0o0o0ooo0.O00000o());
        }
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O000000o(String str) {
        asyncRequest(a.F("s.m.gw.location.update", "1.0", true, o0ooo00oo.O00000o0, str));
    }

    public void O000000o(String str, int i, String str2, Business.ResultListener<String> resultListener) {
        ApiParams D = a.D(O00000Oo, "1.0", o0ooo00oo.O00000o0, str);
        D.putPostData("devId", str);
        D.putPostData("dpId", Integer.valueOf(i));
        D.putPostData("day", str2);
        D.putPostData("statType", "rank");
        asyncRequest(D, String.class, "value", resultListener);
    }

    public void O000000o(String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oo, "1.0");
        apiParams.putPostData(o0ooo00oo.O00000o0, str);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, AlarmTimerBean alarmTimerBean, Business.ResultListener<Integer> resultListener) {
        ApiParams F = a.F(O0000OoO, "1.0", true, "bizId", str);
        F.putPostData("type", oOO0O0O0.O0000oOO);
        F.putPostData("devId", str2);
        String timezoneId = oO0OO000.O000000o().getDeviceBean(str2).getTimezoneId();
        if (TextUtils.isEmpty(timezoneId)) {
            timezoneId = TyCommonUtil.getTimeZoneId();
        }
        F.putPostData("timeZone", TyCommonUtil.getTimezoneGCMById(timezoneId));
        F.putPostData("time", alarmTimerBean.getTime());
        F.putPostData("loops", alarmTimerBean.getLoops());
        F.putPostData("status", Integer.valueOf(alarmTimerBean.getStatus()));
        F.putPostData("instruct", "{\"devId\": \"" + str2 + "\",\"dps\":" + alarmTimerBean.getValue() + "}");
        asyncRequest(F, Integer.class, resultListener);
    }

    public void O000000o(String str, String str2, DataPointTypeEnum dataPointTypeEnum, String str3, String str4, String str5, String str6, int i, int i2, String str7, Business.ResultListener<DataPointStatBean> resultListener) {
        ApiParams D = a.D(O0000oOO, "1.0", o0ooo00oo.O00000o0, str);
        D.putPostData("devId", str2);
        D.putPostData("type", dataPointTypeEnum.getType());
        D.putPostData(CaldroidFragment.YEAR, str3);
        D.putPostData(CaldroidFragment.MONTH, str4);
        D.putPostData("hour", str6);
        D.putPostData("day", str5);
        D.putPostData("number", Integer.valueOf(i));
        D.putPostData("dpId", Integer.valueOf(i2));
        D.putPostData("statType", str7);
        asyncRequest(D, DataPointStatBean.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<DpResp> resultListener) {
        ApiParams F = a.F("s.m.dev.dp.get", "1.0", true, o0ooo00oo.O00000o0, str);
        F.putPostData("devId", str2);
        asyncRequest(F, DpResp.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D("tuya.m.device.sub.name.update", "1.0", "meshId", str);
        D.putPostData("devId", str2);
        D.putPostData("name", str3);
        D.setSessionRequire(true);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O0000oO0, "1.0", o0ooo00oo.O00000o0, str);
        D.putPostData("devId", str2);
        D.putPostData("code", str3);
        D.putPostData("value", str4);
        D.setSessionRequire(true);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, Map<String, Object> map, Business.ResultListener<Object> resultListener) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "1.0";
        }
        if (map == null) {
            map = new HashMap<>();
        }
        ApiParams apiParams = new ApiParams(str, str2);
        apiParams.setSpRequest(true);
        for (Map.Entry next : map.entrySet()) {
            apiParams.putPostData((String) next.getKey(), next.getValue());
        }
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, Object.class, resultListener);
    }

    public <T> void O000000o(String str, String str2, Map<String, Object> map, Class<T> cls, boolean z, Business.ResultListener<T> resultListener) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "1.0";
        }
        if (map == null) {
            map = new HashMap<>();
        }
        ApiParams apiParams = new ApiParams(str, str2);
        apiParams.setSpRequest(true);
        for (Map.Entry next : map.entrySet()) {
            apiParams.putPostData((String) next.getKey(), next.getValue());
        }
        apiParams.setSessionRequire(z);
        asyncRequest(apiParams, cls, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<ArrayList<AlarmTimerBean>> resultListener) {
        ApiParams F = a.F(O0000o0, "1.0", true, "bizId", str);
        F.putPostData("type", oOO0O0O0.O0000oOO);
        asyncArrayList(F, AlarmTimerBean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, AlarmTimerBean alarmTimerBean, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O0000Ooo, "1.0", true, "bizId", str);
        F.putPostData("devId", str2);
        F.putPostData("type", oOO0O0O0.O0000oOO);
        F.putPostData("id", Long.valueOf(alarmTimerBean.getId()));
        F.putPostData("timeZone", TyCommonUtil.getTimeZone());
        F.putPostData("time", alarmTimerBean.getTime());
        F.putPostData("loops", alarmTimerBean.getLoops());
        F.putPostData("status", Integer.valueOf(alarmTimerBean.getStatus()));
        F.putPostData("instruct", "{\"devId\": \"" + str2 + "\",\"dps\":" + alarmTimerBean.getValue() + "}");
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O0000OOo, "1.0", true, o0ooo00oo.O00000o0, str);
        F.putPostData("name", str2);
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, Map<String, Object> map, Business.ResultListener<Object> resultListener) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "1.0";
        }
        if (map == null) {
            map = new HashMap<>();
        }
        ApiParams apiParams = new ApiParams(str, str2);
        apiParams.setSpRequest(true);
        for (Map.Entry next : map.entrySet()) {
            apiParams.putPostData((String) next.getKey(), next.getValue());
        }
        apiParams.setSessionRequire(false);
        asyncRequest(apiParams, Object.class, resultListener);
    }

    public void O00000o(String str, String str2, Business.ResultListener<Map> resultListener) {
        ApiParams D = a.D(O0000oO, "1.0", o0ooo00oo.O00000o0, str);
        D.putPostData("devId", str2);
        D.setSessionRequire(true);
        asyncRequest(D, Map.class, resultListener);
    }

    public void O00000o0(String str, Business.ResultListener<Boolean> resultListener) {
        asyncRequest(a.F("s.m.gw.factory.reset", "1.0", true, o0ooo00oo.O00000o0, str), Boolean.class, resultListener);
    }

    public void O00000o0(String str, String str2, Business.ResultListener<DevResp> resultListener) {
        ApiParams F = a.F(O00000o, "1.0", true, o0ooo00oo.O00000o0, str);
        F.putPostData("devId", str2);
        asyncRequest(F, DevResp.class, resultListener);
    }

    public void O00000oO(String str, String str2, Business.ResultListener<DpBean> resultListener) {
        ApiParams D = a.D("s.m.dev.dp.get", "2.0", "devId", str);
        D.putPostData(o0ooo00oo.O00000o0, str2);
        asyncRequest(D, DpBean.class, resultListener);
    }

    public void O00000oo(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D("tuya.m.device.sub.unbind", "1.0", "meshId", str);
        D.putPostData("devId", str2);
        D.setSessionRequire(true);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O0000O0o(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D("tuya.m.nb.device.dp.publish", "1.0", "devId", str);
        D.putPostData("dps", str2);
        asyncRequest(D, Boolean.class, resultListener);
    }
}

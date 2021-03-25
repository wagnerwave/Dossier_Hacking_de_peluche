package com.tuya.smart.common;

import a.a.a.a.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.timer.bean.CategoryStatusBean;
import com.tuya.sdk.timer.bean.DpTimerListBean;
import com.tuya.sdk.timer.bean.DpTimerPointBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.home.sdk.constant.TimerTypeEnum;
import java.util.ArrayList;

public class o00o00oooo extends Business {
    public static final String O000000o = "tuya.m.timer.group.add";
    public static final String O00000Oo = "tuya.m.timer.group.list";
    public static final String O00000o = "tuya.m.timer.group.status.update";
    public static final String O00000o0 = "tuya.m.timer.group.update";
    public static final String O00000oO = "tuya.m.timer.group.remove";
    public static final String O00000oo = "tuya.m.timer.all.list";
    public static final String O0000O0o = "tuya.m.timer.category.list";
    public static final String O0000OOo = "tuya.m.timer.category.status.update";

    public void O000000o(String str, Business.ResultListener<ArrayList<CategoryStatusBean>> resultListener) {
        asyncArrayList(a.F(O0000O0o, "1.0", true, "devId", str), CategoryStatusBean.class, resultListener);
    }

    public void O000000o(String str, TimerTypeEnum timerTypeEnum, Business.ResultListener<ArrayList<DpTimerListBean>> resultListener) {
        ApiParams F = a.F(O00000oo, "2.0", true, "bizId", str);
        F.putPostData("type", timerTypeEnum.timeType);
        asyncArrayList(F, DpTimerListBean.class, resultListener);
    }

    public void O000000o(String str, String str2, int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O0000OOo, "1.0", true, "category", str);
        F.putPostData("devId", str2);
        F.putPostData("status", Integer.valueOf(i));
        asyncRequestBoolean(F, resultListener);
    }

    public void O000000o(String str, String str2, TimerTypeEnum timerTypeEnum, Business.ResultListener<DpTimerListBean> resultListener) {
        ApiParams F = a.F(O00000Oo, "2.0", true, "bizId", str);
        F.putPostData("category", str2);
        F.putPostData("type", timerTypeEnum.timeType);
        asyncRequest(F, DpTimerListBean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, TimerTypeEnum timerTypeEnum, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000oO, "2.0", true, "bizId", str);
        F.putPostData("category", str2);
        F.putPostData("groupId", str3);
        F.putPostData("type", timerTypeEnum.timeType);
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, TimerTypeEnum timerTypeEnum, Business.ResultListener<JSONObject> resultListener) {
        ApiParams F = a.F(O000000o, GwBroadcastMonitorService.mVersion, true, "bizId", str);
        F.putPostData("category", str2);
        F.putPostData("loops", str3);
        F.putPostData("timeZone", TyCommonUtil.getTimeZone());
        F.putPostData("type", timerTypeEnum.timeType);
        F.putPostData("instruct", str4);
        asyncRequest(F, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, TimerTypeEnum timerTypeEnum, Business.ResultListener<JSONObject> resultListener) {
        ApiParams F = a.F(O00000o0, GwBroadcastMonitorService.mVersion, true, "bizId", str);
        F.putPostData("groupId", str3);
        F.putPostData("category", str2);
        F.putPostData("loops", str4);
        F.putPostData("timeZone", TyCommonUtil.getTimeZone());
        F.putPostData("type", timerTypeEnum.timeType);
        F.putPostData("instruct", str5);
        asyncRequest(F, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, String str6, boolean z, TimerTypeEnum timerTypeEnum, Business.ResultListener<JSONObject> resultListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DpTimerPointBean(str6, str4, z));
        ApiParams F = a.F(O00000o0, GwBroadcastMonitorService.mVersion, true, "bizId", str);
        F.putPostData("groupId", str3);
        F.putPostData("category", str2);
        F.putPostData("loops", str5);
        F.putPostData("timeZone", TyCommonUtil.getTimeZone());
        F.putPostData("type", timerTypeEnum.timeType);
        F.putPostData("instruct", JSON.toJSONString(arrayList));
        asyncRequest(F, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, boolean z, TimerTypeEnum timerTypeEnum, Business.ResultListener<JSONObject> resultListener) {
        ArrayList arrayList = new ArrayList();
        String str6 = str4;
        String str7 = str5;
        boolean z2 = z;
        arrayList.add(new DpTimerPointBean(str5, str4, z));
        O000000o(str, str2, str3, JSON.toJSONString(arrayList), timerTypeEnum, resultListener);
    }

    public void O000000o(String str, String str2, String str3, boolean z, TimerTypeEnum timerTypeEnum, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000o, "2.0", true, "bizId", str);
        F.putPostData("groupId", str3);
        F.putPostData("category", str2);
        F.putPostData("status", Integer.valueOf(z ? 1 : 0));
        F.putPostData("type", timerTypeEnum.timeType);
        asyncRequest(F, Boolean.class, resultListener);
    }
}

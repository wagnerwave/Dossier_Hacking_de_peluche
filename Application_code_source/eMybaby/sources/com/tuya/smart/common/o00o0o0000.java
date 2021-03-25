package com.tuya.smart.common;

import a.a.a.a.a;
import com.alibaba.fastjson.JSON;
import com.tuya.sdk.timer.bean.CategoryStatusBean;
import com.tuya.sdk.timer.bean.DpTimerListBean;
import com.tuya.sdk.timer.bean.DpTimerPointBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.network.Business;
import java.util.ArrayList;

public class o00o0o0000 extends Business {
    public static final String O000000o = "s.m.linkage.timer.category.group.add";
    public static final String O00000Oo = "s.m.linkage.timer.category.list";
    public static final String O00000o = "s.m.linkage.timer.category.group.status";
    public static final String O00000o0 = "s.m.linkage.timer.category.status";
    public static final String O00000oO = "s.m.linkage.timer.category.group.remove";
    public static final String O00000oo = "s.m.linkage.timer.category.group.update";
    public static final String O0000O0o = "s.m.linkage.timer.category.group.list";
    public static final String O0000OOo = "s.m.linkage.timer.category.list.all";

    public void O000000o(String str, Business.ResultListener<ArrayList<CategoryStatusBean>> resultListener) {
        asyncArrayList(a.F(O00000Oo, "1.0", true, "devId", str), CategoryStatusBean.class, resultListener);
    }

    public void O000000o(String str, String str2, int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000o0, "1.0", true, "category", str);
        F.putPostData("devId", str2);
        F.putPostData("status", Integer.valueOf(i));
        asyncRequestBoolean(F, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<DpTimerListBean> resultListener) {
        ApiParams F = a.F(O0000O0o, "2.0", true, "devId", str);
        F.putPostData("category", str2);
        asyncRequest(F, DpTimerListBean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000oO, "1.0", true, "devId", str);
        F.putPostData("category", str2);
        F.putPostData("groupId", str3);
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O000000o, "1.0", true, "devId", str);
        F.putPostData("category", str2);
        F.putPostData("loops", str3);
        F.putPostData("timeZone", TyCommonUtil.getTimeZone());
        F.putPostData("instruct", str4);
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000oo, "1.0", true, "devId", str);
        F.putPostData("groupId", str3);
        F.putPostData("category", str2);
        F.putPostData("loops", str4);
        F.putPostData("timeZone", TyCommonUtil.getTimeZone());
        F.putPostData("instruct", str5);
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, String str6, boolean z, Business.ResultListener<Boolean> resultListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DpTimerPointBean(str6, str4, z));
        ApiParams F = a.F(O00000oo, "1.0", true, "devId", str);
        F.putPostData("groupId", str3);
        F.putPostData("category", str2);
        F.putPostData("loops", str5);
        F.putPostData("timeZone", TyCommonUtil.getTimeZone());
        F.putPostData("instruct", JSON.toJSONString(arrayList));
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, boolean z, Business.ResultListener<Boolean> resultListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DpTimerPointBean(str5, str4, z));
        O000000o(str, str2, str3, JSON.toJSONString(arrayList), resultListener);
    }

    public void O000000o(String str, String str2, String str3, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000o, "1.0", true, "devId", str);
        F.putPostData("groupId", str3);
        F.putPostData("category", str2);
        F.putPostData("status", Integer.valueOf(z ? 1 : 0));
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, boolean z, Business.ResultListener<Boolean> resultListener) {
        O000000o(str, str2, z ? 1 : 0, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<ArrayList<DpTimerListBean>> resultListener) {
        asyncArrayList(a.F(O0000OOo, "1.0", true, "devId", str), DpTimerListBean.class, resultListener);
    }
}

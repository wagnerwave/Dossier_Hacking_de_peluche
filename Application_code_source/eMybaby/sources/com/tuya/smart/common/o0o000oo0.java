package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.sdk.home.bean.MemberResponseBean;
import com.tuya.sdk.home.bean.StorageSignResponseBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.home.sdk.bean.MemberWrapperBean;
import java.util.ArrayList;
import java.util.Map;

public class o0o000oo0 extends Business {
    public static final String O000000o = "tuya.m.group.member.add";
    public static final String O00000Oo = "tuya.m.group.member.account.add";
    public static final String O00000o = "tuya.m.group.member.update";
    public static final String O00000o0 = "tuya.m.group.member.remove";
    public static final String O00000oO = "tuya.m.group.member.role.update";
    public static final String O00000oo = "tuya.m.group.member.get";
    public static final String O0000O0o = "tuya.m.group.member.device.list";
    public static final String O0000OOo = "tuya.m.storage.upload.sign";
    public static final String O0000Oo0 = "tuya.m.group.member.process";

    public void O000000o(long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o0, "2.0");
        apiParams.putPostData("id", Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, String str, String str2, String str3, boolean z, Business.ResultListener<Long> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "2.0");
        apiParams.putPostData("groupId", Long.valueOf(j));
        apiParams.putPostData(o00ooo0o00.O000OOo0, str);
        apiParams.putPostData("userAccount", str2);
        if (!TextUtils.isEmpty(str3)) {
            apiParams.putPostData("name", str3);
        }
        apiParams.putPostData("admin", Boolean.valueOf(z));
        asyncRequest(apiParams, Long.class, resultListener);
    }

    public void O000000o(long j, String str, String str2, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "1.0");
        apiParams.putPostData("id", Long.valueOf(j));
        apiParams.putPostData(o00ooo0o00.O000OOo0, str);
        apiParams.putPostData("userAccount", str2);
        apiParams.putPostData("admin", Boolean.valueOf(z));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, String str, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o, "2.0");
        apiParams.putPostData("id", Long.valueOf(j));
        apiParams.putPostData("name", str);
        apiParams.putPostData("admin", Boolean.valueOf(z));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oO, "1.0");
        apiParams.putPostData("id", Long.valueOf(j));
        apiParams.putPostData("admin", Boolean.valueOf(z));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(MemberWrapperBean memberWrapperBean, Business.ResultListener<Long> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, GwBroadcastMonitorService.mVersion);
        apiParams.putPostData("groupId", Long.valueOf(memberWrapperBean.getHomeId()));
        apiParams.putPostData("name", memberWrapperBean.getNickName());
        apiParams.putPostData("admin", Boolean.valueOf(memberWrapperBean.isAdmin()));
        if (!TextUtils.isEmpty(memberWrapperBean.getHeadPic())) {
            apiParams.putPostData("headPic", memberWrapperBean.getHeadPic());
        }
        if (!TextUtils.isEmpty(memberWrapperBean.getAccount()) && !TextUtils.isEmpty(memberWrapperBean.getCountryCode())) {
            apiParams.putPostData(o00ooo0o00.O000OOo0, memberWrapperBean.getCountryCode());
            apiParams.putPostData("userAccount", memberWrapperBean.getAccount());
        }
        asyncRequest(apiParams, Long.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<StorageSignResponseBean> resultListener) {
        ApiParams F = a.F(O0000Oo0, "1.0", true, "uploadFileName", str);
        F.putPostData("type", "image");
        F.putPostData("method", "PUT");
        F.putPostData("biz", "memberavatar");
        asyncRequest(F, StorageSignResponseBean.class, resultListener);
    }

    public void O00000Oo(long j, Business.ResultListener<ArrayList<MemberResponseBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oo, "2.0");
        apiParams.putPostData("groupId", Long.valueOf(j));
        asyncArrayList(apiParams, MemberResponseBean.class, resultListener);
    }

    public void O00000Oo(long j, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O0000Oo0, "1.0", true);
        E.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        E.putPostData("action", Boolean.valueOf(z));
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O00000Oo(MemberWrapperBean memberWrapperBean, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o, GwBroadcastMonitorService.mVersion);
        apiParams.putPostData("id", Long.valueOf(memberWrapperBean.getMemberId()));
        apiParams.putPostData("admin", Boolean.valueOf(memberWrapperBean.isAdmin()));
        if (!TextUtils.isEmpty(memberWrapperBean.getNickName())) {
            apiParams.putPostData("name", memberWrapperBean.getNickName());
        }
        if (!TextUtils.isEmpty(memberWrapperBean.getHeadPic())) {
            apiParams.putPostData("headPic", memberWrapperBean.getHeadPic());
        }
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000o0(long j, Business.ResultListener<Map<String, Object>> resultListener) {
        ApiParams apiParams = new ApiParams(O0000O0o, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        asyncHashMap(apiParams, Object.class, resultListener);
    }
}

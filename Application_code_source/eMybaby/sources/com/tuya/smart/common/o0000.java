package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.device.bean.GroupDeviceRespBean;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import java.util.ArrayList;
import java.util.List;

public class o0000 extends Business {
    public static final String O000000o = "s.m.dev.group.add.dev.list";
    public static final String O00000Oo = "s.m.dev.group.add";
    public static final String O00000o = "s.m.dev.group.update";
    public static final String O00000o0 = "tuya.m.device.group.add.zigbee";
    public static final String O00000oO = "s.m.dev.group.dismiss";
    public static final String O00000oo = "s.m.dev.group.relations.save";
    public static final String O0000O0o = "s.m.dev.group.dp.publish";

    public void O000000o(long j, long j2, Business.ResultListener<ArrayList<GroupDeviceRespBean>> resultListener) {
        ApiParams E = a.E(O000000o, "1.0", true);
        E.putPostData("groupId", Long.valueOf(j2));
        E.setGid(j);
        asyncArrayList(E, GroupDeviceRespBean.class, resultListener);
    }

    public void O000000o(long j, long j2, String str, Business.ResultListener<ArrayList<GroupDeviceRespBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "2.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        apiParams.putPostData("productId", str);
        if (j2 != -1) {
            apiParams.putPostData("groupId", Long.valueOf(j2));
        }
        asyncArrayList(apiParams, GroupDeviceRespBean.class, resultListener);
    }

    public void O000000o(long j, long j2, String str, String str2, Business.ResultListener<ArrayList<GroupDeviceRespBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, GwBroadcastMonitorService.mVersion);
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        apiParams.putPostData("productId", str);
        apiParams.putPostData("meshId", str2);
        if (j2 != -1) {
            apiParams.putPostData("groupId", Long.valueOf(j2));
        }
        asyncArrayList(apiParams, GroupDeviceRespBean.class, resultListener);
    }

    public void O000000o(long j, long j2, List<String> list, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O00000oo, GwBroadcastMonitorService.mVersion, true);
        E.putPostData("groupId", Long.valueOf(j2));
        E.putPostData("devIds", list.toArray());
        E.setGid(j);
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O000000o(long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O00000oO, "1.0", true);
        E.putPostData("groupId", Long.valueOf(j));
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O000000o(long j, o0o0o0ooo0 o0o0o0ooo0, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O0000O0o, "1.0", true);
        E.putPostData("groupId", Long.valueOf(j));
        E.putPostData("dps", o0o0o0ooo0.O00000o0());
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O000000o(long j, String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000o, "1.0", true, "name", str);
        F.putPostData("groupId", Long.valueOf(j));
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(long j, String str, String str2, List<String> list, Business.ResultListener<GroupRespBean> resultListener) {
        ApiParams F = a.F(O00000Oo, "2.1", true, "productId", str);
        F.setGid(j);
        F.putPostData("name", str2);
        F.putPostData("devIds", list.toArray());
        asyncRequest(F, GroupRespBean.class, resultListener);
    }

    public void O000000o(Long l, Business.ResultListener<GroupRespBean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.group.get", "1.1");
        apiParams.putPostData("id", l);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, GroupRespBean.class, resultListener);
    }

    public void O000000o(String str, long j, String str2, int i, String str3, Business.ResultListener<GroupRespBean> resultListener) {
        ApiParams F = a.F(O00000o0, "1.1", true, "parentId", str2);
        F.putPostData("parentType", Integer.valueOf(i));
        F.putPostData("productId", str);
        F.setGid(j);
        F.putPostData("name", str3);
        asyncRequest(F, GroupRespBean.class, resultListener);
    }
}

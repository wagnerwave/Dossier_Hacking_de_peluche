package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.home.bean.HomeResponseBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.home.sdk.bean.HomeBean;
import java.util.ArrayList;
import java.util.List;

public class o0o0000oo extends Business {
    public static final String O000000o = "tuya.m.location.list";
    public static final String O00000Oo = "tuya.m.location.add";
    public static final String O00000o = "tuya.m.location.dismiss";
    public static final String O00000o0 = "tuya.m.location.update";
    public static final String O00000oO = "tuya.m.location.sort";
    public static final String O00000oo = "tuya.m.location.get";
    public static final String O0000O0o = "tuya.m.devs.user.group.bind";

    public void O000000o(long j, Business.ResultListener<HomeResponseBean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.location.get", "2.0");
        apiParams.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        asyncRequest(apiParams, HomeResponseBean.class, resultListener);
    }

    public void O000000o(long j, String str, double d2, double d3, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o0, "2.0");
        apiParams.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        apiParams.putPostData("name", str);
        if (d3 != 0.0d) {
            apiParams.putPostData(TuyaApiParams.KEY_LAT, Double.valueOf(d3));
        }
        if (d2 != 0.0d) {
            apiParams.putPostData(TuyaApiParams.KEY_LON, Double.valueOf(d2));
        }
        apiParams.putPostData("geoName", str2);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, String str, double d2, double d3, String str2, List<String> list, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o0, GwBroadcastMonitorService.mVersion);
        apiParams.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        apiParams.putPostData("name", str);
        if (d3 != 0.0d) {
            apiParams.putPostData(TuyaApiParams.KEY_LAT, Double.valueOf(d3));
        }
        if (d2 != 0.0d) {
            apiParams.putPostData(TuyaApiParams.KEY_LON, Double.valueOf(d2));
        }
        apiParams.putPostData("geoName", str2);
        apiParams.putPostData("rooms", list);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("overWriteRoom", (Object) Boolean.valueOf(z));
        apiParams.putPostData("options", jSONObject.toJSONString());
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, List<String> list, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000O0o, "1.0");
        apiParams.putPostData("devList", list);
        apiParams.putPostData("groupId", Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(Business.ResultListener<ArrayList<HomeResponseBean>> resultListener) {
        asyncArrayList(new ApiParams(O000000o, "2.1"), HomeResponseBean.class, resultListener);
    }

    public void O000000o(HomeBean homeBean, List<String> list, Business.ResultListener<HomeResponseBean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "2.0");
        apiParams.putPostData("name", homeBean.getName());
        if (homeBean.getLat() != 0.0d) {
            apiParams.putPostData(TuyaApiParams.KEY_LAT, Double.valueOf(homeBean.getLat()));
        }
        if (homeBean.getLon() != 0.0d) {
            apiParams.putPostData(TuyaApiParams.KEY_LON, Double.valueOf(homeBean.getLon()));
        }
        apiParams.putPostData("rooms", list);
        if (!TextUtils.isEmpty(homeBean.getGeoName())) {
            apiParams.putPostData("geoName", homeBean.getGeoName());
        }
        asyncRequest(apiParams, HomeResponseBean.class, resultListener);
    }

    public void O000000o(List<Long> list, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oO, "1.0");
        apiParams.putPostData("ids", list);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o, "2.0");
        apiParams.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }
}

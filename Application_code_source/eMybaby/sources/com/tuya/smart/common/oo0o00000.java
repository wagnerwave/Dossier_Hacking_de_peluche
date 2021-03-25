package com.tuya.smart.common;

import a.a.a.a.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.scene.bean.LocalSceneResBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.home.sdk.bean.scene.ActRespBean;
import com.tuya.smart.home.sdk.bean.scene.ConditionAllBean;
import com.tuya.smart.home.sdk.bean.scene.ConditionRespBean;
import com.tuya.smart.home.sdk.bean.scene.FunctionListBean;
import com.tuya.smart.home.sdk.bean.scene.PlaceFacadeBean;
import com.tuya.smart.home.sdk.bean.scene.SceneBean;
import com.tuya.smart.home.sdk.bean.scene.SceneIdBean;
import java.util.ArrayList;
import java.util.List;

public class oo0o00000 extends Business {
    public static final String O000000o = "tuya.m.scenario.device.list";
    public static final String O00000Oo = "tuya.m.linkage.rule.query";
    public static final String O00000o = "tuya.m.linkage.rule.save";
    public static final String O00000o0 = "tuya.m.linkage.rule.detsplash/build.gradleail";
    public static final String O00000oO = "tuya.m.linkage.rule.trigger";
    public static final String O00000oo = "tuya.m.action.list";
    public static final String O0000O0o = "tuya.m.scenario.modify";
    public static final String O0000OOo = "tuya.m.linkage.rule.remove";
    public static final String O0000Oo = "tuya.m.linkage.dev.group.list";
    public static final String O0000Oo0 = "tuya.m.linkage.dev.list";
    public static final String O0000OoO = "tuya.m.linkage.condition.source";
    public static final String O0000Ooo = "tuya.p.weather.city.info.position";
    public static final String O0000o = "tuya.m.linkage.rule.bind.candidates";
    public static final String O0000o0 = "tuya.m.linkage.condition.env";
    public static final String O0000o00 = "tuya.p.weather.city.info.list";
    public static final String O0000o0O = "tuya.p.weather.city.info.id";
    public static final String O0000o0o = "tuya.m.linkage.rule.bind.query";
    public static final String O0000oO = "tuya.m.linkage.rule.bind.save";
    public static final String O0000oO0 = "tuya.m.linkage.rule.bind.remove";
    public static final String O0000oOO = "tuya.m.linkage.function.list";
    public static final String O0000oOo = "tuya.m.linkage.res.cover.list";
    public static final String O0000oo = "tuya.m.linkage.cond.dev.list";
    public static final String O0000oo0 = "tuya.m.linkage.condition.all";

    public void O000000o(long j, int i, Business.ResultListener<ArrayList<String>> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oo, "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        apiParams.putPostData("type", Integer.valueOf(i));
        asyncArrayList(apiParams, String.class, resultListener);
    }

    public void O000000o(long j, Business.ResultListener<ArrayList<SceneBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "4.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        asyncArrayList(apiParams, SceneBean.class, resultListener);
    }

    public void O000000o(long j, SceneBean sceneBean, Business.ResultListener<SceneBean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o, "1.0");
        apiParams.putPostData("ruleExpr", sceneBean);
        apiParams.setGid(j);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, SceneBean.class, resultListener);
    }

    public void O000000o(long j, String str, Business.ResultListener<ArrayList<String>> resultListener) {
        ApiParams E = a.E(O0000Oo0, "2.0", true);
        E.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        E.putPostData("sourceType", str);
        asyncArrayList(E, String.class, resultListener);
    }

    public void O000000o(long j, List<String> list, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.linkage.rule.sort", "1.0");
        apiParams.setGid(j);
        apiParams.putPostData("sortedRuleIds", list);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, boolean z, Business.ResultListener<ConditionAllBean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oo0, "2.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        apiParams.putPostData("condAbility", 6L);
        apiParams.putPostData("showFahrenheit", Boolean.valueOf(z));
        asyncRequest(apiParams, ConditionAllBean.class, resultListener);
    }

    public void O000000o(Business.ResultListener<ArrayList<String>> resultListener) {
        asyncArrayList(a.E(O0000oOo, "1.0", true), String.class, resultListener);
    }

    public void O000000o(SceneBean sceneBean, Business.ResultListener<SceneBean> resultListener) {
        ApiParams E = a.E(O00000o, "1.0", true);
        E.putPostData("id", sceneBean.getId());
        E.putPostData("ruleExpr", JSON.toJSONString(sceneBean));
        asyncRequest(E, SceneBean.class, resultListener);
    }

    public void O000000o(String str, long j, Business.ResultListener<Boolean> resultListener) {
        a.D(O0000oO0, "1.0", "devId", str).putPostData("dpId", Long.valueOf(j));
    }

    public void O000000o(String str, long j, String str2, String str3, String str4, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O0000oO, "1.0", "devId", str);
        D.putPostData("dpId", Long.valueOf(j));
        D.putPostData(o0ooo00oo.O00000o0, str2);
        D.putPostData("localSid", str3);
        D.putPostData("ruleId", str4);
        asyncRequest(D);
    }

    public void O000000o(String str, Business.ResultListener<ArrayList<ActRespBean>> resultListener) {
        asyncArrayList(a.F(O00000oo, "1.0", true, "devId", str), ActRespBean.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<PlaceFacadeBean> resultListener) {
        ApiParams D = a.D(O0000Ooo, "1.0", TuyaApiParams.KEY_LON, str);
        D.putPostData(TuyaApiParams.KEY_LAT, str2);
        asyncRequest(D, PlaceFacadeBean.class, resultListener);
    }

    public void O000000o(List<String> list, Business.ResultListener<ArrayList<SceneIdBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.scene.group.alloc", "1.0");
        apiParams.putPostData("gwIds", list);
        asyncArrayList(apiParams, SceneIdBean.class, resultListener);
    }

    public void O000000o(boolean z, Business.ResultListener<ArrayList<ConditionRespBean>> resultListener) {
        ApiParams E = a.E(O0000o0, "2.0", true);
        E.putPostData("showFahrenheit", Boolean.valueOf(z));
        asyncArrayList(E, ConditionRespBean.class, resultListener);
    }

    public void O000000o(boolean z, String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(z ? "tuya.m.linkage.rule.enable" : "tuya.m.linkage.rule.disable", "1.0");
        apiParams.putPostData("ruleId", str);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(long j, Business.ResultListener<ArrayList<SceneBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "5.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        asyncArrayList(apiParams, SceneBean.class, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<ArrayList<ActRespBean>> resultListener) {
        asyncArrayList(a.F(O00000oo, "2.0", true, "groupId", str), ActRespBean.class, resultListener);
    }

    public void O00000o(long j, Business.ResultListener<PlaceFacadeBean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000o0O, "1.0");
        apiParams.putPostData("cityId", Long.valueOf(j));
        asyncRequest(apiParams, PlaceFacadeBean.class, resultListener);
    }

    public void O00000o(String str, Business.ResultListener<ArrayList<FunctionListBean>> resultListener) {
        asyncArrayList(a.F(O0000oOO, "1.0", true, "groupId", str), FunctionListBean.class, resultListener);
    }

    public void O00000o0(long j, Business.ResultListener<JSONObject> resultListener) {
        ApiParams E = a.E(O0000Oo, GwBroadcastMonitorService.mVersion, true);
        E.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        asyncRequest(E, resultListener);
    }

    public void O00000o0(String str, Business.ResultListener<ArrayList<FunctionListBean>> resultListener) {
        asyncArrayList(a.F(O0000oOO, "1.0", true, "devId", str), FunctionListBean.class, resultListener);
    }

    public void O00000oO(String str, Business.ResultListener<Boolean> resultListener) {
        asyncRequestBoolean(a.F(O00000oO, "1.0", true, "ruleId", str), resultListener);
    }

    public void O00000oo(String str, Business.ResultListener<Boolean> resultListener) {
        asyncRequestBoolean(a.F(O0000OOo, "1.0", true, "ruleId", str), resultListener);
    }

    public void O0000O0o(String str, Business.ResultListener<SceneBean> resultListener) {
        asyncRequest(a.F(O00000o0, "1.0", true, "ruleId", str), SceneBean.class, resultListener);
    }

    public void O0000OOo(String str, Business.ResultListener<ArrayList<ConditionRespBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O0000OoO, GwBroadcastMonitorService.mVersion);
        apiParams.putPostData("devId", str);
        apiParams.setSessionRequire(true);
        asyncArrayList(apiParams, ConditionRespBean.class, resultListener);
    }

    public void O0000Oo(String str, Business.ResultListener<ArrayList<LocalSceneResBean>> resultListener) {
        asyncArrayList(a.D(O0000o0o, "1.0", "devId", str), LocalSceneResBean.class, resultListener);
    }

    public void O0000Oo0(String str, Business.ResultListener<ArrayList<PlaceFacadeBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O0000o00, "1.0");
        apiParams.putPostData(o00ooo0o00.O000OOo0, str);
        apiParams.setSessionRequire(true);
        asyncArrayList(apiParams, PlaceFacadeBean.class, resultListener);
    }

    public void O0000OoO(String str, Business.ResultListener<ArrayList<SceneBean>> resultListener) {
        asyncArrayList(a.D(O0000o, "1.0", "devId", str), SceneBean.class, resultListener);
    }
}

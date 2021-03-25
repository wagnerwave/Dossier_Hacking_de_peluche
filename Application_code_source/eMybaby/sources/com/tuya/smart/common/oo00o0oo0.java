package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.personal.bean.AddShareInfoBean;
import com.tuya.sdk.personal.bean.DevShareUserBean;
import com.tuya.sdk.personal.bean.UserReceivedShareBean;
import com.tuya.sdk.personal.bean.UserReceivedShareInfoBean;
import com.tuya.sdk.personal.bean.UserShareInfoBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.home.sdk.bean.DeviceType;
import com.tuya.smart.home.sdk.bean.PersonBean;
import com.tuya.smart.home.sdk.bean.SharerInfoBean;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.ArrayList;
import java.util.List;

public class oo00o0oo0 extends Business {
    public static final String O000000o = "tuya.m.sharing.device.add";
    public static final String O00000Oo = "tuya.m.sharing.device.remove";
    public static final String O00000o = "tuya.m.sharing.device.member.list";
    public static final String O00000o0 = "tuya.m.sharing.sharer.remove.res";
    public static final String O00000oO = "tuya.m.sharing.device.group.add";
    public static final String O00000oo = "tuya.m.sharing.device.group.remove";
    public static final String O0000O0o = "tuya.m.sharing.device.group.member.list";
    public static final String O0000OOo = "tuya.m.sharing.member.add";
    public static final String O0000Oo = "tuya.m.sharing.member.list";
    public static final String O0000Oo0 = "tuya.m.sharing.member.detail.get";
    public static final String O0000OoO = "tuya.m.sharing.sharer.list";
    public static final String O0000Ooo = "tuya.m.sharing.member.name.update";
    public static final String O0000o = "tuya.m.sharing.device.account.add";
    public static final String O0000o0 = "tuya.m.sharing.options.auto.share.apply";
    public static final String O0000o00 = "tuya.m.sharing.sharer.name.update";
    public static final String O0000o0O = "tuya.m.sharing.device.list.group.list";
    public static final String O0000o0o = "tuya.m.sharing.sharer.resowner.find";
    public static final String O0000oO = "tuya.m.sharing.member.remove";
    public static final String O0000oO0 = "tuya.m.sharing.device.group.account.add";
    public static final String O0000oOO = "tuya.m.sharing.sharer.remove";
    public static final String O0000oOo = "tuya.m.sharing.sharer.detail.get";
    public static final String O0000oo = "tuya.m.my.shared.device.list";
    public static final String O0000oo0 = "tuya.m.sharing.device.batch.add";
    public static final String O0000ooO = "tuya.m.device.ref.info.list";
    public static final String O0000ooo = "tuya.m.my.shared.device.group.list";
    public static final String O000O00o = "tuya.m.sharing.mesh.add";
    public static final String O000O0OO = "tuya.m.sharing.mesh.remove";
    public static final String O00oOooO = "tuya.m.sharing.invite";
    public static final String O00oOooo = "tuya.m.sharing.accept";

    public void O000000o(int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00oOooo, "1.0");
        apiParams.putPostData("id", Integer.valueOf(i));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, long j2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oO, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j2));
        apiParams.putPostData("devGroupId", Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, Business.ResultListener<ArrayList<DevShareUserBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O0000O0o, "1.0");
        apiParams.putPostData("devGroupId", Long.valueOf(j));
        asyncArrayList(apiParams, DevShareUserBean.class, resultListener);
    }

    public void O000000o(long j, String str, long j2, long j3, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.sharing.device.temp.add", "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        apiParams.putPostData("devId", str);
        apiParams.putPostData("beginTime", Long.valueOf(j2));
        apiParams.putPostData("endTime", Long.valueOf(j3));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000Ooo, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        apiParams.putPostData("name", str);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, String str, String str2, long j2, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O0000oO0, "2.0", o00ooo0o00.O000OOo0, str);
        D.putPostData("userAccount", str2);
        D.putPostData("groupId", Long.valueOf(j));
        D.putPostData("devGroupId", Long.valueOf(j2));
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(long j, String str, String str2, List<String> list, long j2, long j3, Business.ResultListener<AddShareInfoBean> resultListener) {
        ApiParams D = a.D("tuya.m.sharing.device.account.temp.add", "1.0", o00ooo0o00.O000OOo0, str);
        D.putPostData("userAccount", str2);
        D.putPostData("devIds", list);
        D.setGid(j);
        D.putPostData("beginTime", Long.valueOf(j2));
        D.putPostData("endTime", Long.valueOf(j3));
        asyncRequest(D, AddShareInfoBean.class, resultListener);
    }

    public void O000000o(long j, String str, String str2, List<String> list, List<Long> list2, List<String> list3, boolean z, Business.ResultListener<AddShareInfoBean> resultListener) {
        ApiParams D = a.D(O0000OOo, "2.0", o00ooo0o00.O000OOo0, str);
        D.putPostData("userAccount", str2);
        D.putPostData("devIds", list);
        D.putPostData("meshIds", list3);
        D.putPostData("groupId", Long.valueOf(j));
        D.putPostData("devGroupIds", list2);
        D.putPostData("autoSharing", Boolean.valueOf(z));
        asyncRequest(D, AddShareInfoBean.class, resultListener);
    }

    public void O000000o(long j, String str, String str2, List<String> list, List<Long> list2, boolean z, Business.ResultListener<Long> resultListener) {
        ApiParams D = a.D(O0000OOo, "1.0", o00ooo0o00.O000OOo0, str);
        D.putPostData("userAccount", str2);
        D.putPostData("devIds", list);
        D.putPostData("devGroupIds", list2);
        D.setGid(j);
        D.putPostData("autoSharing", Boolean.valueOf(z));
        asyncRequest(D, Long.class, resultListener);
    }

    public void O000000o(long j, List<String> list, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oo0, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        apiParams.putPostData("devIds", list);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(long j, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000o0, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        apiParams.putPostData("optionValue", Boolean.valueOf(z));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(Business.ResultListener<ArrayList<UserReceivedShareBean>> resultListener) {
        asyncArrayList(new ApiParams(O0000OoO, "1.0"), UserReceivedShareBean.class, resultListener);
    }

    public void O000000o(Long l, String str, String str2, List<String> list, Business.ResultListener<AddShareInfoBean> resultListener) {
        ApiParams D = a.D(O0000o, "2.0", o00ooo0o00.O000OOo0, str);
        D.putPostData("userAccount", str2);
        D.putPostData("groupId", l);
        D.putPostData("devIds", list);
        asyncRequest(D, AddShareInfoBean.class, resultListener);
    }

    public void O000000o(String str, long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        apiParams.putPostData("devId", str);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O00000o0, "1.0", "resId", str);
        D.putPostData("resType", oOO0O0O0.O0000oOO);
        asyncRequestBoolean(D, resultListener);
    }

    public void O000000o(String str, DeviceType deviceType, String str2, String str3, Business.ResultListener<Integer> resultListener) {
        ApiParams D = a.D(O00oOooO, "1.0", "resId", str);
        D.putPostData("resType", Integer.valueOf(deviceType.getType()));
        D.putPostData("userAccount", str2);
        D.putPostData(o00ooo0o00.O000OOo0, str3);
        asyncRequest(D, Integer.class, resultListener);
    }

    public void O000000o(String str, String str2, List<String> list, long j, long j2, Business.ResultListener<AddShareInfoBean> resultListener) {
        ApiParams D = a.D("tuya.m.sharing.mesh.account.temp.add", "1.0", o00ooo0o00.O000OOo0, str);
        D.putPostData("userAccount", str2);
        D.putPostData("meshIds", list);
        D.putPostData("beginTime", Long.valueOf(j));
        D.putPostData("endTime", Long.valueOf(j2));
        asyncRequest(D, AddShareInfoBean.class, resultListener);
    }

    public void O000000o(String str, String str2, List<String> list, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O0000o, "1.0", o00ooo0o00.O000OOo0, str);
        D.putPostData("userAccount", str2);
        D.putPostData("devIds", list);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(List<String> list, Business.ResultListener<ArrayList<ProductBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.ref.info.list", GwBroadcastMonitorService.mVersion);
        apiParams.putPostData("productIds", list);
        apiParams.setSessionRequire(true);
        apiParams.putPostData("zigbeeGroup", Boolean.TRUE);
        asyncArrayList(apiParams, ProductBean.class, resultListener);
    }

    public void O00000Oo(long j, long j2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000oo, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j2));
        apiParams.putPostData("devGroupId", Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(long j, Business.ResultListener<ArrayList<PersonBean>> resultListener) {
        ApiParams apiParams = new ApiParams(O0000Oo, "1.0");
        apiParams.putPostData("groupId", Long.valueOf(j));
        asyncArrayList(apiParams, PersonBean.class, resultListener);
    }

    public void O00000Oo(long j, String str, long j2, long j3, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.sharing.mesh.temp.add", "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        apiParams.putPostData("meshId", str);
        apiParams.putPostData("beginTime", Long.valueOf(j2));
        apiParams.putPostData("endTime", Long.valueOf(j3));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(long j, String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000o00, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        apiParams.putPostData("name", str);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(Business.ResultListener<ArrayList<DeviceRespBean>> resultListener) {
        asyncArrayList(a.E("tuya.m.my.shared.device.list", "1.0", true), DeviceRespBean.class, resultListener);
    }

    public void O00000Oo(String str, long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        apiParams.putPostData("devId", str);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<ArrayList<DevShareUserBean>> resultListener) {
        asyncArrayList(a.D(O00000o, "1.0", "devId", str), DevShareUserBean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, List<String> list, Business.ResultListener<AddShareInfoBean> resultListener) {
        ApiParams D = a.D("tuya.m.sharing.mesh.account.add", "1.0", o00ooo0o00.O000OOo0, str);
        D.putPostData("userAccount", str2);
        D.putPostData("meshIds", list);
        asyncRequest(D, AddShareInfoBean.class, resultListener);
    }

    public void O00000o(long j, Business.ResultListener<UserShareInfoBean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000Oo0, "2.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        asyncRequest(apiParams, UserShareInfoBean.class, resultListener);
    }

    public void O00000o(String str, long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O000O0OO, "1.0", "meshId", str);
        D.putPostData("relationId", Long.valueOf(j));
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O00000o0(long j, Business.ResultListener<UserShareInfoBean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000Oo0, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        asyncRequest(apiParams, UserShareInfoBean.class, resultListener);
    }

    public void O00000o0(Business.ResultListener<ArrayList<GroupRespBean>> resultListener) {
        asyncArrayList(a.E("tuya.m.my.shared.device.group.list", "2.0", true), GroupRespBean.class, resultListener);
    }

    public void O00000o0(String str, long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O000O00o, "1.0", "meshId", str);
        D.putPostData("relationId", Long.valueOf(j));
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O00000o0(String str, Business.ResultListener<SharerInfoBean> resultListener) {
        asyncRequest(a.D(O0000o0o, "1.0", "resId", str), SharerInfoBean.class, resultListener);
    }

    public void O00000oO(long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oO, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000oo(long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oOO, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O0000O0o(long j, Business.ResultListener<UserReceivedShareInfoBean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000oOo, "1.0");
        apiParams.putPostData("relationId", Long.valueOf(j));
        asyncRequest(apiParams, UserReceivedShareInfoBean.class, resultListener);
    }
}

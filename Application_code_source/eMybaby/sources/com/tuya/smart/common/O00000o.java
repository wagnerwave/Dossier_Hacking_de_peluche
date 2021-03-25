package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;

public class O00000o extends Business {
    public static final String O000000o = "tuya.m.device.ble.mesh.create";
    public static final String O00000Oo = "tuya.m.device.ble.mesh.dismiss";
    public static final String O00000o = "tuya.m.device.ble.mesh.leave";
    public static final String O00000o0 = "tuya.m.device.ble.mesh.name.update";
    public static final String O00000oO = "tuya.m.device.sub.name.update";
    public static final String O00000oo = "tuya.m.device.sub.list";
    public static final String O0000O0o = "tuya.m.device.ble.mesh.join";
    public static final String O0000OOo = "tuya.m.device.group.add";
    public static final String O0000Oo = "tuya.m.device.sig.mesh.create";
    public static final String O0000Oo0 = "tuya.m.room.background.update";

    public void O000000o(long j, Business.ResultListener<SigMeshBean> resultListener) {
        ApiParams apiParams = new ApiParams(O0000Oo, "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        asyncRequest(apiParams, SigMeshBean.class, resultListener);
    }

    public void O000000o(long j, String str, Business.ResultListener<BlueMeshBean> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "1.0");
        apiParams.putPostData("meshName", str);
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        asyncRequest(apiParams, BlueMeshBean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "1.0");
        apiParams.putPostData("meshId", str);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O00000o0, "1.0", "meshId", str);
        D.putPostData("name", str2);
        D.setSessionRequire(true);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, int i, String str4, int i2, Business.ResultListener<GroupRespBean> resultListener) {
        ApiParams D = a.D(O0000OOo, "3.1", "localId", str);
        D.putPostData("name", str2);
        D.putPostData("parentId", str3);
        D.putPostData("parentType", Integer.valueOf(i));
        D.putPostData("groupType", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str4)) {
            D.putPostData("category", str4);
        }
        asyncRequest(D, GroupRespBean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, int i, String str4, Business.ResultListener<Long> resultListener) {
        ApiParams D = a.D(O0000OOo, "2.0", "localId", str);
        D.putPostData("name", str2);
        D.putPostData("parentId", str3);
        D.putPostData("parentType", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str4)) {
            D.putPostData("category", str4);
        }
        asyncRequest(D, Long.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D("tuya.m.device.sub.name.update", "1.0", "meshId", str);
        D.putPostData("devId", str2);
        D.putPostData("name", str3);
        D.setSessionRequire(true);
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, Business.ResultListener<DeviceRespBean> resultListener) {
        ApiParams D = a.D(O0000O0o, "1.0", "meshId", str);
        D.putPostData("nodeId", str3);
        D.putPostData("productKey", str4);
        D.putPostData("uuid", str2);
        D.setSessionRequire(true);
        D.putPostData("ver", str5);
        asyncRequest(D, DeviceRespBean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, String str6, Business.ResultListener<DeviceRespBean> resultListener) {
        ApiParams D = a.D(O0000O0o, "2.0", "meshId", str);
        D.putPostData("nodeId", str3);
        D.putPostData("productKey", str5);
        D.putPostData("encryptedAuthKey", str4);
        D.putPostData("uuid", str2);
        D.setSessionRequire(true);
        D.putPostData("ver", str6);
        asyncRequest(D, DeviceRespBean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Business.ResultListener<DeviceRespBean> resultListener) {
        ApiParams D = a.D(O0000O0o, GwBroadcastMonitorService.mVersion, "meshId", str);
        D.putPostData("nodeId", str3);
        D.putPostData("productKey", str4);
        D.putPostData("uuid", str2);
        D.putPostData("devKey", str6);
        D.putPostData("mac", str7);
        if (!TextUtils.isEmpty(str8)) {
            D.putPostData("options", str8);
        }
        D.setSessionRequire(true);
        D.putPostData("ver", str5);
        asyncRequest(D, DeviceRespBean.class, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<ArrayList<DeviceRespBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.sub.list", "1.1");
        apiParams.putPostData("meshId", str);
        apiParams.setSessionRequire(true);
        asyncArrayList(apiParams, DeviceRespBean.class, resultListener);
    }

    public void O00000Oo(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o, "1.0");
        apiParams.putPostData("devId", str);
        apiParams.setSessionRequire(true);
        apiParams.putPostData("meshId", str2);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000o(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        L.d(Business.TAG, "updateMeshRoomImage background:" + str2);
        ApiParams apiParams = new ApiParams(O0000Oo0, "1.0");
        apiParams.putPostData("roomId", str);
        apiParams.putPostData(NotificationCompat.WearableExtender.KEY_BACKGROUND, str2);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000o0(String str, String str2, Business.ResultListener<DeviceRespBean> resultListener) {
        ApiParams D = a.D("tuya.m.device.sub.get", "1.1", "meshId", str);
        D.putPostData("devId", str2);
        D.setSessionRequire(true);
        asyncRequest(D, DeviceRespBean.class, resultListener);
    }
}

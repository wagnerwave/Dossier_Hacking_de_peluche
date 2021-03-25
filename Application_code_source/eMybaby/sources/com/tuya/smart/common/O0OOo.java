package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.blemesh.api.BusinessResultListener;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshBusiness;
import com.tuya.smart.android.blemesh.bean.BLEUpgradeBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import com.tuya.smart.sdk.api.ITuyaActivatorGetToken;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.Map;

public class O0OOo extends Business implements ITuyaBlueMeshBusiness<BusinessResponse> {
    public static final String O000000o = "tuya.m.device.upgrade.info";
    public static final String O00000Oo = "tuya.m.device.version.update";
    public static final String O00000o = "tuya.m.mesh.relation.list";
    public static final String O00000o0 = "tuya.m.device.ble.mesh.node.alloc";
    public static final String O00000oO = "s.m.gw.location.update";
    public static final String O00000oo = "tuya.m.my.group.mesh.list";
    public static final String O0000O0o = "tuya.m.device.sig.mesh.list";
    public static final String O0000OOo = "tuya.m.sig.mesh.source.id.alloc";

    public void O000000o(long j, String str, String str2, String str3, String str4, String str5, String str6, final ITuyaActivatorGetToken iTuyaActivatorGetToken) {
        ApiParams apiParams = new ApiParams(oOo00.O0000Oo0, "1.0");
        apiParams.putPostData("timeZone", TyCommonUtil.getTimeZone());
        JSONObject jSONObject = new JSONObject();
        apiParams.setSessionRequire(true);
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("nodeId", (Object) str3);
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("productKey", (Object) str);
        }
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("uuid", (Object) str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            jSONObject.put("encryptedAuthKey", (Object) str5);
        }
        jSONObject.put("meshId", (Object) str2);
        jSONObject.put("ver", (Object) str6);
        apiParams.setGid(j);
        apiParams.putPostData("options", jSONObject.toJSONString());
        L.d(Business.TAG, "options:" + jSONObject.toJSONString());
        asyncRequest(apiParams, ActiveTokenBean.class, new Business.ResultListener<ActiveTokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                ITuyaActivatorGetToken iTuyaActivatorGetToken = iTuyaActivatorGetToken;
                if (iTuyaActivatorGetToken != null) {
                    iTuyaActivatorGetToken.onFailure(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                ITuyaActivatorGetToken iTuyaActivatorGetToken = iTuyaActivatorGetToken;
                if (iTuyaActivatorGetToken != null) {
                    iTuyaActivatorGetToken.onSuccess(TuyaSmartNetWork.getRegion() + activeTokenBean.getToken() + activeTokenBean.getSecret());
                }
            }
        });
    }

    public void O000000o(String str) {
        asyncRequest(a.F("s.m.gw.location.update", "1.0", true, o0ooo00oo.O00000o0, str));
    }

    public void O000000o(String str, Business.ResultListener<Integer> resultListener) {
        asyncRequest(a.F(O00000o0, "1.0", true, "meshId", str), Integer.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000Oo, "4.1", true, "devId", str);
        F.putPostData("softVer", str2);
        F.putPostData("type", 1);
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<Integer> resultListener) {
        asyncRequest(a.F(O0000OOo, "1.0", true, "meshId", str), Integer.class, resultListener);
    }

    public void O00000Oo(String str, String str2, Business.ResultListener<Integer> resultListener) {
        ApiParams F = a.F(O00000o0, "2.0", true, "meshId", str);
        F.putPostData("type", str2);
        asyncRequest(F, Integer.class, resultListener);
    }

    public void O00000o0(String str, Business.ResultListener<Map<String, String>> resultListener) {
        asyncHashMap(a.F(O00000o, "1.0", true, "meshId", str), String.class, resultListener);
    }

    public void getMeshList(long j, final BusinessResultListener<ArrayList<BlueMeshBean>, BusinessResponse> businessResultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.my.group.mesh.list", "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        asyncArrayList(apiParams, BlueMeshBean.class, new Business.ResultListener<ArrayList<BlueMeshBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<BlueMeshBean> arrayList, String str) {
                businessResultListener.onFailure(businessResponse, arrayList, str);
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<BlueMeshBean> arrayList, String str) {
                businessResultListener.onSuccess(businessResponse, arrayList, str);
            }
        });
    }

    public void getSigMeshList(long j, final BusinessResultListener<ArrayList<SigMeshBean>, BusinessResponse> businessResultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.sig.mesh.list", "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        asyncArrayList(apiParams, SigMeshBean.class, new Business.ResultListener<ArrayList<SigMeshBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<SigMeshBean> arrayList, String str) {
                businessResultListener.onFailure(businessResponse, arrayList, str);
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<SigMeshBean> arrayList, String str) {
                businessResultListener.onSuccess(businessResponse, arrayList, str);
            }
        });
    }

    public void meshFirmwareUpgradeCheck(String str, final BusinessResultListener<ArrayList<BLEUpgradeBean>, BusinessResponse> businessResultListener) {
        asyncArrayList(a.F("tuya.m.device.upgrade.info", "1.0", true, "devId", str), BLEUpgradeBean.class, new Business.ResultListener<ArrayList<BLEUpgradeBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<BLEUpgradeBean> arrayList, String str) {
                businessResultListener.onFailure(businessResponse, arrayList, str);
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<BLEUpgradeBean> arrayList, String str) {
                businessResultListener.onSuccess(businessResponse, arrayList, str);
            }
        });
    }
}

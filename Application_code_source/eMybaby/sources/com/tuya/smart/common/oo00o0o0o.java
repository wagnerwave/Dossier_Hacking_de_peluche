package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Build;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.push.PushStatusBean;

public class oo00o0o0o extends Business {
    public static final String O000000o = "b.m.device.register";
    public static final String O00000Oo = "tuya.m.device.push.status.switch";
    public static final String O00000o = "tuya.m.msg.notice.switch.status";
    public static final String O00000o0 = "tuya.m.device.push.status.get";
    public static final String O00000oO = "tuya.m.msg.notice.switch.setting";

    public void O000000o(int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O00000o, "1.0", true);
        E.putPostData("type", Integer.valueOf(i));
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O000000o(int i, boolean z, Business.ResultListener<Boolean> resultListener) {
        ApiParams E = a.E(O00000oO, "1.0", true);
        E.putPostData("type", Integer.valueOf(i));
        E.putPostData("close", Boolean.valueOf(z));
        asyncRequest(E, Boolean.class, resultListener);
    }

    public void O000000o(String str, int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F("tuya.m.device.push.status.switch", "1.0", true, "deviceId", str);
        F.putPostData("status", Integer.valueOf(i));
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<PushStatusBean> resultListener) {
        asyncRequest(a.F("tuya.m.device.push.status.get", "1.0", true, "deviceId", str), PushStatusBean.class, resultListener);
    }

    public void O000000o(String str, String str2, final IResultCallback iResultCallback) {
        ApiParams D = a.D(O000000o, GwBroadcastMonitorService.mVersion, "pushToken", str);
        D.putPostData("pushVersion", "1.0");
        D.putPostData("isEnglish", Integer.valueOf(TyCommonUtil.isZh(TuyaSmartSdk.getApplication()) ? 1 : 0));
        D.putPostData("model", Build.MODEL);
        D.putPostData("pushProvider", str2);
        D.setSessionRequire(true);
        asyncRequest(D, new Business.ResultListener<JSONObject>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }
}

package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.interior.enums.FrameTypeEnum;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;
import java.util.Map;

public class oO0O0o0o {
    public static final String O000000o = "LocalControlModel";

    public static void O000000o(String str, JSONObject jSONObject, o0oo00o00o o0oo00o00o, FrameTypeEnum frameTypeEnum, IResultCallback iResultCallback) {
        DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(str);
        if (deviceBean != null) {
            HgwBean hgwBean = deviceBean.getHgwBean();
            if (hgwBean != null) {
                O000000o(str, deviceBean.isEncrypt() ? deviceBean.getLocalKey() : null, jSONObject, hgwBean.getVersion(), o0oo00o00o, frameTypeEnum, iResultCallback);
            } else if (iResultCallback != null) {
                iResultCallback.onError("11005", "device is not local online");
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("11005", "device is not exist");
        }
    }

    public static void O000000o(String str, Object obj, int i, IResultCallback iResultCallback) {
        String str2;
        DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(str);
        if (deviceBean == null) {
            str2 = "dev == null";
        } else {
            HgwBean hgwBean = deviceBean.getHgwBean();
            if (hgwBean == null) {
                str2 = "hgwbean == null";
            } else {
                o0oo0o0o00 o0oo0o0o00 = new o0oo0o0o00();
                o0oo0o0o00.O000000o(str).O000000o(obj).O00000o0(hgwBean.getVersion()).O00000Oo(deviceBean.getLocalKey()).O000000o(i);
                o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
                if (o0o00o0o00 != null) {
                    o0o00o0o00.O000000o().O000000o(o0oo0o0o00, iResultCallback);
                    return;
                }
                return;
            }
        }
        L.e(O000000o, str2);
    }

    public static void O000000o(String str, String str2, JSONObject jSONObject, String str3, o0oo00o00o o0oo00o00o, FrameTypeEnum frameTypeEnum, IResultCallback iResultCallback) {
        if (L.getLogStatus()) {
            StringBuilder n = a.n("SandR o:");
            n.append(o0oo00o00o.O000000o());
            n.append(" s: ");
            n.append(o0oo00o00o.O00000Oo());
            L.d(O000000o, n.toString());
        }
        o0oo0o00oo o0oo0o00oo = new o0oo0o00oo();
        o0oo0o00oo.O000000o((Object) jSONObject).O000000o(str).O00000Oo(str3).O00000o0(o0oo00o00o.O00000Oo()).O00000Oo(o0oo00o00o.O000000o()).O000000o(frameTypeEnum.getType()).O00000o0(str2);
        o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
        if (o0o00o0o00 != null) {
            if (iResultCallback instanceof oOO0O00O) {
                oOO0O00O ooo0o00o = (oOO0O00O) iResultCallback;
                ooo0o00o.O00000o = oOO0O0O0.O00000oO;
                Map<String, String> O000000o2 = ooo0o00o.O000000o();
                O000000o2.put("localKey", str2);
                O000000o2.put("data", jSONObject.toJSONString());
                O000000o2.put("lpv", str3);
                O000000o2.put("sandR", "o=" + o0oo00o00o.O000000o() + ",s=" + o0oo00o00o.O00000Oo());
                oOO0O0O0.O000000o(oOO0O0O0.O00000oO, O000000o2);
            }
            o0o00o0o00.O000000o().O000000o(o0oo0o00oo, iResultCallback);
        }
    }

    public static void O000000o(String str, String str2, IResultCallback iResultCallback) {
        FrameTypeEnum frameTypeEnum;
        JSONObject jSONObject = new JSONObject();
        DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(str);
        if (deviceBean == null) {
            L.e(O000000o, "dev == null");
            return;
        }
        if ((TuyaUtil.compareVersion(deviceBean.getCadv(), "1.0.1") >= 0 || deviceBean.isBleMesh() || deviceBean.hasZigBee()) && TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        if (TextUtils.isEmpty(str2)) {
            jSONObject.put(o0ooo00oo.O00000o0, (Object) str);
            jSONObject.put("devId", (Object) str);
            frameTypeEnum = FrameTypeEnum.DP_QUERY;
        } else {
            if (!TextUtils.equals(str2, str)) {
                jSONObject.put("cid", (Object) str2);
            }
            frameTypeEnum = FrameTypeEnum.DP_QUERY_NEW;
        }
        if (L.getLogStatus()) {
            StringBuilder n = a.n("queryDp: ");
            n.append(jSONObject.toJSONString());
            L.d(O000000o, n.toString());
        }
        O000000o(str, (Object) jSONObject, frameTypeEnum.getType(), iResultCallback);
    }

    public static void O000000o(String str, String str2, String str3, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TuyaApiParams.KEY_GID, (Object) str2);
        jSONObject.put(TuyaApiParams.KEY_SESSION, (Object) str3);
        O000000o(str, (Object) jSONObject, FrameTypeEnum.SCENE_EXECUTE.getType(), iResultCallback);
    }

    public static void O000000o(String str, List<String> list, List<Integer> list2, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dpId", (Object) list2);
        if (list != null && list.size() > 0) {
            jSONObject.put("cid", (Object) list);
        }
        O000000o(str, (Object) jSONObject, FrameTypeEnum.DP_QUERY_GENERAL.type, iResultCallback);
    }

    public static void O00000Oo(String str, String str2, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sceneId", (Object) str2);
        O000000o(str, (Object) jSONObject, FrameTypeEnum.SCENE_EXECUTE_NEW.getType(), iResultCallback);
    }
}

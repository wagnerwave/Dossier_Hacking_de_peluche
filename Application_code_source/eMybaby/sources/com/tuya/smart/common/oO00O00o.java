package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.List;
import java.util.Map;

public class oO00O00o {
    public static void O000000o(int i, String str, String str2, long j, String str3, String str4, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) Integer.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("token", (Object) str2);
        }
        if (j != -1) {
            jSONObject.put("time", (Object) Long.valueOf(j));
        }
        O000000o(str, str3, str4, (Object) jSONObject, o0oo00o00o, 200, iResultCallback);
    }

    public static void O000000o(String str, String str2, String str3, int i, String str4, String str5, List<String> list, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", (Object) Integer.valueOf(i));
        jSONObject.put("cids", (Object) list);
        jSONObject.put(TuyaApiParams.KEY_SESSION, (Object) str5);
        jSONObject.put(TuyaApiParams.KEY_GID, (Object) str4);
        O000000o(str, str2, str3, (Object) jSONObject, o0oo00o00o, 204, iResultCallback);
    }

    public static void O000000o(String str, String str2, String str3, int i, String str4, List<String> list, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", (Object) Integer.valueOf(i));
        jSONObject.put("cids", (Object) list);
        jSONObject.put(TuyaApiParams.KEY_GID, (Object) str4);
        O000000o(str, str2, str3, (Object) jSONObject, o0oo00o00o, 202, iResultCallback);
    }

    public static void O000000o(String str, String str2, String str3, long j, String str4, String str5, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("stat", (Object) str);
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("token", (Object) str3);
        }
        if (j != -1) {
            jSONObject.put("timeout", (Object) Long.valueOf(j));
        }
        O000000o(str2, str4, str5, (Object) jSONObject, o0oo00o00o, 51, iResultCallback);
    }

    public static void O000000o(String str, String str2, String str3, JSONObject jSONObject, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        O000000o(str, str2, str3, (Object) jSONObject, o0oo00o00o, 5, iResultCallback);
    }

    public static void O000000o(String str, String str2, String str3, Object obj, o0oo00o00o o0oo00o00o, int i, IResultCallback iResultCallback) {
        o0oo0oo0o0 O00000o0 = new o0oo0oo0o0().O000000o(obj).O00000o0(str3).O00000Oo(str2).O00000Oo(i).O000000o(str).O000000o(o0oo00o00o.O00000Oo()).O00000o(o0oo00o00o.O000000o()).O00000oO(o0oo00o00o.O00000Oo()).O00000o0((int) TimeStampManager.instance().getCurrentTimeStamp());
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            if (iResultCallback instanceof oOO0O00O) {
                oOO0O00O ooo0o00o = (oOO0O00O) iResultCallback;
                ooo0o00o.O00000o = oOO0O0O0.O00000o0;
                Map<String, String> O000000o = ooo0o00o.O000000o();
                O000000o.put(o0ooo00oo.O00000oO, str2);
                O000000o.put("localKey", str3);
                O000000o.put("data", ((JSONObject) obj).toJSONString());
                O000000o.put(o0ooo00oo.O00000o, String.valueOf(i));
                O000000o.put("sandR", "o=" + o0oo00o00o.O000000o() + ",s=" + o0oo00o00o.O00000Oo());
                oOO0O0O0.O000000o(oOO0O0O0.O00000o0, O000000o);
            }
            o0o00o0oo0.O000000o().O000000o(O00000o0, iResultCallback);
        }
    }

    public static void O000000o(String str, String str2, String str3, String str4, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sceneId", (Object) str);
        O000000o(str2, str3, str4, (Object) jSONObject, o0oo00o00o, (int) o0oO0Ooo.O000OOo0, iResultCallback);
    }

    public static void O000000o(String str, List<String> list, List<Integer> list2, String str2, String str3, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dpId", (Object) list2);
        if (list != null && list.size() > 0) {
            jSONObject.put("cid", (Object) list);
        }
        O000000o(str, str2, str3, (Object) jSONObject, o0oo00o00o, 31, iResultCallback);
    }

    public static void O00000Oo(String str, String str2, String str3, JSONObject jSONObject, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        O000000o(str, str2, str3, (Object) jSONObject, o0oo00o00o, 22, iResultCallback);
    }
}

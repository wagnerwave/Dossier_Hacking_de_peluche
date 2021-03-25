package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.interior.enums.FrameTypeEnum;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.LinkedHashMap;
import java.util.List;

public class oO0Oo0oo {
    public static final String O000000o = "DevLocalControlImpl";

    public void O000000o(String str, String str2, int i, LinkedHashMap<String, Object> linkedHashMap, o0oo00o00o o0oo00o00o, String str3, IResultCallback iResultCallback) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.equals(str, str2) && !TextUtils.isEmpty(str2)) {
            jSONObject.put("cid", (Object) str2);
            jSONObject.put("ctype", (Object) Integer.valueOf(i));
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("mbid", (Object) str3);
        }
        jSONObject.put("dps", (Object) linkedHashMap);
        oO0O0o0o.O000000o(str, jSONObject, o0oo00o00o, FrameTypeEnum.CONTROL_NEW, iResultCallback);
    }

    public void O000000o(String str, LinkedHashMap<String, Object> linkedHashMap, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        User user;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dps", (Object) linkedHashMap);
        jSONObject.put("devId", (Object) str);
        DeviceBean O00000Oo = oO00O0o0.O000000o().O00000Oo(str);
        if (O00000Oo.getHgwBean() != null && TuyaUtil.checkHgwVersion(O00000Oo.getHgwBean().getVersion(), 1.1f)) {
            jSONObject.put(o0ooo00oo.O00000oo, (Object) Long.valueOf(TimeStampManager.instance().getCurrentTimeStamp()));
        }
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (!(o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null)) {
            jSONObject.put("uid", (Object) user.getUid());
        }
        oO0O0o0o.O000000o(str, jSONObject, o0oo00o00o, FrameTypeEnum.CONTROL, iResultCallback);
    }

    public void O000000o(String str, List<String> list, List<Integer> list2, IResultCallback iResultCallback) {
        oO0O0o0o.O000000o(str, list, list2, iResultCallback);
    }
}

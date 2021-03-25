package com.tuya.smart.common;

import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.config.bean.APConfigBean;
import com.tuya.sdk.config.bean.ActiveBean;
import com.tuya.sdk.config.bean.EnableWifiBean;
import com.tuya.smart.android.common.utils.TyCommonUtil;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.interior.enums.FrameTypeEnum;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;

public class OOOo00 {
    public static final int O000000o = 200;
    public static final String O00000Oo = "TuyaHardwareConfigManager";

    public static void O000000o() {
    }

    public static void O000000o(String str) {
        o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
        if (o0o00o0o00 != null) {
            o0o00o0o00.O000000o().O000000o(str);
        }
    }

    public static void O000000o(String str, int i, IResultCallback iResultCallback) {
        EnableWifiBean enableWifiBean = new EnableWifiBean();
        enableWifiBean.setType(0);
        enableWifiBean.setTime((short) i);
        O000000o(str, (Object) enableWifiBean, FrameTypeEnum.ENABLE_WIFI.getType(), iResultCallback);
    }

    public static void O000000o(String str, Object obj, int i, IResultCallback iResultCallback) {
        String str2;
        DeviceBean deviceBean;
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        String str3 = null;
        if (o0o00o00o0 == null || (deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(str)) == null) {
            str2 = null;
        } else {
            String localKey = deviceBean.getLocalKey();
            if (deviceBean.getHgwBean() != null) {
                str3 = deviceBean.getHgwBean().getVersion();
            }
            str2 = str3;
            str3 = localKey;
        }
        o0oo0o0o00 o0oo0o0o00 = new o0oo0o0o00();
        o0oo0o0o00.O000000o(str).O000000o(obj).O00000Oo(str3).O00000o0(str2).O000000o(i);
        o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
        if (o0o00o0o00 != null) {
            o0o00o0o00.O000000o().O000000o(o0oo0o0o00, iResultCallback);
        }
    }

    public static void O000000o(String str, String str2, String str3, JSONObject jSONObject, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        O000000o(str, str2, str3, jSONObject, o0oo00o00o, 200, iResultCallback);
    }

    public static void O000000o(String str, String str2, String str3, IResultCallback iResultCallback) {
        APConfigBean aPConfigBean = new APConfigBean();
        aPConfigBean.setSsid(str2);
        aPConfigBean.setPasswd(str3);
        O000000o(str, (Object) aPConfigBean, FrameTypeEnum.AP_CONFIG.getType(), iResultCallback);
    }

    public static void O000000o(String str, String str2, String str3, Object obj, o0oo00o00o o0oo00o00o, int i, IResultCallback iResultCallback) {
        o0oo0oo0o0 O00000o0 = new o0oo0oo0o0().O000000o(obj).O00000o0(str3).O00000Oo(str2).O00000Oo(i).O000000o(str).O000000o(o0oo00o00o.O00000Oo()).O00000o(o0oo00o00o.O000000o()).O00000oO(o0oo00o00o.O00000Oo()).O00000o0((int) TimeStampManager.instance().getCurrentTimeStamp());
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            o0o00o0oo0.O000000o().O000000o(O00000o0, iResultCallback);
        }
    }

    public static void O000000o(String str, String str2, String[] strArr, IResultCallback iResultCallback) {
        User user;
        ActiveBean activeBean = new ActiveBean();
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (!(o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null)) {
            activeBean.setUid(user.getUid());
            activeBean.setToken(user.getEcode());
        }
        activeBean.setHttpUrl(str2);
        activeBean.setMqUrl(strArr[0]);
        activeBean.setTimeZone(TyCommonUtil.getTimeZone());
        O000000o(str, (Object) activeBean, FrameTypeEnum.ACTIVE.getType(), iResultCallback);
    }
}

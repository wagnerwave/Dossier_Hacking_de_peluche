package com.tuya.smart.common;

import com.tuya.smart.android.base.TuyaSmartSdk;
import java.util.Map;
import java.util.UUID;

public class oOO0O0O0 {
    public static final String O000000o = "event_sdk_instruct_start";
    public static final String O00000Oo = "event_sdk_instruct_end";
    public static final String O00000o = "event_sdk_instruct_http";
    public static final String O00000o0 = "event_sdk_instruct_mqtt";
    public static final String O00000oO = "event_sdk_instruct_tcp";
    public static final String O00000oo = "event_sdk_instruct_dp_update";
    public static final String O0000O0o = "code";
    public static final String O0000OOo = "msg";
    public static final String O0000Oo = "group_id";
    public static final String O0000Oo0 = "device_id";
    public static final String O0000OoO = "user_id";
    public static final String O0000Ooo = "command";
    public static final String O0000o = "is_cloud";
    public static final String O0000o0 = "request_type";
    public static final String O0000o00 = "request_id";
    public static final String O0000o0O = "gw_id";
    public static final String O0000o0o = "type";
    public static final String O0000oO = "success";
    public static final String O0000oO0 = "0";
    public static final String O0000oOO = "device";
    public static final String O0000oOo = "group";

    public static String O000000o() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void O000000o(String str, Map<String, String> map) {
        if (TuyaSmartSdk.DEBUG) {
            map.put(O0000OoO, O00000Oo());
            o0oo0o0ooo o0oo0o0ooo = (o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class);
            if (o0oo0o0ooo != null) {
                o0oo0o0ooo.O00000Oo(str, map);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.O000000o().getUser();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String O00000Oo() {
        /*
            java.lang.Class<com.tuya.smart.common.o0o00oo0oo> r0 = com.tuya.smart.common.o0o00oo0oo.class
            java.lang.Object r0 = com.tuya.smart.common.Oo0.O000000o(r0)
            com.tuya.smart.common.o0o00oo0oo r0 = (com.tuya.smart.common.o0o00oo0oo) r0
            if (r0 == 0) goto L_0x0019
            com.tuya.smart.sdk.api.ITuyaUser r0 = r0.O000000o()
            com.tuya.smart.android.user.bean.User r0 = r0.getUser()
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getUid()
            goto L_0x001b
        L_0x0019:
            java.lang.String r0 = ""
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oOO0O0O0.O00000Oo():java.lang.String");
    }
}

package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.smart.android.common.utils.TuyaUtil;

public class o000o0o0o {
    public static final int O000000o = 6666;
    public static final int O00000Oo = 6667;
    public static final int O00000o = 6669;
    public static final int O00000o0 = 6670;
    public static final int O00000oO = 7000;
    public static final int O00000oo = 6668;
    public static final int O0000O0o = 12;
    public static final int O0000OOo = 10000;
    public static final String O0000Oo = "tuya.intent.action.udp";
    public static final int O0000Oo0 = 30;
    public static final String O0000OoO = "tuya.intent.action.tcp";
    public static final float O0000Ooo = 3.2f;
    public static final String O0000o0 = "1.1";
    public static final float O0000o00 = 3.3f;

    public static boolean O000000o(String str) {
        return TuyaUtil.checkHgwVersion(str, 3.2f) || TextUtils.equals(str, "1.1");
    }
}

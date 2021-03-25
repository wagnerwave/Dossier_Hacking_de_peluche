package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.smart.android.common.utils.TuyaUtil;

public class o00oo00o0 {
    public static final float O000000o = 3.1f;
    public static final float O00000Oo = 3.2f;
    public static final float O00000o = 3.2f;
    public static final float O00000o0 = 1.1f;
    public static final String O00000oO = "1.1";
    public static final float O00000oo = 1.0f;
    public static final float O0000O0o = 3.3f;

    public static boolean O000000o(String str) {
        return TuyaUtil.checkHgwVersion(str, 3.2f) || TextUtils.equals(str, "1.1");
    }
}

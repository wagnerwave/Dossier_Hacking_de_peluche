package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.common.utils.L;
import java.util.Set;

public final class OO00o00 {
    public static final String O000000o = "ParseMeshUtils";

    public static DpsParseBean O000000o(String str, String str2) {
        return O00000Oo(str2).O000000o(str);
    }

    public static String O000000o(String str) {
        L.d(O000000o, "getDeviceMainVenderId " + str);
        return !TextUtils.isEmpty(str) ? str.split(",")[0] : "";
    }

    public static String O000000o(Set set, String str) {
        for (String str2 : str.split(",")) {
            if (O00000Oo(str2).O000000o(set)) {
                StringBuilder n = a.n("isContainDp：");
                n.append(set.toString());
                n.append(DpTimerBean.FILL);
                n.append(str);
                L.e(O000000o, n.toString());
                return str2;
            }
        }
        StringBuilder n2 = a.n("not ContainDp：");
        n2.append(set.toString());
        n2.append(DpTimerBean.FILL);
        n2.append(str);
        L.e(O000000o, n2.toString());
        return O000000o(str);
    }

    public static DpsParseBean O00000Oo(String str, String str2) {
        return O00000Oo(str2).O00000Oo(str);
    }

    public static OO000OO O00000Oo(String str) {
        return str.endsWith("01") ? new OO000o0() : str.endsWith("02") ? new OO0000o() : str.endsWith("04") ? new OO00O0() : str.endsWith("10") ? new ooO0Ooo() : str.endsWith("08") ? new OO0000() : new OO000o0();
    }

    public static Object O00000o0(String str, String str2) {
        return O00000Oo(str2).O00000oO(str);
    }
}

package com.tuya.smart.common;

import com.tuya.sdk.hardwareprotocol.bean.HRequest;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;

public class o00ooo00o implements o00o0oo00 {
    public static final String O000000o = "LocalControlManager";
    public final o00o0ooo0 O00000Oo;

    public o00ooo00o(o00o0ooo0 o00o0ooo0) {
        this.O00000Oo = o00o0ooo0;
    }

    public void O000000o(o00o0o0o0<HRequest> o00o0o0o0) {
        o00oo0o00 o00oo0o00;
        if (TuyaUtil.checkHgwVersion(this.O00000Oo.O00000o(), 3.2f)) {
            L.d(O000000o, "version_3_2");
            o00oo0o00 = new o00ooo000(this.O00000Oo);
        } else if (TuyaUtil.checkHgwVersion(this.O00000Oo.O00000o(), 3.1f)) {
            L.d(O000000o, "version_3_1");
            o00oo0o00 = new o00oo0ooo(this.O00000Oo);
        } else if (TuyaUtil.isHgwVersionEquals(this.O00000Oo.O00000o(), "1.1")) {
            L.d(O000000o, "version_1_1");
            o00oo0o00 = new o00oo0oo0(this.O00000Oo);
        } else {
            L.d(O000000o, "version_1_0");
            o00oo0o00 = new o00oo0o0o(this.O00000Oo);
        }
        o00oo0o00.O000000o(o00o0o0o0);
    }
}

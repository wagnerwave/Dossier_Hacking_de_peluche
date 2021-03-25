package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.hardwareprotocol.bean.HDpResponse;
import com.tuya.smart.android.common.utils.L;

public class o00oooo0o extends o00ooo0oo {
    public static final String O00000Oo = "LocalResp3_1";

    public o00oooo0o(o00oo0000 o00oo0000) {
        super(o00oo0000);
    }

    public void O000000o(o00o0o000 o00o0o000) {
        String str;
        super.O000000o(o00o0o000);
        String substring = new String(this.O000000o.O00000Oo()).substring(3);
        String substring2 = substring.substring(0, 16);
        String substring3 = substring.substring(16);
        HDpResponse O000000o = o0o000000.O000000o(substring3, this.O000000o.O00000o0());
        if (O000000o == null) {
            str = "hdpResponse == null";
        } else {
            StringBuilder n = a.n("S: ");
            n.append(O000000o.getS());
            L.d(O00000Oo, n.toString());
            if (O000000o.getS() != -1 && this.O000000o.O00000oO() != null && this.O000000o.O00000oO().O000000o(this.O000000o.O00000o(), O000000o.getS())) {
                str = "Data is Updated";
            } else if (substring2.equals(o0o000000.O000000o(this.O000000o.O000000o(), substring3, this.O000000o.O00000o0()))) {
                O000000o(O000000o);
                return;
            } else {
                L.d(O00000Oo, "The sign is invaild");
                return;
            }
        }
        L.d(O00000Oo, str);
    }
}

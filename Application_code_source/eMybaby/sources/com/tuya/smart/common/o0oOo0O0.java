package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.base.event.BaseEventSender;
import java.util.HashMap;

public class o0oOo0O0 extends BaseEventSender {
    public static final String O000000o = "GroupEventSender";

    public static void O000000o(long j, String str) {
        HashMap r = a.r("type", "group");
        r.put(oOO0O0O0.O0000Oo, String.valueOf(j));
        r.put(oOO0O0O0.O0000Ooo, str);
        oOO0O0O0.O000000o(oOO0O0O0.O00000oo, r);
        BaseEventSender.send(new o0O0o000(str, j));
    }
}

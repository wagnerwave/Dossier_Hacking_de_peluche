package com.tuya.smart.common;

import android.util.Log;
import com.tuya.smart.android.device.TuyaSmartLink;

public class o0o000oo00 implements o0o000o000 {
    public static final String O000000o = "TuyaEZConfig";
    public static volatile o0o000oo00 O00000Oo;

    public static o0o000oo00 O00000Oo() {
        if (O00000Oo == null) {
            synchronized (o0o000oo00.class) {
                O00000Oo = new o0o000oo00();
            }
        }
        return O00000Oo;
    }

    public void O000000o() {
        TuyaSmartLink.sendStatusStop();
    }

    public void O000000o(final String str, final String str2, final String str3) {
        new Thread(new Runnable() {
            public void run() {
                Log.d(o0o000oo00.O000000o, "startConfig");
                TuyaSmartLink.smartLink(str, str2, str3, 5, 2, 1000, 1, 1);
                Log.d(o0o000oo00.O000000o, "endConfig");
            }
        }).start();
    }
}

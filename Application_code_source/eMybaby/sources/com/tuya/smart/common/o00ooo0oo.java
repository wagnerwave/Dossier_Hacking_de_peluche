package com.tuya.smart.common;

import com.tuya.sdk.hardwareprotocol.bean.HDpResponse;

public class o00ooo0oo {
    public static final String O00000Oo = "LocalResp";
    public final o00oo0000 O000000o;
    public o00o0o000 O00000o0;

    public o00ooo0oo(o00oo0000 o00oo0000) {
        this.O000000o = o00oo0000;
    }

    public void O000000o(HDpResponse hDpResponse) {
        o00o0o000 o00o0o000 = this.O00000o0;
        if (o00o0o000 == null) {
            return;
        }
        if (hDpResponse == null) {
            o00o0o000.O000000o("result data is null", "result data is null");
        } else {
            o00o0o000.O000000o(hDpResponse);
        }
    }

    public void O000000o(o00o0o000 o00o0o000) {
        this.O00000o0 = o00o0o000;
    }
}

package com.tuya.smart.common;

import com.tuya.sdk.hardwareprotocol.bean.HRequest;
import com.tuya.smart.android.common.utils.L;

public class o00ooo0o0 implements o00o0o0oo {
    public static final String O000000o = "LocalControlNormal";
    public final o00o0oooo O00000Oo;

    public o00ooo0o0(o00o0oooo o00o0oooo) {
        this.O00000Oo = o00o0oooo;
    }

    private HRequest O000000o() {
        HRequest hRequest = new HRequest();
        hRequest.setDevId(this.O00000Oo.O00000Oo());
        hRequest.setType(this.O00000Oo.O000000o());
        hRequest.setData(this.O00000Oo.O00000o0());
        return hRequest;
    }

    public void O000000o(o00o0o0o0<HRequest> o00o0o0o0) {
        L.d(O000000o, "localControlNormal");
        if (o00o0o0o0 != null) {
            o00o0o0o0.O000000o(O000000o());
        }
    }
}

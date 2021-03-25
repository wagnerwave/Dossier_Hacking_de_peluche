package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.sdk.hardwareprotocol.bean.HDpResponse;
import java.lang.reflect.Type;

public class o00oooo00 extends o00ooo0oo {
    public o00oooo00(o00oo0000 o00oo0000) {
        super(o00oo0000);
    }

    public void O000000o(o00o0o000 o00o0o000) {
        super.O000000o(o00o0o000);
        HDpResponse hDpResponse = (HDpResponse) JSON.parseObject(this.O000000o.O00000Oo(), (Type) HDpResponse.class, new Feature[0]);
        if (hDpResponse == null) {
            hDpResponse = null;
        }
        O000000o(hDpResponse);
    }
}

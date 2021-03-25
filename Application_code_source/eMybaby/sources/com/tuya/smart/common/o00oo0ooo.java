package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.sdk.hardwareprotocol.bean.HRequest;
import com.tuya.smart.android.common.utils.ByteUtils;

public class o00oo0ooo extends o00oo0o00 {
    public o00oo0ooo(o00o0ooo0 o00o0ooo0) {
        super(o00o0ooo0);
    }

    public void O000000o(o00o0o0o0<HRequest> o00o0o0o0) {
        HRequest O00000Oo = o0o000000.O00000Oo(O000000o(), this.O00000Oo);
        String O000000o = o0o000000.O000000o(this.O00000o0, new String(O00000Oo.getData()), this.O00000Oo);
        if (!TextUtils.isEmpty(O000000o)) {
            O00000Oo.setData(ByteUtils.contact(this.O00000o0.getBytes(), O000000o.getBytes(), O00000Oo.getData()));
            if (o00o0o0o0 != null) {
                o00o0o0o0.O000000o(O00000Oo);
            }
        } else if (o00o0o0o0 != null) {
            o00o0o0o0.O000000o("11005", "SIGNTURE NOT EQUALS");
        }
    }
}

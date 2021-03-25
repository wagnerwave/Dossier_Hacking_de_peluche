package com.tuya.smart.common;

import com.tuya.smart.android.common.utils.ByteUtils;
import com.tuya.smart.android.common.utils.L;

public class oo00000oo extends o0ooooooo {
    public static final String O0000Oo = "mqtt_2_2";

    public oo00000oo(o0oooo0o0 o0oooo0o0) {
        super(o0oooo0o0);
    }

    public void O000000o(o0ooo0oo0 o0ooo0oo0) {
        byte[] O000000o = o0ooo0o00.O000000o(o0ooo0o00.O000000o(this.O0000O0o, this.O00000oO, this.O00000Oo), this.O00000o);
        if (O000000o == null) {
            L.e(O0000Oo, "control2_2 bytes == null");
            if (o0ooo0oo0 != null) {
                o0ooo0oo0.O000000o("11003", "aesBytes==null");
                return;
            }
            return;
        }
        byte[] contact = ByteUtils.contact(this.O00000o0.getBytes(), o0ooo00oo.O000000o(this.O0000Oo0, this.O0000OOo, O000000o), ByteUtils.intToBytes2(this.O0000Oo0), ByteUtils.intToBytes2(this.O0000OOo), O000000o);
        if (o0ooo0oo0 != null) {
            o0ooo0oo0.O000000o(contact);
        }
    }
}

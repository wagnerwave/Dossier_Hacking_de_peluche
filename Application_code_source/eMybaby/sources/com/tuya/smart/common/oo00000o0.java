package com.tuya.smart.common;

import android.text.TextUtils;

public class oo00000o0 extends o0ooooooo {
    public oo00000o0(o0oooo0o0 o0oooo0o0) {
        super(o0oooo0o0);
    }

    public void O000000o(o0ooo0oo0 o0ooo0oo0) {
        String O000000o = o0ooo0o00.O000000o(o0ooo0o00.O000000o(this.O0000O0o, this.O00000oO, this.O00000oo, this.O00000Oo), this.O00000o);
        if (!TextUtils.isEmpty(O000000o)) {
            String O000000o2 = o0ooo00oo.O000000o(this.O00000o0, O000000o, this.O00000o);
            if (O000000o2 == null) {
                if (o0ooo0oo0 != null) {
                    o0ooo0oo0.O000000o("11004", "sign==null");
                }
            } else if (o0ooo0oo0 != null) {
                o0ooo0oo0.O000000o((this.O00000o0 + O000000o2 + O000000o).getBytes());
            }
        } else if (o0ooo0oo0 != null) {
            o0ooo0oo0.O000000o("11003", "aesBytes==null");
        }
    }
}

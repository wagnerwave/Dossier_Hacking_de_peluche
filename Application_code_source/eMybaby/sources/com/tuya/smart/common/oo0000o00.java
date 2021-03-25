package com.tuya.smart.common;

import com.tuya.smart.android.common.utils.TuyaUtil;

public class oo0000o00 implements o0oooo000 {
    public final o0oooo0o0 O000000o;

    public oo0000o00(o0oooo0o0 o0oooo0o0) {
        this.O000000o = o0oooo0o0;
    }

    public void O000000o(o0ooo0oo0 o0ooo0oo0) {
        String O00000o0 = this.O000000o.O00000o0();
        if (TuyaUtil.checkPvVersion(O00000o0, 2.2f)) {
            new oo00000oo(this.O000000o).O000000o(o0ooo0oo0);
        } else if (TuyaUtil.checkPvVersion(O00000o0, 2.1f)) {
            new oo00000o0(this.O000000o).O000000o(o0ooo0oo0);
        } else if (TuyaUtil.checkPvVersion(O00000o0, 2.0f)) {
            new oo000000o(this.O000000o).O000000o(o0ooo0oo0);
        } else if (TuyaUtil.checkPvVersion(O00000o0, 1.1f)) {
            new oo0000000(this.O000000o).O000000o(o0ooo0oo0);
        }
    }
}

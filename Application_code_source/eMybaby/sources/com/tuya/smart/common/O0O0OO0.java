package com.tuya.smart.common;

import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;

public class O0O0OO0 {
    public static final String O000000o = "ResetMeshNameAndPassword";
    public O0O0O0o O00000Oo;

    public O0O0OO0(O0O0O0o o0O0O0o) {
        this.O00000Oo = o0O0O0o;
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, String str, String str2) {
        new o00o0ooo00(searchDeviceBean.getMacAdress(), o00ooo0000.O000000o(str, 16), o00ooo0000.O000000o(str2, 16), (byte[]) null, searchDeviceBean.getSessionKey(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(O0O0OO0.O000000o, "reset mesh Name onFailure");
                if (O0O0OO0.this.O00000Oo != null) {
                    O0O0OO0.this.O00000Oo.O000000o(searchDeviceBean, O00OOo.O0000OOo, str2);
                }
            }

            public void O00000Oo() {
                o00oo0oo00.O000000o(O0O0OO0.O000000o, "reset mesh Name Success");
                if (O0O0OO0.this.O00000Oo != null) {
                    O0O0OO0.this.O00000Oo.O000000o(searchDeviceBean);
                }
            }
        }).O000000o();
    }
}

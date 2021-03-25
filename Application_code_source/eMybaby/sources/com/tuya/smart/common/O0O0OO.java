package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;

public class O0O0OO {
    public static final String O000000o = "ConfigWifiInfo";
    public o00o0oooo0 O00000Oo;
    public O0O0OOO O00000o0;

    public O0O0OO(O0O0OOO o0o0ooo) {
        this.O00000o0 = o0o0ooo;
    }

    public void O000000o() {
        o00o0oooo0 o00o0oooo0 = this.O00000Oo;
        if (o00o0oooo0 != null) {
            o00o0oooo0.O00000o0();
        }
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str)) {
            o00oo0oo00.O00000Oo(O000000o, "wifi ssid is empty");
            O0O0OOO o0o0ooo = this.O00000o0;
            if (o0o0ooo != null) {
                o0o0ooo.O000000o(searchDeviceBean, O00OOo.O0000oO0, "wifi ssid is empty");
                return;
            }
            return;
        }
        o00oo0oo00.O000000o(O000000o, String.valueOf(searchDeviceBean.getVendorId()));
        o00o0oooo0 O00000oo = new o00oo000oo().O00000Oo(searchDeviceBean.getVendorId()).O000000o(searchDeviceBean.getMeshAddress()).O000000o(searchDeviceBean.getMacAdress()).O00000Oo(str).O00000o0(str2).O00000o(str3).O000000o(searchDeviceBean.getSessionKey()).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (O0O0OO.this.O00000o0 != null) {
                    O0O0OO.this.O00000o0.O000000o(searchDeviceBean, str, str2);
                }
            }

            public void O00000Oo() {
                if (O0O0OO.this.O00000o0 != null) {
                    O0O0OO.this.O00000o0.O000000o(searchDeviceBean, str3);
                }
            }
        }).O00000oo();
        this.O00000Oo = O00000oo;
        O00000oo.O000000o();
    }
}

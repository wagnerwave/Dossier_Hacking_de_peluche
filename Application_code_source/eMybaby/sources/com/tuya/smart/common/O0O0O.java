package com.tuya.smart.common;

import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.o00o0ooo0o;

public class O0O0O {
    public static final String O000000o = "ResetMeshDeviceAddress";
    public O0O00o O00000Oo;
    public o00o0ooo0o O00000o0;

    public O0O0O(O0O00o o0O00o) {
        this.O00000Oo = o0O00o;
    }

    public void O000000o() {
        o00o0ooo0o o00o0ooo0o = this.O00000o0;
        if (o00o0ooo0o != null) {
            o00o0ooo0o.O00000Oo();
        }
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, int i) {
        searchDeviceBean.setMeshAddress(i);
        o00o0ooo0o O00000o = new o00oo000o0().O000000o(searchDeviceBean.getMeshAddress()).O00000Oo(searchDeviceBean.getVendorId()).O000000o(searchDeviceBean.getSessionKey()).O000000o((o00o0ooo0o.O000000o) new o00o0ooo0o.O000000o() {
            public void O000000o() {
                o00oo0oo00.O000000o(O0O0O.O000000o, "reset mesh Address Success");
                O0O0O.this.O00000Oo.O000000o(searchDeviceBean);
            }

            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(O0O0O.O000000o, "reset mesh onError " + str + DpTimerBean.FILL + str2);
                O0O0O.this.O00000Oo.O000000o(searchDeviceBean, O00OOo.O00000oo, str2);
            }
        }).O000000o(searchDeviceBean.getMacAdress()).O00000o();
        this.O00000o0 = O00000o;
        O00000o.O000000o();
    }
}

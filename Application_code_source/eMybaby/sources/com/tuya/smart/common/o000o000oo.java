package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;

public class o000o000oo {
    public SearchDeviceBean O000000o;
    public o0000oo0o0 O00000Oo;
    public ooooo00o0 O00000o0 = new ooooo00o0() {
        public void O000000o(byte[] bArr) {
            if (bArr[1] == 1) {
                ProvisioningCapabilities O00000o = o00o0000oo.O00000o(bArr);
                if (o000o000oo.this.O00000Oo != null) {
                    o000o000oo o000o000oo = o000o000oo.this;
                    if (o000o000oo.O000000o != null) {
                        o000o000oo.O00000Oo.O000000o(o000o000oo.this.O000000o, O00000o);
                    }
                }
            }
        }
    };

    public o000o000oo(o0000oo0o0 o0000oo0o0) {
        this.O00000Oo = o0000oo0o0;
    }

    public ooooo00o0 O000000o() {
        return this.O00000o0;
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean) {
        this.O000000o = searchDeviceBean;
        new ooo00oooo(searchDeviceBean.getMacAdress(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (o000o000oo.this.O00000Oo != null) {
                    o0000oo0o0 O000000o2 = o000o000oo.this.O00000Oo;
                    SearchDeviceBean searchDeviceBean = searchDeviceBean;
                    O000000o2.O000000o(searchDeviceBean, O00OOo.O0000oOO, "invite fail " + str);
                }
            }

            public void O00000Oo() {
            }
        }).O000000o();
    }
}

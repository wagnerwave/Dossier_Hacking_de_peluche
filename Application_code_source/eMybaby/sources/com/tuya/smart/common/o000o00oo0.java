package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;

public class o000o00oo0 {
    public static final String O00000Oo = "ProvisioningSendDataState";
    public SigMeshSearchDeviceBean O000000o;
    public ooooo00o0 O00000o = new ooooo00o0() {
        public void O000000o(byte[] bArr) {
            byte b2 = bArr[1];
            if (b2 != 7) {
                if (b2 != 8) {
                    if (b2 != 9) {
                        return;
                    }
                } else if (o000o00oo0.this.O00000o0 != null) {
                    o000o00oo0.this.O000000o.setProvisionedMeshNode(new ProvisionedMeshNode(o000o00oo0.this.O000000o.getUnprovisionedMeshNode()));
                    o000o00oo0.this.O00000o0.O000000o(o000o00oo0.this.O000000o);
                    return;
                } else {
                    return;
                }
            }
            if (o000o00oo0.this.O00000o0 != null) {
                o000o00oo0.this.O00000o0.O000000o(o000o00oo0.this.O000000o, O00OOo.O00oOoOo, "provisioning fail");
            }
        }
    };
    public o0000ooo00 O00000o0;

    public o000o00oo0(o0000ooo00 o0000ooo00) {
        this.O00000o0 = o0000ooo00;
    }

    public ooooo00o0 O000000o() {
        return this.O00000o;
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean) {
        SigMeshSearchDeviceBean sigMeshSearchDeviceBean = (SigMeshSearchDeviceBean) searchDeviceBean;
        this.O000000o = sigMeshSearchDeviceBean;
        new ooo0o00o0(sigMeshSearchDeviceBean.getMacAdress(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (o000o00oo0.this.O00000o0 != null) {
                    o0000ooo00 O000000o2 = o000o00oo0.this.O00000o0;
                    SearchDeviceBean searchDeviceBean = searchDeviceBean;
                    O000000o2.O000000o(searchDeviceBean, O00OOo.O00oOoOo, "send data fail " + str);
                }
            }

            public void O00000Oo() {
            }
        }).O000000o(this.O000000o.getUnprovisionedMeshNode(), this.O000000o.getCapabilities());
    }
}

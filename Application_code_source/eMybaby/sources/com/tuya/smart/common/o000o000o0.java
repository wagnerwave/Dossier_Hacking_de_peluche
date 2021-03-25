package com.tuya.smart.common;

import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;

public class o000o000o0 {
    public SigMeshSearchDeviceBean O000000o;
    public o0000oo00o O00000Oo;
    public ooooo00o0 O00000o0 = new ooooo00o0() {
        public void O000000o(byte[] bArr) {
            if (bArr[1] == 5) {
                o000o000o0.this.O000000o(bArr);
                o000o000o0.this.O00000Oo.O000000o(o000o000o0.this.O000000o);
            }
        }
    };

    public o000o000o0(o0000oo00o o0000oo00o) {
        this.O00000Oo = o0000oo00o;
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length - 2);
        allocate.put(bArr, 2, allocate.limit());
        this.O000000o.getUnprovisionedMeshNode().setProvisioneeConfirmation(allocate.array());
    }

    public ooooo00o0 O000000o() {
        return this.O00000o0;
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean) {
        SigMeshSearchDeviceBean sigMeshSearchDeviceBean = (SigMeshSearchDeviceBean) searchDeviceBean;
        this.O000000o = sigMeshSearchDeviceBean;
        new ooo00ooo0(sigMeshSearchDeviceBean.getMacAdress(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (o000o000o0.this.O00000Oo != null) {
                    o0000oo00o O000000o2 = o000o000o0.this.O00000Oo;
                    SearchDeviceBean searchDeviceBean = searchDeviceBean;
                    O000000o2.O000000o(searchDeviceBean, O00OOo.O00oOooO, "send confirm fail " + str);
                }
            }

            public void O00000Oo() {
            }
        }).O000000o(this.O000000o.getUnprovisionedMeshNode(), this.O000000o.getCapabilities(), "");
    }
}

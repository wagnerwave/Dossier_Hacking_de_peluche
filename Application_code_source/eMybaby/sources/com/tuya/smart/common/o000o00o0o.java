package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class o000o00o0o {
    public static final String O00000Oo = "ProvisioningRandomConfirmState";
    public SigMeshSearchDeviceBean O000000o;
    public ooooo00o0 O00000o = new ooooo00o0() {
        public void O000000o(byte[] bArr) {
            if (bArr[1] == 6) {
                o000o00o0o.this.O000000o(bArr);
                if (!o000o00o0o.this.O00000Oo()) {
                    o000o00o0o.this.O00000o0.O000000o(o000o00o0o.this.O000000o, O00OOo.O000O00o, "Confirmation values not match");
                } else if (o000o00o0o.this.O00000o0 != null) {
                    o000o00o0o.this.O00000o0.O000000o(o000o00o0o.this.O000000o);
                }
            }
        }
    };
    public o0000oo0oo O00000o0;

    public o000o00o0o(o0000oo0oo o0000oo0oo) {
        this.O00000o0 = o0000oo0oo;
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length - 2);
        allocate.put(bArr, 2, allocate.limit());
        this.O000000o.getUnprovisionedMeshNode().setProvisioneeRandom(allocate.array());
    }

    /* access modifiers changed from: private */
    public boolean O00000Oo() {
        UnprovisionedMeshNode unprovisionedMeshNode = this.O000000o.getUnprovisionedMeshNode();
        byte[] provisioneeRandom = unprovisionedMeshNode.getProvisioneeRandom();
        byte[] O000000o2 = o00o0000oo.O000000o(unprovisionedMeshNode.getProvisionerPublicKeyXY(), unprovisionedMeshNode.getProvisioneePublicKeyXY(), this.O000000o.getCapabilities(), 5);
        StringBuilder n = a.n("Confirmation inputs: ");
        n.append(o00o0000oo.O000000o(O000000o2, false));
        o00oo0oo00.O000000o(O00000Oo, n.toString());
        byte[] O000000o3 = o00o00000o.O000000o(O000000o2);
        StringBuilder n2 = a.n("Confirmation salt: ");
        n2.append(o00o0000oo.O000000o(O000000o3, false));
        o00oo0oo00.O000000o(O00000Oo, n2.toString());
        byte[] O00000Oo2 = o00o00000o.O00000Oo(unprovisionedMeshNode.getSharedECDHSecret(), O000000o3, o00o00000o.O000000o);
        StringBuilder n3 = a.n("Confirmation key: ");
        n3.append(o00o0000oo.O000000o(O00000Oo2, false));
        o00oo0oo00.O000000o(O00000Oo, n3.toString());
        byte[] authenticationValue = unprovisionedMeshNode.getAuthenticationValue();
        a.y(authenticationValue, false, a.n("Authentication value: "), O00000Oo);
        ByteBuffer allocate = ByteBuffer.allocate(provisioneeRandom.length + authenticationValue.length);
        allocate.put(provisioneeRandom);
        allocate.put(authenticationValue);
        byte[] O000000o4 = o00o00000o.O000000o(allocate.array(), O00000Oo2);
        if (!Arrays.equals(O000000o4, unprovisionedMeshNode.getProvisioneeConfirmation())) {
            return false;
        }
        a.y(O000000o4, false, a.n("Confirmation values match!!!!: "), O00000Oo);
        return true;
    }

    public ooooo00o0 O000000o() {
        return this.O00000o;
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean) {
        SigMeshSearchDeviceBean sigMeshSearchDeviceBean = (SigMeshSearchDeviceBean) searchDeviceBean;
        this.O000000o = sigMeshSearchDeviceBean;
        new ooo0o000o(sigMeshSearchDeviceBean.getMacAdress(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (o000o00o0o.this.O00000o0 != null) {
                    o0000oo0oo O00000Oo2 = o000o00o0o.this.O00000o0;
                    SearchDeviceBean searchDeviceBean = searchDeviceBean;
                    O00000Oo2.O000000o(searchDeviceBean, O00OOo.O000O00o, "send random confirm fail " + str);
                }
            }

            public void O00000Oo() {
            }
        }).O000000o(this.O000000o.getUnprovisionedMeshNode());
    }
}

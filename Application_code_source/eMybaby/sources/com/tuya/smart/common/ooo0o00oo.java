package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;

public class ooo0o00oo extends ooo0oo000 {
    public static final String O000000o = "ProvisioningStartAction";
    public String O00000Oo;
    public o00o0o0o0o.O000000o O00000o0;

    public ooo0o00oo(String str, o00o0o0o0o.O000000o o000000o) {
        this.O00000Oo = str;
        this.O00000o0 = o000000o;
    }

    private byte[] O00000Oo(ProvisioningCapabilities provisioningCapabilities) {
        byte[] bArr = new byte[7];
        bArr[0] = 3;
        bArr[1] = 2;
        bArr[2] = o000oooo00.O00000Oo(provisioningCapabilities.getSupportedAlgorithm());
        bArr[3] = 0;
        short O00000o02 = (short) ((byte) o000ooo0oo.O00000o0(provisioningCapabilities.getOutputOOBAction()));
        if (O00000o02 == 0) {
            bArr[4] = 0;
            bArr[5] = 0;
            bArr[6] = 0;
        } else {
            bArr[4] = 2;
            bArr[5] = (byte) o000ooo0oo.O00000Oo(O00000o02);
            bArr[6] = (byte) provisioningCapabilities.getOutputOOBAction();
        }
        StringBuilder n = a.n("Provisioning start PDU: ");
        n.append(o00oo0o00o.O00000Oo(bArr, ":"));
        o00oo0oo00.O000000o(O000000o, n.toString());
        return bArr;
    }

    public void O000000o(ProvisioningCapabilities provisioningCapabilities) {
        O000000o(O000000o(this.O00000Oo, O00000Oo(provisioningCapabilities), CommandBean.CommandType.WRITE_NO_RESPONSE), oo0o0oooo.O000000o().O00000Oo(), this.O00000o0);
    }
}

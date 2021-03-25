package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ooo00ooo0 extends ooo0oo000 {
    public static final String O000000o = "ProvisioningConfirmAction";
    public String O00000Oo;
    public UnprovisionedMeshNode O00000o;
    public o00o0o0o0o.O000000o O00000o0;
    public ProvisioningCapabilities O00000oO;

    public ooo00ooo0(String str, o00o0o0o0o.O000000o o000000o) {
        this.O00000Oo = str;
        this.O00000o0 = o000000o;
    }

    private byte[] O000000o(byte[] bArr) {
        byte[] O000000o2 = o00o0000oo.O000000o(this.O00000o.getProvisionerPublicKeyXY(), this.O00000o.getProvisioneePublicKeyXY(), this.O00000oO, 5);
        StringBuilder n = a.n("Confirmation inputs: ");
        n.append(o00o0000oo.O000000o(O000000o2, false));
        o00oo0oo00.O000000o(O000000o, n.toString());
        byte[] O000000o3 = o00o00000o.O000000o(O000000o2);
        a.y(O000000o3, false, a.n("Confirmation salt: "), O000000o);
        byte[] O00000Oo2 = o00o00000o.O00000Oo(this.O00000o.getSharedECDHSecret(), O000000o3, o00o00000o.O000000o);
        StringBuilder n2 = a.n("Confirmation key: ");
        n2.append(o00o0000oo.O000000o(O00000Oo2, false));
        o00oo0oo00.O000000o(O000000o, n2.toString());
        byte[] O000000o4 = o00o00000o.O000000o();
        this.O00000o.setProvisionerRandom(O000000o4);
        StringBuilder sb = new StringBuilder();
        sb.append("Provisioner random: ");
        a.y(O000000o4, false, sb, O000000o);
        byte[] O00000Oo3 = O00000Oo(bArr);
        this.O00000o.setAuthenticationValue(O00000Oo3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Authentication value: ");
        a.y(O00000Oo3, false, sb2, O000000o);
        ByteBuffer allocate = ByteBuffer.allocate(O000000o4.length + O00000Oo3.length);
        allocate.put(O000000o4);
        allocate.put(O00000Oo3);
        byte[] O000000o5 = o00o00000o.O000000o(allocate.array(), O00000Oo2);
        ByteBuffer allocate2 = ByteBuffer.allocate(O000000o5.length + 2);
        allocate2.put(new byte[]{3, 5});
        allocate2.put(O000000o5);
        byte[] array = allocate2.array();
        a.y(array, false, a.n("Provisioning confirmation: "), O000000o);
        return array;
    }

    private byte[] O00000Oo(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        if (bArr != null) {
            Integer valueOf = Integer.valueOf(new String(bArr, Charset.forName("UTF-8")));
            allocate.position(12);
            allocate.putInt(valueOf.intValue());
        }
        return allocate.array();
    }

    public void O000000o(UnprovisionedMeshNode unprovisionedMeshNode, ProvisioningCapabilities provisioningCapabilities, String str) {
        this.O00000o = unprovisionedMeshNode;
        this.O00000oO = provisioningCapabilities;
        O000000o(O000000o(this.O00000Oo, !TextUtils.isEmpty(str) ? O000000o(str.getBytes()) : O000000o((byte[]) null), CommandBean.CommandType.WRITE_NO_RESPONSE), oo0o0oooo.O000000o().O00000Oo(), this.O00000o0);
    }
}

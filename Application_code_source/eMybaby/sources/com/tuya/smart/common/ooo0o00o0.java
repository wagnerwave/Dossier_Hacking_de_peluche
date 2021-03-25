package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;

public class ooo0o00o0 extends ooo0oo000 {
    public static final String O000000o = "ProvisioningSendDataAction";
    public String O00000Oo;
    public UnprovisionedMeshNode O00000o;
    public o00o0o0o0o.O000000o O00000o0;
    public ProvisioningCapabilities O00000oO;

    public ooo0o00o0(String str, o00o0o0o0o.O000000o o000000o) {
        this.O00000Oo = str;
        this.O00000o0 = o000000o;
    }

    private byte[] O000000o() {
        byte[] O00000Oo2 = O00000Oo();
        a.y(O00000Oo2, false, a.n("Provisioning salt: "), O000000o);
        byte[] sharedECDHSecret = this.O00000o.getSharedECDHSecret();
        byte[] O000000o2 = o00o00000o.O000000o(sharedECDHSecret, O00000Oo2);
        byte[] O000000o3 = o00o00000o.O000000o(o00o00000o.O00000Oo, O000000o2);
        a.y(O000000o3, false, a.n("Session key: "), O000000o);
        byte[] O000000o4 = O000000o(sharedECDHSecret, O00000Oo2);
        a.y(O000000o4, false, a.n("Session nonce: "), O000000o);
        byte[] O000000o5 = o00o00000o.O000000o(o00o00000o.O00000o, O000000o2);
        a.y(O000000o5, false, a.n("Device key: "), O000000o);
        this.O00000o.setDeviceKey(O000000o5);
        byte[] networkKey = this.O00000o.getNetworkKey();
        a.y(networkKey, false, a.n("Network key: "), O000000o);
        byte[] O000000o6 = o00o0000oo.O000000o(Integer.valueOf(this.O00000o.getKeyIndex()));
        a.y(O000000o6, false, a.n("Key index: "), O000000o);
        byte[] flags = this.O00000o.getFlags();
        a.y(flags, false, a.n("Flags: "), O000000o);
        byte[] ivIndex = this.O00000o.getIvIndex();
        a.y(ivIndex, false, a.n("IV index: "), O000000o);
        byte[] unicastAddress = this.O00000o.getUnicastAddress();
        a.y(unicastAddress, false, a.n("Unicast address: "), O000000o);
        ByteBuffer allocate = ByteBuffer.allocate(networkKey.length + O000000o6.length + flags.length + ivIndex.length + unicastAddress.length);
        allocate.put(networkKey);
        allocate.put(O000000o6);
        allocate.put(flags);
        allocate.put(ivIndex);
        allocate.put(unicastAddress);
        byte[] array = allocate.array();
        StringBuilder n = a.n("Provisioning data: ");
        n.append(o00o0000oo.O000000o(array, false));
        o00oo0oo00.O000000o(O000000o, n.toString());
        byte[] O000000o7 = o00o00000o.O000000o(array, O000000o3, O000000o4, 8);
        a.y(O000000o7, false, a.n("Encrypted provisioning data: "), O000000o);
        ByteBuffer allocate2 = ByteBuffer.allocate(O000000o7.length + 2);
        allocate2.put((byte) 3);
        allocate2.put((byte) 7);
        allocate2.put(O000000o7);
        byte[] array2 = allocate2.array();
        a.y(array2, false, a.n("Prov Data: "), O000000o);
        return array2;
    }

    private byte[] O000000o(byte[] bArr, byte[] bArr2) {
        byte[] O00000Oo2 = o00o00000o.O00000Oo(bArr, bArr2, o00o00000o.O00000o0);
        ByteBuffer allocate = ByteBuffer.allocate(O00000Oo2.length - 3);
        allocate.put(O00000Oo2, 3, allocate.limit());
        return allocate.array();
    }

    private byte[] O00000Oo() {
        byte[] O000000o2 = o00o00000o.O000000o(o00o0000oo.O000000o(this.O00000o.getProvisionerPublicKeyXY(), this.O00000o.getProvisioneePublicKeyXY(), this.O00000oO, 5));
        byte[] provisionerRandom = this.O00000o.getProvisionerRandom();
        byte[] provisioneeRandom = this.O00000o.getProvisioneeRandom();
        ByteBuffer allocate = ByteBuffer.allocate(O000000o2.length + provisionerRandom.length + provisioneeRandom.length);
        allocate.put(O000000o2);
        allocate.put(provisionerRandom);
        allocate.put(provisioneeRandom);
        return o00o00000o.O000000o(allocate.array());
    }

    public void O000000o(UnprovisionedMeshNode unprovisionedMeshNode, ProvisioningCapabilities provisioningCapabilities) {
        this.O00000o = unprovisionedMeshNode;
        this.O00000oO = provisioningCapabilities;
        O000000o(O000000o(this.O00000Oo, O000000o(), CommandBean.CommandType.WRITE_NO_RESPONSE), oo0o0oooo.O000000o().O00000Oo(), this.O00000o0);
    }
}

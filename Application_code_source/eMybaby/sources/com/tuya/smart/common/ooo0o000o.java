package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;

public class ooo0o000o extends ooo0oo000 {
    public static final String O000000o = "ProvisioningRandomConfirmAction";
    public String O00000Oo;
    public UnprovisionedMeshNode O00000o;
    public o00o0o0o0o.O000000o O00000o0;

    public ooo0o000o(String str, o00o0o0o0o.O000000o o000000o) {
        this.O00000Oo = str;
        this.O00000o0 = o000000o;
    }

    private byte[] O000000o() {
        byte[] provisionerRandom = this.O00000o.getProvisionerRandom();
        ByteBuffer allocate = ByteBuffer.allocate(provisionerRandom.length + 2);
        allocate.put(new byte[]{3, 6});
        allocate.put(provisionerRandom);
        byte[] array = allocate.array();
        a.y(array, false, a.n("Provisioner random PDU: "), O000000o);
        return array;
    }

    public void O000000o(UnprovisionedMeshNode unprovisionedMeshNode) {
        this.O00000o = unprovisionedMeshNode;
        O000000o(O000000o(this.O00000Oo, O000000o(), CommandBean.CommandType.WRITE_NO_RESPONSE), oo0o0oooo.O000000o().O00000Oo(), this.O00000o0);
    }
}

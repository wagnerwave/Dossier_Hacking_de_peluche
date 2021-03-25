package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.os.Handler;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import java.nio.ByteBuffer;

public final class o000oo0000 extends o000oo000o {
    public static final String O0000o = "o000oo0000";
    public static final int O0000oO0 = 0;

    public o000oo0000() {
    }

    public o000oo0000(Context context) {
        this.O000000o = context;
        O000000o();
    }

    public o000oo0000(Context context, ProvisionedMeshNode provisionedMeshNode) {
        this.O000000o = context;
        this.O00000o = provisionedMeshNode;
        O000000o();
    }

    public int O000000o(byte[] bArr) {
        return oo0o0oooo.O000000o().O0000Oo0();
    }

    public int O000000o(byte[] bArr, byte[] bArr2) {
        oo0o0oooo.O000000o().O00000o0(o00o0000oo.O0000OoO(bArr2));
        return oo0o0oooo.O000000o().O0000Oo0();
    }

    public AccessMessage O000000o(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, int i5, byte[] bArr4) {
        int O000000o = O000000o(bArr);
        byte[] O00000Oo = o00o0000oo.O00000Oo(O000000o);
        o00oo0oo00.O00000o(O0000o, "createVendorMeshMessage");
        String str = O0000o;
        StringBuilder n = a.n("Src address: ");
        n.append(o00o0000oo.O000000o(bArr, false));
        n.append("  Dst address: ");
        n.append(o00o0000oo.O000000o(bArr2, false));
        o00oo0oo00.O00000o(str, n.toString());
        String str2 = O0000o;
        StringBuilder n2 = a.n("Key: ");
        n2.append(o00o0000oo.O000000o(bArr3, false));
        n2.append("   akf: ");
        n2.append(i2);
        n2.append("  aid: ");
        n2.append(i3);
        n2.append("  aszmic: ");
        n2.append(i4);
        o00oo0oo00.O00000o(str2, n2.toString());
        String str3 = O0000o;
        o00oo0oo00.O00000o(str3, "Sequence number: " + O000000o);
        String str4 = O0000o;
        StringBuilder n3 = a.n("Access message opcode: ");
        n3.append(Integer.toHexString(i5));
        o00oo0oo00.O00000o(str4, n3.toString());
        String str5 = O0000o;
        StringBuilder n4 = a.n("Access vendor message parameters: ");
        n4.append(o00o0000oo.O000000o(bArr4, false));
        o00oo0oo00.O00000Oo(str5, n4.toString());
        AccessMessage accessMessage = new AccessMessage();
        accessMessage.setCompanyIdentifier(i);
        accessMessage.setSrc(bArr);
        accessMessage.setDst(bArr2);
        accessMessage.setIvIndex(O00000o0());
        accessMessage.setSequenceNumber(O00000Oo);
        accessMessage.setKey(bArr3);
        accessMessage.setAkf(i2);
        accessMessage.setAid(i3);
        accessMessage.setAszmic(i4);
        accessMessage.setOpCode(i5);
        accessMessage.setParameters(bArr4);
        accessMessage.setPduType(0);
        super.O00000Oo(accessMessage);
        return accessMessage;
    }

    public final AccessMessage O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, byte[] bArr4) {
        int O000000o = O000000o(bArr);
        byte[] O00000Oo = o00o0000oo.O00000Oo(O000000o);
        String str = O0000o;
        StringBuilder n = a.n("Src address: ");
        n.append(o00o0000oo.O000000o(bArr, false));
        n.append("  Dst address: ");
        n.append(o00o0000oo.O000000o(bArr2, false));
        o00oo0oo00.O00000o(str, n.toString());
        a.z(bArr3, false, a.n("Key: "), O0000o);
        String str2 = O0000o;
        o00oo0oo00.O00000o(str2, "akf: " + i + " aid: " + i2 + "  aszmic: " + i3 + "  Sequence number: " + O000000o);
        String str3 = O0000o;
        StringBuilder n2 = a.n("  Access message opcode: ");
        n2.append(Integer.toHexString(i4));
        n2.append("  Access message parameters: ");
        n2.append(o00o0000oo.O000000o(bArr4, false));
        o00oo0oo00.O00000o(str3, n2.toString());
        AccessMessage accessMessage = new AccessMessage();
        accessMessage.setSrc(bArr);
        accessMessage.setDst(bArr2);
        accessMessage.setIvIndex(O00000o0());
        accessMessage.setSequenceNumber(O00000Oo);
        accessMessage.setKey(bArr3);
        accessMessage.setAkf(i);
        accessMessage.setAid(i2);
        accessMessage.setAszmic(i3);
        accessMessage.setOpCode(i4);
        accessMessage.setParameters(bArr4);
        accessMessage.setPduType(0);
        super.O000000o((Message) accessMessage);
        return accessMessage;
    }

    public ControlMessage O000000o(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        int O000000o = O000000o(bArr);
        byte[] O00000Oo = o00o0000oo.O00000Oo(O000000o);
        a.z(bArr, false, a.n("Src address: "), O0000o);
        a.z(bArr2, false, a.n("Dst address: "), O0000o);
        String str = O0000o;
        o00oo0oo00.O00000o(str, "Sequence number: " + O000000o);
        String str2 = O0000o;
        StringBuilder n = a.n("Control message opcode: ");
        n.append(Integer.toHexString(i));
        o00oo0oo00.O00000o(str2, n.toString());
        String str3 = O0000o;
        StringBuilder n2 = a.n("Control message parameters: ");
        n2.append(o00o0000oo.O000000o(bArr3, false));
        o00oo0oo00.O00000o(str3, n2.toString());
        ControlMessage controlMessage = new ControlMessage();
        controlMessage.setSrc(bArr);
        controlMessage.setDst(bArr2);
        controlMessage.setTtl(0);
        controlMessage.setIvIndex(O00000o0());
        controlMessage.setSequenceNumber(O00000Oo);
        controlMessage.setOpCode(i);
        controlMessage.setParameters(bArr3);
        controlMessage.setPduType(2);
        super.O000000o((Message) controlMessage);
        return controlMessage;
    }

    public final Message O000000o(Message message, int i) {
        return O00000Oo(message, i);
    }

    public final void O000000o() {
        this.O00000o0 = new Handler(this.O000000o.getMainLooper());
    }

    public final Message O00000o(byte[] bArr) {
        return O00000oO(bArr);
    }

    public final ControlMessage O00000o0(ControlMessage controlMessage) {
        O000000o(controlMessage);
        O00000o0(controlMessage);
        return controlMessage;
    }

    public byte[] O00000o0() {
        byte[] bArr = this.O00000oo;
        return bArr != null ? bArr : ByteBuffer.allocate(4).putInt(0).array();
    }
}

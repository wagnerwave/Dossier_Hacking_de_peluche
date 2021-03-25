package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class o000o0o00o {
    public static final String O00000oo = "o000o0o00o";
    public Context O000000o;
    public int O00000Oo;
    public ProvisionedMeshNode O00000o;
    public Handler O00000o0;
    public o000oo00o0 O00000oO;

    public abstract void O000000o();

    public final void O000000o(AccessMessage accessMessage) {
        ByteBuffer byteBuffer;
        byte[] O000000o2 = o00o0000oo.O000000o(accessMessage.getOpCode());
        byte[] parameters = accessMessage.getParameters();
        if (parameters != null) {
            byteBuffer = ByteBuffer.allocate(O000000o2.length + parameters.length);
            byteBuffer.put(O000000o2).put(parameters);
        } else {
            byteBuffer = ByteBuffer.allocate(O000000o2.length);
            byteBuffer.put(O000000o2);
        }
        byte[] array = byteBuffer.array();
        String str = O00000oo;
        StringBuilder n = a.n("Created Access PDU ");
        n.append(o00o0000oo.O000000o(array, false));
        Log.v(str, n.toString());
        accessMessage.setAccessPdu(byteBuffer.array());
    }

    public void O000000o(Message message) {
        O000000o((AccessMessage) message);
    }

    public void O000000o(o000oo00o0 o000oo00o0) {
        this.O00000oO = o000oo00o0;
    }

    public final void O00000Oo(AccessMessage accessMessage) {
        ByteBuffer byteBuffer;
        int opCode = accessMessage.getOpCode();
        int companyIdentifier = accessMessage.getCompanyIdentifier();
        byte[] parameters = accessMessage.getParameters();
        byte[] O000000o2 = o00o0000oo.O000000o(opCode, companyIdentifier);
        a.y(O000000o2, false, a.n("opCodesCompanyIdentifier:"), O00000oo);
        int length = O000000o2.length;
        if (parameters != null) {
            byteBuffer = ByteBuffer.allocate(length + parameters.length);
            byteBuffer.put(O000000o2);
            byteBuffer.put(parameters);
        } else {
            byteBuffer = ByteBuffer.allocate(length);
            byteBuffer.put(O000000o2);
        }
        byte[] array = byteBuffer.array();
        String str = O00000oo;
        StringBuilder n = a.n("Created Access PDU ");
        n.append(o00o0000oo.O000000o(array, false));
        o00oo0oo00.O00000o(str, n.toString());
        accessMessage.setAccessPdu(array);
    }

    public void O00000Oo(Message message) {
        O00000Oo((AccessMessage) message);
    }

    public final void O00000o0(AccessMessage accessMessage) {
        byte[] accessPdu = accessMessage.getAccessPdu();
        int i = (accessPdu[0] & 240) >> 6;
        if (i == 0) {
            i = 1;
        }
        String str = O00000oo;
        Log.v(str, "Opcode length: " + i + " Octets");
        accessMessage.setOpCode(o00o0000oo.O000000o(accessPdu, i));
        int length = accessPdu.length - i;
        ByteBuffer order = ByteBuffer.allocate(length).order(ByteOrder.BIG_ENDIAN);
        order.put(accessPdu, i, length);
        accessMessage.setParameters(order.array());
        String str2 = O00000oo;
        StringBuilder n = a.n("Received Access PDU ");
        n.append(o00o0000oo.O000000o(accessPdu, false));
        Log.v(str2, n.toString());
    }
}

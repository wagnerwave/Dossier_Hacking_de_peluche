package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException;
import com.tuya.spongycastle.crypto.InvalidCipherTextException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class o000oo00oo extends o000o0o00o {
    public static final int O00000oo = 0;
    public static final int O0000O0o = 15;
    public static final int O0000OOo = 1;
    public static final int O0000Oo = 11;
    public static final int O0000Oo0 = 12;
    public static final int O0000OoO = 8;
    public static final int O0000Ooo = 0;
    public static final int O0000o = 1;
    public static final int O0000o0 = 0;
    public static final int O0000o00 = 3;
    public static final int O0000o0O = 0;
    public static final int O0000oO = 0;
    public static final int O0000oO0 = 2;
    public static final String O0000oOO = "o000oo00oo";
    public static final int O0000oOo = 1;
    public static final int O0000oo = 4;
    public static final int O0000oo0 = 8191;
    public static final int O0000ooO = 4;
    public static final int O0000ooo = 8;
    public byte[] O0000o0o;

    private byte[] O000000o(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        ByteBuffer allocate = ByteBuffer.allocate(13);
        allocate.put((byte) 1);
        allocate.put((byte) ((i << 7) | 0));
        allocate.put(bArr);
        allocate.put(bArr2);
        allocate.put(bArr3);
        allocate.put(bArr4);
        return allocate.array();
    }

    private byte[] O00000Oo(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        ByteBuffer allocate = ByteBuffer.allocate(13);
        allocate.put((byte) 2);
        allocate.put((byte) ((i << 7) | 0));
        allocate.put(bArr);
        allocate.put(bArr2);
        allocate.put(bArr3);
        allocate.put(bArr4);
        return allocate.array();
    }

    private byte[] O00000oo(AccessMessage accessMessage) {
        String str;
        StringBuilder sb;
        String str2;
        byte[] bArr;
        byte[] accessPdu = accessMessage.getAccessPdu();
        int akf = accessMessage.getAkf();
        int aszmic = accessMessage.getAszmic();
        byte[] sequenceNumber = accessMessage.getSequenceNumber();
        byte[] src = accessMessage.getSrc();
        byte[] dst = accessMessage.getDst();
        byte[] ivIndex = accessMessage.getIvIndex();
        byte[] key = accessMessage.getKey();
        if (akf == 0) {
            bArr = O00000Oo(aszmic, sequenceNumber, src, dst, ivIndex);
            str2 = O0000oOO;
            sb = a.n("Device nonce: ");
            str = o00o0000oo.O000000o(bArr, false);
        } else {
            bArr = O000000o(aszmic, sequenceNumber, src, dst, ivIndex);
            str2 = O0000oOO;
            sb = a.n("Application nonce: ");
            str = o00o0000oo.O000000o(bArr, false);
        }
        sb.append(str);
        Log.v(str2, sb.toString());
        return o00o00000o.O000000o(accessPdu, key, bArr, o00o00000o.O00000o0(accessPdu.length + 4 <= 15 ? accessMessage.getCtl() : accessMessage.getAszmic()));
    }

    private byte[] O0000O0o(AccessMessage accessMessage) {
        byte[] bArr;
        byte[] bArr2;
        if (accessMessage.getAkf() == 0) {
            bArr2 = this.O00000oO.O000000o(accessMessage.getSrc());
            if (bArr2 == null || bArr2.length == 0) {
                o00oo0oo00.O00000Oo(O0000oOO, "device key is empty");
                throw new IllegalArgumentException("device key is empty");
            }
            bArr = O00000Oo(accessMessage.getAszmic(), accessMessage.getSequenceNumber(), accessMessage.getSrc(), accessMessage.getDst(), accessMessage.getIvIndex());
        } else {
            bArr2 = this.O0000o0o;
            if (bArr2 == null) {
                throw new IllegalArgumentException("Unable to find the app key to decrypt the message");
            } else if (o00o00000o.O00000o0(bArr2) == accessMessage.getAid()) {
                bArr = O000000o(accessMessage.getAszmic(), accessMessage.getSequenceNumber(), accessMessage.getSrc(), accessMessage.getDst(), accessMessage.getIvIndex());
            } else {
                throw new IllegalArgumentException("Unable to decrypt the message, invalid application key identifier");
            }
        }
        int aszmic = accessMessage.getAszmic();
        byte[] upperTransportPdu = accessMessage.getUpperTransportPdu();
        byte[] O00000Oo = aszmic == 1 ? o00o00000o.O00000Oo(upperTransportPdu, bArr2, bArr, 8) : o00o00000o.O00000Oo(upperTransportPdu, bArr2, bArr, 4);
        ByteBuffer wrap = ByteBuffer.wrap(new byte[O00000Oo.length]);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        wrap.put(O00000Oo);
        return wrap.array();
    }

    public final int O000000o(int i, int i2) {
        int i3 = i & 8191;
        return i3 < i2 ? (i - (i3 - i2)) - 8192 : i - (i3 - i2);
    }

    public abstract void O000000o(ControlMessage controlMessage);

    public void O000000o(Message message) {
        if (message instanceof AccessMessage) {
            super.O000000o(message);
            AccessMessage accessMessage = (AccessMessage) message;
            byte[] O00000oo2 = O00000oo(accessMessage);
            String str = O0000oOO;
            StringBuilder n = a.n("Encrypted upper transport pdu: ");
            n.append(o00o0000oo.O000000o(O00000oo2, false));
            Log.v(str, n.toString());
            accessMessage.setUpperTransportPdu(O00000oo2);
            return;
        }
        O00000o(message);
    }

    public abstract void O00000Oo(ControlMessage controlMessage);

    public void O00000Oo(Message message) {
        super.O00000Oo(message);
        AccessMessage accessMessage = (AccessMessage) message;
        byte[] O00000oo2 = O00000oo(accessMessage);
        String str = O0000oOO;
        StringBuilder n = a.n("Encrypted upper transport pdu: ");
        n.append(o00o0000oo.O000000o(O00000oo2, false));
        Log.v(str, n.toString());
        accessMessage.setUpperTransportPdu(O00000oo2);
    }

    public abstract void O00000o(AccessMessage accessMessage);

    public void O00000o(Message message) {
        ByteBuffer byteBuffer;
        if (message instanceof AccessMessage) {
            AccessMessage accessMessage = (AccessMessage) message;
            byte[] O00000oo2 = O00000oo(accessMessage);
            String str = O0000oOO;
            StringBuilder n = a.n("Encrypted upper transport pdu: ");
            n.append(o00o0000oo.O000000o(O00000oo2, false));
            Log.v(str, n.toString());
            accessMessage.setUpperTransportPdu(O00000oo2);
            return;
        }
        ControlMessage controlMessage = (ControlMessage) message;
        int opCode = controlMessage.getOpCode();
        byte[] parameters = controlMessage.getParameters();
        if (parameters != null) {
            byteBuffer = ByteBuffer.allocate(parameters.length + 1).order(ByteOrder.BIG_ENDIAN).put((byte) opCode).put(parameters);
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(1);
            allocate.put((byte) opCode);
            byteBuffer = allocate;
        }
        byte[] array = byteBuffer.array();
        String str2 = O0000oOO;
        StringBuilder n2 = a.n("Created Transport Control PDU ");
        n2.append(o00o0000oo.O000000o(array, false));
        Log.v(str2, n2.toString());
        controlMessage.setTransportControlPdu(array);
    }

    public abstract byte[] O00000o0();

    public abstract void O00000oO(AccessMessage accessMessage);

    public final void O00000oO(Message message) {
        try {
            int pduType = message.getPduType();
            if (pduType != 0) {
                if (pduType == 2) {
                    ControlMessage controlMessage = (ControlMessage) message;
                    if (controlMessage.getLowerTransportControlPdu().size() == 1) {
                        ByteBuffer order = ByteBuffer.wrap(controlMessage.getLowerTransportControlPdu().get(0)).order(ByteOrder.BIG_ENDIAN);
                        message.setOpCode(order.get());
                        byte[] bArr = new byte[(order.capacity() - 1)];
                        order.get(bArr);
                        message.setParameters(bArr);
                    }
                }
            } else if (message.getCtl() == 0) {
                AccessMessage accessMessage = (AccessMessage) message;
                O00000oO(accessMessage);
                accessMessage.setAccessPdu(O0000O0o(accessMessage));
            }
        } catch (InvalidCipherTextException e2) {
            throw new ExtendedInvalidCipherTextException(e2.getMessage(), e2.getCause(), O0000oOO);
        }
    }

    public void O00000oo(byte[] bArr) {
        this.O0000o0o = bArr;
    }
}

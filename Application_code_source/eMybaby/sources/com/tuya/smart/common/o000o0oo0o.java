package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.SparseArray;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class o000o0oo0o extends o000oo00oo {
    public static final String O00000oo = "o000o0oo0o";
    public static final int O0000O0o = 0;
    public static final int O0000o = 1;
    public static final int O0000oO = 4;
    public static final int O0000oO0 = 1;
    public static final int O0000oOO = 3;
    public static final long O0000oOo = 10000;
    public final SparseArray<byte[]> O0000oo = new SparseArray<>();
    public final SparseArray<byte[]> O0000oo0 = new SparseArray<>();
    public boolean O0000ooO;
    public Integer O0000ooo;
    public boolean O000O00o;
    public boolean O000O0OO;
    public long O000O0Oo;
    public Runnable O00oOoOo = new Runnable() {
        public void run() {
            boolean unused = o000o0oo0o.this.O000O00o = false;
        }
    };
    public boolean O00oOooO;
    public Integer O00oOooo;

    private void O000000o(int i, int i2, int i3, byte[] bArr, byte[] bArr2, int i4) {
        if (oooo0o0oo.O00000Oo(Integer.valueOf(i), i4)) {
            o00oo0oo00.O00000o(O00000oo, "All segments received cancelling incomplete timer");
            O00000oo();
        }
        byte[] O00000Oo = O00000Oo(i2, i);
        String str = O00000oo;
        StringBuilder n = a.n("Block acknowledgement payload: ");
        n.append(o00o0000oo.O000000o(O00000Oo, false));
        o00oo0oo00.O00000o(str, n.toString());
        ControlMessage controlMessage = new ControlMessage();
        controlMessage.setOpCode(0);
        controlMessage.setTransportControlPdu(O00000Oo);
        controlMessage.setTtl(i3);
        controlMessage.setPduType(0);
        controlMessage.setSrc(bArr);
        controlMessage.setDst(bArr2);
        controlMessage.setIvIndex(oo0o0oooo.O000000o().O00000oo());
        controlMessage.setSequenceNumber(o00o0000oo.O00000Oo(O000000o(controlMessage.getSrc())));
        this.O000O0OO = true;
        this.O0000ooO = false;
    }

    private void O000000o(int i, int i2, byte[] bArr, byte[] bArr2, int i3) {
        O00000oo();
        O00000o(i, i2, bArr, bArr2, i3);
    }

    private byte[] O000000o(byte[] bArr, int i, int i2) {
        ByteBuffer order = ByteBuffer.allocate(i2).order(ByteOrder.BIG_ENDIAN);
        order.put(bArr, i, i2);
        return order.array();
    }

    private void O00000Oo(int i, int i2, byte[] bArr, byte[] bArr2, int i3) {
        if (!this.O0000ooO) {
            this.O0000ooO = true;
            long j = (long) ((i2 * 50) + 150);
            this.O000O0Oo = System.currentTimeMillis() + j;
            final int i4 = i;
            final int i5 = i2;
            final byte[] bArr3 = bArr;
            final byte[] bArr4 = bArr2;
            final int i6 = i3;
            this.O00000o0.postDelayed(new Runnable() {
                public void run() {
                    o00oo0oo00.O00000o(o000o0oo0o.O00000oo, "Acknowledgement timer expiring");
                    o000o0oo0o.this.O00000o(i4, i5, bArr3, bArr4, i6);
                }
            }, j);
        }
    }

    private byte[] O00000Oo(int i, int i2) {
        ByteBuffer order = ByteBuffer.allocate(6).order(ByteOrder.BIG_ENDIAN);
        order.put((byte) (((i >> 6) & 127) | 0));
        order.put((byte) (((i << 2) & 252) | 0));
        order.putInt(i2);
        return order.array();
    }

    private void O00000o() {
        this.O00000o0.postDelayed(this.O00oOoOo, 10000);
        this.O000O00o = true;
    }

    /* access modifiers changed from: private */
    public void O00000o(int i, int i2, byte[] bArr, byte[] bArr2, int i3) {
        Integer num = this.O0000ooo;
        if (num != null) {
            int intValue = num.intValue();
            this.O0000ooo = null;
            if (oooo0o0oo.O00000Oo(Integer.valueOf(intValue), i3)) {
                o00oo0oo00.O00000o(O00000oo, "All segments received cancelling incomplete timer");
                O00000oo();
            }
            byte[] O00000Oo = O00000Oo(i, intValue);
            String str = O00000oo;
            StringBuilder n = a.n("Block acknowledgement payload: ");
            n.append(o00o0000oo.O000000o(O00000Oo, false));
            o00oo0oo00.O00000o(str, n.toString());
            ControlMessage controlMessage = new ControlMessage();
            controlMessage.setOpCode(0);
            controlMessage.setTransportControlPdu(O00000Oo);
            controlMessage.setTtl(i2);
            controlMessage.setPduType(0);
            controlMessage.setSrc(bArr);
            controlMessage.setDst(bArr2);
            controlMessage.setIvIndex(oo0o0oooo.O000000o().O00000oo());
            controlMessage.setSequenceNumber(o00o0000oo.O00000Oo(O000000o(controlMessage.getSrc())));
            this.O000O0OO = true;
            this.O00000oO.O000000o(controlMessage);
            this.O0000ooO = false;
        }
    }

    private void O00000o(ControlMessage controlMessage) {
        ByteBuffer byteBuffer;
        controlMessage.setSegmented(false);
        int opCode = controlMessage.getOpCode();
        byte[] parameters = controlMessage.getParameters();
        byte[] transportControlPdu = controlMessage.getTransportControlPdu();
        byte b2 = (byte) (opCode | 0);
        if (parameters != null) {
            byteBuffer = ByteBuffer.allocate(parameters.length + 1 + transportControlPdu.length).order(ByteOrder.BIG_ENDIAN);
            byteBuffer.put((byte) b2);
            byteBuffer.put(parameters);
        } else {
            byteBuffer = ByteBuffer.allocate(transportControlPdu.length + 1).order(ByteOrder.BIG_ENDIAN);
            byteBuffer.put((byte) b2);
        }
        byteBuffer.put(transportControlPdu);
        byte[] array = byteBuffer.array();
        String str = O00000oo;
        StringBuilder n = a.n("Unsegmented Lower transport control PDU ");
        n.append(o00o0000oo.O000000o(array, false));
        o00oo0oo00.O00000o(str, n.toString());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, array);
        controlMessage.setLowerTransportControlPdu(sparseArray);
    }

    private SparseArray<byte[]> O00000o0(ControlMessage controlMessage) {
        SparseArray<byte[]> lowerTransportControlPdu = controlMessage.getLowerTransportControlPdu();
        if (lowerTransportControlPdu.size() > 1) {
            for (int i = 0; i < lowerTransportControlPdu.size(); i++) {
                byte[] bArr = lowerTransportControlPdu.get(i);
                lowerTransportControlPdu.put(i, O000000o(bArr, 4, bArr.length - 4));
            }
        } else if (controlMessage.getOpCode() != 0) {
            byte[] bArr2 = lowerTransportControlPdu.get(0);
            lowerTransportControlPdu.put(0, O000000o(bArr2, 1, bArr2.length - 1));
        } else {
            byte[] bArr3 = lowerTransportControlPdu.get(0);
            lowerTransportControlPdu.put(0, O000000o(bArr3, 3, bArr3.length - 3));
        }
        return lowerTransportControlPdu;
    }

    private void O00000o0(int i, int i2, byte[] bArr, byte[] bArr2, int i3) {
        if (!this.O00oOooO) {
            this.O00oOooO = true;
            long j = (long) ((i2 * 50) + 150);
            this.O000O0Oo = System.currentTimeMillis() + j;
            final int i4 = i;
            final int i5 = i2;
            final byte[] bArr3 = bArr;
            final byte[] bArr4 = bArr2;
            final int i6 = i3;
            this.O00000o0.postDelayed(new Runnable() {
                public void run() {
                    o000o0oo0o.this.O00000o(i4, i5, bArr3, bArr4, i6);
                }
            }, j);
        }
    }

    private void O00000oO() {
        if (this.O000O00o) {
            this.O00000o0.removeCallbacks(this.O00oOoOo);
        }
        O00000o();
    }

    private void O00000oO(ControlMessage controlMessage) {
        controlMessage.setSegmented(false);
        byte[] transportControlPdu = controlMessage.getTransportControlPdu();
        int opCode = controlMessage.getOpCode();
        int O0000O0o2 = o00o0000oo.O0000O0o(controlMessage.getSequenceNumber());
        int length = (transportControlPdu.length + 7) / 8;
        int i = length - 1;
        SparseArray sparseArray = new SparseArray();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int min = Math.min(transportControlPdu.length - i2, 8);
            ByteBuffer order = ByteBuffer.allocate(min + 4).order(ByteOrder.BIG_ENDIAN);
            order.put((byte) (opCode | 128));
            order.put((byte) (((O0000O0o2 >> 6) & 127) | 0));
            order.put((byte) (((O0000O0o2 << 2) & 252) | ((i3 >> 3) & 3)));
            order.put((byte) (((i3 << 5) & 224) | (i & 31)));
            order.put(transportControlPdu, i2, min);
            i2 += min;
            byte[] array = order.array();
            String str = O00000oo;
            StringBuilder n = a.n("Segmented Lower transport access PDU: ");
            n.append(o00o0000oo.O000000o(array, false));
            n.append(" ");
            n.append(i3);
            n.append(" of ");
            n.append(length);
            o00oo0oo00.O00000o(str, n.toString());
            sparseArray.put(i3, array);
        }
        controlMessage.setLowerTransportControlPdu(sparseArray);
    }

    private SparseArray<byte[]> O00000oo(AccessMessage accessMessage) {
        SparseArray<byte[]> lowerTransportAccessPdu = accessMessage.getLowerTransportAccessPdu();
        if (accessMessage.isSegmented()) {
            for (int i = 0; i < lowerTransportAccessPdu.size(); i++) {
                byte[] bArr = lowerTransportAccessPdu.get(i);
                lowerTransportAccessPdu.put(i, O000000o(bArr, 4, bArr.length - 4));
            }
        } else {
            byte[] bArr2 = lowerTransportAccessPdu.get(0);
            lowerTransportAccessPdu.put(0, O000000o(bArr2, 1, bArr2.length - 1));
        }
        return lowerTransportAccessPdu;
    }

    private void O00000oo() {
        this.O000O00o = false;
        this.O00000o0.removeCallbacks(this.O00oOoOo);
    }

    private void O00000oo(ControlMessage controlMessage) {
        O00000Oo(controlMessage);
        byte[] transportControlPdu = controlMessage.getTransportControlPdu();
        if (controlMessage.getOpCode() == 0) {
            controlMessage.setTransportControlMessage(new oooo0o0oo(transportControlPdu));
        }
    }

    private byte[] O0000O0o(AccessMessage accessMessage) {
        byte[] upperTransportPdu = accessMessage.getUpperTransportPdu();
        boolean isSegmented = accessMessage.isSegmented();
        int aid = accessMessage.getAid();
        ByteBuffer order = ByteBuffer.allocate(upperTransportPdu.length + 1).order(ByteOrder.BIG_ENDIAN);
        order.put((byte) (aid | (accessMessage.getAkf() << 6) | ((isSegmented ? 1 : 0) << true)));
        order.put(upperTransportPdu);
        byte[] array = order.array();
        a.z(array, false, a.n("Unsegmented Lower transport access PDU "), O00000oo);
        return array;
    }

    private SparseArray<byte[]> O0000OOo(AccessMessage accessMessage) {
        byte[] upperTransportPdu = accessMessage.getUpperTransportPdu();
        int akf = (accessMessage.getAkf() << 6) | accessMessage.getAid();
        int aszmic = accessMessage.getAszmic();
        int O0000O0o2 = o00o0000oo.O0000O0o(accessMessage.getSequenceNumber());
        int length = (upperTransportPdu.length + 11) / 12;
        int i = length - 1;
        SparseArray<byte[]> sparseArray = new SparseArray<>();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int min = Math.min(upperTransportPdu.length - i2, 12);
            ByteBuffer order = ByteBuffer.allocate(min + 4).order(ByteOrder.BIG_ENDIAN);
            order.put((byte) (akf | 128));
            order.put((byte) ((aszmic << 7) | ((O0000O0o2 >> 6) & 127)));
            order.put((byte) (((O0000O0o2 << 2) & 252) | ((i3 >> 3) & 3)));
            order.put((byte) (((i3 << 5) & 224) | (i & 31)));
            order.put(upperTransportPdu, i2, min);
            i2 += min;
            byte[] array = order.array();
            String str = O00000oo;
            StringBuilder n = a.n("Segmented Lower transport access PDU: ");
            n.append(o00o0000oo.O000000o(array, false));
            n.append(" ");
            n.append(i3);
            n.append(" of ");
            n.append(length);
            o00oo0oo00.O00000o(str, n.toString());
            sparseArray.put(i3, array);
        }
        return sparseArray;
    }

    public abstract int O000000o(byte[] bArr);

    public abstract int O000000o(byte[] bArr, byte[] bArr2);

    public final void O000000o(AccessMessage accessMessage, byte[] bArr) {
        SparseArray sparseArray;
        byte b2 = bArr[10];
        int i = (b2 >> 7) & 1;
        int i2 = (b2 >> 6) & 1;
        byte b3 = b2 & 63;
        if (i == 0) {
            int length = bArr.length - 10;
            ByteBuffer order = ByteBuffer.allocate(length).order(ByteOrder.BIG_ENDIAN);
            order.put(bArr, 10, length);
            byte[] array = order.array();
            if (i2 == 0) {
                sparseArray.put(0, array);
            } else {
                sparseArray = new SparseArray();
                sparseArray.put(0, array);
            }
            accessMessage.setSegmented(false);
            accessMessage.setAszmic(0);
            accessMessage.setAkf(i2);
            accessMessage.setAid(b3);
            accessMessage.setLowerTransportAccessPdu(sparseArray);
        }
    }

    public final void O000000o(ControlMessage controlMessage) {
        int pduType = controlMessage.getPduType();
        if (pduType != 0) {
            if (pduType == 2) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(0, controlMessage.getTransportControlPdu());
                controlMessage.setLowerTransportControlPdu(sparseArray);
            }
        } else if (controlMessage.getTransportControlPdu().length <= 11) {
            o00oo0oo00.O00000o(O00000oo, "Creating unsegmented transport control");
            O00000o(controlMessage);
        } else {
            o00oo0oo00.O00000o(O00000oo, "Creating segmented transport control");
            O00000oO(controlMessage);
        }
    }

    public final void O000000o(ControlMessage controlMessage, byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        int length = bArr.length - 10;
        ByteBuffer order = ByteBuffer.allocate(length).order(ByteOrder.BIG_ENDIAN);
        order.put(bArr, 10, length);
        sparseArray.put(0, order.array());
        byte b2 = bArr[0];
        if (b2 == 0) {
            controlMessage.setPduType(0);
            controlMessage.setAszmic(0);
            controlMessage.setOpCode(bArr[10] & Byte.MAX_VALUE);
            controlMessage.setLowerTransportControlPdu(sparseArray);
            O00000oo(controlMessage);
        } else if (b2 == 2) {
            controlMessage.setPduType(2);
            controlMessage.setLowerTransportControlPdu(sparseArray);
            try {
                O00000oO((Message) controlMessage);
            } catch (ExtendedInvalidCipherTextException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void O000000o(Message message) {
        super.O000000o(message);
        if (message instanceof AccessMessage) {
            O00000o((AccessMessage) message);
        } else {
            O000000o((ControlMessage) message);
        }
    }

    public final boolean O000000o(byte b2) {
        return ((b2 >> 7) & 1) == 1;
    }

    public final AccessMessage O00000Oo(byte[] bArr) {
        byte b2 = bArr[10];
        int i = (b2 >> 6) & 1;
        byte b3 = b2 & 63;
        int i2 = (bArr[11] >> 7) & 1;
        int i3 = ((bArr[11] & Byte.MAX_VALUE) << 6) | ((bArr[12] & 252) >> 2);
        int i4 = ((bArr[12] & 3) << 3) | ((bArr[13] & 224) >> 5);
        byte b4 = bArr[13] & 31;
        byte b5 = bArr[2] & Byte.MAX_VALUE;
        byte[] O0000OOo = o00o0000oo.O0000OOo(bArr);
        byte[] O0000Oo0 = o00o0000oo.O0000Oo0(bArr);
        String str = O00000oo;
        o00oo0oo00.O00000o(str, "SEG O: " + i4);
        String str2 = O00000oo;
        o00oo0oo00.O00000o(str2, "SEG N: " + b4);
        int i5 = ByteBuffer.wrap(O00000o0()).order(ByteOrder.BIG_ENDIAN).getInt() | O000000o(o00o0000oo.O0000Oo(bArr), i3);
        Integer seqAuth = this.O00000o.getSeqAuth(O0000OOo);
        if (seqAuth != null) {
            String str3 = O00000oo;
            o00oo0oo00.O00000o(str3, "Last SeqAuth value " + seqAuth);
        }
        String str4 = O00000oo;
        o00oo0oo00.O00000o(str4, "Current SeqAuth value " + i5);
        int length = bArr.length - 10;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.put(bArr, 10, length);
        if (seqAuth == null || seqAuth.intValue() < i5) {
            this.O0000oo0.clear();
            this.O0000oo0.put(i4, allocate.array());
            this.O00000o.setSeqAuth(O0000OOo, i5);
            this.O0000ooo = oooo0o0oo.O000000o((Integer) null, i4);
            a.z(O0000OOo, false, a.n("Starting incomplete timer for src: "), O00000oo);
            O00000o();
            if (!o00o0000oo.O0000o00(O0000Oo0)) {
                return null;
            }
            O00000Oo(i3, b5, O0000Oo0, O0000OOo, b4);
            return null;
        } else if (seqAuth.intValue() != i5) {
            return null;
        } else {
            if (this.O000O00o) {
                this.O0000oo0.put(i4, allocate.array());
                int size = this.O0000oo0.size();
                String str5 = O00000oo;
                o00oo0oo00.O00000o(str5, "Received segment message count: " + size);
                if (size != b4 + 1) {
                    this.O0000ooo = oooo0o0oo.O000000o(this.O0000ooo, i4);
                    a.z(O0000OOo, false, a.n("Restarting incomplete timer for src: "), O00000oo);
                    O00000oO();
                    if (!o00o0000oo.O0000o00(O0000Oo0) || this.O0000ooO) {
                        return null;
                    }
                    a.z(O0000OOo, false, a.n("Restarting block acknowledgement timer for src: "), O00000oo);
                    O00000Oo(i3, b5, O0000Oo0, O0000OOo, b4);
                    return null;
                }
                this.O0000ooo = oooo0o0oo.O000000o(this.O0000ooo, i4);
                String str6 = O00000oo;
                StringBuilder n = a.n("SEG O BLOCK ACK VAL: ");
                n.append(this.O0000ooo);
                o00oo0oo00.O00000o(str6, n.toString());
                O000000o(i3, b5, O0000Oo0, O0000OOo, b4);
                byte[] O00000Oo = o00o0000oo.O00000Oo(O000000o(o00o0000oo.O0000Oo(bArr), i3));
                AccessMessage accessMessage = new AccessMessage();
                accessMessage.setAszmic(i2);
                accessMessage.setSequenceNumber(O00000Oo);
                accessMessage.setAkf(i);
                accessMessage.setAid(b3);
                accessMessage.setSegmented(true);
                accessMessage.setLowerTransportAccessPdu(this.O0000oo0.clone());
                return accessMessage;
            }
            o00oo0oo00.O00000o(O00000oo, "Ignoring message since the incomplete timer has expired and all messages have been received");
            return null;
        }
    }

    public final void O00000Oo(ControlMessage controlMessage) {
        controlMessage.setTransportControlPdu(o00o0000oo.O00000Oo(O00000o0(controlMessage)));
    }

    public void O00000Oo(Message message) {
        if (message instanceof AccessMessage) {
            super.O00000Oo(message);
            O00000o((AccessMessage) message);
            return;
        }
        O000000o((ControlMessage) message);
    }

    public final void O00000o(AccessMessage accessMessage) {
        SparseArray<byte[]> sparseArray;
        if (accessMessage.getUpperTransportPdu().length <= 12) {
            accessMessage.setSegmented(false);
            byte[] O0000O0o2 = O0000O0o(accessMessage);
            sparseArray = new SparseArray<>();
            sparseArray.put(0, O0000O0o2);
        } else {
            accessMessage.setSegmented(true);
            sparseArray = O0000OOo(accessMessage);
        }
        accessMessage.setLowerTransportAccessPdu(sparseArray);
    }

    public final ControlMessage O00000o0(byte[] bArr) {
        byte[] bArr2 = bArr;
        byte b2 = bArr2[10];
        int i = (b2 >> 6) & 1;
        byte b3 = b2 & 63;
        int i2 = (bArr2[11] >> 7) & 1;
        int i3 = ((bArr2[11] & Byte.MAX_VALUE) << 6) | ((bArr2[12] & 252) >> 2);
        int i4 = ((bArr2[12] & 3) << 3) | ((bArr2[13] & 224) >> 5);
        byte b4 = bArr2[13] & 31;
        byte b5 = bArr2[2] & Byte.MAX_VALUE;
        byte[] O0000OOo = o00o0000oo.O0000OOo(bArr);
        byte[] O0000Oo0 = o00o0000oo.O0000Oo0(bArr);
        String str = O00000oo;
        o00oo0oo00.O00000o(str, "SEG O: " + i4);
        String str2 = O00000oo;
        o00oo0oo00.O00000o(str2, "SEG N: " + b4);
        this.O00oOooo = oooo0o0oo.O000000o(this.O00oOooo, i4);
        String str3 = O00000oo;
        StringBuilder n = a.n("Block acknowledgement value for ");
        n.append(this.O00oOooo);
        n.append(" Seg O ");
        n.append(i4);
        o00oo0oo00.O00000o(str3, n.toString());
        int length = bArr2.length - 10;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.put(bArr2, 10, length);
        this.O0000oo.put(i4, allocate.array());
        if (b4 != this.O0000oo.size() - 1) {
            return null;
        }
        o00oo0oo00.O00000o(O00000oo, "All segments received");
        String str4 = O00000oo;
        StringBuilder n2 = a.n("Block ack sent? ");
        n2.append(this.O000O0OO);
        o00oo0oo00.O00000o(str4, n2.toString());
        if (this.O000O0Oo > System.currentTimeMillis() && !this.O000O0OO && o00o0000oo.O0000o00(O0000Oo0)) {
            o00oo0oo00.O00000o(O00000oo, "Cancelling Scheduled block ack and incomplete timer, sending an immediate block ack");
            O00000o(i3, b5, O0000Oo0, O0000OOo, b4);
        }
        byte[] O00000Oo = o00o0000oo.O00000Oo(O000000o(o00o0000oo.O0000Oo(bArr), i3));
        ControlMessage controlMessage = new ControlMessage();
        controlMessage.setAszmic(i2);
        controlMessage.setSequenceNumber(O00000Oo);
        controlMessage.setAkf(i);
        controlMessage.setAid(b3);
        controlMessage.setSegmented(true);
        SparseArray<byte[]> clone = this.O0000oo.clone();
        this.O0000oo.clear();
        controlMessage.setLowerTransportControlPdu(clone);
        return controlMessage;
    }

    public abstract Message O00000o0(Message message);

    public final void O00000oO(AccessMessage accessMessage) {
        accessMessage.setUpperTransportPdu(o00o0000oo.O00000Oo(O00000oo(accessMessage)));
    }
}

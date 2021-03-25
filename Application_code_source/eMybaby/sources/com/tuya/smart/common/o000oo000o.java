package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;
import android.util.SparseArray;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.NetworkKey;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException;
import com.tuya.smart.common.o00o00000o;
import com.tuya.spongycastle.crypto.InvalidCipherTextException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class o000oo000o extends o000o0oo0o {
    public static final String O0000o = "o000oo000o";
    public byte[] O00000oo;
    public NetworkKey O0000O0o;
    public SparseArray<byte[]> O0000oO;
    public SparseArray<byte[]> O0000oO0;

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f5, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.tuya.sdk.sigmesh.bean.AccessMessage O000000o(byte[] r8, byte[] r9, byte[] r10, byte[] r11, byte[] r12, int r13) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.tuya.smart.common.o00o00000o$O000000o r0 = r7.O00000oO()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte[] r0 = r0.O00000Oo()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r1 = 0
            byte r2 = r9[r1]     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r2 = r2 & 127(0x7f, float:1.78E-43)
            int r3 = r8.length     // Catch:{ InvalidCipherTextException -> 0x0155 }
            int r4 = r9.length     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r5 = 2
            int r4 = r4 + r5
            int r3 = r3 - r4
            byte[] r4 = new byte[r3]     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r6 = 8
            java.lang.System.arraycopy(r8, r6, r4, r1, r3)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte[] r10 = com.tuya.smart.common.o00o00000o.O00000Oo(r4, r0, r10, r13)     // Catch:{ InvalidCipherTextException -> 0x0142 }
            java.nio.ByteBuffer r13 = java.nio.ByteBuffer.allocate(r5)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r13 = r13.order(r0)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r13 = r13.put(r10, r1, r5)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte[] r13 = r13.array()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r0 = O0000o     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r3.<init>()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r4 = "Dst: "
            r3.append(r4)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r4 = 1
            java.lang.String r4 = com.tuya.smart.common.o00o0000oo.O000000o((byte[]) r13, (boolean) r4)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r3.append(r4)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r3 = r3.toString()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            com.tuya.smart.common.o00oo0oo00.O00000o(r0, r3)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte r0 = r10[r5]     // Catch:{ InvalidCipherTextException -> 0x0155 }
            boolean r0 = r7.O000000o((byte) r0)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            if (r0 == 0) goto L_0x00f6
            java.lang.String r12 = O0000o     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.<init>()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r3 = "Received a segmented access message from: "
            r0.append(r3)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r3 = com.tuya.smart.common.o00o0000oo.O000000o((byte[]) r11, (boolean) r1)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.append(r3)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r0 = r0.toString()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            android.util.Log.v(r12, r0)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode r12 = r7.O00000o     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte[] r12 = r12.getUnicastAddress()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            boolean r12 = java.util.Arrays.equals(r11, r12)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0 = 0
            if (r12 != 0) goto L_0x0083
            java.lang.String r8 = O0000o     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r9 = "Segment received is from a different src than the one we are processing, let's drop it"
            android.util.Log.v(r8, r9)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            monitor-exit(r7)
            return r0
        L_0x0083:
            android.util.SparseArray<byte[]> r12 = r7.O0000oO0     // Catch:{ InvalidCipherTextException -> 0x0155 }
            if (r12 != 0) goto L_0x0092
            android.util.SparseArray r12 = new android.util.SparseArray     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r12.<init>()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r7.O0000oO0 = r12     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r12.put(r1, r8)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            goto L_0x009d
        L_0x0092:
            android.util.SparseArray<byte[]> r12 = r7.O0000oO0     // Catch:{ InvalidCipherTextException -> 0x0155 }
            int r12 = r12.size()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            android.util.SparseArray<byte[]> r3 = r7.O0000oO0     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r3.put(r12, r8)     // Catch:{ InvalidCipherTextException -> 0x0155 }
        L_0x009d:
            int r12 = r9.length     // Catch:{ InvalidCipherTextException -> 0x0155 }
            int r12 = r12 + r5
            int r3 = r10.length     // Catch:{ InvalidCipherTextException -> 0x0155 }
            int r12 = r12 + r3
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r12)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r12 = r12.order(r3)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r12 = r12.put(r8, r1, r5)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r9 = r12.put(r9)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r9 = r9.put(r10)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte[] r9 = r9.array()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            com.tuya.sdk.sigmesh.bean.AccessMessage r9 = r7.O00000Oo((byte[]) r9)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            if (r9 == 0) goto L_0x00f4
            android.util.SparseArray<byte[]> r10 = r7.O0000oO0     // Catch:{ InvalidCipherTextException -> 0x0155 }
            if (r10 != 0) goto L_0x00cf
            android.util.SparseArray r10 = new android.util.SparseArray     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r10.<init>()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r7.O0000oO0 = r10     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r10.put(r1, r8)     // Catch:{ InvalidCipherTextException -> 0x0155 }
        L_0x00cf:
            android.util.SparseArray<byte[]> r8 = r7.O0000oO0     // Catch:{ InvalidCipherTextException -> 0x0155 }
            android.util.SparseArray r8 = r8.clone()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r7.O0000oO0 = r0     // Catch:{ InvalidCipherTextException -> 0x0155 }
            com.tuya.smart.common.oo0o0oooo r10 = com.tuya.smart.common.oo0o0oooo.O000000o()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte[] r10 = r10.O00000oo()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r9.setIvIndex(r10)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r9.setNetworkPdu(r8)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r9.setTtl(r2)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r9.setSrc(r11)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r9.setDst(r13)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r7.O00000oO((com.tuya.sdk.sigmesh.bean.Message) r9)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r7.O00000o0(r9)     // Catch:{ InvalidCipherTextException -> 0x0155 }
        L_0x00f4:
            monitor-exit(r7)
            return r9
        L_0x00f6:
            com.tuya.sdk.sigmesh.bean.AccessMessage r0 = new com.tuya.sdk.sigmesh.bean.AccessMessage     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.<init>()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte[] r3 = r7.O00000o0()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.setIvIndex(r3)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            android.util.SparseArray r3 = new android.util.SparseArray     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r3.<init>()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r3.put(r1, r8)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.setNetworkPdu(r3)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.setTtl(r2)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.setSrc(r11)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.setDst(r13)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r0.setSequenceNumber(r12)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            int r11 = r9.length     // Catch:{ InvalidCipherTextException -> 0x0155 }
            int r11 = r11 + r5
            int r12 = r10.length     // Catch:{ InvalidCipherTextException -> 0x0155 }
            int r11 = r11 + r12
            java.nio.ByteBuffer r11 = java.nio.ByteBuffer.allocate(r11)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteOrder r12 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r11 = r11.order(r12)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r8 = r11.put(r8, r1, r5)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r8 = r8.put(r9)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.nio.ByteBuffer r8 = r8.put(r10)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            byte[] r8 = r8.array()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r7.O000000o((com.tuya.sdk.sigmesh.bean.AccessMessage) r0, (byte[]) r8)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r7.O00000oO((com.tuya.sdk.sigmesh.bean.Message) r0)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r7.O00000o0(r0)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            monitor-exit(r7)
            return r0
        L_0x0142:
            r8 = move-exception
            com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException r9 = new com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r10 = r8.getMessage()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.Throwable r8 = r8.getCause()     // Catch:{ InvalidCipherTextException -> 0x0155 }
            java.lang.String r11 = O0000o     // Catch:{ InvalidCipherTextException -> 0x0155 }
            r9.<init>(r10, r8, r11)     // Catch:{ InvalidCipherTextException -> 0x0155 }
            throw r9     // Catch:{ InvalidCipherTextException -> 0x0155 }
        L_0x0153:
            r8 = move-exception
            goto L_0x0166
        L_0x0155:
            r8 = move-exception
            com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException r9 = new com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException     // Catch:{ all -> 0x0153 }
            java.lang.String r10 = r8.getMessage()     // Catch:{ all -> 0x0153 }
            java.lang.Throwable r8 = r8.getCause()     // Catch:{ all -> 0x0153 }
            java.lang.String r11 = O0000o     // Catch:{ all -> 0x0153 }
            r9.<init>(r10, r8, r11)     // Catch:{ all -> 0x0153 }
            throw r9     // Catch:{ all -> 0x0153 }
        L_0x0166:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o000oo000o.O000000o(byte[], byte[], byte[], byte[], byte[], int):com.tuya.sdk.sigmesh.bean.AccessMessage");
    }

    private ControlMessage O000000o(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        SparseArray<byte[]> sparseArray = this.O0000oO;
        if (sparseArray == null) {
            SparseArray<byte[]> sparseArray2 = new SparseArray<>();
            this.O0000oO = sparseArray2;
            sparseArray2.put(0, bArr);
        } else {
            this.O0000oO0.put(sparseArray.size(), bArr);
        }
        ControlMessage O00000o0 = O00000o0(bArr2);
        if (O00000o0 != null) {
            SparseArray<byte[]> clone = this.O0000oO.clone();
            this.O0000oO = null;
            O00000o0.setIvIndex(O00000o0());
            O00000o0.setNetworkPdu(clone);
            O00000o0.setTtl(i);
            O00000o0.setSrc(bArr3);
            O00000o0.setDst(bArr4);
        }
        return O00000o0;
    }

    private ControlMessage O000000o(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        ControlMessage controlMessage = new ControlMessage();
        controlMessage.setIvIndex(O00000o0());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, bArr);
        controlMessage.setNetworkPdu(sparseArray);
        controlMessage.setTtl(i);
        controlMessage.setSrc(bArr3);
        controlMessage.setDst(bArr4);
        controlMessage.setSequenceNumber(bArr5);
        controlMessage.setSegmented(false);
        O000000o(controlMessage, bArr2);
        return controlMessage;
    }

    private ControlMessage O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, int i) {
        byte[] bArr7 = bArr2;
        byte[] bArr8 = bArr3;
        try {
            byte[] O00000Oo = O00000oO().O00000Oo();
            byte b2 = bArr8[0] & Byte.MAX_VALUE;
            int length = bArr7.length - (bArr8.length + 2);
            byte[] bArr9 = new byte[length];
            System.arraycopy(bArr2, 8, bArr9, 0, length);
            byte[] bArr10 = bArr4;
            try {
                byte[] O00000Oo2 = o00o00000o.O00000Oo(bArr9, O00000Oo, bArr4, i);
                byte[] array = ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).put(O00000Oo2, 0, 2).array();
                byte[] array2 = ByteBuffer.allocate(bArr8.length + 2 + O00000Oo2.length).order(ByteOrder.BIG_ENDIAN).put(bArr2, 0, 2).put(bArr3).put(O00000Oo2).array();
                byte b3 = bArr7[0];
                if (b3 == 0) {
                    byte[] bArr11 = bArr;
                    if (!Arrays.equals(bArr, array)) {
                        Log.v(O0000o, "Received a control message that was not directed to us, so we drop it");
                        return null;
                    }
                    return O000000o(O00000Oo2[2]) ? O000000o(bArr2, array2, b2, bArr5, array) : O000000o(bArr2, array2, (int) b2, bArr5, array, bArr6);
                } else if (b3 != 2) {
                    return null;
                } else {
                    return O000000o(bArr2, array2, (int) b2, bArr5, array, bArr6);
                }
            } catch (InvalidCipherTextException e2) {
                InvalidCipherTextException invalidCipherTextException = e2;
                throw new ExtendedInvalidCipherTextException(invalidCipherTextException.getMessage(), invalidCipherTextException.getCause(), O0000o);
            } catch (InvalidCipherTextException e3) {
                e = e3;
                throw new ExtendedInvalidCipherTextException(e.getMessage(), e.getCause(), O0000o);
            }
        } catch (InvalidCipherTextException e4) {
            e = e4;
            throw new ExtendedInvalidCipherTextException(e.getMessage(), e.getCause(), O0000o);
        }
    }

    private byte[] O000000o(byte b2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteBuffer order = ByteBuffer.allocate(bArr.length + 1 + bArr2.length).order(ByteOrder.BIG_ENDIAN);
        order.put(b2);
        order.put(bArr);
        order.put(bArr2);
        byte[] array = order.array();
        ByteBuffer.allocate(6).put(bArr3, 0, 6);
        byte[] bArr4 = new byte[6];
        for (int i = 0; i < 6; i++) {
            bArr4[i] = (byte) (array[i] ^ bArr3[i]);
        }
        return bArr4;
    }

    private byte[] O000000o(Message message, byte[] bArr, byte[] bArr2) {
        byte[] O000000o = O000000o(message.getSequenceNumber(), message.getSrc(), message.getIvIndex());
        String str = O0000o;
        StringBuilder n = a.n("Proxy nonce: ");
        n.append(o00o0000oo.O000000o(O000000o, false));
        Log.v(str, n.toString());
        byte[] dst = message.getDst();
        return o00o00000o.O000000o(ByteBuffer.allocate(dst.length + bArr.length).order(ByteOrder.BIG_ENDIAN).put(dst).put(bArr).array(), bArr2, O000000o, o00o00000o.O00000Oo(message.getCtl()));
    }

    private byte[] O000000o(Message message, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] O00000Oo = O00000Oo((byte) ((message.getCtl() << 7) | message.getTtl()), bArr, message.getSrc(), message.getIvIndex());
        String str = O0000o;
        StringBuilder n = a.n("Network nonce: ");
        n.append(o00o0000oo.O000000o(O00000Oo, false));
        o00oo0oo00.O00000o(str, n.toString());
        byte[] dst = message.getDst();
        return o00o00000o.O000000o(ByteBuffer.allocate(dst.length + bArr2.length).order(ByteOrder.BIG_ENDIAN).put(dst).put(bArr2).array(), bArr3, O00000Oo, o00o00000o.O00000Oo(message.getCtl()));
    }

    private byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteBuffer allocate = ByteBuffer.allocate(13);
        allocate.put((byte) 3);
        allocate.put((byte) 0);
        allocate.put(bArr);
        allocate.put(bArr2);
        allocate.put(new byte[]{0, 0});
        allocate.put(bArr3);
        return allocate.array();
    }

    private ControlMessage O00000Oo(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i) {
        try {
            byte[] O00000Oo = O00000oO().O00000Oo();
            byte b2 = bArr2[0] & Byte.MAX_VALUE;
            int length = bArr.length - (bArr2.length + 2);
            byte[] bArr6 = new byte[length];
            System.arraycopy(bArr, 8, bArr6, 0, length);
            byte[] O00000Oo2 = o00o00000o.O00000Oo(bArr6, O00000Oo, bArr3, i);
            byte[] array = ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).put(O00000Oo2, 0, 2).array();
            if (O000000o(O00000Oo2[2])) {
                if (this.O0000oO == null) {
                    SparseArray<byte[]> sparseArray = new SparseArray<>();
                    this.O0000oO = sparseArray;
                    sparseArray.put(0, bArr);
                } else {
                    this.O0000oO0.put(this.O0000oO.size(), bArr);
                }
                ControlMessage O00000o0 = O00000o0(ByteBuffer.allocate(bArr2.length + 2 + O00000Oo2.length).order(ByteOrder.BIG_ENDIAN).put(bArr, 0, 2).put(bArr2).put(O00000Oo2).array());
                if (O00000o0 != null) {
                    SparseArray<byte[]> sparseArray2 = this.O0000oO;
                    this.O0000oO = null;
                    O00000o0.setIvIndex(O00000o0());
                    O00000o0.setNetworkPdu(sparseArray2);
                    O00000o0.setTtl(b2);
                    O00000o0.setSrc(bArr4);
                    O00000o0.setDst(array);
                }
                return O00000o0;
            }
            ControlMessage controlMessage = new ControlMessage();
            controlMessage.setIvIndex(O00000o0());
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(0, bArr);
            controlMessage.setNetworkPdu(sparseArray3);
            controlMessage.setTtl(b2);
            controlMessage.setSrc(bArr4);
            controlMessage.setDst(array);
            controlMessage.setSequenceNumber(bArr5);
            O000000o(controlMessage, ByteBuffer.allocate(bArr2.length + 2 + O00000Oo2.length).order(ByteOrder.BIG_ENDIAN).put(bArr, 0, 2).put(bArr2).put(O00000Oo2).array());
            return controlMessage;
        } catch (InvalidCipherTextException e2) {
            throw new ExtendedInvalidCipherTextException(e2.getMessage(), e2.getCause(), O0000o);
        } catch (InvalidCipherTextException e3) {
            throw new ExtendedInvalidCipherTextException(e3.getMessage(), e3.getCause(), O0000o);
        }
    }

    private byte[] O00000Oo(byte b2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteBuffer allocate = ByteBuffer.allocate(13);
        allocate.put((byte) 0);
        allocate.put(b2);
        allocate.put(bArr);
        allocate.put(bArr2);
        allocate.put(new byte[]{0, 0});
        allocate.put(bArr3);
        return allocate.array();
    }

    private byte[] O00000Oo(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = this.O00000oo;
        if (bArr4 != null) {
            bArr3 = (byte[]) bArr4.clone();
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 5 + bArr3.length);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(new byte[]{0, 0, 0, 0, 0});
        allocate.put(bArr3);
        allocate.put(bArr);
        byte[] array = allocate.array();
        String str = O0000o;
        StringBuilder n = a.n("Privacy Random: ");
        n.append(o00o0000oo.O000000o(array, false));
        o00oo0oo00.O00000o(str, n.toString());
        return o00o00000o.O00000o0(array, bArr2);
    }

    private byte[] O00000Oo(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr2.length + 5 + bArr.length);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(new byte[]{0, 0, 0, 0, 0});
        allocate.put(bArr);
        allocate.put(bArr2);
        return o00o00000o.O00000o0(allocate.array(), bArr3);
    }

    private byte[] O00000o(byte[] bArr) {
        if (O00000oO() == null) {
            return null;
        }
        byte[] O00000o0 = O00000oO().O00000o0();
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(bArr, 2, 6);
        byte[] array = allocate.array();
        ByteBuffer allocate2 = ByteBuffer.allocate(7);
        allocate2.order(ByteOrder.BIG_ENDIAN);
        allocate2.put(bArr, 8, 7);
        byte[] O00000Oo = O00000Oo(O0000O0o(allocate2.array()), O00000o0);
        byte[] bArr2 = new byte[6];
        for (int i = 0; i < 6; i++) {
            bArr2[i] = (byte) (array[i] ^ O00000Oo[i]);
        }
        return bArr2;
    }

    private o00o00000o.O000000o O00000oO() {
        NetworkKey O00000o = O00000o();
        if (O00000o != null) {
            return o00o00000o.O00000Oo(O00000o.getKey(), o00o00000o.O00000oO);
        }
        o00oo0oo00.O000000o(O0000o, "network layer networkKey is null");
        return null;
    }

    private byte[] O0000O0o(byte[] bArr) {
        byte[] bArr2 = new byte[7];
        System.arraycopy(bArr, 0, bArr2, 0, 7);
        return bArr2;
    }

    public final void O000000o(Message message) {
        boolean z = message instanceof AccessMessage;
        super.O000000o(message);
        O00000o0(message);
    }

    public void O000000o(NetworkKey networkKey, ProvisionedMeshNode provisionedMeshNode, byte[] bArr, byte[] bArr2) {
        this.O00000o = provisionedMeshNode;
        this.O00000oo = bArr;
        this.O0000O0o = networkKey;
        O00000oo(bArr2);
    }

    public /* bridge */ /* synthetic */ void O000000o(o000oo00o0 o000oo00o0) {
        super.O000000o(o000oo00o0);
    }

    public final Message O00000Oo(Message message, int i) {
        byte[] bArr;
        o00o00000o.O000000o O00000oO = O00000oO();
        byte O000000o = O00000oO.O000000o();
        byte[] O00000Oo = O00000oO.O00000Oo();
        String str = O0000o;
        StringBuilder n = a.n("Encryption key: ");
        n.append(o00o0000oo.O000000o(O00000Oo, false));
        Log.v(str, n.toString());
        byte[] O00000o0 = O00000oO.O00000o0();
        String str2 = O0000o;
        StringBuilder n2 = a.n("Privacy key: ");
        n2.append(o00o0000oo.O000000o(O00000o0, false));
        Log.v(str2, n2.toString());
        int ctl = message.getCtl();
        int ttl = message.getTtl();
        byte b2 = (byte) (O000000o | ((message.getIvIndex()[3] & 1) << 7));
        byte b3 = (byte) ((ctl << 7) | ttl);
        byte[] src = message.getSrc();
        SparseArray<byte[]> lowerTransportAccessPdu = message instanceof AccessMessage ? ((AccessMessage) message).getLowerTransportAccessPdu() : ((ControlMessage) message).getLowerTransportControlPdu();
        int pduType = message.getPduType();
        if (message.getPduType() != 0) {
            bArr = null;
        } else {
            byte[] O00000Oo2 = o00o0000oo.O00000Oo(O000000o(message.getSrc(), message.getSequenceNumber()));
            message.setSequenceNumber(O00000Oo2);
            String str3 = O0000o;
            StringBuilder n3 = a.n("Sequence Number: ");
            n3.append(o00o0000oo.O000000o(O00000Oo2, false));
            Log.v(str3, n3.toString());
            bArr = O000000o(message, O00000Oo2, lowerTransportAccessPdu.get(i), O00000Oo);
            if (bArr == null) {
                return null;
            }
            String str4 = O0000o;
            StringBuilder n4 = a.n("Encrypted Network payload: ");
            n4.append(o00o0000oo.O000000o(bArr, false));
            Log.v(str4, n4.toString());
        }
        SparseArray sparseArray = new SparseArray();
        byte[] O00000Oo3 = O00000Oo(message.getIvIndex(), O0000O0o(bArr), O00000o0);
        if (bArr == null) {
            return null;
        }
        byte[] O000000o2 = O000000o(b3, message.getSequenceNumber(), src, O00000Oo3);
        sparseArray.put(i, ByteBuffer.allocate(O000000o2.length + 2 + bArr.length).order(ByteOrder.BIG_ENDIAN).put((byte) pduType).put(b2).put(O000000o2).put(bArr).array());
        message.setNetworkPdu(sparseArray);
        return message;
    }

    public final void O00000Oo(Message message) {
        boolean z = message instanceof AccessMessage;
        super.O00000Oo(message);
        O00000o0(message);
    }

    public NetworkKey O00000o() {
        return this.O0000O0o;
    }

    public final Message O00000o0(Message message) {
        Message message2 = message;
        o00o00000o.O000000o O00000oO = O00000oO();
        byte O000000o = O00000oO.O000000o();
        byte[] O00000Oo = O00000oO.O00000Oo();
        String str = O0000o;
        StringBuilder n = a.n("Encryption key: ");
        n.append(o00o0000oo.O000000o(O00000Oo, false));
        o00oo0oo00.O000000o(str, n.toString());
        byte[] O00000o0 = O00000oO.O00000o0();
        String str2 = O0000o;
        StringBuilder n2 = a.n("Privacy key: ");
        n2.append(o00o0000oo.O000000o(O00000o0, false));
        o00oo0oo00.O000000o(str2, n2.toString());
        int ctl = message.getCtl();
        int ttl = message.getTtl();
        byte b2 = (byte) (O000000o | ((message.getIvIndex()[3] & 1) << 7));
        byte b3 = (byte) ((ctl << 7) | ttl);
        byte[] src = message.getSrc();
        SparseArray sparseArray = new SparseArray();
        ArrayList arrayList = new ArrayList();
        int pduType = message.getPduType();
        int pduType2 = message.getPduType();
        if (pduType2 == 0) {
            SparseArray<byte[]> lowerTransportAccessPdu = message2 instanceof AccessMessage ? ((AccessMessage) message2).getLowerTransportAccessPdu() : ((ControlMessage) message2).getLowerTransportControlPdu();
            int i = 0;
            while (i < lowerTransportAccessPdu.size()) {
                byte[] bArr = lowerTransportAccessPdu.get(i);
                if (i != 0) {
                    message2.setSequenceNumber(o00o0000oo.O00000Oo(O000000o(message.getSrc(), message.getSequenceNumber())));
                }
                arrayList.add(message.getSequenceNumber());
                String str3 = O0000o;
                StringBuilder n3 = a.n("Sequence Number: ");
                SparseArray<byte[]> sparseArray2 = lowerTransportAccessPdu;
                byte b4 = b2;
                n3.append(o00o0000oo.O000000o((byte[]) arrayList.get(i), false));
                o00oo0oo00.O00000o(str3, n3.toString());
                byte[] O000000o2 = O000000o(message2, (byte[]) arrayList.get(i), bArr, O00000Oo);
                sparseArray.put(i, O000000o2);
                String str4 = O0000o;
                StringBuilder n4 = a.n("Encrypted Network payload: ");
                n4.append(o00o0000oo.O000000o(O000000o2, false));
                o00oo0oo00.O00000o(str4, n4.toString());
                i++;
                b2 = b4;
                lowerTransportAccessPdu = sparseArray2;
            }
        } else if (pduType2 == 2) {
            int i2 = 0;
            for (SparseArray<byte[]> lowerTransportControlPdu = ((ControlMessage) message2).getLowerTransportControlPdu(); i2 < lowerTransportControlPdu.size(); lowerTransportControlPdu = lowerTransportControlPdu) {
                message2.setSequenceNumber(o00o0000oo.O00000Oo(O000000o(message.getSrc())));
                arrayList.add(message.getSequenceNumber());
                byte[] O000000o3 = O000000o(message2, lowerTransportControlPdu.get(i2), O00000Oo);
                sparseArray.put(i2, O000000o3);
                String str5 = O0000o;
                StringBuilder n5 = a.n("Encrypted Network payload: ");
                n5.append(o00o0000oo.O000000o(O000000o3, false));
                Log.v(str5, n5.toString());
                i2++;
            }
        }
        byte b5 = b2;
        SparseArray sparseArray3 = new SparseArray();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            byte[] bArr2 = (byte[]) sparseArray.get(i3);
            byte[] O000000o4 = O000000o(b3, (byte[]) arrayList.get(i3), src, O00000Oo(message.getIvIndex(), O0000O0o(bArr2), O00000o0));
            sparseArray3.put(i3, ByteBuffer.allocate(O000000o4.length + 2 + bArr2.length).order(ByteOrder.BIG_ENDIAN).put((byte) pduType).put(b5).put(O000000o4).put(bArr2).array());
            message2.setNetworkPdu(sparseArray3);
        }
        return message2;
    }

    public final Message O00000oO(byte[] bArr) {
        byte[] bArr2;
        byte[] O00000o = O00000o(bArr);
        if (O00000o == null) {
            return null;
        }
        byte b2 = O00000o[0];
        int i = (b2 >> 7) & 1;
        String str = O0000o;
        Log.v(str, "TTL for received message: " + (b2 & Byte.MAX_VALUE));
        int O00000Oo = o00o00000o.O00000Oo(i);
        byte[] array = ByteBuffer.allocate(3).order(ByteOrder.BIG_ENDIAN).put(O00000o, 1, 3).array();
        byte[] array2 = ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).put(O00000o, 4, 2).array();
        a.z(array2, true, a.n("Src: "), O0000o);
        ProvisionedMeshNode provisionedMeshNode = this.O00000o;
        if ((provisionedMeshNode == null || provisionedMeshNode.getUnicastAddressInt() != o000oo0o0o.O00000Oo(array2)) && this.O00000o == null) {
            return null;
        }
        int O0000OoO = o00o0000oo.O0000OoO(array);
        String str2 = O0000o;
        StringBuilder n = a.n("Sequence number of received access message: ");
        n.append(o00o0000oo.O0000OoO(array));
        o00oo0oo00.O00000o(str2, n.toString());
        if (O0000OoO > this.O00000o.getReceivedSequenceNumber()) {
            if (!o00o0000oo.O00000Oo(Integer.valueOf(O0000OoO))) {
                return null;
            }
            this.O00000o.setReceivedSequenceNumber(O0000OoO);
        }
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = this.O00000oo;
        if (bArr4 != null) {
            bArr3 = (byte[]) bArr4.clone();
        }
        byte b3 = bArr[0];
        if (b3 == 0) {
            bArr2 = O00000Oo((byte) b2, array, array2, bArr3);
        } else if (b3 != 2) {
            return null;
        } else {
            bArr2 = O000000o(array, array2, bArr3);
        }
        byte[] bArr5 = bArr2;
        if (i != 1) {
            return O000000o(bArr, O00000o, bArr5, array2, array, O00000Oo);
        }
        return O000000o(oo0o0oooo.O000000o().O00000o0(), bArr, O00000o, bArr5, array2, array, O00000Oo);
    }
}

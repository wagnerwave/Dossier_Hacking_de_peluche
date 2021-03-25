package com.tuya.smart.common;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class oo0ooo00o extends oo0oo0oo0 {
    public static final String O00000Oo = "ConfigModelSubscriptionAddAction";
    public static final int O00000o = 6;
    public static final int O00000o0 = 32795;
    public static final int O00000oO = 8;
    public final byte[] O0000OoO;
    public final int O0000Ooo;
    public final byte[] O0000o00;

    public oo0ooo00o(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length == 2) {
            this.O0000OoO = bArr;
            this.O0000Ooo = i;
            if (bArr2.length == 2) {
                this.O0000o00 = bArr2;
                O000000o();
                return;
            }
            throw new IllegalArgumentException("Subscription address must be 2 bytes");
        }
        throw new IllegalArgumentException("Element address must be 2 bytes");
    }

    public byte[] O000000o() {
        ByteBuffer order;
        int i = this.O0000Ooo;
        if (i < -32768 || i > 32767) {
            order = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            order.put(this.O0000OoO[1]);
            order.put(this.O0000OoO[0]);
            order.put(this.O0000o00[1]);
            order.put(this.O0000o00[0]);
            int i2 = this.O0000Ooo;
            byte[] bArr = {(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
            order.put(bArr[1]);
            order.put(bArr[0]);
            order.put(bArr[3]);
            order.put(bArr[2]);
        } else {
            order = ByteBuffer.allocate(6).order(ByteOrder.LITTLE_ENDIAN);
            order.put(this.O0000OoO[1]);
            order.put(this.O0000OoO[0]);
            order.put(this.O0000o00[1]);
            order.put(this.O0000o00[0]);
            order.putShort((short) this.O0000Ooo);
        }
        return order.array();
    }

    public int O00000Oo() {
        return 32795;
    }

    public int O00000o0() {
        return 32799;
    }
}

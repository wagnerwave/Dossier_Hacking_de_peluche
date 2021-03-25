package com.tuya.smart.common;

import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class oo0oo0ooo extends oo0oo0oo0 {
    public static final int O00000Oo = 32829;
    public static final int O00000o = 8;
    public static final int O00000o0 = 6;
    public byte[] O00000oO;
    public int O0000OoO;
    public int O0000Ooo;

    public oo0oo0ooo() {
    }

    public oo0oo0ooo(String str, byte[] bArr, int i, int i2, o00o0o0o0o.O000000o o000000o, o000oo0000 o000oo0000) {
        super(str, o000000o, o000oo0000);
        this.O00000oO = bArr;
        this.O0000OoO = i;
        this.O0000Ooo = i2;
    }

    public byte[] O000000o() {
        ByteBuffer order;
        byte[] O000000o = o00o0000oo.O000000o(Integer.valueOf(this.O0000Ooo));
        int i = this.O0000OoO;
        if (i < -32768 || i > 32767) {
            order = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            order.put(this.O00000oO[1]);
            order.put(this.O00000oO[0]);
            order.put(O000000o[1]);
            order.put(O000000o[0]);
            int i2 = this.O0000OoO;
            byte[] bArr = {(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
            order.put(bArr[1]);
            order.put(bArr[0]);
            order.put(bArr[3]);
            order.put(bArr[2]);
        } else {
            order = ByteBuffer.allocate(6).order(ByteOrder.LITTLE_ENDIAN);
            order.put(this.O00000oO[1]);
            order.put(this.O00000oO[0]);
            order.put(O000000o[1]);
            order.put(O000000o[0]);
            order.putShort((short) this.O0000OoO);
        }
        return order.array();
    }

    public int O00000Oo() {
        return 32829;
    }

    public int O00000o0() {
        return 32830;
    }
}

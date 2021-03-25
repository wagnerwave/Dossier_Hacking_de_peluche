package com.tuya.smart.common;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class oo0ooo000 extends oo0oo0oo0 {
    public static final String O00000Oo = "ConfigModelPublicationAction";
    public static final int O00000o = 11;
    public static final int O00000o0 = 3;
    public static final int O00000oO = 13;
    public final byte[] O0000OoO;
    public final byte[] O0000Ooo;
    public final int O0000o;
    public final boolean O0000o0;
    public final int O0000o00;
    public final int O0000o0O;
    public final int O0000o0o;
    public final int O0000oO;
    public final int O0000oO0;
    public final int O0000oOO;

    public oo0ooo000(@NonNull byte[] bArr, @NonNull byte[] bArr2, int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (bArr.length == 2) {
            this.O0000OoO = bArr;
            if (bArr2.length == 2) {
                this.O0000Ooo = bArr2;
                this.O0000o0 = z;
                this.O0000o0O = i2;
                this.O0000o0o = i3;
                this.O0000o = i4;
                this.O0000oO0 = i5;
                this.O0000oO = i6;
                this.O0000oOO = i7;
                this.O0000o00 = i;
                return;
            }
            throw new IllegalArgumentException("Publish address must be 2 bytes");
        }
        throw new IllegalArgumentException("Element address must be 2 bytes");
    }

    public byte[] O000000o() {
        byte[] O000000o = o00o0000oo.O000000o(Integer.valueOf(this.O0000o00));
        boolean z = (O000000o[0] << 4) | this.O0000o0;
        int i = (this.O0000oO0 << 5) | (this.O0000oO & 31);
        int i2 = this.O0000oOO;
        if (i2 < -32768 || i2 > 32767) {
            ByteBuffer order = ByteBuffer.allocate(13).order(ByteOrder.LITTLE_ENDIAN);
            order.put(this.O0000OoO[1]);
            order.put(this.O0000OoO[0]);
            order.put(this.O0000Ooo[1]);
            order.put(this.O0000Ooo[0]);
            order.put(O000000o[1]);
            order.put(z ? (byte) 1 : 0);
            order.put((byte) this.O0000o0O);
            order.put((byte) ((this.O0000o0o << 6) | this.O0000o));
            order.put((byte) i);
            int i3 = this.O0000oOO;
            byte[] bArr = {(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
            order.put(bArr[1]);
            order.put(bArr[0]);
            order.put(bArr[3]);
            order.put(bArr[2]);
            return order.array();
        }
        ByteBuffer order2 = ByteBuffer.allocate(11).order(ByteOrder.LITTLE_ENDIAN);
        order2.put(this.O0000OoO[1]);
        order2.put(this.O0000OoO[0]);
        order2.put(this.O0000Ooo[1]);
        order2.put(this.O0000Ooo[0]);
        order2.put(O000000o[1]);
        order2.put(z ? (byte) 1 : 0);
        order2.put((byte) this.O0000o0O);
        order2.put((byte) ((this.O0000o << 6) | this.O0000o0o));
        order2.put((byte) i);
        order2.putShort((short) this.O0000oOO);
        return order2.array();
    }

    public int O00000Oo() {
        return 3;
    }

    public int O00000o0() {
        return ooooooo00.O00oOooo;
    }

    public byte[] O0000O0o() {
        return this.O0000OoO;
    }

    public byte[] O0000OOo() {
        return this.O0000Ooo;
    }

    public boolean O0000Oo() {
        return this.O0000o0;
    }

    public int O0000Oo0() {
        return this.O0000o00;
    }

    public int O0000OoO() {
        return this.O0000o0O;
    }

    public int O0000Ooo() {
        return this.O0000o0o;
    }

    public int O0000o0() {
        return this.O0000oO0;
    }

    public int O0000o00() {
        return this.O0000o;
    }

    public int O0000o0O() {
        return this.O0000oO;
    }

    public int O0000o0o() {
        return this.O0000oOO;
    }
}

package com.tuya.smart.common;

import a.a.a.a.a;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class oo0oooooo extends oo0oooo0o {
    public static final int O0000OoO = 33282;
    public static final int O0000Ooo = 33284;
    public static final int O0000o0 = 2;
    public static final int O0000o00 = 4;
    public final Integer O0000o;
    public final Integer O0000o0O;
    public final Integer O0000o0o;
    public final int O0000oO;
    public boolean O0000oO0;

    public oo0oooooo(boolean z, int i) {
        this(z, i, (Integer) null, (Integer) null, (Integer) null);
    }

    public oo0oooooo(boolean z, int i, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.O0000o0O = num;
        this.O0000o0o = num2;
        this.O0000o = num3;
        this.O0000oO0 = z;
        this.O0000oO = i;
    }

    public void O000000o(boolean z) {
        this.O0000oO0 = z;
    }

    public byte[] O00000oO() {
        int i;
        ByteBuffer byteBuffer;
        this.O00000Oo = o00o00000o.O00000o0(this.O000000o);
        StringBuilder n = a.n("State: ");
        n.append(this.O0000oO0 ? "ON" : "OFF");
        o00oo0oo00.O00000o(ooo0o0o00.O00000oo, n.toString());
        if (this.O0000o0O == null || this.O0000o0o == null || this.O0000o == null) {
            byteBuffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.put(this.O0000oO0 ? (byte) 1 : 0);
            i = this.O0000oO;
        } else {
            StringBuilder n2 = a.n("Transition steps: ");
            n2.append(this.O0000o0O);
            o00oo0oo00.O00000o(ooo0o0o00.O00000oo, n2.toString());
            o00oo0oo00.O00000o(ooo0o0o00.O00000oo, "Transition step resolution: " + this.O0000o0o);
            byteBuffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.put(this.O0000oO0 ? (byte) 1 : 0);
            byteBuffer.put((byte) this.O0000oO);
            byteBuffer.put((byte) ((this.O0000o0o.intValue() << 6) | this.O0000o0O.intValue()));
            i = this.O0000o.intValue();
        }
        byteBuffer.put((byte) i);
        return byteBuffer.array();
    }

    public int O00000oo() {
        return 33282;
    }

    public int O0000O0o() {
        return 33284;
    }

    public boolean O0000OOo() {
        return this.O0000oO0;
    }
}

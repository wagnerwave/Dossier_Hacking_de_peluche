package com.tuya.smart.common;

import a.a.a.a.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ooo00o000 extends oo0oooo0o {
    public static final String O0000OoO = "LightLightnessSetAction";
    public static final int O0000Ooo = 33356;
    public static final int O0000o0 = 3;
    public static final int O0000o00 = 5;
    public final Integer O0000o;
    public final Integer O0000o0O;
    public final Integer O0000o0o;
    public final int O0000oO;
    public final int O0000oO0;

    public ooo00o000(int i, int i2) {
        this((Integer) null, (Integer) null, (Integer) null, i, i2);
    }

    public ooo00o000(Integer num, Integer num2, Integer num3, int i, int i2) {
        this.O0000o0O = num;
        this.O0000o0o = num2;
        this.O0000o = num3;
        this.O0000oO = i2;
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Light lightness value must be between 0x0000 and 0xFFFF");
        }
        this.O0000oO0 = i;
    }

    public byte[] O00000oO() {
        int i;
        ByteBuffer byteBuffer;
        this.O00000Oo = o00o00000o.O00000o0(this.O000000o);
        StringBuilder n = a.n("Lightness: ");
        n.append(this.O0000oO0);
        o00oo0oo00.O00000o(O0000OoO, n.toString());
        if (this.O0000o0O == null || this.O0000o0o == null || this.O0000o == null) {
            byteBuffer = ByteBuffer.allocate(3).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort((short) this.O0000oO0);
            i = this.O0000oO;
        } else {
            StringBuilder n2 = a.n("Transition steps: ");
            n2.append(this.O0000o0O);
            o00oo0oo00.O00000o(O0000OoO, n2.toString());
            o00oo0oo00.O00000o(O0000OoO, "Transition step resolution: " + this.O0000o0o);
            byteBuffer = ByteBuffer.allocate(5).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort((short) this.O0000oO0);
            byteBuffer.put((byte) this.O0000oO);
            byteBuffer.put((byte) ((this.O0000o0o.intValue() << 6) | this.O0000o0O.intValue()));
            i = this.O0000o.intValue();
        }
        byteBuffer.put((byte) i);
        return byteBuffer.array();
    }

    public int O00000oo() {
        return 33356;
    }

    public int O0000O0o() {
        return 33358;
    }
}

package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ooo000o0o extends oo0oooo0o {
    public static final String O0000OoO = "LightHslSetAction";
    public static final int O0000Ooo = 33398;
    public static final int O0000o0 = 7;
    public static final int O0000o00 = 9;
    public final Integer O0000o;
    public final Integer O0000o0O;
    public final Integer O0000o0o;
    public final int O0000oO;
    public final int O0000oO0;
    public final int O0000oOO;
    public final int O0000oOo;

    public ooo000o0o(int i, int i2, int i3, int i4) {
        this((Integer) null, (Integer) null, (Integer) null, i, i2, i3, i4);
    }

    public ooo000o0o(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, int i, int i2, int i3, int i4) {
        this.O0000o0O = num;
        this.O0000o0o = num2;
        this.O0000o = num3;
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Light lightness value must be between 0 to 0xFFFF");
        } else if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("Light hue value must be between 0 to 0xFFFF");
        } else if (i3 < 0 || i3 > 65535) {
            throw new IllegalArgumentException("Light hue value must be between 0 to 0xFFFF");
        } else {
            this.O0000oO0 = i;
            this.O0000oO = i2;
            this.O0000oOO = i3;
            this.O0000oOo = i4;
        }
    }

    public byte[] O00000oO() {
        int i;
        ByteBuffer byteBuffer;
        this.O00000Oo = o00o00000o.O00000o0(this.O000000o);
        StringBuilder n = a.n("Lightness: ");
        n.append(this.O0000oO0);
        o00oo0oo00.O00000o(O0000OoO, n.toString());
        o00oo0oo00.O00000o(O0000OoO, "Hue: " + this.O0000oO);
        Log.v(O0000OoO, "Saturation: " + this.O0000oOO);
        Log.v(O0000OoO, "TID: " + this.O0000oOo);
        if (this.O0000o0O == null || this.O0000o0o == null || this.O0000o == null) {
            byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort((short) this.O0000oO0);
            byteBuffer.putShort((short) this.O0000oO);
            byteBuffer.putShort((short) this.O0000oOO);
            i = this.O0000oOo;
        } else {
            StringBuilder n2 = a.n("Transition steps: ");
            n2.append(this.O0000o0O);
            Log.v(O0000OoO, n2.toString());
            Log.v(O0000OoO, "Transition step resolution: " + this.O0000o0o);
            byteBuffer = ByteBuffer.allocate(9).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort((short) this.O0000oO0);
            byteBuffer.putShort((short) this.O0000oO);
            byteBuffer.putShort((short) this.O0000oOO);
            byteBuffer.put((byte) this.O0000oOo);
            byteBuffer.put((byte) ((this.O0000o0o.intValue() << 6) | this.O0000o0O.intValue()));
            i = this.O0000o.intValue();
        }
        byteBuffer.put((byte) i);
        return byteBuffer.array();
    }

    public int O00000oo() {
        return 33398;
    }

    public int O0000O0o() {
        return 33400;
    }
}

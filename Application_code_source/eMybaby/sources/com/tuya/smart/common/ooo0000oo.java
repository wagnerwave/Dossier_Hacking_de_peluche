package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ooo0000oo extends oo0oooo0o {
    public static final String O0000OoO = "LightCtlSetAction";
    public static final int O0000Ooo = 33381;
    public static final int O0000o0 = 7;
    public static final int O0000o00 = 9;
    public final Integer O0000o;
    public final Integer O0000o0O;
    public final Integer O0000o0o;
    public final int O0000oO;
    public final int O0000oO0;
    public final int O0000oOO;

    public ooo0000oo(int i, int i2, int i3) {
        this((Integer) null, (Integer) null, (Integer) null, i, i2, i3);
    }

    public ooo0000oo(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, int i, int i2, int i3) {
        this.O0000o0O = num;
        this.O0000o0o = num2;
        this.O0000o = num3;
        if (i < 800 || i > 20000) {
            throw new IllegalArgumentException("Light temperature value must be between 0x0320 to 0x4E20");
        } else if ((i2 == 0 || i2 >= 32768) && i2 <= 32767) {
            this.O0000oO0 = i;
            this.O0000oO = i2;
            this.O0000oOO = i3;
        } else {
            throw new IllegalArgumentException("Light delta uv value must be between 0x8000 to 0x7FFF or 0");
        }
    }

    public byte[] O00000oO() {
        int i;
        ByteBuffer byteBuffer;
        this.O00000Oo = o00o00000o.O00000o0(this.O000000o);
        StringBuilder n = a.n("Temperature: ");
        n.append(this.O0000oO0);
        o00oo0oo00.O00000o("LightCtlSetAction", n.toString());
        Log.v("LightCtlSetAction", "Delta UV: " + this.O0000oO);
        Log.v("LightCtlSetAction", "TID: " + ((byte) this.O0000oOO));
        if (this.O0000o0O == null || this.O0000o0o == null || this.O0000o == null) {
            byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort((short) this.O0000oO0);
            byteBuffer.putShort((short) this.O0000oO);
            i = this.O0000oOO;
        } else {
            StringBuilder n2 = a.n("Transition steps: ");
            n2.append(this.O0000o0O);
            Log.v("LightCtlSetAction", n2.toString());
            Log.v("LightCtlSetAction", "Transition step resolution: " + this.O0000o0o);
            byteBuffer = ByteBuffer.allocate(9).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort((short) this.O0000oO0);
            byteBuffer.putShort((short) this.O0000oO);
            byteBuffer.put((byte) this.O0000oOO);
            byteBuffer.put((byte) ((this.O0000o0o.intValue() << 6) | this.O0000o0O.intValue()));
            i = this.O0000o.intValue();
        }
        byteBuffer.put((byte) i);
        return byteBuffer.array();
    }

    public int O00000oo() {
        return 33381;
    }

    public int O0000O0o() {
        return 0;
    }
}

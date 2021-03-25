package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ooo000000 extends oo0oooo0o {
    public static final String O0000OoO = "GenericOnOffSetUnacknowledgedAction";
    public static final int O0000Ooo = 33283;
    public static final int O0000o0 = 2;
    public static final int O0000o00 = 4;
    public final Integer O0000o;
    public final Integer O0000o0O;
    public final Integer O0000o0o;
    public final int O0000oO;
    public final boolean O0000oO0;

    public ooo000000(boolean z, int i) {
        this(z, i, (Integer) null, (Integer) null, (Integer) null);
    }

    public ooo000000(boolean z, int i, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.O0000o0O = num;
        this.O0000o0o = num2;
        this.O0000o = num3;
        this.O0000oO0 = z;
        this.O0000oO = i;
    }

    public byte[] O00000oO() {
        int i;
        ByteBuffer byteBuffer;
        this.O00000Oo = o00o00000o.O00000o0(this.O000000o);
        StringBuilder n = a.n("State: ");
        n.append(this.O0000oO0 ? "ON" : "OFF");
        Log.v(O0000OoO, n.toString());
        if (this.O0000o0O == null || this.O0000o0o == null || this.O0000o == null) {
            byteBuffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.put(this.O0000oO0 ? (byte) 1 : 0);
            i = this.O0000oO;
        } else {
            StringBuilder n2 = a.n("Transition steps: ");
            n2.append(this.O0000o0O);
            Log.v(O0000OoO, n2.toString());
            Log.v(O0000OoO, "Transition step resolution: " + this.O0000o0o);
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
        return 33283;
    }

    public int O0000O0o() {
        return 0;
    }
}

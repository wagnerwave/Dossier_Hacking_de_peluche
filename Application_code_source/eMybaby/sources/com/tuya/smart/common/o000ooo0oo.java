package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.util.ArrayList;

public class o000ooo0oo {
    public static final short O000000o = 0;
    public static final String O00000Oo = "o000ooo0oo";
    public static final short O00000o = 2;
    public static final short O00000o0 = 1;
    public static final short O00000oO = 4;
    public static final short O00000oo = 8;
    public static final short O0000O0o = 16;

    public static int O000000o(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i == 4) {
                    return 3;
                }
                if (i != 8) {
                    return i != 16 ? -1 : 10;
                }
                return 4;
            }
        }
        return i2;
    }

    public static String O000000o(short s) {
        return s != 0 ? s != 1 ? s != 2 ? s != 4 ? s != 8 ? s != 16 ? "Unknown" : "Output Alpha Numeric" : "Output Numeric" : "Vibrate" : "Beep" : "Blink" : "Not Supported";
    }

    public static int O00000Oo(short s) {
        if (s == 2) {
            return 1;
        }
        if (s == 4) {
            return 2;
        }
        if (s != 8) {
            return s != 16 ? 0 : 4;
        }
        return 3;
    }

    public static void O00000Oo(int i) {
        byte[] bArr = {1, 2, 4, 8, Tnaf.POW_2_WIDTH};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            byte b2 = bArr[i2];
            if ((i & b2) == b2) {
                arrayList.add(Byte.valueOf(b2));
                String str = O00000Oo;
                StringBuilder n = a.n("Supported output oob action type: ");
                n.append(O000000o((short) b2));
                Log.v(str, n.toString());
            }
        }
    }

    public static short O00000o0(int i) {
        byte[] bArr = {1, 2, 4, 8, Tnaf.POW_2_WIDTH};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            byte b2 = bArr[i2];
            if ((i & b2) == b2) {
                arrayList.add(Byte.valueOf(b2));
                String str = O00000Oo;
                StringBuilder n = a.n("Supported output oob action type: ");
                n.append(O000000o((short) b2));
                Log.v(str, n.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            return (short) ((Byte) arrayList.get(0)).byteValue();
        }
        return 0;
    }
}

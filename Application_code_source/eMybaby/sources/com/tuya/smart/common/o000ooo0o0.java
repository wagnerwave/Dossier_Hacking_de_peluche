package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;

public class o000ooo0o0 {
    public static final String O000000o = "o000ooo0o0";
    public static final short O00000Oo = 0;
    public static final short O00000o = 2;
    public static final short O00000o0 = 1;
    public static final short O00000oO = 4;
    public static final short O00000oo = 8;

    public static String O000000o(short s) {
        return s != 0 ? s != 1 ? s != 2 ? s != 4 ? s != 8 ? "Unknown" : "Input Alpha Numeric" : "Input Number" : "Twist" : "Push" : "Not supported";
    }

    public static void O000000o(int i) {
        byte[] bArr = {1, 2, 4, 8};
        for (int i2 = 0; i2 < 4; i2++) {
            byte b2 = bArr[i2];
            if ((i & b2) == b2) {
                String str = O000000o;
                StringBuilder n = a.n("Input oob action type value: ");
                n.append(O000000o((short) b2));
                Log.v(str, n.toString());
            }
        }
    }

    public static int O00000Oo(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 4;
                if (i != 4) {
                    i2 = 8;
                    if (i != 8) {
                        return -1;
                    }
                }
            }
        }
        return i2;
    }

    public static int O00000Oo(short s) {
        if (s == 1) {
            return 0;
        }
        if (s == 2) {
            return 1;
        }
        if (s != 4) {
            return s != 8 ? -1 : 3;
        }
        return 2;
    }
}

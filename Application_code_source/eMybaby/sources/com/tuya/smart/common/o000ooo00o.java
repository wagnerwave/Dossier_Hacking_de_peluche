package com.tuya.smart.common;

import java.util.ArrayList;
import java.util.List;

public class o000ooo00o {
    public static final int O000000o = 20;

    public static void O000000o(String[] strArr) {
    }

    public static byte[] O000000o(int i) {
        byte[] bArr = new byte[0];
        do {
            int i2 = i % 128;
            i /= 128;
            if (i > 0) {
                i2 |= 128;
            }
            bArr = o00o0000oo.O000000o(bArr, new byte[]{(byte) i2});
        } while (i > 0);
        return bArr;
    }

    public static byte[][] O000000o(int i, byte[] bArr, int i2) {
        if (bArr == null || i2 < 0) {
            return new byte[0][];
        }
        if (bArr.length <= i2) {
            i2 = bArr.length;
        }
        byte[] O000000o2 = o00o0000oo.O000000o(bArr, 0, i2);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        do {
            byte[] O000000o3 = o00o0000oo.O000000o(new byte[0], O000000o(i3));
            if (i3 == 0) {
                O000000o3 = o00o0000oo.O000000o(o00o0000oo.O000000o(O000000o3, O000000o(i2)), new byte[]{(byte) (i << 4)});
            }
            byte[] O000000o4 = o00o0000oo.O000000o(O000000o2, i4, 20 - O000000o3.length);
            arrayList.add(o00o0000oo.O000000o(O000000o3, O000000o4));
            i4 += O000000o4.length;
            i3++;
        } while (i4 < i2);
        return o00o0000oo.O00000Oo((List<byte[]>) arrayList);
    }
}

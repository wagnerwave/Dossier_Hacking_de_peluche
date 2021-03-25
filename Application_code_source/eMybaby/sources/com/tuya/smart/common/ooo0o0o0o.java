package com.tuya.smart.common;

import java.util.ArrayList;
import java.util.List;

public class ooo0o0o0o extends ooo0o0oo0 {
    public static final int O000000o = 1;
    public final List<o000oo0o00> O00000Oo;

    public ooo0o0o0o(List<o000oo0o00> list) {
        ArrayList arrayList = new ArrayList();
        this.O00000Oo = arrayList;
        arrayList.addAll(list);
    }

    public byte[] O000000o() {
        if (!this.O00000Oo.isEmpty()) {
            byte[] bArr = new byte[((int) Math.pow(2.0d, (double) this.O00000Oo.size()))];
            int i = 0;
            for (o000oo0o00 next : this.O00000Oo) {
                bArr[i] = next.O000000o()[1];
                bArr[i + 1] = next.O000000o()[0];
                i += 2;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Address list cannot be empty!");
    }

    public int O00000Oo() {
        return 1;
    }
}

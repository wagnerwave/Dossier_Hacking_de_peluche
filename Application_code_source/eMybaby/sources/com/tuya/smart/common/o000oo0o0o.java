package com.tuya.smart.common;

import a.e.a.a.r.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class o000oo0o0o {
    public static final String O000000o = "o000oo0o0o";

    public static byte[] O000000o(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] O000000o(String str) {
        return O000000o(a.c(str));
    }

    public static byte[] O000000o(byte[] bArr) {
        int O00000Oo = O00000Oo(bArr) + 1;
        return new byte[]{(byte) ((O00000Oo >> 8) & 255), (byte) (O00000Oo & 255)};
    }

    public static int O00000Oo(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getShort() & 65535;
    }
}

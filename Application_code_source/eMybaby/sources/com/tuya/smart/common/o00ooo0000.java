package com.tuya.smart.common;

import java.nio.charset.Charset;

public final class o00ooo0000 {
    public static String O000000o(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return new String(bArr, Charset.defaultCharset()).trim();
    }

    public static byte[] O000000o(String str) {
        return O000000o(str, 0);
    }

    public static byte[] O000000o(String str, int i) {
        if (i <= 0) {
            return str.getBytes(Charset.defaultCharset());
        }
        byte[] bArr = new byte[i];
        byte[] bytes = str.getBytes(Charset.defaultCharset());
        if (bytes.length <= i) {
            i = bytes.length;
        }
        System.arraycopy(bytes, 0, bArr, 0, i);
        return bArr;
    }

    public static boolean O00000Oo(String str) {
        return str == null || str.trim().isEmpty();
    }
}

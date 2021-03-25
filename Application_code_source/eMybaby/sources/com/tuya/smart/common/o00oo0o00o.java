package com.tuya.smart.common;

import android.text.TextUtils;
import java.util.Formatter;
import okhttp3.HttpUrl;

public final class o00oo0o00o {
    public static String O000000o(byte[] bArr, String str) {
        return new String(bArr, str);
    }

    public static boolean O000000o(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] O000000o(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static byte[] O000000o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        while (true) {
            length--;
            if (length < 0) {
                return bArr2;
            }
            bArr2[length] = bArr[i];
            i++;
        }
    }

    public static byte[] O000000o(byte[] bArr, int i, int i2) {
        while (i < i2) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i];
            bArr[i] = b2;
            i++;
            i2--;
        }
        return bArr;
    }

    public static String O00000Oo(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        if (bArr.length == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 6);
        sb.append('[');
        sb.append(bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            sb.append(", ");
            sb.append(bArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public static String O00000Oo(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("%02X", new Object[]{Byte.valueOf(bArr[0])});
        for (int i = 1; i < bArr.length; i++) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            formatter.format("%02X", new Object[]{Byte.valueOf(bArr[i])});
        }
        formatter.flush();
        formatter.close();
        return sb.toString();
    }
}

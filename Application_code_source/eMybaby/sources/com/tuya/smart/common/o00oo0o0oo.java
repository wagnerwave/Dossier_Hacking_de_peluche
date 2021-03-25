package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tutk.IOTC.AVFrame;
import com.tutk.IOTC.Camera;
import java.io.ByteArrayOutputStream;

public class o00oo0o0oo {
    public static String O000000o = "0123456789ABCDEF";

    public static byte O000000o(byte b2, byte b3) {
        StringBuilder n = a.n("0x");
        n.append(new String(new byte[]{b2}));
        StringBuilder n2 = a.n("0x");
        n2.append(new String(new byte[]{b3}));
        return (byte) (((byte) (Byte.decode(n.toString()).byteValue() << 4)) | Byte.decode(n2.toString()).byteValue());
    }

    public static byte O000000o(char c2) {
        return (byte) Camera.HEXES.indexOf(c2);
    }

    public static String O000000o(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            str2 = a.k(str2, Integer.toHexString(str.charAt(i)));
        }
        return str2;
    }

    public static String O000000o(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & AVFrame.FRM_STATE_UNKOWN);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void O000000o(String[] strArr) {
        System.out.println(O00000oo("12345678910abcdefABCDEFa"));
    }

    public static String O00000Oo(String str) {
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            sb.append(O000000o.charAt((bytes[i] & 240) >> 4));
            sb.append(O000000o.charAt((bytes[i] & 15) >> 0));
        }
        return sb.toString();
    }

    public static boolean O00000Oo(char c2) {
        return (c2 >= '0' && c2 <= '9') || (c2 >= 'A' && c2 <= 'F') || (c2 >= 'a' && c2 <= 'f');
    }

    public static byte[] O00000o(String str) {
        byte[] bArr = new byte[6];
        byte[] bytes = str.getBytes();
        for (int i = 0; i < 6; i++) {
            int i2 = i * 2;
            bArr[i] = O000000o(bytes[i2], bytes[i2 + 1]);
        }
        return bArr;
    }

    public static String O00000o0(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write((O000000o.indexOf(str.charAt(i)) << 4) | O000000o.indexOf(str.charAt(i + 1)));
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static byte[] O00000oO(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (O000000o(charArray[i2 + 1]) | (O000000o(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static boolean O00000oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!O00000Oo(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

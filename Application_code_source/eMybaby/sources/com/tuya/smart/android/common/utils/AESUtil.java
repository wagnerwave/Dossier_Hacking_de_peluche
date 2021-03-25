package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.oOO0O0O0;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    public String ALGO;
    public byte[] keyValue;

    public static String byte2hex(byte[] bArr) {
        String str;
        StringBuilder sb;
        String str2 = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & AVFrame.FRM_STATE_UNKOWN);
            if (hexString.length() == 1) {
                sb = a.n(str2);
                str = oOO0O0O0.O0000oO0;
            } else {
                str = str2;
                sb = new StringBuilder();
            }
            str2 = a.m(sb, str, hexString);
        }
        return str2.toUpperCase();
    }

    private Key generateKey() {
        return new SecretKeySpec(this.keyValue, this.ALGO);
    }

    public static byte[] hex2byte(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 == 1) {
            return null;
        }
        int i = length / 2;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 != i; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public static void main(String[] strArr) {
    }

    public String decrypt(String str) {
        Key generateKey = generateKey();
        Cipher instance = Cipher.getInstance(this.ALGO);
        instance.init(2, generateKey);
        return new String(instance.doFinal(hex2byte(str)));
    }

    public String decrypt(byte[] bArr) {
        Key generateKey = generateKey();
        Cipher instance = Cipher.getInstance(this.ALGO);
        instance.init(2, generateKey);
        return new String(instance.doFinal(bArr), "UTF-8");
    }

    public String decryptWithBase64(String str) {
        Key generateKey = generateKey();
        Cipher instance = Cipher.getInstance(this.ALGO);
        instance.init(2, generateKey);
        return new String(instance.doFinal(Base64.decodeBase64(str.getBytes())));
    }

    public byte[] decryptWithBytes(byte[] bArr) {
        Key generateKey = generateKey();
        Cipher instance = Cipher.getInstance(this.ALGO);
        instance.init(2, generateKey);
        return instance.doFinal(bArr);
    }

    public String encrypt(String str) {
        Key generateKey = generateKey();
        Cipher instance = Cipher.getInstance(this.ALGO);
        instance.init(1, generateKey);
        return byte2hex(instance.doFinal(str.getBytes()));
    }

    public String encryptWithBase64(String str) {
        Key generateKey = generateKey();
        Cipher instance = Cipher.getInstance(this.ALGO);
        instance.init(1, generateKey);
        return new String(Base64.encodeBase64(instance.doFinal(str.getBytes())));
    }

    public byte[] encryptWithBytes(String str) {
        Key generateKey = generateKey();
        Cipher instance = Cipher.getInstance(this.ALGO);
        instance.init(1, generateKey);
        return instance.doFinal(str.getBytes());
    }

    public byte[] encryptWithBytes(byte[] bArr) {
        Key generateKey = generateKey();
        Cipher instance = Cipher.getInstance(this.ALGO);
        instance.init(1, generateKey);
        return instance.doFinal(bArr);
    }

    public String getALGO() {
        return this.ALGO;
    }

    public byte[] getKeyValue() {
        return this.keyValue;
    }

    public void setALGO(String str) {
        this.ALGO = str;
    }

    public void setKeyValue(byte[] bArr) {
        this.keyValue = bArr;
    }
}

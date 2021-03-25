package com.tuya.smart.common;

import com.tutk.IOTC.AVFrame;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class o00oo0oo0o {
    public static final int O000000o = 16384;

    public static String O000000o(String str) {
        return O00000Oo(str.getBytes());
    }

    public static String O000000o(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "HmacMD5");
            Mac instance = Mac.getInstance("HmacMD5");
            instance.init(secretKeySpec);
            byte[] doFinal = instance.doFinal(str.getBytes("ASCII"));
            StringBuilder sb = new StringBuilder();
            for (byte b2 : doFinal) {
                String hexString = Integer.toHexString(b2 & AVFrame.FRM_STATE_UNKOWN);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static byte[] O000000o(File file) {
        return O000000o((InputStream) new FileInputStream(file));
    }

    public static byte[] O000000o(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[16384];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 16384);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            try {
                bufferedInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return digest;
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalStateException(e3);
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String O00000Oo(File file) {
        return o00oo0o0oo.O000000o(O000000o(file));
    }

    public static String O00000Oo(InputStream inputStream) {
        return o00oo0o0oo.O000000o(O000000o(inputStream));
    }

    public static String O00000Oo(String str) {
        return O000000o(str).substring(8, 24);
    }

    public static String O00000Oo(byte[] bArr) {
        return o00oo0o0oo.O000000o(O000000o(bArr));
    }
}

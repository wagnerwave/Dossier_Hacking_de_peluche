package com.tuya.smart.android.common.utils;

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

public class MD5Util {
    public static final int SIXTEEN_K = 16384;

    public static byte[] computeMD5Hash(File file) {
        return computeMD5Hash((InputStream) new FileInputStream(file));
    }

    public static byte[] computeMD5Hash(InputStream inputStream) {
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

    public static byte[] computeMD5Hash(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String getHmacMd5Str(String str, String str2) {
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

    public static String md5AsBase64(File file) {
        return HexUtil.bytesToHexString(computeMD5Hash(file));
    }

    public static String md5AsBase64(InputStream inputStream) {
        return HexUtil.bytesToHexString(computeMD5Hash(inputStream));
    }

    public static String md5AsBase64(String str) {
        return md5AsBase64(str.getBytes());
    }

    public static String md5AsBase64(byte[] bArr) {
        return HexUtil.bytesToHexString(computeMD5Hash(bArr));
    }

    public static String md5AsBase64For16(String str) {
        return md5AsBase64(str).substring(8, 24);
    }
}

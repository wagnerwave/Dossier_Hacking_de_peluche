package com.tuya.sdk.sweeper.utils;

import com.tuya.sdk.security.EncryptionManager;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class TuyaCloudSignatureTools {
    static {
        System.loadLibrary("cloudsignature-lib");
    }

    public static native String generateSignedUrl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    public static byte[] hmacSha1(byte[] bArr, byte[] bArr2) {
        return hmacShaEncrypt(bArr, bArr2, "HmacSHA1");
    }

    public static byte[] hmacSha256(byte[] bArr, byte[] bArr2) {
        return hmacShaEncrypt(bArr, bArr2, EncryptionManager.O000O0o0);
    }

    public static byte[] hmacShaEncrypt(byte[] bArr, byte[] bArr2, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, str);
            Mac instance = Mac.getInstance(str);
            instance.init(secretKeySpec);
            return instance.doFinal(bArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] sha256(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}

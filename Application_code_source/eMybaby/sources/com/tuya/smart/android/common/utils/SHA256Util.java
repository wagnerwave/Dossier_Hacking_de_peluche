package com.tuya.smart.android.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Util {
    public static byte[] getHash(String str) {
        return getHash(str.getBytes());
    }

    public static byte[] getHash(byte[] bArr) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.reset();
        return messageDigest.digest(bArr);
    }

    public static String sha256(String str) {
        return sha256(str.getBytes());
    }

    public static String sha256(byte[] bArr) {
        String bytesToHexString;
        byte[] hash = getHash(bArr);
        if (hash == null || (bytesToHexString = HexUtil.bytesToHexString(hash)) == null) {
            return null;
        }
        return bytesToHexString.toLowerCase();
    }
}

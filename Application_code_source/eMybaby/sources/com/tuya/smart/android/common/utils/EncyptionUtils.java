package com.tuya.smart.android.common.utils;

import com.tuya.sdk.security.EncryptionManager;

public class EncyptionUtils {
    public static String decryptAes(String str, String str2) {
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str.getBytes());
        try {
            return aESUtil.decrypt(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String encryptAes(String str, String str2) {
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str2.getBytes());
        try {
            return aESUtil.encrypt(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}

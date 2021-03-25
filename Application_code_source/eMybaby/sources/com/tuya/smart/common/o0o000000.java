package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.sdk.hardwareprotocol.bean.HDpResponse;
import com.tuya.sdk.hardwareprotocol.bean.HRequest;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.android.common.utils.AESUtil;
import com.tuya.smart.android.common.utils.MD5;

public class o0o000000 {
    public static HDpResponse O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str2.getBytes());
        try {
            return (HDpResponse) JSON.parseObject(aESUtil.decryptWithBase64(str), HDpResponse.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static HRequest O000000o(HRequest hRequest, String str) {
        if (!TextUtils.isEmpty(str)) {
            AESUtil aESUtil = new AESUtil();
            aESUtil.setALGO(EncryptionManager.O0000ooO);
            aESUtil.setKeyValue(str.getBytes());
            try {
                hRequest.setData(aESUtil.encrypt(new String(hRequest.getData())).getBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hRequest;
    }

    public static String O000000o(String str, String str2, String str3) {
        String md5 = MD5.md5("data=" + str2 + "||lpv=" + str + o0ooo00oo.O0000Oo + str3);
        if (md5 == null) {
            return null;
        }
        return md5.toLowerCase().substring(8, 24);
    }

    public static HRequest O00000Oo(HRequest hRequest, String str) {
        if (!TextUtils.isEmpty(str)) {
            AESUtil aESUtil = new AESUtil();
            aESUtil.setALGO(EncryptionManager.O0000ooO);
            aESUtil.setKeyValue(str.getBytes());
            try {
                hRequest.setData(aESUtil.encryptWithBase64(new String(hRequest.getData())).getBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hRequest;
    }
}

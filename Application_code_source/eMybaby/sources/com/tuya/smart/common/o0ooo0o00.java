package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.sdk.mqttprotocol.bean.PublishBean;
import com.tuya.sdk.mqttprotocol.bean.PublishBean2_1;
import com.tuya.sdk.mqttprotocol.bean.PublishBean2_2;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.android.common.utils.AESUtil;

public class o0ooo0o00 {
    public static PublishBean2_1 O000000o(long j, int i, int i2, Object obj) {
        PublishBean2_1 publishBean2_1 = new PublishBean2_1();
        publishBean2_1.setData(obj);
        publishBean2_1.setProtocol(i);
        publishBean2_1.setT(j);
        publishBean2_1.setS(i2);
        return publishBean2_1;
    }

    public static PublishBean2_2 O000000o(long j, int i, Object obj) {
        PublishBean2_2 publishBean2_2 = new PublishBean2_2();
        publishBean2_2.setData(obj);
        publishBean2_2.setProtocol(i);
        publishBean2_2.setT(j);
        return publishBean2_2;
    }

    public static PublishBean O000000o(PublishBean publishBean, String str) {
        String data = publishBean.getData();
        if (!TextUtils.isEmpty(str)) {
            AESUtil aESUtil = new AESUtil();
            aESUtil.setALGO(EncryptionManager.O0000ooO);
            aESUtil.setKeyValue(str.getBytes());
            try {
                publishBean.setData(aESUtil.encrypt(data));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return publishBean;
    }

    public static PublishBean O000000o(String str, long j, String str2, int i, String str3) {
        PublishBean publishBean = new PublishBean();
        publishBean.setPv(str2);
        publishBean.setT(j);
        publishBean.setGwId(str);
        publishBean.setProtocol(i);
        publishBean.setData(str3);
        return publishBean;
    }

    public static String O000000o(PublishBean2_1 publishBean2_1, String str) {
        String jSONString = JSON.toJSONString((Object) publishBean2_1, SerializerFeature.WriteMapNullValue);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str.getBytes());
        try {
            return aESUtil.encryptWithBase64(jSONString);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str2.getBytes());
        try {
            return aESUtil.decrypt(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String O000000o(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str.getBytes());
        try {
            return aESUtil.decrypt(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] O000000o(PublishBean2_2 publishBean2_2, String str) {
        String jSONString = JSON.toJSONString((Object) publishBean2_2, SerializerFeature.WriteMapNullValue);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str.getBytes());
        try {
            return aESUtil.encryptWithBytes(jSONString);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String O00000Oo(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str2.getBytes());
        try {
            return aESUtil.decryptWithBase64(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

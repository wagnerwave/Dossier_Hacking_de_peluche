package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.sdk.hardwareprotocol.bean.HRequest;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.android.common.utils.AESUtil;
import com.tuya.smart.android.common.utils.ByteUtils;

public class o00ooo000 extends o00oo0o00 {
    public o00ooo000(o00o0ooo0 o00o0ooo0) {
        super(o00o0ooo0);
    }

    public static HRequest O000000o(HRequest hRequest, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            AESUtil aESUtil = new AESUtil();
            aESUtil.setALGO(EncryptionManager.O0000ooO);
            aESUtil.setKeyValue(str2.getBytes());
            try {
                hRequest.setData(aESUtil.encryptWithBytes(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hRequest;
    }

    public static HRequest O000000o(String str, int i) {
        HRequest hRequest = new HRequest();
        hRequest.setDevId(str);
        hRequest.setType(i);
        return hRequest;
    }

    public static byte[] O00000Oo() {
        return new byte[4];
    }

    public void O000000o(o00o0o0o0<HRequest> o00o0o0o0) {
        HRequest O000000o = O000000o(O000000o(this.O00000o, this.O00000oO), JSON.toJSONString(this.O000000o, SerializerFeature.WriteMapNullValue), this.O00000Oo);
        O000000o.setData(ByteUtils.contact(this.O00000o0.getBytes(), O00000Oo(), ByteUtils.intToBytes2(this.O00000oo), ByteUtils.intToBytes2(this.O0000O0o), O000000o.getData()));
        if (o00o0o0o0 != null) {
            o00o0o0o0.O000000o(O000000o);
        }
    }
}

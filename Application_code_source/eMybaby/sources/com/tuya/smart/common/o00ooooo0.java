package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.sdk.hardwareprotocol.bean.HDpResponse;
import com.tuya.sdk.hardwareprotocol.bean.ResponseSRBean3_2;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.android.common.utils.AESUtil;
import com.tuya.smart.android.common.utils.ByteUtils;
import com.tuya.smart.android.common.utils.L;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

public class o00ooooo0 extends o00ooo0oo {
    public static final String O00000Oo = "LocalResp3_2";

    public o00ooooo0(o00oo0000 o00oo0000) {
        super(o00oo0000);
    }

    public static ResponseSRBean3_2 O000000o(byte[] bArr) {
        ResponseSRBean3_2 responseSRBean3_2 = new ResponseSRBean3_2();
        responseSRBean3_2.setS(ByteUtils.bytesToInt2(bArr, 7));
        responseSRBean3_2.setO(ByteUtils.bytesToInt2(bArr, 11));
        byte[] bArr2 = new byte[3];
        System.arraycopy(bArr, 0, bArr2, 0, 3);
        try {
            responseSRBean3_2.setVersion(new String(bArr2, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return responseSRBean3_2;
    }

    public static byte[] O000000o(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AESUtil aESUtil = new AESUtil();
        aESUtil.setALGO(EncryptionManager.O0000ooO);
        aESUtil.setKeyValue(str.getBytes());
        try {
            return aESUtil.decryptWithBytes(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void O000000o(o00o0o000 o00o0o000) {
        HDpResponse hDpResponse;
        super.O000000o(o00o0o000);
        ResponseSRBean3_2 O000000o = O000000o(this.O000000o.O00000Oo());
        if (this.O000000o.O00000oO() == null || !this.O000000o.O00000oO().O000000o(this.O000000o.O00000o(), O000000o.getS(), O000000o.getO())) {
            int length = this.O000000o.O00000Oo().length - 15;
            byte[] bArr = new byte[length];
            System.arraycopy(this.O000000o.O00000Oo(), 15, bArr, 0, length);
            byte[] O000000o2 = O000000o(bArr, this.O000000o.O00000o0());
            if (O000000o2 == null || (hDpResponse = (HDpResponse) JSON.parseObject(O000000o2, (Type) HDpResponse.class, new Feature[0])) == null) {
                O000000o((HDpResponse) null);
            } else {
                O000000o(hDpResponse);
            }
        } else {
            L.d(O00000Oo, "Data is Updated");
        }
    }
}

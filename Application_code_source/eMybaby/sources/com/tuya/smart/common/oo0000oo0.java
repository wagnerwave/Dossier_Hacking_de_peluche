package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.ByteUtils;
import com.tuya.smart.android.common.utils.CRC32Utils;
import com.tuya.smart.android.common.utils.L;
import java.io.UnsupportedEncodingException;

public class oo0000oo0 extends oo0000o0o {
    public static final String O00000Oo = "MsgProtocol1_1";
    public o0ooooo00 O00000o0;

    public oo0000oo0(o0oooo0oo o0oooo0oo) {
        super(o0oooo0oo);
    }

    private void O000000o(int i, JSONObject jSONObject) {
        this.O00000o0.O000000o(i, jSONObject);
    }

    private void O000000o(JSONObject jSONObject) {
        Integer integer = jSONObject.getInteger(o0ooo00oo.O00000o);
        if (integer == null) {
            O000000o("12004", "protocol is not exist null");
        } else {
            O000000o(integer.intValue(), jSONObject);
        }
    }

    private void O000000o(String str, String str2) {
        L.d(O00000Oo, "error: " + str + " errorMsg: " + str2);
        o0ooooo00 o0ooooo00 = this.O00000o0;
        if (o0ooooo00 != null) {
            o0ooooo00.O000000o(str, str2);
        }
    }

    private void O000000o(String str, byte[] bArr, String str2) {
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, 7, bArr2, 0, 4);
        System.arraycopy(bArr, 11, bArr3, 0, 4);
        int bytesToInt2 = ByteUtils.bytesToInt2(bArr2, 0);
        int bytesToInt22 = ByteUtils.bytesToInt2(bArr3, 0);
        StringBuilder n = a.n("receiveData ");
        n.append(Thread.currentThread());
        L.e(O00000Oo, n.toString());
        if (this.O000000o.O00000o() == null || !this.O000000o.O00000o().O000000o(str2, bytesToInt2, bytesToInt22)) {
            int length = bArr.length - 15;
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, 15, bArr4, 0, length);
            int crc32 = CRC32Utils.crc32(bArr4);
            byte[] bArr5 = new byte[(str.getBytes().length + 12)];
            System.arraycopy(bArr2, 0, bArr5, 0, 4);
            System.arraycopy(bArr3, 0, bArr5, 4, 4);
            byte[] intToBytes2 = ByteUtils.intToBytes2(crc32);
            System.arraycopy(intToBytes2, 0, bArr5, 8, 4);
            System.arraycopy(str.getBytes(), 0, bArr5, 12, str.getBytes().length);
            byte[] bArr6 = new byte[4];
            System.arraycopy(bArr, 3, bArr6, 0, 4);
            if (CRC32Utils.crc32(bArr5) != ByteUtils.bytesToInt2(bArr6, 0)) {
                L.e(O00000Oo, "crc32 is not equal");
                L.e(O00000Oo, "data: " + ByteUtils.bytesToHexString(bArr, ":"));
                L.e(O00000Oo, "signBt: " + ByteUtils.bytesToHexString(bArr6, ":"));
                L.e(O00000Oo, "sBt: " + ByteUtils.bytesToHexString(bArr2, ":"));
                L.e(O00000Oo, "oBt: " + ByteUtils.bytesToHexString(bArr3, ":"));
                L.e(O00000Oo, "dataCrcBt: " + ByteUtils.bytesToHexString(intToBytes2, ":"));
                L.e(O00000Oo, "localKeyBt: " + ByteUtils.bytesToHexString(str.getBytes(), ":"));
                L.e(O00000Oo, "signStr: " + ByteUtils.bytesToHexString(bArr5, ":"));
                L.e(O00000Oo, "receiveData: " + ByteUtils.bytesToHexString(bArr4, ":"));
                O000000o("12002", "mqtt1_1: signature is not match signStrBt" + CRC32Utils.crc32(bArr5) + "signBt:" + ByteUtils.bytesToInt2(bArr6, 0));
                return;
            }
            String str3 = null;
            try {
                str3 = new String(bArr4, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                L.d(O00000Oo, "string parser error");
                e2.printStackTrace();
            }
            if (TextUtils.isEmpty(str3)) {
                O000000o("12001", "dealWithDeviceTopic1_1 data parsing failure");
                return;
            }
            L.d(O00000Oo, "receiveData: " + str3);
            O000000o(JSON.parseObject(str3));
            return;
        }
        L.e(O00000Oo, "the data is dated");
        L.e(O00000Oo, "receiveData ddd" + Thread.currentThread());
        O000000o("12003", "cloud command repeat with s:" + bytesToInt2 + " o:" + bytesToInt22);
    }

    public void O000000o(o0ooooo00 o0ooooo00) {
        this.O00000o0 = o0ooooo00;
        o0oooo0oo o0oooo0oo = this.O000000o;
        O000000o(o0oooo0oo.O000000o, o0oooo0oo.O00000Oo(), this.O000000o.O000000o());
    }
}

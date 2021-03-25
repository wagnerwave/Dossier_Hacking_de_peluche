package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.ByteUtils;
import com.tuya.smart.android.common.utils.CRC32Utils;
import com.tuya.smart.android.common.utils.L;

public class oo000o000 extends oo0000o0o {
    public static final String O00000Oo = "MsgProtocol2_2";
    public o0ooooo00 O00000o0;

    public oo000o000(o0oooo0oo o0oooo0oo) {
        super(o0oooo0oo);
    }

    private void O000000o(int i, JSONObject jSONObject) {
        this.O00000o0.O000000o(i, jSONObject);
    }

    private void O000000o(JSONObject jSONObject) {
        Integer integer = jSONObject.getInteger(o0ooo00oo.O00000o);
        if (integer == null) {
            O000000o("12004", "protocol is not exist");
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
            int length = bArr.length - 7;
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, 7, bArr4, 0, length);
            byte[] bArr5 = new byte[4];
            System.arraycopy(bArr, 3, bArr5, 0, 4);
            if (CRC32Utils.crc32(bArr4) != ByteUtils.bytesToInt2(bArr5, 0)) {
                StringBuilder n2 = a.n("mqtt2_2: signature is not match signStrBt");
                n2.append(CRC32Utils.crc32(bArr4));
                n2.append("signBt:");
                n2.append(ByteUtils.bytesToInt2(bArr5, 0));
                O000000o("12002", n2.toString());
                return;
            }
            int length2 = bArr.length - 15;
            byte[] bArr6 = new byte[length2];
            System.arraycopy(bArr, 15, bArr6, 0, length2);
            String O000000o = o0ooo0o00.O000000o(bArr6, str);
            if (TextUtils.isEmpty(O000000o)) {
                O000000o("12001", "mqtt2_2: data parsing failure");
            } else {
                O000000o(JSON.parseObject(O000000o));
            }
        } else {
            StringBuilder n3 = a.n("receiveData ddd");
            n3.append(Thread.currentThread());
            L.e(O00000Oo, n3.toString());
            O000000o("12003", "cloud command repeat with s:" + bytesToInt2 + " o:" + bytesToInt22);
        }
    }

    public void O000000o(o0ooooo00 o0ooooo00) {
        this.O00000o0 = o0ooooo00;
        o0oooo0oo o0oooo0oo = this.O000000o;
        O000000o(o0oooo0oo.O000000o, o0oooo0oo.O00000Oo(), this.O000000o.O000000o());
    }
}

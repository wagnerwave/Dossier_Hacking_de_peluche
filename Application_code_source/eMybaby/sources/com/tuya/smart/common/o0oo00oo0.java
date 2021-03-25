package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.android.common.utils.AESUtil;
import com.tuya.smart.android.common.utils.CRC32Utils;
import com.tuya.smart.android.common.utils.HexUtil;
import com.tuya.smart.android.common.utils.L;
import java.nio.ByteBuffer;

public class o0oo00oo0 {
    public static final String O000000o = "MqttTransfer";
    public static final int O00000Oo = 21930;
    public static final int O00000o = 0;
    public static final int O00000o0 = 0;
    public static final int O00000oO = 1;

    public static void O000000o(String[] strArr) {
    }

    public static boolean O000000o(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length - 4)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length - 4);
        return ByteBuffer.wrap(bArr, bArr.length - 4, 4).asIntBuffer().get() == CRC32Utils.crc32(bArr2);
    }

    public static byte[] O000000o(String str, byte[] bArr) {
        L.d(O000000o, HexUtil.bytesToHexString(bArr) + " localKey: " + str);
        if (!O000000o(bArr)) {
            return null;
        }
        short s = ByteBuffer.wrap(bArr, 0, 2).asShortBuffer().get();
        short s2 = ByteBuffer.wrap(bArr, 2, 2).asShortBuffer().get();
        short s3 = ByteBuffer.wrap(bArr, 4, 2).asShortBuffer().get();
        int i = ByteBuffer.wrap(bArr, 6, 2).asShortBuffer().get();
        if (21930 == s && s2 == 0 && s3 == 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 8, bArr2, 0, i);
            String bytesToHexString = HexUtil.bytesToHexString(bArr2);
            L.d(O000000o, "original Data: " + bytesToHexString);
            byte[] O000000o2 = O000000o(bArr2, str);
            try {
                L.d(O000000o, "real Data: " + HexUtil.bytesToHexString(O000000o2));
                return O000000o2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (21930 != s || s2 != 0 || 1 != s3) {
            return null;
        } else {
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr, 8, bArr3, 0, i);
            a.v("original Data: ", HexUtil.bytesToHexString(bArr3), O000000o);
            return bArr3;
        }
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
}

package com.tuya.smart.android.common.utils;

import android.text.TextUtils;
import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.util.Formatter;

public class ByteUtils {
    public static String bytesToHexString(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("%02X", new Object[]{Byte.valueOf(bArr[0])});
        for (int i = 1; i < bArr.length; i++) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            formatter.format("%02X", new Object[]{Byte.valueOf(bArr[i])});
        }
        formatter.flush();
        formatter.close();
        return sb.toString();
    }

    public static int bytesToInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & AVFrame.FRM_STATE_UNKOWN) << 24) | (bArr[i] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[i + 1] & AVFrame.FRM_STATE_UNKOWN) << 8) | ((bArr[i + 2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH);
    }

    public static int bytesToInt2(byte[] bArr, int i) {
        return (bArr[i + 3] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[i] & AVFrame.FRM_STATE_UNKOWN) << 24) | ((bArr[i + 1] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[i + 2] & AVFrame.FRM_STATE_UNKOWN) << 8);
    }

    public static byte[] contact(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (bArr2 != null) {
                i += bArr2.length;
            }
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            if (bArr4 != null) {
                System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
                i2 += bArr4.length;
            }
        }
        return bArr3;
    }

    public static byte[] getBigEndian(long j) {
        return new byte[]{(byte) ((int) ((4278190080L & j) >> 24)), (byte) ((int) ((16711680 & j) >> 16)), (byte) ((int) ((65280 & j) >> 8)), (byte) ((int) (j & 255))};
    }

    public static byte[] intToBytes(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) ((i >> 24) & 255);
        bArr[2] = (byte) ((i >> 16) & 255);
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[0] = (byte) (i & 255);
        return bArr;
    }

    public static byte[] intToBytes2(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public long getUnsignedIntt(int i) {
        return (long) (i & -1);
    }
}

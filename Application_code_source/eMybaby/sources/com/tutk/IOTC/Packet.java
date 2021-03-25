package com.tutk.IOTC;

import com.tuya.spongycastle.math.ec.Tnaf;

public class Packet {
    public static final int byteArrayToInt_Big(byte[] bArr) {
        if (bArr.length == 1) {
            return bArr[0] & AVFrame.FRM_STATE_UNKOWN;
        }
        if (bArr.length == 2) {
            return (bArr[1] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[0] & AVFrame.FRM_STATE_UNKOWN) << 8);
        } else if (bArr.length != 4) {
            return 0;
        } else {
            return (bArr[3] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[0] & AVFrame.FRM_STATE_UNKOWN) << 24) | ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[2] & AVFrame.FRM_STATE_UNKOWN) << 8);
        }
    }

    public static final int byteArrayToInt_Little(byte[] bArr) {
        if (bArr.length == 1) {
            return bArr[0] & AVFrame.FRM_STATE_UNKOWN;
        }
        if (bArr.length == 2) {
            return ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << 8) | (bArr[0] & AVFrame.FRM_STATE_UNKOWN);
        } else if (bArr.length != 4) {
            return 0;
        } else {
            return ((bArr[3] & AVFrame.FRM_STATE_UNKOWN) << 24) | (bArr[0] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << 8) | ((bArr[2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH);
        }
    }

    public static final int byteArrayToInt_Little(byte[] bArr, int i) {
        return ((bArr[i + 3] & AVFrame.FRM_STATE_UNKOWN) << 24) | (bArr[i] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[i + 1] & AVFrame.FRM_STATE_UNKOWN) << 8) | ((bArr[i + 2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH);
    }

    public static final long byteArrayToLong_Little(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = (bArr[i + 3] & AVFrame.FRM_STATE_UNKOWN) << 24;
        return (long) (((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << 56) | i3 | (bArr[i] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << 8) | ((bArr[i + 2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << 32) | ((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << 40) | ((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << 48));
    }

    public static final short byteArrayToShort_Little(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & AVFrame.FRM_STATE_UNKOWN) << 8) | (bArr[i] & AVFrame.FRM_STATE_UNKOWN));
    }

    public static final byte[] intToByteArray_Big(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    public static final byte[] intToByteArray_Little(int i) {
        return new byte[]{(byte) i, (byte) (i >>> 8), (byte) (i >>> 16), (byte) (i >>> 24)};
    }

    public static final byte[] longToByteArray_Little(long j) {
        return new byte[]{(byte) ((int) j), (byte) ((int) (j >>> 8)), (byte) ((int) (j >>> 16)), (byte) ((int) (j >>> 24)), (byte) ((int) (j >>> 32)), (byte) ((int) (j >>> 40)), (byte) ((int) (j >>> 48)), (byte) ((int) (j >>> 56))};
    }

    public static final byte[] shortToByteArray_Big(short s) {
        return new byte[]{(byte) (s >>> 8), (byte) s};
    }

    public static final byte[] shortToByteArray_Little(short s) {
        return new byte[]{(byte) s, (byte) (s >>> 8)};
    }
}

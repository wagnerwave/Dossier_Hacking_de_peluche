package com.tuya.spongycastle.util;

import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;

public abstract class Pack {
    public static int bigEndianToInt(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] & AVFrame.FRM_STATE_UNKOWN) | (bArr[i] << 24) | ((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[i3] & AVFrame.FRM_STATE_UNKOWN) << 8);
    }

    public static void bigEndianToInt(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = bigEndianToInt(bArr, i);
            i += 4;
        }
    }

    public static long bigEndianToLong(byte[] bArr, int i) {
        int bigEndianToInt = bigEndianToInt(bArr, i);
        return (((long) bigEndianToInt(bArr, i + 4)) & 4294967295L) | ((((long) bigEndianToInt) & 4294967295L) << 32);
    }

    public static void bigEndianToLong(byte[] bArr, int i, long[] jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2] = bigEndianToLong(bArr, i);
            i += 8;
        }
    }

    public static short bigEndianToShort(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[i] & AVFrame.FRM_STATE_UNKOWN) << 8));
    }

    public static void intToBigEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static void intToBigEndian(int[] iArr, byte[] bArr, int i) {
        for (int intToBigEndian : iArr) {
            intToBigEndian(intToBigEndian, bArr, i);
            i += 4;
        }
    }

    public static byte[] intToBigEndian(int i) {
        byte[] bArr = new byte[4];
        intToBigEndian(i, bArr, 0);
        return bArr;
    }

    public static byte[] intToBigEndian(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        intToBigEndian(iArr, bArr, 0);
        return bArr;
    }

    public static void intToLittleEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    public static void intToLittleEndian(int[] iArr, byte[] bArr, int i) {
        for (int intToLittleEndian : iArr) {
            intToLittleEndian(intToLittleEndian, bArr, i);
            i += 4;
        }
    }

    public static byte[] intToLittleEndian(int i) {
        byte[] bArr = new byte[4];
        intToLittleEndian(i, bArr, 0);
        return bArr;
    }

    public static byte[] intToLittleEndian(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        intToLittleEndian(iArr, bArr, 0);
        return bArr;
    }

    public static int littleEndianToInt(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << 24) | (bArr[i] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << 8) | ((bArr[i3] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH);
    }

    public static void littleEndianToInt(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = littleEndianToInt(bArr, i);
            i += 4;
        }
    }

    public static void littleEndianToInt(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = littleEndianToInt(bArr, i);
            i += 4;
        }
    }

    public static int[] littleEndianToInt(byte[] bArr, int i, int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = littleEndianToInt(bArr, i);
            i += 4;
        }
        return iArr;
    }

    public static long littleEndianToLong(byte[] bArr, int i) {
        return ((((long) littleEndianToInt(bArr, i + 4)) & 4294967295L) << 32) | (4294967295L & ((long) littleEndianToInt(bArr, i)));
    }

    public static void littleEndianToLong(byte[] bArr, int i, long[] jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2] = littleEndianToLong(bArr, i);
            i += 8;
        }
    }

    public static void littleEndianToLong(byte[] bArr, int i, long[] jArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            jArr[i2 + i4] = littleEndianToLong(bArr, i);
            i += 8;
        }
    }

    public static short littleEndianToShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & AVFrame.FRM_STATE_UNKOWN) << 8) | (bArr[i] & AVFrame.FRM_STATE_UNKOWN));
    }

    public static void longToBigEndian(long j, byte[] bArr, int i) {
        intToBigEndian((int) (j >>> 32), bArr, i);
        intToBigEndian((int) (j & 4294967295L), bArr, i + 4);
    }

    public static void longToBigEndian(long[] jArr, byte[] bArr, int i) {
        for (long longToBigEndian : jArr) {
            longToBigEndian(longToBigEndian, bArr, i);
            i += 8;
        }
    }

    public static byte[] longToBigEndian(long j) {
        byte[] bArr = new byte[8];
        longToBigEndian(j, bArr, 0);
        return bArr;
    }

    public static byte[] longToBigEndian(long[] jArr) {
        byte[] bArr = new byte[(jArr.length * 8)];
        longToBigEndian(jArr, bArr, 0);
        return bArr;
    }

    public static void longToLittleEndian(long j, byte[] bArr, int i) {
        intToLittleEndian((int) (4294967295L & j), bArr, i);
        intToLittleEndian((int) (j >>> 32), bArr, i + 4);
    }

    public static void longToLittleEndian(long[] jArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            longToLittleEndian(jArr[i + i4], bArr, i3);
            i3 += 8;
        }
    }

    public static void longToLittleEndian(long[] jArr, byte[] bArr, int i) {
        for (long longToLittleEndian : jArr) {
            longToLittleEndian(longToLittleEndian, bArr, i);
            i += 8;
        }
    }

    public static byte[] longToLittleEndian(long j) {
        byte[] bArr = new byte[8];
        longToLittleEndian(j, bArr, 0);
        return bArr;
    }

    public static byte[] longToLittleEndian(long[] jArr) {
        byte[] bArr = new byte[(jArr.length * 8)];
        longToLittleEndian(jArr, bArr, 0);
        return bArr;
    }

    public static void shortToLittleEndian(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
        bArr[i + 1] = (byte) (s >>> 8);
    }

    public static byte[] shortToLittleEndian(short s) {
        byte[] bArr = new byte[2];
        shortToLittleEndian(s, bArr, 0);
        return bArr;
    }
}

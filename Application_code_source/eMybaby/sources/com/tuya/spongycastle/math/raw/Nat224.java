package com.tuya.spongycastle.math.raw;

import a.a.a.a.a;
import com.tuya.spongycastle.util.Pack;
import java.math.BigInteger;

public abstract class Nat224 {
    public static final long M = 4294967295L;

    public static int add(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i2 + 0]) & 4294967295L) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i2 + 1]) & 4294967295L) + (j >>> 32);
        iArr3[i3 + 1] = (int) j2;
        long j3 = (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i2 + 2]) & 4294967295L) + (j2 >>> 32);
        iArr3[i3 + 2] = (int) j3;
        long j4 = (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i2 + 3]) & 4294967295L) + (j3 >>> 32);
        iArr3[i3 + 3] = (int) j4;
        long j5 = (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i2 + 4]) & 4294967295L) + (j4 >>> 32);
        iArr3[i3 + 4] = (int) j5;
        long j6 = (((long) iArr[i + 5]) & 4294967295L) + (((long) iArr2[i2 + 5]) & 4294967295L) + (j5 >>> 32);
        iArr3[i3 + 5] = (int) j6;
        long j7 = (((long) iArr[i + 6]) & 4294967295L) + (((long) iArr2[i2 + 6]) & 4294967295L) + (j6 >>> 32);
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (j5 >>> 32);
        iArr3[5] = (int) j6;
        long j7 = (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (j6 >>> 32);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        int i4 = i3 + 0;
        long j = (((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i2 + 0]) & 4294967295L) + (((long) iArr3[i4]) & 4294967295L) + 0;
        iArr3[i4] = (int) j;
        int i5 = i3 + 1;
        long j2 = (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i2 + 1]) & 4294967295L) + (((long) iArr3[i5]) & 4294967295L) + (j >>> 32);
        iArr3[i5] = (int) j2;
        int i6 = i3 + 2;
        long j3 = (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i2 + 2]) & 4294967295L) + (((long) iArr3[i6]) & 4294967295L) + (j2 >>> 32);
        iArr3[i6] = (int) j3;
        int i7 = i3 + 3;
        long j4 = (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i2 + 3]) & 4294967295L) + (((long) iArr3[i7]) & 4294967295L) + (j3 >>> 32);
        iArr3[i7] = (int) j4;
        int i8 = i3 + 4;
        long j5 = (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i2 + 4]) & 4294967295L) + (((long) iArr3[i8]) & 4294967295L) + (j4 >>> 32);
        iArr3[i8] = (int) j5;
        int i9 = i3 + 5;
        long j6 = (((long) iArr[i + 5]) & 4294967295L) + (((long) iArr2[i2 + 5]) & 4294967295L) + (((long) iArr3[i9]) & 4294967295L) + (j5 >>> 32);
        iArr3[i9] = (int) j6;
        int i10 = i3 + 6;
        long j7 = (((long) iArr[i + 6]) & 4294967295L) + (((long) iArr2[i2 + 6]) & 4294967295L) + (((long) iArr3[i10]) & 4294967295L) + (j6 >>> 32);
        iArr3[i10] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L) + (j5 >>> 32);
        iArr3[5] = (int) j6;
        long j7 = (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (((long) iArr3[6]) & 4294967295L) + (j6 >>> 32);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i2 + 0;
        long j = (((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L) + (((long) i3) & 4294967295L);
        iArr2[i4] = (int) j;
        int i5 = i2 + 1;
        long j2 = (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i5]) & 4294967295L) + (j >>> 32);
        iArr2[i5] = (int) j2;
        int i6 = i2 + 2;
        long j3 = (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L) + (j2 >>> 32);
        iArr2[i6] = (int) j3;
        int i7 = i2 + 3;
        long j4 = (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L) + (j3 >>> 32);
        iArr2[i7] = (int) j4;
        int i8 = i2 + 4;
        long j5 = (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i8]) & 4294967295L) + (j4 >>> 32);
        iArr2[i8] = (int) j5;
        int i9 = i2 + 5;
        long j6 = (((long) iArr[i + 5]) & 4294967295L) + (((long) iArr2[i9]) & 4294967295L) + (j5 >>> 32);
        iArr2[i9] = (int) j6;
        int i10 = i2 + 6;
        long j7 = (((long) iArr[i + 6]) & 4294967295L) + (4294967295L & ((long) iArr2[i10])) + (j6 >>> 32);
        iArr2[i10] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j;
        long j2 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (j >>> 32);
        iArr2[1] = (int) j2;
        long j3 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (j2 >>> 32);
        iArr2[2] = (int) j3;
        long j4 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (j3 >>> 32);
        iArr2[3] = (int) j4;
        long j5 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (j4 >>> 32);
        iArr2[4] = (int) j5;
        long j6 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (j5 >>> 32);
        iArr2[5] = (int) j6;
        long j7 = (((long) iArr[6]) & 4294967295L) + (4294967295L & ((long) iArr2[6])) + (j6 >>> 32);
        iArr2[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = (((long) iArr[i3]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        int i6 = i + 1;
        int i7 = i2 + 1;
        long j2 = (((long) iArr[i6]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L) + (j >>> 32);
        int i8 = (int) j2;
        iArr[i6] = i8;
        iArr2[i7] = i8;
        int i9 = i + 2;
        int i10 = i2 + 2;
        long j3 = (((long) iArr[i9]) & 4294967295L) + (((long) iArr2[i10]) & 4294967295L) + (j2 >>> 32);
        int i11 = (int) j3;
        iArr[i9] = i11;
        iArr2[i10] = i11;
        int i12 = i + 3;
        int i13 = i2 + 3;
        long j4 = (((long) iArr[i12]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L) + (j3 >>> 32);
        int i14 = (int) j4;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i + 4;
        int i16 = i2 + 4;
        long j5 = (((long) iArr[i15]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L) + (j4 >>> 32);
        int i17 = (int) j5;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i + 5;
        int i19 = i2 + 5;
        long j6 = (((long) iArr[i18]) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L) + (j5 >>> 32);
        int i20 = (int) j6;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        int i21 = i + 6;
        int i22 = i2 + 6;
        long j7 = (((long) iArr[i21]) & 4294967295L) + (4294967295L & ((long) iArr2[i22])) + (j6 >>> 32);
        int i23 = (int) j7;
        iArr[i21] = i23;
        iArr2[i22] = i23;
        return (int) (j7 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int[] create() {
        return new int[7];
    }

    public static int[] createExt() {
        return new int[14];
    }

    public static boolean diff(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean gte = gte(iArr, i, iArr2, i2);
        if (gte) {
            sub(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            sub(iArr2, i2, iArr, i, iArr3, i3);
        }
        return gte;
    }

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        int i = 0;
        while (bigInteger.signum() != 0) {
            create[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return create;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 7) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 6; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & 4294967295L;
        long j2 = ((long) iArr2[i2 + 1]) & 4294967295L;
        long j3 = ((long) iArr2[i2 + 2]) & 4294967295L;
        long j4 = ((long) iArr2[i2 + 3]) & 4294967295L;
        long j5 = ((long) iArr2[i2 + 4]) & 4294967295L;
        long j6 = ((long) iArr2[i2 + 5]) & 4294967295L;
        long j7 = ((long) iArr2[i2 + 6]) & 4294967295L;
        long j8 = ((long) iArr[i + 0]) & 4294967295L;
        long j9 = (j8 * j) + 0;
        long j10 = j;
        iArr3[i3 + 0] = (int) j9;
        long j11 = (j8 * j2) + (j9 >>> 32);
        long j12 = j2;
        iArr3[i3 + 1] = (int) j11;
        long j13 = (j8 * j3) + (j11 >>> 32);
        iArr3[i3 + 2] = (int) j13;
        long j14 = (j8 * j4) + (j13 >>> 32);
        iArr3[i3 + 3] = (int) j14;
        long j15 = (j8 * j5) + (j14 >>> 32);
        iArr3[i3 + 4] = (int) j15;
        long j16 = (j8 * j6) + (j15 >>> 32);
        iArr3[i3 + 5] = (int) j16;
        long j17 = (j8 * j7) + (j16 >>> 32);
        iArr3[i3 + 6] = (int) j17;
        iArr3[i3 + 7] = (int) (j17 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 7) {
            i5 += i4;
            long j18 = ((long) iArr[i + i6]) & 4294967295L;
            int i7 = i5 + 0;
            long j19 = (j18 * j10) + (((long) iArr3[i7]) & 4294967295L) + 0;
            iArr3[i7] = (int) j19;
            int i8 = i5 + 1;
            long j20 = j6;
            long j21 = (j18 * j12) + (((long) iArr3[i8]) & 4294967295L) + (j19 >>> 32);
            iArr3[i8] = (int) j21;
            int i9 = i5 + 2;
            long j22 = j3;
            long j23 = (j18 * j3) + (((long) iArr3[i9]) & 4294967295L) + (j21 >>> 32);
            iArr3[i9] = (int) j23;
            int i10 = i5 + 3;
            long j24 = (j18 * j4) + (((long) iArr3[i10]) & 4294967295L) + (j23 >>> 32);
            iArr3[i10] = (int) j24;
            int i11 = i5 + 4;
            long j25 = (j18 * j5) + (((long) iArr3[i11]) & 4294967295L) + (j24 >>> 32);
            iArr3[i11] = (int) j25;
            int i12 = i5 + 5;
            long j26 = (j18 * j20) + (((long) iArr3[i12]) & 4294967295L) + (j25 >>> 32);
            iArr3[i12] = (int) j26;
            int i13 = i5 + 6;
            long j27 = (j18 * j7) + (((long) iArr3[i13]) & 4294967295L) + (j26 >>> 32);
            iArr3[i13] = (int) j27;
            iArr3[i5 + 7] = (int) (j27 >>> 32);
            i6++;
            j6 = j20;
            j3 = j22;
            i4 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[4]) & 4294967295L;
        long j5 = ((long) iArr2[2]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = ((long) iArr[0]) & 4294967295L;
        long j9 = (j8 * j) + 0;
        iArr3[0] = (int) j9;
        long j10 = (j8 * j2) + (j9 >>> 32);
        iArr3[1] = (int) j10;
        long j11 = (j8 * j5) + (j10 >>> 32);
        iArr3[2] = (int) j11;
        long j12 = (j8 * j3) + (j11 >>> 32);
        iArr3[3] = (int) j12;
        long j13 = (j8 * j4) + (j12 >>> 32);
        iArr3[4] = (int) j13;
        long j14 = (j8 * j6) + (j13 >>> 32);
        iArr3[5] = (int) j14;
        long j15 = (j8 * j7) + (j14 >>> 32);
        iArr3[6] = (int) j15;
        iArr3[7] = (int) (j15 >>> 32);
        int i = 1;
        for (int i2 = 7; i < i2; i2 = 7) {
            long j16 = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j17 = j;
            long j18 = (j16 * j) + (((long) iArr3[i3]) & 4294967295L) + 0;
            iArr3[i3] = (int) j18;
            int i4 = i + 1;
            long j19 = j2;
            long j20 = (j16 * j2) + (((long) iArr3[i4]) & 4294967295L) + (j18 >>> 32);
            iArr3[i4] = (int) j20;
            long j21 = j20 >>> 32;
            int i5 = i + 2;
            long j22 = (j16 * j5) + (((long) iArr3[i5]) & 4294967295L) + j21;
            iArr3[i5] = (int) j22;
            long j23 = j22 >>> 32;
            int i6 = i + 3;
            long j24 = (j16 * j3) + (((long) iArr3[i6]) & 4294967295L) + j23;
            iArr3[i6] = (int) j24;
            long j25 = j24 >>> 32;
            int i7 = i + 4;
            long j26 = (j16 * j4) + (((long) iArr3[i7]) & 4294967295L) + j25;
            iArr3[i7] = (int) j26;
            long j27 = j26 >>> 32;
            int i8 = i + 5;
            long j28 = (j16 * j6) + (((long) iArr3[i8]) & 4294967295L) + j27;
            iArr3[i8] = (int) j28;
            long j29 = j28 >>> 32;
            int i9 = i + 6;
            long j30 = (j16 * j7) + (((long) iArr3[i9]) & 4294967295L) + j29;
            iArr3[i9] = (int) j30;
            iArr3[i + 7] = (int) (j30 >>> 32);
            i = i4;
            j = j17;
            j2 = j19;
        }
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((long) iArr[i2 + 0]) & 4294967295L;
        long j3 = (j * j2) + (((long) iArr2[i3 + 0]) & 4294967295L) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & 4294967295L;
        long j5 = (j * j4) + j2 + (((long) iArr2[i3 + 1]) & 4294967295L) + (j3 >>> 32);
        iArr3[i4 + 1] = (int) j5;
        long j6 = ((long) iArr[i2 + 2]) & 4294967295L;
        long j7 = (j * j6) + j4 + (((long) iArr2[i3 + 2]) & 4294967295L) + (j5 >>> 32);
        iArr3[i4 + 2] = (int) j7;
        long j8 = ((long) iArr[i2 + 3]) & 4294967295L;
        long j9 = (j * j8) + j6 + (((long) iArr2[i3 + 3]) & 4294967295L) + (j7 >>> 32);
        iArr3[i4 + 3] = (int) j9;
        long j10 = ((long) iArr[i2 + 4]) & 4294967295L;
        long j11 = (j * j10) + j8 + (((long) iArr2[i3 + 4]) & 4294967295L) + (j9 >>> 32);
        iArr3[i4 + 4] = (int) j11;
        long j12 = ((long) iArr[i2 + 5]) & 4294967295L;
        long j13 = (j * j12) + j10 + (((long) iArr2[i3 + 5]) & 4294967295L) + (j11 >>> 32);
        iArr3[i4 + 5] = (int) j13;
        long j14 = ((long) iArr[i2 + 6]) & 4294967295L;
        long j15 = (j * j14) + j12 + (4294967295L & ((long) iArr2[i3 + 6])) + (j13 >>> 32);
        iArr3[i4 + 6] = (int) j15;
        return (j15 >>> 32) + j14;
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        int[] iArr2 = iArr;
        int i3 = i2;
        long j2 = ((long) i) & 4294967295L;
        long j3 = j & 4294967295L;
        int i4 = i3 + 0;
        long j4 = (j2 * j3) + (((long) iArr2[i4]) & 4294967295L) + 0;
        iArr2[i4] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i5 = i3 + 1;
        long j7 = j6 + (((long) iArr2[i5]) & 4294967295L) + (j4 >>> 32);
        iArr2[i5] = (int) j7;
        int i6 = i3 + 2;
        long j8 = j5 + (((long) iArr2[i6]) & 4294967295L) + (j7 >>> 32);
        iArr2[i6] = (int) j8;
        int i7 = i3 + 3;
        long j9 = (j8 >>> 32) + (4294967295L & ((long) iArr2[i7]));
        iArr2[i7] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr2, i3, 4);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((long) i2) & 4294967295L;
        int i4 = i3 + 0;
        long j2 = ((((long) i) & 4294967295L) * j) + (((long) iArr[i4]) & 4294967295L) + 0;
        iArr[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = j + (((long) iArr[i5]) & 4294967295L) + (j2 >>> 32);
        iArr[i5] = (int) j3;
        int i6 = i3 + 2;
        long j4 = (j3 >>> 32) + (4294967295L & ((long) iArr[i6]));
        iArr[i6] = (int) j4;
        if ((j4 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & 4294967295L;
        long j2 = ((long) iArr2[i2 + 1]) & 4294967295L;
        long j3 = ((long) iArr2[i2 + 2]) & 4294967295L;
        long j4 = ((long) iArr2[i2 + 3]) & 4294967295L;
        long j5 = ((long) iArr2[i2 + 4]) & 4294967295L;
        long j6 = ((long) iArr2[i2 + 5]) & 4294967295L;
        long j7 = ((long) iArr2[i2 + 6]) & 4294967295L;
        int i4 = i3;
        long j8 = 0;
        int i5 = 0;
        while (i5 < 7) {
            int i6 = i5;
            long j9 = ((long) iArr[i + i5]) & 4294967295L;
            int i7 = i4 + 0;
            long j10 = j;
            long j11 = (j9 * j) + (((long) iArr3[i7]) & 4294967295L) + 0;
            long j12 = j7;
            iArr3[i7] = (int) j11;
            int i8 = i4 + 1;
            long j13 = (j9 * j2) + (((long) iArr3[i8]) & 4294967295L) + (j11 >>> 32);
            iArr3[i8] = (int) j13;
            int i9 = i4 + 2;
            long j14 = (j9 * j3) + (((long) iArr3[i9]) & 4294967295L) + (j13 >>> 32);
            iArr3[i9] = (int) j14;
            int i10 = i4 + 3;
            long j15 = (j9 * j4) + (((long) iArr3[i10]) & 4294967295L) + (j14 >>> 32);
            iArr3[i10] = (int) j15;
            int i11 = i4 + 4;
            long j16 = (j9 * j5) + (((long) iArr3[i11]) & 4294967295L) + (j15 >>> 32);
            iArr3[i11] = (int) j16;
            int i12 = i4 + 5;
            long j17 = (j9 * j6) + (((long) iArr3[i12]) & 4294967295L) + (j16 >>> 32);
            iArr3[i12] = (int) j17;
            int i13 = i4 + 6;
            long j18 = (j9 * j12) + (((long) iArr3[i13]) & 4294967295L) + (j17 >>> 32);
            iArr3[i13] = (int) j18;
            int i14 = i4 + 7;
            long j19 = j8 + (((long) iArr3[i14]) & 4294967295L) + (j18 >>> 32);
            iArr3[i14] = (int) j19;
            j8 = j19 >>> 32;
            i5 = i6 + 1;
            i4 = i8;
            j7 = j12;
            j = j10;
            j3 = j3;
            j2 = j2;
        }
        return (int) j8;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[1]) & 4294967295L;
        long j2 = ((long) iArr2[2]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[4]) & 4294967295L;
        long j5 = ((long) iArr2[5]) & 4294967295L;
        long j6 = ((long) iArr2[0]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = 0;
        int i = 0;
        while (i < 7) {
            long j9 = j7;
            long j10 = ((long) iArr[i]) & 4294967295L;
            int i2 = i + 0;
            long j11 = j5;
            long j12 = (j10 * j6) + (((long) iArr3[i2]) & 4294967295L) + 0;
            iArr3[i2] = (int) j12;
            int i3 = i + 1;
            long j13 = j;
            long j14 = (j10 * j) + (((long) iArr3[i3]) & 4294967295L) + (j12 >>> 32);
            iArr3[i3] = (int) j14;
            int i4 = i + 2;
            long j15 = (j10 * j2) + (((long) iArr3[i4]) & 4294967295L) + (j14 >>> 32);
            iArr3[i4] = (int) j15;
            int i5 = i + 3;
            long j16 = (j10 * j3) + (((long) iArr3[i5]) & 4294967295L) + (j15 >>> 32);
            iArr3[i5] = (int) j16;
            int i6 = i + 4;
            long j17 = (j10 * j4) + (((long) iArr3[i6]) & 4294967295L) + (j16 >>> 32);
            iArr3[i6] = (int) j17;
            int i7 = i + 5;
            long j18 = (j10 * j11) + (((long) iArr3[i7]) & 4294967295L) + (j17 >>> 32);
            iArr3[i7] = (int) j18;
            int i8 = i + 6;
            long j19 = (j10 * j9) + (((long) iArr3[i8]) & 4294967295L) + (j18 >>> 32);
            iArr3[i8] = (int) j19;
            int i9 = i + 7;
            long j20 = j8 + (((long) iArr3[i9]) & 4294967295L) + (j19 >>> 32);
            iArr3[i9] = (int) j20;
            j8 = j20 >>> 32;
            i = i3;
            j7 = j9;
            j5 = j11;
            j2 = j2;
            j = j13;
        }
        return (int) j8;
    }

    public static int mulByWord(int i, int[] iArr) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((((long) iArr[0]) & 4294967295L) * j) + 0;
        iArr[0] = (int) j2;
        long j3 = ((((long) iArr[1]) & 4294967295L) * j) + (j2 >>> 32);
        iArr[1] = (int) j3;
        long j4 = ((((long) iArr[2]) & 4294967295L) * j) + (j3 >>> 32);
        iArr[2] = (int) j4;
        long j5 = ((((long) iArr[3]) & 4294967295L) * j) + (j4 >>> 32);
        iArr[3] = (int) j5;
        long j6 = ((((long) iArr[4]) & 4294967295L) * j) + (j5 >>> 32);
        iArr[4] = (int) j6;
        long j7 = ((((long) iArr[5]) & 4294967295L) * j) + (j6 >>> 32);
        iArr[5] = (int) j7;
        long j8 = (j * (4294967295L & ((long) iArr[6]))) + (j7 >>> 32);
        iArr[6] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulByWordAddTo(int i, int[] iArr, int[] iArr2) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((((long) iArr2[0]) & 4294967295L) * j) + (((long) iArr[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j2;
        long j3 = ((((long) iArr2[1]) & 4294967295L) * j) + (((long) iArr[1]) & 4294967295L) + (j2 >>> 32);
        iArr2[1] = (int) j3;
        long j4 = ((((long) iArr2[2]) & 4294967295L) * j) + (((long) iArr[2]) & 4294967295L) + (j3 >>> 32);
        iArr2[2] = (int) j4;
        long j5 = ((((long) iArr2[3]) & 4294967295L) * j) + (((long) iArr[3]) & 4294967295L) + (j4 >>> 32);
        iArr2[3] = (int) j5;
        long j6 = ((((long) iArr2[4]) & 4294967295L) * j) + (((long) iArr[4]) & 4294967295L) + (j5 >>> 32);
        iArr2[4] = (int) j6;
        long j7 = ((((long) iArr2[5]) & 4294967295L) * j) + (((long) iArr[5]) & 4294967295L) + (j6 >>> 32);
        iArr2[5] = (int) j7;
        long j8 = (j * (((long) iArr2[6]) & 4294967295L)) + (4294967295L & ((long) iArr[6])) + (j7 >>> 32);
        iArr2[6] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = ((long) i) & 4294967295L;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = ((((long) iArr[i3]) & 4294967295L) * j) + j2;
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 7);
        return (int) j2;
    }

    public static int mulWordAddTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) i) & 4294967295L;
        int i4 = i3 + 0;
        long j2 = ((((long) iArr[i2 + 0]) & 4294967295L) * j) + (((long) iArr2[i4]) & 4294967295L) + 0;
        iArr2[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = ((((long) iArr[i2 + 1]) & 4294967295L) * j) + (((long) iArr2[i5]) & 4294967295L) + (j2 >>> 32);
        iArr2[i5] = (int) j3;
        int i6 = i3 + 2;
        long j4 = ((((long) iArr[i2 + 2]) & 4294967295L) * j) + (((long) iArr2[i6]) & 4294967295L) + (j3 >>> 32);
        iArr2[i6] = (int) j4;
        int i7 = i3 + 3;
        long j5 = ((((long) iArr[i2 + 3]) & 4294967295L) * j) + (((long) iArr2[i7]) & 4294967295L) + (j4 >>> 32);
        iArr2[i7] = (int) j5;
        int i8 = i3 + 4;
        long j6 = ((((long) iArr[i2 + 4]) & 4294967295L) * j) + (((long) iArr2[i8]) & 4294967295L) + (j5 >>> 32);
        iArr2[i8] = (int) j6;
        int i9 = i3 + 5;
        long j7 = ((((long) iArr[i2 + 5]) & 4294967295L) * j) + (((long) iArr2[i9]) & 4294967295L) + (j6 >>> 32);
        iArr2[i9] = (int) j7;
        int i10 = i3 + 6;
        long j8 = (j * (((long) iArr[i2 + 6]) & 4294967295L)) + (((long) iArr2[i10]) & 4294967295L) + (j7 >>> 32);
        iArr2[i10] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & 4294967295L;
        int i3 = i2 + 0;
        long j3 = ((j & 4294967295L) * j2) + (((long) iArr[i3]) & 4294967295L) + 0;
        iArr[i3] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i4 = i2 + 1;
        long j5 = j4 + (((long) iArr[i4]) & 4294967295L) + (j3 >>> 32);
        iArr[i4] = (int) j5;
        long j6 = j5 >>> 32;
        int i5 = i2 + 2;
        long j7 = j6 + (4294967295L & ((long) iArr[i5]));
        iArr[i5] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr, i2, 3);
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i + 0]) & 4294967295L;
        int i3 = 0;
        int i4 = 14;
        int i5 = 6;
        while (true) {
            int i6 = i5 - 1;
            long j2 = ((long) iArr[i + i5]) & 4294967295L;
            long j3 = j2 * j2;
            int i7 = i4 - 1;
            iArr2[i2 + i7] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 = i7 - 1;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                iArr2[i2 + 0] = (int) j4;
                long j5 = ((long) iArr[i + 1]) & 4294967295L;
                int i8 = i2 + 2;
                long j6 = (j5 * j) + ((((long) (i3 << 31)) & 4294967295L) | (j4 >>> 33));
                int i9 = (int) j6;
                iArr2[i2 + 1] = (((int) (j4 >>> 32)) & 1) | (i9 << 1);
                int i10 = i9 >>> 31;
                long j7 = (((long) iArr2[i8]) & 4294967295L) + (j6 >>> 32);
                long j8 = ((long) iArr[i + 2]) & 4294967295L;
                int i11 = i2 + 3;
                long j9 = ((long) iArr2[i11]) & 4294967295L;
                int i12 = i2 + 4;
                long j10 = ((long) iArr2[i12]) & 4294967295L;
                long j11 = (j8 * j) + j7;
                int i13 = (int) j11;
                iArr2[i8] = i10 | (i13 << 1);
                int i14 = i13 >>> 31;
                long w = a.w(j8, j5, j11 >>> 32, j9);
                long j12 = j10 + (w >>> 32);
                long j13 = ((long) iArr[i + 3]) & 4294967295L;
                int i15 = i2 + 5;
                long j14 = (((long) iArr2[i15]) & 4294967295L) + (j12 >>> 32);
                long j15 = j12 & 4294967295L;
                int i16 = i2 + 6;
                long j16 = j8;
                int i17 = i15;
                long j17 = (((long) iArr2[i16]) & 4294967295L) + (j14 >>> 32);
                long j18 = (j13 * j) + (w & 4294967295L);
                int i18 = (int) j18;
                iArr2[i11] = i14 | (i18 << 1);
                int i19 = i18 >>> 31;
                long w2 = a.w(j13, j5, j18 >>> 32, j15);
                long w3 = a.w(j13, j16, w2 >>> 32, j14 & 4294967295L);
                long j19 = j17 + (w3 >>> 32);
                long j20 = w3 & 4294967295L;
                long j21 = ((long) iArr[i + 4]) & 4294967295L;
                int i20 = i2 + 7;
                long j22 = (((long) iArr2[i20]) & 4294967295L) + (j19 >>> 32);
                long j23 = j19 & 4294967295L;
                int i21 = i2 + 8;
                int i22 = i21;
                long j24 = (((long) iArr2[i21]) & 4294967295L) + (j22 >>> 32);
                long j25 = j22 & 4294967295L;
                long j26 = (j21 * j) + (w2 & 4294967295L);
                int i23 = (int) j26;
                iArr2[i12] = (i23 << 1) | i19;
                long w4 = a.w(j21, j5, j26 >>> 32, j20);
                long w5 = a.w(j21, j16, w4 >>> 32, j23);
                long j27 = j13;
                long w6 = a.w(j21, j27, w5 >>> 32, j25);
                long j28 = w5 & 4294967295L;
                long j29 = j24 + (w6 >>> 32);
                long j30 = ((long) iArr[i + 5]) & 4294967295L;
                int i24 = i2 + 9;
                long j31 = (((long) iArr2[i24]) & 4294967295L) + (j29 >>> 32);
                long j32 = j29 & 4294967295L;
                int i25 = i2 + 10;
                int i26 = i25;
                long j33 = (((long) iArr2[i25]) & 4294967295L) + (j31 >>> 32);
                long j34 = j31 & 4294967295L;
                long j35 = (j30 * j) + (w4 & 4294967295L);
                int i27 = (int) j35;
                iArr2[i17] = (i23 >>> 31) | (i27 << 1);
                int i28 = i27 >>> 31;
                long w7 = a.w(j30, j5, j35 >>> 32, j28);
                long w8 = a.w(j30, j16, w7 >>> 32, w6 & 4294967295L);
                long j36 = j30;
                long w9 = a.w(j36, j27, w8 >>> 32, j32);
                long j37 = w8 & 4294967295L;
                long w10 = a.w(j36, j21, w9 >>> 32, j34);
                long j38 = j33 + (w10 >>> 32);
                long j39 = w10 & 4294967295L;
                long j40 = ((long) iArr[i + 6]) & 4294967295L;
                int i29 = i2 + 11;
                long j41 = (((long) iArr2[i29]) & 4294967295L) + (j38 >>> 32);
                int i30 = i2 + 12;
                int i31 = i20;
                long j42 = (((long) iArr2[i30]) & 4294967295L) + (j41 >>> 32);
                long j43 = j41 & 4294967295L;
                long j44 = (j * j40) + (w7 & 4294967295L);
                int i32 = (int) j44;
                iArr2[i16] = i28 | (i32 << 1);
                int i33 = i32 >>> 31;
                long w11 = a.w(j40, j5, j44 >>> 32, j37);
                long w12 = a.w(j40, j16, w11 >>> 32, w9 & 4294967295L);
                long j45 = j40;
                long w13 = a.w(j45, j13, w12 >>> 32, j39);
                long w14 = a.w(j45, j21, w13 >>> 32, j38 & 4294967295L);
                long w15 = a.w(j40, j30, w14 >>> 32, j43);
                long j46 = j42 + (w15 >>> 32);
                int i34 = (int) w11;
                iArr2[i31] = (i34 << 1) | i33;
                int i35 = i34 >>> 31;
                int i36 = (int) w12;
                iArr2[i22] = i35 | (i36 << 1);
                int i37 = i36 >>> 31;
                int i38 = (int) w13;
                iArr2[i24] = i37 | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = (int) w14;
                iArr2[i26] = i39 | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = (int) w15;
                iArr2[i29] = i41 | (i42 << 1);
                int i43 = i42 >>> 31;
                int i44 = (int) j46;
                iArr2[i30] = i43 | (i44 << 1);
                int i45 = i44 >>> 31;
                int i46 = i2 + 13;
                iArr2[i46] = i45 | ((iArr2[i46] + ((int) (j46 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 14;
        int i2 = 6;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2]) & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                iArr2[0] = (int) j4;
                long j5 = ((long) iArr[1]) & 4294967295L;
                long j6 = (j5 * j) + ((((long) (i6 << 31)) & 4294967295L) | (j4 >>> 33));
                int i7 = (int) j6;
                iArr2[1] = (((int) (j4 >>> 32)) & 1) | (i7 << 1);
                int i8 = i7 >>> 31;
                long j7 = (((long) iArr2[2]) & 4294967295L) + (j6 >>> 32);
                long j8 = ((long) iArr[2]) & 4294967295L;
                long j9 = ((long) iArr2[3]) & 4294967295L;
                long j10 = ((long) iArr2[4]) & 4294967295L;
                long j11 = (j8 * j) + j7;
                int i9 = (int) j11;
                iArr2[2] = i8 | (i9 << 1);
                int i10 = i9 >>> 31;
                long w = a.w(j8, j5, j11 >>> 32, j9);
                long j12 = j10 + (w >>> 32);
                long j13 = ((long) iArr[3]) & 4294967295L;
                long j14 = (((long) iArr2[5]) & 4294967295L) + (j12 >>> 32);
                long j15 = j12 & 4294967295L;
                long j16 = j8;
                long j17 = (((long) iArr2[6]) & 4294967295L) + (j14 >>> 32);
                long j18 = j14 & 4294967295L;
                long j19 = (j13 * j) + (w & 4294967295L);
                int i11 = (int) j19;
                iArr2[3] = i10 | (i11 << 1);
                long w2 = a.w(j13, j5, j19 >>> 32, j15);
                long w3 = a.w(j13, j16, w2 >>> 32, j18);
                long j20 = j17 + (w3 >>> 32);
                long j21 = w3 & 4294967295L;
                long j22 = ((long) iArr[4]) & 4294967295L;
                long j23 = (((long) iArr2[7]) & 4294967295L) + (j20 >>> 32);
                long j24 = j20 & 4294967295L;
                long j25 = (((long) iArr2[8]) & 4294967295L) + (j23 >>> 32);
                long j26 = j23 & 4294967295L;
                long j27 = (j22 * j) + (w2 & 4294967295L);
                int i12 = (int) j27;
                iArr2[4] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                long w4 = a.w(j22, j5, j27 >>> 32, j21);
                long w5 = a.w(j22, j16, w4 >>> 32, j24);
                long j28 = j13;
                long w6 = a.w(j22, j28, w5 >>> 32, j26);
                long j29 = w5 & 4294967295L;
                long j30 = j25 + (w6 >>> 32);
                long j31 = ((long) iArr[5]) & 4294967295L;
                long j32 = (((long) iArr2[9]) & 4294967295L) + (j30 >>> 32);
                long j33 = j30 & 4294967295L;
                long j34 = (((long) iArr2[10]) & 4294967295L) + (j32 >>> 32);
                long j35 = j32 & 4294967295L;
                long j36 = (j31 * j) + (w4 & 4294967295L);
                int i14 = (int) j36;
                iArr2[5] = i13 | (i14 << 1);
                int i15 = i14 >>> 31;
                long w7 = a.w(j31, j5, j36 >>> 32, j29);
                long w8 = a.w(j31, j16, w7 >>> 32, w6 & 4294967295L);
                long w9 = a.w(j31, j28, w8 >>> 32, j33);
                long j37 = w8 & 4294967295L;
                long w10 = a.w(j31, j22, w9 >>> 32, j35);
                long j38 = j34 + (w10 >>> 32);
                long j39 = w10 & 4294967295L;
                long j40 = ((long) iArr[6]) & 4294967295L;
                long j41 = (((long) iArr2[11]) & 4294967295L) + (j38 >>> 32);
                long j42 = (((long) iArr2[12]) & 4294967295L) + (j41 >>> 32);
                long j43 = 4294967295L & j41;
                long j44 = (j * j40) + (w7 & 4294967295L);
                int i16 = (int) j44;
                iArr2[6] = i15 | (i16 << 1);
                int i17 = i16 >>> 31;
                long w11 = a.w(j40, j5, j44 >>> 32, j37);
                long w12 = a.w(j40, j16, w11 >>> 32, w9 & 4294967295L);
                long w13 = a.w(j40, j13, w12 >>> 32, j39);
                long w14 = a.w(j40, j22, w13 >>> 32, j38 & 4294967295L);
                long w15 = a.w(j40, j31, w14 >>> 32, j43);
                long j45 = j42 + (w15 >>> 32);
                int i18 = (int) w11;
                iArr2[7] = (i18 << 1) | i17;
                int i19 = (int) w12;
                iArr2[8] = (i18 >>> 31) | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) w13;
                iArr2[9] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) w14;
                iArr2[10] = i22 | (i23 << 1);
                int i24 = i23 >>> 31;
                int i25 = (int) w15;
                iArr2[11] = i24 | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) j45;
                iArr2[12] = i26 | (i27 << 1);
                iArr2[13] = (i27 >>> 31) | ((iArr2[13] + ((int) (j45 >>> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & 4294967295L) - (((long) iArr2[i2 + 0]) & 4294967295L)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = ((((long) iArr[i + 1]) & 4294967295L) - (((long) iArr2[i2 + 1]) & 4294967295L)) + (j >> 32);
        iArr3[i3 + 1] = (int) j2;
        long j3 = ((((long) iArr[i + 2]) & 4294967295L) - (((long) iArr2[i2 + 2]) & 4294967295L)) + (j2 >> 32);
        iArr3[i3 + 2] = (int) j3;
        long j4 = ((((long) iArr[i + 3]) & 4294967295L) - (((long) iArr2[i2 + 3]) & 4294967295L)) + (j3 >> 32);
        iArr3[i3 + 3] = (int) j4;
        long j5 = ((((long) iArr[i + 4]) & 4294967295L) - (((long) iArr2[i2 + 4]) & 4294967295L)) + (j4 >> 32);
        iArr3[i3 + 4] = (int) j5;
        long j6 = ((((long) iArr[i + 5]) & 4294967295L) - (((long) iArr2[i2 + 5]) & 4294967295L)) + (j5 >> 32);
        iArr3[i3 + 5] = (int) j6;
        long j7 = ((((long) iArr[i + 6]) & 4294967295L) - (((long) iArr2[i2 + 6]) & 4294967295L)) + (j6 >> 32);
        iArr3[i3 + 6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        long j5 = ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L)) + (j4 >> 32);
        iArr3[4] = (int) j5;
        long j6 = ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L)) + (j5 >> 32);
        iArr3[5] = (int) j6;
        long j7 = ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295L)) + (j6 >> 32);
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr3[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = (((((long) iArr3[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) - (((long) iArr2[1]) & 4294967295L)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = (((((long) iArr3[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) - (((long) iArr2[2]) & 4294967295L)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = (((((long) iArr3[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) - (((long) iArr2[3]) & 4294967295L)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        long j5 = (((((long) iArr3[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) - (((long) iArr2[4]) & 4294967295L)) + (j4 >> 32);
        iArr3[4] = (int) j5;
        long j6 = (((((long) iArr3[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) - (((long) iArr2[5]) & 4294967295L)) + (j5 >> 32);
        iArr3[5] = (int) j6;
        long j7 = (((((long) iArr3[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) - (((long) iArr2[6]) & 4294967295L)) + (j6 >> 32);
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i2 + 0;
        long j = ((((long) iArr2[i3]) & 4294967295L) - (((long) iArr[i + 0]) & 4294967295L)) + 0;
        iArr2[i3] = (int) j;
        int i4 = i2 + 1;
        long j2 = ((((long) iArr2[i4]) & 4294967295L) - (((long) iArr[i + 1]) & 4294967295L)) + (j >> 32);
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = ((((long) iArr2[i5]) & 4294967295L) - (((long) iArr[i + 2]) & 4294967295L)) + (j2 >> 32);
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = ((((long) iArr2[i6]) & 4294967295L) - (((long) iArr[i + 3]) & 4294967295L)) + (j3 >> 32);
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = ((((long) iArr2[i7]) & 4294967295L) - (((long) iArr[i + 4]) & 4294967295L)) + (j4 >> 32);
        iArr2[i7] = (int) j5;
        int i8 = i2 + 5;
        long j6 = ((((long) iArr2[i8]) & 4294967295L) - (((long) iArr[i + 5]) & 4294967295L)) + (j5 >> 32);
        iArr2[i8] = (int) j6;
        int i9 = i2 + 6;
        long j7 = ((((long) iArr2[i9]) & 4294967295L) - (((long) iArr[i + 6]) & 4294967295L)) + (j6 >> 32);
        iArr2[i9] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        long j2 = ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) + (j >> 32);
        iArr2[1] = (int) j2;
        long j3 = ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) + (j2 >> 32);
        iArr2[2] = (int) j3;
        long j4 = ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) + (j3 >> 32);
        iArr2[3] = (int) j4;
        long j5 = ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) + (j4 >> 32);
        iArr2[4] = (int) j5;
        long j6 = ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) + (j5 >> 32);
        iArr2[5] = (int) j6;
        long j7 = ((((long) iArr2[6]) & 4294967295L) - (4294967295L & ((long) iArr[6]))) + (j6 >> 32);
        iArr2[6] = (int) j7;
        return (int) (j7 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i = 0; i < 7; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (6 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
    }
}

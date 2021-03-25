package com.tuya.spongycastle.math.raw;

import a.a.a.a.a;
import com.tuya.spongycastle.util.Pack;
import java.math.BigInteger;

public abstract class Nat192 {
    public static final long M = 4294967295L;

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
        return (int) (j6 >>> 32);
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
        return (int) (j6 >>> 32);
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
        long j6 = (((long) iArr[i + 5]) & 4294967295L) + (4294967295L & ((long) iArr2[i9])) + (j5 >>> 32);
        iArr2[i9] = (int) j6;
        return (int) (j6 >>> 32);
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
        long j6 = (((long) iArr[5]) & 4294967295L) + (4294967295L & ((long) iArr2[5])) + (j5 >>> 32);
        iArr2[5] = (int) j6;
        return (int) (j6 >>> 32);
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
        long j6 = (((long) iArr[i18]) & 4294967295L) + (4294967295L & ((long) iArr2[i19])) + (j5 >>> 32);
        int i20 = (int) j6;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        return (int) (j6 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static int[] create() {
        return new int[6];
    }

    public static long[] create64() {
        return new long[3];
    }

    public static int[] createExt() {
        return new int[12];
    }

    public static long[] createExt64() {
        return new long[6];
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
        for (int i = 5; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i = 2; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
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

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        long[] create64 = create64();
        int i = 0;
        while (bigInteger.signum() != 0) {
            create64[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i++;
        }
        return create64;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 6) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 5; i3 >= 0; i3--) {
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
        for (int i = 5; i >= 0; i--) {
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
        for (int i = 1; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i = 0; i < 3; i++) {
            if (jArr[i] != 0) {
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
        long j7 = ((long) iArr[i + 0]) & 4294967295L;
        long j8 = (j7 * j) + 0;
        long j9 = j;
        iArr3[i3 + 0] = (int) j8;
        long j10 = (j7 * j2) + (j8 >>> 32);
        long j11 = j2;
        iArr3[i3 + 1] = (int) j10;
        long j12 = (j7 * j3) + (j10 >>> 32);
        iArr3[i3 + 2] = (int) j12;
        long j13 = (j7 * j4) + (j12 >>> 32);
        iArr3[i3 + 3] = (int) j13;
        long j14 = (j7 * j5) + (j13 >>> 32);
        iArr3[i3 + 4] = (int) j14;
        long j15 = (j7 * j6) + (j14 >>> 32);
        iArr3[i3 + 5] = (int) j15;
        iArr3[i3 + 6] = (int) (j15 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 6) {
            i5 += i4;
            long j16 = ((long) iArr[i + i6]) & 4294967295L;
            int i7 = i5 + 0;
            long j17 = (j16 * j9) + (((long) iArr3[i7]) & 4294967295L) + 0;
            iArr3[i7] = (int) j17;
            int i8 = i5 + 1;
            long j18 = j6;
            long j19 = (j16 * j11) + (((long) iArr3[i8]) & 4294967295L) + (j17 >>> 32);
            iArr3[i8] = (int) j19;
            int i9 = i5 + 2;
            long j20 = j3;
            long j21 = (j16 * j3) + (((long) iArr3[i9]) & 4294967295L) + (j19 >>> 32);
            iArr3[i9] = (int) j21;
            int i10 = i5 + 3;
            long j22 = (j16 * j4) + (((long) iArr3[i10]) & 4294967295L) + (j21 >>> 32);
            iArr3[i10] = (int) j22;
            int i11 = i5 + 4;
            long j23 = (j16 * j5) + (((long) iArr3[i11]) & 4294967295L) + (j22 >>> 32);
            iArr3[i11] = (int) j23;
            int i12 = i5 + 5;
            long j24 = (j16 * j18) + (((long) iArr3[i12]) & 4294967295L) + (j23 >>> 32);
            iArr3[i12] = (int) j24;
            iArr3[i5 + 6] = (int) (j24 >>> 32);
            i6++;
            j3 = j20;
            j6 = j18;
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
        long j7 = ((long) iArr[0]) & 4294967295L;
        long j8 = (j7 * j) + 0;
        iArr3[0] = (int) j8;
        long j9 = (j7 * j2) + (j8 >>> 32);
        iArr3[1] = (int) j9;
        long j10 = (j7 * j5) + (j9 >>> 32);
        iArr3[2] = (int) j10;
        long j11 = (j7 * j3) + (j10 >>> 32);
        iArr3[3] = (int) j11;
        long j12 = (j7 * j4) + (j11 >>> 32);
        iArr3[4] = (int) j12;
        long j13 = (j7 * j6) + (j12 >>> 32);
        iArr3[5] = (int) j13;
        iArr3[6] = (int) (j13 >>> 32);
        int i = 1;
        for (int i2 = 6; i < i2; i2 = 6) {
            long j14 = ((long) iArr[i]) & 4294967295L;
            int i3 = i + 0;
            long j15 = j;
            long j16 = (j14 * j) + (((long) iArr3[i3]) & 4294967295L) + 0;
            iArr3[i3] = (int) j16;
            int i4 = i + 1;
            long j17 = j2;
            long j18 = (j14 * j2) + (((long) iArr3[i4]) & 4294967295L) + (j16 >>> 32);
            iArr3[i4] = (int) j18;
            long j19 = j18 >>> 32;
            int i5 = i + 2;
            long j20 = (j14 * j5) + (((long) iArr3[i5]) & 4294967295L) + j19;
            iArr3[i5] = (int) j20;
            long j21 = j20 >>> 32;
            int i6 = i + 3;
            long j22 = (j14 * j3) + (((long) iArr3[i6]) & 4294967295L) + j21;
            iArr3[i6] = (int) j22;
            long j23 = j22 >>> 32;
            int i7 = i + 4;
            long j24 = (j14 * j4) + (((long) iArr3[i7]) & 4294967295L) + j23;
            iArr3[i7] = (int) j24;
            long j25 = j24 >>> 32;
            int i8 = i + 5;
            long j26 = (j14 * j6) + (((long) iArr3[i8]) & 4294967295L) + j25;
            iArr3[i8] = (int) j26;
            iArr3[i + 6] = (int) (j26 >>> 32);
            i = i4;
            j = j15;
            j2 = j17;
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
        long j13 = (j * j12) + j10 + (4294967295L & ((long) iArr2[i3 + 5])) + (j11 >>> 32);
        iArr3[i4 + 5] = (int) j13;
        return (j13 >>> 32) + j12;
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
        return Nat.incAt(6, iArr2, i3, 4);
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
        return Nat.incAt(6, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = 4294967295L;
        long j2 = ((long) iArr2[i2 + 0]) & 4294967295L;
        long j3 = ((long) iArr2[i2 + 1]) & 4294967295L;
        long j4 = ((long) iArr2[i2 + 2]) & 4294967295L;
        long j5 = ((long) iArr2[i2 + 3]) & 4294967295L;
        long j6 = ((long) iArr2[i2 + 4]) & 4294967295L;
        long j7 = ((long) iArr2[i2 + 5]) & 4294967295L;
        int i4 = i3;
        int i5 = 0;
        long j8 = 0;
        while (i5 < 6) {
            int i6 = i5;
            long j9 = ((long) iArr[i + i5]) & j;
            int i7 = i4 + 0;
            long j10 = (j9 * j2) + (((long) iArr3[i7]) & j) + 0;
            iArr3[i7] = (int) j10;
            int i8 = i4 + 1;
            long j11 = j3;
            long j12 = (j9 * j3) + (((long) iArr3[i8]) & 4294967295L) + (j10 >>> 32);
            iArr3[i8] = (int) j12;
            int i9 = i4 + 2;
            long j13 = j4;
            long j14 = (j9 * j4) + (((long) iArr3[i9]) & 4294967295L) + (j12 >>> 32);
            iArr3[i9] = (int) j14;
            int i10 = i4 + 3;
            long j15 = (j9 * j5) + (((long) iArr3[i10]) & 4294967295L) + (j14 >>> 32);
            iArr3[i10] = (int) j15;
            int i11 = i4 + 4;
            long j16 = (j9 * j6) + (((long) iArr3[i11]) & 4294967295L) + (j15 >>> 32);
            iArr3[i11] = (int) j16;
            long j17 = j16 >>> 32;
            int i12 = i4 + 5;
            long j18 = (j9 * j7) + (((long) iArr3[i12]) & 4294967295L) + j17;
            iArr3[i12] = (int) j18;
            int i13 = i4 + 6;
            long j19 = j8 + (((long) iArr3[i13]) & 4294967295L) + (j18 >>> 32);
            iArr3[i13] = (int) j19;
            j8 = j19 >>> 32;
            i5 = i6 + 1;
            i4 = i8;
            j2 = j2;
            j = 4294967295L;
            j3 = j11;
            j4 = j13;
        }
        return (int) j8;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = 4294967295L;
        long j2 = ((long) iArr2[0]) & 4294967295L;
        long j3 = ((long) iArr2[1]) & 4294967295L;
        long j4 = ((long) iArr2[2]) & 4294967295L;
        long j5 = ((long) iArr2[3]) & 4294967295L;
        long j6 = ((long) iArr2[4]) & 4294967295L;
        long j7 = ((long) iArr2[5]) & 4294967295L;
        long j8 = 0;
        while (i < 6) {
            long j9 = j7;
            long j10 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j11 = j2;
            long j12 = (j10 * j2) + (((long) iArr3[i2]) & j) + 0;
            iArr3[i2] = (int) j12;
            int i3 = i + 1;
            long j13 = (j10 * j3) + (((long) iArr3[i3]) & 4294967295L) + (j12 >>> 32);
            iArr3[i3] = (int) j13;
            int i4 = i + 2;
            long j14 = (j10 * j4) + (((long) iArr3[i4]) & 4294967295L) + (j13 >>> 32);
            iArr3[i4] = (int) j14;
            int i5 = i + 3;
            long j15 = (j10 * j5) + (((long) iArr3[i5]) & 4294967295L) + (j14 >>> 32);
            iArr3[i5] = (int) j15;
            int i6 = i + 4;
            long j16 = (j10 * j6) + (((long) iArr3[i6]) & 4294967295L) + (j15 >>> 32);
            iArr3[i6] = (int) j16;
            long j17 = j16 >>> 32;
            int i7 = i + 5;
            long j18 = (j10 * j9) + (((long) iArr3[i7]) & 4294967295L) + j17;
            iArr3[i7] = (int) j18;
            int i8 = i + 6;
            long j19 = j8 + (((long) iArr3[i8]) & 4294967295L) + (j18 >>> 32);
            iArr3[i8] = (int) j19;
            j8 = j19 >>> 32;
            i = i3;
            j = 4294967295L;
            j7 = j9;
            j2 = j11;
            j3 = j3;
        }
        return (int) j8;
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
        } while (i3 < 6);
        return (int) j2;
    }

    public static int mulWordAddExt(int i, int[] iArr, int i2, int[] iArr2, int i3) {
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
        long j7 = (j * (((long) iArr[i2 + 5]) & 4294967295L)) + (((long) iArr2[i9]) & 4294967295L) + (j6 >>> 32);
        iArr2[i9] = (int) j7;
        return (int) (j7 >>> 32);
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
        return Nat.incAt(6, iArr, i2, 3);
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i + 0]) & 4294967295L;
        int i3 = 0;
        int i4 = 12;
        int i5 = 5;
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
                long j34 = (j * j30) + (w4 & 4294967295L);
                int i27 = (int) j34;
                iArr2[i17] = (i23 >>> 31) | (i27 << 1);
                int i28 = i27 >>> 31;
                long w7 = a.w(j30, j5, j34 >>> 32, j28);
                long w8 = a.w(j30, j16, w7 >>> 32, w6 & 4294967295L);
                long j35 = j30;
                long w9 = a.w(j35, j27, w8 >>> 32, j32);
                long w10 = a.w(j35, j21, w9 >>> 32, j31 & 4294967295L);
                long j36 = j33 + (w10 >>> 32);
                int i29 = (int) w7;
                iArr2[i16] = (i29 << 1) | i28;
                int i30 = i29 >>> 31;
                int i31 = (int) w8;
                iArr2[i20] = i30 | (i31 << 1);
                int i32 = i31 >>> 31;
                int i33 = (int) w9;
                iArr2[i22] = i32 | (i33 << 1);
                int i34 = i33 >>> 31;
                int i35 = (int) w10;
                iArr2[i24] = i34 | (i35 << 1);
                int i36 = i35 >>> 31;
                int i37 = (int) j36;
                iArr2[i26] = i36 | (i37 << 1);
                int i38 = i37 >>> 31;
                int i39 = i2 + 11;
                iArr2[i39] = i38 | ((iArr2[i39] + ((int) (j36 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 12;
        int i2 = 5;
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
                long j33 = (j * j31) + (w4 & 4294967295L);
                int i14 = (int) j33;
                iArr2[5] = i13 | (i14 << 1);
                int i15 = i14 >>> 31;
                long w7 = a.w(j31, j5, j33 >>> 32, j29);
                long w8 = a.w(j31, j16, w7 >>> 32, w6 & 4294967295L);
                long w9 = a.w(j31, j28, w8 >>> 32, j30 & 4294967295L);
                long w10 = a.w(j31, j22, w9 >>> 32, 4294967295L & j32);
                long j34 = (((long) iArr2[10]) & 4294967295L) + (j32 >>> 32) + (w10 >>> 32);
                int i16 = (int) w7;
                iArr2[6] = (i16 << 1) | i15;
                int i17 = (int) w8;
                iArr2[7] = (i16 >>> 31) | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) w9;
                iArr2[8] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) w10;
                iArr2[9] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) j34;
                iArr2[10] = i22 | (i23 << 1);
                iArr2[11] = (i23 >>> 31) | ((iArr2[11] + ((int) (j34 >>> 32))) << 1);
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
        return (int) (j6 >> 32);
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
        return (int) (j6 >> 32);
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
        return (int) (j6 >> 32);
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
        return (int) (j6 >> 32);
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
        long j6 = ((((long) iArr2[5]) & 4294967295L) - (4294967295L & ((long) iArr[5]))) + (j5 >> 32);
        iArr2[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (5 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 3; i++) {
            long j = jArr[i];
            if (j != 0) {
                Pack.longToBigEndian(j, bArr, (2 - i) << 3);
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
    }
}

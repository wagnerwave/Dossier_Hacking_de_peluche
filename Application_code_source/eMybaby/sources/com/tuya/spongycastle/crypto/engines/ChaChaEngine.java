package com.tuya.spongycastle.crypto.engines;

import a.a.a.a.a;
import com.tuya.spongycastle.util.Pack;

public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine() {
    }

    public ChaChaEngine(int i) {
        super(i);
    }

    public static void chachaCore(int i, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i2 = 16;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i % 2 == 0) {
            char c2 = 0;
            int i3 = iArr3[0];
            int i4 = iArr3[1];
            int i5 = iArr3[2];
            int i6 = iArr3[3];
            int i7 = iArr3[4];
            int i8 = iArr3[5];
            int i9 = iArr3[6];
            int i10 = 7;
            int i11 = iArr3[7];
            int i12 = 8;
            int i13 = iArr3[8];
            int i14 = iArr3[9];
            int i15 = iArr3[10];
            int i16 = iArr3[11];
            int i17 = 12;
            int i18 = iArr3[12];
            int i19 = iArr3[13];
            int i20 = iArr3[14];
            int i21 = iArr3[15];
            int i22 = i20;
            int i23 = i19;
            int i24 = i18;
            int i25 = i16;
            int i26 = i15;
            int i27 = i14;
            int i28 = i13;
            int i29 = i11;
            int i30 = i9;
            int i31 = i8;
            int i32 = i7;
            int i33 = i6;
            int i34 = i5;
            int i35 = i4;
            int i36 = i3;
            int i37 = i;
            while (i37 > 0) {
                int i38 = i36 + i32;
                int rotl = Salsa20Engine.rotl(i24 ^ i38, i2);
                int i39 = i28 + rotl;
                int rotl2 = Salsa20Engine.rotl(i32 ^ i39, i17);
                int i40 = i38 + rotl2;
                int rotl3 = Salsa20Engine.rotl(rotl ^ i40, i12);
                int i41 = i39 + rotl3;
                int rotl4 = Salsa20Engine.rotl(rotl2 ^ i41, i10);
                int i42 = i35 + i31;
                int rotl5 = Salsa20Engine.rotl(i23 ^ i42, i2);
                int i43 = i27 + rotl5;
                int rotl6 = Salsa20Engine.rotl(i31 ^ i43, i17);
                int i44 = i42 + rotl6;
                int rotl7 = Salsa20Engine.rotl(rotl5 ^ i44, i12);
                int i45 = i43 + rotl7;
                int rotl8 = Salsa20Engine.rotl(rotl6 ^ i45, i10);
                int i46 = i34 + i30;
                int rotl9 = Salsa20Engine.rotl(i22 ^ i46, i2);
                int i47 = i26 + rotl9;
                int rotl10 = Salsa20Engine.rotl(i30 ^ i47, i17);
                int i48 = i46 + rotl10;
                int rotl11 = Salsa20Engine.rotl(rotl9 ^ i48, i12);
                int i49 = i47 + rotl11;
                int rotl12 = Salsa20Engine.rotl(rotl10 ^ i49, i10);
                int i50 = i33 + i29;
                int rotl13 = Salsa20Engine.rotl(i21 ^ i50, 16);
                int i51 = i25 + rotl13;
                int rotl14 = Salsa20Engine.rotl(i29 ^ i51, i17);
                int i52 = i50 + rotl14;
                int rotl15 = Salsa20Engine.rotl(rotl13 ^ i52, 8);
                int i53 = i51 + rotl15;
                int rotl16 = Salsa20Engine.rotl(rotl14 ^ i53, 7);
                int i54 = i40 + rotl8;
                int rotl17 = Salsa20Engine.rotl(rotl15 ^ i54, 16);
                int i55 = i49 + rotl17;
                int rotl18 = Salsa20Engine.rotl(rotl8 ^ i55, 12);
                i36 = i54 + rotl18;
                i21 = Salsa20Engine.rotl(rotl17 ^ i36, 8);
                i26 = i55 + i21;
                i31 = Salsa20Engine.rotl(rotl18 ^ i26, 7);
                int i56 = i44 + rotl12;
                int rotl19 = Salsa20Engine.rotl(rotl3 ^ i56, 16);
                int i57 = i53 + rotl19;
                int rotl20 = Salsa20Engine.rotl(rotl12 ^ i57, 12);
                i35 = i56 + rotl20;
                i24 = Salsa20Engine.rotl(rotl19 ^ i35, 8);
                i25 = i57 + i24;
                i30 = Salsa20Engine.rotl(rotl20 ^ i25, 7);
                int i58 = i48 + rotl16;
                int rotl21 = Salsa20Engine.rotl(rotl7 ^ i58, 16);
                int i59 = i41 + rotl21;
                int rotl22 = Salsa20Engine.rotl(rotl16 ^ i59, 12);
                i34 = i58 + rotl22;
                i23 = Salsa20Engine.rotl(rotl21 ^ i34, 8);
                i28 = i59 + i23;
                i29 = Salsa20Engine.rotl(rotl22 ^ i28, 7);
                int i60 = i52 + rotl4;
                i2 = 16;
                int rotl23 = Salsa20Engine.rotl(rotl11 ^ i60, 16);
                int i61 = i45 + rotl23;
                int rotl24 = Salsa20Engine.rotl(rotl4 ^ i61, 12);
                i33 = i60 + rotl24;
                i22 = Salsa20Engine.rotl(rotl23 ^ i33, 8);
                i27 = i61 + i22;
                i32 = Salsa20Engine.rotl(rotl24 ^ i27, 7);
                i37 -= 2;
                c2 = 0;
                i17 = 12;
                i12 = 8;
                i10 = 7;
            }
            iArr4[c2] = i36 + iArr3[c2];
            iArr4[1] = i35 + iArr3[1];
            iArr4[2] = i34 + iArr3[2];
            iArr4[3] = i33 + iArr3[3];
            iArr4[4] = i32 + iArr3[4];
            iArr4[5] = i31 + iArr3[5];
            iArr4[6] = i30 + iArr3[6];
            iArr4[7] = i29 + iArr3[7];
            iArr4[8] = i28 + iArr3[8];
            iArr4[9] = i27 + iArr3[9];
            iArr4[10] = i26 + iArr3[10];
            iArr4[11] = i25 + iArr3[11];
            iArr4[12] = i24 + iArr3[12];
            iArr4[13] = i23 + iArr3[13];
            iArr4[14] = i22 + iArr3[14];
            iArr4[15] = i21 + iArr3[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i = iArr[12] + 1;
        iArr[12] = i;
        if (i == 0) {
            iArr[13] = iArr[13] + 1;
        }
    }

    public void advanceCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i > 0) {
            int[] iArr = this.engineState;
            iArr[13] = iArr[13] + i;
        }
        int[] iArr2 = this.engineState;
        int i3 = iArr2[12];
        iArr2[12] = iArr2[12] + i2;
        if (i3 != 0 && iArr2[12] < i3) {
            iArr2[13] = iArr2[13] + 1;
        }
    }

    public void generateKeyStream(byte[] bArr) {
        chachaCore(this.rounds, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, bArr, 0);
    }

    public String getAlgorithmName() {
        StringBuilder n = a.n("ChaCha");
        n.append(this.rounds);
        return n.toString();
    }

    public long getCounter() {
        int[] iArr = this.engineState;
        return (((long) iArr[13]) << 32) | (((long) iArr[12]) & 4294967295L);
    }

    public void resetCounter() {
        int[] iArr = this.engineState;
        iArr[13] = 0;
        iArr[12] = 0;
    }

    public void retreatCounter() {
        int[] iArr = this.engineState;
        if (iArr[12] == 0 && iArr[13] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int[] iArr2 = this.engineState;
        int i = iArr2[12] - 1;
        iArr2[12] = i;
        if (i == -1) {
            iArr2[13] = iArr2[13] - 1;
        }
    }

    public void retreatCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i != 0) {
            int[] iArr = this.engineState;
            if ((((long) iArr[13]) & 4294967295L) >= (((long) i) & 4294967295L)) {
                iArr[13] = iArr[13] - i;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2 = this.engineState;
        if ((((long) iArr2[12]) & 4294967295L) >= (4294967295L & ((long) i2))) {
            iArr2[12] = iArr2[12] - i2;
        } else if (iArr2[13] != 0) {
            iArr2[13] = iArr2[13] - 1;
            iArr2[12] = iArr2[12] - i2;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                packTauOrSigma(bArr.length, this.engineState, 0);
                Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 4);
                Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 8, 4);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 14, 2);
    }
}

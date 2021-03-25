package com.tuya.spongycastle.crypto.digests;

import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;
import com.tuya.spongycastle.util.Memoable;
import com.tuya.spongycastle.util.Pack;

public class SM3Digest extends GeneralDigest {
    public static final int BLOCK_SIZE = 16;
    public static final int DIGEST_LENGTH = 32;
    public static final int[] T = new int[64];
    public int[] V = new int[8];
    public int[] W = new int[68];
    public int[] W1 = new int[64];
    public int[] inwords = new int[16];
    public int xOff;

    static {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            T[i2] = (2043430169 >>> (32 - i2)) | (2043430169 << i2);
            i2++;
        }
        for (i = 16; i < 64; i++) {
            int i3 = i % 32;
            T[i] = (2055708042 >>> (32 - i3)) | (2055708042 << i3);
        }
    }

    public SM3Digest() {
        reset();
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super((GeneralDigest) sM3Digest);
        copyIn(sM3Digest);
    }

    private int FF0(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int FF1(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    private int GG0(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int GG1(int i, int i2, int i3) {
        return ((i ^ -1) & i3) | (i2 & i);
    }

    private int P0(int i) {
        return (i ^ ((i << 9) | (i >>> 23))) ^ ((i << 17) | (i >>> 15));
    }

    private int P1(int i) {
        return (i ^ ((i << 15) | (i >>> 17))) ^ ((i << 23) | (i >>> 9));
    }

    private void copyIn(SM3Digest sM3Digest) {
        int[] iArr = sM3Digest.V;
        int[] iArr2 = this.V;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = sM3Digest.inwords;
        int[] iArr4 = this.inwords;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.xOff = sM3Digest.xOff;
    }

    public Memoable copy() {
        return new SM3Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.V[0], bArr, i + 0);
        Pack.intToBigEndian(this.V[1], bArr, i + 4);
        Pack.intToBigEndian(this.V[2], bArr, i + 8);
        Pack.intToBigEndian(this.V[3], bArr, i + 12);
        Pack.intToBigEndian(this.V[4], bArr, i + 16);
        Pack.intToBigEndian(this.V[5], bArr, i + 20);
        Pack.intToBigEndian(this.V[6], bArr, i + 24);
        Pack.intToBigEndian(this.V[7], bArr, i + 28);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "SM3";
    }

    public int getDigestSize() {
        return 32;
    }

    public void processBlock() {
        for (int i = 0; i < 16; i++) {
            this.W[i] = this.inwords[i];
        }
        for (int i2 = 16; i2 < 68; i2++) {
            int[] iArr = this.W;
            int i3 = iArr[i2 - 3];
            int i4 = (i3 >>> 17) | (i3 << 15);
            int i5 = iArr[i2 - 13];
            iArr[i2] = (P1(i4 ^ (iArr[i2 - 16] ^ iArr[i2 - 9])) ^ ((i5 >>> 25) | (i5 << 7))) ^ this.W[i2 - 6];
        }
        for (int i6 = 0; i6 < 64; i6++) {
            int[] iArr2 = this.W1;
            int[] iArr3 = this.W;
            iArr2[i6] = iArr3[i6 + 4] ^ iArr3[i6];
        }
        int[] iArr4 = this.V;
        int i7 = iArr4[0];
        int i8 = iArr4[1];
        int i9 = iArr4[2];
        int i10 = iArr4[3];
        int i11 = iArr4[4];
        int i12 = iArr4[5];
        int i13 = iArr4[6];
        int i14 = iArr4[7];
        int i15 = i13;
        int i16 = 0;
        while (i16 < 16) {
            int i17 = (i7 << 12) | (i7 >>> 20);
            int i18 = i17 + i11 + T[i16];
            int i19 = (i18 << 7) | (i18 >>> 25);
            int FF0 = FF0(i7, i8, i9) + i10;
            int GG0 = GG0(i11, i12, i15) + i14 + i19 + this.W[i16];
            i16++;
            int i20 = i11;
            i11 = P0(GG0);
            i14 = i15;
            i15 = (i12 << 19) | (i12 >>> 13);
            i12 = i20;
            int i21 = (i8 << 9) | (i8 >>> 23);
            i8 = i7;
            i7 = FF0 + (i19 ^ i17) + this.W1[i16];
            i10 = i9;
            i9 = i21;
        }
        int i22 = i14;
        int i23 = i10;
        int i24 = i15;
        int i25 = i9;
        int i26 = i8;
        int i27 = i7;
        int i28 = 16;
        while (i28 < 64) {
            int i29 = (i27 << 12) | (i27 >>> 20);
            int i30 = i29 + i11 + T[i28];
            int i31 = (i30 << 7) | (i30 >>> 25);
            int FF1 = FF1(i27, i26, i25) + i23;
            int GG1 = GG1(i11, i12, i24) + i22 + i31 + this.W[i28];
            int i32 = (i26 >>> 23) | (i26 << 9);
            int i33 = (i12 << 19) | (i12 >>> 13);
            i28++;
            i12 = i11;
            i11 = P0(GG1);
            int i34 = i33;
            i22 = i24;
            i24 = i34;
            int i35 = i32;
            i26 = i27;
            i27 = FF1 + (i31 ^ i29) + this.W1[i28];
            i23 = i25;
            i25 = i35;
        }
        int[] iArr5 = this.V;
        iArr5[0] = iArr5[0] ^ i27;
        iArr5[1] = iArr5[1] ^ i26;
        iArr5[2] = iArr5[2] ^ i25;
        iArr5[3] = iArr5[3] ^ i23;
        iArr5[4] = iArr5[4] ^ i11;
        iArr5[5] = iArr5[5] ^ i12;
        iArr5[6] = i24 ^ iArr5[6];
        iArr5[7] = iArr5[7] ^ i22;
        this.xOff = 0;
    }

    public void processLength(long j) {
        int i = this.xOff;
        if (i > 14) {
            this.inwords[i] = 0;
            this.xOff = i + 1;
            processBlock();
        }
        while (true) {
            int i2 = this.xOff;
            if (i2 < 14) {
                this.inwords[i2] = 0;
                this.xOff = i2 + 1;
            } else {
                int[] iArr = this.inwords;
                int i3 = i2 + 1;
                this.xOff = i3;
                iArr[i2] = (int) (j >>> 32);
                this.xOff = i3 + 1;
                iArr[i3] = (int) j;
                return;
            }
        }
    }

    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[i] & AVFrame.FRM_STATE_UNKOWN) << 24) | ((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[i3] & AVFrame.FRM_STATE_UNKOWN) << 8);
        int[] iArr = this.inwords;
        int i5 = this.xOff;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.xOff = i6;
        if (i6 >= 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        int[] iArr = this.V;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.xOff = 0;
    }

    public void reset(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.copyIn(sM3Digest);
        copyIn(sM3Digest);
    }
}

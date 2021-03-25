package com.tuya.spongycastle.crypto.digests;

import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;
import com.tuya.spongycastle.util.Memoable;
import com.tuya.spongycastle.util.Pack;

public class SHA224Digest extends GeneralDigest implements EncodableDigest {
    public static final int DIGEST_LENGTH = 28;
    public static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    public int H1;
    public int H2;
    public int H3;
    public int H4;
    public int H5;
    public int H6;
    public int H7;
    public int H8;
    public int[] X = new int[64];
    public int xOff;

    public SHA224Digest() {
        reset();
    }

    public SHA224Digest(SHA224Digest sHA224Digest) {
        super((GeneralDigest) sHA224Digest);
        doCopy(sHA224Digest);
    }

    public SHA224Digest(byte[] bArr) {
        super(bArr);
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.H6 = Pack.bigEndianToInt(bArr, 36);
        this.H7 = Pack.bigEndianToInt(bArr, 40);
        this.H8 = Pack.bigEndianToInt(bArr, 44);
        this.xOff = Pack.bigEndianToInt(bArr, 48);
        for (int i = 0; i != this.xOff; i++) {
            this.X[i] = Pack.bigEndianToInt(bArr, (i * 4) + 52);
        }
    }

    private int Ch(int i, int i2, int i3) {
        return ((i ^ -1) & i3) ^ (i2 & i);
    }

    private int Maj(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    private int Sum0(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    private int Sum1(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    private int Theta0(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    private int Theta1(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    private void doCopy(SHA224Digest sHA224Digest) {
        super.copyIn(sHA224Digest);
        this.H1 = sHA224Digest.H1;
        this.H2 = sHA224Digest.H2;
        this.H3 = sHA224Digest.H3;
        this.H4 = sHA224Digest.H4;
        this.H5 = sHA224Digest.H5;
        this.H6 = sHA224Digest.H6;
        this.H7 = sHA224Digest.H7;
        this.H8 = sHA224Digest.H8;
        int[] iArr = sHA224Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA224Digest.xOff;
    }

    public Memoable copy() {
        return new SHA224Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i);
        Pack.intToBigEndian(this.H2, bArr, i + 4);
        Pack.intToBigEndian(this.H3, bArr, i + 8);
        Pack.intToBigEndian(this.H4, bArr, i + 12);
        Pack.intToBigEndian(this.H5, bArr, i + 16);
        Pack.intToBigEndian(this.H6, bArr, i + 20);
        Pack.intToBigEndian(this.H7, bArr, i + 24);
        reset();
        return 28;
    }

    public String getAlgorithmName() {
        return "SHA-224";
    }

    public int getDigestSize() {
        return 28;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.xOff * 4) + 52)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.H6, bArr, 36);
        Pack.intToBigEndian(this.H7, bArr, 40);
        Pack.intToBigEndian(this.H8, bArr, 44);
        Pack.intToBigEndian(this.xOff, bArr, 48);
        for (int i = 0; i != this.xOff; i++) {
            Pack.intToBigEndian(this.X[i], bArr, (i * 4) + 52);
        }
        return bArr;
    }

    public void processBlock() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.X;
            int Theta1 = Theta1(iArr[i - 2]);
            int[] iArr2 = this.X;
            iArr[i] = Theta1 + iArr2[i - 7] + Theta0(iArr2[i - 15]) + this.X[i - 16];
        }
        int i2 = this.H1;
        int i3 = this.H2;
        int i4 = this.H3;
        int i5 = this.H4;
        int i6 = this.H5;
        int i7 = this.H6;
        int i8 = this.H7;
        int i9 = this.H8;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int Sum1 = Sum1(i6) + Ch(i6, i7, i8) + K[i10] + this.X[i10] + i9;
            int i12 = i5 + Sum1;
            int Sum0 = Sum0(i2) + Maj(i2, i3, i4) + Sum1;
            int i13 = i10 + 1;
            int Sum12 = Sum1(i12) + Ch(i12, i6, i7) + K[i13] + this.X[i13] + i8;
            int i14 = i4 + Sum12;
            int Sum02 = Sum0(Sum0) + Maj(Sum0, i2, i3) + Sum12;
            int i15 = i13 + 1;
            int Sum13 = Sum1(i14) + Ch(i14, i12, i6) + K[i15] + this.X[i15] + i7;
            int i16 = i3 + Sum13;
            int Sum03 = Sum0(Sum02) + Maj(Sum02, Sum0, i2) + Sum13;
            int i17 = i15 + 1;
            int Sum14 = Sum1(i16) + Ch(i16, i14, i12) + K[i17] + this.X[i17] + i6;
            int i18 = i2 + Sum14;
            int Sum04 = Sum0(Sum03) + Maj(Sum03, Sum02, Sum0) + Sum14;
            int i19 = i17 + 1;
            int Sum15 = Sum1(i18) + Ch(i18, i16, i14) + K[i19] + this.X[i19] + i12;
            i9 = Sum0 + Sum15;
            i5 = Sum0(Sum04) + Maj(Sum04, Sum03, Sum02) + Sum15;
            int i20 = i19 + 1;
            int Sum16 = Sum1(i9) + Ch(i9, i18, i16) + K[i20] + this.X[i20] + i14;
            i8 = Sum02 + Sum16;
            i4 = Sum0(i5) + Maj(i5, Sum04, Sum03) + Sum16;
            int i21 = i20 + 1;
            int Sum17 = Sum1(i8) + Ch(i8, i9, i18) + K[i21] + this.X[i21] + i16;
            i7 = Sum03 + Sum17;
            i3 = Sum0(i4) + Maj(i4, i5, Sum04) + Sum17;
            int i22 = i21 + 1;
            int Sum18 = Sum1(i7) + Ch(i7, i8, i9) + K[i22] + this.X[i22] + i18;
            i6 = Sum04 + Sum18;
            i2 = Sum0(i3) + Maj(i3, i4, i5) + Sum18;
            i10 = i22 + 1;
        }
        this.H1 += i2;
        this.H2 += i3;
        this.H3 += i4;
        this.H4 += i5;
        this.H5 += i6;
        this.H6 += i7;
        this.H7 += i8;
        this.H8 += i9;
        this.xOff = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            this.X[i23] = 0;
        }
    }

    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & -1);
    }

    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & AVFrame.FRM_STATE_UNKOWN) | (bArr[i] << 24) | ((bArr[i2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[i3] & AVFrame.FRM_STATE_UNKOWN) << 8);
        int[] iArr = this.X;
        int i5 = this.xOff;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.xOff = i6;
        if (i6 == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.H1 = -1056596264;
        this.H2 = 914150663;
        this.H3 = 812702999;
        this.H4 = -150054599;
        this.H5 = -4191439;
        this.H6 = 1750603025;
        this.H7 = 1694076839;
        this.H8 = -1090891868;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        doCopy((SHA224Digest) memoable);
    }
}

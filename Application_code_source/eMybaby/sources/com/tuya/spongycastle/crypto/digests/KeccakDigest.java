package com.tuya.spongycastle.crypto.digests;

import a.a.a.a.a;
import com.tuya.smart.common.o00o0000o0;
import com.tuya.spongycastle.crypto.ExtendedDigest;
import com.tuya.spongycastle.util.Arrays;
import com.tuya.spongycastle.util.Pack;

public class KeccakDigest implements ExtendedDigest {
    public static int[] KeccakRhoOffsets = keccakInitializeRhoOffsets();
    public static long[] KeccakRoundConstants = keccakInitializeRoundConstants();
    public int bitsInQueue;
    public byte[] dataQueue;
    public int fixedOutputLength;
    public int rate;
    public boolean squeezing;
    public long[] state;

    public KeccakDigest() {
        this(288);
    }

    public KeccakDigest(int i) {
        this.state = new long[25];
        this.dataQueue = new byte[o00o0000o0.O00000Oo];
        init(i);
    }

    public KeccakDigest(KeccakDigest keccakDigest) {
        long[] jArr = new long[25];
        this.state = jArr;
        this.dataQueue = new byte[o00o0000o0.O00000Oo];
        long[] jArr2 = keccakDigest.state;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        byte[] bArr = keccakDigest.dataQueue;
        System.arraycopy(bArr, 0, this.dataQueue, 0, bArr.length);
        this.rate = keccakDigest.rate;
        this.bitsInQueue = keccakDigest.bitsInQueue;
        this.fixedOutputLength = keccakDigest.fixedOutputLength;
        this.squeezing = keccakDigest.squeezing;
    }

    private void KeccakAbsorb(byte[] bArr, int i) {
        int i2 = this.rate >> 6;
        for (int i3 = 0; i3 < i2; i3++) {
            long[] jArr = this.state;
            jArr[i3] = jArr[i3] ^ Pack.littleEndianToLong(bArr, i);
            i += 8;
        }
        KeccakPermutation();
    }

    private void KeccakExtract() {
        Pack.longToLittleEndian(this.state, 0, this.rate >> 6, this.dataQueue, 0);
    }

    private void KeccakPermutation() {
        for (int i = 0; i < 24; i++) {
            theta(this.state);
            rho(this.state);
            pi(this.state);
            chi(this.state);
            iota(this.state, i);
        }
    }

    public static boolean LFSR86540(byte[] bArr) {
        boolean z = (bArr[0] & 1) != 0;
        if ((bArr[0] & 128) != 0) {
            bArr[0] = (byte) ((bArr[0] << 1) ^ 113);
        } else {
            bArr[0] = (byte) (bArr[0] << 1);
        }
        return z;
    }

    public static void chi(long[] jArr) {
        for (int i = 0; i < 25; i += 5) {
            int i2 = i + 0;
            int i3 = i + 1;
            int i4 = i + 2;
            long j = jArr[i2] ^ ((jArr[i3] ^ -1) & jArr[i4]);
            int i5 = i + 3;
            long j2 = jArr[i3] ^ ((jArr[i4] ^ -1) & jArr[i5]);
            int i6 = i + 4;
            long j3 = jArr[i4] ^ ((jArr[i5] ^ -1) & jArr[i6]);
            long j4 = jArr[i5] ^ ((jArr[i6] ^ -1) & jArr[i2]);
            jArr[i2] = j;
            jArr[i3] = j2;
            jArr[i4] = j3;
            jArr[i5] = j4;
            jArr[i6] = jArr[i6] ^ ((jArr[i2] ^ -1) & jArr[i3]);
        }
    }

    private void init(int i) {
        if (i == 128 || i == 224 || i == 256 || i == 288 || i == 384 || i == 512) {
            initSponge(1600 - (i << 1));
            return;
        }
        throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
    }

    private void initSponge(int i) {
        if (i <= 0 || i >= 1600 || i % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        }
        this.rate = i;
        int i2 = 0;
        while (true) {
            long[] jArr = this.state;
            if (i2 < jArr.length) {
                jArr[i2] = 0;
                i2++;
            } else {
                Arrays.fill(this.dataQueue, (byte) 0);
                this.bitsInQueue = 0;
                this.squeezing = false;
                this.fixedOutputLength = (1600 - i) / 2;
                return;
            }
        }
    }

    public static void iota(long[] jArr, int i) {
        jArr[0] = jArr[0] ^ KeccakRoundConstants[i];
    }

    public static int[] keccakInitializeRhoOffsets() {
        int[] iArr = new int[25];
        int i = 0;
        iArr[0] = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < 24) {
            int i4 = i + 1;
            iArr[((i2 % 5) * 5) + (i3 % 5)] = (((i + 2) * i4) / 2) % 64;
            int i5 = i2 * 1;
            i2 = ((i2 * 3) + (i3 * 2)) % 5;
            i3 = (i5 + (i3 * 0)) % 5;
            i = i4;
        }
        return iArr;
    }

    public static long[] keccakInitializeRoundConstants() {
        long[] jArr = new long[24];
        byte[] bArr = {1};
        for (int i = 0; i < 24; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 7; i2++) {
                int i3 = (1 << i2) - 1;
                if (LFSR86540(bArr)) {
                    jArr[i] = jArr[i] ^ (1 << i3);
                }
            }
        }
        return jArr;
    }

    public static long leftRotate(long j, int i) {
        return (j >>> (-i)) | (j << i);
    }

    private void padAndSwitchToSqueezingPhase() {
        byte[] bArr = this.dataQueue;
        int i = this.bitsInQueue;
        int i2 = i >> 3;
        bArr[i2] = (byte) (bArr[i2] | ((byte) ((int) (1 << (i & 7)))));
        int i3 = i + 1;
        this.bitsInQueue = i3;
        if (i3 == this.rate) {
            KeccakAbsorb(bArr, 0);
            this.bitsInQueue = 0;
        }
        int i4 = this.bitsInQueue;
        int i5 = i4 >> 6;
        int i6 = i4 & 63;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            long[] jArr = this.state;
            jArr[i8] = jArr[i8] ^ Pack.littleEndianToLong(this.dataQueue, i7);
            i7 += 8;
        }
        if (i6 > 0) {
            long[] jArr2 = this.state;
            jArr2[i5] = jArr2[i5] ^ (((1 << i6) - 1) & Pack.littleEndianToLong(this.dataQueue, i7));
        }
        long[] jArr3 = this.state;
        int i9 = (this.rate - 1) >> 6;
        jArr3[i9] = jArr3[i9] ^ Long.MIN_VALUE;
        KeccakPermutation();
        KeccakExtract();
        this.bitsInQueue = this.rate;
        this.squeezing = true;
    }

    public static void pi(long[] jArr) {
        long j = jArr[1];
        jArr[1] = jArr[6];
        jArr[6] = jArr[9];
        jArr[9] = jArr[22];
        jArr[22] = jArr[14];
        jArr[14] = jArr[20];
        jArr[20] = jArr[2];
        jArr[2] = jArr[12];
        jArr[12] = jArr[13];
        jArr[13] = jArr[19];
        jArr[19] = jArr[23];
        jArr[23] = jArr[15];
        jArr[15] = jArr[4];
        jArr[4] = jArr[24];
        jArr[24] = jArr[21];
        jArr[21] = jArr[8];
        jArr[8] = jArr[16];
        jArr[16] = jArr[5];
        jArr[5] = jArr[3];
        jArr[3] = jArr[18];
        jArr[18] = jArr[17];
        jArr[17] = jArr[11];
        jArr[11] = jArr[7];
        jArr[7] = jArr[10];
        jArr[10] = j;
    }

    public static void rho(long[] jArr) {
        for (int i = 1; i < 25; i++) {
            jArr[i] = leftRotate(jArr[i], KeccakRhoOffsets[i]);
        }
    }

    public static void theta(long[] jArr) {
        long j = (((jArr[0] ^ jArr[5]) ^ jArr[10]) ^ jArr[15]) ^ jArr[20];
        long j2 = (((jArr[1] ^ jArr[6]) ^ jArr[11]) ^ jArr[16]) ^ jArr[21];
        long j3 = (((jArr[2] ^ jArr[7]) ^ jArr[12]) ^ jArr[17]) ^ jArr[22];
        long j4 = (((jArr[3] ^ jArr[8]) ^ jArr[13]) ^ jArr[18]) ^ jArr[23];
        long j5 = (((jArr[4] ^ jArr[9]) ^ jArr[14]) ^ jArr[19]) ^ jArr[24];
        long leftRotate = leftRotate(j2, 1) ^ j5;
        jArr[0] = jArr[0] ^ leftRotate;
        jArr[5] = jArr[5] ^ leftRotate;
        jArr[10] = jArr[10] ^ leftRotate;
        jArr[15] = jArr[15] ^ leftRotate;
        jArr[20] = jArr[20] ^ leftRotate;
        long leftRotate2 = leftRotate(j3, 1) ^ j;
        jArr[1] = jArr[1] ^ leftRotate2;
        jArr[6] = jArr[6] ^ leftRotate2;
        jArr[11] = jArr[11] ^ leftRotate2;
        jArr[16] = jArr[16] ^ leftRotate2;
        jArr[21] = leftRotate2 ^ jArr[21];
        long leftRotate3 = leftRotate(j4, 1) ^ j2;
        jArr[2] = jArr[2] ^ leftRotate3;
        jArr[7] = jArr[7] ^ leftRotate3;
        jArr[12] = jArr[12] ^ leftRotate3;
        jArr[17] = jArr[17] ^ leftRotate3;
        jArr[22] = leftRotate3 ^ jArr[22];
        long leftRotate4 = leftRotate(j5, 1) ^ j3;
        jArr[3] = jArr[3] ^ leftRotate4;
        jArr[8] = jArr[8] ^ leftRotate4;
        jArr[13] = jArr[13] ^ leftRotate4;
        jArr[18] = jArr[18] ^ leftRotate4;
        jArr[23] = leftRotate4 ^ jArr[23];
        long leftRotate5 = leftRotate(j, 1) ^ j4;
        jArr[4] = jArr[4] ^ leftRotate5;
        jArr[9] = jArr[9] ^ leftRotate5;
        jArr[14] = jArr[14] ^ leftRotate5;
        jArr[19] = jArr[19] ^ leftRotate5;
        jArr[24] = leftRotate5 ^ jArr[24];
    }

    public void absorb(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.bitsInQueue;
        if (i4 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            int i5 = i4 >> 3;
            int i6 = this.rate >> 3;
            int i7 = 0;
            while (i7 < i2) {
                if (i5 != 0 || i7 > (i3 = i2 - i6)) {
                    int min = Math.min(i6 - i5, i2 - i7);
                    System.arraycopy(bArr, i + i7, this.dataQueue, i5, min);
                    i5 += min;
                    i7 += min;
                    if (i5 == i6) {
                        KeccakAbsorb(this.dataQueue, 0);
                        i5 = 0;
                    }
                } else {
                    do {
                        KeccakAbsorb(bArr, i + i7);
                        i7 += i6;
                    } while (i7 <= i3);
                }
            }
            this.bitsInQueue = i5 << 3;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public void absorbBits(int i, int i2) {
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i3 = this.bitsInQueue;
        if (i3 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            this.dataQueue[i3 >> 3] = (byte) (i & ((1 << i2) - 1));
            this.bitsInQueue = i3 + i2;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public int doFinal(byte[] bArr, int i) {
        squeeze(bArr, i, (long) this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    public int doFinal(byte[] bArr, int i, byte b2, int i2) {
        if (i2 > 0) {
            absorbBits(b2, i2);
        }
        squeeze(bArr, i, (long) this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    public String getAlgorithmName() {
        StringBuilder n = a.n("Keccak-");
        n.append(this.fixedOutputLength);
        return n.toString();
    }

    public int getByteLength() {
        return this.rate / 8;
    }

    public int getDigestSize() {
        return this.fixedOutputLength / 8;
    }

    public void reset() {
        init(this.fixedOutputLength);
    }

    public void squeeze(byte[] bArr, int i, long j) {
        if (!this.squeezing) {
            padAndSwitchToSqueezingPhase();
        }
        long j2 = 0;
        if (j % 8 == 0) {
            while (j2 < j) {
                if (this.bitsInQueue == 0) {
                    KeccakPermutation();
                    KeccakExtract();
                    this.bitsInQueue = this.rate;
                }
                int min = (int) Math.min((long) this.bitsInQueue, j - j2);
                System.arraycopy(this.dataQueue, (this.rate - this.bitsInQueue) / 8, bArr, ((int) (j2 / 8)) + i, min / 8);
                this.bitsInQueue -= min;
                j2 += (long) min;
            }
            return;
        }
        throw new IllegalStateException("outputLength not a multiple of 8");
    }

    public void update(byte b2) {
        absorb(new byte[]{b2}, 0, 1);
    }

    public void update(byte[] bArr, int i, int i2) {
        absorb(bArr, i, i2);
    }
}

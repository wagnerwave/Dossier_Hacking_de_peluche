package com.tuya.spongycastle.crypto.generators;

import androidx.core.view.InputDeviceCompat;
import com.tuya.spongycastle.crypto.DerivationParameters;
import com.tuya.spongycastle.crypto.Digest;
import com.tuya.spongycastle.crypto.DigestDerivationFunction;
import com.tuya.spongycastle.crypto.OutputLengthException;
import com.tuya.spongycastle.crypto.params.ISO18033KDFParameters;
import com.tuya.spongycastle.crypto.params.KDFParameters;
import com.tuya.spongycastle.util.Pack;

public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    public int counterStart;
    public Digest digest;
    public byte[] iv;
    public byte[] shared;

    public BaseKDFBytesGenerator(int i, Digest digest2) {
        this.counterStart = i;
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        int i4 = i;
        if (bArr2.length - i3 >= i4) {
            long j = (long) i3;
            int digestSize = this.digest.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = (long) digestSize;
                int i5 = (int) (((j + j2) - 1) / j2);
                byte[] bArr3 = new byte[this.digest.getDigestSize()];
                byte[] bArr4 = new byte[4];
                Pack.intToBigEndian(this.counterStart, bArr4, 0);
                int i6 = this.counterStart & InputDeviceCompat.SOURCE_ANY;
                for (int i7 = 0; i7 < i5; i7++) {
                    Digest digest2 = this.digest;
                    byte[] bArr5 = this.shared;
                    digest2.update(bArr5, 0, bArr5.length);
                    this.digest.update(bArr4, 0, 4);
                    byte[] bArr6 = this.iv;
                    if (bArr6 != null) {
                        this.digest.update(bArr6, 0, bArr6.length);
                    }
                    this.digest.doFinal(bArr3, 0);
                    if (i3 > digestSize) {
                        System.arraycopy(bArr3, 0, bArr2, i4, digestSize);
                        i4 += digestSize;
                        i3 -= digestSize;
                    } else {
                        System.arraycopy(bArr3, 0, bArr2, i4, i3);
                    }
                    byte b2 = (byte) (bArr4[3] + 1);
                    bArr4[3] = b2;
                    if (b2 == 0) {
                        i6 += 256;
                        Pack.intToBigEndian(i6, bArr4, 0);
                    }
                }
                this.digest.reset();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            this.iv = kDFParameters.getIV();
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
            this.iv = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
    }
}

package com.tuya.spongycastle.crypto.params;

import com.tuya.spongycastle.crypto.DerivationParameters;

public class KDFParameters implements DerivationParameters {
    public byte[] iv;
    public byte[] shared;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.shared = bArr;
        this.iv = bArr2;
    }

    public byte[] getIV() {
        return this.iv;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }
}

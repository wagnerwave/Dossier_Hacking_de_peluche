package com.tuya.spongycastle.crypto.params;

import com.tuya.spongycastle.crypto.DerivationParameters;

public class ISO18033KDFParameters implements DerivationParameters {
    public byte[] seed;

    public ISO18033KDFParameters(byte[] bArr) {
        this.seed = bArr;
    }

    public byte[] getSeed() {
        return this.seed;
    }
}

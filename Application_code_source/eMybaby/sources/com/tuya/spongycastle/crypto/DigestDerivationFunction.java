package com.tuya.spongycastle.crypto;

public interface DigestDerivationFunction extends DerivationFunction {
    Digest getDigest();
}

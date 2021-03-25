package com.tuya.spongycastle.crypto.params;

import com.tuya.spongycastle.crypto.CipherParameters;
import java.security.SecureRandom;

public class ParametersWithRandom implements CipherParameters {
    public CipherParameters parameters;
    public SecureRandom random;

    public ParametersWithRandom(CipherParameters cipherParameters) {
        this(cipherParameters, new SecureRandom());
    }

    public ParametersWithRandom(CipherParameters cipherParameters, SecureRandom secureRandom) {
        this.random = secureRandom;
        this.parameters = cipherParameters;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }

    public SecureRandom getRandom() {
        return this.random;
    }
}

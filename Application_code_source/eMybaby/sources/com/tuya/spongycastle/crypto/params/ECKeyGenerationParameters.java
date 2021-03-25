package com.tuya.spongycastle.crypto.params;

import com.tuya.spongycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class ECKeyGenerationParameters extends KeyGenerationParameters {
    public ECDomainParameters domainParams;

    public ECKeyGenerationParameters(ECDomainParameters eCDomainParameters, SecureRandom secureRandom) {
        super(secureRandom, eCDomainParameters.getN().bitLength());
        this.domainParams = eCDomainParameters;
    }

    public ECDomainParameters getDomainParameters() {
        return this.domainParams;
    }
}

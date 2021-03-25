package com.tuya.spongycastle.crypto.params;

public class ECKeyParameters extends AsymmetricKeyParameter {
    public ECDomainParameters params;

    public ECKeyParameters(boolean z, ECDomainParameters eCDomainParameters) {
        super(z);
        this.params = eCDomainParameters;
    }

    public ECDomainParameters getParameters() {
        return this.params;
    }
}

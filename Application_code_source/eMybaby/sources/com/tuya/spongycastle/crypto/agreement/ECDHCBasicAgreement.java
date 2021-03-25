package com.tuya.spongycastle.crypto.agreement;

import com.tuya.spongycastle.crypto.BasicAgreement;
import com.tuya.spongycastle.crypto.CipherParameters;
import com.tuya.spongycastle.crypto.params.ECDomainParameters;
import com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.math.ec.ECPoint;
import java.math.BigInteger;

public class ECDHCBasicAgreement implements BasicAgreement {
    public ECPrivateKeyParameters key;

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        if (parameters.equals(this.key.getParameters())) {
            ECPoint normalize = eCPublicKeyParameters.getQ().multiply(parameters.getH().multiply(this.key.getD()).mod(parameters.getN())).normalize();
            if (!normalize.isInfinity()) {
                return normalize.getAffineXCoord().toBigInteger();
            }
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
        }
        throw new IllegalStateException("ECDHC public key has wrong domain parameters");
    }

    public int getFieldSize() {
        return (this.key.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.key = (ECPrivateKeyParameters) cipherParameters;
    }
}

package com.tuya.spongycastle.crypto.agreement;

import com.tuya.spongycastle.crypto.BasicAgreement;
import com.tuya.spongycastle.crypto.CipherParameters;
import com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.math.ec.ECPoint;
import java.math.BigInteger;

public class ECDHBasicAgreement implements BasicAgreement {
    public ECPrivateKeyParameters key;

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        if (eCPublicKeyParameters.getParameters().equals(this.key.getParameters())) {
            ECPoint normalize = eCPublicKeyParameters.getQ().multiply(this.key.getD()).normalize();
            if (!normalize.isInfinity()) {
                return normalize.getAffineXCoord().toBigInteger();
            }
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
        }
        throw new IllegalStateException("ECDH public key has wrong domain parameters");
    }

    public int getFieldSize() {
        return (this.key.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.key = (ECPrivateKeyParameters) cipherParameters;
    }
}

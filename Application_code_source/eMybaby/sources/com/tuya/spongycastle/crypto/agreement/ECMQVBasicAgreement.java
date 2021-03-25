package com.tuya.spongycastle.crypto.agreement;

import com.tuya.spongycastle.crypto.BasicAgreement;
import com.tuya.spongycastle.crypto.CipherParameters;
import com.tuya.spongycastle.crypto.params.ECDomainParameters;
import com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.crypto.params.MQVPrivateParameters;
import com.tuya.spongycastle.crypto.params.MQVPublicParameters;
import com.tuya.spongycastle.math.ec.ECAlgorithms;
import com.tuya.spongycastle.math.ec.ECConstants;
import com.tuya.spongycastle.math.ec.ECCurve;
import com.tuya.spongycastle.math.ec.ECPoint;
import com.tuya.spongycastle.util.Properties;
import java.math.BigInteger;

public class ECMQVBasicAgreement implements BasicAgreement {
    public MQVPrivateParameters privParams;

    private ECPoint calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        BigInteger n = eCDomainParameters.getN();
        int bitLength = (n.bitLength() + 1) / 2;
        BigInteger shiftLeft = ECConstants.ONE.shiftLeft(bitLength);
        ECCurve curve = eCDomainParameters.getCurve();
        ECPoint[] eCPointArr = {ECAlgorithms.importPoint(curve, eCPublicKeyParameters.getQ()), ECAlgorithms.importPoint(curve, eCPublicKeyParameters2.getQ()), ECAlgorithms.importPoint(curve, eCPublicKeyParameters3.getQ())};
        curve.normalizeAll(eCPointArr);
        ECPoint eCPoint = eCPointArr[0];
        ECPoint eCPoint2 = eCPointArr[1];
        ECPoint eCPoint3 = eCPointArr[2];
        BigInteger mod = eCPrivateKeyParameters.getD().multiply(eCPoint.getAffineXCoord().toBigInteger().mod(shiftLeft).setBit(bitLength)).add(eCPrivateKeyParameters2.getD()).mod(n);
        BigInteger bit = eCPoint3.getAffineXCoord().toBigInteger().mod(shiftLeft).setBit(bitLength);
        BigInteger mod2 = eCDomainParameters.getH().multiply(mod).mod(n);
        return ECAlgorithms.sumOfTwoMultiplies(eCPoint2, bit.multiply(mod2).mod(n), eCPoint3, mod2);
    }

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        if (!Properties.isOverrideSet("com.tuya.spongycastle.ec.disable_mqv")) {
            MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
            ECPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
            ECDomainParameters parameters = staticPrivateKey.getParameters();
            if (parameters.equals(mQVPublicParameters.getStaticPublicKey().getParameters())) {
                ECPoint normalize = calculateMqvAgreement(parameters, staticPrivateKey, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey()).normalize();
                if (!normalize.isInfinity()) {
                    return normalize.getAffineXCoord().toBigInteger();
                }
                throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
            }
            throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
        }
        throw new IllegalStateException("ECMQV explicitly disabled");
    }

    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.privParams = (MQVPrivateParameters) cipherParameters;
    }
}

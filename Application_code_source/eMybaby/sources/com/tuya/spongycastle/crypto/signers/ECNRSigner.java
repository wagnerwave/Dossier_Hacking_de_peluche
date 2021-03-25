package com.tuya.spongycastle.crypto.signers;

import com.tuya.spongycastle.crypto.AsymmetricCipherKeyPair;
import com.tuya.spongycastle.crypto.CipherParameters;
import com.tuya.spongycastle.crypto.DSA;
import com.tuya.spongycastle.crypto.DataLengthException;
import com.tuya.spongycastle.crypto.generators.ECKeyPairGenerator;
import com.tuya.spongycastle.crypto.params.ECKeyGenerationParameters;
import com.tuya.spongycastle.crypto.params.ECKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.crypto.params.ParametersWithRandom;
import com.tuya.spongycastle.math.ec.ECAlgorithms;
import com.tuya.spongycastle.math.ec.ECConstants;
import com.tuya.spongycastle.math.ec.ECPoint;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ECNRSigner implements DSA {
    public boolean forSigning;
    public ECKeyParameters key;
    public SecureRandom random;

    public BigInteger[] generateSignature(byte[] bArr) {
        AsymmetricCipherKeyPair generateKeyPair;
        BigInteger mod;
        if (this.forSigning) {
            BigInteger n = ((ECPrivateKeyParameters) this.key).getParameters().getN();
            int bitLength = n.bitLength();
            BigInteger bigInteger = new BigInteger(1, bArr);
            int bitLength2 = bigInteger.bitLength();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.key;
            if (bitLength2 <= bitLength) {
                do {
                    ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                    eCKeyPairGenerator.init(new ECKeyGenerationParameters(eCPrivateKeyParameters.getParameters(), this.random));
                    generateKeyPair = eCKeyPairGenerator.generateKeyPair();
                    mod = ((ECPublicKeyParameters) generateKeyPair.getPublic()).getQ().getAffineXCoord().toBigInteger().add(bigInteger).mod(n);
                } while (mod.equals(ECConstants.ZERO));
                return new BigInteger[]{mod, ((ECPrivateKeyParameters) generateKeyPair.getPrivate()).getD().subtract(mod.multiply(eCPrivateKeyParameters.getD())).mod(n)};
            }
            throw new DataLengthException("input too large for ECNR key.");
        }
        throw new IllegalStateException("not initialised for signing");
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        ECKeyParameters eCKeyParameters;
        this.forSigning = z;
        if (!z) {
            eCKeyParameters = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            this.key = (ECPrivateKeyParameters) parametersWithRandom.getParameters();
            return;
        } else {
            this.random = new SecureRandom();
            eCKeyParameters = (ECPrivateKeyParameters) cipherParameters;
        }
        this.key = eCKeyParameters;
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (!this.forSigning) {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) this.key;
            BigInteger n = eCPublicKeyParameters.getParameters().getN();
            int bitLength = n.bitLength();
            BigInteger bigInteger3 = new BigInteger(1, bArr);
            if (bigInteger3.bitLength() > bitLength) {
                throw new DataLengthException("input too large for ECNR key.");
            } else if (bigInteger.compareTo(ECConstants.ONE) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(ECConstants.ZERO) < 0 || bigInteger2.compareTo(n) >= 0) {
                return false;
            } else {
                ECPoint normalize = ECAlgorithms.sumOfTwoMultiplies(eCPublicKeyParameters.getParameters().getG(), bigInteger2, eCPublicKeyParameters.getQ(), bigInteger).normalize();
                if (normalize.isInfinity()) {
                    return false;
                }
                return bigInteger.subtract(normalize.getAffineXCoord().toBigInteger()).mod(n).equals(bigInteger3);
            }
        } else {
            throw new IllegalStateException("not initialised for verifying");
        }
    }
}

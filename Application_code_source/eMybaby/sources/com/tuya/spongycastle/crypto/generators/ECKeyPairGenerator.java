package com.tuya.spongycastle.crypto.generators;

import com.tuya.spongycastle.crypto.AsymmetricCipherKeyPair;
import com.tuya.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.tuya.spongycastle.crypto.KeyGenerationParameters;
import com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter;
import com.tuya.spongycastle.crypto.params.ECDomainParameters;
import com.tuya.spongycastle.crypto.params.ECKeyGenerationParameters;
import com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.math.ec.ECConstants;
import com.tuya.spongycastle.math.ec.ECMultiplier;
import com.tuya.spongycastle.math.ec.FixedPointCombMultiplier;
import com.tuya.spongycastle.math.ec.WNafUtil;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, ECConstants {
    public ECDomainParameters params;
    public SecureRandom random;

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger n = this.params.getN();
        int bitLength = n.bitLength();
        int i = bitLength >>> 2;
        while (true) {
            BigInteger bigInteger = new BigInteger(bitLength, this.random);
            if (bigInteger.compareTo(ECConstants.TWO) >= 0 && bigInteger.compareTo(n) < 0 && WNafUtil.getNafWeight(bigInteger) >= i) {
                return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECPublicKeyParameters(createBasePointMultiplier().multiply(this.params.getG(), bigInteger), this.params), (AsymmetricKeyParameter) new ECPrivateKeyParameters(bigInteger, this.params));
            }
        }
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        ECKeyGenerationParameters eCKeyGenerationParameters = (ECKeyGenerationParameters) keyGenerationParameters;
        this.random = eCKeyGenerationParameters.getRandom();
        this.params = eCKeyGenerationParameters.getDomainParameters();
        if (this.random == null) {
            this.random = new SecureRandom();
        }
    }
}

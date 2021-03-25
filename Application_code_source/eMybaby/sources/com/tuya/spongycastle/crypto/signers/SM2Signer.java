package com.tuya.spongycastle.crypto.signers;

import com.tuya.spongycastle.crypto.CipherParameters;
import com.tuya.spongycastle.crypto.DSA;
import com.tuya.spongycastle.crypto.Digest;
import com.tuya.spongycastle.crypto.digests.SM3Digest;
import com.tuya.spongycastle.crypto.params.ECDomainParameters;
import com.tuya.spongycastle.crypto.params.ECKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPrivateKeyParameters;
import com.tuya.spongycastle.crypto.params.ECPublicKeyParameters;
import com.tuya.spongycastle.crypto.params.ParametersWithID;
import com.tuya.spongycastle.crypto.params.ParametersWithRandom;
import com.tuya.spongycastle.math.ec.ECConstants;
import com.tuya.spongycastle.math.ec.ECFieldElement;
import com.tuya.spongycastle.math.ec.ECMultiplier;
import com.tuya.spongycastle.math.ec.ECPoint;
import com.tuya.spongycastle.math.ec.FixedPointCombMultiplier;
import com.tuya.spongycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class SM2Signer implements DSA, ECConstants {
    public int curveLength;
    public ECKeyParameters ecKey;
    public ECDomainParameters ecParams;
    public final DSAKCalculator kCalculator = new RandomDSAKCalculator();
    public ECPoint pubPoint;
    public SecureRandom random;
    public byte[] userID;

    private void addFieldElement(Digest digest, ECFieldElement eCFieldElement) {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.curveLength, eCFieldElement.toBigInteger());
        digest.update(asUnsignedByteArray, 0, asUnsignedByteArray.length);
    }

    private void addUserID(Digest digest, byte[] bArr) {
        int length = bArr.length * 8;
        digest.update((byte) ((length >> 8) & 255));
        digest.update((byte) (length & 255));
        digest.update(bArr, 0, bArr.length);
    }

    private byte[] getZ(Digest digest) {
        addUserID(digest, this.userID);
        addFieldElement(digest, this.ecParams.getCurve().getA());
        addFieldElement(digest, this.ecParams.getCurve().getB());
        addFieldElement(digest, this.ecParams.getG().getAffineXCoord());
        addFieldElement(digest, this.ecParams.getG().getAffineYCoord());
        addFieldElement(digest, this.pubPoint.getAffineXCoord());
        addFieldElement(digest, this.pubPoint.getAffineYCoord());
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return bArr;
    }

    public BigInteger calculateE(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public BigInteger[] generateSignature(byte[] bArr) {
        SM3Digest sM3Digest = new SM3Digest();
        byte[] z = getZ(sM3Digest);
        sM3Digest.update(z, 0, z.length);
        sM3Digest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sM3Digest.getDigestSize()];
        sM3Digest.doFinal(bArr2, 0);
        BigInteger n = this.ecParams.getN();
        BigInteger calculateE = calculateE(bArr2);
        BigInteger d2 = ((ECPrivateKeyParameters) this.ecKey).getD();
        ECMultiplier createBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger nextK = this.kCalculator.nextK();
            BigInteger mod = calculateE.add(createBasePointMultiplier.multiply(this.ecParams.getG(), nextK).normalize().getAffineXCoord().toBigInteger()).mod(n);
            if (!mod.equals(ECConstants.ZERO) && !mod.add(nextK).equals(n)) {
                BigInteger mod2 = d2.add(ECConstants.ONE).modInverse(n).multiply(nextK.subtract(mod.multiply(d2)).mod(n)).mod(n);
                if (!mod2.equals(ECConstants.ZERO)) {
                    return new BigInteger[]{mod, mod2};
                }
            }
        }
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        ECPoint eCPoint;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            CipherParameters parameters = parametersWithID.getParameters();
            this.userID = parametersWithID.getID();
            cipherParameters = parameters;
        } else {
            this.userID = new byte[0];
        }
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                ECKeyParameters eCKeyParameters = (ECKeyParameters) parametersWithRandom.getParameters();
                this.ecKey = eCKeyParameters;
                ECDomainParameters parameters2 = eCKeyParameters.getParameters();
                this.ecParams = parameters2;
                this.kCalculator.init(parameters2.getN(), parametersWithRandom.getRandom());
            } else {
                ECKeyParameters eCKeyParameters2 = (ECKeyParameters) cipherParameters;
                this.ecKey = eCKeyParameters2;
                ECDomainParameters parameters3 = eCKeyParameters2.getParameters();
                this.ecParams = parameters3;
                this.kCalculator.init(parameters3.getN(), new SecureRandom());
            }
            eCPoint = this.ecParams.getG().multiply(((ECPrivateKeyParameters) this.ecKey).getD()).normalize();
        } else {
            ECKeyParameters eCKeyParameters3 = (ECKeyParameters) cipherParameters;
            this.ecKey = eCKeyParameters3;
            this.ecParams = eCKeyParameters3.getParameters();
            eCPoint = ((ECPublicKeyParameters) this.ecKey).getQ();
        }
        this.pubPoint = eCPoint;
        this.curveLength = (this.ecParams.getCurve().getFieldSize() + 7) / 8;
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger n = this.ecParams.getN();
        if (bigInteger.compareTo(ECConstants.ONE) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(ECConstants.ONE) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        ECPoint q = ((ECPublicKeyParameters) this.ecKey).getQ();
        SM3Digest sM3Digest = new SM3Digest();
        byte[] z = getZ(sM3Digest);
        sM3Digest.update(z, 0, z.length);
        sM3Digest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sM3Digest.getDigestSize()];
        sM3Digest.doFinal(bArr2, 0);
        BigInteger calculateE = calculateE(bArr2);
        BigInteger mod = bigInteger.add(bigInteger2).mod(n);
        if (mod.equals(ECConstants.ZERO)) {
            return false;
        }
        return bigInteger.equals(calculateE.add(this.ecParams.getG().multiply(bigInteger2).add(q.multiply(mod)).normalize().getAffineXCoord().toBigInteger()).mod(n));
    }
}

package com.tuya.spongycastle.jcajce.provider.asymmetric.ec;

import com.tuya.spongycastle.asn1.ASN1EncodableVector;
import com.tuya.spongycastle.asn1.ASN1Encoding;
import com.tuya.spongycastle.asn1.ASN1Integer;
import com.tuya.spongycastle.asn1.ASN1Primitive;
import com.tuya.spongycastle.asn1.ASN1Sequence;
import com.tuya.spongycastle.asn1.DERSequence;
import com.tuya.spongycastle.crypto.DSA;
import com.tuya.spongycastle.crypto.Digest;
import com.tuya.spongycastle.crypto.digests.SM3Digest;
import com.tuya.spongycastle.crypto.params.AsymmetricKeyParameter;
import com.tuya.spongycastle.crypto.params.ParametersWithRandom;
import com.tuya.spongycastle.crypto.signers.SM2Signer;
import com.tuya.spongycastle.jcajce.provider.asymmetric.util.DSABase;
import com.tuya.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import com.tuya.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.tuya.spongycastle.util.Arrays;
import java.io.IOException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class GMSignatureSpi extends DSABase {

    public static class StdDSAEncoder implements DSAEncoder {
        public StdDSAEncoder() {
        }

        public BigInteger[] decode(byte[] bArr) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.fromByteArray(bArr);
            if (aSN1Sequence.size() != 2) {
                throw new IOException("malformed signature");
            } else if (Arrays.areEqual(bArr, aSN1Sequence.getEncoded(ASN1Encoding.DER))) {
                return new BigInteger[]{ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue(), ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue()};
            } else {
                throw new IOException("malformed signature");
            }
        }

        public byte[] encode(BigInteger bigInteger, BigInteger bigInteger2) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
            aSN1EncodableVector.add(new ASN1Integer(bigInteger2));
            return new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
        }
    }

    public static class sm3WithSM2 extends GMSignatureSpi {
        public sm3WithSM2() {
            super(new SM3Digest(), new SM2Signer(), new StdDSAEncoder());
        }
    }

    public GMSignatureSpi(Digest digest, DSA dsa, DSAEncoder dSAEncoder) {
        super(digest, dsa, dSAEncoder);
    }

    public void engineInitSign(PrivateKey privateKey) {
        AsymmetricKeyParameter generatePrivateKeyParameter = ECUtil.generatePrivateKeyParameter(privateKey);
        this.digest.reset();
        SecureRandom secureRandom = this.appRandom;
        if (secureRandom != null) {
            this.signer.init(true, new ParametersWithRandom(generatePrivateKeyParameter, secureRandom));
        } else {
            this.signer.init(true, generatePrivateKeyParameter);
        }
    }

    public void engineInitVerify(PublicKey publicKey) {
        AsymmetricKeyParameter generatePublicKeyParameter = ECUtils.generatePublicKeyParameter(publicKey);
        this.digest.reset();
        this.signer.init(false, generatePublicKeyParameter);
    }
}

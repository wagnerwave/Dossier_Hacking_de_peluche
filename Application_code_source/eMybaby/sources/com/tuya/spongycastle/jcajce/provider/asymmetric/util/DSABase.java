package com.tuya.spongycastle.jcajce.provider.asymmetric.util;

import com.tuya.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.tuya.spongycastle.asn1.x509.X509ObjectIdentifiers;
import com.tuya.spongycastle.crypto.DSA;
import com.tuya.spongycastle.crypto.Digest;
import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;

public abstract class DSABase extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public Digest digest;
    public DSAEncoder encoder;
    public DSA signer;

    public DSABase(Digest digest2, DSA dsa, DSAEncoder dSAEncoder) {
        this.digest = digest2;
        this.signer = dsa;
        this.encoder = dSAEncoder;
    }

    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public byte[] engineSign() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        try {
            BigInteger[] generateSignature = this.signer.generateSignature(bArr);
            return this.encoder.encode(generateSignature[0], generateSignature[1]);
        } catch (Exception e2) {
            throw new SignatureException(e2.toString());
        }
    }

    public void engineUpdate(byte b2) {
        this.digest.update(b2);
    }

    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }

    public boolean engineVerify(byte[] bArr) {
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr2, 0);
        try {
            BigInteger[] decode = this.encoder.decode(bArr);
            return this.signer.verifySignature(bArr2, decode[0], decode[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}

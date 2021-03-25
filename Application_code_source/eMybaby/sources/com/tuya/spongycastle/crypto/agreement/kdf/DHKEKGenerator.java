package com.tuya.spongycastle.crypto.agreement.kdf;

import a.a.a.a.a;
import com.tuya.spongycastle.asn1.ASN1EncodableVector;
import com.tuya.spongycastle.asn1.ASN1Encoding;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.DEROctetString;
import com.tuya.spongycastle.asn1.DERSequence;
import com.tuya.spongycastle.asn1.DERTaggedObject;
import com.tuya.spongycastle.crypto.DerivationFunction;
import com.tuya.spongycastle.crypto.DerivationParameters;
import com.tuya.spongycastle.crypto.Digest;
import com.tuya.spongycastle.crypto.OutputLengthException;
import com.tuya.spongycastle.util.Pack;
import java.io.IOException;

public class DHKEKGenerator implements DerivationFunction {
    public ASN1ObjectIdentifier algorithm;
    public final Digest digest;
    public int keySize;
    public byte[] partyAInfo;
    public byte[] z;

    public DHKEKGenerator(Digest digest2) {
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 >= i) {
            long j = (long) i2;
            int digestSize = this.digest.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = (long) digestSize;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr2 = new byte[this.digest.getDigestSize()];
                int i4 = 0;
                int i5 = 0;
                int i6 = 1;
                while (i5 < i3) {
                    Digest digest2 = this.digest;
                    byte[] bArr3 = this.z;
                    digest2.update(bArr3, i4, bArr3.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(this.algorithm);
                    aSN1EncodableVector2.add(new DEROctetString(Pack.intToBigEndian(i6)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    byte[] bArr4 = this.partyAInfo;
                    if (bArr4 != null) {
                        aSN1EncodableVector.add(new DERTaggedObject(true, i4, new DEROctetString(bArr4)));
                    }
                    aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(Pack.intToBigEndian(this.keySize))));
                    try {
                        byte[] encoded = new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
                        this.digest.update(encoded, 0, encoded.length);
                        this.digest.doFinal(bArr2, 0);
                        if (i2 > digestSize) {
                            System.arraycopy(bArr2, 0, bArr, i, digestSize);
                            i += digestSize;
                            i2 -= digestSize;
                        } else {
                            System.arraycopy(bArr2, 0, bArr, i, i2);
                        }
                        i6++;
                        i5++;
                        i4 = 0;
                    } catch (IOException e2) {
                        StringBuilder n = a.n("unable to encode parameter info: ");
                        n.append(e2.getMessage());
                        throw new IllegalArgumentException(n.toString());
                    }
                }
                this.digest.reset();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.keySize = dHKDFParameters.getKeySize();
        this.z = dHKDFParameters.getZ();
        this.partyAInfo = dHKDFParameters.getExtraInfo();
    }
}

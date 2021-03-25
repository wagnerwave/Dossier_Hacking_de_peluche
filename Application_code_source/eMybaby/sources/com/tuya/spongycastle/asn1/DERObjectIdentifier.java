package com.tuya.spongycastle.asn1;

public class DERObjectIdentifier extends ASN1ObjectIdentifier {
    public DERObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        super(aSN1ObjectIdentifier, str);
    }

    public DERObjectIdentifier(String str) {
        super(str);
    }

    public DERObjectIdentifier(byte[] bArr) {
        super(bArr);
    }
}

package com.tuya.spongycastle.asn1;

import java.math.BigInteger;

public class DEREnumerated extends ASN1Enumerated {
    public DEREnumerated(int i) {
        super(i);
    }

    public DEREnumerated(BigInteger bigInteger) {
        super(bigInteger);
    }

    public DEREnumerated(byte[] bArr) {
        super(bArr);
    }
}

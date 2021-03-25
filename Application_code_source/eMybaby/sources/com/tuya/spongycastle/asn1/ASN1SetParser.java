package com.tuya.spongycastle.asn1;

public interface ASN1SetParser extends ASN1Encodable, InMemoryRepresentable {
    ASN1Encodable readObject();
}

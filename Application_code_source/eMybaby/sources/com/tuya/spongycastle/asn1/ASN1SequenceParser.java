package com.tuya.spongycastle.asn1;

public interface ASN1SequenceParser extends ASN1Encodable, InMemoryRepresentable {
    ASN1Encodable readObject();
}

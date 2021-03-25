package com.tuya.spongycastle.jce.interfaces;

import com.tuya.spongycastle.asn1.ASN1Encodable;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import java.util.Enumeration;

public interface PKCS12BagAttributeCarrier {
    ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier);

    Enumeration getBagAttributeKeys();

    void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable);
}

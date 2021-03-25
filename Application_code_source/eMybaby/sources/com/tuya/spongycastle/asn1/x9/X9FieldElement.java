package com.tuya.spongycastle.asn1.x9;

import com.tuya.spongycastle.asn1.ASN1Object;
import com.tuya.spongycastle.asn1.ASN1OctetString;
import com.tuya.spongycastle.asn1.ASN1Primitive;
import com.tuya.spongycastle.asn1.DEROctetString;
import com.tuya.spongycastle.math.ec.ECFieldElement;
import java.math.BigInteger;

public class X9FieldElement extends ASN1Object {
    public static X9IntegerConverter converter = new X9IntegerConverter();
    public ECFieldElement f;

    public X9FieldElement(int i, int i2, int i3, int i4, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.F2m(i, i2, i3, i4, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f = eCFieldElement;
    }

    public X9FieldElement(BigInteger bigInteger, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.Fp(bigInteger, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public ECFieldElement getValue() {
        return this.f;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(converter.integerToBytes(this.f.toBigInteger(), converter.getByteLength(this.f)));
    }
}

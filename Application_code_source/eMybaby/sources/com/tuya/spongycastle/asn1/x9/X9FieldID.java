package com.tuya.spongycastle.asn1.x9;

import com.tuya.spongycastle.asn1.ASN1EncodableVector;
import com.tuya.spongycastle.asn1.ASN1Integer;
import com.tuya.spongycastle.asn1.ASN1Object;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import com.tuya.spongycastle.asn1.ASN1Primitive;
import com.tuya.spongycastle.asn1.ASN1Sequence;
import com.tuya.spongycastle.asn1.DERSequence;
import java.math.BigInteger;

public class X9FieldID extends ASN1Object implements X9ObjectIdentifiers {
    public ASN1ObjectIdentifier id;
    public ASN1Primitive parameters;

    public X9FieldID(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public X9FieldID(int i, int i2, int i3, int i4) {
        this.id = X9ObjectIdentifiers.characteristic_two_field;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) i));
        if (i3 == 0) {
            if (i4 == 0) {
                aSN1EncodableVector.add(X9ObjectIdentifiers.tpBasis);
                aSN1EncodableVector.add(new ASN1Integer((long) i2));
            } else {
                throw new IllegalArgumentException("inconsistent k values");
            }
        } else if (i3 <= i2 || i4 <= i3) {
            throw new IllegalArgumentException("inconsistent k values");
        } else {
            aSN1EncodableVector.add(X9ObjectIdentifiers.ppBasis);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new ASN1Integer((long) i2));
            aSN1EncodableVector2.add(new ASN1Integer((long) i3));
            aSN1EncodableVector2.add(new ASN1Integer((long) i4));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        this.parameters = new DERSequence(aSN1EncodableVector);
    }

    public X9FieldID(ASN1Sequence aSN1Sequence) {
        this.id = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.parameters = aSN1Sequence.getObjectAt(1).toASN1Primitive();
    }

    public X9FieldID(BigInteger bigInteger) {
        this.id = X9ObjectIdentifiers.prime_field;
        this.parameters = new ASN1Integer(bigInteger);
    }

    public static X9FieldID getInstance(Object obj) {
        if (obj instanceof X9FieldID) {
            return (X9FieldID) obj;
        }
        if (obj != null) {
            return new X9FieldID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.id;
    }

    public ASN1Primitive getParameters() {
        return this.parameters;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.id);
        aSN1EncodableVector.add(this.parameters);
        return new DERSequence(aSN1EncodableVector);
    }
}

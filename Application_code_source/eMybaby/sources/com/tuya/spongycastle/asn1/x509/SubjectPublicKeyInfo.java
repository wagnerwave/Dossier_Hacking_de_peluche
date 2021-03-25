package com.tuya.spongycastle.asn1.x509;

import a.a.a.a.a;
import com.tuya.spongycastle.asn1.ASN1Encodable;
import com.tuya.spongycastle.asn1.ASN1EncodableVector;
import com.tuya.spongycastle.asn1.ASN1InputStream;
import com.tuya.spongycastle.asn1.ASN1Object;
import com.tuya.spongycastle.asn1.ASN1Primitive;
import com.tuya.spongycastle.asn1.ASN1Sequence;
import com.tuya.spongycastle.asn1.ASN1TaggedObject;
import com.tuya.spongycastle.asn1.DERBitString;
import com.tuya.spongycastle.asn1.DERSequence;
import java.util.Enumeration;

public class SubjectPublicKeyInfo extends ASN1Object {
    public AlgorithmIdentifier algId;
    public DERBitString keyData;

    public SubjectPublicKeyInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.algId = AlgorithmIdentifier.getInstance(objects.nextElement());
            this.keyData = DERBitString.getInstance(objects.nextElement());
            return;
        }
        StringBuilder n = a.n("Bad sequence size: ");
        n.append(aSN1Sequence.size());
        throw new IllegalArgumentException(n.toString());
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        this.keyData = new DERBitString(aSN1Encodable);
        this.algId = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.keyData = new DERBitString(bArr);
        this.algId = algorithmIdentifier;
    }

    public static SubjectPublicKeyInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static SubjectPublicKeyInfo getInstance(Object obj) {
        if (obj instanceof SubjectPublicKeyInfo) {
            return (SubjectPublicKeyInfo) obj;
        }
        if (obj != null) {
            return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algId;
    }

    public AlgorithmIdentifier getAlgorithmId() {
        return this.algId;
    }

    public ASN1Primitive getPublicKey() {
        return new ASN1InputStream(this.keyData.getOctets()).readObject();
    }

    public DERBitString getPublicKeyData() {
        return this.keyData;
    }

    public ASN1Primitive parsePublicKey() {
        return new ASN1InputStream(this.keyData.getOctets()).readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.algId);
        aSN1EncodableVector.add(this.keyData);
        return new DERSequence(aSN1EncodableVector);
    }
}

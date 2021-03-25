package com.tuya.spongycastle.asn1.pkcs;

import com.tuya.spongycastle.asn1.ASN1Encodable;
import com.tuya.spongycastle.asn1.ASN1EncodableVector;
import com.tuya.spongycastle.asn1.ASN1Encoding;
import com.tuya.spongycastle.asn1.ASN1Integer;
import com.tuya.spongycastle.asn1.ASN1Object;
import com.tuya.spongycastle.asn1.ASN1OctetString;
import com.tuya.spongycastle.asn1.ASN1Primitive;
import com.tuya.spongycastle.asn1.ASN1Sequence;
import com.tuya.spongycastle.asn1.ASN1Set;
import com.tuya.spongycastle.asn1.ASN1TaggedObject;
import com.tuya.spongycastle.asn1.DEROctetString;
import com.tuya.spongycastle.asn1.DERSequence;
import com.tuya.spongycastle.asn1.DERTaggedObject;
import com.tuya.spongycastle.asn1.x509.AlgorithmIdentifier;
import java.io.IOException;
import java.util.Enumeration;

public class PrivateKeyInfo extends ASN1Object {
    public AlgorithmIdentifier algId;
    public ASN1Set attributes;
    public ASN1OctetString privKey;

    public PrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        if (((ASN1Integer) objects.nextElement()).getValue().intValue() == 0) {
            this.algId = AlgorithmIdentifier.getInstance(objects.nextElement());
            this.privKey = ASN1OctetString.getInstance(objects.nextElement());
            if (objects.hasMoreElements()) {
                this.attributes = ASN1Set.getInstance((ASN1TaggedObject) objects.nextElement(), false);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for private key info");
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        this(algorithmIdentifier, aSN1Encodable, (ASN1Set) null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable, ASN1Set aSN1Set) {
        this.privKey = new DEROctetString(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
        this.algId = algorithmIdentifier;
        this.attributes = aSN1Set;
    }

    public static PrivateKeyInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static PrivateKeyInfo getInstance(Object obj) {
        if (obj instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new PrivateKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithmId() {
        return this.algId;
    }

    public ASN1Set getAttributes() {
        return this.attributes;
    }

    public ASN1Primitive getPrivateKey() {
        try {
            return parsePrivateKey().toASN1Primitive();
        } catch (IOException unused) {
            throw new IllegalStateException("unable to parse private key");
        }
    }

    public AlgorithmIdentifier getPrivateKeyAlgorithm() {
        return this.algId;
    }

    public ASN1Encodable parsePrivateKey() {
        return ASN1Primitive.fromByteArray(this.privKey.getOctets());
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(0));
        aSN1EncodableVector.add(this.algId);
        aSN1EncodableVector.add(this.privKey);
        ASN1Set aSN1Set = this.attributes;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}

package com.tuya.spongycastle.asn1;

import a.a.a.a.a;
import com.tuya.spongycastle.util.Arrays;
import com.tuya.spongycastle.util.Strings;

public class DERGraphicString extends ASN1Primitive implements ASN1String {
    public final byte[] string;

    public DERGraphicString(byte[] bArr) {
        this.string = Arrays.clone(bArr);
    }

    public static DERGraphicString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DERGraphicString)) ? getInstance(object) : new DERGraphicString(((ASN1OctetString) object).getOctets());
    }

    public static DERGraphicString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERGraphicString)) {
            return (DERGraphicString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERGraphicString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException(a.f(e2, a.n("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException(a.g(obj, a.n("illegal object in getInstance: ")));
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERGraphicString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((DERGraphicString) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(25, this.string);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public byte[] getOctets() {
        return Arrays.clone(this.string);
    }

    public String getString() {
        return Strings.fromByteArray(this.string);
    }

    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    public boolean isConstructed() {
        return false;
    }
}

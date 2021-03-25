package com.tuya.spongycastle.asn1;

import a.a.a.a.a;
import com.tuya.spongycastle.util.Arrays;
import com.tuya.spongycastle.util.Strings;

public class DERVisibleString extends ASN1Primitive implements ASN1String {
    public final byte[] string;

    public DERVisibleString(String str) {
        this.string = Strings.toByteArray(str);
    }

    public DERVisibleString(byte[] bArr) {
        this.string = bArr;
    }

    public static DERVisibleString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DERVisibleString)) ? getInstance(object) : new DERVisibleString(ASN1OctetString.getInstance(object).getOctets());
    }

    public static DERVisibleString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERVisibleString)) {
            return (DERVisibleString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERVisibleString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException(a.f(e2, a.n("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException(a.g(obj, a.n("illegal object in getInstance: ")));
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERVisibleString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((DERVisibleString) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(26, this.string);
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

    public String toString() {
        return getString();
    }
}

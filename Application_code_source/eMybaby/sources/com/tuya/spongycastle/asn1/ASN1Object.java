package com.tuya.spongycastle.asn1;

import com.tuya.spongycastle.util.Encodable;
import java.io.ByteArrayOutputStream;

public abstract class ASN1Object implements ASN1Encodable, Encodable {
    public static boolean hasEncodedTagValue(Object obj, int i) {
        return (obj instanceof byte[]) && ((byte[]) obj)[0] == i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ASN1Encodable)) {
            return false;
        }
        return toASN1Primitive().equals(((ASN1Encodable) obj).toASN1Primitive());
    }

    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ASN1OutputStream(byteArrayOutputStream).writeObject(this);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getEncoded(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (str.equals(ASN1Encoding.DER)) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            new DEROutputStream(byteArrayOutputStream).writeObject(this);
        } else if (!str.equals(ASN1Encoding.DL)) {
            return getEncoded();
        } else {
            byteArrayOutputStream = new ByteArrayOutputStream();
            new DLOutputStream(byteArrayOutputStream).writeObject(this);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return toASN1Primitive().hashCode();
    }

    public ASN1Primitive toASN1Object() {
        return toASN1Primitive();
    }

    public abstract ASN1Primitive toASN1Primitive();
}

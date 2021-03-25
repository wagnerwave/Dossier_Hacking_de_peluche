package com.tuya.spongycastle.asn1;

import a.a.a.a.a;
import java.io.IOException;

public abstract class ASN1Null extends ASN1Primitive {
    public static ASN1Null getInstance(Object obj) {
        if (obj instanceof ASN1Null) {
            return (ASN1Null) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
        } catch (IOException e2) {
            StringBuilder n = a.n("failed to construct NULL from byte[]: ");
            n.append(e2.getMessage());
            throw new IllegalArgumentException(n.toString());
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(a.g(obj, a.n("unknown object in getInstance(): ")));
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return aSN1Primitive instanceof ASN1Null;
    }

    public abstract void encode(ASN1OutputStream aSN1OutputStream);

    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}

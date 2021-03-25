package com.tuya.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class LazyConstructionEnumeration implements Enumeration {
    public ASN1InputStream aIn;
    public Object nextObj = readObject();

    public LazyConstructionEnumeration(byte[] bArr) {
        this.aIn = new ASN1InputStream(bArr, true);
    }

    private Object readObject() {
        try {
            return this.aIn.readObject();
        } catch (IOException e2) {
            throw new ASN1ParsingException("malformed DER construction: " + e2, e2);
        }
    }

    public boolean hasMoreElements() {
        return this.nextObj != null;
    }

    public Object nextElement() {
        Object obj = this.nextObj;
        this.nextObj = readObject();
        return obj;
    }
}

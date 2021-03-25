package com.tuya.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class DEROutputStream extends ASN1OutputStream {
    public DEROutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public ASN1OutputStream getDERSubStream() {
        return this;
    }

    public ASN1OutputStream getDLSubStream() {
        return this;
    }

    public void writeObject(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1Encodable.toASN1Primitive().toDERObject().encode(this);
            return;
        }
        throw new IOException("null object detected");
    }
}

package com.tuya.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class DERSequenceGenerator extends DERGenerator {
    public final ByteArrayOutputStream _bOut = new ByteArrayOutputStream();

    public DERSequenceGenerator(OutputStream outputStream) {
        super(outputStream);
    }

    public DERSequenceGenerator(OutputStream outputStream, int i, boolean z) {
        super(outputStream, i, z);
    }

    public void addObject(ASN1Encodable aSN1Encodable) {
        aSN1Encodable.toASN1Primitive().encode(new DEROutputStream(this._bOut));
    }

    public void close() {
        writeDEREncoded(48, this._bOut.toByteArray());
    }

    public OutputStream getRawOutputStream() {
        return this._bOut;
    }
}

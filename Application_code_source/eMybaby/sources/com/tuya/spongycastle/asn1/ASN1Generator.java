package com.tuya.spongycastle.asn1;

import java.io.OutputStream;

public abstract class ASN1Generator {
    public OutputStream _out;

    public ASN1Generator(OutputStream outputStream) {
        this._out = outputStream;
    }

    public abstract OutputStream getRawOutputStream();
}

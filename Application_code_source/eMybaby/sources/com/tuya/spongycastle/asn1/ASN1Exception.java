package com.tuya.spongycastle.asn1;

import java.io.IOException;

public class ASN1Exception extends IOException {
    public Throwable cause;

    public ASN1Exception(String str) {
        super(str);
    }

    public ASN1Exception(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }
}

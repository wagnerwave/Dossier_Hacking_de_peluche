package com.tuya.spongycastle.asn1;

public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE = new DERNull();
    public static final byte[] zeroBytes = new byte[0];

    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(5, zeroBytes);
    }

    public int encodedLength() {
        return 2;
    }

    public boolean isConstructed() {
        return false;
    }
}

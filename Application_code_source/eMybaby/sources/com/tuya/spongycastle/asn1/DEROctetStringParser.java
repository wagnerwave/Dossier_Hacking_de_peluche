package com.tuya.spongycastle.asn1;

import a.a.a.a.a;
import java.io.IOException;
import java.io.InputStream;

public class DEROctetStringParser implements ASN1OctetStringParser {
    public DefiniteLengthInputStream stream;

    public DEROctetStringParser(DefiniteLengthInputStream definiteLengthInputStream) {
        this.stream = definiteLengthInputStream;
    }

    public ASN1Primitive getLoadedObject() {
        return new DEROctetString(this.stream.toByteArray());
    }

    public InputStream getOctetStream() {
        return this.stream;
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            StringBuilder n = a.n("IOException converting stream to byte array: ");
            n.append(e2.getMessage());
            throw new ASN1ParsingException(n.toString(), e2);
        }
    }
}

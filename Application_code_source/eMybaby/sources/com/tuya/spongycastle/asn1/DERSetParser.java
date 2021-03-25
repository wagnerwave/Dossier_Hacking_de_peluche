package com.tuya.spongycastle.asn1;

import java.io.IOException;

public class DERSetParser implements ASN1SetParser {
    public ASN1StreamParser _parser;

    public DERSetParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() {
        return new DERSet(this._parser.readVector(), false);
    }

    public ASN1Encodable readObject() {
        return this._parser.readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new ASN1ParsingException(e2.getMessage(), e2);
        }
    }
}

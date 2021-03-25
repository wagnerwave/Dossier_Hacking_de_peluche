package com.tuya.spongycastle.asn1;

import java.io.IOException;

public class DERSequenceParser implements ASN1SequenceParser {
    public ASN1StreamParser _parser;

    public DERSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() {
        return new DERSequence(this._parser.readVector());
    }

    public ASN1Encodable readObject() {
        return this._parser.readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }
}

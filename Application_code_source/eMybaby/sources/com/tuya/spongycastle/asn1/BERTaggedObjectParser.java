package com.tuya.spongycastle.asn1;

import java.io.IOException;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    public boolean _constructed;
    public ASN1StreamParser _parser;
    public int _tagNumber;

    public BERTaggedObjectParser(boolean z, int i, ASN1StreamParser aSN1StreamParser) {
        this._constructed = z;
        this._tagNumber = i;
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() {
        return this._parser.readTaggedObject(this._constructed, this._tagNumber);
    }

    public ASN1Encodable getObjectParser(int i, boolean z) {
        if (!z) {
            return this._parser.readImplicit(this._constructed, i);
        }
        if (this._constructed) {
            return this._parser.readObject();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    public int getTagNo() {
        return this._tagNumber;
    }

    public boolean isConstructed() {
        return this._constructed;
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new ASN1ParsingException(e2.getMessage());
        }
    }
}

package com.tuya.spongycastle.asn1;

import java.io.InputStream;

public abstract class LimitedInputStream extends InputStream {
    public final InputStream _in;
    public int _limit;

    public LimitedInputStream(InputStream inputStream, int i) {
        this._in = inputStream;
        this._limit = i;
    }

    public int getRemaining() {
        return this._limit;
    }

    public void setParentEofDetect(boolean z) {
        InputStream inputStream = this._in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z);
        }
    }
}

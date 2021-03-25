package com.tuya.spongycastle.crypto.generators;

import com.tuya.spongycastle.crypto.Digest;

public class KDF2BytesGenerator extends BaseKDFBytesGenerator {
    public KDF2BytesGenerator(Digest digest) {
        super(1, digest);
    }
}

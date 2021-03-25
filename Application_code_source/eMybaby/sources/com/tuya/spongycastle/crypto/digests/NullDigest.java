package com.tuya.spongycastle.crypto.digests;

import com.tuya.spongycastle.crypto.Digest;
import java.io.ByteArrayOutputStream;

public class NullDigest implements Digest {
    public ByteArrayOutputStream bOut = new ByteArrayOutputStream();

    public int doFinal(byte[] bArr, int i) {
        byte[] byteArray = this.bOut.toByteArray();
        System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
        reset();
        return byteArray.length;
    }

    public String getAlgorithmName() {
        return "NULL";
    }

    public int getDigestSize() {
        return this.bOut.size();
    }

    public void reset() {
        this.bOut.reset();
    }

    public void update(byte b2) {
        this.bOut.write(b2);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.bOut.write(bArr, i, i2);
    }
}

package com.tuya.spongycastle.crypto.params;

import com.tuya.spongycastle.crypto.CipherParameters;

public class KeyParameter implements CipherParameters {
    public byte[] key;

    public KeyParameter(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public KeyParameter(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.key = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public byte[] getKey() {
        return this.key;
    }
}

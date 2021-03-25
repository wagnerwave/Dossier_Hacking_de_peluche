package com.tuya.spongycastle.crypto.params;

import com.tuya.spongycastle.crypto.CipherParameters;

public class AEADParameters implements CipherParameters {
    public byte[] associatedText;
    public KeyParameter key;
    public int macSize;
    public byte[] nonce;

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr) {
        this(keyParameter, i, bArr, (byte[]) null);
    }

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr, byte[] bArr2) {
        this.key = keyParameter;
        this.nonce = bArr;
        this.macSize = i;
        this.associatedText = bArr2;
    }

    public byte[] getAssociatedText() {
        return this.associatedText;
    }

    public KeyParameter getKey() {
        return this.key;
    }

    public int getMacSize() {
        return this.macSize;
    }

    public byte[] getNonce() {
        return this.nonce;
    }
}

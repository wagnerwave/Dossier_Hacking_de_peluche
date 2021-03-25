package com.tuya.spongycastle.crypto.params;

import com.tuya.spongycastle.crypto.CipherParameters;

public class ParametersWithID implements CipherParameters {
    public byte[] id;
    public CipherParameters parameters;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.id = bArr;
    }

    public byte[] getID() {
        return this.id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}

package com.tuya.spongycastle.crypto.modes;

import com.tuya.spongycastle.crypto.BlockCipher;
import com.tuya.spongycastle.crypto.CipherParameters;

public interface AEADBlockCipher {
    int doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int i);

    BlockCipher getUnderlyingCipher();

    int getUpdateOutputSize(int i);

    void init(boolean z, CipherParameters cipherParameters);

    void processAADByte(byte b2);

    void processAADBytes(byte[] bArr, int i, int i2);

    int processByte(byte b2, byte[] bArr, int i);

    int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    void reset();
}

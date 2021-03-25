package com.tuya.spongycastle.crypto;

public abstract class StreamBlockCipher implements BlockCipher, StreamCipher {
    public final BlockCipher cipher;

    public StreamBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
    }

    public abstract byte calculateByte(byte b2);

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i + i2;
        if (i4 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        } else if (i3 + i2 <= bArr2.length) {
            while (i < i4) {
                bArr2[i3] = calculateByte(bArr[i]);
                i3++;
                i++;
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final byte returnByte(byte b2) {
        return calculateByte(b2);
    }
}

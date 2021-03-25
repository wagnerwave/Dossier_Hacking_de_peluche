package com.tuya.spongycastle.crypto.macs;

import com.tuya.spongycastle.crypto.BlockCipher;
import com.tuya.spongycastle.crypto.CipherParameters;
import com.tuya.spongycastle.crypto.Mac;
import com.tuya.spongycastle.crypto.modes.CBCBlockCipher;
import com.tuya.spongycastle.crypto.paddings.BlockCipherPadding;

public class CBCBlockCipherMac implements Mac {
    public byte[] buf;
    public int bufOff;
    public BlockCipher cipher;
    public byte[] mac;
    public int macSize;
    public BlockCipherPadding padding;

    public CBCBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2, (BlockCipherPadding) null);
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i) {
        this(blockCipher, i, (BlockCipherPadding) null);
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i, BlockCipherPadding blockCipherPadding) {
        if (i % 8 == 0) {
            this.cipher = new CBCBlockCipher(blockCipher);
            this.padding = blockCipherPadding;
            this.macSize = i / 8;
            this.mac = new byte[blockCipher.getBlockSize()];
            this.buf = new byte[blockCipher.getBlockSize()];
            this.bufOff = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }

    public int doFinal(byte[] bArr, int i) {
        int blockSize = this.cipher.getBlockSize();
        if (this.padding == null) {
            while (true) {
                int i2 = this.bufOff;
                if (i2 >= blockSize) {
                    break;
                }
                this.buf[i2] = 0;
                this.bufOff = i2 + 1;
            }
        } else {
            if (this.bufOff == blockSize) {
                this.cipher.processBlock(this.buf, 0, this.mac, 0);
                this.bufOff = 0;
            }
            this.padding.addPadding(this.buf, this.bufOff);
        }
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        System.arraycopy(this.mac, 0, bArr, i, this.macSize);
        reset();
        return this.macSize;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void init(CipherParameters cipherParameters) {
        reset();
        this.cipher.init(true, cipherParameters);
    }

    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            }
        }
    }

    public void update(byte b2) {
        int i = this.bufOff;
        byte[] bArr = this.buf;
        if (i == bArr.length) {
            this.cipher.processBlock(bArr, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i2 = this.bufOff;
        this.bufOff = i2 + 1;
        bArr2[i2] = b2;
    }

    public void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int blockSize = this.cipher.getBlockSize();
            int i3 = this.bufOff;
            int i4 = blockSize - i3;
            if (i2 > i4) {
                System.arraycopy(bArr, i, this.buf, i3, i4);
                this.cipher.processBlock(this.buf, 0, this.mac, 0);
                this.bufOff = 0;
                i2 -= i4;
                i += i4;
                while (i2 > blockSize) {
                    this.cipher.processBlock(bArr, i, this.mac, 0);
                    i2 -= blockSize;
                    i += blockSize;
                }
            }
            System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
            this.bufOff += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}

package com.tuya.spongycastle.crypto.macs;

import a.a.a.a.a;
import com.tuya.spongycastle.crypto.CipherParameters;
import com.tuya.spongycastle.crypto.Digest;
import com.tuya.spongycastle.crypto.ExtendedDigest;
import com.tuya.spongycastle.crypto.Mac;
import com.tuya.spongycastle.crypto.params.KeyParameter;
import com.tuya.spongycastle.util.Integers;
import com.tuya.spongycastle.util.Memoable;
import java.util.Hashtable;

public class HMac implements Mac {
    public static final byte IPAD = 54;
    public static final byte OPAD = 92;
    public static Hashtable blockLengths;
    public int blockLength;
    public Digest digest;
    public int digestSize;
    public byte[] inputPad;
    public Memoable ipadState;
    public Memoable opadState;
    public byte[] outputBuf;

    static {
        Hashtable hashtable = new Hashtable();
        blockLengths = hashtable;
        hashtable.put("GOST3411", Integers.valueOf(32));
        blockLengths.put("MD2", Integers.valueOf(16));
        blockLengths.put("MD4", Integers.valueOf(64));
        blockLengths.put("MD5", Integers.valueOf(64));
        blockLengths.put("RIPEMD128", Integers.valueOf(64));
        blockLengths.put("RIPEMD160", Integers.valueOf(64));
        blockLengths.put("SHA-1", Integers.valueOf(64));
        blockLengths.put("SHA-224", Integers.valueOf(64));
        blockLengths.put("SHA-256", Integers.valueOf(64));
        blockLengths.put("SHA-384", Integers.valueOf(128));
        blockLengths.put("SHA-512", Integers.valueOf(128));
        blockLengths.put("Tiger", Integers.valueOf(64));
        blockLengths.put("Whirlpool", Integers.valueOf(64));
    }

    public HMac(Digest digest2) {
        this(digest2, getByteLength(digest2));
    }

    public HMac(Digest digest2, int i) {
        this.digest = digest2;
        int digestSize2 = digest2.getDigestSize();
        this.digestSize = digestSize2;
        this.blockLength = i;
        this.inputPad = new byte[i];
        this.outputBuf = new byte[(i + digestSize2)];
    }

    public static int getByteLength(Digest digest2) {
        if (digest2 instanceof ExtendedDigest) {
            return ((ExtendedDigest) digest2).getByteLength();
        }
        Integer num = (Integer) blockLengths.get(digest2.getAlgorithmName());
        if (num != null) {
            return num.intValue();
        }
        StringBuilder n = a.n("unknown digest passed: ");
        n.append(digest2.getAlgorithmName());
        throw new IllegalArgumentException(n.toString());
    }

    public static void xorPad(byte[] bArr, int i, byte b2) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ b2);
        }
    }

    public int doFinal(byte[] bArr, int i) {
        this.digest.doFinal(this.outputBuf, this.blockLength);
        Memoable memoable = this.opadState;
        if (memoable != null) {
            ((Memoable) this.digest).reset(memoable);
            Digest digest2 = this.digest;
            digest2.update(this.outputBuf, this.blockLength, digest2.getDigestSize());
        } else {
            Digest digest3 = this.digest;
            byte[] bArr2 = this.outputBuf;
            digest3.update(bArr2, 0, bArr2.length);
        }
        int doFinal = this.digest.doFinal(bArr, i);
        int i2 = this.blockLength;
        while (true) {
            byte[] bArr3 = this.outputBuf;
            if (i2 >= bArr3.length) {
                break;
            }
            bArr3[i2] = 0;
            i2++;
        }
        Memoable memoable2 = this.ipadState;
        if (memoable2 != null) {
            ((Memoable) this.digest).reset(memoable2);
        } else {
            Digest digest4 = this.digest;
            byte[] bArr4 = this.inputPad;
            digest4.update(bArr4, 0, bArr4.length);
        }
        return doFinal;
    }

    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "/HMAC";
    }

    public int getMacSize() {
        return this.digestSize;
    }

    public Digest getUnderlyingDigest() {
        return this.digest;
    }

    public void init(CipherParameters cipherParameters) {
        byte[] bArr;
        this.digest.reset();
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        int length = key.length;
        if (length > this.blockLength) {
            this.digest.update(key, 0, length);
            this.digest.doFinal(this.inputPad, 0);
            length = this.digestSize;
        } else {
            System.arraycopy(key, 0, this.inputPad, 0, length);
        }
        while (true) {
            bArr = this.inputPad;
            if (length >= bArr.length) {
                break;
            }
            bArr[length] = 0;
            length++;
        }
        System.arraycopy(bArr, 0, this.outputBuf, 0, this.blockLength);
        xorPad(this.inputPad, this.blockLength, IPAD);
        xorPad(this.outputBuf, this.blockLength, OPAD);
        Digest digest2 = this.digest;
        if (digest2 instanceof Memoable) {
            Memoable copy = ((Memoable) digest2).copy();
            this.opadState = copy;
            ((Digest) copy).update(this.outputBuf, 0, this.blockLength);
        }
        Digest digest3 = this.digest;
        byte[] bArr2 = this.inputPad;
        digest3.update(bArr2, 0, bArr2.length);
        Digest digest4 = this.digest;
        if (digest4 instanceof Memoable) {
            this.ipadState = ((Memoable) digest4).copy();
        }
    }

    public void reset() {
        this.digest.reset();
        Digest digest2 = this.digest;
        byte[] bArr = this.inputPad;
        digest2.update(bArr, 0, bArr.length);
    }

    public void update(byte b2) {
        this.digest.update(b2);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}

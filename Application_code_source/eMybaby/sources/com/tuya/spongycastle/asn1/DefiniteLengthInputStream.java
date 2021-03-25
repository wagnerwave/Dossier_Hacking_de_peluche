package com.tuya.spongycastle.asn1;

import a.a.a.a.a;
import com.tuya.spongycastle.util.io.Streams;
import java.io.EOFException;
import java.io.InputStream;

public class DefiniteLengthInputStream extends LimitedInputStream {
    public static final byte[] EMPTY_BYTES = new byte[0];
    public final int _originalLength;
    public int _remaining;

    public DefiniteLengthInputStream(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i >= 0) {
            this._originalLength = i;
            this._remaining = i;
            if (i == 0) {
                setParentEofDetect(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    public int getRemaining() {
        return this._remaining;
    }

    public int read() {
        if (this._remaining == 0) {
            return -1;
        }
        int read = this._in.read();
        if (read >= 0) {
            int i = this._remaining - 1;
            this._remaining = i;
            if (i == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        StringBuilder n = a.n("DEF length ");
        n.append(this._originalLength);
        n.append(" object truncated by ");
        n.append(this._remaining);
        throw new EOFException(n.toString());
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = this._remaining;
        if (i3 == 0) {
            return -1;
        }
        int read = this._in.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            int i4 = this._remaining - read;
            this._remaining = i4;
            if (i4 == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        StringBuilder n = a.n("DEF length ");
        n.append(this._originalLength);
        n.append(" object truncated by ");
        n.append(this._remaining);
        throw new EOFException(n.toString());
    }

    public byte[] toByteArray() {
        int i = this._remaining;
        if (i == 0) {
            return EMPTY_BYTES;
        }
        byte[] bArr = new byte[i];
        int readFully = i - Streams.readFully(this._in, bArr);
        this._remaining = readFully;
        if (readFully == 0) {
            setParentEofDetect(true);
            return bArr;
        }
        StringBuilder n = a.n("DEF length ");
        n.append(this._originalLength);
        n.append(" object truncated by ");
        n.append(this._remaining);
        throw new EOFException(n.toString());
    }
}

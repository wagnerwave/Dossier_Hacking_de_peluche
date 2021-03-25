package com.tuya.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class ASN1OutputStream {
    public OutputStream os;

    public class ImplicitOutputStream extends ASN1OutputStream {
        public boolean first = true;

        public ImplicitOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public void write(int i) {
            if (this.first) {
                this.first = false;
            } else {
                ASN1OutputStream.super.write(i);
            }
        }
    }

    public ASN1OutputStream(OutputStream outputStream) {
        this.os = outputStream;
    }

    public void close() {
        this.os.close();
    }

    public void flush() {
        this.os.flush();
    }

    public ASN1OutputStream getDERSubStream() {
        return new DEROutputStream(this.os);
    }

    public ASN1OutputStream getDLSubStream() {
        return new DLOutputStream(this.os);
    }

    public void write(int i) {
        this.os.write(i);
    }

    public void write(byte[] bArr) {
        this.os.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.os.write(bArr, i, i2);
    }

    public void writeEncoded(int i, int i2, byte[] bArr) {
        writeTag(i, i2);
        writeLength(bArr.length);
        write(bArr);
    }

    public void writeEncoded(int i, byte[] bArr) {
        write(i);
        writeLength(bArr.length);
        write(bArr);
    }

    public void writeImplicitObject(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive != null) {
            aSN1Primitive.encode(new ImplicitOutputStream(this.os));
            return;
        }
        throw new IOException("null object detected");
    }

    public void writeLength(int i) {
        if (i > 127) {
            int i2 = i;
            int i3 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i3++;
            }
            write((int) (byte) (i3 | 128));
            for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
                write((int) (byte) (i >> i4));
            }
            return;
        }
        write((int) (byte) i);
    }

    public void writeNull() {
        this.os.write(5);
        this.os.write(0);
    }

    public void writeObject(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1Encodable.toASN1Primitive().encode(this);
            return;
        }
        throw new IOException("null object detected");
    }

    public void writeTag(int i, int i2) {
        if (i2 < 31) {
            write(i | i2);
            return;
        }
        write(i | 31);
        if (i2 < 128) {
            write(i2);
            return;
        }
        byte[] bArr = new byte[5];
        int i3 = 4;
        bArr[4] = (byte) (i2 & 127);
        do {
            i2 >>= 7;
            i3--;
            bArr[i3] = (byte) ((i2 & 127) | 128);
        } while (i2 > 127);
        write(bArr, i3, 5 - i3);
    }
}

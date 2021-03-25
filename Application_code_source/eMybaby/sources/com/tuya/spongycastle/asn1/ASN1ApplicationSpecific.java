package com.tuya.spongycastle.asn1;

import a.a.a.a.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.util.Arrays;
import java.io.IOException;

public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    public final boolean isConstructed;
    public final byte[] octets;
    public final int tag;

    public ASN1ApplicationSpecific(boolean z, int i, byte[] bArr) {
        this.isConstructed = z;
        this.tag = i;
        this.octets = Arrays.clone(bArr);
    }

    public static ASN1ApplicationSpecific getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ApplicationSpecific)) {
            return (ASN1ApplicationSpecific) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e2) {
                StringBuilder n = a.n("Failed to construct object from byte[]: ");
                n.append(e2.getMessage());
                throw new IllegalArgumentException(n.toString());
            }
        } else {
            throw new IllegalArgumentException(a.g(obj, a.n("unknown object in getInstance: ")));
        }
    }

    public static int getLengthOfHeader(byte[] bArr) {
        byte b2 = bArr[1] & AVFrame.FRM_STATE_UNKOWN;
        if (b2 == 128 || b2 <= Byte.MAX_VALUE) {
            return 2;
        }
        byte b3 = b2 & Byte.MAX_VALUE;
        if (b3 <= 4) {
            return b3 + 2;
        }
        throw new IllegalStateException(a.h("DER length more than 4 bytes: ", b3));
    }

    private byte[] replaceTagNumber(int i, byte[] bArr) {
        int i2;
        if ((bArr[0] & 31) == 31) {
            i2 = 2;
            byte b2 = bArr[1] & AVFrame.FRM_STATE_UNKOWN;
            if ((b2 & Byte.MAX_VALUE) != 0) {
                while (b2 >= 0 && (b2 & 128) != 0) {
                    int i3 = i2 + 1;
                    b2 = bArr[i2] & AVFrame.FRM_STATE_UNKOWN;
                    i2 = i3;
                }
            } else {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
        } else {
            i2 = 1;
        }
        int length = (bArr.length - i2) + 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i2, bArr2, 1, length - 1);
        bArr2[0] = (byte) i;
        return bArr2;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1ApplicationSpecific)) {
            return false;
        }
        ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific) aSN1Primitive;
        return this.isConstructed == aSN1ApplicationSpecific.isConstructed && this.tag == aSN1ApplicationSpecific.tag && Arrays.areEqual(this.octets, aSN1ApplicationSpecific.octets);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.octets.length) + StreamUtil.calculateTagLength(this.tag) + this.octets.length;
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public byte[] getContents() {
        return Arrays.clone(this.octets);
    }

    public ASN1Primitive getObject() {
        return ASN1Primitive.fromByteArray(getContents());
    }

    public ASN1Primitive getObject(int i) {
        if (i < 31) {
            byte[] encoded = getEncoded();
            byte[] replaceTagNumber = replaceTagNumber(i, encoded);
            if ((encoded[0] & 32) != 0) {
                replaceTagNumber[0] = (byte) (replaceTagNumber[0] | 32);
            }
            return ASN1Primitive.fromByteArray(replaceTagNumber);
        }
        throw new IOException("unsupported tag number");
    }

    public int hashCode() {
        return (this.isConstructed ^ this.tag) ^ Arrays.hashCode(this.octets) ? 1 : 0;
    }

    public boolean isConstructed() {
        return this.isConstructed;
    }
}

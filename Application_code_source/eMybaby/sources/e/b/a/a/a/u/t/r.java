package e.b.a.a.a.u.t;

import e.b.a.a.a.n;
import e.b.a.a.a.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class r extends u {

    /* renamed from: e  reason: collision with root package name */
    public String[] f5335e;
    public int[] f;
    public int g;

    public r(byte[] bArr) {
        super((byte) 8);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f5339b = dataInputStream.readUnsignedShort();
        boolean z = false;
        this.g = 0;
        this.f5335e = new String[10];
        this.f = new int[10];
        while (!z) {
            try {
                this.f5335e[this.g] = h(dataInputStream);
                int[] iArr = this.f;
                int i = this.g;
                this.g = i + 1;
                iArr[i] = dataInputStream.readByte();
            } catch (Exception unused) {
                z = true;
            }
        }
        dataInputStream.close();
    }

    public r(String[] strArr, int[] iArr) {
        super((byte) 8);
        this.f5335e = strArr;
        this.f = iArr;
        if (strArr.length == iArr.length) {
            this.g = strArr.length;
            for (int validateQos : iArr) {
                o.validateQos(validateQos);
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public byte n() {
        return (byte) ((this.f5340c ? 8 : 0) | 2);
    }

    public byte[] o() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            for (int i = 0; i < this.f5335e.length; i++) {
                k(dataOutputStream, this.f5335e[i]);
                dataOutputStream.writeByte(this.f[i]);
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new n((Throwable) e2);
        }
    }

    public byte[] p() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.f5339b);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new n((Throwable) e2);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" names:[");
        for (int i = 0; i < this.g; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("\"");
            stringBuffer.append(this.f5335e[i]);
            stringBuffer.append("\"");
        }
        stringBuffer.append("] qos:[");
        for (int i2 = 0; i2 < this.g; i2++) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.f[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

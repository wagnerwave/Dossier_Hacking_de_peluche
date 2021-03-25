package e.b.a.a.a.u.t;

import e.b.a.a.a.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class t extends u {

    /* renamed from: e  reason: collision with root package name */
    public String[] f5336e;
    public int f;

    public t(byte[] bArr) {
        super((byte) 10);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f5339b = dataInputStream.readUnsignedShort();
        boolean z = false;
        this.f = 0;
        this.f5336e = new String[10];
        while (!z) {
            try {
                this.f5336e[this.f] = h(dataInputStream);
            } catch (Exception unused) {
                z = true;
            }
        }
        dataInputStream.close();
    }

    public t(String[] strArr) {
        super((byte) 10);
        this.f5336e = strArr;
    }

    public byte n() {
        return (byte) ((this.f5340c ? 8 : 0) | 2);
    }

    public byte[] o() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            for (String k : this.f5336e) {
                k(dataOutputStream, k);
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
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("\"" + this.f5336e[i] + "\"");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

package e.b.a.a.a.u.t;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class c extends b {

    /* renamed from: e  reason: collision with root package name */
    public int f5322e;
    public boolean f;

    public c(byte[] bArr) {
        super((byte) 2);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f = (dataInputStream.readUnsignedByte() & 1) != 1 ? false : true;
        this.f5322e = dataInputStream.readUnsignedByte();
        dataInputStream.close();
    }

    public String m() {
        return "Con";
    }

    public byte[] p() {
        return new byte[0];
    }

    public boolean q() {
        return false;
    }

    public String toString() {
        return String.valueOf(super.toString()) + " session present:" + this.f + " return code: " + this.f5322e;
    }
}

package e.b.a.a.a.u.t;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class n extends h {
    public n(m mVar) {
        super((byte) 6);
        this.f5339b = mVar.f5339b;
    }

    public n(byte[] bArr) {
        super((byte) 6);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f5339b = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte n() {
        return (byte) ((this.f5340c ? 8 : 0) | 2);
    }

    public byte[] p() {
        return j();
    }

    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.f5339b;
    }
}

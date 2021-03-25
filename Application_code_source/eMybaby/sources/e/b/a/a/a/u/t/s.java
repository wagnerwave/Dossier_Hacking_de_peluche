package e.b.a.a.a.u.t;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class s extends b {
    public s(byte[] bArr) {
        super((byte) 11);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f5339b = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte[] p() {
        return new byte[0];
    }
}

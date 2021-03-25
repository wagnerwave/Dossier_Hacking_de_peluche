package e.b.a.a.a.u.t;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class k extends b {
    public k(o oVar) {
        super((byte) 4);
        this.f5339b = oVar.f5339b;
    }

    public k(byte[] bArr) {
        super((byte) 4);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f5339b = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte[] p() {
        return j();
    }
}

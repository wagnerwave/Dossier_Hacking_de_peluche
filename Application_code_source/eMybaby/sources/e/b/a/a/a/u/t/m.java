package e.b.a.a.a.u.t;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class m extends b {
    public m(o oVar) {
        super((byte) 5);
        this.f5339b = oVar.f5339b;
    }

    public m(byte[] bArr) {
        super((byte) 5);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f5339b = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte[] p() {
        return j();
    }
}

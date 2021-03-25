package e.b.a.a.a.u.t;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class l extends b {
    public l(int i) {
        super((byte) 7);
        this.f5339b = i;
    }

    public l(o oVar) {
        super((byte) 7);
        this.f5339b = oVar.f5339b;
    }

    public l(byte[] bArr) {
        super((byte) 7);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f5339b = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte[] p() {
        return j();
    }
}

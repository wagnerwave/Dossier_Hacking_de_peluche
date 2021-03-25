package e.b.a.a.a.u.t;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class q extends b {

    /* renamed from: e  reason: collision with root package name */
    public int[] f5334e;

    public q(byte[] bArr) {
        super((byte) 9);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f5339b = dataInputStream.readUnsignedShort();
        this.f5334e = new int[(bArr.length - 2)];
        int i = 0;
        for (int read = dataInputStream.read(); read != -1; read = dataInputStream.read()) {
            this.f5334e[i] = read;
            i++;
        }
        dataInputStream.close();
    }

    public byte[] p() {
        return new byte[0];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" granted Qos");
        for (int append : this.f5334e) {
            stringBuffer.append(" ");
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }
}

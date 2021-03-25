package e.b.a.a.a.u.t;

import e.b.a.a.a.n;
import e.b.a.a.a.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class d extends u {

    /* renamed from: e  reason: collision with root package name */
    public String f5323e;
    public boolean f;
    public o g;
    public String h;
    public char[] i;
    public int j;
    public String k;
    public int l;

    public d(String str, int i2, boolean z, int i3, String str2, char[] cArr, o oVar, String str3) {
        super((byte) 1);
        this.f5323e = str;
        this.f = z;
        this.j = i3;
        this.h = str2;
        this.i = cArr;
        this.g = oVar;
        this.k = str3;
        this.l = i2;
    }

    public d(byte[] bArr) {
        super((byte) 1);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        h(dataInputStream);
        dataInputStream.readByte();
        dataInputStream.readByte();
        this.j = dataInputStream.readUnsignedShort();
        this.f5323e = h(dataInputStream);
        dataInputStream.close();
    }

    public String m() {
        return "Con";
    }

    public byte n() {
        return 0;
    }

    public byte[] o() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            k(dataOutputStream, this.f5323e);
            if (this.g != null) {
                k(dataOutputStream, this.k);
                dataOutputStream.writeShort(this.g.getPayload().length);
                dataOutputStream.write(this.g.getPayload());
            }
            if (this.h != null) {
                k(dataOutputStream, this.h);
                if (this.i != null) {
                    k(dataOutputStream, new String(this.i));
                }
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new n((Throwable) e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[Catch:{ IOException -> 0x0063 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] p() {
        /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0063 }
            r0.<init>()     // Catch:{ IOException -> 0x0063 }
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0063 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0063 }
            int r2 = r5.l     // Catch:{ IOException -> 0x0063 }
            r3 = 3
            if (r2 != r3) goto L_0x0015
            java.lang.String r2 = "MQIsdp"
        L_0x0011:
            r5.k(r1, r2)     // Catch:{ IOException -> 0x0063 }
            goto L_0x001d
        L_0x0015:
            int r2 = r5.l     // Catch:{ IOException -> 0x0063 }
            r4 = 4
            if (r2 != r4) goto L_0x001d
            java.lang.String r2 = "MQTT"
            goto L_0x0011
        L_0x001d:
            int r2 = r5.l     // Catch:{ IOException -> 0x0063 }
            r1.write(r2)     // Catch:{ IOException -> 0x0063 }
            r2 = 0
            boolean r4 = r5.f     // Catch:{ IOException -> 0x0063 }
            if (r4 == 0) goto L_0x0029
            r2 = 2
            byte r2 = (byte) r2     // Catch:{ IOException -> 0x0063 }
        L_0x0029:
            e.b.a.a.a.o r4 = r5.g     // Catch:{ IOException -> 0x0063 }
            if (r4 == 0) goto L_0x0045
            r2 = r2 | 4
            byte r2 = (byte) r2     // Catch:{ IOException -> 0x0063 }
            e.b.a.a.a.o r4 = r5.g     // Catch:{ IOException -> 0x0063 }
            int r4 = r4.getQos()     // Catch:{ IOException -> 0x0063 }
            int r3 = r4 << 3
            r2 = r2 | r3
            byte r2 = (byte) r2     // Catch:{ IOException -> 0x0063 }
            e.b.a.a.a.o r3 = r5.g     // Catch:{ IOException -> 0x0063 }
            boolean r3 = r3.isRetained()     // Catch:{ IOException -> 0x0063 }
            if (r3 == 0) goto L_0x0045
            r2 = r2 | 32
            byte r2 = (byte) r2     // Catch:{ IOException -> 0x0063 }
        L_0x0045:
            java.lang.String r3 = r5.h     // Catch:{ IOException -> 0x0063 }
            if (r3 == 0) goto L_0x0053
            r2 = r2 | 128(0x80, float:1.794E-43)
            byte r2 = (byte) r2     // Catch:{ IOException -> 0x0063 }
            char[] r3 = r5.i     // Catch:{ IOException -> 0x0063 }
            if (r3 == 0) goto L_0x0053
            r2 = r2 | 64
            byte r2 = (byte) r2     // Catch:{ IOException -> 0x0063 }
        L_0x0053:
            r1.write(r2)     // Catch:{ IOException -> 0x0063 }
            int r2 = r5.j     // Catch:{ IOException -> 0x0063 }
            r1.writeShort(r2)     // Catch:{ IOException -> 0x0063 }
            r1.flush()     // Catch:{ IOException -> 0x0063 }
            byte[] r0 = r0.toByteArray()     // Catch:{ IOException -> 0x0063 }
            return r0
        L_0x0063:
            r0 = move-exception
            e.b.a.a.a.n r1 = new e.b.a.a.a.n
            r1.<init>((java.lang.Throwable) r0)
            goto L_0x006b
        L_0x006a:
            throw r1
        L_0x006b:
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.t.d.p():byte[]");
    }

    public boolean q() {
        return false;
    }

    public String toString() {
        return String.valueOf(super.toString()) + " clientId " + this.f5323e + " keepAliveInterval " + this.j;
    }
}

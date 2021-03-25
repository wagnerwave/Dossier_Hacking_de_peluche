package e.b.a.a.a.u.t;

import a.e.a.a.r.b;
import e.b.a.a.a.n;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public abstract class u {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f5337d = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};

    /* renamed from: a  reason: collision with root package name */
    public byte f5338a;

    /* renamed from: b  reason: collision with root package name */
    public int f5339b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5340c = false;

    public u(byte b2) {
        this.f5338a = b2;
        this.f5339b = 0;
    }

    public static u g(InputStream inputStream) {
        try {
            a aVar = new a(inputStream);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte b2 = (byte) (readUnsignedByte >> 4);
            byte b3 = (byte) (readUnsignedByte & 15);
            long j = (((long) aVar.f5321b) + r(dataInputStream).f5346a) - ((long) aVar.f5321b);
            byte[] bArr = new byte[0];
            if (j > 0) {
                int i = (int) j;
                byte[] bArr2 = new byte[i];
                dataInputStream.readFully(bArr2, 0, i);
                bArr = bArr2;
            }
            if (b2 == 1) {
                return new d(bArr);
            }
            if (b2 == 3) {
                return new o(b3, bArr);
            }
            if (b2 == 4) {
                return new k(bArr);
            }
            if (b2 == 7) {
                return new l(bArr);
            }
            if (b2 == 2) {
                return new c(bArr);
            }
            if (b2 == 12) {
                return new i(b3, bArr);
            }
            if (b2 == 13) {
                return new j();
            }
            if (b2 == 8) {
                return new r(bArr);
            }
            if (b2 == 9) {
                return new q(bArr);
            }
            if (b2 == 10) {
                return new t(bArr);
            }
            if (b2 == 11) {
                return new s(bArr);
            }
            if (b2 == 6) {
                return new n(bArr);
            }
            if (b2 == 5) {
                return new m(bArr);
            }
            if (b2 == 14) {
                return new e(b3, bArr);
            }
            throw b.g(6);
        } catch (IOException e2) {
            throw new n((Throwable) e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] i(long r6) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x0006:
            r2 = 128(0x80, double:6.32E-322)
            long r4 = r6 % r2
            int r5 = (int) r4
            byte r4 = (byte) r5
            long r6 = r6 / r2
            r2 = 0
            int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0016
            r4 = r4 | 128(0x80, float:1.794E-43)
            byte r4 = (byte) r4
        L_0x0016:
            r0.write(r4)
            int r1 = r1 + 1
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0022
            r2 = 4
            if (r1 < r2) goto L_0x0006
        L_0x0022:
            byte[] r6 = r0.toByteArray()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.t.u.i(long):byte[]");
    }

    public static w r(DataInputStream dataInputStream) {
        byte readByte;
        long j = 0;
        int i = 0;
        int i2 = 1;
        do {
            readByte = dataInputStream.readByte();
            i++;
            j += (long) ((readByte & Byte.MAX_VALUE) * i2);
            i2 *= 128;
        } while ((readByte & 128) != 0);
        return new w(j, i);
    }

    public String h(DataInputStream dataInputStream) {
        try {
            byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
            dataInputStream.readFully(bArr);
            return new String(bArr, "UTF-8");
        } catch (IOException e2) {
            throw new n((Throwable) e2);
        }
    }

    public byte[] j() {
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

    public void k(DataOutputStream dataOutputStream, String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            dataOutputStream.write((byte) ((bytes.length >>> 8) & 255));
            dataOutputStream.write((byte) ((bytes.length >>> 0) & 255));
            dataOutputStream.write(bytes);
        } catch (UnsupportedEncodingException e2) {
            throw new n((Throwable) e2);
        } catch (IOException e3) {
            throw new n((Throwable) e3);
        }
    }

    public byte[] l() {
        try {
            byte n = ((this.f5338a & 15) << 4) ^ (n() & 15);
            byte[] p = p();
            int length = p.length + o().length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(n);
            dataOutputStream.write(i((long) length));
            dataOutputStream.write(p);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new n((Throwable) e2);
        }
    }

    public String m() {
        return new Integer(this.f5339b).toString();
    }

    public abstract byte n();

    public byte[] o() {
        return new byte[0];
    }

    public abstract byte[] p();

    public boolean q() {
        return true;
    }

    public void s(int i) {
        this.f5339b = i;
    }

    public String toString() {
        return f5337d[this.f5338a];
    }
}

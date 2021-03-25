package e.b.a.a.a.u.t;

import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.net.SocketTimeoutException;

public class f extends InputStream {
    public static final String g;
    public static final b h;

    /* renamed from: a  reason: collision with root package name */
    public e.b.a.a.a.u.b f5324a = null;

    /* renamed from: b  reason: collision with root package name */
    public DataInputStream f5325b;

    /* renamed from: c  reason: collision with root package name */
    public ByteArrayOutputStream f5326c;

    /* renamed from: d  reason: collision with root package name */
    public long f5327d;

    /* renamed from: e  reason: collision with root package name */
    public long f5328e;
    public byte[] f;

    static {
        String name = f.class.getName();
        g = name;
        h = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public f(e.b.a.a.a.u.b bVar, InputStream inputStream) {
        this.f5324a = bVar;
        this.f5325b = new DataInputStream(inputStream);
        this.f5326c = new ByteArrayOutputStream();
        this.f5327d = -1;
    }

    public final void a() {
        int size = this.f5326c.size();
        long j = this.f5328e;
        int i = size + ((int) j);
        int i2 = (int) (this.f5327d - j);
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    int read = this.f5325b.read(this.f, i + i3, i2 - i3);
                    this.f5324a.q(read);
                    if (read >= 0) {
                        i3 += read;
                    } else {
                        throw new EOFException();
                    }
                } catch (SocketTimeoutException e2) {
                    this.f5328e += (long) i3;
                    throw e2;
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public int available() {
        return this.f5325b.available();
    }

    public u b() {
        try {
            if (this.f5327d < 0) {
                this.f5326c.reset();
                byte readByte = this.f5325b.readByte();
                this.f5324a.q(1);
                byte b2 = (byte) ((readByte >>> 4) & 15);
                if (b2 < 1 || b2 > 14) {
                    throw a.e.a.a.r.b.g(32108);
                }
                this.f5327d = u.r(this.f5325b).f5346a;
                this.f5326c.write(readByte);
                this.f5326c.write(u.i(this.f5327d));
                this.f = new byte[((int) (((long) this.f5326c.size()) + this.f5327d))];
                this.f5328e = 0;
            }
            if (this.f5327d >= 0) {
                a();
                this.f5327d = -1;
                byte[] byteArray = this.f5326c.toByteArray();
                System.arraycopy(byteArray, 0, this.f, 0, byteArray.length);
                u g2 = u.g(new ByteArrayInputStream(this.f));
                try {
                    h.e(g, "readMqttWireMessage", "501", new Object[]{g2});
                    return g2;
                } catch (SocketTimeoutException unused) {
                    return g2;
                }
            }
        } catch (SocketTimeoutException unused2) {
        }
        return null;
    }

    public void close() {
        this.f5325b.close();
    }

    public int read() {
        return this.f5325b.read();
    }
}

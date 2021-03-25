package e.b.a.a.a.u.t;

import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class g extends OutputStream {

    /* renamed from: c  reason: collision with root package name */
    public static final String f5329c;

    /* renamed from: d  reason: collision with root package name */
    public static final b f5330d;

    /* renamed from: a  reason: collision with root package name */
    public e.b.a.a.a.u.b f5331a = null;

    /* renamed from: b  reason: collision with root package name */
    public BufferedOutputStream f5332b;

    static {
        String name = g.class.getName();
        f5329c = name;
        f5330d = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public g(e.b.a.a.a.u.b bVar, OutputStream outputStream) {
        this.f5331a = bVar;
        this.f5332b = new BufferedOutputStream(outputStream);
    }

    public void a(u uVar) {
        byte[] l = uVar.l();
        byte[] o = uVar.o();
        this.f5332b.write(l, 0, l.length);
        this.f5331a.u(l.length);
        int i = 0;
        while (i < o.length) {
            int min = Math.min(1024, o.length - i);
            this.f5332b.write(o, i, min);
            i += 1024;
            this.f5331a.u(min);
        }
        f5330d.e(f5329c, "write", "529", new Object[]{uVar});
    }

    public void close() {
        this.f5332b.close();
    }

    public void flush() {
        this.f5332b.flush();
    }

    public void write(int i) {
        this.f5332b.write(i);
    }

    public void write(byte[] bArr) {
        this.f5332b.write(bArr);
        this.f5331a.u(bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f5332b.write(bArr, i, i2);
        this.f5331a.u(i2);
    }
}

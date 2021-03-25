package e.b.a.a.a.u.s;

import e.b.a.a.a.u.p;
import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import javax.net.SocketFactory;

public class f extends p {
    public static final b m = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", f.class.getName());
    public String g;
    public String h;
    public int i;
    public PipedInputStream j;
    public g k;
    public ByteArrayOutputStream l = new b(this);

    public f(SocketFactory socketFactory, String str, String str2, int i2, String str3) {
        super(socketFactory, str2, i2, str3);
        this.g = str;
        this.h = str2;
        this.i = i2;
        this.j = new PipedInputStream();
        m.i(str3);
    }

    public OutputStream a() {
        return this.l;
    }

    public InputStream b() {
        return this.j;
    }

    public String c() {
        return "ws://" + this.h + ":" + this.i;
    }

    public OutputStream d() {
        return super.a();
    }

    public void start() {
        super.start();
        new e(super.b(), super.a(), this.g, this.h, this.i).a();
        g gVar = new g(super.b(), this.j);
        this.k = gVar;
        gVar.a("webSocketReceiver");
    }

    public void stop() {
        super.a().write(new d((byte) 8, true, "1000".getBytes()).b());
        super.a().flush();
        g gVar = this.k;
        if (gVar != null) {
            gVar.b();
        }
        super.stop();
    }
}

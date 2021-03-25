package e.b.a.a.a.u.s;

import e.b.a.a.a.u.o;
import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import javax.net.ssl.SSLSocketFactory;

public class h extends o {
    public static final b s = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", h.class.getName());
    public PipedInputStream m;
    public g n;
    public String o;
    public String p;
    public int q;
    public ByteArrayOutputStream r = new b(this);

    public h(SSLSocketFactory sSLSocketFactory, String str, String str2, int i, String str3) {
        super(sSLSocketFactory, str2, i, str3);
        this.o = str;
        this.p = str2;
        this.q = i;
        this.m = new PipedInputStream();
        s.i(str3);
    }

    public OutputStream a() {
        return this.r;
    }

    public InputStream b() {
        return this.m;
    }

    public String c() {
        return "wss://" + this.p + ":" + this.q;
    }

    public OutputStream e() {
        return super.a();
    }

    public void start() {
        super.start();
        new e(super.b(), super.a(), this.o, this.p, this.q).a();
        g gVar = new g(super.b(), this.m);
        this.n = gVar;
        gVar.a("WssSocketReceiver");
    }

    public void stop() {
        super.a().write(new d((byte) 8, true, "1000".getBytes()).b());
        super.a().flush();
        g gVar = this.n;
        if (gVar != null) {
            gVar.b();
        }
        super.stop();
    }
}

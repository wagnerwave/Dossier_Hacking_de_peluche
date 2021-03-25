package e.a.a.g0.g;

import e.a.a.c;
import e.a.a.f0.e;
import e.a.a.g;
import e.a.a.h;
import java.io.InputStream;
import java.io.OutputStream;

public class n extends p implements h {
    public g h;
    public boolean i;

    public class a extends e {
        public a(g gVar) {
            super(gVar);
        }

        public InputStream getContent() {
            n.this.i = true;
            return super.getContent();
        }

        public void writeTo(OutputStream outputStream) {
            n.this.i = true;
            super.writeTo(outputStream);
        }
    }

    public n(h hVar) {
        super(hVar);
        g b2 = hVar.b();
        this.h = b2 != null ? new a(b2) : null;
        this.i = false;
    }

    public g b() {
        return this.h;
    }

    public boolean c() {
        c l = l("Expect");
        return l != null && "100-continue".equalsIgnoreCase(l.getValue());
    }

    public boolean w() {
        g gVar = this.h;
        return gVar == null || gVar.isRepeatable() || !this.i;
    }
}

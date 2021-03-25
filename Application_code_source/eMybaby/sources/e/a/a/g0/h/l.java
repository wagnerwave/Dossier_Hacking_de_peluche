package e.a.a.g0.h;

import a.a.a.a.a;
import e.a.a.g0.k.i;
import e.a.a.h0.d;
import e.a.a.l0.b;
import java.io.ByteArrayInputStream;

public class l implements d {

    /* renamed from: a  reason: collision with root package name */
    public final d f5023a;

    /* renamed from: b  reason: collision with root package name */
    public final n f5024b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5025c;

    public l(d dVar, n nVar, String str) {
        this.f5023a = dVar;
        this.f5024b = nVar;
        this.f5025c = str;
    }

    public i a() {
        return this.f5023a.a();
    }

    public void b(String str) {
        this.f5023a.b(str);
        if (this.f5024b.a()) {
            this.f5024b.b(a.k(str, "\r\n").getBytes(this.f5025c));
        }
    }

    public void c(b bVar) {
        this.f5023a.c(bVar);
        if (this.f5024b.a()) {
            this.f5024b.b(a.k(new String(bVar.f5183a, 0, bVar.f5184b), "\r\n").getBytes(this.f5025c));
        }
    }

    public void d(int i) {
        this.f5023a.d(i);
        if (this.f5024b.a()) {
            n nVar = this.f5024b;
            if (nVar != null) {
                nVar.b(new byte[]{(byte) i});
                return;
            }
            throw null;
        }
    }

    public void flush() {
        this.f5023a.flush();
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f5023a.write(bArr, i, i2);
        if (this.f5024b.a()) {
            n nVar = this.f5024b;
            if (nVar == null) {
                throw null;
            } else if (bArr != null) {
                nVar.c(">> ", new ByteArrayInputStream(bArr, i, i2));
            } else {
                throw new IllegalArgumentException("Output may not be null");
            }
        }
    }
}

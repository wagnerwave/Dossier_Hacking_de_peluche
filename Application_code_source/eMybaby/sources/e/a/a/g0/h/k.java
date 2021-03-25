package e.a.a.g0.h;

import a.a.a.a.a;
import e.a.a.g0.k.i;
import e.a.a.h0.b;
import e.a.a.h0.c;
import java.io.ByteArrayInputStream;

public class k implements c, b {

    /* renamed from: a  reason: collision with root package name */
    public final c f5019a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5020b;

    /* renamed from: c  reason: collision with root package name */
    public final n f5021c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5022d;

    public k(c cVar, n nVar, String str) {
        this.f5019a = cVar;
        this.f5020b = (b) cVar;
        this.f5021c = nVar;
        this.f5022d = str;
    }

    public i a() {
        return this.f5019a.a();
    }

    public int b(e.a.a.l0.b bVar) {
        int b2 = this.f5019a.b(bVar);
        if (this.f5021c.a() && b2 >= 0) {
            String k = a.k(new String(bVar.f5183a, bVar.f5184b - b2, b2), "\r\n");
            n nVar = this.f5021c;
            byte[] bytes = k.getBytes(this.f5022d);
            if (nVar == null) {
                throw null;
            } else if (bytes != null) {
                nVar.c("<< ", new ByteArrayInputStream(bytes));
            } else {
                throw new IllegalArgumentException("Input may not be null");
            }
        }
        return b2;
    }

    public boolean c() {
        b bVar = this.f5020b;
        if (bVar != null) {
            return bVar.c();
        }
        return false;
    }

    public boolean d(int i) {
        return this.f5019a.d(i);
    }

    public int read() {
        int read = this.f5019a.read();
        if (this.f5021c.a() && read != -1) {
            n nVar = this.f5021c;
            if (nVar != null) {
                nVar.c("<< ", new ByteArrayInputStream(new byte[]{(byte) read}));
            } else {
                throw null;
            }
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.f5019a.read(bArr, i, i2);
        if (this.f5021c.a() && read > 0) {
            n nVar = this.f5021c;
            if (nVar == null) {
                throw null;
            } else if (bArr != null) {
                nVar.c("<< ", new ByteArrayInputStream(bArr, i, read));
            } else {
                throw new IllegalArgumentException("Input may not be null");
            }
        }
        return read;
    }
}

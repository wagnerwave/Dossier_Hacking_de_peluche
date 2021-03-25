package e.a.a.g0;

import e.a.a.e;
import e.a.a.g;
import e.a.a.g0.j.b;
import e.a.a.g0.j.c;
import e.a.a.g0.j.d;
import e.a.a.g0.k.f;
import e.a.a.g0.k.j;
import e.a.a.g0.k.k;
import e.a.a.h;
import e.a.a.i0.m;
import e.a.a.l;
import e.a.a.o;
import e.a.a.u;
import e.a.a.v;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final b f4937a = new b(new d());

    /* renamed from: b  reason: collision with root package name */
    public final e.a.a.g0.j.a f4938b = new e.a.a.g0.j.a(new c());

    /* renamed from: c  reason: collision with root package name */
    public e.a.a.h0.c f4939c = null;

    /* renamed from: d  reason: collision with root package name */
    public e.a.a.h0.d f4940d = null;

    /* renamed from: e  reason: collision with root package name */
    public e.a.a.h0.b f4941e = null;
    public e.a.a.g0.k.a f = null;
    public e.a.a.g0.k.b g = null;
    public e h = null;

    public void a(o oVar) {
        InputStream inputStream;
        if (oVar != null) {
            i();
            e.a.a.g0.j.a aVar = this.f4938b;
            e.a.a.h0.c cVar = this.f4939c;
            if (aVar == null) {
                throw null;
            } else if (cVar != null) {
                e.a.a.f0.b bVar = new e.a.a.f0.b();
                long a2 = aVar.f5082a.a(oVar);
                if (a2 == -2) {
                    bVar.f4904c = true;
                    bVar.f4906e = -1;
                    inputStream = new e.a.a.g0.k.d(cVar);
                } else if (a2 == -1) {
                    bVar.f4904c = false;
                    bVar.f4906e = -1;
                    inputStream = new j(cVar);
                } else {
                    bVar.f4904c = false;
                    bVar.f4906e = a2;
                    inputStream = new f(cVar, a2);
                }
                bVar.f4905d = inputStream;
                e.a.a.c l = oVar.l("Content-Type");
                if (l != null) {
                    bVar.f4902a = l;
                }
                e.a.a.c l2 = oVar.l("Content-Encoding");
                if (l2 != null) {
                    bVar.f4903b = l2;
                }
                oVar.q(bVar);
            } else {
                throw new IllegalArgumentException("Session input buffer may not be null");
            }
        } else {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
    }

    public boolean d(int i) {
        i();
        return this.f4939c.d(i);
    }

    public o f() {
        i();
        e.a.a.g0.k.a aVar = this.f;
        int i = aVar.f;
        if (i == 0) {
            try {
                aVar.g = aVar.a(aVar.f5084a);
                aVar.f = 1;
            } catch (u e2) {
                throw new v(e2.getMessage(), e2);
            }
        } else if (i != 1) {
            throw new IllegalStateException("Inconsistent parser state");
        }
        aVar.g.r(e.a.a.g0.k.a.b(aVar.f5084a, aVar.f5085b, aVar.f5086c, aVar.f5088e, aVar.f5087d));
        l lVar = aVar.g;
        aVar.g = null;
        aVar.f5087d.clear();
        aVar.f = 0;
        o oVar = (o) lVar;
        if (((m) oVar.s()).f5157b >= 200) {
            this.h.f4946b++;
        }
        return oVar;
    }

    public void flush() {
        i();
        this.f4940d.flush();
    }

    public abstract void i();

    public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        e.a.a.h0.b bVar = this.f4941e;
        if (bVar != null && bVar.c()) {
            return true;
        }
        try {
            this.f4939c.d(1);
            e.a.a.h0.b bVar2 = this.f4941e;
            if (bVar2 == null || !bVar2.c()) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return true;
        }
    }

    public abstract e.a.a.g0.k.a j(e.a.a.h0.c cVar, c cVar2, e.a.a.j0.c cVar3);

    public void sendRequestEntity(h hVar) {
        if (hVar != null) {
            i();
            if (hVar.b() != null) {
                b bVar = this.f4937a;
                e.a.a.h0.d dVar = this.f4940d;
                g b2 = hVar.b();
                if (bVar == null) {
                    throw null;
                } else if (dVar == null) {
                    throw new IllegalArgumentException("Session output buffer may not be null");
                } else if (b2 != null) {
                    long a2 = bVar.f5083a.a(hVar);
                    OutputStream eVar = a2 == -2 ? new e.a.a.g0.k.e(dVar) : a2 == -1 ? new k(dVar) : new e.a.a.g0.k.g(dVar, a2);
                    b2.writeTo(eVar);
                    eVar.close();
                } else {
                    throw new IllegalArgumentException("HTTP entity may not be null");
                }
            }
        } else {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
    }

    public void sendRequestHeader(e.a.a.m mVar) {
        if (mVar != null) {
            i();
            e.a.a.g0.k.b bVar = this.g;
            if (bVar != null) {
                e.a.a.g0.k.h hVar = (e.a.a.g0.k.h) bVar;
                ((e.a.a.i0.h) hVar.f5091c).d(hVar.f5090b, mVar.f());
                hVar.f5089a.c(hVar.f5090b);
                e.a.a.i0.j n = mVar.n();
                while (n.hasNext()) {
                    bVar.f5089a.c(((e.a.a.i0.h) bVar.f5091c).c(bVar.f5090b, n.b()));
                }
                e.a.a.l0.b bVar2 = bVar.f5090b;
                bVar2.f5184b = 0;
                bVar.f5089a.c(bVar2);
                this.h.f4945a++;
                return;
            }
            throw null;
        }
        throw new IllegalArgumentException("HTTP request may not be null");
    }
}

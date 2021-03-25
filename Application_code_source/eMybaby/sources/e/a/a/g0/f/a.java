package e.a.a.g0.f;

import e.a.a.b0.g;
import e.a.a.b0.h;
import e.a.a.b0.j;
import e.a.a.c;
import e.a.a.l0.b;
import e.a.a.m;

public abstract class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4947a;

    public c a(h hVar, m mVar, e.a.a.k0.c cVar) {
        return c(hVar, mVar);
    }

    public void b(c cVar) {
        b bVar;
        if (cVar != null) {
            String name = cVar.getName();
            int i = 0;
            if (name.equalsIgnoreCase("WWW-Authenticate")) {
                this.f4947a = false;
            } else if (name.equalsIgnoreCase("Proxy-Authenticate")) {
                this.f4947a = true;
            } else {
                throw new j(a.a.a.a.a.k("Unexpected header name: ", name));
            }
            if (cVar instanceof e.a.a.b) {
                e.a.a.b bVar2 = (e.a.a.b) cVar;
                bVar = bVar2.b();
                i = bVar2.d();
            } else {
                String value = cVar.getValue();
                if (value != null) {
                    bVar = new b(value.length());
                    bVar.b(value);
                } else {
                    throw new j("Header value is null");
                }
            }
            while (i < bVar.f5184b && a.e.a.a.r.b.N(bVar.f5183a[i])) {
                i++;
            }
            int i2 = i;
            while (i2 < bVar.f5184b && !a.e.a.a.r.b.N(bVar.f5183a[i2])) {
                i2++;
            }
            String h = bVar.h(i, i2);
            if (h.equalsIgnoreCase(g())) {
                h(bVar, i2, bVar.f5184b);
                return;
            }
            throw new j(a.a.a.a.a.k("Invalid scheme identifier: ", h));
        }
        throw new IllegalArgumentException("Header may not be null");
    }

    public abstract void h(b bVar, int i, int i2);

    public String toString() {
        return g();
    }
}

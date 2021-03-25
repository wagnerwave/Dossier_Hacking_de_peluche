package e.a.a.g0.g;

import a.e.a.a.r.b;
import e.a.a.c0.k.g;
import e.a.a.i0.a;
import e.a.a.i0.l;
import e.a.a.m;
import e.a.a.v;
import e.a.a.w;
import e.a.a.y;
import java.net.URI;
import java.net.URISyntaxException;

public class p extends a implements g {

    /* renamed from: c  reason: collision with root package name */
    public final m f4999c;

    /* renamed from: d  reason: collision with root package name */
    public URI f5000d;

    /* renamed from: e  reason: collision with root package name */
    public String f5001e;
    public w f;
    public int g;

    public p(m mVar) {
        w wVar;
        if (mVar != null) {
            this.f4999c = mVar;
            d(mVar.getParams());
            r(mVar.m());
            if (mVar instanceof g) {
                g gVar = (g) mVar;
                this.f5000d = gVar.i();
                this.f5001e = gVar.t();
                wVar = null;
            } else {
                y f2 = mVar.f();
                try {
                    this.f5000d = new URI(((l) f2).f5155c);
                    this.f5001e = ((l) f2).f5154b;
                    wVar = mVar.v();
                } catch (URISyntaxException e2) {
                    StringBuilder n = a.a.a.a.a.n("Invalid request URI: ");
                    n.append(((l) f2).f5155c);
                    throw new v(n.toString(), e2);
                }
            }
            this.f = wVar;
            this.g = 0;
            return;
        }
        throw new IllegalArgumentException("HTTP request may not be null");
    }

    public y f() {
        String str = this.f5001e;
        w v = v();
        String str2 = null;
        URI uri = this.f5000d;
        if (uri != null) {
            str2 = uri.toASCIIString();
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "/";
        }
        return new l(str, str2, v);
    }

    public URI i() {
        return this.f5000d;
    }

    public String t() {
        return this.f5001e;
    }

    public w v() {
        if (this.f == null) {
            this.f = b.E(getParams());
        }
        return this.f;
    }

    public boolean w() {
        return true;
    }

    public void x() {
        this.f5125a.f5166a.clear();
        r(this.f4999c.m());
    }
}

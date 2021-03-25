package e.b.a.a.a.u;

import e.b.a.a.a.c;
import e.b.a.a.a.h;
import e.b.a.a.a.j;
import e.b.a.a.a.k;
import e.b.a.a.a.l;
import e.b.a.a.a.n;
import e.b.a.a.a.q;
import e.b.a.a.a.t;
import e.b.a.a.a.u.a;
import e.b.a.a.a.u.t.u;

public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public k f5265a;

    /* renamed from: b  reason: collision with root package name */
    public h f5266b;

    /* renamed from: c  reason: collision with root package name */
    public a f5267c;

    /* renamed from: d  reason: collision with root package name */
    public l f5268d;

    /* renamed from: e  reason: collision with root package name */
    public t f5269e;
    public Object f;
    public c g;
    public int h;
    public j i;
    public boolean j;

    public g(h hVar, k kVar, a aVar, l lVar, t tVar, Object obj, c cVar, boolean z) {
        this.f5265a = kVar;
        this.f5266b = hVar;
        this.f5267c = aVar;
        this.f5268d = lVar;
        this.f5269e = tVar;
        this.f = obj;
        this.g = cVar;
        this.h = lVar.m;
        this.j = z;
    }

    public void a() {
        t tVar = new t(this.f5266b.f5206a);
        q qVar = tVar.f5223a;
        qVar.k = this;
        qVar.l = this;
        k kVar = this.f5265a;
        h hVar = this.f5266b;
        kVar.open(hVar.f5206a, hVar.f5207b);
        if (this.f5268d.j) {
            this.f5265a.clear();
        }
        l lVar = this.f5268d;
        if (lVar.m == 0) {
            lVar.a(4);
        }
        try {
            this.f5267c.b(this.f5268d, tVar);
        } catch (n e2) {
            onFailure(tVar, e2);
        }
    }

    public void onFailure(e.b.a.a.a.g gVar, Throwable th) {
        a aVar = this.f5267c;
        int length = aVar.f5226c.length;
        int i2 = aVar.f5225b + 1;
        if (i2 < length || (this.h == 0 && this.f5268d.m == 4)) {
            if (this.h == 0) {
                l lVar = this.f5268d;
                if (lVar.m == 4) {
                    lVar.a(3);
                    a();
                }
                lVar.a(4);
            }
            this.f5267c.f5225b = i2;
            try {
                a();
            } catch (q e2) {
                onFailure(gVar, e2);
            }
        } else {
            if (this.h == 0) {
                this.f5268d.a(0);
            }
            this.f5269e.f5223a.a((u) null, th instanceof n ? (n) th : new n(th));
            this.f5269e.f5223a.b();
            t tVar = this.f5269e;
            q qVar = tVar.f5223a;
            qVar.j = this.f5266b;
            c cVar = this.g;
            if (cVar != null) {
                qVar.l = this.f;
                cVar.onFailure(tVar, th);
            }
        }
    }

    public void onSuccess(e.b.a.a.a.g gVar) {
        if (this.h == 0) {
            this.f5268d.a(0);
        }
        this.f5269e.f5223a.a(gVar.getResponse(), (n) null);
        this.f5269e.f5223a.b();
        this.f5269e.f5223a.j = this.f5266b;
        a aVar = this.f5267c;
        if (aVar.p != null) {
            a.r.h("e.b.a.a.a.u.a", "notifyConnect", "509");
            aVar.p.f5274d = new a.c("notifyConnect");
            aVar.q.execute(aVar.p);
        }
        c cVar = this.g;
        if (cVar != null) {
            t tVar = this.f5269e;
            tVar.f5223a.l = this.f;
            cVar.onSuccess(tVar);
        }
        if (this.i != null) {
            a aVar2 = this.f5267c;
            this.i.connectComplete(this.j, aVar2.f5226c[aVar2.f5225b].c());
        }
    }
}

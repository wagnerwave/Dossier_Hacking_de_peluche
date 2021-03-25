package a.d.b.f;

import a.d.a.a.e.q.c;
import a.d.a.a.h.g.f;
import a.d.a.a.h.g.h;
import a.d.a.a.h.g.j;
import a.d.a.a.h.g.k;
import a.d.a.a.h.g.ld;
import a.d.a.a.h.g.o;
import a.d.a.a.h.g.p;
import a.d.a.a.h.g.q;
import a.d.a.a.h.g.r;
import a.d.a.a.h.g.s;
import a.d.a.a.h.g.t;
import a.d.a.a.h.g.v;
import a.d.a.a.h.g.w;
import a.d.a.a.h.g.y;
import a.d.a.a.i.b.f7;
import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class b implements f7 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f2734a;

    public b(f fVar) {
        this.f2734a = fVar;
    }

    public final String a() {
        f fVar = this.f2734a;
        if (fVar != null) {
            ld ldVar = new ld();
            fVar.f1683c.execute(new s(fVar, ldVar));
            return ldVar.h(500);
        }
        throw null;
    }

    public final String b() {
        f fVar = this.f2734a;
        if (fVar != null) {
            ld ldVar = new ld();
            fVar.f1683c.execute(new w(fVar, ldVar));
            return ldVar.h(500);
        }
        throw null;
    }

    public final String c() {
        f fVar = this.f2734a;
        if (fVar != null) {
            ld ldVar = new ld();
            fVar.f1683c.execute(new q(fVar, ldVar));
            return ldVar.h(50);
        }
        throw null;
    }

    public final String d() {
        f fVar = this.f2734a;
        if (fVar != null) {
            ld ldVar = new ld();
            fVar.f1683c.execute(new r(fVar, ldVar));
            return ldVar.h(500);
        }
        throw null;
    }

    public final long e() {
        f fVar = this.f2734a;
        if (fVar != null) {
            ld ldVar = new ld();
            fVar.f1683c.execute(new t(fVar, ldVar));
            Long l = (Long) ld.g(ldVar.U(500), Long.class);
            if (l != null) {
                return l.longValue();
            }
            long nanoTime = System.nanoTime();
            if (((c) fVar.f1682b) != null) {
                long nextLong = new Random(nanoTime ^ System.currentTimeMillis()).nextLong();
                int i = fVar.f + 1;
                fVar.f = i;
                return nextLong + ((long) i);
            }
            throw null;
        }
        throw null;
    }

    public final void f(Bundle bundle) {
        f fVar = this.f2734a;
        if (fVar != null) {
            fVar.f1683c.execute(new h(fVar, bundle));
            return;
        }
        throw null;
    }

    public final void g(String str) {
        f fVar = this.f2734a;
        if (fVar != null) {
            fVar.f1683c.execute(new p(fVar, str));
            return;
        }
        throw null;
    }

    public final List<Bundle> h(String str, String str2) {
        f fVar = this.f2734a;
        if (fVar != null) {
            ld ldVar = new ld();
            fVar.f1683c.execute(new j(fVar, str, str2, ldVar));
            List<Bundle> list = (List) ld.g(ldVar.U(5000), List.class);
            return list == null ? Collections.emptyList() : list;
        }
        throw null;
    }

    public final int i(String str) {
        f fVar = this.f2734a;
        if (fVar != null) {
            ld ldVar = new ld();
            fVar.f1683c.execute(new y(fVar, str, ldVar));
            Integer num = (Integer) ld.g(ldVar.U(10000), Integer.class);
            if (num == null) {
                return 25;
            }
            return num.intValue();
        }
        throw null;
    }

    public final void j(String str) {
        f fVar = this.f2734a;
        if (fVar != null) {
            fVar.f1683c.execute(new o(fVar, str));
            return;
        }
        throw null;
    }

    public final Map<String, Object> k(String str, String str2, boolean z) {
        f fVar = this.f2734a;
        if (fVar != null) {
            ld ldVar = new ld();
            fVar.f1683c.execute(new v(fVar, str, str2, z, ldVar));
            Bundle U = ldVar.U(5000);
            if (U == null || U.size() == 0) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap(U.size());
            for (String str3 : U.keySet()) {
                Object obj = U.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    hashMap.put(str3, obj);
                }
            }
            return hashMap;
        }
        throw null;
    }

    public final void l(String str, String str2, Bundle bundle) {
        f fVar = this.f2734a;
        if (fVar != null) {
            fVar.f1683c.execute(new k(fVar, str, str2, bundle));
            return;
        }
        throw null;
    }

    public final void m(String str, String str2, Bundle bundle) {
        this.f2734a.c(str, str2, bundle, true, true, (Long) null);
    }
}

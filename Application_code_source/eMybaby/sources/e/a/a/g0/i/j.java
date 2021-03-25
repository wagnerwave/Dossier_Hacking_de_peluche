package e.a.a.g0.i;

import com.tuya.smart.android.network.http.BusinessResponse;
import e.a.a.c;
import e.a.a.d;
import e.a.a.e0.b;
import e.a.a.e0.e;
import e.a.a.e0.h;
import e.a.a.e0.k;
import e.a.a.e0.l;
import e.a.a.i0.t;
import java.util.List;

public class j implements h {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f5065a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5066b;

    /* renamed from: c  reason: collision with root package name */
    public e0 f5067c;

    /* renamed from: d  reason: collision with root package name */
    public x f5068d;

    /* renamed from: e  reason: collision with root package name */
    public l f5069e;

    public j() {
        this.f5065a = null;
        this.f5066b = false;
    }

    public j(String[] strArr, boolean z) {
        this.f5065a = strArr == null ? null : (String[]) strArr.clone();
        this.f5066b = z;
    }

    public void a(b bVar, e eVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (eVar == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        } else if (bVar.d() <= 0) {
            g().a(bVar, eVar);
        } else if (bVar instanceof l) {
            i().a(bVar, eVar);
        } else {
            h().a(bVar, eVar);
        }
    }

    public boolean b(b bVar, e eVar) {
        return bVar.d() > 0 ? bVar instanceof l ? i().b(bVar, eVar) : h().b(bVar, eVar) : g().b(bVar, eVar);
    }

    public List<b> c(c cVar, e eVar) {
        t tVar;
        e.a.a.l0.b bVar;
        if (cVar == null) {
            throw new IllegalArgumentException("Header may not be null");
        } else if (eVar != null) {
            d[] c2 = cVar.c();
            boolean z = false;
            boolean z2 = false;
            for (d dVar : c2) {
                if (dVar.b("version") != null) {
                    z2 = true;
                }
                if (dVar.b(BusinessResponse.KEY_EXPIRES) != null) {
                    z = true;
                }
            }
            if (!z && z2) {
                return "Set-Cookie2".equals(cVar.getName()) ? i().h(c2, eVar) : h().h(c2, eVar);
            }
            if (cVar instanceof e.a.a.b) {
                e.a.a.b bVar2 = (e.a.a.b) cVar;
                bVar = bVar2.b();
                tVar = new t(bVar2.d(), bVar.f5184b);
            } else {
                String value = cVar.getValue();
                if (value != null) {
                    bVar = new e.a.a.l0.b(value.length());
                    bVar.b(value);
                    tVar = new t(0, bVar.f5184b);
                } else {
                    throw new k("Header value is null");
                }
            }
            return g().h(new d[]{t.a(bVar, tVar)}, eVar);
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    public int d() {
        if (i() != null) {
            return 1;
        }
        throw null;
    }

    public c e() {
        return i().e();
    }

    public List<c> f(List<b> list) {
        int i = Integer.MAX_VALUE;
        boolean z = true;
        for (b next : list) {
            if (!(next instanceof l)) {
                z = false;
            }
            if (next.d() < i) {
                i = next.d();
            }
        }
        return i > 0 ? z ? i().f(list) : h().f(list) : g().f(list);
    }

    public final l g() {
        if (this.f5069e == null) {
            this.f5069e = new l(this.f5065a);
        }
        return this.f5069e;
    }

    public final x h() {
        if (this.f5068d == null) {
            this.f5068d = new x(this.f5065a, this.f5066b);
        }
        return this.f5068d;
    }

    public final e0 i() {
        if (this.f5067c == null) {
            this.f5067c = new e0(this.f5065a, this.f5066b);
        }
        return this.f5067c;
    }

    public String toString() {
        return "best-match";
    }
}

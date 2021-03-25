package a.d.a.a.i.b;

import a.d.a.a.e.q.c;

public final class a9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f2092a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b9 f2093b;

    public a9(b9 b9Var, long j) {
        this.f2093b = b9Var;
        this.f2092a = j;
    }

    public final void run() {
        b9 b9Var = this.f2093b;
        long j = this.f2092a;
        b9Var.b();
        b9Var.z();
        b9Var.i().n.b("Activity resumed, time", Long.valueOf(j));
        if (b9Var.f2563a.g.o(q.x0)) {
            if (b9Var.f2563a.g.y().booleanValue() || b9Var.k().w.b()) {
                h9 h9Var = b9Var.f2111e;
                h9Var.f2253d.b();
                h9Var.f2252c.c();
                h9Var.f2250a = j;
                h9Var.f2251b = j;
            }
            b9Var.f.a();
        } else {
            b9Var.f.a();
            if (b9Var.f2563a.g.y().booleanValue()) {
                h9 h9Var2 = b9Var.f2111e;
                h9Var2.f2253d.b();
                h9Var2.f2252c.c();
                h9Var2.f2250a = j;
                h9Var2.f2251b = j;
            }
        }
        j9 j9Var = b9Var.f2110d;
        j9Var.f2307a.b();
        if (j9Var.f2307a.f2563a.d()) {
            if (!j9Var.f2307a.f2563a.g.o(q.x0)) {
                j9Var.f2307a.k().w.a(false);
            }
            if (((c) j9Var.f2307a.f2563a.n) != null) {
                j9Var.b(System.currentTimeMillis(), false);
                return;
            }
            throw null;
        }
    }
}

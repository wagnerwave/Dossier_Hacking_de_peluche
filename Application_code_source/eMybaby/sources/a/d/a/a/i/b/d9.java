package a.d.a.a.i.b;

import a.d.a.a.e.q.c;

public final class d9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f2153a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b9 f2154b;

    public d9(b9 b9Var, long j) {
        this.f2154b = b9Var;
        this.f2153a = j;
    }

    public final void run() {
        b9 b9Var = this.f2154b;
        long j = this.f2153a;
        b9Var.b();
        b9Var.z();
        b9Var.i().n.b("Activity paused, time", Long.valueOf(j));
        c9 c9Var = b9Var.f;
        if (c9Var.f2140b.f2563a.g.o(q.l0)) {
            if (((c) c9Var.f2140b.f2563a.n) != null) {
                f9 f9Var = new f9(c9Var, System.currentTimeMillis(), j);
                c9Var.f2139a = f9Var;
                c9Var.f2140b.f2109c.postDelayed(f9Var, 2000);
            } else {
                throw null;
            }
        }
        if (b9Var.f2563a.g.y().booleanValue()) {
            b9Var.f2111e.f2252c.c();
        }
        j9 j9Var = b9Var.f2110d;
        if (!j9Var.f2307a.f2563a.g.o(q.x0)) {
            j9Var.f2307a.k().w.a(true);
        }
    }
}

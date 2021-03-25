package a.d.a.a.i.b;

import android.os.Bundle;

public final /* synthetic */ class e9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final f9 f2174a;

    public e9(f9 f9Var) {
        this.f2174a = f9Var;
    }

    public final void run() {
        f9 f9Var = this.f2174a;
        c9 c9Var = f9Var.f2200c;
        long j = f9Var.f2198a;
        long j2 = f9Var.f2199b;
        c9Var.f2140b.b();
        c9Var.f2140b.i().m.a("Application going to the background");
        boolean z = true;
        if (c9Var.f2140b.f2563a.g.o(q.x0)) {
            c9Var.f2140b.k().w.a(true);
        }
        Bundle bundle = new Bundle();
        if (!c9Var.f2140b.f2563a.g.y().booleanValue()) {
            c9Var.f2140b.f2111e.f2252c.c();
            if (c9Var.f2140b.f2563a.g.o(q.o0)) {
                h9 h9Var = c9Var.f2140b.f2111e;
                h9Var.f2251b = j2;
                bundle.putLong("_et", j2 - h9Var.f2251b);
                l7.C(c9Var.f2140b.r().y(true), bundle, true);
            } else {
                z = false;
            }
            c9Var.f2140b.y(false, z, j2);
        }
        c9Var.f2140b.o().E("auto", "_ab", j, bundle);
    }
}

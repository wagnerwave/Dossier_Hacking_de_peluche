package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.e.q.c;
import android.os.Handler;

public abstract class d0 {

    /* renamed from: d  reason: collision with root package name */
    public static volatile Handler f1484d;

    /* renamed from: a  reason: collision with root package name */
    public final h f1485a;

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f1486b = new e0(this);

    /* renamed from: c  reason: collision with root package name */
    public volatile long f1487c;

    public d0(h hVar) {
        b.k(hVar);
        this.f1485a = hVar;
    }

    public final void a() {
        this.f1487c = 0;
        b().removeCallbacks(this.f1486b);
    }

    public final Handler b() {
        Handler handler;
        if (f1484d != null) {
            return f1484d;
        }
        synchronized (d0.class) {
            if (f1484d == null) {
                f1484d = new j1(this.f1485a.f1503a.getMainLooper());
            }
            handler = f1484d;
        }
        return handler;
    }

    public abstract void c();

    public final boolean d() {
        return this.f1487c != 0;
    }

    public final void e(long j) {
        a();
        if (j < 0) {
            return;
        }
        if (((c) this.f1485a.f1505c) != null) {
            this.f1487c = System.currentTimeMillis();
            if (!b().postDelayed(this.f1486b, j)) {
                this.f1485a.c().n("Failed to schedule delayed post. time", Long.valueOf(j));
                return;
            }
            return;
        }
        throw null;
    }
}

package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.q.c;
import a.d.a.a.h.g.kd;
import android.os.Handler;

public abstract class i {

    /* renamed from: d  reason: collision with root package name */
    public static volatile Handler f2254d;

    /* renamed from: a  reason: collision with root package name */
    public final x5 f2255a;

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f2256b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f2257c;

    public i(x5 x5Var) {
        b.k(x5Var);
        this.f2255a = x5Var;
        this.f2256b = new h(this, x5Var);
    }

    public abstract void a();

    public final void b(long j) {
        c();
        if (j < 0) {
            return;
        }
        if (((c) this.f2255a.g()) != null) {
            this.f2257c = System.currentTimeMillis();
            if (!d().postDelayed(this.f2256b, j)) {
                this.f2255a.i().f.b("Failed to schedule delayed post. time", Long.valueOf(j));
                return;
            }
            return;
        }
        throw null;
    }

    public final void c() {
        this.f2257c = 0;
        d().removeCallbacks(this.f2256b);
    }

    public final Handler d() {
        Handler handler;
        if (f2254d != null) {
            return f2254d;
        }
        synchronized (i.class) {
            if (f2254d == null) {
                f2254d = new kd(this.f2255a.j().getMainLooper());
            }
            handler = f2254d;
        }
        return handler;
    }
}

package a.d.a.a.i.b;

import a.d.a.a.e.q.c;
import a.d.a.a.h.g.ga;
import android.app.ActivityManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;

public final class j9 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b9 f2307a;

    public j9(b9 b9Var) {
        this.f2307a = b9Var;
    }

    @WorkerThread
    public final void a() {
        this.f2307a.b();
        k4 k = this.f2307a.k();
        if (((c) this.f2307a.f2563a.n) == null) {
            throw null;
        } else if (k.t(System.currentTimeMillis())) {
            this.f2307a.k().r.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f2307a.i().n.a("Detected application was in foreground");
                if (((c) this.f2307a.f2563a.n) != null) {
                    c(System.currentTimeMillis(), false);
                    return;
                }
                throw null;
            }
        }
    }

    @WorkerThread
    public final void b(long j, boolean z) {
        this.f2307a.b();
        this.f2307a.z();
        if (this.f2307a.k().t(j)) {
            this.f2307a.k().r.a(true);
        }
        this.f2307a.k().u.b(j);
        if (this.f2307a.k().r.b()) {
            c(j, z);
        }
    }

    @WorkerThread
    public final void c(long j, boolean z) {
        this.f2307a.b();
        if (this.f2307a.f2563a.d()) {
            this.f2307a.k().u.b(j);
            if (((c) this.f2307a.f2563a.n) != null) {
                this.f2307a.i().n.b("Session started, time", Long.valueOf(SystemClock.elapsedRealtime()));
                Long valueOf = Long.valueOf(j / 1000);
                this.f2307a.o().K("auto", "_sid", valueOf, j);
                this.f2307a.k().r.a(false);
                Bundle bundle = new Bundle();
                bundle.putLong("_sid", valueOf.longValue());
                if (this.f2307a.f2563a.g.o(q.m0) && z) {
                    bundle.putLong("_aib", 1);
                }
                this.f2307a.o().E("auto", "_s", j, bundle);
                if (ga.b() && this.f2307a.f2563a.g.o(q.r0)) {
                    String a2 = this.f2307a.k().z.a();
                    if (!TextUtils.isEmpty(a2)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("_ffr", a2);
                        this.f2307a.o().E("auto", "_ssr", j, bundle2);
                        return;
                    }
                    return;
                }
                return;
            }
            throw null;
        }
    }
}

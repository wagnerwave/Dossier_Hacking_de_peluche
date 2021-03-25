package a.d.a.a.i.b;

import a.d.a.a.e.q.c;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.MainThread;

@TargetApi(14)
@MainThread
public final class d7 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f6 f2151a;

    public d7(f6 f6Var, k6 k6Var) {
        this.f2151a = f6Var;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f2151a.i().n.a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.f2151a.e();
                        this.f2151a.f().v(new g7(this, bundle == null, data, v9.T(intent) ? "gs" : "auto", data.getQueryParameter("referrer")));
                    }
                }
            }
        } catch (Exception e2) {
            this.f2151a.i().f.b("Throwable caught in onActivityCreated", e2);
        } catch (Throwable th) {
            this.f2151a.r().A(activity, bundle);
            throw th;
        }
        this.f2151a.r().A(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        l7 r = this.f2151a.r();
        synchronized (r.l) {
            if (activity == r.g) {
                r.g = null;
            }
        }
        if (r.f2563a.g.y().booleanValue()) {
            r.f.remove(activity);
        }
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        l7 r = this.f2151a.r();
        if (r.f2563a.g.o(q.x0)) {
            synchronized (r.l) {
                r.k = false;
                r.h = true;
            }
        }
        if (((c) r.f2563a.n) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!r.f2563a.g.o(q.w0) || r.f2563a.g.y().booleanValue()) {
                m7 G = r.G(activity);
                r.f2353d = r.f2352c;
                r.f2352c = null;
                r.f().v(new s7(r, G, elapsedRealtime));
            } else {
                r.f2352c = null;
                r.f().v(new p7(r, elapsedRealtime));
            }
            b9 t = this.f2151a.t();
            if (((c) t.f2563a.n) != null) {
                t.f().v(new d9(t, SystemClock.elapsedRealtime()));
                return;
            }
            throw null;
        }
        throw null;
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        b9 t = this.f2151a.t();
        if (((c) t.f2563a.n) != null) {
            t.f().v(new a9(t, SystemClock.elapsedRealtime()));
            l7 r = this.f2151a.r();
            if (r.f2563a.g.o(q.x0)) {
                synchronized (r.l) {
                    r.k = true;
                    if (activity != r.g) {
                        synchronized (r.l) {
                            r.g = activity;
                            r.h = false;
                        }
                        if (r.f2563a.g.o(q.w0) && r.f2563a.g.y().booleanValue()) {
                            r.i = null;
                            r.f().v(new r7(r));
                        }
                    }
                }
            }
            if (!r.f2563a.g.o(q.w0) || r.f2563a.g.y().booleanValue()) {
                r.B(activity, r.G(activity), false);
                a n = r.n();
                if (((c) n.f2563a.n) != null) {
                    n.f().v(new a3(n, SystemClock.elapsedRealtime()));
                    return;
                }
                throw null;
            }
            r.f2352c = r.i;
            r.f().v(new q7(r));
            return;
        }
        throw null;
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m7 m7Var;
        l7 r = this.f2151a.r();
        if (r.f2563a.g.y().booleanValue() && bundle != null && (m7Var = r.f.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", m7Var.f2378c);
            bundle2.putString("name", m7Var.f2376a);
            bundle2.putString("referrer_name", m7Var.f2377b);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}

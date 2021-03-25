package a.d.a.a.i.b;

import a.c.a.d.a;
import a.d.a.a.e.k.l.g;
import a.d.a.a.e.q.b;
import a.d.a.a.e.q.c;
import a.d.a.a.h.g.c2;
import a.d.a.a.h.g.f2;
import a.d.a.a.h.g.k2;
import a.d.a.a.h.g.m2;
import a.d.a.a.h.g.p1;
import a.d.a.a.h.g.q1;
import a.d.a.a.h.g.u9;
import a.d.a.a.h.g.x1;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzae;
import java.util.concurrent.atomic.AtomicInteger;

public class c5 implements x5 {
    public static volatile c5 H;
    public volatile Boolean A;
    public Boolean B;
    public Boolean C;
    public volatile boolean D;
    public int E;
    public AtomicInteger F = new AtomicInteger(0);
    public final long G;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2123a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2124b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2125c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2126d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2127e;
    public final ja f;
    public final ka g;
    public final k4 h;
    public final x3 i;
    public final v4 j;
    public final b9 k;
    public final v9 l;
    public final v3 m;
    public final b n;
    public final l7 o;
    public final f6 p;
    public final a q;
    public final h7 r;
    public t3 s;
    public u7 t;
    public k u;
    public q3 v;
    public p4 w;
    public boolean x = false;
    public Boolean y;
    public long z;

    public c5(g6 g6Var) {
        long j2;
        String str;
        z3 z3Var;
        Bundle bundle;
        boolean z2 = false;
        a.c.a.f.b.k(g6Var);
        ja jaVar = new ja();
        this.f = jaVar;
        a.c.a.f.b.g = jaVar;
        this.f2123a = g6Var.f2214a;
        this.f2124b = g6Var.f2215b;
        this.f2125c = g6Var.f2216c;
        this.f2126d = g6Var.f2217d;
        this.f2127e = g6Var.h;
        this.A = g6Var.f2218e;
        this.D = true;
        zzae zzae = g6Var.g;
        if (!(zzae == null || (bundle = zzae.g) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = zzae.g.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        Context context = this.f2123a;
        synchronized (c2.g) {
            k2 k2Var = c2.h;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (k2Var == null || ((q1) k2Var).f1891a != context) {
                p1.c();
                m2.b();
                x1.b();
                c2.h = new q1(context, a.v(new f2(context)));
                c2.j.incrementAndGet();
            }
        }
        this.n = c.f1429a;
        Long l2 = g6Var.i;
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            j2 = System.currentTimeMillis();
        }
        this.G = j2;
        this.g = new ka(this);
        k4 k4Var = new k4(this);
        k4Var.o();
        this.h = k4Var;
        x3 x3Var = new x3(this);
        x3Var.o();
        this.i = x3Var;
        v9 v9Var = new v9(this);
        v9Var.o();
        this.l = v9Var;
        v3 v3Var = new v3(this);
        v3Var.o();
        this.m = v3Var;
        this.q = new a(this);
        l7 l7Var = new l7(this);
        l7Var.v();
        this.o = l7Var;
        f6 f6Var = new f6(this);
        f6Var.v();
        this.p = f6Var;
        b9 b9Var = new b9(this);
        b9Var.v();
        this.k = b9Var;
        h7 h7Var = new h7(this);
        h7Var.o();
        this.r = h7Var;
        v4 v4Var = new v4(this);
        v4Var.o();
        this.j = v4Var;
        zzae zzae2 = g6Var.g;
        if (!(zzae2 == null || zzae2.f4258b == 0)) {
            z2 = true;
        }
        boolean z3 = !z2;
        if (this.f2123a.getApplicationContext() instanceof Application) {
            f6 s2 = s();
            if (s2.f2563a.f2123a.getApplicationContext() instanceof Application) {
                Application application = (Application) s2.f2563a.f2123a.getApplicationContext();
                if (s2.f2193c == null) {
                    s2.f2193c = new d7(s2, (k6) null);
                }
                if (z3) {
                    application.unregisterActivityLifecycleCallbacks(s2.f2193c);
                    application.registerActivityLifecycleCallbacks(s2.f2193c);
                    z3Var = s2.i().n;
                    str = "Registered activity lifecycle callback";
                }
            }
            this.j.v(new e5(this, g6Var));
        }
        z3Var = i().i;
        str = "Application context is not an Application";
        z3Var.a(str);
        this.j.v(new e5(this, g6Var));
    }

    public static c5 a(Context context, zzae zzae, Long l2) {
        Bundle bundle;
        if (zzae != null && (zzae.f4261e == null || zzae.f == null)) {
            zzae = new zzae(zzae.f4257a, zzae.f4258b, zzae.f4259c, zzae.f4260d, (String) null, (String) null, zzae.g);
        }
        a.c.a.f.b.k(context);
        a.c.a.f.b.k(context.getApplicationContext());
        if (H == null) {
            synchronized (c5.class) {
                if (H == null) {
                    H = new c5(new g6(context, zzae, l2));
                }
            }
        } else if (!(zzae == null || (bundle = zzae.g) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            H.A = Boolean.valueOf(zzae.g.getBoolean("dataCollectionDefaultEnabled"));
        }
        return H;
    }

    public static void c(v5 v5Var) {
        if (v5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static void p(a5 a5Var) {
        if (a5Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!a5Var.f2081b) {
            String valueOf = String.valueOf(a5Var.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    public static void q(y5 y5Var) {
        if (y5Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!y5Var.r()) {
            String valueOf = String.valueOf(y5Var.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    public final a A() {
        a aVar = this.q;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @WorkerThread
    public final boolean B() {
        return this.A != null && this.A.booleanValue();
    }

    public final ka b() {
        return this.g;
    }

    @WorkerThread
    public final boolean d() {
        return e() == 0;
    }

    @WorkerThread
    public final int e() {
        f().b();
        if (this.g.w()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (u9.b() && this.g.o(q.P0) && !h()) {
            return 8;
        }
        Boolean w2 = o().w();
        if (w2 != null) {
            return w2.booleanValue() ? 0 : 3;
        }
        Boolean v2 = this.g.v("firebase_analytics_collection_enabled");
        if (v2 != null) {
            return v2.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.B;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (g.a("isMeasurementExplicitlyDisabled").f1303c) {
            return 6;
        }
        if (!this.g.o(q.T) || this.A == null || this.A.booleanValue()) {
            return 0;
        }
        return 7;
    }

    public final v4 f() {
        q(this.j);
        return this.j;
    }

    public final b g() {
        return this.n;
    }

    @WorkerThread
    public final boolean h() {
        f().b();
        return this.D;
    }

    public final x3 i() {
        q(this.i);
        return this.i;
    }

    public final Context j() {
        return this.f2123a;
    }

    public final void k() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (java.lang.Math.abs(android.os.SystemClock.elapsedRealtime() - r7.z) > 1000) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c2, code lost:
        if (android.text.TextUtils.isEmpty(r0.l) == false) goto L_0x00c4;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l() {
        /*
            r7 = this;
            boolean r0 = r7.x
            if (r0 == 0) goto L_0x00d3
            a.d.a.a.i.b.v4 r0 = r7.f()
            r0.b()
            java.lang.Boolean r0 = r7.y
            r1 = 0
            if (r0 == 0) goto L_0x0037
            long r2 = r7.z
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0037
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00cb
            a.d.a.a.e.q.b r0 = r7.n
            a.d.a.a.e.q.c r0 = (a.d.a.a.e.q.c) r0
            if (r0 == 0) goto L_0x0036
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r7.z
            long r2 = r2 - r4
            long r2 = java.lang.Math.abs(r2)
            r4 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00cb
            goto L_0x0037
        L_0x0036:
            throw r1
        L_0x0037:
            a.d.a.a.e.q.b r0 = r7.n
            a.d.a.a.e.q.c r0 = (a.d.a.a.e.q.c) r0
            if (r0 == 0) goto L_0x00d2
            long r0 = android.os.SystemClock.elapsedRealtime()
            r7.z = r0
            a.d.a.a.i.b.v9 r0 = r7.t()
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r0 = r0.q0(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0083
            a.d.a.a.i.b.v9 r0 = r7.t()
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r0 = r0.q0(r3)
            if (r0 == 0) goto L_0x0083
            android.content.Context r0 = r7.f2123a
            a.d.a.a.e.r.b r0 = a.d.a.a.e.r.c.a(r0)
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0081
            a.d.a.a.i.b.ka r0 = r7.g
            boolean r0 = r0.B()
            if (r0 != 0) goto L_0x0081
            android.content.Context r0 = r7.f2123a
            boolean r0 = a.d.a.a.i.b.u4.a(r0)
            if (r0 == 0) goto L_0x0083
            android.content.Context r0 = r7.f2123a
            boolean r0 = a.d.a.a.i.b.v9.S(r0)
            if (r0 == 0) goto L_0x0083
        L_0x0081:
            r0 = 1
            goto L_0x0084
        L_0x0083:
            r0 = 0
        L_0x0084:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.y = r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00cb
            a.d.a.a.i.b.v9 r0 = r7.t()
            a.d.a.a.i.b.q3 r3 = r7.z()
            r3.u()
            java.lang.String r3 = r3.k
            a.d.a.a.i.b.q3 r4 = r7.z()
            r4.u()
            java.lang.String r4 = r4.l
            a.d.a.a.i.b.q3 r5 = r7.z()
            r5.u()
            java.lang.String r5 = r5.m
            boolean r0 = r0.a0(r3, r4, r5)
            if (r0 != 0) goto L_0x00c4
            a.d.a.a.i.b.q3 r0 = r7.z()
            r0.u()
            java.lang.String r0 = r0.l
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00c5
        L_0x00c4:
            r1 = 1
        L_0x00c5:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r7.y = r0
        L_0x00cb:
            java.lang.Boolean r0 = r7.y
            boolean r0 = r0.booleanValue()
            return r0
        L_0x00d2:
            throw r1
        L_0x00d3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "AppMeasurement is not initialized"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.c5.l():boolean");
    }

    public final ja m() {
        return this.f;
    }

    public final h7 n() {
        q(this.r);
        return this.r;
    }

    public final k4 o() {
        c(this.h);
        return this.h;
    }

    public final b9 r() {
        p(this.k);
        return this.k;
    }

    public final f6 s() {
        p(this.p);
        return this.p;
    }

    public final v9 t() {
        c(this.l);
        return this.l;
    }

    public final v3 u() {
        c(this.m);
        return this.m;
    }

    public final boolean v() {
        return TextUtils.isEmpty(this.f2124b);
    }

    public final l7 w() {
        p(this.o);
        return this.o;
    }

    public final u7 x() {
        p(this.t);
        return this.t;
    }

    public final k y() {
        q(this.u);
        return this.u;
    }

    public final q3 z() {
        p(this.v);
        return this.v;
    }
}

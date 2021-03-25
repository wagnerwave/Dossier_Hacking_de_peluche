package a.d.a.a.i.b;

public final class e5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g6 f2167a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c5 f2168b;

    public e5(c5 c5Var, g6 g6Var) {
        this.f2168b = c5Var;
        this.f2167a = g6Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x03d7, code lost:
        if (android.text.TextUtils.isEmpty(r1.l) == false) goto L_0x03d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0267, code lost:
        if (android.text.TextUtils.isEmpty(r1.l) == false) goto L_0x0269;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r12 = this;
            a.d.a.a.i.b.c5 r0 = r12.f2168b
            a.d.a.a.i.b.g6 r1 = r12.f2167a
            a.d.a.a.i.b.v4 r2 = r0.f()
            r2.b()
            a.d.a.a.i.b.k r2 = new a.d.a.a.i.b.k
            r2.<init>(r0)
            r2.o()
            r0.u = r2
            a.d.a.a.i.b.q3 r2 = new a.d.a.a.i.b.q3
            long r3 = r1.f
            r2.<init>(r0, r3)
            r2.v()
            r0.v = r2
            a.d.a.a.i.b.t3 r1 = new a.d.a.a.i.b.t3
            r1.<init>(r0)
            r1.v()
            r0.s = r1
            a.d.a.a.i.b.u7 r1 = new a.d.a.a.i.b.u7
            r1.<init>(r0)
            r1.v()
            r0.t = r1
            a.d.a.a.i.b.v9 r1 = r0.l
            r1.p()
            a.d.a.a.i.b.k4 r1 = r0.h
            r1.p()
            a.d.a.a.i.b.p4 r1 = new a.d.a.a.i.b.p4
            r1.<init>(r0)
            r0.w = r1
            a.d.a.a.i.b.q3 r1 = r0.v
            boolean r3 = r1.f2081b
            if (r3 != 0) goto L_0x045c
            r1.x()
            a.d.a.a.i.b.c5 r3 = r1.f2563a
            java.util.concurrent.atomic.AtomicInteger r3 = r3.F
            r3.incrementAndGet()
            r3 = 1
            r1.f2081b = r3
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.l
            r4 = 31049(0x7949, double:1.534E-319)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "App measurement initialized, version"
            r1.b(r5, r4)
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.l
            java.lang.String r4 = "To enable debug logging run: adb shell setprop log.tag.FA VERBOSE"
            r1.a(r4)
            r2.u()
            java.lang.String r1 = r2.f2474c
            java.lang.String r2 = r0.f2124b
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00b7
            a.d.a.a.i.b.v9 r2 = r0.t()
            boolean r2 = r2.t0(r1)
            if (r2 == 0) goto L_0x0095
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.l
            java.lang.String r2 = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none."
            goto L_0x00b4
        L_0x0095:
            a.d.a.a.i.b.x3 r2 = r0.i()
            a.d.a.a.i.b.z3 r2 = r2.l
            java.lang.String r4 = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r5 = r1.length()
            if (r5 == 0) goto L_0x00ac
            java.lang.String r1 = r4.concat(r1)
            goto L_0x00b1
        L_0x00ac:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4)
        L_0x00b1:
            r11 = r2
            r2 = r1
            r1 = r11
        L_0x00b4:
            r1.a(r2)
        L_0x00b7:
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.m
            java.lang.String r2 = "Debug-level message logging enabled"
            r1.a(r2)
            int r1 = r0.E
            java.util.concurrent.atomic.AtomicInteger r2 = r0.F
            int r2 = r2.get()
            if (r1 == r2) goto L_0x00e7
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            int r2 = r0.E
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.util.concurrent.atomic.AtomicInteger r4 = r0.F
            int r4 = r4.get()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "Not all components initialized"
            r1.c(r5, r2, r4)
        L_0x00e7:
            r0.x = r3
            a.d.a.a.i.b.c5 r0 = r12.f2168b
            a.d.a.a.i.b.g6 r1 = r12.f2167a
            com.google.android.gms.internal.measurement.zzae r1 = r1.g
            a.d.a.a.i.b.v4 r2 = r0.f()
            r2.b()
            boolean r2 = a.d.a.a.h.g.u9.b()
            if (r2 == 0) goto L_0x014b
            a.d.a.a.i.b.ka r2 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.P0
            boolean r2 = r2.o(r4)
            if (r2 == 0) goto L_0x014b
            a.d.a.a.i.b.k4 r2 = r0.o()
            a.d.a.a.i.b.e r2 = r2.x()
            if (r1 == 0) goto L_0x0144
            android.os.Bundle r4 = r1.g
            if (r4 == 0) goto L_0x0144
            a.d.a.a.i.b.k4 r4 = r0.o()
            android.content.SharedPreferences r4 = r4.v()
            r5 = 100
            java.lang.String r6 = "consent_source"
            int r4 = r4.getInt(r6, r5)
            r5 = 30
            boolean r4 = a.d.a.a.i.b.e.e(r5, r4)
            if (r4 == 0) goto L_0x0144
            android.os.Bundle r1 = r1.g
            a.d.a.a.i.b.e r1 = a.d.a.a.i.b.e.g(r1)
            a.d.a.a.i.b.e r4 = a.d.a.a.i.b.e.f2160c
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0144
            a.d.a.a.i.b.f6 r2 = r0.s()
            long r6 = r0.G
            r2.B(r1, r5, r6)
            r2 = r1
        L_0x0144:
            a.d.a.a.i.b.f6 r1 = r0.s()
            r1.A(r2)
        L_0x014b:
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.o4 r1 = r1.f2317e
            long r1 = r1.a()
            r4 = 0
            r6 = 0
            int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x0171
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.o4 r1 = r1.f2317e
            a.d.a.a.e.q.b r2 = r0.n
            a.d.a.a.e.q.c r2 = (a.d.a.a.e.q.c) r2
            if (r2 == 0) goto L_0x0170
            long r7 = java.lang.System.currentTimeMillis()
            r1.b(r7)
            goto L_0x0171
        L_0x0170:
            throw r6
        L_0x0171:
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.o4 r1 = r1.j
            long r1 = r1.a()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            long r1 = r1.longValue()
            int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x01a3
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            long r4 = r0.G
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "Persisting first open"
            r1.b(r4, r2)
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.o4 r1 = r1.j
            long r4 = r0.G
            r1.b(r4)
        L_0x01a3:
            a.d.a.a.i.b.ka r1 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.L0
            boolean r1 = r1.o(r2)
            if (r1 == 0) goto L_0x01ca
            a.d.a.a.i.b.f6 r1 = r0.s()
            a.d.a.a.i.b.ca r1 = r1.n
            boolean r2 = r1.c()
            if (r2 == 0) goto L_0x01ca
            boolean r2 = r1.b()
            if (r2 == 0) goto L_0x01ca
            a.d.a.a.i.b.c5 r1 = r1.f2141a
            a.d.a.a.i.b.k4 r1 = r1.o()
            a.d.a.a.i.b.q4 r1 = r1.A
            r1.b(r6)
        L_0x01ca:
            boolean r1 = r0.l()
            if (r1 != 0) goto L_0x024b
            boolean r1 = r0.d()
            if (r1 == 0) goto L_0x044a
            a.d.a.a.i.b.v9 r1 = r0.t()
            java.lang.String r2 = "android.permission.INTERNET"
            boolean r1 = r1.q0(r2)
            if (r1 != 0) goto L_0x01ed
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.String r2 = "App is missing INTERNET permission"
            r1.a(r2)
        L_0x01ed:
            a.d.a.a.i.b.v9 r1 = r0.t()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r1.q0(r2)
            if (r1 != 0) goto L_0x0204
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.String r2 = "App is missing ACCESS_NETWORK_STATE permission"
            r1.a(r2)
        L_0x0204:
            android.content.Context r1 = r0.f2123a
            a.d.a.a.e.r.b r1 = a.d.a.a.e.r.c.a(r1)
            boolean r1 = r1.c()
            if (r1 != 0) goto L_0x023e
            a.d.a.a.i.b.ka r1 = r0.g
            boolean r1 = r1.B()
            if (r1 != 0) goto L_0x023e
            android.content.Context r1 = r0.f2123a
            boolean r1 = a.d.a.a.i.b.u4.a(r1)
            if (r1 != 0) goto L_0x022b
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.String r2 = "AppMeasurementReceiver not registered/enabled"
            r1.a(r2)
        L_0x022b:
            android.content.Context r1 = r0.f2123a
            boolean r1 = a.d.a.a.i.b.v9.S(r1)
            if (r1 != 0) goto L_0x023e
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.String r2 = "AppMeasurementService not registered/enabled"
            r1.a(r2)
        L_0x023e:
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.String r2 = "Uploading is not possible. App measurement disabled"
            r1.a(r2)
            goto L_0x044a
        L_0x024b:
            a.d.a.a.i.b.q3 r1 = r0.z()
            r1.u()
            java.lang.String r1 = r1.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0269
            a.d.a.a.i.b.q3 r1 = r0.z()
            r1.u()
            java.lang.String r1 = r1.l
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0333
        L_0x0269:
            r0.t()
            a.d.a.a.i.b.q3 r1 = r0.z()
            r1.u()
            java.lang.String r1 = r1.k
            a.d.a.a.i.b.k4 r2 = r0.o()
            r2.b()
            android.content.SharedPreferences r2 = r2.v()
            java.lang.String r4 = "gmp_app_id"
            java.lang.String r2 = r2.getString(r4, r6)
            a.d.a.a.i.b.q3 r5 = r0.z()
            r5.u()
            java.lang.String r5 = r5.l
            a.d.a.a.i.b.k4 r7 = r0.o()
            r7.b()
            android.content.SharedPreferences r7 = r7.v()
            java.lang.String r8 = "admob_app_id"
            java.lang.String r7 = r7.getString(r8, r6)
            boolean r1 = a.d.a.a.i.b.v9.b0(r1, r2, r5, r7)
            if (r1 == 0) goto L_0x02f7
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.l
            java.lang.String r2 = "Rechecking which service to use due to a GMP App Id change"
            r1.a(r2)
            a.d.a.a.i.b.k4 r1 = r0.o()
            r1.b()
            java.lang.Boolean r2 = r1.w()
            android.content.SharedPreferences r5 = r1.v()
            android.content.SharedPreferences$Editor r5 = r5.edit()
            r5.clear()
            r5.apply()
            if (r2 == 0) goto L_0x02cf
            r1.s(r2)
        L_0x02cf:
            a.d.a.a.i.b.t3 r1 = r0.s
            a.d.a.a.i.b.c5.p(r1)
            a.d.a.a.i.b.t3 r1 = r0.s
            r1.A()
            a.d.a.a.i.b.u7 r1 = r0.t
            r1.F()
            a.d.a.a.i.b.u7 r1 = r0.t
            r1.E()
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.o4 r1 = r1.j
            long r9 = r0.G
            r1.b(r9)
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.q4 r1 = r1.l
            r1.b(r6)
        L_0x02f7:
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.q3 r2 = r0.z()
            r2.u()
            java.lang.String r2 = r2.k
            r1.b()
            android.content.SharedPreferences r1 = r1.v()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.putString(r4, r2)
            r1.apply()
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.q3 r2 = r0.z()
            r2.u()
            java.lang.String r2 = r2.l
            r1.b()
            android.content.SharedPreferences r1 = r1.v()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.putString(r8, r2)
            r1.apply()
        L_0x0333:
            boolean r1 = a.d.a.a.h.g.u9.b()
            if (r1 == 0) goto L_0x035a
            a.d.a.a.i.b.ka r1 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.P0
            boolean r1 = r1.o(r2)
            if (r1 == 0) goto L_0x035a
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.e r1 = r1.x()
            boolean r1 = r1.k()
            if (r1 != 0) goto L_0x035a
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.q4 r1 = r1.l
            r1.b(r6)
        L_0x035a:
            a.d.a.a.i.b.f6 r1 = r0.s()
            a.d.a.a.i.b.k4 r2 = r0.o()
            a.d.a.a.i.b.q4 r2 = r2.l
            java.lang.String r2 = r2.a()
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r1 = r1.g
            r1.set(r2)
            boolean r1 = a.d.a.a.h.g.ga.b()
            r2 = 0
            if (r1 == 0) goto L_0x03bb
            a.d.a.a.i.b.ka r1 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.r0
            boolean r1 = r1.o(r4)
            if (r1 == 0) goto L_0x03bb
            a.d.a.a.i.b.v9 r1 = r0.t()
            if (r1 == 0) goto L_0x03ba
            a.d.a.a.i.b.c5 r1 = r1.f2563a     // Catch:{ ClassNotFoundException -> 0x0392 }
            android.content.Context r1 = r1.f2123a     // Catch:{ ClassNotFoundException -> 0x0392 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0392 }
            java.lang.String r4 = "com.google.firebase.remoteconfig.FirebaseRemoteConfig"
            r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x0392 }
            goto L_0x0393
        L_0x0392:
            r3 = 0
        L_0x0393:
            if (r3 != 0) goto L_0x03bb
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.q4 r1 = r1.z
            java.lang.String r1 = r1.a()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03bb
            a.d.a.a.i.b.x3 r1 = r0.i()
            a.d.a.a.i.b.z3 r1 = r1.i
            java.lang.String r3 = "Remote config removed with active feature rollouts"
            r1.a(r3)
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.q4 r1 = r1.z
            r1.b(r6)
            goto L_0x03bb
        L_0x03ba:
            throw r6
        L_0x03bb:
            a.d.a.a.i.b.q3 r1 = r0.z()
            r1.u()
            java.lang.String r1 = r1.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x03d9
            a.d.a.a.i.b.q3 r1 = r0.z()
            r1.u()
            java.lang.String r1 = r1.l
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x044a
        L_0x03d9:
            boolean r1 = r0.d()
            a.d.a.a.i.b.k4 r3 = r0.o()
            android.content.SharedPreferences r3 = r3.f2315c
            java.lang.String r4 = "deferred_analytics_collection"
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x03fc
            a.d.a.a.i.b.ka r3 = r0.g
            boolean r3 = r3.w()
            if (r3 != 0) goto L_0x03fc
            a.d.a.a.i.b.k4 r3 = r0.o()
            r4 = r1 ^ 1
            r3.u(r4)
        L_0x03fc:
            if (r1 == 0) goto L_0x0405
            a.d.a.a.i.b.f6 r1 = r0.s()
            r1.N()
        L_0x0405:
            a.d.a.a.i.b.b9 r1 = r0.r()
            a.d.a.a.i.b.j9 r1 = r1.f2110d
            r1.a()
            a.d.a.a.i.b.u7 r1 = r0.x()
            java.util.concurrent.atomic.AtomicReference r3 = new java.util.concurrent.atomic.AtomicReference
            r3.<init>()
            r1.C(r3)
            boolean r1 = a.d.a.a.h.g.kb.b()
            if (r1 == 0) goto L_0x044a
            a.d.a.a.i.b.ka r1 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.H0
            boolean r1 = r1.o(r3)
            if (r1 == 0) goto L_0x044a
            a.d.a.a.i.b.u7 r1 = r0.x()
            a.d.a.a.i.b.k4 r3 = r0.o()
            a.d.a.a.i.b.l4 r3 = r3.C
            android.os.Bundle r3 = r3.a()
            r1.b()
            r1.u()
            com.google.android.gms.measurement.internal.zzn r2 = r1.K(r2)
            a.d.a.a.i.b.e8 r4 = new a.d.a.a.i.b.e8
            r4.<init>(r1, r3, r2)
            r1.B(r4)
        L_0x044a:
            a.d.a.a.i.b.k4 r1 = r0.o()
            a.d.a.a.i.b.m4 r1 = r1.t
            a.d.a.a.i.b.ka r0 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.Z
            boolean r0 = r0.o(r2)
            r1.a(r0)
            return
        L_0x045c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't initialize twice"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.e5.run():void");
    }
}

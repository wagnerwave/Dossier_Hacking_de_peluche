package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.b.f;
import a.d.a.a.e.q.c;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class s extends f {

    /* renamed from: c  reason: collision with root package name */
    public boolean f1554c;

    /* renamed from: d  reason: collision with root package name */
    public final p f1555d;

    /* renamed from: e  reason: collision with root package name */
    public final t0 f1556e;
    public final s0 f;
    public final k g;
    public long h = Long.MIN_VALUE;
    public final d0 i;
    public final d0 j;
    public final d1 k;
    public long l;
    public boolean m;

    public s(h hVar, j jVar) {
        super(hVar);
        b.k(jVar);
        this.f = new s0(hVar);
        this.f1555d = new p(hVar);
        this.f1556e = new t0(hVar);
        this.g = new k(hVar);
        this.k = new d1(this.f1490a.f1505c);
        this.i = new t(this, hVar);
        this.j = new u(this, hVar);
    }

    public final void A() {
        long j2;
        h hVar = this.f1490a;
        h.a(hVar.h);
        g0 g0Var = hVar.h;
        if (g0Var.f1497c && !g0Var.f1498d) {
            f.b();
            u();
            try {
                j2 = this.f1555d.C();
            } catch (SQLiteException e2) {
                n("Failed to get min/max hit times from local store", e2);
                j2 = 0;
            }
            if (j2 == 0) {
                return;
            }
            if (((c) this.f1490a.f1505c) == null) {
                throw null;
            } else if (Math.abs(System.currentTimeMillis() - j2) <= ((Long) i0.f.f1517a).longValue()) {
                b("Dispatch alarm scheduled (ms)", Long.valueOf(b0.b()));
                g0Var.u();
                b.o(g0Var.f1497c, "Receiver not registered");
                long b2 = b0.b();
                if (b2 > 0) {
                    g0Var.v();
                    if (((c) g0Var.f1490a.f1505c) != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() + b2;
                        g0Var.f1498d = true;
                        ((Boolean) i0.C.f1517a).booleanValue();
                        if (Build.VERSION.SDK_INT >= 24) {
                            g0Var.o("Scheduling upload with JobScheduler");
                            Context context = g0Var.f1490a.f1503a;
                            ComponentName componentName = new ComponentName(context, "com.google.android.gms.analytics.AnalyticsJobService");
                            int w = g0Var.w();
                            PersistableBundle persistableBundle = new PersistableBundle();
                            persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                            JobInfo build = new JobInfo.Builder(w, componentName).setMinimumLatency(b2).setOverrideDeadline(b2 << 1).setExtras(persistableBundle).build();
                            g0Var.b("Scheduling job. JobID", Integer.valueOf(w));
                            g1.a(context, build, "com.google.android.gms", "DispatchAlarm");
                            return;
                        }
                        g0Var.o("Scheduling upload with AlarmManager");
                        g0Var.f1499e.setInexactRepeating(2, elapsedRealtime, b2, g0Var.x());
                        return;
                    }
                    throw null;
                }
            }
        }
    }

    public final void B() {
        if (this.i.d()) {
            o("All hits dispatched or no network/service. Going to power save mode");
        }
        this.i.a();
        h hVar = this.f1490a;
        h.a(hVar.h);
        g0 g0Var = hVar.h;
        if (g0Var.f1498d) {
            g0Var.v();
        }
    }

    public final long C() {
        long j2 = this.h;
        if (j2 != Long.MIN_VALUE) {
            return j2;
        }
        long longValue = ((Long) i0.f1512c.f1517a).longValue();
        f1 j3 = j();
        j3.u();
        if (!j3.f1495e) {
            return longValue;
        }
        f1 j4 = j();
        j4.u();
        return ((long) j4.f) * 1000;
    }

    public final boolean D(String str) {
        return a.d.a.a.e.r.c.a(this.f1490a.f1503a).f1443a.checkCallingOrSelfPermission(str) == 0;
    }

    public final void t() {
        this.f1555d.s();
        this.f1556e.s();
        this.g.s();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[LOOP:1: B:18:0x004c->B:26:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0048 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v() {
        /*
            r5 = this;
            a.d.a.a.b.f.b()
            a.d.a.a.b.f.b()
            r5.u()
            a.d.a.a.h.f.j0<java.lang.Boolean> r0 = a.d.a.a.h.f.i0.f1510a
            V r0 = r0.f1517a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x001a
            java.lang.String r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService"
            r5.p(r0)
        L_0x001a:
            a.d.a.a.h.f.k r0 = r5.g
            boolean r0 = r0.w()
            if (r0 != 0) goto L_0x0028
            java.lang.String r0 = "Service not connected"
            r5.o(r0)
            return
        L_0x0028:
            a.d.a.a.h.f.p r0 = r5.f1555d
            boolean r0 = r0.x()
            if (r0 != 0) goto L_0x0083
            java.lang.String r0 = "Dispatching local hits to device AnalyticsService"
            r5.o(r0)
        L_0x0035:
            a.d.a.a.h.f.p r0 = r5.f1555d     // Catch:{ SQLiteException -> 0x007a }
            int r1 = a.d.a.a.h.f.b0.c()     // Catch:{ SQLiteException -> 0x007a }
            long r1 = (long) r1     // Catch:{ SQLiteException -> 0x007a }
            java.util.List r0 = r0.A(r1)     // Catch:{ SQLiteException -> 0x007a }
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            boolean r1 = r0.isEmpty()     // Catch:{ SQLiteException -> 0x007a }
            if (r1 == 0) goto L_0x004c
            r5.z()     // Catch:{ SQLiteException -> 0x007a }
            return
        L_0x004c:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0035
            r1 = 0
            java.lang.Object r1 = r0.get(r1)
            a.d.a.a.h.f.n0 r1 = (a.d.a.a.h.f.n0) r1
            a.d.a.a.h.f.k r2 = r5.g
            boolean r2 = r2.x(r1)
            if (r2 != 0) goto L_0x0065
            r5.z()
            return
        L_0x0065:
            r0.remove(r1)
            a.d.a.a.h.f.p r2 = r5.f1555d     // Catch:{ SQLiteException -> 0x0070 }
            long r3 = r1.f1539b     // Catch:{ SQLiteException -> 0x0070 }
            r2.D(r3)     // Catch:{ SQLiteException -> 0x0070 }
            goto L_0x004c
        L_0x0070:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r5.n(r1, r0)
            r5.B()
            return
        L_0x007a:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from store"
            r5.n(r1, r0)
            r5.B()
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.s.v():void");
    }

    public final void w(h0 h0Var) {
        long j2;
        long j3 = this.l;
        f.b();
        u();
        long v = k().v();
        if (v == 0) {
            j2 = -1;
        } else if (((c) this.f1490a.f1505c) != null) {
            j2 = Math.abs(System.currentTimeMillis() - v);
        } else {
            throw null;
        }
        d("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        x();
        try {
            y();
            k().w();
            z();
            if (h0Var != null) {
                h0Var.a((Throwable) null);
            }
            if (this.l != j3) {
                Context context = this.f.f1558a.f1503a;
                Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
                intent.addCategory(context.getPackageName());
                intent.putExtra(s0.f1557d, true);
                context.sendOrderedBroadcast(intent, (String) null);
            }
        } catch (Exception e2) {
            n("Local dispatch failed", e2);
            k().w();
            z();
            if (h0Var != null) {
                h0Var.a(e2);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:26|27|28|29|30|(1:32)|33|34) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00ae */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x() {
        /*
            r11 = this;
            boolean r0 = r11.m
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            a.d.a.a.h.f.j0<java.lang.Boolean> r0 = a.d.a.a.h.f.i0.f1510a
            V r0 = r0.f1517a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            a.d.a.a.h.f.k r0 = r11.g
            boolean r0 = r0.w()
            if (r0 == 0) goto L_0x001b
            return
        L_0x001b:
            a.d.a.a.h.f.j0<java.lang.Long> r0 = a.d.a.a.h.f.i0.z
            V r0 = r0.f1517a
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            a.d.a.a.h.f.d1 r2 = r11.k
            boolean r0 = r2.b(r0)
            if (r0 == 0) goto L_0x00e6
            a.d.a.a.h.f.d1 r0 = r11.k
            r0.a()
            java.lang.String r0 = "Connecting to service"
            r11.o(r0)
            a.d.a.a.h.f.k r0 = r11.g
            r1 = 0
            if (r0 == 0) goto L_0x00e5
            a.d.a.a.b.f.b()
            r0.u()
            a.d.a.a.h.f.o0 r2 = r0.f1519d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x004a
            goto L_0x00cf
        L_0x004a:
            a.d.a.a.h.f.m r2 = r0.f1518c
            if (r2 == 0) goto L_0x00e4
            a.d.a.a.b.f.b()
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "com.google.android.gms.analytics.service.START"
            r5.<init>(r6)
            android.content.ComponentName r6 = new android.content.ComponentName
            java.lang.String r7 = "com.google.android.gms"
            java.lang.String r8 = "com.google.android.gms.analytics.service.AnalyticsService"
            r6.<init>(r7, r8)
            r5.setComponent(r6)
            a.d.a.a.h.f.k r6 = r2.f1530c
            a.d.a.a.h.f.h r6 = r6.f1490a
            android.content.Context r6 = r6.f1503a
            java.lang.String r7 = "app_package_name"
            java.lang.String r8 = r6.getPackageName()
            r5.putExtra(r7, r8)
            a.d.a.a.e.p.a r7 = a.d.a.a.e.p.a.a()
            monitor-enter(r2)
            r2.f1528a = r1     // Catch:{ all -> 0x00e1 }
            r2.f1529b = r3     // Catch:{ all -> 0x00e1 }
            a.d.a.a.h.f.k r8 = r2.f1530c     // Catch:{ all -> 0x00e1 }
            a.d.a.a.h.f.m r8 = r8.f1518c     // Catch:{ all -> 0x00e1 }
            r9 = 129(0x81, float:1.81E-43)
            if (r7 == 0) goto L_0x00e0
            java.lang.Class r10 = r6.getClass()     // Catch:{ all -> 0x00e1 }
            r10.getName()     // Catch:{ all -> 0x00e1 }
            boolean r5 = r7.b(r6, r5, r8, r9)     // Catch:{ all -> 0x00e1 }
            a.d.a.a.h.f.k r6 = r2.f1530c     // Catch:{ all -> 0x00e1 }
            java.lang.String r7 = "Bind to service requested"
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x00e1 }
            r6.b(r7, r8)     // Catch:{ all -> 0x00e1 }
            if (r5 != 0) goto L_0x00a0
            r2.f1529b = r4     // Catch:{ all -> 0x00e1 }
            monitor-exit(r2)     // Catch:{ all -> 0x00e1 }
            goto L_0x00c6
        L_0x00a0:
            a.d.a.a.h.f.j0<java.lang.Long> r5 = a.d.a.a.h.f.i0.y     // Catch:{ InterruptedException -> 0x00ae }
            V r5 = r5.f1517a     // Catch:{ InterruptedException -> 0x00ae }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ InterruptedException -> 0x00ae }
            long r5 = r5.longValue()     // Catch:{ InterruptedException -> 0x00ae }
            r2.wait(r5)     // Catch:{ InterruptedException -> 0x00ae }
            goto L_0x00b5
        L_0x00ae:
            a.d.a.a.h.f.k r5 = r2.f1530c     // Catch:{ all -> 0x00e1 }
            java.lang.String r6 = "Wait for service connect was interrupted"
            r5.p(r6)     // Catch:{ all -> 0x00e1 }
        L_0x00b5:
            r2.f1529b = r4     // Catch:{ all -> 0x00e1 }
            a.d.a.a.h.f.o0 r5 = r2.f1528a     // Catch:{ all -> 0x00e1 }
            r2.f1528a = r1     // Catch:{ all -> 0x00e1 }
            if (r5 != 0) goto L_0x00c4
            a.d.a.a.h.f.k r1 = r2.f1530c     // Catch:{ all -> 0x00e1 }
            java.lang.String r6 = "Successfully bound to service but never got onServiceConnected callback"
            r1.q(r6)     // Catch:{ all -> 0x00e1 }
        L_0x00c4:
            monitor-exit(r2)     // Catch:{ all -> 0x00e1 }
            r1 = r5
        L_0x00c6:
            if (r1 == 0) goto L_0x00ce
            r0.f1519d = r1
            r0.y()
            goto L_0x00cf
        L_0x00ce:
            r3 = 0
        L_0x00cf:
            if (r3 == 0) goto L_0x00e6
            java.lang.String r0 = "Connected to service"
            r11.o(r0)
            a.d.a.a.h.f.d1 r0 = r11.k
            r1 = 0
            r0.f1489b = r1
            r11.v()
            goto L_0x00e6
        L_0x00e0:
            throw r1     // Catch:{ all -> 0x00e1 }
        L_0x00e1:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00e1 }
            throw r0
        L_0x00e4:
            throw r1
        L_0x00e5:
            throw r1
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.s.x():void");
    }

    public final boolean y() {
        f.b();
        u();
        o("Dispatching a batch of local hits");
        boolean z = !this.g.w();
        boolean z2 = !this.f1556e.B();
        if (!z || !z2) {
            long max = (long) Math.max(b0.c(), ((Integer) i0.h.f1517a).intValue());
            ArrayList arrayList = new ArrayList();
            long j2 = 0;
            while (true) {
                p pVar = this.f1555d;
                pVar.u();
                pVar.w().beginTransaction();
                arrayList.clear();
                try {
                    List<n0> A = this.f1555d.A(max);
                    ArrayList arrayList2 = (ArrayList) A;
                    if (arrayList2.isEmpty()) {
                        o("Store is empty, nothing to dispatch");
                        B();
                        try {
                            this.f1555d.y();
                            this.f1555d.v();
                            return false;
                        } catch (SQLiteException e2) {
                            n("Failed to commit local dispatch transaction", e2);
                            B();
                            return false;
                        }
                    } else {
                        b("Hits loaded from store. count", Integer.valueOf(arrayList2.size()));
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            if (((n0) it.next()).f1539b == j2) {
                                m("Database contains successfully uploaded hit", Long.valueOf(j2), Integer.valueOf(arrayList2.size()));
                                B();
                                try {
                                    this.f1555d.y();
                                    this.f1555d.v();
                                    return false;
                                } catch (SQLiteException e3) {
                                    n("Failed to commit local dispatch transaction", e3);
                                    B();
                                    return false;
                                }
                            }
                        }
                        if (this.g.w()) {
                            o("Service connected, sending hits to the service");
                            while (!arrayList2.isEmpty()) {
                                n0 n0Var = (n0) arrayList2.get(0);
                                if (this.g.x(n0Var)) {
                                    j2 = Math.max(j2, n0Var.f1539b);
                                    arrayList2.remove(n0Var);
                                    d("Hit sent do device AnalyticsService for delivery", n0Var);
                                    try {
                                        this.f1555d.D(n0Var.f1539b);
                                        arrayList.add(Long.valueOf(n0Var.f1539b));
                                    } catch (SQLiteException e4) {
                                        n("Failed to remove hit that was send for delivery", e4);
                                        B();
                                        try {
                                            this.f1555d.y();
                                            this.f1555d.v();
                                            return false;
                                        } catch (SQLiteException e5) {
                                            n("Failed to commit local dispatch transaction", e5);
                                            B();
                                            return false;
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            this.f1555d.y();
                                            this.f1555d.v();
                                            throw th;
                                        } catch (SQLiteException e6) {
                                            n("Failed to commit local dispatch transaction", e6);
                                            B();
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                        if (this.f1556e.B()) {
                            List<Long> A2 = this.f1556e.A(A);
                            for (Long longValue : A2) {
                                j2 = Math.max(j2, longValue.longValue());
                            }
                            try {
                                this.f1555d.z(A2);
                                arrayList.addAll(A2);
                            } catch (SQLiteException e7) {
                                n("Failed to remove successfully uploaded hits", e7);
                                B();
                                try {
                                    this.f1555d.y();
                                    this.f1555d.v();
                                    return false;
                                } catch (SQLiteException e8) {
                                    n("Failed to commit local dispatch transaction", e8);
                                    B();
                                    return false;
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            try {
                                this.f1555d.y();
                                this.f1555d.v();
                                return false;
                            } catch (SQLiteException e9) {
                                n("Failed to commit local dispatch transaction", e9);
                                B();
                                return false;
                            }
                        } else {
                            try {
                                this.f1555d.y();
                                this.f1555d.v();
                            } catch (SQLiteException e10) {
                                n("Failed to commit local dispatch transaction", e10);
                                B();
                                return false;
                            }
                        }
                    }
                } catch (SQLiteException e11) {
                    l("Failed to read hits from persisted store", e11);
                    B();
                    try {
                        this.f1555d.y();
                        this.f1555d.v();
                        return false;
                    } catch (SQLiteException e12) {
                        n("Failed to commit local dispatch transaction", e12);
                        B();
                        return false;
                    }
                }
            }
        } else {
            o("No network or service available. Will retry later");
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c7, code lost:
        if (r4 > 0) goto L_0x00d9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z() {
        /*
            r12 = this;
            a.d.a.a.b.f.b()
            r12.u()
            boolean r0 = r12.m
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            long r4 = r12.C()
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 != 0) goto L_0x0023
            a.d.a.a.h.f.s0 r0 = r12.f
            r0.a()
            r12.B()
            return
        L_0x0023:
            a.d.a.a.h.f.p r0 = r12.f1555d
            boolean r0 = r0.x()
            if (r0 == 0) goto L_0x0034
            a.d.a.a.h.f.s0 r0 = r12.f
            r0.a()
            r12.B()
            return
        L_0x0034:
            a.d.a.a.h.f.j0<java.lang.Boolean> r0 = a.d.a.a.h.f.i0.w
            V r0 = r0.f1517a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x009c
            a.d.a.a.h.f.s0 r0 = r12.f
            a.d.a.a.h.f.h r4 = r0.f1558a
            r4.c()
            a.d.a.a.h.f.h r4 = r0.f1558a
            r4.e()
            boolean r4 = r0.f1559b
            if (r4 == 0) goto L_0x0051
            goto L_0x0089
        L_0x0051:
            a.d.a.a.h.f.h r4 = r0.f1558a
            android.content.Context r4 = r4.f1503a
            android.content.IntentFilter r5 = new android.content.IntentFilter
            java.lang.String r6 = "android.net.conn.CONNECTIVITY_CHANGE"
            r5.<init>(r6)
            r4.registerReceiver(r0, r5)
            android.content.IntentFilter r5 = new android.content.IntentFilter
            java.lang.String r6 = "com.google.analytics.RADIO_POWERED"
            r5.<init>(r6)
            java.lang.String r6 = r4.getPackageName()
            r5.addCategory(r6)
            r4.registerReceiver(r0, r5)
            boolean r4 = r0.b()
            r0.f1560c = r4
            a.d.a.a.h.f.h r4 = r0.f1558a
            a.d.a.a.h.f.r0 r4 = r4.c()
            boolean r5 = r0.f1560c
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.String r6 = "Registering connectivity change receiver. Network connected"
            r4.b(r6, r5)
            r0.f1559b = r1
        L_0x0089:
            a.d.a.a.h.f.s0 r0 = r12.f
            boolean r1 = r0.f1559b
            if (r1 != 0) goto L_0x009a
            a.d.a.a.h.f.h r1 = r0.f1558a
            a.d.a.a.h.f.r0 r1 = r1.c()
            java.lang.String r4 = "Connectivity unknown. Receiver not registered"
            r1.p(r4)
        L_0x009a:
            boolean r1 = r0.f1560c
        L_0x009c:
            if (r1 == 0) goto L_0x0166
            r12.A()
            long r0 = r12.C()
            a.d.a.a.h.f.u0 r4 = r12.k()
            long r4 = r4.v()
            r6 = 0
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x00cb
            a.d.a.a.h.f.h r7 = r12.f1490a
            a.d.a.a.e.q.b r7 = r7.f1505c
            a.d.a.a.e.q.c r7 = (a.d.a.a.e.q.c) r7
            if (r7 == 0) goto L_0x00ca
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r4
            long r4 = java.lang.Math.abs(r7)
            long r4 = r0 - r4
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x00cb
            goto L_0x00d9
        L_0x00ca:
            throw r6
        L_0x00cb:
            a.d.a.a.h.f.j0<java.lang.Long> r4 = a.d.a.a.h.f.i0.f1513d
            V r4 = r4.f1517a
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            long r4 = java.lang.Math.min(r4, r0)
        L_0x00d9:
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            java.lang.String r1 = "Dispatch scheduled (ms)"
            r12.b(r1, r0)
            a.d.a.a.h.f.d0 r0 = r12.i
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0160
            r0 = 1
            a.d.a.a.h.f.d0 r7 = r12.i
            long r8 = r7.f1487c
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 != 0) goto L_0x00f6
            r7 = r2
            goto L_0x0109
        L_0x00f6:
            a.d.a.a.h.f.h r8 = r7.f1485a
            a.d.a.a.e.q.b r8 = r8.f1505c
            a.d.a.a.e.q.c r8 = (a.d.a.a.e.q.c) r8
            if (r8 == 0) goto L_0x015f
            long r8 = java.lang.System.currentTimeMillis()
            long r10 = r7.f1487c
            long r8 = r8 - r10
            long r7 = java.lang.Math.abs(r8)
        L_0x0109:
            long r4 = r4 + r7
            long r0 = java.lang.Math.max(r0, r4)
            a.d.a.a.h.f.d0 r4 = r12.i
            boolean r5 = r4.d()
            if (r5 != 0) goto L_0x0117
            goto L_0x015d
        L_0x0117:
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x011f
            r4.a()
            goto L_0x015d
        L_0x011f:
            a.d.a.a.h.f.h r5 = r4.f1485a
            a.d.a.a.e.q.b r5 = r5.f1505c
            a.d.a.a.e.q.c r5 = (a.d.a.a.e.q.c) r5
            if (r5 == 0) goto L_0x015e
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r4.f1487c
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r0 = r0 - r5
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x0138
            goto L_0x0139
        L_0x0138:
            r2 = r0
        L_0x0139:
            android.os.Handler r0 = r4.b()
            java.lang.Runnable r1 = r4.f1486b
            r0.removeCallbacks(r1)
            android.os.Handler r0 = r4.b()
            java.lang.Runnable r1 = r4.f1486b
            boolean r0 = r0.postDelayed(r1, r2)
            if (r0 != 0) goto L_0x015d
            a.d.a.a.h.f.h r0 = r4.f1485a
            a.d.a.a.h.f.r0 r0 = r0.c()
            java.lang.Long r1 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "Failed to adjust delayed post. time"
            r0.n(r2, r1)
        L_0x015d:
            return
        L_0x015e:
            throw r6
        L_0x015f:
            throw r6
        L_0x0160:
            a.d.a.a.h.f.d0 r0 = r12.i
            r0.e(r4)
            return
        L_0x0166:
            r12.B()
            r12.A()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.s.z():void");
    }
}

package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.p.a;
import a.d.a.a.e.q.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal.ws.RealWebSocket;

public final class u7 extends a5 {

    /* renamed from: c  reason: collision with root package name */
    public final o8 f2548c;

    /* renamed from: d  reason: collision with root package name */
    public p3 f2549d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Boolean f2550e;
    public final i f;
    public final i9 g;
    public final List<Runnable> h = new ArrayList();
    public final i i;

    public u7(c5 c5Var) {
        super(c5Var);
        this.g = new i9(c5Var.n);
        this.f2548c = new o8(this);
        this.f = new t7(this, c5Var);
        this.i = new d8(this, c5Var);
    }

    public static void z(u7 u7Var, ComponentName componentName) {
        u7Var.b();
        if (u7Var.f2549d != null) {
            u7Var.f2549d = null;
            u7Var.i().n.b("Disconnected from device MeasurementService", componentName);
            u7Var.b();
            u7Var.E();
        }
    }

    @WorkerThread
    public final void A(zzw zzw) {
        boolean z;
        b.k(zzw);
        b();
        u();
        t3 s = s();
        s.e();
        byte[] e0 = v9.e0(zzw);
        if (e0.length > 131072) {
            s.i().g.a("Conditional user property too long for local database. Sending directly to service");
            z = false;
        } else {
            z = s.z(2, e0);
        }
        B(new k8(this, z, new zzw(zzw), K(true), zzw));
    }

    @WorkerThread
    public final void B(Runnable runnable) {
        b();
        if (D()) {
            runnable.run();
        } else if (((long) this.h.size()) >= 1000) {
            i().f.a("Discarding data. Max runnable queue size reached");
        } else {
            this.h.add(runnable);
            this.i.b(RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
            E();
        }
    }

    @WorkerThread
    public final void C(AtomicReference<String> atomicReference) {
        b();
        u();
        B(new a8(this, atomicReference, K(false)));
    }

    @WorkerThread
    public final boolean D() {
        b();
        u();
        return this.f2549d != null;
    }

    @WorkerThread
    public final void E() {
        b();
        u();
        if (!D()) {
            if (I()) {
                o8 o8Var = this.f2548c;
                o8Var.f2441c.b();
                Context context = o8Var.f2441c.f2563a.f2123a;
                synchronized (o8Var) {
                    if (o8Var.f2439a) {
                        o8Var.f2441c.i().n.a("Connection attempt already in progress");
                    } else if (o8Var.f2440b == null || (!o8Var.f2440b.g() && !o8Var.f2440b.isConnected())) {
                        o8Var.f2440b = new u3(context, Looper.getMainLooper(), o8Var, o8Var);
                        o8Var.f2441c.i().n.a("Connecting to remote service");
                        o8Var.f2439a = true;
                        o8Var.f2440b.k();
                    } else {
                        o8Var.f2441c.i().n.a("Already awaiting connection attempt");
                    }
                }
            } else if (!this.f2563a.g.B()) {
                List<ResolveInfo> queryIntentServices = this.f2563a.f2123a.getPackageManager().queryIntentServices(new Intent().setClassName(this.f2563a.f2123a, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(this.f2563a.f2123a, "com.google.android.gms.measurement.AppMeasurementService"));
                    o8 o8Var2 = this.f2548c;
                    o8Var2.f2441c.b();
                    Context context2 = o8Var2.f2441c.f2563a.f2123a;
                    a a2 = a.a();
                    synchronized (o8Var2) {
                        if (o8Var2.f2439a) {
                            o8Var2.f2441c.i().n.a("Connection attempt already in progress");
                        } else {
                            o8Var2.f2441c.i().n.a("Using local app measurement service");
                            o8Var2.f2439a = true;
                            o8 o8Var3 = o8Var2.f2441c.f2548c;
                            if (a2 != null) {
                                context2.getClass().getName();
                                a2.b(context2, intent, o8Var3, 129);
                            } else {
                                throw null;
                            }
                        }
                    }
                    return;
                }
                i().f.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    @WorkerThread
    public final void F() {
        b();
        u();
        o8 o8Var = this.f2548c;
        if (o8Var.f2440b != null && (o8Var.f2440b.isConnected() || o8Var.f2440b.g())) {
            o8Var.f2440b.disconnect();
        }
        o8Var.f2440b = null;
        try {
            a a2 = a.a();
            Context context = this.f2563a.f2123a;
            o8 o8Var2 = this.f2548c;
            if (a2 != null) {
                context.unbindService(o8Var2);
                this.f2549d = null;
                return;
            }
            throw null;
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
    }

    @WorkerThread
    public final boolean G() {
        b();
        u();
        if (!this.f2563a.g.o(q.Q0)) {
            return false;
        }
        return !I() || e().z0() >= q.R0.a(null).intValue();
    }

    @WorkerThread
    public final void H() {
        b();
        i9 i9Var = this.g;
        if (((c) i9Var.f2277a) != null) {
            i9Var.f2278b = SystemClock.elapsedRealtime();
            this.f.b(q.J.a(null).longValue());
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fd  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean I() {
        /*
            r7 = this;
            r7.b()
            r7.u()
            java.lang.Boolean r0 = r7.f2550e
            if (r0 != 0) goto L_0x011a
            r7.b()
            r7.u()
            a.d.a.a.i.b.k4 r0 = r7.k()
            r0.b()
            android.content.SharedPreferences r1 = r0.v()
            java.lang.String r2 = "use_service"
            boolean r1 = r1.contains(r2)
            r3 = 0
            r4 = 0
            if (r1 != 0) goto L_0x0027
            r0 = r3
            goto L_0x0033
        L_0x0027:
            android.content.SharedPreferences r0 = r0.v()
            boolean r0 = r0.getBoolean(r2, r4)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0033:
            r1 = 1
            if (r0 == 0) goto L_0x003e
            boolean r5 = r0.booleanValue()
            if (r5 == 0) goto L_0x003e
            goto L_0x0112
        L_0x003e:
            a.d.a.a.i.b.q3 r5 = r7.p()
            r5.u()
            int r5 = r5.j
            if (r5 != r1) goto L_0x004b
            goto L_0x00e1
        L_0x004b:
            a.d.a.a.i.b.x3 r5 = r7.i()
            a.d.a.a.i.b.z3 r5 = r5.n
            java.lang.String r6 = "Checking service availability"
            r5.a(r6)
            a.d.a.a.i.b.v9 r5 = r7.e()
            if (r5 == 0) goto L_0x0119
            a.d.a.a.e.d r3 = a.d.a.a.e.d.f1239b
            a.d.a.a.i.b.c5 r5 = r5.f2563a
            android.content.Context r5 = r5.f2123a
            r6 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r3 = r3.b(r5, r6)
            if (r3 == 0) goto L_0x00d6
            if (r3 == r1) goto L_0x00c8
            r5 = 2
            if (r3 == r5) goto L_0x00aa
            r0 = 3
            if (r3 == r0) goto L_0x009d
            r0 = 9
            if (r3 == r0) goto L_0x0094
            r0 = 18
            if (r3 == r0) goto L_0x008b
            a.d.a.a.i.b.x3 r0 = r7.i()
            a.d.a.a.i.b.z3 r0 = r0.i
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.String r3 = "Unexpected service status"
            r0.b(r3, r1)
            goto L_0x00a8
        L_0x008b:
            a.d.a.a.i.b.x3 r0 = r7.i()
            a.d.a.a.i.b.z3 r0 = r0.i
            java.lang.String r3 = "Service updating"
            goto L_0x00de
        L_0x0094:
            a.d.a.a.i.b.x3 r0 = r7.i()
            a.d.a.a.i.b.z3 r0 = r0.i
            java.lang.String r1 = "Service invalid"
            goto L_0x00a5
        L_0x009d:
            a.d.a.a.i.b.x3 r0 = r7.i()
            a.d.a.a.i.b.z3 r0 = r0.i
            java.lang.String r1 = "Service disabled"
        L_0x00a5:
            r0.a(r1)
        L_0x00a8:
            r1 = 0
            goto L_0x00d3
        L_0x00aa:
            a.d.a.a.i.b.x3 r3 = r7.i()
            a.d.a.a.i.b.z3 r3 = r3.m
            java.lang.String r5 = "Service container out of date"
            r3.a(r5)
            a.d.a.a.i.b.v9 r3 = r7.e()
            int r3 = r3.z0()
            r5 = 17443(0x4423, float:2.4443E-41)
            if (r3 >= r5) goto L_0x00c2
            goto L_0x00d3
        L_0x00c2:
            if (r0 != 0) goto L_0x00c5
            goto L_0x00c6
        L_0x00c5:
            r1 = 0
        L_0x00c6:
            r0 = 0
            goto L_0x00e2
        L_0x00c8:
            a.d.a.a.i.b.x3 r0 = r7.i()
            a.d.a.a.i.b.z3 r0 = r0.n
            java.lang.String r3 = "Service missing"
            r0.a(r3)
        L_0x00d3:
            r0 = r1
            r1 = 0
            goto L_0x00e2
        L_0x00d6:
            a.d.a.a.i.b.x3 r0 = r7.i()
            a.d.a.a.i.b.z3 r0 = r0.n
            java.lang.String r3 = "Service available"
        L_0x00de:
            r0.a(r3)
        L_0x00e1:
            r0 = 1
        L_0x00e2:
            if (r1 != 0) goto L_0x00fa
            a.d.a.a.i.b.c5 r3 = r7.f2563a
            a.d.a.a.i.b.ka r3 = r3.g
            boolean r3 = r3.B()
            if (r3 == 0) goto L_0x00fa
            a.d.a.a.i.b.x3 r0 = r7.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r3 = "No way to upload. Consider using the full version of Analytics"
            r0.a(r3)
            goto L_0x00fb
        L_0x00fa:
            r4 = r0
        L_0x00fb:
            if (r4 == 0) goto L_0x0112
            a.d.a.a.i.b.k4 r0 = r7.k()
            r0.b()
            android.content.SharedPreferences r0 = r0.v()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r2, r1)
            r0.apply()
        L_0x0112:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r7.f2550e = r0
            goto L_0x011a
        L_0x0119:
            throw r3
        L_0x011a:
            java.lang.Boolean r0 = r7.f2550e
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.u7.I():boolean");
    }

    @WorkerThread
    public final void J() {
        b();
        i().n.b("Processing queued up service tasks", Integer.valueOf(this.h.size()));
        for (Runnable run : this.h) {
            try {
                run.run();
            } catch (Exception e2) {
                i().f.b("Task exception while flushing queue", e2);
            }
        }
        this.h.clear();
        this.i.c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x023a  */
    @androidx.annotation.WorkerThread
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzn K(boolean r36) {
        /*
            r35 = this;
            a.d.a.a.i.b.q3 r1 = r35.p()
            if (r36 == 0) goto L_0x0010
            a.d.a.a.i.b.x3 r0 = r35.i()
            java.lang.String r0 = r0.E()
            r14 = r0
            goto L_0x0011
        L_0x0010:
            r14 = 0
        L_0x0011:
            r1.b()
            com.google.android.gms.measurement.internal.zzn r33 = new com.google.android.gms.measurement.internal.zzn
            r1.u()
            java.lang.String r4 = r1.f2474c
            r1.u()
            java.lang.String r5 = r1.k
            r1.u()
            java.lang.String r6 = r1.f2475d
            r1.u()
            int r0 = r1.f2476e
            long r7 = (long) r0
            r1.u()
            java.lang.String r9 = r1.f
            r1.u()
            r1.b()
            long r10 = r1.g
            r3 = 0
            r12 = 0
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x00c0
            a.d.a.a.i.b.c5 r0 = r1.f2563a
            a.d.a.a.i.b.v9 r10 = r0.t()
            a.d.a.a.i.b.c5 r0 = r1.f2563a
            android.content.Context r0 = r0.f2123a
            java.lang.String r11 = r0.getPackageName()
            r10.b()
            a.c.a.f.b.k(r0)
            a.c.a.f.b.h(r11)
            android.content.pm.PackageManager r15 = r0.getPackageManager()
            java.security.MessageDigest r12 = a.d.a.a.i.b.v9.y0()
            r18 = -1
            if (r12 != 0) goto L_0x006e
            a.d.a.a.i.b.x3 r0 = r10.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r10 = "Could not get MD5 instance"
            r0.a(r10)
            goto L_0x00ad
        L_0x006e:
            if (r15 == 0) goto L_0x00bc
            boolean r11 = r10.p0(r0, r11)     // Catch:{ NameNotFoundException -> 0x00b0 }
            if (r11 != 0) goto L_0x00bc
            a.d.a.a.e.r.b r0 = a.d.a.a.e.r.c.a(r0)     // Catch:{ NameNotFoundException -> 0x00b0 }
            a.d.a.a.i.b.c5 r11 = r10.f2563a     // Catch:{ NameNotFoundException -> 0x00b0 }
            android.content.Context r11 = r11.f2123a     // Catch:{ NameNotFoundException -> 0x00b0 }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ NameNotFoundException -> 0x00b0 }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.b(r11, r13)     // Catch:{ NameNotFoundException -> 0x00b0 }
            android.content.pm.Signature[] r11 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00b0 }
            if (r11 == 0) goto L_0x00a2
            android.content.pm.Signature[] r11 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00b0 }
            int r11 = r11.length     // Catch:{ NameNotFoundException -> 0x00b0 }
            if (r11 <= 0) goto L_0x00a2
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00b0 }
            r0 = r0[r3]     // Catch:{ NameNotFoundException -> 0x00b0 }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00b0 }
            byte[] r0 = r12.digest(r0)     // Catch:{ NameNotFoundException -> 0x00b0 }
            long r18 = a.d.a.a.i.b.v9.w(r0)     // Catch:{ NameNotFoundException -> 0x00b0 }
            goto L_0x00ad
        L_0x00a2:
            a.d.a.a.i.b.x3 r0 = r10.i()     // Catch:{ NameNotFoundException -> 0x00b0 }
            a.d.a.a.i.b.z3 r0 = r0.i     // Catch:{ NameNotFoundException -> 0x00b0 }
            java.lang.String r11 = "Could not get signatures"
            r0.a(r11)     // Catch:{ NameNotFoundException -> 0x00b0 }
        L_0x00ad:
            r10 = r18
            goto L_0x00be
        L_0x00b0:
            r0 = move-exception
            a.d.a.a.i.b.x3 r10 = r10.i()
            a.d.a.a.i.b.z3 r10 = r10.f
            java.lang.String r11 = "Package name not found"
            r10.b(r11, r0)
        L_0x00bc:
            r10 = 0
        L_0x00be:
            r1.g = r10
        L_0x00c0:
            long r12 = r1.g
            a.d.a.a.i.b.c5 r0 = r1.f2563a
            boolean r15 = r0.d()
            a.d.a.a.i.b.k4 r0 = r1.k()
            boolean r0 = r0.v
            r10 = 1
            r0 = r0 ^ r10
            r1.b()
            a.d.a.a.i.b.c5 r11 = r1.f2563a
            boolean r11 = r11.d()
            if (r11 != 0) goto L_0x00e0
        L_0x00db:
            r19 = r15
        L_0x00dd:
            r2 = 0
            goto L_0x0161
        L_0x00e0:
            a.d.a.a.h.g.zc r11 = a.d.a.a.h.g.zc.f2065b
            java.lang.Object r11 = r11.a()
            a.d.a.a.h.g.yc r11 = (a.d.a.a.h.g.yc) r11
            boolean r11 = r11.a()
            if (r11 == 0) goto L_0x0105
            a.d.a.a.i.b.c5 r11 = r1.f2563a
            a.d.a.a.i.b.ka r11 = r11.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.n0
            boolean r2 = r11.o(r2)
            if (r2 == 0) goto L_0x0105
            a.d.a.a.i.b.x3 r2 = r1.i()
            a.d.a.a.i.b.z3 r2 = r2.n
            java.lang.String r11 = "Disabled IID for tests."
            r19 = r15
            goto L_0x015c
        L_0x0105:
            a.d.a.a.i.b.c5 r2 = r1.f2563a     // Catch:{ ClassNotFoundException -> 0x00db }
            android.content.Context r2 = r2.f2123a     // Catch:{ ClassNotFoundException -> 0x00db }
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00db }
            java.lang.String r11 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r2 = r2.loadClass(r11)     // Catch:{ ClassNotFoundException -> 0x00db }
            if (r2 != 0) goto L_0x0116
            goto L_0x00db
        L_0x0116:
            java.lang.String r11 = "getInstance"
            java.lang.Class[] r3 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x0152 }
            java.lang.Class<android.content.Context> r19 = android.content.Context.class
            r10 = 0
            r3[r10] = r19     // Catch:{ Exception -> 0x0152 }
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r11, r3)     // Catch:{ Exception -> 0x0152 }
            r11 = 1
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0152 }
            a.d.a.a.i.b.c5 r11 = r1.f2563a     // Catch:{ Exception -> 0x0152 }
            android.content.Context r11 = r11.f2123a     // Catch:{ Exception -> 0x0152 }
            r19 = r15
            r15 = 0
            r10[r15] = r11     // Catch:{ Exception -> 0x0154 }
            r11 = 0
            java.lang.Object r3 = r3.invoke(r11, r10)     // Catch:{ Exception -> 0x0154 }
            if (r3 != 0) goto L_0x0138
            r2 = r11
            goto L_0x0161
        L_0x0138:
            java.lang.String r10 = "getFirebaseInstanceId"
            java.lang.Class[] r11 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0149 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r10, r11)     // Catch:{ Exception -> 0x0149 }
            java.lang.Object[] r10 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0149 }
            java.lang.Object r2 = r2.invoke(r3, r10)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0149 }
            goto L_0x0161
        L_0x0149:
            a.d.a.a.i.b.x3 r2 = r1.i()
            a.d.a.a.i.b.z3 r2 = r2.k
            java.lang.String r11 = "Failed to retrieve Firebase Instance Id"
            goto L_0x015c
        L_0x0152:
            r19 = r15
        L_0x0154:
            a.d.a.a.i.b.x3 r2 = r1.i()
            a.d.a.a.i.b.z3 r2 = r2.j
            java.lang.String r11 = "Failed to obtain Firebase Analytics instance"
        L_0x015c:
            r2.a(r11)
            goto L_0x00dd
        L_0x0161:
            r21 = 0
            a.d.a.a.i.b.c5 r3 = r1.f2563a
            a.d.a.a.i.b.k4 r10 = r3.o()
            a.d.a.a.i.b.o4 r10 = r10.j
            long r10 = r10.a()
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            long r23 = r10.longValue()
            r15 = 0
            int r11 = (r23 > r15 ? 1 : (r23 == r15 ? 0 : -1))
            if (r11 != 0) goto L_0x0184
            long r10 = r3.G
            r17 = r2
            r23 = r10
            goto L_0x0192
        L_0x0184:
            r17 = r2
            long r2 = r3.G
            long r10 = r10.longValue()
            long r2 = java.lang.Math.min(r2, r10)
            r23 = r2
        L_0x0192:
            r1.u()
            int r2 = r1.j
            a.d.a.a.i.b.c5 r3 = r1.f2563a
            a.d.a.a.i.b.ka r3 = r3.g
            java.lang.Boolean r3 = r3.x()
            boolean r25 = r3.booleanValue()
            a.d.a.a.i.b.c5 r3 = r1.f2563a
            a.d.a.a.i.b.ka r3 = r3.g
            java.lang.String r10 = "google_analytics_ssaid_collection_enabled"
            java.lang.Boolean r3 = r3.v(r10)
            if (r3 == 0) goto L_0x01b8
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x01b6
            goto L_0x01b8
        L_0x01b6:
            r10 = 0
            goto L_0x01b9
        L_0x01b8:
            r10 = 1
        L_0x01b9:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r10)
            boolean r26 = r3.booleanValue()
            a.d.a.a.i.b.k4 r3 = r1.k()
            r3.b()
            android.content.SharedPreferences r3 = r3.v()
            java.lang.String r10 = "deferred_analytics_collection"
            r11 = 0
            boolean r27 = r3.getBoolean(r10, r11)
            r1.u()
            java.lang.String r15 = r1.l
            a.d.a.a.i.b.c5 r3 = r1.f2563a
            a.d.a.a.i.b.ka r3 = r3.g
            java.lang.String r10 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r3 = r3.v(r10)
            if (r3 != 0) goto L_0x01e7
            r28 = 0
            goto L_0x01f3
        L_0x01e7:
            boolean r3 = r3.booleanValue()
            r10 = 1
            r3 = r3 ^ r10
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r28 = r3
        L_0x01f3:
            long r10 = r1.h
            java.util.List<java.lang.String> r3 = r1.i
            boolean r16 = a.d.a.a.h.g.jb.b()
            if (r16 == 0) goto L_0x0215
            r16 = r3
            a.d.a.a.i.b.c5 r3 = r1.f2563a
            a.d.a.a.i.b.ka r3 = r3.g
            r29 = r10
            a.d.a.a.i.b.n3<java.lang.Boolean> r10 = a.d.a.a.i.b.q.k0
            boolean r3 = r3.o(r10)
            if (r3 == 0) goto L_0x0219
            r1.u()
            java.lang.String r3 = r1.m
            r31 = r3
            goto L_0x021b
        L_0x0215:
            r16 = r3
            r29 = r10
        L_0x0219:
            r31 = 0
        L_0x021b:
            boolean r3 = a.d.a.a.h.g.u9.b()
            if (r3 == 0) goto L_0x023a
            a.d.a.a.i.b.c5 r3 = r1.f2563a
            a.d.a.a.i.b.ka r3 = r3.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r10 = a.d.a.a.i.b.q.P0
            boolean r3 = r3.o(r10)
            if (r3 == 0) goto L_0x023a
            a.d.a.a.i.b.k4 r1 = r1.k()
            a.d.a.a.i.b.e r1 = r1.x()
            java.lang.String r1 = r1.d()
            goto L_0x023c
        L_0x023a:
            java.lang.String r1 = ""
        L_0x023c:
            r32 = r1
            r10 = 31049(0x7949, double:1.534E-319)
            r1 = r16
            r3 = r33
            r34 = r15
            r15 = r19
            r16 = r0
            r18 = r21
            r20 = r23
            r22 = r2
            r23 = r25
            r24 = r26
            r25 = r27
            r26 = r34
            r27 = r28
            r28 = r29
            r30 = r1
            r3.<init>((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (java.lang.String) r9, (long) r10, (long) r12, (java.lang.String) r14, (boolean) r15, (boolean) r16, (java.lang.String) r17, (long) r18, (long) r20, (int) r22, (boolean) r23, (boolean) r24, (boolean) r25, (java.lang.String) r26, (java.lang.Boolean) r27, (long) r28, (java.util.List<java.lang.String>) r30, (java.lang.String) r31, (java.lang.String) r32)
            return r33
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.u7.K(boolean):com.google.android.gms.measurement.internal.zzn");
    }

    public final boolean w() {
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:63|64|65|66) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:87|88|89|90) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:49|50|51|52|69|93|216|101) */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01d6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01d8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01d9, code lost:
        r18 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01dd, code lost:
        r18 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01e1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01e2, code lost:
        r18 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d7, code lost:
        if (r0 != null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r8.i().f.a("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r4.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r8.i().f.a("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r4.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011b, code lost:
        if (r0 != null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0122, code lost:
        r18 = r6;
        r0 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0147, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r8.i().f.a("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r4.recycle();
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x015e, code lost:
        if (r5 != null) goto L_0x0160;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00dc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x010c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x014f */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01d6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:15:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:15:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01f3 A[SYNTHETIC, Splitter:B:138:0x01f3] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x023f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x023f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x023f A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y(a.d.a.a.i.b.p3 r28, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r29, com.google.android.gms.measurement.internal.zzn r30) {
        /*
            r27 = this;
            r1 = r28
            r2 = r29
            r3 = r30
            r27.b()
            r27.u()
            r4 = 100
            r5 = 0
            r0 = 100
            r6 = 0
        L_0x0012:
            r7 = 1001(0x3e9, float:1.403E-42)
            if (r6 >= r7) goto L_0x02de
            if (r0 != r4) goto L_0x02de
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            a.d.a.a.i.b.t3 r8 = r27.s()
            java.lang.String r9 = "Error reading entries from local database"
            r8.b()
            boolean r0 = r8.f2528d
            if (r0 == 0) goto L_0x002b
            goto L_0x0055
        L_0x002b:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            a.d.a.a.i.b.c5 r0 = r8.f2563a
            android.content.Context r0 = r0.f2123a
            java.lang.String r12 = "google_app_measurement_local.db"
            java.io.File r0 = r0.getDatabasePath(r12)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0042
            r10 = r11
            goto L_0x0056
        L_0x0042:
            r12 = 5
            r13 = 0
            r14 = 5
        L_0x0045:
            if (r13 >= r12) goto L_0x0257
            r15 = 1
            android.database.sqlite.SQLiteDatabase r10 = r8.C()     // Catch:{ SQLiteFullException -> 0x0223, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x01eb, all -> 0x01e6 }
            if (r10 != 0) goto L_0x005f
            r8.f2528d = r15     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x005b, all -> 0x01d6 }
            if (r10 == 0) goto L_0x0055
            r10.close()
        L_0x0055:
            r10 = 0
        L_0x0056:
            r18 = r6
            r15 = 0
            goto L_0x0266
        L_0x005b:
            r0 = move-exception
            goto L_0x007b
        L_0x005d:
            r0 = move-exception
            goto L_0x0080
        L_0x005f:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x01e1, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01d8, all -> 0x01d6 }
            long r16 = a.d.a.a.i.b.t3.y(r10)     // Catch:{ SQLiteFullException -> 0x01e1, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01d8, all -> 0x01d6 }
            r25 = -1
            int r0 = (r16 > r25 ? 1 : (r16 == r25 ? 0 : -1))
            if (r0 == 0) goto L_0x0085
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r12 = new java.lang.String[r15]     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x005b, all -> 0x01d6 }
            java.lang.String r16 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x005b, all -> 0x01d6 }
            r12[r5] = r16     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x005b, all -> 0x01d6 }
            r19 = r0
            r20 = r12
            goto L_0x0089
        L_0x007b:
            r18 = r6
            r12 = 0
            goto L_0x01c4
        L_0x0080:
            r18 = r6
            r12 = 0
            goto L_0x01c7
        L_0x0085:
            r19 = 0
            r20 = 0
        L_0x0089:
            java.lang.String r17 = "messages"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteFullException -> 0x01e1, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01d8, all -> 0x01d6 }
            java.lang.String r16 = "rowid"
            r12[r5] = r16     // Catch:{ SQLiteFullException -> 0x01e1, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01d8, all -> 0x01d6 }
            java.lang.String r16 = "type"
            r12[r15] = r16     // Catch:{ SQLiteFullException -> 0x01e1, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01d8, all -> 0x01d6 }
            java.lang.String r16 = "entry"
            r0 = 2
            r12[r0] = r16     // Catch:{ SQLiteFullException -> 0x01e1, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01d8, all -> 0x01d6 }
            r21 = 0
            r22 = 0
            java.lang.String r23 = "rowid asc"
            java.lang.String r24 = java.lang.Integer.toString(r4)     // Catch:{ SQLiteFullException -> 0x01e1, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01d8, all -> 0x01d6 }
            r16 = r10
            r18 = r12
            android.database.Cursor r12 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteFullException -> 0x01e1, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01d8, all -> 0x01d6 }
        L_0x00ad:
            boolean r16 = r12.moveToNext()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            if (r16 == 0) goto L_0x018a
            long r25 = r12.getLong(r5)     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            int r4 = r12.getInt(r15)     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            byte[] r15 = r12.getBlob(r0)     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            if (r4 != 0) goto L_0x00ef
            android.os.Parcel r4 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            int r0 = r15.length     // Catch:{ a -> 0x00dc }
            r4.unmarshall(r15, r5, r0)     // Catch:{ a -> 0x00dc }
            r4.setDataPosition(r5)     // Catch:{ a -> 0x00dc }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r0 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ a -> 0x00dc }
            java.lang.Object r0 = r0.createFromParcel(r4)     // Catch:{ a -> 0x00dc }
            com.google.android.gms.measurement.internal.zzar r0 = (com.google.android.gms.measurement.internal.zzar) r0     // Catch:{ a -> 0x00dc }
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            if (r0 == 0) goto L_0x0122
            goto L_0x011d
        L_0x00da:
            r0 = move-exception
            goto L_0x00eb
        L_0x00dc:
            a.d.a.a.i.b.x3 r0 = r8.i()     // Catch:{ all -> 0x00da }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ all -> 0x00da }
            java.lang.String r15 = "Failed to load event from local database"
            r0.a(r15)     // Catch:{ all -> 0x00da }
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            goto L_0x0122
        L_0x00eb:
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            throw r0     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
        L_0x00ef:
            r5 = 1
            if (r4 != r5) goto L_0x012a
            android.os.Parcel r4 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            int r0 = r15.length     // Catch:{ a -> 0x010c }
            r5 = 0
            r4.unmarshall(r15, r5, r0)     // Catch:{ a -> 0x010c }
            r4.setDataPosition(r5)     // Catch:{ a -> 0x010c }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkw> r0 = com.google.android.gms.measurement.internal.zzkw.CREATOR     // Catch:{ a -> 0x010c }
            java.lang.Object r0 = r0.createFromParcel(r4)     // Catch:{ a -> 0x010c }
            com.google.android.gms.measurement.internal.zzkw r0 = (com.google.android.gms.measurement.internal.zzkw) r0     // Catch:{ a -> 0x010c }
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            goto L_0x011b
        L_0x010a:
            r0 = move-exception
            goto L_0x0126
        L_0x010c:
            a.d.a.a.i.b.x3 r0 = r8.i()     // Catch:{ all -> 0x010a }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ all -> 0x010a }
            java.lang.String r5 = "Failed to load user property from local database"
            r0.a(r5)     // Catch:{ all -> 0x010a }
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            r0 = 0
        L_0x011b:
            if (r0 == 0) goto L_0x0122
        L_0x011d:
            r5 = r0
            r18 = r6
            r0 = 2
            goto L_0x0160
        L_0x0122:
            r18 = r6
            r0 = 2
            goto L_0x0163
        L_0x0126:
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            throw r0     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
        L_0x012a:
            r0 = 2
            if (r4 != r0) goto L_0x0169
            android.os.Parcel r4 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01d2, SQLiteDatabaseLockedException -> 0x01ce, SQLiteException -> 0x01ca }
            int r5 = r15.length     // Catch:{ a -> 0x014d, all -> 0x0149 }
            r18 = r6
            r6 = 0
            r4.unmarshall(r15, r6, r5)     // Catch:{ a -> 0x014f }
            r4.setDataPosition(r6)     // Catch:{ a -> 0x014f }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r5 = com.google.android.gms.measurement.internal.zzw.CREATOR     // Catch:{ a -> 0x014f }
            java.lang.Object r5 = r5.createFromParcel(r4)     // Catch:{ a -> 0x014f }
            com.google.android.gms.measurement.internal.zzw r5 = (com.google.android.gms.measurement.internal.zzw) r5     // Catch:{ a -> 0x014f }
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            goto L_0x015e
        L_0x0147:
            r0 = move-exception
            goto L_0x0165
        L_0x0149:
            r0 = move-exception
            r18 = r6
            goto L_0x0165
        L_0x014d:
            r18 = r6
        L_0x014f:
            a.d.a.a.i.b.x3 r5 = r8.i()     // Catch:{ all -> 0x0147 }
            a.d.a.a.i.b.z3 r5 = r5.f     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = "Failed to load conditional user property from local database"
            r5.a(r6)     // Catch:{ all -> 0x0147 }
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            r5 = 0
        L_0x015e:
            if (r5 == 0) goto L_0x0163
        L_0x0160:
            r11.add(r5)     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
        L_0x0163:
            r5 = 3
            goto L_0x0182
        L_0x0165:
            r4.recycle()     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
        L_0x0169:
            r18 = r6
            r5 = 3
            if (r4 != r5) goto L_0x0177
            a.d.a.a.i.b.x3 r4 = r8.i()     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            a.d.a.a.i.b.z3 r4 = r4.i     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            java.lang.String r6 = "Skipping app launch break"
            goto L_0x017f
        L_0x0177:
            a.d.a.a.i.b.x3 r4 = r8.i()     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            a.d.a.a.i.b.z3 r4 = r4.f     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            java.lang.String r6 = "Unknown record type in local database"
        L_0x017f:
            r4.a(r6)     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
        L_0x0182:
            r6 = r18
            r4 = 100
            r5 = 0
            r15 = 1
            goto L_0x00ad
        L_0x018a:
            r18 = r6
            java.lang.String r0 = "messages"
            java.lang.String r4 = "rowid <= ?"
            r5 = 1
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            java.lang.String r5 = java.lang.Long.toString(r25)     // Catch:{ SQLiteFullException -> 0x01c6, SQLiteDatabaseLockedException -> 0x01d0, SQLiteException -> 0x01c3 }
            r15 = 0
            r6[r15] = r5     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x0215, SQLiteException -> 0x01be }
            int r0 = r10.delete(r0, r4, r6)     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x0215, SQLiteException -> 0x01be }
            int r4 = r11.size()     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x0215, SQLiteException -> 0x01be }
            if (r0 >= r4) goto L_0x01af
            a.d.a.a.i.b.x3 r0 = r8.i()     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x0215, SQLiteException -> 0x01be }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x0215, SQLiteException -> 0x01be }
            java.lang.String r4 = "Fewer entries removed from local database than expected"
            r0.a(r4)     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x0215, SQLiteException -> 0x01be }
        L_0x01af:
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x0215, SQLiteException -> 0x01be }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x0215, SQLiteException -> 0x01be }
            r12.close()
            r10.close()
            r10 = r11
            goto L_0x0266
        L_0x01be:
            r0 = move-exception
            goto L_0x01f1
        L_0x01c0:
            r0 = move-exception
            goto L_0x0229
        L_0x01c3:
            r0 = move-exception
        L_0x01c4:
            r15 = 0
            goto L_0x01f1
        L_0x01c6:
            r0 = move-exception
        L_0x01c7:
            r15 = 0
            goto L_0x0229
        L_0x01ca:
            r0 = move-exception
            r18 = r6
            goto L_0x01c4
        L_0x01ce:
            r18 = r6
        L_0x01d0:
            r15 = 0
            goto L_0x0215
        L_0x01d2:
            r0 = move-exception
            r18 = r6
            goto L_0x01c7
        L_0x01d6:
            r0 = move-exception
            goto L_0x01e8
        L_0x01d8:
            r0 = move-exception
            r18 = r6
            r15 = 0
            goto L_0x01f0
        L_0x01dd:
            r18 = r6
            r15 = 0
            goto L_0x0214
        L_0x01e1:
            r0 = move-exception
            r18 = r6
            r15 = 0
            goto L_0x0228
        L_0x01e6:
            r0 = move-exception
            r10 = 0
        L_0x01e8:
            r1 = r10
            r10 = 0
            goto L_0x024c
        L_0x01eb:
            r0 = move-exception
            r18 = r6
            r15 = 0
            r10 = 0
        L_0x01f0:
            r12 = 0
        L_0x01f1:
            if (r10 == 0) goto L_0x01fc
            boolean r4 = r10.inTransaction()     // Catch:{ all -> 0x0249 }
            if (r4 == 0) goto L_0x01fc
            r10.endTransaction()     // Catch:{ all -> 0x0249 }
        L_0x01fc:
            a.d.a.a.i.b.x3 r4 = r8.i()     // Catch:{ all -> 0x0249 }
            a.d.a.a.i.b.z3 r4 = r4.f     // Catch:{ all -> 0x0249 }
            r4.b(r9, r0)     // Catch:{ all -> 0x0249 }
            r4 = 1
            r8.f2528d = r4     // Catch:{ all -> 0x0249 }
            if (r12 == 0) goto L_0x020d
            r12.close()
        L_0x020d:
            if (r10 == 0) goto L_0x023f
            goto L_0x023c
        L_0x0210:
            r18 = r6
            r15 = 0
            r10 = 0
        L_0x0214:
            r12 = 0
        L_0x0215:
            long r4 = (long) r14
            android.os.SystemClock.sleep(r4)     // Catch:{ all -> 0x0249 }
            int r14 = r14 + 20
            if (r12 == 0) goto L_0x0220
            r12.close()
        L_0x0220:
            if (r10 == 0) goto L_0x023f
            goto L_0x023c
        L_0x0223:
            r0 = move-exception
            r18 = r6
            r15 = 0
            r10 = 0
        L_0x0228:
            r12 = 0
        L_0x0229:
            a.d.a.a.i.b.x3 r4 = r8.i()     // Catch:{ all -> 0x0249 }
            a.d.a.a.i.b.z3 r4 = r4.f     // Catch:{ all -> 0x0249 }
            r4.b(r9, r0)     // Catch:{ all -> 0x0249 }
            r4 = 1
            r8.f2528d = r4     // Catch:{ all -> 0x0249 }
            if (r12 == 0) goto L_0x023a
            r12.close()
        L_0x023a:
            if (r10 == 0) goto L_0x023f
        L_0x023c:
            r10.close()
        L_0x023f:
            int r13 = r13 + 1
            r6 = r18
            r4 = 100
            r5 = 0
            r12 = 5
            goto L_0x0045
        L_0x0249:
            r0 = move-exception
            r1 = r10
            r10 = r12
        L_0x024c:
            if (r10 == 0) goto L_0x0251
            r10.close()
        L_0x0251:
            if (r1 == 0) goto L_0x0256
            r1.close()
        L_0x0256:
            throw r0
        L_0x0257:
            r18 = r6
            r15 = 0
            a.d.a.a.i.b.x3 r0 = r8.i()
            a.d.a.a.i.b.z3 r0 = r0.i
            java.lang.String r4 = "Failed to read events from database in reasonable time"
            r0.a(r4)
            r10 = 0
        L_0x0266:
            if (r10 == 0) goto L_0x0271
            r7.addAll(r10)
            int r0 = r10.size()
            r4 = r0
            goto L_0x0272
        L_0x0271:
            r4 = 0
        L_0x0272:
            r5 = 100
            if (r2 == 0) goto L_0x027b
            if (r4 >= r5) goto L_0x027b
            r7.add(r2)
        L_0x027b:
            int r6 = r7.size()
            r0 = 0
        L_0x0280:
            if (r0 >= r6) goto L_0x02d6
            java.lang.Object r8 = r7.get(r0)
            int r9 = r0 + 1
            com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r8 = (com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable) r8
            boolean r0 = r8 instanceof com.google.android.gms.measurement.internal.zzar
            if (r0 == 0) goto L_0x029e
            com.google.android.gms.measurement.internal.zzar r8 = (com.google.android.gms.measurement.internal.zzar) r8     // Catch:{ RemoteException -> 0x0294 }
            r1.A(r8, r3)     // Catch:{ RemoteException -> 0x0294 }
            goto L_0x02d4
        L_0x0294:
            r0 = move-exception
            a.d.a.a.i.b.x3 r8 = r27.i()
            a.d.a.a.i.b.z3 r8 = r8.f
            java.lang.String r10 = "Failed to send event to the service"
            goto L_0x02c5
        L_0x029e:
            boolean r0 = r8 instanceof com.google.android.gms.measurement.internal.zzkw
            if (r0 == 0) goto L_0x02b2
            com.google.android.gms.measurement.internal.zzkw r8 = (com.google.android.gms.measurement.internal.zzkw) r8     // Catch:{ RemoteException -> 0x02a8 }
            r1.u(r8, r3)     // Catch:{ RemoteException -> 0x02a8 }
            goto L_0x02d4
        L_0x02a8:
            r0 = move-exception
            a.d.a.a.i.b.x3 r8 = r27.i()
            a.d.a.a.i.b.z3 r8 = r8.f
            java.lang.String r10 = "Failed to send user property to the service"
            goto L_0x02c5
        L_0x02b2:
            boolean r0 = r8 instanceof com.google.android.gms.measurement.internal.zzw
            if (r0 == 0) goto L_0x02c9
            com.google.android.gms.measurement.internal.zzw r8 = (com.google.android.gms.measurement.internal.zzw) r8     // Catch:{ RemoteException -> 0x02bc }
            r1.l(r8, r3)     // Catch:{ RemoteException -> 0x02bc }
            goto L_0x02d4
        L_0x02bc:
            r0 = move-exception
            a.d.a.a.i.b.x3 r8 = r27.i()
            a.d.a.a.i.b.z3 r8 = r8.f
            java.lang.String r10 = "Failed to send conditional user property to the service"
        L_0x02c5:
            r8.b(r10, r0)
            goto L_0x02d4
        L_0x02c9:
            a.d.a.a.i.b.x3 r0 = r27.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r8 = "Discarding data. Unrecognized parcel type."
            r0.a(r8)
        L_0x02d4:
            r0 = r9
            goto L_0x0280
        L_0x02d6:
            int r6 = r18 + 1
            r0 = r4
            r4 = 100
            r5 = 0
            goto L_0x0012
        L_0x02de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.u7.y(a.d.a.a.i.b.p3, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzn):void");
    }
}

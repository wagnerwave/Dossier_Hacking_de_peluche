package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.q.c;
import a.d.a.a.h.g.ma;
import a.d.a.a.h.g.pa;
import a.d.a.a.h.g.u9;
import a.d.a.a.h.g.xa;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class f6 extends a5 {

    /* renamed from: c  reason: collision with root package name */
    public d7 f2193c;

    /* renamed from: d  reason: collision with root package name */
    public e6 f2194d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d6> f2195e = new CopyOnWriteArraySet();
    public boolean f;
    public final AtomicReference<String> g = new AtomicReference<>();
    public final Object h = new Object();
    @GuardedBy("consentLock")
    public e i = new e((Boolean) null, (Boolean) null);
    @GuardedBy("consentLock")
    public int j = 100;
    public final AtomicLong k = new AtomicLong(0);
    public long l = -1;
    public int m = 100;
    public final ca n;
    public boolean o = true;

    public f6(c5 c5Var) {
        super(c5Var);
        this.n = new ca(c5Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void C(a.d.a.a.i.b.f6 r6, a.d.a.a.i.b.e r7, int r8, long r9, boolean r11, boolean r12) {
        /*
            r6.b()
            r6.u()
            long r0 = r6.l
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x001e
            int r0 = r6.m
            boolean r0 = a.d.a.a.i.b.e.e(r0, r8)
            if (r0 == 0) goto L_0x001e
            a.d.a.a.i.b.x3 r6 = r6.i()
            a.d.a.a.i.b.z3 r6 = r6.l
            java.lang.String r8 = "Dropped out-of-date consent setting, proposed settings"
            goto L_0x00c2
        L_0x001e:
            a.d.a.a.i.b.k4 r0 = r6.k()
            r1 = 0
            if (r0 == 0) goto L_0x00c6
            boolean r2 = a.d.a.a.h.g.u9.b()
            r3 = 0
            if (r2 == 0) goto L_0x0066
            a.d.a.a.i.b.c5 r2 = r0.f2563a
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.P0
            boolean r2 = r2.o(r4)
            if (r2 == 0) goto L_0x0066
            r0.b()
            android.content.SharedPreferences r2 = r0.v()
            r4 = 100
            java.lang.String r5 = "consent_source"
            int r2 = r2.getInt(r5, r4)
            boolean r2 = a.d.a.a.i.b.e.e(r8, r2)
            if (r2 == 0) goto L_0x0066
            android.content.SharedPreferences r0 = r0.v()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r7 = r7.d()
            java.lang.String r2 = "consent_settings"
            r0.putString(r2, r7)
            r0.putInt(r5, r8)
            r0.apply()
            r7 = 1
            goto L_0x0067
        L_0x0066:
            r7 = 0
        L_0x0067:
            if (r7 == 0) goto L_0x00b6
            r6.l = r9
            r6.m = r8
            a.d.a.a.i.b.u7 r7 = r6.q()
            if (r7 == 0) goto L_0x00b5
            boolean r8 = a.d.a.a.h.g.u9.b()
            if (r8 == 0) goto L_0x00a6
            a.d.a.a.i.b.c5 r8 = r7.f2563a
            a.d.a.a.i.b.ka r8 = r8.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r9 = a.d.a.a.i.b.q.P0
            boolean r8 = r8.o(r9)
            if (r8 == 0) goto L_0x00a6
            r7.b()
            r7.u()
            if (r11 == 0) goto L_0x0094
            a.d.a.a.i.b.t3 r8 = r7.s()
            r8.A()
        L_0x0094:
            boolean r8 = r7.G()
            if (r8 == 0) goto L_0x00a6
            com.google.android.gms.measurement.internal.zzn r8 = r7.K(r3)
            a.d.a.a.i.b.i8 r9 = new a.d.a.a.i.b.i8
            r9.<init>(r7, r8)
            r7.B(r9)
        L_0x00a6:
            if (r12 == 0) goto L_0x00c5
            a.d.a.a.i.b.u7 r6 = r6.q()
            java.util.concurrent.atomic.AtomicReference r7 = new java.util.concurrent.atomic.AtomicReference
            r7.<init>()
            r6.C(r7)
            goto L_0x00c5
        L_0x00b5:
            throw r1
        L_0x00b6:
            a.d.a.a.i.b.x3 r6 = r6.i()
            a.d.a.a.i.b.z3 r6 = r6.l
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.String r8 = "Lower precedence consent source ignored, proposed source"
        L_0x00c2:
            r6.b(r8, r7)
        L_0x00c5:
            return
        L_0x00c6:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.f6.C(a.d.a.a.i.b.f6, a.d.a.a.i.b.e, int, long, boolean, boolean):void");
    }

    @WorkerThread
    public final void A(e eVar) {
        b();
        boolean z = (eVar.k() && eVar.j()) || q().G();
        if (z != this.f2563a.h()) {
            c5 c5Var = this.f2563a;
            c5Var.f().b();
            c5Var.D = z;
            k4 k2 = k();
            Boolean bool = null;
            if (k2 != null) {
                if (u9.b() && k2.f2563a.g.o(q.P0)) {
                    k2.b();
                    if (k2.v().contains("measurement_enabled_from_api")) {
                        bool = Boolean.valueOf(k2.v().getBoolean("measurement_enabled_from_api", true));
                    }
                }
                if (!z || bool == null || bool.booleanValue()) {
                    D(Boolean.valueOf(z), false);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public final void B(e eVar, int i2, long j2) {
        boolean z;
        boolean z2;
        boolean z3;
        e eVar2 = eVar;
        if (u9.b() && this.f2563a.g.o(q.P0)) {
            u();
            if (eVar2.f2161a == null && eVar2.f2162b == null) {
                i().k.a("Discarding empty consent settings");
                return;
            }
            synchronized (this.h) {
                z = false;
                if (e.e(i2, this.j)) {
                    z3 = eVar.f(this.i);
                    if (eVar.k() && !this.i.k()) {
                        z = true;
                    }
                    e eVar3 = this.i;
                    Boolean bool = eVar2.f2161a;
                    if (bool == null) {
                        bool = eVar3.f2161a;
                    }
                    Boolean bool2 = eVar2.f2162b;
                    if (bool2 == null) {
                        bool2 = eVar3.f2162b;
                    }
                    e eVar4 = new e(bool, bool2);
                    this.i = eVar4;
                    z2 = z;
                    eVar2 = eVar4;
                    z = true;
                } else {
                    z3 = false;
                    z2 = false;
                }
            }
            if (!z) {
                i().l.b("Ignoring lower-priority consent settings, proposed settings", eVar2);
                return;
            }
            long andIncrement = this.k.getAndIncrement();
            if (z3) {
                this.g.set((Object) null);
                v4 f2 = f();
                c7 c7Var = new c7(this, eVar2, j2, i2, andIncrement, z2);
                f2.n();
                b.k(c7Var);
                f2.u(new z4(f2, (Runnable) c7Var, true, "Task exception on worker thread"));
                return;
            }
            f().v(new b7(this, eVar2, i2, andIncrement, z2));
        }
    }

    @WorkerThread
    public final void D(@Nullable Boolean bool, boolean z) {
        b();
        u();
        i().m.b("Setting app measurement enabled (FE)", bool);
        k().s(bool);
        if (u9.b() && this.f2563a.g.o(q.P0) && z) {
            k4 k2 = k();
            if (k2 == null) {
                throw null;
            } else if (u9.b() && k2.f2563a.g.o(q.P0)) {
                k2.b();
                SharedPreferences.Editor edit = k2.v().edit();
                if (bool != null) {
                    edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
                } else {
                    edit.remove("measurement_enabled_from_api");
                }
                edit.apply();
            }
        }
        if (!u9.b() || !this.f2563a.g.o(q.P0) || this.f2563a.h() || !bool.booleanValue()) {
            P();
        }
    }

    @WorkerThread
    public final void E(String str, String str2, long j2, Bundle bundle) {
        b();
        F(str, str2, j2, bundle, true, this.f2194d == null || v9.s0(str2), false, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x043a  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x048d  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0551  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x061d  */
    /* JADX WARNING: Removed duplicated region for block: B:266:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x015e  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F(java.lang.String r30, java.lang.String r31, long r32, android.os.Bundle r34, boolean r35, boolean r36, boolean r37, java.lang.String r38) {
        /*
            r29 = this;
            r7 = r29
            r8 = r30
            r15 = r31
            r13 = r32
            r12 = r34
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            a.c.a.f.b.h(r30)
            a.c.a.f.b.k(r34)
            r29.b()
            r29.u()
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            boolean r1 = r1.d()
            if (r1 != 0) goto L_0x002c
            a.d.a.a.i.b.x3 r0 = r29.i()
            a.d.a.a.i.b.z3 r0 = r0.m
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.a(r1)
            return
        L_0x002c:
            a.d.a.a.i.b.q3 r1 = r29.p()
            java.util.List<java.lang.String> r1 = r1.i
            if (r1 == 0) goto L_0x0046
            boolean r1 = r1.contains(r15)
            if (r1 != 0) goto L_0x0046
            a.d.a.a.i.b.x3 r0 = r29.i()
            a.d.a.a.i.b.z3 r0 = r0.m
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.c(r1, r15, r8)
            return
        L_0x0046:
            boolean r1 = r7.f
            r11 = 0
            r10 = 1
            r9 = 0
            if (r1 != 0) goto L_0x0096
            r7.f = r10
            a.d.a.a.i.b.c5 r1 = r7.f2563a     // Catch:{ ClassNotFoundException -> 0x008b }
            boolean r1 = r1.f2127e     // Catch:{ ClassNotFoundException -> 0x008b }
            if (r1 != 0) goto L_0x0062
            a.d.a.a.i.b.c5 r1 = r7.f2563a     // Catch:{ ClassNotFoundException -> 0x008b }
            android.content.Context r1 = r1.f2123a     // Catch:{ ClassNotFoundException -> 0x008b }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x008b }
            java.lang.Class r0 = java.lang.Class.forName(r0, r10, r1)     // Catch:{ ClassNotFoundException -> 0x008b }
            goto L_0x0066
        L_0x0062:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x008b }
        L_0x0066:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x007e }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r9] = r3     // Catch:{ Exception -> 0x007e }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x007e }
            java.lang.Object[] r1 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x007e }
            a.d.a.a.i.b.c5 r2 = r7.f2563a     // Catch:{ Exception -> 0x007e }
            android.content.Context r2 = r2.f2123a     // Catch:{ Exception -> 0x007e }
            r1[r9] = r2     // Catch:{ Exception -> 0x007e }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x007e }
            goto L_0x0096
        L_0x007e:
            r0 = move-exception
            a.d.a.a.i.b.x3 r1 = r29.i()     // Catch:{ ClassNotFoundException -> 0x008b }
            a.d.a.a.i.b.z3 r1 = r1.i     // Catch:{ ClassNotFoundException -> 0x008b }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.b(r2, r0)     // Catch:{ ClassNotFoundException -> 0x008b }
            goto L_0x0096
        L_0x008b:
            a.d.a.a.i.b.x3 r0 = r29.i()
            a.d.a.a.i.b.z3 r0 = r0.l
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.a(r1)
        L_0x0096:
            a.d.a.a.i.b.c5 r0 = r7.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r1 = a.d.a.a.i.b.q.f0
            boolean r0 = r0.o(r1)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00cd
            java.lang.String r4 = r12.getString(r0)
            a.d.a.a.i.b.c5 r0 = r7.f2563a
            a.d.a.a.e.q.b r0 = r0.n
            a.d.a.a.e.q.c r0 = (a.d.a.a.e.q.c) r0
            if (r0 == 0) goto L_0x00cc
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r29
            r1.K(r2, r3, r4, r5)
            goto L_0x00cd
        L_0x00cc:
            throw r11
        L_0x00cd:
            boolean r0 = a.d.a.a.h.g.kb.b()
            if (r0 == 0) goto L_0x0108
            a.d.a.a.i.b.c5 r0 = r7.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r1 = a.d.a.a.i.b.q.H0
            boolean r0 = r0.o(r1)
            if (r0 == 0) goto L_0x0108
            if (r35 == 0) goto L_0x0108
            java.lang.String[] r0 = a.d.a.a.i.b.v9.h
            int r1 = r0.length
            r2 = 0
        L_0x00e5:
            if (r2 >= r1) goto L_0x00f4
            r3 = r0[r2]
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x00f1
            r0 = 0
            goto L_0x00f5
        L_0x00f1:
            int r2 = r2 + 1
            goto L_0x00e5
        L_0x00f4:
            r0 = 1
        L_0x00f5:
            if (r0 == 0) goto L_0x0108
            a.d.a.a.i.b.v9 r0 = r29.e()
            a.d.a.a.i.b.k4 r1 = r29.k()
            a.d.a.a.i.b.l4 r1 = r1.C
            android.os.Bundle r1 = r1.a()
            r0.H(r12, r1)
        L_0x0108:
            java.lang.String r0 = "_ev"
            r1 = 40
            r2 = 2
            if (r37 == 0) goto L_0x018a
            java.lang.String r3 = "_iap"
            boolean r3 = r3.equals(r15)
            if (r3 != 0) goto L_0x018a
            a.d.a.a.i.b.c5 r3 = r7.f2563a
            a.d.a.a.i.b.v9 r3 = r3.t()
            boolean r4 = a.d.a.a.h.g.c9.b()
            if (r4 == 0) goto L_0x0131
            a.d.a.a.i.b.c5 r4 = r7.f2563a
            a.d.a.a.i.b.ka r4 = r4.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.S0
            boolean r4 = r4.o(r5)
            if (r4 == 0) goto L_0x0131
            r4 = 1
            goto L_0x0132
        L_0x0131:
            r4 = 0
        L_0x0132:
            java.lang.String r5 = "event"
            boolean r6 = r3.Y(r5, r15)
            if (r6 != 0) goto L_0x013b
            goto L_0x0159
        L_0x013b:
            if (r4 == 0) goto L_0x0148
            java.lang.String[] r4 = a.d.a.a.i.b.z5.f2662a
            java.lang.String[] r6 = a.d.a.a.i.b.z5.f2663b
            boolean r4 = r3.d0(r5, r4, r6, r15)
            if (r4 != 0) goto L_0x0153
            goto L_0x0150
        L_0x0148:
            java.lang.String[] r4 = a.d.a.a.i.b.z5.f2662a
            boolean r4 = r3.d0(r5, r4, r11, r15)
            if (r4 != 0) goto L_0x0153
        L_0x0150:
            r3 = 13
            goto L_0x015c
        L_0x0153:
            boolean r3 = r3.X(r5, r1, r15)
            if (r3 != 0) goto L_0x015b
        L_0x0159:
            r3 = 2
            goto L_0x015c
        L_0x015b:
            r3 = 0
        L_0x015c:
            if (r3 == 0) goto L_0x018a
            a.d.a.a.i.b.x3 r2 = r29.i()
            a.d.a.a.i.b.z3 r2 = r2.h
            a.d.a.a.i.b.v3 r4 = r29.d()
            java.lang.String r4 = r4.u(r15)
            java.lang.String r5 = "Invalid public event name. Event will not be logged (FE)"
            r2.b(r5, r4)
            a.d.a.a.i.b.c5 r2 = r7.f2563a
            r2.t()
            java.lang.String r1 = a.d.a.a.i.b.v9.E(r15, r1, r10)
            if (r15 == 0) goto L_0x0180
            int r9 = r31.length()
        L_0x0180:
            a.d.a.a.i.b.c5 r2 = r7.f2563a
            a.d.a.a.i.b.v9 r2 = r2.t()
            r2.f0(r3, r0, r1, r9)
            return
        L_0x018a:
            a.d.a.a.i.b.l7 r3 = r29.r()
            a.d.a.a.i.b.m7 r3 = r3.y(r9)
            java.lang.String r4 = "_sc"
            if (r3 == 0) goto L_0x019e
            boolean r5 = r12.containsKey(r4)
            if (r5 != 0) goto L_0x019e
            r3.f2379d = r10
        L_0x019e:
            if (r35 == 0) goto L_0x01a4
            if (r37 == 0) goto L_0x01a4
            r5 = 1
            goto L_0x01a5
        L_0x01a4:
            r5 = 0
        L_0x01a5:
            a.d.a.a.i.b.l7.C(r3, r12, r5)
            java.lang.String r5 = "am"
            boolean r16 = r5.equals(r8)
            boolean r5 = a.d.a.a.i.b.v9.s0(r31)
            if (r35 == 0) goto L_0x01fe
            a.d.a.a.i.b.e6 r6 = r7.f2194d
            if (r6 == 0) goto L_0x01fe
            if (r5 != 0) goto L_0x01fe
            if (r16 != 0) goto L_0x01fe
            a.d.a.a.i.b.x3 r0 = r29.i()
            a.d.a.a.i.b.z3 r0 = r0.m
            a.d.a.a.i.b.v3 r1 = r29.d()
            java.lang.String r1 = r1.u(r15)
            a.d.a.a.i.b.v3 r2 = r29.d()
            java.lang.String r2 = r2.s(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.c(r3, r1, r2)
            a.d.a.a.i.b.e6 r0 = r7.f2194d
            r9 = r0
            com.google.android.gms.measurement.internal.AppMeasurementDynamiteService$b r9 = (com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.b) r9
            if (r9 == 0) goto L_0x01fd
            a.d.a.a.h.g.b r1 = r9.f4273a     // Catch:{ RemoteException -> 0x01ec }
            r2 = r30
            r3 = r31
            r4 = r34
            r5 = r32
            r1.q(r2, r3, r4, r5)     // Catch:{ RemoteException -> 0x01ec }
            goto L_0x01fc
        L_0x01ec:
            r0 = move-exception
            com.google.android.gms.measurement.internal.AppMeasurementDynamiteService r1 = com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.this
            a.d.a.a.i.b.c5 r1 = r1.f4269a
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.i
            java.lang.String r2 = "Event interceptor threw exception"
            r1.b(r2, r0)
        L_0x01fc:
            return
        L_0x01fd:
            throw r11
        L_0x01fe:
            a.d.a.a.i.b.c5 r5 = r7.f2563a
            boolean r5 = r5.l()
            if (r5 != 0) goto L_0x0207
            return
        L_0x0207:
            a.d.a.a.i.b.v9 r5 = r29.e()
            boolean r6 = a.d.a.a.h.g.c9.b()
            if (r6 == 0) goto L_0x021f
            a.d.a.a.i.b.c5 r6 = r7.f2563a
            a.d.a.a.i.b.ka r6 = r6.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.S0
            boolean r6 = r6.o(r11)
            if (r6 == 0) goto L_0x021f
            r6 = 1
            goto L_0x0220
        L_0x021f:
            r6 = 0
        L_0x0220:
            int r5 = r5.t(r15, r6)
            if (r5 == 0) goto L_0x0250
            a.d.a.a.i.b.x3 r2 = r29.i()
            a.d.a.a.i.b.z3 r2 = r2.h
            a.d.a.a.i.b.v3 r3 = r29.d()
            java.lang.String r3 = r3.u(r15)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.b(r4, r3)
            r29.e()
            java.lang.String r1 = a.d.a.a.i.b.v9.E(r15, r1, r10)
            if (r15 == 0) goto L_0x0246
            int r9 = r31.length()
        L_0x0246:
            a.d.a.a.i.b.c5 r2 = r7.f2563a
            a.d.a.a.i.b.v9 r2 = r2.t()
            r2.f0(r5, r0, r1, r9)
            return
        L_0x0250:
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r5 = "_o"
            r0[r9] = r5
            java.lang.String r1 = "_sn"
            r0[r10] = r1
            r0[r2] = r4
            r2 = 3
            java.lang.String r6 = "_si"
            r0[r2] = r6
            java.util.List r0 = java.util.Arrays.asList(r0)
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            a.d.a.a.i.b.v9 r2 = r29.e()
            r18 = 1
            r11 = 0
            r9 = r2
            r2 = 1
            r10 = r38
            r17 = 0
            r11 = r31
            r12 = r34
            r20 = r3
            r2 = r13
            r13 = r0
            r14 = r37
            r21 = r5
            r5 = r15
            r15 = r18
            android.os.Bundle r15 = r9.z(r10, r11, r12, r13, r14, r15)
            if (r15 == 0) goto L_0x02b3
            boolean r9 = r15.containsKey(r4)
            if (r9 == 0) goto L_0x02b3
            boolean r9 = r15.containsKey(r6)
            if (r9 != 0) goto L_0x0299
            goto L_0x02b3
        L_0x0299:
            java.lang.String r1 = r15.getString(r1)
            java.lang.String r4 = r15.getString(r4)
            long r9 = r15.getLong(r6)
            java.lang.Long r6 = java.lang.Long.valueOf(r9)
            a.d.a.a.i.b.m7 r11 = new a.d.a.a.i.b.m7
            long r9 = r6.longValue()
            r11.<init>(r1, r4, r9)
            goto L_0x02b5
        L_0x02b3:
            r11 = r17
        L_0x02b5:
            if (r11 != 0) goto L_0x02ba
            r14 = r20
            goto L_0x02bb
        L_0x02ba:
            r14 = r11
        L_0x02bb:
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.i.b.ka r1 = r1.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.U
            boolean r1 = r1.o(r4)
            java.lang.String r13 = "_ae"
            r9 = 0
            if (r1 == 0) goto L_0x02f4
            a.d.a.a.i.b.l7 r1 = r29.r()
            r12 = 0
            a.d.a.a.i.b.m7 r1 = r1.y(r12)
            if (r1 == 0) goto L_0x02f4
            boolean r1 = r13.equals(r5)
            if (r1 == 0) goto L_0x02f4
            a.d.a.a.i.b.b9 r1 = r29.t()
            a.d.a.a.i.b.h9 r1 = r1.f2111e
            r34 = r13
            long r12 = r1.b()
            int r1 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x02f6
            a.d.a.a.i.b.v9 r1 = r29.e()
            r1.G(r15, r12)
            goto L_0x02f6
        L_0x02f4:
            r34 = r13
        L_0x02f6:
            boolean r1 = a.d.a.a.h.g.ga.b()
            if (r1 == 0) goto L_0x0379
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.i.b.ka r1 = r1.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.r0
            boolean r1 = r1.o(r4)
            if (r1 == 0) goto L_0x0379
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r4 = "_ffr"
            if (r1 != 0) goto L_0x0359
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0359
            a.d.a.a.i.b.v9 r1 = r29.e()
            java.lang.String r4 = r15.getString(r4)
            boolean r6 = a.d.a.a.e.q.g.a(r4)
            if (r6 == 0) goto L_0x032b
            r11 = r17
            goto L_0x032f
        L_0x032b:
            java.lang.String r11 = r4.trim()
        L_0x032f:
            a.d.a.a.i.b.k4 r4 = r1.k()
            a.d.a.a.i.b.q4 r4 = r4.z
            java.lang.String r4 = r4.a()
            boolean r4 = a.d.a.a.i.b.v9.r0(r11, r4)
            if (r4 == 0) goto L_0x034c
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.m
            java.lang.String r4 = "Not logging duplicate session_start_with_rollout event"
            r1.a(r4)
            r1 = 0
            goto L_0x0356
        L_0x034c:
            a.d.a.a.i.b.k4 r1 = r1.k()
            a.d.a.a.i.b.q4 r1 = r1.z
            r1.b(r11)
            r1 = 1
        L_0x0356:
            if (r1 != 0) goto L_0x0379
            return
        L_0x0359:
            r13 = r34
            boolean r1 = r13.equals(r5)
            if (r1 == 0) goto L_0x037b
            a.d.a.a.i.b.v9 r1 = r29.e()
            a.d.a.a.i.b.k4 r1 = r1.k()
            a.d.a.a.i.b.q4 r1 = r1.z
            java.lang.String r1 = r1.a()
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x037b
            r15.putString(r4, r1)
            goto L_0x037b
        L_0x0379:
            r13 = r34
        L_0x037b:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r12.add(r15)
            a.d.a.a.i.b.v9 r1 = r29.e()
            java.security.SecureRandom r1 = r1.w0()
            long r4 = r1.nextLong()
            a.d.a.a.i.b.k4 r1 = r29.k()
            a.d.a.a.i.b.o4 r1 = r1.u
            long r22 = r1.a()
            int r1 = (r22 > r9 ? 1 : (r22 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x0410
            a.d.a.a.i.b.k4 r1 = r29.k()
            boolean r1 = r1.t(r2)
            if (r1 == 0) goto L_0x0410
            a.d.a.a.i.b.k4 r1 = r29.k()
            a.d.a.a.i.b.m4 r1 = r1.w
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x0410
            a.d.a.a.i.b.x3 r1 = r29.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            java.lang.String r6 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.a(r6)
            r6 = 0
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.e.q.b r1 = r1.n
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x040f
            long r22 = java.lang.System.currentTimeMillis()
            java.lang.String r11 = "auto"
            java.lang.String r18 = "_sid"
            r1 = r29
            r3 = 1
            r2 = r11
            r11 = 1
            r3 = r18
            r24 = r4
            r4 = r6
            r26 = r21
            r5 = r22
            r1.K(r2, r3, r4, r5)
            r4 = 0
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.e.q.b r1 = r1.n
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x040e
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r29
            r1.K(r2, r3, r4, r5)
            r4 = 0
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.e.q.b r1 = r1.n
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x040d
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r29
            r1.K(r2, r3, r4, r5)
            goto L_0x0415
        L_0x040d:
            throw r17
        L_0x040e:
            throw r17
        L_0x040f:
            throw r17
        L_0x0410:
            r24 = r4
            r26 = r21
            r11 = 1
        L_0x0415:
            java.lang.String r1 = "extend_session"
            long r1 = r15.getLong(r1, r9)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x043a
            a.d.a.a.i.b.x3 r1 = r29.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.a(r2)
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.i.b.b9 r1 = r1.r()
            a.d.a.a.i.b.j9 r1 = r1.f2110d
            r5 = r32
            r1.b(r5, r11)
            goto L_0x043c
        L_0x043a:
            r5 = r32
        L_0x043c:
            java.util.Set r1 = r15.keySet()
            int r2 = r15.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            boolean r2 = a.d.a.a.h.g.aa.b()
            if (r2 == 0) goto L_0x048d
            a.d.a.a.i.b.c5 r2 = r7.f2563a
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.B0
            boolean r2 = r2.o(r3)
            if (r2 == 0) goto L_0x048d
            a.d.a.a.i.b.c5 r2 = r7.f2563a
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.A0
            boolean r2 = r2.o(r3)
            if (r2 == 0) goto L_0x048d
            int r0 = r1.length
            r9 = 0
        L_0x046f:
            if (r9 >= r0) goto L_0x0486
            r2 = r1[r9]
            r29.e()
            java.lang.Object r3 = r15.get(r2)
            android.os.Bundle[] r3 = a.d.a.a.i.b.v9.n0(r3)
            if (r3 == 0) goto L_0x0483
            r15.putParcelableArray(r2, r3)
        L_0x0483:
            int r9 = r9 + 1
            goto L_0x046f
        L_0x0486:
            r11 = r31
            r15 = r11
            r10 = r12
            r5 = r13
            goto L_0x054a
        L_0x048d:
            int r2 = r1.length
            r9 = r31
            r3 = 0
            r4 = 0
        L_0x0492:
            java.lang.String r10 = "_eid"
            if (r3 >= r2) goto L_0x0537
            r11 = r1[r3]
            java.lang.Object r18 = r15.get(r11)
            r29.e()
            r34 = r1
            android.os.Bundle[] r1 = a.d.a.a.i.b.v9.n0(r18)
            if (r1 == 0) goto L_0x0516
            r18 = r2
            int r2 = r1.length
            r15.putInt(r11, r2)
            r2 = 0
        L_0x04ae:
            int r5 = r1.length
            if (r2 >= r5) goto L_0x0508
            r5 = r1[r2]
            r6 = 1
            a.d.a.a.i.b.l7.C(r14, r5, r6)
            a.d.a.a.i.b.v9 r9 = r29.e()
            r20 = 0
            java.lang.String r21 = "_ep"
            r6 = r10
            r10 = r38
            r27 = r11
            r11 = r21
            r28 = r12
            r12 = r5
            r5 = r13
            r13 = r0
            r19 = r14
            r14 = r37
            r35 = r0
            r0 = r15
            r15 = r20
            android.os.Bundle r9 = r9.z(r10, r11, r12, r13, r14, r15)
            java.lang.String r10 = "_en"
            r11 = r31
            r9.putString(r10, r11)
            r12 = r24
            r9.putLong(r6, r12)
            java.lang.String r10 = "_gn"
            r14 = r27
            r9.putString(r10, r14)
            int r10 = r1.length
            java.lang.String r15 = "_ll"
            r9.putInt(r15, r10)
            java.lang.String r10 = "_i"
            r9.putInt(r10, r2)
            r10 = r28
            r10.add(r9)
            int r2 = r2 + 1
            r15 = r0
            r9 = r11
            r11 = r14
            r14 = r19
            r0 = r35
            r13 = r5
            r12 = r10
            r10 = r6
            goto L_0x04ae
        L_0x0508:
            r11 = r31
            r35 = r0
            r10 = r12
            r5 = r13
            r19 = r14
            r0 = r15
            r12 = r24
            int r1 = r1.length
            int r4 = r4 + r1
            goto L_0x0523
        L_0x0516:
            r11 = r31
            r35 = r0
            r18 = r2
            r10 = r12
            r5 = r13
            r19 = r14
            r0 = r15
            r12 = r24
        L_0x0523:
            int r3 = r3 + 1
            r1 = r34
            r15 = r0
            r24 = r12
            r2 = r18
            r14 = r19
            r11 = 1
            r0 = r35
            r13 = r5
            r12 = r10
            r5 = r32
            goto L_0x0492
        L_0x0537:
            r11 = r31
            r6 = r10
            r10 = r12
            r5 = r13
            r0 = r15
            r12 = r24
            if (r4 == 0) goto L_0x0549
            r0.putLong(r6, r12)
            java.lang.String r1 = "_epc"
            r0.putInt(r1, r4)
        L_0x0549:
            r15 = r9
        L_0x054a:
            r9 = 0
        L_0x054b:
            int r0 = r10.size()
            if (r9 >= r0) goto L_0x060b
            java.lang.Object r0 = r10.get(r9)
            android.os.Bundle r0 = (android.os.Bundle) r0
            if (r9 == 0) goto L_0x055b
            r1 = 1
            goto L_0x055c
        L_0x055b:
            r1 = 0
        L_0x055c:
            if (r1 == 0) goto L_0x0562
            java.lang.String r1 = "_ep"
            r2 = r1
            goto L_0x0563
        L_0x0562:
            r2 = r15
        L_0x0563:
            r12 = r26
            r0.putString(r12, r8)
            if (r36 == 0) goto L_0x0572
            a.d.a.a.i.b.v9 r1 = r29.e()
            android.os.Bundle r0 = r1.y(r0)
        L_0x0572:
            com.google.android.gms.measurement.internal.zzar r13 = new com.google.android.gms.measurement.internal.zzar
            com.google.android.gms.measurement.internal.zzam r3 = new com.google.android.gms.measurement.internal.zzam
            r3.<init>(r0)
            r1 = r13
            r4 = r30
            r14 = r5
            r5 = r32
            r1.<init>(r2, r3, r4, r5)
            a.d.a.a.i.b.u7 r1 = r29.q()
            if (r1 == 0) goto L_0x060a
            a.c.a.f.b.k(r13)
            r1.b()
            r1.u()
            a.d.a.a.i.b.t3 r2 = r1.s()
            if (r2 == 0) goto L_0x0609
            android.os.Parcel r3 = android.os.Parcel.obtain()
            r5 = 0
            r13.writeToParcel(r3, r5)
            byte[] r4 = r3.marshall()
            r3.recycle()
            int r3 = r4.length
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r3 <= r6) goto L_0x05ba
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.g
            java.lang.String r3 = "Event is too long for local database. Sending event directly to service"
            r2.a(r3)
            r6 = 1
            r21 = 0
            goto L_0x05c1
        L_0x05ba:
            boolean r2 = r2.z(r5, r4)
            r21 = r2
            r6 = 1
        L_0x05c1:
            com.google.android.gms.measurement.internal.zzn r23 = r1.K(r6)
            a.d.a.a.i.b.h8 r2 = new a.d.a.a.i.b.h8
            r20 = 1
            r18 = r2
            r19 = r1
            r22 = r13
            r24 = r38
            r18.<init>(r19, r20, r21, r22, r23, r24)
            r1.B(r2)
            if (r16 != 0) goto L_0x05ff
            java.util.Set<a.d.a.a.i.b.d6> r1 = r7.f2195e
            java.util.Iterator r13 = r1.iterator()
        L_0x05df:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x05ff
            java.lang.Object r1 = r13.next()
            a.d.a.a.i.b.d6 r1 = (a.d.a.a.i.b.d6) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r0)
            r2 = r30
            r3 = r31
            r8 = 0
            r5 = r32
            r1.a(r2, r3, r4, r5)
            r8 = r30
            r5 = 0
            r6 = 1
            goto L_0x05df
        L_0x05ff:
            r8 = 0
            int r9 = r9 + 1
            r8 = r30
            r26 = r12
            r5 = r14
            goto L_0x054b
        L_0x0609:
            throw r17
        L_0x060a:
            throw r17
        L_0x060b:
            r14 = r5
            r8 = 0
            a.d.a.a.i.b.l7 r0 = r29.r()
            a.d.a.a.i.b.m7 r0 = r0.y(r8)
            if (r0 == 0) goto L_0x0633
            boolean r0 = r14.equals(r15)
            if (r0 == 0) goto L_0x0633
            a.d.a.a.i.b.b9 r0 = r29.t()
            a.d.a.a.i.b.c5 r1 = r7.f2563a
            a.d.a.a.e.q.b r1 = r1.n
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x0632
            long r1 = android.os.SystemClock.elapsedRealtime()
            r3 = 1
            r0.y(r3, r3, r1)
            goto L_0x0633
        L_0x0632:
            throw r17
        L_0x0633:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.f6.F(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void G(String str, String str2, long j2, Object obj) {
        f().v(new n6(this, str, str2, obj, j2));
    }

    public final void H(String str, String str2, Bundle bundle) {
        if (((c) this.f2563a.n) != null) {
            I(str, str2, bundle, true, true, System.currentTimeMillis());
            return;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f6, code lost:
        r2 = r1.i().n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fe, code lost:
        if (r14 != null) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0100, code lost:
        r5 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0103, code lost:
        r5 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0104, code lost:
        if (r15 != null) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0106, code lost:
        r6 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0109, code lost:
        r6 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010a, code lost:
        r2.c("Logging screen view with name, class", r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010f, code lost:
        if (r1.f2352c != null) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0111, code lost:
        r2 = r1.f2353d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0114, code lost:
        r2 = r1.f2352c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0116, code lost:
        r13 = new a.d.a.a.i.b.m7(r14, r15, r1.e().u0(), true, r27);
        r1.f2352c = r13;
        r1.f2353d = r2;
        r1.i = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0134, code lost:
        if (((a.d.a.a.e.q.c) r1.f2563a.n) == null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0136, code lost:
        r1.f().v(new a.d.a.a.i.b.o7(r1, r0, r13, r2, android.os.SystemClock.elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0153, code lost:
        throw null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(java.lang.String r22, java.lang.String r23, android.os.Bundle r24, boolean r25, boolean r26, long r27) {
        /*
            r21 = this;
            r12 = r21
            if (r22 != 0) goto L_0x0008
            java.lang.String r0 = "app"
            r3 = r0
            goto L_0x000a
        L_0x0008:
            r3 = r22
        L_0x000a:
            if (r24 != 0) goto L_0x0012
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            goto L_0x0014
        L_0x0012:
            r0 = r24
        L_0x0014:
            a.d.a.a.i.b.c5 r1 = r12.f2563a
            a.d.a.a.i.b.ka r1 = r1.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.x0
            boolean r1 = r1.o(r2)
            r2 = 0
            if (r1 == 0) goto L_0x0157
            java.lang.String r1 = "screen_view"
            r4 = r23
            boolean r1 = a.d.a.a.i.b.v9.r0(r4, r1)
            if (r1 == 0) goto L_0x0159
            a.d.a.a.i.b.l7 r1 = r21.r()
            a.d.a.a.i.b.c5 r3 = r1.f2563a
            a.d.a.a.i.b.ka r3 = r3.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.x0
            boolean r3 = r3.o(r4)
            if (r3 != 0) goto L_0x0048
            a.d.a.a.i.b.x3 r0 = r1.i()
            a.d.a.a.i.b.z3 r0 = r0.k
            java.lang.String r1 = "Manual screen reporting is disabled."
            r0.a(r1)
            goto L_0x0152
        L_0x0048:
            java.lang.Object r5 = r1.l
            monitor-enter(r5)
            boolean r3 = r1.k     // Catch:{ all -> 0x0154 }
            if (r3 != 0) goto L_0x005d
            a.d.a.a.i.b.x3 r0 = r1.i()     // Catch:{ all -> 0x0154 }
            a.d.a.a.i.b.z3 r0 = r0.k     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = "Cannot log screen view event when the app is in the background."
            r0.a(r1)     // Catch:{ all -> 0x0154 }
        L_0x005a:
            monitor-exit(r5)     // Catch:{ all -> 0x0154 }
            goto L_0x0152
        L_0x005d:
            r3 = 0
            java.lang.String r4 = "screen_name"
            java.lang.String r14 = r0.getString(r4)     // Catch:{ all -> 0x0154 }
            r4 = 100
            if (r14 == 0) goto L_0x0088
            int r6 = r14.length()     // Catch:{ all -> 0x0154 }
            if (r6 <= 0) goto L_0x0074
            int r6 = r14.length()     // Catch:{ all -> 0x0154 }
            if (r6 <= r4) goto L_0x0088
        L_0x0074:
            a.d.a.a.i.b.x3 r0 = r1.i()     // Catch:{ all -> 0x0154 }
            a.d.a.a.i.b.z3 r0 = r0.k     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = "Invalid screen name length for screen view. Length"
            int r2 = r14.length()     // Catch:{ all -> 0x0154 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0154 }
            r0.b(r1, r2)     // Catch:{ all -> 0x0154 }
            goto L_0x005a
        L_0x0088:
            java.lang.String r6 = "screen_class"
            java.lang.String r6 = r0.getString(r6)     // Catch:{ all -> 0x0154 }
            if (r6 == 0) goto L_0x00b0
            int r7 = r6.length()     // Catch:{ all -> 0x0154 }
            if (r7 <= 0) goto L_0x009c
            int r7 = r6.length()     // Catch:{ all -> 0x0154 }
            if (r7 <= r4) goto L_0x00b0
        L_0x009c:
            a.d.a.a.i.b.x3 r0 = r1.i()     // Catch:{ all -> 0x0154 }
            a.d.a.a.i.b.z3 r0 = r0.k     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = "Invalid screen class length for screen view. Length"
            int r2 = r6.length()     // Catch:{ all -> 0x0154 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0154 }
            r0.b(r1, r2)     // Catch:{ all -> 0x0154 }
            goto L_0x005a
        L_0x00b0:
            if (r6 != 0) goto L_0x00c9
            android.app.Activity r4 = r1.g     // Catch:{ all -> 0x0154 }
            if (r4 == 0) goto L_0x00c5
            android.app.Activity r4 = r1.g     // Catch:{ all -> 0x0154 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x0154 }
            java.lang.String r4 = r4.getCanonicalName()     // Catch:{ all -> 0x0154 }
            java.lang.String r4 = a.d.a.a.i.b.l7.z(r4)     // Catch:{ all -> 0x0154 }
            goto L_0x00c7
        L_0x00c5:
            java.lang.String r4 = "Activity"
        L_0x00c7:
            r15 = r4
            goto L_0x00ca
        L_0x00c9:
            r15 = r6
        L_0x00ca:
            boolean r4 = r1.h     // Catch:{ all -> 0x0154 }
            if (r4 == 0) goto L_0x00f5
            a.d.a.a.i.b.m7 r4 = r1.f2352c     // Catch:{ all -> 0x0154 }
            if (r4 == 0) goto L_0x00f5
            r1.h = r2     // Catch:{ all -> 0x0154 }
            a.d.a.a.i.b.m7 r2 = r1.f2352c     // Catch:{ all -> 0x0154 }
            java.lang.String r2 = r2.f2377b     // Catch:{ all -> 0x0154 }
            boolean r2 = a.d.a.a.i.b.v9.r0(r2, r15)     // Catch:{ all -> 0x0154 }
            a.d.a.a.i.b.m7 r4 = r1.f2352c     // Catch:{ all -> 0x0154 }
            java.lang.String r4 = r4.f2376a     // Catch:{ all -> 0x0154 }
            boolean r4 = a.d.a.a.i.b.v9.r0(r4, r14)     // Catch:{ all -> 0x0154 }
            if (r2 == 0) goto L_0x00f5
            if (r4 == 0) goto L_0x00f5
            a.d.a.a.i.b.x3 r0 = r1.i()     // Catch:{ all -> 0x0154 }
            a.d.a.a.i.b.z3 r0 = r0.k     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = "Ignoring call to log screen view event with duplicate parameters."
            r0.a(r1)     // Catch:{ all -> 0x0154 }
            goto L_0x005a
        L_0x00f5:
            monitor-exit(r5)     // Catch:{ all -> 0x0154 }
            a.d.a.a.i.b.x3 r2 = r1.i()
            a.d.a.a.i.b.z3 r2 = r2.n
            java.lang.String r4 = "Logging screen view with name, class"
            if (r14 != 0) goto L_0x0103
            java.lang.String r5 = "null"
            goto L_0x0104
        L_0x0103:
            r5 = r14
        L_0x0104:
            if (r15 != 0) goto L_0x0109
            java.lang.String r6 = "null"
            goto L_0x010a
        L_0x0109:
            r6 = r15
        L_0x010a:
            r2.c(r4, r5, r6)
            a.d.a.a.i.b.m7 r2 = r1.f2352c
            if (r2 != 0) goto L_0x0114
            a.d.a.a.i.b.m7 r2 = r1.f2353d
            goto L_0x0116
        L_0x0114:
            a.d.a.a.i.b.m7 r2 = r1.f2352c
        L_0x0116:
            a.d.a.a.i.b.m7 r4 = new a.d.a.a.i.b.m7
            a.d.a.a.i.b.v9 r5 = r1.e()
            long r16 = r5.u0()
            r18 = 1
            r13 = r4
            r19 = r27
            r13.<init>(r14, r15, r16, r18, r19)
            r1.f2352c = r4
            r1.f2353d = r2
            r1.i = r4
            a.d.a.a.i.b.c5 r5 = r1.f2563a
            a.d.a.a.e.q.b r5 = r5.n
            a.d.a.a.e.q.c r5 = (a.d.a.a.e.q.c) r5
            if (r5 == 0) goto L_0x0153
            long r5 = android.os.SystemClock.elapsedRealtime()
            a.d.a.a.i.b.v4 r3 = r1.f()
            a.d.a.a.i.b.o7 r7 = new a.d.a.a.i.b.o7
            r22 = r7
            r23 = r1
            r24 = r0
            r25 = r4
            r26 = r2
            r27 = r5
            r22.<init>(r23, r24, r25, r26, r27)
            r3.v(r7)
        L_0x0152:
            return
        L_0x0153:
            throw r3
        L_0x0154:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0154 }
            throw r0
        L_0x0157:
            r4 = r23
        L_0x0159:
            r1 = 1
            if (r26 == 0) goto L_0x0169
            a.d.a.a.i.b.e6 r5 = r12.f2194d
            if (r5 == 0) goto L_0x0169
            boolean r5 = a.d.a.a.i.b.v9.s0(r23)
            if (r5 == 0) goto L_0x0167
            goto L_0x0169
        L_0x0167:
            r9 = 0
            goto L_0x016a
        L_0x0169:
            r9 = 1
        L_0x016a:
            r10 = r25 ^ 1
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>(r0)
            java.util.Set r0 = r7.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0179:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01d8
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r7.get(r1)
            boolean r6 = r5 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x0198
            android.os.Bundle r6 = new android.os.Bundle
            android.os.Bundle r5 = (android.os.Bundle) r5
            r6.<init>(r5)
            r7.putBundle(r1, r6)
            goto L_0x0179
        L_0x0198:
            boolean r1 = r5 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x01b6
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            r1 = 0
        L_0x019f:
            int r6 = r5.length
            if (r1 >= r6) goto L_0x0179
            r6 = r5[r1]
            boolean r6 = r6 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x01b3
            android.os.Bundle r6 = new android.os.Bundle
            r8 = r5[r1]
            android.os.Bundle r8 = (android.os.Bundle) r8
            r6.<init>(r8)
            r5[r1] = r6
        L_0x01b3:
            int r1 = r1 + 1
            goto L_0x019f
        L_0x01b6:
            boolean r1 = r5 instanceof java.util.List
            if (r1 == 0) goto L_0x0179
            java.util.List r5 = (java.util.List) r5
            r1 = 0
        L_0x01bd:
            int r6 = r5.size()
            if (r1 >= r6) goto L_0x0179
            java.lang.Object r6 = r5.get(r1)
            boolean r8 = r6 instanceof android.os.Bundle
            if (r8 == 0) goto L_0x01d5
            android.os.Bundle r8 = new android.os.Bundle
            android.os.Bundle r6 = (android.os.Bundle) r6
            r8.<init>(r6)
            r5.set(r1, r8)
        L_0x01d5:
            int r1 = r1 + 1
            goto L_0x01bd
        L_0x01d8:
            a.d.a.a.i.b.v4 r0 = r21.f()
            a.d.a.a.i.b.o6 r13 = new a.d.a.a.i.b.o6
            r11 = 0
            r1 = r13
            r2 = r21
            r4 = r23
            r5 = r27
            r8 = r26
            r1.<init>(r2, r3, r4, r5, r7, r8, r9, r10, r11)
            r0.v(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.f6.I(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void J(String str, String str2, Object obj) {
        if (((c) this.f2563a.n) != null) {
            L(str, str2, obj, true, System.currentTimeMillis());
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            a.c.a.f.b.h(r9)
            a.c.a.f.b.h(r10)
            r8.b()
            r8.u()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0060
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0050
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0050
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0035
            r4 = r2
            goto L_0x0037
        L_0x0035:
            r4 = 0
        L_0x0037:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            a.d.a.a.i.b.k4 r0 = r8.k()
            a.d.a.a.i.b.q4 r0 = r0.s
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004b
            java.lang.String r11 = "true"
        L_0x004b:
            r0.b(r11)
            r6 = r10
            goto L_0x005e
        L_0x0050:
            if (r11 != 0) goto L_0x0060
            a.d.a.a.i.b.k4 r10 = r8.k()
            a.d.a.a.i.b.q4 r10 = r10.s
            java.lang.String r0 = "unset"
            r10.b(r0)
            r6 = r11
        L_0x005e:
            r3 = r1
            goto L_0x0062
        L_0x0060:
            r3 = r10
            r6 = r11
        L_0x0062:
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            boolean r10 = r10.d()
            if (r10 != 0) goto L_0x0076
            a.d.a.a.i.b.x3 r9 = r8.i()
            a.d.a.a.i.b.z3 r9 = r9.n
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L_0x0076:
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            boolean r10 = r10.l()
            if (r10 != 0) goto L_0x007f
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzkw r10 = new com.google.android.gms.measurement.internal.zzkw
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            a.d.a.a.i.b.u7 r9 = r8.q()
            r9.b()
            r9.u()
            a.d.a.a.i.b.t3 r11 = r9.s()
            if (r11 == 0) goto L_0x00c9
            android.os.Parcel r12 = android.os.Parcel.obtain()
            r13 = 0
            r10.writeToParcel(r12, r13)
            byte[] r0 = r12.marshall()
            r12.recycle()
            int r12 = r0.length
            r1 = 131072(0x20000, float:1.83671E-40)
            r2 = 1
            if (r12 <= r1) goto L_0x00b8
            a.d.a.a.i.b.x3 r11 = r11.i()
            a.d.a.a.i.b.z3 r11 = r11.g
            java.lang.String r12 = "User property too long for local database. Sending directly to service"
            r11.a(r12)
            goto L_0x00bc
        L_0x00b8:
            boolean r13 = r11.z(r2, r0)
        L_0x00bc:
            com.google.android.gms.measurement.internal.zzn r11 = r9.K(r2)
            a.d.a.a.i.b.v7 r12 = new a.d.a.a.i.b.v7
            r12.<init>(r9, r13, r10, r11)
            r9.B(r12)
            return
        L_0x00c9:
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.f6.K(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void L(String str, String str2, Object obj, boolean z, long j2) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i2 = 6;
        int i3 = 0;
        if (z) {
            i2 = e().g0(str2);
        } else {
            v9 e2 = e();
            if (e2.Y("user property", str2)) {
                if (!e2.d0("user property", b6.f2100a, (String[]) null, str2)) {
                    i2 = 15;
                } else if (e2.X("user property", 24, str2)) {
                    i2 = 0;
                }
            }
        }
        if (i2 != 0) {
            e();
            String E = v9.E(str2, 24, true);
            if (str2 != null) {
                i3 = str2.length();
            }
            this.f2563a.t().f0(i2, "_ev", E, i3);
        } else if (obj != null) {
            int h0 = e().h0(str2, obj);
            if (h0 != 0) {
                e();
                String E2 = v9.E(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i3 = String.valueOf(obj).length();
                }
                this.f2563a.t().f0(h0, "_ev", E2, i3);
                return;
            }
            Object o0 = e().o0(str2, obj);
            if (o0 != null) {
                G(str3, str2, j2, o0);
            }
        } else {
            G(str3, str2, j2, (Object) null);
        }
    }

    public final void M() {
        if (this.f2563a.f2123a.getApplicationContext() instanceof Application) {
            ((Application) this.f2563a.f2123a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f2193c);
        }
    }

    @WorkerThread
    public final void N() {
        b();
        u();
        if (this.f2563a.l()) {
            if (this.f2563a.g.o(q.e0)) {
                Boolean v = this.f2563a.g.v("google_analytics_deferred_deep_link_enabled");
                if (v != null && v.booleanValue()) {
                    i().m.a("Deferred Deep Link feature enabled.");
                    f().v(new h6(this));
                }
            }
            u7 q = q();
            q.b();
            q.u();
            zzn K = q.K(true);
            q.s().z(3, new byte[0]);
            q.B(new c8(q, K));
            this.o = false;
            k4 k2 = k();
            k2.b();
            String string = k2.v().getString("previous_os_version", (String) null);
            k2.c().n();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = k2.v().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                c().n();
                if (!string.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    H("auto", "_ou", bundle);
                }
            }
        }
    }

    @Nullable
    public final String O() {
        c5 c5Var = this.f2563a;
        String str = c5Var.f2124b;
        if (str != null) {
            return str;
        }
        try {
            return b.Z0(c5Var.f2123a, "google_app_id");
        } catch (IllegalStateException e2) {
            this.f2563a.i().f.b("getGoogleAppId failed with exception", e2);
            return null;
        }
    }

    @WorkerThread
    public final void P() {
        b();
        String a2 = k().s.a();
        if (a2 != null) {
            if (!"unset".equals(a2)) {
                Long valueOf = Long.valueOf("true".equals(a2) ? 1 : 0);
                if (((c) this.f2563a.n) != null) {
                    K("app", "_npa", valueOf, System.currentTimeMillis());
                } else {
                    throw null;
                }
            } else if (((c) this.f2563a.n) != null) {
                K("app", "_npa", (Object) null, System.currentTimeMillis());
            } else {
                throw null;
            }
        }
        boolean z = true;
        if (!this.f2563a.d() || !this.o) {
            i().m.a("Updating Scion state (FE)");
            u7 q = q();
            q.b();
            q.u();
            q.B(new f8(q, q.K(true)));
            return;
        }
        i().m.a("Recording app launch after enabling measurement for the first time (FE)");
        N();
        if (xa.b() && this.f2563a.g.o(q.s0)) {
            t().f2110d.a();
        }
        if (((pa) ma.f1835b.a()).a() && this.f2563a.g.o(q.v0)) {
            if (this.f2563a.w.f2455a.o().k.a() <= 0) {
                z = false;
            }
            if (!z) {
                p4 p4Var = this.f2563a.w;
                p4Var.a(p4Var.f2455a.f2123a.getPackageName());
            }
        }
        if (this.f2563a.g.o(q.L0)) {
            f().v(new j6(this));
        }
    }

    public final ArrayList<Bundle> Q(String str, String str2, String str3) {
        if (f().x()) {
            i().f.a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (ja.a()) {
            i().f.a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.f2563a.f().s(atomicReference, 5000, "get conditional user properties", new v6(this, atomicReference, (String) null, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return v9.i0(list);
            }
            i().f.b("Timed out waiting for get conditional user properties", (Object) null);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> R(String str, String str2, String str3, boolean z) {
        String str4;
        z3 z3Var;
        if (f().x()) {
            z3Var = i().f;
            str4 = "Cannot get user properties from analytics worker thread";
        } else if (ja.a()) {
            z3Var = i().f;
            str4 = "Cannot get user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.f2563a.f().s(atomicReference, 5000, "get user properties", new u6(this, atomicReference, (String) null, str2, str3, z));
            List<zzkw> list = (List) atomicReference.get();
            if (list == null) {
                i().f.b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkw zzkw : list) {
                arrayMap.put(zzkw.f4281b, zzkw.e());
            }
            return arrayMap;
        }
        z3Var.a(str4);
        return Collections.emptyMap();
    }

    public final void S(Bundle bundle, long j2) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        b.k(bundle);
        b.W0(bundle, "app_id", cls2, null);
        b.W0(bundle, "origin", cls2, null);
        b.W0(bundle, "name", cls2, null);
        b.W0(bundle, "value", Object.class, null);
        b.W0(bundle, "trigger_event_name", cls2, null);
        b.W0(bundle, "trigger_timeout", cls, 0L);
        b.W0(bundle, "timed_out_event_name", cls2, null);
        b.W0(bundle, "timed_out_event_params", Bundle.class, null);
        b.W0(bundle, "triggered_event_name", cls2, null);
        b.W0(bundle, "triggered_event_params", Bundle.class, null);
        b.W0(bundle, "time_to_live", cls, 0L);
        b.W0(bundle, "expired_event_name", cls2, null);
        b.W0(bundle, "expired_event_params", Bundle.class, null);
        b.h(bundle.getString("name"));
        b.h(bundle.getString("origin"));
        b.k(bundle.get("value"));
        bundle.putLong("creation_timestamp", j2);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (e().g0(string) != 0) {
            i().f.b("Invalid conditional user property name", d().y(string));
        } else if (e().h0(string, obj) != 0) {
            i().f.c("Invalid conditional user property value", d().y(string), obj);
        } else {
            Object o0 = e().o0(string, obj);
            if (o0 == null) {
                i().f.c("Unable to normalize conditional user property value", d().y(string), obj);
                return;
            }
            b.h1(bundle, o0);
            long j3 = bundle.getLong("trigger_timeout");
            if (TextUtils.isEmpty(bundle.getString("trigger_event_name")) || (j3 <= 15552000000L && j3 >= 1)) {
                long j4 = bundle.getLong("time_to_live");
                if (j4 > 15552000000L || j4 < 1) {
                    i().f.c("Invalid conditional user property time to live", d().y(string), Long.valueOf(j4));
                } else {
                    f().v(new q6(this, bundle));
                }
            } else {
                i().f.c("Invalid conditional user property timeout", d().y(string), Long.valueOf(j3));
            }
        }
    }

    public final void T(String str, String str2, String str3, Bundle bundle) {
        if (((c) this.f2563a.n) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            b.h(str2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("creation_timestamp", currentTimeMillis);
            if (str3 != null) {
                bundle2.putString("expired_event_name", str3);
                bundle2.putBundle("expired_event_params", bundle);
            }
            f().v(new s6(this, bundle2));
            return;
        }
        throw null;
    }

    public final boolean w() {
        return false;
    }

    public final void y(long j2, boolean z) {
        b();
        u();
        i().m.a("Resetting analytics data (FE)");
        b9 t = t();
        t.b();
        h9 h9Var = t.f2111e;
        h9Var.f2252c.c();
        h9Var.f2250a = 0;
        h9Var.f2251b = 0;
        boolean d2 = this.f2563a.d();
        k4 k2 = k();
        k2.j.b(j2);
        if (!TextUtils.isEmpty(k2.k().z.a())) {
            k2.z.b((String) null);
        }
        if (xa.b() && k2.f2563a.g.o(q.s0)) {
            k2.u.b(0);
        }
        if (!k2.f2563a.g.w()) {
            k2.u(!d2);
        }
        k2.A.b((String) null);
        k2.B.b(0);
        k2.C.b((Bundle) null);
        if (z) {
            u7 q = q();
            q.b();
            q.u();
            zzn K = q.K(false);
            q.s().A();
            q.B(new x7(q, K));
        }
        if (xa.b() && this.f2563a.g.o(q.s0)) {
            t().f2110d.a();
        }
        this.o = !d2;
    }

    public final void z(Bundle bundle, long j2) {
        b.k(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            i().i.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        S(bundle2, j2);
    }
}

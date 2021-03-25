package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.q.c;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l7 extends a5 {

    /* renamed from: c  reason: collision with root package name */
    public volatile m7 f2352c;

    /* renamed from: d  reason: collision with root package name */
    public m7 f2353d;

    /* renamed from: e  reason: collision with root package name */
    public m7 f2354e;
    public final Map<Activity, m7> f = new ConcurrentHashMap();
    public Activity g;
    public volatile boolean h;
    public volatile m7 i;
    public m7 j;
    public boolean k;
    public final Object l = new Object();
    public String m;

    public l7(c5 c5Var) {
        super(c5Var);
    }

    public static void C(m7 m7Var, Bundle bundle, boolean z) {
        if (bundle != null && m7Var != null && (!bundle.containsKey("_sc") || z)) {
            String str = m7Var.f2376a;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            String str2 = m7Var.f2377b;
            if (str2 != null) {
                bundle.putString("_sc", str2);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", m7Var.f2378c);
        } else if (bundle != null && m7Var == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static String z(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    public final void A(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.f2563a.g.y().booleanValue() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f.put(activity, new m7(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void B(Activity activity, m7 m7Var, boolean z) {
        m7 m7Var2;
        m7 m7Var3 = m7Var;
        m7 m7Var4 = this.f2352c == null ? this.f2353d : this.f2352c;
        if (m7Var3.f2377b == null) {
            m7Var2 = new m7(m7Var3.f2376a, activity != null ? z(activity.getClass().getCanonicalName()) : null, m7Var3.f2378c, m7Var3.f2380e, m7Var3.f);
        } else {
            m7Var2 = m7Var3;
        }
        this.f2353d = this.f2352c;
        this.f2352c = m7Var2;
        if (((c) this.f2563a.n) != null) {
            f().v(new n7(this, m7Var2, m7Var4, SystemClock.elapsedRealtime(), z));
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0130  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(a.d.a.a.i.b.m7 r9, a.d.a.a.i.b.m7 r10, long r11, boolean r13, android.os.Bundle r14) {
        /*
            r8 = this;
            r8.b()
            a.d.a.a.i.b.c5 r0 = r8.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r1 = a.d.a.a.i.b.q.U
            boolean r0 = r0.o(r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            if (r13 == 0) goto L_0x0019
            a.d.a.a.i.b.m7 r13 = r8.f2354e
            if (r13 == 0) goto L_0x0019
            r13 = 1
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            if (r13 == 0) goto L_0x002c
            a.d.a.a.i.b.m7 r0 = r8.f2354e
            r8.E(r0, r1, r11)
            goto L_0x002c
        L_0x0022:
            if (r13 == 0) goto L_0x002b
            a.d.a.a.i.b.m7 r13 = r8.f2354e
            if (r13 == 0) goto L_0x002b
            r8.E(r13, r1, r11)
        L_0x002b:
            r13 = 0
        L_0x002c:
            if (r10 == 0) goto L_0x004a
            long r3 = r10.f2378c
            long r5 = r9.f2378c
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x004a
            java.lang.String r0 = r10.f2377b
            java.lang.String r3 = r9.f2377b
            boolean r0 = a.d.a.a.i.b.v9.r0(r0, r3)
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = r10.f2376a
            java.lang.String r3 = r9.f2376a
            boolean r0 = a.d.a.a.i.b.v9.r0(r0, r3)
            if (r0 != 0) goto L_0x004b
        L_0x004a:
            r2 = 1
        L_0x004b:
            if (r2 == 0) goto L_0x014a
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            a.d.a.a.i.b.c5 r2 = r8.f2563a
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.x0
            boolean r2 = r2.o(r3)
            if (r2 == 0) goto L_0x0069
            android.os.Bundle r0 = new android.os.Bundle
            if (r14 == 0) goto L_0x0066
            r0.<init>(r14)
            goto L_0x0069
        L_0x0066:
            r0.<init>()
        L_0x0069:
            r7 = r0
            C(r9, r7, r1)
            if (r10 == 0) goto L_0x0088
            java.lang.String r14 = r10.f2376a
            if (r14 == 0) goto L_0x0078
            java.lang.String r0 = "_pn"
            r7.putString(r0, r14)
        L_0x0078:
            java.lang.String r14 = r10.f2377b
            if (r14 == 0) goto L_0x0081
            java.lang.String r0 = "_pc"
            r7.putString(r0, r14)
        L_0x0081:
            long r0 = r10.f2378c
            java.lang.String r10 = "_pi"
            r7.putLong(r10, r0)
        L_0x0088:
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            a.d.a.a.i.b.ka r10 = r10.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r14 = a.d.a.a.i.b.q.U
            boolean r10 = r10.o(r14)
            r0 = 0
            if (r10 == 0) goto L_0x00d4
            if (r13 == 0) goto L_0x00d4
            a.d.a.a.h.g.ya r10 = a.d.a.a.h.g.ya.f2050b
            java.lang.Object r10 = r10.a()
            a.d.a.a.h.g.bb r10 = (a.d.a.a.h.g.bb) r10
            boolean r10 = r10.a()
            if (r10 == 0) goto L_0x00bf
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            a.d.a.a.i.b.ka r10 = r10.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r13 = a.d.a.a.i.b.q.W
            boolean r10 = r10.o(r13)
            if (r10 == 0) goto L_0x00bf
            a.d.a.a.i.b.b9 r10 = r8.t()
            a.d.a.a.i.b.h9 r10 = r10.f2111e
            long r13 = r10.f2251b
            long r13 = r11 - r13
            r10.f2251b = r11
            goto L_0x00c9
        L_0x00bf:
            a.d.a.a.i.b.b9 r10 = r8.t()
            a.d.a.a.i.b.h9 r10 = r10.f2111e
            long r13 = r10.b()
        L_0x00c9:
            int r10 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r10 <= 0) goto L_0x00d4
            a.d.a.a.i.b.v9 r10 = r8.e()
            r10.G(r7, r13)
        L_0x00d4:
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            a.d.a.a.i.b.ka r10 = r10.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.x0
            boolean r10 = r10.o(r11)
            if (r10 == 0) goto L_0x00fc
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            a.d.a.a.i.b.ka r10 = r10.g
            java.lang.Boolean r10 = r10.y()
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x00f5
            r10 = 1
            java.lang.String r12 = "_mst"
            r7.putLong(r12, r10)
        L_0x00f5:
            boolean r10 = r9.f2380e
            if (r10 == 0) goto L_0x00fc
            java.lang.String r10 = "app"
            goto L_0x00fe
        L_0x00fc:
            java.lang.String r10 = "auto"
        L_0x00fe:
            r3 = r10
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            a.d.a.a.i.b.ka r10 = r10.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.x0
            boolean r10 = r10.o(r11)
            r11 = 0
            if (r10 == 0) goto L_0x0130
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            a.d.a.a.e.q.b r10 = r10.n
            a.d.a.a.e.q.c r10 = (a.d.a.a.e.q.c) r10
            if (r10 == 0) goto L_0x012f
            long r10 = java.lang.System.currentTimeMillis()
            boolean r12 = r9.f2380e
            if (r12 == 0) goto L_0x0124
            long r12 = r9.f
            int r14 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r14 == 0) goto L_0x0124
            r5 = r12
            goto L_0x0125
        L_0x0124:
            r5 = r10
        L_0x0125:
            a.d.a.a.i.b.f6 r2 = r8.o()
            java.lang.String r4 = "_vs"
            r2.E(r3, r4, r5, r7)
            goto L_0x014a
        L_0x012f:
            throw r11
        L_0x0130:
            a.d.a.a.i.b.f6 r2 = r8.o()
            r2.b()
            a.d.a.a.i.b.c5 r10 = r2.f2563a
            a.d.a.a.e.q.b r10 = r10.n
            a.d.a.a.e.q.c r10 = (a.d.a.a.e.q.c) r10
            if (r10 == 0) goto L_0x0149
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = "_vs"
            r2.E(r3, r4, r5, r7)
            goto L_0x014a
        L_0x0149:
            throw r11
        L_0x014a:
            r8.f2354e = r9
            a.d.a.a.i.b.c5 r10 = r8.f2563a
            a.d.a.a.i.b.ka r10 = r10.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.x0
            boolean r10 = r10.o(r11)
            if (r10 == 0) goto L_0x015e
            boolean r10 = r9.f2380e
            if (r10 == 0) goto L_0x015e
            r8.j = r9
        L_0x015e:
            a.d.a.a.i.b.u7 r10 = r8.q()
            r10.b()
            r10.u()
            a.d.a.a.i.b.b8 r11 = new a.d.a.a.i.b.b8
            r11.<init>(r10, r9)
            r10.B(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.l7.D(a.d.a.a.i.b.m7, a.d.a.a.i.b.m7, long, boolean, android.os.Bundle):void");
    }

    @WorkerThread
    public final void E(m7 m7Var, boolean z, long j2) {
        a n = n();
        if (((c) this.f2563a.n) != null) {
            n.u(SystemClock.elapsedRealtime());
            if (t().y(m7Var != null && m7Var.f2379d, z, j2) && m7Var != null) {
                m7Var.f2379d = false;
                return;
            }
            return;
        }
        throw null;
    }

    @WorkerThread
    public final void F(String str, m7 m7Var) {
        b();
        synchronized (this) {
            if (this.m == null || this.m.equals(str)) {
                this.m = str;
            }
        }
    }

    @MainThread
    public final m7 G(@NonNull Activity activity) {
        b.k(activity);
        m7 m7Var = this.f.get(activity);
        if (m7Var == null) {
            m7 m7Var2 = new m7((String) null, z(activity.getClass().getCanonicalName()), e().u0());
            this.f.put(activity, m7Var2);
            m7Var = m7Var2;
        }
        return (this.f2563a.g.o(q.x0) && this.i != null) ? this.i : m7Var;
    }

    public final boolean w() {
        return false;
    }

    @WorkerThread
    public final m7 y(boolean z) {
        u();
        b();
        if (!this.f2563a.g.o(q.x0) || !z) {
            return this.f2354e;
        }
        m7 m7Var = this.f2354e;
        return m7Var != null ? m7Var : this.j;
    }
}

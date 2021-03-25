package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.q.c;
import a.d.a.a.h.g.b1;
import a.d.a.a.h.g.c9;
import a.d.a.a.h.g.f1;
import a.d.a.a.h.g.jb;
import a.d.a.a.h.g.kb;
import a.d.a.a.h.g.u9;
import a.d.a.a.h.g.x0;
import a.d.a.a.h.g.y5;
import a.d.a.a.h.g.z0;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzar;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzw;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class o9 implements x5 {
    public static volatile o9 z;

    /* renamed from: a  reason: collision with root package name */
    public w4 f2442a;

    /* renamed from: b  reason: collision with root package name */
    public b4 f2443b;

    /* renamed from: c  reason: collision with root package name */
    public d f2444c;

    /* renamed from: d  reason: collision with root package name */
    public i4 f2445d;

    /* renamed from: e  reason: collision with root package name */
    public l9 f2446e;
    public ba f;
    public final s9 g;
    public k7 h;
    public u8 i;
    public final c5 j;
    public boolean k = false;
    public boolean l;
    public long m;
    public List<Runnable> n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public FileLock t;
    public FileChannel u;
    public List<Long> v;
    public List<Long> w;
    public long x;
    public final Map<String, e> y;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public b1 f2447a;

        /* renamed from: b  reason: collision with root package name */
        public List<Long> f2448b;

        /* renamed from: c  reason: collision with root package name */
        public List<x0> f2449c;

        /* renamed from: d  reason: collision with root package name */
        public long f2450d;

        public a(o9 o9Var, n9 n9Var) {
        }

        public final void a(b1 b1Var) {
            b.k(b1Var);
            this.f2447a = b1Var;
        }

        public final boolean b(long j, x0 x0Var) {
            b.k(x0Var);
            if (this.f2449c == null) {
                this.f2449c = new ArrayList();
            }
            if (this.f2448b == null) {
                this.f2448b = new ArrayList();
            }
            if (this.f2449c.size() > 0 && ((this.f2449c.get(0).zzf / 1000) / 60) / 60 != ((x0Var.zzf / 1000) / 60) / 60) {
                return false;
            }
            long c2 = this.f2450d + ((long) x0Var.c());
            if (c2 >= ((long) Math.max(0, q.i.a(null).intValue()))) {
                return false;
            }
            this.f2450d = c2;
            this.f2449c.add(x0Var);
            this.f2448b.add(Long.valueOf(j));
            if (this.f2449c.size() >= Math.max(1, q.j.a(null).intValue())) {
                return false;
            }
            return true;
        }
    }

    public o9(t9 t9Var) {
        b.k(t9Var);
        this.j = c5.a(t9Var.f2535a, (zzae) null, (Long) null);
        this.x = -1;
        s9 s9Var = new s9(this);
        s9Var.o();
        this.g = s9Var;
        b4 b4Var = new b4(this);
        b4Var.o();
        this.f2443b = b4Var;
        w4 w4Var = new w4(this);
        w4Var.o();
        this.f2442a = w4Var;
        this.y = new HashMap();
        this.j.f().v(new n9(this, t9Var));
    }

    public static void B(m9 m9Var) {
        if (m9Var == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!m9Var.f2387c) {
            String valueOf = String.valueOf(m9Var.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    public static o9 b(Context context) {
        b.k(context);
        b.k(context.getApplicationContext());
        if (z == null) {
            synchronized (o9.class) {
                if (z == null) {
                    z = new o9(new t9(context));
                }
            }
        }
        return z;
    }

    public static void d(x0.a aVar, int i2, String str) {
        List<z0> s2 = aVar.s();
        int i3 = 0;
        while (i3 < s2.size()) {
            if (!"_err".equals(s2.get(i3).zzd)) {
                i3++;
            } else {
                return;
            }
        }
        z0.a E = z0.E();
        E.q("_err");
        E.o(Long.valueOf((long) i2).longValue());
        z0 z0Var = (z0) ((y5) E.m());
        z0.a E2 = z0.E();
        E2.q("_ev");
        E2.r(str);
        z0 z0Var2 = (z0) ((y5) E2.m());
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        x0 x0Var = (x0) aVar.f2047b;
        if (x0Var != null) {
            z0Var.getClass();
            x0Var.D();
            x0Var.zzd.add(z0Var);
            if (aVar.f2048c) {
                aVar.k();
                aVar.f2048c = false;
            }
            x0 x0Var2 = (x0) aVar.f2047b;
            if (x0Var2 != null) {
                z0Var2.getClass();
                x0Var2.D();
                x0Var2.zzd.add(z0Var2);
                return;
            }
            throw null;
        }
        throw null;
    }

    public static void e(x0.a aVar, @NonNull String str) {
        List<z0> s2 = aVar.s();
        for (int i2 = 0; i2 < s2.size(); i2++) {
            if (str.equals(s2.get(i2).zzd)) {
                aVar.u(i2);
                return;
            }
        }
    }

    @WorkerThread
    public final void A(zzar zzar, zzn zzn) {
        if (kb.b() && this.j.g.o(q.I0)) {
            c4 b2 = c4.b(zzar);
            this.j.t().H(b2.f2122d, J().h0(zzn.f4285a));
            this.j.t().Q(b2, this.j.g.l(zzn.f4285a));
            zzar = b2.a();
        }
        if (this.j.g.o(q.f0) && "_cmp".equals(zzar.f4276a) && "referrer API v2".equals(zzar.f4277b.f4275a.getString("_cis"))) {
            String string = zzar.f4277b.f4275a.getString("gclid");
            if (!TextUtils.isEmpty(string)) {
                n(new zzkw("_lgclid", zzar.f4279d, string, "auto"), zzn);
            }
        }
        k(zzar, zzn);
    }

    @WorkerThread
    public final void C(zzkw zzkw, zzn zzn) {
        T();
        O();
        if (K(zzn)) {
            if (!zzn.h) {
                F(zzn);
            } else if (!"_npa".equals(zzkw.f4281b) || zzn.s == null) {
                this.j.i().m.b("Removing user property", this.j.u().y(zzkw.f4281b));
                J().b0();
                try {
                    F(zzn);
                    J().V(zzn.f4285a, zzkw.f4281b);
                    J().s();
                    this.j.i().m.b("User property removed", this.j.u().y(zzkw.f4281b));
                } finally {
                    J().e0();
                }
            } else {
                this.j.i().m.a("Falling back to manifest metadata value for ad personalization");
                if (((c) this.j.n) != null) {
                    n(new zzkw("_npa", System.currentTimeMillis(), Long.valueOf(zzn.s.booleanValue() ? 1 : 0), "auto"), zzn);
                    return;
                }
                throw null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0445 A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0479 A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0129 A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01da A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x020e A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0210 A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0214 A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0237 A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x023d A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x024a A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0259 A[Catch:{ SQLiteException -> 0x01c7, all -> 0x04a3 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.T()
            r21.O()
            a.c.a.f.b.k(r22)
            java.lang.String r7 = r2.f4285a
            a.c.a.f.b.h(r7)
            boolean r7 = r21.K(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            a.d.a.a.i.b.d r7 = r21.J()
            java.lang.String r8 = r2.f4285a
            a.d.a.a.i.b.a4 r7 = r7.T(r8)
            r8 = 0
            if (r7 == 0) goto L_0x005b
            java.lang.String r10 = r7.v()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x005b
            java.lang.String r10 = r2.f4286b
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x005b
            r7.F(r8)
            a.d.a.a.i.b.d r10 = r21.J()
            r10.I(r7)
            a.d.a.a.i.b.w4 r7 = r21.G()
            java.lang.String r10 = r2.f4285a
            r7.b()
            java.util.Map<java.lang.String, a.d.a.a.h.g.r0> r7 = r7.g
            r7.remove(r10)
        L_0x005b:
            boolean r7 = r2.h
            if (r7 != 0) goto L_0x0063
            r21.F(r22)
            return
        L_0x0063:
            long r10 = r2.m
            r7 = 0
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 != 0) goto L_0x0078
            a.d.a.a.i.b.c5 r10 = r1.j
            a.d.a.a.e.q.b r10 = r10.n
            a.d.a.a.e.q.c r10 = (a.d.a.a.e.q.c) r10
            if (r10 == 0) goto L_0x0077
            long r10 = java.lang.System.currentTimeMillis()
            goto L_0x0078
        L_0x0077:
            throw r7
        L_0x0078:
            a.d.a.a.i.b.c5 r12 = r1.j
            a.d.a.a.i.b.k r12 = r12.y()
            r12.b()
            r12.g = r7
            r12.h = r8
            int r12 = r2.n
            r15 = 1
            if (r12 == 0) goto L_0x00a5
            if (r12 == r15) goto L_0x00a5
            a.d.a.a.i.b.c5 r13 = r1.j
            a.d.a.a.i.b.x3 r13 = r13.i()
            a.d.a.a.i.b.z3 r13 = r13.i
            java.lang.String r7 = r2.f4285a
            java.lang.Object r7 = a.d.a.a.i.b.x3.s(r7)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r13.c(r14, r7, r12)
            r7 = 0
            goto L_0x00a6
        L_0x00a5:
            r7 = r12
        L_0x00a6:
            a.d.a.a.i.b.d r12 = r21.J()
            r12.b0()
            a.d.a.a.i.b.d r12 = r21.J()     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            java.lang.String r14 = "_npa"
            a.d.a.a.i.b.w9 r14 = r12.Y(r13, r14)     // Catch:{ all -> 0x04a3 }
            if (r14 == 0) goto L_0x00ca
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.f2607b     // Catch:{ all -> 0x04a3 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x04a3 }
            if (r12 == 0) goto L_0x00c6
            goto L_0x00ca
        L_0x00c6:
            r20 = r3
            r3 = 1
            goto L_0x011d
        L_0x00ca:
            java.lang.Boolean r12 = r2.s     // Catch:{ all -> 0x04a3 }
            if (r12 == 0) goto L_0x0107
            com.google.android.gms.measurement.internal.zzkw r13 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04a3 }
            java.lang.String r17 = "_npa"
            java.lang.Boolean r12 = r2.s     // Catch:{ all -> 0x04a3 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x04a3 }
            if (r12 == 0) goto L_0x00dd
            r18 = 1
            goto L_0x00df
        L_0x00dd:
            r18 = r8
        L_0x00df:
            java.lang.Long r18 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x04a3 }
            java.lang.String r19 = "auto"
            r8 = 1
            r12 = r13
            r8 = r13
            r13 = r17
            r20 = r3
            r9 = r14
            r3 = 1
            r14 = r10
            r16 = r18
            r17 = r19
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04a3 }
            if (r9 == 0) goto L_0x0103
            java.lang.Object r9 = r9.f2610e     // Catch:{ all -> 0x04a3 }
            java.lang.Long r12 = r8.f4283d     // Catch:{ all -> 0x04a3 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x04a3 }
            if (r9 != 0) goto L_0x011d
        L_0x0103:
            r1.n(r8, r2)     // Catch:{ all -> 0x04a3 }
            goto L_0x011d
        L_0x0107:
            r20 = r3
            r9 = r14
            r3 = 1
            if (r9 == 0) goto L_0x011d
            com.google.android.gms.measurement.internal.zzkw r8 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04a3 }
            r1.C(r8, r2)     // Catch:{ all -> 0x04a3 }
        L_0x011d:
            a.d.a.a.i.b.d r8 = r21.J()     // Catch:{ all -> 0x04a3 }
            java.lang.String r9 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.a4 r8 = r8.T(r9)     // Catch:{ all -> 0x04a3 }
            if (r8 == 0) goto L_0x01d8
            a.d.a.a.i.b.c5 r9 = r1.j     // Catch:{ all -> 0x04a3 }
            r9.t()     // Catch:{ all -> 0x04a3 }
            java.lang.String r9 = r2.f4286b     // Catch:{ all -> 0x04a3 }
            java.lang.String r12 = r8.v()     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = r2.r     // Catch:{ all -> 0x04a3 }
            java.lang.String r14 = r8.y()     // Catch:{ all -> 0x04a3 }
            boolean r9 = a.d.a.a.i.b.v9.b0(r9, r12, r13, r14)     // Catch:{ all -> 0x04a3 }
            if (r9 == 0) goto L_0x01d8
            a.d.a.a.i.b.c5 r9 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.x3 r9 = r9.i()     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.z3 r9 = r9.i     // Catch:{ all -> 0x04a3 }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r8.o()     // Catch:{ all -> 0x04a3 }
            java.lang.Object r13 = a.d.a.a.i.b.x3.s(r13)     // Catch:{ all -> 0x04a3 }
            r9.b(r12, r13)     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.d r9 = r21.J()     // Catch:{ all -> 0x04a3 }
            java.lang.String r8 = r8.o()     // Catch:{ all -> 0x04a3 }
            r9.n()     // Catch:{ all -> 0x04a3 }
            r9.b()     // Catch:{ all -> 0x04a3 }
            a.c.a.f.b.h(r8)     // Catch:{ all -> 0x04a3 }
            android.database.sqlite.SQLiteDatabase r12 = r9.t()     // Catch:{ SQLiteException -> 0x01c7 }
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01c7 }
            r14 = 0
            r13[r14] = r8     // Catch:{ SQLiteException -> 0x01c7 }
            java.lang.String r15 = "events"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "user_attributes"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "conditional_properties"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "apps"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "raw_events"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "raw_events_metadata"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "event_filters"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "property_filters"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "audience_filter_values"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r14
            java.lang.String r14 = "consent_settings"
            int r0 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            int r15 = r15 + r0
            if (r15 <= 0) goto L_0x01d7
            a.d.a.a.i.b.x3 r0 = r9.i()     // Catch:{ SQLiteException -> 0x01c7 }
            a.d.a.a.i.b.z3 r0 = r0.n     // Catch:{ SQLiteException -> 0x01c7 }
            java.lang.String r12 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)     // Catch:{ SQLiteException -> 0x01c7 }
            r0.c(r12, r8, r13)     // Catch:{ SQLiteException -> 0x01c7 }
            goto L_0x01d7
        L_0x01c7:
            r0 = move-exception
            a.d.a.a.i.b.x3 r9 = r9.i()     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.z3 r9 = r9.f     // Catch:{ all -> 0x04a3 }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = a.d.a.a.i.b.x3.s(r8)     // Catch:{ all -> 0x04a3 }
            r9.c(r12, r8, r0)     // Catch:{ all -> 0x04a3 }
        L_0x01d7:
            r8 = 0
        L_0x01d8:
            if (r8 == 0) goto L_0x0237
            long r12 = r8.N()     // Catch:{ all -> 0x04a3 }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01f2
            long r12 = r8.N()     // Catch:{ all -> 0x04a3 }
            r9 = r4
            long r3 = r2.j     // Catch:{ all -> 0x04a3 }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01f3
            r0 = 1
            goto L_0x01f4
        L_0x01f2:
            r9 = r4
        L_0x01f3:
            r0 = 0
        L_0x01f4:
            long r3 = r8.N()     // Catch:{ all -> 0x04a3 }
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x0210
            java.lang.String r3 = r8.M()     // Catch:{ all -> 0x04a3 }
            if (r3 == 0) goto L_0x0210
            java.lang.String r3 = r8.M()     // Catch:{ all -> 0x04a3 }
            java.lang.String r4 = r2.f4287c     // Catch:{ all -> 0x04a3 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04a3 }
            if (r3 != 0) goto L_0x0210
            r14 = 1
            goto L_0x0211
        L_0x0210:
            r14 = 0
        L_0x0211:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x0238
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04a3 }
            r0.<init>()     // Catch:{ all -> 0x04a3 }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.M()     // Catch:{ all -> 0x04a3 }
            r0.putString(r3, r4)     // Catch:{ all -> 0x04a3 }
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04a3 }
            r14.<init>(r0)     // Catch:{ all -> 0x04a3 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04a3 }
            r1.k(r3, r2)     // Catch:{ all -> 0x04a3 }
            goto L_0x0238
        L_0x0237:
            r9 = r4
        L_0x0238:
            r21.F(r22)     // Catch:{ all -> 0x04a3 }
            if (r7 != 0) goto L_0x024a
            a.d.a.a.i.b.d r0 = r21.J()     // Catch:{ all -> 0x04a3 }
            java.lang.String r3 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            java.lang.String r4 = "_f"
        L_0x0245:
            a.d.a.a.i.b.l r0 = r0.z(r3, r4)     // Catch:{ all -> 0x04a3 }
            goto L_0x0257
        L_0x024a:
            r3 = 1
            if (r7 != r3) goto L_0x0256
            a.d.a.a.i.b.d r0 = r21.J()     // Catch:{ all -> 0x04a3 }
            java.lang.String r3 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            java.lang.String r4 = "_v"
            goto L_0x0245
        L_0x0256:
            r0 = 0
        L_0x0257:
            if (r0 != 0) goto L_0x0479
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x03df
            com.google.android.gms.measurement.internal.zzkw r7 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04a3 }
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04a3 }
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04a3 }
            r1.n(r7, r2)     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.ka r7 = r7.g     // Catch:{ all -> 0x04a3 }
            java.lang.String r12 = r2.f4286b     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r13 = a.d.a.a.i.b.q.S     // Catch:{ all -> 0x04a3 }
            boolean r7 = r7.t(r12, r13)     // Catch:{ all -> 0x04a3 }
            if (r7 == 0) goto L_0x029a
            r21.T()     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.p4 r7 = r7.w     // Catch:{ all -> 0x04a3 }
            java.lang.String r12 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            r7.a(r12)     // Catch:{ all -> 0x04a3 }
        L_0x029a:
            r21.T()     // Catch:{ all -> 0x04a3 }
            r21.O()     // Catch:{ all -> 0x04a3 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x04a3 }
            r7.<init>()     // Catch:{ all -> 0x04a3 }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x04a3 }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x04a3 }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x04a3 }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04a3 }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x04a3 }
            r14 = r20
            r7.putLong(r14, r3)     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.ka r3 = r3.g     // Catch:{ all -> 0x04a3 }
            java.lang.String r4 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r12 = a.d.a.a.i.b.q.U     // Catch:{ all -> 0x04a3 }
            boolean r3 = r3.t(r4, r12)     // Catch:{ all -> 0x04a3 }
            if (r3 == 0) goto L_0x02d1
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x04a3 }
            goto L_0x02d3
        L_0x02d1:
            r3 = 1
        L_0x02d3:
            boolean r12 = r2.q     // Catch:{ all -> 0x04a3 }
            if (r12 == 0) goto L_0x02da
            r7.putLong(r0, r3)     // Catch:{ all -> 0x04a3 }
        L_0x02da:
            a.d.a.a.i.b.d r0 = r21.J()     // Catch:{ all -> 0x04a3 }
            java.lang.String r3 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            a.c.a.f.b.h(r3)     // Catch:{ all -> 0x04a3 }
            r0.b()     // Catch:{ all -> 0x04a3 }
            r0.n()     // Catch:{ all -> 0x04a3 }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.g0(r3, r4)     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x04a3 }
            android.content.Context r0 = r0.f2123a     // Catch:{ all -> 0x04a3 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04a3 }
            if (r0 != 0) goto L_0x0310
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ all -> 0x04a3 }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r9)     // Catch:{ all -> 0x04a3 }
            r0.b(r6, r9)     // Catch:{ all -> 0x04a3 }
        L_0x030c:
            r12 = 0
            goto L_0x03c3
        L_0x0310:
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ NameNotFoundException -> 0x0320 }
            android.content.Context r0 = r0.f2123a     // Catch:{ NameNotFoundException -> 0x0320 }
            a.d.a.a.e.r.b r0 = a.d.a.a.e.r.c.a(r0)     // Catch:{ NameNotFoundException -> 0x0320 }
            java.lang.String r12 = r2.f4285a     // Catch:{ NameNotFoundException -> 0x0320 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.b(r12, r13)     // Catch:{ NameNotFoundException -> 0x0320 }
            goto L_0x0335
        L_0x0320:
            r0 = move-exception
            a.d.a.a.i.b.c5 r12 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.x3 r12 = r12.i()     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.z3 r12 = r12.f     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            java.lang.Object r15 = a.d.a.a.i.b.x3.s(r15)     // Catch:{ all -> 0x04a3 }
            r12.c(r13, r15, r0)     // Catch:{ all -> 0x04a3 }
            r0 = 0
        L_0x0335:
            if (r0 == 0) goto L_0x0383
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04a3 }
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x0383
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04a3 }
            r20 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x04a3 }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0366
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r12 = a.d.a.a.i.b.q.p0     // Catch:{ all -> 0x04a3 }
            boolean r0 = r0.o(r12)     // Catch:{ all -> 0x04a3 }
            if (r0 == 0) goto L_0x0361
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0364
            r12 = 1
        L_0x035d:
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04a3 }
            goto L_0x0364
        L_0x0361:
            r12 = 1
            goto L_0x035d
        L_0x0364:
            r14 = 0
            goto L_0x0367
        L_0x0366:
            r14 = 1
        L_0x0367:
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x0370
            r14 = 1
            goto L_0x0372
        L_0x0370:
            r14 = 0
        L_0x0372:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x04a3 }
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r20
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04a3 }
            r1.n(r0, r2)     // Catch:{ all -> 0x04a3 }
            goto L_0x0384
        L_0x0383:
            r6 = r14
        L_0x0384:
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ NameNotFoundException -> 0x0394 }
            android.content.Context r0 = r0.f2123a     // Catch:{ NameNotFoundException -> 0x0394 }
            a.d.a.a.e.r.b r0 = a.d.a.a.e.r.c.a(r0)     // Catch:{ NameNotFoundException -> 0x0394 }
            java.lang.String r12 = r2.f4285a     // Catch:{ NameNotFoundException -> 0x0394 }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.a(r12, r13)     // Catch:{ NameNotFoundException -> 0x0394 }
            goto L_0x03a9
        L_0x0394:
            r0 = move-exception
            a.d.a.a.i.b.c5 r12 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.x3 r12 = r12.i()     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.z3 r12 = r12.f     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            java.lang.Object r14 = a.d.a.a.i.b.x3.s(r14)     // Catch:{ all -> 0x04a3 }
            r12.c(r13, r14, r0)     // Catch:{ all -> 0x04a3 }
            r0 = 0
        L_0x03a9:
            if (r0 == 0) goto L_0x030c
            int r12 = r0.flags     // Catch:{ all -> 0x04a3 }
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x03b6
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x04a3 }
        L_0x03b6:
            int r0 = r0.flags     // Catch:{ all -> 0x04a3 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x030c
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04a3 }
            goto L_0x030c
        L_0x03c3:
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x03ca
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04a3 }
        L_0x03ca:
            com.google.android.gms.measurement.internal.zzar r0 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04a3 }
            r14.<init>(r7)     // Catch:{ all -> 0x04a3 }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04a3 }
        L_0x03db:
            r1.A(r0, r2)     // Catch:{ all -> 0x04a3 }
            goto L_0x0437
        L_0x03df:
            r5 = 1
            if (r7 != r5) goto L_0x0437
            com.google.android.gms.measurement.internal.zzkw r5 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x04a3 }
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04a3 }
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04a3 }
            r1.n(r5, r2)     // Catch:{ all -> 0x04a3 }
            r21.T()     // Catch:{ all -> 0x04a3 }
            r21.O()     // Catch:{ all -> 0x04a3 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x04a3 }
            r5.<init>()     // Catch:{ all -> 0x04a3 }
            r6 = 1
            r5.putLong(r4, r6)     // Catch:{ all -> 0x04a3 }
            r5.putLong(r3, r6)     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.ka r3 = r3.g     // Catch:{ all -> 0x04a3 }
            java.lang.String r4 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.U     // Catch:{ all -> 0x04a3 }
            boolean r3 = r3.t(r4, r6)     // Catch:{ all -> 0x04a3 }
            if (r3 == 0) goto L_0x041c
            r3 = 1
            r5.putLong(r8, r3)     // Catch:{ all -> 0x04a3 }
            goto L_0x041e
        L_0x041c:
            r3 = 1
        L_0x041e:
            boolean r6 = r2.q     // Catch:{ all -> 0x04a3 }
            if (r6 == 0) goto L_0x0425
            r5.putLong(r0, r3)     // Catch:{ all -> 0x04a3 }
        L_0x0425:
            com.google.android.gms.measurement.internal.zzar r0 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04a3 }
            r14.<init>(r5)     // Catch:{ all -> 0x04a3 }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04a3 }
            goto L_0x03db
        L_0x0437:
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x04a3 }
            java.lang.String r3 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.V     // Catch:{ all -> 0x04a3 }
            boolean r0 = r0.t(r3, r4)     // Catch:{ all -> 0x04a3 }
            if (r0 != 0) goto L_0x0494
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04a3 }
            r0.<init>()     // Catch:{ all -> 0x04a3 }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.ka r3 = r3.g     // Catch:{ all -> 0x04a3 }
            java.lang.String r4 = r2.f4285a     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.U     // Catch:{ all -> 0x04a3 }
            boolean r3 = r3.t(r4, r5)     // Catch:{ all -> 0x04a3 }
            if (r3 == 0) goto L_0x0464
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04a3 }
        L_0x0464:
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04a3 }
            r14.<init>(r0)     // Catch:{ all -> 0x04a3 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04a3 }
        L_0x0475:
            r1.A(r3, r2)     // Catch:{ all -> 0x04a3 }
            goto L_0x0494
        L_0x0479:
            boolean r0 = r2.i     // Catch:{ all -> 0x04a3 }
            if (r0 == 0) goto L_0x0494
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04a3 }
            r0.<init>()     // Catch:{ all -> 0x04a3 }
            com.google.android.gms.measurement.internal.zzar r3 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x04a3 }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzam r14 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04a3 }
            r14.<init>(r0)     // Catch:{ all -> 0x04a3 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04a3 }
            goto L_0x0475
        L_0x0494:
            a.d.a.a.i.b.d r0 = r21.J()     // Catch:{ all -> 0x04a3 }
            r0.s()     // Catch:{ all -> 0x04a3 }
            a.d.a.a.i.b.d r0 = r21.J()
            r0.e0()
            return
        L_0x04a3:
            r0 = move-exception
            a.d.a.a.i.b.d r2 = r21.J()
            r2.e0()
            goto L_0x04ad
        L_0x04ac:
            throw r0
        L_0x04ad:
            goto L_0x04ac
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.D(com.google.android.gms.measurement.internal.zzn):void");
    }

    @WorkerThread
    public final void E(zzw zzw, zzn zzn) {
        b.k(zzw);
        b.h(zzw.f4290a);
        b.k(zzw.f4292c);
        b.h(zzw.f4292c.f4281b);
        T();
        O();
        if (K(zzn)) {
            if (!zzn.h) {
                F(zzn);
                return;
            }
            J().b0();
            try {
                F(zzn);
                zzw Z = J().Z(zzw.f4290a, zzw.f4292c.f4281b);
                if (Z != null) {
                    this.j.i().m.c("Removing conditional user property", zzw.f4290a, this.j.u().y(zzw.f4292c.f4281b));
                    J().a0(zzw.f4290a, zzw.f4292c.f4281b);
                    if (Z.f4294e) {
                        J().V(zzw.f4290a, zzw.f4292c.f4281b);
                    }
                    if (zzw.k != null) {
                        Bundle bundle = null;
                        if (zzw.k.f4277b != null) {
                            bundle = zzw.k.f4277b.h();
                        }
                        H(this.j.t().B(zzw.f4290a, zzw.k.f4276a, bundle, Z.f4291b, zzw.k.f4279d, c9.b() && this.j.g.o(q.T0)), zzn);
                    }
                } else {
                    this.j.i().i.c("Conditional user property doesn't exist", x3.s(zzw.f4290a), this.j.u().y(zzw.f4292c.f4281b));
                }
                J().s();
            } finally {
                J().e0();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r1.j() != false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01f3, code lost:
        if (r1.j() != false) goto L_0x01fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0376  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03a1  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.a.a.i.b.a4 F(com.google.android.gms.measurement.internal.zzn r11) {
        /*
            r10 = this;
            r10.T()
            r10.O()
            a.c.a.f.b.k(r11)
            java.lang.String r0 = r11.f4285a
            a.c.a.f.b.h(r0)
            a.d.a.a.i.b.d r0 = r10.J()
            java.lang.String r1 = r11.f4285a
            a.d.a.a.i.b.a4 r0 = r0.T(r1)
            a.d.a.a.i.b.e r1 = a.d.a.a.i.b.e.f2160c
            boolean r2 = a.d.a.a.h.g.u9.b()
            if (r2 == 0) goto L_0x003c
            a.d.a.a.i.b.c5 r2 = r10.j
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.Q0
            boolean r2 = r2.o(r3)
            if (r2 == 0) goto L_0x003c
            java.lang.String r1 = r11.f4285a
            a.d.a.a.i.b.e r1 = r10.a(r1)
            java.lang.String r2 = r11.w
            a.d.a.a.i.b.e r2 = a.d.a.a.i.b.e.b(r2)
            a.d.a.a.i.b.e r1 = r1.h(r2)
        L_0x003c:
            boolean r2 = a.d.a.a.h.g.u9.b()
            if (r2 == 0) goto L_0x0058
            a.d.a.a.i.b.c5 r2 = r10.j
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.Q0
            boolean r2 = r2.o(r3)
            if (r2 == 0) goto L_0x0058
            boolean r2 = r1.j()
            if (r2 == 0) goto L_0x0055
            goto L_0x0058
        L_0x0055:
            java.lang.String r2 = ""
            goto L_0x0060
        L_0x0058:
            a.d.a.a.i.b.u8 r2 = r10.i
            java.lang.String r3 = r11.f4285a
            java.lang.String r2 = r2.t(r3)
        L_0x0060:
            a.d.a.a.h.g.sa r3 = a.d.a.a.h.g.sa.f1936b
            java.lang.Object r3 = r3.a()
            a.d.a.a.h.g.va r3 = (a.d.a.a.h.g.va) r3
            boolean r3 = r3.a()
            r4 = 0
            if (r3 == 0) goto L_0x01a0
            a.d.a.a.i.b.c5 r3 = r10.j
            a.d.a.a.i.b.ka r3 = r3.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.q0
            boolean r3 = r3.o(r6)
            if (r3 == 0) goto L_0x01a0
            if (r0 != 0) goto L_0x00b8
            a.d.a.a.i.b.a4 r0 = new a.d.a.a.i.b.a4
            a.d.a.a.i.b.c5 r3 = r10.j
            java.lang.String r6 = r11.f4285a
            r0.<init>(r3, r6)
            boolean r3 = a.d.a.a.h.g.u9.b()
            if (r3 == 0) goto L_0x00ad
            a.d.a.a.i.b.c5 r3 = r10.j
            a.d.a.a.i.b.ka r3 = r3.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.Q0
            boolean r3 = r3.o(r6)
            if (r3 == 0) goto L_0x00ad
            boolean r3 = r1.k()
            if (r3 == 0) goto L_0x00a6
            java.lang.String r3 = r10.c(r1)
            r0.c(r3)
        L_0x00a6:
            boolean r1 = r1.j()
            if (r1 == 0) goto L_0x00fb
            goto L_0x00b4
        L_0x00ad:
            java.lang.String r1 = r10.V()
            r0.c(r1)
        L_0x00b4:
            r0.x(r2)
            goto L_0x00fb
        L_0x00b8:
            boolean r3 = a.d.a.a.h.g.u9.b()
            if (r3 == 0) goto L_0x00d0
            a.d.a.a.i.b.c5 r3 = r10.j
            a.d.a.a.i.b.ka r3 = r3.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.Q0
            boolean r3 = r3.o(r6)
            if (r3 == 0) goto L_0x00d0
            boolean r3 = r1.j()
            if (r3 == 0) goto L_0x00fb
        L_0x00d0:
            java.lang.String r3 = r0.E()
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x00fb
            r0.x(r2)
            boolean r2 = a.d.a.a.h.g.u9.b()
            if (r2 == 0) goto L_0x00f4
            a.d.a.a.i.b.c5 r2 = r10.j
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.Q0
            boolean r2 = r2.o(r3)
            if (r2 == 0) goto L_0x00f4
            java.lang.String r1 = r10.c(r1)
            goto L_0x00f8
        L_0x00f4:
            java.lang.String r1 = r10.V()
        L_0x00f8:
            r0.c(r1)
        L_0x00fb:
            java.lang.String r1 = r11.f4286b
            r0.m(r1)
            java.lang.String r1 = r11.r
            r0.q(r1)
            boolean r1 = a.d.a.a.h.g.jb.b()
            if (r1 == 0) goto L_0x0120
            a.d.a.a.i.b.c5 r1 = r10.j
            a.d.a.a.i.b.ka r1 = r1.g
            java.lang.String r2 = r0.o()
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.k0
            boolean r1 = r1.t(r2, r3)
            if (r1 == 0) goto L_0x0120
            java.lang.String r1 = r11.v
            r0.u(r1)
        L_0x0120:
            java.lang.String r1 = r11.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x012d
            java.lang.String r1 = r11.k
            r0.A(r1)
        L_0x012d:
            long r1 = r11.f4289e
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0136
            r0.t(r1)
        L_0x0136:
            java.lang.String r1 = r11.f4287c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0143
            java.lang.String r1 = r11.f4287c
            r0.D(r1)
        L_0x0143:
            long r1 = r11.j
            r0.p(r1)
            java.lang.String r1 = r11.f4288d
            if (r1 == 0) goto L_0x014f
            r0.G(r1)
        L_0x014f:
            long r1 = r11.f
            r0.w(r1)
            boolean r1 = r11.h
            r0.e(r1)
            java.lang.String r1 = r11.g
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0166
            java.lang.String r1 = r11.g
            r0.J(r1)
        L_0x0166:
            a.d.a.a.i.b.c5 r1 = r10.j
            a.d.a.a.i.b.ka r1 = r1.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.G0
            boolean r1 = r1.o(r2)
            if (r1 != 0) goto L_0x0177
            long r1 = r11.l
            r0.R(r1)
        L_0x0177:
            boolean r1 = r11.o
            r0.n(r1)
            boolean r1 = r11.p
            r0.r(r1)
            java.lang.Boolean r1 = r11.s
            r0.b(r1)
            long r1 = r11.t
            r0.z(r1)
            a.d.a.a.i.b.c5 r11 = r0.f2076a
            a.d.a.a.i.b.v4 r11 = r11.f()
            r11.b()
            boolean r11 = r0.E
            if (r11 == 0) goto L_0x019f
            a.d.a.a.i.b.d r11 = r10.J()
            r11.I(r0)
        L_0x019f:
            return r0
        L_0x01a0:
            a.d.a.a.i.b.e r1 = a.d.a.a.i.b.e.f2160c
            boolean r3 = a.d.a.a.h.g.u9.b()
            if (r3 == 0) goto L_0x01c4
            a.d.a.a.i.b.c5 r3 = r10.j
            a.d.a.a.i.b.ka r3 = r3.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.Q0
            boolean r3 = r3.o(r6)
            if (r3 == 0) goto L_0x01c4
            java.lang.String r1 = r11.f4285a
            a.d.a.a.i.b.e r1 = r10.a(r1)
            java.lang.String r3 = r11.w
            a.d.a.a.i.b.e r3 = a.d.a.a.i.b.e.b(r3)
            a.d.a.a.i.b.e r1 = r1.h(r3)
        L_0x01c4:
            r3 = 1
            if (r0 != 0) goto L_0x0201
            a.d.a.a.i.b.a4 r0 = new a.d.a.a.i.b.a4
            a.d.a.a.i.b.c5 r6 = r10.j
            java.lang.String r7 = r11.f4285a
            r0.<init>(r6, r7)
            boolean r6 = a.d.a.a.h.g.u9.b()
            if (r6 == 0) goto L_0x01f6
            a.d.a.a.i.b.c5 r6 = r10.j
            a.d.a.a.i.b.ka r6 = r6.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r7 = a.d.a.a.i.b.q.Q0
            boolean r6 = r6.o(r7)
            if (r6 == 0) goto L_0x01f6
            boolean r6 = r1.k()
            if (r6 == 0) goto L_0x01ef
            java.lang.String r6 = r10.c(r1)
            r0.c(r6)
        L_0x01ef:
            boolean r1 = r1.j()
            if (r1 == 0) goto L_0x024a
            goto L_0x01fd
        L_0x01f6:
            java.lang.String r1 = r10.V()
            r0.c(r1)
        L_0x01fd:
            r0.x(r2)
            goto L_0x024a
        L_0x0201:
            boolean r6 = a.d.a.a.h.g.u9.b()
            if (r6 == 0) goto L_0x0219
            a.d.a.a.i.b.c5 r6 = r10.j
            a.d.a.a.i.b.ka r6 = r6.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r7 = a.d.a.a.i.b.q.Q0
            boolean r6 = r6.o(r7)
            if (r6 == 0) goto L_0x0219
            boolean r6 = r1.j()
            if (r6 == 0) goto L_0x024c
        L_0x0219:
            java.lang.String r6 = r0.E()
            boolean r6 = r2.equals(r6)
            if (r6 != 0) goto L_0x024c
            r0.x(r2)
            boolean r2 = a.d.a.a.h.g.u9.b()
            if (r2 == 0) goto L_0x0243
            a.d.a.a.i.b.c5 r2 = r10.j
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.Q0
            boolean r2 = r2.o(r6)
            if (r2 == 0) goto L_0x0243
            boolean r2 = r1.k()
            if (r2 == 0) goto L_0x024a
            java.lang.String r1 = r10.c(r1)
            goto L_0x0247
        L_0x0243:
            java.lang.String r1 = r10.V()
        L_0x0247:
            r0.c(r1)
        L_0x024a:
            r1 = 1
            goto L_0x024d
        L_0x024c:
            r1 = 0
        L_0x024d:
            java.lang.String r2 = r11.f4286b
            java.lang.String r6 = r0.v()
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 != 0) goto L_0x025f
            java.lang.String r1 = r11.f4286b
            r0.m(r1)
            r1 = 1
        L_0x025f:
            java.lang.String r2 = r11.r
            java.lang.String r6 = r0.y()
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 != 0) goto L_0x0271
            java.lang.String r1 = r11.r
            r0.q(r1)
            r1 = 1
        L_0x0271:
            boolean r2 = a.d.a.a.h.g.jb.b()
            if (r2 == 0) goto L_0x0299
            a.d.a.a.i.b.c5 r2 = r10.j
            a.d.a.a.i.b.ka r2 = r2.g
            java.lang.String r6 = r0.o()
            a.d.a.a.i.b.n3<java.lang.Boolean> r7 = a.d.a.a.i.b.q.k0
            boolean r2 = r2.t(r6, r7)
            if (r2 == 0) goto L_0x0299
            java.lang.String r2 = r11.v
            java.lang.String r6 = r0.B()
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 != 0) goto L_0x0299
            java.lang.String r1 = r11.v
            r0.u(r1)
            r1 = 1
        L_0x0299:
            java.lang.String r2 = r11.k
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02b3
            java.lang.String r2 = r11.k
            java.lang.String r6 = r0.H()
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x02b3
            java.lang.String r1 = r11.k
            r0.A(r1)
            r1 = 1
        L_0x02b3:
            long r6 = r11.f4289e
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x02c7
            long r8 = r0.P()
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x02c7
            long r1 = r11.f4289e
            r0.t(r1)
            r1 = 1
        L_0x02c7:
            java.lang.String r2 = r11.f4287c
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02e1
            java.lang.String r2 = r11.f4287c
            java.lang.String r6 = r0.M()
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x02e1
            java.lang.String r1 = r11.f4287c
            r0.D(r1)
            r1 = 1
        L_0x02e1:
            long r6 = r11.j
            long r8 = r0.N()
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x02f1
            long r1 = r11.j
            r0.p(r1)
            r1 = 1
        L_0x02f1:
            java.lang.String r2 = r11.f4288d
            if (r2 == 0) goto L_0x0305
            java.lang.String r6 = r0.O()
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0305
            java.lang.String r1 = r11.f4288d
            r0.G(r1)
            r1 = 1
        L_0x0305:
            long r6 = r11.f
            long r8 = r0.Q()
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0315
            long r1 = r11.f
            r0.w(r1)
            r1 = 1
        L_0x0315:
            boolean r2 = r11.h
            boolean r6 = r0.T()
            if (r2 == r6) goto L_0x0323
            boolean r1 = r11.h
            r0.e(r1)
            r1 = 1
        L_0x0323:
            java.lang.String r2 = r11.g
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0344
            java.lang.String r2 = r11.g
            a.d.a.a.i.b.c5 r6 = r0.f2076a
            a.d.a.a.i.b.v4 r6 = r6.f()
            r6.b()
            java.lang.String r6 = r0.D
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0344
            java.lang.String r1 = r11.g
            r0.J(r1)
            r1 = 1
        L_0x0344:
            a.d.a.a.i.b.c5 r2 = r10.j
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.G0
            boolean r2 = r2.o(r6)
            if (r2 != 0) goto L_0x0360
            long r6 = r11.l
            long r8 = r0.g()
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0360
            long r1 = r11.l
            r0.R(r1)
            r1 = 1
        L_0x0360:
            boolean r2 = r11.o
            boolean r6 = r0.h()
            if (r2 == r6) goto L_0x036e
            boolean r1 = r11.o
            r0.n(r1)
            r1 = 1
        L_0x036e:
            boolean r2 = r11.p
            boolean r6 = r0.i()
            if (r2 == r6) goto L_0x037c
            boolean r1 = r11.p
            r0.r(r1)
            r1 = 1
        L_0x037c:
            java.lang.Boolean r2 = r11.s
            java.lang.Boolean r6 = r0.j()
            if (r2 == r6) goto L_0x038a
            java.lang.Boolean r1 = r11.s
            r0.b(r1)
            r1 = 1
        L_0x038a:
            long r6 = r11.t
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x039e
            long r4 = r0.S()
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x039e
            long r1 = r11.t
            r0.z(r1)
            goto L_0x039f
        L_0x039e:
            r3 = r1
        L_0x039f:
            if (r3 == 0) goto L_0x03a8
            a.d.a.a.i.b.d r11 = r10.J()
            r11.I(r0)
        L_0x03a8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.F(com.google.android.gms.measurement.internal.zzn):a.d.a.a.i.b.a4");
    }

    public final w4 G() {
        B(this.f2442a);
        return this.f2442a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:220:0x068a, code lost:
        if (android.text.TextUtils.isEmpty(r3.r) == false) goto L_0x068c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x0995, code lost:
        if (r8.f2181e < ((long) r1.j.b().r(r4.f2284a))) goto L_0x0997;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02f3 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0329 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0363 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0372 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03a7 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x06ad A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x06c1 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0700 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x071c A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x07d9 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x07e6 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0812 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x08e5 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x08fd A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0944 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x099e A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x017f A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0187 A[Catch:{ SQLiteException -> 0x02bb, all -> 0x09ed }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(com.google.android.gms.measurement.internal.zzar r29, com.google.android.gms.measurement.internal.zzn r30) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            r3 = r30
            java.lang.String r4 = "_sno"
            a.c.a.f.b.k(r30)
            java.lang.String r5 = r3.f4285a
            a.c.a.f.b.h(r5)
            long r5 = java.lang.System.nanoTime()
            r28.T()
            r28.O()
            java.lang.String r15 = r3.f4285a
            r28.M()
            boolean r7 = a.d.a.a.i.b.s9.O(r29, r30)
            if (r7 != 0) goto L_0x0026
            return
        L_0x0026:
            boolean r7 = r3.h
            if (r7 != 0) goto L_0x002e
            r1.F(r3)
            return
        L_0x002e:
            a.d.a.a.i.b.w4 r7 = r28.G()
            java.lang.String r8 = r2.f4276a
            boolean r7 = r7.x(r15, r8)
            java.lang.String r14 = "_ev"
            java.lang.String r13 = "_err"
            r18 = 1
            r11 = 0
            r12 = 0
            if (r7 == 0) goto L_0x00db
            a.d.a.a.i.b.c5 r3 = r1.j
            a.d.a.a.i.b.x3 r3 = r3.i()
            a.d.a.a.i.b.z3 r3 = r3.A()
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r15)
            a.d.a.a.i.b.c5 r5 = r1.j
            a.d.a.a.i.b.v3 r5 = r5.u()
            java.lang.String r6 = r2.f4276a
            java.lang.String r5 = r5.u(r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.c(r6, r4, r5)
            a.d.a.a.i.b.w4 r3 = r28.G()
            boolean r3 = r3.C(r15)
            if (r3 != 0) goto L_0x0078
            a.d.a.a.i.b.w4 r3 = r28.G()
            boolean r3 = r3.D(r15)
            if (r3 == 0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r18 = 0
        L_0x0078:
            if (r18 != 0) goto L_0x008f
            java.lang.String r3 = r2.f4276a
            boolean r3 = r13.equals(r3)
            if (r3 != 0) goto L_0x008f
            a.d.a.a.i.b.c5 r3 = r1.j
            a.d.a.a.i.b.v9 r3 = r3.t()
            r4 = 11
            java.lang.String r2 = r2.f4276a
            r3.f0(r4, r14, r2, r12)
        L_0x008f:
            if (r18 == 0) goto L_0x00da
            a.d.a.a.i.b.d r2 = r28.J()
            a.d.a.a.i.b.a4 r2 = r2.T(r15)
            if (r2 == 0) goto L_0x00da
            long r3 = r2.W()
            long r5 = r2.V()
            long r3 = java.lang.Math.max(r3, r5)
            a.d.a.a.i.b.c5 r5 = r1.j
            a.d.a.a.e.q.b r5 = r5.g()
            a.d.a.a.e.q.c r5 = (a.d.a.a.e.q.c) r5
            long r5 = r5.a()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            a.d.a.a.i.b.n3<java.lang.Long> r5 = a.d.a.a.i.b.q.z
            java.lang.Object r5 = r5.a(r11)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00da
            a.d.a.a.i.b.c5 r3 = r1.j
            a.d.a.a.i.b.x3 r3 = r3.i()
            a.d.a.a.i.b.z3 r3 = r3.C()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.a(r4)
            r1.l(r2)
        L_0x00da:
            return
        L_0x00db:
            boolean r7 = a.d.a.a.h.g.t9.b()
            if (r7 == 0) goto L_0x010a
            a.d.a.a.i.b.c5 r7 = r1.j
            a.d.a.a.i.b.ka r7 = r7.b()
            a.d.a.a.i.b.n3<java.lang.Boolean> r8 = a.d.a.a.i.b.q.E0
            boolean r7 = r7.o(r8)
            if (r7 == 0) goto L_0x010a
            a.d.a.a.i.b.c4 r2 = a.d.a.a.i.b.c4.b(r29)
            a.d.a.a.i.b.c5 r7 = r1.j
            a.d.a.a.i.b.v9 r7 = r7.t()
            a.d.a.a.i.b.c5 r8 = r1.j
            a.d.a.a.i.b.ka r8 = r8.b()
            int r8 = r8.l(r15)
            r7.Q(r2, r8)
            com.google.android.gms.measurement.internal.zzar r2 = r2.a()
        L_0x010a:
            a.d.a.a.i.b.c5 r7 = r1.j
            a.d.a.a.i.b.x3 r7 = r7.i()
            r8 = 2
            boolean r7 = r7.x(r8)
            if (r7 == 0) goto L_0x0130
            a.d.a.a.i.b.c5 r7 = r1.j
            a.d.a.a.i.b.x3 r7 = r7.i()
            a.d.a.a.i.b.z3 r7 = r7.D()
            a.d.a.a.i.b.c5 r9 = r1.j
            a.d.a.a.i.b.v3 r9 = r9.u()
            java.lang.String r9 = r9.t(r2)
            java.lang.String r10 = "Logging event"
            r7.b(r10, r9)
        L_0x0130:
            a.d.a.a.i.b.d r7 = r28.J()
            r7.b0()
            r1.F(r3)     // Catch:{ all -> 0x09ed }
            boolean r7 = a.d.a.a.h.g.aa.b()     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0150
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r7 = r7.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r9 = a.d.a.a.i.b.q.D0     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.o(r9)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0150
            r7 = 1
            goto L_0x0151
        L_0x0150:
            r7 = 0
        L_0x0151:
            java.lang.String r9 = "ecommerce_purchase"
            java.lang.String r10 = r2.f4276a     // Catch:{ all -> 0x09ed }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x09ed }
            java.lang.String r10 = "refund"
            if (r9 != 0) goto L_0x0174
            if (r7 == 0) goto L_0x0172
            java.lang.String r7 = "purchase"
            java.lang.String r9 = r2.f4276a     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x0174
            java.lang.String r7 = r2.f4276a     // Catch:{ all -> 0x09ed }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0172
            goto L_0x0174
        L_0x0172:
            r7 = 0
            goto L_0x0175
        L_0x0174:
            r7 = 1
        L_0x0175:
            java.lang.String r9 = "_iap"
            java.lang.String r11 = r2.f4276a     // Catch:{ all -> 0x09ed }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x09ed }
            if (r9 != 0) goto L_0x0184
            if (r7 == 0) goto L_0x0182
            goto L_0x0184
        L_0x0182:
            r9 = 0
            goto L_0x0185
        L_0x0184:
            r9 = 1
        L_0x0185:
            if (r9 == 0) goto L_0x0338
            com.google.android.gms.measurement.internal.zzam r9 = r2.f4277b     // Catch:{ all -> 0x09ed }
            java.lang.String r11 = "currency"
            java.lang.String r9 = r9.n(r11)     // Catch:{ all -> 0x09ed }
            java.lang.String r11 = "value"
            if (r7 == 0) goto L_0x020f
            com.google.android.gms.measurement.internal.zzam r7 = r2.f4277b     // Catch:{ all -> 0x09ed }
            java.lang.Double r7 = r7.m(r11)     // Catch:{ all -> 0x09ed }
            double r19 = r7.doubleValue()     // Catch:{ all -> 0x09ed }
            r21 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r19 = r19 * r21
            r23 = 0
            int r7 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r7 != 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.zzam r7 = r2.f4277b     // Catch:{ all -> 0x09ed }
            java.lang.Long r7 = r7.l(r11)     // Catch:{ all -> 0x09ed }
            r17 = r13
            long r12 = r7.longValue()     // Catch:{ all -> 0x09ed }
            double r11 = (double) r12
            java.lang.Double.isNaN(r11)
            java.lang.Double.isNaN(r11)
            double r19 = r11 * r21
            goto L_0x01c2
        L_0x01c0:
            r17 = r13
        L_0x01c2:
            r11 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x01f0
            r11 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x01f0
            long r11 = java.lang.Math.round(r19)     // Catch:{ all -> 0x09ed }
            boolean r7 = a.d.a.a.h.g.aa.b()     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x021b
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r7 = r7.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r13 = a.d.a.a.i.b.q.D0     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.o(r13)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x021b
            java.lang.String r7 = r2.f4276a     // Catch:{ all -> 0x09ed }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x021b
            long r11 = -r11
            goto L_0x021b
        L_0x01f0:
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r7 = r7.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r7 = r7.A()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r15)     // Catch:{ all -> 0x09ed }
            java.lang.Double r10 = java.lang.Double.valueOf(r19)     // Catch:{ all -> 0x09ed }
            r7.c(r8, r9, r10)     // Catch:{ all -> 0x09ed }
            r24 = r5
            r26 = r17
            r5 = 0
            r12 = 0
            goto L_0x0327
        L_0x020f:
            r17 = r13
            com.google.android.gms.measurement.internal.zzam r7 = r2.f4277b     // Catch:{ all -> 0x09ed }
            java.lang.Long r7 = r7.l(r11)     // Catch:{ all -> 0x09ed }
            long r11 = r7.longValue()     // Catch:{ all -> 0x09ed }
        L_0x021b:
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x0321
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r9.toUpperCase(r7)     // Catch:{ all -> 0x09ed }
            java.lang.String r9 = "[A-Z]{3}"
            boolean r9 = r7.matches(r9)     // Catch:{ all -> 0x09ed }
            if (r9 == 0) goto L_0x0321
            java.lang.String r9 = "_ltv_"
            int r10 = r7.length()     // Catch:{ all -> 0x09ed }
            if (r10 == 0) goto L_0x023c
            java.lang.String r7 = r9.concat(r7)     // Catch:{ all -> 0x09ed }
            goto L_0x0241
        L_0x023c:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x09ed }
            r7.<init>(r9)     // Catch:{ all -> 0x09ed }
        L_0x0241:
            r10 = r7
            a.d.a.a.i.b.d r7 = r28.J()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.w9 r7 = r7.Y(r15, r10)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0281
            java.lang.Object r9 = r7.f2610e     // Catch:{ all -> 0x09ed }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x09ed }
            if (r9 != 0) goto L_0x0253
            goto L_0x0281
        L_0x0253:
            java.lang.Object r7 = r7.f2610e     // Catch:{ all -> 0x09ed }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x09ed }
            long r7 = r7.longValue()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.w9 r19 = new a.d.a.a.i.b.w9     // Catch:{ all -> 0x09ed }
            java.lang.String r9 = r2.f4278c     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r13 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.e.q.b r13 = r13.g()     // Catch:{ all -> 0x09ed }
            a.d.a.a.e.q.c r13 = (a.d.a.a.e.q.c) r13
            long r20 = r13.a()     // Catch:{ all -> 0x09ed }
            long r7 = r7 + r11
            java.lang.Long r13 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09ed }
            r7 = r19
            r8 = r15
            r24 = r5
            r5 = 0
            r6 = 0
            r11 = r20
            r26 = r17
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09ed }
            r6 = r19
            goto L_0x02e9
        L_0x0281:
            r24 = r5
            r26 = r17
            r5 = 0
            r6 = 0
            a.d.a.a.i.b.d r7 = r28.J()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r9 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r9 = r9.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Integer> r13 = a.d.a.a.i.b.q.E     // Catch:{ all -> 0x09ed }
            int r9 = r9.q(r15, r13)     // Catch:{ all -> 0x09ed }
            int r9 = r9 + -1
            a.c.a.f.b.h(r15)     // Catch:{ all -> 0x09ed }
            r7.b()     // Catch:{ all -> 0x09ed }
            r7.n()     // Catch:{ all -> 0x09ed }
            android.database.sqlite.SQLiteDatabase r13 = r7.t()     // Catch:{ SQLiteException -> 0x02bb }
            java.lang.String r6 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r8 = 3
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x02bb }
            r8[r5] = r15     // Catch:{ SQLiteException -> 0x02bb }
            r8[r18] = r15     // Catch:{ SQLiteException -> 0x02bb }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x02bb }
            r16 = 2
            r8[r16] = r9     // Catch:{ SQLiteException -> 0x02bb }
            r13.execSQL(r6, r8)     // Catch:{ SQLiteException -> 0x02bb }
            goto L_0x02ce
        L_0x02bb:
            r0 = move-exception
            r6 = r0
            a.d.a.a.i.b.x3 r7 = r7.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r7 = r7.z()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r15)     // Catch:{ all -> 0x09ed }
            r7.c(r8, r9, r6)     // Catch:{ all -> 0x09ed }
        L_0x02ce:
            a.d.a.a.i.b.w9 r6 = new a.d.a.a.i.b.w9     // Catch:{ all -> 0x09ed }
            java.lang.String r9 = r2.f4278c     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.e.q.b r7 = r7.g()     // Catch:{ all -> 0x09ed }
            a.d.a.a.e.q.c r7 = (a.d.a.a.e.q.c) r7
            long r16 = r7.a()     // Catch:{ all -> 0x09ed }
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x09ed }
            r7 = r6
            r8 = r15
            r11 = r16
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09ed }
        L_0x02e9:
            a.d.a.a.i.b.d r7 = r28.J()     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.M(r6)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x0326
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r7 = r7.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r7 = r7.z()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r15)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r10 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v3 r10 = r10.u()     // Catch:{ all -> 0x09ed }
            java.lang.String r11 = r6.f2608c     // Catch:{ all -> 0x09ed }
            java.lang.String r10 = r10.y(r11)     // Catch:{ all -> 0x09ed }
            java.lang.Object r6 = r6.f2610e     // Catch:{ all -> 0x09ed }
            r7.d(r8, r9, r10, r6)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r6 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v9 r6 = r6.t()     // Catch:{ all -> 0x09ed }
            r7 = 9
            r8 = 0
            r6.f0(r7, r8, r8, r5)     // Catch:{ all -> 0x09ed }
            goto L_0x0326
        L_0x0321:
            r24 = r5
            r26 = r17
            r5 = 0
        L_0x0326:
            r12 = 1
        L_0x0327:
            if (r12 != 0) goto L_0x033d
            a.d.a.a.i.b.d r2 = r28.J()     // Catch:{ all -> 0x09ed }
            r2.s()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r2 = r28.J()
            r2.e0()
            return
        L_0x0338:
            r24 = r5
            r26 = r13
            r5 = 0
        L_0x033d:
            java.lang.String r6 = r2.f4276a     // Catch:{ all -> 0x09ed }
            boolean r6 = a.d.a.a.i.b.v9.V(r6)     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r2.f4276a     // Catch:{ all -> 0x09ed }
            r8 = r26
            boolean r20 = r8.equals(r7)     // Catch:{ all -> 0x09ed }
            boolean r7 = a.d.a.a.h.g.aa.b()     // Catch:{ all -> 0x09ed }
            r21 = 1
            if (r7 == 0) goto L_0x0372
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r7 = r7.b()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.f4285a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r9 = a.d.a.a.i.b.q.z0     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.u(r8, r9)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0372
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            r7.t()     // Catch:{ all -> 0x09ed }
            com.google.android.gms.measurement.internal.zzam r7 = r2.f4277b     // Catch:{ all -> 0x09ed }
            long r7 = a.d.a.a.i.b.v9.v(r7)     // Catch:{ all -> 0x09ed }
            long r7 = r7 + r21
            r11 = r7
            goto L_0x0374
        L_0x0372:
            r11 = r21
        L_0x0374:
            a.d.a.a.i.b.d r7 = r28.J()     // Catch:{ all -> 0x09ed }
            long r8 = r28.U()     // Catch:{ all -> 0x09ed }
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r5 = r14
            r14 = r6
            r29 = r15
            r15 = r16
            r16 = r20
            a.d.a.a.i.b.f r7 = r7.x(r8, r10, r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x09ed }
            long r8 = r7.f2178b     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Integer> r10 = a.d.a.a.i.b.q.k     // Catch:{ all -> 0x09ed }
            r11 = 0
            java.lang.Object r10 = r10.a(r11)     // Catch:{ all -> 0x09ed }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x09ed }
            int r10 = r10.intValue()     // Catch:{ all -> 0x09ed }
            long r10 = (long) r10     // Catch:{ all -> 0x09ed }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r14 = 0
            int r12 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x03d4
            long r8 = r8 % r10
            int r2 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x03c5
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r2 = r2.z()     // Catch:{ all -> 0x09ed }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r29)     // Catch:{ all -> 0x09ed }
            long r5 = r7.f2178b     // Catch:{ all -> 0x09ed }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09ed }
            r2.c(r3, r4, r5)     // Catch:{ all -> 0x09ed }
        L_0x03c5:
            a.d.a.a.i.b.d r2 = r28.J()     // Catch:{ all -> 0x09ed }
            r2.s()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r2 = r28.J()
            r2.e0()
            return
        L_0x03d4:
            if (r6 == 0) goto L_0x0426
            long r8 = r7.f2177a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Integer> r12 = a.d.a.a.i.b.q.m     // Catch:{ all -> 0x09ed }
            r13 = 0
            java.lang.Object r12 = r12.a(r13)     // Catch:{ all -> 0x09ed }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x09ed }
            int r12 = r12.intValue()     // Catch:{ all -> 0x09ed }
            long r12 = (long) r12     // Catch:{ all -> 0x09ed }
            long r8 = r8 - r12
            int r12 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x0426
            long r8 = r8 % r10
            int r3 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r3 != 0) goto L_0x0409
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r3 = r3.z()     // Catch:{ all -> 0x09ed }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r6 = a.d.a.a.i.b.x3.s(r29)     // Catch:{ all -> 0x09ed }
            long r7 = r7.f2177a     // Catch:{ all -> 0x09ed }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09ed }
            r3.c(r4, r6, r7)     // Catch:{ all -> 0x09ed }
        L_0x0409:
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v9 r3 = r3.t()     // Catch:{ all -> 0x09ed }
            r4 = 16
            java.lang.String r2 = r2.f4276a     // Catch:{ all -> 0x09ed }
            r6 = 0
            r3.f0(r4, r5, r2, r6)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r2 = r28.J()     // Catch:{ all -> 0x09ed }
            r2.s()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r2 = r28.J()
            r2.e0()
            return
        L_0x0426:
            if (r20 == 0) goto L_0x0476
            long r8 = r7.f2180d     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r5 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r5 = r5.b()     // Catch:{ all -> 0x09ed }
            java.lang.String r10 = r3.f4285a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Integer> r11 = a.d.a.a.i.b.q.l     // Catch:{ all -> 0x09ed }
            int r5 = r5.q(r10, r11)     // Catch:{ all -> 0x09ed }
            r10 = 1000000(0xf4240, float:1.401298E-39)
            int r5 = java.lang.Math.min(r10, r5)     // Catch:{ all -> 0x09ed }
            r10 = 0
            int r5 = java.lang.Math.max(r10, r5)     // Catch:{ all -> 0x09ed }
            long r10 = (long) r5     // Catch:{ all -> 0x09ed }
            long r8 = r8 - r10
            int r5 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r5 <= 0) goto L_0x0476
            int r2 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x0467
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r2 = r2.z()     // Catch:{ all -> 0x09ed }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r29)     // Catch:{ all -> 0x09ed }
            long r5 = r7.f2180d     // Catch:{ all -> 0x09ed }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09ed }
            r2.c(r3, r4, r5)     // Catch:{ all -> 0x09ed }
        L_0x0467:
            a.d.a.a.i.b.d r2 = r28.J()     // Catch:{ all -> 0x09ed }
            r2.s()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r2 = r28.J()
            r2.e0()
            return
        L_0x0476:
            com.google.android.gms.measurement.internal.zzam r5 = r2.f4277b     // Catch:{ all -> 0x09ed }
            android.os.Bundle r5 = r5.h()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v9 r7 = r7.t()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.f4278c     // Catch:{ all -> 0x09ed }
            r7.I(r5, r8, r9)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v9 r7 = r7.t()     // Catch:{ all -> 0x09ed }
            r12 = r29
            boolean r7 = r7.t0(r12)     // Catch:{ all -> 0x09ed }
            java.lang.String r13 = "_r"
            if (r7 == 0) goto L_0x04b5
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v9 r7 = r7.t()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r21)     // Catch:{ all -> 0x09ed }
            r7.I(r5, r8, r9)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v9 r7 = r7.t()     // Catch:{ all -> 0x09ed }
            java.lang.Long r8 = java.lang.Long.valueOf(r21)     // Catch:{ all -> 0x09ed }
            r7.I(r5, r13, r8)     // Catch:{ all -> 0x09ed }
        L_0x04b5:
            java.lang.String r7 = "_s"
            java.lang.String r8 = r2.f4276a     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x04dc
            a.d.a.a.i.b.d r7 = r28.J()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.f4285a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.w9 r7 = r7.Y(r8, r4)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x04dc
            java.lang.Object r8 = r7.f2610e     // Catch:{ all -> 0x09ed }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x04dc
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v9 r8 = r8.t()     // Catch:{ all -> 0x09ed }
            java.lang.Object r7 = r7.f2610e     // Catch:{ all -> 0x09ed }
            r8.I(r5, r4, r7)     // Catch:{ all -> 0x09ed }
        L_0x04dc:
            a.d.a.a.i.b.d r4 = r28.J()     // Catch:{ all -> 0x09ed }
            long r7 = r4.X(r12)     // Catch:{ all -> 0x09ed }
            int r4 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x04ff
            a.d.a.a.i.b.c5 r4 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r4 = r4.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r4 = r4.A()     // Catch:{ all -> 0x09ed }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = a.d.a.a.i.b.x3.s(r12)     // Catch:{ all -> 0x09ed }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09ed }
            r4.c(r9, r10, r7)     // Catch:{ all -> 0x09ed }
        L_0x04ff:
            a.d.a.a.i.b.j r4 = new a.d.a.a.i.b.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            java.lang.String r9 = r2.f4278c     // Catch:{ all -> 0x09ed }
            java.lang.String r11 = r2.f4276a     // Catch:{ all -> 0x09ed }
            long r14 = r2.f4279d     // Catch:{ all -> 0x09ed }
            r20 = 0
            r7 = r4
            r10 = r12
            r2 = r12
            r27 = r13
            r12 = r14
            r14 = r20
            r16 = r5
            r7.<init>((a.d.a.a.i.b.c5) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r5 = r28.J()     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r4.f2285b     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.l r5 = r5.z(r2, r7)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x058a
            a.d.a.a.i.b.d r5 = r28.J()     // Catch:{ all -> 0x09ed }
            long r7 = r5.f0(r2)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r5 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r5 = r5.b()     // Catch:{ all -> 0x09ed }
            int r5 = r5.p(r2)     // Catch:{ all -> 0x09ed }
            long r9 = (long) r5     // Catch:{ all -> 0x09ed }
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x057f
            if (r6 == 0) goto L_0x057f
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r3 = r3.z()     // Catch:{ all -> 0x09ed }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = a.d.a.a.i.b.x3.s(r2)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v3 r7 = r7.u()     // Catch:{ all -> 0x09ed }
            java.lang.String r4 = r4.f2285b     // Catch:{ all -> 0x09ed }
            java.lang.String r4 = r7.u(r4)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r7 = r7.b()     // Catch:{ all -> 0x09ed }
            int r2 = r7.p(r2)     // Catch:{ all -> 0x09ed }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x09ed }
            r3.d(r5, r6, r4, r2)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.v9 r2 = r2.t()     // Catch:{ all -> 0x09ed }
            r3 = 8
            r4 = 0
            r6 = 0
            r2.f0(r3, r4, r4, r6)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r2 = r28.J()
            r2.e0()
            return
        L_0x057f:
            r6 = 0
            a.d.a.a.i.b.l r5 = new a.d.a.a.i.b.l     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r4.f2285b     // Catch:{ all -> 0x09ed }
            long r8 = r4.f2287d     // Catch:{ all -> 0x09ed }
            r5.<init>(r2, r7, r8)     // Catch:{ all -> 0x09ed }
            goto L_0x0599
        L_0x058a:
            r6 = 0
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x09ed }
            long r7 = r5.f     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.j r4 = r4.a(r2, r7)     // Catch:{ all -> 0x09ed }
            long r7 = r4.f2287d     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.l r5 = r5.a(r7)     // Catch:{ all -> 0x09ed }
        L_0x0599:
            a.d.a.a.i.b.d r2 = r28.J()     // Catch:{ all -> 0x09ed }
            r2.H(r5)     // Catch:{ all -> 0x09ed }
            r28.T()     // Catch:{ all -> 0x09ed }
            r28.O()     // Catch:{ all -> 0x09ed }
            a.c.a.f.b.k(r4)     // Catch:{ all -> 0x09ed }
            a.c.a.f.b.k(r30)     // Catch:{ all -> 0x09ed }
            java.lang.String r2 = r4.f2284a     // Catch:{ all -> 0x09ed }
            a.c.a.f.b.h(r2)     // Catch:{ all -> 0x09ed }
            java.lang.String r2 = r4.f2284a     // Catch:{ all -> 0x09ed }
            java.lang.String r5 = r3.f4285a     // Catch:{ all -> 0x09ed }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x09ed }
            a.c.a.f.b.d(r2)     // Catch:{ all -> 0x09ed }
            a.d.a.a.h.g.b1$a r2 = a.d.a.a.h.g.b1.C()     // Catch:{ all -> 0x09ed }
            r2.n()     // Catch:{ all -> 0x09ed }
            java.lang.String r5 = "android"
            r2.v(r5)     // Catch:{ all -> 0x09ed }
            java.lang.String r5 = r3.f4285a     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x05d5
            java.lang.String r5 = r3.f4285a     // Catch:{ all -> 0x09ed }
            r2.U(r5)     // Catch:{ all -> 0x09ed }
        L_0x05d5:
            java.lang.String r5 = r3.f4288d     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x05e2
            java.lang.String r5 = r3.f4288d     // Catch:{ all -> 0x09ed }
            r2.Q(r5)     // Catch:{ all -> 0x09ed }
        L_0x05e2:
            java.lang.String r5 = r3.f4287c     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x05ef
            java.lang.String r5 = r3.f4287c     // Catch:{ all -> 0x09ed }
            r2.Y(r5)     // Catch:{ all -> 0x09ed }
        L_0x05ef:
            long r7 = r3.j     // Catch:{ all -> 0x09ed }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x05fe
            long r7 = r3.j     // Catch:{ all -> 0x09ed }
            int r5 = (int) r7     // Catch:{ all -> 0x09ed }
            r2.a0(r5)     // Catch:{ all -> 0x09ed }
        L_0x05fe:
            long r7 = r3.f4289e     // Catch:{ all -> 0x09ed }
            r2.T(r7)     // Catch:{ all -> 0x09ed }
            java.lang.String r5 = r3.f4286b     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x0610
            java.lang.String r5 = r3.f4286b     // Catch:{ all -> 0x09ed }
            r2.l0(r5)     // Catch:{ all -> 0x09ed }
        L_0x0610:
            boolean r5 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x0643
            a.d.a.a.i.b.c5 r5 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r5 = r5.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r7 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x09ed }
            boolean r5 = r5.o(r7)     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x0643
            java.lang.String r5 = r3.f4285a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.e r5 = r1.a(r5)     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r3.w     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.e r7 = a.d.a.a.i.b.e.b(r7)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.e r5 = r5.h(r7)     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r3.w     // Catch:{ all -> 0x09ed }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x0643
            java.lang.String r5 = r5.d()     // Catch:{ all -> 0x09ed }
            r2.v0(r5)     // Catch:{ all -> 0x09ed }
        L_0x0643:
            boolean r5 = a.d.a.a.h.g.jb.b()     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x068f
            a.d.a.a.i.b.c5 r5 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r5 = r5.b()     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r3.f4285a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r8 = a.d.a.a.i.b.q.k0     // Catch:{ all -> 0x09ed }
            boolean r5 = r5.u(r7, r8)     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x068f
            java.lang.String r5 = r2.r0()     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x0670
            java.lang.String r5 = r3.v     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x0670
            java.lang.String r5 = r3.v     // Catch:{ all -> 0x09ed }
            r2.t0(r5)     // Catch:{ all -> 0x09ed }
        L_0x0670:
            java.lang.String r5 = r2.r0()     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x06a5
            java.lang.String r5 = r2.w0()     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x06a5
            java.lang.String r5 = r3.r     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x06a5
        L_0x068c:
            java.lang.String r5 = r3.r     // Catch:{ all -> 0x09ed }
            goto L_0x06a2
        L_0x068f:
            java.lang.String r5 = r2.r0()     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x06a5
            java.lang.String r5 = r3.r     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x06a5
            goto L_0x068c
        L_0x06a2:
            r2.q0(r5)     // Catch:{ all -> 0x09ed }
        L_0x06a5:
            long r7 = r3.f     // Catch:{ all -> 0x09ed }
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x06b2
            long r7 = r3.f     // Catch:{ all -> 0x09ed }
            r2.b0(r7)     // Catch:{ all -> 0x09ed }
        L_0x06b2:
            long r7 = r3.t     // Catch:{ all -> 0x09ed }
            r2.k0(r7)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.s9 r5 = r28.M()     // Catch:{ all -> 0x09ed }
            java.util.List r5 = r5.U()     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x06c4
            r2.J(r5)     // Catch:{ all -> 0x09ed }
        L_0x06c4:
            java.lang.String r5 = r3.f4285a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.e r5 = r1.a(r5)     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r3.w     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.e r7 = a.d.a.a.i.b.e.b(r7)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.e r5 = r5.h(r7)     // Catch:{ all -> 0x09ed }
            boolean r7 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x06ee
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r7 = r7.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r8 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.o(r8)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x06ee
            boolean r7 = r5.j()     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0794
        L_0x06ee:
            a.d.a.a.i.b.u8 r7 = r1.i     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.f4285a     // Catch:{ all -> 0x09ed }
            android.util.Pair r7 = r7.s(r8, r5)     // Catch:{ all -> 0x09ed }
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x09ed }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x09ed }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x09ed }
            if (r8 != 0) goto L_0x071c
            boolean r8 = r3.o     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x0794
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x09ed }
            r2.c0(r8)     // Catch:{ all -> 0x09ed }
            java.lang.Object r8 = r7.second     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x0794
            java.lang.Object r7 = r7.second     // Catch:{ all -> 0x09ed }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x09ed }
            r2.w(r7)     // Catch:{ all -> 0x09ed }
            goto L_0x0794
        L_0x071c:
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.k r7 = r7.y()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            android.content.Context r8 = r8.j()     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.s(r8)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x0794
            boolean r7 = r3.p     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0794
            boolean r7 = a.d.a.a.h.g.oc.b()     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0748
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r7 = r7.b()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.f4285a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.O0     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.u(r8, r11)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x0794
        L_0x0748:
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            android.content.Context r7 = r7.j()     // Catch:{ all -> 0x09ed }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r8)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x0774
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r7 = r7.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r7 = r7.A()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = "null secure ID. appId"
            java.lang.String r11 = r2.j0()     // Catch:{ all -> 0x09ed }
            java.lang.Object r11 = a.d.a.a.i.b.x3.s(r11)     // Catch:{ all -> 0x09ed }
            r7.b(r8, r11)     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = "null"
            goto L_0x0791
        L_0x0774:
            boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x0791
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r8 = r8.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r8 = r8.A()     // Catch:{ all -> 0x09ed }
            java.lang.String r11 = "empty secure ID. appId"
            java.lang.String r12 = r2.j0()     // Catch:{ all -> 0x09ed }
            java.lang.Object r12 = a.d.a.a.i.b.x3.s(r12)     // Catch:{ all -> 0x09ed }
            r8.b(r11, r12)     // Catch:{ all -> 0x09ed }
        L_0x0791:
            r2.n0(r7)     // Catch:{ all -> 0x09ed }
        L_0x0794:
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.k r7 = r7.y()     // Catch:{ all -> 0x09ed }
            r7.n()     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x09ed }
            r2.H(r7)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.k r7 = r7.y()     // Catch:{ all -> 0x09ed }
            r7.n()     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x09ed }
            r2.B(r7)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.k r7 = r7.y()     // Catch:{ all -> 0x09ed }
            long r7 = r7.t()     // Catch:{ all -> 0x09ed }
            int r8 = (int) r7     // Catch:{ all -> 0x09ed }
            r2.S(r8)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.k r7 = r7.y()     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r7.u()     // Catch:{ all -> 0x09ed }
            r2.K(r7)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r7 = r7.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r8 = a.d.a.a.i.b.q.G0     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.o(r8)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x07de
            long r7 = r3.l     // Catch:{ all -> 0x09ed }
            r2.h0(r7)     // Catch:{ all -> 0x09ed }
        L_0x07de:
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.d()     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0806
            boolean r7 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x07f7
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r7 = r7.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r8 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x09ed }
            r7.o(r8)     // Catch:{ all -> 0x09ed }
        L_0x07f7:
            r2.j0()     // Catch:{ all -> 0x09ed }
            r7 = 0
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x0802
            goto L_0x0806
        L_0x0802:
            r2.p0()     // Catch:{ all -> 0x09ed }
            throw r7
        L_0x0806:
            a.d.a.a.i.b.d r7 = r28.J()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.f4285a     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.a4 r7 = r7.T(r8)     // Catch:{ all -> 0x09ed }
            if (r7 != 0) goto L_0x08b0
            a.d.a.a.i.b.a4 r7 = new a.d.a.a.i.b.a4     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            java.lang.String r11 = r3.f4285a     // Catch:{ all -> 0x09ed }
            r7.<init>(r8, r11)     // Catch:{ all -> 0x09ed }
            boolean r8 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x0834
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r8 = r8.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x09ed }
            boolean r8 = r8.o(r11)     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x0834
            java.lang.String r8 = r1.c(r5)     // Catch:{ all -> 0x09ed }
            goto L_0x0838
        L_0x0834:
            java.lang.String r8 = r28.V()     // Catch:{ all -> 0x09ed }
        L_0x0838:
            r7.c(r8)     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.k     // Catch:{ all -> 0x09ed }
            r7.A(r8)     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.f4286b     // Catch:{ all -> 0x09ed }
            r7.m(r8)     // Catch:{ all -> 0x09ed }
            boolean r8 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x085f
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r8 = r8.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x09ed }
            boolean r8 = r8.o(r11)     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x085f
            boolean r8 = r5.j()     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x086a
        L_0x085f:
            a.d.a.a.i.b.u8 r8 = r1.i     // Catch:{ all -> 0x09ed }
            java.lang.String r11 = r3.f4285a     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r8.t(r11)     // Catch:{ all -> 0x09ed }
            r7.x(r8)     // Catch:{ all -> 0x09ed }
        L_0x086a:
            r7.C(r9)     // Catch:{ all -> 0x09ed }
            r7.a(r9)     // Catch:{ all -> 0x09ed }
            r7.l(r9)     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.f4287c     // Catch:{ all -> 0x09ed }
            r7.D(r8)     // Catch:{ all -> 0x09ed }
            long r11 = r3.j     // Catch:{ all -> 0x09ed }
            r7.p(r11)     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r3.f4288d     // Catch:{ all -> 0x09ed }
            r7.G(r8)     // Catch:{ all -> 0x09ed }
            long r11 = r3.f4289e     // Catch:{ all -> 0x09ed }
            r7.t(r11)     // Catch:{ all -> 0x09ed }
            long r11 = r3.f     // Catch:{ all -> 0x09ed }
            r7.w(r11)     // Catch:{ all -> 0x09ed }
            boolean r8 = r3.h     // Catch:{ all -> 0x09ed }
            r7.e(r8)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r8 = r8.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.G0     // Catch:{ all -> 0x09ed }
            boolean r8 = r8.o(r11)     // Catch:{ all -> 0x09ed }
            if (r8 != 0) goto L_0x08a4
            long r11 = r3.l     // Catch:{ all -> 0x09ed }
            r7.R(r11)     // Catch:{ all -> 0x09ed }
        L_0x08a4:
            long r11 = r3.t     // Catch:{ all -> 0x09ed }
            r7.z(r11)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r8 = r28.J()     // Catch:{ all -> 0x09ed }
            r8.I(r7)     // Catch:{ all -> 0x09ed }
        L_0x08b0:
            boolean r8 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x08ca
            a.d.a.a.i.b.c5 r8 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r8 = r8.b()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x09ed }
            boolean r8 = r8.o(r11)     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x08ca
            boolean r5 = r5.k()     // Catch:{ all -> 0x09ed }
            if (r5 == 0) goto L_0x08db
        L_0x08ca:
            java.lang.String r5 = r7.s()     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x08db
            java.lang.String r5 = r7.s()     // Catch:{ all -> 0x09ed }
            r2.g0(r5)     // Catch:{ all -> 0x09ed }
        L_0x08db:
            java.lang.String r5 = r7.H()     // Catch:{ all -> 0x09ed }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x09ed }
            if (r5 != 0) goto L_0x08ec
            java.lang.String r5 = r7.H()     // Catch:{ all -> 0x09ed }
            r2.m0(r5)     // Catch:{ all -> 0x09ed }
        L_0x08ec:
            a.d.a.a.i.b.d r5 = r28.J()     // Catch:{ all -> 0x09ed }
            java.lang.String r3 = r3.f4285a     // Catch:{ all -> 0x09ed }
            java.util.List r3 = r5.C(r3)     // Catch:{ all -> 0x09ed }
            r12 = 0
        L_0x08f7:
            int r5 = r3.size()     // Catch:{ all -> 0x09ed }
            if (r12 >= r5) goto L_0x092c
            a.d.a.a.h.g.f1$a r5 = a.d.a.a.h.g.f1.v()     // Catch:{ all -> 0x09ed }
            java.lang.Object r7 = r3.get(r12)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.w9 r7 = (a.d.a.a.i.b.w9) r7     // Catch:{ all -> 0x09ed }
            java.lang.String r7 = r7.f2608c     // Catch:{ all -> 0x09ed }
            r5.o(r7)     // Catch:{ all -> 0x09ed }
            java.lang.Object r7 = r3.get(r12)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.w9 r7 = (a.d.a.a.i.b.w9) r7     // Catch:{ all -> 0x09ed }
            long r7 = r7.f2609d     // Catch:{ all -> 0x09ed }
            r5.n(r7)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.s9 r7 = r28.M()     // Catch:{ all -> 0x09ed }
            java.lang.Object r8 = r3.get(r12)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.w9 r8 = (a.d.a.a.i.b.w9) r8     // Catch:{ all -> 0x09ed }
            java.lang.Object r8 = r8.f2610e     // Catch:{ all -> 0x09ed }
            r7.G(r5, r8)     // Catch:{ all -> 0x09ed }
            r2.s(r5)     // Catch:{ all -> 0x09ed }
            int r12 = r12 + 1
            goto L_0x08f7
        L_0x092c:
            a.d.a.a.i.b.d r3 = r28.J()     // Catch:{ IOException -> 0x09a1 }
            a.d.a.a.h.g.i7 r5 = r2.m()     // Catch:{ IOException -> 0x09a1 }
            a.d.a.a.h.g.y5 r5 = (a.d.a.a.h.g.y5) r5     // Catch:{ IOException -> 0x09a1 }
            a.d.a.a.h.g.b1 r5 = (a.d.a.a.h.g.b1) r5     // Catch:{ IOException -> 0x09a1 }
            long r2 = r3.v(r5)     // Catch:{ IOException -> 0x09a1 }
            a.d.a.a.i.b.d r5 = r28.J()     // Catch:{ all -> 0x09ed }
            com.google.android.gms.measurement.internal.zzam r7 = r4.f     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0998
            com.google.android.gms.measurement.internal.zzam r7 = r4.f     // Catch:{ all -> 0x09ed }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x09ed }
        L_0x094a:
            r8 = r7
            a.d.a.a.i.b.n r8 = (a.d.a.a.i.b.n) r8
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x09ed }
            if (r11 == 0) goto L_0x0965
            java.lang.Object r8 = r8.next()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x09ed }
            r11 = r27
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x09ed }
            if (r8 == 0) goto L_0x0962
            goto L_0x0997
        L_0x0962:
            r27 = r11
            goto L_0x094a
        L_0x0965:
            a.d.a.a.i.b.w4 r7 = r28.G()     // Catch:{ all -> 0x09ed }
            java.lang.String r8 = r4.f2284a     // Catch:{ all -> 0x09ed }
            java.lang.String r11 = r4.f2285b     // Catch:{ all -> 0x09ed }
            boolean r7 = r7.y(r8, r11)     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r11 = r28.J()     // Catch:{ all -> 0x09ed }
            long r12 = r28.U()     // Catch:{ all -> 0x09ed }
            java.lang.String r14 = r4.f2284a     // Catch:{ all -> 0x09ed }
            r15 = 0
            r16 = 0
            a.d.a.a.i.b.f r8 = r11.y(r12, r14, r15, r16)     // Catch:{ all -> 0x09ed }
            if (r7 == 0) goto L_0x0998
            long r7 = r8.f2181e     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.c5 r11 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.ka r11 = r11.b()     // Catch:{ all -> 0x09ed }
            java.lang.String r12 = r4.f2284a     // Catch:{ all -> 0x09ed }
            int r11 = r11.r(r12)     // Catch:{ all -> 0x09ed }
            long r11 = (long) r11     // Catch:{ all -> 0x09ed }
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0998
        L_0x0997:
            r6 = 1
        L_0x0998:
            boolean r2 = r5.L(r4, r2, r6)     // Catch:{ all -> 0x09ed }
            if (r2 == 0) goto L_0x09ba
            r1.m = r9     // Catch:{ all -> 0x09ed }
            goto L_0x09ba
        L_0x09a1:
            r0 = move-exception
            r3 = r0
            a.d.a.a.i.b.c5 r4 = r1.j     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.x3 r4 = r4.i()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.z3 r4 = r4.z()     // Catch:{ all -> 0x09ed }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.j0()     // Catch:{ all -> 0x09ed }
            java.lang.Object r2 = a.d.a.a.i.b.x3.s(r2)     // Catch:{ all -> 0x09ed }
            r4.c(r5, r2, r3)     // Catch:{ all -> 0x09ed }
        L_0x09ba:
            a.d.a.a.i.b.d r2 = r28.J()     // Catch:{ all -> 0x09ed }
            r2.s()     // Catch:{ all -> 0x09ed }
            a.d.a.a.i.b.d r2 = r28.J()
            r2.e0()
            r28.v()
            a.d.a.a.i.b.c5 r2 = r1.j
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.D()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r24
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.b(r4, r3)
            return
        L_0x09ed:
            r0 = move-exception
            r2 = r0
            a.d.a.a.i.b.d r3 = r28.J()
            r3.e0()
            goto L_0x09f8
        L_0x09f7:
            throw r2
        L_0x09f8:
            goto L_0x09f7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.H(com.google.android.gms.measurement.internal.zzar, com.google.android.gms.measurement.internal.zzn):void");
    }

    public final b4 I() {
        B(this.f2443b);
        return this.f2443b;
    }

    public final d J() {
        B(this.f2444c);
        return this.f2444c;
    }

    public final boolean K(zzn zzn) {
        return (!jb.b() || !this.j.g.t(zzn.f4285a, q.k0)) ? !TextUtils.isEmpty(zzn.f4286b) || !TextUtils.isEmpty(zzn.r) : !TextUtils.isEmpty(zzn.f4286b) || !TextUtils.isEmpty(zzn.v) || !TextUtils.isEmpty(zzn.r);
    }

    public final ba L() {
        B(this.f);
        return this.f;
    }

    public final s9 M() {
        B(this.g);
        return this.g;
    }

    public final v3 N() {
        return this.j.u();
    }

    public final void O() {
        if (!this.k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:140|141) */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        r1.j.i().f.c("Failed to parse upload URL. Not uploading. appId", a.d.a.a.i.b.x3.s(r3), r2);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:140:0x03af */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0300 A[Catch:{ all -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0311 A[Catch:{ all -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0335 A[Catch:{ MalformedURLException -> 0x03af }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0337 A[Catch:{ MalformedURLException -> 0x03af }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x033f A[Catch:{ MalformedURLException -> 0x03af }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x034d A[Catch:{ MalformedURLException -> 0x03af }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0363 A[Catch:{ MalformedURLException -> 0x03af }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01fb A[Catch:{ all -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01fc A[Catch:{ all -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0202 A[Catch:{ all -> 0x03f5 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void P() {
        /*
            r18 = this;
            r1 = r18
            r18.T()
            r18.O()
            r0 = 1
            r1.s = r0
            r2 = 0
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.u7 r3 = r3.x()     // Catch:{ all -> 0x03f5 }
            java.lang.Boolean r3 = r3.f2550e     // Catch:{ all -> 0x03f5 }
            if (r3 != 0) goto L_0x0021
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.z3 r0 = r0.i     // Catch:{ all -> 0x03f5 }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            goto L_0x0051
        L_0x0021:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x03f5 }
            if (r3 == 0) goto L_0x0032
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ all -> 0x03f5 }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            goto L_0x0051
        L_0x0032:
            long r3 = r1.m     // Catch:{ all -> 0x03f5 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x003b
            goto L_0x006d
        L_0x003b:
            r18.T()     // Catch:{ all -> 0x03f5 }
            java.util.List<java.lang.Long> r3 = r1.v     // Catch:{ all -> 0x03f5 }
            if (r3 == 0) goto L_0x0044
            r3 = 1
            goto L_0x0045
        L_0x0044:
            r3 = 0
        L_0x0045:
            if (r3 == 0) goto L_0x0056
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.z3 r0 = r0.n     // Catch:{ all -> 0x03f5 }
            java.lang.String r3 = "Uploading requested multiple times"
        L_0x0051:
            r0.a(r3)     // Catch:{ all -> 0x03f5 }
            goto L_0x03ed
        L_0x0056:
            a.d.a.a.i.b.b4 r3 = r18.I()     // Catch:{ all -> 0x03f5 }
            boolean r3 = r3.u()     // Catch:{ all -> 0x03f5 }
            if (r3 != 0) goto L_0x0072
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.z3 r0 = r0.n     // Catch:{ all -> 0x03f5 }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.a(r3)     // Catch:{ all -> 0x03f5 }
        L_0x006d:
            r18.v()     // Catch:{ all -> 0x03f5 }
            goto L_0x03ed
        L_0x0072:
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.e.q.b r3 = r3.n     // Catch:{ all -> 0x03f5 }
            a.d.a.a.e.q.c r3 = (a.d.a.a.e.q.c) r3     // Catch:{ all -> 0x03f5 }
            r4 = 0
            if (r3 == 0) goto L_0x03f3
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r3 = r3.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Integer> r9 = a.d.a.a.i.b.q.Q     // Catch:{ all -> 0x03f5 }
            int r3 = r3.q(r4, r9)     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Long> r9 = a.d.a.a.i.b.q.f2469d     // Catch:{ all -> 0x03f5 }
            java.lang.Object r9 = r9.a(r4)     // Catch:{ all -> 0x03f5 }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ all -> 0x03f5 }
            long r9 = r9.longValue()     // Catch:{ all -> 0x03f5 }
            long r9 = r7 - r9
            r11 = 0
        L_0x0098:
            if (r11 >= r3) goto L_0x00a3
            boolean r12 = r1.s(r9)     // Catch:{ all -> 0x03f5 }
            if (r12 == 0) goto L_0x00a3
            int r11 = r11 + 1
            goto L_0x0098
        L_0x00a3:
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.k4 r3 = r3.o()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.o4 r3 = r3.f2317e     // Catch:{ all -> 0x03f5 }
            long r9 = r3.a()     // Catch:{ all -> 0x03f5 }
            int r3 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00ca
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.z3 r3 = r3.m     // Catch:{ all -> 0x03f5 }
            java.lang.String r5 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r9 = r7 - r9
            long r9 = java.lang.Math.abs(r9)     // Catch:{ all -> 0x03f5 }
            java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x03f5 }
            r3.b(r5, r6)     // Catch:{ all -> 0x03f5 }
        L_0x00ca:
            a.d.a.a.i.b.d r3 = r18.J()     // Catch:{ all -> 0x03f5 }
            java.lang.String r3 = r3.u()     // Catch:{ all -> 0x03f5 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x03f5 }
            r9 = -1
            if (r5 != 0) goto L_0x03c1
            long r5 = r1.x     // Catch:{ all -> 0x03f5 }
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x00ea
            a.d.a.a.i.b.d r5 = r18.J()     // Catch:{ all -> 0x03f5 }
            long r5 = r5.j0()     // Catch:{ all -> 0x03f5 }
            r1.x = r5     // Catch:{ all -> 0x03f5 }
        L_0x00ea:
            a.d.a.a.i.b.c5 r5 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r5 = r5.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Integer> r6 = a.d.a.a.i.b.q.g     // Catch:{ all -> 0x03f5 }
            int r5 = r5.q(r3, r6)     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.c5 r6 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r6 = r6.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Integer> r9 = a.d.a.a.i.b.q.h     // Catch:{ all -> 0x03f5 }
            int r6 = r6.q(r3, r9)     // Catch:{ all -> 0x03f5 }
            int r6 = java.lang.Math.max(r2, r6)     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.d r9 = r18.J()     // Catch:{ all -> 0x03f5 }
            java.util.List r5 = r9.D(r3, r5, r6)     // Catch:{ all -> 0x03f5 }
            boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x03f5 }
            if (r6 != 0) goto L_0x03ec
            boolean r6 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x03f5 }
            if (r6 == 0) goto L_0x012c
            a.d.a.a.i.b.c5 r6 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r6 = r6.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r9 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x03f5 }
            boolean r6 = r6.o(r9)     // Catch:{ all -> 0x03f5 }
            if (r6 == 0) goto L_0x012c
            a.d.a.a.i.b.e r6 = r1.a(r3)     // Catch:{ all -> 0x03f5 }
            boolean r6 = r6.j()     // Catch:{ all -> 0x03f5 }
            if (r6 == 0) goto L_0x0177
        L_0x012c:
            java.util.Iterator r6 = r5.iterator()     // Catch:{ all -> 0x03f5 }
        L_0x0130:
            boolean r9 = r6.hasNext()     // Catch:{ all -> 0x03f5 }
            if (r9 == 0) goto L_0x014b
            java.lang.Object r9 = r6.next()     // Catch:{ all -> 0x03f5 }
            android.util.Pair r9 = (android.util.Pair) r9     // Catch:{ all -> 0x03f5 }
            java.lang.Object r9 = r9.first     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r9 = (a.d.a.a.h.g.b1) r9     // Catch:{ all -> 0x03f5 }
            java.lang.String r10 = r9.zzw     // Catch:{ all -> 0x03f5 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x03f5 }
            if (r10 != 0) goto L_0x0130
            java.lang.String r6 = r9.zzw     // Catch:{ all -> 0x03f5 }
            goto L_0x014c
        L_0x014b:
            r6 = r4
        L_0x014c:
            if (r6 == 0) goto L_0x0177
            r9 = 0
        L_0x014f:
            int r10 = r5.size()     // Catch:{ all -> 0x03f5 }
            if (r9 >= r10) goto L_0x0177
            java.lang.Object r10 = r5.get(r9)     // Catch:{ all -> 0x03f5 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x03f5 }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r10 = (a.d.a.a.h.g.b1) r10     // Catch:{ all -> 0x03f5 }
            java.lang.String r11 = r10.zzw     // Catch:{ all -> 0x03f5 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x03f5 }
            if (r11 != 0) goto L_0x0174
            java.lang.String r10 = r10.zzw     // Catch:{ all -> 0x03f5 }
            boolean r10 = r10.equals(r6)     // Catch:{ all -> 0x03f5 }
            if (r10 != 0) goto L_0x0174
            java.util.List r5 = r5.subList(r2, r9)     // Catch:{ all -> 0x03f5 }
            goto L_0x0177
        L_0x0174:
            int r9 = r9 + 1
            goto L_0x014f
        L_0x0177:
            a.d.a.a.h.g.a1 r6 = a.d.a.a.h.g.a1.zzd     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.y5$b r6 = r6.q()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.a1$a r6 = (a.d.a.a.h.g.a1.a) r6     // Catch:{ all -> 0x03f5 }
            int r9 = r5.size()     // Catch:{ all -> 0x03f5 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x03f5 }
            int r11 = r5.size()     // Catch:{ all -> 0x03f5 }
            r10.<init>(r11)     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.c5 r11 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r11 = r11.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.b r11 = r11.f2331c     // Catch:{ all -> 0x03f5 }
            java.lang.String r12 = "gaia_collection_enabled"
            java.lang.String r11 = r11.h(r3, r12)     // Catch:{ all -> 0x03f5 }
            java.lang.String r12 = "1"
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x03f5 }
            if (r11 == 0) goto L_0x01be
            boolean r11 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x03f5 }
            if (r11 == 0) goto L_0x01bc
            a.d.a.a.i.b.c5 r11 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r11 = r11.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r12 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x03f5 }
            boolean r11 = r11.o(r12)     // Catch:{ all -> 0x03f5 }
            if (r11 == 0) goto L_0x01bc
            a.d.a.a.i.b.e r11 = r1.a(r3)     // Catch:{ all -> 0x03f5 }
            boolean r11 = r11.j()     // Catch:{ all -> 0x03f5 }
            if (r11 == 0) goto L_0x01be
        L_0x01bc:
            r11 = 1
            goto L_0x01bf
        L_0x01be:
            r11 = 0
        L_0x01bf:
            boolean r12 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x03f5 }
            if (r12 == 0) goto L_0x01de
            a.d.a.a.i.b.c5 r12 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r12 = r12.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r13 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x03f5 }
            boolean r12 = r12.o(r13)     // Catch:{ all -> 0x03f5 }
            if (r12 == 0) goto L_0x01de
            a.d.a.a.i.b.e r12 = r1.a(r3)     // Catch:{ all -> 0x03f5 }
            boolean r12 = r12.j()     // Catch:{ all -> 0x03f5 }
            if (r12 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01dc:
            r12 = 0
            goto L_0x01df
        L_0x01de:
            r12 = 1
        L_0x01df:
            boolean r13 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x03f5 }
            if (r13 == 0) goto L_0x01fe
            a.d.a.a.i.b.c5 r13 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r13 = r13.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r14 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x03f5 }
            boolean r13 = r13.o(r14)     // Catch:{ all -> 0x03f5 }
            if (r13 == 0) goto L_0x01fe
            a.d.a.a.i.b.e r13 = r1.a(r3)     // Catch:{ all -> 0x03f5 }
            boolean r13 = r13.k()     // Catch:{ all -> 0x03f5 }
            if (r13 == 0) goto L_0x01fc
            goto L_0x01fe
        L_0x01fc:
            r13 = 0
            goto L_0x01ff
        L_0x01fe:
            r13 = 1
        L_0x01ff:
            r14 = 0
        L_0x0200:
            if (r14 >= r9) goto L_0x02f3
            java.lang.Object r15 = r5.get(r14)     // Catch:{ all -> 0x03f5 }
            android.util.Pair r15 = (android.util.Pair) r15     // Catch:{ all -> 0x03f5 }
            java.lang.Object r15 = r15.first     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r15 = (a.d.a.a.h.g.b1) r15     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.y5$b r15 = r15.r()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1$a r15 = (a.d.a.a.h.g.b1.a) r15     // Catch:{ all -> 0x03f5 }
            java.lang.Object r16 = r5.get(r14)     // Catch:{ all -> 0x03f5 }
            r0 = r16
            android.util.Pair r0 = (android.util.Pair) r0     // Catch:{ all -> 0x03f5 }
            java.lang.Object r0 = r0.second     // Catch:{ all -> 0x03f5 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x03f5 }
            r10.add(r0)     // Catch:{ all -> 0x03f5 }
            r16 = r5
            r4 = 31049(0x7949, double:1.534E-319)
            r15.X(r4)     // Catch:{ all -> 0x03f5 }
            r15.q(r7)     // Catch:{ all -> 0x03f5 }
            r15.C(r2)     // Catch:{ all -> 0x03f5 }
            if (r11 != 0) goto L_0x024c
            boolean r4 = r15.f2048c     // Catch:{ all -> 0x03f5 }
            if (r4 == 0) goto L_0x0239
            r15.k()     // Catch:{ all -> 0x03f5 }
            r15.f2048c = r2     // Catch:{ all -> 0x03f5 }
        L_0x0239:
            MessageType r4 = r15.f2047b     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r4 = (a.d.a.a.h.g.b1) r4     // Catch:{ all -> 0x03f5 }
            int r5 = r4.zzc     // Catch:{ all -> 0x03f5 }
            r17 = 2147483647(0x7fffffff, float:NaN)
            r5 = r5 & r17
            r4.zzc = r5     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r5 = a.d.a.a.h.g.b1.zzaw     // Catch:{ all -> 0x03f5 }
            java.lang.String r5 = r5.zzam     // Catch:{ all -> 0x03f5 }
            r4.zzam = r5     // Catch:{ all -> 0x03f5 }
        L_0x024c:
            boolean r4 = a.d.a.a.h.g.u9.b()     // Catch:{ all -> 0x03f5 }
            if (r4 == 0) goto L_0x02b2
            a.d.a.a.i.b.c5 r4 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r4 = r4.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.Q0     // Catch:{ all -> 0x03f5 }
            boolean r4 = r4.o(r5)     // Catch:{ all -> 0x03f5 }
            if (r4 == 0) goto L_0x02b2
            if (r12 != 0) goto L_0x0294
            boolean r4 = r15.f2048c     // Catch:{ all -> 0x03f5 }
            if (r4 == 0) goto L_0x0269
            r15.k()     // Catch:{ all -> 0x03f5 }
            r15.f2048c = r2     // Catch:{ all -> 0x03f5 }
        L_0x0269:
            MessageType r4 = r15.f2047b     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r4 = (a.d.a.a.h.g.b1) r4     // Catch:{ all -> 0x03f5 }
            int r5 = r4.zzc     // Catch:{ all -> 0x03f5 }
            r17 = -65537(0xfffffffffffeffff, float:NaN)
            r5 = r5 & r17
            r4.zzc = r5     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r5 = a.d.a.a.h.g.b1.zzaw     // Catch:{ all -> 0x03f5 }
            java.lang.String r5 = r5.zzw     // Catch:{ all -> 0x03f5 }
            r4.zzw = r5     // Catch:{ all -> 0x03f5 }
            boolean r4 = r15.f2048c     // Catch:{ all -> 0x03f5 }
            if (r4 == 0) goto L_0x0285
            r15.k()     // Catch:{ all -> 0x03f5 }
            r15.f2048c = r2     // Catch:{ all -> 0x03f5 }
        L_0x0285:
            MessageType r4 = r15.f2047b     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r4 = (a.d.a.a.h.g.b1) r4     // Catch:{ all -> 0x03f5 }
            int r5 = r4.zzc     // Catch:{ all -> 0x03f5 }
            r17 = -131073(0xfffffffffffdffff, float:NaN)
            r5 = r5 & r17
            r4.zzc = r5     // Catch:{ all -> 0x03f5 }
            r4.zzx = r2     // Catch:{ all -> 0x03f5 }
        L_0x0294:
            if (r13 != 0) goto L_0x02b2
            boolean r4 = r15.f2048c     // Catch:{ all -> 0x03f5 }
            if (r4 == 0) goto L_0x029f
            r15.k()     // Catch:{ all -> 0x03f5 }
            r15.f2048c = r2     // Catch:{ all -> 0x03f5 }
        L_0x029f:
            MessageType r4 = r15.f2047b     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r4 = (a.d.a.a.h.g.b1) r4     // Catch:{ all -> 0x03f5 }
            int r5 = r4.zzc     // Catch:{ all -> 0x03f5 }
            r17 = -262145(0xfffffffffffbffff, float:NaN)
            r5 = r5 & r17
            r4.zzc = r5     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r5 = a.d.a.a.h.g.b1.zzaw     // Catch:{ all -> 0x03f5 }
            java.lang.String r5 = r5.zzy     // Catch:{ all -> 0x03f5 }
            r4.zzy = r5     // Catch:{ all -> 0x03f5 }
        L_0x02b2:
            a.d.a.a.i.b.c5 r4 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.ka r4 = r4.g     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.Y     // Catch:{ all -> 0x03f5 }
            boolean r4 = r4.t(r3, r5)     // Catch:{ all -> 0x03f5 }
            if (r4 == 0) goto L_0x02e7
            a.d.a.a.h.g.i7 r4 = r15.m()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.y5 r4 = (a.d.a.a.h.g.y5) r4     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r4 = (a.d.a.a.h.g.b1) r4     // Catch:{ all -> 0x03f5 }
            byte[] r4 = r4.j()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.s9 r5 = r18.M()     // Catch:{ all -> 0x03f5 }
            long r4 = r5.t(r4)     // Catch:{ all -> 0x03f5 }
            boolean r0 = r15.f2048c     // Catch:{ all -> 0x03f5 }
            if (r0 == 0) goto L_0x02db
            r15.k()     // Catch:{ all -> 0x03f5 }
            r15.f2048c = r2     // Catch:{ all -> 0x03f5 }
        L_0x02db:
            MessageType r0 = r15.f2047b     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.b1 r0 = (a.d.a.a.h.g.b1) r0     // Catch:{ all -> 0x03f5 }
            int r2 = r0.zzd     // Catch:{ all -> 0x03f5 }
            r2 = r2 | 32
            r0.zzd = r2     // Catch:{ all -> 0x03f5 }
            r0.zzat = r4     // Catch:{ all -> 0x03f5 }
        L_0x02e7:
            r6.n(r15)     // Catch:{ all -> 0x03f5 }
            int r14 = r14 + 1
            r5 = r16
            r0 = 1
            r2 = 0
            r4 = 0
            goto L_0x0200
        L_0x02f3:
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ all -> 0x03f5 }
            r2 = 2
            boolean r0 = r0.x(r2)     // Catch:{ all -> 0x03f5 }
            if (r0 == 0) goto L_0x0311
            a.d.a.a.i.b.s9 r0 = r18.M()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.i7 r2 = r6.m()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.a1 r2 = (a.d.a.a.h.g.a1) r2     // Catch:{ all -> 0x03f5 }
            java.lang.String r0 = r0.z(r2)     // Catch:{ all -> 0x03f5 }
            goto L_0x0312
        L_0x0311:
            r0 = 0
        L_0x0312:
            r18.M()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.i7 r2 = r6.m()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x03f5 }
            a.d.a.a.h.g.a1 r2 = (a.d.a.a.h.g.a1) r2     // Catch:{ all -> 0x03f5 }
            byte[] r13 = r2.j()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.String> r2 = a.d.a.a.i.b.q.q     // Catch:{ all -> 0x03f5 }
            r4 = 0
            java.lang.Object r2 = r2.a(r4)     // Catch:{ all -> 0x03f5 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x03f5 }
            java.net.URL r12 = new java.net.URL     // Catch:{ MalformedURLException -> 0x03af }
            r12.<init>(r2)     // Catch:{ MalformedURLException -> 0x03af }
            boolean r4 = r10.isEmpty()     // Catch:{ MalformedURLException -> 0x03af }
            if (r4 != 0) goto L_0x0337
            r4 = 1
            goto L_0x0338
        L_0x0337:
            r4 = 0
        L_0x0338:
            a.c.a.f.b.d(r4)     // Catch:{ MalformedURLException -> 0x03af }
            java.util.List<java.lang.Long> r4 = r1.v     // Catch:{ MalformedURLException -> 0x03af }
            if (r4 == 0) goto L_0x034d
            a.d.a.a.i.b.c5 r4 = r1.j     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.x3 r4 = r4.i()     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.z3 r4 = r4.f     // Catch:{ MalformedURLException -> 0x03af }
            java.lang.String r5 = "Set uploading progress before finishing the previous upload"
            r4.a(r5)     // Catch:{ MalformedURLException -> 0x03af }
            goto L_0x0354
        L_0x034d:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x03af }
            r4.<init>(r10)     // Catch:{ MalformedURLException -> 0x03af }
            r1.v = r4     // Catch:{ MalformedURLException -> 0x03af }
        L_0x0354:
            a.d.a.a.i.b.c5 r4 = r1.j     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.k4 r4 = r4.o()     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.o4 r4 = r4.f     // Catch:{ MalformedURLException -> 0x03af }
            r4.b(r7)     // Catch:{ MalformedURLException -> 0x03af }
            java.lang.String r4 = "?"
            if (r9 <= 0) goto L_0x0372
            MessageType r4 = r6.f2047b     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.h.g.a1 r4 = (a.d.a.a.h.g.a1) r4     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.h.g.f6<a.d.a.a.h.g.b1> r4 = r4.zzc     // Catch:{ MalformedURLException -> 0x03af }
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.h.g.b1 r4 = (a.d.a.a.h.g.b1) r4     // Catch:{ MalformedURLException -> 0x03af }
            java.lang.String r4 = r4.zzs     // Catch:{ MalformedURLException -> 0x03af }
        L_0x0372:
            a.d.a.a.i.b.c5 r5 = r1.j     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.x3 r5 = r5.i()     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.z3 r5 = r5.n     // Catch:{ MalformedURLException -> 0x03af }
            java.lang.String r6 = "Uploading data. app, uncompressed size, data"
            int r7 = r13.length     // Catch:{ MalformedURLException -> 0x03af }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x03af }
            r5.d(r6, r4, r7, r0)     // Catch:{ MalformedURLException -> 0x03af }
            r0 = 1
            r1.r = r0     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.b4 r10 = r18.I()     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.q9 r15 = new a.d.a.a.i.b.q9     // Catch:{ MalformedURLException -> 0x03af }
            r15.<init>(r1, r3)     // Catch:{ MalformedURLException -> 0x03af }
            r10.b()     // Catch:{ MalformedURLException -> 0x03af }
            r10.n()     // Catch:{ MalformedURLException -> 0x03af }
            a.c.a.f.b.k(r12)     // Catch:{ MalformedURLException -> 0x03af }
            a.c.a.f.b.k(r13)     // Catch:{ MalformedURLException -> 0x03af }
            a.c.a.f.b.k(r15)     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.v4 r0 = r10.f()     // Catch:{ MalformedURLException -> 0x03af }
            a.d.a.a.i.b.f4 r4 = new a.d.a.a.i.b.f4     // Catch:{ MalformedURLException -> 0x03af }
            r14 = 0
            r9 = r4
            r11 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ MalformedURLException -> 0x03af }
            r0.w(r4)     // Catch:{ MalformedURLException -> 0x03af }
            goto L_0x03ec
        L_0x03af:
            a.d.a.a.i.b.c5 r0 = r1.j     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ all -> 0x03f5 }
            java.lang.String r4 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r3)     // Catch:{ all -> 0x03f5 }
            r0.c(r4, r3, r2)     // Catch:{ all -> 0x03f5 }
            goto L_0x03ec
        L_0x03c1:
            r1.x = r9     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.d r2 = r18.J()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.n3<java.lang.Long> r3 = a.d.a.a.i.b.q.f2469d     // Catch:{ all -> 0x03f5 }
            r0 = 0
            java.lang.Object r0 = r3.a(r0)     // Catch:{ all -> 0x03f5 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x03f5 }
            long r3 = r0.longValue()     // Catch:{ all -> 0x03f5 }
            long r7 = r7 - r3
            java.lang.String r0 = r2.B(r7)     // Catch:{ all -> 0x03f5 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x03f5 }
            if (r2 != 0) goto L_0x03ec
            a.d.a.a.i.b.d r2 = r18.J()     // Catch:{ all -> 0x03f5 }
            a.d.a.a.i.b.a4 r0 = r2.T(r0)     // Catch:{ all -> 0x03f5 }
            if (r0 == 0) goto L_0x03ec
            r1.l(r0)     // Catch:{ all -> 0x03f5 }
        L_0x03ec:
            r2 = 0
        L_0x03ed:
            r1.s = r2
            r18.w()
            return
        L_0x03f3:
            r0 = r4
            throw r0     // Catch:{ all -> 0x03f5 }
        L_0x03f5:
            r0 = move-exception
            r2 = 0
            r1.s = r2
            r18.w()
            goto L_0x03fe
        L_0x03fd:
            throw r0
        L_0x03fe:
            goto L_0x03fd
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.P():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Q() {
        /*
            r11 = this;
            r11.T()
            r11.O()
            boolean r0 = r11.l
            if (r0 != 0) goto L_0x01b6
            r0 = 1
            r11.l = r0
            r11.T()
            a.d.a.a.i.b.c5 r1 = r11.j
            a.d.a.a.i.b.ka r1 = r1.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.j0
            boolean r1 = r1.o(r2)
            java.lang.String r2 = "Storage concurrent access okay"
            r3 = 0
            if (r1 == 0) goto L_0x0035
            java.nio.channels.FileLock r1 = r11.t
            if (r1 == 0) goto L_0x0035
            boolean r1 = r1.isValid()
            if (r1 == 0) goto L_0x0035
            a.d.a.a.i.b.c5 r1 = r11.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            r1.a(r2)
            goto L_0x0064
        L_0x0035:
            a.d.a.a.i.b.c5 r1 = r11.j
            android.content.Context r1 = r1.f2123a
            java.io.File r1 = r1.getFilesDir()
            java.io.File r4 = new java.io.File
            java.lang.String r5 = "google_app_measurement.db"
            r4.<init>(r1, r5)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            java.lang.String r5 = "rw"
            r1.<init>(r4, r5)     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            r11.u = r1     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            java.nio.channels.FileLock r1 = r1.tryLock()     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            r11.t = r1     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            if (r1 == 0) goto L_0x0066
            a.d.a.a.i.b.c5 r1 = r11.j     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            a.d.a.a.i.b.x3 r1 = r1.i()     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            a.d.a.a.i.b.z3 r1 = r1.n     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            r1.a(r2)     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
        L_0x0064:
            r1 = 1
            goto L_0x009b
        L_0x0066:
            a.d.a.a.i.b.c5 r1 = r11.j     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            a.d.a.a.i.b.x3 r1 = r1.i()     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            java.lang.String r2 = "Storage concurrent data access panic"
            r1.a(r2)     // Catch:{ FileNotFoundException -> 0x008c, IOException -> 0x0080, OverlappingFileLockException -> 0x0074 }
            goto L_0x009a
        L_0x0074:
            r1 = move-exception
            a.d.a.a.i.b.c5 r2 = r11.j
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.i
            java.lang.String r4 = "Storage lock already acquired"
            goto L_0x0097
        L_0x0080:
            r1 = move-exception
            a.d.a.a.i.b.c5 r2 = r11.j
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.String r4 = "Failed to access storage lock file"
            goto L_0x0097
        L_0x008c:
            r1 = move-exception
            a.d.a.a.i.b.c5 r2 = r11.j
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.String r4 = "Failed to acquire storage lock"
        L_0x0097:
            r2.b(r4, r1)
        L_0x009a:
            r1 = 0
        L_0x009b:
            if (r1 == 0) goto L_0x01b6
            java.nio.channels.FileChannel r1 = r11.u
            r11.T()
            r4 = 0
            r2 = 4
            java.lang.String r6 = "Bad channel to read from"
            if (r1 == 0) goto L_0x00e9
            boolean r7 = r1.isOpen()
            if (r7 != 0) goto L_0x00b0
            goto L_0x00e9
        L_0x00b0:
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r2)
            r1.position(r4)     // Catch:{ IOException -> 0x00da }
            int r1 = r1.read(r7)     // Catch:{ IOException -> 0x00da }
            if (r1 == r2) goto L_0x00d2
            r7 = -1
            if (r1 == r7) goto L_0x00f4
            a.d.a.a.i.b.c5 r7 = r11.j     // Catch:{ IOException -> 0x00da }
            a.d.a.a.i.b.x3 r7 = r7.i()     // Catch:{ IOException -> 0x00da }
            a.d.a.a.i.b.z3 r7 = r7.i     // Catch:{ IOException -> 0x00da }
            java.lang.String r8 = "Unexpected data length. Bytes read"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ IOException -> 0x00da }
            r7.b(r8, r1)     // Catch:{ IOException -> 0x00da }
            goto L_0x00f4
        L_0x00d2:
            r7.flip()     // Catch:{ IOException -> 0x00da }
            int r1 = r7.getInt()     // Catch:{ IOException -> 0x00da }
            goto L_0x00f5
        L_0x00da:
            r1 = move-exception
            a.d.a.a.i.b.c5 r7 = r11.j
            a.d.a.a.i.b.x3 r7 = r7.i()
            a.d.a.a.i.b.z3 r7 = r7.f
            java.lang.String r8 = "Failed to read from channel"
            r7.b(r8, r1)
            goto L_0x00f4
        L_0x00e9:
            a.d.a.a.i.b.c5 r1 = r11.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            r1.a(r6)
        L_0x00f4:
            r1 = 0
        L_0x00f5:
            a.d.a.a.i.b.c5 r7 = r11.j
            a.d.a.a.i.b.q3 r7 = r7.z()
            r7.u()
            int r7 = r7.f2476e
            r11.T()
            if (r1 <= r7) goto L_0x0119
            a.d.a.a.i.b.c5 r0 = r11.j
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            java.lang.String r3 = "Panic: can't downgrade version. Previous, current version"
            goto L_0x01b3
        L_0x0119:
            if (r1 >= r7) goto L_0x01b6
            java.nio.channels.FileChannel r8 = r11.u
            r11.T()
            if (r8 == 0) goto L_0x0180
            boolean r9 = r8.isOpen()
            if (r9 != 0) goto L_0x0129
            goto L_0x0180
        L_0x0129:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)
            r2.putInt(r7)
            r2.flip()
            r8.truncate(r4)     // Catch:{ IOException -> 0x0171 }
            a.d.a.a.i.b.c5 r6 = r11.j     // Catch:{ IOException -> 0x0171 }
            a.d.a.a.i.b.ka r6 = r6.g     // Catch:{ IOException -> 0x0171 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r9 = a.d.a.a.i.b.q.u0     // Catch:{ IOException -> 0x0171 }
            boolean r6 = r6.o(r9)     // Catch:{ IOException -> 0x0171 }
            if (r6 == 0) goto L_0x014b
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0171 }
            r9 = 19
            if (r6 > r9) goto L_0x014b
            r8.position(r4)     // Catch:{ IOException -> 0x0171 }
        L_0x014b:
            r8.write(r2)     // Catch:{ IOException -> 0x0171 }
            r8.force(r0)     // Catch:{ IOException -> 0x0171 }
            long r4 = r8.size()     // Catch:{ IOException -> 0x0171 }
            r9 = 4
            int r2 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x018c
            a.d.a.a.i.b.c5 r2 = r11.j     // Catch:{ IOException -> 0x0171 }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ IOException -> 0x0171 }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ IOException -> 0x0171 }
            java.lang.String r4 = "Error writing to channel. Bytes written"
            long r5 = r8.size()     // Catch:{ IOException -> 0x0171 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ IOException -> 0x0171 }
            r2.b(r4, r5)     // Catch:{ IOException -> 0x0171 }
            goto L_0x018c
        L_0x0171:
            r0 = move-exception
            a.d.a.a.i.b.c5 r2 = r11.j
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.String r4 = "Failed to write to channel"
            r2.b(r4, r0)
            goto L_0x018b
        L_0x0180:
            a.d.a.a.i.b.c5 r0 = r11.j
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            r0.a(r6)
        L_0x018b:
            r0 = 0
        L_0x018c:
            if (r0 == 0) goto L_0x01a1
            a.d.a.a.i.b.c5 r0 = r11.j
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.n
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            java.lang.String r3 = "Storage version upgraded. Previous, current version"
            goto L_0x01b3
        L_0x01a1:
            a.d.a.a.i.b.c5 r0 = r11.j
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            java.lang.String r3 = "Storage version upgrade failed. Previous, current version"
        L_0x01b3:
            r0.c(r3, r1, r2)
        L_0x01b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.Q():void");
    }

    public final i4 R() {
        i4 i4Var = this.f2445d;
        if (i4Var != null) {
            return i4Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final l9 S() {
        B(this.f2446e);
        return this.f2446e;
    }

    @WorkerThread
    public final void T() {
        this.j.f().b();
    }

    public final long U() {
        if (((c) this.j.n) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            k4 o2 = this.j.o();
            o2.n();
            o2.b();
            long a2 = o2.i.a();
            if (a2 == 0) {
                a2 = 1 + ((long) o2.e().w0().nextInt(86400000));
                o2.i.b(a2);
            }
            return ((((currentTimeMillis + a2) / 1000) / 60) / 60) / 24;
        }
        throw null;
    }

    @WorkerThread
    @Deprecated
    public final String V() {
        byte[] bArr = new byte[16];
        this.j.t().w0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Throwable, android.database.Cursor] */
    @WorkerThread
    public final e a(String str) {
        String str2;
        e eVar = e.f2160c;
        if (!u9.b() || !this.j.g.o(q.Q0)) {
            return eVar;
        }
        T();
        O();
        e eVar2 = this.y.get(str);
        if (eVar2 != null) {
            return eVar2;
        }
        d J = J();
        ? r1 = 0;
        if (J != null) {
            b.k(str);
            J.b();
            J.n();
            try {
                Cursor rawQuery = J.t().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (rawQuery.moveToFirst()) {
                    str2 = rawQuery.getString(0);
                    rawQuery.close();
                } else {
                    rawQuery.close();
                    str2 = "G1";
                }
                e b2 = e.b(str2);
                r(str, b2);
                return b2;
            } catch (SQLiteException e2) {
                J.i().f.c("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e2);
                throw e2;
            } catch (Throwable th) {
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } else {
            throw r1;
        }
    }

    @WorkerThread
    public final String c(e eVar) {
        if (!u9.b() || !this.j.g.o(q.Q0) || eVar.k()) {
            return V();
        }
        return null;
    }

    public final v4 f() {
        return this.j.f();
    }

    public final a.d.a.a.e.q.b g() {
        return this.j.n;
    }

    public final void h(b1.a aVar, long j2, boolean z2) {
        w9 w9Var;
        boolean z3;
        String str = z2 ? "_se" : "_lte";
        w9 Y = J().Y(aVar.j0(), str);
        if (Y == null || Y.f2610e == null) {
            String j0 = aVar.j0();
            if (((c) this.j.n) != null) {
                w9Var = new w9(j0, "auto", str, System.currentTimeMillis(), Long.valueOf(j2));
            } else {
                throw null;
            }
        } else {
            String j02 = aVar.j0();
            if (((c) this.j.n) != null) {
                w9Var = new w9(j02, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) Y.f2610e).longValue() + j2));
            } else {
                throw null;
            }
        }
        f1.a v2 = f1.v();
        v2.o(str);
        if (((c) this.j.n) != null) {
            v2.n(System.currentTimeMillis());
            v2.p(((Long) w9Var.f2610e).longValue());
            f1 f1Var = (f1) ((y5) v2.m());
            int s2 = s9.s(aVar, str);
            if (s2 >= 0) {
                if (aVar.f2048c) {
                    aVar.k();
                    aVar.f2048c = false;
                }
                b1.u((b1) aVar.f2047b, s2, f1Var);
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                if (aVar.f2048c) {
                    aVar.k();
                    aVar.f2048c = false;
                }
                b1 b1Var = (b1) aVar.f2047b;
                if (b1Var != null) {
                    f1Var.getClass();
                    b1Var.E();
                    b1Var.zzg.add(f1Var);
                } else {
                    throw null;
                }
            }
            if (j2 > 0) {
                J().M(w9Var);
                this.j.i().n.c("Updated engagement user property. scope, value", z2 ? "session-scoped" : "lifetime", w9Var.f2610e);
                return;
            }
            return;
        }
        throw null;
    }

    public final x3 i() {
        return this.j.i();
    }

    public final Context j() {
        return this.j.f2123a;
    }

    @WorkerThread
    public final void k(zzar zzar, zzn zzn) {
        List<zzw> list;
        List<zzw> list2;
        List<zzw> list3;
        z3 z3Var;
        String str;
        Object s2;
        String y2;
        Object obj;
        zzar zzar2 = zzar;
        zzn zzn2 = zzn;
        b.k(zzn);
        b.h(zzn2.f4285a);
        T();
        O();
        String str2 = zzn2.f4285a;
        long j2 = zzar2.f4279d;
        M();
        if (s9.O(zzar, zzn)) {
            if (!zzn2.h) {
                F(zzn2);
                return;
            }
            List<String> list4 = zzn2.u;
            if (list4 != null) {
                if (list4.contains(zzar2.f4276a)) {
                    Bundle h2 = zzar2.f4277b.h();
                    h2.putLong("ga_safelisted", 1);
                    zzar2 = new zzar(zzar2.f4276a, new zzam(h2), zzar2.f4278c, zzar2.f4279d);
                } else {
                    this.j.i().m.d("Dropping non-safelisted event. appId, event name, origin", str2, zzar2.f4276a, zzar2.f4278c);
                    return;
                }
            }
            J().b0();
            try {
                d J = J();
                b.h(str2);
                J.b();
                J.n();
                if (j2 < 0) {
                    J.i().i.c("Invalid time querying timed out conditional properties", x3.s(str2), Long.valueOf(j2));
                    list = Collections.emptyList();
                } else {
                    list = J.F("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j2)});
                }
                for (zzw next : list) {
                    if (next != null) {
                        this.j.i().n.d("User property timed out", next.f4290a, this.j.u().y(next.f4292c.f4281b), next.f4292c.e());
                        if (next.g != null) {
                            H(new zzar(next.g, j2), zzn2);
                        }
                        J().a0(str2, next.f4292c.f4281b);
                    }
                }
                d J2 = J();
                b.h(str2);
                J2.b();
                J2.n();
                if (j2 < 0) {
                    J2.i().i.c("Invalid time querying expired conditional properties", x3.s(str2), Long.valueOf(j2));
                    list2 = Collections.emptyList();
                } else {
                    list2 = J2.F("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j2)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzw next2 : list2) {
                    if (next2 != null) {
                        this.j.i().n.d("User property expired", next2.f4290a, this.j.u().y(next2.f4292c.f4281b), next2.f4292c.e());
                        J().V(str2, next2.f4292c.f4281b);
                        if (next2.k != null) {
                            arrayList.add(next2.k);
                        }
                        J().a0(str2, next2.f4292c.f4281b);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    H(new zzar((zzar) obj2, j2), zzn2);
                }
                d J3 = J();
                String str3 = zzar2.f4276a;
                b.h(str2);
                b.h(str3);
                J3.b();
                J3.n();
                if (j2 < 0) {
                    J3.i().i.d("Invalid time querying triggered conditional properties", x3.s(str2), J3.d().u(str3), Long.valueOf(j2));
                    list3 = Collections.emptyList();
                } else {
                    list3 = J3.F("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j2)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzw next3 : list3) {
                    if (next3 != null) {
                        zzkw zzkw = next3.f4292c;
                        w9 w9Var = r4;
                        w9 w9Var2 = new w9(next3.f4290a, next3.f4291b, zzkw.f4281b, j2, zzkw.e());
                        if (J().M(w9Var)) {
                            z3Var = this.j.i().n;
                            str = "User property triggered";
                            s2 = next3.f4290a;
                            y2 = this.j.u().y(w9Var.f2608c);
                            obj = w9Var.f2610e;
                        } else {
                            z3Var = this.j.i().f;
                            str = "Too many active user properties, ignoring";
                            s2 = x3.s(next3.f4290a);
                            y2 = this.j.u().y(w9Var.f2608c);
                            obj = w9Var.f2610e;
                        }
                        z3Var.d(str, s2, y2, obj);
                        if (next3.i != null) {
                            arrayList2.add(next3.i);
                        }
                        next3.f4292c = new zzkw(w9Var);
                        next3.f4294e = true;
                        J().N(next3);
                    }
                }
                H(zzar2, zzn2);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj3 = arrayList2.get(i3);
                    i3++;
                    H(new zzar((zzar) obj3, j2), zzn2);
                }
                J().s();
            } finally {
                J().e0();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009b, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x009d;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(a.d.a.a.i.b.a4 r11) {
        /*
            r10 = this;
            r10.T()
            boolean r0 = a.d.a.a.h.g.jb.b()
            if (r0 == 0) goto L_0x0045
            a.d.a.a.i.b.c5 r0 = r10.j
            a.d.a.a.i.b.ka r0 = r0.g
            java.lang.String r1 = r11.o()
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.k0
            boolean r0 = r0.t(r1, r2)
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r11.v()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r11.B()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r11.y()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0067
            java.lang.String r2 = r11.o()
            r3 = 204(0xcc, float:2.86E-43)
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r10
            r1.q(r2, r3, r4, r5, r6)
            return
        L_0x0045:
            java.lang.String r0 = r11.v()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r11.y()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0067
            java.lang.String r2 = r11.o()
            r3 = 204(0xcc, float:2.86E-43)
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r10
            r1.q(r2, r3, r4, r5, r6)
            return
        L_0x0067:
            a.d.a.a.i.b.c5 r0 = r10.j
            a.d.a.a.i.b.ka r0 = r0.g
            r1 = 0
            if (r0 == 0) goto L_0x017d
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = r11.v()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x00a1
            boolean r3 = a.d.a.a.h.g.jb.b()
            if (r3 == 0) goto L_0x009d
            a.d.a.a.i.b.c5 r0 = r0.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            java.lang.String r3 = r11.o()
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.k0
            boolean r0 = r0.t(r3, r4)
            if (r0 == 0) goto L_0x009d
            java.lang.String r3 = r11.B()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x00a1
        L_0x009d:
            java.lang.String r3 = r11.y()
        L_0x00a1:
            a.d.a.a.i.b.n3<java.lang.String> r0 = a.d.a.a.i.b.q.f2470e
            java.lang.Object r0 = r0.a(r1)
            java.lang.String r0 = (java.lang.String) r0
            android.net.Uri$Builder r0 = r2.scheme(r0)
            a.d.a.a.i.b.n3<java.lang.String> r4 = a.d.a.a.i.b.q.f
            java.lang.Object r4 = r4.a(r1)
            java.lang.String r4 = (java.lang.String) r4
            android.net.Uri$Builder r0 = r0.encodedAuthority(r4)
            java.lang.String r4 = "config/app/"
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r5 = r3.length()
            if (r5 == 0) goto L_0x00ca
            java.lang.String r3 = r4.concat(r3)
            goto L_0x00cf
        L_0x00ca:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r4)
        L_0x00cf:
            android.net.Uri$Builder r0 = r0.path(r3)
            java.lang.String r3 = r11.s()
            java.lang.String r4 = "app_instance_id"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r4, r3)
            java.lang.String r3 = "platform"
            java.lang.String r4 = "android"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r3, r4)
            java.lang.String r3 = "gmp_version"
            java.lang.String r4 = "31049"
            r0.appendQueryParameter(r3, r4)
            android.net.Uri r0 = r2.build()
            java.lang.String r0 = r0.toString()
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0167 }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.c5 r2 = r10.j     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.z3 r2 = r2.n     // Catch:{ MalformedURLException -> 0x0167 }
            java.lang.String r3 = "Fetching remote configuration"
            java.lang.String r4 = r11.o()     // Catch:{ MalformedURLException -> 0x0167 }
            r2.b(r3, r4)     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.w4 r2 = r10.G()     // Catch:{ MalformedURLException -> 0x0167 }
            java.lang.String r3 = r11.o()     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.h.g.r0 r2 = r2.s(r3)     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.w4 r3 = r10.G()     // Catch:{ MalformedURLException -> 0x0167 }
            java.lang.String r4 = r11.o()     // Catch:{ MalformedURLException -> 0x0167 }
            r3.b()     // Catch:{ MalformedURLException -> 0x0167 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r3.i     // Catch:{ MalformedURLException -> 0x0167 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ MalformedURLException -> 0x0167 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ MalformedURLException -> 0x0167 }
            if (r2 == 0) goto L_0x013b
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ MalformedURLException -> 0x0167 }
            if (r2 != 0) goto L_0x013b
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ MalformedURLException -> 0x0167 }
            r1.<init>()     // Catch:{ MalformedURLException -> 0x0167 }
            java.lang.String r2 = "If-Modified-Since"
            r1.put(r2, r3)     // Catch:{ MalformedURLException -> 0x0167 }
        L_0x013b:
            r7 = r1
            r1 = 1
            r10.q = r1     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.b4 r3 = r10.I()     // Catch:{ MalformedURLException -> 0x0167 }
            java.lang.String r4 = r11.o()     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.p9 r8 = new a.d.a.a.i.b.p9     // Catch:{ MalformedURLException -> 0x0167 }
            r8.<init>(r10)     // Catch:{ MalformedURLException -> 0x0167 }
            r3.b()     // Catch:{ MalformedURLException -> 0x0167 }
            r3.n()     // Catch:{ MalformedURLException -> 0x0167 }
            a.c.a.f.b.k(r5)     // Catch:{ MalformedURLException -> 0x0167 }
            a.c.a.f.b.k(r8)     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.v4 r1 = r3.f()     // Catch:{ MalformedURLException -> 0x0167 }
            a.d.a.a.i.b.f4 r9 = new a.d.a.a.i.b.f4     // Catch:{ MalformedURLException -> 0x0167 }
            r6 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ MalformedURLException -> 0x0167 }
            r1.w(r9)     // Catch:{ MalformedURLException -> 0x0167 }
            return
        L_0x0167:
            a.d.a.a.i.b.c5 r1 = r10.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.String r11 = r11.o()
            java.lang.Object r11 = a.d.a.a.i.b.x3.s(r11)
            java.lang.String r2 = "Failed to parse config URL. Not fetching. appId"
            r1.c(r2, r11, r0)
            return
        L_0x017d:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.l(a.d.a.a.i.b.a4):void");
    }

    public final ja m() {
        return this.j.f;
    }

    @WorkerThread
    public final void n(zzkw zzkw, zzn zzn) {
        T();
        O();
        if (K(zzn)) {
            if (!zzn.h) {
                F(zzn);
                return;
            }
            int g0 = this.j.t().g0(zzkw.f4281b);
            int i2 = 0;
            if (g0 != 0) {
                this.j.t();
                String E = v9.E(zzkw.f4281b, 24, true);
                String str = zzkw.f4281b;
                if (str != null) {
                    i2 = str.length();
                }
                this.j.t().f0(g0, "_ev", E, i2);
                return;
            }
            int h0 = this.j.t().h0(zzkw.f4281b, zzkw.e());
            if (h0 != 0) {
                this.j.t();
                String E2 = v9.E(zzkw.f4281b, 24, true);
                Object e2 = zzkw.e();
                if (e2 != null && ((e2 instanceof String) || (e2 instanceof CharSequence))) {
                    i2 = String.valueOf(e2).length();
                }
                this.j.t().f0(h0, "_ev", E2, i2);
                return;
            }
            Object o0 = this.j.t().o0(zzkw.f4281b, zzkw.e());
            if (o0 != null) {
                if ("_sid".equals(zzkw.f4281b)) {
                    long j2 = zzkw.f4282c;
                    String str2 = zzkw.f;
                    long j3 = 0;
                    w9 Y = J().Y(zzn.f4285a, "_sno");
                    if (Y != null) {
                        Object obj = Y.f2610e;
                        if (obj instanceof Long) {
                            j3 = ((Long) obj).longValue();
                            n(new zzkw("_sno", j2, Long.valueOf(j3 + 1), str2), zzn);
                        }
                    }
                    if (Y != null) {
                        this.j.i().i.b("Retrieved last session number from database does not contain a valid (long) value", Y.f2610e);
                    }
                    l z2 = J().z(zzn.f4285a, "_s");
                    if (z2 != null) {
                        j3 = z2.f2335c;
                        this.j.i().n.b("Backfill the session number. Last used session number", Long.valueOf(j3));
                    }
                    n(new zzkw("_sno", j2, Long.valueOf(j3 + 1), str2), zzn);
                }
                w9 w9Var = new w9(zzn.f4285a, zzkw.f, zzkw.f4281b, zzkw.f4282c, o0);
                this.j.i().n.c("Setting user property", this.j.u().y(w9Var.f2608c), o0);
                J().b0();
                try {
                    F(zzn);
                    boolean M = J().M(w9Var);
                    J().s();
                    if (!M) {
                        this.j.i().f.c("Too many unique user properties are set. Ignoring user property", this.j.u().y(w9Var.f2608c), w9Var.f2610e);
                        this.j.t().f0(9, (String) null, (String) null, 0);
                    }
                } finally {
                    J().e0();
                }
            }
        }
    }

    @WorkerThread
    public final void o(zzn zzn) {
        if (this.v != null) {
            ArrayList arrayList = new ArrayList();
            this.w = arrayList;
            arrayList.addAll(this.v);
        }
        d J = J();
        String str = zzn.f4285a;
        b.h(str);
        J.b();
        J.n();
        try {
            SQLiteDatabase t2 = J.t();
            String[] strArr = {str};
            int delete = t2.delete("apps", "app_id=?", strArr) + 0 + t2.delete("events", "app_id=?", strArr) + t2.delete("user_attributes", "app_id=?", strArr) + t2.delete("conditional_properties", "app_id=?", strArr) + t2.delete("raw_events", "app_id=?", strArr) + t2.delete("raw_events_metadata", "app_id=?", strArr) + t2.delete("queue", "app_id=?", strArr) + t2.delete("audience_filter_values", "app_id=?", strArr) + t2.delete("main_event_params", "app_id=?", strArr) + t2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                J.i().n.c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            J.i().f.c("Error resetting analytics data. appId, error", x3.s(str), e2);
        }
        if (zzn.h) {
            D(zzn);
        }
    }

    @WorkerThread
    public final void p(zzw zzw, zzn zzn) {
        z3 z3Var;
        String str;
        Object s2;
        String y2;
        Object e2;
        z3 z3Var2;
        String str2;
        Object s3;
        String y3;
        Object obj;
        b.k(zzw);
        b.h(zzw.f4290a);
        b.k(zzw.f4291b);
        b.k(zzw.f4292c);
        b.h(zzw.f4292c.f4281b);
        T();
        O();
        if (K(zzn)) {
            if (!zzn.h) {
                F(zzn);
                return;
            }
            zzw zzw2 = new zzw(zzw);
            boolean z2 = false;
            zzw2.f4294e = false;
            J().b0();
            try {
                zzw Z = J().Z(zzw2.f4290a, zzw2.f4292c.f4281b);
                if (Z != null && !Z.f4291b.equals(zzw2.f4291b)) {
                    this.j.i().i.d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.j.u().y(zzw2.f4292c.f4281b), zzw2.f4291b, Z.f4291b);
                }
                if (Z != null && Z.f4294e) {
                    zzw2.f4291b = Z.f4291b;
                    zzw2.f4293d = Z.f4293d;
                    zzw2.h = Z.h;
                    zzw2.f = Z.f;
                    zzw2.i = Z.i;
                    zzw2.f4294e = Z.f4294e;
                    zzw2.f4292c = new zzkw(zzw2.f4292c.f4281b, Z.f4292c.f4282c, zzw2.f4292c.e(), Z.f4292c.f);
                } else if (TextUtils.isEmpty(zzw2.f)) {
                    zzw2.f4292c = new zzkw(zzw2.f4292c.f4281b, zzw2.f4293d, zzw2.f4292c.e(), zzw2.f4292c.f);
                    zzw2.f4294e = true;
                    z2 = true;
                }
                if (zzw2.f4294e) {
                    zzkw zzkw = zzw2.f4292c;
                    w9 w9Var = new w9(zzw2.f4290a, zzw2.f4291b, zzkw.f4281b, zzkw.f4282c, zzkw.e());
                    if (J().M(w9Var)) {
                        z3Var2 = this.j.i().m;
                        str2 = "User property updated immediately";
                        s3 = zzw2.f4290a;
                        y3 = this.j.u().y(w9Var.f2608c);
                        obj = w9Var.f2610e;
                    } else {
                        z3Var2 = this.j.i().f;
                        str2 = "(2)Too many active user properties, ignoring";
                        s3 = x3.s(zzw2.f4290a);
                        y3 = this.j.u().y(w9Var.f2608c);
                        obj = w9Var.f2610e;
                    }
                    z3Var2.d(str2, s3, y3, obj);
                    if (z2 && zzw2.i != null) {
                        H(new zzar(zzw2.i, zzw2.f4293d), zzn);
                    }
                }
                if (J().N(zzw2)) {
                    z3Var = this.j.i().m;
                    str = "Conditional property added";
                    s2 = zzw2.f4290a;
                    y2 = this.j.u().y(zzw2.f4292c.f4281b);
                    e2 = zzw2.f4292c.e();
                } else {
                    z3Var = this.j.i().f;
                    str = "Too many conditional properties, ignoring";
                    s2 = x3.s(zzw2.f4290a);
                    y2 = this.j.u().y(zzw2.f4292c.f4281b);
                    e2 = zzw2.f4292c.e();
                }
                z3Var.d(str, s2, y2, e2);
                J().s();
            } finally {
                J().e0();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0117 A[Catch:{ all -> 0x0173, all -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0172 A[SYNTHETIC, Splitter:B:69:0x0172] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12) {
        /*
            r7 = this;
            r7.T()
            r7.O()
            a.c.a.f.b.h(r8)
            r0 = 0
            if (r11 != 0) goto L_0x000e
            byte[] r11 = new byte[r0]     // Catch:{ all -> 0x017c }
        L_0x000e:
            a.d.a.a.i.b.c5 r1 = r7.j     // Catch:{ all -> 0x017c }
            a.d.a.a.i.b.x3 r1 = r1.i()     // Catch:{ all -> 0x017c }
            a.d.a.a.i.b.z3 r1 = r1.n     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r11.length     // Catch:{ all -> 0x017c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x017c }
            r1.b(r2, r3)     // Catch:{ all -> 0x017c }
            a.d.a.a.i.b.d r1 = r7.J()     // Catch:{ all -> 0x017c }
            r1.b0()     // Catch:{ all -> 0x017c }
            a.d.a.a.i.b.d r1 = r7.J()     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.a4 r1 = r1.T(r8)     // Catch:{ all -> 0x0173 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r9 == r2) goto L_0x003c
            r2 = 204(0xcc, float:2.86E-43)
            if (r9 == r2) goto L_0x003c
            if (r9 != r3) goto L_0x0040
        L_0x003c:
            if (r10 != 0) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            if (r1 != 0) goto L_0x0056
            a.d.a.a.i.b.c5 r9 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.x3 r9 = r9.i()     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.z3 r9 = r9.i     // Catch:{ all -> 0x0173 }
            java.lang.String r10 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r8 = a.d.a.a.i.b.x3.s(r8)     // Catch:{ all -> 0x0173 }
            r9.b(r10, r8)     // Catch:{ all -> 0x0173 }
            goto L_0x015e
        L_0x0056:
            r5 = 404(0x194, float:5.66E-43)
            r6 = 0
            if (r2 != 0) goto L_0x00d5
            if (r9 != r5) goto L_0x005f
            goto L_0x00d5
        L_0x005f:
            a.d.a.a.i.b.c5 r11 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.e.q.b r11 = r11.n     // Catch:{ all -> 0x0173 }
            a.d.a.a.e.q.c r11 = (a.d.a.a.e.q.c) r11     // Catch:{ all -> 0x0173 }
            if (r11 == 0) goto L_0x00d4
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0173 }
            r1.I(r11)     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.d r11 = r7.J()     // Catch:{ all -> 0x0173 }
            r11.I(r1)     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.c5 r11 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.x3 r11 = r11.i()     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.z3 r11 = r11.n     // Catch:{ all -> 0x0173 }
            java.lang.String r12 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0173 }
            r11.c(r12, r1, r10)     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.w4 r10 = r7.G()     // Catch:{ all -> 0x0173 }
            r10.b()     // Catch:{ all -> 0x0173 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r10.i     // Catch:{ all -> 0x0173 }
            r10.put(r8, r6)     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.c5 r8 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.k4 r8 = r8.o()     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.o4 r8 = r8.f     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.c5 r10 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.e.q.b r10 = r10.n     // Catch:{ all -> 0x0173 }
            a.d.a.a.e.q.c r10 = (a.d.a.a.e.q.c) r10     // Catch:{ all -> 0x0173 }
            if (r10 == 0) goto L_0x00d3
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0173 }
            r8.b(r10)     // Catch:{ all -> 0x0173 }
            r8 = 503(0x1f7, float:7.05E-43)
            if (r9 == r8) goto L_0x00b3
            r8 = 429(0x1ad, float:6.01E-43)
            if (r9 != r8) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            if (r4 == 0) goto L_0x00ce
            a.d.a.a.i.b.c5 r8 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.k4 r8 = r8.o()     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.o4 r8 = r8.g     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.c5 r9 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.e.q.b r9 = r9.n     // Catch:{ all -> 0x0173 }
            a.d.a.a.e.q.c r9 = (a.d.a.a.e.q.c) r9     // Catch:{ all -> 0x0173 }
            if (r9 == 0) goto L_0x00cd
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0173 }
            r8.b(r9)     // Catch:{ all -> 0x0173 }
            goto L_0x00ce
        L_0x00cd:
            throw r6     // Catch:{ all -> 0x0173 }
        L_0x00ce:
            r7.v()     // Catch:{ all -> 0x0173 }
            goto L_0x015e
        L_0x00d3:
            throw r6     // Catch:{ all -> 0x0173 }
        L_0x00d4:
            throw r6     // Catch:{ all -> 0x0173 }
        L_0x00d5:
            if (r12 == 0) goto L_0x00e0
            java.lang.String r10 = "Last-Modified"
            java.lang.Object r10 = r12.get(r10)     // Catch:{ all -> 0x0173 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x0173 }
            goto L_0x00e1
        L_0x00e0:
            r10 = r6
        L_0x00e1:
            if (r10 == 0) goto L_0x00f0
            int r12 = r10.size()     // Catch:{ all -> 0x0173 }
            if (r12 <= 0) goto L_0x00f0
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0173 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0173 }
            goto L_0x00f1
        L_0x00f0:
            r10 = r6
        L_0x00f1:
            if (r9 == r5) goto L_0x00fe
            if (r9 != r3) goto L_0x00f6
            goto L_0x00fe
        L_0x00f6:
            a.d.a.a.i.b.w4 r12 = r7.G()     // Catch:{ all -> 0x0173 }
            r12.w(r8, r11, r10)     // Catch:{ all -> 0x0173 }
            goto L_0x010f
        L_0x00fe:
            a.d.a.a.i.b.w4 r10 = r7.G()     // Catch:{ all -> 0x0173 }
            a.d.a.a.h.g.r0 r10 = r10.s(r8)     // Catch:{ all -> 0x0173 }
            if (r10 != 0) goto L_0x010f
            a.d.a.a.i.b.w4 r10 = r7.G()     // Catch:{ all -> 0x0173 }
            r10.w(r8, r6, r6)     // Catch:{ all -> 0x0173 }
        L_0x010f:
            a.d.a.a.i.b.c5 r10 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.e.q.b r10 = r10.n     // Catch:{ all -> 0x0173 }
            a.d.a.a.e.q.c r10 = (a.d.a.a.e.q.c) r10     // Catch:{ all -> 0x0173 }
            if (r10 == 0) goto L_0x0172
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0173 }
            r1.F(r2)     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.d r10 = r7.J()     // Catch:{ all -> 0x0173 }
            r10.I(r1)     // Catch:{ all -> 0x0173 }
            if (r9 != r5) goto L_0x0135
            a.d.a.a.i.b.c5 r9 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.x3 r9 = r9.i()     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.z3 r9 = r9.k     // Catch:{ all -> 0x0173 }
            java.lang.String r10 = "Config not found. Using empty config. appId"
            r9.b(r10, r8)     // Catch:{ all -> 0x0173 }
            goto L_0x014b
        L_0x0135:
            a.d.a.a.i.b.c5 r8 = r7.j     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.x3 r8 = r8.i()     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.z3 r8 = r8.n     // Catch:{ all -> 0x0173 }
            java.lang.String r10 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0173 }
            int r11 = r11.length     // Catch:{ all -> 0x0173 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0173 }
            r8.c(r10, r9, r11)     // Catch:{ all -> 0x0173 }
        L_0x014b:
            a.d.a.a.i.b.b4 r8 = r7.I()     // Catch:{ all -> 0x0173 }
            boolean r8 = r8.u()     // Catch:{ all -> 0x0173 }
            if (r8 == 0) goto L_0x00ce
            boolean r8 = r7.u()     // Catch:{ all -> 0x0173 }
            if (r8 == 0) goto L_0x00ce
            r7.P()     // Catch:{ all -> 0x0173 }
        L_0x015e:
            a.d.a.a.i.b.d r8 = r7.J()     // Catch:{ all -> 0x0173 }
            r8.s()     // Catch:{ all -> 0x0173 }
            a.d.a.a.i.b.d r8 = r7.J()     // Catch:{ all -> 0x017c }
            r8.e0()     // Catch:{ all -> 0x017c }
            r7.q = r0
            r7.w()
            return
        L_0x0172:
            throw r6     // Catch:{ all -> 0x0173 }
        L_0x0173:
            r8 = move-exception
            a.d.a.a.i.b.d r9 = r7.J()     // Catch:{ all -> 0x017c }
            r9.e0()     // Catch:{ all -> 0x017c }
            throw r8     // Catch:{ all -> 0x017c }
        L_0x017c:
            r8 = move-exception
            r7.q = r0
            r7.w()
            goto L_0x0184
        L_0x0183:
            throw r8
        L_0x0184:
            goto L_0x0183
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.q(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    @WorkerThread
    public final void r(String str, e eVar) {
        if (u9.b() && this.j.g.o(q.Q0)) {
            T();
            O();
            this.y.put(str, eVar);
            d J = J();
            if (u9.b() && J.f2563a.g.o(q.Q0)) {
                b.k(str);
                b.k(eVar);
                J.b();
                J.n();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", eVar.d());
                try {
                    if (J.t().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                        J.i().f.b("Failed to insert/update consent setting (got -1). appId", x3.s(str));
                    }
                } catch (SQLiteException e2) {
                    J.i().f.c("Error storing consent setting. appId, error", x3.s(str), e2);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v98, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v99, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v102, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v111, resolved type: a.d.a.a.i.b.z3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v137, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v139, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v140, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v143, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v146, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v149, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v101, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v103 */
    /* JADX WARNING: type inference failed for: r9v108 */
    /* JADX WARNING: type inference failed for: r9v141 */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0267, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0283, code lost:
        r0 = e;
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0285, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0286, code lost:
        r2 = r0;
        r9 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x028a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x028b, code lost:
        r29 = "_si";
        r30 = "_sc";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x028f, code lost:
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0290, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x029f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02a1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02a2, code lost:
        r29 = "_si";
        r30 = "_sc";
        r28 = "_npa";
        r9 = r6;
        r7 = r47;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02b0, code lost:
        r9 = r47;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02c1, code lost:
        r2 = r0;
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02c4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02c5, code lost:
        r29 = "_si";
        r30 = "_sc";
        r28 = "_npa";
        r9 = r6;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02ce, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02cf, code lost:
        r29 = "_si";
        r30 = "_sc";
        r28 = "_npa";
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02d8, code lost:
        r2 = r0;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02da, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02dd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02de, code lost:
        r29 = "_si";
        r30 = "_sc";
        r28 = "_npa";
        r9 = r6;
        r27 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02e7, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02fe, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:646:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01c0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0285 A[ExcHandler: all (r0v17 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r5 
      PHI: (r5v114 android.database.Cursor) = (r5v110 android.database.Cursor), (r5v110 android.database.Cursor), (r5v110 android.database.Cursor), (r5v110 android.database.Cursor), (r5v110 android.database.Cursor), (r5v119 android.database.Cursor), (r5v119 android.database.Cursor), (r5v119 android.database.Cursor), (r5v119 android.database.Cursor), (r5v119 android.database.Cursor), (r5v119 android.database.Cursor), (r5v119 android.database.Cursor), (r5v110 android.database.Cursor), (r5v110 android.database.Cursor), (r5v110 android.database.Cursor), (r5v110 android.database.Cursor), (r5v110 android.database.Cursor), (r5v110 android.database.Cursor) binds: [B:68:0x0142, B:73:0x0164, B:75:0x0176, B:88:0x01a1, B:89:?, B:105:0x0215, B:107:0x021e, B:110:0x0229, B:111:?, B:113:0x0232, B:101:0x0200, B:102:?, B:97:0x01c5, B:93:0x01b0, B:94:?, B:78:0x017c, B:81:0x018a, B:82:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:68:0x0142] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029f A[ExcHandler: all (r0v12 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:63:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02c0 A[ExcHandler: all (r0v10 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r7 
      PHI: (r7v75 android.database.Cursor) = (r7v109 android.database.Cursor), (r7v109 android.database.Cursor), (r7v109 android.database.Cursor), (r7v121 android.database.Cursor), (r7v121 android.database.Cursor), (r7v121 android.database.Cursor) binds: [B:52:0x00fc, B:59:0x010f, B:60:?, B:21:0x0082, B:27:0x0090, B:28:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:21:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02d7 A[ExcHandler: all (r0v8 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0306 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0314 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x04e8 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x04ea A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x04ed A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x04ee A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x050c A[SYNTHETIC, Splitter:B:247:0x050c] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x059f A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x05f9 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x05fd A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x065d A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x068d A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x06aa A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x079e A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0971 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x0996 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x09ad A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:518:0x0d22 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:519:0x0d35 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:521:0x0d38 A[Catch:{ all -> 0x10cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:523:0x0d5e A[SYNTHETIC, Splitter:B:523:0x0d5e] */
    /* JADX WARNING: Removed duplicated region for block: B:637:0x10b1  */
    /* JADX WARNING: Removed duplicated region for block: B:645:0x10c8 A[SYNTHETIC, Splitter:B:645:0x10c8] */
    /* JADX WARNING: Removed duplicated region for block: B:663:0x0567 A[EDGE_INSN: B:663:0x0567->B:255:0x0567 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0148 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x015f A[Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x0102=Splitter:B:55:0x0102, B:159:0x02ff=Splitter:B:159:0x02ff} */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean s(long r47) {
        /*
            r46 = this;
            r1 = r46
            java.lang.String r2 = "_si"
            java.lang.String r3 = "_sc"
            java.lang.String r4 = "_sn"
            java.lang.String r5 = "_npa"
            java.lang.String r6 = "_ai"
            java.lang.String r7 = ""
            a.d.a.a.i.b.d r8 = r46.J()
            r8.b0()
            a.d.a.a.i.b.o9$a r8 = new a.d.a.a.i.b.o9$a     // Catch:{ all -> 0x10cf }
            r9 = 0
            r8.<init>(r1, r9)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.d r10 = r46.J()     // Catch:{ all -> 0x10cf }
            long r11 = r1.x     // Catch:{ all -> 0x10cf }
            a.c.a.f.b.k(r8)     // Catch:{ all -> 0x10cf }
            r10.b()     // Catch:{ all -> 0x10cf }
            r10.n()     // Catch:{ all -> 0x10cf }
            r14 = -1
            android.database.sqlite.SQLiteDatabase r13 = r10.t()     // Catch:{ SQLiteException -> 0x02dd, all -> 0x02d7 }
            boolean r18 = android.text.TextUtils.isEmpty(r9)     // Catch:{ SQLiteException -> 0x02dd, all -> 0x02d7 }
            if (r18 == 0) goto L_0x00aa
            int r18 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r18 == 0) goto L_0x004c
            r9 = 2
            java.lang.String[] r14 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
            r15 = 0
            r14[r15] = r9     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
            java.lang.String r9 = java.lang.String.valueOf(r47)     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
            r15 = 1
            r14[r15] = r9     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
            goto L_0x0056
        L_0x004c:
            r9 = 1
            java.lang.String[] r14 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
            java.lang.String r9 = java.lang.String.valueOf(r47)     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
            r15 = 0
            r14[r15] = r9     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
        L_0x0056:
            r18 = -1
            int r9 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r9 == 0) goto L_0x005f
            java.lang.String r9 = "rowid <= ? and "
            goto L_0x0060
        L_0x005f:
            r9 = r7
        L_0x0060:
            int r15 = r9.length()     // Catch:{ SQLiteException -> 0x00a5, all -> 0x02d7 }
            int r15 = r15 + 148
            r27 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            r7.<init>(r15)     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            java.lang.String r15 = "select app_id, metadata_fingerprint from raw_events where "
            r7.append(r15)     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            r7.append(r9)     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            java.lang.String r9 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r7.append(r9)     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            android.database.Cursor r7 = r13.rawQuery(r7, r14)     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            boolean r9 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x02c4, all -> 0x02c0 }
            if (r9 != 0) goto L_0x008a
            goto L_0x0102
        L_0x008a:
            r9 = 0
            java.lang.String r14 = r7.getString(r9)     // Catch:{ SQLiteException -> 0x02c4, all -> 0x02c0 }
            r9 = 1
            java.lang.String r15 = r7.getString(r9)     // Catch:{ SQLiteException -> 0x009a, all -> 0x02c0 }
            r7.close()     // Catch:{ SQLiteException -> 0x009a, all -> 0x02c0 }
            r9 = 0
            goto L_0x0117
        L_0x009a:
            r0 = move-exception
            r29 = r2
            r30 = r3
            r28 = r5
            r9 = r6
        L_0x00a2:
            r2 = r0
            goto L_0x02eb
        L_0x00a5:
            r0 = move-exception
            r27 = r7
        L_0x00a8:
            r7 = r0
            goto L_0x00d1
        L_0x00aa:
            r27 = r7
            int r7 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r7 == 0) goto L_0x00c1
            r7 = 2
            java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            r7 = 0
            r14 = 0
            r9[r14] = r7     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            java.lang.String r7 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            r14 = 1
            r9[r14] = r7     // Catch:{ SQLiteException -> 0x00bf, all -> 0x02d7 }
            goto L_0x00c8
        L_0x00bf:
            r0 = move-exception
            goto L_0x00a8
        L_0x00c1:
            r7 = 1
            java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            r7 = 0
            r14 = 0
            r9[r14] = r7     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
        L_0x00c8:
            r14 = -1
            int r7 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r7 == 0) goto L_0x00da
            java.lang.String r7 = " and rowid <= ?"
            goto L_0x00dc
        L_0x00d1:
            r29 = r2
            r30 = r3
            r28 = r5
            r9 = r6
            goto L_0x02e8
        L_0x00da:
            r7 = r27
        L_0x00dc:
            int r14 = r7.length()     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            int r14 = r14 + 84
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            r15.<init>(r14)     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            java.lang.String r14 = "select metadata_fingerprint from raw_events where app_id = ?"
            r15.append(r14)     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            r15.append(r7)     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            java.lang.String r7 = " order by rowid limit 1;"
            r15.append(r7)     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            java.lang.String r7 = r15.toString()     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            android.database.Cursor r7 = r13.rawQuery(r7, r9)     // Catch:{ SQLiteException -> 0x02ce, all -> 0x02d7 }
            boolean r9 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x02c4, all -> 0x02c0 }
            if (r9 != 0) goto L_0x010e
        L_0x0102:
            r7.close()     // Catch:{ all -> 0x10cf }
            r29 = r2
            r30 = r3
            r28 = r5
            r9 = r6
            goto L_0x0302
        L_0x010e:
            r9 = 0
            java.lang.String r15 = r7.getString(r9)     // Catch:{ SQLiteException -> 0x02c4, all -> 0x02c0 }
            r7.close()     // Catch:{ SQLiteException -> 0x02c4, all -> 0x02c0 }
            r14 = 0
        L_0x0117:
            java.lang.String r19 = "raw_events_metadata"
            r47 = r7
            r9 = 1
            java.lang.String[] r7 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x02a1, all -> 0x029f }
            java.lang.String r9 = "metadata"
            r17 = 0
            r7[r17] = r9     // Catch:{ SQLiteException -> 0x02a1, all -> 0x029f }
            java.lang.String r21 = "app_id = ? and metadata_fingerprint = ?"
            r28 = r5
            r9 = 2
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0294, all -> 0x029f }
            r5[r17] = r14     // Catch:{ SQLiteException -> 0x0294, all -> 0x029f }
            r9 = 1
            r5[r9] = r15     // Catch:{ SQLiteException -> 0x0294, all -> 0x029f }
            r23 = 0
            r24 = 0
            java.lang.String r25 = "rowid"
            java.lang.String r26 = "2"
            r18 = r13
            r20 = r7
            r22 = r5
            android.database.Cursor r5 = r18.query(r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ SQLiteException -> 0x0294, all -> 0x029f }
            boolean r7 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }
            if (r7 != 0) goto L_0x015f
            a.d.a.a.i.b.x3 r7 = r10.i()     // Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }
            a.d.a.a.i.b.z3 r7 = r7.z()     // Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }
            java.lang.String r9 = "Raw event metadata record is missing. appId"
            java.lang.Object r11 = a.d.a.a.i.b.x3.s(r14)     // Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }
            r7.b(r9, r11)     // Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }
            r29 = r2
            r30 = r3
            goto L_0x0211
        L_0x015f:
            r7 = 0
            byte[] r9 = r5.getBlob(r7)     // Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }
            a.d.a.a.h.g.b1$a r7 = a.d.a.a.h.g.b1.C()     // Catch:{ IOException -> 0x0269 }
            a.d.a.a.h.g.h7 r7 = a.d.a.a.i.b.s9.x(r7, r9)     // Catch:{ IOException -> 0x0269 }
            a.d.a.a.h.g.b1$a r7 = (a.d.a.a.h.g.b1.a) r7     // Catch:{ IOException -> 0x0269 }
            a.d.a.a.h.g.i7 r7 = r7.m()     // Catch:{ IOException -> 0x0269 }
            a.d.a.a.h.g.y5 r7 = (a.d.a.a.h.g.y5) r7     // Catch:{ IOException -> 0x0269 }
            a.d.a.a.h.g.b1 r7 = (a.d.a.a.h.g.b1) r7     // Catch:{ IOException -> 0x0269 }
            boolean r9 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x028a, all -> 0x0285 }
            if (r9 == 0) goto L_0x019d
            a.d.a.a.i.b.x3 r9 = r10.i()     // Catch:{ SQLiteException -> 0x0194, all -> 0x0285 }
            a.d.a.a.i.b.z3 r9 = r9.A()     // Catch:{ SQLiteException -> 0x0194, all -> 0x0285 }
            r29 = r2
            java.lang.String r2 = "Get multiple raw event metadata records, expected one. appId"
            r30 = r3
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r14)     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            r9.b(r2, r3)     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            goto L_0x01a1
        L_0x0192:
            r0 = move-exception
            goto L_0x0197
        L_0x0194:
            r0 = move-exception
            r29 = r2
        L_0x0197:
            r30 = r3
        L_0x0199:
            r2 = r0
            r9 = r6
            goto L_0x0291
        L_0x019d:
            r29 = r2
            r30 = r3
        L_0x01a1:
            r5.close()     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            r8.a(r7)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            r2 = -1
            int r7 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x01c2
            java.lang.String r2 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r3 = 3
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            r3 = 0
            r7[r3] = r14     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            r3 = 1
            r7[r3] = r15     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            r9 = 2
            r7[r9] = r3     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            goto L_0x01cd
        L_0x01c0:
            r0 = move-exception
            goto L_0x0199
        L_0x01c2:
            java.lang.String r2 = "app_id = ? and metadata_fingerprint = ?"
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            r3 = 0
            r7[r3] = r14     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            r3 = 1
            r7[r3] = r15     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
        L_0x01cd:
            r21 = r2
            r22 = r7
            java.lang.String r19 = "raw_events"
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            java.lang.String r3 = "rowid"
            r7 = 0
            r2[r7] = r3     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            java.lang.String r3 = "name"
            r7 = 1
            r2[r7] = r3     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            java.lang.String r3 = "timestamp"
            r7 = 2
            r2[r7] = r3     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            java.lang.String r3 = "data"
            r7 = 3
            r2[r7] = r3     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            r23 = 0
            r24 = 0
            java.lang.String r25 = "rowid"
            r26 = 0
            r18 = r13
            r20 = r2
            android.database.Cursor r5 = r18.query(r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            boolean r2 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            if (r2 != 0) goto L_0x0214
            a.d.a.a.i.b.x3 r2 = r10.i()     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            a.d.a.a.i.b.z3 r2 = r2.A()     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            java.lang.String r3 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r7 = a.d.a.a.i.b.x3.s(r14)     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
            r2.b(r3, r7)     // Catch:{ SQLiteException -> 0x01c0, all -> 0x0285 }
        L_0x0211:
            r9 = r6
            goto L_0x02ff
        L_0x0214:
            r2 = 0
            long r11 = r5.getLong(r2)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            r2 = 3
            byte[] r3 = r5.getBlob(r2)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            a.d.a.a.h.g.x0$a r2 = a.d.a.a.h.g.x0.C()     // Catch:{ IOException -> 0x0249 }
            a.d.a.a.h.g.h7 r2 = a.d.a.a.i.b.s9.x(r2, r3)     // Catch:{ IOException -> 0x0249 }
            a.d.a.a.h.g.x0$a r2 = (a.d.a.a.h.g.x0.a) r2     // Catch:{ IOException -> 0x0249 }
            r3 = 1
            java.lang.String r7 = r5.getString(r3)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            r2.q(r7)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0285 }
            r9 = r6
            r3 = 2
            long r6 = r5.getLong(r3)     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            r2.o(r6)     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            a.d.a.a.h.g.i7 r2 = r2.m()     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            a.d.a.a.h.g.x0 r2 = (a.d.a.a.h.g.x0) r2     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            boolean r2 = r8.b(r11, r2)     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            if (r2 != 0) goto L_0x025d
            goto L_0x02ff
        L_0x0249:
            r0 = move-exception
            r9 = r6
            r2 = r0
            a.d.a.a.i.b.x3 r3 = r10.i()     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            a.d.a.a.i.b.z3 r3 = r3.z()     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            java.lang.String r6 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r7 = a.d.a.a.i.b.x3.s(r14)     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            r3.c(r6, r7, r2)     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
        L_0x025d:
            boolean r2 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            if (r2 != 0) goto L_0x0265
            goto L_0x02ff
        L_0x0265:
            r6 = r9
            goto L_0x0214
        L_0x0267:
            r0 = move-exception
            goto L_0x028f
        L_0x0269:
            r0 = move-exception
            r29 = r2
            r30 = r3
            r9 = r6
            r2 = r0
            a.d.a.a.i.b.x3 r3 = r10.i()     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            a.d.a.a.i.b.z3 r3 = r3.z()     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            java.lang.String r6 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r7 = a.d.a.a.i.b.x3.s(r14)     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            r3.c(r6, r7, r2)     // Catch:{ SQLiteException -> 0x0283, all -> 0x0285 }
            goto L_0x02ff
        L_0x0283:
            r0 = move-exception
            goto L_0x0290
        L_0x0285:
            r0 = move-exception
            r2 = r0
            r9 = r5
            goto L_0x02da
        L_0x028a:
            r0 = move-exception
            r29 = r2
            r30 = r3
        L_0x028f:
            r9 = r6
        L_0x0290:
            r2 = r0
        L_0x0291:
            r7 = r5
            goto L_0x02eb
        L_0x0294:
            r0 = move-exception
            r29 = r2
            r30 = r3
            r9 = r6
            r2 = r0
            r7 = r47
            goto L_0x02eb
        L_0x029f:
            r0 = move-exception
            goto L_0x02b0
        L_0x02a1:
            r0 = move-exception
            r29 = r2
            r30 = r3
            r28 = r5
            r9 = r6
            r7 = r47
            goto L_0x00a2
        L_0x02ad:
            r0 = move-exception
            r47 = r7
        L_0x02b0:
            r9 = r47
            r2 = r0
            goto L_0x02da
        L_0x02b4:
            r0 = move-exception
            r29 = r2
            r30 = r3
            r28 = r5
            r9 = r6
            r47 = r7
            goto L_0x00a2
        L_0x02c0:
            r0 = move-exception
            r2 = r0
            r9 = r7
            goto L_0x02da
        L_0x02c4:
            r0 = move-exception
            r29 = r2
            r30 = r3
            r28 = r5
            r9 = r6
            r2 = r0
            goto L_0x02ea
        L_0x02ce:
            r0 = move-exception
            r29 = r2
            r30 = r3
            r28 = r5
            r9 = r6
            goto L_0x02e7
        L_0x02d7:
            r0 = move-exception
            r2 = r0
            r9 = 0
        L_0x02da:
            r4 = r1
            goto L_0x10c6
        L_0x02dd:
            r0 = move-exception
            r29 = r2
            r30 = r3
            r28 = r5
            r9 = r6
            r27 = r7
        L_0x02e7:
            r7 = r0
        L_0x02e8:
            r2 = r7
            r7 = 0
        L_0x02ea:
            r14 = 0
        L_0x02eb:
            a.d.a.a.i.b.x3 r3 = r10.i()     // Catch:{ all -> 0x10c2 }
            a.d.a.a.i.b.z3 r3 = r3.z()     // Catch:{ all -> 0x10c2 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r6 = a.d.a.a.i.b.x3.s(r14)     // Catch:{ all -> 0x10c2 }
            r3.c(r5, r6, r2)     // Catch:{ all -> 0x10c2 }
            if (r7 == 0) goto L_0x0302
            r5 = r7
        L_0x02ff:
            r5.close()     // Catch:{ all -> 0x10cf }
        L_0x0302:
            java.util.List<a.d.a.a.h.g.x0> r2 = r8.f2449c     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0311
            java.util.List<a.d.a.a.h.g.x0> r2 = r8.f2449c     // Catch:{ all -> 0x10cf }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x030f
            goto L_0x0311
        L_0x030f:
            r2 = 0
            goto L_0x0312
        L_0x0311:
            r2 = 1
        L_0x0312:
            if (r2 != 0) goto L_0x10b1
            a.d.a.a.h.g.b1 r2 = r8.f2447a     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5$b r2 = r2.r()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1$a r2 = (a.d.a.a.h.g.b1.a) r2     // Catch:{ all -> 0x10cf }
            r2.D()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ka r3 = r3.b()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r5 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = r5.W()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.V     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.u(r5, r6)     // Catch:{ all -> 0x10cf }
            r5 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = -1
            r18 = 0
        L_0x033a:
            java.util.List<a.d.a.a.h.g.x0> r6 = r8.f2449c     // Catch:{ all -> 0x10cf }
            int r6 = r6.size()     // Catch:{ all -> 0x10cf }
            java.lang.String r7 = "_fr"
            r21 = r10
            java.lang.String r10 = "_et"
            r22 = r11
            java.lang.String r11 = "_e"
            r24 = r3
            r23 = r4
            if (r12 >= r6) goto L_0x0a0a
            java.util.List<a.d.a.a.h.g.x0> r6 = r8.f2449c     // Catch:{ all -> 0x10cf }
            java.lang.Object r6 = r6.get(r12)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r6 = (a.d.a.a.h.g.x0) r6     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5$b r6 = r6.r()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0$a r6 = (a.d.a.a.h.g.x0.a) r6     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.w4 r3 = r46.G()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r4 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = r4.W()     // Catch:{ all -> 0x10cf }
            r31 = r12
            java.lang.String r12 = r6.w()     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.x(r4, r12)     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = "_err"
            if (r3 == 0) goto L_0x03f7
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r3 = r3.A()     // Catch:{ all -> 0x10cf }
            java.lang.String r7 = "Dropping blacklisted raw event. appId"
            a.d.a.a.h.g.b1 r10 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r10 = r10.W()     // Catch:{ all -> 0x10cf }
            java.lang.Object r10 = a.d.a.a.i.b.x3.s(r10)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.c5 r11 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.v3 r11 = r11.u()     // Catch:{ all -> 0x10cf }
            java.lang.String r12 = r6.w()     // Catch:{ all -> 0x10cf }
            java.lang.String r11 = r11.u(r12)     // Catch:{ all -> 0x10cf }
            r3.c(r7, r10, r11)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.w4 r3 = r46.G()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r7 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r7 = r7.W()     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.C(r7)     // Catch:{ all -> 0x10cf }
            if (r3 != 0) goto L_0x03c0
            a.d.a.a.i.b.w4 r3 = r46.G()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r7 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r7 = r7.W()     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.D(r7)     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x03be
            goto L_0x03c0
        L_0x03be:
            r3 = 0
            goto L_0x03c1
        L_0x03c0:
            r3 = 1
        L_0x03c1:
            if (r3 != 0) goto L_0x03e4
            java.lang.String r3 = r6.w()     // Catch:{ all -> 0x10cf }
            boolean r3 = r4.equals(r3)     // Catch:{ all -> 0x10cf }
            if (r3 != 0) goto L_0x03e4
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.v9 r3 = r3.t()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r4 = r8.f2447a     // Catch:{ all -> 0x10cf }
            r4.W()     // Catch:{ all -> 0x10cf }
            r4 = 11
            java.lang.String r7 = "_ev"
            java.lang.String r6 = r6.w()     // Catch:{ all -> 0x10cf }
            r10 = 0
            r3.f0(r4, r7, r6, r10)     // Catch:{ all -> 0x10cf }
        L_0x03e4:
            r12 = r2
            r33 = r9
            r11 = r22
            r10 = r29
            r9 = r30
            r4 = r31
            r44 = r23
            r23 = r14
            r14 = r44
            goto L_0x09f4
        L_0x03f7:
            boolean r3 = a.d.a.a.h.g.c9.b()     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x0487
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ka r3 = r3.b()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r12 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r12 = r12.W()     // Catch:{ all -> 0x10cf }
            r32 = r15
            a.d.a.a.i.b.n3<java.lang.Boolean> r15 = a.d.a.a.i.b.q.T0     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.u(r12, r15)     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x0489
            java.lang.String r3 = r6.w()     // Catch:{ all -> 0x10cf }
            java.lang.String r12 = a.d.a.a.i.b.z5.a(r9)     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.equals(r12)     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x0489
            r6.q(r9)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r3 = r3.D()     // Catch:{ all -> 0x10cf }
            java.lang.String r12 = "Renaming ad_impression to _ai"
            r3.a(r12)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.c5 r3 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x10cf }
            r12 = 5
            boolean r3 = r3.x(r12)     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x0489
            r3 = 0
        L_0x0441:
            int r12 = r6.t()     // Catch:{ all -> 0x10cf }
            if (r3 >= r12) goto L_0x0489
            java.lang.String r12 = "ad_platform"
            a.d.a.a.h.g.z0 r15 = r6.r(r3)     // Catch:{ all -> 0x10cf }
            java.lang.String r15 = r15.u()     // Catch:{ all -> 0x10cf }
            boolean r12 = r12.equals(r15)     // Catch:{ all -> 0x10cf }
            if (r12 == 0) goto L_0x0484
            a.d.a.a.h.g.z0 r12 = r6.r(r3)     // Catch:{ all -> 0x10cf }
            java.lang.String r12 = r12.x()     // Catch:{ all -> 0x10cf }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x10cf }
            if (r12 != 0) goto L_0x0484
            java.lang.String r12 = "admob"
            a.d.a.a.h.g.z0 r15 = r6.r(r3)     // Catch:{ all -> 0x10cf }
            java.lang.String r15 = r15.x()     // Catch:{ all -> 0x10cf }
            boolean r12 = r12.equalsIgnoreCase(r15)     // Catch:{ all -> 0x10cf }
            if (r12 == 0) goto L_0x0484
            a.d.a.a.i.b.c5 r12 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r12 = r12.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r12 = r12.B()     // Catch:{ all -> 0x10cf }
            java.lang.String r15 = "AdMob ad impression logged from app. Potentially duplicative."
            r12.a(r15)     // Catch:{ all -> 0x10cf }
        L_0x0484:
            int r3 = r3 + 1
            goto L_0x0441
        L_0x0487:
            r32 = r15
        L_0x0489:
            a.d.a.a.i.b.w4 r3 = r46.G()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r12 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r12 = r12.W()     // Catch:{ all -> 0x10cf }
            java.lang.String r15 = r6.w()     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.y(r12, r15)     // Catch:{ all -> 0x10cf }
            java.lang.String r12 = "_c"
            if (r3 != 0) goto L_0x04f9
            r46.M()     // Catch:{ all -> 0x10cf }
            java.lang.String r15 = r6.w()     // Catch:{ all -> 0x10cf }
            a.c.a.f.b.h(r15)     // Catch:{ all -> 0x10cf }
            r33 = r9
            int r9 = r15.hashCode()     // Catch:{ all -> 0x10cf }
            r34 = r13
            r13 = 94660(0x171c4, float:1.32647E-40)
            if (r9 == r13) goto L_0x04d5
            r13 = 95025(0x17331, float:1.33158E-40)
            if (r9 == r13) goto L_0x04cb
            r13 = 95027(0x17333, float:1.33161E-40)
            if (r9 == r13) goto L_0x04c1
            goto L_0x04df
        L_0x04c1:
            java.lang.String r9 = "_ui"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x10cf }
            if (r9 == 0) goto L_0x04df
            r9 = 1
            goto L_0x04e0
        L_0x04cb:
            java.lang.String r9 = "_ug"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x10cf }
            if (r9 == 0) goto L_0x04df
            r9 = 2
            goto L_0x04e0
        L_0x04d5:
            java.lang.String r9 = "_in"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x10cf }
            if (r9 == 0) goto L_0x04df
            r9 = 0
            goto L_0x04e0
        L_0x04df:
            r9 = -1
        L_0x04e0:
            if (r9 == 0) goto L_0x04ea
            r13 = 1
            if (r9 == r13) goto L_0x04ea
            r13 = 2
            if (r9 == r13) goto L_0x04ea
            r9 = 0
            goto L_0x04eb
        L_0x04ea:
            r9 = 1
        L_0x04eb:
            if (r9 == 0) goto L_0x04ee
            goto L_0x04fd
        L_0x04ee:
            r36 = r2
            r37 = r5
            r35 = r10
            r15 = r14
        L_0x04f5:
            r10 = r21
            goto L_0x06c5
        L_0x04f9:
            r33 = r9
            r34 = r13
        L_0x04fd:
            r35 = r10
            r9 = 0
            r13 = 0
            r15 = 0
        L_0x0502:
            int r10 = r6.t()     // Catch:{ all -> 0x10cf }
            r36 = r2
            java.lang.String r2 = "_r"
            if (r9 >= r10) goto L_0x0567
            a.d.a.a.h.g.z0 r10 = r6.r(r9)     // Catch:{ all -> 0x10cf }
            java.lang.String r10 = r10.u()     // Catch:{ all -> 0x10cf }
            boolean r10 = r12.equals(r10)     // Catch:{ all -> 0x10cf }
            if (r10 == 0) goto L_0x0537
            a.d.a.a.h.g.z0 r2 = r6.r(r9)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5$b r2 = r2.r()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0$a r2 = (a.d.a.a.h.g.z0.a) r2     // Catch:{ all -> 0x10cf }
            r10 = r14
            r13 = 1
            r2.o(r13)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r2 = r2.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r2 = (a.d.a.a.h.g.z0) r2     // Catch:{ all -> 0x10cf }
            r6.n(r9, r2)     // Catch:{ all -> 0x10cf }
            r13 = 1
            goto L_0x0561
        L_0x0537:
            r10 = r14
            a.d.a.a.h.g.z0 r14 = r6.r(r9)     // Catch:{ all -> 0x10cf }
            java.lang.String r14 = r14.u()     // Catch:{ all -> 0x10cf }
            boolean r2 = r2.equals(r14)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0561
            a.d.a.a.h.g.z0 r2 = r6.r(r9)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5$b r2 = r2.r()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0$a r2 = (a.d.a.a.h.g.z0.a) r2     // Catch:{ all -> 0x10cf }
            r14 = 1
            r2.o(r14)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r2 = r2.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r2 = (a.d.a.a.h.g.z0) r2     // Catch:{ all -> 0x10cf }
            r6.n(r9, r2)     // Catch:{ all -> 0x10cf }
            r15 = 1
        L_0x0561:
            int r9 = r9 + 1
            r14 = r10
            r2 = r36
            goto L_0x0502
        L_0x0567:
            r10 = r14
            if (r13 != 0) goto L_0x059b
            if (r3 == 0) goto L_0x059b
            a.d.a.a.i.b.c5 r9 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r9 = r9.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r9 = r9.D()     // Catch:{ all -> 0x10cf }
            java.lang.String r13 = "Marking event as conversion"
            a.d.a.a.i.b.c5 r14 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.v3 r14 = r14.u()     // Catch:{ all -> 0x10cf }
            r37 = r5
            java.lang.String r5 = r6.w()     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = r14.u(r5)     // Catch:{ all -> 0x10cf }
            r9.b(r13, r5)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0$a r5 = a.d.a.a.h.g.z0.E()     // Catch:{ all -> 0x10cf }
            r5.q(r12)     // Catch:{ all -> 0x10cf }
            r13 = 1
            r5.o(r13)     // Catch:{ all -> 0x10cf }
            r6.p(r5)     // Catch:{ all -> 0x10cf }
            goto L_0x059d
        L_0x059b:
            r37 = r5
        L_0x059d:
            if (r15 != 0) goto L_0x05cb
            a.d.a.a.i.b.c5 r5 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r5 = r5.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r5 = r5.D()     // Catch:{ all -> 0x10cf }
            java.lang.String r9 = "Marking event as real-time"
            a.d.a.a.i.b.c5 r13 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.v3 r13 = r13.u()     // Catch:{ all -> 0x10cf }
            java.lang.String r14 = r6.w()     // Catch:{ all -> 0x10cf }
            java.lang.String r13 = r13.u(r14)     // Catch:{ all -> 0x10cf }
            r5.b(r9, r13)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0$a r5 = a.d.a.a.h.g.z0.E()     // Catch:{ all -> 0x10cf }
            r5.q(r2)     // Catch:{ all -> 0x10cf }
            r13 = 1
            r5.o(r13)     // Catch:{ all -> 0x10cf }
            r6.p(r5)     // Catch:{ all -> 0x10cf }
        L_0x05cb:
            a.d.a.a.i.b.d r38 = r46.J()     // Catch:{ all -> 0x10cf }
            long r39 = r46.U()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r5 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r41 = r5.W()     // Catch:{ all -> 0x10cf }
            r42 = 0
            r43 = 1
            a.d.a.a.i.b.f r5 = r38.y(r39, r41, r42, r43)     // Catch:{ all -> 0x10cf }
            long r13 = r5.f2181e     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.c5 r5 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ka r5 = r5.b()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r9 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r9 = r9.W()     // Catch:{ all -> 0x10cf }
            int r5 = r5.r(r9)     // Catch:{ all -> 0x10cf }
            r15 = r10
            long r9 = (long) r5     // Catch:{ all -> 0x10cf }
            int r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x05fd
            e(r6, r2)     // Catch:{ all -> 0x10cf }
            goto L_0x05ff
        L_0x05fd:
            r21 = 1
        L_0x05ff:
            java.lang.String r2 = r6.w()     // Catch:{ all -> 0x10cf }
            boolean r2 = a.d.a.a.i.b.v9.V(r2)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x04f5
            if (r3 == 0) goto L_0x04f5
            a.d.a.a.i.b.d r38 = r46.J()     // Catch:{ all -> 0x10cf }
            long r39 = r46.U()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r2 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r41 = r2.W()     // Catch:{ all -> 0x10cf }
            r42 = 1
            r43 = 0
            a.d.a.a.i.b.f r2 = r38.y(r39, r41, r42, r43)     // Catch:{ all -> 0x10cf }
            long r9 = r2.f2179c     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ka r2 = r2.b()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r5 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = r5.W()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.n3<java.lang.Integer> r13 = a.d.a.a.i.b.q.n     // Catch:{ all -> 0x10cf }
            int r2 = r2.q(r5, r13)     // Catch:{ all -> 0x10cf }
            long r13 = (long) r2     // Catch:{ all -> 0x10cf }
            int r2 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x04f5
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r2 = r2.A()     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = "Too many conversions. Not logging as conversion. appId"
            a.d.a.a.h.g.b1 r9 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r9 = r9.W()     // Catch:{ all -> 0x10cf }
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r9)     // Catch:{ all -> 0x10cf }
            r2.b(r5, r9)     // Catch:{ all -> 0x10cf }
            r2 = 0
            r5 = 0
            r9 = -1
            r10 = 0
        L_0x0657:
            int r13 = r6.t()     // Catch:{ all -> 0x10cf }
            if (r2 >= r13) goto L_0x0682
            a.d.a.a.h.g.z0 r13 = r6.r(r2)     // Catch:{ all -> 0x10cf }
            java.lang.String r14 = r13.u()     // Catch:{ all -> 0x10cf }
            boolean r14 = r12.equals(r14)     // Catch:{ all -> 0x10cf }
            if (r14 == 0) goto L_0x0674
            a.d.a.a.h.g.y5$b r9 = r13.r()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0$a r9 = (a.d.a.a.h.g.z0.a) r9     // Catch:{ all -> 0x10cf }
            r10 = r9
            r9 = r2
            goto L_0x067f
        L_0x0674:
            java.lang.String r13 = r13.u()     // Catch:{ all -> 0x10cf }
            boolean r13 = r4.equals(r13)     // Catch:{ all -> 0x10cf }
            if (r13 == 0) goto L_0x067f
            r5 = 1
        L_0x067f:
            int r2 = r2 + 1
            goto L_0x0657
        L_0x0682:
            if (r5 == 0) goto L_0x068b
            if (r10 == 0) goto L_0x068b
            r6.u(r9)     // Catch:{ all -> 0x10cf }
            goto L_0x04f5
        L_0x068b:
            if (r10 == 0) goto L_0x06aa
            java.lang.Object r2 = r10.clone()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5$b r2 = (a.d.a.a.h.g.y5.b) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0$a r2 = (a.d.a.a.h.g.z0.a) r2     // Catch:{ all -> 0x10cf }
            r2.q(r4)     // Catch:{ all -> 0x10cf }
            r4 = 10
            r2.o(r4)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r2 = r2.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r2 = (a.d.a.a.h.g.z0) r2     // Catch:{ all -> 0x10cf }
            r6.n(r9, r2)     // Catch:{ all -> 0x10cf }
            goto L_0x04f5
        L_0x06aa:
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r2 = r2.z()     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = "Did not find conversion parameter. appId"
            a.d.a.a.h.g.b1 r5 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = r5.W()     // Catch:{ all -> 0x10cf }
            java.lang.Object r5 = a.d.a.a.i.b.x3.s(r5)     // Catch:{ all -> 0x10cf }
            r2.b(r4, r5)     // Catch:{ all -> 0x10cf }
            goto L_0x04f5
        L_0x06c5:
            if (r3 == 0) goto L_0x0788
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x10cf }
            java.util.List r3 = r6.s()     // Catch:{ all -> 0x10cf }
            r2.<init>(r3)     // Catch:{ all -> 0x10cf }
            r3 = 0
            r4 = -1
            r5 = -1
        L_0x06d3:
            int r9 = r2.size()     // Catch:{ all -> 0x10cf }
            java.lang.String r13 = "currency"
            java.lang.String r14 = "value"
            if (r3 >= r9) goto L_0x0703
            java.lang.Object r9 = r2.get(r3)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r9 = (a.d.a.a.h.g.z0) r9     // Catch:{ all -> 0x10cf }
            java.lang.String r9 = r9.u()     // Catch:{ all -> 0x10cf }
            boolean r9 = r14.equals(r9)     // Catch:{ all -> 0x10cf }
            if (r9 == 0) goto L_0x06ef
            r4 = r3
            goto L_0x0700
        L_0x06ef:
            java.lang.Object r9 = r2.get(r3)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r9 = (a.d.a.a.h.g.z0) r9     // Catch:{ all -> 0x10cf }
            java.lang.String r9 = r9.u()     // Catch:{ all -> 0x10cf }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x10cf }
            if (r9 == 0) goto L_0x0700
            r5 = r3
        L_0x0700:
            int r3 = r3 + 1
            goto L_0x06d3
        L_0x0703:
            r3 = -1
            if (r4 == r3) goto L_0x0789
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r3 = (a.d.a.a.h.g.z0) r3     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.z()     // Catch:{ all -> 0x10cf }
            if (r3 != 0) goto L_0x0739
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r3 = (a.d.a.a.h.g.z0) r3     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.B()     // Catch:{ all -> 0x10cf }
            if (r3 != 0) goto L_0x0739
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r2 = r2.B()     // Catch:{ all -> 0x10cf }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.a(r3)     // Catch:{ all -> 0x10cf }
            r6.u(r4)     // Catch:{ all -> 0x10cf }
            e(r6, r12)     // Catch:{ all -> 0x10cf }
            r2 = 18
            d(r6, r2, r14)     // Catch:{ all -> 0x10cf }
            goto L_0x0788
        L_0x0739:
            r3 = -1
            if (r5 != r3) goto L_0x073f
            r2 = 1
            r9 = 3
            goto L_0x076b
        L_0x073f:
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r2 = (a.d.a.a.h.g.z0) r2     // Catch:{ all -> 0x10cf }
            java.lang.String r2 = r2.x()     // Catch:{ all -> 0x10cf }
            int r5 = r2.length()     // Catch:{ all -> 0x10cf }
            r9 = 3
            if (r5 == r9) goto L_0x0751
            goto L_0x0762
        L_0x0751:
            r5 = 0
        L_0x0752:
            int r14 = r2.length()     // Catch:{ all -> 0x10cf }
            if (r5 >= r14) goto L_0x076a
            int r14 = r2.codePointAt(r5)     // Catch:{ all -> 0x10cf }
            boolean r16 = java.lang.Character.isLetter(r14)     // Catch:{ all -> 0x10cf }
            if (r16 != 0) goto L_0x0764
        L_0x0762:
            r2 = 1
            goto L_0x076b
        L_0x0764:
            int r14 = java.lang.Character.charCount(r14)     // Catch:{ all -> 0x10cf }
            int r5 = r5 + r14
            goto L_0x0752
        L_0x076a:
            r2 = 0
        L_0x076b:
            if (r2 == 0) goto L_0x078a
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r2 = r2.B()     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.a(r5)     // Catch:{ all -> 0x10cf }
            r6.u(r4)     // Catch:{ all -> 0x10cf }
            e(r6, r12)     // Catch:{ all -> 0x10cf }
            r2 = 19
            d(r6, r2, r13)     // Catch:{ all -> 0x10cf }
            goto L_0x078a
        L_0x0788:
            r3 = -1
        L_0x0789:
            r9 = 3
        L_0x078a:
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ka r2 = r2.b()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r4 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = r4.W()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.U     // Catch:{ all -> 0x10cf }
            boolean r2 = r2.u(r4, r5)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0971
            java.lang.String r2 = r6.w()     // Catch:{ all -> 0x10cf }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x10cf }
            r4 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x0811
            r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r2 = r6.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r2 = (a.d.a.a.h.g.x0) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r2 = a.d.a.a.i.b.s9.w(r2, r7)     // Catch:{ all -> 0x10cf }
            if (r2 != 0) goto L_0x0801
            if (r15 == 0) goto L_0x07ea
            long r12 = r15.x()     // Catch:{ all -> 0x10cf }
            long r20 = r6.x()     // Catch:{ all -> 0x10cf }
            long r12 = r12 - r20
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x10cf }
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x07ea
            java.lang.Object r2 = r15.clone()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5$b r2 = (a.d.a.a.h.g.y5.b) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0$a r2 = (a.d.a.a.h.g.x0.a) r2     // Catch:{ all -> 0x10cf }
            boolean r4 = r1.t(r6, r2)     // Catch:{ all -> 0x10cf }
            if (r4 == 0) goto L_0x07ea
            r12 = r36
            r7 = r37
            r12.o(r7, r2)     // Catch:{ all -> 0x10cf }
            r4 = r32
            r13 = r35
            goto L_0x085b
        L_0x07ea:
            r12 = r36
            r7 = r37
            r34 = r6
            r5 = r7
            r21 = r10
            r14 = r23
            r10 = r29
            r9 = r30
            r13 = r35
            r23 = r15
            r15 = r22
            goto L_0x0984
        L_0x0801:
            r12 = r36
            r21 = r10
            r14 = r23
            r10 = r29
            r9 = r30
            r4 = r32
            r13 = r35
            goto L_0x097f
        L_0x0811:
            r12 = r36
            r7 = r37
            java.lang.String r2 = "_vs"
            java.lang.String r13 = r6.w()     // Catch:{ all -> 0x10cf }
            boolean r2 = r2.equals(r13)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0880
            r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r2 = r6.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r2 = (a.d.a.a.h.g.x0) r2     // Catch:{ all -> 0x10cf }
            r13 = r35
            a.d.a.a.h.g.z0 r2 = a.d.a.a.i.b.s9.w(r2, r13)     // Catch:{ all -> 0x10cf }
            if (r2 != 0) goto L_0x087c
            if (r34 == 0) goto L_0x086b
            long r14 = r34.x()     // Catch:{ all -> 0x10cf }
            long r20 = r6.x()     // Catch:{ all -> 0x10cf }
            long r14 = r14 - r20
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x10cf }
            int r2 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x086b
            java.lang.Object r2 = r34.clone()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5$b r2 = (a.d.a.a.h.g.y5.b) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0$a r2 = (a.d.a.a.h.g.x0.a) r2     // Catch:{ all -> 0x10cf }
            boolean r4 = r1.t(r2, r6)     // Catch:{ all -> 0x10cf }
            if (r4 == 0) goto L_0x086b
            r4 = r32
            r12.o(r4, r2)     // Catch:{ all -> 0x10cf }
        L_0x085b:
            r15 = r4
            r5 = r7
            r21 = r10
            r14 = r23
            r10 = r29
            r9 = r30
            r23 = 0
        L_0x0867:
            r34 = 0
            goto L_0x0984
        L_0x086b:
            r4 = r32
            r15 = r4
            r21 = r10
            r5 = r22
            r14 = r23
            r10 = r29
            r9 = r30
            r23 = r6
            goto L_0x0984
        L_0x087c:
            r4 = r32
            goto L_0x0966
        L_0x0880:
            r4 = r32
            r13 = r35
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ka r2 = r2.b()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r5 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = r5.W()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.n3<java.lang.Boolean> r14 = a.d.a.a.i.b.q.o0     // Catch:{ all -> 0x10cf }
            boolean r2 = r2.u(r5, r14)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0966
            java.lang.String r2 = "_ab"
            java.lang.String r5 = r6.w()     // Catch:{ all -> 0x10cf }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0966
            r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r2 = r6.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r2 = (a.d.a.a.h.g.x0) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r2 = a.d.a.a.i.b.s9.w(r2, r13)     // Catch:{ all -> 0x10cf }
            if (r2 != 0) goto L_0x0966
            if (r34 == 0) goto L_0x0966
            long r20 = r34.x()     // Catch:{ all -> 0x10cf }
            long r25 = r6.x()     // Catch:{ all -> 0x10cf }
            long r20 = r20 - r25
            long r20 = java.lang.Math.abs(r20)     // Catch:{ all -> 0x10cf }
            r25 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r20 > r25 ? 1 : (r20 == r25 ? 0 : -1))
            if (r2 > 0) goto L_0x0966
            java.lang.Object r2 = r34.clone()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5$b r2 = (a.d.a.a.h.g.y5.b) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0$a r2 = (a.d.a.a.h.g.x0.a) r2     // Catch:{ all -> 0x10cf }
            r1.z(r2, r6)     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = r2.w()     // Catch:{ all -> 0x10cf }
            boolean r5 = r11.equals(r5)     // Catch:{ all -> 0x10cf }
            a.c.a.f.b.d(r5)     // Catch:{ all -> 0x10cf }
            r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r5 = r2.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r5 = (a.d.a.a.h.g.y5) r5     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r5 = (a.d.a.a.h.g.x0) r5     // Catch:{ all -> 0x10cf }
            r14 = r23
            a.d.a.a.h.g.z0 r5 = a.d.a.a.i.b.s9.w(r5, r14)     // Catch:{ all -> 0x10cf }
            r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r16 = r2.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r16 = (a.d.a.a.h.g.y5) r16     // Catch:{ all -> 0x10cf }
            r3 = r16
            a.d.a.a.h.g.x0 r3 = (a.d.a.a.h.g.x0) r3     // Catch:{ all -> 0x10cf }
            r9 = r30
            a.d.a.a.h.g.z0 r3 = a.d.a.a.i.b.s9.w(r3, r9)     // Catch:{ all -> 0x10cf }
            r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r21 = r2.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r21 = (a.d.a.a.h.g.y5) r21     // Catch:{ all -> 0x10cf }
            r37 = r7
            r7 = r21
            a.d.a.a.h.g.x0 r7 = (a.d.a.a.h.g.x0) r7     // Catch:{ all -> 0x10cf }
            r21 = r10
            r10 = r29
            a.d.a.a.h.g.z0 r7 = a.d.a.a.i.b.s9.w(r7, r10)     // Catch:{ all -> 0x10cf }
            if (r5 == 0) goto L_0x0923
            java.lang.String r5 = r5.x()     // Catch:{ all -> 0x10cf }
            goto L_0x0925
        L_0x0923:
            r5 = r27
        L_0x0925:
            boolean r23 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x10cf }
            if (r23 != 0) goto L_0x0935
            r23 = r15
            a.d.a.a.i.b.s9 r15 = r46.M()     // Catch:{ all -> 0x10cf }
            r15.E(r6, r14, r5)     // Catch:{ all -> 0x10cf }
            goto L_0x0937
        L_0x0935:
            r23 = r15
        L_0x0937:
            if (r3 == 0) goto L_0x093e
            java.lang.String r3 = r3.x()     // Catch:{ all -> 0x10cf }
            goto L_0x0940
        L_0x093e:
            r3 = r27
        L_0x0940:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x10cf }
            if (r5 != 0) goto L_0x094d
            a.d.a.a.i.b.s9 r5 = r46.M()     // Catch:{ all -> 0x10cf }
            r5.E(r6, r9, r3)     // Catch:{ all -> 0x10cf }
        L_0x094d:
            if (r7 == 0) goto L_0x095e
            a.d.a.a.i.b.s9 r3 = r46.M()     // Catch:{ all -> 0x10cf }
            long r25 = r7.A()     // Catch:{ all -> 0x10cf }
            java.lang.Long r5 = java.lang.Long.valueOf(r25)     // Catch:{ all -> 0x10cf }
            r3.E(r6, r10, r5)     // Catch:{ all -> 0x10cf }
        L_0x095e:
            r12.o(r4, r2)     // Catch:{ all -> 0x10cf }
            r15 = r4
            r5 = r37
            goto L_0x0867
        L_0x0966:
            r37 = r7
            r21 = r10
            r14 = r23
            r10 = r29
            r9 = r30
            goto L_0x097f
        L_0x0971:
            r21 = r10
            r14 = r23
            r10 = r29
            r9 = r30
            r4 = r32
            r13 = r35
            r12 = r36
        L_0x097f:
            r23 = r15
            r15 = r4
            r5 = r37
        L_0x0984:
            if (r24 != 0) goto L_0x09de
            java.lang.String r2 = r6.w()     // Catch:{ all -> 0x10cf }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x09de
            int r2 = r6.t()     // Catch:{ all -> 0x10cf }
            if (r2 != 0) goto L_0x09ad
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r2 = r2.A()     // Catch:{ all -> 0x10cf }
            java.lang.String r3 = "Engagement event does not contain any parameters. appId"
            a.d.a.a.h.g.b1 r4 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = r4.W()     // Catch:{ all -> 0x10cf }
        L_0x09a8:
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r4)     // Catch:{ all -> 0x10cf }
            goto L_0x09d4
        L_0x09ad:
            a.d.a.a.i.b.s9 r2 = r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r3 = r6.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r3 = (a.d.a.a.h.g.y5) r3     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r3 = (a.d.a.a.h.g.x0) r3     // Catch:{ all -> 0x10cf }
            java.lang.Object r2 = r2.R(r3, r13)     // Catch:{ all -> 0x10cf }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x10cf }
            if (r2 != 0) goto L_0x09d8
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r2 = r2.A()     // Catch:{ all -> 0x10cf }
            java.lang.String r3 = "Engagement event does not include duration. appId"
            a.d.a.a.h.g.b1 r4 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = r4.W()     // Catch:{ all -> 0x10cf }
            goto L_0x09a8
        L_0x09d4:
            r2.b(r3, r4)     // Catch:{ all -> 0x10cf }
            goto L_0x09de
        L_0x09d8:
            long r2 = r2.longValue()     // Catch:{ all -> 0x10cf }
            long r18 = r18 + r2
        L_0x09de:
            java.util.List<a.d.a.a.h.g.x0> r2 = r8.f2449c     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r3 = r6.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r3 = (a.d.a.a.h.g.y5) r3     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r3 = (a.d.a.a.h.g.x0) r3     // Catch:{ all -> 0x10cf }
            r4 = r31
            r2.set(r4, r3)     // Catch:{ all -> 0x10cf }
            int r11 = r22 + 1
            r12.r(r6)     // Catch:{ all -> 0x10cf }
            r13 = r34
        L_0x09f4:
            int r2 = r4 + 1
            r30 = r9
            r29 = r10
            r4 = r14
            r10 = r21
            r14 = r23
            r3 = r24
            r9 = r33
            r44 = r12
            r12 = r2
            r2 = r44
            goto L_0x033a
        L_0x0a0a:
            r12 = r2
            r13 = r10
            if (r24 == 0) goto L_0x0a60
            r2 = r22
            r3 = 0
        L_0x0a11:
            if (r3 >= r2) goto L_0x0a60
            a.d.a.a.h.g.x0 r4 = r12.z(r3)     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = r4.z()     // Catch:{ all -> 0x10cf }
            boolean r5 = r11.equals(r5)     // Catch:{ all -> 0x10cf }
            if (r5 == 0) goto L_0x0a32
            r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r5 = a.d.a.a.i.b.s9.w(r4, r7)     // Catch:{ all -> 0x10cf }
            if (r5 == 0) goto L_0x0a32
            r12.E(r3)     // Catch:{ all -> 0x10cf }
            int r2 = r2 + -1
            int r3 = r3 + -1
            goto L_0x0a5d
        L_0x0a32:
            r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r4 = a.d.a.a.i.b.s9.w(r4, r13)     // Catch:{ all -> 0x10cf }
            if (r4 == 0) goto L_0x0a5d
            boolean r5 = r4.z()     // Catch:{ all -> 0x10cf }
            if (r5 == 0) goto L_0x0a4a
            long r4 = r4.A()     // Catch:{ all -> 0x10cf }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x10cf }
            goto L_0x0a4b
        L_0x0a4a:
            r4 = 0
        L_0x0a4b:
            if (r4 == 0) goto L_0x0a5d
            long r5 = r4.longValue()     // Catch:{ all -> 0x10cf }
            r9 = 0
            int r14 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r14 <= 0) goto L_0x0a5d
            long r4 = r4.longValue()     // Catch:{ all -> 0x10cf }
            long r18 = r18 + r4
        L_0x0a5d:
            r4 = 1
            int r3 = r3 + r4
            goto L_0x0a11
        L_0x0a60:
            r2 = r18
            r4 = 0
            r1.h(r12, r2, r4)     // Catch:{ all -> 0x10cf }
            java.util.List r4 = r12.x()     // Catch:{ all -> 0x10cf }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x10cf }
        L_0x0a6e:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x10cf }
            if (r5 == 0) goto L_0x0a88
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r5 = (a.d.a.a.h.g.x0) r5     // Catch:{ all -> 0x10cf }
            java.lang.String r6 = "_s"
            java.lang.String r5 = r5.z()     // Catch:{ all -> 0x10cf }
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x10cf }
            if (r5 == 0) goto L_0x0a6e
            r4 = 1
            goto L_0x0a89
        L_0x0a88:
            r4 = 0
        L_0x0a89:
            java.lang.String r5 = "_se"
            if (r4 == 0) goto L_0x0a98
            a.d.a.a.i.b.d r4 = r46.J()     // Catch:{ all -> 0x10cf }
            java.lang.String r6 = r12.j0()     // Catch:{ all -> 0x10cf }
            r4.V(r6, r5)     // Catch:{ all -> 0x10cf }
        L_0x0a98:
            java.lang.String r4 = "_sid"
            int r4 = a.d.a.a.i.b.s9.s(r12, r4)     // Catch:{ all -> 0x10cf }
            if (r4 < 0) goto L_0x0aa2
            r4 = 1
            goto L_0x0aa3
        L_0x0aa2:
            r4 = 0
        L_0x0aa3:
            if (r4 == 0) goto L_0x0aaa
            r4 = 1
            r1.h(r12, r2, r4)     // Catch:{ all -> 0x10cf }
            goto L_0x0acc
        L_0x0aaa:
            int r2 = a.d.a.a.i.b.s9.s(r12, r5)     // Catch:{ all -> 0x10cf }
            if (r2 < 0) goto L_0x0acc
            r12.O(r2)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r2 = r2.z()     // Catch:{ all -> 0x10cf }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            a.d.a.a.h.g.b1 r4 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = r4.W()     // Catch:{ all -> 0x10cf }
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r4)     // Catch:{ all -> 0x10cf }
            r2.b(r3, r4)     // Catch:{ all -> 0x10cf }
        L_0x0acc:
            a.d.a.a.i.b.s9 r2 = r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r3 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r3 = r3.D()     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = "Checking account type status for ad personalization signals"
            r3.a(r4)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.w4 r3 = r2.r()     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = r12.j0()     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.A(r4)     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x0b5a
            a.d.a.a.i.b.d r3 = r2.q()     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = r12.j0()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.a4 r3 = r3.T(r4)     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x0b5a
            boolean r3 = r3.h()     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x0b5a
            a.d.a.a.i.b.k r3 = r2.c()     // Catch:{ all -> 0x10cf }
            boolean r3 = r3.w()     // Catch:{ all -> 0x10cf }
            if (r3 == 0) goto L_0x0b5a
            a.d.a.a.i.b.x3 r3 = r2.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r3 = r3.C()     // Catch:{ all -> 0x10cf }
            java.lang.String r4 = "Turning off ad personalization due to account type"
            r3.a(r4)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.f1$a r3 = a.d.a.a.h.g.f1.v()     // Catch:{ all -> 0x10cf }
            r4 = r28
            r3.o(r4)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.k r2 = r2.c()     // Catch:{ all -> 0x10cf }
            long r5 = r2.v()     // Catch:{ all -> 0x10cf }
            r3.n(r5)     // Catch:{ all -> 0x10cf }
            r5 = 1
            r3.p(r5)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r2 = r3.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.f1 r2 = (a.d.a.a.h.g.f1) r2     // Catch:{ all -> 0x10cf }
            r3 = 0
        L_0x0b38:
            int r5 = r12.N()     // Catch:{ all -> 0x10cf }
            if (r3 >= r5) goto L_0x0b54
            a.d.a.a.h.g.f1 r5 = r12.L(r3)     // Catch:{ all -> 0x10cf }
            java.lang.String r5 = r5.u()     // Catch:{ all -> 0x10cf }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x10cf }
            if (r5 == 0) goto L_0x0b51
            r12.p(r3, r2)     // Catch:{ all -> 0x10cf }
            r3 = 1
            goto L_0x0b55
        L_0x0b51:
            int r3 = r3 + 1
            goto L_0x0b38
        L_0x0b54:
            r3 = 0
        L_0x0b55:
            if (r3 != 0) goto L_0x0b5a
            r12.t(r2)     // Catch:{ all -> 0x10cf }
        L_0x0b5a:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12.A(r2)     // Catch:{ all -> 0x10cf }
            r2 = -9223372036854775808
            r12.F(r2)     // Catch:{ all -> 0x10cf }
            r2 = 0
        L_0x0b68:
            int r3 = r12.y()     // Catch:{ all -> 0x10cf }
            if (r2 >= r3) goto L_0x0b9b
            a.d.a.a.h.g.x0 r3 = r12.z(r2)     // Catch:{ all -> 0x10cf }
            long r4 = r3.B()     // Catch:{ all -> 0x10cf }
            long r6 = r12.R()     // Catch:{ all -> 0x10cf }
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0b85
            long r4 = r3.B()     // Catch:{ all -> 0x10cf }
            r12.A(r4)     // Catch:{ all -> 0x10cf }
        L_0x0b85:
            long r4 = r3.B()     // Catch:{ all -> 0x10cf }
            long r6 = r12.V()     // Catch:{ all -> 0x10cf }
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x0b98
            long r3 = r3.B()     // Catch:{ all -> 0x10cf }
            r12.F(r3)     // Catch:{ all -> 0x10cf }
        L_0x0b98:
            int r2 = r2 + 1
            goto L_0x0b68
        L_0x0b9b:
            boolean r2 = a.d.a.a.h.g.oc.b()     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0bb6
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ka r2 = r2.b()     // Catch:{ all -> 0x10cf }
            java.lang.String r3 = r12.j0()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.O0     // Catch:{ all -> 0x10cf }
            boolean r2 = r2.u(r3, r4)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0bb6
            r12.u0()     // Catch:{ all -> 0x10cf }
        L_0x0bb6:
            r12.s0()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ba r27 = r46.L()     // Catch:{ all -> 0x10cf }
            java.lang.String r28 = r12.j0()     // Catch:{ all -> 0x10cf }
            java.util.List r29 = r12.x()     // Catch:{ all -> 0x10cf }
            java.util.List r30 = r12.M()     // Catch:{ all -> 0x10cf }
            long r2 = r12.R()     // Catch:{ all -> 0x10cf }
            java.lang.Long r31 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x10cf }
            long r2 = r12.V()     // Catch:{ all -> 0x10cf }
            java.lang.Long r32 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x10cf }
            java.util.List r2 = r27.t(r28, r29, r30, r31, r32)     // Catch:{ all -> 0x10cf }
            r12.G(r2)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.c5 r2 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.ka r2 = r2.b()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r3 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r3 = r3.W()     // Catch:{ all -> 0x10cf }
            boolean r2 = r2.A(r3)     // Catch:{ all -> 0x10cf }
            if (r2 == 0) goto L_0x0f26
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0f20 }
            r2.<init>()     // Catch:{ all -> 0x0f20 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0f20 }
            r3.<init>()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.c5 r4 = r1.j     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.v9 r4 = r4.t()     // Catch:{ all -> 0x0f20 }
            java.security.SecureRandom r4 = r4.w0()     // Catch:{ all -> 0x0f20 }
            r5 = 0
        L_0x0c07:
            int r6 = r12.y()     // Catch:{ all -> 0x0f20 }
            if (r5 >= r6) goto L_0x0eec
            a.d.a.a.h.g.x0 r6 = r12.z(r5)     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.y5$b r6 = r6.r()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.x0$a r6 = (a.d.a.a.h.g.x0.a) r6     // Catch:{ all -> 0x0f20 }
            java.lang.String r7 = r6.w()     // Catch:{ all -> 0x0f20 }
            java.lang.String r9 = "_ep"
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x0f20 }
            java.lang.String r9 = "_sr"
            java.lang.String r10 = "_efs"
            if (r7 == 0) goto L_0x0c93
            a.d.a.a.i.b.s9 r7 = r46.M()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r11 = r6.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r11 = (a.d.a.a.h.g.y5) r11     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r11 = (a.d.a.a.h.g.x0) r11     // Catch:{ all -> 0x10cf }
            java.lang.String r13 = "_en"
            java.lang.Object r7 = r7.R(r11, r13)     // Catch:{ all -> 0x10cf }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x10cf }
            java.lang.Object r11 = r2.get(r7)     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.l r11 = (a.d.a.a.i.b.l) r11     // Catch:{ all -> 0x10cf }
            if (r11 != 0) goto L_0x0c54
            a.d.a.a.i.b.d r11 = r46.J()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r13 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r13 = r13.W()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.l r11 = r11.z(r13, r7)     // Catch:{ all -> 0x10cf }
            r2.put(r7, r11)     // Catch:{ all -> 0x10cf }
        L_0x0c54:
            java.lang.Long r7 = r11.i     // Catch:{ all -> 0x10cf }
            if (r7 != 0) goto L_0x0d59
            java.lang.Long r7 = r11.j     // Catch:{ all -> 0x10cf }
            long r13 = r7.longValue()     // Catch:{ all -> 0x10cf }
            r15 = 1
            int r7 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r7 <= 0) goto L_0x0c6d
            a.d.a.a.i.b.s9 r7 = r46.M()     // Catch:{ all -> 0x10cf }
            java.lang.Long r13 = r11.j     // Catch:{ all -> 0x10cf }
            r7.E(r6, r9, r13)     // Catch:{ all -> 0x10cf }
        L_0x0c6d:
            java.lang.Boolean r7 = r11.k     // Catch:{ all -> 0x10cf }
            if (r7 == 0) goto L_0x0c86
            java.lang.Boolean r7 = r11.k     // Catch:{ all -> 0x10cf }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x10cf }
            if (r7 == 0) goto L_0x0c86
            a.d.a.a.i.b.s9 r7 = r46.M()     // Catch:{ all -> 0x10cf }
            r13 = 1
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x10cf }
            r7.E(r6, r10, r9)     // Catch:{ all -> 0x10cf }
        L_0x0c86:
            a.d.a.a.h.g.i7 r7 = r6.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r7 = (a.d.a.a.h.g.y5) r7     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r7 = (a.d.a.a.h.g.x0) r7     // Catch:{ all -> 0x10cf }
        L_0x0c8e:
            r3.add(r7)     // Catch:{ all -> 0x10cf }
            goto L_0x0d59
        L_0x0c93:
            a.d.a.a.i.b.w4 r7 = r46.G()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.b1 r11 = r8.f2447a     // Catch:{ all -> 0x0f20 }
            java.lang.String r11 = r11.W()     // Catch:{ all -> 0x0f20 }
            long r13 = r7.B(r11)     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.c5 r7 = r1.j     // Catch:{ all -> 0x0f20 }
            r7.t()     // Catch:{ all -> 0x0f20 }
            r7 = r10
            long r10 = r6.x()     // Catch:{ all -> 0x0f20 }
            long r10 = a.d.a.a.i.b.v9.u(r10, r13)     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.i7 r15 = r6.m()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.y5 r15 = (a.d.a.a.h.g.y5) r15     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.x0 r15 = (a.d.a.a.h.g.x0) r15     // Catch:{ all -> 0x0f20 }
            r16 = r7
            java.lang.String r7 = "_dbg"
            r22 = r13
            r18 = 1
            java.lang.Long r13 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x0f20 }
            boolean r14 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0f20 }
            if (r14 != 0) goto L_0x0d1f
            if (r13 != 0) goto L_0x0ccc
            goto L_0x0d1f
        L_0x0ccc:
            java.util.List r14 = r15.s()     // Catch:{ all -> 0x10cf }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ all -> 0x10cf }
        L_0x0cd4:
            boolean r15 = r14.hasNext()     // Catch:{ all -> 0x10cf }
            if (r15 == 0) goto L_0x0d1f
            java.lang.Object r15 = r14.next()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.z0 r15 = (a.d.a.a.h.g.z0) r15     // Catch:{ all -> 0x10cf }
            r18 = r14
            java.lang.String r14 = r15.u()     // Catch:{ all -> 0x10cf }
            boolean r14 = r7.equals(r14)     // Catch:{ all -> 0x10cf }
            if (r14 == 0) goto L_0x0d1c
            long r18 = r15.A()     // Catch:{ all -> 0x10cf }
            java.lang.Long r7 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x10cf }
            boolean r7 = r13.equals(r7)     // Catch:{ all -> 0x10cf }
            if (r7 != 0) goto L_0x0d1a
            boolean r7 = r13 instanceof java.lang.String     // Catch:{ all -> 0x10cf }
            if (r7 == 0) goto L_0x0d08
            java.lang.String r7 = r15.x()     // Catch:{ all -> 0x10cf }
            boolean r7 = r13.equals(r7)     // Catch:{ all -> 0x10cf }
            if (r7 != 0) goto L_0x0d1a
        L_0x0d08:
            boolean r7 = r13 instanceof java.lang.Double     // Catch:{ all -> 0x10cf }
            if (r7 == 0) goto L_0x0d1f
            double r14 = r15.C()     // Catch:{ all -> 0x10cf }
            java.lang.Double r7 = java.lang.Double.valueOf(r14)     // Catch:{ all -> 0x10cf }
            boolean r7 = r13.equals(r7)     // Catch:{ all -> 0x10cf }
            if (r7 == 0) goto L_0x0d1f
        L_0x0d1a:
            r7 = 1
            goto L_0x0d20
        L_0x0d1c:
            r14 = r18
            goto L_0x0cd4
        L_0x0d1f:
            r7 = 0
        L_0x0d20:
            if (r7 != 0) goto L_0x0d35
            a.d.a.a.i.b.w4 r7 = r46.G()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.b1 r13 = r8.f2447a     // Catch:{ all -> 0x10cf }
            java.lang.String r13 = r13.W()     // Catch:{ all -> 0x10cf }
            java.lang.String r14 = r6.w()     // Catch:{ all -> 0x10cf }
            int r7 = r7.z(r13, r14)     // Catch:{ all -> 0x10cf }
            goto L_0x0d36
        L_0x0d35:
            r7 = 1
        L_0x0d36:
            if (r7 > 0) goto L_0x0d5e
            a.d.a.a.i.b.c5 r9 = r1.j     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.x3 r9 = r9.i()     // Catch:{ all -> 0x10cf }
            a.d.a.a.i.b.z3 r9 = r9.A()     // Catch:{ all -> 0x10cf }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r11 = r6.w()     // Catch:{ all -> 0x10cf }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x10cf }
            r9.c(r10, r11, r7)     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.i7 r7 = r6.m()     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.y5 r7 = (a.d.a.a.h.g.y5) r7     // Catch:{ all -> 0x10cf }
            a.d.a.a.h.g.x0 r7 = (a.d.a.a.h.g.x0) r7     // Catch:{ all -> 0x10cf }
            goto L_0x0c8e
        L_0x0d59:
            r12.o(r5, r6)     // Catch:{ all -> 0x10cf }
            goto L_0x0e08
        L_0x0d5e:
            java.lang.String r13 = r6.w()     // Catch:{ all -> 0x0f20 }
            java.lang.Object r13 = r2.get(r13)     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.l r13 = (a.d.a.a.i.b.l) r13     // Catch:{ all -> 0x0f20 }
            if (r13 != 0) goto L_0x0dbc
            a.d.a.a.i.b.d r13 = r46.J()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.b1 r14 = r8.f2447a     // Catch:{ all -> 0x0f20 }
            java.lang.String r14 = r14.W()     // Catch:{ all -> 0x0f20 }
            java.lang.String r15 = r6.w()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.l r13 = r13.z(r14, r15)     // Catch:{ all -> 0x0f20 }
            if (r13 != 0) goto L_0x0dbc
            a.d.a.a.i.b.c5 r13 = r1.j     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.x3 r13 = r13.i()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.z3 r13 = r13.A()     // Catch:{ all -> 0x0f20 }
            java.lang.String r14 = "Event being bundled has no eventAggregate. appId, eventName"
            a.d.a.a.h.g.b1 r15 = r8.f2447a     // Catch:{ all -> 0x0f20 }
            java.lang.String r15 = r15.W()     // Catch:{ all -> 0x0f20 }
            java.lang.String r1 = r6.w()     // Catch:{ all -> 0x0f20 }
            r13.c(r14, r15, r1)     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.l r13 = new a.d.a.a.i.b.l     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.b1 r1 = r8.f2447a     // Catch:{ all -> 0x0f20 }
            java.lang.String r28 = r1.W()     // Catch:{ all -> 0x0f20 }
            java.lang.String r29 = r6.w()     // Catch:{ all -> 0x0f20 }
            r30 = 1
            r32 = 1
            r34 = 1
            long r36 = r6.x()     // Catch:{ all -> 0x0f20 }
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r27 = r13
            r27.<init>(r28, r29, r30, r32, r34, r36, r38, r40, r41, r42, r43)     // Catch:{ all -> 0x0f20 }
        L_0x0dbc:
            a.d.a.a.i.b.s9 r1 = r46.M()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.i7 r14 = r6.m()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.y5 r14 = (a.d.a.a.h.g.y5) r14     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.x0 r14 = (a.d.a.a.h.g.x0) r14     // Catch:{ all -> 0x0f20 }
            java.lang.String r15 = "_eid"
            java.lang.Object r1 = r1.R(r14, r15)     // Catch:{ all -> 0x0f20 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0f20 }
            if (r1 == 0) goto L_0x0dd4
            r14 = 1
            goto L_0x0dd5
        L_0x0dd4:
            r14 = 0
        L_0x0dd5:
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x0f20 }
            r15 = 1
            if (r7 != r15) goto L_0x0e0f
            a.d.a.a.h.g.i7 r1 = r6.m()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.x0 r1 = (a.d.a.a.h.g.x0) r1     // Catch:{ all -> 0x0f20 }
            r3.add(r1)     // Catch:{ all -> 0x0f20 }
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x0f20 }
            if (r1 == 0) goto L_0x0e05
            java.lang.Long r1 = r13.i     // Catch:{ all -> 0x0f20 }
            if (r1 != 0) goto L_0x0df9
            java.lang.Long r1 = r13.j     // Catch:{ all -> 0x0f20 }
            if (r1 != 0) goto L_0x0df9
            java.lang.Boolean r1 = r13.k     // Catch:{ all -> 0x0f20 }
            if (r1 == 0) goto L_0x0e05
        L_0x0df9:
            r1 = 0
            a.d.a.a.i.b.l r7 = r13.c(r1, r1, r1)     // Catch:{ all -> 0x0f20 }
            java.lang.String r1 = r6.w()     // Catch:{ all -> 0x0f20 }
            r2.put(r1, r7)     // Catch:{ all -> 0x0f20 }
        L_0x0e05:
            r12.o(r5, r6)     // Catch:{ all -> 0x0f20 }
        L_0x0e08:
            r18 = r4
            r15 = r8
            r4 = r2
            r8 = r5
            goto L_0x0ee2
        L_0x0e0f:
            int r15 = r4.nextInt(r7)     // Catch:{ all -> 0x0f20 }
            if (r15 != 0) goto L_0x0e51
            a.d.a.a.i.b.s9 r1 = r46.M()     // Catch:{ all -> 0x0f20 }
            r15 = r8
            long r7 = (long) r7     // Catch:{ all -> 0x0f20 }
            r18 = r4
            java.lang.Long r4 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0f20 }
            r1.E(r6, r9, r4)     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.i7 r1 = r6.m()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.x0 r1 = (a.d.a.a.h.g.x0) r1     // Catch:{ all -> 0x0f20 }
            r3.add(r1)     // Catch:{ all -> 0x0f20 }
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x0f20 }
            if (r1 == 0) goto L_0x0e3e
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0f20 }
            r4 = 0
            a.d.a.a.i.b.l r13 = r13.c(r4, r1, r4)     // Catch:{ all -> 0x0f20 }
        L_0x0e3e:
            java.lang.String r1 = r6.w()     // Catch:{ all -> 0x0f20 }
            long r7 = r6.x()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.l r4 = r13.b(r7, r10)     // Catch:{ all -> 0x0f20 }
            r2.put(r1, r4)     // Catch:{ all -> 0x0f20 }
            r4 = r2
            r8 = r5
            goto L_0x0edf
        L_0x0e51:
            r18 = r4
            r15 = r8
            java.lang.Long r4 = r13.h     // Catch:{ all -> 0x0f20 }
            if (r4 == 0) goto L_0x0e68
            java.lang.Long r4 = r13.h     // Catch:{ all -> 0x0f20 }
            long r19 = r4.longValue()     // Catch:{ all -> 0x0f20 }
            r8 = r5
            r44 = r19
            r20 = r1
            r19 = r2
            r1 = r44
            goto L_0x0e7e
        L_0x0e68:
            r4 = r46
            a.d.a.a.i.b.c5 r8 = r4.j     // Catch:{ all -> 0x0f20 }
            r8.t()     // Catch:{ all -> 0x0f20 }
            r8 = r5
            long r4 = r6.y()     // Catch:{ all -> 0x0f20 }
            r20 = r1
            r19 = r2
            r1 = r22
            long r1 = a.d.a.a.i.b.v9.u(r4, r1)     // Catch:{ all -> 0x0f20 }
        L_0x0e7e:
            int r4 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0ec6
            a.d.a.a.i.b.s9 r1 = r46.M()     // Catch:{ all -> 0x0f20 }
            r4 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0f20 }
            r4 = r16
            r1.E(r6, r4, r2)     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.s9 r1 = r46.M()     // Catch:{ all -> 0x0f20 }
            long r4 = (long) r7     // Catch:{ all -> 0x0f20 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0f20 }
            r1.E(r6, r9, r2)     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.i7 r1 = r6.m()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1     // Catch:{ all -> 0x0f20 }
            a.d.a.a.h.g.x0 r1 = (a.d.a.a.h.g.x0) r1     // Catch:{ all -> 0x0f20 }
            r3.add(r1)     // Catch:{ all -> 0x0f20 }
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x0f20 }
            if (r1 == 0) goto L_0x0eb9
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0f20 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0f20 }
            r4 = 0
            a.d.a.a.i.b.l r13 = r13.c(r4, r1, r2)     // Catch:{ all -> 0x0f20 }
        L_0x0eb9:
            java.lang.String r1 = r6.w()     // Catch:{ all -> 0x0f20 }
            long r4 = r6.x()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.l r2 = r13.b(r4, r10)     // Catch:{ all -> 0x0f20 }
            goto L_0x0ed7
        L_0x0ec6:
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x0f20 }
            if (r1 == 0) goto L_0x0edd
            java.lang.String r1 = r6.w()     // Catch:{ all -> 0x0f20 }
            r2 = r20
            r4 = 0
            a.d.a.a.i.b.l r2 = r13.c(r2, r4, r4)     // Catch:{ all -> 0x0f20 }
        L_0x0ed7:
            r4 = r19
            r4.put(r1, r2)     // Catch:{ all -> 0x0f20 }
            goto L_0x0edf
        L_0x0edd:
            r4 = r19
        L_0x0edf:
            r12.o(r8, r6)     // Catch:{ all -> 0x0f20 }
        L_0x0ee2:
            int r5 = r8 + 1
            r1 = r46
            r2 = r4
            r8 = r15
            r4 = r18
            goto L_0x0c07
        L_0x0eec:
            r4 = r2
            r15 = r8
            int r1 = r3.size()     // Catch:{ all -> 0x0f20 }
            int r2 = r12.y()     // Catch:{ all -> 0x0f20 }
            if (r1 >= r2) goto L_0x0efe
            r12.D()     // Catch:{ all -> 0x0f20 }
            r12.u(r3)     // Catch:{ all -> 0x0f20 }
        L_0x0efe:
            java.util.Set r1 = r4.entrySet()     // Catch:{ all -> 0x0f20 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0f20 }
        L_0x0f06:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0f20 }
            if (r2 == 0) goto L_0x0f27
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0f20 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.d r3 = r46.J()     // Catch:{ all -> 0x0f20 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.l r2 = (a.d.a.a.i.b.l) r2     // Catch:{ all -> 0x0f20 }
            r3.H(r2)     // Catch:{ all -> 0x0f20 }
            goto L_0x0f06
        L_0x0f20:
            r0 = move-exception
            r4 = r46
        L_0x0f23:
            r1 = r0
            goto L_0x10d3
        L_0x0f26:
            r15 = r8
        L_0x0f27:
            r1 = r15
            a.d.a.a.h.g.b1 r2 = r1.f2447a     // Catch:{ all -> 0x0f20 }
            java.lang.String r2 = r2.W()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.d r3 = r46.J()     // Catch:{ all -> 0x0f20 }
            a.d.a.a.i.b.a4 r3 = r3.T(r2)     // Catch:{ all -> 0x0f20 }
            r4 = r46
            if (r3 != 0) goto L_0x0f54
            a.d.a.a.i.b.c5 r3 = r4.j     // Catch:{ all -> 0x10cc }
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x10cc }
            a.d.a.a.i.b.z3 r3 = r3.z()     // Catch:{ all -> 0x10cc }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            a.d.a.a.h.g.b1 r6 = r1.f2447a     // Catch:{ all -> 0x10cc }
            java.lang.String r6 = r6.W()     // Catch:{ all -> 0x10cc }
            java.lang.Object r6 = a.d.a.a.i.b.x3.s(r6)     // Catch:{ all -> 0x10cc }
            r3.b(r5, r6)     // Catch:{ all -> 0x10cc }
            goto L_0x0faf
        L_0x0f54:
            int r5 = r12.y()     // Catch:{ all -> 0x10cc }
            if (r5 <= 0) goto L_0x0faf
            long r5 = r3.L()     // Catch:{ all -> 0x10cc }
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0f68
            r12.P(r5)     // Catch:{ all -> 0x10cc }
            goto L_0x0f6b
        L_0x0f68:
            r12.d0()     // Catch:{ all -> 0x10cc }
        L_0x0f6b:
            long r7 = r3.K()     // Catch:{ all -> 0x10cc }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0f76
            goto L_0x0f77
        L_0x0f76:
            r5 = r7
        L_0x0f77:
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0f7f
            r12.I(r5)     // Catch:{ all -> 0x10cc }
            goto L_0x0f82
        L_0x0f7f:
            r12.Z()     // Catch:{ all -> 0x10cc }
        L_0x0f82:
            r3.X()     // Catch:{ all -> 0x10cc }
            long r5 = r3.U()     // Catch:{ all -> 0x10cc }
            int r6 = (int) r5     // Catch:{ all -> 0x10cc }
            r12.W(r6)     // Catch:{ all -> 0x10cc }
            long r5 = r12.R()     // Catch:{ all -> 0x10cc }
            r3.a(r5)     // Catch:{ all -> 0x10cc }
            long r5 = r12.V()     // Catch:{ all -> 0x10cc }
            r3.l(r5)     // Catch:{ all -> 0x10cc }
            java.lang.String r5 = r3.f()     // Catch:{ all -> 0x10cc }
            if (r5 == 0) goto L_0x0fa5
            r12.i0(r5)     // Catch:{ all -> 0x10cc }
            goto L_0x0fa8
        L_0x0fa5:
            r12.o0()     // Catch:{ all -> 0x10cc }
        L_0x0fa8:
            a.d.a.a.i.b.d r5 = r46.J()     // Catch:{ all -> 0x10cc }
            r5.I(r3)     // Catch:{ all -> 0x10cc }
        L_0x0faf:
            int r3 = r12.y()     // Catch:{ all -> 0x10cc }
            if (r3 <= 0) goto L_0x1010
            a.d.a.a.i.b.w4 r3 = r46.G()     // Catch:{ all -> 0x10cc }
            a.d.a.a.h.g.b1 r5 = r1.f2447a     // Catch:{ all -> 0x10cc }
            java.lang.String r5 = r5.W()     // Catch:{ all -> 0x10cc }
            a.d.a.a.h.g.r0 r3 = r3.s(r5)     // Catch:{ all -> 0x10cc }
            if (r3 == 0) goto L_0x0fd4
            boolean r5 = r3.u()     // Catch:{ all -> 0x10cc }
            if (r5 != 0) goto L_0x0fcc
            goto L_0x0fd4
        L_0x0fcc:
            long r5 = r3.v()     // Catch:{ all -> 0x10cc }
            r12.f0(r5)     // Catch:{ all -> 0x10cc }
            goto L_0x0fff
        L_0x0fd4:
            a.d.a.a.h.g.b1 r3 = r1.f2447a     // Catch:{ all -> 0x10cc }
            java.lang.String r3 = r3.z()     // Catch:{ all -> 0x10cc }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x10cc }
            if (r3 == 0) goto L_0x0fe6
            r5 = -1
            r12.f0(r5)     // Catch:{ all -> 0x10cc }
            goto L_0x0fff
        L_0x0fe6:
            a.d.a.a.i.b.c5 r3 = r4.j     // Catch:{ all -> 0x10cc }
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x10cc }
            a.d.a.a.i.b.z3 r3 = r3.A()     // Catch:{ all -> 0x10cc }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            a.d.a.a.h.g.b1 r6 = r1.f2447a     // Catch:{ all -> 0x10cc }
            java.lang.String r6 = r6.W()     // Catch:{ all -> 0x10cc }
            java.lang.Object r6 = a.d.a.a.i.b.x3.s(r6)     // Catch:{ all -> 0x10cc }
            r3.b(r5, r6)     // Catch:{ all -> 0x10cc }
        L_0x0fff:
            a.d.a.a.i.b.d r3 = r46.J()     // Catch:{ all -> 0x10cc }
            a.d.a.a.h.g.i7 r5 = r12.m()     // Catch:{ all -> 0x10cc }
            a.d.a.a.h.g.y5 r5 = (a.d.a.a.h.g.y5) r5     // Catch:{ all -> 0x10cc }
            a.d.a.a.h.g.b1 r5 = (a.d.a.a.h.g.b1) r5     // Catch:{ all -> 0x10cc }
            r6 = r21
            r3.K(r5, r6)     // Catch:{ all -> 0x10cc }
        L_0x1010:
            a.d.a.a.i.b.d r3 = r46.J()     // Catch:{ all -> 0x10cc }
            java.util.List<java.lang.Long> r1 = r1.f2448b     // Catch:{ all -> 0x10cc }
            a.c.a.f.b.k(r1)     // Catch:{ all -> 0x10cc }
            r3.b()     // Catch:{ all -> 0x10cc }
            r3.n()     // Catch:{ all -> 0x10cc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x10cc }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x10cc }
            r6 = 0
        L_0x1027:
            int r7 = r1.size()     // Catch:{ all -> 0x10cc }
            if (r6 >= r7) goto L_0x1044
            if (r6 == 0) goto L_0x1034
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x10cc }
        L_0x1034:
            java.lang.Object r7 = r1.get(r6)     // Catch:{ all -> 0x10cc }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x10cc }
            long r7 = r7.longValue()     // Catch:{ all -> 0x10cc }
            r5.append(r7)     // Catch:{ all -> 0x10cc }
            int r6 = r6 + 1
            goto L_0x1027
        L_0x1044:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x10cc }
            android.database.sqlite.SQLiteDatabase r6 = r3.t()     // Catch:{ all -> 0x10cc }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x10cc }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x10cc }
            int r6 = r1.size()     // Catch:{ all -> 0x10cc }
            if (r5 == r6) goto L_0x1077
            a.d.a.a.i.b.x3 r3 = r3.i()     // Catch:{ all -> 0x10cc }
            a.d.a.a.i.b.z3 r3 = r3.z()     // Catch:{ all -> 0x10cc }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x10cc }
            int r1 = r1.size()     // Catch:{ all -> 0x10cc }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x10cc }
            r3.c(r6, r5, r1)     // Catch:{ all -> 0x10cc }
        L_0x1077:
            a.d.a.a.i.b.d r1 = r46.J()     // Catch:{ all -> 0x10cc }
            android.database.sqlite.SQLiteDatabase r3 = r1.t()     // Catch:{ all -> 0x10cc }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x108e }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x108e }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x108e }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x108e }
            goto L_0x10a1
        L_0x108e:
            r0 = move-exception
            r3 = r0
            a.d.a.a.i.b.x3 r1 = r1.i()     // Catch:{ all -> 0x10cc }
            a.d.a.a.i.b.z3 r1 = r1.z()     // Catch:{ all -> 0x10cc }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = a.d.a.a.i.b.x3.s(r2)     // Catch:{ all -> 0x10cc }
            r1.c(r5, r2, r3)     // Catch:{ all -> 0x10cc }
        L_0x10a1:
            a.d.a.a.i.b.d r1 = r46.J()     // Catch:{ all -> 0x10cc }
            r1.s()     // Catch:{ all -> 0x10cc }
            a.d.a.a.i.b.d r1 = r46.J()
            r1.e0()
            r1 = 1
            return r1
        L_0x10b1:
            r4 = r1
            a.d.a.a.i.b.d r1 = r46.J()     // Catch:{ all -> 0x10cc }
            r1.s()     // Catch:{ all -> 0x10cc }
            a.d.a.a.i.b.d r1 = r46.J()
            r1.e0()
            r1 = 0
            return r1
        L_0x10c2:
            r0 = move-exception
            r4 = r1
            r2 = r0
            r9 = r7
        L_0x10c6:
            if (r9 == 0) goto L_0x10cb
            r9.close()     // Catch:{ all -> 0x10cc }
        L_0x10cb:
            throw r2     // Catch:{ all -> 0x10cc }
        L_0x10cc:
            r0 = move-exception
            goto L_0x0f23
        L_0x10cf:
            r0 = move-exception
            r4 = r1
            goto L_0x0f23
        L_0x10d3:
            a.d.a.a.i.b.d r2 = r46.J()
            r2.e0()
            goto L_0x10dc
        L_0x10db:
            throw r1
        L_0x10dc:
            goto L_0x10db
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.s(long):boolean");
    }

    public final boolean t(x0.a aVar, x0.a aVar2) {
        b.d("_e".equals(aVar.w()));
        M();
        z0 w2 = s9.w((x0) ((y5) aVar.m()), "_sc");
        String str = null;
        String str2 = w2 == null ? null : w2.zze;
        M();
        z0 w3 = s9.w((x0) ((y5) aVar2.m()), "_pc");
        if (w3 != null) {
            str = w3.zze;
        }
        if (str == null || !str.equals(str2)) {
            return false;
        }
        z(aVar, aVar2);
        return true;
    }

    public final boolean u() {
        T();
        O();
        return ((J().S("select count(1) > 0 from raw_events", (String[]) null) > 0 ? 1 : (J().S("select count(1) > 0 from raw_events", (String[]) null) == 0 ? 0 : -1)) != 0) || !TextUtils.isEmpty(J().u());
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018d  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v() {
        /*
            r20 = this;
            r0 = r20
            r20.T()
            r20.O()
            long r1 = r0.m
            r3 = 0
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0043
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.e.q.b r1 = r1.n
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x0042
            long r1 = android.os.SystemClock.elapsedRealtime()
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r0.m
            long r1 = r1 - r8
            long r1 = java.lang.Math.abs(r1)
            long r6 = r6 - r1
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x003f
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.b(r3, r2)
            goto L_0x034c
        L_0x003f:
            r0.m = r4
            goto L_0x0043
        L_0x0042:
            throw r3
        L_0x0043:
            a.d.a.a.i.b.c5 r1 = r0.j
            boolean r1 = r1.l()
            if (r1 == 0) goto L_0x033f
            boolean r1 = r20.u()
            if (r1 != 0) goto L_0x0053
            goto L_0x033f
        L_0x0053:
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.e.q.b r1 = r1.n
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x033e
            long r1 = java.lang.System.currentTimeMillis()
            a.d.a.a.i.b.n3<java.lang.Long> r6 = a.d.a.a.i.b.q.A
            java.lang.Object r6 = r6.a(r3)
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            long r6 = java.lang.Math.max(r4, r6)
            a.d.a.a.i.b.d r8 = r20.J()
            java.lang.String r9 = "select count(1) > 0 from raw_events where realtime = 1"
            long r8 = r8.S(r9, r3)
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x007f
            r8 = 1
            goto L_0x0080
        L_0x007f:
            r8 = 0
        L_0x0080:
            if (r8 != 0) goto L_0x0098
            a.d.a.a.i.b.d r8 = r20.J()
            java.lang.String r9 = "select count(1) > 0 from queue where has_realtime = 1"
            long r8 = r8.S(r9, r3)
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0092
            r8 = 1
            goto L_0x0093
        L_0x0092:
            r8 = 0
        L_0x0093:
            if (r8 == 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r8 = 0
            goto L_0x0099
        L_0x0098:
            r8 = 1
        L_0x0099:
            if (r8 == 0) goto L_0x00bb
            a.d.a.a.i.b.c5 r9 = r0.j
            a.d.a.a.i.b.ka r9 = r9.g
            java.lang.String r12 = "debug.firebase.analytics.app"
            java.lang.String r13 = ""
            java.lang.String r9 = r9.h(r12, r13)
            boolean r12 = android.text.TextUtils.isEmpty(r9)
            if (r12 != 0) goto L_0x00b8
            java.lang.String r12 = ".none."
            boolean r9 = r12.equals(r9)
            if (r9 != 0) goto L_0x00b8
            a.d.a.a.i.b.n3<java.lang.Long> r9 = a.d.a.a.i.b.q.v
            goto L_0x00bd
        L_0x00b8:
            a.d.a.a.i.b.n3<java.lang.Long> r9 = a.d.a.a.i.b.q.u
            goto L_0x00bd
        L_0x00bb:
            a.d.a.a.i.b.n3<java.lang.Long> r9 = a.d.a.a.i.b.q.t
        L_0x00bd:
            java.lang.Object r9 = r9.a(r3)
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            long r12 = java.lang.Math.max(r4, r12)
            a.d.a.a.i.b.c5 r9 = r0.j
            a.d.a.a.i.b.k4 r9 = r9.o()
            a.d.a.a.i.b.o4 r9 = r9.f2317e
            long r14 = r9.a()
            a.d.a.a.i.b.c5 r9 = r0.j
            a.d.a.a.i.b.k4 r9 = r9.o()
            a.d.a.a.i.b.o4 r9 = r9.f
            long r16 = r9.a()
            a.d.a.a.i.b.d r9 = r20.J()
            java.lang.String r11 = "select max(bundle_end_timestamp) from queue"
            long r10 = r9.w(r11, r3, r4)
            a.d.a.a.i.b.d r9 = r20.J()
            java.lang.String r0 = "select max(timestamp) from raw_events"
            r18 = r12
            long r12 = r9.w(r0, r3, r4)
            long r9 = java.lang.Math.max(r10, r12)
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0104
            r6 = r4
            goto L_0x017a
        L_0x0104:
            long r9 = r9 - r1
            long r9 = java.lang.Math.abs(r9)
            long r9 = r1 - r9
            long r14 = r14 - r1
            long r11 = java.lang.Math.abs(r14)
            long r11 = r1 - r11
            long r16 = r16 - r1
            long r13 = java.lang.Math.abs(r16)
            long r1 = r1 - r13
            long r11 = java.lang.Math.max(r11, r1)
            long r6 = r6 + r9
            if (r8 == 0) goto L_0x012a
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x012a
            long r6 = java.lang.Math.min(r9, r11)
            long r6 = r6 + r18
        L_0x012a:
            a.d.a.a.i.b.s9 r0 = r20.M()
            r13 = r18
            boolean r0 = r0.N(r11, r13)
            if (r0 != 0) goto L_0x0138
            long r6 = r11 + r13
        L_0x0138:
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x017a
            int r0 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x017a
            r0 = 0
        L_0x0141:
            r8 = 20
            a.d.a.a.i.b.n3<java.lang.Integer> r9 = a.d.a.a.i.b.q.C
            java.lang.Object r9 = r9.a(r3)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r10 = 0
            int r9 = java.lang.Math.max(r10, r9)
            int r8 = java.lang.Math.min(r8, r9)
            if (r0 >= r8) goto L_0x0178
            r8 = 1
            long r8 = r8 << r0
            a.d.a.a.i.b.n3<java.lang.Long> r11 = a.d.a.a.i.b.q.B
            java.lang.Object r11 = r11.a(r3)
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = java.lang.Math.max(r4, r11)
            long r11 = r11 * r8
            long r6 = r6 + r11
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L_0x0175
            goto L_0x017b
        L_0x0175:
            int r0 = r0 + 1
            goto L_0x0141
        L_0x0178:
            r6 = r4
            goto L_0x017b
        L_0x017a:
            r10 = 0
        L_0x017b:
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x018d
            r0 = r20
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            java.lang.String r2 = "Next upload time is 0"
            goto L_0x0349
        L_0x018d:
            r0 = r20
            a.d.a.a.i.b.b4 r1 = r20.I()
            boolean r1 = r1.u()
            if (r1 != 0) goto L_0x01f2
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            java.lang.String r2 = "No network"
            r1.a(r2)
            a.d.a.a.i.b.i4 r1 = r20.R()
            a.d.a.a.i.b.o9 r2 = r1.f2262a
            r2.O()
            a.d.a.a.i.b.o9 r2 = r1.f2262a
            a.d.a.a.i.b.v4 r2 = r2.f()
            r2.b()
            boolean r2 = r1.f2263b
            if (r2 == 0) goto L_0x01be
            goto L_0x0353
        L_0x01be:
            a.d.a.a.i.b.o9 r2 = r1.f2262a
            a.d.a.a.i.b.c5 r2 = r2.j
            android.content.Context r2 = r2.f2123a
            android.content.IntentFilter r3 = new android.content.IntentFilter
            java.lang.String r4 = "android.net.conn.CONNECTIVITY_CHANGE"
            r3.<init>(r4)
            r2.registerReceiver(r1, r3)
            a.d.a.a.i.b.o9 r2 = r1.f2262a
            a.d.a.a.i.b.b4 r2 = r2.I()
            boolean r2 = r2.u()
            r1.f2264c = r2
            a.d.a.a.i.b.o9 r2 = r1.f2262a
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.n
            boolean r3 = r1.f2264c
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = "Registering connectivity change receiver. Network connected"
            r2.b(r4, r3)
            r2 = 1
            r1.f2263b = r2
            goto L_0x0353
        L_0x01f2:
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.i.b.k4 r1 = r1.o()
            a.d.a.a.i.b.o4 r1 = r1.g
            long r1 = r1.a()
            a.d.a.a.i.b.n3<java.lang.Long> r8 = a.d.a.a.i.b.q.r
            java.lang.Object r8 = r8.a(r3)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            long r8 = java.lang.Math.max(r4, r8)
            a.d.a.a.i.b.s9 r11 = r20.M()
            boolean r11 = r11.N(r1, r8)
            if (r11 != 0) goto L_0x021d
            long r1 = r1 + r8
            long r6 = java.lang.Math.max(r6, r1)
        L_0x021d:
            a.d.a.a.i.b.i4 r1 = r20.R()
            r1.a()
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.e.q.b r1 = r1.n
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x033d
            long r1 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r1
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x025e
            a.d.a.a.i.b.n3<java.lang.Long> r1 = a.d.a.a.i.b.q.w
            java.lang.Object r1 = r1.a(r3)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r6 = java.lang.Math.max(r4, r1)
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.i.b.k4 r1 = r1.o()
            a.d.a.a.i.b.o4 r1 = r1.f2317e
            a.d.a.a.i.b.c5 r2 = r0.j
            a.d.a.a.e.q.b r2 = r2.n
            a.d.a.a.e.q.c r2 = (a.d.a.a.e.q.c) r2
            if (r2 == 0) goto L_0x025d
            long r8 = java.lang.System.currentTimeMillis()
            r1.b(r8)
            goto L_0x025e
        L_0x025d:
            throw r3
        L_0x025e:
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            java.lang.String r8 = "Upload scheduled in approximately ms"
            r1.b(r8, r2)
            a.d.a.a.i.b.l9 r1 = r20.S()
            r1.n()
            a.d.a.a.i.b.c5 r2 = r1.f2563a
            android.content.Context r2 = r2.f2123a
            boolean r8 = a.d.a.a.i.b.u4.a(r2)
            if (r8 != 0) goto L_0x028b
            a.d.a.a.i.b.x3 r8 = r1.i()
            a.d.a.a.i.b.z3 r8 = r8.m
            java.lang.String r9 = "Receiver not registered/enabled"
            r8.a(r9)
        L_0x028b:
            boolean r2 = a.d.a.a.i.b.v9.S(r2)
            if (r2 != 0) goto L_0x029c
            a.d.a.a.i.b.x3 r2 = r1.i()
            a.d.a.a.i.b.z3 r2 = r2.m
            java.lang.String r8 = "Service not registered/enabled"
            r2.a(r8)
        L_0x029c:
            r1.s()
            a.d.a.a.i.b.x3 r2 = r1.i()
            a.d.a.a.i.b.z3 r2 = r2.n
            java.lang.Long r8 = java.lang.Long.valueOf(r6)
            java.lang.String r9 = "Scheduling upload, millis"
            r2.b(r9, r8)
            a.d.a.a.i.b.c5 r2 = r1.f2563a
            a.d.a.a.e.q.b r2 = r2.n
            a.d.a.a.e.q.c r2 = (a.d.a.a.e.q.c) r2
            if (r2 == 0) goto L_0x033c
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r13 = r8 + r6
            a.d.a.a.i.b.n3<java.lang.Long> r2 = a.d.a.a.i.b.q.x
            java.lang.Object r2 = r2.a(r3)
            java.lang.Long r2 = (java.lang.Long) r2
            long r8 = r2.longValue()
            long r8 = java.lang.Math.max(r4, r8)
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x02e0
            a.d.a.a.i.b.i r2 = r1.f2361e
            long r8 = r2.f2257c
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x02d9
            r10 = 1
        L_0x02d9:
            if (r10 != 0) goto L_0x02e0
            a.d.a.a.i.b.i r2 = r1.f2361e
            r2.b(r6)
        L_0x02e0:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r2 < r4) goto L_0x0321
            a.d.a.a.i.b.c5 r2 = r1.f2563a
            android.content.Context r2 = r2.f2123a
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurementJobService"
            r3.<init>(r2, r4)
            int r1 = r1.t()
            android.os.PersistableBundle r4 = new android.os.PersistableBundle
            r4.<init>()
            java.lang.String r5 = "action"
            java.lang.String r8 = "com.google.android.gms.measurement.UPLOAD"
            r4.putString(r5, r8)
            android.app.job.JobInfo$Builder r5 = new android.app.job.JobInfo$Builder
            r5.<init>(r1, r3)
            android.app.job.JobInfo$Builder r1 = r5.setMinimumLatency(r6)
            r3 = 1
            long r5 = r6 << r3
            android.app.job.JobInfo$Builder r1 = r1.setOverrideDeadline(r5)
            android.app.job.JobInfo$Builder r1 = r1.setExtras(r4)
            android.app.job.JobInfo r1 = r1.build()
            java.lang.String r3 = "com.google.android.gms"
            java.lang.String r4 = "UploadAlarm"
            a.d.a.a.h.g.f5.a(r2, r1, r3, r4)
            goto L_0x033b
        L_0x0321:
            android.app.AlarmManager r11 = r1.f2360d
            r12 = 2
            a.d.a.a.i.b.n3<java.lang.Long> r2 = a.d.a.a.i.b.q.s
            java.lang.Object r2 = r2.a(r3)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            long r15 = java.lang.Math.max(r2, r6)
            android.app.PendingIntent r17 = r1.u()
            r11.setInexactRepeating(r12, r13, r15, r17)
        L_0x033b:
            return
        L_0x033c:
            throw r3
        L_0x033d:
            throw r3
        L_0x033e:
            throw r3
        L_0x033f:
            a.d.a.a.i.b.c5 r1 = r0.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            java.lang.String r2 = "Nothing to upload or uploading impossible"
        L_0x0349:
            r1.a(r2)
        L_0x034c:
            a.d.a.a.i.b.i4 r1 = r20.R()
            r1.a()
        L_0x0353:
            a.d.a.a.i.b.l9 r1 = r20.S()
            r1.s()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o9.v():void");
    }

    @WorkerThread
    public final void w() {
        T();
        if (this.q || this.r || this.s) {
            this.j.i().n.d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.q), Boolean.valueOf(this.r), Boolean.valueOf(this.s));
            return;
        }
        this.j.i().n.a("Stopping uploading service(s)");
        List<Runnable> list = this.n;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.n.clear();
        }
    }

    @WorkerThread
    public final zzn x(String str) {
        String str2 = str;
        a4 T = J().T(str2);
        if (T == null || TextUtils.isEmpty(T.M())) {
            this.j.i().m.b("No app data available; dropping", str2);
            return null;
        }
        Boolean y2 = y(T);
        if (y2 == null || y2.booleanValue()) {
            return new zzn(str, T.v(), T.M(), T.N(), T.O(), T.P(), T.Q(), (String) null, T.T(), false, T.H(), T.g(), 0, 0, T.h(), T.i(), false, T.y(), T.j(), T.S(), T.k(), (!jb.b() || !this.j.g.t(str2, q.k0)) ? null : T.B(), (!u9.b() || !this.j.g.o(q.Q0)) ? "" : a(str).d());
        }
        this.j.i().f.b("App version does not match; dropping. appId", x3.s(str));
        return null;
    }

    @WorkerThread
    public final Boolean y(a4 a4Var) {
        try {
            if (a4Var.N() != -2147483648L) {
                if (a4Var.N() == ((long) a.d.a.a.e.r.c.a(this.j.f2123a).b(a4Var.o(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = a.d.a.a.e.r.c.a(this.j.f2123a).b(a4Var.o(), 0).versionName;
                if (a4Var.M() != null && a4Var.M().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final void z(x0.a aVar, x0.a aVar2) {
        b.d("_e".equals(aVar.w()));
        M();
        z0 w2 = s9.w((x0) ((y5) aVar.m()), "_et");
        if (w2.z()) {
            long j2 = w2.zzf;
            if (j2 > 0) {
                M();
                z0 w3 = s9.w((x0) ((y5) aVar2.m()), "_et");
                if (w3 != null) {
                    long j3 = w3.zzf;
                    if (j3 > 0) {
                        j2 += j3;
                    }
                }
                M().E(aVar2, "_et", Long.valueOf(j2));
                M().E(aVar, "_fr", 1L);
            }
        }
    }
}

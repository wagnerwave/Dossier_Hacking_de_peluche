package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.g;
import a.d.a.a.e.h;
import a.d.a.a.e.q.c;
import a.d.a.a.h.g.kb;
import a.d.a.a.h.g.u9;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzar;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class d5 extends o3 {

    /* renamed from: a  reason: collision with root package name */
    public final o9 f2148a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f2149b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public String f2150c = null;

    public d5(o9 o9Var) {
        b.k(o9Var);
        this.f2148a = o9Var;
    }

    @BinderThread
    public final void A(zzar zzar, zzn zzn) {
        b.k(zzar);
        U(zzn);
        g(new q5(this, zzar, zzn));
    }

    @BinderThread
    public final String G(zzn zzn) {
        U(zzn);
        o9 o9Var = this.f2148a;
        try {
            return (String) ((FutureTask) o9Var.j.f().t(new r9(o9Var, zzn))).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            o9Var.j.i().f.c("Failed to get app instance id. appId", x3.s(zzn.f4285a), e2);
            return null;
        }
    }

    @BinderThread
    public final void H(Bundle bundle, zzn zzn) {
        if (kb.b() && this.f2148a.j.g.o(q.I0)) {
            U(zzn);
            g(new g5(this, zzn, bundle));
        }
    }

    @BinderThread
    public final void N(long j, String str, String str2, String str3) {
        g(new w5(this, str2, str3, str, j));
    }

    @BinderThread
    public final void P(zzn zzn) {
        h(zzn.f4285a, false);
        g(new o5(this, zzn));
    }

    @BinderThread
    public final List<zzw> Q(String str, String str2, String str3) {
        h(str, true);
        try {
            return (List) ((FutureTask) this.f2148a.f().t(new l5(this, str, str2, str3))).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f2148a.i().f.b("Failed to get conditional user properties as", e2);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void R(zzar zzar, String str, String str2) {
        b.k(zzar);
        b.h(str);
        h(str, true);
        g(new p5(this, zzar, str));
    }

    @BinderThread
    public final List<zzw> S(String str, String str2, zzn zzn) {
        U(zzn);
        try {
            return (List) ((FutureTask) this.f2148a.f().t(new m5(this, zzn, str, str2))).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f2148a.i().f.b("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void U(zzn zzn) {
        b.k(zzn);
        h(zzn.f4285a, false);
        this.f2148a.j.t().a0(zzn.f4286b, zzn.r, zzn.v);
    }

    public final void g(Runnable runnable) {
        b.k(runnable);
        if (this.f2148a.f().x()) {
            runnable.run();
        } else {
            this.f2148a.f().v(runnable);
        }
    }

    @BinderThread
    public final void h(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.f2149b == null) {
                        if (!"com.google.android.gms".equals(this.f2150c) && !b.T(this.f2148a.j.f2123a, Binder.getCallingUid())) {
                            if (!h.a(this.f2148a.j.f2123a).b(Binder.getCallingUid())) {
                                z2 = false;
                                this.f2149b = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.f2149b = Boolean.valueOf(z2);
                    }
                    if (this.f2149b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.f2148a.i().f.b("Measurement Service called with invalid calling package. appId", x3.s(str));
                    throw e2;
                }
            }
            if (this.f2150c == null && g.h(this.f2148a.j.f2123a, Binder.getCallingUid(), str)) {
                this.f2150c = str;
            }
            if (!str.equals(this.f2150c)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.f2148a.i().f.a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @BinderThread
    public final List<zzkw> j(String str, String str2, boolean z, zzn zzn) {
        U(zzn);
        try {
            List<w9> list = (List) ((FutureTask) this.f2148a.f().t(new k5(this, zzn, str, str2))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (w9 w9Var : list) {
                if (z || !v9.s0(w9Var.f2608c)) {
                    arrayList.add(new zzkw(w9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f2148a.i().f.c("Failed to query user properties. appId", x3.s(zzn.f4285a), e2);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzkw> k(zzn zzn, boolean z) {
        U(zzn);
        try {
            List<w9> list = (List) ((FutureTask) this.f2148a.f().t(new u5(this, zzn))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (w9 w9Var : list) {
                if (z || !v9.s0(w9Var.f2608c)) {
                    arrayList.add(new zzkw(w9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f2148a.i().f.c("Failed to get user properties. appId", x3.s(zzn.f4285a), e2);
            return null;
        }
    }

    @BinderThread
    public final void l(zzw zzw, zzn zzn) {
        b.k(zzw);
        b.k(zzw.f4292c);
        U(zzn);
        zzw zzw2 = new zzw(zzw);
        zzw2.f4290a = zzn.f4285a;
        g(new i5(this, zzw2, zzn));
    }

    @BinderThread
    public final void m(zzn zzn) {
        U(zzn);
        g(new t5(this, zzn));
    }

    @BinderThread
    public final void n(zzn zzn) {
        if (u9.b() && this.f2148a.j.g.o(q.Q0)) {
            b.h(zzn.f4285a);
            b.k(zzn.w);
            n5 n5Var = new n5(this, zzn);
            b.k(n5Var);
            if (this.f2148a.f().x()) {
                n5Var.run();
                return;
            }
            v4 f = this.f2148a.f();
            f.n();
            b.k(n5Var);
            f.u(new z4(f, (Runnable) n5Var, true, "Task exception on worker thread"));
        }
    }

    @BinderThread
    public final void r(zzw zzw) {
        b.k(zzw);
        b.k(zzw.f4292c);
        h(zzw.f4290a, true);
        g(new h5(this, new zzw(zzw)));
    }

    @BinderThread
    public final void u(zzkw zzkw, zzn zzn) {
        b.k(zzkw);
        U(zzn);
        g(new r5(this, zzkw, zzn));
    }

    @BinderThread
    public final void w(zzn zzn) {
        U(zzn);
        g(new f5(this, zzn));
    }

    @BinderThread
    public final List<zzkw> y(String str, String str2, String str3, boolean z) {
        h(str, true);
        try {
            List<w9> list = (List) ((FutureTask) this.f2148a.f().t(new j5(this, str, str2, str3))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (w9 w9Var : list) {
                if (z || !v9.s0(w9Var.f2608c)) {
                    arrayList.add(new zzkw(w9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f2148a.i().f.c("Failed to get user properties as. appId", x3.s(str), e2);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final byte[] z(zzar zzar, String str) {
        b.h(str);
        b.k(zzar);
        h(str, true);
        this.f2148a.i().m.b("Log and bundle. event", this.f2148a.N().u(zzar.f4276a));
        if (((c) this.f2148a.j.n) != null) {
            long nanoTime = System.nanoTime() / 1000000;
            v4 f = this.f2148a.f();
            s5 s5Var = new s5(this, zzar, str);
            f.n();
            b.k(s5Var);
            z4 z4Var = new z4(f, s5Var, true, "Task exception on worker thread");
            if (Thread.currentThread() == f.f2560c) {
                z4Var.run();
            } else {
                f.u(z4Var);
            }
            try {
                byte[] bArr = (byte[]) z4Var.get();
                if (bArr == null) {
                    this.f2148a.i().f.b("Log and bundle returned null. appId", x3.s(str));
                    bArr = new byte[0];
                }
                if (((c) this.f2148a.j.n) != null) {
                    this.f2148a.i().m.d("Log and bundle processed. event, size, time_ms", this.f2148a.N().u(zzar.f4276a), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - nanoTime));
                    return bArr;
                }
                throw null;
            } catch (InterruptedException | ExecutionException e2) {
                this.f2148a.i().f.d("Failed to log and bundle. appId, event, error", x3.s(str), this.f2148a.N().u(zzar.f4276a), e2);
                return null;
            }
        } else {
            throw null;
        }
    }
}

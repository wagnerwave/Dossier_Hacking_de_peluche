package a.d.a.a.i.b;

import a.c.a.f.b;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;

public final class a4 {
    public long A;
    public long B;
    public long C;
    public String D;
    public boolean E;
    public long F;
    public long G;

    /* renamed from: a  reason: collision with root package name */
    public final c5 f2076a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2077b;

    /* renamed from: c  reason: collision with root package name */
    public String f2078c;

    /* renamed from: d  reason: collision with root package name */
    public String f2079d;

    /* renamed from: e  reason: collision with root package name */
    public String f2080e;
    public String f;
    public long g;
    public long h;
    public long i;
    public String j;
    public long k;
    public String l;
    public long m;
    public long n;
    public boolean o;
    public long p;
    public boolean q;
    public boolean r;
    public String s;
    public Boolean t;
    public long u;
    public List<String> v;
    public String w;
    public long x;
    public long y;
    public long z;

    @WorkerThread
    public a4(c5 c5Var, String str) {
        b.k(c5Var);
        b.h(str);
        this.f2076a = c5Var;
        this.f2077b = str;
        c5Var.f().b();
    }

    @WorkerThread
    public final void A(String str) {
        this.f2076a.f().b();
        this.E |= !v9.r0(this.f, str);
        this.f = str;
    }

    @WorkerThread
    public final String B() {
        this.f2076a.f().b();
        return this.w;
    }

    @WorkerThread
    public final void C(long j2) {
        boolean z2 = true;
        b.d(j2 >= 0);
        this.f2076a.f().b();
        boolean z3 = this.E;
        if (this.g == j2) {
            z2 = false;
        }
        this.E = z2 | z3;
        this.g = j2;
    }

    @WorkerThread
    public final void D(String str) {
        this.f2076a.f().b();
        this.E |= !v9.r0(this.j, str);
        this.j = str;
    }

    @WorkerThread
    public final String E() {
        this.f2076a.f().b();
        return this.f2080e;
    }

    @WorkerThread
    public final void F(long j2) {
        this.f2076a.f().b();
        this.E |= this.F != j2;
        this.F = j2;
    }

    @WorkerThread
    public final void G(String str) {
        this.f2076a.f().b();
        this.E |= !v9.r0(this.l, str);
        this.l = str;
    }

    @WorkerThread
    public final String H() {
        this.f2076a.f().b();
        return this.f;
    }

    @WorkerThread
    public final void I(long j2) {
        this.f2076a.f().b();
        this.E |= this.G != j2;
        this.G = j2;
    }

    @WorkerThread
    public final void J(String str) {
        this.f2076a.f().b();
        this.E |= !v9.r0(this.D, str);
        this.D = str;
    }

    @WorkerThread
    public final long K() {
        this.f2076a.f().b();
        return this.h;
    }

    @WorkerThread
    public final long L() {
        this.f2076a.f().b();
        return this.i;
    }

    @WorkerThread
    public final String M() {
        this.f2076a.f().b();
        return this.j;
    }

    @WorkerThread
    public final long N() {
        this.f2076a.f().b();
        return this.k;
    }

    @WorkerThread
    public final String O() {
        this.f2076a.f().b();
        return this.l;
    }

    @WorkerThread
    public final long P() {
        this.f2076a.f().b();
        return this.m;
    }

    @WorkerThread
    public final long Q() {
        this.f2076a.f().b();
        return this.n;
    }

    @WorkerThread
    public final void R(long j2) {
        this.f2076a.f().b();
        this.E |= this.p != j2;
        this.p = j2;
    }

    @WorkerThread
    public final long S() {
        this.f2076a.f().b();
        return this.u;
    }

    @WorkerThread
    public final boolean T() {
        this.f2076a.f().b();
        return this.o;
    }

    @WorkerThread
    public final long U() {
        this.f2076a.f().b();
        return this.g;
    }

    @WorkerThread
    public final long V() {
        this.f2076a.f().b();
        return this.F;
    }

    @WorkerThread
    public final long W() {
        this.f2076a.f().b();
        return this.G;
    }

    @WorkerThread
    public final void X() {
        this.f2076a.f().b();
        long j2 = this.g + 1;
        if (j2 > 2147483647L) {
            this.f2076a.i().i.b("Bundle index overflow. appId", x3.s(this.f2077b));
            j2 = 0;
        }
        this.E = true;
        this.g = j2;
    }

    @WorkerThread
    public final void a(long j2) {
        this.f2076a.f().b();
        this.E |= this.h != j2;
        this.h = j2;
    }

    @WorkerThread
    public final void b(Boolean bool) {
        this.f2076a.f().b();
        boolean z2 = this.E;
        Boolean bool2 = this.t;
        this.E = z2 | (!((bool2 == null && bool == null) ? true : bool2 == null ? false : bool2.equals(bool)));
        this.t = bool;
    }

    @WorkerThread
    public final void c(String str) {
        this.f2076a.f().b();
        this.E |= !v9.r0(this.f2078c, str);
        this.f2078c = str;
    }

    @WorkerThread
    public final void d(@Nullable List<String> list) {
        this.f2076a.f().b();
        List<String> list2 = this.v;
        if (!((list2 == null && list == null) ? true : list2 == null ? false : list2.equals(list))) {
            this.E = true;
            this.v = list != null ? new ArrayList(list) : null;
        }
    }

    @WorkerThread
    public final void e(boolean z2) {
        this.f2076a.f().b();
        this.E |= this.o != z2;
        this.o = z2;
    }

    @WorkerThread
    public final String f() {
        this.f2076a.f().b();
        String str = this.D;
        J((String) null);
        return str;
    }

    @WorkerThread
    public final long g() {
        this.f2076a.f().b();
        return this.p;
    }

    @WorkerThread
    public final boolean h() {
        this.f2076a.f().b();
        return this.q;
    }

    @WorkerThread
    public final boolean i() {
        this.f2076a.f().b();
        return this.r;
    }

    @WorkerThread
    public final Boolean j() {
        this.f2076a.f().b();
        return this.t;
    }

    @WorkerThread
    @Nullable
    public final List<String> k() {
        this.f2076a.f().b();
        return this.v;
    }

    @WorkerThread
    public final void l(long j2) {
        this.f2076a.f().b();
        this.E |= this.i != j2;
        this.i = j2;
    }

    @WorkerThread
    public final void m(String str) {
        this.f2076a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !v9.r0(this.f2079d, str);
        this.f2079d = str;
    }

    @WorkerThread
    public final void n(boolean z2) {
        this.f2076a.f().b();
        this.E |= this.q != z2;
        this.q = z2;
    }

    @WorkerThread
    public final String o() {
        this.f2076a.f().b();
        return this.f2077b;
    }

    @WorkerThread
    public final void p(long j2) {
        this.f2076a.f().b();
        this.E |= this.k != j2;
        this.k = j2;
    }

    @WorkerThread
    public final void q(String str) {
        this.f2076a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !v9.r0(this.s, str);
        this.s = str;
    }

    @WorkerThread
    public final void r(boolean z2) {
        this.f2076a.f().b();
        this.E |= this.r != z2;
        this.r = z2;
    }

    @WorkerThread
    public final String s() {
        this.f2076a.f().b();
        return this.f2078c;
    }

    @WorkerThread
    public final void t(long j2) {
        this.f2076a.f().b();
        this.E |= this.m != j2;
        this.m = j2;
    }

    @WorkerThread
    public final void u(String str) {
        this.f2076a.f().b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !v9.r0(this.w, str);
        this.w = str;
    }

    @WorkerThread
    public final String v() {
        this.f2076a.f().b();
        return this.f2079d;
    }

    @WorkerThread
    public final void w(long j2) {
        this.f2076a.f().b();
        this.E |= this.n != j2;
        this.n = j2;
    }

    @WorkerThread
    public final void x(String str) {
        this.f2076a.f().b();
        this.E |= !v9.r0(this.f2080e, str);
        this.f2080e = str;
    }

    @WorkerThread
    public final String y() {
        this.f2076a.f().b();
        return this.s;
    }

    @WorkerThread
    public final void z(long j2) {
        this.f2076a.f().b();
        this.E |= this.u != j2;
        this.u = j2;
    }
}

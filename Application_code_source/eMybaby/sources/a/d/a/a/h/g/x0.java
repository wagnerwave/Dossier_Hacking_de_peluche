package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;
import a.d.a.a.h.g.z0;
import java.util.Collections;
import java.util.List;

public final class x0 extends y5<x0, a> implements j7 {
    public static final x0 zzi;
    public static volatile p7<x0> zzj;
    public int zzc;
    public f6<z0> zzd = u7.f1967d;
    public String zze = "";
    public long zzf;
    public long zzg;
    public int zzh;

    static {
        x0 x0Var = new x0();
        zzi = x0Var;
        y5.zzd.put(x0.class, x0Var);
    }

    public static a C() {
        return (a) zzi.q();
    }

    public static void t(x0 x0Var) {
        if (x0Var != null) {
            x0Var.zzd = u7.f1967d;
            return;
        }
        throw null;
    }

    public static void u(x0 x0Var, int i) {
        x0Var.D();
        x0Var.zzd.remove(i);
    }

    public static void v(x0 x0Var, int i, z0 z0Var) {
        if (x0Var != null) {
            z0Var.getClass();
            x0Var.D();
            x0Var.zzd.set(i, z0Var);
            return;
        }
        throw null;
    }

    public static void w(x0 x0Var, z0 z0Var) {
        if (x0Var != null) {
            z0Var.getClass();
            x0Var.D();
            x0Var.zzd.add(z0Var);
            return;
        }
        throw null;
    }

    public static void x(x0 x0Var, Iterable iterable) {
        x0Var.D();
        o4.i(iterable, x0Var.zzd);
    }

    public static void y(x0 x0Var, String str) {
        if (x0Var != null) {
            str.getClass();
            x0Var.zzc |= 1;
            x0Var.zze = str;
            return;
        }
        throw null;
    }

    public final boolean A() {
        return (this.zzc & 2) != 0;
    }

    public final long B() {
        return this.zzf;
    }

    public final void D() {
        f6<z0> f6Var = this.zzd;
        if (!f6Var.a()) {
            this.zzd = y5.l(f6Var);
        }
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new x0();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", z0.class, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                p7<x0> p7Var = zzj;
                if (p7Var == null) {
                    synchronized (x0.class) {
                        p7Var = zzj;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzi);
                            zzj = p7Var;
                        }
                    }
                }
                return p7Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final List<z0> s() {
        return this.zzd;
    }

    public final String z() {
        return this.zze;
    }

    public static final class a extends y5.b<x0, a> implements j7 {
        public a() {
            super(x0.zzi);
        }

        public final a n(int i, z0 z0Var) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            x0.v((x0) this.f2047b, i, z0Var);
            return this;
        }

        public final a o(long j) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            x0 x0Var = (x0) this.f2047b;
            x0Var.zzc |= 2;
            x0Var.zzf = j;
            return this;
        }

        public final a p(z0.a aVar) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            x0.w((x0) this.f2047b, (z0) ((y5) aVar.m()));
            return this;
        }

        public final a q(String str) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            x0.y((x0) this.f2047b, str);
            return this;
        }

        public final z0 r(int i) {
            return ((x0) this.f2047b).zzd.get(i);
        }

        public final List<z0> s() {
            return Collections.unmodifiableList(((x0) this.f2047b).zzd);
        }

        public final int t() {
            return ((x0) this.f2047b).zzd.size();
        }

        public final a u(int i) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            x0.u((x0) this.f2047b, i);
            return this;
        }

        public final a v(long j) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            x0 x0Var = (x0) this.f2047b;
            x0Var.zzc |= 4;
            x0Var.zzg = j;
            return this;
        }

        public final String w() {
            return ((x0) this.f2047b).zze;
        }

        public final long x() {
            return ((x0) this.f2047b).zzf;
        }

        public final long y() {
            return ((x0) this.f2047b).zzg;
        }

        public a(g1 g1Var) {
            super(x0.zzi);
        }
    }
}

package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class z0 extends y5<z0, a> implements j7 {
    public static final z0 zzj;
    public static volatile p7<z0> zzk;
    public int zzc;
    public String zzd = "";
    public String zze = "";
    public long zzf;
    public float zzg;
    public double zzh;
    public f6<z0> zzi = u7.f1967d;

    static {
        z0 z0Var = new z0();
        zzj = z0Var;
        y5.zzd.put(z0.class, z0Var);
    }

    public static a E() {
        return (a) zzj.q();
    }

    public static void s(z0 z0Var, z0 z0Var2) {
        if (z0Var != null) {
            z0Var2.getClass();
            f6<z0> f6Var = z0Var.zzi;
            if (!f6Var.a()) {
                z0Var.zzi = y5.l(f6Var);
            }
            z0Var.zzi.add(z0Var2);
            return;
        }
        throw null;
    }

    public static void t(z0 z0Var, String str) {
        if (z0Var != null) {
            str.getClass();
            z0Var.zzc |= 1;
            z0Var.zzd = str;
            return;
        }
        throw null;
    }

    public static void v(z0 z0Var, String str) {
        if (z0Var != null) {
            str.getClass();
            z0Var.zzc |= 2;
            z0Var.zze = str;
            return;
        }
        throw null;
    }

    public static void y(z0 z0Var) {
        if (z0Var != null) {
            z0Var.zzi = u7.f1967d;
            return;
        }
        throw null;
    }

    public final long A() {
        return this.zzf;
    }

    public final boolean B() {
        return (this.zzc & 16) != 0;
    }

    public final double C() {
        return this.zzh;
    }

    public final int D() {
        return this.zzi.size();
    }

    public final Object n(int i, Object obj, Object obj2) {
        Class<z0> cls = z0.class;
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new z0();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", cls});
            case 4:
                return zzj;
            case 5:
                p7<z0> p7Var = zzk;
                if (p7Var == null) {
                    synchronized (cls) {
                        p7Var = zzk;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzj);
                            zzk = p7Var;
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

    public final String u() {
        return this.zzd;
    }

    public final boolean w() {
        return (this.zzc & 2) != 0;
    }

    public final String x() {
        return this.zze;
    }

    public final boolean z() {
        return (this.zzc & 4) != 0;
    }

    public static final class a extends y5.b<z0, a> implements j7 {
        public a() {
            super(z0.zzj);
        }

        public final a n(double d2) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            z0 z0Var = (z0) this.f2047b;
            z0Var.zzc |= 16;
            z0Var.zzh = d2;
            return this;
        }

        public final a o(long j) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            z0 z0Var = (z0) this.f2047b;
            z0Var.zzc |= 4;
            z0Var.zzf = j;
            return this;
        }

        public final a p(Iterable<? extends z0> iterable) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            z0 z0Var = (z0) this.f2047b;
            f6<z0> f6Var = z0Var.zzi;
            if (!f6Var.a()) {
                z0Var.zzi = y5.l(f6Var);
            }
            o4.i(iterable, z0Var.zzi);
            return this;
        }

        public final a q(String str) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            z0.t((z0) this.f2047b, str);
            return this;
        }

        public final a r(String str) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            z0.v((z0) this.f2047b, str);
            return this;
        }

        public a(g1 g1Var) {
            super(z0.zzj);
        }
    }
}

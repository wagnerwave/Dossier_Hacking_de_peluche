package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class d1 extends y5<d1, a> implements j7 {
    public static final d1 zzg;
    public static volatile p7<d1> zzh;
    public g6 zzc;
    public g6 zzd;
    public f6<w0> zze;
    public f6<e1> zzf;

    static {
        d1 d1Var = new d1();
        zzg = d1Var;
        y5.zzd.put(d1.class, d1Var);
    }

    public d1() {
        w6 w6Var = w6.f2005d;
        this.zzc = w6Var;
        this.zzd = w6Var;
        u7<Object> u7Var = u7.f1967d;
        this.zze = u7Var;
        this.zzf = u7Var;
    }

    public static void t(d1 d1Var) {
        if (d1Var != null) {
            d1Var.zzc = w6.f2005d;
            return;
        }
        throw null;
    }

    public static void v(d1 d1Var) {
        if (d1Var != null) {
            d1Var.zzd = w6.f2005d;
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new d1();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", w0.class, "zzf", e1.class});
            case 4:
                return zzg;
            case 5:
                p7<d1> p7Var = zzh;
                if (p7Var == null) {
                    synchronized (d1.class) {
                        p7Var = zzh;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzg);
                            zzh = p7Var;
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

    public final w0 s(int i) {
        return this.zze.get(i);
    }

    public final e1 u(int i) {
        return this.zzf.get(i);
    }

    public final int w() {
        return this.zze.size();
    }

    public final int x() {
        return this.zzf.size();
    }

    public static final class a extends y5.b<d1, a> implements j7 {
        public a() {
            super(d1.zzg);
        }

        public final a n() {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            d1.t((d1) this.f2047b);
            return this;
        }

        public final a o(int i) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            d1 d1Var = (d1) this.f2047b;
            f6<w0> f6Var = d1Var.zze;
            if (!f6Var.a()) {
                d1Var.zze = y5.l(f6Var);
            }
            d1Var.zze.remove(i);
            return this;
        }

        public final a p(Iterable<? extends Long> iterable) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            d1 d1Var = (d1) this.f2047b;
            g6 g6Var = d1Var.zzc;
            if (!g6Var.a()) {
                d1Var.zzc = y5.m(g6Var);
            }
            o4.i(iterable, d1Var.zzc);
            return this;
        }

        public final a q() {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            d1.v((d1) this.f2047b);
            return this;
        }

        public final a r(int i) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            d1 d1Var = (d1) this.f2047b;
            f6<e1> f6Var = d1Var.zzf;
            if (!f6Var.a()) {
                d1Var.zzf = y5.l(f6Var);
            }
            d1Var.zzf.remove(i);
            return this;
        }

        public final a s(Iterable<? extends Long> iterable) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            d1 d1Var = (d1) this.f2047b;
            g6 g6Var = d1Var.zzd;
            if (!g6Var.a()) {
                d1Var.zzd = y5.m(g6Var);
            }
            o4.i(iterable, d1Var.zzd);
            return this;
        }

        public a(g1 g1Var) {
            super(d1.zzg);
        }
    }
}

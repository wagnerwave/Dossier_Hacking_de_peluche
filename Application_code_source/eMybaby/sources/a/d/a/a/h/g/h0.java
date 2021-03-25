package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class h0 extends y5<h0, a> implements j7 {
    public static final h0 zzi;
    public static volatile p7<h0> zzj;
    public int zzc;
    public int zzd;
    public f6<l0> zze;
    public f6<i0> zzf;
    public boolean zzg;
    public boolean zzh;

    static {
        h0 h0Var = new h0();
        zzi = h0Var;
        y5.zzd.put(h0.class, h0Var);
    }

    public h0() {
        u7<Object> u7Var = u7.f1967d;
        this.zze = u7Var;
        this.zzf = u7Var;
    }

    public static void s(h0 h0Var, int i, i0 i0Var) {
        if (h0Var != null) {
            i0Var.getClass();
            f6<i0> f6Var = h0Var.zzf;
            if (!f6Var.a()) {
                h0Var.zzf = y5.l(f6Var);
            }
            h0Var.zzf.set(i, i0Var);
            return;
        }
        throw null;
    }

    public static void t(h0 h0Var, int i, l0 l0Var) {
        if (h0Var != null) {
            l0Var.getClass();
            f6<l0> f6Var = h0Var.zze;
            if (!f6Var.a()) {
                h0Var.zze = y5.l(f6Var);
            }
            h0Var.zze.set(i, l0Var);
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (n0.f1841a[i - 1]) {
            case 1:
                return new h0();
            case 2:
                return new a((n0) null);
            case 3:
                return new t7(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", l0.class, "zzf", i0.class, "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                p7<h0> p7Var = zzj;
                if (p7Var == null) {
                    synchronized (h0.class) {
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

    public static final class a extends y5.b<h0, a> implements j7 {
        public a() {
            super(h0.zzi);
        }

        public a(n0 n0Var) {
            super(h0.zzi);
        }
    }
}

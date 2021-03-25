package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class e1 extends y5<e1, a> implements j7 {
    public static final e1 zzf;
    public static volatile p7<e1> zzg;
    public int zzc;
    public int zzd;
    public g6 zze = w6.f2005d;

    static {
        e1 e1Var = new e1();
        zzf = e1Var;
        y5.zzd.put(e1.class, e1Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new e1();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                p7<e1> p7Var = zzg;
                if (p7Var == null) {
                    synchronized (e1.class) {
                        p7Var = zzg;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzf);
                            zzg = p7Var;
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

    public final long s(int i) {
        w6 w6Var = (w6) this.zze;
        w6Var.l(i);
        return w6Var.f2006b[i];
    }

    public final int t() {
        return this.zzd;
    }

    public final int u() {
        return this.zze.size();
    }

    public static final class a extends y5.b<e1, a> implements j7 {
        public a() {
            super(e1.zzf);
        }

        public a(g1 g1Var) {
            super(e1.zzf);
        }
    }
}

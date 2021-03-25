package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class v0 extends y5<v0, a> implements j7 {
    public static final v0 zzh;
    public static volatile p7<v0> zzi;
    public int zzc;
    public int zzd;
    public d1 zze;
    public d1 zzf;
    public boolean zzg;

    static {
        v0 v0Var = new v0();
        zzh = v0Var;
        y5.zzd.put(v0.class, v0Var);
    }

    public static void s(v0 v0Var, d1 d1Var) {
        if (v0Var != null) {
            d1Var.getClass();
            v0Var.zze = d1Var;
            v0Var.zzc |= 2;
            return;
        }
        throw null;
    }

    public static void t(v0 v0Var, d1 d1Var) {
        if (v0Var != null) {
            d1Var.getClass();
            v0Var.zzf = d1Var;
            v0Var.zzc |= 4;
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new v0();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                p7<v0> p7Var = zzi;
                if (p7Var == null) {
                    synchronized (v0.class) {
                        p7Var = zzi;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzh);
                            zzi = p7Var;
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

    public static final class a extends y5.b<v0, a> implements j7 {
        public a() {
            super(v0.zzh);
        }

        public a(g1 g1Var) {
            super(v0.zzh);
        }
    }
}

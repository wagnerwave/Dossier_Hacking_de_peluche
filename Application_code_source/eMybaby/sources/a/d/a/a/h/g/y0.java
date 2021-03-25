package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class y0 extends y5<y0, a> implements j7 {
    public static final y0 zzf;
    public static volatile p7<y0> zzg;
    public int zzc;
    public String zzd = "";
    public long zze;

    public static final class a extends y5.b<y0, a> implements j7 {
        public a(g1 g1Var) {
            super(y0.zzf);
        }
    }

    static {
        y0 y0Var = new y0();
        zzf = y0Var;
        y5.zzd.put(y0.class, y0Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new y0();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                p7<y0> p7Var = zzg;
                if (p7Var == null) {
                    synchronized (y0.class) {
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
}

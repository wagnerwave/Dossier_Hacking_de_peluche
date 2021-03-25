package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class j1 extends y5<j1, a> implements j7 {
    public static final j1 zzd;
    public static volatile p7<j1> zze;
    public f6<k1> zzc = u7.f1967d;

    public static final class a extends y5.b<j1, a> implements j7 {
        public a(i1 i1Var) {
            super(j1.zzd);
        }
    }

    static {
        j1 j1Var = new j1();
        zzd = j1Var;
        y5.zzd.put(j1.class, j1Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (i1.f1732a[i - 1]) {
            case 1:
                return new j1();
            case 2:
                return new a((i1) null);
            case 3:
                return new t7(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", k1.class});
            case 4:
                return zzd;
            case 5:
                p7<j1> p7Var = zze;
                if (p7Var == null) {
                    synchronized (j1.class) {
                        p7Var = zze;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzd);
                            zze = p7Var;
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

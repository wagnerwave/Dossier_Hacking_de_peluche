package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class s0 extends y5<s0, a> implements j7 {
    public static final s0 zzf;
    public static volatile p7<s0> zzg;
    public int zzc;
    public String zzd = "";
    public String zze = "";

    public static final class a extends y5.b<s0, a> implements j7 {
        public a(u0 u0Var) {
            super(s0.zzf);
        }
    }

    static {
        s0 s0Var = new s0();
        zzf = s0Var;
        y5.zzd.put(s0.class, s0Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (u0.f1957a[i - 1]) {
            case 1:
                return new s0();
            case 2:
                return new a((u0) null);
            case 3:
                return new t7(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                p7<s0> p7Var = zzg;
                if (p7Var == null) {
                    synchronized (s0.class) {
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

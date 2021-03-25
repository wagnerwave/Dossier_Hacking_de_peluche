package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class w0 extends y5<w0, a> implements j7 {
    public static final w0 zzf;
    public static volatile p7<w0> zzg;
    public int zzc;
    public int zzd;
    public long zze;

    static {
        w0 w0Var = new w0();
        zzf = w0Var;
        y5.zzd.put(w0.class, w0Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new w0();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                p7<w0> p7Var = zzg;
                if (p7Var == null) {
                    synchronized (w0.class) {
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

    public final int s() {
        return this.zzd;
    }

    public final boolean t() {
        return (this.zzc & 2) != 0;
    }

    public final long u() {
        return this.zze;
    }

    public static final class a extends y5.b<w0, a> implements j7 {
        public a() {
            super(w0.zzf);
        }

        public a(g1 g1Var) {
            super(w0.zzf);
        }
    }
}

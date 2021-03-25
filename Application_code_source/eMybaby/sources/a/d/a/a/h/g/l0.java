package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class l0 extends y5<l0, a> implements j7 {
    public static final l0 zzj;
    public static volatile p7<l0> zzk;
    public int zzc;
    public int zzd;
    public String zze = "";
    public j0 zzf;
    public boolean zzg;
    public boolean zzh;
    public boolean zzi;

    static {
        l0 l0Var = new l0();
        zzj = l0Var;
        y5.zzd.put(l0.class, l0Var);
    }

    public static void s(l0 l0Var, String str) {
        if (l0Var != null) {
            str.getClass();
            l0Var.zzc |= 2;
            l0Var.zze = str;
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (n0.f1841a[i - 1]) {
            case 1:
                return new l0();
            case 2:
                return new a((n0) null);
            case 3:
                return new t7(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                p7<l0> p7Var = zzk;
                if (p7Var == null) {
                    synchronized (l0.class) {
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

    public final boolean t() {
        return (this.zzc & 1) != 0;
    }

    public final int u() {
        return this.zzd;
    }

    public final String v() {
        return this.zze;
    }

    public static final class a extends y5.b<l0, a> implements j7 {
        public a() {
            super(l0.zzj);
        }

        public a(n0 n0Var) {
            super(l0.zzj);
        }
    }
}

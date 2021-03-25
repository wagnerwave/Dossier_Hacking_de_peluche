package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class j0 extends y5<j0, a> implements j7 {
    public static final j0 zzh;
    public static volatile p7<j0> zzi;
    public int zzc;
    public m0 zzd;
    public k0 zze;
    public boolean zzf;
    public String zzg = "";

    static {
        j0 j0Var = new j0();
        zzh = j0Var;
        y5.zzd.put(j0.class, j0Var);
    }

    public static void s(j0 j0Var, String str) {
        if (j0Var != null) {
            str.getClass();
            j0Var.zzc |= 8;
            j0Var.zzg = str;
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (n0.f1841a[i - 1]) {
            case 1:
                return new j0();
            case 2:
                return new a((n0) null);
            case 3:
                return new t7(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                p7<j0> p7Var = zzi;
                if (p7Var == null) {
                    synchronized (j0.class) {
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

    public final boolean t() {
        return (this.zzc & 1) != 0;
    }

    public final m0 u() {
        m0 m0Var = this.zzd;
        return m0Var == null ? m0.zzh : m0Var;
    }

    public final boolean v() {
        return (this.zzc & 2) != 0;
    }

    public final k0 w() {
        k0 k0Var = this.zze;
        return k0Var == null ? k0.zzi : k0Var;
    }

    public static final class a extends y5.b<j0, a> implements j7 {
        public a() {
            super(j0.zzh);
        }

        public a(n0 n0Var) {
            super(j0.zzh);
        }
    }
}

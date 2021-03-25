package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class i0 extends y5<i0, a> implements j7 {
    public static final i0 zzl;
    public static volatile p7<i0> zzm;
    public int zzc;
    public int zzd;
    public String zze = "";
    public f6<j0> zzf = u7.f1967d;
    public boolean zzg;
    public k0 zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;

    static {
        i0 i0Var = new i0();
        zzl = i0Var;
        y5.zzd.put(i0.class, i0Var);
    }

    public static void s(i0 i0Var, int i, j0 j0Var) {
        if (i0Var != null) {
            j0Var.getClass();
            f6<j0> f6Var = i0Var.zzf;
            if (!f6Var.a()) {
                i0Var.zzf = y5.l(f6Var);
            }
            i0Var.zzf.set(i, j0Var);
            return;
        }
        throw null;
    }

    public static void t(i0 i0Var, String str) {
        if (i0Var != null) {
            str.getClass();
            i0Var.zzc |= 2;
            i0Var.zze = str;
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (n0.f1841a[i - 1]) {
            case 1:
                return new i0();
            case 2:
                return new a((n0) null);
            case 3:
                return new t7(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", j0.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                p7<i0> p7Var = zzm;
                if (p7Var == null) {
                    synchronized (i0.class) {
                        p7Var = zzm;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzl);
                            zzm = p7Var;
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

    public final boolean u() {
        return (this.zzc & 1) != 0;
    }

    public final int v() {
        return this.zzd;
    }

    public final boolean w() {
        return (this.zzc & 8) != 0;
    }

    public final boolean x() {
        return this.zzj;
    }

    public static final class a extends y5.b<i0, a> implements j7 {
        public a() {
            super(i0.zzl);
        }

        public a(n0 n0Var) {
            super(i0.zzl);
        }
    }
}

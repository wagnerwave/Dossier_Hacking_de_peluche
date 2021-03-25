package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class q0 extends y5<q0, a> implements j7 {
    public static final q0 zzh;
    public static volatile p7<q0> zzi;
    public int zzc;
    public String zzd = "";
    public boolean zze;
    public boolean zzf;
    public int zzg;

    static {
        q0 q0Var = new q0();
        zzh = q0Var;
        y5.zzd.put(q0.class, q0Var);
    }

    public static void s(q0 q0Var, String str) {
        if (q0Var != null) {
            str.getClass();
            q0Var.zzc |= 1;
            q0Var.zzd = str;
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (u0.f1957a[i - 1]) {
            case 1:
                return new q0();
            case 2:
                return new a((u0) null);
            case 3:
                return new t7(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                p7<q0> p7Var = zzi;
                if (p7Var == null) {
                    synchronized (q0.class) {
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

    public static final class a extends y5.b<q0, a> implements j7 {
        public a() {
            super(q0.zzh);
        }

        public final String n() {
            return ((q0) this.f2047b).zzd;
        }

        public final int o() {
            return ((q0) this.f2047b).zzg;
        }

        public a(u0 u0Var) {
            super(q0.zzh);
        }
    }
}

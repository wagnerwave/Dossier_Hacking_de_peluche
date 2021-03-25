package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class r0 extends y5<r0, a> implements j7 {
    public static final r0 zzm;
    public static volatile p7<r0> zzn;
    public int zzc;
    public long zzd;
    public String zze = "";
    public int zzf;
    public f6<s0> zzg;
    public f6<q0> zzh;
    public f6<h0> zzi;
    public String zzj;
    public boolean zzk;
    public f6<j1> zzl;

    static {
        r0 r0Var = new r0();
        zzm = r0Var;
        y5.zzd.put(r0.class, r0Var);
    }

    public r0() {
        u7<Object> u7Var = u7.f1967d;
        this.zzg = u7Var;
        this.zzh = u7Var;
        this.zzi = u7Var;
        this.zzj = "";
        this.zzl = u7Var;
    }

    public static void s(r0 r0Var) {
        if (r0Var != null) {
            r0Var.zzi = u7.f1967d;
            return;
        }
        throw null;
    }

    public static void t(r0 r0Var, int i, q0 q0Var) {
        if (r0Var != null) {
            q0Var.getClass();
            f6<q0> f6Var = r0Var.zzh;
            if (!f6Var.a()) {
                r0Var.zzh = y5.l(f6Var);
            }
            r0Var.zzh.set(i, q0Var);
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (u0.f1957a[i - 1]) {
            case 1:
                return new r0();
            case 2:
                return new a((u0) null);
            case 3:
                return new t7(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", s0.class, "zzh", q0.class, "zzi", h0.class, "zzj", "zzk", "zzl", j1.class});
            case 4:
                return zzm;
            case 5:
                p7<r0> p7Var = zzn;
                if (p7Var == null) {
                    synchronized (r0.class) {
                        p7Var = zzn;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzm);
                            zzn = p7Var;
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

    public final long v() {
        return this.zzd;
    }

    public static final class a extends y5.b<r0, a> implements j7 {
        public a() {
            super(r0.zzm);
        }

        public a(u0 u0Var) {
            super(r0.zzm);
        }
    }
}

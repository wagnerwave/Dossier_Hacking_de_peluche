package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class f1 extends y5<f1, a> implements j7 {
    public static final f1 zzj;
    public static volatile p7<f1> zzk;
    public int zzc;
    public long zzd;
    public String zze = "";
    public String zzf = "";
    public long zzg;
    public float zzh;
    public double zzi;

    static {
        f1 f1Var = new f1();
        zzj = f1Var;
        y5.zzd.put(f1.class, f1Var);
    }

    public static void s(f1 f1Var, String str) {
        if (f1Var != null) {
            str.getClass();
            f1Var.zzc |= 2;
            f1Var.zze = str;
            return;
        }
        throw null;
    }

    public static void t(f1 f1Var, String str) {
        if (f1Var != null) {
            str.getClass();
            f1Var.zzc |= 4;
            f1Var.zzf = str;
            return;
        }
        throw null;
    }

    public static a v() {
        return (a) zzj.q();
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new f1();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                p7<f1> p7Var = zzk;
                if (p7Var == null) {
                    synchronized (f1.class) {
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

    public final String u() {
        return this.zze;
    }

    public static final class a extends y5.b<f1, a> implements j7 {
        public a() {
            super(f1.zzj);
        }

        public final a n(long j) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            f1 f1Var = (f1) this.f2047b;
            f1Var.zzc |= 1;
            f1Var.zzd = j;
            return this;
        }

        public final a o(String str) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            f1.s((f1) this.f2047b, str);
            return this;
        }

        public final a p(long j) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            f1 f1Var = (f1) this.f2047b;
            f1Var.zzc |= 8;
            f1Var.zzg = j;
            return this;
        }

        public a(g1 g1Var) {
            super(f1.zzj);
        }
    }
}

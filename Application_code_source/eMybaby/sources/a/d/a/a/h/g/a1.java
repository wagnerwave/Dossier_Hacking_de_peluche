package a.d.a.a.h.g;

import a.d.a.a.h.g.b1;
import a.d.a.a.h.g.y5;

public final class a1 extends y5<a1, a> implements j7 {
    public static final a1 zzd;
    public static volatile p7<a1> zze;
    public f6<b1> zzc = u7.f1967d;

    static {
        a1 a1Var = new a1();
        zzd = a1Var;
        y5.zzd.put(a1.class, a1Var);
    }

    public static void s(a1 a1Var, b1 b1Var) {
        if (a1Var != null) {
            b1Var.getClass();
            f6<b1> f6Var = a1Var.zzc;
            if (!f6Var.a()) {
                a1Var.zzc = y5.l(f6Var);
            }
            a1Var.zzc.add(b1Var);
            return;
        }
        throw null;
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new a1();
            case 2:
                return new a((g1) null);
            case 3:
                return new t7(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", b1.class});
            case 4:
                return zzd;
            case 5:
                p7<a1> p7Var = zze;
                if (p7Var == null) {
                    synchronized (a1.class) {
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

    public static final class a extends y5.b<a1, a> implements j7 {
        public a() {
            super(a1.zzd);
        }

        public final a n(b1.a aVar) {
            if (this.f2048c) {
                k();
                this.f2048c = false;
            }
            a1.s((a1) this.f2047b, (b1) ((y5) aVar.m()));
            return this;
        }

        public a(g1 g1Var) {
            super(a1.zzd);
        }
    }
}

package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class k0 extends y5<k0, b> implements j7 {
    public static final k0 zzi;
    public static volatile p7<k0> zzj;
    public int zzc;
    public int zzd;
    public boolean zze;
    public String zzf = "";
    public String zzg = "";
    public String zzh = "";

    public enum a implements c6 {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f1763a;

        /* access modifiers changed from: public */
        a(int i) {
            this.f1763a = i;
        }

        public static a f(int i) {
            if (i == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i == 1) {
                return LESS_THAN;
            }
            if (i == 2) {
                return GREATER_THAN;
            }
            if (i == 3) {
                return EQUAL;
            }
            if (i != 4) {
                return null;
            }
            return BETWEEN;
        }

        public final int a() {
            return this.f1763a;
        }

        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1763a + " name=" + name() + '>';
        }
    }

    public static final class b extends y5.b<k0, b> implements j7 {
        public b(n0 n0Var) {
            super(k0.zzi);
        }
    }

    static {
        k0 k0Var = new k0();
        zzi = k0Var;
        y5.zzd.put(k0.class, k0Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (n0.f1841a[i - 1]) {
            case 1:
                return new k0();
            case 2:
                return new b((n0) null);
            case 3:
                return new t7(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", o0.f1860a, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                p7<k0> p7Var = zzj;
                if (p7Var == null) {
                    synchronized (k0.class) {
                        p7Var = zzj;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzi);
                            zzj = p7Var;
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

    public final a s() {
        a f = a.f(this.zzd);
        return f == null ? a.UNKNOWN_COMPARISON_TYPE : f;
    }
}

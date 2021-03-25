package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class m0 extends y5<m0, a> implements j7 {
    public static final m0 zzh;
    public static volatile p7<m0> zzi;
    public int zzc;
    public int zzd;
    public String zze = "";
    public boolean zzf;
    public f6<String> zzg = u7.f1967d;

    public static final class a extends y5.b<m0, a> implements j7 {
        public a(n0 n0Var) {
            super(m0.zzh);
        }
    }

    public enum b implements c6 {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f1821a;

        /* access modifiers changed from: public */
        b(int i2) {
            this.f1821a = i2;
        }

        public static b f(int i2) {
            switch (i2) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        public final int a() {
            return this.f1821a;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1821a + " name=" + name() + '>';
        }
    }

    static {
        m0 m0Var = new m0();
        zzh = m0Var;
        y5.zzd.put(m0.class, m0Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (n0.f1841a[i - 1]) {
            case 1:
                return new m0();
            case 2:
                return new a((n0) null);
            case 3:
                return new t7(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", t0.f1943a, "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                p7<m0> p7Var = zzi;
                if (p7Var == null) {
                    synchronized (m0.class) {
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

    public final b s() {
        b f = b.f(this.zzd);
        return f == null ? b.UNKNOWN_MATCH_TYPE : f;
    }

    public final int t() {
        return this.zzg.size();
    }
}

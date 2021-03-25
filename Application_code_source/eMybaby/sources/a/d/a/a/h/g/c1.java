package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class c1 extends y5<c1, b> implements j7 {
    public static final c1 zzf;
    public static volatile p7<c1> zzg;
    public int zzc;
    public int zzd = 1;
    public f6<y0> zze = u7.f1967d;

    public enum a implements c6 {
        RADS(1),
        PROVISIONING(2);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f1629a;

        /* access modifiers changed from: public */
        a(int i) {
            this.f1629a = i;
        }

        public final int a() {
            return this.f1629a;
        }

        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1629a + " name=" + name() + '>';
        }
    }

    public static final class b extends y5.b<c1, b> implements j7 {
        public b(g1 g1Var) {
            super(c1.zzf);
        }
    }

    static {
        c1 c1Var = new c1();
        zzf = c1Var;
        y5.zzd.put(c1.class, c1Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        switch (g1.f1712a[i - 1]) {
            case 1:
                return new c1();
            case 2:
                return new b((g1) null);
            case 3:
                return new t7(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", h1.f1720a, "zze", y0.class});
            case 4:
                return zzf;
            case 5:
                p7<c1> p7Var = zzg;
                if (p7Var == null) {
                    synchronized (c1.class) {
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
}

package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;

public final class k1 extends y5<k1, a> implements j7 {
    public static final k1 zzk;
    public static volatile p7<k1> zzl;
    public int zzc;
    public int zzd;
    public String zze = "";
    public boolean zzf;
    public long zzg;
    public double zzh;
    public f6<k1> zzi = u7.f1967d;
    public String zzj = "";

    public static final class a extends y5.b<k1, a> implements j7 {
        public a(i1 i1Var) {
            super(k1.zzk);
        }
    }

    public enum b implements c6 {
        UNDEFINED(0),
        NULL(1),
        STRING(2),
        NUMBER(3),
        BOOLEAN(4),
        LIST(5),
        MAP(6),
        STATEMENT(7);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f1768a;

        /* access modifiers changed from: public */
        b(int i) {
            this.f1768a = i;
        }

        public final int a() {
            return this.f1768a;
        }

        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1768a + " name=" + name() + '>';
        }
    }

    static {
        k1 k1Var = new k1();
        zzk = k1Var;
        y5.zzd.put(k1.class, k1Var);
    }

    public final Object n(int i, Object obj, Object obj2) {
        Class<k1> cls = k1.class;
        switch (i1.f1732a[i - 1]) {
            case 1:
                return new k1();
            case 2:
                return new a((i1) null);
            case 3:
                return new t7(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005က\u0004\u0006\u001b\u0007ဈ\u0005", new Object[]{"zzc", "zzd", m1.f1822a, "zze", "zzf", "zzg", "zzh", "zzi", cls, "zzj"});
            case 4:
                return zzk;
            case 5:
                p7<k1> p7Var = zzl;
                if (p7Var == null) {
                    synchronized (cls) {
                        p7Var = zzl;
                        if (p7Var == null) {
                            p7Var = new y5.a<>(zzk);
                            zzl = p7Var;
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

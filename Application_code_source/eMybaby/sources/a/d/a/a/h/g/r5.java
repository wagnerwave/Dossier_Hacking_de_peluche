package a.d.a.a.h.g;

import a.d.a.a.h.g.t5;
import a.d.a.a.h.g.y5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class r5<T extends t5<T>> {

    /* renamed from: d  reason: collision with root package name */
    public static final r5 f1916d = new r5(true);

    /* renamed from: a  reason: collision with root package name */
    public final z7<T, Object> f1917a = z7.b(16);

    /* renamed from: b  reason: collision with root package name */
    public boolean f1918b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1919c;

    public r5() {
    }

    public r5(boolean z) {
        g();
        g();
    }

    public static int a(t5<?> t5Var, Object obj) {
        x8 b2 = t5Var.b();
        int a2 = t5Var.a();
        if (!t5Var.d()) {
            return b(b2, a2, obj);
        }
        int i = 0;
        List<Object> list = (List) obj;
        if (t5Var.e()) {
            for (Object f : list) {
                i += f(b2, f);
            }
            return i5.A(a2) + i + i5.I(i);
        }
        for (Object b3 : list) {
            i += b(b2, a2, b3);
        }
        return i;
    }

    public static int b(x8 x8Var, int i, Object obj) {
        int A = i5.A(i);
        if (x8Var == x8.GROUP) {
            i7 i7Var = (i7) obj;
            if (i7Var instanceof p4) {
                p4 p4Var = (p4) i7Var;
            }
            A <<= 1;
        }
        return f(x8Var, obj) + A;
    }

    public static Object c(Object obj) {
        if (obj instanceof l7) {
            return ((l7) obj).a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if ((r2 instanceof byte[]) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        if (r1 == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        throw new java.lang.IllegalArgumentException("Wrong object type used with protocol message reflection.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if ((r2 instanceof a.d.a.a.h.g.j6) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r2 instanceof a.d.a.a.h.g.c6) == false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(a.d.a.a.h.g.x8 r1, java.lang.Object r2) {
        /*
            a.d.a.a.h.g.a6.d(r2)
            int[] r0 = a.d.a.a.h.g.q5.f1894a
            a.d.a.a.h.g.a9 r1 = r1.f2031a
            int r1 = r1.ordinal()
            r1 = r0[r1]
            switch(r1) {
                case 1: goto L_0x003c;
                case 2: goto L_0x0039;
                case 3: goto L_0x0036;
                case 4: goto L_0x0033;
                case 5: goto L_0x0030;
                case 6: goto L_0x002d;
                case 7: goto L_0x0023;
                case 8: goto L_0x001a;
                case 9: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x003f
        L_0x0011:
            boolean r1 = r2 instanceof a.d.a.a.h.g.i7
            if (r1 != 0) goto L_0x002b
            boolean r1 = r2 instanceof a.d.a.a.h.g.j6
            if (r1 == 0) goto L_0x003f
            goto L_0x002b
        L_0x001a:
            boolean r1 = r2 instanceof java.lang.Integer
            if (r1 != 0) goto L_0x002b
            boolean r1 = r2 instanceof a.d.a.a.h.g.c6
            if (r1 == 0) goto L_0x003f
            goto L_0x002b
        L_0x0023:
            boolean r1 = r2 instanceof a.d.a.a.h.g.w4
            if (r1 != 0) goto L_0x002b
            boolean r1 = r2 instanceof byte[]
            if (r1 == 0) goto L_0x003f
        L_0x002b:
            r1 = 1
            goto L_0x0040
        L_0x002d:
            boolean r1 = r2 instanceof java.lang.String
            goto L_0x0040
        L_0x0030:
            boolean r1 = r2 instanceof java.lang.Boolean
            goto L_0x0040
        L_0x0033:
            boolean r1 = r2 instanceof java.lang.Double
            goto L_0x0040
        L_0x0036:
            boolean r1 = r2 instanceof java.lang.Float
            goto L_0x0040
        L_0x0039:
            boolean r1 = r2 instanceof java.lang.Long
            goto L_0x0040
        L_0x003c:
            boolean r1 = r2 instanceof java.lang.Integer
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            if (r1 == 0) goto L_0x0043
            return
        L_0x0043:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Wrong object type used with protocol message reflection."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.r5.d(a.d.a.a.h.g.x8, java.lang.Object):void");
    }

    public static <T extends t5<T>> boolean e(Map.Entry<T, Object> entry) {
        t5 t5Var = (t5) entry.getKey();
        if (t5Var.c() == a9.MESSAGE) {
            boolean d2 = t5Var.d();
            Object value = entry.getValue();
            if (d2) {
                for (i7 g : (List) value) {
                    if (!g.g()) {
                        return false;
                    }
                }
            } else if (value instanceof i7) {
                if (!((i7) value).g()) {
                    return false;
                }
            } else if (value instanceof j6) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public static int f(x8 x8Var, Object obj) {
        switch (q5.f1895b[x8Var.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                i5.q();
                return 8;
            case 2:
                ((Float) obj).floatValue();
                i5.h();
                return 4;
            case 3:
                return i5.C(((Long) obj).longValue());
            case 4:
                return i5.C(((Long) obj).longValue());
            case 5:
                return i5.D(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                i5.H();
                return 8;
            case 7:
                ((Integer) obj).intValue();
                i5.P();
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                i5.s();
                return 1;
            case 9:
                return i5.w((i7) obj);
            case 10:
                return obj instanceof j6 ? i5.b((j6) obj) : i5.l((i7) obj);
            case 11:
                return obj instanceof w4 ? i5.k((w4) obj) : i5.m((String) obj);
            case 12:
                return obj instanceof w4 ? i5.k((w4) obj) : i5.n((byte[]) obj);
            case 13:
                return i5.I(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                i5.S();
                return 4;
            case 15:
                ((Long) obj).longValue();
                i5.L();
                return 8;
            case 16:
                return i5.M(((Integer) obj).intValue());
            case 17:
                return i5.G(((Long) obj).longValue());
            case 18:
                if (obj instanceof c6) {
                    return i5.D(((c6) obj).a());
                }
                return i5.D(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int j(Map.Entry<T, Object> entry) {
        int J;
        int I;
        int c2;
        int I2;
        t5 t5Var = (t5) entry.getKey();
        Object value = entry.getValue();
        if (t5Var.c() != a9.MESSAGE || t5Var.d() || t5Var.e()) {
            return a(t5Var, value);
        }
        boolean z = value instanceof j6;
        int a2 = ((t5) entry.getKey()).a();
        if (z) {
            J = i5.J(2, a2) + (i5.I(8) << 1);
            I = i5.I(24);
            c2 = ((j6) value).a();
            I2 = i5.I(c2);
        } else {
            J = i5.J(2, a2) + (i5.I(8) << 1);
            I = i5.I(24);
            c2 = ((i7) value).c();
            I2 = i5.I(c2);
        }
        return I2 + c2 + I + J;
    }

    public final /* synthetic */ Object clone() {
        r5 r5Var = new r5();
        for (int i = 0; i < this.f1917a.g(); i++) {
            Map.Entry<T, Object> f = this.f1917a.f(i);
            r5Var.h((t5) f.getKey(), f.getValue());
        }
        for (Map.Entry next : this.f1917a.i()) {
            r5Var.h((t5) next.getKey(), next.getValue());
        }
        r5Var.f1919c = this.f1919c;
        return r5Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r5)) {
            return false;
        }
        return this.f1917a.equals(((r5) obj).f1917a);
    }

    public final void g() {
        if (!this.f1918b) {
            this.f1917a.d();
            this.f1918b = true;
        }
    }

    public final void h(T t, Object obj) {
        if (!t.d()) {
            d(t.b(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                d(t.b(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof j6) {
            this.f1919c = true;
        }
        this.f1917a.put(t, obj);
    }

    public final int hashCode() {
        return this.f1917a.hashCode();
    }

    public final void i(Map.Entry<T, Object> entry) {
        t5 t5Var = (t5) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof j6) {
            j6 j6Var = (j6) value;
            j6.d();
            throw null;
        } else if (t5Var.d()) {
            Object obj = this.f1917a.get(t5Var);
            if (!(obj instanceof j6)) {
                if (obj == null) {
                    obj = new ArrayList();
                }
                for (Object c2 : (List) value) {
                    ((List) obj).add(c(c2));
                }
                this.f1917a.put(t5Var, obj);
                return;
            }
            j6 j6Var2 = (j6) obj;
            j6.d();
            throw null;
        } else if (t5Var.c() == a9.MESSAGE) {
            Object obj2 = this.f1917a.get(t5Var);
            if (obj2 instanceof j6) {
                j6 j6Var3 = (j6) obj2;
                j6.d();
                throw null;
            } else if (obj2 == null) {
                this.f1917a.put(t5Var, c(value));
            } else {
                this.f1917a.put(t5Var, obj2 instanceof l7 ? t5Var.h((l7) obj2, (l7) value) : ((y5.b) t5Var.l(((i7) obj2).d(), (i7) value)).m());
            }
        } else {
            this.f1917a.put(t5Var, c(value));
        }
    }

    public final Iterator<Map.Entry<T, Object>> k() {
        return this.f1919c ? new o6(this.f1917a.entrySet().iterator()) : this.f1917a.entrySet().iterator();
    }

    public final boolean l() {
        for (int i = 0; i < this.f1917a.g(); i++) {
            if (!e(this.f1917a.f(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> e2 : this.f1917a.i()) {
            if (!e(e2)) {
                return false;
            }
        }
        return true;
    }
}

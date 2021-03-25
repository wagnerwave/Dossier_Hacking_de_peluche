package a.d.a.a.h.g;

import a.c.a.d.a;
import a.c.a.f.b;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class c3<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Object j = new Object();
    @NullableDecl

    /* renamed from: a  reason: collision with root package name */
    public transient Object f1635a;
    @NullableDecl

    /* renamed from: b  reason: collision with root package name */
    public transient int[] f1636b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    public transient Object[] f1637c;
    @NullableDecl

    /* renamed from: d  reason: collision with root package name */
    public transient Object[] f1638d;

    /* renamed from: e  reason: collision with root package name */
    public transient int f1639e = b.K0(3, 1);
    public transient int f;
    @NullableDecl
    public transient Set<K> g;
    @NullableDecl
    public transient Set<Map.Entry<K, V>> h;
    @NullableDecl
    public transient Collection<V> i;

    public final int a(int i2, int i3, int i4, int i5) {
        Object d2 = j3.d(i3);
        int i6 = i3 - 1;
        if (i5 != 0) {
            j3.e(d2, i4 & i6, i5 + 1);
        }
        Object obj = this.f1635a;
        int[] iArr = this.f1636b;
        for (int i7 = 0; i7 <= i2; i7++) {
            int b2 = j3.b(obj, i7);
            while (b2 != 0) {
                int i8 = b2 - 1;
                int i9 = iArr[i8];
                int i10 = ((i2 ^ -1) & i9) | i7;
                int i11 = i10 & i6;
                int b3 = j3.b(d2, i11);
                j3.e(d2, i11, b2);
                iArr[i8] = j3.a(i10, b3, i6);
                b2 = i9 & i2;
            }
        }
        this.f1635a = d2;
        this.f1639e = j3.a(this.f1639e, 32 - Integer.numberOfLeadingZeros(i6), 31);
        return i6;
    }

    public final int b(@NullableDecl Object obj) {
        if (d()) {
            return -1;
        }
        int t = a.t(obj);
        int i2 = i();
        int b2 = j3.b(this.f1635a, t & i2);
        if (b2 == 0) {
            return -1;
        }
        int i3 = i2 ^ -1;
        int i4 = t & i3;
        do {
            int i5 = b2 - 1;
            int i6 = this.f1636b[i5];
            if ((i6 & i3) == i4 && a.z(obj, this.f1637c[i5])) {
                return i5;
            }
            b2 = i6 & i2;
        } while (b2 != 0);
        return -1;
    }

    public final void c(int i2, int i3) {
        int size = size() - 1;
        if (i2 < size) {
            Object[] objArr = this.f1637c;
            Object obj = objArr[size];
            objArr[i2] = obj;
            Object[] objArr2 = this.f1638d;
            objArr2[i2] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            int[] iArr = this.f1636b;
            iArr[i2] = iArr[size];
            iArr[size] = 0;
            int t = a.t(obj) & i3;
            int b2 = j3.b(this.f1635a, t);
            int i4 = size + 1;
            if (b2 == i4) {
                j3.e(this.f1635a, t, i2 + 1);
                return;
            }
            while (true) {
                int i5 = b2 - 1;
                int[] iArr2 = this.f1636b;
                int i6 = iArr2[i5];
                int i7 = i6 & i3;
                if (i7 == i4) {
                    iArr2[i5] = j3.a(i6, i2 + 1, i3);
                    return;
                }
                b2 = i7;
            }
        } else {
            this.f1637c[i2] = null;
            this.f1638d[i2] = null;
            this.f1636b[i2] = 0;
        }
    }

    public final void clear() {
        if (!d()) {
            h();
            Map g2 = g();
            if (g2 != null) {
                this.f1639e = b.K0(size(), 3);
                g2.clear();
                this.f1635a = null;
            } else {
                Arrays.fill(this.f1637c, 0, this.f, (Object) null);
                Arrays.fill(this.f1638d, 0, this.f, (Object) null);
                Object obj = this.f1635a;
                if (obj instanceof byte[]) {
                    Arrays.fill((byte[]) obj, (byte) 0);
                } else if (obj instanceof short[]) {
                    Arrays.fill((short[]) obj, 0);
                } else {
                    Arrays.fill((int[]) obj, 0);
                }
                Arrays.fill(this.f1636b, 0, this.f, 0);
            }
            this.f = 0;
        }
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        Map g2 = g();
        return g2 != null ? g2.containsKey(obj) : b(obj) != -1;
    }

    public final boolean containsValue(@NullableDecl Object obj) {
        Map g2 = g();
        if (g2 != null) {
            return g2.containsValue(obj);
        }
        for (int i2 = 0; i2 < this.f; i2++) {
            if (a.z(obj, this.f1638d[i2])) {
                return true;
            }
        }
        return false;
    }

    public final boolean d() {
        return this.f1635a == null;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.h;
        if (set != null) {
            return set;
        }
        g3 g3Var = new g3(this);
        this.h = g3Var;
        return g3Var;
    }

    @NullableDecl
    public final Object f(@NullableDecl Object obj) {
        if (d()) {
            return j;
        }
        int i2 = i();
        int c2 = j3.c(obj, (Object) null, i2, this.f1635a, this.f1636b, this.f1637c, (Object[]) null);
        if (c2 == -1) {
            return j;
        }
        Object obj2 = this.f1638d[c2];
        c(c2, i2);
        this.f--;
        h();
        return obj2;
    }

    @NullableDecl
    public final Map<K, V> g() {
        Object obj = this.f1635a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final V get(@NullableDecl Object obj) {
        Map g2 = g();
        if (g2 != null) {
            return g2.get(obj);
        }
        int b2 = b(obj);
        if (b2 == -1) {
            return null;
        }
        return this.f1638d[b2];
    }

    public final void h() {
        this.f1639e += 32;
    }

    public final int i() {
        return (1 << (this.f1639e & 31)) - 1;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set<K> keySet() {
        Set<K> set = this.g;
        if (set != null) {
            return set;
        }
        i3 i3Var = new i3(this);
        this.g = i3Var;
        return i3Var;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f4 A[SYNTHETIC] */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final V put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K r21, @org.checkerframework.checker.nullness.compatqual.NullableDecl V r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            boolean r3 = r20.d()
            r4 = 4
            r5 = 2
            r6 = 32
            r7 = 1
            if (r3 == 0) goto L_0x0063
            boolean r3 = r20.d()
            java.lang.String r8 = "Arrays already allocated"
            a.c.a.d.a.B(r3, r8)
            int r3 = r0.f1639e
            int r8 = r3 + 1
            int r8 = java.lang.Math.max(r8, r5)
            int r9 = java.lang.Integer.highestOneBit(r8)
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = (double) r9
            java.lang.Double.isNaN(r12)
            java.lang.Double.isNaN(r12)
            double r12 = r12 * r10
            int r10 = (int) r12
            if (r8 <= r10) goto L_0x003b
            int r9 = r9 << 1
            if (r9 > 0) goto L_0x003b
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x003c
        L_0x003b:
            r8 = r9
        L_0x003c:
            int r8 = java.lang.Math.max(r4, r8)
            java.lang.Object r9 = a.d.a.a.h.g.j3.d(r8)
            r0.f1635a = r9
            int r8 = r8 - r7
            int r8 = java.lang.Integer.numberOfLeadingZeros(r8)
            int r8 = 32 - r8
            int r9 = r0.f1639e
            r10 = 31
            int r8 = a.d.a.a.h.g.j3.a(r9, r8, r10)
            r0.f1639e = r8
            int[] r8 = new int[r3]
            r0.f1636b = r8
            java.lang.Object[] r8 = new java.lang.Object[r3]
            r0.f1637c = r8
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r0.f1638d = r3
        L_0x0063:
            java.util.Map r3 = r20.g()
            if (r3 == 0) goto L_0x006e
            java.lang.Object r1 = r3.put(r1, r2)
            return r1
        L_0x006e:
            int[] r3 = r0.f1636b
            java.lang.Object[] r8 = r0.f1637c
            java.lang.Object[] r9 = r0.f1638d
            int r10 = r0.f
            int r11 = r10 + 1
            int r12 = a.c.a.d.a.t(r21)
            int r13 = r20.i()
            r14 = r12 & r13
            java.lang.Object r15 = r0.f1635a
            int r15 = a.d.a.a.h.g.j3.b(r15, r14)
            if (r15 != 0) goto L_0x00a0
            if (r11 <= r13) goto L_0x0099
            if (r13 >= r6) goto L_0x0091
            r16 = 4
            goto L_0x0093
        L_0x0091:
            r16 = 2
        L_0x0093:
            int r3 = r13 + 1
            int r3 = r3 * r16
            goto L_0x0112
        L_0x0099:
            java.lang.Object r3 = r0.f1635a
            a.d.a.a.h.g.j3.e(r3, r14, r11)
            goto L_0x011d
        L_0x00a0:
            r14 = r13 ^ -1
            r5 = r12 & r14
            r18 = 0
        L_0x00a6:
            int r15 = r15 - r7
            r6 = r3[r15]
            r4 = r6 & r14
            if (r4 != r5) goto L_0x00ba
            r4 = r8[r15]
            boolean r4 = a.c.a.d.a.z(r1, r4)
            if (r4 == 0) goto L_0x00ba
            r1 = r9[r15]
            r9[r15] = r2
            return r1
        L_0x00ba:
            r4 = r6 & r13
            r19 = r5
            int r5 = r18 + 1
            if (r4 != 0) goto L_0x0163
            r4 = 9
            if (r5 < r4) goto L_0x0105
            int r3 = r20.i()
            int r3 = r3 + r7
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r5 = 1065353216(0x3f800000, float:1.0)
            r4.<init>(r3, r5)
            boolean r3 = r20.isEmpty()
            if (r3 == 0) goto L_0x00db
            r3 = r0
            r6 = r3
            goto L_0x00f2
        L_0x00db:
            r3 = r0
            r6 = r3
            r5 = 0
        L_0x00de:
            if (r5 < 0) goto L_0x00f4
            java.lang.Object[] r7 = r3.f1637c
            r7 = r7[r5]
            java.lang.Object[] r8 = r3.f1638d
            r8 = r8[r5]
            r4.put(r7, r8)
            int r5 = r5 + 1
            int r7 = r3.f
            if (r5 >= r7) goto L_0x00f2
            goto L_0x00de
        L_0x00f2:
            r5 = -1
            goto L_0x00de
        L_0x00f4:
            r3.f1635a = r4
            r5 = 0
            r3.f1636b = r5
            r3.f1637c = r5
            r3.f1638d = r5
            r6.h()
            java.lang.Object r1 = r4.put(r1, r2)
            return r1
        L_0x0105:
            if (r11 <= r13) goto L_0x0117
            r4 = 32
            if (r13 >= r4) goto L_0x010d
            r4 = 4
            goto L_0x010e
        L_0x010d:
            r4 = 2
        L_0x010e:
            int r3 = r13 + 1
            int r3 = r3 * r4
        L_0x0112:
            int r13 = r0.a(r13, r3, r12, r10)
            goto L_0x011d
        L_0x0117:
            int r4 = a.d.a.a.h.g.j3.a(r6, r11, r13)
            r3[r15] = r4
        L_0x011d:
            int[] r3 = r0.f1636b
            int r3 = r3.length
            if (r11 <= r3) goto L_0x014b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            int r5 = r3 >>> 1
            int r5 = java.lang.Math.max(r7, r5)
            int r5 = r5 + r3
            r5 = r5 | r7
            int r4 = java.lang.Math.min(r4, r5)
            if (r4 == r3) goto L_0x014b
            int[] r3 = r0.f1636b
            int[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f1636b = r3
            java.lang.Object[] r3 = r0.f1637c
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f1637c = r3
            java.lang.Object[] r3 = r0.f1638d
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            r0.f1638d = r3
        L_0x014b:
            int[] r3 = r0.f1636b
            r6 = 0
            int r4 = a.d.a.a.h.g.j3.a(r12, r6, r13)
            r3[r10] = r4
            java.lang.Object[] r3 = r0.f1637c
            r3[r10] = r1
            java.lang.Object[] r1 = r0.f1638d
            r1[r10] = r2
            r0.f = r11
            r20.h()
            r15 = 0
            return r15
        L_0x0163:
            r6 = 0
            r15 = r4
            r18 = r5
            r5 = r19
            r6 = 32
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.c3.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map g2 = g();
        if (g2 != null) {
            return g2.remove(obj);
        }
        V f2 = f(obj);
        if (f2 == j) {
            return null;
        }
        return f2;
    }

    public final int size() {
        Map g2 = g();
        return g2 != null ? g2.size() : this.f;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.i;
        if (collection != null) {
            return collection;
        }
        k3 k3Var = new k3(this);
        this.i = k3Var;
        return k3Var;
    }
}

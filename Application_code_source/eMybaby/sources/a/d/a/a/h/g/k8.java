package a.d.a.a.h.g;

import a.d.a.a.h.g.i5;
import java.util.Arrays;

public final class k8 {
    public static final k8 f = new k8(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f1781a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f1782b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1783c;

    /* renamed from: d  reason: collision with root package name */
    public int f1784d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1785e;

    public k8() {
        this(0, new int[8], new Object[8], true);
    }

    public k8(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f1784d = -1;
        this.f1781a = i;
        this.f1782b = iArr;
        this.f1783c = objArr;
        this.f1785e = z;
    }

    public static void b(int i, Object obj, d9 d9Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((k5) d9Var).d(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ((k5) d9Var).m(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ((k5) d9Var).e(i2, (w4) obj);
        } else if (i3 == 3) {
            k5 k5Var = (k5) d9Var;
            int i4 = i2 << 3;
            ((i5.b) k5Var.f1770a).o(i4 | 3);
            ((k8) obj).d(d9Var);
            ((i5.b) k5Var.f1770a).o(i4 | 4);
        } else if (i3 == 5) {
            ((k5) d9Var).l(i2, ((Integer) obj).intValue());
        } else {
            throw new RuntimeException(i6.d());
        }
    }

    public static k8 c() {
        return new k8(0, new int[8], new Object[8], true);
    }

    public final void a(int i, Object obj) {
        if (this.f1785e) {
            int i2 = this.f1781a;
            if (i2 == this.f1782b.length) {
                int i3 = this.f1781a + (i2 < 4 ? 8 : i2 >> 1);
                this.f1782b = Arrays.copyOf(this.f1782b, i3);
                this.f1783c = Arrays.copyOf(this.f1783c, i3);
            }
            int[] iArr = this.f1782b;
            int i4 = this.f1781a;
            iArr[i4] = i;
            this.f1783c[i4] = obj;
            this.f1781a = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void d(d9 d9Var) {
        if (this.f1781a != 0) {
            if (((k5) d9Var) != null) {
                for (int i = 0; i < this.f1781a; i++) {
                    b(this.f1782b[i], this.f1783c[i], d9Var);
                }
                return;
            }
            throw null;
        }
    }

    public final int e() {
        int i;
        int i2 = this.f1784d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1781a; i4++) {
            int i5 = this.f1782b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = i5.B(i6, ((Long) this.f1783c[i4]).longValue());
            } else if (i7 == 1) {
                ((Long) this.f1783c[i4]).longValue();
                i = i5.K(i6);
            } else if (i7 == 2) {
                i = i5.u(i6, (w4) this.f1783c[i4]);
            } else if (i7 == 3) {
                i3 = ((k8) this.f1783c[i4]).e() + (i5.A(i6) << 1) + i3;
            } else if (i7 == 5) {
                ((Integer) this.f1783c[i4]).intValue();
                i = i5.R(i6);
            } else {
                throw new IllegalStateException(i6.d());
            }
            i3 = i + i3;
        }
        this.f1784d = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof k8)) {
            return false;
        }
        k8 k8Var = (k8) obj;
        int i = this.f1781a;
        if (i == k8Var.f1781a) {
            int[] iArr = this.f1782b;
            int[] iArr2 = k8Var.f1782b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.f1783c;
                Object[] objArr2 = k8Var.f1783c;
                int i3 = this.f1781a;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.f1781a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f1782b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f1783c;
        int i7 = this.f1781a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}

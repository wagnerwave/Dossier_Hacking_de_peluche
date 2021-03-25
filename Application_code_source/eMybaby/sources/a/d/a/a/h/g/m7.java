package a.d.a.a.h.g;

import a.c.a.f.b;
import a.d.a.a.h.g.l5;
import a.d.a.a.h.g.y5;
import java.util.Iterator;
import java.util.Map;

public final class m7<T> implements v7<T> {

    /* renamed from: a  reason: collision with root package name */
    public final i7 f1830a;

    /* renamed from: b  reason: collision with root package name */
    public final h8<?, ?> f1831b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1832c;

    /* renamed from: d  reason: collision with root package name */
    public final n5<?> f1833d;

    public m7(h8<?, ?> h8Var, n5<?> n5Var, i7 i7Var) {
        this.f1831b = h8Var;
        if (((p5) n5Var) != null) {
            this.f1832c = i7Var instanceof y5.d;
            this.f1833d = n5Var;
            this.f1830a = i7Var;
            return;
        }
        throw null;
    }

    public final T a() {
        return ((y5.b) this.f1830a.f()).l();
    }

    public final int b(T t) {
        if (((j8) this.f1831b) != null) {
            int hashCode = ((y5) t).zzb.hashCode();
            if (!this.f1832c) {
                return hashCode;
            }
            if (((p5) this.f1833d) != null) {
                return (hashCode * 53) + ((y5.d) t).zzc.hashCode();
            }
            throw null;
        }
        throw null;
    }

    public final boolean c(T t) {
        if (((p5) this.f1833d) != null) {
            return ((y5.d) t).zzc.l();
        }
        throw null;
    }

    public final boolean d(T t, T t2) {
        j8 j8Var = (j8) this.f1831b;
        if (j8Var != null) {
            k8 k8Var = ((y5) t).zzb;
            if (j8Var == null) {
                throw null;
            } else if (!k8Var.equals(((y5) t2).zzb)) {
                return false;
            } else {
                if (!this.f1832c) {
                    return true;
                }
                p5 p5Var = (p5) this.f1833d;
                if (p5Var != null) {
                    r5<y5.c> r5Var = ((y5.d) t).zzc;
                    if (p5Var != null) {
                        return r5Var.equals(((y5.d) t2).zzc);
                    }
                    throw null;
                }
                throw null;
            }
        } else {
            throw null;
        }
    }

    public final void e(T t) {
        if (((j8) this.f1831b) != null) {
            ((y5) t).zzb.f1785e = false;
            if (((p5) this.f1833d) != null) {
                ((y5.d) t).zzc.g();
                return;
            }
            throw null;
        }
        throw null;
    }

    public final int f(T t) {
        if (((j8) this.f1831b) != null) {
            k8 k8Var = ((y5) t).zzb;
            int i = k8Var.f1784d;
            if (i == -1) {
                i = 0;
                for (int i2 = 0; i2 < k8Var.f1781a; i2++) {
                    int J = i5.J(2, k8Var.f1782b[i2] >>> 3);
                    i += i5.u(3, (w4) k8Var.f1783c[i2]) + J + (i5.I(8) << 1);
                }
                k8Var.f1784d = i;
            }
            int i3 = i + 0;
            if (!this.f1832c) {
                return i3;
            }
            if (((p5) this.f1833d) != null) {
                r5<y5.c> r5Var = ((y5.d) t).zzc;
                int i4 = 0;
                for (int i5 = 0; i5 < r5Var.f1917a.g(); i5++) {
                    i4 += r5.j(r5Var.f1917a.f(i5));
                }
                for (Map.Entry<T, Object> j : r5Var.f1917a.i()) {
                    i4 += r5.j(j);
                }
                return i3 + i4;
            }
            throw null;
        }
        throw null;
    }

    public final void g(T t, byte[] bArr, int i, int i2, v4 v4Var) {
        y5 y5Var = (y5) t;
        k8 k8Var = y5Var.zzb;
        if (k8Var == k8.f) {
            k8Var = k8.c();
            y5Var.zzb = k8Var;
        }
        ((y5.d) t).s();
        y5.f fVar = null;
        while (i < i2) {
            int U0 = b.U0(bArr, i, v4Var);
            int i3 = v4Var.f1981a;
            if (i3 == 11) {
                int i4 = 0;
                w4 w4Var = null;
                while (U0 < i2) {
                    U0 = b.U0(bArr, U0, v4Var);
                    int i5 = v4Var.f1981a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (fVar != null) {
                                r7 r7Var = r7.f1920c;
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                U0 = b.A1(bArr, U0, v4Var);
                                w4Var = (w4) v4Var.f1983c;
                            }
                        }
                    } else if (i7 == 0) {
                        U0 = b.U0(bArr, U0, v4Var);
                        i4 = v4Var.f1981a;
                        n5<?> n5Var = this.f1833d;
                        l5 l5Var = v4Var.f1984d;
                        i7 i7Var = this.f1830a;
                        if (((p5) n5Var) != null) {
                            fVar = l5Var.f1804a.get(new l5.a(i7Var, i4));
                        } else {
                            throw null;
                        }
                    }
                    if (i5 == 12) {
                        break;
                    }
                    U0 = b.L0(i5, bArr, U0, i2, v4Var);
                }
                if (w4Var != null) {
                    k8Var.a((i4 << 3) | 2, w4Var);
                }
                i = U0;
            } else if ((i3 & 7) == 2) {
                n5<?> n5Var2 = this.f1833d;
                l5 l5Var2 = v4Var.f1984d;
                i7 i7Var2 = this.f1830a;
                int i8 = i3 >>> 3;
                if (((p5) n5Var2) != null) {
                    fVar = l5Var2.f1804a.get(new l5.a(i7Var2, i8));
                    if (fVar == null) {
                        i = b.N0(i3, bArr, U0, i2, k8Var, v4Var);
                    } else {
                        r7 r7Var2 = r7.f1920c;
                        throw new NoSuchMethodError();
                    }
                } else {
                    throw null;
                }
            } else {
                i = b.L0(i3, bArr, U0, i2, v4Var);
            }
        }
        if (i != i2) {
            throw i6.e();
        }
    }

    public final void h(T t, d9 d9Var) {
        if (((p5) this.f1833d) != null) {
            Iterator<Map.Entry<y5.c, Object>> k = ((y5.d) t).zzc.k();
            while (k.hasNext()) {
                Map.Entry next = k.next();
                t5 t5Var = (t5) next.getKey();
                if (t5Var.c() != a9.MESSAGE || t5Var.d() || t5Var.e()) {
                    throw new IllegalStateException("Found invalid MessageSet item.");
                }
                ((k5) d9Var).f(t5Var.a(), next instanceof l6 ? ((l6) next).f1807a.getValue().c() : next.getValue());
            }
            if (((j8) this.f1831b) != null) {
                k8 k8Var = ((y5) t).zzb;
                if (k8Var != null) {
                    k5 k5Var = (k5) d9Var;
                    if (k5Var != null) {
                        for (int i = 0; i < k8Var.f1781a; i++) {
                            k5Var.f(k8Var.f1782b[i] >>> 3, k8Var.f1783c[i]);
                        }
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public final void i(T t, T t2) {
        w7.m(this.f1831b, t, t2);
        if (this.f1832c) {
            w7.k(this.f1833d, t, t2);
        }
    }
}

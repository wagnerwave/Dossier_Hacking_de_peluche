package a.d.a.a.h.g;

import a.d.a.a.h.g.i5;
import a.d.a.a.h.g.y5;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

public final class w7 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f2008a;

    /* renamed from: b  reason: collision with root package name */
    public static final h8<?, ?> f2009b = e(false);

    /* renamed from: c  reason: collision with root package name */
    public static final h8<?, ?> f2010c = e(true);

    /* renamed from: d  reason: collision with root package name */
    public static final h8<?, ?> f2011d = new j8();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f2008a = cls;
    }

    public static int A(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (i5.A(i) * size) + B(list);
    }

    public static int B(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b6) {
            b6 b6Var = (b6) list;
            i = 0;
            while (i2 < size) {
                i += i5.D(b6Var.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + i5.D(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void C(int i, List<Long> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += i5.C(list.get(i3).longValue());
                    }
                    k5Var.f1770a.o(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        k5Var.f1770a.g(list.get(i4).longValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i5 i5Var = k5Var.f1770a;
                    long longValue = list.get(i5).longValue();
                    i5.b bVar = (i5.b) i5Var;
                    bVar.o((i << 3) | 0);
                    bVar.g(longValue);
                }
                return;
            }
            throw null;
        }
    }

    public static int D(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (i5.A(i) * size) + E(list);
    }

    public static int E(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b6) {
            b6 b6Var = (b6) list;
            i = 0;
            while (i2 < size) {
                i += i5.D(b6Var.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + i5.D(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void F(int i, List<Long> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += i5.G(list.get(i3).longValue());
                    }
                    k5Var.f1770a.o(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        k5Var.f1770a.g(i5.Q(list.get(i4).longValue()));
                    }
                    return;
                }
                int i5 = 0;
                while (i5 < list.size()) {
                    i5 i5Var = k5Var.f1770a;
                    long longValue = list.get(i5).longValue();
                    if (i5Var != null) {
                        long Q = i5.Q(longValue);
                        i5.b bVar = (i5.b) i5Var;
                        bVar.o((i << 3) | 0);
                        bVar.g(Q);
                        i5++;
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static int G(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (i5.A(i) * size) + H(list);
    }

    public static int H(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b6) {
            b6 b6Var = (b6) list;
            i = 0;
            while (i2 < size) {
                i += i5.I(b6Var.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + i5.I(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void I(int i, List<Long> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    k5Var.f1770a.o(i3);
                    while (i2 < list.size()) {
                        k5Var.f1770a.x(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i5 i5Var = k5Var.f1770a;
                    long longValue = list.get(i2).longValue();
                    i5.b bVar = (i5.b) i5Var;
                    bVar.o((i << 3) | 1);
                    bVar.x(longValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static int J(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (i5.A(i) * size) + K(list);
    }

    public static int K(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b6) {
            b6 b6Var = (b6) list;
            i = 0;
            while (i2 < size) {
                i += i5.M(b6Var.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + i5.M(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void L(int i, List<Long> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    k5Var.f1770a.o(i3);
                    while (i2 < list.size()) {
                        k5Var.f1770a.x(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i5 i5Var = k5Var.f1770a;
                    long longValue = list.get(i2).longValue();
                    i5.b bVar = (i5.b) i5Var;
                    bVar.o((i << 3) | 1);
                    bVar.x(longValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static int M(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i5.R(i) * size;
    }

    public static int N(List<?> list) {
        return list.size() << 2;
    }

    public static void O(int i, List<Integer> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += i5.D(list.get(i4).intValue());
                    }
                    k5Var.f1770a.o(i3);
                    while (i2 < list.size()) {
                        k5Var.f1770a.f(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    k5Var.f1770a.p(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static int P(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i5.K(i) * size;
    }

    public static int Q(List<?> list) {
        return list.size() << 3;
    }

    public static void R(int i, List<Integer> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += i5.I(list.get(i3).intValue());
                    }
                    k5Var.f1770a.o(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        k5Var.f1770a.o(list.get(i4).intValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i5 i5Var = k5Var.f1770a;
                    int intValue = list.get(i5).intValue();
                    i5.b bVar = (i5.b) i5Var;
                    bVar.o((i << 3) | 0);
                    bVar.o(intValue);
                }
                return;
            }
            throw null;
        }
    }

    public static int S(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i5.t(i) * size;
    }

    public static int T(List<?> list) {
        return list.size();
    }

    public static void U(int i, List<Integer> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += i5.M(list.get(i3).intValue());
                    }
                    k5Var.f1770a.o(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        k5Var.f1770a.o(i5.V(list.get(i4).intValue()));
                    }
                    return;
                }
                int i5 = 0;
                while (i5 < list.size()) {
                    i5 i5Var = k5Var.f1770a;
                    int intValue = list.get(i5).intValue();
                    if (i5Var != null) {
                        int V = i5.V(intValue);
                        i5.b bVar = (i5.b) i5Var;
                        bVar.o((i << 3) | 0);
                        bVar.o(V);
                        i5++;
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static void V(int i, List<Integer> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    k5Var.f1770a.o(i3);
                    while (i2 < list.size()) {
                        k5Var.f1770a.z(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i5 i5Var = k5Var.f1770a;
                    int intValue = list.get(i2).intValue();
                    i5.b bVar = (i5.b) i5Var;
                    bVar.o((i << 3) | 5);
                    bVar.z(intValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void W(int i, List<Integer> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    k5Var.f1770a.o(i3);
                    while (i2 < list.size()) {
                        k5Var.f1770a.z(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i5 i5Var = k5Var.f1770a;
                    int intValue = list.get(i2).intValue();
                    i5.b bVar = (i5.b) i5Var;
                    bVar.o((i << 3) | 5);
                    bVar.z(intValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void X(int i, List<Integer> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += i5.D(list.get(i4).intValue());
                    }
                    k5Var.f1770a.o(i3);
                    while (i2 < list.size()) {
                        k5Var.f1770a.f(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    k5Var.f1770a.p(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void Y(int i, List<Boolean> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        list.get(i3).booleanValue();
                        i2++;
                    }
                    k5Var.f1770a.o(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        k5Var.f1770a.e(list.get(i4).booleanValue() ? (byte) 1 : 0);
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i5 i5Var = k5Var.f1770a;
                    boolean booleanValue = list.get(i5).booleanValue();
                    i5.b bVar = (i5.b) i5Var;
                    bVar.o((i << 3) | 0);
                    bVar.e(booleanValue ? (byte) 1 : 0);
                }
                return;
            }
            throw null;
        }
    }

    public static int a(int i, Object obj, v7 v7Var) {
        if (obj instanceof n6) {
            int I = i5.I(i << 3);
            int a2 = ((n6) obj).a();
            return i5.I(a2) + a2 + I;
        }
        return i5.c((i7) obj, v7Var) + i5.I(i << 3);
    }

    public static int b(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int A = i5.A(i) * size;
        if (list instanceof p6) {
            p6 p6Var = (p6) list;
            while (i2 < size) {
                Object j = p6Var.j(i2);
                A = (j instanceof w4 ? i5.k((w4) j) : i5.m((String) j)) + A;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                A = (obj instanceof w4 ? i5.k((w4) obj) : i5.m((String) obj)) + A;
                i2++;
            }
        }
        return A;
    }

    public static int c(int i, List<?> list, v7 v7Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int A = i5.A(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            A += obj instanceof n6 ? i5.b((n6) obj) : i5.c((i7) obj, v7Var);
        }
        return A;
    }

    public static int d(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w6) {
            w6 w6Var = (w6) list;
            i = 0;
            while (i2 < size) {
                i += i5.C(w6Var.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + i5.C(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static h8<?, ?> e(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (h8) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static <UT, UB> UB f(int i, int i2, UB ub, h8<UT, UB> h8Var) {
        if (ub == null) {
            if (((j8) h8Var) != null) {
                ub = k8.c();
            } else {
                throw null;
            }
        }
        long j = (long) i2;
        if (((j8) h8Var) != null) {
            ((k8) ub).a(i << 3, Long.valueOf(j));
            return ub;
        }
        throw null;
    }

    public static <UT, UB> UB g(int i, List<Integer> list, e6 e6Var, UB ub, h8<UT, UB> h8Var) {
        if (e6Var == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (e6Var.f(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = f(i, intValue, ub, h8Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!e6Var.f(intValue2)) {
                    ub = f(i, intValue2, ub, h8Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static void h(int i, List<String> list, d9 d9Var) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (list instanceof p6) {
                    p6 p6Var = (p6) list;
                    while (i2 < list.size()) {
                        Object j = p6Var.j(i2);
                        if (j instanceof String) {
                            i5.b bVar = (i5.b) k5Var.f1770a;
                            bVar.o((i << 3) | 2);
                            bVar.a0((String) j);
                        } else {
                            i5.b bVar2 = (i5.b) k5Var.f1770a;
                            bVar2.o((i << 3) | 2);
                            bVar2.Y((w4) j);
                        }
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i5.b bVar3 = (i5.b) k5Var.f1770a;
                    bVar3.o((i << 3) | 2);
                    bVar3.a0(list.get(i2));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void i(int i, List<?> list, d9 d9Var, v7 v7Var) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    k5Var.g(i, list.get(i2), v7Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void j(int i, List<Double> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).doubleValue();
                        i3 += 8;
                    }
                    k5Var.f1770a.o(i3);
                    while (i2 < list.size()) {
                        i5 i5Var = k5Var.f1770a;
                        double doubleValue = list.get(i2).doubleValue();
                        if (i5Var != null) {
                            i5Var.x(Double.doubleToRawLongBits(doubleValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i5 i5Var2 = k5Var.f1770a;
                    double doubleValue2 = list.get(i2).doubleValue();
                    if (i5Var2 != null) {
                        long doubleToRawLongBits = Double.doubleToRawLongBits(doubleValue2);
                        i5.b bVar = (i5.b) i5Var2;
                        bVar.o((i << 3) | 1);
                        bVar.x(doubleToRawLongBits);
                        i2++;
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static <T, FT extends t5<FT>> void k(n5<FT> n5Var, T t, T t2) {
        if (((p5) n5Var) != null) {
            r5<y5.c> r5Var = ((y5.d) t2).zzc;
            if (!r5Var.f1917a.isEmpty()) {
                r5<y5.c> s = ((y5.d) t).s();
                if (s != null) {
                    for (int i = 0; i < r5Var.f1917a.g(); i++) {
                        s.i(r5Var.f1917a.f(i));
                    }
                    for (Map.Entry<T, Object> i2 : r5Var.f1917a.i()) {
                        s.i(i2);
                    }
                    return;
                }
                throw null;
            }
            return;
        }
        throw null;
    }

    public static <T> void l(b7 b7Var, T t, T t2, long j) {
        n8.f(t, j, b7Var.d(n8.r(t, j), n8.r(t2, j)));
    }

    public static <T, UT, UB> void m(h8<UT, UB> h8Var, T t, T t2) {
        if (((j8) h8Var) != null) {
            y5 y5Var = (y5) t;
            k8 k8Var = y5Var.zzb;
            k8 k8Var2 = ((y5) t2).zzb;
            if (!k8Var2.equals(k8.f)) {
                int i = k8Var.f1781a + k8Var2.f1781a;
                int[] copyOf = Arrays.copyOf(k8Var.f1782b, i);
                System.arraycopy(k8Var2.f1782b, 0, copyOf, k8Var.f1781a, k8Var2.f1781a);
                Object[] copyOf2 = Arrays.copyOf(k8Var.f1783c, i);
                System.arraycopy(k8Var2.f1783c, 0, copyOf2, k8Var.f1781a, k8Var2.f1781a);
                k8Var = new k8(i, copyOf, copyOf2, true);
            }
            y5Var.zzb = k8Var;
            return;
        }
        throw null;
    }

    public static void n(Class<?> cls) {
        Class<?> cls2;
        if (!y5.class.isAssignableFrom(cls) && (cls2 = f2008a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean o(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int p(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (i5.A(i) * list.size()) + d(list);
    }

    public static int q(int i, List<w4> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int A = i5.A(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            A += i5.k(list.get(i2));
        }
        return A;
    }

    public static int r(int i, List<i7> list, v7 v7Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += i5.v(i, list.get(i3), v7Var);
        }
        return i2;
    }

    public static int s(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w6) {
            w6 w6Var = (w6) list;
            i = 0;
            while (i2 < size) {
                i += i5.C(w6Var.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + i5.C(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void t(int i, List<w4> list, d9 d9Var) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    i5.b bVar = (i5.b) k5Var.f1770a;
                    bVar.o((i << 3) | 2);
                    bVar.Y(list.get(i2));
                }
                return;
            }
            throw null;
        }
    }

    public static void u(int i, List<?> list, d9 d9Var, v7 v7Var) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    k5Var.j(i, list.get(i2), v7Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void v(int i, List<Float> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                int i2 = 0;
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).floatValue();
                        i3 += 4;
                    }
                    k5Var.f1770a.o(i3);
                    while (i2 < list.size()) {
                        i5 i5Var = k5Var.f1770a;
                        float floatValue = list.get(i2).floatValue();
                        if (i5Var != null) {
                            i5Var.z(Float.floatToRawIntBits(floatValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i5 i5Var2 = k5Var.f1770a;
                    float floatValue2 = list.get(i2).floatValue();
                    if (i5Var2 != null) {
                        int floatToRawIntBits = Float.floatToRawIntBits(floatValue2);
                        i5.b bVar = (i5.b) i5Var2;
                        bVar.o((i << 3) | 5);
                        bVar.z(floatToRawIntBits);
                        i2++;
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static int w(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (i5.A(i) * size) + s(list);
    }

    public static int x(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (i5.A(i) * size) + y(list);
    }

    public static int y(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w6) {
            w6 w6Var = (w6) list;
            i = 0;
            while (i2 < size) {
                i += i5.G(w6Var.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + i5.G(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void z(int i, List<Long> list, d9 d9Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                if (z) {
                    ((i5.b) k5Var.f1770a).o((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += i5.C(list.get(i3).longValue());
                    }
                    k5Var.f1770a.o(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        k5Var.f1770a.g(list.get(i4).longValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i5 i5Var = k5Var.f1770a;
                    long longValue = list.get(i5).longValue();
                    i5.b bVar = (i5.b) i5Var;
                    bVar.o((i << 3) | 0);
                    bVar.g(longValue);
                }
                return;
            }
            throw null;
        }
    }
}

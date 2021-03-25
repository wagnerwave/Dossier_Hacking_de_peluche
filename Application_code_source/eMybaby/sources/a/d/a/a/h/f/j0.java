package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.e.l.a;
import a.d.a.a.e.l.c;
import a.d.a.a.e.l.d;
import a.d.a.a.e.l.e;

public final class j0<V> {

    /* renamed from: a  reason: collision with root package name */
    public final V f1517a;

    public j0(a<V> aVar, V v) {
        b.k(aVar);
        this.f1517a = v;
    }

    public static j0<Integer> a(String str, int i, int i2) {
        return new j0<>(new c(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    public static j0<Long> b(String str, long j, long j2) {
        return new j0<>(new d(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    public static j0<String> c(String str, String str2, String str3) {
        return new j0<>(new e(str, str3), str2);
    }

    public static j0<Boolean> d(String str, boolean z, boolean z2) {
        return new j0<>(new a.d.a.a.e.l.b(str, Boolean.valueOf(z2)), Boolean.valueOf(z));
    }
}

package a.d.a.a.e.k.l;

import a.d.a.a.e.k.a;
import a.d.a.a.e.k.a.d;
import java.util.Arrays;

public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1265a = false;

    /* renamed from: b  reason: collision with root package name */
    public final int f1266b;

    /* renamed from: c  reason: collision with root package name */
    public final a<O> f1267c;

    /* renamed from: d  reason: collision with root package name */
    public final O f1268d;

    public b(a<O> aVar, O o) {
        this.f1267c = aVar;
        this.f1268d = o;
        this.f1266b = Arrays.hashCode(new Object[]{aVar, o});
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return !this.f1265a && !bVar.f1265a && a.c.a.f.b.B(this.f1267c, bVar.f1267c) && a.c.a.f.b.B(this.f1268d, bVar.f1268d);
    }

    public final int hashCode() {
        return this.f1266b;
    }
}

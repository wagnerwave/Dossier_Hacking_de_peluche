package a.d.a.a.h.g;

import a.c.a.d.a;
import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class x2<T> implements u2<T>, Serializable {
    @NullableDecl

    /* renamed from: a  reason: collision with root package name */
    public final T f2022a;

    public x2(@NullableDecl T t) {
        this.f2022a = t;
    }

    public final T a() {
        return this.f2022a;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof x2) {
            return a.z(this.f2022a, ((x2) obj).f2022a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2022a});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f2022a);
        return a.a.a.a.a.d(valueOf.length() + 22, "Suppliers.ofInstance(", valueOf, ")");
    }
}

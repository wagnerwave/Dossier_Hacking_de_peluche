package a.d.a.a.h.g;

import a.a.a.a.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class t2<T> extends s2<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f1944a;

    public t2(T t) {
        this.f1944a = t;
    }

    public final boolean b() {
        return true;
    }

    public final T c() {
        return this.f1944a;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof t2) {
            return this.f1944a.equals(((t2) obj).f1944a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1944a.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f1944a);
        return a.d(valueOf.length() + 13, "Optional.of(", valueOf, ")");
    }
}

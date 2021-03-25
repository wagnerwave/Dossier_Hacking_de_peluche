package a.d.a.a.h.g;

import a.a.a.a.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class v2<T> implements u2<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile u2<T> f1976a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f1977b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    public T f1978c;

    public v2(u2<T> u2Var) {
        if (u2Var != null) {
            this.f1976a = u2Var;
            return;
        }
        throw null;
    }

    public final T a() {
        if (!this.f1977b) {
            synchronized (this) {
                if (!this.f1977b) {
                    T a2 = this.f1976a.a();
                    this.f1978c = a2;
                    this.f1977b = true;
                    this.f1976a = null;
                    return a2;
                }
            }
        }
        return this.f1978c;
    }

    public final String toString() {
        Object obj = this.f1976a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f1978c);
            obj = a.d(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        }
        String valueOf2 = String.valueOf(obj);
        return a.d(valueOf2.length() + 19, "Suppliers.memoize(", valueOf2, ")");
    }
}

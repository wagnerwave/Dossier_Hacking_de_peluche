package a.d.a.a.h.g;

import a.a.a.a.a;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class w2<T> implements u2<T>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final u2<T> f1997a;

    /* renamed from: b  reason: collision with root package name */
    public volatile transient boolean f1998b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    public transient T f1999c;

    public w2(u2<T> u2Var) {
        if (u2Var != null) {
            this.f1997a = u2Var;
            return;
        }
        throw null;
    }

    public final T a() {
        if (!this.f1998b) {
            synchronized (this) {
                if (!this.f1998b) {
                    T a2 = this.f1997a.a();
                    this.f1999c = a2;
                    this.f1998b = true;
                    return a2;
                }
            }
        }
        return this.f1999c;
    }

    public final String toString() {
        Object obj;
        if (this.f1998b) {
            String valueOf = String.valueOf(this.f1999c);
            obj = a.d(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        } else {
            obj = this.f1997a;
        }
        String valueOf2 = String.valueOf(obj);
        return a.d(valueOf2.length() + 19, "Suppliers.memoize(", valueOf2, ")");
    }
}

package a.d.a.a.h.g;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class m4 extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f1829a;

    public m4(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f1829a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == m4.class) {
            if (this == obj) {
                return true;
            }
            m4 m4Var = (m4) obj;
            return this.f1829a == m4Var.f1829a && get() == m4Var.get();
        }
    }

    public final int hashCode() {
        return this.f1829a;
    }
}

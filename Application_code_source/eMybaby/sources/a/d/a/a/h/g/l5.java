package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class l5 {

    /* renamed from: b  reason: collision with root package name */
    public static volatile l5 f1801b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile l5 f1802c;

    /* renamed from: d  reason: collision with root package name */
    public static final l5 f1803d = new l5(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, y5.f<?, ?>> f1804a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1805a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1806b;

        public a(Object obj, int i) {
            this.f1805a = obj;
            this.f1806b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1805a == aVar.f1805a && this.f1806b == aVar.f1806b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f1805a) * 65535) + this.f1806b;
        }
    }

    public l5() {
        this.f1804a = new HashMap();
    }

    public l5(boolean z) {
        this.f1804a = Collections.emptyMap();
    }

    public static l5 a() {
        l5 l5Var = f1801b;
        if (l5Var == null) {
            synchronized (l5.class) {
                l5Var = f1801b;
                if (l5Var == null) {
                    l5Var = f1803d;
                    f1801b = l5Var;
                }
            }
        }
        return l5Var;
    }
}

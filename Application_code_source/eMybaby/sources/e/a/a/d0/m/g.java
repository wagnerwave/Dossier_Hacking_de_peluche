package e.a.a.d0.m;

import a.a.a.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, f> f4887a = new ConcurrentHashMap<>();

    public final f a(String str) {
        if (str != null) {
            f fVar = this.f4887a.get(str);
            if (fVar != null) {
                return fVar;
            }
            throw new IllegalStateException(a.l("Scheme '", str, "' not registered."));
        }
        throw new IllegalArgumentException("Name must not be null.");
    }

    public final f b(f fVar) {
        return this.f4887a.put(fVar.f4882a, fVar);
    }
}

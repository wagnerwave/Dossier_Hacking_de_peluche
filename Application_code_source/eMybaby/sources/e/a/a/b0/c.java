package e.a.a.b0;

import a.a.a.a.a;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f4836a = new ConcurrentHashMap<>();

    public a a(String str, e.a.a.j0.c cVar) {
        b bVar = this.f4836a.get(str.toLowerCase(Locale.ENGLISH));
        if (bVar != null) {
            return bVar.a(cVar);
        }
        throw new IllegalStateException(a.k("Unsupported authentication scheme: ", str));
    }

    public void b(String str, b bVar) {
        this.f4836a.put(str.toLowerCase(Locale.ENGLISH), bVar);
    }
}

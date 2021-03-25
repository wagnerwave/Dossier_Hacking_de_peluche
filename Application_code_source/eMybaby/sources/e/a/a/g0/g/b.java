package e.a.a.g0.g;

import e.a.a.c0.a;
import e.a.a.j;
import java.util.HashMap;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<j, e.a.a.b0.a> f4976a = new HashMap<>();

    public e.a.a.b0.a a(j jVar) {
        return this.f4976a.get(jVar);
    }

    public void b(j jVar) {
        if (jVar != null) {
            this.f4976a.remove(jVar);
            return;
        }
        throw new IllegalArgumentException("HTTP host may not be null");
    }

    public void c(j jVar, e.a.a.b0.a aVar) {
        if (jVar != null) {
            this.f4976a.put(jVar, aVar);
            return;
        }
        throw new IllegalArgumentException("HTTP host may not be null");
    }

    public String toString() {
        return this.f4976a.toString();
    }
}

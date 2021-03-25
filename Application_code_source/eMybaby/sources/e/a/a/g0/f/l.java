package e.a.a.g0.f;

import e.a.a.b0.j;
import e.a.a.d;
import e.a.a.i0.e;
import e.a.a.i0.t;
import e.a.a.l0.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class l extends a {

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f4973b;

    public String d() {
        return i("realm");
    }

    public void h(b bVar, int i, int i2) {
        d[] b2 = e.f5137a.b(bVar, new t(i, bVar.f5184b));
        if (b2.length != 0) {
            this.f4973b = new HashMap(b2.length);
            for (d dVar : b2) {
                this.f4973b.put(dVar.getName(), dVar.getValue());
            }
            return;
        }
        throw new j("Authentication challenge is empty");
    }

    public String i(String str) {
        Map<String, String> map = this.f4973b;
        if (map == null) {
            return null;
        }
        return map.get(str.toLowerCase(Locale.ENGLISH));
    }

    public Map<String, String> j() {
        if (this.f4973b == null) {
            this.f4973b = new HashMap();
        }
        return this.f4973b;
    }
}

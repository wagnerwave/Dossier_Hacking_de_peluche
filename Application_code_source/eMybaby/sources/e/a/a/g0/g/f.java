package e.a.a.g0.g;

import e.a.a.i0.d;
import e.a.a.o;

public class f {
    public long a(o oVar) {
        d dVar = new d(oVar.g("Keep-Alive"));
        while (dVar.hasNext()) {
            e.a.a.d a2 = dVar.a();
            String name = a2.getName();
            String value = a2.getValue();
            if (value != null && name.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(value) * 1000;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return -1;
    }
}

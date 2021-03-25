package e.a.a.g0.i;

import e.a.a.e0.b;
import e.a.a.e0.c;
import e.a.a.e0.g;
import e.a.a.e0.k;
import e.a.a.e0.m;

public class e implements c {
    public void a(b bVar, e.a.a.e0.e eVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (eVar != null) {
            String str = eVar.f4897a;
            String h = bVar.h();
            if (h == null) {
                throw new g("Cookie domain may not be null");
            } else if (str.contains(".")) {
                if (!str.endsWith(h)) {
                    if (h.startsWith(".")) {
                        h = h.substring(1, h.length());
                    }
                    if (!str.equals(h)) {
                        throw new g("Illegal domain attribute \"" + h + "\". Domain of origin: \"" + str + "\"");
                    }
                }
            } else if (!str.equals(h)) {
                throw new g("Illegal domain attribute \"" + h + "\". Domain of origin: \"" + str + "\"");
            }
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    public boolean b(b bVar, e.a.a.e0.e eVar) {
        String str = eVar.f4897a;
        String h = bVar.h();
        if (h == null) {
            return false;
        }
        if (str.equals(h)) {
            return true;
        }
        if (!h.startsWith(".")) {
            h = '.' + h;
        }
        return str.endsWith(h) || str.equals(h.substring(1));
    }

    public void c(m mVar, String str) {
        if (str == null) {
            throw new k("Missing value for domain attribute");
        } else if (str.trim().length() != 0) {
            ((c) mVar).m(str);
        } else {
            throw new k("Blank value for domain attribute");
        }
    }
}

package e.a.a.g0.i;

import a.a.a.a.a;
import e.a.a.e0.b;
import e.a.a.e0.c;
import e.a.a.e0.e;
import e.a.a.e0.g;
import e.a.a.e0.k;
import e.a.a.e0.m;
import java.util.Locale;

public class w implements c {
    public void a(b bVar, e eVar) {
        String str = eVar.f4897a;
        String h = bVar.h();
        if (h == null) {
            throw new g("Cookie domain may not be null");
        } else if (h.equals(str)) {
        } else {
            if (h.indexOf(46) == -1) {
                throw new g("Domain attribute \"" + h + "\" does not match the host \"" + str + "\"");
            } else if (h.startsWith(".")) {
                int indexOf = h.indexOf(46, 1);
                if (indexOf < 0 || indexOf == h.length() - 1) {
                    throw new g(a.l("Domain attribute \"", h, "\" violates RFC 2109: domain must contain an embedded dot"));
                }
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (!lowerCase.endsWith(h)) {
                    throw new g("Illegal domain attribute \"" + h + "\". Domain of origin: \"" + lowerCase + "\"");
                } else if (lowerCase.substring(0, lowerCase.length() - h.length()).indexOf(46) != -1) {
                    throw new g(a.l("Domain attribute \"", h, "\" violates RFC 2109: host minus domain may not contain any dots"));
                }
            } else {
                throw new g(a.l("Domain attribute \"", h, "\" violates RFC 2109: domain must start with a dot"));
            }
        }
    }

    public boolean b(b bVar, e eVar) {
        String str = eVar.f4897a;
        String h = bVar.h();
        if (h == null) {
            return false;
        }
        return str.equals(h) || (h.startsWith(".") && str.endsWith(h));
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

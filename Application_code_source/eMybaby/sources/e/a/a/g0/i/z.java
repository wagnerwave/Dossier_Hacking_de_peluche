package e.a.a.g0.i;

import a.a.a.a.a;
import e.a.a.e0.b;
import e.a.a.e0.e;
import e.a.a.e0.g;
import e.a.a.e0.k;
import e.a.a.e0.m;

public class z extends a {
    public void a(b bVar, e eVar) {
        if (bVar.d() < 0) {
            throw new g("Cookie version may not be negative");
        }
    }

    public void c(m mVar, String str) {
        if (str == null) {
            throw new k("Missing value for version attribute");
        } else if (str.trim().length() != 0) {
            try {
                ((c) mVar).h = Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                StringBuilder n = a.n("Invalid version: ");
                n.append(e2.getMessage());
                throw new k(n.toString());
            }
        } else {
            throw new k("Blank value for version attribute");
        }
    }
}

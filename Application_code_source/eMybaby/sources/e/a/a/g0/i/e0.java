package e.a.a.g0.i;

import a.a.a.a.a;
import e.a.a.c;
import e.a.a.d;
import e.a.a.e0.b;
import e.a.a.e0.e;
import e.a.a.e0.k;
import e.a.a.i0.o;
import e.a.a.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class e0 extends x {
    public e0(String[] strArr, boolean z) {
        super(strArr, z);
        i("domain", new c0());
        i("port", new d0());
        i("commenturl", new a0());
        i("discard", new b0());
        i("version", new g0());
    }

    public static e l(e eVar) {
        String str = eVar.f4897a;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            }
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == ':') {
                break;
            }
            i++;
        }
        return z ? new e(a.k(str, ".local"), eVar.f4898b, eVar.f4899c, eVar.f4900d) : eVar;
    }

    public void a(b bVar, e eVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (eVar != null) {
            super.a(bVar, l(eVar));
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    public boolean b(b bVar, e eVar) {
        return super.b(bVar, l(eVar));
    }

    public List<b> c(c cVar, e eVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Header may not be null");
        } else if (eVar == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        } else if (cVar.getName().equalsIgnoreCase("Set-Cookie2")) {
            return m(cVar.c(), l(eVar));
        } else {
            StringBuilder n = a.n("Unrecognized cookie header '");
            n.append(cVar.toString());
            n.append("'");
            throw new k(n.toString());
        }
    }

    public int d() {
        return 1;
    }

    public c e() {
        e.a.a.l0.b bVar = new e.a.a.l0.b(40);
        bVar.b("Cookie2");
        bVar.b(": ");
        bVar.b("$Version=");
        bVar.b(Integer.toString(1));
        return new o(bVar);
    }

    public List<b> h(d[] dVarArr, e eVar) {
        return m(dVarArr, l(eVar));
    }

    public void j(e.a.a.l0.b bVar, b bVar2, int i) {
        String b2;
        int[] j;
        super.j(bVar, bVar2, i);
        if ((bVar2 instanceof e.a.a.e0.a) && (b2 = ((e.a.a.e0.a) bVar2).b("port")) != null) {
            bVar.b("; $Port");
            bVar.b("=\"");
            if (b2.trim().length() > 0 && (j = bVar2.j()) != null) {
                int length = j.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 > 0) {
                        bVar.b(",");
                    }
                    bVar.b(Integer.toString(j[i2]));
                }
            }
            bVar.b("\"");
        }
    }

    public final List<b> m(d[] dVarArr, e eVar) {
        ArrayList arrayList = new ArrayList(dVarArr.length);
        for (d dVar : dVarArr) {
            String name = dVar.getName();
            String value = dVar.getValue();
            if (name == null || name.length() == 0) {
                throw new k("Cookie name may not be empty");
            }
            b bVar = new b(name, value);
            bVar.f = n.g(eVar);
            bVar.m(eVar.f4897a);
            bVar.i = new int[]{eVar.f4898b};
            s[] parameters = dVar.getParameters();
            HashMap hashMap = new HashMap(parameters.length);
            for (int length = parameters.length - 1; length >= 0; length--) {
                s sVar = parameters[length];
                hashMap.put(sVar.getName().toLowerCase(Locale.ENGLISH), sVar);
            }
            for (Map.Entry value2 : hashMap.entrySet()) {
                s sVar2 = (s) value2.getValue();
                String lowerCase = sVar2.getName().toLowerCase(Locale.ENGLISH);
                bVar.f5060b.put(lowerCase, sVar2.getValue());
                e.a.a.e0.c cVar = this.f5072a.get(lowerCase);
                if (cVar != null) {
                    cVar.c(bVar, sVar2.getValue());
                }
            }
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public String toString() {
        return "rfc2965";
    }
}

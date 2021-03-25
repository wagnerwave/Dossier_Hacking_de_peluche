package e.a.a.g0.i;

import e.a.a.d;
import e.a.a.e0.b;
import e.a.a.e0.c;
import e.a.a.e0.e;
import e.a.a.e0.h;
import e.a.a.e0.k;
import e.a.a.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class n implements h {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f5072a = new HashMap(10);

    public static String g(e eVar) {
        String str = eVar.f4899c;
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf < 0) {
            return str;
        }
        if (lastIndexOf == 0) {
            lastIndexOf = 1;
        }
        return str.substring(0, lastIndexOf);
    }

    public void a(b bVar, e eVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (eVar != null) {
            for (c a2 : this.f5072a.values()) {
                a2.a(bVar, eVar);
            }
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    public boolean b(b bVar, e eVar) {
        for (c b2 : this.f5072a.values()) {
            if (!b2.b(bVar, eVar)) {
                return false;
            }
        }
        return true;
    }

    public List<b> h(d[] dVarArr, e eVar) {
        ArrayList arrayList = new ArrayList(dVarArr.length);
        for (d dVar : dVarArr) {
            String name = dVar.getName();
            String value = dVar.getValue();
            if (name == null || name.length() == 0) {
                throw new k("Cookie name may not be empty");
            }
            c cVar = new c(name, value);
            cVar.f = g(eVar);
            cVar.m(eVar.f4897a);
            s[] parameters = dVar.getParameters();
            int length = parameters.length;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                s sVar = parameters[length];
                String lowerCase = sVar.getName().toLowerCase(Locale.ENGLISH);
                cVar.f5060b.put(lowerCase, sVar.getValue());
                c cVar2 = this.f5072a.get(lowerCase);
                if (cVar2 != null) {
                    cVar2.c(cVar, sVar.getValue());
                }
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public void i(String str, c cVar) {
        this.f5072a.put(str, cVar);
    }
}

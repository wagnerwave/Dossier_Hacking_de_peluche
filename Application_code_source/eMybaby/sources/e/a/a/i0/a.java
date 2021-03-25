package e.a.a.i0;

import e.a.a.j0.b;
import e.a.a.j0.c;
import e.a.a.l;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements l {

    /* renamed from: a  reason: collision with root package name */
    public p f5125a = new p();

    /* renamed from: b  reason: collision with root package name */
    public c f5126b = null;

    public void d(c cVar) {
        if (cVar != null) {
            this.f5126b = cVar;
            return;
        }
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public void e(String str, String str2) {
        p pVar = this.f5125a;
        b bVar = new b(str, str2);
        if (pVar != null) {
            pVar.f5166a.add(bVar);
            return;
        }
        throw null;
    }

    public j g(String str) {
        return new j(this.f5125a.f5166a, str);
    }

    public c getParams() {
        if (this.f5126b == null) {
            this.f5126b = new b();
        }
        return this.f5126b;
    }

    public void h(e.a.a.c cVar) {
        p pVar = this.f5125a;
        if (pVar == null) {
            throw null;
        } else if (cVar != null) {
            pVar.f5166a.add(cVar);
        }
    }

    public boolean j(String str) {
        p pVar = this.f5125a;
        for (int i = 0; i < pVar.f5166a.size(); i++) {
            if (((e.a.a.c) pVar.f5166a.get(i)).getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public e.a.a.c l(String str) {
        p pVar = this.f5125a;
        for (int i = 0; i < pVar.f5166a.size(); i++) {
            e.a.a.c cVar = (e.a.a.c) pVar.f5166a.get(i);
            if (cVar.getName().equalsIgnoreCase(str)) {
                return cVar;
            }
        }
        return null;
    }

    public e.a.a.c[] m() {
        List list = this.f5125a.f5166a;
        return (e.a.a.c[]) list.toArray(new e.a.a.c[list.size()]);
    }

    public j n() {
        return new j(this.f5125a.f5166a, (String) null);
    }

    public void o(String str, String str2) {
        p pVar = this.f5125a;
        b bVar = new b(str, str2);
        if (pVar != null) {
            for (int i = 0; i < pVar.f5166a.size(); i++) {
                if (((e.a.a.c) pVar.f5166a.get(i)).getName().equalsIgnoreCase(bVar.f5127a)) {
                    pVar.f5166a.set(i, bVar);
                    return;
                }
            }
            pVar.f5166a.add(bVar);
            return;
        }
        throw null;
    }

    public e.a.a.c[] p(String str) {
        p pVar = this.f5125a;
        if (pVar != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < pVar.f5166a.size(); i++) {
                e.a.a.c cVar = (e.a.a.c) pVar.f5166a.get(i);
                if (cVar.getName().equalsIgnoreCase(str)) {
                    arrayList.add(cVar);
                }
            }
            return (e.a.a.c[]) arrayList.toArray(new e.a.a.c[arrayList.size()]);
        }
        throw null;
    }

    public void r(e.a.a.c[] cVarArr) {
        p pVar = this.f5125a;
        pVar.f5166a.clear();
        if (cVarArr != null) {
            for (e.a.a.c add : cVarArr) {
                pVar.f5166a.add(add);
            }
        }
    }
}

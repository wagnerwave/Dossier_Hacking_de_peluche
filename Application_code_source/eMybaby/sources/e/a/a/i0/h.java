package e.a.a.i0;

import e.a.a.c;
import e.a.a.l0.b;
import e.a.a.w;
import e.a.a.y;

public class h implements r {

    /* renamed from: a  reason: collision with root package name */
    public static final h f5144a = new h();

    public b a(b bVar, w wVar) {
        if (wVar != null) {
            bVar.e(b(wVar));
            bVar.b(wVar.f5194a);
            bVar.a('/');
            bVar.b(Integer.toString(wVar.f5195b));
            bVar.a('.');
            bVar.b(Integer.toString(wVar.f5196c));
            return bVar;
        }
        throw new IllegalArgumentException("Protocol version may not be null");
    }

    public int b(w wVar) {
        return wVar.f5194a.length() + 4;
    }

    public b c(b bVar, c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Header may not be null");
        } else if (cVar instanceof e.a.a.b) {
            return ((e.a.a.b) cVar).b();
        } else {
            b e2 = e(bVar);
            String name = cVar.getName();
            String value = cVar.getValue();
            int length = name.length() + 2;
            if (value != null) {
                length += value.length();
            }
            e2.e(length);
            e2.b(name);
            e2.b(": ");
            if (value == null) {
                return e2;
            }
            e2.b(value);
            return e2;
        }
    }

    public b d(b bVar, y yVar) {
        if (yVar != null) {
            b e2 = e(bVar);
            l lVar = (l) yVar;
            String str = lVar.f5154b;
            String str2 = lVar.f5155c;
            int length = str2.length();
            e2.e(b(lVar.f5153a) + length + str.length() + 1 + 1);
            e2.b(str);
            e2.a(' ');
            e2.b(str2);
            e2.a(' ');
            a(e2, lVar.f5153a);
            return e2;
        }
        throw new IllegalArgumentException("Request line may not be null");
    }

    public b e(b bVar) {
        if (bVar == null) {
            return new b(64);
        }
        bVar.f5184b = 0;
        return bVar;
    }
}

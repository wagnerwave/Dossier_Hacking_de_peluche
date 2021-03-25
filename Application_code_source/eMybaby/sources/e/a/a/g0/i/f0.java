package e.a.a.g0.i;

import e.a.a.e0.h;
import e.a.a.e0.i;
import e.a.a.j0.c;
import java.util.Collection;

public class f0 implements i {
    public h a(c cVar) {
        String[] strArr = null;
        if (cVar == null) {
            return new e0((String[]) null, false);
        }
        Collection collection = (Collection) cVar.e("http.protocol.cookie-datepatterns");
        if (collection != null) {
            strArr = (String[]) collection.toArray(new String[collection.size()]);
        }
        return new e0(strArr, cVar.c("http.protocol.single-cookie-header", false));
    }
}

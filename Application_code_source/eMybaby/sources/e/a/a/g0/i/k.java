package e.a.a.g0.i;

import e.a.a.e0.h;
import e.a.a.e0.i;
import e.a.a.j0.c;
import java.util.Collection;

public class k implements i {
    public h a(c cVar) {
        if (cVar == null) {
            return new j();
        }
        String[] strArr = null;
        Collection collection = (Collection) cVar.e("http.protocol.cookie-datepatterns");
        if (collection != null) {
            strArr = (String[]) collection.toArray(new String[collection.size()]);
        }
        return new j(strArr, cVar.c("http.protocol.single-cookie-header", false));
    }
}

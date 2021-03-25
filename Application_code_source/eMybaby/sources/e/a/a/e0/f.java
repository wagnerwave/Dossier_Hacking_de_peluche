package e.a.a.e0;

import java.io.Serializable;
import java.util.Comparator;

public class f implements Serializable, Comparator<b> {
    public final String a(b bVar) {
        String g = bVar.g();
        if (g == null) {
            g = "/";
        }
        if (g.endsWith("/")) {
            return g;
        }
        return g + '/';
    }

    public int compare(Object obj, Object obj2) {
        String a2 = a((b) obj);
        String a3 = a((b) obj2);
        if (a2.equals(a3)) {
            return 0;
        }
        if (a2.startsWith(a3)) {
            return -1;
        }
        return a3.startsWith(a2) ? 1 : 0;
    }
}

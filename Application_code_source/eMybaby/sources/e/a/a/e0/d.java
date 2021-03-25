package e.a.a.e0;

import a.a.a.a.a;
import java.io.Serializable;
import java.util.Comparator;

public class d implements Serializable, Comparator<b> {
    public int compare(Object obj, Object obj2) {
        b bVar = (b) obj;
        b bVar2 = (b) obj2;
        int compareTo = bVar.getName().compareTo(bVar2.getName());
        if (compareTo == 0) {
            String h = bVar.h();
            String str = "";
            if (h == null) {
                h = str;
            } else if (h.indexOf(46) == -1) {
                h = a.k(h, ".local");
            }
            String h2 = bVar2.h();
            if (h2 != null) {
                str = h2.indexOf(46) == -1 ? a.k(h2, ".local") : h2;
            }
            compareTo = h.compareToIgnoreCase(str);
        }
        if (compareTo != 0) {
            return compareTo;
        }
        String g = bVar.g();
        String str2 = "/";
        if (g == null) {
            g = str2;
        }
        String g2 = bVar2.g();
        if (g2 != null) {
            str2 = g2;
        }
        return g.compareTo(str2);
    }
}

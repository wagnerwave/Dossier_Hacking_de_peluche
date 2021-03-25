package a.g.a.b.l;

import java.util.Comparator;

public final class f implements Comparator<String> {
    public int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
    }
}

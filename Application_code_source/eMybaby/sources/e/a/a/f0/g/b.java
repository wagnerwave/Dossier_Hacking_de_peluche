package e.a.a.f0.g;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class b implements Iterable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final List<f> f4913a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<f>> f4914b = new HashMap();

    public f c(String str) {
        List list = this.f4914b.get(str.toLowerCase(Locale.US));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (f) list.get(0);
    }

    public Iterator<f> iterator() {
        return Collections.unmodifiableList(this.f4913a).iterator();
    }

    public String toString() {
        return this.f4913a.toString();
    }
}

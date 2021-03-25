package a.d.a.a.h.g;

import java.util.Iterator;
import java.util.Map;

public final class o6<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a  reason: collision with root package name */
    public Iterator<Map.Entry<K, Object>> f1867a;

    public o6(Iterator<Map.Entry<K, Object>> it) {
        this.f1867a = it;
    }

    public final boolean hasNext() {
        return this.f1867a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f1867a.next();
        return next.getValue() instanceof j6 ? new l6(next, (m6) null) : next;
    }

    public final void remove() {
        this.f1867a.remove();
    }
}

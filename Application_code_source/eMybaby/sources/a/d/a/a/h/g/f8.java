package a.d.a.a.h.g;

import java.util.Iterator;
import java.util.Map;

public final class f8 implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    public int f1701a = -1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1702b;

    /* renamed from: c  reason: collision with root package name */
    public Iterator<Map.Entry<K, V>> f1703c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z7 f1704d;

    public f8(z7 z7Var, y7 y7Var) {
        this.f1704d = z7Var;
    }

    public final Iterator<Map.Entry<K, V>> a() {
        if (this.f1703c == null) {
            this.f1703c = this.f1704d.f2059c.entrySet().iterator();
        }
        return this.f1703c;
    }

    public final boolean hasNext() {
        if (this.f1701a + 1 < this.f1704d.f2058b.size() || (!this.f1704d.f2059c.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.f1702b = true;
        int i = this.f1701a + 1;
        this.f1701a = i;
        return (Map.Entry) (i < this.f1704d.f2058b.size() ? this.f1704d.f2058b.get(this.f1701a) : a().next());
    }

    public final void remove() {
        if (this.f1702b) {
            this.f1702b = false;
            this.f1704d.j();
            if (this.f1701a < this.f1704d.f2058b.size()) {
                z7 z7Var = this.f1704d;
                int i = this.f1701a;
                this.f1701a = i - 1;
                z7Var.h(i);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}

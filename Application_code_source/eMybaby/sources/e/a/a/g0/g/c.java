package e.a.a.g0.g;

import e.a.a.c0.e;
import e.a.a.e0.b;
import e.a.a.e0.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class c implements e, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final TreeSet<b> f4977a = new TreeSet<>(new d());

    public synchronized List<b> a() {
        return new ArrayList(this.f4977a);
    }

    public synchronized void b(b bVar) {
        if (bVar != null) {
            this.f4977a.remove(bVar);
            if (!bVar.f(new Date())) {
                this.f4977a.add(bVar);
            }
        }
    }

    public synchronized String toString() {
        return this.f4977a.toString();
    }
}

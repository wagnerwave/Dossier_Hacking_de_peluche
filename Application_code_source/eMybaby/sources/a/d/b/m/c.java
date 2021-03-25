package a.d.b.m;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public final String f2851a;

    /* renamed from: b  reason: collision with root package name */
    public final d f2852b;

    public c(Set<e> set, d dVar) {
        this.f2851a = b(set);
        this.f2852b = dVar;
    }

    public static String b(Set<e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<e> it = set.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            sb.append(aVar.f2848a);
            sb.append('/');
            sb.append(aVar.f2849b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String a() {
        Set<T> unmodifiableSet;
        Set<T> unmodifiableSet2;
        d dVar = this.f2852b;
        synchronized (dVar.f2854a) {
            unmodifiableSet = Collections.unmodifiableSet(dVar.f2854a);
        }
        if (unmodifiableSet.isEmpty()) {
            return this.f2851a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2851a);
        sb.append(' ');
        d dVar2 = this.f2852b;
        synchronized (dVar2.f2854a) {
            unmodifiableSet2 = Collections.unmodifiableSet(dVar2.f2854a);
        }
        sb.append(b(unmodifiableSet2));
        return sb.toString();
    }
}

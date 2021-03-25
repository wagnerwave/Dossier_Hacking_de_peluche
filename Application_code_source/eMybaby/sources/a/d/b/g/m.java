package a.d.b.g;

import a.c.a.f.b;
import a.d.b.h.c;
import a.d.b.h.d;
import a.d.b.j.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class m extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final a<Set<Object>> f2752e = l.f2751a;

    /* renamed from: a  reason: collision with root package name */
    public final Map<d<?>, v<?>> f2753a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, v<?>> f2754b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<?>, v<Set<?>>> f2755c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final u f2756d;

    public m(Executor executor, Iterable<i> iterable, d<?>... dVarArr) {
        Set<o> set;
        this.f2756d = new u(executor);
        ArrayList arrayList = new ArrayList();
        arrayList.add(d.c(this.f2756d, u.class, d.class, c.class));
        for (i components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        for (d<?> dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            o oVar = new o(dVar2);
            Iterator<Class<? super T>> it2 = dVar2.f2737a.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Class next = it2.next();
                    p pVar = new p(next, !dVar2.b(), (n) null);
                    if (!hashMap.containsKey(pVar)) {
                        hashMap.put(pVar, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(pVar);
                    if (set2.isEmpty() || pVar.f2761b) {
                        set2.add(oVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{next}));
                    }
                }
            }
        }
        for (Set<o> it3 : hashMap.values()) {
            for (o oVar2 : it3) {
                for (q next2 : oVar2.f2757a.f2738b) {
                    if ((next2.f2764c == 0) && (set = (Set) hashMap.get(new p(next2.f2762a, next2.a(), (n) null))) != null) {
                        for (o oVar3 : set) {
                            oVar2.f2758b.add(oVar3);
                            oVar3.f2759c.add(oVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        HashSet hashSet2 = new HashSet();
        Iterator it4 = hashSet.iterator();
        while (it4.hasNext()) {
            o oVar4 = (o) it4.next();
            if (oVar4.a()) {
                hashSet2.add(oVar4);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            o oVar5 = (o) hashSet2.iterator().next();
            hashSet2.remove(oVar5);
            i++;
            for (o next3 : oVar5.f2758b) {
                next3.f2759c.remove(oVar5);
                if (next3.a()) {
                    hashSet2.add(next3);
                }
            }
        }
        if (i == arrayList.size()) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                d dVar3 = (d) it5.next();
                this.f2753a.put(dVar3, new v(new j(this, dVar3)));
            }
            for (Map.Entry next4 : this.f2753a.entrySet()) {
                d dVar4 = (d) next4.getKey();
                if (dVar4.b()) {
                    v vVar = (v) next4.getValue();
                    for (Class<? super T> put : dVar4.f2737a) {
                        this.f2754b.put(put, vVar);
                    }
                }
            }
            for (d next5 : this.f2753a.keySet()) {
                Iterator<q> it6 = next5.f2738b.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        q next6 = it6.next();
                        if ((next6.f2763b == 1) && !this.f2754b.containsKey(next6.f2762a)) {
                            throw new w(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next5, next6.f2762a}));
                        }
                    }
                }
            }
            HashMap hashMap2 = new HashMap();
            for (Map.Entry next7 : this.f2753a.entrySet()) {
                d dVar5 = (d) next7.getKey();
                if (!dVar5.b()) {
                    v vVar2 = (v) next7.getValue();
                    for (Class next8 : dVar5.f2737a) {
                        if (!hashMap2.containsKey(next8)) {
                            hashMap2.put(next8, new HashSet());
                        }
                        ((Set) hashMap2.get(next8)).add(vVar2);
                    }
                }
            }
            for (Map.Entry entry : hashMap2.entrySet()) {
                this.f2755c.put((Class) entry.getKey(), new v(new k((Set) entry.getValue())));
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it7 = hashSet.iterator();
        while (it7.hasNext()) {
            o oVar6 = (o) it7.next();
            if (!oVar6.a() && !oVar6.f2758b.isEmpty()) {
                arrayList2.add(oVar6.f2757a);
            }
        }
        throw new r(arrayList2);
    }

    public static Object e(m mVar, d dVar) {
        return dVar.f2741e.a(new x(dVar, mVar));
    }

    public static /* synthetic */ Set f(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((v) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public <T> a<T> c(Class<T> cls) {
        b.m(cls, "Null interface requested.");
        return this.f2754b.get(cls);
    }

    public <T> a<Set<T>> d(Class<T> cls) {
        v vVar = this.f2755c.get(cls);
        return vVar != null ? vVar : f2752e;
    }
}

package a.d.b.g;

import a.d.b.h.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public final Set<Class<?>> f2772a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Class<?>> f2773b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Class<?>> f2774c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Class<?>> f2775d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<Class<?>> f2776e;
    public final e f;

    public static class a implements c {
        public a(Set<Class<?>> set, c cVar) {
        }
    }

    public x(d<?> dVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (q next : dVar.f2738b) {
            if (next.f2764c == 0) {
                if (next.a()) {
                    hashSet3.add(next.f2762a);
                } else {
                    hashSet.add(next.f2762a);
                }
            } else if (next.a()) {
                hashSet4.add(next.f2762a);
            } else {
                hashSet2.add(next.f2762a);
            }
        }
        if (!dVar.f.isEmpty()) {
            hashSet.add(c.class);
        }
        this.f2772a = Collections.unmodifiableSet(hashSet);
        this.f2773b = Collections.unmodifiableSet(hashSet2);
        this.f2774c = Collections.unmodifiableSet(hashSet3);
        this.f2775d = Collections.unmodifiableSet(hashSet4);
        this.f2776e = dVar.f;
        this.f = eVar;
    }

    public <T> T a(Class<T> cls) {
        if (this.f2772a.contains(cls)) {
            T a2 = this.f.a(cls);
            return !cls.equals(c.class) ? a2 : new a(this.f2776e, (c) a2);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> Set<T> b(Class<T> cls) {
        if (this.f2774c.contains(cls)) {
            return this.f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    public <T> a.d.b.j.a<T> c(Class<T> cls) {
        if (this.f2773b.contains(cls)) {
            return this.f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public <T> a.d.b.j.a<Set<T>> d(Class<T> cls) {
        if (this.f2775d.contains(cls)) {
            return this.f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }
}

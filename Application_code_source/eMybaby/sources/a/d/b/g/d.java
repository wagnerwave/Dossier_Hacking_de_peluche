package a.d.b.g;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Set<Class<? super T>> f2737a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<q> f2738b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2739c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2740d;

    /* renamed from: e  reason: collision with root package name */
    public final h<T> f2741e;
    public final Set<Class<?>> f;

    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Class<? super T>> f2742a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public final Set<q> f2743b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        public int f2744c;

        /* renamed from: d  reason: collision with root package name */
        public int f2745d;

        /* renamed from: e  reason: collision with root package name */
        public h<T> f2746e;
        public Set<Class<?>> f;

        public b(Class cls, Class[] clsArr, a aVar) {
            this.f2744c = 0;
            this.f2745d = 0;
            this.f = new HashSet();
            a.c.a.f.b.m(cls, "Null interface");
            this.f2742a.add(cls);
            for (Class m : clsArr) {
                a.c.a.f.b.m(m, "Null interface");
            }
            Collections.addAll(this.f2742a, clsArr);
        }

        public b<T> a(q qVar) {
            a.c.a.f.b.m(qVar, "Null dependency");
            if (!this.f2742a.contains(qVar.f2762a)) {
                this.f2743b.add(qVar);
                return this;
            }
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }

        public d<T> b() {
            if (this.f2746e != null) {
                return new d(new HashSet(this.f2742a), new HashSet(this.f2743b), this.f2744c, this.f2745d, this.f2746e, this.f, (a) null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public b<T> c(h<T> hVar) {
            a.c.a.f.b.m(hVar, "Null factory");
            this.f2746e = hVar;
            return this;
        }
    }

    public d(Set set, Set set2, int i, int i2, h hVar, Set set3, a aVar) {
        this.f2737a = Collections.unmodifiableSet(set);
        this.f2738b = Collections.unmodifiableSet(set2);
        this.f2739c = i;
        this.f2740d = i2;
        this.f2741e = hVar;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0], (a) null);
    }

    @SafeVarargs
    public static <T> d<T> c(T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, (a) null);
        bVar.c(new b(t));
        return bVar.b();
    }

    public boolean b() {
        return this.f2740d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f2737a.toArray()) + ">{" + this.f2739c + ", type=" + this.f2740d + ", deps=" + Arrays.toString(this.f2738b.toArray()) + "}";
    }
}

package a.d.b.g;

import a.d.b.j.a;

public class v<T> implements a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f2769c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile Object f2770a = f2769c;

    /* renamed from: b  reason: collision with root package name */
    public volatile a<T> f2771b;

    public v(a<T> aVar) {
        this.f2771b = aVar;
    }

    public T get() {
        T t = this.f2770a;
        if (t == f2769c) {
            synchronized (this) {
                t = this.f2770a;
                if (t == f2769c) {
                    t = this.f2771b.get();
                    this.f2770a = t;
                    this.f2771b = null;
                }
            }
        }
        return t;
    }
}

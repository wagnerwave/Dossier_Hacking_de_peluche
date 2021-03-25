package a.d.a.a.h.g;

import java.util.NoSuchElementException;

public final class v3 extends e4<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1979a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1980b;

    public v3(Object obj) {
        this.f1980b = obj;
    }

    public final boolean hasNext() {
        return !this.f1979a;
    }

    public final T next() {
        if (!this.f1979a) {
            this.f1979a = true;
            return this.f1980b;
        }
        throw new NoSuchElementException();
    }
}

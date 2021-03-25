package a.d.a.a.h.g;

import a.c.a.d.a;
import java.util.NoSuchElementException;

public final class p3<E> extends p3<E> {

    /* renamed from: a  reason: collision with root package name */
    public final int f1882a;

    /* renamed from: b  reason: collision with root package name */
    public int f1883b;

    /* renamed from: c  reason: collision with root package name */
    public final m3<E> f1884c;

    public p3(m3<E> m3Var, int i) {
        int size = m3Var.size();
        a.A(i, size);
        this.f1882a = size;
        this.f1883b = i;
        this.f1884c = m3Var;
    }

    public final boolean hasNext() {
        return this.f1883b < this.f1882a;
    }

    public final boolean hasPrevious() {
        return this.f1883b > 0;
    }

    public final Object next() {
        if (this.f1883b < this.f1882a) {
            int i = this.f1883b;
            this.f1883b = i + 1;
            return this.f1884c.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f1883b;
    }

    public final Object previous() {
        if (this.f1883b > 0) {
            int i = this.f1883b - 1;
            this.f1883b = i;
            return this.f1884c.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f1883b - 1;
    }
}

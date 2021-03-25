package a.d.a.a.h.g;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class y4 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public int f2043a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f2044b = this.f2045c.d();

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w4 f2045c;

    public y4(w4 w4Var) {
        this.f2045c = w4Var;
    }

    public final byte a() {
        int i = this.f2043a;
        if (i < this.f2044b) {
            this.f2043a = i + 1;
            return this.f2045c.m(i);
        }
        throw new NoSuchElementException();
    }

    public final boolean hasNext() {
        return this.f2043a < this.f2044b;
    }

    public /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

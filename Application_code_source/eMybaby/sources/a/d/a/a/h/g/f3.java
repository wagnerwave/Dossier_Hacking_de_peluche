package a.d.a.a.h.g;

import a.c.a.d.a;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class f3<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f1693a;

    /* renamed from: b  reason: collision with root package name */
    public int f1694b;

    /* renamed from: c  reason: collision with root package name */
    public int f1695c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c3 f1696d;

    public f3(c3 c3Var, b3 b3Var) {
        this.f1696d = c3Var;
        c3 c3Var2 = this.f1696d;
        this.f1693a = c3Var2.f1639e;
        this.f1694b = c3Var2.isEmpty() ? -1 : 0;
        this.f1695c = -1;
    }

    public abstract T a(int i);

    public boolean hasNext() {
        return this.f1694b >= 0;
    }

    public T next() {
        if (this.f1696d.f1639e != this.f1693a) {
            throw new ConcurrentModificationException();
        } else if (hasNext()) {
            int i = this.f1694b;
            this.f1695c = i;
            T a2 = a(i);
            c3 c3Var = this.f1696d;
            int i2 = this.f1694b + 1;
            if (i2 >= c3Var.f) {
                i2 = -1;
            }
            this.f1694b = i2;
            return a2;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        if (this.f1696d.f1639e == this.f1693a) {
            a.B(this.f1695c >= 0, "no calls to next() since the last call to remove()");
            this.f1693a += 32;
            c3 c3Var = this.f1696d;
            c3Var.remove(c3Var.f1637c[this.f1695c]);
            this.f1694b--;
            this.f1695c = -1;
            return;
        }
        throw new ConcurrentModificationException();
    }
}

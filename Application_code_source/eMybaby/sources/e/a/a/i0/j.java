package e.a.a.i0;

import e.a.a.c;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class j implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final List f5147a;

    /* renamed from: b  reason: collision with root package name */
    public int f5148b;

    /* renamed from: c  reason: collision with root package name */
    public int f5149c;

    /* renamed from: d  reason: collision with root package name */
    public String f5150d;

    public j(List list, String str) {
        if (list != null) {
            this.f5147a = list;
            this.f5150d = str;
            this.f5148b = a(-1);
            this.f5149c = -1;
            return;
        }
        throw new IllegalArgumentException("Header list must not be null.");
    }

    public int a(int i) {
        if (i < -1) {
            return -1;
        }
        int size = this.f5147a.size() - 1;
        boolean z = false;
        while (!z && i < size) {
            i++;
            if (this.f5150d == null) {
                z = true;
            } else {
                z = this.f5150d.equalsIgnoreCase(((c) this.f5147a.get(i)).getName());
            }
        }
        if (z) {
            return i;
        }
        return -1;
    }

    public c b() {
        int i = this.f5148b;
        if (i >= 0) {
            this.f5149c = i;
            this.f5148b = a(i);
            return (c) this.f5147a.get(i);
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    public boolean hasNext() {
        return this.f5148b >= 0;
    }

    public final Object next() {
        return b();
    }

    public void remove() {
        int i = this.f5149c;
        if (i >= 0) {
            this.f5147a.remove(i);
            this.f5149c = -1;
            this.f5148b--;
            return;
        }
        throw new IllegalStateException("No header to remove.");
    }
}

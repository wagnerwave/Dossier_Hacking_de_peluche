package a.d.a.a.h.g;

import java.util.ListIterator;

public final class l8 implements ListIterator<String> {

    /* renamed from: a  reason: collision with root package name */
    public ListIterator<String> f1808a = this.f1810c.f1834a.listIterator(this.f1809b);

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1809b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m8 f1810c;

    public l8(m8 m8Var, int i) {
        this.f1810c = m8Var;
        this.f1809b = i;
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f1808a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f1808a.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.f1808a.next();
    }

    public final int nextIndex() {
        return this.f1808a.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.f1808a.previous();
    }

    public final int previousIndex() {
        return this.f1808a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}

package a.d.a.a.h.g;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class m8 extends AbstractList<String> implements p6, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    public final p6 f1834a;

    public m8(p6 p6Var) {
        this.f1834a = p6Var;
    }

    public final List<?> b() {
        return this.f1834a.b();
    }

    public final void g(w4 w4Var) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.f1834a.get(i);
    }

    public final p6 i() {
        return this;
    }

    public final Iterator<String> iterator() {
        return new o8(this);
    }

    public final Object j(int i) {
        return this.f1834a.j(i);
    }

    public final ListIterator<String> listIterator(int i) {
        return new l8(this, i);
    }

    public final int size() {
        return this.f1834a.size();
    }
}

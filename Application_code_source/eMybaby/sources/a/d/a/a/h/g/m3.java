package a.d.a.a.h.g;

import a.c.a.d.a;
import a.c.a.f.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class m3<E> extends n3<E> implements List<E>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public static final g4<Object> f1828b = new p3(y3.f2040e, 0);

    public static <E> m3<E> o(E e2) {
        Object[] objArr = {e2};
        for (int i = 0; i <= 0; i++) {
            b.Y0(objArr[0], 0);
        }
        return q(objArr, 1);
    }

    public static <E> m3<E> p(Object[] objArr) {
        return q(objArr, objArr.length);
    }

    public static <E> m3<E> q(Object[] objArr, int i) {
        return i == 0 ? y3.f2040e : new y3(objArr, i);
    }

    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public int c(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: d */
    public final e4<E> iterator() {
        return (g4) listIterator();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (a.z(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = get(i2);
                        i2++;
                        if (!a.z(obj2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ((get(i2).hashCode() + (i * 31)) ^ -1) ^ -1;
        }
        return i;
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public /* synthetic */ ListIterator listIterator() {
        return (g4) listIterator(0);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [a.d.a.a.h.g.p3, java.util.ListIterator] */
    public /* synthetic */ ListIterator listIterator(int i) {
        a.A(i, size());
        return isEmpty() ? f1828b : new p3(this, i);
    }

    /* renamed from: n */
    public m3<E> subList(int i, int i2) {
        a.y(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? y3.f2040e : new o3(this, i, i3);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }
}

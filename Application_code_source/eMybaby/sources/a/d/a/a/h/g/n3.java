package a.d.a.a.h.g;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class n3<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Object[] f1843a = new Object[0];

    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public int c(Object[] objArr, int i) {
        e4 e4Var = (e4) iterator();
        while (e4Var.hasNext()) {
            objArr[i] = e4Var.next();
            i++;
        }
        return i;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: d */
    public abstract e4<E> iterator();

    @NullableDecl
    public Object[] e() {
        return null;
    }

    public int h() {
        throw new UnsupportedOperationException();
    }

    public int l() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean m();

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(f1843a);
    }

    public final <T> T[] toArray(T[] tArr) {
        if (tArr != null) {
            int size = size();
            if (tArr.length < size) {
                Object[] e2 = e();
                if (e2 != null) {
                    return Arrays.copyOfRange(e2, h(), l(), tArr.getClass());
                }
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
            } else if (tArr.length > size) {
                tArr[size] = null;
            }
            c(tArr, 0);
            return tArr;
        }
        throw null;
    }
}

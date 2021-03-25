package a.d.a.a.h.g;

import java.util.Arrays;
import java.util.RandomAccess;

public final class u7<E> extends r4<E> implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final u7<Object> f1967d;

    /* renamed from: b  reason: collision with root package name */
    public E[] f1968b;

    /* renamed from: c  reason: collision with root package name */
    public int f1969c;

    static {
        u7<Object> u7Var = new u7<>(new Object[0], 0);
        f1967d = u7Var;
        u7Var.f1915a = false;
    }

    public u7(E[] eArr, int i) {
        this.f1968b = eArr;
        this.f1969c = i;
    }

    public final void add(int i, E e2) {
        int i2;
        c();
        if (i < 0 || i > (i2 = this.f1969c)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        E[] eArr = this.f1968b;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.f1968b, i, eArr2, i + 1, this.f1969c - i);
            this.f1968b = eArr2;
        }
        this.f1968b[i] = e2;
        this.f1969c++;
        this.modCount++;
    }

    public final boolean add(E e2) {
        c();
        int i = this.f1969c;
        E[] eArr = this.f1968b;
        if (i == eArr.length) {
            this.f1968b = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f1968b;
        int i2 = this.f1969c;
        this.f1969c = i2 + 1;
        eArr2[i2] = e2;
        this.modCount++;
        return true;
    }

    public final void d(int i) {
        if (i < 0 || i >= this.f1969c) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    public final String e(int i) {
        int i2 = this.f1969c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ f6 f(int i) {
        if (i >= this.f1969c) {
            return new u7(Arrays.copyOf(this.f1968b, i), this.f1969c);
        }
        throw new IllegalArgumentException();
    }

    public final E get(int i) {
        d(i);
        return this.f1968b[i];
    }

    public final E remove(int i) {
        c();
        d(i);
        E[] eArr = this.f1968b;
        E e2 = eArr[i];
        int i2 = this.f1969c;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.f1969c--;
        this.modCount++;
        return e2;
    }

    public final E set(int i, E e2) {
        c();
        d(i);
        E[] eArr = this.f1968b;
        E e3 = eArr[i];
        eArr[i] = e2;
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f1969c;
    }
}

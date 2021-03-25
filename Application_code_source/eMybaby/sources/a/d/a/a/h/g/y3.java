package a.d.a.a.h.g;

import a.c.a.d.a;

public final class y3<E> extends m3<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final m3<Object> f2040e = new y3(new Object[0], 0);

    /* renamed from: c  reason: collision with root package name */
    public final transient Object[] f2041c;

    /* renamed from: d  reason: collision with root package name */
    public final transient int f2042d;

    public y3(Object[] objArr, int i) {
        this.f2041c = objArr;
        this.f2042d = i;
    }

    public final int c(Object[] objArr, int i) {
        System.arraycopy(this.f2041c, 0, objArr, i, this.f2042d);
        return i + this.f2042d;
    }

    public final Object[] e() {
        return this.f2041c;
    }

    public final E get(int i) {
        a.s(i, this.f2042d);
        return this.f2041c[i];
    }

    public final int h() {
        return 0;
    }

    public final int l() {
        return this.f2042d;
    }

    public final boolean m() {
        return false;
    }

    public final int size() {
        return this.f2042d;
    }
}

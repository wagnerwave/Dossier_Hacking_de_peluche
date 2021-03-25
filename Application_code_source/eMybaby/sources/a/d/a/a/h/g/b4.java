package a.d.a.a.h.g;

import a.c.a.d.a;

public final class b4 extends m3<Object> {

    /* renamed from: c  reason: collision with root package name */
    public final transient Object[] f1612c;

    /* renamed from: d  reason: collision with root package name */
    public final transient int f1613d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f1614e;

    public b4(Object[] objArr, int i, int i2) {
        this.f1612c = objArr;
        this.f1613d = i;
        this.f1614e = i2;
    }

    public final Object get(int i) {
        a.s(i, this.f1614e);
        return this.f1612c[(i * 2) + this.f1613d];
    }

    public final boolean m() {
        return true;
    }

    public final int size() {
        return this.f1614e;
    }
}

package a.d.a.a.h.g;

import a.c.a.d.a;

public final class o3 extends m3<E> {

    /* renamed from: c  reason: collision with root package name */
    public final transient int f1862c;

    /* renamed from: d  reason: collision with root package name */
    public final transient int f1863d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m3 f1864e;

    public o3(m3 m3Var, int i, int i2) {
        this.f1864e = m3Var;
        this.f1862c = i;
        this.f1863d = i2;
    }

    public final Object[] e() {
        return this.f1864e.e();
    }

    public final E get(int i) {
        a.s(i, this.f1863d);
        return this.f1864e.get(i + this.f1862c);
    }

    public final int h() {
        return this.f1864e.h() + this.f1862c;
    }

    public final int l() {
        return this.f1864e.h() + this.f1862c + this.f1863d;
    }

    public final boolean m() {
        return true;
    }

    /* renamed from: n */
    public final m3<E> subList(int i, int i2) {
        a.y(i, i2, this.f1863d);
        m3 m3Var = this.f1864e;
        int i3 = this.f1862c;
        return (m3) m3Var.subList(i + i3, i2 + i3);
    }

    public final int size() {
        return this.f1863d;
    }
}

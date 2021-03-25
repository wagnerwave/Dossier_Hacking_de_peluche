package a.d.c.u.p.f.c;

import a.a.a.a.a;

public final class p extends q {

    /* renamed from: b  reason: collision with root package name */
    public final int f3108b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3109c;

    public p(int i, int i2, int i3) {
        super(i);
        this.f3108b = i2;
        this.f3109c = i3;
        if (i2 < 0 || i2 > 10) {
            throw new IllegalArgumentException(a.h("Invalid firstDigit: ", i2));
        } else if (i3 < 0 || i3 > 10) {
            throw new IllegalArgumentException(a.h("Invalid secondDigit: ", i3));
        }
    }
}

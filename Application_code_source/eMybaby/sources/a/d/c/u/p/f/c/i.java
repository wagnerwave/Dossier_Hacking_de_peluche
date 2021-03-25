package a.d.c.u.p.f.c;

import a.d.c.r.a;

public abstract class i extends h {
    public i(a aVar) {
        super(aVar);
    }

    public abstract void d(StringBuilder sb, int i);

    public abstract int e(int i);

    public void f(StringBuilder sb, int i, int i2) {
        int d2 = s.d(this.f3095b.f3116a, i, i2);
        d(sb, d2);
        int e2 = e(d2);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (e2 / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(e2);
    }
}

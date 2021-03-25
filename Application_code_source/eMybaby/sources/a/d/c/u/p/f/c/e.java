package a.d.c.u.p.f.c;

import a.d.c.i;
import a.d.c.r.a;

public final class e extends i {

    /* renamed from: c  reason: collision with root package name */
    public final String f3092c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3093d;

    public e(a aVar, String str, String str2) {
        super(aVar);
        this.f3092c = str2;
        this.f3093d = str;
    }

    public String a() {
        if (this.f3094a.f2965b == 84) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            f(sb, 48, 20);
            int d2 = s.d(this.f3095b.f3116a, 68, 16);
            if (d2 != 38400) {
                sb.append('(');
                sb.append(this.f3092c);
                sb.append(')');
                int i = d2 % 32;
                int i2 = d2 / 32;
                int i3 = (i2 % 12) + 1;
                int i4 = i2 / 12;
                if (i4 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i4);
                if (i3 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i3);
                if (i / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i);
            }
            return sb.toString();
        }
        throw i.f2874a;
    }

    public void d(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.f3093d);
        sb.append(i / 100000);
        sb.append(')');
    }

    public int e(int i) {
        return i % 100000;
    }
}

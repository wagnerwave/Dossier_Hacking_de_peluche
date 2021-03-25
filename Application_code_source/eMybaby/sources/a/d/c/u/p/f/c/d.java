package a.d.c.u.p.f.c;

import a.d.c.i;
import a.d.c.r.a;

public final class d extends h {
    public d(a aVar) {
        super(aVar);
    }

    public String a() {
        if (this.f3094a.f2965b >= 48) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            int c2 = this.f3095b.c(48, 2);
            sb.append("(393");
            sb.append(c2);
            sb.append(')');
            int c3 = this.f3095b.c(50, 10);
            if (c3 / 100 == 0) {
                sb.append('0');
            }
            if (c3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(c3);
            sb.append(this.f3095b.b(60, (String) null).f3105b);
            return sb.toString();
        }
        throw i.f2874a;
    }
}

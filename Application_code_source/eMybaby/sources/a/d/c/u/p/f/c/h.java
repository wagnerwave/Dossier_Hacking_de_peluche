package a.d.c.u.p.f.c;

import a.d.c.r.a;

public abstract class h extends j {
    public h(a aVar) {
        super(aVar);
    }

    public void b(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        c(sb, i, length);
    }

    public void c(StringBuilder sb, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int c2 = this.f3095b.c((i4 * 10) + i, 10);
            if (c2 / 100 == 0) {
                sb.append('0');
            }
            if (c2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(c2);
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 13; i6++) {
            int charAt = sb.charAt(i6 + i2) - '0';
            if ((i6 & 1) == 0) {
                charAt *= 3;
            }
            i5 += charAt;
        }
        int i7 = 10 - (i5 % 10);
        if (i7 != 10) {
            i3 = i7;
        }
        sb.append(i3);
    }
}

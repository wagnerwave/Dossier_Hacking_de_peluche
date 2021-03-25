package e.a.a.g0.i;

import e.a.a.e0.a;
import e.a.a.e0.b;
import e.a.a.e0.c;
import e.a.a.e0.e;
import e.a.a.e0.g;
import e.a.a.e0.k;
import e.a.a.e0.l;
import e.a.a.e0.m;
import java.util.StringTokenizer;

public class d0 implements c {
    public static boolean d(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public void a(b bVar, e eVar) {
        int i = eVar.f4898b;
        if ((bVar instanceof a) && ((a) bVar).e("port") && !d(i, bVar.j())) {
            throw new g("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
        }
    }

    public boolean b(b bVar, e eVar) {
        int i = eVar.f4898b;
        if (!(bVar instanceof a) || !((a) bVar).e("port")) {
            return true;
        }
        return bVar.j() != null && d(i, bVar.j());
    }

    public void c(m mVar, String str) {
        if (mVar instanceof l) {
            l lVar = (l) mVar;
            if (str != null && str.trim().length() > 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
                int[] iArr = new int[stringTokenizer.countTokens()];
                int i = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    try {
                        iArr[i] = Integer.parseInt(stringTokenizer.nextToken().trim());
                        if (iArr[i] >= 0) {
                            i++;
                        } else {
                            throw new k("Invalid Port attribute.");
                        }
                    } catch (NumberFormatException e2) {
                        StringBuilder n = a.a.a.a.a.n("Invalid Port attribute: ");
                        n.append(e2.getMessage());
                        throw new k(n.toString());
                    }
                }
                lVar.l(iArr);
            }
        }
    }
}

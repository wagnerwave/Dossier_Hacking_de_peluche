package e.a.a.g0.i;

import e.a.a.d;
import e.a.a.i0.c;
import e.a.a.i0.k;
import e.a.a.l0.b;
import e.a.a.s;
import java.util.ArrayList;

public class t {
    public static d a(b bVar, e.a.a.i0.t tVar) {
        s b2 = b(bVar, tVar);
        ArrayList arrayList = new ArrayList();
        while (!tVar.a()) {
            arrayList.add(b(bVar, tVar));
        }
        k kVar = (k) b2;
        return new c(kVar.f5151a, kVar.f5152b, (s[]) arrayList.toArray(new s[arrayList.size()]));
    }

    public static final s b(b bVar, e.a.a.i0.t tVar) {
        boolean z;
        boolean z2;
        String str;
        char c2;
        int i = tVar.f5169c;
        int i2 = tVar.f5168b;
        int i3 = i;
        while (true) {
            z = true;
            if (i3 >= i2 || (c2 = bVar.f5183a[i3]) == '=') {
                z2 = false;
            } else if (c2 == ';') {
                z2 = true;
                break;
            } else {
                i3++;
            }
        }
        z2 = false;
        if (i3 == i2) {
            str = bVar.i(i, i2);
            z2 = true;
        } else {
            str = bVar.i(i, i3);
            i3++;
        }
        if (z2) {
            tVar.b(i3);
            return new k(str, (String) null);
        }
        int i4 = i3;
        while (true) {
            if (i4 >= i2) {
                z = z2;
                break;
            } else if (bVar.f5183a[i4] == ';') {
                break;
            } else {
                i4++;
            }
        }
        while (i3 < i4 && a.e.a.a.r.b.N(bVar.f5183a[i3])) {
            i3++;
        }
        int i5 = i4;
        while (i5 > i3) {
            int i6 = i5 - 1;
            if (!a.e.a.a.r.b.N(bVar.f5183a[i6])) {
                break;
            }
            i5 = i6;
        }
        String h = bVar.h(i3, i5);
        if (z) {
            i4++;
        }
        tVar.b(i4);
        return new k(str, h);
    }
}

package e.a.a.i0;

import e.a.a.d;
import e.a.a.l0.b;
import e.a.a.s;
import java.util.ArrayList;

public class e implements q {

    /* renamed from: a  reason: collision with root package name */
    public static final e f5137a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f5138b = {';', ','};

    public static boolean a(char c2, char[] cArr) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c2 == c3) {
                    return true;
                }
            }
        }
        return false;
    }

    public d[] b(b bVar, t tVar) {
        if (bVar != null) {
            ArrayList arrayList = new ArrayList();
            while (!tVar.a()) {
                d c2 = c(bVar, tVar);
                c cVar = (c) c2;
                if (cVar.f5129a.length() != 0 || cVar.f5130b != null) {
                    arrayList.add(c2);
                }
            }
            return (d[]) arrayList.toArray(new d[arrayList.size()]);
        }
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    public d c(b bVar, t tVar) {
        s[] sVarArr;
        if (bVar == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        } else if (tVar != null) {
            s d2 = d(bVar, tVar);
            s[] sVarArr2 = null;
            if (!tVar.a()) {
                int i = tVar.f5169c;
                if (bVar.f5183a[i - 1] != ',') {
                    int i2 = tVar.f5168b;
                    while (i < i2 && a.e.a.a.r.b.N(bVar.f5183a[i])) {
                        i++;
                    }
                    tVar.b(i);
                    if (tVar.a()) {
                        sVarArr = new s[0];
                    } else {
                        ArrayList arrayList = new ArrayList();
                        while (!tVar.a()) {
                            arrayList.add(d(bVar, tVar));
                            if (bVar.f5183a[tVar.f5169c - 1] == ',') {
                                break;
                            }
                        }
                        sVarArr = (s[]) arrayList.toArray(new s[arrayList.size()]);
                    }
                    sVarArr2 = sVarArr;
                }
            }
            return new c(d2.getName(), d2.getValue(), sVarArr2);
        } else {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
    }

    public s d(b bVar, t tVar) {
        boolean z;
        boolean z2;
        String str;
        char c2;
        char[] cArr = f5138b;
        int i = tVar.f5169c;
        int i2 = tVar.f5168b;
        int i3 = i;
        while (true) {
            z = true;
            if (i3 >= i2 || (c2 = bVar.f5183a[i3]) == '=') {
                z2 = false;
            } else if (a(c2, cArr)) {
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
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i4 >= i2) {
                z = z2;
                break;
            }
            char c3 = bVar.f5183a[i4];
            if (c3 == '\"' && !z3) {
                z4 = !z4;
            }
            if (!z4 && !z3 && a(c3, cArr)) {
                break;
            }
            z3 = !z3 && z4 && c3 == '\\';
            i4++;
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
        if (i5 - i3 >= 2) {
            char[] cArr2 = bVar.f5183a;
            if (cArr2[i3] == '\"') {
                int i7 = i5 - 1;
                if (cArr2[i7] == '\"') {
                    i3++;
                    i5 = i7;
                }
            }
        }
        String h = bVar.h(i3, i5);
        if (z) {
            i4++;
        }
        tVar.b(i4);
        return new k(str, h);
    }
}

package e.a.a.g0.k;

import e.a.a.h0.c;
import e.a.a.i0.i;
import e.a.a.i0.o;
import e.a.a.i0.s;
import e.a.a.l;
import e.a.a.l0.b;
import e.a.a.u;
import e.a.a.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final c f5084a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5085b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5086c;

    /* renamed from: d  reason: collision with root package name */
    public final List f5087d;

    /* renamed from: e  reason: collision with root package name */
    public final s f5088e;
    public int f;
    public l g;

    public a(c cVar, s sVar, e.a.a.j0.c cVar2) {
        if (cVar == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        } else if (cVar2 != null) {
            this.f5084a = cVar;
            this.f5085b = cVar2.b("http.connection.max-header-count", -1);
            this.f5086c = cVar2.b("http.connection.max-line-length", -1);
            this.f5088e = sVar == null ? i.f5145b : sVar;
            this.f5087d = new ArrayList();
            this.f = 0;
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    public static e.a.a.c[] b(c cVar, int i, int i2, s sVar, List list) {
        int i3;
        if (cVar == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        } else if (sVar == null) {
            throw new IllegalArgumentException("Line parser may not be null");
        } else if (list != null) {
            b bVar = null;
            b bVar2 = null;
            while (true) {
                i3 = 0;
                if (bVar == null) {
                    bVar = new b(64);
                } else {
                    bVar.f5184b = 0;
                }
                if (cVar.b(bVar) == -1 || bVar.f5184b < 1) {
                    e.a.a.c[] cVarArr = new e.a.a.c[list.size()];
                } else {
                    char[] cArr = bVar.f5183a;
                    if ((cArr[0] == ' ' || cArr[0] == 9) && bVar2 != null) {
                        while (i3 < bVar.f5184b && ((r3 = bVar.f5183a[i3]) == ' ' || r3 == 9)) {
                            i3++;
                        }
                        if (i2 <= 0 || ((bVar2.f5184b + 1) + bVar.f5184b) - i3 <= i2) {
                            bVar2.a(' ');
                            bVar2.d(bVar.f5183a, i3, bVar.f5184b - i3);
                        } else {
                            throw new IOException("Maximum line length limit exceeded");
                        }
                    } else {
                        list.add(bVar);
                        bVar2 = bVar;
                        bVar = null;
                    }
                    if (i > 0 && list.size() >= i) {
                        throw new IOException("Maximum header count exceeded");
                    }
                }
            }
            e.a.a.c[] cVarArr2 = new e.a.a.c[list.size()];
            while (i3 < list.size()) {
                try {
                    cVarArr2[i3] = new o((b) list.get(i3));
                    i3++;
                } catch (u e2) {
                    throw new v(e2.getMessage());
                }
            }
            return cVarArr2;
        } else {
            throw new IllegalArgumentException("Header line list may not be null");
        }
    }

    public abstract l a(c cVar);
}

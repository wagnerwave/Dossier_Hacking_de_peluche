package a.d.a.a.h.g;

import java.util.Collections;
import java.util.List;

public final class u6 extends s6 {

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f1966c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public u6(r6 r6Var) {
        super((r6) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: a.d.a.a.h.g.q6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: a.d.a.a.h.g.q6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: a.d.a.a.h.g.q6} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E> void a(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r6, r7)
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            java.lang.Object r1 = a.d.a.a.h.g.n8.r(r5, r7)
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0035
            boolean r2 = r1 instanceof a.d.a.a.h.g.p6
            if (r2 == 0) goto L_0x0020
            a.d.a.a.h.g.q6 r1 = new a.d.a.a.h.g.q6
            r1.<init>((int) r0)
            goto L_0x0083
        L_0x0020:
            boolean r2 = r1 instanceof a.d.a.a.h.g.s7
            if (r2 == 0) goto L_0x002f
            boolean r2 = r1 instanceof a.d.a.a.h.g.f6
            if (r2 == 0) goto L_0x002f
            a.d.a.a.h.g.f6 r1 = (a.d.a.a.h.g.f6) r1
            a.d.a.a.h.g.f6 r0 = r1.f(r0)
            goto L_0x0082
        L_0x002f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            goto L_0x0083
        L_0x0035:
            java.lang.Class<?> r2 = f1966c
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x004f
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
            goto L_0x0066
        L_0x004f:
            boolean r2 = r1 instanceof a.d.a.a.h.g.m8
            if (r2 == 0) goto L_0x0068
            a.d.a.a.h.g.q6 r2 = new a.d.a.a.h.g.q6
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>((int) r3)
            a.d.a.a.h.g.m8 r1 = (a.d.a.a.h.g.m8) r1
            int r0 = r2.size()
            r2.addAll(r0, r1)
        L_0x0066:
            r1 = r2
            goto L_0x0083
        L_0x0068:
            boolean r2 = r1 instanceof a.d.a.a.h.g.s7
            if (r2 == 0) goto L_0x0086
            boolean r2 = r1 instanceof a.d.a.a.h.g.f6
            if (r2 == 0) goto L_0x0086
            r2 = r1
            a.d.a.a.h.g.f6 r2 = (a.d.a.a.h.g.f6) r2
            boolean r3 = r2.a()
            if (r3 != 0) goto L_0x0086
            int r1 = r1.size()
            int r1 = r1 + r0
            a.d.a.a.h.g.f6 r0 = r2.f(r1)
        L_0x0082:
            r1 = r0
        L_0x0083:
            a.d.a.a.h.g.n8.f(r5, r7, r1)
        L_0x0086:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x0095
            if (r2 <= 0) goto L_0x0095
            r1.addAll(r6)
        L_0x0095:
            if (r0 <= 0) goto L_0x0098
            r6 = r1
        L_0x0098:
            a.d.a.a.h.g.n8.f(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.u6.a(java.lang.Object, java.lang.Object, long):void");
    }

    public final void b(Object obj, long j) {
        Object obj2;
        List list = (List) n8.r(obj, j);
        if (list instanceof p6) {
            obj2 = ((p6) list).i();
        } else if (!f1966c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof s7) || !(list instanceof f6)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                f6 f6Var = (f6) list;
                if (f6Var.a()) {
                    f6Var.k();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        n8.f(obj, j, obj2);
    }
}

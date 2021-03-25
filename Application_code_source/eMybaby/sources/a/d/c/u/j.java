package a.d.c.u;

import a.d.c.e;
import a.d.c.i;
import a.d.c.k;
import a.d.c.l;
import a.d.c.r.a;
import java.util.Collection;
import java.util.Map;

public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    public final n[] f3066a;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(java.util.Map<a.d.c.e, ?> r3) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 != 0) goto L_0x0007
            r3 = 0
            goto L_0x000f
        L_0x0007:
            a.d.c.e r0 = a.d.c.e.POSSIBLE_FORMATS
            java.lang.Object r3 = r3.get(r0)
            java.util.Collection r3 = (java.util.Collection) r3
        L_0x000f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x0054
            a.d.c.a r1 = a.d.c.a.EAN_13
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0024
            a.d.c.u.e r1 = new a.d.c.u.e
            r1.<init>()
            goto L_0x0031
        L_0x0024:
            a.d.c.a r1 = a.d.c.a.UPC_A
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0034
            a.d.c.u.l r1 = new a.d.c.u.l
            r1.<init>()
        L_0x0031:
            r0.add(r1)
        L_0x0034:
            a.d.c.a r1 = a.d.c.a.EAN_8
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0044
            a.d.c.u.f r1 = new a.d.c.u.f
            r1.<init>()
            r0.add(r1)
        L_0x0044:
            a.d.c.a r1 = a.d.c.a.UPC_E
            boolean r3 = r3.contains(r1)
            if (r3 == 0) goto L_0x0054
            a.d.c.u.o r3 = new a.d.c.u.o
            r3.<init>()
            r0.add(r3)
        L_0x0054:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0072
            a.d.c.u.e r3 = new a.d.c.u.e
            r3.<init>()
            r0.add(r3)
            a.d.c.u.f r3 = new a.d.c.u.f
            r3.<init>()
            r0.add(r3)
            a.d.c.u.o r3 = new a.d.c.u.o
            r3.<init>()
            r0.add(r3)
        L_0x0072:
            int r3 = r0.size()
            a.d.c.u.n[] r3 = new a.d.c.u.n[r3]
            java.lang.Object[] r3 = r0.toArray(r3)
            a.d.c.u.n[] r3 = (a.d.c.u.n[]) r3
            r2.f3066a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.j.<init>(java.util.Map):void");
    }

    public l b(int i, a aVar, Map<e, ?> map) {
        a.d.c.a aVar2 = a.d.c.a.UPC_A;
        int[] n = n.n(aVar);
        n[] nVarArr = this.f3066a;
        boolean z = false;
        int i2 = 0;
        while (i2 < nVarArr.length) {
            try {
                l k = nVarArr[i2].k(i, aVar, n, map);
                boolean z2 = k.f2878d == a.d.c.a.EAN_13 && k.f2875a.charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
                if (collection == null || collection.contains(aVar2)) {
                    z = true;
                }
                return (!z2 || !z) ? k : new l(k.f2875a.substring(1), (byte[]) null, k.f2877c, aVar2);
            } catch (k unused) {
                i2++;
            }
        }
        throw i.f2874a;
    }

    public void reset() {
        for (n reset : this.f3066a) {
            reset.reset();
        }
    }
}

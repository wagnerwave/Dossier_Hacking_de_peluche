package e.a.a.g0.g;

import e.a.a.b0.h;
import e.a.a.c0.f;
import java.util.concurrent.ConcurrentHashMap;

public class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<e.a.a.b0.d, h> f4978a = new ConcurrentHashMap<>();

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r6.f4839b != null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r9 != -1) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006e, code lost:
        if (r6.f4840c != null) goto L_0x0070;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0015 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.a.a.b0.h a(e.a.a.b0.d r11) {
        /*
            r10 = this;
            java.util.concurrent.ConcurrentHashMap<e.a.a.b0.d, e.a.a.b0.h> r0 = r10.f4978a
            java.lang.Object r1 = r0.get(r11)
            e.a.a.b0.h r1 = (e.a.a.b0.h) r1
            if (r1 != 0) goto L_0x007f
            r2 = 0
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
            r4 = -1
            r5 = -1
        L_0x0015:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0076
            java.lang.Object r6 = r3.next()
            e.a.a.b0.d r6 = (e.a.a.b0.d) r6
            java.lang.String r7 = r11.f4838a
            java.lang.String r8 = r6.f4838a
            boolean r7 = a.e.a.a.r.b.m(r7, r8)
            if (r7 == 0) goto L_0x002d
            r7 = 1
            goto L_0x0037
        L_0x002d:
            java.lang.String r7 = r11.f4838a
            if (r7 == 0) goto L_0x0036
            java.lang.String r7 = r6.f4838a
            if (r7 == 0) goto L_0x0036
            goto L_0x0070
        L_0x0036:
            r7 = 0
        L_0x0037:
            java.lang.String r8 = r11.f4839b
            java.lang.String r9 = r6.f4839b
            boolean r8 = a.e.a.a.r.b.m(r8, r9)
            if (r8 == 0) goto L_0x0044
            int r7 = r7 + 2
            goto L_0x004d
        L_0x0044:
            java.lang.String r8 = r11.f4839b
            if (r8 == 0) goto L_0x004d
            java.lang.String r8 = r6.f4839b
            if (r8 == 0) goto L_0x004d
            goto L_0x0070
        L_0x004d:
            int r8 = r11.f4841d
            int r9 = r6.f4841d
            if (r8 != r9) goto L_0x0056
            int r7 = r7 + 4
            goto L_0x005b
        L_0x0056:
            if (r8 == r4) goto L_0x005b
            if (r9 == r4) goto L_0x005b
            goto L_0x0070
        L_0x005b:
            java.lang.String r8 = r11.f4840c
            java.lang.String r9 = r6.f4840c
            boolean r8 = a.e.a.a.r.b.m(r8, r9)
            if (r8 == 0) goto L_0x0068
            int r7 = r7 + 8
            goto L_0x0071
        L_0x0068:
            java.lang.String r8 = r11.f4840c
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = r6.f4840c
            if (r8 == 0) goto L_0x0071
        L_0x0070:
            r7 = -1
        L_0x0071:
            if (r7 <= r5) goto L_0x0015
            r2 = r6
            r5 = r7
            goto L_0x0015
        L_0x0076:
            if (r2 == 0) goto L_0x007f
            java.lang.Object r11 = r0.get(r2)
            r1 = r11
            e.a.a.b0.h r1 = (e.a.a.b0.h) r1
        L_0x007f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.g.d.a(e.a.a.b0.d):e.a.a.b0.h");
    }

    public String toString() {
        return this.f4978a.toString();
    }
}

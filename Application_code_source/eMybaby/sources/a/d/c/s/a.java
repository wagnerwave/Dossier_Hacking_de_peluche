package a.d.c.s;

import a.d.c.j;
import a.d.c.n;
import a.d.c.s.b.d;

public final class a implements j {

    /* renamed from: b  reason: collision with root package name */
    public static final n[] f3008b = new n[0];

    /* renamed from: a  reason: collision with root package name */
    public final d f3009a = new d();

    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02b7, code lost:
        if ((java.lang.Math.abs(r6 - r1.e(r12, r8).f3038c) + java.lang.Math.abs(r4 - r1.e(r10, r8).f3038c)) <= (java.lang.Math.abs(r6 - r1.e(r12, r7).f3038c) + java.lang.Math.abs(r4 - r1.e(r10, r7).f3038c))) goto L_0x02b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.l a(a.d.c.c r25, java.util.Map<a.d.c.e, ?> r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0084
            a.d.c.e r4 = a.d.c.e.PURE_BARCODE
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0084
            a.d.c.r.b r1 = r25.a()
            int[] r4 = r1.c()
            int[] r5 = r1.b()
            if (r4 == 0) goto L_0x0081
            if (r5 == 0) goto L_0x0081
            int r6 = r1.f2966a
            r7 = r4[r2]
            r8 = r4[r3]
        L_0x0026:
            if (r7 >= r6) goto L_0x0031
            boolean r9 = r1.a(r7, r8)
            if (r9 == 0) goto L_0x0031
            int r7 = r7 + 1
            goto L_0x0026
        L_0x0031:
            if (r7 == r6) goto L_0x007e
            r6 = r4[r2]
            int r7 = r7 - r6
            if (r7 == 0) goto L_0x007b
            r6 = r4[r3]
            r8 = r5[r3]
            r4 = r4[r2]
            r5 = r5[r2]
            int r5 = r5 - r4
            int r5 = r5 + r3
            int r5 = r5 / r7
            int r8 = r8 - r6
            int r8 = r8 + r3
            int r8 = r8 / r7
            if (r5 <= 0) goto L_0x0078
            if (r8 <= 0) goto L_0x0078
            int r3 = r7 >> 1
            int r6 = r6 + r3
            int r4 = r4 + r3
            a.d.c.r.b r3 = new a.d.c.r.b
            r3.<init>(r5, r8)
            r9 = 0
        L_0x0054:
            if (r9 >= r8) goto L_0x006e
            int r10 = r9 * r7
            int r10 = r10 + r6
            r11 = 0
        L_0x005a:
            if (r11 >= r5) goto L_0x006b
            int r12 = r11 * r7
            int r12 = r12 + r4
            boolean r12 = r1.a(r12, r10)
            if (r12 == 0) goto L_0x0068
            r3.d(r11, r9)
        L_0x0068:
            int r11 = r11 + 1
            goto L_0x005a
        L_0x006b:
            int r9 = r9 + 1
            goto L_0x0054
        L_0x006e:
            a.d.c.s.b.d r1 = r0.f3009a
            a.d.c.r.e r1 = r1.a(r3)
            a.d.c.n[] r2 = f3008b
            goto L_0x02fe
        L_0x0078:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x007b:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x007e:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0081:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0084:
            a.d.c.s.c.a r1 = new a.d.c.s.c.a
            a.d.c.r.b r4 = r25.a()
            r1.<init>(r4)
            a.d.c.r.k.a r4 = r1.f3035b
            a.d.c.n[] r4 = r4.b()
            r5 = r4[r2]
            r6 = r4[r3]
            r7 = 2
            r8 = r4[r7]
            r9 = 3
            r4 = r4[r9]
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 4
            r10.<init>(r11)
            a.d.c.s.c.a$b r12 = r1.e(r5, r6)
            r10.add(r12)
            a.d.c.s.c.a$b r12 = r1.e(r5, r8)
            r10.add(r12)
            a.d.c.s.c.a$b r12 = r1.e(r6, r4)
            r10.add(r12)
            a.d.c.s.c.a$b r12 = r1.e(r8, r4)
            r10.add(r12)
            a.d.c.s.c.a$c r12 = new a.d.c.s.c.a$c
            r13 = 0
            r12.<init>(r13)
            java.util.Collections.sort(r10, r12)
            java.lang.Object r12 = r10.get(r2)
            a.d.c.s.c.a$b r12 = (a.d.c.s.c.a.b) r12
            java.lang.Object r10 = r10.get(r3)
            a.d.c.s.c.a$b r10 = (a.d.c.s.c.a.b) r10
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            a.d.c.n r15 = r12.f3036a
            a.d.c.s.c.a.b(r14, r15)
            a.d.c.n r12 = r12.f3037b
            a.d.c.s.c.a.b(r14, r12)
            a.d.c.n r12 = r10.f3036a
            a.d.c.s.c.a.b(r14, r12)
            a.d.c.n r10 = r10.f3037b
            a.d.c.s.c.a.b(r14, r10)
            java.util.Set r10 = r14.entrySet()
            java.util.Iterator r10 = r10.iterator()
            r12 = r13
            r15 = r12
            r16 = r15
        L_0x00f9:
            boolean r17 = r10.hasNext()
            if (r17 == 0) goto L_0x0123
            java.lang.Object r17 = r10.next()
            java.util.Map$Entry r17 = (java.util.Map.Entry) r17
            java.lang.Object r18 = r17.getKey()
            a.d.c.n r18 = (a.d.c.n) r18
            java.lang.Object r17 = r17.getValue()
            java.lang.Integer r17 = (java.lang.Integer) r17
            int r13 = r17.intValue()
            if (r13 != r7) goto L_0x011a
            r15 = r18
            goto L_0x0121
        L_0x011a:
            if (r12 != 0) goto L_0x011f
            r12 = r18
            goto L_0x0121
        L_0x011f:
            r16 = r18
        L_0x0121:
            r13 = 0
            goto L_0x00f9
        L_0x0123:
            if (r12 == 0) goto L_0x031c
            if (r15 == 0) goto L_0x031c
            if (r16 == 0) goto L_0x031c
            a.d.c.n[] r10 = new a.d.c.n[r9]
            r10[r2] = r12
            r10[r3] = r15
            r10[r7] = r16
            a.d.c.n.b(r10)
            r12 = r10[r2]
            r13 = r10[r3]
            r10 = r10[r7]
            boolean r15 = r14.containsKey(r5)
            if (r15 != 0) goto L_0x0141
            goto L_0x0152
        L_0x0141:
            boolean r5 = r14.containsKey(r6)
            if (r5 != 0) goto L_0x0149
            r5 = r6
            goto L_0x0152
        L_0x0149:
            boolean r5 = r14.containsKey(r8)
            if (r5 != 0) goto L_0x0151
            r5 = r8
            goto L_0x0152
        L_0x0151:
            r5 = r4
        L_0x0152:
            a.d.c.s.c.a$b r4 = r1.e(r10, r5)
            int r4 = r4.f3038c
            a.d.c.s.c.a$b r6 = r1.e(r12, r5)
            int r6 = r6.f3038c
            r8 = r4 & 1
            if (r8 != r3) goto L_0x0164
            int r4 = r4 + 1
        L_0x0164:
            int r4 = r4 + r7
            r8 = r6 & 1
            if (r8 != r3) goto L_0x016b
            int r6 = r6 + 1
        L_0x016b:
            int r6 = r6 + r7
            int r8 = r4 * 4
            int r14 = r6 * 7
            if (r8 >= r14) goto L_0x0227
            int r8 = r6 * 4
            int r14 = r4 * 7
            if (r8 < r14) goto L_0x017a
            goto L_0x0227
        L_0x017a:
            int r4 = java.lang.Math.min(r6, r4)
            int r6 = a.d.c.s.c.a.a(r13, r12)
            float r6 = (float) r6
            float r4 = (float) r4
            float r6 = r6 / r4
            int r8 = a.d.c.s.c.a.a(r10, r5)
            float r14 = r5.f2885a
            float r15 = r10.f2885a
            float r15 = r14 - r15
            float r8 = (float) r8
            float r15 = r15 / r8
            float r9 = r5.f2886b
            float r7 = r10.f2886b
            float r7 = r9 - r7
            float r7 = r7 / r8
            a.d.c.n r8 = new a.d.c.n
            float r15 = r15 * r6
            float r15 = r15 + r14
            float r6 = r6 * r7
            float r6 = r6 + r9
            r8.<init>(r15, r6)
            int r6 = a.d.c.s.c.a.a(r13, r12)
            float r6 = (float) r6
            float r6 = r6 / r4
            int r4 = a.d.c.s.c.a.a(r12, r5)
            float r7 = r5.f2885a
            float r9 = r12.f2885a
            float r9 = r7 - r9
            float r4 = (float) r4
            float r9 = r9 / r4
            float r14 = r5.f2886b
            float r15 = r12.f2886b
            float r15 = r14 - r15
            float r15 = r15 / r4
            a.d.c.n r4 = new a.d.c.n
            float r9 = r9 * r6
            float r9 = r9 + r7
            float r6 = r6 * r15
            float r6 = r6 + r14
            r4.<init>(r9, r6)
            boolean r6 = r1.c(r8)
            if (r6 != 0) goto L_0x01d6
            boolean r6 = r1.c(r4)
            if (r6 == 0) goto L_0x01d4
            goto L_0x0202
        L_0x01d4:
            r4 = 0
            goto L_0x0202
        L_0x01d6:
            boolean r6 = r1.c(r4)
            if (r6 != 0) goto L_0x01dd
            goto L_0x0201
        L_0x01dd:
            a.d.c.s.c.a$b r6 = r1.e(r10, r8)
            int r6 = r6.f3038c
            a.d.c.s.c.a$b r7 = r1.e(r12, r8)
            int r7 = r7.f3038c
            int r6 = r6 - r7
            int r6 = java.lang.Math.abs(r6)
            a.d.c.s.c.a$b r7 = r1.e(r10, r4)
            int r7 = r7.f3038c
            a.d.c.s.c.a$b r9 = r1.e(r12, r4)
            int r9 = r9.f3038c
            int r7 = r7 - r9
            int r7 = java.lang.Math.abs(r7)
            if (r6 > r7) goto L_0x0202
        L_0x0201:
            r4 = r8
        L_0x0202:
            if (r4 != 0) goto L_0x0205
            goto L_0x0206
        L_0x0205:
            r5 = r4
        L_0x0206:
            a.d.c.s.c.a$b r4 = r1.e(r10, r5)
            int r4 = r4.f3038c
            a.d.c.s.c.a$b r6 = r1.e(r12, r5)
            int r6 = r6.f3038c
            int r4 = java.lang.Math.max(r4, r6)
            int r4 = r4 + r3
            r6 = r4 & 1
            if (r6 != r3) goto L_0x021d
            int r4 = r4 + 1
        L_0x021d:
            a.d.c.r.b r1 = r1.f3034a
            r17 = r1
            r22 = r4
            r23 = r22
            goto L_0x02de
        L_0x0227:
            int r7 = a.d.c.s.c.a.a(r13, r12)
            float r7 = (float) r7
            float r8 = (float) r4
            float r7 = r7 / r8
            int r8 = a.d.c.s.c.a.a(r10, r5)
            float r9 = r5.f2885a
            float r14 = r10.f2885a
            float r14 = r9 - r14
            float r8 = (float) r8
            float r14 = r14 / r8
            float r15 = r5.f2886b
            float r2 = r10.f2886b
            float r2 = r15 - r2
            float r2 = r2 / r8
            a.d.c.n r8 = new a.d.c.n
            float r14 = r14 * r7
            float r14 = r14 + r9
            float r7 = r7 * r2
            float r7 = r7 + r15
            r8.<init>(r14, r7)
            int r2 = a.d.c.s.c.a.a(r13, r10)
            float r2 = (float) r2
            float r7 = (float) r6
            float r2 = r2 / r7
            int r7 = a.d.c.s.c.a.a(r12, r5)
            float r9 = r5.f2885a
            float r14 = r12.f2885a
            float r14 = r9 - r14
            float r7 = (float) r7
            float r14 = r14 / r7
            float r15 = r5.f2886b
            float r11 = r12.f2886b
            float r11 = r15 - r11
            float r11 = r11 / r7
            a.d.c.n r7 = new a.d.c.n
            float r14 = r14 * r2
            float r14 = r14 + r9
            float r2 = r2 * r11
            float r2 = r2 + r15
            r7.<init>(r14, r2)
            boolean r2 = r1.c(r8)
            if (r2 != 0) goto L_0x0280
            boolean r2 = r1.c(r7)
            if (r2 == 0) goto L_0x027e
            goto L_0x02ba
        L_0x027e:
            r7 = 0
            goto L_0x02ba
        L_0x0280:
            boolean r2 = r1.c(r7)
            if (r2 != 0) goto L_0x0287
            goto L_0x02b9
        L_0x0287:
            a.d.c.s.c.a$b r2 = r1.e(r10, r8)
            int r2 = r2.f3038c
            int r2 = r4 - r2
            int r2 = java.lang.Math.abs(r2)
            a.d.c.s.c.a$b r9 = r1.e(r12, r8)
            int r9 = r9.f3038c
            int r9 = r6 - r9
            int r9 = java.lang.Math.abs(r9)
            int r9 = r9 + r2
            a.d.c.s.c.a$b r2 = r1.e(r10, r7)
            int r2 = r2.f3038c
            int r4 = r4 - r2
            int r2 = java.lang.Math.abs(r4)
            a.d.c.s.c.a$b r4 = r1.e(r12, r7)
            int r4 = r4.f3038c
            int r6 = r6 - r4
            int r4 = java.lang.Math.abs(r6)
            int r4 = r4 + r2
            if (r9 > r4) goto L_0x02ba
        L_0x02b9:
            r7 = r8
        L_0x02ba:
            if (r7 != 0) goto L_0x02bd
            goto L_0x02be
        L_0x02bd:
            r5 = r7
        L_0x02be:
            a.d.c.s.c.a$b r2 = r1.e(r10, r5)
            int r2 = r2.f3038c
            a.d.c.s.c.a$b r4 = r1.e(r12, r5)
            int r4 = r4.f3038c
            r6 = r2 & 1
            if (r6 != r3) goto L_0x02d0
            int r2 = r2 + 1
        L_0x02d0:
            r6 = r4 & 1
            if (r6 != r3) goto L_0x02d6
            int r4 = r4 + 1
        L_0x02d6:
            a.d.c.r.b r1 = r1.f3034a
            r17 = r1
            r22 = r2
            r23 = r4
        L_0x02de:
            r18 = r10
            r19 = r13
            r20 = r12
            r21 = r5
            a.d.c.r.b r1 = a.d.c.s.c.a.d(r17, r18, r19, r20, r21, r22, r23)
            r2 = 4
            a.d.c.n[] r2 = new a.d.c.n[r2]
            r4 = 0
            r2[r4] = r10
            r2[r3] = r13
            r3 = 2
            r2[r3] = r12
            r3 = 3
            r2[r3] = r5
            a.d.c.s.b.d r3 = r0.f3009a
            a.d.c.r.e r1 = r3.a(r1)
        L_0x02fe:
            a.d.c.l r3 = new a.d.c.l
            java.lang.String r4 = r1.f2979b
            byte[] r5 = r1.f2978a
            a.d.c.a r6 = a.d.c.a.DATA_MATRIX
            r3.<init>(r4, r5, r2, r6)
            java.util.List<byte[]> r2 = r1.f2980c
            if (r2 == 0) goto L_0x0312
            a.d.c.m r4 = a.d.c.m.BYTE_SEGMENTS
            r3.a(r4, r2)
        L_0x0312:
            java.lang.String r1 = r1.f2981d
            if (r1 == 0) goto L_0x031b
            a.d.c.m r2 = a.d.c.m.ERROR_CORRECTION_LEVEL
            r3.a(r2, r1)
        L_0x031b:
            return r3
        L_0x031c:
            a.d.c.i r1 = a.d.c.i.f2874a
            goto L_0x0320
        L_0x031f:
            throw r1
        L_0x0320:
            goto L_0x031f
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.s.a.a(a.d.c.c, java.util.Map):a.d.c.l");
    }

    public void reset() {
    }
}

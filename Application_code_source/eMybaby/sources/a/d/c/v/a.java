package a.d.c.v;

import a.d.c.j;
import a.d.c.n;
import a.d.c.v.b.c;

public final class a implements j {

    /* renamed from: b  reason: collision with root package name */
    public static final n[] f3119b = new n[0];

    /* renamed from: a  reason: collision with root package name */
    public final c f3120a = new c();

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.l a(a.d.c.c r31, java.util.Map<a.d.c.e, ?> r32) {
        /*
            r30 = this;
            r0 = r30
            r1 = r32
            r2 = 3
            r3 = 8
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x00cb
            a.d.c.e r6 = a.d.c.e.PURE_BARCODE
            boolean r1 = r1.containsKey(r6)
            if (r1 == 0) goto L_0x00cb
            a.d.c.r.b r1 = r31.a()
            int[] r6 = r1.c()
            int[] r7 = r1.b()
            if (r6 == 0) goto L_0x00c8
            if (r7 == 0) goto L_0x00c8
            r8 = r6[r4]
            r9 = r6[r5]
            int r10 = r1.f2966a
        L_0x0029:
            if (r8 >= r10) goto L_0x0034
            boolean r11 = r1.a(r8, r9)
            if (r11 == 0) goto L_0x0034
            int r8 = r8 + 1
            goto L_0x0029
        L_0x0034:
            if (r8 == r10) goto L_0x00c5
            r9 = r6[r4]
            int r8 = r8 - r9
            int r2 = r8 >>> 3
            if (r2 == 0) goto L_0x00c2
            r8 = r6[r5]
            r7 = r7[r5]
            r9 = r6[r4]
            int r10 = r1.f2966a
            r11 = 0
            r12 = 1
        L_0x0047:
            int r13 = r10 + -1
            if (r9 >= r13) goto L_0x0059
            if (r11 >= r3) goto L_0x0059
            int r9 = r9 + 1
            boolean r13 = r1.a(r9, r8)
            if (r12 == r13) goto L_0x0057
            int r11 = r11 + 1
        L_0x0057:
            r12 = r13
            goto L_0x0047
        L_0x0059:
            if (r9 == r13) goto L_0x00bf
            r3 = r6[r4]
            int r6 = r1.f2966a
            int r6 = r6 - r5
        L_0x0060:
            if (r6 <= r3) goto L_0x006b
            boolean r10 = r1.a(r6, r8)
            if (r10 != 0) goto L_0x006b
            int r6 = r6 + -1
            goto L_0x0060
        L_0x006b:
            r10 = 0
            r11 = 1
        L_0x006d:
            if (r6 <= r3) goto L_0x007f
            r12 = 9
            if (r10 >= r12) goto L_0x007f
            int r6 = r6 + -1
            boolean r12 = r1.a(r6, r8)
            if (r11 == r12) goto L_0x007d
            int r10 = r10 + 1
        L_0x007d:
            r11 = r12
            goto L_0x006d
        L_0x007f:
            if (r6 == r3) goto L_0x00bc
            int r6 = r6 - r9
            int r6 = r6 + r5
            int r6 = r6 / r2
            int r7 = r7 - r8
            int r7 = r7 + r5
            int r7 = r7 / r2
            if (r6 <= 0) goto L_0x00b9
            if (r7 <= 0) goto L_0x00b9
            int r3 = r2 >> 1
            int r8 = r8 + r3
            int r9 = r9 + r3
            a.d.c.r.b r3 = new a.d.c.r.b
            r3.<init>(r6, r7)
            r5 = 0
        L_0x0095:
            if (r5 >= r7) goto L_0x00af
            int r10 = r5 * r2
            int r10 = r10 + r8
            r11 = 0
        L_0x009b:
            if (r11 >= r6) goto L_0x00ac
            int r12 = r11 * r2
            int r12 = r12 + r9
            boolean r12 = r1.a(r12, r10)
            if (r12 == 0) goto L_0x00a9
            r3.d(r11, r5)
        L_0x00a9:
            int r11 = r11 + 1
            goto L_0x009b
        L_0x00ac:
            int r5 = r5 + 1
            goto L_0x0095
        L_0x00af:
            a.d.c.v.b.c r1 = r0.f3120a
            a.d.c.r.e r1 = r1.a(r3)
            a.d.c.n[] r2 = f3119b
            goto L_0x035a
        L_0x00b9:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00bc:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00bf:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00c2:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00c5:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00c8:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00cb:
            a.d.c.r.b r1 = r31.a()
            int r13 = r1.f2967b
            int r14 = r1.f2966a
            a.d.c.n[] r15 = new a.d.c.n[r3]
            int[] r6 = a.d.c.v.c.a.f3134a
            int r6 = r6.length
            int[] r12 = new int[r6]
            r11 = 0
        L_0x00db:
            r10 = 4
            if (r11 >= r13) goto L_0x0113
            r7 = 0
            r16 = 0
            int[] r17 = a.d.c.v.c.a.f3134a
            r6 = r1
            r8 = r11
            r9 = r14
            r3 = 4
            r10 = r16
            r2 = r11
            r11 = r17
            r16 = r12
            int[] r6 = a.d.c.v.c.a.b(r6, r7, r8, r9, r10, r11, r12)
            if (r6 == 0) goto L_0x010b
            a.d.c.n r7 = new a.d.c.n
            r8 = r6[r4]
            float r8 = (float) r8
            float r2 = (float) r2
            r7.<init>(r8, r2)
            r15[r4] = r7
            a.d.c.n r7 = new a.d.c.n
            r6 = r6[r5]
            float r6 = (float) r6
            r7.<init>(r6, r2)
            r15[r3] = r7
            r2 = 1
            goto L_0x0117
        L_0x010b:
            int r11 = r2 + 1
            r12 = r16
            r2 = 3
            r3 = 8
            goto L_0x00db
        L_0x0113:
            r16 = r12
            r3 = 4
            r2 = 0
        L_0x0117:
            r26 = 5
            if (r2 == 0) goto L_0x0149
            int r2 = r13 + -1
        L_0x011d:
            if (r2 <= 0) goto L_0x0148
            r7 = 0
            r10 = 0
            int[] r11 = a.d.c.v.c.a.f3134a
            r6 = r1
            r8 = r2
            r9 = r14
            r12 = r16
            int[] r6 = a.d.c.v.c.a.b(r6, r7, r8, r9, r10, r11, r12)
            if (r6 == 0) goto L_0x0145
            a.d.c.n r7 = new a.d.c.n
            r8 = r6[r4]
            float r8 = (float) r8
            float r2 = (float) r2
            r7.<init>(r8, r2)
            r15[r5] = r7
            a.d.c.n r7 = new a.d.c.n
            r6 = r6[r5]
            float r6 = (float) r6
            r7.<init>(r6, r2)
            r15[r26] = r7
            r2 = 1
            goto L_0x0149
        L_0x0145:
            int r2 = r2 + -1
            goto L_0x011d
        L_0x0148:
            r2 = 0
        L_0x0149:
            int[] r6 = a.d.c.v.c.a.f3136c
            int r6 = r6.length
            int[] r12 = new int[r6]
            r27 = 2
            r28 = 6
            if (r2 == 0) goto L_0x0186
            r2 = 0
        L_0x0155:
            if (r2 >= r13) goto L_0x0182
            r7 = 0
            r10 = 0
            int[] r11 = a.d.c.v.c.a.f3136c
            r6 = r1
            r8 = r2
            r9 = r14
            r16 = r12
            int[] r6 = a.d.c.v.c.a.b(r6, r7, r8, r9, r10, r11, r12)
            if (r6 == 0) goto L_0x017d
            a.d.c.n r7 = new a.d.c.n
            r8 = r6[r5]
            float r8 = (float) r8
            float r2 = (float) r2
            r7.<init>(r8, r2)
            r15[r27] = r7
            a.d.c.n r7 = new a.d.c.n
            r6 = r6[r4]
            float r6 = (float) r6
            r7.<init>(r6, r2)
            r15[r28] = r7
            r2 = 1
            goto L_0x0188
        L_0x017d:
            int r2 = r2 + 1
            r12 = r16
            goto L_0x0155
        L_0x0182:
            r16 = r12
            r2 = 0
            goto L_0x0188
        L_0x0186:
            r16 = r12
        L_0x0188:
            r29 = 7
            if (r2 == 0) goto L_0x01ba
            int r13 = r13 - r5
        L_0x018d:
            if (r13 <= 0) goto L_0x01b9
            r7 = 0
            r10 = 0
            int[] r11 = a.d.c.v.c.a.f3136c
            r6 = r1
            r8 = r13
            r9 = r14
            r12 = r16
            int[] r2 = a.d.c.v.c.a.b(r6, r7, r8, r9, r10, r11, r12)
            if (r2 == 0) goto L_0x01b6
            a.d.c.n r6 = new a.d.c.n
            r7 = r2[r5]
            float r7 = (float) r7
            float r8 = (float) r13
            r6.<init>(r7, r8)
            r7 = 3
            r15[r7] = r6
            a.d.c.n r6 = new a.d.c.n
            r2 = r2[r4]
            float r2 = (float) r2
            r6.<init>(r2, r8)
            r15[r29] = r6
            r2 = 1
            goto L_0x01ba
        L_0x01b6:
            int r13 = r13 + -1
            goto L_0x018d
        L_0x01b9:
            r2 = 0
        L_0x01ba:
            if (r2 == 0) goto L_0x01bd
            goto L_0x01be
        L_0x01bd:
            r15 = 0
        L_0x01be:
            if (r15 != 0) goto L_0x02a6
            int r2 = r1.f2967b
            int r6 = r1.f2966a
            int r14 = r6 >> 1
            r6 = 8
            a.d.c.n[] r15 = new a.d.c.n[r6]
            int[] r6 = a.d.c.v.c.a.f3135b
            int r6 = r6.length
            int[] r12 = new int[r6]
            int r16 = r2 + -1
            r11 = r16
        L_0x01d3:
            if (r11 <= 0) goto L_0x0203
            r10 = 1
            int[] r17 = a.d.c.v.c.a.f3135b
            r6 = r1
            r7 = r14
            r8 = r11
            r9 = r14
            r13 = r11
            r11 = r17
            r17 = r12
            int[] r6 = a.d.c.v.c.a.b(r6, r7, r8, r9, r10, r11, r12)
            if (r6 == 0) goto L_0x01fe
            a.d.c.n r7 = new a.d.c.n
            r8 = r6[r5]
            float r8 = (float) r8
            float r9 = (float) r13
            r7.<init>(r8, r9)
            r15[r4] = r7
            a.d.c.n r7 = new a.d.c.n
            r6 = r6[r4]
            float r6 = (float) r6
            r7.<init>(r6, r9)
            r15[r3] = r7
            r6 = 1
            goto L_0x0206
        L_0x01fe:
            int r11 = r13 + -1
            r12 = r17
            goto L_0x01d3
        L_0x0203:
            r17 = r12
            r6 = 0
        L_0x0206:
            if (r6 == 0) goto L_0x0235
            r13 = 0
        L_0x0209:
            if (r13 >= r2) goto L_0x0234
            r10 = 1
            int[] r11 = a.d.c.v.c.a.f3135b
            r6 = r1
            r7 = r14
            r8 = r13
            r9 = r14
            r12 = r17
            int[] r6 = a.d.c.v.c.a.b(r6, r7, r8, r9, r10, r11, r12)
            if (r6 == 0) goto L_0x0231
            a.d.c.n r7 = new a.d.c.n
            r8 = r6[r5]
            float r8 = (float) r8
            float r9 = (float) r13
            r7.<init>(r8, r9)
            r15[r5] = r7
            a.d.c.n r7 = new a.d.c.n
            r6 = r6[r4]
            float r6 = (float) r6
            r7.<init>(r6, r9)
            r15[r26] = r7
            r6 = 1
            goto L_0x0235
        L_0x0231:
            int r13 = r13 + 1
            goto L_0x0209
        L_0x0234:
            r6 = 0
        L_0x0235:
            int[] r7 = a.d.c.v.c.a.f3137d
            int r7 = r7.length
            int[] r13 = new int[r7]
            if (r6 == 0) goto L_0x026b
            r12 = r16
        L_0x023e:
            if (r12 <= 0) goto L_0x026a
            r7 = 0
            r10 = 0
            int[] r11 = a.d.c.v.c.a.f3137d
            r6 = r1
            r8 = r12
            r9 = r14
            r3 = r12
            r12 = r13
            int[] r6 = a.d.c.v.c.a.b(r6, r7, r8, r9, r10, r11, r12)
            if (r6 == 0) goto L_0x0266
            a.d.c.n r7 = new a.d.c.n
            r8 = r6[r4]
            float r8 = (float) r8
            float r3 = (float) r3
            r7.<init>(r8, r3)
            r15[r27] = r7
            a.d.c.n r7 = new a.d.c.n
            r6 = r6[r5]
            float r6 = (float) r6
            r7.<init>(r6, r3)
            r15[r28] = r7
            r6 = 1
            goto L_0x026b
        L_0x0266:
            int r12 = r3 + -1
            r3 = 4
            goto L_0x023e
        L_0x026a:
            r6 = 0
        L_0x026b:
            if (r6 == 0) goto L_0x029a
            r3 = 0
        L_0x026e:
            if (r3 >= r2) goto L_0x0299
            r7 = 0
            r10 = 0
            int[] r11 = a.d.c.v.c.a.f3137d
            r6 = r1
            r8 = r3
            r9 = r14
            r12 = r13
            int[] r6 = a.d.c.v.c.a.b(r6, r7, r8, r9, r10, r11, r12)
            if (r6 == 0) goto L_0x0296
            a.d.c.n r2 = new a.d.c.n
            r7 = r6[r4]
            float r7 = (float) r7
            float r3 = (float) r3
            r2.<init>(r7, r3)
            r7 = 3
            r15[r7] = r2
            a.d.c.n r2 = new a.d.c.n
            r6 = r6[r5]
            float r6 = (float) r6
            r2.<init>(r6, r3)
            r15[r29] = r2
            r6 = 1
            goto L_0x029a
        L_0x0296:
            int r3 = r3 + 1
            goto L_0x026e
        L_0x0299:
            r6 = 0
        L_0x029a:
            if (r6 == 0) goto L_0x029e
            r13 = r15
            goto L_0x029f
        L_0x029e:
            r13 = 0
        L_0x029f:
            if (r13 == 0) goto L_0x02a4
            a.d.c.v.c.a.a(r13, r5)
        L_0x02a4:
            r2 = r13
            goto L_0x02aa
        L_0x02a6:
            a.d.c.v.c.a.a(r15, r4)
            r2 = r15
        L_0x02aa:
            if (r2 == 0) goto L_0x036c
            r3 = r2[r4]
            r6 = 4
            r7 = r2[r6]
            float r3 = a.d.c.n.a(r3, r7)
            r6 = r2[r5]
            r7 = r2[r26]
            float r6 = a.d.c.n.a(r6, r7)
            float r6 = r6 + r3
            r3 = 1107820544(0x42080000, float:34.0)
            float r6 = r6 / r3
            r3 = r2[r28]
            r7 = r2[r27]
            float r3 = a.d.c.n.a(r3, r7)
            r7 = r2[r29]
            r8 = 3
            r9 = r2[r8]
            float r7 = a.d.c.n.a(r7, r9)
            float r7 = r7 + r3
            r3 = 1108344832(0x42100000, float:36.0)
            float r7 = r7 / r3
            float r7 = r7 + r6
            r3 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r3
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0369
            r3 = 4
            r6 = r2[r3]
            r3 = r2[r28]
            r8 = r2[r26]
            r9 = r2[r29]
            float r3 = a.d.c.n.a(r6, r3)
            float r3 = r3 / r7
            r6 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r6
            int r3 = (int) r3
            float r8 = a.d.c.n.a(r8, r9)
            float r8 = r8 / r7
            float r8 = r8 + r6
            int r6 = (int) r8
            int r3 = r3 + r6
            int r3 = r3 >> r5
            r6 = 8
            int r3 = r3 + r6
            int r3 = r3 / 17
            int r9 = r3 * 17
            if (r9 < r5) goto L_0x0366
            r3 = 4
            r7 = r2[r3]
            r3 = r2[r26]
            r8 = r2[r28]
            r10 = r2[r29]
            a.d.c.r.f r6 = a.d.c.r.f.f2982a
            float r15 = (float) r9
            r12 = r15
            r17 = r15
            r14 = r15
            r16 = 0
            float r11 = r7.f2885a
            r18 = r11
            float r7 = r7.f2886b
            r19 = r7
            float r7 = r8.f2885a
            r20 = r7
            float r7 = r8.f2886b
            r21 = r7
            float r7 = r10.f2885a
            r22 = r7
            float r7 = r10.f2886b
            r23 = r7
            float r7 = r3.f2885a
            r24 = r7
            float r3 = r3.f2886b
            r25 = r3
            r10 = 0
            r11 = 0
            r13 = 0
            r7 = r1
            r8 = r9
            a.d.c.r.b r1 = r6.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r3 = 4
            a.d.c.n[] r6 = new a.d.c.n[r3]
            r7 = r2[r26]
            r6[r4] = r7
            r3 = r2[r3]
            r6[r5] = r3
            r3 = r2[r28]
            r6[r27] = r3
            r2 = r2[r29]
            r3 = 3
            r6[r3] = r2
            a.d.c.v.b.c r2 = r0.f3120a
            a.d.c.r.e r1 = r2.a(r1)
            r2 = r6
        L_0x035a:
            a.d.c.l r3 = new a.d.c.l
            java.lang.String r4 = r1.f2979b
            byte[] r1 = r1.f2978a
            a.d.c.a r5 = a.d.c.a.PDF_417
            r3.<init>(r4, r1, r2, r5)
            return r3
        L_0x0366:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0369:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x036c:
            a.d.c.i r1 = a.d.c.i.f2874a
            goto L_0x0370
        L_0x036f:
            throw r1
        L_0x0370:
            goto L_0x036f
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.v.a.a(a.d.c.c, java.util.Map):a.d.c.l");
    }

    public void reset() {
    }
}

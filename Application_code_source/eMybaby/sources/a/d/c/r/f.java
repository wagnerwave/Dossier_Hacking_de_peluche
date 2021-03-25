package a.d.c.r;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f2982a = new f();

    public b a(b bVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        b bVar2 = bVar;
        int i3 = i;
        int i4 = i2;
        return b(bVar, i, i2, i.a(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.r.b b(a.d.c.r.b r23, int r24, int r25, a.d.c.r.i r26) {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            if (r1 <= 0) goto L_0x0109
            if (r2 <= 0) goto L_0x0109
            a.d.c.r.b r4 = new a.d.c.r.b
            r4.<init>(r1, r2)
            r5 = 1
            int r1 = r1 << r5
            float[] r6 = new float[r1]
            r8 = 0
        L_0x0016:
            if (r8 >= r2) goto L_0x0108
            float r9 = (float) r8
            r10 = 1056964608(0x3f000000, float:0.5)
            float r9 = r9 + r10
            r11 = 0
        L_0x001d:
            if (r11 >= r1) goto L_0x002c
            int r12 = r11 >> 1
            float r12 = (float) r12
            float r12 = r12 + r10
            r6[r11] = r12
            int r12 = r11 + 1
            r6[r12] = r9
            int r11 = r11 + 2
            goto L_0x001d
        L_0x002c:
            if (r3 == 0) goto L_0x0106
            float r9 = r3.f2988a
            float r10 = r3.f2989b
            float r11 = r3.f2990c
            float r12 = r3.f2991d
            float r13 = r3.f2992e
            float r14 = r3.f
            float r15 = r3.g
            float r5 = r3.h
            float r7 = r3.i
            r2 = 0
        L_0x0041:
            if (r2 >= r1) goto L_0x006c
            r16 = r6[r2]
            int r17 = r2 + 1
            r18 = r6[r17]
            float r19 = r11 * r16
            float r20 = r14 * r18
            float r20 = r20 + r19
            float r20 = r20 + r7
            float r19 = r9 * r16
            float r21 = r12 * r18
            float r21 = r21 + r19
            float r21 = r21 + r15
            float r21 = r21 / r20
            r6[r2] = r21
            float r16 = r16 * r10
            float r18 = r18 * r13
            float r18 = r18 + r16
            float r18 = r18 + r5
            float r18 = r18 / r20
            r6[r17] = r18
            int r2 = r2 + 2
            goto L_0x0041
        L_0x006c:
            int r2 = r0.f2966a
            int r5 = r0.f2967b
            r7 = 0
            r9 = 1
        L_0x0072:
            r10 = 0
            r11 = -1
            if (r7 >= r1) goto L_0x00aa
            if (r9 == 0) goto L_0x00aa
            r9 = r6[r7]
            int r9 = (int) r9
            int r12 = r7 + 1
            r13 = r6[r12]
            int r13 = (int) r13
            if (r9 < r11) goto L_0x00a7
            if (r9 > r2) goto L_0x00a7
            if (r13 < r11) goto L_0x00a7
            if (r13 > r5) goto L_0x00a7
            if (r9 != r11) goto L_0x008d
            r6[r7] = r10
            goto L_0x0094
        L_0x008d:
            if (r9 != r2) goto L_0x0096
            int r9 = r2 + -1
            float r9 = (float) r9
            r6[r7] = r9
        L_0x0094:
            r9 = 1
            goto L_0x0097
        L_0x0096:
            r9 = 0
        L_0x0097:
            if (r13 != r11) goto L_0x009c
            r6[r12] = r10
            goto L_0x00a3
        L_0x009c:
            if (r13 != r5) goto L_0x00a4
            int r9 = r5 + -1
            float r9 = (float) r9
            r6[r12] = r9
        L_0x00a3:
            r9 = 1
        L_0x00a4:
            int r7 = r7 + 2
            goto L_0x0072
        L_0x00a7:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x00aa:
            int r7 = r1 + -2
            r9 = 1
        L_0x00ad:
            if (r7 < 0) goto L_0x00e3
            if (r9 == 0) goto L_0x00e3
            r9 = r6[r7]
            int r9 = (int) r9
            int r12 = r7 + 1
            r13 = r6[r12]
            int r13 = (int) r13
            if (r9 < r11) goto L_0x00e0
            if (r9 > r2) goto L_0x00e0
            if (r13 < r11) goto L_0x00e0
            if (r13 > r5) goto L_0x00e0
            if (r9 != r11) goto L_0x00c6
            r6[r7] = r10
            goto L_0x00cd
        L_0x00c6:
            if (r9 != r2) goto L_0x00cf
            int r9 = r2 + -1
            float r9 = (float) r9
            r6[r7] = r9
        L_0x00cd:
            r9 = 1
            goto L_0x00d0
        L_0x00cf:
            r9 = 0
        L_0x00d0:
            if (r13 != r11) goto L_0x00d5
            r6[r12] = r10
            goto L_0x00dc
        L_0x00d5:
            if (r13 != r5) goto L_0x00dd
            int r9 = r5 + -1
            float r9 = (float) r9
            r6[r12] = r9
        L_0x00dc:
            r9 = 1
        L_0x00dd:
            int r7 = r7 + -2
            goto L_0x00ad
        L_0x00e0:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x00e3:
            r2 = 0
        L_0x00e4:
            if (r2 >= r1) goto L_0x00ff
            r5 = r6[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fc }
            int r5 = (int) r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fc }
            int r7 = r2 + 1
            r7 = r6[r7]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fc }
            int r7 = (int) r7     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fc }
            boolean r5 = r0.a(r5, r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fc }
            if (r5 == 0) goto L_0x00f9
            int r5 = r2 >> 1
            r4.d(r5, r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00fc }
        L_0x00f9:
            int r2 = r2 + 2
            goto L_0x00e4
        L_0x00fc:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x00ff:
            int r8 = r8 + 1
            r2 = r25
            r5 = 1
            goto L_0x0016
        L_0x0106:
            r0 = 0
            throw r0
        L_0x0108:
            return r4
        L_0x0109:
            a.d.c.i r0 = a.d.c.i.f2874a
            goto L_0x010d
        L_0x010c:
            throw r0
        L_0x010d:
            goto L_0x010c
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.r.f.b(a.d.c.r.b, int, int, a.d.c.r.i):a.d.c.r.b");
    }
}

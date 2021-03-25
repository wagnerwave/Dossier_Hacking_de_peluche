package a.d.c.w;

import a.d.c.j;
import a.d.c.n;
import a.d.c.w.b.e;

public class a implements j {

    /* renamed from: b  reason: collision with root package name */
    public static final n[] f3138b = new n[0];

    /* renamed from: a  reason: collision with root package name */
    public final e f3139a = new e();

    /* JADX WARNING: Removed duplicated region for block: B:158:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.l a(a.d.c.c r29, java.util.Map<a.d.c.e, ?> r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r30
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 5
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x00b4
            a.d.c.e r6 = a.d.c.e.PURE_BARCODE
            boolean r6 = r1.containsKey(r6)
            if (r6 == 0) goto L_0x00b4
            a.d.c.r.b r6 = r29.a()
            int[] r7 = r6.c()
            int[] r8 = r6.b()
            if (r7 == 0) goto L_0x00b1
            if (r8 == 0) goto L_0x00b1
            int r9 = r6.f2967b
            int r10 = r6.f2966a
            r11 = r7[r4]
            r12 = r7[r5]
            r13 = 1
            r14 = 0
        L_0x002d:
            if (r11 >= r10) goto L_0x0043
            if (r12 >= r9) goto L_0x0043
            boolean r15 = r6.a(r11, r12)
            if (r13 == r15) goto L_0x003e
            int r14 = r14 + 1
            if (r14 != r3) goto L_0x003c
            goto L_0x0043
        L_0x003c:
            r13 = r13 ^ 1
        L_0x003e:
            int r11 = r11 + 1
            int r12 = r12 + 1
            goto L_0x002d
        L_0x0043:
            if (r11 == r10) goto L_0x00ae
            if (r12 == r9) goto L_0x00ae
            r3 = r7[r4]
            int r11 = r11 - r3
            float r3 = (float) r11
            r9 = 1088421888(0x40e00000, float:7.0)
            float r3 = r3 / r9
            r9 = r7[r5]
            r10 = r8[r5]
            r7 = r7[r4]
            r4 = r8[r4]
            int r10 = r10 - r9
            int r8 = r4 - r7
            if (r10 == r8) goto L_0x005d
            int r4 = r7 + r10
        L_0x005d:
            int r4 = r4 - r7
            int r4 = r4 + r5
            float r4 = (float) r4
            float r4 = r4 / r3
            int r4 = java.lang.Math.round(r4)
            int r10 = r10 + r5
            float r5 = (float) r10
            float r5 = r5 / r3
            int r5 = java.lang.Math.round(r5)
            if (r4 <= 0) goto L_0x00ab
            if (r5 <= 0) goto L_0x00ab
            if (r5 != r4) goto L_0x00a8
            float r2 = r3 / r2
            int r2 = java.lang.Math.round(r2)
            int r9 = r9 + r2
            int r7 = r7 + r2
            a.d.c.r.b r2 = new a.d.c.r.b
            r2.<init>(r4, r5)
            r8 = 0
        L_0x0080:
            if (r8 >= r5) goto L_0x009e
            float r10 = (float) r8
            float r10 = r10 * r3
            int r10 = (int) r10
            int r10 = r10 + r9
            r11 = 0
        L_0x0088:
            if (r11 >= r4) goto L_0x009b
            float r12 = (float) r11
            float r12 = r12 * r3
            int r12 = (int) r12
            int r12 = r12 + r7
            boolean r12 = r6.a(r12, r10)
            if (r12 == 0) goto L_0x0098
            r2.d(r11, r8)
        L_0x0098:
            int r11 = r11 + 1
            goto L_0x0088
        L_0x009b:
            int r8 = r8 + 1
            goto L_0x0080
        L_0x009e:
            a.d.c.w.b.e r3 = r0.f3139a
            a.d.c.r.e r1 = r3.a(r2, r1)
            a.d.c.n[] r2 = f3138b
            goto L_0x03c3
        L_0x00a8:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00ab:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00ae:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00b1:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00b4:
            a.d.c.w.c.c r2 = new a.d.c.w.c.c
            a.d.c.r.b r6 = r29.a()
            r2.<init>(r6)
            if (r1 != 0) goto L_0x00c1
            r6 = 0
            goto L_0x00c9
        L_0x00c1:
            a.d.c.e r6 = a.d.c.e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r6 = r1.get(r6)
            a.d.c.o r6 = (a.d.c.o) r6
        L_0x00c9:
            r2.f3178b = r6
            a.d.c.w.c.e r7 = new a.d.c.w.c.e
            a.d.c.r.b r8 = r2.f3177a
            r7.<init>(r8, r6)
            if (r1 == 0) goto L_0x00de
            a.d.c.e r6 = a.d.c.e.TRY_HARDER
            boolean r6 = r1.containsKey(r6)
            if (r6 == 0) goto L_0x00de
            r6 = 1
            goto L_0x00df
        L_0x00de:
            r6 = 0
        L_0x00df:
            a.d.c.r.b r8 = r7.f3181a
            int r9 = r8.f2967b
            int r8 = r8.f2966a
            int r10 = r9 * 3
            int r10 = r10 / 228
            r11 = 3
            if (r10 < r11) goto L_0x00ee
            if (r6 == 0) goto L_0x00ef
        L_0x00ee:
            r10 = 3
        L_0x00ef:
            int[] r3 = new int[r3]
            int r6 = r10 + -1
            r12 = 0
        L_0x00f4:
            r13 = 2
            r14 = 4
            if (r6 >= r9) goto L_0x01e7
            if (r12 != 0) goto L_0x01e7
            r3[r4] = r4
            r3[r5] = r4
            r3[r13] = r4
            r3[r11] = r4
            r3[r14] = r4
            r4 = 0
            r11 = 0
        L_0x0106:
            if (r4 >= r8) goto L_0x01ca
            a.d.c.r.b r15 = r7.f3181a
            boolean r15 = r15.a(r4, r6)
            if (r15 == 0) goto L_0x011d
            r14 = r11 & 1
            if (r14 != r5) goto L_0x0116
            int r11 = r11 + 1
        L_0x0116:
            r14 = r3[r11]
            int r14 = r14 + r5
            r3[r11] = r14
            goto L_0x01c6
        L_0x011d:
            r15 = r11 & 1
            if (r15 != 0) goto L_0x01c1
            if (r11 != r14) goto L_0x01b9
            boolean r11 = a.d.c.w.c.e.b(r3)
            if (r11 == 0) goto L_0x01a4
            boolean r11 = r7.d(r3, r6, r4)
            if (r11 == 0) goto L_0x0190
            boolean r10 = r7.f3183c
            if (r10 == 0) goto L_0x0138
            boolean r12 = r7.e()
            goto L_0x0180
        L_0x0138:
            java.util.List<a.d.c.w.c.d> r10 = r7.f3182b
            int r10 = r10.size()
            if (r10 > r5) goto L_0x0141
            goto L_0x0174
        L_0x0141:
            java.util.List<a.d.c.w.c.d> r10 = r7.f3182b
            java.util.Iterator r10 = r10.iterator()
            r11 = 0
        L_0x0148:
            boolean r14 = r10.hasNext()
            if (r14 == 0) goto L_0x0174
            java.lang.Object r14 = r10.next()
            a.d.c.w.c.d r14 = (a.d.c.w.c.d) r14
            int r15 = r14.f3180d
            if (r15 < r13) goto L_0x0148
            if (r11 != 0) goto L_0x015c
            r11 = r14
            goto L_0x0148
        L_0x015c:
            r7.f3183c = r5
            float r10 = r11.f2885a
            float r15 = r14.f2885a
            float r10 = r10 - r15
            float r10 = java.lang.Math.abs(r10)
            float r11 = r11.f2886b
            float r14 = r14.f2886b
            float r11 = r11 - r14
            float r11 = java.lang.Math.abs(r11)
            float r10 = r10 - r11
            int r10 = (int) r10
            int r10 = r10 / r13
            goto L_0x0175
        L_0x0174:
            r10 = 0
        L_0x0175:
            r11 = r3[r13]
            if (r10 <= r11) goto L_0x0180
            r4 = r3[r13]
            int r10 = r10 - r4
            int r10 = r10 - r13
            int r6 = r6 + r10
            int r4 = r8 + -1
        L_0x0180:
            r10 = 0
            r3[r10] = r10
            r3[r5] = r10
            r3[r13] = r10
            r11 = 3
            r3[r11] = r10
            r11 = 4
            r3[r11] = r10
            r10 = 2
            r11 = 0
            goto L_0x01c6
        L_0x0190:
            r11 = 0
            r14 = 3
            r15 = 4
            r16 = r3[r13]
            r3[r11] = r16
            r16 = r3[r14]
            r3[r5] = r16
            r16 = r3[r15]
            r3[r13] = r16
            r3[r14] = r5
            r3[r15] = r11
            goto L_0x01b7
        L_0x01a4:
            r11 = 0
            r14 = 3
            r15 = 4
            r16 = r3[r13]
            r3[r11] = r16
            r16 = r3[r14]
            r3[r5] = r16
            r16 = r3[r15]
            r3[r13] = r16
            r3[r14] = r5
            r3[r15] = r11
        L_0x01b7:
            r11 = 3
            goto L_0x01c6
        L_0x01b9:
            int r11 = r11 + 1
            r14 = r3[r11]
            int r14 = r14 + r5
            r3[r11] = r14
            goto L_0x01c6
        L_0x01c1:
            r14 = r3[r11]
            int r14 = r14 + r5
            r3[r11] = r14
        L_0x01c6:
            int r4 = r4 + r5
            r14 = 4
            goto L_0x0106
        L_0x01ca:
            boolean r4 = a.d.c.w.c.e.b(r3)
            if (r4 == 0) goto L_0x01e2
            boolean r4 = r7.d(r3, r6, r8)
            if (r4 == 0) goto L_0x01e2
            r4 = 0
            r4 = r3[r4]
            boolean r10 = r7.f3183c
            if (r10 == 0) goto L_0x01e1
            boolean r12 = r7.e()
        L_0x01e1:
            r10 = r4
        L_0x01e2:
            int r6 = r6 + r10
            r4 = 0
            r11 = 3
            goto L_0x00f4
        L_0x01e7:
            java.util.List<a.d.c.w.c.d> r3 = r7.f3182b
            int r3 = r3.size()
            r4 = 3
            if (r3 < r4) goto L_0x03e4
            r6 = 0
            if (r3 <= r4) goto L_0x025c
            java.util.List<a.d.c.w.c.d> r4 = r7.f3182b
            java.util.Iterator r4 = r4.iterator()
            r8 = 0
            r9 = 0
        L_0x01fb:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x020e
            java.lang.Object r10 = r4.next()
            a.d.c.w.c.d r10 = (a.d.c.w.c.d) r10
            float r10 = r10.f3179c
            float r8 = r8 + r10
            float r10 = r10 * r10
            float r9 = r9 + r10
            goto L_0x01fb
        L_0x020e:
            float r3 = (float) r3
            float r8 = r8 / r3
            float r9 = r9 / r3
            float r3 = r8 * r8
            float r9 = r9 - r3
            double r3 = (double) r9
            double r3 = java.lang.Math.sqrt(r3)
            float r3 = (float) r3
            java.util.List<a.d.c.w.c.d> r4 = r7.f3182b
            a.d.c.w.c.e$c r9 = new a.d.c.w.c.e$c
            r10 = 0
            r9.<init>(r8, r10)
            java.util.Collections.sort(r4, r9)
            r4 = 1045220557(0x3e4ccccd, float:0.2)
            float r4 = r4 * r8
            float r3 = java.lang.Math.max(r4, r3)
            r4 = 0
        L_0x022f:
            java.util.List<a.d.c.w.c.d> r9 = r7.f3182b
            int r9 = r9.size()
            if (r4 >= r9) goto L_0x025c
            java.util.List<a.d.c.w.c.d> r9 = r7.f3182b
            int r9 = r9.size()
            r10 = 3
            if (r9 <= r10) goto L_0x025c
            java.util.List<a.d.c.w.c.d> r9 = r7.f3182b
            java.lang.Object r9 = r9.get(r4)
            a.d.c.w.c.d r9 = (a.d.c.w.c.d) r9
            float r9 = r9.f3179c
            float r9 = r9 - r8
            float r9 = java.lang.Math.abs(r9)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x025a
            java.util.List<a.d.c.w.c.d> r9 = r7.f3182b
            r9.remove(r4)
            int r4 = r4 + -1
        L_0x025a:
            int r4 = r4 + r5
            goto L_0x022f
        L_0x025c:
            java.util.List<a.d.c.w.c.d> r3 = r7.f3182b
            int r3 = r3.size()
            r4 = 3
            if (r3 <= r4) goto L_0x029d
            java.util.List<a.d.c.w.c.d> r3 = r7.f3182b
            java.util.Iterator r3 = r3.iterator()
        L_0x026b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x027b
            java.lang.Object r4 = r3.next()
            a.d.c.w.c.d r4 = (a.d.c.w.c.d) r4
            float r4 = r4.f3179c
            float r6 = r6 + r4
            goto L_0x026b
        L_0x027b:
            java.util.List<a.d.c.w.c.d> r3 = r7.f3182b
            int r3 = r3.size()
            float r3 = (float) r3
            float r6 = r6 / r3
            java.util.List<a.d.c.w.c.d> r3 = r7.f3182b
            a.d.c.w.c.e$b r4 = new a.d.c.w.c.e$b
            r8 = 0
            r4.<init>(r6, r8)
            java.util.Collections.sort(r3, r4)
            java.util.List<a.d.c.w.c.d> r3 = r7.f3182b
            int r4 = r3.size()
            r6 = 3
            java.util.List r3 = r3.subList(r6, r4)
            r3.clear()
            goto L_0x029e
        L_0x029d:
            r6 = 3
        L_0x029e:
            a.d.c.w.c.d[] r3 = new a.d.c.w.c.d[r6]
            java.util.List<a.d.c.w.c.d> r4 = r7.f3182b
            r6 = 0
            java.lang.Object r4 = r4.get(r6)
            a.d.c.w.c.d r4 = (a.d.c.w.c.d) r4
            r3[r6] = r4
            java.util.List<a.d.c.w.c.d> r4 = r7.f3182b
            java.lang.Object r4 = r4.get(r5)
            a.d.c.w.c.d r4 = (a.d.c.w.c.d) r4
            r3[r5] = r4
            java.util.List<a.d.c.w.c.d> r4 = r7.f3182b
            java.lang.Object r4 = r4.get(r13)
            a.d.c.w.c.d r4 = (a.d.c.w.c.d) r4
            r3[r13] = r4
            a.d.c.n.b(r3)
            a.d.c.w.c.f r4 = new a.d.c.w.c.f
            r4.<init>(r3)
            a.d.c.w.c.d r3 = r4.f3189b
            a.d.c.w.c.d r6 = r4.f3190c
            a.d.c.w.c.d r4 = r4.f3188a
            float r7 = r2.a(r3, r6)
            float r8 = r2.a(r3, r4)
            float r8 = r8 + r7
            r7 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r7
            r7 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x03e1
            float r9 = a.d.c.n.a(r3, r6)
            float r9 = r9 / r8
            r10 = 1056964608(0x3f000000, float:0.5)
            float r9 = r9 + r10
            int r9 = (int) r9
            float r11 = a.d.c.n.a(r3, r4)
            float r11 = r11 / r8
            float r11 = r11 + r10
            int r10 = (int) r11
            int r9 = r9 + r10
            int r5 = r9 >> 1
            int r5 = r5 + 7
            r9 = r5 & 3
            if (r9 == 0) goto L_0x0304
            if (r9 == r13) goto L_0x0301
            r10 = 3
            if (r9 == r10) goto L_0x02fe
            goto L_0x0306
        L_0x02fe:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0301:
            int r5 = r5 + -1
            goto L_0x0306
        L_0x0304:
            int r5 = r5 + 1
        L_0x0306:
            a.d.c.w.b.i r9 = a.d.c.w.b.i.d(r5)
            int r10 = r9.c()
            int r10 = r10 + -7
            int[] r9 = r9.f3164b
            int r9 = r9.length
            r11 = 1077936128(0x40400000, float:3.0)
            if (r9 <= 0) goto L_0x0343
            float r9 = r6.f2885a
            float r12 = r3.f2885a
            float r9 = r9 - r12
            float r13 = r4.f2885a
            float r9 = r9 + r13
            float r13 = r6.f2886b
            float r14 = r3.f2886b
            float r13 = r13 - r14
            float r15 = r4.f2886b
            float r13 = r13 + r15
            float r10 = (float) r10
            float r10 = r11 / r10
            float r7 = r7 - r10
            float r9 = a.a.a.a.a.a(r9, r12, r7, r12)
            int r9 = (int) r9
            float r7 = a.a.a.a.a.a(r13, r14, r7, r14)
            int r7 = (int) r7
            r10 = 4
        L_0x0336:
            r12 = 16
            if (r10 > r12) goto L_0x0343
            float r12 = (float) r10
            a.d.c.w.c.a r7 = r2.b(r8, r9, r7, r12)     // Catch:{ i -> 0x0340 }
            goto L_0x0344
        L_0x0340:
            int r10 = r10 << 1
            goto L_0x0336
        L_0x0343:
            r7 = 0
        L_0x0344:
            float r8 = (float) r5
            r9 = 1080033280(0x40600000, float:3.5)
            float r19 = r8 - r9
            if (r7 == 0) goto L_0x0358
            float r8 = r7.f2885a
            float r9 = r7.f2886b
            float r10 = r19 - r11
            r24 = r8
            r25 = r9
            r17 = r10
            goto L_0x036e
        L_0x0358:
            float r8 = r6.f2885a
            float r9 = r3.f2885a
            float r8 = r8 - r9
            float r9 = r4.f2885a
            float r8 = r8 + r9
            float r9 = r6.f2886b
            float r10 = r3.f2886b
            float r9 = r9 - r10
            float r10 = r4.f2886b
            float r9 = r9 + r10
            r24 = r8
            r25 = r9
            r17 = r19
        L_0x036e:
            r12 = 1080033280(0x40600000, float:3.5)
            r13 = 1080033280(0x40600000, float:3.5)
            r18 = 1080033280(0x40600000, float:3.5)
            float r8 = r3.f2885a
            float r9 = r3.f2886b
            float r10 = r6.f2885a
            float r11 = r6.f2886b
            float r14 = r4.f2885a
            float r15 = r4.f2886b
            r26 = r14
            r14 = r19
            r27 = r15
            r15 = 1080033280(0x40600000, float:3.5)
            r16 = r17
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            a.d.c.r.i r8 = a.d.c.r.i.a(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            a.d.c.r.b r2 = r2.f3177a
            a.d.c.r.f r9 = a.d.c.r.f.f2982a
            a.d.c.r.b r2 = r9.b(r2, r5, r5, r8)
            r5 = 3
            if (r7 != 0) goto L_0x03ad
            a.d.c.n[] r5 = new a.d.c.n[r5]
            r7 = 0
            r5[r7] = r4
            r4 = 1
            r5[r4] = r3
            r3 = 2
            r5[r3] = r6
            goto L_0x03bc
        L_0x03ad:
            r8 = 0
            r9 = 1
            r10 = 2
            r11 = 4
            a.d.c.n[] r11 = new a.d.c.n[r11]
            r11[r8] = r4
            r11[r9] = r3
            r11[r10] = r6
            r11[r5] = r7
            r5 = r11
        L_0x03bc:
            a.d.c.w.b.e r3 = r0.f3139a
            a.d.c.r.e r1 = r3.a(r2, r1)
            r2 = r5
        L_0x03c3:
            a.d.c.l r3 = new a.d.c.l
            java.lang.String r4 = r1.f2979b
            byte[] r5 = r1.f2978a
            a.d.c.a r6 = a.d.c.a.QR_CODE
            r3.<init>(r4, r5, r2, r6)
            java.util.List<byte[]> r2 = r1.f2980c
            if (r2 == 0) goto L_0x03d7
            a.d.c.m r4 = a.d.c.m.BYTE_SEGMENTS
            r3.a(r4, r2)
        L_0x03d7:
            java.lang.String r1 = r1.f2981d
            if (r1 == 0) goto L_0x03e0
            a.d.c.m r2 = a.d.c.m.ERROR_CORRECTION_LEVEL
            r3.a(r2, r1)
        L_0x03e0:
            return r3
        L_0x03e1:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x03e4:
            a.d.c.i r1 = a.d.c.i.f2874a
            goto L_0x03e8
        L_0x03e7:
            throw r1
        L_0x03e8:
            goto L_0x03e7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.w.a.a(a.d.c.c, java.util.Map):a.d.c.l");
    }

    public void reset() {
    }
}

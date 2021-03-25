package a.d.c.w.b;

import a.d.c.r.l.a;
import a.d.c.r.l.c;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final c f3147a = new c(a.l);

    /* JADX WARNING: Removed duplicated region for block: B:153:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0519 A[LOOP:21: B:117:0x0241->B:305:0x0519, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0502 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.r.e a(a.d.c.r.b r26, java.util.Map<a.d.c.e, ?> r27) {
        /*
            r25 = this;
            a.d.c.w.b.a r0 = new a.d.c.w.b.a
            r1 = r26
            r0.<init>(r1)
            a.d.c.w.b.i r1 = r0.c()
            a.d.c.w.b.g r2 = r0.b()
            a.d.c.w.b.f r2 = r2.f3155a
            a.d.c.w.b.g r3 = r0.b()
            a.d.c.w.b.i r4 = r0.c()
            byte r3 = r3.f3156b
            if (r3 < 0) goto L_0x0534
            r5 = 7
            if (r3 > r5) goto L_0x0534
            a.d.c.w.b.c[] r5 = a.d.c.w.b.c.f3145a
            r3 = r5[r3]
            a.d.c.r.b r5 = r0.f3140a
            int r6 = r5.f2967b
            if (r3 == 0) goto L_0x0532
            r7 = 0
            r8 = 0
        L_0x002c:
            r9 = 1
            if (r8 >= r6) goto L_0x0050
            r10 = 0
        L_0x0030:
            if (r10 >= r6) goto L_0x004d
            boolean r11 = r3.a(r8, r10)
            if (r11 == 0) goto L_0x004a
            int r11 = r5.f2968c
            int r11 = r11 * r8
            int r12 = r10 >> 5
            int r11 = r11 + r12
            int[] r12 = r5.f2969d
            r13 = r12[r11]
            r14 = r10 & 31
            int r14 = r9 << r14
            r13 = r13 ^ r14
            r12[r11] = r13
        L_0x004a:
            int r10 = r10 + 1
            goto L_0x0030
        L_0x004d:
            int r8 = r8 + 1
            goto L_0x002c
        L_0x0050:
            int r3 = r4.c()
            a.d.c.r.b r5 = new a.d.c.r.b
            r5.<init>(r3, r3)
            r8 = 9
            r5.e(r7, r7, r8, r8)
            int r10 = r3 + -8
            r11 = 8
            r5.e(r10, r7, r11, r8)
            r5.e(r7, r10, r8, r11)
            int[] r10 = r4.f3164b
            int r10 = r10.length
            r11 = 0
        L_0x006c:
            r12 = 5
            if (r11 >= r10) goto L_0x0096
            int[] r13 = r4.f3164b
            r13 = r13[r11]
            int r13 = r13 + -2
            r14 = 0
        L_0x0076:
            if (r14 >= r10) goto L_0x0093
            if (r11 != 0) goto L_0x0080
            if (r14 == 0) goto L_0x0090
            int r15 = r10 + -1
            if (r14 == r15) goto L_0x0090
        L_0x0080:
            int r15 = r10 + -1
            if (r11 != r15) goto L_0x0087
            if (r14 != 0) goto L_0x0087
            goto L_0x0090
        L_0x0087:
            int[] r15 = r4.f3164b
            r15 = r15[r14]
            int r15 = r15 + -2
            r5.e(r15, r13, r12, r12)
        L_0x0090:
            int r14 = r14 + 1
            goto L_0x0076
        L_0x0093:
            int r11 = r11 + 1
            goto L_0x006c
        L_0x0096:
            int r10 = r3 + -17
            r11 = 6
            r5.e(r11, r8, r9, r10)
            r5.e(r8, r11, r10, r9)
            int r8 = r4.f3163a
            r9 = 3
            if (r8 <= r11) goto L_0x00ac
            int r3 = r3 + -11
            r5.e(r3, r7, r9, r11)
            r5.e(r7, r3, r11, r9)
        L_0x00ac:
            int r3 = r4.f3166d
            byte[] r7 = new byte[r3]
            int r8 = r6 + -1
            r9 = 0
            r10 = 1
            r12 = 0
            r13 = 0
            r14 = r8
        L_0x00b7:
            r15 = 2
            if (r14 <= 0) goto L_0x011b
            if (r14 != r11) goto L_0x00be
            int r14 = r14 + -1
        L_0x00be:
            r11 = 0
        L_0x00bf:
            if (r11 >= r6) goto L_0x010f
            if (r10 == 0) goto L_0x00cc
            int r16 = r8 - r11
            r24 = r16
            r16 = r6
            r6 = r24
            goto L_0x00cf
        L_0x00cc:
            r16 = r6
            r6 = r11
        L_0x00cf:
            r17 = 0
            r26 = r8
            r8 = 0
        L_0x00d4:
            if (r8 >= r15) goto L_0x0105
            int r15 = r14 - r8
            boolean r17 = r5.a(r15, r6)
            if (r17 != 0) goto L_0x00fd
            int r12 = r12 + 1
            int r13 = r13 << 1
            r17 = r5
            a.d.c.r.b r5 = r0.f3140a
            boolean r5 = r5.a(r15, r6)
            if (r5 == 0) goto L_0x00ee
            r13 = r13 | 1
        L_0x00ee:
            r5 = 8
            if (r12 != r5) goto L_0x00ff
            int r5 = r9 + 1
            byte r12 = (byte) r13
            r7[r9] = r12
            r9 = 0
            r12 = 0
            r9 = r5
            r12 = 0
            r13 = 0
            goto L_0x00ff
        L_0x00fd:
            r17 = r5
        L_0x00ff:
            int r8 = r8 + 1
            r15 = 2
            r5 = r17
            goto L_0x00d4
        L_0x0105:
            r17 = r5
            int r11 = r11 + 1
            r15 = 2
            r8 = r26
            r6 = r16
            goto L_0x00bf
        L_0x010f:
            r17 = r5
            r16 = r6
            r26 = r8
            r10 = r10 ^ 1
            int r14 = r14 + -2
            r11 = 6
            goto L_0x00b7
        L_0x011b:
            int r0 = r4.f3166d
            if (r9 != r0) goto L_0x052f
            int r0 = r1.f3166d
            if (r3 != r0) goto L_0x0529
            a.d.c.w.b.i$b[] r0 = r1.f3165c
            int r3 = r2.ordinal()
            r0 = r0[r3]
            a.d.c.w.b.i$a[] r3 = r0.f3170b
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x0130:
            if (r5 >= r4) goto L_0x013a
            r8 = r3[r5]
            int r8 = r8.f3167a
            int r6 = r6 + r8
            int r5 = r5 + 1
            goto L_0x0130
        L_0x013a:
            a.d.c.w.b.b[] r4 = new a.d.c.w.b.b[r6]
            int r5 = r3.length
            r8 = 0
            r9 = 0
        L_0x013f:
            if (r8 >= r5) goto L_0x015f
            r10 = r3[r8]
            r11 = 0
        L_0x0144:
            int r12 = r10.f3167a
            if (r11 >= r12) goto L_0x015c
            int r12 = r10.f3168b
            int r13 = r0.f3169a
            int r13 = r13 + r12
            int r14 = r9 + 1
            a.d.c.w.b.b r15 = new a.d.c.w.b.b
            byte[] r13 = new byte[r13]
            r15.<init>(r12, r13)
            r4[r9] = r15
            int r11 = r11 + 1
            r9 = r14
            goto L_0x0144
        L_0x015c:
            int r8 = r8 + 1
            goto L_0x013f
        L_0x015f:
            r3 = 0
            r3 = r4[r3]
            byte[] r3 = r3.f3144b
            int r3 = r3.length
            int r5 = r6 + -1
        L_0x0167:
            if (r5 < 0) goto L_0x0174
            r8 = r4[r5]
            byte[] r8 = r8.f3144b
            int r8 = r8.length
            if (r8 != r3) goto L_0x0171
            goto L_0x0174
        L_0x0171:
            int r5 = r5 + -1
            goto L_0x0167
        L_0x0174:
            int r5 = r5 + 1
            int r0 = r0.f3169a
            int r3 = r3 - r0
            r0 = 0
            r8 = 0
        L_0x017b:
            if (r8 >= r3) goto L_0x0191
            r10 = 0
        L_0x017e:
            if (r10 >= r9) goto L_0x018e
            r11 = r4[r10]
            byte[] r11 = r11.f3144b
            int r12 = r0 + 1
            byte r0 = r7[r0]
            r11[r8] = r0
            int r10 = r10 + 1
            r0 = r12
            goto L_0x017e
        L_0x018e:
            int r8 = r8 + 1
            goto L_0x017b
        L_0x0191:
            r8 = r5
        L_0x0192:
            if (r8 >= r9) goto L_0x01a2
            r10 = r4[r8]
            byte[] r10 = r10.f3144b
            int r11 = r0 + 1
            byte r0 = r7[r0]
            r10[r3] = r0
            int r8 = r8 + 1
            r0 = r11
            goto L_0x0192
        L_0x01a2:
            r8 = 0
            r8 = r4[r8]
            byte[] r8 = r8.f3144b
            int r8 = r8.length
        L_0x01a8:
            if (r3 >= r8) goto L_0x01c4
            r10 = 0
        L_0x01ab:
            if (r10 >= r9) goto L_0x01c1
            if (r10 >= r5) goto L_0x01b1
            r11 = r3
            goto L_0x01b3
        L_0x01b1:
            int r11 = r3 + 1
        L_0x01b3:
            r12 = r4[r10]
            byte[] r12 = r12.f3144b
            int r13 = r0 + 1
            byte r0 = r7[r0]
            r12[r11] = r0
            int r10 = r10 + 1
            r0 = r13
            goto L_0x01ab
        L_0x01c1:
            int r3 = r3 + 1
            goto L_0x01a8
        L_0x01c4:
            r0 = 0
            r3 = 0
        L_0x01c6:
            if (r0 >= r6) goto L_0x01d0
            r5 = r4[r0]
            int r5 = r5.f3143a
            int r3 = r3 + r5
            int r0 = r0 + 1
            goto L_0x01c6
        L_0x01d0:
            byte[] r0 = new byte[r3]
            r3 = 0
            r5 = 0
        L_0x01d4:
            if (r3 >= r6) goto L_0x0212
            r7 = r4[r3]
            byte[] r8 = r7.f3144b
            int r7 = r7.f3143a
            int r9 = r8.length
            int[] r10 = new int[r9]
            r11 = 0
        L_0x01e0:
            if (r11 >= r9) goto L_0x01eb
            byte r12 = r8[r11]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r10[r11] = r12
            int r11 = r11 + 1
            goto L_0x01e0
        L_0x01eb:
            int r9 = r8.length
            int r9 = r9 - r7
            r11 = r25
            a.d.c.r.l.c r12 = r11.f3147a     // Catch:{ d -> 0x020f }
            r12.a(r10, r9)     // Catch:{ d -> 0x020f }
            r9 = 0
        L_0x01f5:
            if (r9 >= r7) goto L_0x01ff
            r12 = r10[r9]
            byte r12 = (byte) r12
            r8[r9] = r12
            int r9 = r9 + 1
            goto L_0x01f5
        L_0x01ff:
            r9 = 0
        L_0x0200:
            if (r9 >= r7) goto L_0x020c
            int r10 = r5 + 1
            byte r12 = r8[r9]
            r0[r5] = r12
            int r9 = r9 + 1
            r5 = r10
            goto L_0x0200
        L_0x020c:
            int r3 = r3 + 1
            goto L_0x01d4
        L_0x020f:
            a.d.c.d r0 = a.d.c.d.f2863a
            throw r0
        L_0x0212:
            r11 = r25
            a.d.c.w.b.h r3 = a.d.c.w.b.h.HANZI
            a.d.c.w.b.h r4 = a.d.c.w.b.h.FNC1_SECOND_POSITION
            a.d.c.w.b.h r5 = a.d.c.w.b.h.KANJI
            a.d.c.w.b.h r6 = a.d.c.w.b.h.ECI
            a.d.c.w.b.h r7 = a.d.c.w.b.h.FNC1_FIRST_POSITION
            a.d.c.w.b.h r8 = a.d.c.w.b.h.BYTE
            a.d.c.w.b.h r9 = a.d.c.w.b.h.STRUCTURED_APPEND
            a.d.c.w.b.h r10 = a.d.c.w.b.h.ALPHANUMERIC
            a.d.c.w.b.h r12 = a.d.c.w.b.h.NUMERIC
            a.d.c.w.b.h r13 = a.d.c.w.b.h.TERMINATOR
            a.d.c.r.c r14 = new a.d.c.r.c
            r14.<init>(r0)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r11 = 50
            r15.<init>(r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r16 = r0
            r0 = 1
            r11.<init>(r0)
            r0 = 0
            r17 = 0
            r26 = r2
        L_0x0241:
            int r2 = r14.a()
            r18 = r5
            r5 = 4
            if (r2 >= r5) goto L_0x024b
            goto L_0x0288
        L_0x024b:
            int r2 = r14.b(r5)     // Catch:{ IllegalArgumentException -> 0x0526 }
            if (r2 == 0) goto L_0x0288
            r5 = 1
            if (r2 == r5) goto L_0x0286
            r5 = 2
            if (r2 == r5) goto L_0x0284
            r5 = 3
            if (r2 == r5) goto L_0x0282
            r5 = 4
            if (r2 == r5) goto L_0x0280
            r5 = 5
            if (r2 == r5) goto L_0x027e
            r5 = 7
            if (r2 == r5) goto L_0x027c
            r5 = 8
            if (r2 == r5) goto L_0x0279
            r5 = 9
            if (r2 == r5) goto L_0x0277
            r5 = 13
            if (r2 != r5) goto L_0x0271
            r2 = r3
            goto L_0x0289
        L_0x0271:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0526 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x0526 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0526 }
        L_0x0277:
            r2 = r4
            goto L_0x0289
        L_0x0279:
            r2 = r18
            goto L_0x0289
        L_0x027c:
            r2 = r6
            goto L_0x0289
        L_0x027e:
            r2 = r7
            goto L_0x0289
        L_0x0280:
            r2 = r8
            goto L_0x0289
        L_0x0282:
            r2 = r9
            goto L_0x0289
        L_0x0284:
            r2 = r10
            goto L_0x0289
        L_0x0286:
            r2 = r12
            goto L_0x0289
        L_0x0288:
            r2 = r13
        L_0x0289:
            if (r2 == r13) goto L_0x04f0
            if (r2 == r7) goto L_0x04e0
            if (r2 != r4) goto L_0x0291
            goto L_0x04e0
        L_0x0291:
            r5 = 16
            if (r2 != r9) goto L_0x029a
            r14.b(r5)
            goto L_0x04f0
        L_0x029a:
            if (r2 != r6) goto L_0x02e7
            r5 = 8
            int r5 = r14.b(r5)
            r19 = r4
            r4 = r5 & 128(0x80, float:1.794E-43)
            if (r4 != 0) goto L_0x02ad
            r4 = r5 & 127(0x7f, float:1.78E-43)
            r20 = r6
            goto L_0x02d0
        L_0x02ad:
            r4 = r5 & 192(0xc0, float:2.69E-43)
            r20 = r6
            r6 = 128(0x80, float:1.794E-43)
            if (r4 != r6) goto L_0x02c0
            r4 = 8
            int r4 = r14.b(r4)
            r5 = r5 & 63
            r6 = 8
            goto L_0x02ce
        L_0x02c0:
            r4 = r5 & 224(0xe0, float:3.14E-43)
            r6 = 192(0xc0, float:2.69E-43)
            if (r4 != r6) goto L_0x02db
            r6 = 16
            int r4 = r14.b(r6)
            r5 = r5 & 31
        L_0x02ce:
            int r5 = r5 << r6
            r4 = r4 | r5
        L_0x02d0:
            a.d.c.r.d r17 = a.d.c.r.d.f(r4)
            if (r17 == 0) goto L_0x02d8
            goto L_0x0354
        L_0x02d8:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x02db:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Bad ECI bits starting with byte "
            java.lang.String r1 = a.a.a.a.a.h(r1, r5)
            r0.<init>(r1)
            throw r0
        L_0x02e7:
            r19 = r4
            r20 = r6
            if (r2 != r3) goto L_0x035c
            r4 = 4
            int r4 = r14.b(r4)
            int r5 = r2.f(r1)
            int r5 = r14.b(r5)
            r6 = 1
            if (r4 != r6) goto L_0x0354
            int r4 = r5 * 13
            int r6 = r14.a()
            if (r4 > r6) goto L_0x0351
            int r4 = r5 * 2
            byte[] r4 = new byte[r4]
            r6 = 0
        L_0x030a:
            r21 = r3
            if (r5 <= 0) goto L_0x0341
            r3 = 13
            int r3 = r14.b(r3)
            int r22 = r3 / 96
            int r22 = r22 << 8
            int r3 = r3 % 96
            r3 = r3 | r22
            r22 = r7
            r7 = 959(0x3bf, float:1.344E-42)
            if (r3 >= r7) goto L_0x0326
            r7 = 41377(0xa1a1, float:5.7982E-41)
            goto L_0x0329
        L_0x0326:
            r7 = 42657(0xa6a1, float:5.9775E-41)
        L_0x0329:
            int r3 = r3 + r7
            int r7 = r3 >> 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r4[r6] = r7
            int r7 = r6 + 1
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r4[r7] = r3
            int r6 = r6 + 2
            int r5 = r5 + -1
            r3 = r21
            r7 = r22
            goto L_0x030a
        L_0x0341:
            r22 = r7
            java.lang.String r3 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x034e }
            java.lang.String r5 = "GB2312"
            r3.<init>(r4, r5)     // Catch:{ UnsupportedEncodingException -> 0x034e }
            r15.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x034e }
            goto L_0x0358
        L_0x034e:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x0351:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x0354:
            r21 = r3
            r22 = r7
        L_0x0358:
            r5 = r27
            goto L_0x0477
        L_0x035c:
            r21 = r3
            r22 = r7
            int r3 = r2.f(r1)
            int r3 = r14.b(r3)
            if (r2 != r12) goto L_0x03e5
        L_0x036a:
            r4 = 10
            r5 = 3
            if (r3 < r5) goto L_0x03a2
            int r5 = r14.a()
            if (r5 < r4) goto L_0x039f
            int r5 = r14.b(r4)
            r6 = 1000(0x3e8, float:1.401E-42)
            if (r5 >= r6) goto L_0x039c
            int r6 = r5 / 100
            char r6 = a.d.c.w.b.d.a(r6)
            r15.append(r6)
            int r6 = r5 / 10
            int r6 = r6 % r4
            char r4 = a.d.c.w.b.d.a(r6)
            r15.append(r4)
            int r5 = r5 % 10
            char r4 = a.d.c.w.b.d.a(r5)
            r15.append(r4)
            int r3 = r3 + -3
            goto L_0x036a
        L_0x039c:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x039f:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x03a2:
            r5 = 2
            if (r3 != r5) goto L_0x03c6
            int r3 = r14.a()
            r4 = 7
            if (r3 < r4) goto L_0x03c3
            int r3 = r14.b(r4)
            r4 = 100
            if (r3 >= r4) goto L_0x03c0
            int r4 = r3 / 10
            char r4 = a.d.c.w.b.d.a(r4)
            r15.append(r4)
            int r3 = r3 % 10
            goto L_0x03d6
        L_0x03c0:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x03c3:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x03c6:
            r5 = 1
            if (r3 != r5) goto L_0x0358
            int r3 = r14.a()
            r5 = 4
            if (r3 < r5) goto L_0x03e2
            int r3 = r14.b(r5)
            if (r3 >= r4) goto L_0x03df
        L_0x03d6:
            char r3 = a.d.c.w.b.d.a(r3)
            r15.append(r3)
            goto L_0x0358
        L_0x03df:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x03e2:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x03e5:
            if (r2 != r10) goto L_0x0444
            int r4 = r15.length()
        L_0x03eb:
            r5 = 1
            if (r3 <= r5) goto L_0x0409
            r5 = 11
            int r5 = r14.b(r5)
            int r6 = r5 / 45
            char r6 = a.d.c.w.b.d.a(r6)
            r15.append(r6)
            int r5 = r5 % 45
            char r5 = a.d.c.w.b.d.a(r5)
            r15.append(r5)
            int r3 = r3 + -2
            goto L_0x03eb
        L_0x0409:
            r5 = 1
            r6 = 6
            if (r3 != r5) goto L_0x0418
            int r3 = r14.b(r6)
            char r3 = a.d.c.w.b.d.a(r3)
            r15.append(r3)
        L_0x0418:
            if (r0 == 0) goto L_0x0358
        L_0x041a:
            int r3 = r15.length()
            if (r4 >= r3) goto L_0x0358
            char r3 = r15.charAt(r4)
            r5 = 37
            if (r3 != r5) goto L_0x0441
            int r3 = r15.length()
            int r3 = r3 + -1
            if (r4 >= r3) goto L_0x043c
            int r3 = r4 + 1
            char r6 = r15.charAt(r3)
            if (r6 != r5) goto L_0x043c
            r15.deleteCharAt(r3)
            goto L_0x0441
        L_0x043c:
            r3 = 29
            r15.setCharAt(r4, r3)
        L_0x0441:
            int r4 = r4 + 1
            goto L_0x041a
        L_0x0444:
            if (r2 != r8) goto L_0x0485
            int r4 = r3 << 3
            int r5 = r14.a()
            if (r4 > r5) goto L_0x0482
            byte[] r4 = new byte[r3]
            r5 = 0
        L_0x0451:
            if (r5 >= r3) goto L_0x045f
            r6 = 8
            int r6 = r14.b(r6)
            byte r6 = (byte) r6
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x0451
        L_0x045f:
            r5 = r27
            if (r17 != 0) goto L_0x0468
            java.lang.String r3 = a.d.c.r.j.a(r4, r5)
            goto L_0x046c
        L_0x0468:
            java.lang.String r3 = r17.name()
        L_0x046c:
            java.lang.String r6 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x047f }
            r6.<init>(r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x047f }
            r15.append(r6)     // Catch:{ UnsupportedEncodingException -> 0x047f }
            r11.add(r4)
        L_0x0477:
            r23 = r1
        L_0x0479:
            r4 = r18
            r18 = r0
            goto L_0x04fe
        L_0x047f:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x0482:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x0485:
            r5 = r27
            r4 = r18
            if (r2 != r4) goto L_0x04dd
            int r6 = r3 * 13
            int r7 = r14.a()
            if (r6 > r7) goto L_0x04da
            int r6 = r3 * 2
            byte[] r6 = new byte[r6]
            r7 = 0
        L_0x0498:
            r18 = r0
            if (r3 <= 0) goto L_0x04ca
            r0 = 13
            int r0 = r14.b(r0)
            r23 = r1
            int r1 = r0 / 192
            int r1 = r1 << 8
            int r0 = r0 % 192
            r0 = r0 | r1
            r1 = 7936(0x1f00, float:1.1121E-41)
            if (r0 >= r1) goto L_0x04b3
            r1 = 33088(0x8140, float:4.6366E-41)
            goto L_0x04b6
        L_0x04b3:
            r1 = 49472(0xc140, float:6.9325E-41)
        L_0x04b6:
            int r0 = r0 + r1
            int r1 = r0 >> 8
            byte r1 = (byte) r1
            r6[r7] = r1
            int r1 = r7 + 1
            byte r0 = (byte) r0
            r6[r1] = r0
            int r7 = r7 + 2
            int r3 = r3 + -1
            r0 = r18
            r1 = r23
            goto L_0x0498
        L_0x04ca:
            r23 = r1
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x04d7 }
            java.lang.String r1 = "SJIS"
            r0.<init>(r6, r1)     // Catch:{ UnsupportedEncodingException -> 0x04d7 }
            r15.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x04d7 }
            goto L_0x04fe
        L_0x04d7:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x04da:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x04dd:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x04e0:
            r5 = r27
            r23 = r1
            r21 = r3
            r19 = r4
            r20 = r6
            r22 = r7
            r4 = r18
            r0 = 1
            goto L_0x0500
        L_0x04f0:
            r5 = r27
            r23 = r1
            r21 = r3
            r19 = r4
            r20 = r6
            r22 = r7
            goto L_0x0479
        L_0x04fe:
            r0 = r18
        L_0x0500:
            if (r2 != r13) goto L_0x0519
            a.d.c.r.e r0 = new a.d.c.r.e
            java.lang.String r1 = r15.toString()
            boolean r2 = r11.isEmpty()
            if (r2 == 0) goto L_0x050f
            r11 = 0
        L_0x050f:
            java.lang.String r2 = r26.toString()
            r3 = r16
            r0.<init>(r3, r1, r11, r2)
            return r0
        L_0x0519:
            r5 = r4
            r4 = r19
            r6 = r20
            r3 = r21
            r7 = r22
            r1 = r23
            goto L_0x0241
        L_0x0526:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x0529:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x052f:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x0532:
            r0 = 0
            throw r0
        L_0x0534:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            goto L_0x053b
        L_0x053a:
            throw r0
        L_0x053b:
            goto L_0x053a
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.w.b.e.a(a.d.c.r.b, java.util.Map):a.d.c.r.e");
    }
}

package a.d.a.a.h.g;

import a.c.a.f.b;

public final class v8 extends r8 {
    public static int d(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return q8.a(i);
        }
        if (i2 == 1) {
            return q8.b(i, n8.a(bArr, j));
        }
        if (i2 == 2) {
            return q8.e(i, n8.a(bArr, j), n8.a(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b6, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(int r16, byte[] r17, int r18, int r19) {
        /*
            r15 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r1 | r2
            int r4 = r0.length
            int r4 = r4 - r2
            r3 = r3 | r4
            r4 = 2
            r5 = 3
            r6 = 0
            if (r3 < 0) goto L_0x00b7
            long r7 = (long) r1
            long r1 = (long) r2
            long r1 = r1 - r7
            int r2 = (int) r1
            r1 = 16
            r9 = 1
            if (r2 >= r1) goto L_0x001c
            r1 = 0
            goto L_0x002e
        L_0x001c:
            r11 = r7
            r1 = 0
        L_0x001e:
            if (r1 >= r2) goto L_0x002d
            long r13 = r11 + r9
            byte r3 = a.d.a.a.h.g.n8.a(r0, r11)
            if (r3 >= 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            int r1 = r1 + 1
            r11 = r13
            goto L_0x001e
        L_0x002d:
            r1 = r2
        L_0x002e:
            int r2 = r2 - r1
            long r11 = (long) r1
            long r7 = r7 + r11
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r2 <= 0) goto L_0x0041
            long r11 = r7 + r9
            byte r1 = a.d.a.a.h.g.n8.a(r0, r7)
            if (r1 < 0) goto L_0x0040
            int r2 = r2 + -1
            r7 = r11
            goto L_0x0032
        L_0x0040:
            r7 = r11
        L_0x0041:
            if (r2 != 0) goto L_0x0044
            return r6
        L_0x0044:
            int r2 = r2 + -1
            r3 = -32
            r11 = -65
            r12 = -1
            if (r1 >= r3) goto L_0x0062
            if (r2 != 0) goto L_0x0050
            return r1
        L_0x0050:
            int r2 = r2 + -1
            r3 = -62
            if (r1 < r3) goto L_0x0061
            long r13 = r7 + r9
            byte r1 = a.d.a.a.h.g.n8.a(r0, r7)
            if (r1 <= r11) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r7 = r13
            goto L_0x0031
        L_0x0061:
            return r12
        L_0x0062:
            r13 = -16
            if (r1 >= r13) goto L_0x008c
            if (r2 >= r4) goto L_0x006d
            int r0 = d(r0, r1, r7, r2)
            return r0
        L_0x006d:
            int r2 = r2 + -2
            long r13 = r7 + r9
            byte r7 = a.d.a.a.h.g.n8.a(r0, r7)
            if (r7 > r11) goto L_0x008b
            r8 = -96
            if (r1 != r3) goto L_0x007d
            if (r7 < r8) goto L_0x008b
        L_0x007d:
            r3 = -19
            if (r1 != r3) goto L_0x0083
            if (r7 >= r8) goto L_0x008b
        L_0x0083:
            long r7 = r13 + r9
            byte r1 = a.d.a.a.h.g.n8.a(r0, r13)
            if (r1 <= r11) goto L_0x0031
        L_0x008b:
            return r12
        L_0x008c:
            if (r2 >= r5) goto L_0x0093
            int r0 = d(r0, r1, r7, r2)
            return r0
        L_0x0093:
            int r2 = r2 + -3
            long r13 = r7 + r9
            byte r3 = a.d.a.a.h.g.n8.a(r0, r7)
            if (r3 > r11) goto L_0x00b6
            int r1 = r1 << 28
            int r3 = r3 + 112
            int r3 = r3 + r1
            int r1 = r3 >> 30
            if (r1 != 0) goto L_0x00b6
            long r7 = r13 + r9
            byte r1 = a.d.a.a.h.g.n8.a(r0, r13)
            if (r1 > r11) goto L_0x00b6
            long r13 = r7 + r9
            byte r1 = a.d.a.a.h.g.n8.a(r0, r7)
            if (r1 <= r11) goto L_0x005f
        L_0x00b6:
            return r12
        L_0x00b7:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.Object[] r5 = new java.lang.Object[r5]
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5[r6] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            r1 = 1
            r5[r1] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            r5[r4] = r0
            java.lang.String r0 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            r3.<init>(r0)
            goto L_0x00da
        L_0x00d9:
            throw r3
        L_0x00da:
            goto L_0x00d9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.v8.a(int, byte[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00fb, LOOP_START, PHI: r2 r3 r4 r11 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(java.lang.CharSequence r23, byte[] r24, int r25, int r26) {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            long r4 = (long) r2
            long r6 = (long) r3
            long r6 = r6 + r4
            int r8 = r23.length()
            java.lang.String r9 = " at index "
            java.lang.String r10 = "Failed writing "
            if (r8 > r3) goto L_0x0146
            int r11 = r1.length
            int r11 = r11 - r3
            if (r11 < r2) goto L_0x0146
            r2 = 0
        L_0x001a:
            r3 = 128(0x80, float:1.794E-43)
            r11 = 1
            if (r2 >= r8) goto L_0x002f
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x002f
            long r11 = r11 + r4
            byte r3 = (byte) r13
            a.d.a.a.h.g.n8.g(r1, r4, r3)
            int r2 = r2 + 1
            r4 = r11
            goto L_0x001a
        L_0x002f:
            if (r2 != r8) goto L_0x0033
            int r0 = (int) r4
            return r0
        L_0x0033:
            if (r2 >= r8) goto L_0x0144
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x004b
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 >= 0) goto L_0x004b
            long r14 = r4 + r11
            byte r13 = (byte) r13
            a.d.a.a.h.g.n8.g(r1, r4, r13)
            r4 = r11
            r12 = r14
        L_0x0047:
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x00fb
        L_0x004b:
            r14 = 2048(0x800, float:2.87E-42)
            if (r13 >= r14) goto L_0x0075
            r14 = 2
            long r14 = r6 - r14
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 > 0) goto L_0x0075
            long r14 = r4 + r11
            int r3 = r13 >>> 6
            r3 = r3 | 960(0x3c0, float:1.345E-42)
            byte r3 = (byte) r3
            a.d.a.a.h.g.n8.g(r1, r4, r3)
            long r3 = r14 + r11
            r5 = r13 & 63
            r13 = 128(0x80, float:1.794E-43)
            r5 = r5 | r13
            byte r5 = (byte) r5
            a.d.a.a.h.g.n8.g(r1, r14, r5)
            r20 = r11
            r11 = 128(0x80, float:1.794E-43)
            r12 = r3
            r4 = r20
            goto L_0x00fb
        L_0x0075:
            r3 = 57343(0xdfff, float:8.0355E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r13 < r14) goto L_0x007f
            if (r3 >= r13) goto L_0x00ae
        L_0x007f:
            r15 = 3
            long r15 = r6 - r15
            int r17 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r17 > 0) goto L_0x00ae
            long r14 = r4 + r11
            int r3 = r13 >>> 12
            r3 = r3 | 480(0x1e0, float:6.73E-43)
            byte r3 = (byte) r3
            a.d.a.a.h.g.n8.g(r1, r4, r3)
            long r3 = r14 + r11
            int r5 = r13 >>> 6
            r5 = r5 & 63
            r11 = 128(0x80, float:1.794E-43)
            r5 = r5 | r11
            byte r5 = (byte) r5
            a.d.a.a.h.g.n8.g(r1, r14, r5)
            r14 = 1
            long r18 = r3 + r14
            r5 = r13 & 63
            r5 = r5 | r11
            byte r5 = (byte) r5
            a.d.a.a.h.g.n8.g(r1, r3, r5)
            r12 = r18
            r4 = 1
            goto L_0x0047
        L_0x00ae:
            r11 = 4
            long r11 = r6 - r11
            int r15 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r15 > 0) goto L_0x010f
            int r3 = r2 + 1
            if (r3 == r8) goto L_0x0107
            char r2 = r0.charAt(r3)
            boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
            if (r11 == 0) goto L_0x0106
            int r2 = java.lang.Character.toCodePoint(r13, r2)
            r11 = 1
            long r13 = r4 + r11
            int r15 = r2 >>> 18
            r15 = r15 | 240(0xf0, float:3.36E-43)
            byte r15 = (byte) r15
            a.d.a.a.h.g.n8.g(r1, r4, r15)
            long r4 = r13 + r11
            int r15 = r2 >>> 12
            r15 = r15 & 63
            r11 = 128(0x80, float:1.794E-43)
            r12 = r15 | 128(0x80, float:1.794E-43)
            byte r12 = (byte) r12
            a.d.a.a.h.g.n8.g(r1, r13, r12)
            r12 = 1
            long r14 = r4 + r12
            int r16 = r2 >>> 6
            r12 = r16 & 63
            r12 = r12 | r11
            byte r12 = (byte) r12
            a.d.a.a.h.g.n8.g(r1, r4, r12)
            r4 = 1
            long r12 = r14 + r4
            r2 = r2 & 63
            r2 = r2 | r11
            byte r2 = (byte) r2
            a.d.a.a.h.g.n8.g(r1, r14, r2)
            r2 = r3
        L_0x00fb:
            int r2 = r2 + 1
            r3 = 128(0x80, float:1.794E-43)
            r20 = r4
            r4 = r12
            r11 = r20
            goto L_0x0033
        L_0x0106:
            r2 = r3
        L_0x0107:
            a.d.a.a.h.g.s8 r0 = new a.d.a.a.h.g.s8
            int r2 = r2 + -1
            r0.<init>(r2, r8)
            throw r0
        L_0x010f:
            if (r14 > r13) goto L_0x0127
            if (r13 > r3) goto L_0x0127
            int r1 = r2 + 1
            if (r1 == r8) goto L_0x0121
            char r0 = r0.charAt(r1)
            boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
            if (r0 != 0) goto L_0x0127
        L_0x0121:
            a.d.a.a.h.g.s8 r0 = new a.d.a.a.h.g.s8
            r0.<init>(r2, r8)
            throw r0
        L_0x0127:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r10)
            r2.append(r13)
            r2.append(r9)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0144:
            int r0 = (int) r4
            return r0
        L_0x0146:
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
            int r8 = r8 + -1
            char r0 = r0.charAt(r8)
            int r2 = r2 + r3
            r3 = 37
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r10)
            r4.append(r0)
            r4.append(r9)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r1.<init>(r0)
            goto L_0x016b
        L_0x016a:
            throw r1
        L_0x016b:
            goto L_0x016a
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.v8.b(java.lang.CharSequence, byte[], int, int):int");
    }

    public final String c(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r13 < i3) {
                byte a2 = n8.a(bArr, (long) r13);
                if (!b.p1(a2)) {
                    break;
                }
                i = r13 + 1;
                cArr[i4] = (char) a2;
                i4++;
            }
            int i5 = i4;
            while (r13 < i3) {
                int i6 = r13 + 1;
                byte a3 = n8.a(bArr, (long) r13);
                if (b.p1(a3)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) a3;
                    r13 = i6;
                    while (true) {
                        i5 = i7;
                        if (r13 >= i3) {
                            break;
                        }
                        byte a4 = n8.a(bArr, (long) r13);
                        if (!b.p1(a4)) {
                            break;
                        }
                        r13++;
                        i7 = i5 + 1;
                        cArr[i5] = (char) a4;
                    }
                } else {
                    if (!(a3 < -32)) {
                        if (a3 < -16) {
                            if (i6 < i3 - 1) {
                                int i8 = i6 + 1;
                                b.f1(a3, n8.a(bArr, (long) i6), n8.a(bArr, (long) i8), cArr, i5);
                                r13 = i8 + 1;
                                i5++;
                            } else {
                                throw i6.f();
                            }
                        } else if (i6 < i3 - 2) {
                            int i9 = i6 + 1;
                            byte a5 = n8.a(bArr, (long) i6);
                            int i10 = i9 + 1;
                            b.e1(a3, a5, n8.a(bArr, (long) i9), n8.a(bArr, (long) i10), cArr, i5);
                            i5 = i5 + 1 + 1;
                            r13 = i10 + 1;
                        } else {
                            throw i6.f();
                        }
                    } else if (i6 < i3) {
                        b.g1(a3, n8.a(bArr, (long) i6), cArr, i5);
                        r13 = i6 + 1;
                        i5++;
                    } else {
                        throw i6.f();
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }
}

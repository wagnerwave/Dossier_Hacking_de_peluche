package a.d.a.a.h.g;

import a.c.a.d.a;

public final class q2 {

    /* renamed from: a  reason: collision with root package name */
    public static final u2<t3<String, String>> f1893a = a.v(p2.f1881a);

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r6v0 ?, r6v1 ?, r6v4 ?, r6v5 ?, r6v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public static final a.d.a.a.h.g.t3 a() {
        /*
            a.d.a.a.h.g.c3 r0 = new a.d.a.a.h.g.c3
            r0.<init>()
            java.util.Set r0 = r0.entrySet()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0013
            a.d.a.a.h.g.l3 r0 = a.d.a.a.h.g.l3.f1799b
            goto L_0x01f9
        L_0x0013:
            int r1 = r0.size()
            int r1 = r1 * 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
            r4 = 0
        L_0x0021:
            boolean r5 = r0.hasNext()
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x010d
            java.lang.Object r5 = r0.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r8 = r5.getKey()
            java.lang.Object r5 = r5.getValue()
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r9 = r5 instanceof a.d.a.a.h.g.u3
            if (r9 == 0) goto L_0x004c
            boolean r9 = r5 instanceof java.util.SortedSet
            if (r9 != 0) goto L_0x004c
            r9 = r5
            a.d.a.a.h.g.u3 r9 = (a.d.a.a.h.g.u3) r9
            boolean r10 = r9.m()
            if (r10 != 0) goto L_0x004c
            goto L_0x00c9
        L_0x004c:
            java.lang.Object[] r5 = r5.toArray()
            int r9 = r5.length
        L_0x0051:
            if (r9 == 0) goto L_0x00c7
            if (r9 == r7) goto L_0x00be
            int r10 = a.d.a.a.h.g.u3.n(r9)
            java.lang.Object[] r14 = new java.lang.Object[r10]
            int r15 = r10 + -1
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0060:
            if (r11 >= r9) goto L_0x008d
            r2 = r5[r11]
            a.c.a.f.b.Y0(r2, r11)
            int r16 = r2.hashCode()
            int r17 = a.c.a.d.a.r(r16)
        L_0x006f:
            r18 = r17 & r15
            r7 = r14[r18]
            if (r7 != 0) goto L_0x007f
            int r7 = r12 + 1
            r5[r12] = r2
            r14[r18] = r2
            int r13 = r13 + r16
            r12 = r7
            goto L_0x0089
        L_0x007f:
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x0089
            int r17 = r17 + 1
            r7 = 1
            goto L_0x006f
        L_0x0089:
            int r11 = r11 + 1
            r7 = 1
            goto L_0x0060
        L_0x008d:
            java.util.Arrays.fill(r5, r12, r9, r6)
            r2 = 1
            if (r12 != r2) goto L_0x009c
            r2 = 0
            r5 = r5[r2]
            a.d.a.a.h.g.f4 r9 = new a.d.a.a.h.g.f4
            r9.<init>(r5, r13)
            goto L_0x00c9
        L_0x009c:
            int r2 = a.d.a.a.h.g.u3.n(r12)
            int r10 = r10 / 2
            if (r2 >= r10) goto L_0x00a7
            r9 = r12
            r7 = 1
            goto L_0x0051
        L_0x00a7:
            int r2 = r5.length
            int r6 = r2 >> 1
            int r2 = r2 >> 2
            int r6 = r6 + r2
            if (r12 >= r6) goto L_0x00b3
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r12)
        L_0x00b3:
            a.d.a.a.h.g.d4 r9 = new a.d.a.a.h.g.d4
            r11 = r9
            r2 = r12
            r12 = r5
            r16 = r2
            r11.<init>(r12, r13, r14, r15, r16)
            goto L_0x00c9
        L_0x00be:
            r2 = 0
            r5 = r5[r2]
            a.d.a.a.h.g.f4 r9 = new a.d.a.a.h.g.f4
            r9.<init>(r5)
            goto L_0x00c9
        L_0x00c7:
            a.d.a.a.h.g.d4<java.lang.Object> r9 = a.d.a.a.h.g.d4.h
        L_0x00c9:
            boolean r2 = r9.isEmpty()
            if (r2 != 0) goto L_0x0021
            int r2 = r3 + 1
            int r5 = r2 << 1
            int r6 = r1.length
            if (r5 <= r6) goto L_0x00fa
            int r6 = r1.length
            if (r5 < 0) goto L_0x00f2
            int r7 = r6 >> 1
            int r6 = r6 + r7
            r7 = 1
            int r6 = r6 + r7
            if (r6 >= r5) goto L_0x00e8
            int r5 = r5 + -1
            int r5 = java.lang.Integer.highestOneBit(r5)
            int r6 = r5 << 1
        L_0x00e8:
            if (r6 >= 0) goto L_0x00ed
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x00ed:
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r6)
            goto L_0x00fa
        L_0x00f2:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "cannot store more than MAX_VALUE elements"
            r0.<init>(r1)
            throw r0
        L_0x00fa:
            a.c.a.f.b.n1(r8, r9)
            int r3 = r3 * 2
            r1[r3] = r8
            r5 = 1
            int r3 = r3 + r5
            r1[r3] = r9
            int r3 = r9.size()
            int r4 = r4 + r3
            r3 = r2
            goto L_0x0021
        L_0x010d:
            r5 = 1
            a.d.a.a.h.g.t3 r0 = new a.d.a.a.h.g.t3
            if (r3 != 0) goto L_0x0118
            a.d.a.a.h.g.r3<java.lang.Object, java.lang.Object> r1 = a.d.a.a.h.g.x3.g
            a.d.a.a.h.g.x3 r1 = (a.d.a.a.h.g.x3) r1
            goto L_0x01f6
        L_0x0118:
            r2 = 0
            if (r3 != r5) goto L_0x012a
            r2 = r1[r2]
            r3 = r1[r5]
            a.c.a.f.b.n1(r2, r3)
            a.d.a.a.h.g.x3 r2 = new a.d.a.a.h.g.x3
            r2.<init>(r6, r1, r5)
        L_0x0127:
            r1 = r2
            goto L_0x01f6
        L_0x012a:
            int r7 = r1.length
            int r7 = r7 >> r5
            a.c.a.d.a.A(r3, r7)
            int r7 = a.d.a.a.h.g.u3.n(r3)
            if (r3 != r5) goto L_0x013e
            r2 = r1[r2]
            r5 = r1[r5]
            a.c.a.f.b.n1(r2, r5)
            goto L_0x01ef
        L_0x013e:
            int r5 = r7 + -1
            r6 = 128(0x80, float:1.794E-43)
            r8 = -1
            if (r7 > r6) goto L_0x017d
            byte[] r6 = new byte[r7]
            java.util.Arrays.fill(r6, r8)
        L_0x014a:
            if (r2 >= r3) goto L_0x01ef
            int r7 = r2 * 2
            r8 = r1[r7]
            r9 = r7 ^ 1
            r9 = r1[r9]
            a.c.a.f.b.n1(r8, r9)
            int r10 = r8.hashCode()
            int r10 = a.c.a.d.a.r(r10)
        L_0x015f:
            r10 = r10 & r5
            byte r11 = r6[r10]
            r12 = 255(0xff, float:3.57E-43)
            r11 = r11 & r12
            if (r11 != r12) goto L_0x016d
            byte r7 = (byte) r7
            r6[r10] = r7
            int r2 = r2 + 1
            goto L_0x014a
        L_0x016d:
            r12 = r1[r11]
            boolean r12 = r12.equals(r8)
            if (r12 != 0) goto L_0x0178
            int r10 = r10 + 1
            goto L_0x015f
        L_0x0178:
            java.lang.IllegalArgumentException r0 = a.d.a.a.h.g.x3.a(r8, r9, r1, r11)
            throw r0
        L_0x017d:
            r6 = 32768(0x8000, float:4.5918E-41)
            if (r7 > r6) goto L_0x01bb
            short[] r6 = new short[r7]
            java.util.Arrays.fill(r6, r8)
        L_0x0187:
            if (r2 >= r3) goto L_0x01ef
            int r7 = r2 * 2
            r8 = r1[r7]
            r9 = r7 ^ 1
            r9 = r1[r9]
            a.c.a.f.b.n1(r8, r9)
            int r10 = r8.hashCode()
            int r10 = a.c.a.d.a.r(r10)
        L_0x019c:
            r10 = r10 & r5
            short r11 = r6[r10]
            r12 = 65535(0xffff, float:9.1834E-41)
            r11 = r11 & r12
            if (r11 != r12) goto L_0x01ab
            short r7 = (short) r7
            r6[r10] = r7
            int r2 = r2 + 1
            goto L_0x0187
        L_0x01ab:
            r12 = r1[r11]
            boolean r12 = r12.equals(r8)
            if (r12 != 0) goto L_0x01b6
            int r10 = r10 + 1
            goto L_0x019c
        L_0x01b6:
            java.lang.IllegalArgumentException r0 = a.d.a.a.h.g.x3.a(r8, r9, r1, r11)
            throw r0
        L_0x01bb:
            int[] r6 = new int[r7]
            java.util.Arrays.fill(r6, r8)
        L_0x01c0:
            if (r2 >= r3) goto L_0x01ef
            int r7 = r2 * 2
            r9 = r1[r7]
            r10 = r7 ^ 1
            r10 = r1[r10]
            a.c.a.f.b.n1(r9, r10)
            int r11 = r9.hashCode()
            int r11 = a.c.a.d.a.r(r11)
        L_0x01d5:
            r11 = r11 & r5
            r12 = r6[r11]
            if (r12 != r8) goto L_0x01df
            r6[r11] = r7
            int r2 = r2 + 1
            goto L_0x01c0
        L_0x01df:
            r13 = r1[r12]
            boolean r13 = r13.equals(r9)
            if (r13 != 0) goto L_0x01ea
            int r11 = r11 + 1
            goto L_0x01d5
        L_0x01ea:
            java.lang.IllegalArgumentException r0 = a.d.a.a.h.g.x3.a(r9, r10, r1, r12)
            throw r0
        L_0x01ef:
            a.d.a.a.h.g.x3 r2 = new a.d.a.a.h.g.x3
            r2.<init>(r6, r1, r3)
            goto L_0x0127
        L_0x01f6:
            r0.<init>(r1, r4)
        L_0x01f9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.q2.a():a.d.a.a.h.g.t3");
    }
}

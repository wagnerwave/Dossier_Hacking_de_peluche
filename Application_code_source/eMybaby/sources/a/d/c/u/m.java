package a.d.c.u;

public final class m {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f3067c = {1, 1, 2};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3068d = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3069a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    public final StringBuilder f3070b = new StringBuilder();

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.l a(int r17, a.d.c.r.a r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            int[] r2 = f3067c
            r3 = 0
            r4 = r19
            int[] r2 = a.d.c.u.n.l(r1, r4, r3, r2)
            java.lang.StringBuilder r4 = r0.f3070b
            r4.setLength(r3)
            int[] r5 = r0.f3069a
            r5[r3] = r3
            r6 = 1
            r5[r6] = r3
            r7 = 2
            r5[r7] = r3
            r8 = 3
            r5[r8] = r3
            int r8 = r1.f2965b
            r9 = r2[r6]
            r10 = 0
            r11 = 0
        L_0x0025:
            r12 = 5
            r13 = 10
            r14 = 48
            if (r10 >= r12) goto L_0x005d
            if (r9 >= r8) goto L_0x005d
            int[][] r12 = a.d.c.u.n.g
            int r12 = a.d.c.u.n.h(r1, r5, r9, r12)
            int r14 = r12 % 10
            int r14 = r14 + 48
            char r14 = (char) r14
            r4.append(r14)
            int r14 = r5.length
        L_0x003d:
            if (r3 >= r14) goto L_0x0045
            r15 = r5[r3]
            int r9 = r9 + r15
            int r3 = r3 + 1
            goto L_0x003d
        L_0x0045:
            if (r12 < r13) goto L_0x004d
            int r3 = 4 - r10
            int r3 = r6 << r3
            r3 = r3 | r11
            r11 = r3
        L_0x004d:
            r3 = 4
            if (r10 == r3) goto L_0x0059
            int r3 = r1.b(r9)
            int r3 = r1.c(r3)
            r9 = r3
        L_0x0059:
            int r10 = r10 + 1
            r3 = 0
            goto L_0x0025
        L_0x005d:
            int r1 = r4.length()
            if (r1 != r12) goto L_0x0168
            r1 = 0
        L_0x0064:
            if (r1 >= r13) goto L_0x0165
            int[] r3 = f3068d
            r3 = r3[r1]
            if (r11 != r3) goto L_0x015f
            java.lang.String r3 = r4.toString()
            int r5 = r3.length()
            int r8 = r5 + -2
            r10 = 0
        L_0x0077:
            if (r8 < 0) goto L_0x0083
            char r11 = r3.charAt(r8)
            int r11 = r11 + -48
            int r10 = r10 + r11
            int r8 = r8 + -2
            goto L_0x0077
        L_0x0083:
            int r10 = r10 * 3
            int r5 = r5 + -1
        L_0x0087:
            if (r5 < 0) goto L_0x0093
            char r8 = r3.charAt(r5)
            int r8 = r8 + -48
            int r10 = r10 + r8
            int r5 = r5 + -2
            goto L_0x0087
        L_0x0093:
            int r10 = r10 * 3
            int r10 = r10 % r13
            if (r10 != r1) goto L_0x015c
            java.lang.String r1 = r4.toString()
            int r3 = r1.length()
            r4 = 0
            if (r3 == r7) goto L_0x0116
            if (r3 == r12) goto L_0x00a7
            goto L_0x011e
        L_0x00a7:
            a.d.c.m r3 = a.d.c.m.SUGGESTED_PRICE
            r5 = 0
            char r5 = r1.charAt(r5)
            if (r5 == r14) goto L_0x00df
            r8 = 53
            if (r5 == r8) goto L_0x00dc
            r8 = 57
            if (r5 == r8) goto L_0x00b9
            goto L_0x00d9
        L_0x00b9:
            java.lang.String r5 = "90000"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x00c3
            r5 = r4
            goto L_0x011c
        L_0x00c3:
            java.lang.String r5 = "99991"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x00ce
            java.lang.String r5 = "0.00"
            goto L_0x011c
        L_0x00ce:
            java.lang.String r5 = "99990"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x00d9
            java.lang.String r5 = "Used"
            goto L_0x011c
        L_0x00d9:
            java.lang.String r5 = ""
            goto L_0x00e1
        L_0x00dc:
            java.lang.String r5 = "$"
            goto L_0x00e1
        L_0x00df:
            java.lang.String r5 = "£"
        L_0x00e1:
            java.lang.String r8 = r1.substring(r6)
            int r8 = java.lang.Integer.parseInt(r8)
            int r10 = r8 / 100
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r8 = r8 % 100
            if (r8 >= r13) goto L_0x00fa
            java.lang.String r11 = "0"
            java.lang.String r8 = a.a.a.a.a.h(r11, r8)
            goto L_0x00fe
        L_0x00fa:
            java.lang.String r8 = java.lang.String.valueOf(r8)
        L_0x00fe:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r5)
            r11.append(r10)
            r5 = 46
            r11.append(r5)
            r11.append(r8)
            java.lang.String r5 = r11.toString()
            goto L_0x011c
        L_0x0116:
            a.d.c.m r3 = a.d.c.m.ISSUE_NUMBER
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
        L_0x011c:
            if (r5 != 0) goto L_0x0120
        L_0x011e:
            r8 = r4
            goto L_0x012a
        L_0x0120:
            java.util.EnumMap r8 = new java.util.EnumMap
            java.lang.Class<a.d.c.m> r10 = a.d.c.m.class
            r8.<init>(r10)
            r8.put(r3, r5)
        L_0x012a:
            a.d.c.l r3 = new a.d.c.l
            a.d.c.n[] r5 = new a.d.c.n[r7]
            a.d.c.n r7 = new a.d.c.n
            r10 = 0
            r11 = r2[r10]
            r2 = r2[r6]
            int r11 = r11 + r2
            float r2 = (float) r11
            r11 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r11
            r15 = r17
            float r11 = (float) r15
            r7.<init>(r2, r11)
            r5[r10] = r7
            a.d.c.n r2 = new a.d.c.n
            float r7 = (float) r9
            r2.<init>(r7, r11)
            r5[r6] = r2
            a.d.c.a r2 = a.d.c.a.UPC_EAN_EXTENSION
            r3.<init>(r1, r4, r5, r2)
            if (r8 == 0) goto L_0x015b
            java.util.Map<a.d.c.m, java.lang.Object> r1 = r3.f2879e
            if (r1 != 0) goto L_0x0158
            r3.f2879e = r8
            goto L_0x015b
        L_0x0158:
            r1.putAll(r8)
        L_0x015b:
            return r3
        L_0x015c:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x015f:
            r15 = r17
            int r1 = r1 + 1
            goto L_0x0064
        L_0x0165:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0168:
            a.d.c.i r1 = a.d.c.i.f2874a
            goto L_0x016c
        L_0x016b:
            throw r1
        L_0x016c:
            goto L_0x016b
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.m.a(int, a.d.c.r.a, int):a.d.c.l");
    }
}

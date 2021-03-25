package a.d.c.u;

public final class c extends k {

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f3050c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3051d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3052e;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3053a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3054b;

    static {
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};
        f3051d = iArr;
        f3052e = iArr[39];
    }

    public c() {
        this.f3053a = false;
        this.f3054b = false;
    }

    public c(boolean z) {
        this.f3053a = z;
        this.f3054b = false;
    }

    public static int g(int[] iArr) {
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < r0; i7++) {
                int i8 = iArr[i7];
                if (iArr[i7] > i2) {
                    i5 |= 1 << ((r0 - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < r0 && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (iArr[i9] > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        r9 = f3050c[r10];
        r8.append(r9);
        r12 = r6;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        if (r10 >= 9) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        r12 = r12 + r3[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        r10 = r1.b(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        if (r9 != '*') goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        r8.setLength(r8.length() - r11);
        r1 = 0;
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008c, code lost:
        if (r1 >= 9) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
        r9 = r9 + r3[r1];
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        r1 = (r10 - r6) - r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0097, code lost:
        if (r10 == r7) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
        if ((r1 >> r11) < r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009f, code lost:
        throw a.d.c.i.f2874a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a4, code lost:
        if (r0.f3053a == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a6, code lost:
        r1 = r8.length() - r11;
        r3 = 0;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ad, code lost:
        if (r3 >= r1) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        r7 = r7 + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(r8.charAt(r3));
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c6, code lost:
        if (r8.charAt(r1) != f3050c[r7 % 43]) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c8, code lost:
        r8.setLength(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ce, code lost:
        throw a.d.c.d.f2863a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d3, code lost:
        if (r8.length() == 0) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d7, code lost:
        if (r0.f3054b == false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d9, code lost:
        r1 = r8.length();
        r3 = new java.lang.StringBuilder(r1);
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e3, code lost:
        if (r7 >= r1) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e5, code lost:
        r9 = r8.charAt(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ef, code lost:
        if (r9 == '+') goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f1, code lost:
        if (r9 == '$') goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f3, code lost:
        if (r9 == '%') goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        if (r9 != '/') goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f7, code lost:
        r7 = r7 + 1;
        r14 = r8.charAt(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0101, code lost:
        if (r9 == '$') goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0103, code lost:
        if (r9 == '%') goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0105, code lost:
        if (r9 == '+') goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0107, code lost:
        if (r9 == '/') goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0109, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010b, code lost:
        if (r14 < 'A') goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010f, code lost:
        if (r14 > 'O') goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0111, code lost:
        r14 = r14 - ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0114, code lost:
        if (r14 != 'Z') goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0116, code lost:
        r9 = ':';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011b, code lost:
        throw a.d.c.f.f2869a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x011c, code lost:
        if (r14 < 'A') goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011e, code lost:
        if (r14 > 'Z') goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0120, code lost:
        r14 = r14 + ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0125, code lost:
        throw a.d.c.f.f2869a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0126, code lost:
        if (r14 < 'A') goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012a, code lost:
        if (r14 > 'E') goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x012c, code lost:
        r14 = r14 - '&';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0131, code lost:
        if (r14 < 'F') goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0135, code lost:
        if (r14 > 'W') goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0137, code lost:
        r14 = r14 - 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013c, code lost:
        throw a.d.c.f.f2869a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x013d, code lost:
        if (r14 < 'A') goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x013f, code lost:
        if (r14 > 'Z') goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0141, code lost:
        r14 = r14 - '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0143, code lost:
        r9 = (char) r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0144, code lost:
        r3.append(r9);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x014f, code lost:
        throw a.d.c.f.f2869a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0150, code lost:
        r1 = r3.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0155, code lost:
        r1 = r8.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0159, code lost:
        r8 = (float) r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0185, code lost:
        return new a.d.c.l(r1, (byte[]) null, new a.d.c.n[]{new a.d.c.n(((float) (r4[1] + r4[0])) / 2.0f, r8), new a.d.c.n(((float) (r10 + r6)) / 2.0f, r8)}, a.d.c.a.CODE_39);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0188, code lost:
        throw a.d.c.i.f2874a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.l b(int r17, a.d.c.r.a r18, java.util.Map<a.d.c.e, ?> r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = 9
            int[] r3 = new int[r2]
            int r4 = r1.f2965b
            r5 = 0
            int r6 = r1.b(r5)
            r7 = r6
            r8 = 0
            r9 = 0
        L_0x0012:
            if (r6 >= r4) goto L_0x01c0
            boolean r10 = r1.a(r6)
            r10 = r10 ^ r8
            r11 = 1
            if (r10 == 0) goto L_0x0025
            r10 = r3[r9]
            int r10 = r10 + r11
            r3[r9] = r10
            r11 = r17
            goto L_0x01bc
        L_0x0025:
            r10 = 8
            if (r9 != r10) goto L_0x01b3
            int r12 = g(r3)
            int r13 = f3052e
            r14 = 2
            if (r12 != r13) goto L_0x019e
            int r12 = r6 - r7
            int r12 = r12 >> r11
            int r12 = r7 - r12
            int r12 = java.lang.Math.max(r5, r12)
            boolean r12 = r1.d(r12, r7, r5)
            if (r12 == 0) goto L_0x019e
            int[] r4 = new int[r14]
            r4[r5] = r7
            r4[r11] = r6
            r6 = r4[r11]
            int r6 = r1.b(r6)
            int r7 = r1.f2965b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r9 = 20
            r8.<init>(r9)
        L_0x0056:
            a.d.c.u.k.e(r1, r6, r3)
            int r9 = g(r3)
            if (r9 < 0) goto L_0x019b
            r10 = 0
        L_0x0060:
            int[] r12 = f3051d
            int r13 = r12.length
            if (r10 >= r13) goto L_0x0198
            r12 = r12[r10]
            if (r12 != r9) goto L_0x018f
            char[] r9 = f3050c
            char r9 = r9[r10]
            r8.append(r9)
            r12 = r6
            r10 = 0
        L_0x0072:
            if (r10 >= r2) goto L_0x007a
            r13 = r3[r10]
            int r12 = r12 + r13
            int r10 = r10 + 1
            goto L_0x0072
        L_0x007a:
            int r10 = r1.b(r12)
            r12 = 42
            if (r9 != r12) goto L_0x0189
            int r1 = r8.length()
            int r1 = r1 - r11
            r8.setLength(r1)
            r1 = 0
            r9 = 0
        L_0x008c:
            if (r1 >= r2) goto L_0x0094
            r12 = r3[r1]
            int r9 = r9 + r12
            int r1 = r1 + 1
            goto L_0x008c
        L_0x0094:
            int r1 = r10 - r6
            int r1 = r1 - r9
            if (r10 == r7) goto L_0x00a0
            int r1 = r1 >> r11
            if (r1 < r9) goto L_0x009d
            goto L_0x00a0
        L_0x009d:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00a0:
            boolean r1 = r0.f3053a
            r2 = 43
            if (r1 == 0) goto L_0x00cf
            int r1 = r8.length()
            int r1 = r1 - r11
            r3 = 0
            r7 = 0
        L_0x00ad:
            if (r3 >= r1) goto L_0x00bd
            char r9 = r8.charAt(r3)
            java.lang.String r12 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%"
            int r9 = r12.indexOf(r9)
            int r7 = r7 + r9
            int r3 = r3 + 1
            goto L_0x00ad
        L_0x00bd:
            char r3 = r8.charAt(r1)
            char[] r9 = f3050c
            int r7 = r7 % r2
            char r7 = r9[r7]
            if (r3 != r7) goto L_0x00cc
            r8.setLength(r1)
            goto L_0x00cf
        L_0x00cc:
            a.d.c.d r1 = a.d.c.d.f2863a
            throw r1
        L_0x00cf:
            int r1 = r8.length()
            if (r1 == 0) goto L_0x0186
            boolean r1 = r0.f3054b
            if (r1 == 0) goto L_0x0155
            int r1 = r8.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r7 = 0
        L_0x00e3:
            if (r7 >= r1) goto L_0x0150
            char r9 = r8.charAt(r7)
            r12 = 47
            r13 = 37
            r15 = 36
            if (r9 == r2) goto L_0x00f7
            if (r9 == r15) goto L_0x00f7
            if (r9 == r13) goto L_0x00f7
            if (r9 != r12) goto L_0x0144
        L_0x00f7:
            int r7 = r7 + 1
            char r14 = r8.charAt(r7)
            r5 = 90
            r11 = 65
            if (r9 == r15) goto L_0x013d
            if (r9 == r13) goto L_0x0126
            if (r9 == r2) goto L_0x011c
            if (r9 == r12) goto L_0x010b
            r9 = 0
            goto L_0x0144
        L_0x010b:
            if (r14 < r11) goto L_0x0114
            r9 = 79
            if (r14 > r9) goto L_0x0114
            int r14 = r14 + -32
            goto L_0x0143
        L_0x0114:
            if (r14 != r5) goto L_0x0119
            r9 = 58
            goto L_0x0144
        L_0x0119:
            a.d.c.f r1 = a.d.c.f.f2869a
            throw r1
        L_0x011c:
            if (r14 < r11) goto L_0x0123
            if (r14 > r5) goto L_0x0123
            int r14 = r14 + 32
            goto L_0x0143
        L_0x0123:
            a.d.c.f r1 = a.d.c.f.f2869a
            throw r1
        L_0x0126:
            if (r14 < r11) goto L_0x012f
            r5 = 69
            if (r14 > r5) goto L_0x012f
            int r14 = r14 + -38
            goto L_0x0143
        L_0x012f:
            r5 = 70
            if (r14 < r5) goto L_0x013a
            r5 = 87
            if (r14 > r5) goto L_0x013a
            int r14 = r14 + -11
            goto L_0x0143
        L_0x013a:
            a.d.c.f r1 = a.d.c.f.f2869a
            throw r1
        L_0x013d:
            if (r14 < r11) goto L_0x014d
            if (r14 > r5) goto L_0x014d
            int r14 = r14 + -64
        L_0x0143:
            char r9 = (char) r14
        L_0x0144:
            r3.append(r9)
            r5 = 1
            int r7 = r7 + r5
            r5 = 0
            r11 = 1
            r14 = 2
            goto L_0x00e3
        L_0x014d:
            a.d.c.f r1 = a.d.c.f.f2869a
            throw r1
        L_0x0150:
            java.lang.String r1 = r3.toString()
            goto L_0x0159
        L_0x0155:
            java.lang.String r1 = r8.toString()
        L_0x0159:
            r2 = 1
            r3 = r4[r2]
            r2 = 0
            r4 = r4[r2]
            int r3 = r3 + r4
            float r2 = (float) r3
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            int r10 = r10 + r6
            float r4 = (float) r10
            float r4 = r4 / r3
            a.d.c.l r3 = new a.d.c.l
            r5 = 0
            r6 = 2
            a.d.c.n[] r6 = new a.d.c.n[r6]
            a.d.c.n r7 = new a.d.c.n
            r11 = r17
            float r8 = (float) r11
            r7.<init>(r2, r8)
            r2 = 0
            r6[r2] = r7
            a.d.c.n r2 = new a.d.c.n
            r2.<init>(r4, r8)
            r4 = 1
            r6[r4] = r2
            a.d.c.a r2 = a.d.c.a.CODE_39
            r3.<init>(r1, r5, r6, r2)
            return r3
        L_0x0186:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0189:
            r11 = r17
            r6 = r10
            r11 = 1
            goto L_0x0056
        L_0x018f:
            r11 = r17
            int r10 = r10 + 1
            r5 = 0
            r11 = 1
            r14 = 2
            goto L_0x0060
        L_0x0198:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x019b:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x019e:
            r11 = r17
            r12 = r3[r5]
            r13 = 1
            r14 = r3[r13]
            int r12 = r12 + r14
            int r7 = r7 + r12
            r12 = 7
            r13 = 2
            java.lang.System.arraycopy(r3, r13, r3, r5, r12)
            r3[r12] = r5
            r3[r10] = r5
            int r9 = r9 + -1
            goto L_0x01b7
        L_0x01b3:
            r11 = r17
            int r9 = r9 + 1
        L_0x01b7:
            r10 = 1
            r3[r9] = r10
            r8 = r8 ^ 1
        L_0x01bc:
            int r6 = r6 + 1
            goto L_0x0012
        L_0x01c0:
            a.d.c.i r1 = a.d.c.i.f2874a
            goto L_0x01c4
        L_0x01c3:
            throw r1
        L_0x01c4:
            goto L_0x01c3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.c.b(int, a.d.c.r.a, java.util.Map):a.d.c.l");
    }
}

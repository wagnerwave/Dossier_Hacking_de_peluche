package a.d.c.u;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tuya.smart.common.o0oO0Ooo;

public final class d extends k {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3055a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f3056b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3057c;

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, o0oO0Ooo.O000Oo0O, 468, 466, 458, 366, 374, 430, 294, 474, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 306, 350};
        f3056b = iArr;
        f3057c = iArr[47];
    }

    public static void g(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != f3055a[i3 % 47]) {
            throw a.d.c.d.f2863a;
        }
    }

    public static int h(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < r0; i4++) {
            int i5 = ((iArr[i4] << 8) * 9) / i;
            int i6 = i5 >> 8;
            if ((i5 & 255) > 127) {
                i6++;
            }
            if (i6 < 1 || i6 > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i7 = 0; i7 < i6; i7++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= i6;
            }
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r9 = f3055a[r11];
        r6.append(r9);
        r12 = r3;
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        if (r11 >= 6) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        r12 = r12 + r8[r11];
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        r11 = r0.b(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        if (r9 != '*') goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        r6.deleteCharAt(r6.length() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0079, code lost:
        if (r11 == r5) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        if (r0.a(r11) == false) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        if (r6.length() < 2) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        r0 = r6.length();
        g(r6, r0 - 2, 20);
        g(r6, r0 - 1, 15);
        r6.setLength(r6.length() - 2);
        r0 = r6.length();
        r4 = new java.lang.StringBuilder(r0);
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
        if (r5 >= r0) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        r7 = r6.charAt(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b1, code lost:
        if (r7 < 'a') goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b5, code lost:
        if (r7 > 'd') goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b7, code lost:
        r5 = r5 + 1;
        r8 = r6.charAt(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c1, code lost:
        switch(r7) {
            case 97: goto L_0x00f8;
            case 98: goto L_0x00e1;
            case 99: goto L_0x00d0;
            case 100: goto L_0x00c6;
            default: goto L_0x00c4;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c4, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        if (r8 < 'A') goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c8, code lost:
        if (r8 > 'Z') goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ca, code lost:
        r8 = r8 + ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cf, code lost:
        throw a.d.c.f.f2869a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d0, code lost:
        if (r8 < 'A') goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d4, code lost:
        if (r8 > 'O') goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d6, code lost:
        r8 = r8 - ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d9, code lost:
        if (r8 != 'Z') goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00db, code lost:
        r7 = ':';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e0, code lost:
        throw a.d.c.f.f2869a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e1, code lost:
        if (r8 < 'A') goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e5, code lost:
        if (r8 > 'E') goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        r8 = r8 - '&';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ec, code lost:
        if (r8 < 'F') goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f0, code lost:
        if (r8 > 'W') goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f2, code lost:
        r8 = r8 - 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f7, code lost:
        throw a.d.c.f.f2869a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f8, code lost:
        if (r8 < 'A') goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fa, code lost:
        if (r8 > 'Z') goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00fc, code lost:
        r8 = r8 - '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00fe, code lost:
        r7 = (char) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0102, code lost:
        throw a.d.c.f.f2869a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0103, code lost:
        r4.append(r7);
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0108, code lost:
        r8 = (float) r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0133, code lost:
        return new a.d.c.l(r4.toString(), (byte[]) null, new a.d.c.n[]{new a.d.c.n(((float) (r1[1] + r1[0])) / 2.0f, r8), new a.d.c.n(((float) (r11 + r3)) / 2.0f, r8)}, a.d.c.a.CODE_93);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0136, code lost:
        throw a.d.c.i.f2874a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0139, code lost:
        throw a.d.c.i.f2874a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.l b(int r16, a.d.c.r.a r17, java.util.Map<a.d.c.e, ?> r18) {
        /*
            r15 = this;
            r0 = r17
            int r1 = r0.f2965b
            r2 = 0
            int r3 = r0.b(r2)
            r4 = 6
            int[] r5 = new int[r4]
            r6 = r3
            r7 = 0
            r8 = 0
        L_0x000f:
            if (r3 >= r1) goto L_0x016a
            boolean r9 = r0.a(r3)
            r9 = r9 ^ r7
            r10 = 1
            if (r9 == 0) goto L_0x0022
            r9 = r5[r8]
            int r9 = r9 + r10
            r5[r8] = r9
            r12 = r16
            goto L_0x0166
        L_0x0022:
            r9 = 5
            if (r8 != r9) goto L_0x015e
            int r11 = h(r5)
            int r12 = f3057c
            r13 = 2
            if (r11 != r12) goto L_0x014b
            int[] r1 = new int[r13]
            r1[r2] = r6
            r1[r10] = r3
            r3 = r1[r10]
            int r3 = r0.b(r3)
            int r5 = r0.f2965b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r7 = 20
            r6.<init>(r7)
            int[] r8 = new int[r4]
        L_0x0045:
            a.d.c.u.k.e(r0, r3, r8)
            int r9 = h(r8)
            if (r9 < 0) goto L_0x0148
            r11 = 0
        L_0x004f:
            int[] r12 = f3056b
            int r14 = r12.length
            if (r11 >= r14) goto L_0x0145
            r12 = r12[r11]
            if (r12 != r9) goto L_0x013f
            char[] r9 = f3055a
            char r9 = r9[r11]
            r6.append(r9)
            r12 = r3
            r11 = 0
        L_0x0061:
            if (r11 >= r4) goto L_0x0069
            r14 = r8[r11]
            int r12 = r12 + r14
            int r11 = r11 + 1
            goto L_0x0061
        L_0x0069:
            int r11 = r0.b(r12)
            r12 = 42
            if (r9 != r12) goto L_0x013a
            int r4 = r6.length()
            int r4 = r4 - r10
            r6.deleteCharAt(r4)
            if (r11 == r5) goto L_0x0137
            boolean r0 = r0.a(r11)
            if (r0 == 0) goto L_0x0137
            int r0 = r6.length()
            if (r0 < r13) goto L_0x0134
            int r0 = r6.length()
            int r4 = r0 + -2
            g(r6, r4, r7)
            int r0 = r0 + -1
            r4 = 15
            g(r6, r0, r4)
            int r0 = r6.length()
            int r0 = r0 - r13
            r6.setLength(r0)
            int r0 = r6.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r5 = 0
        L_0x00a9:
            if (r5 >= r0) goto L_0x0108
            char r7 = r6.charAt(r5)
            r8 = 97
            if (r7 < r8) goto L_0x0103
            r8 = 100
            if (r7 > r8) goto L_0x0103
            int r5 = r5 + 1
            char r8 = r6.charAt(r5)
            r9 = 90
            r12 = 65
            switch(r7) {
                case 97: goto L_0x00f8;
                case 98: goto L_0x00e1;
                case 99: goto L_0x00d0;
                case 100: goto L_0x00c6;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            r7 = 0
            goto L_0x0103
        L_0x00c6:
            if (r8 < r12) goto L_0x00cd
            if (r8 > r9) goto L_0x00cd
            int r8 = r8 + 32
            goto L_0x00fe
        L_0x00cd:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x00d0:
            if (r8 < r12) goto L_0x00d9
            r7 = 79
            if (r8 > r7) goto L_0x00d9
            int r8 = r8 + -32
            goto L_0x00fe
        L_0x00d9:
            if (r8 != r9) goto L_0x00de
            r7 = 58
            goto L_0x0103
        L_0x00de:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x00e1:
            if (r8 < r12) goto L_0x00ea
            r7 = 69
            if (r8 > r7) goto L_0x00ea
            int r8 = r8 + -38
            goto L_0x00fe
        L_0x00ea:
            r7 = 70
            if (r8 < r7) goto L_0x00f5
            r7 = 87
            if (r8 > r7) goto L_0x00f5
            int r8 = r8 + -11
            goto L_0x00fe
        L_0x00f5:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x00f8:
            if (r8 < r12) goto L_0x0100
            if (r8 > r9) goto L_0x0100
            int r8 = r8 + -64
        L_0x00fe:
            char r7 = (char) r8
            goto L_0x0103
        L_0x0100:
            a.d.c.f r0 = a.d.c.f.f2869a
            throw r0
        L_0x0103:
            r4.append(r7)
            int r5 = r5 + r10
            goto L_0x00a9
        L_0x0108:
            java.lang.String r0 = r4.toString()
            r4 = r1[r10]
            r1 = r1[r2]
            int r4 = r4 + r1
            float r1 = (float) r4
            r4 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r4
            int r11 = r11 + r3
            float r3 = (float) r11
            float r3 = r3 / r4
            a.d.c.l r4 = new a.d.c.l
            r5 = 0
            a.d.c.n[] r6 = new a.d.c.n[r13]
            a.d.c.n r7 = new a.d.c.n
            r12 = r16
            float r8 = (float) r12
            r7.<init>(r1, r8)
            r6[r2] = r7
            a.d.c.n r1 = new a.d.c.n
            r1.<init>(r3, r8)
            r6[r10] = r1
            a.d.c.a r1 = a.d.c.a.CODE_93
            r4.<init>(r0, r5, r6, r1)
            return r4
        L_0x0134:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x0137:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x013a:
            r12 = r16
            r3 = r11
            goto L_0x0045
        L_0x013f:
            r12 = r16
            int r11 = r11 + 1
            goto L_0x004f
        L_0x0145:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x0148:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x014b:
            r12 = r16
            r11 = r5[r2]
            r14 = r5[r10]
            int r11 = r11 + r14
            int r6 = r6 + r11
            r11 = 4
            java.lang.System.arraycopy(r5, r13, r5, r2, r11)
            r5[r11] = r2
            r5[r9] = r2
            int r8 = r8 + -1
            goto L_0x0162
        L_0x015e:
            r12 = r16
            int r8 = r8 + 1
        L_0x0162:
            r5[r8] = r10
            r7 = r7 ^ 1
        L_0x0166:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x016a:
            a.d.c.i r0 = a.d.c.i.f2874a
            goto L_0x016e
        L_0x016d:
            throw r0
        L_0x016e:
            goto L_0x016d
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.d.b(int, a.d.c.r.a, java.util.Map):a.d.c.l");
    }
}

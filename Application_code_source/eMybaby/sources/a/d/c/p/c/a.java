package a.d.c.p.c;

import a.g.a.b.d;
import androidx.core.graphics.PaintCompat;
import androidx.core.view.PointerIconCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tuya.smart.common.OO000o0;
import com.tuya.smart.common.o0ooo00oo;
import com.tuya.smart.common.oOO0O0O0;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f2890e = {0, 104, 240, 408, 608};
    public static final int[] f = {0, 128, 288, 480, 704, 960, 1248, 1568, 1920, 2304, 2720, 3168, 3648, 4160, 4704, 5280, 5888, 6528, 7200, 7904, 8640, 9408, 10208, 11040, 11904, 12800, 13728, 14688, 15680, 16704, 17760, 18848, 19968};
    public static final int[] g = {0, 17, 40, 51, 76};
    public static final int[] h = {0, 21, 48, 60, 88, 120, 156, 196, 240, 230, 272, 316, 364, 416, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 528, 588, 652, 720, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_GETRCD_DURATION_REQ, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SET_ENVIRONMENT_REQ, 940, PointerIconCompat.TYPE_GRAB, 920, 992, 1066, 1144, 1224, 1306, 1392, 1480, 1570, 1664};
    public static final String[] i = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] j = {"CTRL_PS", " ", "a", "b", "c", d.f, "e", "f", "g", "h", "i", "j", "k", "l", PaintCompat.EM_STRING, "n", "o", "p", "q", "r", "s", o0ooo00oo.O00000oo, "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] k = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] l = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, ",", "-", ".", "/", ":", ";", "<", o0ooo00oo.O0000Oo0, ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    public static final String[] m = {"CTRL_PS", " ", oOO0O0O0.O0000oO0, "1", "2", OO000o0.O00000o, OO000o0.O00000o0, "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a  reason: collision with root package name */
    public int f2891a;

    /* renamed from: b  reason: collision with root package name */
    public int f2892b;

    /* renamed from: c  reason: collision with root package name */
    public a.d.c.p.a f2893c;

    /* renamed from: d  reason: collision with root package name */
    public int f2894d;

    /* renamed from: a.d.c.p.c.a$a  reason: collision with other inner class name */
    public enum C0069a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static int b(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4++;
            }
        }
        return i4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:173:0x0276 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.r.e a(a.d.c.p.a r15) {
        /*
            r14 = this;
            r14.f2893c = r15
            a.d.c.r.b r0 = r15.f2983a
            boolean r15 = r15.f2887c
            r1 = 2
            r2 = 1
            if (r15 != 0) goto L_0x004e
            int r15 = r0.f2966a
            int r3 = r15 + -1
            int r3 = r3 / r1
            int r3 = r3 / 16
            int r3 = r3 * 2
            int r3 = r3 + r2
            a.d.c.r.b r4 = new a.d.c.r.b
            int r15 = r15 - r3
            int r5 = r0.f2967b
            int r5 = r5 - r3
            r4.<init>(r15, r5)
            r15 = 0
            r3 = 0
        L_0x001f:
            int r5 = r0.f2966a
            if (r15 >= r5) goto L_0x004d
            int r5 = r5 / 2
            int r5 = r5 - r15
            int r5 = r5 % 16
            if (r5 != 0) goto L_0x002b
            goto L_0x004a
        L_0x002b:
            r5 = 0
            r6 = 0
        L_0x002d:
            int r7 = r0.f2967b
            if (r5 >= r7) goto L_0x0048
            int r7 = r0.f2966a
            int r7 = r7 / r1
            int r7 = r7 - r5
            int r7 = r7 % 16
            if (r7 != 0) goto L_0x003a
            goto L_0x0045
        L_0x003a:
            boolean r7 = r0.a(r15, r5)
            if (r7 == 0) goto L_0x0043
            r4.d(r3, r6)
        L_0x0043:
            int r6 = r6 + 1
        L_0x0045:
            int r5 = r5 + 1
            goto L_0x002d
        L_0x0048:
            int r3 = r3 + 1
        L_0x004a:
            int r15 = r15 + 1
            goto L_0x001f
        L_0x004d:
            r0 = r4
        L_0x004e:
            a.d.c.p.a r15 = r14.f2893c
            boolean r3 = r15.f2887c
            if (r3 == 0) goto L_0x0067
            int r15 = r15.f2889e
            int[] r3 = f2890e
            int r4 = r3.length
            if (r15 > r4) goto L_0x0064
            r3 = r3[r15]
            boolean[] r3 = new boolean[r3]
            int[] r4 = g
            r15 = r4[r15]
            goto L_0x0076
        L_0x0064:
            a.d.c.f r15 = a.d.c.f.f2869a
            throw r15
        L_0x0067:
            int r15 = r15.f2889e
            int[] r3 = f
            int r4 = r3.length
            if (r15 > r4) goto L_0x028a
            r3 = r3[r15]
            boolean[] r3 = new boolean[r3]
            int[] r4 = h
            r15 = r4[r15]
        L_0x0076:
            r14.f2891a = r15
            a.d.c.p.a r15 = r14.f2893c
            int r15 = r15.f2889e
            int r4 = r0.f2967b
            r5 = 0
            r6 = 0
        L_0x0080:
            r7 = 5
            if (r15 == 0) goto L_0x00ec
            r8 = 0
            r9 = 0
        L_0x0085:
            int r10 = r4 * 2
            int r11 = r10 + -4
            if (r8 >= r11) goto L_0x00ad
            int r11 = r5 + r8
            int r12 = r6 + r9
            int r13 = r8 / 2
            int r13 = r13 + r6
            boolean r12 = r0.a(r12, r13)
            r3[r11] = r12
            r11 = -4
            int r10 = a.a.a.a.a.b(r10, r5, r11, r8)
            int r11 = r6 + r4
            int r11 = r11 + -1
            int r11 = r11 - r9
            boolean r11 = r0.a(r13, r11)
            r3[r10] = r11
            int r9 = r9 + r2
            int r9 = r9 % r1
            int r8 = r8 + 1
            goto L_0x0085
        L_0x00ad:
            int r8 = r10 + 1
            r9 = 0
        L_0x00b0:
            if (r8 <= r7) goto L_0x00e0
            int r7 = r4 * 4
            int r7 = r7 + r5
            int r7 = r7 + -8
            int r11 = r10 - r8
            int r7 = r7 + r11
            int r7 = r7 + r2
            int r12 = r6 + r4
            int r12 = r12 + -1
            int r12 = r12 - r9
            int r13 = r8 / 2
            int r13 = r13 + r6
            int r13 = r13 + -1
            boolean r12 = r0.a(r12, r13)
            r3[r7] = r12
            int r7 = r4 * 6
            int r7 = r7 + r5
            int r7 = r7 + -12
            int r7 = r7 + r11
            int r7 = r7 + r2
            int r11 = r6 + r9
            boolean r11 = r0.a(r13, r11)
            r3[r7] = r11
            int r9 = r9 + r2
            int r9 = r9 % r1
            int r8 = r8 + -1
            r7 = 5
            goto L_0x00b0
        L_0x00e0:
            int r6 = r6 + 2
            int r7 = r4 * 8
            int r7 = r7 + -16
            int r5 = r5 + r7
            int r15 = r15 + -1
            int r4 = r4 + -4
            goto L_0x0080
        L_0x00ec:
            a.d.c.p.a r15 = r14.f2893c
            int r15 = r15.f2889e
            r0 = 6
            r4 = 8
            if (r15 > r1) goto L_0x00fa
            r14.f2892b = r0
            a.d.c.r.l.a r15 = a.d.c.r.l.a.j
            goto L_0x0112
        L_0x00fa:
            if (r15 > r4) goto L_0x0101
            r14.f2892b = r4
            a.d.c.r.l.a r15 = a.d.c.r.l.a.n
            goto L_0x0112
        L_0x0101:
            r0 = 22
            if (r15 > r0) goto L_0x010c
            r15 = 10
            r14.f2892b = r15
            a.d.c.r.l.a r15 = a.d.c.r.l.a.i
            goto L_0x0112
        L_0x010c:
            r15 = 12
            r14.f2892b = r15
            a.d.c.r.l.a r15 = a.d.c.r.l.a.h
        L_0x0112:
            a.d.c.p.a r0 = r14.f2893c
            int r4 = r0.f2888d
            boolean r5 = r0.f2887c
            if (r5 == 0) goto L_0x012c
            int[] r5 = f2890e
            int r0 = r0.f2889e
            r5 = r5[r0]
            int r6 = r14.f2891a
            int r7 = r14.f2892b
            int r6 = r6 * r7
            int r5 = r5 - r6
            int[] r6 = g
            r0 = r6[r0]
            goto L_0x013d
        L_0x012c:
            int[] r5 = f
            int r0 = r0.f2889e
            r5 = r5[r0]
            int r6 = r14.f2891a
            int r7 = r14.f2892b
            int r6 = r6 * r7
            int r5 = r5 - r6
            int[] r6 = h
            r0 = r6[r0]
        L_0x013d:
            int r0 = r0 - r4
            int r6 = r14.f2891a
            int[] r6 = new int[r6]
            r7 = 0
        L_0x0143:
            int r8 = r14.f2891a
            if (r7 >= r8) goto L_0x0163
            r8 = 1
            r9 = 1
        L_0x0149:
            int r10 = r14.f2892b
            if (r8 > r10) goto L_0x0160
            int r11 = r10 * r7
            int r11 = r11 + r10
            int r11 = r11 - r8
            int r11 = r11 + r5
            boolean r10 = r3[r11]
            if (r10 == 0) goto L_0x015b
            r10 = r6[r7]
            int r10 = r10 + r9
            r6[r7] = r10
        L_0x015b:
            int r9 = r9 << 1
            int r8 = r8 + 1
            goto L_0x0149
        L_0x0160:
            int r7 = r7 + 1
            goto L_0x0143
        L_0x0163:
            a.d.c.r.l.c r3 = new a.d.c.r.l.c     // Catch:{ d -> 0x0287 }
            r3.<init>(r15)     // Catch:{ d -> 0x0287 }
            r3.a(r6, r0)     // Catch:{ d -> 0x0287 }
            r15 = 0
            r14.f2894d = r15
            int r15 = r14.f2892b
            int r15 = r15 * r4
            boolean[] r0 = new boolean[r15]
            r3 = 0
            r5 = 0
        L_0x0176:
            if (r3 >= r4) goto L_0x01b7
            int r7 = r14.f2892b
            int r7 = r7 - r2
            int r7 = r2 << r7
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0180:
            int r11 = r14.f2892b
            if (r8 >= r11) goto L_0x01b4
            r11 = r6[r3]
            r11 = r11 & r7
            if (r11 != r7) goto L_0x018b
            r11 = 1
            goto L_0x018c
        L_0x018b:
            r11 = 0
        L_0x018c:
            int r12 = r14.f2892b
            int r12 = r12 - r2
            if (r9 != r12) goto L_0x01a0
            if (r11 == r10) goto L_0x019d
            int r5 = r5 + 1
            int r9 = r14.f2894d
            int r9 = r9 + r2
            r14.f2894d = r9
            r9 = 0
            r10 = 0
            goto L_0x01af
        L_0x019d:
            a.d.c.f r15 = a.d.c.f.f2869a
            throw r15
        L_0x01a0:
            if (r10 != r11) goto L_0x01a5
            int r9 = r9 + 1
            goto L_0x01a7
        L_0x01a5:
            r9 = 1
            r10 = r11
        L_0x01a7:
            int r12 = r14.f2892b
            int r12 = r12 * r3
            int r12 = r12 + r8
            int r12 = r12 - r5
            r0[r12] = r11
        L_0x01af:
            int r7 = r7 >>> 1
            int r8 = r8 + 1
            goto L_0x0180
        L_0x01b4:
            int r3 = r3 + 1
            goto L_0x0176
        L_0x01b7:
            a.d.c.p.c.a$a r3 = a.d.c.p.c.a.C0069a.DIGIT
            a.d.c.p.c.a$a r4 = a.d.c.p.c.a.C0069a.UPPER
            int r5 = r14.f2892b
            a.d.c.p.a r6 = r14.f2893c
            int r6 = r6.f2888d
            int r5 = r5 * r6
            int r6 = r14.f2894d
            int r5 = r5 - r6
            if (r5 > r15) goto L_0x0284
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r6 = 20
            r15.<init>(r6)
            r6 = 0
            r7 = 0
            r8 = r4
        L_0x01d2:
            r9 = 0
            r10 = 0
            r9 = r8
            r10 = 0
            r11 = 0
        L_0x01d7:
            if (r7 != 0) goto L_0x0279
            if (r10 == 0) goto L_0x01dd
            r11 = 1
            goto L_0x01de
        L_0x01dd:
            r9 = r8
        L_0x01de:
            int r12 = r8.ordinal()
            r13 = 5
            if (r12 == r13) goto L_0x0260
            if (r8 != r3) goto L_0x01e9
            r12 = 4
            goto L_0x01ea
        L_0x01e9:
            r12 = 5
        L_0x01ea:
            int r13 = r5 - r6
            if (r13 >= r12) goto L_0x01f0
            goto L_0x0266
        L_0x01f0:
            int r13 = b(r0, r6, r12)
            int r6 = r6 + r12
            int r12 = r8.ordinal()
            if (r12 == 0) goto L_0x021c
            if (r12 == r2) goto L_0x0217
            if (r12 == r1) goto L_0x0212
            r1 = 3
            if (r12 == r1) goto L_0x020d
            r1 = 4
            if (r12 == r1) goto L_0x0208
            java.lang.String r1 = ""
            goto L_0x0220
        L_0x0208:
            java.lang.String[] r1 = l
            r1 = r1[r13]
            goto L_0x0220
        L_0x020d:
            java.lang.String[] r1 = m
            r1 = r1[r13]
            goto L_0x0220
        L_0x0212:
            java.lang.String[] r1 = k
            r1 = r1[r13]
            goto L_0x0220
        L_0x0217:
            java.lang.String[] r1 = j
            r1 = r1[r13]
            goto L_0x0220
        L_0x021c:
            java.lang.String[] r1 = i
            r1 = r1[r13]
        L_0x0220:
            java.lang.String r12 = "CTRL_"
            boolean r12 = r1.startsWith(r12)
            if (r12 == 0) goto L_0x025c
            r8 = 5
            char r8 = r1.charAt(r8)
            r12 = 66
            if (r8 == r12) goto L_0x024e
            r12 = 68
            if (r8 == r12) goto L_0x024c
            r12 = 80
            if (r8 == r12) goto L_0x0249
            r12 = 76
            if (r8 == r12) goto L_0x0246
            r12 = 77
            if (r8 == r12) goto L_0x0243
            r8 = r4
            goto L_0x0250
        L_0x0243:
            a.d.c.p.c.a$a r8 = a.d.c.p.c.a.C0069a.MIXED
            goto L_0x0250
        L_0x0246:
            a.d.c.p.c.a$a r8 = a.d.c.p.c.a.C0069a.LOWER
            goto L_0x0250
        L_0x0249:
            a.d.c.p.c.a$a r8 = a.d.c.p.c.a.C0069a.PUNCT
            goto L_0x0250
        L_0x024c:
            r8 = r3
            goto L_0x0250
        L_0x024e:
            a.d.c.p.c.a$a r8 = a.d.c.p.c.a.C0069a.BINARY
        L_0x0250:
            r12 = 6
            char r1 = r1.charAt(r12)
            r12 = 83
            if (r1 != r12) goto L_0x0273
            r1 = 1
            r10 = 1
            goto L_0x0273
        L_0x025c:
            r15.append(r1)
            goto L_0x0273
        L_0x0260:
            int r1 = r5 - r6
            r12 = 8
            if (r1 >= r12) goto L_0x0269
        L_0x0266:
            r1 = 1
            r7 = 1
            goto L_0x0273
        L_0x0269:
            int r1 = b(r0, r6, r12)
            int r6 = r6 + 8
            char r1 = (char) r1
            r15.append(r1)
        L_0x0273:
            r1 = 2
            if (r11 == 0) goto L_0x01d7
            r8 = r9
            goto L_0x01d2
        L_0x0279:
            java.lang.String r15 = r15.toString()
            a.d.c.r.e r0 = new a.d.c.r.e
            r1 = 0
            r0.<init>(r1, r15, r1, r1)
            return r0
        L_0x0284:
            a.d.c.f r15 = a.d.c.f.f2869a
            throw r15
        L_0x0287:
            a.d.c.f r15 = a.d.c.f.f2869a
            throw r15
        L_0x028a:
            a.d.c.f r15 = a.d.c.f.f2869a
            goto L_0x028e
        L_0x028d:
            throw r15
        L_0x028e:
            goto L_0x028d
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.p.c.a.a(a.d.c.p.a):a.d.c.r.e");
    }
}

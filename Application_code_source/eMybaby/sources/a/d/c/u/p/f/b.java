package a.d.c.u.p.f;

import a.d.c.u.p.a;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.o00o0000o0;
import com.tuya.smart.common.o0oO0Ooo;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    public static final int[] j = {7, 5, 4, 3, 1};
    public static final int[] k = {4, 20, 52, 104, 204};
    public static final int[] l = {0, 348, 1388, 2948, 3988};
    public static final int[][] m = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    public static final int[][] n = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, AVFrame.MEDIA_CODEC_AUDIO_G726, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, AVFrame.MEDIA_CODEC_AUDIO_PCM, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, AVFrame.MEDIA_CODEC_AUDIO_MP3, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, o0oO0Ooo.O000O0Oo, 187, AVFrame.MEDIA_CODEC_AUDIO_ADPCM, o0oO0Ooo.O000O0o, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, o00o0000o0.O00000Oo, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, DrawerLayout.PEEK_DELAY, 58, 174, 100, 89}};
    public static final int[][] o;
    public static final int p;
    public final List<a> g = new ArrayList(11);
    public final int[] h = new int[2];
    public final int[] i = new int[p];

    static {
        int[][] iArr = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
        o = iArr;
        p = iArr[iArr.length - 1].length;
    }

    public static void m(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01be, code lost:
        r4 = new a.d.c.r.a(r2 * 12);
        r2 = r0.get(0).f3090c.f3081a;
        r8 = 11;
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01d6, code lost:
        if (r8 < 0) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01db, code lost:
        if (((1 << r8) & r2) == 0) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01dd, code lost:
        r4.f(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e0, code lost:
        r11 = r11 + 1;
        r8 = r8 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e5, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01ea, code lost:
        if (r2 >= r0.size()) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01ec, code lost:
        r8 = r0.get(r2);
        r12 = r8.f3089b.f3081a;
        r13 = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f8, code lost:
        if (r13 < 0) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01fd, code lost:
        if (((1 << r13) & r12) == 0) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ff, code lost:
        r4.f(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0202, code lost:
        r11 = r11 + 1;
        r13 = r13 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0207, code lost:
        r8 = r8.f3090c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0209, code lost:
        if (r8 == null) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x020b, code lost:
        r8 = r8.f3081a;
        r12 = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x020f, code lost:
        if (r12 < 0) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0214, code lost:
        if (((1 << r12) & r8) == 0) goto L_0x0219;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0216, code lost:
        r4.f(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0219, code lost:
        r11 = r11 + 1;
        r12 = r12 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x021e, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0226, code lost:
        if (r4.a(1) == false) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0228, code lost:
        r2 = new a.d.c.u.p.f.c.g(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0234, code lost:
        if (r4.a(2) != false) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0236, code lost:
        r2 = new a.d.c.u.p.f.c.k(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x023d, code lost:
        r2 = a.d.c.u.p.f.c.s.d(r4, 1, 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0241, code lost:
        if (r2 == 4) goto L_0x02bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0244, code lost:
        if (r2 == 5) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0246, code lost:
        r2 = a.d.c.u.p.f.c.s.d(r4, 1, 5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x024a, code lost:
        if (r2 == 12) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x024e, code lost:
        if (r2 == 13) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0261, code lost:
        switch(a.d.c.u.p.f.c.s.d(r4, 1, 7)) {
            case 56: goto L_0x02a5;
            case 57: goto L_0x029f;
            case 58: goto L_0x0299;
            case 59: goto L_0x0293;
            case 60: goto L_0x028d;
            case 61: goto L_0x0287;
            case 62: goto L_0x0281;
            case 63: goto L_0x027b;
            default: goto L_0x0264;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x027a, code lost:
        throw new java.lang.IllegalStateException("unknown decoder: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x027b, code lost:
        r2 = new a.d.c.u.p.f.c.e(r4, "320", "17");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0281, code lost:
        r2 = new a.d.c.u.p.f.c.e(r4, "310", "17");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0287, code lost:
        r2 = new a.d.c.u.p.f.c.e(r4, "320", "15");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x028d, code lost:
        r2 = new a.d.c.u.p.f.c.e(r4, "310", "15");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0293, code lost:
        r2 = new a.d.c.u.p.f.c.e(r4, "320", "13");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0299, code lost:
        r2 = new a.d.c.u.p.f.c.e(r4, "310", "13");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x029f, code lost:
        r2 = new a.d.c.u.p.f.c.e(r4, "320", "11");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02a5, code lost:
        r2 = new a.d.c.u.p.f.c.e(r4, "310", "11");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02ab, code lost:
        r2 = new a.d.c.u.p.f.c.d(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02b1, code lost:
        r2 = new a.d.c.u.p.f.c.c(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02b7, code lost:
        r2 = new a.d.c.u.p.f.c.b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02bd, code lost:
        r2 = new a.d.c.u.p.f.c.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02c2, code lost:
        r2 = r2.a();
        r3 = r0.get(0).f3091d.f3085c;
        r0 = r0.get(r0.size() - 1).f3091d.f3085c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02f9, code lost:
        return new a.d.c.l(r2, (byte[]) null, new a.d.c.n[]{r3[0], r3[1], r0[0], r0[1]}, a.d.c.a.RSS_EXPANDED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02fc, code lost:
        if (r3.f3090c != null) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02fe, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02ff, code lost:
        if (r5 != false) goto L_0x0303;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0305, code lost:
        throw a.d.c.i.f2874a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0306, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0307, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x030d, code lost:
        throw a.d.c.i.f2874a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0310, code lost:
        throw a.d.c.i.f2874a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f7, code lost:
        r7 = r0.size() + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ff, code lost:
        if (r7 > r1.i.length) goto L_0x030e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0101, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (r8 >= r0.size()) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0108, code lost:
        r1.i[r8] = r0.get(r8).f3091d.f3083a;
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0119, code lost:
        r1.i[r7 - 1] = r4.f3083a;
        r0 = o;
        r8 = r0.length;
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0125, code lost:
        if (r11 >= r8) goto L_0x030b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0127, code lost:
        r12 = r0[r11];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012a, code lost:
        if (r12.length < r7) goto L_0x0307;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012c, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012d, code lost:
        if (r13 >= r7) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0135, code lost:
        if (r1.i[r13] == r12[r13]) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0137, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0139, code lost:
        r13 = r13 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x013c, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x013d, code lost:
        if (r13 == false) goto L_0x0307;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (r7 != r12.length) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0142, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0144, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0145, code lost:
        r8 = l(r2, r4, r3, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r0 = l(r2, r4, r3, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x014f, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0150, code lost:
        if (r7 != false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0152, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0153, code lost:
        r3 = new a.d.c.u.p.f.a(r8, r0, r4, r7);
        r1.g.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x015f, code lost:
        if (r3.f3088a == false) goto L_0x0009;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0161, code lost:
        r0 = r1.g.get(0);
        r4 = r0.f3089b;
        r7 = r0.f3090c.f3082b;
        r0 = 2;
        r8 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0178, code lost:
        if (r8 >= r1.g.size()) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x017a, code lost:
        r11 = r1.g.get(r8);
        r7 = r7 + r11.f3089b.f3082b;
        r0 = r0 + 1;
        r11 = r11.f3090c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x018b, code lost:
        if (r11 == null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x018d, code lost:
        r7 = r7 + r11.f3082b;
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0192, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x019e, code lost:
        if ((((r0 - 4) * 211) + (r7 % 211)) != r4.f3081a) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01a0, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01a2, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01a3, code lost:
        if (r0 == false) goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a5, code lost:
        r0 = r1.g;
        r2 = (r0.size() << 1) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ba, code lost:
        if (r0.get(r0.size() - 1).f3090c != null) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01bc, code lost:
        r2 = r2 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.l b(int r19, a.d.c.r.a r20, java.util.Map<a.d.c.e, ?> r21) {
        /*
            r18 = this;
            r1 = r18
            r2 = r20
            java.util.List<a.d.c.u.p.f.a> r0 = r1.g
            r0.clear()
        L_0x0009:
            java.util.List<a.d.c.u.p.f.a> r0 = r1.g
            int r3 = r0.size()
            r4 = 2
            int r3 = r3 % r4
            r5 = 0
            r6 = 1
            if (r3 != 0) goto L_0x0017
            r3 = 1
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            r7 = -1
            r8 = 1
        L_0x001a:
            int[] r9 = r1.f3076a
            r9[r5] = r5
            r9[r6] = r5
            r9[r4] = r5
            r10 = 3
            r9[r10] = r5
            int r11 = r2.f2965b
            if (r7 < 0) goto L_0x002b
            r12 = r7
            goto L_0x0044
        L_0x002b:
            boolean r12 = r0.isEmpty()
            if (r12 == 0) goto L_0x0033
            r12 = 0
            goto L_0x0044
        L_0x0033:
            int r12 = r0.size()
            int r12 = r12 - r6
            java.lang.Object r12 = r0.get(r12)
            a.d.c.u.p.f.a r12 = (a.d.c.u.p.f.a) r12
            a.d.c.u.p.c r12 = r12.f3091d
            int[] r12 = r12.f3084b
            r12 = r12[r6]
        L_0x0044:
            int r13 = r0.size()
            int r13 = r13 % r4
            if (r13 == 0) goto L_0x004d
            r13 = 1
            goto L_0x004e
        L_0x004d:
            r13 = 0
        L_0x004e:
            r14 = 0
        L_0x004f:
            if (r12 >= r11) goto L_0x005c
            boolean r14 = r2.a(r12)
            r14 = r14 ^ r6
            if (r14 != 0) goto L_0x0059
            goto L_0x005c
        L_0x0059:
            int r12 = r12 + 1
            goto L_0x004f
        L_0x005c:
            r15 = r14
            r4 = 0
            r14 = r12
        L_0x005f:
            if (r12 >= r11) goto L_0x033e
            boolean r16 = r2.a(r12)
            r16 = r16 ^ r15
            if (r16 == 0) goto L_0x0073
            r16 = r9[r4]
            int r16 = r16 + 1
            r9[r4] = r16
            r16 = 2
            goto L_0x033a
        L_0x0073:
            if (r4 != r10) goto L_0x0332
            if (r13 == 0) goto L_0x007a
            m(r9)
        L_0x007a:
            boolean r16 = a.d.c.u.p.a.j(r9)
            if (r16 == 0) goto L_0x0314
            int[] r4 = r1.h
            r4[r5] = r14
            r4[r6] = r12
            if (r3 == 0) goto L_0x00a3
            r4 = r4[r5]
            int r4 = r4 - r6
        L_0x008b:
            if (r4 < 0) goto L_0x0096
            boolean r9 = r2.a(r4)
            if (r9 != 0) goto L_0x0096
            int r4 = r4 + -1
            goto L_0x008b
        L_0x0096:
            int r4 = r4 + 1
            int[] r9 = r1.h
            r11 = r9[r5]
            int r11 = r11 - r4
            r9 = r9[r6]
            r15 = r4
            r16 = r9
            goto L_0x00b5
        L_0x00a3:
            r9 = r4[r5]
            r4 = r4[r6]
            int r4 = r4 + r6
            int r4 = r2.c(r4)
            int[] r11 = r1.h
            r11 = r11[r6]
            int r11 = r4 - r11
            r16 = r4
            r15 = r9
        L_0x00b5:
            int[] r4 = r1.f3076a
            int r9 = r4.length
            int r9 = r9 - r6
            java.lang.System.arraycopy(r4, r5, r4, r6, r9)
            r4[r5] = r11
            r9 = 0
            int[][] r11 = m     // Catch:{ i -> 0x00d5 }
            int r13 = a.d.c.u.p.a.k(r4, r11)     // Catch:{ i -> 0x00d5 }
            a.d.c.u.p.c r4 = new a.d.c.u.p.c
            r11 = 2
            int[] r14 = new int[r11]
            r14[r5] = r15
            r14[r6] = r16
            r12 = r4
            r17 = r19
            r12.<init>(r13, r14, r15, r16, r17)
            goto L_0x00d6
        L_0x00d5:
            r4 = r9
        L_0x00d6:
            if (r4 != 0) goto L_0x00f4
            int[] r7 = r1.h
            r7 = r7[r5]
            boolean r11 = r2.a(r7)
            if (r11 == 0) goto L_0x00eb
            int r7 = r2.c(r7)
            int r7 = r2.b(r7)
            goto L_0x00f5
        L_0x00eb:
            int r7 = r2.b(r7)
            int r7 = r2.c(r7)
            goto L_0x00f5
        L_0x00f4:
            r8 = 0
        L_0x00f5:
            if (r8 != 0) goto L_0x0311
            int r7 = r0.size()
            int r7 = r7 + r6
            int[] r8 = r1.i
            int r8 = r8.length
            if (r7 > r8) goto L_0x030e
            r8 = 0
        L_0x0102:
            int r11 = r0.size()
            if (r8 >= r11) goto L_0x0119
            int[] r11 = r1.i
            java.lang.Object r12 = r0.get(r8)
            a.d.c.u.p.f.a r12 = (a.d.c.u.p.f.a) r12
            a.d.c.u.p.c r12 = r12.f3091d
            int r12 = r12.f3083a
            r11[r8] = r12
            int r8 = r8 + 1
            goto L_0x0102
        L_0x0119:
            int[] r0 = r1.i
            int r8 = r7 + -1
            int r11 = r4.f3083a
            r0[r8] = r11
            int[][] r0 = o
            int r8 = r0.length
            r11 = 0
        L_0x0125:
            if (r11 >= r8) goto L_0x030b
            r12 = r0[r11]
            int r13 = r12.length
            if (r13 < r7) goto L_0x0307
            r13 = 0
        L_0x012d:
            if (r13 >= r7) goto L_0x013c
            int[] r14 = r1.i
            r14 = r14[r13]
            r15 = r12[r13]
            if (r14 == r15) goto L_0x0139
            r13 = 0
            goto L_0x013d
        L_0x0139:
            int r13 = r13 + 1
            goto L_0x012d
        L_0x013c:
            r13 = 1
        L_0x013d:
            if (r13 == 0) goto L_0x0307
            int r0 = r12.length
            if (r7 != r0) goto L_0x0144
            r7 = 1
            goto L_0x0145
        L_0x0144:
            r7 = 0
        L_0x0145:
            a.d.c.u.p.b r8 = r1.l(r2, r4, r3, r6)
            a.d.c.u.p.b r0 = r1.l(r2, r4, r3, r5)     // Catch:{ i -> 0x014e }
            goto L_0x0153
        L_0x014e:
            r0 = move-exception
            r3 = r0
            if (r7 == 0) goto L_0x0306
            r0 = r9
        L_0x0153:
            a.d.c.u.p.f.a r3 = new a.d.c.u.p.f.a
            r3.<init>(r8, r0, r4, r7)
            java.util.List<a.d.c.u.p.f.a> r0 = r1.g
            r0.add(r3)
            boolean r0 = r3.f3088a
            if (r0 == 0) goto L_0x0009
            java.util.List<a.d.c.u.p.f.a> r0 = r1.g
            java.lang.Object r0 = r0.get(r5)
            a.d.c.u.p.f.a r0 = (a.d.c.u.p.f.a) r0
            a.d.c.u.p.b r4 = r0.f3089b
            a.d.c.u.p.b r0 = r0.f3090c
            int r0 = r0.f3082b
            r7 = r0
            r0 = 2
            r8 = 1
        L_0x0172:
            java.util.List<a.d.c.u.p.f.a> r11 = r1.g
            int r11 = r11.size()
            if (r8 >= r11) goto L_0x0195
            java.util.List<a.d.c.u.p.f.a> r11 = r1.g
            java.lang.Object r11 = r11.get(r8)
            a.d.c.u.p.f.a r11 = (a.d.c.u.p.f.a) r11
            a.d.c.u.p.b r12 = r11.f3089b
            int r12 = r12.f3082b
            int r7 = r7 + r12
            int r0 = r0 + 1
            a.d.c.u.p.b r11 = r11.f3090c
            if (r11 == 0) goto L_0x0192
            int r11 = r11.f3082b
            int r7 = r7 + r11
            int r0 = r0 + 1
        L_0x0192:
            int r8 = r8 + 1
            goto L_0x0172
        L_0x0195:
            int r7 = r7 % 211
            int r0 = r0 + -4
            int r0 = r0 * 211
            int r0 = r0 + r7
            int r4 = r4.f3081a
            if (r0 != r4) goto L_0x01a2
            r0 = 1
            goto L_0x01a3
        L_0x01a2:
            r0 = 0
        L_0x01a3:
            if (r0 == 0) goto L_0x02fa
            java.util.List<a.d.c.u.p.f.a> r0 = r1.g
            int r2 = r0.size()
            int r2 = r2 << r6
            int r2 = r2 - r6
            int r3 = r0.size()
            int r3 = r3 - r6
            java.lang.Object r3 = r0.get(r3)
            a.d.c.u.p.f.a r3 = (a.d.c.u.p.f.a) r3
            a.d.c.u.p.b r3 = r3.f3090c
            if (r3 != 0) goto L_0x01be
            int r2 = r2 + -1
        L_0x01be:
            r3 = 12
            int r2 = r2 * 12
            a.d.c.r.a r4 = new a.d.c.r.a
            r4.<init>(r2)
            java.lang.Object r2 = r0.get(r5)
            a.d.c.u.p.f.a r2 = (a.d.c.u.p.f.a) r2
            a.d.c.u.p.b r2 = r2.f3090c
            int r2 = r2.f3081a
            r7 = 11
            r8 = 11
            r11 = 0
        L_0x01d6:
            if (r8 < 0) goto L_0x01e5
            int r12 = r6 << r8
            r12 = r12 & r2
            if (r12 == 0) goto L_0x01e0
            r4.f(r11)
        L_0x01e0:
            int r11 = r11 + 1
            int r8 = r8 + -1
            goto L_0x01d6
        L_0x01e5:
            r2 = 1
        L_0x01e6:
            int r8 = r0.size()
            if (r2 >= r8) goto L_0x0221
            java.lang.Object r8 = r0.get(r2)
            a.d.c.u.p.f.a r8 = (a.d.c.u.p.f.a) r8
            a.d.c.u.p.b r12 = r8.f3089b
            int r12 = r12.f3081a
            r13 = 11
        L_0x01f8:
            if (r13 < 0) goto L_0x0207
            int r14 = r6 << r13
            r14 = r14 & r12
            if (r14 == 0) goto L_0x0202
            r4.f(r11)
        L_0x0202:
            int r11 = r11 + 1
            int r13 = r13 + -1
            goto L_0x01f8
        L_0x0207:
            a.d.c.u.p.b r8 = r8.f3090c
            if (r8 == 0) goto L_0x021e
            int r8 = r8.f3081a
            r12 = 11
        L_0x020f:
            if (r12 < 0) goto L_0x021e
            int r13 = r6 << r12
            r13 = r13 & r8
            if (r13 == 0) goto L_0x0219
            r4.f(r11)
        L_0x0219:
            int r11 = r11 + 1
            int r12 = r12 + -1
            goto L_0x020f
        L_0x021e:
            int r2 = r2 + 1
            goto L_0x01e6
        L_0x0221:
            boolean r2 = r4.a(r6)
            r7 = 4
            if (r2 == 0) goto L_0x022f
            a.d.c.u.p.f.c.g r2 = new a.d.c.u.p.f.c.g
            r2.<init>(r4)
            goto L_0x02c2
        L_0x022f:
            r2 = 2
            boolean r8 = r4.a(r2)
            if (r8 != 0) goto L_0x023d
            a.d.c.u.p.f.c.k r2 = new a.d.c.u.p.f.c.k
            r2.<init>(r4)
            goto L_0x02c2
        L_0x023d:
            int r2 = a.d.c.u.p.f.c.s.d(r4, r6, r7)
            if (r2 == r7) goto L_0x02bd
            r8 = 5
            if (r2 == r8) goto L_0x02b7
            int r2 = a.d.c.u.p.f.c.s.d(r4, r6, r8)
            if (r2 == r3) goto L_0x02b1
            r3 = 13
            if (r2 == r3) goto L_0x02ab
            r2 = 7
            int r2 = a.d.c.u.p.f.c.s.d(r4, r6, r2)
            java.lang.String r3 = "17"
            java.lang.String r8 = "15"
            java.lang.String r11 = "13"
            java.lang.String r12 = "11"
            java.lang.String r13 = "320"
            java.lang.String r14 = "310"
            switch(r2) {
                case 56: goto L_0x02a5;
                case 57: goto L_0x029f;
                case 58: goto L_0x0299;
                case 59: goto L_0x0293;
                case 60: goto L_0x028d;
                case 61: goto L_0x0287;
                case 62: goto L_0x0281;
                case 63: goto L_0x027b;
                default: goto L_0x0264;
            }
        L_0x0264:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "unknown decoder: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x027b:
            a.d.c.u.p.f.c.e r2 = new a.d.c.u.p.f.c.e
            r2.<init>(r4, r13, r3)
            goto L_0x02c2
        L_0x0281:
            a.d.c.u.p.f.c.e r2 = new a.d.c.u.p.f.c.e
            r2.<init>(r4, r14, r3)
            goto L_0x02c2
        L_0x0287:
            a.d.c.u.p.f.c.e r2 = new a.d.c.u.p.f.c.e
            r2.<init>(r4, r13, r8)
            goto L_0x02c2
        L_0x028d:
            a.d.c.u.p.f.c.e r2 = new a.d.c.u.p.f.c.e
            r2.<init>(r4, r14, r8)
            goto L_0x02c2
        L_0x0293:
            a.d.c.u.p.f.c.e r2 = new a.d.c.u.p.f.c.e
            r2.<init>(r4, r13, r11)
            goto L_0x02c2
        L_0x0299:
            a.d.c.u.p.f.c.e r2 = new a.d.c.u.p.f.c.e
            r2.<init>(r4, r14, r11)
            goto L_0x02c2
        L_0x029f:
            a.d.c.u.p.f.c.e r2 = new a.d.c.u.p.f.c.e
            r2.<init>(r4, r13, r12)
            goto L_0x02c2
        L_0x02a5:
            a.d.c.u.p.f.c.e r2 = new a.d.c.u.p.f.c.e
            r2.<init>(r4, r14, r12)
            goto L_0x02c2
        L_0x02ab:
            a.d.c.u.p.f.c.d r2 = new a.d.c.u.p.f.c.d
            r2.<init>(r4)
            goto L_0x02c2
        L_0x02b1:
            a.d.c.u.p.f.c.c r2 = new a.d.c.u.p.f.c.c
            r2.<init>(r4)
            goto L_0x02c2
        L_0x02b7:
            a.d.c.u.p.f.c.b r2 = new a.d.c.u.p.f.c.b
            r2.<init>(r4)
            goto L_0x02c2
        L_0x02bd:
            a.d.c.u.p.f.c.a r2 = new a.d.c.u.p.f.c.a
            r2.<init>(r4)
        L_0x02c2:
            java.lang.String r2 = r2.a()
            java.lang.Object r3 = r0.get(r5)
            a.d.c.u.p.f.a r3 = (a.d.c.u.p.f.a) r3
            a.d.c.u.p.c r3 = r3.f3091d
            a.d.c.n[] r3 = r3.f3085c
            int r4 = r0.size()
            int r4 = r4 - r6
            java.lang.Object r0 = r0.get(r4)
            a.d.c.u.p.f.a r0 = (a.d.c.u.p.f.a) r0
            a.d.c.u.p.c r0 = r0.f3091d
            a.d.c.n[] r0 = r0.f3085c
            a.d.c.l r4 = new a.d.c.l
            a.d.c.n[] r7 = new a.d.c.n[r7]
            r8 = r3[r5]
            r7[r5] = r8
            r3 = r3[r6]
            r7[r6] = r3
            r3 = r0[r5]
            r5 = 2
            r7[r5] = r3
            r0 = r0[r6]
            r7[r10] = r0
            a.d.c.a r0 = a.d.c.a.RSS_EXPANDED
            r4.<init>(r2, r9, r7, r0)
            return r4
        L_0x02fa:
            a.d.c.u.p.b r0 = r3.f3090c
            if (r0 != 0) goto L_0x02ff
            r5 = 1
        L_0x02ff:
            if (r5 != 0) goto L_0x0303
            goto L_0x0009
        L_0x0303:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x0306:
            throw r3
        L_0x0307:
            int r11 = r11 + 1
            goto L_0x0125
        L_0x030b:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x030e:
            a.d.c.i r0 = a.d.c.i.f2874a
            throw r0
        L_0x0311:
            r4 = 2
            goto L_0x001a
        L_0x0314:
            if (r13 == 0) goto L_0x0319
            m(r9)
        L_0x0319:
            r16 = r9[r5]
            r17 = r9[r6]
            int r16 = r16 + r17
            int r14 = r16 + r14
            r16 = 2
            r17 = r9[r16]
            r9[r5] = r17
            r17 = r9[r10]
            r9[r6] = r17
            r9[r16] = r5
            r9[r10] = r5
            int r4 = r4 + -1
            goto L_0x0336
        L_0x0332:
            r16 = 2
            int r4 = r4 + 1
        L_0x0336:
            r9[r4] = r6
            r15 = r15 ^ 1
        L_0x033a:
            int r12 = r12 + 1
            goto L_0x005f
        L_0x033e:
            a.d.c.i r0 = a.d.c.i.f2874a
            goto L_0x0342
        L_0x0341:
            throw r0
        L_0x0342:
            goto L_0x0341
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.p.f.b.b(int, a.d.c.r.a, java.util.Map):a.d.c.l");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0184 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.u.p.b l(a.d.c.r.a r18, a.d.c.u.p.c r19, boolean r20, boolean r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            int[] r3 = r0.f3077b
            r4 = 0
            r3[r4] = r4
            r5 = 1
            r3[r5] = r4
            r6 = 2
            r3[r6] = r4
            r7 = 3
            r3[r7] = r4
            r7 = 4
            r3[r7] = r4
            r8 = 5
            r3[r8] = r4
            r8 = 6
            r3[r8] = r4
            r8 = 7
            r3[r8] = r4
            if (r21 == 0) goto L_0x002a
            int[] r8 = r2.f3084b
            r8 = r8[r4]
            a.d.c.u.k.f(r1, r8, r3)
            goto L_0x0044
        L_0x002a:
            int[] r8 = r2.f3084b
            r8 = r8[r5]
            int r8 = r8 + r5
            a.d.c.u.k.e(r1, r8, r3)
            int r1 = r3.length
            int r1 = r1 - r5
            r8 = 0
        L_0x0035:
            if (r8 >= r1) goto L_0x0044
            r9 = r3[r8]
            r10 = r3[r1]
            r3[r8] = r10
            r3[r1] = r9
            int r8 = r8 + 1
            int r1 = r1 + -1
            goto L_0x0035
        L_0x0044:
            r1 = 17
            int r8 = a.d.c.u.p.a.g(r3)
            float r8 = (float) r8
            float r9 = (float) r1
            float r8 = r8 / r9
            int[] r9 = r0.f3080e
            int[] r10 = r0.f
            float[] r11 = r0.f3078c
            float[] r12 = r0.f3079d
            r13 = 0
        L_0x0056:
            int r14 = r3.length
            if (r13 >= r14) goto L_0x0086
            r14 = 1065353216(0x3f800000, float:1.0)
            r15 = r3[r13]
            float r15 = (float) r15
            float r15 = r15 * r14
            float r15 = r15 / r8
            r14 = 1056964608(0x3f000000, float:0.5)
            float r14 = r14 + r15
            int r14 = (int) r14
            r4 = 8
            if (r14 >= r5) goto L_0x006b
            r14 = 1
            goto L_0x006f
        L_0x006b:
            if (r14 <= r4) goto L_0x006f
            r14 = 8
        L_0x006f:
            int r4 = r13 >> 1
            r16 = r13 & 1
            if (r16 != 0) goto L_0x007c
            r9[r4] = r14
            float r14 = (float) r14
            float r15 = r15 - r14
            r11[r4] = r15
            goto L_0x0082
        L_0x007c:
            r10[r4] = r14
            float r14 = (float) r14
            float r15 = r15 - r14
            r12[r4] = r15
        L_0x0082:
            int r13 = r13 + 1
            r4 = 0
            goto L_0x0056
        L_0x0086:
            int[] r3 = r0.f3080e
            int r3 = a.d.c.u.p.a.g(r3)
            int[] r4 = r0.f
            int r4 = a.d.c.u.p.a.g(r4)
            int r8 = r3 + r4
            int r8 = r8 - r1
            r1 = r3 & 1
            if (r1 != r5) goto L_0x009b
            r1 = 1
            goto L_0x009c
        L_0x009b:
            r1 = 0
        L_0x009c:
            r11 = r4 & 1
            if (r11 != 0) goto L_0x00a2
            r11 = 1
            goto L_0x00a3
        L_0x00a2:
            r11 = 0
        L_0x00a3:
            r12 = 13
            if (r3 <= r12) goto L_0x00aa
            r13 = 0
            r14 = 1
            goto L_0x00b0
        L_0x00aa:
            if (r3 >= r7) goto L_0x00ae
            r13 = 1
            goto L_0x00af
        L_0x00ae:
            r13 = 0
        L_0x00af:
            r14 = 0
        L_0x00b0:
            if (r4 <= r12) goto L_0x00b6
            r15 = 0
            r16 = 1
            goto L_0x00bd
        L_0x00b6:
            if (r4 >= r7) goto L_0x00ba
            r15 = 1
            goto L_0x00bb
        L_0x00ba:
            r15 = 0
        L_0x00bb:
            r16 = 0
        L_0x00bd:
            if (r8 != r5) goto L_0x00cd
            if (r1 == 0) goto L_0x00c7
            if (r11 != 0) goto L_0x00c4
            goto L_0x00ed
        L_0x00c4:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00c7:
            if (r11 == 0) goto L_0x00ca
            goto L_0x00e9
        L_0x00ca:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00cd:
            r6 = -1
            if (r8 != r6) goto L_0x00e0
            if (r1 == 0) goto L_0x00d9
            if (r11 != 0) goto L_0x00d6
            r13 = 1
            goto L_0x00f4
        L_0x00d6:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00d9:
            if (r11 == 0) goto L_0x00dd
            r15 = 1
            goto L_0x00f4
        L_0x00dd:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00e0:
            if (r8 != 0) goto L_0x01b2
            if (r1 == 0) goto L_0x00f2
            if (r11 == 0) goto L_0x00ef
            if (r3 >= r4) goto L_0x00ec
            r13 = 1
        L_0x00e9:
            r16 = 1
            goto L_0x00f4
        L_0x00ec:
            r15 = 1
        L_0x00ed:
            r14 = 1
            goto L_0x00f4
        L_0x00ef:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00f2:
            if (r11 != 0) goto L_0x01af
        L_0x00f4:
            if (r13 == 0) goto L_0x0103
            if (r14 != 0) goto L_0x0100
            int[] r1 = r0.f3080e
            float[] r3 = r0.f3078c
            a.d.c.u.p.a.i(r1, r3)
            goto L_0x0103
        L_0x0100:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0103:
            if (r14 == 0) goto L_0x010c
            int[] r1 = r0.f3080e
            float[] r3 = r0.f3078c
            a.d.c.u.p.a.h(r1, r3)
        L_0x010c:
            if (r15 == 0) goto L_0x011b
            if (r16 != 0) goto L_0x0118
            int[] r1 = r0.f
            float[] r3 = r0.f3078c
            a.d.c.u.p.a.i(r1, r3)
            goto L_0x011b
        L_0x0118:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x011b:
            if (r16 == 0) goto L_0x0124
            int[] r1 = r0.f
            float[] r3 = r0.f3079d
            a.d.c.u.p.a.h(r1, r3)
        L_0x0124:
            int r1 = r2.f3083a
            int r1 = r1 * 4
            if (r20 == 0) goto L_0x012c
            r3 = 0
            goto L_0x012d
        L_0x012c:
            r3 = 2
        L_0x012d:
            int r1 = r1 + r3
            r3 = r21 ^ 1
            int r1 = r1 + r3
            int r1 = r1 - r5
            int r3 = r9.length
            int r3 = r3 - r5
            r4 = 0
            r6 = 0
        L_0x0136:
            if (r3 < 0) goto L_0x0159
            int r8 = r2.f3083a
            if (r8 != 0) goto L_0x0143
            if (r20 == 0) goto L_0x0143
            if (r21 != 0) goto L_0x0141
            goto L_0x0143
        L_0x0141:
            r8 = 0
            goto L_0x0144
        L_0x0143:
            r8 = 1
        L_0x0144:
            if (r8 == 0) goto L_0x0153
            int[][] r8 = n
            r8 = r8[r1]
            int r11 = r3 * 2
            r8 = r8[r11]
            r11 = r9[r3]
            int r11 = r11 * r8
            int r4 = r4 + r11
        L_0x0153:
            r8 = r9[r3]
            int r6 = r6 + r8
            int r3 = r3 + -1
            goto L_0x0136
        L_0x0159:
            int r3 = r10.length
            int r3 = r3 - r5
            r8 = 0
        L_0x015c:
            if (r3 < 0) goto L_0x017f
            int r11 = r2.f3083a
            if (r11 != 0) goto L_0x0169
            if (r20 == 0) goto L_0x0169
            if (r21 != 0) goto L_0x0167
            goto L_0x0169
        L_0x0167:
            r11 = 0
            goto L_0x016a
        L_0x0169:
            r11 = 1
        L_0x016a:
            if (r11 == 0) goto L_0x017a
            int[][] r11 = n
            r11 = r11[r1]
            int r13 = r3 * 2
            int r13 = r13 + r5
            r11 = r11[r13]
            r13 = r10[r3]
            int r13 = r13 * r11
            int r8 = r8 + r13
        L_0x017a:
            r11 = r10[r3]
            int r3 = r3 + -1
            goto L_0x015c
        L_0x017f:
            int r4 = r4 + r8
            r1 = r6 & 1
            if (r1 != 0) goto L_0x01ac
            if (r6 > r12) goto L_0x01ac
            if (r6 < r7) goto L_0x01ac
            int r12 = r12 - r6
            r1 = 2
            int r12 = r12 / r1
            int[] r1 = j
            r1 = r1[r12]
            int r2 = 9 - r1
            int r1 = a.c.a.f.b.I(r9, r1, r5)
            r3 = 0
            int r2 = a.c.a.f.b.I(r10, r2, r3)
            int[] r3 = k
            r3 = r3[r12]
            int[] r5 = l
            r5 = r5[r12]
            int r1 = r1 * r3
            int r1 = r1 + r2
            int r1 = r1 + r5
            a.d.c.u.p.b r2 = new a.d.c.u.p.b
            r2.<init>(r1, r4)
            return r2
        L_0x01ac:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x01af:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x01b2:
            a.d.c.i r1 = a.d.c.i.f2874a
            goto L_0x01b6
        L_0x01b5:
            throw r1
        L_0x01b6:
            goto L_0x01b5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.p.f.b.l(a.d.c.r.a, a.d.c.u.p.c, boolean, boolean):a.d.c.u.p.b");
    }

    public void reset() {
        this.g.clear();
    }
}

package a.d.c.w.c;

import a.d.c.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final a.d.c.r.b f3181a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d> f3182b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f3183c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f3184d = new int[5];

    /* renamed from: e  reason: collision with root package name */
    public final o f3185e;

    public static class b implements Comparator<d>, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final float f3186a;

        public b(float f, a aVar) {
            this.f3186a = f;
        }

        public int compare(Object obj, Object obj2) {
            d dVar = (d) obj;
            d dVar2 = (d) obj2;
            int i = dVar2.f3180d;
            int i2 = dVar.f3180d;
            if (i != i2) {
                return i - i2;
            }
            float abs = Math.abs(dVar2.f3179c - this.f3186a);
            float abs2 = Math.abs(dVar.f3179c - this.f3186a);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    public static class c implements Comparator<d>, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final float f3187a;

        public c(float f, a aVar) {
            this.f3187a = f;
        }

        public int compare(Object obj, Object obj2) {
            float abs = Math.abs(((d) obj2).f3179c - this.f3187a);
            float abs2 = Math.abs(((d) obj).f3179c - this.f3187a);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    public e(a.d.c.r.b bVar, o oVar) {
        this.f3181a = bVar;
        this.f3185e = oVar;
    }

    public static float a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        r2 = (r2 << 8) / 7;
        r1 = r2 / 2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(int[] r6) {
        /*
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x0003:
            r3 = 5
            if (r1 >= r3) goto L_0x000f
            r3 = r6[r1]
            if (r3 != 0) goto L_0x000b
            return r0
        L_0x000b:
            int r2 = r2 + r3
            int r1 = r1 + 1
            goto L_0x0003
        L_0x000f:
            r1 = 7
            if (r2 >= r1) goto L_0x0013
            return r0
        L_0x0013:
            int r2 = r2 << 8
            int r2 = r2 / r1
            int r1 = r2 / 2
            r3 = r6[r0]
            int r3 = r3 << 8
            int r3 = r2 - r3
            int r3 = java.lang.Math.abs(r3)
            r4 = 1
            if (r3 >= r1) goto L_0x005b
            r3 = r6[r4]
            int r3 = r3 << 8
            int r3 = r2 - r3
            int r3 = java.lang.Math.abs(r3)
            if (r3 >= r1) goto L_0x005b
            int r3 = r2 * 3
            r5 = 2
            r5 = r6[r5]
            int r5 = r5 << 8
            int r3 = r3 - r5
            int r3 = java.lang.Math.abs(r3)
            int r5 = r1 * 3
            if (r3 >= r5) goto L_0x005b
            r3 = 3
            r3 = r6[r3]
            int r3 = r3 << 8
            int r3 = r2 - r3
            int r3 = java.lang.Math.abs(r3)
            if (r3 >= r1) goto L_0x005b
            r3 = 4
            r6 = r6[r3]
            int r6 = r6 << 8
            int r2 = r2 - r6
            int r6 = java.lang.Math.abs(r2)
            if (r6 >= r1) goto L_0x005b
            r0 = 1
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.w.c.e.b(int[]):boolean");
    }

    public final int[] c() {
        int[] iArr = this.f3184d;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x021e A[LOOP:12: B:109:0x01b9->B:123:0x021e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01fa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(int[] r18, int r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            r3 = r1[r2]
            r4 = 1
            r5 = r1[r4]
            int r3 = r3 + r5
            r5 = 2
            r6 = r1[r5]
            int r3 = r3 + r6
            r6 = 3
            r7 = r1[r6]
            int r3 = r3 + r7
            r7 = 4
            r8 = r1[r7]
            int r3 = r3 + r8
            r8 = r20
            float r8 = a(r1, r8)
            int r8 = (int) r8
            r9 = r1[r5]
            a.d.c.r.b r10 = r0.f3181a
            int r11 = r10.f2967b
            int[] r12 = r17.c()
            r13 = r19
        L_0x002a:
            if (r13 < 0) goto L_0x003a
            boolean r14 = r10.a(r8, r13)
            if (r14 == 0) goto L_0x003a
            r14 = r12[r5]
            int r14 = r14 + r4
            r12[r5] = r14
            int r13 = r13 + -1
            goto L_0x002a
        L_0x003a:
            if (r13 >= 0) goto L_0x003e
            goto L_0x00e2
        L_0x003e:
            if (r13 < 0) goto L_0x0052
            boolean r15 = r10.a(r8, r13)
            if (r15 != 0) goto L_0x0052
            r15 = r12[r4]
            if (r15 > r9) goto L_0x0052
            r15 = r12[r4]
            int r15 = r15 + r4
            r12[r4] = r15
            int r13 = r13 + -1
            goto L_0x003e
        L_0x0052:
            if (r13 < 0) goto L_0x00e2
            r15 = r12[r4]
            if (r15 <= r9) goto L_0x005a
            goto L_0x00e2
        L_0x005a:
            if (r13 < 0) goto L_0x006e
            boolean r15 = r10.a(r8, r13)
            if (r15 == 0) goto L_0x006e
            r15 = r12[r2]
            if (r15 > r9) goto L_0x006e
            r15 = r12[r2]
            int r15 = r15 + r4
            r12[r2] = r15
            int r13 = r13 + -1
            goto L_0x005a
        L_0x006e:
            r13 = r12[r2]
            if (r13 <= r9) goto L_0x0074
            goto L_0x00e2
        L_0x0074:
            int r13 = r19 + 1
        L_0x0076:
            if (r13 >= r11) goto L_0x0086
            boolean r15 = r10.a(r8, r13)
            if (r15 == 0) goto L_0x0086
            r15 = r12[r5]
            int r15 = r15 + r4
            r12[r5] = r15
            int r13 = r13 + 1
            goto L_0x0076
        L_0x0086:
            if (r13 != r11) goto L_0x0089
            goto L_0x00e2
        L_0x0089:
            if (r13 >= r11) goto L_0x009d
            boolean r15 = r10.a(r8, r13)
            if (r15 != 0) goto L_0x009d
            r15 = r12[r6]
            if (r15 >= r9) goto L_0x009d
            r15 = r12[r6]
            int r15 = r15 + r4
            r12[r6] = r15
            int r13 = r13 + 1
            goto L_0x0089
        L_0x009d:
            if (r13 == r11) goto L_0x00e2
            r15 = r12[r6]
            if (r15 < r9) goto L_0x00a4
            goto L_0x00e2
        L_0x00a4:
            if (r13 >= r11) goto L_0x00b8
            boolean r15 = r10.a(r8, r13)
            if (r15 == 0) goto L_0x00b8
            r15 = r12[r7]
            if (r15 >= r9) goto L_0x00b8
            r15 = r12[r7]
            int r15 = r15 + r4
            r12[r7] = r15
            int r13 = r13 + 1
            goto L_0x00a4
        L_0x00b8:
            r10 = r12[r7]
            if (r10 < r9) goto L_0x00bd
            goto L_0x00e2
        L_0x00bd:
            r9 = r12[r2]
            r10 = r12[r4]
            int r9 = r9 + r10
            r10 = r12[r5]
            int r9 = r9 + r10
            r10 = r12[r6]
            int r9 = r9 + r10
            r10 = r12[r7]
            int r9 = r9 + r10
            int r9 = r9 - r3
            int r9 = java.lang.Math.abs(r9)
            int r9 = r9 * 5
            int r10 = r3 * 2
            if (r9 < r10) goto L_0x00d7
            goto L_0x00e2
        L_0x00d7:
            boolean r9 = b(r12)
            if (r9 == 0) goto L_0x00e2
            float r9 = a(r12, r13)
            goto L_0x00e4
        L_0x00e2:
            r9 = 2143289344(0x7fc00000, float:NaN)
        L_0x00e4:
            boolean r10 = java.lang.Float.isNaN(r9)
            if (r10 != 0) goto L_0x0235
            int r10 = (int) r9
            r1 = r1[r5]
            a.d.c.r.b r11 = r0.f3181a
            int r12 = r11.f2966a
            int[] r13 = r17.c()
            r15 = r8
        L_0x00f6:
            if (r15 < 0) goto L_0x0107
            boolean r16 = r11.a(r15, r10)
            if (r16 == 0) goto L_0x0107
            r16 = r13[r5]
            int r16 = r16 + 1
            r13[r5] = r16
            int r15 = r15 + -1
            goto L_0x00f6
        L_0x0107:
            if (r15 >= 0) goto L_0x010b
            goto L_0x01ac
        L_0x010b:
            if (r15 < 0) goto L_0x011f
            boolean r16 = r11.a(r15, r10)
            if (r16 != 0) goto L_0x011f
            r14 = r13[r4]
            if (r14 > r1) goto L_0x011f
            r14 = r13[r4]
            int r14 = r14 + r4
            r13[r4] = r14
            int r15 = r15 + -1
            goto L_0x010b
        L_0x011f:
            if (r15 < 0) goto L_0x01ac
            r14 = r13[r4]
            if (r14 <= r1) goto L_0x0127
            goto L_0x01ac
        L_0x0127:
            if (r15 < 0) goto L_0x013b
            boolean r14 = r11.a(r15, r10)
            if (r14 == 0) goto L_0x013b
            r14 = r13[r2]
            if (r14 > r1) goto L_0x013b
            r14 = r13[r2]
            int r14 = r14 + r4
            r13[r2] = r14
            int r15 = r15 + -1
            goto L_0x0127
        L_0x013b:
            r14 = r13[r2]
            if (r14 <= r1) goto L_0x0141
            goto L_0x01ac
        L_0x0141:
            int r8 = r8 + r4
        L_0x0142:
            if (r8 >= r12) goto L_0x0152
            boolean r14 = r11.a(r8, r10)
            if (r14 == 0) goto L_0x0152
            r14 = r13[r5]
            int r14 = r14 + r4
            r13[r5] = r14
            int r8 = r8 + 1
            goto L_0x0142
        L_0x0152:
            if (r8 != r12) goto L_0x0155
            goto L_0x01ac
        L_0x0155:
            if (r8 >= r12) goto L_0x0169
            boolean r14 = r11.a(r8, r10)
            if (r14 != 0) goto L_0x0169
            r14 = r13[r6]
            if (r14 >= r1) goto L_0x0169
            r14 = r13[r6]
            int r14 = r14 + r4
            r13[r6] = r14
            int r8 = r8 + 1
            goto L_0x0155
        L_0x0169:
            if (r8 == r12) goto L_0x01ac
            r14 = r13[r6]
            if (r14 < r1) goto L_0x0170
            goto L_0x01ac
        L_0x0170:
            if (r8 >= r12) goto L_0x0184
            boolean r14 = r11.a(r8, r10)
            if (r14 == 0) goto L_0x0184
            r14 = r13[r7]
            if (r14 >= r1) goto L_0x0184
            r14 = r13[r7]
            int r14 = r14 + r4
            r13[r7] = r14
            int r8 = r8 + 1
            goto L_0x0170
        L_0x0184:
            r10 = r13[r7]
            if (r10 < r1) goto L_0x0189
            goto L_0x01ac
        L_0x0189:
            r1 = r13[r2]
            r10 = r13[r4]
            int r1 = r1 + r10
            r5 = r13[r5]
            int r1 = r1 + r5
            r5 = r13[r6]
            int r1 = r1 + r5
            r5 = r13[r7]
            int r1 = r1 + r5
            int r1 = r1 - r3
            int r1 = java.lang.Math.abs(r1)
            int r1 = r1 * 5
            if (r1 < r3) goto L_0x01a1
            goto L_0x01ac
        L_0x01a1:
            boolean r1 = b(r13)
            if (r1 == 0) goto L_0x01ac
            float r14 = a(r13, r8)
            goto L_0x01ae
        L_0x01ac:
            r14 = 2143289344(0x7fc00000, float:NaN)
        L_0x01ae:
            boolean r1 = java.lang.Float.isNaN(r14)
            if (r1 != 0) goto L_0x0235
            float r1 = (float) r3
            r3 = 1088421888(0x40e00000, float:7.0)
            float r1 = r1 / r3
            r3 = 0
        L_0x01b9:
            java.util.List<a.d.c.w.c.d> r5 = r0.f3182b
            int r5 = r5.size()
            if (r3 >= r5) goto L_0x0221
            java.util.List<a.d.c.w.c.d> r5 = r0.f3182b
            java.lang.Object r5 = r5.get(r3)
            a.d.c.w.c.d r5 = (a.d.c.w.c.d) r5
            float r6 = r5.f2886b
            float r6 = r9 - r6
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x01f7
            float r6 = r5.f2885a
            float r6 = r14 - r6
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x01f7
            float r6 = r5.f3179c
            float r6 = r1 - r6
            float r6 = java.lang.Math.abs(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x01f5
            float r7 = r5.f3179c
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 > 0) goto L_0x01f7
        L_0x01f5:
            r6 = 1
            goto L_0x01f8
        L_0x01f7:
            r6 = 0
        L_0x01f8:
            if (r6 == 0) goto L_0x021e
            java.util.List<a.d.c.w.c.d> r2 = r0.f3182b
            int r6 = r5.f3180d
            int r7 = r6 + 1
            float r6 = (float) r6
            float r8 = r5.f2885a
            float r8 = r8 * r6
            float r8 = r8 + r14
            float r10 = (float) r7
            float r8 = r8 / r10
            float r11 = r5.f2886b
            float r11 = r11 * r6
            float r11 = r11 + r9
            float r11 = r11 / r10
            float r5 = r5.f3179c
            float r6 = r6 * r5
            float r6 = r6 + r1
            float r6 = r6 / r10
            a.d.c.w.c.d r5 = new a.d.c.w.c.d
            r5.<init>(r8, r11, r6, r7)
            r2.set(r3, r5)
            r2 = 1
            goto L_0x0221
        L_0x021e:
            int r3 = r3 + 1
            goto L_0x01b9
        L_0x0221:
            if (r2 != 0) goto L_0x0234
            a.d.c.w.c.d r2 = new a.d.c.w.c.d
            r2.<init>(r14, r9, r1)
            java.util.List<a.d.c.w.c.d> r1 = r0.f3182b
            r1.add(r2)
            a.d.c.o r1 = r0.f3185e
            if (r1 == 0) goto L_0x0234
            r1.a(r2)
        L_0x0234:
            return r4
        L_0x0235:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.w.c.e.d(int[], int, int):boolean");
    }

    public final boolean e() {
        int size = this.f3182b.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (d next : this.f3182b) {
            if (next.f3180d >= 2) {
                i++;
                f2 += next.f3179c;
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (d dVar : this.f3182b) {
            f += Math.abs(dVar.f3179c - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }
}

package a.d.c.u.p;

import a.d.c.i;
import a.d.c.l;
import a.d.c.n;
import a.d.c.o;
import a.d.c.r.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e extends a {
    public static final int[] i = {1, 10, 34, 70, 126};
    public static final int[] j = {4, 20, 48, 81};
    public static final int[] k = {0, 161, 961, 2015, 2715};
    public static final int[] l = {0, 336, 1036, 1516};
    public static final int[] m = {8, 6, 4, 3, 1};
    public static final int[] n = {2, 4, 6, 8};
    public static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final List<d> g = new ArrayList();
    public final List<d> h = new ArrayList();

    public static void l(Collection<d> collection, d dVar) {
        if (dVar != null) {
            boolean z = false;
            Iterator<d> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (next.f3081a == dVar.f3081a) {
                    next.f3087d++;
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(dVar);
            }
        }
    }

    public l b(int i2, a aVar, Map<a.d.c.e, ?> map) {
        l(this.g, n(aVar, false, i2, map));
        aVar.e();
        l(this.h, n(aVar, true, i2, map));
        aVar.e();
        for (d next : this.g) {
            if (next.f3087d > 1) {
                for (d next2 : this.h) {
                    if (next2.f3087d > 1) {
                        int i3 = next.f3086c.f3083a;
                        int i4 = next2.f3086c.f3083a;
                        int i5 = ((next2.f3082b * 16) + next.f3082b) % 79;
                        int i6 = (i3 * 9) + i4;
                        if (i6 > 72) {
                            i6--;
                        }
                        if (i6 > 8) {
                            i6--;
                        }
                        if (i5 == i6) {
                            String valueOf = String.valueOf((((long) next.f3081a) * 4537077) + ((long) next2.f3081a));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - valueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(valueOf);
                            int i7 = 0;
                            for (int i8 = 0; i8 < 13; i8++) {
                                int charAt = sb.charAt(i8) - '0';
                                if ((i8 & 1) == 0) {
                                    charAt *= 3;
                                }
                                i7 += charAt;
                            }
                            int i9 = 10 - (i7 % 10);
                            if (i9 == 10) {
                                i9 = 0;
                            }
                            sb.append(i9);
                            n[] nVarArr = next.f3086c.f3085c;
                            n[] nVarArr2 = next2.f3086c.f3085c;
                            return new l(String.valueOf(sb.toString()), (byte[]) null, new n[]{nVarArr[0], nVarArr[1], nVarArr2[0], nVarArr2[1]}, a.d.c.a.RSS_14);
                        }
                    }
                }
                continue;
            }
        }
        throw i.f2874a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bc, code lost:
        if (r4 < 4) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d2, code lost:
        if (r4 < 4) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d4, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d6, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d7, code lost:
        r17 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0157 A[LOOP:3: B:101:0x0155->B:102:0x0157, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0146 A[LOOP:2: B:98:0x0144->B:99:0x0146, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.c.u.p.b m(a.d.c.r.a r19, a.d.c.u.p.c r20, boolean r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            int[] r4 = r0.f3077b
            r5 = 0
            r4[r5] = r5
            r6 = 1
            r4[r6] = r5
            r7 = 2
            r4[r7] = r5
            r8 = 3
            r4[r8] = r5
            r9 = 4
            r4[r9] = r5
            r10 = 5
            r4[r10] = r5
            r11 = 6
            r4[r11] = r5
            r11 = 7
            r4[r11] = r5
            if (r3 == 0) goto L_0x002c
            int[] r2 = r2.f3084b
            r2 = r2[r5]
            a.d.c.u.k.f(r1, r2, r4)
            goto L_0x0046
        L_0x002c:
            int[] r2 = r2.f3084b
            r2 = r2[r6]
            int r2 = r2 + r6
            a.d.c.u.k.e(r1, r2, r4)
            int r1 = r4.length
            int r1 = r1 - r6
            r2 = 0
        L_0x0037:
            if (r2 >= r1) goto L_0x0046
            r11 = r4[r2]
            r12 = r4[r1]
            r4[r2] = r12
            r4[r1] = r11
            int r2 = r2 + 1
            int r1 = r1 + -1
            goto L_0x0037
        L_0x0046:
            if (r3 == 0) goto L_0x004b
            r1 = 16
            goto L_0x004d
        L_0x004b:
            r1 = 15
        L_0x004d:
            int r2 = a.d.c.u.p.a.g(r4)
            float r2 = (float) r2
            float r11 = (float) r1
            float r2 = r2 / r11
            int[] r11 = r0.f3080e
            int[] r12 = r0.f
            float[] r13 = r0.f3078c
            float[] r14 = r0.f3079d
            r15 = 0
        L_0x005d:
            int r5 = r4.length
            if (r15 >= r5) goto L_0x008b
            r5 = r4[r15]
            float r5 = (float) r5
            float r5 = r5 / r2
            r16 = 1056964608(0x3f000000, float:0.5)
            float r7 = r5 + r16
            int r7 = (int) r7
            r8 = 8
            if (r7 >= r6) goto L_0x006f
            r7 = 1
            goto L_0x0073
        L_0x006f:
            if (r7 <= r8) goto L_0x0073
            r7 = 8
        L_0x0073:
            int r8 = r15 >> 1
            r17 = r15 & 1
            if (r17 != 0) goto L_0x0080
            r11[r8] = r7
            float r7 = (float) r7
            float r5 = r5 - r7
            r13[r8] = r5
            goto L_0x0086
        L_0x0080:
            r12[r8] = r7
            float r7 = (float) r7
            float r5 = r5 - r7
            r14[r8] = r5
        L_0x0086:
            int r15 = r15 + 1
            r7 = 2
            r8 = 3
            goto L_0x005d
        L_0x008b:
            int[] r2 = r0.f3080e
            int r2 = a.d.c.u.p.a.g(r2)
            int[] r4 = r0.f
            int r4 = a.d.c.u.p.a.g(r4)
            int r5 = r2 + r4
            int r5 = r5 - r1
            r1 = r2 & 1
            if (r1 != r3) goto L_0x00a0
            r1 = 1
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            r7 = r4 & 1
            if (r7 != r6) goto L_0x00a7
            r7 = 1
            goto L_0x00a8
        L_0x00a7:
            r7 = 0
        L_0x00a8:
            r8 = 12
            r13 = 10
            if (r3 == 0) goto L_0x00bf
            if (r2 <= r8) goto L_0x00b3
            r10 = 0
            r14 = 1
            goto L_0x00b9
        L_0x00b3:
            if (r2 >= r9) goto L_0x00b7
            r10 = 1
            goto L_0x00b8
        L_0x00b7:
            r10 = 0
        L_0x00b8:
            r14 = 0
        L_0x00b9:
            if (r4 <= r8) goto L_0x00bc
            goto L_0x00ce
        L_0x00bc:
            if (r4 >= r9) goto L_0x00d6
            goto L_0x00d4
        L_0x00bf:
            r14 = 11
            if (r2 <= r14) goto L_0x00c6
            r10 = 0
            r14 = 1
            goto L_0x00cc
        L_0x00c6:
            if (r2 >= r10) goto L_0x00ca
            r10 = 1
            goto L_0x00cb
        L_0x00ca:
            r10 = 0
        L_0x00cb:
            r14 = 0
        L_0x00cc:
            if (r4 <= r13) goto L_0x00d2
        L_0x00ce:
            r15 = 0
            r17 = 1
            goto L_0x00d9
        L_0x00d2:
            if (r4 >= r9) goto L_0x00d6
        L_0x00d4:
            r15 = 1
            goto L_0x00d7
        L_0x00d6:
            r15 = 0
        L_0x00d7:
            r17 = 0
        L_0x00d9:
            if (r5 != r6) goto L_0x00e9
            if (r1 == 0) goto L_0x00e3
            if (r7 != 0) goto L_0x00e0
            goto L_0x0109
        L_0x00e0:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00e3:
            if (r7 == 0) goto L_0x00e6
            goto L_0x0105
        L_0x00e6:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00e9:
            r13 = -1
            if (r5 != r13) goto L_0x00fc
            if (r1 == 0) goto L_0x00f5
            if (r7 != 0) goto L_0x00f2
            r10 = 1
            goto L_0x0110
        L_0x00f2:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00f5:
            if (r7 == 0) goto L_0x00f9
            r15 = 1
            goto L_0x0110
        L_0x00f9:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x00fc:
            if (r5 != 0) goto L_0x01cc
            if (r1 == 0) goto L_0x010e
            if (r7 == 0) goto L_0x010b
            if (r2 >= r4) goto L_0x0108
            r10 = 1
        L_0x0105:
            r17 = 1
            goto L_0x0110
        L_0x0108:
            r15 = 1
        L_0x0109:
            r14 = 1
            goto L_0x0110
        L_0x010b:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x010e:
            if (r7 != 0) goto L_0x01c9
        L_0x0110:
            if (r10 == 0) goto L_0x011f
            if (r14 != 0) goto L_0x011c
            int[] r1 = r0.f3080e
            float[] r2 = r0.f3078c
            a.d.c.u.p.a.i(r1, r2)
            goto L_0x011f
        L_0x011c:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x011f:
            if (r14 == 0) goto L_0x0128
            int[] r1 = r0.f3080e
            float[] r2 = r0.f3078c
            a.d.c.u.p.a.h(r1, r2)
        L_0x0128:
            if (r15 == 0) goto L_0x0137
            if (r17 != 0) goto L_0x0134
            int[] r1 = r0.f
            float[] r2 = r0.f3078c
            a.d.c.u.p.a.i(r1, r2)
            goto L_0x0137
        L_0x0134:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0137:
            if (r17 == 0) goto L_0x0140
            int[] r1 = r0.f
            float[] r2 = r0.f3079d
            a.d.c.u.p.a.h(r1, r2)
        L_0x0140:
            int r1 = r11.length
            int r1 = r1 - r6
            r2 = 0
            r4 = 0
        L_0x0144:
            if (r1 < 0) goto L_0x0151
            int r2 = r2 * 9
            r5 = r11[r1]
            int r2 = r2 + r5
            r5 = r11[r1]
            int r4 = r4 + r5
            int r1 = r1 + -1
            goto L_0x0144
        L_0x0151:
            int r1 = r12.length
            int r1 = r1 - r6
            r5 = 0
            r7 = 0
        L_0x0155:
            if (r1 < 0) goto L_0x0162
            int r5 = r5 * 9
            r10 = r12[r1]
            int r5 = r5 + r10
            r10 = r12[r1]
            int r7 = r7 + r10
            int r1 = r1 + -1
            goto L_0x0155
        L_0x0162:
            r1 = 3
            int r5 = r5 * 3
            int r5 = r5 + r2
            if (r3 == 0) goto L_0x0197
            r1 = r4 & 1
            if (r1 != 0) goto L_0x0194
            if (r4 > r8) goto L_0x0194
            if (r4 < r9) goto L_0x0194
            int r8 = r8 - r4
            r1 = 2
            int r8 = r8 / r1
            int[] r1 = m
            r1 = r1[r8]
            int r2 = 9 - r1
            r3 = 0
            int r1 = a.c.a.f.b.I(r11, r1, r3)
            int r2 = a.c.a.f.b.I(r12, r2, r6)
            int[] r3 = i
            r3 = r3[r8]
            int[] r4 = k
            r4 = r4[r8]
            a.d.c.u.p.b r6 = new a.d.c.u.p.b
            int r1 = r1 * r3
            int r1 = r1 + r2
            int r1 = r1 + r4
            r6.<init>(r1, r5)
            return r6
        L_0x0194:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x0197:
            r1 = r7 & 1
            if (r1 != 0) goto L_0x01c6
            r1 = 10
            if (r7 > r1) goto L_0x01c6
            if (r7 < r9) goto L_0x01c6
            int r13 = 10 - r7
            r1 = 2
            int r13 = r13 / r1
            int[] r1 = n
            r1 = r1[r13]
            int r2 = 9 - r1
            int r1 = a.c.a.f.b.I(r11, r1, r6)
            r3 = 0
            int r2 = a.c.a.f.b.I(r12, r2, r3)
            int[] r3 = j
            r3 = r3[r13]
            int[] r4 = l
            r4 = r4[r13]
            a.d.c.u.p.b r6 = new a.d.c.u.p.b
            int r2 = r2 * r3
            int r2 = r2 + r1
            int r2 = r2 + r4
            r6.<init>(r2, r5)
            return r6
        L_0x01c6:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x01c9:
            a.d.c.i r1 = a.d.c.i.f2874a
            throw r1
        L_0x01cc:
            a.d.c.i r1 = a.d.c.i.f2874a
            goto L_0x01d0
        L_0x01cf:
            throw r1
        L_0x01d0:
            goto L_0x01cf
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.p.e.m(a.d.c.r.a, a.d.c.u.p.c, boolean):a.d.c.u.p.b");
    }

    public final d n(a aVar, boolean z, int i2, Map<a.d.c.e, ?> map) {
        try {
            int[] o2 = o(aVar, 0, z);
            c p = p(aVar, i2, z, o2);
            o oVar = map == null ? null : (o) map.get(a.d.c.e.NEED_RESULT_POINT_CALLBACK);
            if (oVar != null) {
                float f = ((float) (o2[0] + o2[1])) / 2.0f;
                if (z) {
                    f = ((float) (aVar.f2965b - 1)) - f;
                }
                oVar.a(new n(f, (float) i2));
            }
            b m2 = m(aVar, p, true);
            b m3 = m(aVar, p, false);
            return new d((m2.f3081a * 1597) + m3.f3081a, (m3.f3082b * 4) + m2.f3082b, p);
        } catch (i unused) {
            return null;
        }
    }

    public final int[] o(a aVar, int i2, boolean z) {
        int[] iArr = this.f3076a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i3 = aVar.f2965b;
        boolean z2 = false;
        while (i2 < i3) {
            z2 = !aVar.a(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i4 = i2;
        int i5 = 0;
        while (i2 < i3) {
            if (aVar.a(i2) ^ z2) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != 3) {
                    i5++;
                } else if (a.j(iArr)) {
                    return new int[]{i4, i2};
                } else {
                    i4 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i5--;
                }
                iArr[i5] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw i.f2874a;
    }

    public final c p(a aVar, int i2, boolean z, int[] iArr) {
        int i3;
        int i4;
        boolean a2 = aVar.a(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && (aVar.a(i5) ^ a2)) {
            i5--;
        }
        int i6 = i5 + 1;
        int[] iArr2 = this.f3076a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = iArr[0] - i6;
        int k2 = a.k(iArr2, o);
        int i7 = iArr[1];
        if (z) {
            int i8 = aVar.f2965b;
            i3 = (i8 - 1) - i7;
            i4 = (i8 - 1) - i6;
        } else {
            i3 = i7;
            i4 = i6;
        }
        return new c(k2, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    public void reset() {
        this.g.clear();
        this.h.clear();
    }
}

package a.d.a.a.h.g;

import a.a.a.a.a;
import a.c.a.f.b;
import a.d.a.a.h.g.i5;
import a.d.a.a.h.g.y5;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

public final class k7<T> implements v7<T> {
    public static final int[] p = new int[0];
    public static final Unsafe q = n8.k();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1776a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f1777b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1778c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1779d;

    /* renamed from: e  reason: collision with root package name */
    public final i7 f1780e;
    public final boolean f;
    public final boolean g;
    public final int[] h;
    public final int i;
    public final int j;
    public final o7 k;
    public final s6 l;
    public final h8<?, ?> m;
    public final n5<?> n;
    public final b7 o;

    public k7(int[] iArr, Object[] objArr, int i2, int i3, i7 i7Var, boolean z, int[] iArr2, int i4, int i5, o7 o7Var, s6 s6Var, h8 h8Var, n5 n5Var, b7 b7Var) {
        this.f1776a = iArr;
        this.f1777b = objArr;
        this.f1778c = i2;
        this.f1779d = i3;
        boolean z2 = i7Var instanceof y5;
        this.g = z;
        this.f = n5Var != null && (i7Var instanceof y5.d);
        this.h = iArr2;
        this.i = i4;
        this.j = i5;
        this.k = o7Var;
        this.l = s6Var;
        this.m = h8Var;
        this.n = n5Var;
        this.f1780e = i7Var;
        this.o = b7Var;
    }

    public static <T> float F(T t, long j2) {
        return ((Float) n8.r(t, j2)).floatValue();
    }

    public static <T> int J(T t, long j2) {
        return ((Integer) n8.r(t, j2)).intValue();
    }

    public static <T> long L(T t, long j2) {
        return ((Long) n8.r(t, j2)).longValue();
    }

    public static k8 M(Object obj) {
        y5 y5Var = (y5) obj;
        k8 k8Var = y5Var.zzb;
        if (k8Var != k8.f) {
            return k8Var;
        }
        k8 c2 = k8.c();
        y5Var.zzb = c2;
        return c2;
    }

    public static <T> boolean N(T t, long j2) {
        return ((Boolean) n8.r(t, j2)).booleanValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> a.d.a.a.h.g.k7<T> n(java.lang.Class<T> r34, a.d.a.a.h.g.g7 r35, a.d.a.a.h.g.o7 r36, a.d.a.a.h.g.s6 r37, a.d.a.a.h.g.h8<?, ?> r38, a.d.a.a.h.g.n5<?> r39, a.d.a.a.h.g.b7 r40) {
        /*
            r0 = r35
            boolean r1 = r0 instanceof a.d.a.a.h.g.t7
            if (r1 == 0) goto L_0x0425
            a.d.a.a.h.g.t7 r0 = (a.d.a.a.h.g.t7) r0
            int r1 = r0.f1950d
            r2 = 1
            r1 = r1 & r2
            r3 = 2
            if (r1 != r2) goto L_0x0011
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 2
        L_0x0012:
            r4 = 0
            if (r1 != r3) goto L_0x0017
            r11 = 1
            goto L_0x0018
        L_0x0017:
            r11 = 0
        L_0x0018:
            java.lang.String r1 = r0.f1948b
            int r3 = r1.length()
            char r5 = r1.charAt(r4)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0032
            r5 = 1
        L_0x0028:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0033
            r5 = r7
            goto L_0x0028
        L_0x0032:
            r7 = 1
        L_0x0033:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0052
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x003f:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x004f
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x003f
        L_0x004f:
            int r5 = r5 << r9
            r7 = r7 | r5
            r5 = r10
        L_0x0052:
            if (r7 != 0) goto L_0x005f
            int[] r7 = p
            r13 = r7
            r7 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            goto L_0x0170
        L_0x005f:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x007e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006b:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x007b
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r5 = r5 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x006b
        L_0x007b:
            int r7 = r7 << r9
            r5 = r5 | r7
            r7 = r10
        L_0x007e:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x009d
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x008a:
            int r12 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x009a
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r12
            goto L_0x008a
        L_0x009a:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r12
        L_0x009d:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x00bc
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a9:
            int r13 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00b9
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r12
            r9 = r9 | r10
            int r12 = r12 + 13
            r10 = r13
            goto L_0x00a9
        L_0x00b9:
            int r10 = r10 << r12
            r9 = r9 | r10
            r10 = r13
        L_0x00bc:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00db
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c8:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00d8
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r10 = r10 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00c8
        L_0x00d8:
            int r12 = r12 << r13
            r10 = r10 | r12
            r12 = r14
        L_0x00db:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00fa
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e7:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x00f7
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00e7
        L_0x00f7:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00fa:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x011b
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0106:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x0117
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0106
        L_0x0117:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011b:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x013e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0127:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0139
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0127
        L_0x0139:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x013e:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0163
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r4 = r16
            r16 = 13
        L_0x014c:
            int r17 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r6) goto L_0x015e
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r16
            r15 = r15 | r4
            int r16 = r16 + 13
            r4 = r17
            goto L_0x014c
        L_0x015e:
            int r4 = r4 << r16
            r15 = r15 | r4
            r16 = r17
        L_0x0163:
            int r4 = r15 + r13
            int r4 = r4 + r14
            int[] r4 = new int[r4]
            int r14 = r5 << 1
            int r14 = r14 + r7
            r7 = r13
            r13 = r4
            r4 = r5
            r5 = r16
        L_0x0170:
            sun.misc.Unsafe r8 = q
            java.lang.Object[] r6 = r0.f1949c
            a.d.a.a.h.g.i7 r2 = r0.f1947a
            java.lang.Class r2 = r2.getClass()
            r18 = r5
            int r5 = r12 * 3
            int[] r5 = new int[r5]
            r17 = 1
            int r12 = r12 << 1
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r19 = r15 + r7
            r21 = r15
            r7 = r18
            r22 = r19
            r18 = 0
            r20 = 0
        L_0x0192:
            if (r7 >= r3) goto L_0x03f8
            int r23 = r7 + 1
            char r7 = r1.charAt(r7)
            r24 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r3) goto L_0x01c6
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r3 = r23
            r23 = 13
        L_0x01a7:
            int r25 = r3 + 1
            char r3 = r1.charAt(r3)
            r26 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r15) goto L_0x01c0
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r23
            r7 = r7 | r3
            int r23 = r23 + 13
            r3 = r25
            r15 = r26
            goto L_0x01a7
        L_0x01c0:
            int r3 = r3 << r23
            r7 = r7 | r3
            r3 = r25
            goto L_0x01ca
        L_0x01c6:
            r26 = r15
            r3 = r23
        L_0x01ca:
            int r15 = r3 + 1
            char r3 = r1.charAt(r3)
            r23 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r15) goto L_0x01fc
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r15 = r23
            r23 = 13
        L_0x01dd:
            int r25 = r15 + 1
            char r15 = r1.charAt(r15)
            r27 = r10
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x01f6
            r10 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r23
            r3 = r3 | r10
            int r23 = r23 + 13
            r15 = r25
            r10 = r27
            goto L_0x01dd
        L_0x01f6:
            int r10 = r15 << r23
            r3 = r3 | r10
            r15 = r25
            goto L_0x0200
        L_0x01fc:
            r27 = r10
            r15 = r23
        L_0x0200:
            r10 = r3 & 255(0xff, float:3.57E-43)
            r23 = r9
            r9 = r3 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x020e
            int r9 = r18 + 1
            r13[r18] = r20
            r18 = r9
        L_0x020e:
            r9 = 51
            if (r10 < r9) goto L_0x02bc
            int r9 = r15 + 1
            char r15 = r1.charAt(r15)
            r25 = r9
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r9) goto L_0x0246
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
            r33 = r25
            r25 = r15
            r15 = r33
        L_0x0229:
            int r32 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r9) goto L_0x023f
            r9 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r31
            r25 = r25 | r9
            int r31 = r31 + 13
            r15 = r32
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0229
        L_0x023f:
            int r9 = r15 << r31
            r15 = r25 | r9
            r9 = r32
            goto L_0x0248
        L_0x0246:
            r9 = r25
        L_0x0248:
            r25 = r9
            int r9 = r10 + -51
            r31 = r0
            r0 = 9
            if (r9 == r0) goto L_0x026b
            r0 = 17
            if (r9 != r0) goto L_0x0257
            goto L_0x026b
        L_0x0257:
            r0 = 12
            if (r9 != r0) goto L_0x0269
            if (r11 != 0) goto L_0x0269
            int r0 = r20 / 3
            r9 = 1
            int r0 = r0 << r9
            int r0 = r0 + r9
            int r9 = r14 + 1
            r14 = r6[r14]
            r12[r0] = r14
            r14 = r9
        L_0x0269:
            r9 = 1
            goto L_0x0278
        L_0x026b:
            int r0 = r20 / 3
            r9 = 1
            int r0 = r0 << r9
            int r0 = r0 + r9
            int r17 = r14 + 1
            r14 = r6[r14]
            r12[r0] = r14
            r14 = r17
        L_0x0278:
            int r0 = r15 << 1
            r9 = r6[r0]
            boolean r15 = r9 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x0283
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x028b
        L_0x0283:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = p(r2, r9)
            r6[r0] = r9
        L_0x028b:
            r28 = r14
            long r14 = r8.objectFieldOffset(r9)
            int r9 = (int) r14
            int r0 = r0 + 1
            r14 = r6[r0]
            boolean r15 = r14 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x029d
            java.lang.reflect.Field r14 = (java.lang.reflect.Field) r14
            goto L_0x02a5
        L_0x029d:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.reflect.Field r14 = p(r2, r14)
            r6[r0] = r14
        L_0x02a5:
            long r14 = r8.objectFieldOffset(r14)
            int r0 = (int) r14
            r29 = r1
            r14 = r11
            r15 = r25
            r30 = r28
            r16 = 1
            r1 = r0
            r28 = r12
            r0 = 55296(0xd800, float:7.7486E-41)
            r12 = 0
            goto L_0x03c0
        L_0x02bc:
            r31 = r0
            int r0 = r14 + 1
            r9 = r6[r14]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = p(r2, r9)
            r14 = 9
            if (r10 == r14) goto L_0x0336
            r14 = 17
            if (r10 != r14) goto L_0x02d2
            goto L_0x0336
        L_0x02d2:
            r14 = 27
            if (r10 == r14) goto L_0x0325
            r14 = 49
            if (r10 != r14) goto L_0x02db
            goto L_0x0325
        L_0x02db:
            r14 = 12
            if (r10 == r14) goto L_0x0311
            r14 = 30
            if (r10 == r14) goto L_0x0311
            r14 = 44
            if (r10 != r14) goto L_0x02e8
            goto L_0x0311
        L_0x02e8:
            r14 = 50
            if (r10 != r14) goto L_0x0344
            int r14 = r21 + 1
            r13[r21] = r20
            int r21 = r20 / 3
            r17 = 1
            int r21 = r21 << 1
            int r28 = r0 + 1
            r0 = r6[r0]
            r12[r21] = r0
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x030e
            int r21 = r21 + 1
            int r0 = r28 + 1
            r28 = r6[r28]
            r12[r21] = r28
            r28 = r12
            r21 = r14
            r14 = r11
            goto L_0x0347
        L_0x030e:
            r21 = r14
            goto L_0x0333
        L_0x0311:
            if (r11 != 0) goto L_0x0322
            int r14 = r20 / 3
            r17 = 1
            int r14 = r14 << 1
            int r14 = r14 + 1
            int r28 = r0 + 1
            r0 = r6[r0]
            r12[r14] = r0
            goto L_0x0333
        L_0x0322:
            r17 = 1
            goto L_0x0344
        L_0x0325:
            r17 = 1
            int r14 = r20 / 3
            int r14 = r14 << 1
            int r14 = r14 + 1
            int r28 = r0 + 1
            r0 = r6[r0]
            r12[r14] = r0
        L_0x0333:
            r0 = r28
            goto L_0x0344
        L_0x0336:
            r17 = 1
            int r14 = r20 / 3
            int r14 = r14 << 1
            int r14 = r14 + 1
            java.lang.Class r28 = r9.getType()
            r12[r14] = r28
        L_0x0344:
            r14 = r11
            r28 = r12
        L_0x0347:
            long r11 = r8.objectFieldOffset(r9)
            int r9 = (int) r11
            r11 = r3 & 4096(0x1000, float:5.74E-42)
            r12 = 4096(0x1000, float:5.74E-42)
            if (r11 != r12) goto L_0x03a5
            r11 = 17
            if (r10 > r11) goto L_0x03a5
            int r11 = r15 + 1
            char r12 = r1.charAt(r15)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r12 < r15) goto L_0x037c
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0365:
            int r29 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r15) goto L_0x0377
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r16
            r12 = r12 | r11
            int r16 = r16 + 13
            r11 = r29
            goto L_0x0365
        L_0x0377:
            int r11 = r11 << r16
            r12 = r12 | r11
            r11 = r29
        L_0x037c:
            r16 = 1
            int r17 = r4 << 1
            int r29 = r12 / 32
            int r29 = r29 + r17
            r15 = r6[r29]
            r30 = r0
            boolean r0 = r15 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x038f
            java.lang.reflect.Field r15 = (java.lang.reflect.Field) r15
            goto L_0x0397
        L_0x038f:
            java.lang.String r15 = (java.lang.String) r15
            java.lang.reflect.Field r15 = p(r2, r15)
            r6[r29] = r15
        L_0x0397:
            r29 = r1
            long r0 = r8.objectFieldOffset(r15)
            int r1 = (int) r0
            int r12 = r12 % 32
            r15 = r11
            r0 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03b2
        L_0x03a5:
            r30 = r0
            r29 = r1
            r0 = 55296(0xd800, float:7.7486E-41)
            r16 = 1
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x03b2:
            r11 = 18
            if (r10 < r11) goto L_0x03c0
            r11 = 49
            if (r10 > r11) goto L_0x03c0
            int r11 = r22 + 1
            r13[r22] = r9
            r22 = r11
        L_0x03c0:
            int r11 = r20 + 1
            r5[r20] = r7
            int r7 = r11 + 1
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03cd
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03ce
        L_0x03cd:
            r0 = 0
        L_0x03ce:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03d5
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03d6
        L_0x03d5:
            r3 = 0
        L_0x03d6:
            r0 = r0 | r3
            int r3 = r10 << 20
            r0 = r0 | r3
            r0 = r0 | r9
            r5[r11] = r0
            int r20 = r7 + 1
            int r0 = r12 << 20
            r0 = r0 | r1
            r5[r7] = r0
            r11 = r14
            r7 = r15
            r9 = r23
            r3 = r24
            r15 = r26
            r10 = r27
            r12 = r28
            r1 = r29
            r14 = r30
            r0 = r31
            goto L_0x0192
        L_0x03f8:
            r31 = r0
            r23 = r9
            r27 = r10
            r14 = r11
            r28 = r12
            r26 = r15
            a.d.a.a.h.g.k7 r0 = new a.d.a.a.h.g.k7
            r1 = r31
            a.d.a.a.h.g.i7 r10 = r1.f1947a
            r1 = r5
            r5 = r0
            r6 = r1
            r7 = r28
            r8 = r23
            r9 = r27
            r12 = r13
            r13 = r26
            r14 = r19
            r15 = r36
            r16 = r37
            r17 = r38
            r18 = r39
            r19 = r40
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        L_0x0425:
            a.d.a.a.h.g.g8 r0 = (a.d.a.a.h.g.g8) r0
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            goto L_0x042e
        L_0x042d:
            throw r0
        L_0x042e:
            goto L_0x042d
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.n(java.lang.Class, a.d.a.a.h.g.g7, a.d.a.a.h.g.o7, a.d.a.a.h.g.s6, a.d.a.a.h.g.h8, a.d.a.a.h.g.n5, a.d.a.a.h.g.b7):a.d.a.a.h.g.k7");
    }

    public static Field p(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + name.length() + String.valueOf(str).length() + 40);
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            throw new RuntimeException(a.m(sb, " not found. Known fields are ", arrays));
        }
    }

    public static List<?> q(Object obj, long j2) {
        return (List) n8.r(obj, j2);
    }

    public static void r(int i2, Object obj, d9 d9Var) {
        if (obj instanceof String) {
            i5.b bVar = (i5.b) ((k5) d9Var).f1770a;
            bVar.o((i2 << 3) | 2);
            bVar.a0((String) obj);
            return;
        }
        i5.b bVar2 = (i5.b) ((k5) d9Var).f1770a;
        bVar2.o((i2 << 3) | 2);
        bVar2.Y((w4) obj);
    }

    public static <UT, UB> void s(h8<UT, UB> h8Var, T t, d9 d9Var) {
        if (((j8) h8Var) != null) {
            ((y5) t).zzb.d(d9Var);
            return;
        }
        throw null;
    }

    public static <T> double y(T t, long j2) {
        return ((Double) n8.r(t, j2)).doubleValue();
    }

    public final Object A(int i2) {
        return this.f1777b[(i2 / 3) << 1];
    }

    public final void B(T t, int i2) {
        int i3 = this.f1776a[i2 + 2];
        long j2 = (long) (1048575 & i3);
        if (j2 != 1048575) {
            n8.f.e(t, j2, (1 << (i3 >>> 20)) | n8.b(t, j2));
        }
    }

    public final void C(T t, int i2, int i3) {
        n8.f.e(t, (long) (this.f1776a[i3 + 2] & 1048575), i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x04ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(T r17, a.d.a.a.h.g.d9 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.f
            r4 = 0
            if (r3 == 0) goto L_0x002a
            a.d.a.a.h.g.n5<?> r3 = r0.n
            a.d.a.a.h.g.p5 r3 = (a.d.a.a.h.g.p5) r3
            if (r3 == 0) goto L_0x0029
            r3 = r1
            a.d.a.a.h.g.y5$d r3 = (a.d.a.a.h.g.y5.d) r3
            a.d.a.a.h.g.r5<a.d.a.a.h.g.y5$c> r3 = r3.zzc
            a.d.a.a.h.g.z7<T, java.lang.Object> r5 = r3.f1917a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x002a
            java.util.Iterator r3 = r3.k()
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x002b
        L_0x0029:
            throw r4
        L_0x002a:
            r3 = r4
        L_0x002b:
            int[] r5 = r0.f1776a
            int r5 = r5.length
            sun.misc.Unsafe r6 = q
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r11 = 0
        L_0x0038:
            if (r9 >= r5) goto L_0x04e4
            int r12 = r0.I(r9)
            int[] r13 = r0.f1776a
            r14 = r13[r9]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.g
            r8 = 1
            if (r4 != 0) goto L_0x0063
            r4 = 17
            if (r15 > r4) goto L_0x0063
            int r4 = r9 + 2
            r4 = r13[r4]
            r13 = r4 & r7
            if (r13 == r10) goto L_0x005e
            long r10 = (long) r13
            int r11 = r6.getInt(r1, r10)
            r10 = r13
        L_0x005e:
            int r4 = r4 >>> 20
            int r4 = r8 << r4
            goto L_0x0064
        L_0x0063:
            r4 = 0
        L_0x0064:
            if (r3 != 0) goto L_0x04dd
            r12 = r12 & r7
            long r12 = (long) r12
            switch(r15) {
                case 0: goto L_0x04ca;
                case 1: goto L_0x04bb;
                case 2: goto L_0x04ac;
                case 3: goto L_0x049d;
                case 4: goto L_0x048c;
                case 5: goto L_0x047d;
                case 6: goto L_0x046e;
                case 7: goto L_0x045e;
                case 8: goto L_0x0451;
                case 9: goto L_0x043d;
                case 10: goto L_0x042b;
                case 11: goto L_0x041b;
                case 12: goto L_0x0409;
                case 13: goto L_0x03f9;
                case 14: goto L_0x03e9;
                case 15: goto L_0x03d9;
                case 16: goto L_0x03c9;
                case 17: goto L_0x03b5;
                case 18: goto L_0x03a5;
                case 19: goto L_0x0395;
                case 20: goto L_0x0385;
                case 21: goto L_0x0375;
                case 22: goto L_0x0365;
                case 23: goto L_0x0355;
                case 24: goto L_0x0345;
                case 25: goto L_0x0335;
                case 26: goto L_0x0326;
                case 27: goto L_0x0313;
                case 28: goto L_0x0304;
                case 29: goto L_0x02f4;
                case 30: goto L_0x02e4;
                case 31: goto L_0x02d4;
                case 32: goto L_0x02c4;
                case 33: goto L_0x02b4;
                case 34: goto L_0x02a4;
                case 35: goto L_0x0295;
                case 36: goto L_0x0286;
                case 37: goto L_0x0277;
                case 38: goto L_0x0268;
                case 39: goto L_0x0259;
                case 40: goto L_0x024a;
                case 41: goto L_0x023b;
                case 42: goto L_0x022c;
                case 43: goto L_0x021d;
                case 44: goto L_0x020e;
                case 45: goto L_0x01ff;
                case 46: goto L_0x01f0;
                case 47: goto L_0x01e1;
                case 48: goto L_0x01d2;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b6;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0192;
                case 53: goto L_0x0180;
                case 54: goto L_0x016e;
                case 55: goto L_0x015a;
                case 56: goto L_0x0148;
                case 57: goto L_0x0136;
                case 58: goto L_0x0124;
                case 59: goto L_0x0115;
                case 60: goto L_0x00ff;
                case 61: goto L_0x00eb;
                case 62: goto L_0x00da;
                case 63: goto L_0x00c7;
                case 64: goto L_0x00b6;
                case 65: goto L_0x00a5;
                case 66: goto L_0x0094;
                case 67: goto L_0x0083;
                case 68: goto L_0x006e;
                default: goto L_0x006b;
            }
        L_0x006b:
            r15 = 0
            goto L_0x04d8
        L_0x006e:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            java.lang.Object r4 = r6.getObject(r1, r12)
            a.d.a.a.h.g.v7 r8 = r0.o(r9)
            r12 = r2
            a.d.a.a.h.g.k5 r12 = (a.d.a.a.h.g.k5) r12
            r12.j(r14, r4, r8)
            goto L_0x006b
        L_0x0083:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            long r12 = L(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.o(r14, r12)
            goto L_0x006b
        L_0x0094:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            int r4 = J(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.p(r14, r4)
            goto L_0x006b
        L_0x00a5:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            long r12 = L(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.i(r14, r12)
            goto L_0x006b
        L_0x00b6:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            int r4 = J(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.c(r14, r4)
            goto L_0x006b
        L_0x00c7:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            int r4 = J(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            a.d.a.a.h.g.i5 r8 = r8.f1770a
            r8.p(r14, r4)
            goto L_0x006b
        L_0x00da:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            int r4 = J(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.n(r14, r4)
            goto L_0x006b
        L_0x00eb:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            java.lang.Object r4 = r6.getObject(r1, r12)
            a.d.a.a.h.g.w4 r4 = (a.d.a.a.h.g.w4) r4
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.e(r14, r4)
            goto L_0x006b
        L_0x00ff:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            java.lang.Object r4 = r6.getObject(r1, r12)
            a.d.a.a.h.g.v7 r8 = r0.o(r9)
            r12 = r2
            a.d.a.a.h.g.k5 r12 = (a.d.a.a.h.g.k5) r12
            r12.g(r14, r4, r8)
            goto L_0x006b
        L_0x0115:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            java.lang.Object r4 = r6.getObject(r1, r12)
            r(r14, r4, r2)
            goto L_0x006b
        L_0x0124:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            boolean r4 = N(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.h(r14, r4)
            goto L_0x006b
        L_0x0136:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            int r4 = J(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.l(r14, r4)
            goto L_0x006b
        L_0x0148:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            long r12 = L(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.m(r14, r12)
            goto L_0x006b
        L_0x015a:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            int r4 = J(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            a.d.a.a.h.g.i5 r8 = r8.f1770a
            r8.p(r14, r4)
            goto L_0x006b
        L_0x016e:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            long r12 = L(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.k(r14, r12)
            goto L_0x006b
        L_0x0180:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            long r12 = L(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.d(r14, r12)
            goto L_0x006b
        L_0x0192:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            float r4 = F(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.b(r14, r4)
            goto L_0x006b
        L_0x01a4:
            boolean r4 = r0.w(r1, r14, r9)
            if (r4 == 0) goto L_0x006b
            double r12 = y(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.a(r14, r12)
            goto L_0x006b
        L_0x01b6:
            java.lang.Object r4 = r6.getObject(r1, r12)
            r0.t(r2, r14, r4, r9)
            goto L_0x006b
        L_0x01bf:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.v7 r12 = r0.o(r9)
            a.d.a.a.h.g.w7.u(r4, r8, r2, r12)
            goto L_0x006b
        L_0x01d2:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.F(r4, r12, r2, r8)
            goto L_0x006b
        L_0x01e1:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.U(r4, r12, r2, r8)
            goto L_0x006b
        L_0x01f0:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.L(r4, r12, r2, r8)
            goto L_0x006b
        L_0x01ff:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.W(r4, r12, r2, r8)
            goto L_0x006b
        L_0x020e:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.X(r4, r12, r2, r8)
            goto L_0x006b
        L_0x021d:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.R(r4, r12, r2, r8)
            goto L_0x006b
        L_0x022c:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.Y(r4, r12, r2, r8)
            goto L_0x006b
        L_0x023b:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.V(r4, r12, r2, r8)
            goto L_0x006b
        L_0x024a:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.I(r4, r12, r2, r8)
            goto L_0x006b
        L_0x0259:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.O(r4, r12, r2, r8)
            goto L_0x006b
        L_0x0268:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.C(r4, r12, r2, r8)
            goto L_0x006b
        L_0x0277:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.z(r4, r12, r2, r8)
            goto L_0x006b
        L_0x0286:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.v(r4, r12, r2, r8)
            goto L_0x006b
        L_0x0295:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r12 = r6.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            a.d.a.a.h.g.w7.j(r4, r12, r2, r8)
            goto L_0x006b
        L_0x02a4:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 0
            a.d.a.a.h.g.w7.F(r4, r8, r2, r14)
            goto L_0x006b
        L_0x02b4:
            r14 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.U(r4, r8, r2, r14)
            goto L_0x006b
        L_0x02c4:
            r14 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.L(r4, r8, r2, r14)
            goto L_0x006b
        L_0x02d4:
            r14 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.W(r4, r8, r2, r14)
            goto L_0x006b
        L_0x02e4:
            r14 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.X(r4, r8, r2, r14)
            goto L_0x006b
        L_0x02f4:
            r14 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.R(r4, r8, r2, r14)
            goto L_0x006b
        L_0x0304:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.t(r4, r8, r2)
            goto L_0x006b
        L_0x0313:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.v7 r12 = r0.o(r9)
            a.d.a.a.h.g.w7.i(r4, r8, r2, r12)
            goto L_0x006b
        L_0x0326:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.h(r4, r8, r2)
            goto L_0x006b
        L_0x0335:
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            a.d.a.a.h.g.w7.Y(r4, r8, r2, r15)
            goto L_0x04d8
        L_0x0345:
            r15 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.V(r4, r8, r2, r15)
            goto L_0x04d8
        L_0x0355:
            r15 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.I(r4, r8, r2, r15)
            goto L_0x04d8
        L_0x0365:
            r15 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.O(r4, r8, r2, r15)
            goto L_0x04d8
        L_0x0375:
            r15 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.C(r4, r8, r2, r15)
            goto L_0x04d8
        L_0x0385:
            r15 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.z(r4, r8, r2, r15)
            goto L_0x04d8
        L_0x0395:
            r15 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.v(r4, r8, r2, r15)
            goto L_0x04d8
        L_0x03a5:
            r15 = 0
            int[] r4 = r0.f1776a
            r4 = r4[r9]
            java.lang.Object r8 = r6.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            a.d.a.a.h.g.w7.j(r4, r8, r2, r15)
            goto L_0x04d8
        L_0x03b5:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            java.lang.Object r4 = r6.getObject(r1, r12)
            a.d.a.a.h.g.v7 r8 = r0.o(r9)
            r12 = r2
            a.d.a.a.h.g.k5 r12 = (a.d.a.a.h.g.k5) r12
            r12.j(r14, r4, r8)
            goto L_0x04d8
        L_0x03c9:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            long r12 = r6.getLong(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.o(r14, r12)
            goto L_0x04d8
        L_0x03d9:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            int r4 = r6.getInt(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.p(r14, r4)
            goto L_0x04d8
        L_0x03e9:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            long r12 = r6.getLong(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.i(r14, r12)
            goto L_0x04d8
        L_0x03f9:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            int r4 = r6.getInt(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.c(r14, r4)
            goto L_0x04d8
        L_0x0409:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            int r4 = r6.getInt(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            a.d.a.a.h.g.i5 r8 = r8.f1770a
            r8.p(r14, r4)
            goto L_0x04d8
        L_0x041b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            int r4 = r6.getInt(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.n(r14, r4)
            goto L_0x04d8
        L_0x042b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            java.lang.Object r4 = r6.getObject(r1, r12)
            a.d.a.a.h.g.w4 r4 = (a.d.a.a.h.g.w4) r4
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.e(r14, r4)
            goto L_0x04d8
        L_0x043d:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            java.lang.Object r4 = r6.getObject(r1, r12)
            a.d.a.a.h.g.v7 r8 = r0.o(r9)
            r12 = r2
            a.d.a.a.h.g.k5 r12 = (a.d.a.a.h.g.k5) r12
            r12.g(r14, r4, r8)
            goto L_0x04d8
        L_0x0451:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            java.lang.Object r4 = r6.getObject(r1, r12)
            r(r14, r4, r2)
            goto L_0x04d8
        L_0x045e:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            boolean r4 = a.d.a.a.h.g.n8.m(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.h(r14, r4)
            goto L_0x04d8
        L_0x046e:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            int r4 = r6.getInt(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.l(r14, r4)
            goto L_0x04d8
        L_0x047d:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            long r12 = r6.getLong(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.m(r14, r12)
            goto L_0x04d8
        L_0x048c:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            int r4 = r6.getInt(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            a.d.a.a.h.g.i5 r8 = r8.f1770a
            r8.p(r14, r4)
            goto L_0x04d8
        L_0x049d:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            long r12 = r6.getLong(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.k(r14, r12)
            goto L_0x04d8
        L_0x04ac:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            long r12 = r6.getLong(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.d(r14, r12)
            goto L_0x04d8
        L_0x04bb:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            float r4 = a.d.a.a.h.g.n8.n(r1, r12)
            r8 = r2
            a.d.a.a.h.g.k5 r8 = (a.d.a.a.h.g.k5) r8
            r8.b(r14, r4)
            goto L_0x04d8
        L_0x04ca:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x04d8
            double r12 = a.d.a.a.h.g.n8.q(r1, r12)
            r4 = r2
            a.d.a.a.h.g.k5 r4 = (a.d.a.a.h.g.k5) r4
            r4.a(r14, r12)
        L_0x04d8:
            int r9 = r9 + 3
            r4 = 0
            goto L_0x0038
        L_0x04dd:
            a.d.a.a.h.g.n5<?> r1 = r0.n
            r1.a(r3)
            r4 = 0
            throw r4
        L_0x04e4:
            if (r3 != 0) goto L_0x04ec
            a.d.a.a.h.g.h8<?, ?> r3 = r0.m
            s(r3, r1, r2)
            return
        L_0x04ec:
            a.d.a.a.h.g.n5<?> r1 = r0.n
            r1.b(r2, r3)
            goto L_0x04f3
        L_0x04f2:
            throw r4
        L_0x04f3:
            goto L_0x04f2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.D(java.lang.Object, a.d.a.a.h.g.d9):void");
    }

    public final void E(T t, T t2, int i2) {
        int[] iArr = this.f1776a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long j2 = (long) (i3 & 1048575);
        if (w(t2, i4, i2)) {
            Object r = n8.r(t, j2);
            Object r2 = n8.r(t2, j2);
            if (r != null && r2 != null) {
                n8.f(t, j2, a6.e(r, r2));
                C(t, i4, i2);
            } else if (r2 != null) {
                n8.f(t, j2, r2);
                C(t, i4, i2);
            }
        }
    }

    public final e6 G(int i2) {
        return (e6) this.f1777b[((i2 / 3) << 1) + 1];
    }

    public final boolean H(T t, T t2, int i2) {
        return v(t, i2) == v(t2, i2);
    }

    public final int I(int i2) {
        return this.f1776a[i2 + 1];
    }

    public final int K(int i2) {
        return this.f1776a[i2 + 2];
    }

    public final T a() {
        return this.k.b(this.f1780e);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r3 = a.d.a.a.h.g.n8.r(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r2 = r2 * 53;
        r3 = J(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r2 = r2 * 53;
        r3 = L(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r2 * 53;
        r3 = a.d.a.a.h.g.n8.r(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ea, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) a.d.a.a.h.g.n8.r(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fd, code lost:
        r3 = a.d.a.a.h.g.a6.c(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0116, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0121, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0125, code lost:
        r3 = a.d.a.a.h.g.a6.b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0129, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012b, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f1776a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x012f
            int r3 = r8.I(r1)
            int[] r4 = r8.f1776a
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0110;
                case 2: goto L_0x0109;
                case 3: goto L_0x0109;
                case 4: goto L_0x0102;
                case 5: goto L_0x0109;
                case 6: goto L_0x0102;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00ea;
                case 9: goto L_0x00dc;
                case 10: goto L_0x00d1;
                case 11: goto L_0x0102;
                case 12: goto L_0x0102;
                case 13: goto L_0x0102;
                case 14: goto L_0x0109;
                case 15: goto L_0x0102;
                case 16: goto L_0x0109;
                case 17: goto L_0x00ca;
                case 18: goto L_0x00d1;
                case 19: goto L_0x00d1;
                case 20: goto L_0x00d1;
                case 21: goto L_0x00d1;
                case 22: goto L_0x00d1;
                case 23: goto L_0x00d1;
                case 24: goto L_0x00d1;
                case 25: goto L_0x00d1;
                case 26: goto L_0x00d1;
                case 27: goto L_0x00d1;
                case 28: goto L_0x00d1;
                case 29: goto L_0x00d1;
                case 30: goto L_0x00d1;
                case 31: goto L_0x00d1;
                case 32: goto L_0x00d1;
                case 33: goto L_0x00d1;
                case 34: goto L_0x00d1;
                case 35: goto L_0x00d1;
                case 36: goto L_0x00d1;
                case 37: goto L_0x00d1;
                case 38: goto L_0x00d1;
                case 39: goto L_0x00d1;
                case 40: goto L_0x00d1;
                case 41: goto L_0x00d1;
                case 42: goto L_0x00d1;
                case 43: goto L_0x00d1;
                case 44: goto L_0x00d1;
                case 45: goto L_0x00d1;
                case 46: goto L_0x00d1;
                case 47: goto L_0x00d1;
                case 48: goto L_0x00d1;
                case 49: goto L_0x00d1;
                case 50: goto L_0x00d1;
                case 51: goto L_0x00bd;
                case 52: goto L_0x00b0;
                case 53: goto L_0x00a2;
                case 54: goto L_0x009b;
                case 55: goto L_0x008d;
                case 56: goto L_0x0086;
                case 57: goto L_0x007f;
                case 58: goto L_0x0071;
                case 59: goto L_0x0069;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x012b
        L_0x0020:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x0061
        L_0x0027:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x00a8
        L_0x002f:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x0093
        L_0x0036:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x00a8
        L_0x003e:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x0093
        L_0x0045:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x0093
        L_0x004c:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x0093
        L_0x0053:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x00d1
        L_0x005b:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
        L_0x0061:
            java.lang.Object r3 = a.d.a.a.h.g.n8.r(r9, r5)
            int r2 = r2 * 53
            goto L_0x00d7
        L_0x0069:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x00ea
        L_0x0071:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            int r2 = r2 * 53
            boolean r3 = N(r9, r5)
            goto L_0x00fd
        L_0x007f:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x0093
        L_0x0086:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x00a8
        L_0x008d:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
        L_0x0093:
            int r2 = r2 * 53
            int r3 = J(r9, r5)
            goto L_0x0129
        L_0x009b:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            goto L_0x00a8
        L_0x00a2:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
        L_0x00a8:
            int r2 = r2 * 53
            long r3 = L(r9, r5)
            goto L_0x0125
        L_0x00b0:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            int r2 = r2 * 53
            float r3 = F(r9, r5)
            goto L_0x0116
        L_0x00bd:
            boolean r3 = r8.w(r9, r4, r1)
            if (r3 == 0) goto L_0x012b
            int r2 = r2 * 53
            double r3 = y(r9, r5)
            goto L_0x0121
        L_0x00ca:
            java.lang.Object r3 = a.d.a.a.h.g.n8.r(r9, r5)
            if (r3 == 0) goto L_0x00e6
            goto L_0x00e2
        L_0x00d1:
            int r2 = r2 * 53
            java.lang.Object r3 = a.d.a.a.h.g.n8.r(r9, r5)
        L_0x00d7:
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00dc:
            java.lang.Object r3 = a.d.a.a.h.g.n8.r(r9, r5)
            if (r3 == 0) goto L_0x00e6
        L_0x00e2:
            int r7 = r3.hashCode()
        L_0x00e6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x012b
        L_0x00ea:
            int r2 = r2 * 53
            java.lang.Object r3 = a.d.a.a.h.g.n8.r(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00f7:
            int r2 = r2 * 53
            boolean r3 = a.d.a.a.h.g.n8.m(r9, r5)
        L_0x00fd:
            int r3 = a.d.a.a.h.g.a6.c(r3)
            goto L_0x0129
        L_0x0102:
            int r2 = r2 * 53
            int r3 = a.d.a.a.h.g.n8.b(r9, r5)
            goto L_0x0129
        L_0x0109:
            int r2 = r2 * 53
            long r3 = a.d.a.a.h.g.n8.i(r9, r5)
            goto L_0x0125
        L_0x0110:
            int r2 = r2 * 53
            float r3 = a.d.a.a.h.g.n8.n(r9, r5)
        L_0x0116:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0129
        L_0x011b:
            int r2 = r2 * 53
            double r3 = a.d.a.a.h.g.n8.q(r9, r5)
        L_0x0121:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0125:
            int r3 = a.d.a.a.h.g.a6.b(r3)
        L_0x0129:
            int r3 = r3 + r2
            r2 = r3
        L_0x012b:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x012f:
            int r2 = r2 * 53
            a.d.a.a.h.g.h8<?, ?> r0 = r8.m
            a.d.a.a.h.g.j8 r0 = (a.d.a.a.h.g.j8) r0
            r1 = 0
            if (r0 == 0) goto L_0x015a
            r0 = r9
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0
            a.d.a.a.h.g.k8 r0 = r0.zzb
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            boolean r2 = r8.f
            if (r2 == 0) goto L_0x0159
            int r0 = r0 * 53
            a.d.a.a.h.g.n5<?> r2 = r8.n
            a.d.a.a.h.g.p5 r2 = (a.d.a.a.h.g.p5) r2
            if (r2 == 0) goto L_0x0158
            a.d.a.a.h.g.y5$d r9 = (a.d.a.a.h.g.y5.d) r9
            a.d.a.a.h.g.r5<a.d.a.a.h.g.y5$c> r9 = r9.zzc
            int r9 = r9.hashCode()
            int r0 = r0 + r9
            goto L_0x0159
        L_0x0158:
            throw r1
        L_0x0159:
            return r0
        L_0x015a:
            goto L_0x015c
        L_0x015b:
            throw r1
        L_0x015c:
            goto L_0x015b
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.b(java.lang.Object):int");
    }

    public final boolean c(T t) {
        int i2;
        int i3;
        T t2 = t;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i6 < this.i) {
                int i7 = this.h[i6];
                int i8 = this.f1776a[i7];
                int I = I(i7);
                int i9 = this.f1776a[i7 + 2];
                int i10 = i9 & 1048575;
                int i11 = 1 << (i9 >>> 20);
                if (i10 != i4) {
                    if (i10 != 1048575) {
                        i5 = q.getInt(t2, (long) i10);
                    }
                    i2 = i5;
                    i3 = i10;
                } else {
                    i3 = i4;
                    i2 = i5;
                }
                if (((268435456 & I) != 0) && !x(t, i7, i3, i2, i11)) {
                    return false;
                }
                int i12 = (267386880 & I) >>> 20;
                if (i12 != 9 && i12 != 17) {
                    if (i12 != 27) {
                        if (i12 == 60 || i12 == 68) {
                            if (w(t2, i8, i7) && !o(i7).c(n8.r(t2, (long) (I & 1048575)))) {
                                return false;
                            }
                        } else if (i12 != 49) {
                            if (i12 == 50 && !this.o.f(n8.r(t2, (long) (I & 1048575))).isEmpty()) {
                                this.o.g(A(i7));
                                throw null;
                            }
                        }
                    }
                    List list = (List) n8.r(t2, (long) (I & 1048575));
                    if (!list.isEmpty()) {
                        v7 o2 = o(i7);
                        int i13 = 0;
                        while (true) {
                            if (i13 >= list.size()) {
                                break;
                            } else if (!o2.c(list.get(i13))) {
                                z = false;
                                break;
                            } else {
                                i13++;
                            }
                        }
                    }
                    if (!z) {
                        return false;
                    }
                } else if (x(t, i7, i3, i2, i11) && !o(i7).c(n8.r(t2, (long) (I & 1048575)))) {
                    return false;
                }
                i6++;
                i4 = i3;
                i5 = i2;
            } else {
                if (this.f) {
                    if (((p5) this.n) == null) {
                        throw null;
                    } else if (!((y5.d) t2).zzc.l()) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (a.d.a.a.h.g.w7.o(a.d.a.a.h.g.n8.r(r10, r6), a.d.a.a.h.g.n8.r(r11, r6)) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (a.d.a.a.h.g.n8.i(r10, r6) == a.d.a.a.h.g.n8.i(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (a.d.a.a.h.g.n8.b(r10, r6) == a.d.a.a.h.g.n8.b(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (a.d.a.a.h.g.n8.i(r10, r6) == a.d.a.a.h.g.n8.i(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (a.d.a.a.h.g.n8.b(r10, r6) == a.d.a.a.h.g.n8.b(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (a.d.a.a.h.g.n8.b(r10, r6) == a.d.a.a.h.g.n8.b(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (a.d.a.a.h.g.n8.b(r10, r6) == a.d.a.a.h.g.n8.b(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (a.d.a.a.h.g.w7.o(a.d.a.a.h.g.n8.r(r10, r6), a.d.a.a.h.g.n8.r(r11, r6)) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (a.d.a.a.h.g.w7.o(a.d.a.a.h.g.n8.r(r10, r6), a.d.a.a.h.g.n8.r(r11, r6)) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (a.d.a.a.h.g.w7.o(a.d.a.a.h.g.n8.r(r10, r6), a.d.a.a.h.g.n8.r(r11, r6)) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (a.d.a.a.h.g.n8.m(r10, r6) == a.d.a.a.h.g.n8.m(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (a.d.a.a.h.g.n8.b(r10, r6) == a.d.a.a.h.g.n8.b(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0146, code lost:
        if (a.d.a.a.h.g.n8.i(r10, r6) == a.d.a.a.h.g.n8.i(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0157, code lost:
        if (a.d.a.a.h.g.n8.b(r10, r6) == a.d.a.a.h.g.n8.b(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016a, code lost:
        if (a.d.a.a.h.g.n8.i(r10, r6) == a.d.a.a.h.g.n8.i(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017d, code lost:
        if (a.d.a.a.h.g.n8.i(r10, r6) == a.d.a.a.h.g.n8.i(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0196, code lost:
        if (java.lang.Float.floatToIntBits(a.d.a.a.h.g.n8.n(r10, r6)) == java.lang.Float.floatToIntBits(a.d.a.a.h.g.n8.n(r11, r6))) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b1, code lost:
        if (java.lang.Double.doubleToLongBits(a.d.a.a.h.g.n8.q(r10, r6)) == java.lang.Double.doubleToLongBits(a.d.a.a.h.g.n8.q(r11, r6))) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b3, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (a.d.a.a.h.g.w7.o(a.d.a.a.h.g.n8.r(r10, r6), a.d.a.a.h.g.n8.r(r11, r6)) != false) goto L_0x01b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.f1776a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01bb
            int r4 = r9.I(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x0199;
                case 1: goto L_0x0180;
                case 2: goto L_0x016d;
                case 3: goto L_0x015a;
                case 4: goto L_0x0149;
                case 5: goto L_0x0136;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003c;
                case 19: goto L_0x003c;
                case 20: goto L_0x003c;
                case 21: goto L_0x003c;
                case 22: goto L_0x003c;
                case 23: goto L_0x003c;
                case 24: goto L_0x003c;
                case 25: goto L_0x003c;
                case 26: goto L_0x003c;
                case 27: goto L_0x003c;
                case 28: goto L_0x003c;
                case 29: goto L_0x003c;
                case 30: goto L_0x003c;
                case 31: goto L_0x003c;
                case 32: goto L_0x003c;
                case 33: goto L_0x003c;
                case 34: goto L_0x003c;
                case 35: goto L_0x003c;
                case 36: goto L_0x003c;
                case 37: goto L_0x003c;
                case 38: goto L_0x003c;
                case 39: goto L_0x003c;
                case 40: goto L_0x003c;
                case 41: goto L_0x003c;
                case 42: goto L_0x003c;
                case 43: goto L_0x003c;
                case 44: goto L_0x003c;
                case 45: goto L_0x003c;
                case 46: goto L_0x003c;
                case 47: goto L_0x003c;
                case 48: goto L_0x003c;
                case 49: goto L_0x003c;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01b4
        L_0x001c:
            int r4 = r9.K(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = a.d.a.a.h.g.n8.b(r10, r4)
            int r4 = a.d.a.a.h.g.n8.b(r11, r4)
            if (r8 != r4) goto L_0x01b3
            java.lang.Object r4 = a.d.a.a.h.g.n8.r(r10, r6)
            java.lang.Object r5 = a.d.a.a.h.g.n8.r(r11, r6)
            boolean r4 = a.d.a.a.h.g.w7.o(r4, r5)
            if (r4 != 0) goto L_0x01b4
            goto L_0x01b3
        L_0x003c:
            java.lang.Object r3 = a.d.a.a.h.g.n8.r(r10, r6)
            java.lang.Object r4 = a.d.a.a.h.g.n8.r(r11, r6)
            boolean r3 = a.d.a.a.h.g.w7.o(r3, r4)
            goto L_0x01b4
        L_0x004a:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            java.lang.Object r4 = a.d.a.a.h.g.n8.r(r10, r6)
            java.lang.Object r5 = a.d.a.a.h.g.n8.r(r11, r6)
            boolean r4 = a.d.a.a.h.g.w7.o(r4, r5)
            if (r4 != 0) goto L_0x01b4
            goto L_0x01b3
        L_0x0060:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            long r4 = a.d.a.a.h.g.n8.i(r10, r6)
            long r6 = a.d.a.a.h.g.n8.i(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b4
            goto L_0x01b3
        L_0x0074:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            int r4 = a.d.a.a.h.g.n8.b(r10, r6)
            int r5 = a.d.a.a.h.g.n8.b(r11, r6)
            if (r4 == r5) goto L_0x01b4
            goto L_0x01b3
        L_0x0086:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            long r4 = a.d.a.a.h.g.n8.i(r10, r6)
            long r6 = a.d.a.a.h.g.n8.i(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b4
            goto L_0x01b3
        L_0x009a:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            int r4 = a.d.a.a.h.g.n8.b(r10, r6)
            int r5 = a.d.a.a.h.g.n8.b(r11, r6)
            if (r4 == r5) goto L_0x01b4
            goto L_0x01b3
        L_0x00ac:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            int r4 = a.d.a.a.h.g.n8.b(r10, r6)
            int r5 = a.d.a.a.h.g.n8.b(r11, r6)
            if (r4 == r5) goto L_0x01b4
            goto L_0x01b3
        L_0x00be:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            int r4 = a.d.a.a.h.g.n8.b(r10, r6)
            int r5 = a.d.a.a.h.g.n8.b(r11, r6)
            if (r4 == r5) goto L_0x01b4
            goto L_0x01b3
        L_0x00d0:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            java.lang.Object r4 = a.d.a.a.h.g.n8.r(r10, r6)
            java.lang.Object r5 = a.d.a.a.h.g.n8.r(r11, r6)
            boolean r4 = a.d.a.a.h.g.w7.o(r4, r5)
            if (r4 != 0) goto L_0x01b4
            goto L_0x01b3
        L_0x00e6:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            java.lang.Object r4 = a.d.a.a.h.g.n8.r(r10, r6)
            java.lang.Object r5 = a.d.a.a.h.g.n8.r(r11, r6)
            boolean r4 = a.d.a.a.h.g.w7.o(r4, r5)
            if (r4 != 0) goto L_0x01b4
            goto L_0x01b3
        L_0x00fc:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            java.lang.Object r4 = a.d.a.a.h.g.n8.r(r10, r6)
            java.lang.Object r5 = a.d.a.a.h.g.n8.r(r11, r6)
            boolean r4 = a.d.a.a.h.g.w7.o(r4, r5)
            if (r4 != 0) goto L_0x01b4
            goto L_0x01b3
        L_0x0112:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            boolean r4 = a.d.a.a.h.g.n8.m(r10, r6)
            boolean r5 = a.d.a.a.h.g.n8.m(r11, r6)
            if (r4 == r5) goto L_0x01b4
            goto L_0x01b3
        L_0x0124:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            int r4 = a.d.a.a.h.g.n8.b(r10, r6)
            int r5 = a.d.a.a.h.g.n8.b(r11, r6)
            if (r4 == r5) goto L_0x01b4
            goto L_0x01b3
        L_0x0136:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            long r4 = a.d.a.a.h.g.n8.i(r10, r6)
            long r6 = a.d.a.a.h.g.n8.i(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b4
            goto L_0x01b3
        L_0x0149:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            int r4 = a.d.a.a.h.g.n8.b(r10, r6)
            int r5 = a.d.a.a.h.g.n8.b(r11, r6)
            if (r4 == r5) goto L_0x01b4
            goto L_0x01b3
        L_0x015a:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            long r4 = a.d.a.a.h.g.n8.i(r10, r6)
            long r6 = a.d.a.a.h.g.n8.i(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b4
            goto L_0x01b3
        L_0x016d:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            long r4 = a.d.a.a.h.g.n8.i(r10, r6)
            long r6 = a.d.a.a.h.g.n8.i(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b4
            goto L_0x01b3
        L_0x0180:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            float r4 = a.d.a.a.h.g.n8.n(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = a.d.a.a.h.g.n8.n(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01b4
            goto L_0x01b3
        L_0x0199:
            boolean r4 = r9.H(r10, r11, r2)
            if (r4 == 0) goto L_0x01b3
            double r4 = a.d.a.a.h.g.n8.q(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = a.d.a.a.h.g.n8.q(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b4
        L_0x01b3:
            r3 = 0
        L_0x01b4:
            if (r3 != 0) goto L_0x01b7
            return r1
        L_0x01b7:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01bb:
            a.d.a.a.h.g.h8<?, ?> r0 = r9.m
            a.d.a.a.h.g.j8 r0 = (a.d.a.a.h.g.j8) r0
            r2 = 0
            if (r0 == 0) goto L_0x01f2
            r4 = r10
            a.d.a.a.h.g.y5 r4 = (a.d.a.a.h.g.y5) r4
            a.d.a.a.h.g.k8 r4 = r4.zzb
            if (r0 == 0) goto L_0x01f1
            r0 = r11
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0
            a.d.a.a.h.g.k8 r0 = r0.zzb
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x01d5
            return r1
        L_0x01d5:
            boolean r0 = r9.f
            if (r0 == 0) goto L_0x01f0
            a.d.a.a.h.g.n5<?> r0 = r9.n
            a.d.a.a.h.g.p5 r0 = (a.d.a.a.h.g.p5) r0
            if (r0 == 0) goto L_0x01ef
            a.d.a.a.h.g.y5$d r10 = (a.d.a.a.h.g.y5.d) r10
            a.d.a.a.h.g.r5<a.d.a.a.h.g.y5$c> r10 = r10.zzc
            if (r0 == 0) goto L_0x01ee
            a.d.a.a.h.g.y5$d r11 = (a.d.a.a.h.g.y5.d) r11
            a.d.a.a.h.g.r5<a.d.a.a.h.g.y5$c> r11 = r11.zzc
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01ee:
            throw r2
        L_0x01ef:
            throw r2
        L_0x01f0:
            return r3
        L_0x01f1:
            throw r2
        L_0x01f2:
            goto L_0x01f4
        L_0x01f3:
            throw r2
        L_0x01f4:
            goto L_0x01f3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.d(java.lang.Object, java.lang.Object):boolean");
    }

    public final void e(T t) {
        int i2;
        int i3 = this.i;
        while (true) {
            i2 = this.j;
            if (i3 >= i2) {
                break;
            }
            long I = (long) (I(this.h[i3]) & 1048575);
            Object r = n8.r(t, I);
            if (r != null) {
                n8.f(t, I, this.o.c(r));
            }
            i3++;
        }
        int length = this.h.length;
        while (i2 < length) {
            this.l.b(t, (long) this.h[i2]);
            i2++;
        }
        if (((j8) this.m) != null) {
            ((y5) t).zzb.f1785e = false;
            if (!this.f) {
                return;
            }
            if (((p5) this.n) != null) {
                ((y5.d) t).zzc.g();
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x025d, code lost:
        r6 = a.d.a.a.h.g.i5.v(r9, (a.d.a.a.h.g.i7) a.d.a.a.h.g.n8.r(r15, r10), o(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0277, code lost:
        r6 = a.d.a.a.h.g.i5.F(r9, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0287, code lost:
        r6 = a.d.a.a.h.g.i5.N(r9, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0293, code lost:
        r6 = a.d.a.a.h.g.i5.O(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x029f, code lost:
        r6 = a.d.a.a.h.g.i5.T(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02af, code lost:
        r6 = a.d.a.a.h.g.i5.U(r9, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02bf, code lost:
        r6 = a.d.a.a.h.g.i5.J(r9, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02cb, code lost:
        r6 = a.d.a.a.h.g.n8.r(r15, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02d6, code lost:
        r6 = a.d.a.a.h.g.w7.a(r9, a.d.a.a.h.g.n8.r(r15, r10), o(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02f0, code lost:
        if ((r6 instanceof a.d.a.a.h.g.w4) != false) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02f2, code lost:
        r6 = a.d.a.a.h.g.i5.u(r9, (a.d.a.a.h.g.w4) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02fa, code lost:
        r6 = a.d.a.a.h.g.i5.j(r9, (java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0307, code lost:
        r6 = a.d.a.a.h.g.i5.t(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0312, code lost:
        r6 = a.d.a.a.h.g.i5.R(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x031d, code lost:
        r6 = a.d.a.a.h.g.i5.K(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x032c, code lost:
        r6 = a.d.a.a.h.g.i5.E(r9, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x033b, code lost:
        r6 = a.d.a.a.h.g.i5.B(r9, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x034a, code lost:
        r6 = a.d.a.a.h.g.i5.y(r9, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0355, code lost:
        r6 = a.d.a.a.h.g.i5.i(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0360, code lost:
        r6 = a.d.a.a.h.g.i5.r(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0364, code lost:
        r5 = r6 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0366, code lost:
        r4 = r4 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0419, code lost:
        if ((r1 instanceof a.d.a.a.h.g.w4) != false) goto L_0x0679;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0544, code lost:
        r5 = ((a.d.a.a.h.g.i5.I(r1) + a.d.a.a.h.g.i5.A(r10)) + r1) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x05f6, code lost:
        r1 = a.d.a.a.h.g.i5.v(r10, (a.d.a.a.h.g.i7) r0.getObject(r15, r12), o(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x060e, code lost:
        r1 = a.d.a.a.h.g.i5.F(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x061c, code lost:
        r1 = a.d.a.a.h.g.i5.N(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0626, code lost:
        r1 = a.d.a.a.h.g.i5.O(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0630, code lost:
        r1 = a.d.a.a.h.g.i5.T(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x063e, code lost:
        r1 = a.d.a.a.h.g.i5.U(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x064c, code lost:
        r1 = a.d.a.a.h.g.i5.J(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0656, code lost:
        r1 = r0.getObject(r15, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x065f, code lost:
        r1 = a.d.a.a.h.g.w7.a(r10, r0.getObject(r15, r12), o(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0677, code lost:
        if ((r1 instanceof a.d.a.a.h.g.w4) != false) goto L_0x0679;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0679, code lost:
        r1 = a.d.a.a.h.g.i5.u(r10, (a.d.a.a.h.g.w4) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0680, code lost:
        r1 = a.d.a.a.h.g.i5.j(r10, (java.lang.String) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x068b, code lost:
        r1 = a.d.a.a.h.g.i5.t(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0694, code lost:
        r1 = a.d.a.a.h.g.i5.R(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x069d, code lost:
        r1 = a.d.a.a.h.g.i5.K(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x06aa, code lost:
        r1 = a.d.a.a.h.g.i5.E(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x06b7, code lost:
        r1 = a.d.a.a.h.g.i5.B(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x06c4, code lost:
        r1 = a.d.a.a.h.g.i5.y(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x06cd, code lost:
        r1 = a.d.a.a.h.g.i5.i(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x06d6, code lost:
        r1 = a.d.a.a.h.g.i5.r(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x06da, code lost:
        r5 = r5 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x06db, code lost:
        r4 = r4 + 3;
        r1 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
        if ((r6 instanceof a.d.a.a.h.g.w4) != false) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c3, code lost:
        r5 = ((a.d.a.a.h.g.i5.I(r6) + a.d.a.a.h.g.i5.A(r9)) + r6) + r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int f(T r15) {
        /*
            r14 = this;
            boolean r0 = r14.g
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            if (r0 == 0) goto L_0x037b
            sun.misc.Unsafe r0 = q
            r4 = 0
            r5 = 0
        L_0x000e:
            int[] r6 = r14.f1776a
            int r6 = r6.length
            if (r4 >= r6) goto L_0x036a
            int r6 = r14.I(r4)
            r7 = r6 & r2
            int r7 = r7 >>> 20
            int[] r8 = r14.f1776a
            r9 = r8[r4]
            r6 = r6 & r1
            long r10 = (long) r6
            a.d.a.a.h.g.s5 r6 = a.d.a.a.h.g.s5.DOUBLE_LIST_PACKED
            int r6 = r6.f1933a
            if (r7 < r6) goto L_0x0031
            a.d.a.a.h.g.s5 r6 = a.d.a.a.h.g.s5.SINT64_LIST_PACKED
            int r6 = r6.f1933a
            if (r7 > r6) goto L_0x0031
            int r6 = r4 + 2
            r6 = r8[r6]
        L_0x0031:
            switch(r7) {
                case 0: goto L_0x035a;
                case 1: goto L_0x034f;
                case 2: goto L_0x0340;
                case 3: goto L_0x0331;
                case 4: goto L_0x0322;
                case 5: goto L_0x0317;
                case 6: goto L_0x030c;
                case 7: goto L_0x0301;
                case 8: goto L_0x02e4;
                case 9: goto L_0x02d0;
                case 10: goto L_0x02c5;
                case 11: goto L_0x02b5;
                case 12: goto L_0x02a5;
                case 13: goto L_0x0299;
                case 14: goto L_0x028d;
                case 15: goto L_0x027d;
                case 16: goto L_0x026d;
                case 17: goto L_0x0257;
                case 18: goto L_0x024d;
                case 19: goto L_0x0243;
                case 20: goto L_0x0239;
                case 21: goto L_0x022f;
                case 22: goto L_0x0225;
                case 23: goto L_0x024d;
                case 24: goto L_0x0243;
                case 25: goto L_0x021b;
                case 26: goto L_0x0211;
                case 27: goto L_0x0203;
                case 28: goto L_0x01f9;
                case 29: goto L_0x01ef;
                case 30: goto L_0x01e5;
                case 31: goto L_0x0243;
                case 32: goto L_0x024d;
                case 33: goto L_0x01db;
                case 34: goto L_0x01d1;
                case 35: goto L_0x01b7;
                case 36: goto L_0x01aa;
                case 37: goto L_0x019d;
                case 38: goto L_0x0190;
                case 39: goto L_0x0183;
                case 40: goto L_0x0176;
                case 41: goto L_0x0169;
                case 42: goto L_0x015c;
                case 43: goto L_0x014e;
                case 44: goto L_0x0140;
                case 45: goto L_0x0132;
                case 46: goto L_0x0124;
                case 47: goto L_0x0116;
                case 48: goto L_0x0108;
                case 49: goto L_0x00fa;
                case 50: goto L_0x00ea;
                case 51: goto L_0x00e2;
                case 52: goto L_0x00da;
                case 53: goto L_0x00ce;
                case 54: goto L_0x00c2;
                case 55: goto L_0x00b6;
                case 56: goto L_0x00ae;
                case 57: goto L_0x00a6;
                case 58: goto L_0x009e;
                case 59: goto L_0x008e;
                case 60: goto L_0x0086;
                case 61: goto L_0x007e;
                case 62: goto L_0x0072;
                case 63: goto L_0x0066;
                case 64: goto L_0x005e;
                case 65: goto L_0x0056;
                case 66: goto L_0x004a;
                case 67: goto L_0x003e;
                case 68: goto L_0x0036;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0366
        L_0x0036:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x025d
        L_0x003e:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            long r6 = L(r15, r10)
            goto L_0x0277
        L_0x004a:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            int r6 = J(r15, r10)
            goto L_0x0287
        L_0x0056:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x0293
        L_0x005e:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x029f
        L_0x0066:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            int r6 = J(r15, r10)
            goto L_0x02af
        L_0x0072:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            int r6 = J(r15, r10)
            goto L_0x02bf
        L_0x007e:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x02cb
        L_0x0086:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x02d6
        L_0x008e:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r15, r10)
            boolean r7 = r6 instanceof a.d.a.a.h.g.w4
            if (r7 == 0) goto L_0x02fa
            goto L_0x02f2
        L_0x009e:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x0307
        L_0x00a6:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x0312
        L_0x00ae:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x031d
        L_0x00b6:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            int r6 = J(r15, r10)
            goto L_0x032c
        L_0x00c2:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            long r6 = L(r15, r10)
            goto L_0x033b
        L_0x00ce:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            long r6 = L(r15, r10)
            goto L_0x034a
        L_0x00da:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x0355
        L_0x00e2:
            boolean r6 = r14.w(r15, r9, r4)
            if (r6 == 0) goto L_0x0366
            goto L_0x0360
        L_0x00ea:
            a.d.a.a.h.g.b7 r6 = r14.o
            java.lang.Object r7 = a.d.a.a.h.g.n8.r(r15, r10)
            java.lang.Object r8 = r14.A(r4)
            int r6 = r6.i(r9, r7, r8)
            goto L_0x0364
        L_0x00fa:
            java.util.List r6 = q(r15, r10)
            a.d.a.a.h.g.v7 r7 = r14.o(r4)
            int r6 = a.d.a.a.h.g.w7.r(r9, r6, r7)
            goto L_0x0364
        L_0x0108:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.y(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x0116:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.K(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x0124:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.Q(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x0132:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.N(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x0140:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.B(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x014e:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.H(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x015c:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.T(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x0169:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.N(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x0176:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.Q(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x0183:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.E(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x0190:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.s(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x019d:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.d(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x01aa:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.N(r6)
            if (r6 <= 0) goto L_0x0366
            goto L_0x01c3
        L_0x01b7:
            java.lang.Object r6 = r0.getObject(r15, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = a.d.a.a.h.g.w7.Q(r6)
            if (r6 <= 0) goto L_0x0366
        L_0x01c3:
            int r7 = a.d.a.a.h.g.i5.A(r9)
            int r8 = a.d.a.a.h.g.i5.I(r6)
            int r8 = r8 + r7
            int r8 = r8 + r6
            int r8 = r8 + r5
            r5 = r8
            goto L_0x0366
        L_0x01d1:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.x(r9, r6)
            goto L_0x0364
        L_0x01db:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.J(r9, r6)
            goto L_0x0364
        L_0x01e5:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.A(r9, r6)
            goto L_0x0364
        L_0x01ef:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.G(r9, r6)
            goto L_0x0364
        L_0x01f9:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.q(r9, r6)
            goto L_0x0364
        L_0x0203:
            java.util.List r6 = q(r15, r10)
            a.d.a.a.h.g.v7 r7 = r14.o(r4)
            int r6 = a.d.a.a.h.g.w7.c(r9, r6, r7)
            goto L_0x0364
        L_0x0211:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.b(r9, r6)
            goto L_0x0364
        L_0x021b:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.S(r9, r6)
            goto L_0x0364
        L_0x0225:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.D(r9, r6)
            goto L_0x0364
        L_0x022f:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.w(r9, r6)
            goto L_0x0364
        L_0x0239:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.p(r9, r6)
            goto L_0x0364
        L_0x0243:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.M(r9, r6)
            goto L_0x0364
        L_0x024d:
            java.util.List r6 = q(r15, r10)
            int r6 = a.d.a.a.h.g.w7.P(r9, r6)
            goto L_0x0364
        L_0x0257:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x025d:
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r15, r10)
            a.d.a.a.h.g.i7 r6 = (a.d.a.a.h.g.i7) r6
            a.d.a.a.h.g.v7 r7 = r14.o(r4)
            int r6 = a.d.a.a.h.g.i5.v(r9, r6, r7)
            goto L_0x0364
        L_0x026d:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
            long r6 = a.d.a.a.h.g.n8.i(r15, r10)
        L_0x0277:
            int r6 = a.d.a.a.h.g.i5.F(r9, r6)
            goto L_0x0364
        L_0x027d:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
            int r6 = a.d.a.a.h.g.n8.b(r15, r10)
        L_0x0287:
            int r6 = a.d.a.a.h.g.i5.N(r9, r6)
            goto L_0x0364
        L_0x028d:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x0293:
            int r6 = a.d.a.a.h.g.i5.O(r9)
            goto L_0x0364
        L_0x0299:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x029f:
            int r6 = a.d.a.a.h.g.i5.T(r9)
            goto L_0x0364
        L_0x02a5:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
            int r6 = a.d.a.a.h.g.n8.b(r15, r10)
        L_0x02af:
            int r6 = a.d.a.a.h.g.i5.U(r9, r6)
            goto L_0x0364
        L_0x02b5:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
            int r6 = a.d.a.a.h.g.n8.b(r15, r10)
        L_0x02bf:
            int r6 = a.d.a.a.h.g.i5.J(r9, r6)
            goto L_0x0364
        L_0x02c5:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x02cb:
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r15, r10)
            goto L_0x02f2
        L_0x02d0:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x02d6:
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r15, r10)
            a.d.a.a.h.g.v7 r7 = r14.o(r4)
            int r6 = a.d.a.a.h.g.w7.a(r9, r6, r7)
            goto L_0x0364
        L_0x02e4:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r15, r10)
            boolean r7 = r6 instanceof a.d.a.a.h.g.w4
            if (r7 == 0) goto L_0x02fa
        L_0x02f2:
            a.d.a.a.h.g.w4 r6 = (a.d.a.a.h.g.w4) r6
            int r6 = a.d.a.a.h.g.i5.u(r9, r6)
            goto L_0x0364
        L_0x02fa:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = a.d.a.a.h.g.i5.j(r9, r6)
            goto L_0x0364
        L_0x0301:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x0307:
            int r6 = a.d.a.a.h.g.i5.t(r9)
            goto L_0x0364
        L_0x030c:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x0312:
            int r6 = a.d.a.a.h.g.i5.R(r9)
            goto L_0x0364
        L_0x0317:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x031d:
            int r6 = a.d.a.a.h.g.i5.K(r9)
            goto L_0x0364
        L_0x0322:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
            int r6 = a.d.a.a.h.g.n8.b(r15, r10)
        L_0x032c:
            int r6 = a.d.a.a.h.g.i5.E(r9, r6)
            goto L_0x0364
        L_0x0331:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
            long r6 = a.d.a.a.h.g.n8.i(r15, r10)
        L_0x033b:
            int r6 = a.d.a.a.h.g.i5.B(r9, r6)
            goto L_0x0364
        L_0x0340:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
            long r6 = a.d.a.a.h.g.n8.i(r15, r10)
        L_0x034a:
            int r6 = a.d.a.a.h.g.i5.y(r9, r6)
            goto L_0x0364
        L_0x034f:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x0355:
            int r6 = a.d.a.a.h.g.i5.i(r9)
            goto L_0x0364
        L_0x035a:
            boolean r6 = r14.v(r15, r4)
            if (r6 == 0) goto L_0x0366
        L_0x0360:
            int r6 = a.d.a.a.h.g.i5.r(r9)
        L_0x0364:
            int r6 = r6 + r5
            r5 = r6
        L_0x0366:
            int r4 = r4 + 3
            goto L_0x000e
        L_0x036a:
            a.d.a.a.h.g.h8<?, ?> r0 = r14.m
            a.d.a.a.h.g.j8 r0 = (a.d.a.a.h.g.j8) r0
            if (r0 == 0) goto L_0x037a
            a.d.a.a.h.g.y5 r15 = (a.d.a.a.h.g.y5) r15
            a.d.a.a.h.g.k8 r15 = r15.zzb
            int r15 = r15.e()
            int r15 = r15 + r5
            return r15
        L_0x037a:
            throw r3
        L_0x037b:
            sun.misc.Unsafe r0 = q
            r4 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r7 = 0
        L_0x0383:
            int[] r8 = r14.f1776a
            int r8 = r8.length
            if (r4 >= r8) goto L_0x06e2
            int r8 = r14.I(r4)
            int[] r9 = r14.f1776a
            r10 = r9[r4]
            r11 = r8 & r2
            int r11 = r11 >>> 20
            r12 = 17
            if (r11 > r12) goto L_0x03ad
            int r12 = r4 + 2
            r9 = r9[r12]
            r12 = r9 & r1
            int r9 = r9 >>> 20
            r13 = 1
            int r9 = r13 << r9
            if (r12 == r6) goto L_0x03ae
            long r6 = (long) r12
            int r6 = r0.getInt(r15, r6)
            r7 = r6
            r6 = r12
            goto L_0x03ae
        L_0x03ad:
            r9 = 0
        L_0x03ae:
            r1 = r1 & r8
            long r12 = (long) r1
            switch(r11) {
                case 0: goto L_0x06d2;
                case 1: goto L_0x06c9;
                case 2: goto L_0x06bc;
                case 3: goto L_0x06af;
                case 4: goto L_0x06a2;
                case 5: goto L_0x0699;
                case 6: goto L_0x0690;
                case 7: goto L_0x0687;
                case 8: goto L_0x066d;
                case 9: goto L_0x065b;
                case 10: goto L_0x0652;
                case 11: goto L_0x0644;
                case 12: goto L_0x0636;
                case 13: goto L_0x062c;
                case 14: goto L_0x0622;
                case 15: goto L_0x0614;
                case 16: goto L_0x0606;
                case 17: goto L_0x05f2;
                case 18: goto L_0x05e6;
                case 19: goto L_0x05da;
                case 20: goto L_0x05ce;
                case 21: goto L_0x05c2;
                case 22: goto L_0x05b6;
                case 23: goto L_0x05e6;
                case 24: goto L_0x05da;
                case 25: goto L_0x05aa;
                case 26: goto L_0x059e;
                case 27: goto L_0x058e;
                case 28: goto L_0x0582;
                case 29: goto L_0x0576;
                case 30: goto L_0x056a;
                case 31: goto L_0x05da;
                case 32: goto L_0x05e6;
                case 33: goto L_0x055e;
                case 34: goto L_0x0552;
                case 35: goto L_0x0538;
                case 36: goto L_0x052b;
                case 37: goto L_0x051e;
                case 38: goto L_0x0511;
                case 39: goto L_0x0504;
                case 40: goto L_0x04f7;
                case 41: goto L_0x04ea;
                case 42: goto L_0x04dd;
                case 43: goto L_0x04cf;
                case 44: goto L_0x04c1;
                case 45: goto L_0x04b3;
                case 46: goto L_0x04a5;
                case 47: goto L_0x0497;
                case 48: goto L_0x0489;
                case 49: goto L_0x0479;
                case 50: goto L_0x0469;
                case 51: goto L_0x0461;
                case 52: goto L_0x0459;
                case 53: goto L_0x044d;
                case 54: goto L_0x0441;
                case 55: goto L_0x0435;
                case 56: goto L_0x042d;
                case 57: goto L_0x0425;
                case 58: goto L_0x041d;
                case 59: goto L_0x040d;
                case 60: goto L_0x0405;
                case 61: goto L_0x03fd;
                case 62: goto L_0x03f1;
                case 63: goto L_0x03e5;
                case 64: goto L_0x03dd;
                case 65: goto L_0x03d5;
                case 66: goto L_0x03c9;
                case 67: goto L_0x03bd;
                case 68: goto L_0x03b5;
                default: goto L_0x03b3;
            }
        L_0x03b3:
            goto L_0x06db
        L_0x03b5:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x05f6
        L_0x03bd:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            long r8 = L(r15, r12)
            goto L_0x060e
        L_0x03c9:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            int r1 = J(r15, r12)
            goto L_0x061c
        L_0x03d5:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x0626
        L_0x03dd:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x0630
        L_0x03e5:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            int r1 = J(r15, r12)
            goto L_0x063e
        L_0x03f1:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            int r1 = J(r15, r12)
            goto L_0x064c
        L_0x03fd:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x0656
        L_0x0405:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x065f
        L_0x040d:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            java.lang.Object r1 = r0.getObject(r15, r12)
            boolean r8 = r1 instanceof a.d.a.a.h.g.w4
            if (r8 == 0) goto L_0x0680
            goto L_0x0679
        L_0x041d:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x068b
        L_0x0425:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x0694
        L_0x042d:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x069d
        L_0x0435:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            int r1 = J(r15, r12)
            goto L_0x06aa
        L_0x0441:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            long r8 = L(r15, r12)
            goto L_0x06b7
        L_0x044d:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            long r8 = L(r15, r12)
            goto L_0x06c4
        L_0x0459:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x06cd
        L_0x0461:
            boolean r1 = r14.w(r15, r10, r4)
            if (r1 == 0) goto L_0x06db
            goto L_0x06d6
        L_0x0469:
            a.d.a.a.h.g.b7 r1 = r14.o
            java.lang.Object r8 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.A(r4)
            int r1 = r1.i(r10, r8, r9)
            goto L_0x06da
        L_0x0479:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            a.d.a.a.h.g.v7 r8 = r14.o(r4)
            int r1 = a.d.a.a.h.g.w7.r(r10, r1, r8)
            goto L_0x06da
        L_0x0489:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.y(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x0497:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.K(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x04a5:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.Q(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x04b3:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.N(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x04c1:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.B(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x04cf:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.H(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x04dd:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.T(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x04ea:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.N(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x04f7:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.Q(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x0504:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.E(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x0511:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.s(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x051e:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.d(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x052b:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.N(r1)
            if (r1 <= 0) goto L_0x06db
            goto L_0x0544
        L_0x0538:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.Q(r1)
            if (r1 <= 0) goto L_0x06db
        L_0x0544:
            int r8 = a.d.a.a.h.g.i5.A(r10)
            int r9 = a.d.a.a.h.g.i5.I(r1)
            int r9 = r9 + r8
            int r9 = r9 + r1
            int r9 = r9 + r5
            r5 = r9
            goto L_0x06db
        L_0x0552:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.x(r10, r1)
            goto L_0x06da
        L_0x055e:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.J(r10, r1)
            goto L_0x06da
        L_0x056a:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.A(r10, r1)
            goto L_0x06da
        L_0x0576:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.G(r10, r1)
            goto L_0x06da
        L_0x0582:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.q(r10, r1)
            goto L_0x06da
        L_0x058e:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            a.d.a.a.h.g.v7 r8 = r14.o(r4)
            int r1 = a.d.a.a.h.g.w7.c(r10, r1, r8)
            goto L_0x06da
        L_0x059e:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.b(r10, r1)
            goto L_0x06da
        L_0x05aa:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.S(r10, r1)
            goto L_0x06da
        L_0x05b6:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.D(r10, r1)
            goto L_0x06da
        L_0x05c2:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.w(r10, r1)
            goto L_0x06da
        L_0x05ce:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.p(r10, r1)
            goto L_0x06da
        L_0x05da:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.M(r10, r1)
            goto L_0x06da
        L_0x05e6:
            java.lang.Object r1 = r0.getObject(r15, r12)
            java.util.List r1 = (java.util.List) r1
            int r1 = a.d.a.a.h.g.w7.P(r10, r1)
            goto L_0x06da
        L_0x05f2:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x05f6:
            java.lang.Object r1 = r0.getObject(r15, r12)
            a.d.a.a.h.g.i7 r1 = (a.d.a.a.h.g.i7) r1
            a.d.a.a.h.g.v7 r8 = r14.o(r4)
            int r1 = a.d.a.a.h.g.i5.v(r10, r1, r8)
            goto L_0x06da
        L_0x0606:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
            long r8 = r0.getLong(r15, r12)
        L_0x060e:
            int r1 = a.d.a.a.h.g.i5.F(r10, r8)
            goto L_0x06da
        L_0x0614:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
            int r1 = r0.getInt(r15, r12)
        L_0x061c:
            int r1 = a.d.a.a.h.g.i5.N(r10, r1)
            goto L_0x06da
        L_0x0622:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x0626:
            int r1 = a.d.a.a.h.g.i5.O(r10)
            goto L_0x06da
        L_0x062c:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x0630:
            int r1 = a.d.a.a.h.g.i5.T(r10)
            goto L_0x06da
        L_0x0636:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
            int r1 = r0.getInt(r15, r12)
        L_0x063e:
            int r1 = a.d.a.a.h.g.i5.U(r10, r1)
            goto L_0x06da
        L_0x0644:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
            int r1 = r0.getInt(r15, r12)
        L_0x064c:
            int r1 = a.d.a.a.h.g.i5.J(r10, r1)
            goto L_0x06da
        L_0x0652:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x0656:
            java.lang.Object r1 = r0.getObject(r15, r12)
            goto L_0x0679
        L_0x065b:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x065f:
            java.lang.Object r1 = r0.getObject(r15, r12)
            a.d.a.a.h.g.v7 r8 = r14.o(r4)
            int r1 = a.d.a.a.h.g.w7.a(r10, r1, r8)
            goto L_0x06da
        L_0x066d:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
            java.lang.Object r1 = r0.getObject(r15, r12)
            boolean r8 = r1 instanceof a.d.a.a.h.g.w4
            if (r8 == 0) goto L_0x0680
        L_0x0679:
            a.d.a.a.h.g.w4 r1 = (a.d.a.a.h.g.w4) r1
            int r1 = a.d.a.a.h.g.i5.u(r10, r1)
            goto L_0x06da
        L_0x0680:
            java.lang.String r1 = (java.lang.String) r1
            int r1 = a.d.a.a.h.g.i5.j(r10, r1)
            goto L_0x06da
        L_0x0687:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x068b:
            int r1 = a.d.a.a.h.g.i5.t(r10)
            goto L_0x06da
        L_0x0690:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x0694:
            int r1 = a.d.a.a.h.g.i5.R(r10)
            goto L_0x06da
        L_0x0699:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x069d:
            int r1 = a.d.a.a.h.g.i5.K(r10)
            goto L_0x06da
        L_0x06a2:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
            int r1 = r0.getInt(r15, r12)
        L_0x06aa:
            int r1 = a.d.a.a.h.g.i5.E(r10, r1)
            goto L_0x06da
        L_0x06af:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
            long r8 = r0.getLong(r15, r12)
        L_0x06b7:
            int r1 = a.d.a.a.h.g.i5.B(r10, r8)
            goto L_0x06da
        L_0x06bc:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
            long r8 = r0.getLong(r15, r12)
        L_0x06c4:
            int r1 = a.d.a.a.h.g.i5.y(r10, r8)
            goto L_0x06da
        L_0x06c9:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x06cd:
            int r1 = a.d.a.a.h.g.i5.i(r10)
            goto L_0x06da
        L_0x06d2:
            r1 = r7 & r9
            if (r1 == 0) goto L_0x06db
        L_0x06d6:
            int r1 = a.d.a.a.h.g.i5.r(r10)
        L_0x06da:
            int r5 = r5 + r1
        L_0x06db:
            int r4 = r4 + 3
            r1 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0383
        L_0x06e2:
            a.d.a.a.h.g.h8<?, ?> r0 = r14.m
            a.d.a.a.h.g.j8 r0 = (a.d.a.a.h.g.j8) r0
            if (r0 == 0) goto L_0x074c
            r0 = r15
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0
            a.d.a.a.h.g.k8 r0 = r0.zzb
            int r0 = r0.e()
            int r0 = r0 + r5
            boolean r1 = r14.f
            if (r1 == 0) goto L_0x074b
            a.d.a.a.h.g.n5<?> r1 = r14.n
            a.d.a.a.h.g.p5 r1 = (a.d.a.a.h.g.p5) r1
            if (r1 == 0) goto L_0x074a
            a.d.a.a.h.g.y5$d r15 = (a.d.a.a.h.g.y5.d) r15
            a.d.a.a.h.g.r5<a.d.a.a.h.g.y5$c> r15 = r15.zzc
            r1 = 0
            r2 = 0
        L_0x0702:
            a.d.a.a.h.g.z7<T, java.lang.Object> r3 = r15.f1917a
            int r3 = r3.g()
            if (r1 >= r3) goto L_0x0722
            a.d.a.a.h.g.z7<T, java.lang.Object> r3 = r15.f1917a
            java.util.Map$Entry r3 = r3.f(r1)
            java.lang.Object r4 = r3.getKey()
            a.d.a.a.h.g.t5 r4 = (a.d.a.a.h.g.t5) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = a.d.a.a.h.g.r5.a(r4, r3)
            int r2 = r2 + r3
            int r1 = r1 + 1
            goto L_0x0702
        L_0x0722:
            a.d.a.a.h.g.z7<T, java.lang.Object> r15 = r15.f1917a
            java.lang.Iterable r15 = r15.i()
            java.util.Iterator r15 = r15.iterator()
        L_0x072c:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0748
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            a.d.a.a.h.g.t5 r3 = (a.d.a.a.h.g.t5) r3
            java.lang.Object r1 = r1.getValue()
            int r1 = a.d.a.a.h.g.r5.a(r3, r1)
            int r2 = r2 + r1
            goto L_0x072c
        L_0x0748:
            int r0 = r0 + r2
            goto L_0x074b
        L_0x074a:
            throw r3
        L_0x074b:
            return r0
        L_0x074c:
            goto L_0x074e
        L_0x074d:
            throw r3
        L_0x074e:
            goto L_0x074d
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.f(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x032b, code lost:
        if (r0 == r15) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0372, code lost:
        if (r0 == r15) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d6, code lost:
        r15 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0107, code lost:
        r12.putInt(r5, r14, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0123, code lost:
        r10 = r10 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0126, code lost:
        r15 = r32;
        r14 = r3;
        r9 = r5;
        r17 = r6;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0152, code lost:
        r1 = r6.f1983c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017b, code lost:
        r12.putObject(r5, r3, r1);
        r9 = r6;
        r14 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01bf, code lost:
        r10 = r10 | r21;
        r3 = r5;
        r5 = r6;
        r2 = r13;
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0207, code lost:
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x024b, code lost:
        r1 = r10 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x024d, code lost:
        r10 = r1;
        r3 = r6;
        r5 = r9;
        r27 = r12;
        r2 = r13;
        r6 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0282, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(T r29, byte[] r30, int r31, int r32, a.d.a.a.h.g.v4 r33) {
        /*
            r28 = this;
            r15 = r32
            r14 = r28
            boolean r0 = r14.g
            if (r0 == 0) goto L_0x03c6
            sun.misc.Unsafe r12 = q
            r13 = -1
            r9 = 0
            r3 = r29
            r7 = r30
            r0 = r31
            r5 = r33
            r6 = r14
            r1 = -1
            r2 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 0
        L_0x001b:
            if (r0 >= r15) goto L_0x03a9
            int r4 = r0 + 1
            byte r0 = r7[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = a.c.a.f.b.O0(r0, r7, r4, r5)
            int r4 = r5.f1981a
            r16 = r4
            goto L_0x002f
        L_0x002c:
            r16 = r0
            r0 = r4
        L_0x002f:
            int r4 = r16 >>> 3
            r11 = r16 & 7
            if (r4 <= r1) goto L_0x0044
            int r2 = r2 / 3
            int r1 = r6.f1778c
            if (r4 < r1) goto L_0x0052
            int r1 = r6.f1779d
            if (r4 > r1) goto L_0x0052
            int r1 = r6.z(r4, r2)
            goto L_0x0050
        L_0x0044:
            int r1 = r6.f1778c
            if (r4 < r1) goto L_0x0052
            int r1 = r6.f1779d
            if (r4 > r1) goto L_0x0052
            int r1 = r6.z(r4, r9)
        L_0x0050:
            r2 = r1
            goto L_0x0053
        L_0x0052:
            r2 = -1
        L_0x0053:
            if (r2 != r13) goto L_0x005d
            r23 = r4
            r2 = 0
            r24 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0283
        L_0x005d:
            int[] r1 = r6.f1776a
            int r18 = r2 + 1
            r9 = r1[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r9 & r18
            int r13 = r18 >>> 20
            r31 = r4
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r9 & r17
            long r14 = (long) r4
            r4 = 17
            r18 = r6
            if (r13 > r4) goto L_0x028e
            int r4 = r2 + 2
            r1 = r1[r4]
            int r4 = r1 >>> 20
            r6 = 1
            int r21 = r6 << r4
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r4
            r17 = r7
            if (r1 == r8) goto L_0x0097
            if (r8 == r4) goto L_0x008e
            long r6 = (long) r8
            r12.putInt(r3, r6, r10)
        L_0x008e:
            if (r1 == r4) goto L_0x0096
            long r6 = (long) r1
            int r6 = r12.getInt(r3, r6)
            r10 = r6
        L_0x0096:
            r8 = r1
        L_0x0097:
            r1 = 5
            switch(r13) {
                case 0: goto L_0x025a;
                case 1: goto L_0x022f;
                case 2: goto L_0x0209;
                case 3: goto L_0x0209;
                case 4: goto L_0x01ed;
                case 5: goto L_0x01c8;
                case 6: goto L_0x01a7;
                case 7: goto L_0x0183;
                case 8: goto L_0x015c;
                case 9: goto L_0x0130;
                case 10: goto L_0x010b;
                case 11: goto L_0x01ed;
                case 12: goto L_0x00f3;
                case 13: goto L_0x01a7;
                case 14: goto L_0x01c8;
                case 15: goto L_0x00da;
                case 16: goto L_0x00a5;
                default: goto L_0x009b;
            }
        L_0x009b:
            r23 = r31
            r15 = r32
            r13 = r2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0282
        L_0x00a5:
            if (r11 != 0) goto L_0x00d0
            r7 = r17
            int r0 = a.c.a.f.b.r1(r7, r0, r5)
            r9 = r0
            long r0 = r5.f1982b
            long r16 = a.d.a.a.h.g.g5.a(r0)
            r1 = r12
            r13 = r2
            r2 = r29
            r23 = r31
            r11 = r3
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r14
            r14 = r5
            r15 = r18
            r5 = r16
            r1.putLong(r2, r3, r5)
            r0 = r10 | r21
            r10 = r0
            r0 = r9
            r5 = r11
            r6 = r14
            r3 = r15
            goto L_0x0126
        L_0x00d0:
            r23 = r31
            r13 = r2
            r24 = 1048575(0xfffff, float:1.469367E-39)
        L_0x00d6:
            r15 = r32
            goto L_0x0282
        L_0x00da:
            r23 = r31
            r13 = r2
            r6 = r5
            r7 = r17
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r18
            if (r11 != 0) goto L_0x00d6
            int r0 = a.c.a.f.b.U0(r7, r0, r6)
            int r1 = r6.f1981a
            int r1 = a.d.a.a.h.g.g5.b(r1)
            goto L_0x0107
        L_0x00f3:
            r23 = r31
            r13 = r2
            r6 = r5
            r7 = r17
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r18
            if (r11 != 0) goto L_0x00d6
            int r0 = a.c.a.f.b.U0(r7, r0, r6)
            int r1 = r6.f1981a
        L_0x0107:
            r12.putInt(r5, r14, r1)
            goto L_0x0123
        L_0x010b:
            r23 = r31
            r13 = r2
            r6 = r5
            r7 = r17
            r1 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r18
            if (r11 != r1) goto L_0x00d6
            int r0 = a.c.a.f.b.A1(r7, r0, r6)
            java.lang.Object r1 = r6.f1983c
            r12.putObject(r5, r14, r1)
        L_0x0123:
            r1 = r10 | r21
            r10 = r1
        L_0x0126:
            r15 = r32
            r14 = r3
            r9 = r5
            r17 = r6
            r18 = r13
            goto L_0x02d8
        L_0x0130:
            r23 = r31
            r13 = r2
            r6 = r5
            r7 = r17
            r1 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r18
            if (r11 != r1) goto L_0x00d6
            a.d.a.a.h.g.v7 r1 = r3.o(r13)
            r18 = r3
            r3 = r14
            r15 = r32
            int r0 = a.c.a.f.b.S0(r1, r7, r0, r15, r6)
            java.lang.Object r1 = r12.getObject(r5, r3)
            if (r1 != 0) goto L_0x0155
        L_0x0152:
            java.lang.Object r1 = r6.f1983c
            goto L_0x017b
        L_0x0155:
            java.lang.Object r2 = r6.f1983c
            java.lang.Object r1 = a.d.a.a.h.g.a6.e(r1, r2)
            goto L_0x017b
        L_0x015c:
            r23 = r31
            r13 = r2
            r6 = r5
            r7 = r17
            r1 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r14
            r15 = r32
            if (r11 != r1) goto L_0x0282
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r1 & r9
            if (r1 != 0) goto L_0x0176
            int r0 = a.c.a.f.b.x1(r7, r0, r6)
            goto L_0x0152
        L_0x0176:
            int r0 = a.c.a.f.b.z1(r7, r0, r6)
            goto L_0x0152
        L_0x017b:
            r12.putObject(r5, r3, r1)
            r9 = r6
            r14 = r18
            goto L_0x0207
        L_0x0183:
            r23 = r31
            r13 = r2
            r6 = r5
            r7 = r17
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r14
            r15 = r32
            if (r11 != 0) goto L_0x0282
            int r0 = a.c.a.f.b.r1(r7, r0, r6)
            long r1 = r6.f1982b
            r16 = 0
            int r9 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r9 == 0) goto L_0x01a0
            r1 = 1
            goto L_0x01a1
        L_0x01a0:
            r1 = 0
        L_0x01a1:
            a.d.a.a.h.g.n8$d r2 = a.d.a.a.h.g.n8.f
            r2.g(r5, r3, r1)
            goto L_0x01bf
        L_0x01a7:
            r23 = r31
            r13 = r2
            r6 = r5
            r7 = r17
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r14
            r15 = r32
            if (r11 != r1) goto L_0x0282
            int r1 = a.c.a.f.b.T0(r7, r0)
            r12.putInt(r5, r3, r1)
            int r0 = r0 + 4
        L_0x01bf:
            r10 = r10 | r21
            r3 = r5
            r5 = r6
            r2 = r13
            r6 = r18
            goto L_0x02de
        L_0x01c8:
            r23 = r31
            r13 = r2
            r6 = r5
            r7 = r17
            r1 = 1
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r14
            r15 = r32
            if (r11 != r1) goto L_0x0282
            long r16 = a.c.a.f.b.s1(r7, r0)
            r1 = r12
            r2 = r29
            r14 = r18
            r11 = r5
            r9 = r6
            r5 = r16
            r1.putLong(r2, r3, r5)
            int r0 = r0 + 8
            r6 = r11
            goto L_0x024b
        L_0x01ed:
            r23 = r31
            r13 = r2
            r9 = r5
            r7 = r17
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r14
            r14 = r18
            r15 = r32
            if (r11 != 0) goto L_0x0282
            int r0 = a.c.a.f.b.U0(r7, r0, r9)
            int r1 = r9.f1981a
            r12.putInt(r5, r3, r1)
        L_0x0207:
            r6 = r5
            goto L_0x024b
        L_0x0209:
            r23 = r31
            r13 = r2
            r9 = r5
            r7 = r17
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3
            r3 = r14
            r14 = r18
            r15 = r32
            if (r11 != 0) goto L_0x0282
            int r0 = a.c.a.f.b.r1(r7, r0, r9)
            long r1 = r9.f1982b
            r16 = r1
            r1 = r12
            r2 = r29
            r11 = r5
            r5 = r16
            r1.putLong(r2, r3, r5)
            r1 = r10 | r21
            r6 = r11
            goto L_0x024d
        L_0x022f:
            r23 = r31
            r13 = r2
            r6 = r3
            r9 = r5
            r3 = r14
            r7 = r17
            r14 = r18
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r32
            if (r11 != r1) goto L_0x0282
            float r1 = a.c.a.f.b.y1(r7, r0)
            a.d.a.a.h.g.n8$d r2 = a.d.a.a.h.g.n8.f
            r2.d(r6, r3, r1)
            int r0 = r0 + 4
        L_0x024b:
            r1 = r10 | r21
        L_0x024d:
            r10 = r1
            r3 = r6
            r5 = r9
            r27 = r12
            r2 = r13
            r6 = r14
            r17 = 0
            r20 = -1
            goto L_0x039d
        L_0x025a:
            r23 = r31
            r13 = r2
            r6 = r3
            r9 = r5
            r3 = r14
            r7 = r17
            r14 = r18
            r1 = 1
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r32
            if (r11 != r1) goto L_0x0282
            double r1 = a.c.a.f.b.w1(r7, r0)
            a.d.a.a.h.g.n8.d(r6, r3, r1)
            int r0 = r0 + 8
            r1 = r10 | r21
            r3 = r6
            r5 = r9
            r27 = r12
            r2 = r13
            r17 = 0
            r20 = -1
            goto L_0x039b
        L_0x0282:
            r2 = r13
        L_0x0283:
            r18 = r2
            r27 = r12
            r17 = 0
            r20 = -1
            r2 = r0
            goto L_0x0379
        L_0x028e:
            r23 = r31
            r6 = r3
            r17 = r5
            r3 = r14
            r14 = r18
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r32
            r5 = r2
            r1 = 27
            if (r13 != r1) goto L_0x02f4
            r1 = 2
            if (r11 != r1) goto L_0x02e6
            java.lang.Object r1 = r12.getObject(r6, r3)
            a.d.a.a.h.g.f6 r1 = (a.d.a.a.h.g.f6) r1
            boolean r2 = r1.a()
            if (r2 != 0) goto L_0x02c1
            int r2 = r1.size()
            if (r2 != 0) goto L_0x02b8
            r2 = 10
            goto L_0x02ba
        L_0x02b8:
            int r2 = r2 << 1
        L_0x02ba:
            a.d.a.a.h.g.f6 r1 = r1.f(r2)
            r12.putObject(r6, r3, r1)
        L_0x02c1:
            r9 = r1
            a.d.a.a.h.g.v7 r1 = r14.o(r5)
            r3 = r0
            r0 = r1
            r1 = r16
            r2 = r30
            r4 = r32
            r18 = r5
            r5 = r9
            r9 = r6
            r6 = r33
            int r0 = a.c.a.f.b.Q0(r0, r1, r2, r3, r4, r5, r6)
        L_0x02d8:
            r3 = r9
            r6 = r14
            r5 = r17
            r2 = r18
        L_0x02de:
            r1 = r23
            r9 = 0
            r13 = -1
            r14 = r28
            goto L_0x001b
        L_0x02e6:
            r18 = r5
            r15 = r0
            r24 = r8
            r19 = r10
            r27 = r12
            r17 = 0
            r20 = -1
            goto L_0x0342
        L_0x02f4:
            r14 = r0
            r18 = r5
            r0 = 49
            if (r13 > r0) goto L_0x032e
            long r6 = (long) r9
            r0 = r28
            r1 = r29
            r2 = r30
            r21 = r3
            r3 = r14
            r4 = r32
            r5 = r16
            r25 = r6
            r6 = r23
            r7 = r11
            r11 = r8
            r8 = r18
            r15 = r10
            r17 = 0
            r9 = r25
            r24 = r11
            r19 = r15
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r13
            r27 = r12
            r20 = -1
            r12 = r21
            r15 = r14
            r14 = r33
            int r0 = r0.k(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x038c
            goto L_0x0374
        L_0x032e:
            r21 = r3
            r24 = r8
            r19 = r10
            r27 = r12
            r15 = r14
            r17 = 0
            r20 = -1
            r0 = 50
            if (r13 != r0) goto L_0x0358
            r0 = 2
            if (r11 == r0) goto L_0x0344
        L_0x0342:
            r0 = r15
            goto L_0x0374
        L_0x0344:
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r18
            r6 = r21
            r8 = r33
            r0.l(r1, r2, r3, r4, r5, r6, r8)
            r0 = 0
            throw r0
        L_0x0358:
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r16
            r6 = r23
            r7 = r11
            r8 = r9
            r9 = r13
            r10 = r21
            r12 = r18
            r13 = r33
            int r0 = r0.j(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x038c
        L_0x0374:
            r2 = r0
            r10 = r19
            r8 = r24
        L_0x0379:
            a.d.a.a.h.g.k8 r4 = M(r29)
            r0 = r16
            r1 = r30
            r3 = r32
            r5 = r33
            int r0 = a.c.a.f.b.N0(r0, r1, r2, r3, r4, r5)
            r2 = r18
            goto L_0x0392
        L_0x038c:
            r2 = r18
            r10 = r19
            r8 = r24
        L_0x0392:
            r14 = r28
            r3 = r29
            r7 = r30
            r5 = r33
            r1 = r10
        L_0x039b:
            r10 = r1
            r6 = r14
        L_0x039d:
            r14 = r28
            r15 = r32
            r1 = r23
            r12 = r27
            r9 = 0
            r13 = -1
            goto L_0x001b
        L_0x03a9:
            r19 = r10
            r27 = r12
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r8 == r1) goto L_0x03bc
            long r1 = (long) r8
            r3 = r29
            r10 = r19
            r4 = r27
            r4.putInt(r3, r1, r10)
        L_0x03bc:
            r4 = r32
            if (r0 != r4) goto L_0x03c1
            return
        L_0x03c1:
            a.d.a.a.h.g.i6 r0 = a.d.a.a.h.g.i6.e()
            throw r0
        L_0x03c6:
            r3 = r29
            r4 = r15
            r5 = 0
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
            r6 = r33
            r0.m(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.g(java.lang.Object, byte[], int, int, a.d.a.a.h.g.v4):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x032a, code lost:
        r0.j(r8, a.d.a.a.h.g.n8.r(r13, (long) (r6 & 1048575)), o(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0345, code lost:
        r0.o(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0356, code lost:
        r0.p(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0367, code lost:
        r0.i(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0378, code lost:
        r0.c(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0389, code lost:
        r0.f1770a.p(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x039c, code lost:
        r0.n(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x03a7, code lost:
        r0.e(r8, (a.d.a.a.h.g.w4) a.d.a.a.h.g.n8.r(r13, (long) (r6 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03ba, code lost:
        r0.g(r8, a.d.a.a.h.g.n8.r(r13, (long) (r6 & 1048575)), o(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x03cf, code lost:
        r(r8, a.d.a.a.h.g.n8.r(r13, (long) (r6 & 1048575)), r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x03e6, code lost:
        r0.h(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03f7, code lost:
        r0.l(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0407, code lost:
        r0.m(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0417, code lost:
        r0.f1770a.p(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0429, code lost:
        r0.k(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0439, code lost:
        r0.d(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0449, code lost:
        r0.b(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0459, code lost:
        r0.a(r8, r6);
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x046e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(T r13, a.d.a.a.h.g.d9 r14) {
        /*
            r12 = this;
            r0 = r14
            a.d.a.a.h.g.k5 r0 = (a.d.a.a.h.g.k5) r0
            r1 = 0
            if (r0 == 0) goto L_0x0478
            boolean r2 = r12.g
            if (r2 == 0) goto L_0x0474
            boolean r2 = r12.f
            if (r2 == 0) goto L_0x002d
            a.d.a.a.h.g.n5<?> r2 = r12.n
            a.d.a.a.h.g.p5 r2 = (a.d.a.a.h.g.p5) r2
            if (r2 == 0) goto L_0x002c
            r2 = r13
            a.d.a.a.h.g.y5$d r2 = (a.d.a.a.h.g.y5.d) r2
            a.d.a.a.h.g.r5<a.d.a.a.h.g.y5$c> r2 = r2.zzc
            a.d.a.a.h.g.z7<T, java.lang.Object> r3 = r2.f1917a
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x002d
            java.util.Iterator r2 = r2.k()
            java.lang.Object r2 = r2.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002e
        L_0x002c:
            throw r1
        L_0x002d:
            r2 = r1
        L_0x002e:
            int[] r3 = r12.f1776a
            int r3 = r3.length
            r4 = 0
            r5 = 0
        L_0x0033:
            if (r5 >= r3) goto L_0x0466
            int r6 = r12.I(r5)
            int[] r7 = r12.f1776a
            r8 = r7[r5]
            if (r2 != 0) goto L_0x0460
            r9 = 267386880(0xff00000, float:2.3665827E-29)
            r9 = r9 & r6
            int r9 = r9 >>> 20
            r10 = 1
            r11 = 1048575(0xfffff, float:1.469367E-39)
            switch(r9) {
                case 0: goto L_0x044d;
                case 1: goto L_0x043d;
                case 2: goto L_0x042d;
                case 3: goto L_0x041d;
                case 4: goto L_0x040b;
                case 5: goto L_0x03fb;
                case 6: goto L_0x03eb;
                case 7: goto L_0x03da;
                case 8: goto L_0x03c9;
                case 9: goto L_0x03b4;
                case 10: goto L_0x03a1;
                case 11: goto L_0x0390;
                case 12: goto L_0x037d;
                case 13: goto L_0x036c;
                case 14: goto L_0x035b;
                case 15: goto L_0x034a;
                case 16: goto L_0x0339;
                case 17: goto L_0x0324;
                case 18: goto L_0x0315;
                case 19: goto L_0x0306;
                case 20: goto L_0x02f7;
                case 21: goto L_0x02e8;
                case 22: goto L_0x02d9;
                case 23: goto L_0x02ca;
                case 24: goto L_0x02bb;
                case 25: goto L_0x02ac;
                case 26: goto L_0x029d;
                case 27: goto L_0x028a;
                case 28: goto L_0x027b;
                case 29: goto L_0x026c;
                case 30: goto L_0x025d;
                case 31: goto L_0x024e;
                case 32: goto L_0x023f;
                case 33: goto L_0x0230;
                case 34: goto L_0x0221;
                case 35: goto L_0x0212;
                case 36: goto L_0x0203;
                case 37: goto L_0x01f4;
                case 38: goto L_0x01e5;
                case 39: goto L_0x01d6;
                case 40: goto L_0x01c7;
                case 41: goto L_0x01b8;
                case 42: goto L_0x01a9;
                case 43: goto L_0x019a;
                case 44: goto L_0x018b;
                case 45: goto L_0x017c;
                case 46: goto L_0x016d;
                case 47: goto L_0x015e;
                case 48: goto L_0x014f;
                case 49: goto L_0x013c;
                case 50: goto L_0x0131;
                case 51: goto L_0x0123;
                case 52: goto L_0x0115;
                case 53: goto L_0x0107;
                case 54: goto L_0x00f9;
                case 55: goto L_0x00eb;
                case 56: goto L_0x00dd;
                case 57: goto L_0x00cf;
                case 58: goto L_0x00c1;
                case 59: goto L_0x00b9;
                case 60: goto L_0x00b1;
                case 61: goto L_0x00a9;
                case 62: goto L_0x009b;
                case 63: goto L_0x008d;
                case 64: goto L_0x007f;
                case 65: goto L_0x0071;
                case 66: goto L_0x0063;
                case 67: goto L_0x0055;
                case 68: goto L_0x004d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x045c
        L_0x004d:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            goto L_0x032a
        L_0x0055:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = L(r13, r6)
            goto L_0x0345
        L_0x0063:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = J(r13, r6)
            goto L_0x0356
        L_0x0071:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = L(r13, r6)
            goto L_0x0367
        L_0x007f:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = J(r13, r6)
            goto L_0x0378
        L_0x008d:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = J(r13, r6)
            goto L_0x0389
        L_0x009b:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = J(r13, r6)
            goto L_0x039c
        L_0x00a9:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            goto L_0x03a7
        L_0x00b1:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            goto L_0x03ba
        L_0x00b9:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            goto L_0x03cf
        L_0x00c1:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            boolean r6 = N(r13, r6)
            goto L_0x03e6
        L_0x00cf:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = J(r13, r6)
            goto L_0x03f7
        L_0x00dd:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = L(r13, r6)
            goto L_0x0407
        L_0x00eb:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = J(r13, r6)
            goto L_0x0417
        L_0x00f9:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = L(r13, r6)
            goto L_0x0429
        L_0x0107:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = L(r13, r6)
            goto L_0x0439
        L_0x0115:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            float r6 = F(r13, r6)
            goto L_0x0449
        L_0x0123:
            boolean r7 = r12.w(r13, r8, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            double r6 = y(r13, r6)
            goto L_0x0459
        L_0x0131:
            r6 = r6 & r11
            long r6 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r6)
            r12.t(r14, r8, r6, r5)
            goto L_0x045c
        L_0x013c:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.v7 r8 = r12.o(r5)
            a.d.a.a.h.g.w7.u(r7, r6, r14, r8)
            goto L_0x045c
        L_0x014f:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.F(r7, r6, r14, r10)
            goto L_0x045c
        L_0x015e:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.U(r7, r6, r14, r10)
            goto L_0x045c
        L_0x016d:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.L(r7, r6, r14, r10)
            goto L_0x045c
        L_0x017c:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.W(r7, r6, r14, r10)
            goto L_0x045c
        L_0x018b:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.X(r7, r6, r14, r10)
            goto L_0x045c
        L_0x019a:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.R(r7, r6, r14, r10)
            goto L_0x045c
        L_0x01a9:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.Y(r7, r6, r14, r10)
            goto L_0x045c
        L_0x01b8:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.V(r7, r6, r14, r10)
            goto L_0x045c
        L_0x01c7:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.I(r7, r6, r14, r10)
            goto L_0x045c
        L_0x01d6:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.O(r7, r6, r14, r10)
            goto L_0x045c
        L_0x01e5:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.C(r7, r6, r14, r10)
            goto L_0x045c
        L_0x01f4:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.z(r7, r6, r14, r10)
            goto L_0x045c
        L_0x0203:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.v(r7, r6, r14, r10)
            goto L_0x045c
        L_0x0212:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.j(r7, r6, r14, r10)
            goto L_0x045c
        L_0x0221:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.F(r7, r6, r14, r4)
            goto L_0x045c
        L_0x0230:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.U(r7, r6, r14, r4)
            goto L_0x045c
        L_0x023f:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.L(r7, r6, r14, r4)
            goto L_0x045c
        L_0x024e:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.W(r7, r6, r14, r4)
            goto L_0x045c
        L_0x025d:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.X(r7, r6, r14, r4)
            goto L_0x045c
        L_0x026c:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.R(r7, r6, r14, r4)
            goto L_0x045c
        L_0x027b:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.t(r7, r6, r14)
            goto L_0x045c
        L_0x028a:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.v7 r8 = r12.o(r5)
            a.d.a.a.h.g.w7.i(r7, r6, r14, r8)
            goto L_0x045c
        L_0x029d:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.h(r7, r6, r14)
            goto L_0x045c
        L_0x02ac:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.Y(r7, r6, r14, r4)
            goto L_0x045c
        L_0x02bb:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.V(r7, r6, r14, r4)
            goto L_0x045c
        L_0x02ca:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.I(r7, r6, r14, r4)
            goto L_0x045c
        L_0x02d9:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.O(r7, r6, r14, r4)
            goto L_0x045c
        L_0x02e8:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.C(r7, r6, r14, r4)
            goto L_0x045c
        L_0x02f7:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.z(r7, r6, r14, r4)
            goto L_0x045c
        L_0x0306:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.v(r7, r6, r14, r4)
            goto L_0x045c
        L_0x0315:
            r7 = r7[r5]
            r6 = r6 & r11
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r8)
            java.util.List r6 = (java.util.List) r6
            a.d.a.a.h.g.w7.j(r7, r6, r14, r4)
            goto L_0x045c
        L_0x0324:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
        L_0x032a:
            r6 = r6 & r11
            long r6 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r6)
            a.d.a.a.h.g.v7 r7 = r12.o(r5)
            r0.j(r8, r6, r7)
            goto L_0x045c
        L_0x0339:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = a.d.a.a.h.g.n8.i(r13, r6)
        L_0x0345:
            r0.o(r8, r6)
            goto L_0x045c
        L_0x034a:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = a.d.a.a.h.g.n8.b(r13, r6)
        L_0x0356:
            r0.p(r8, r6)
            goto L_0x045c
        L_0x035b:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = a.d.a.a.h.g.n8.i(r13, r6)
        L_0x0367:
            r0.i(r8, r6)
            goto L_0x045c
        L_0x036c:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = a.d.a.a.h.g.n8.b(r13, r6)
        L_0x0378:
            r0.c(r8, r6)
            goto L_0x045c
        L_0x037d:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = a.d.a.a.h.g.n8.b(r13, r6)
        L_0x0389:
            a.d.a.a.h.g.i5 r7 = r0.f1770a
            r7.p(r8, r6)
            goto L_0x045c
        L_0x0390:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = a.d.a.a.h.g.n8.b(r13, r6)
        L_0x039c:
            r0.n(r8, r6)
            goto L_0x045c
        L_0x03a1:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
        L_0x03a7:
            r6 = r6 & r11
            long r6 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r6)
            a.d.a.a.h.g.w4 r6 = (a.d.a.a.h.g.w4) r6
            r0.e(r8, r6)
            goto L_0x045c
        L_0x03b4:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
        L_0x03ba:
            r6 = r6 & r11
            long r6 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r6)
            a.d.a.a.h.g.v7 r7 = r12.o(r5)
            r0.g(r8, r6, r7)
            goto L_0x045c
        L_0x03c9:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
        L_0x03cf:
            r6 = r6 & r11
            long r6 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r13, r6)
            r(r8, r6, r14)
            goto L_0x045c
        L_0x03da:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            boolean r6 = a.d.a.a.h.g.n8.m(r13, r6)
        L_0x03e6:
            r0.h(r8, r6)
            goto L_0x045c
        L_0x03eb:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = a.d.a.a.h.g.n8.b(r13, r6)
        L_0x03f7:
            r0.l(r8, r6)
            goto L_0x045c
        L_0x03fb:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = a.d.a.a.h.g.n8.i(r13, r6)
        L_0x0407:
            r0.m(r8, r6)
            goto L_0x045c
        L_0x040b:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            int r6 = a.d.a.a.h.g.n8.b(r13, r6)
        L_0x0417:
            a.d.a.a.h.g.i5 r7 = r0.f1770a
            r7.p(r8, r6)
            goto L_0x045c
        L_0x041d:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = a.d.a.a.h.g.n8.i(r13, r6)
        L_0x0429:
            r0.k(r8, r6)
            goto L_0x045c
        L_0x042d:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            long r6 = a.d.a.a.h.g.n8.i(r13, r6)
        L_0x0439:
            r0.d(r8, r6)
            goto L_0x045c
        L_0x043d:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            float r6 = a.d.a.a.h.g.n8.n(r13, r6)
        L_0x0449:
            r0.b(r8, r6)
            goto L_0x045c
        L_0x044d:
            boolean r7 = r12.v(r13, r5)
            if (r7 == 0) goto L_0x045c
            r6 = r6 & r11
            long r6 = (long) r6
            double r6 = a.d.a.a.h.g.n8.q(r13, r6)
        L_0x0459:
            r0.a(r8, r6)
        L_0x045c:
            int r5 = r5 + 3
            goto L_0x0033
        L_0x0460:
            a.d.a.a.h.g.n5<?> r13 = r12.n
            r13.a(r2)
            throw r1
        L_0x0466:
            if (r2 != 0) goto L_0x046e
            a.d.a.a.h.g.h8<?, ?> r0 = r12.m
            s(r0, r13, r14)
            return
        L_0x046e:
            a.d.a.a.h.g.n5<?> r13 = r12.n
            r13.b(r14, r2)
            throw r1
        L_0x0474:
            r12.D(r13, r14)
            return
        L_0x0478:
            goto L_0x047a
        L_0x0479:
            throw r1
        L_0x047a:
            goto L_0x0479
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.h(java.lang.Object, a.d.a.a.h.g.d9):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        a.d.a.a.h.g.n8.f(r7, r2, a.d.a.a.h.g.n8.r(r8, r2));
        C(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        a.d.a.a.h.g.n8.f(r7, r2, a.d.a.a.h.g.n8.r(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b9, code lost:
        r1 = a.d.a.a.h.g.n8.b(r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bd, code lost:
        a.d.a.a.h.g.n8.f.e(r7, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d0, code lost:
        a.d.a.a.h.g.n8.e(r7, r2, a.d.a.a.h.g.n8.i(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f5, code lost:
        B(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f8, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(T r7, T r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x010b
            r0 = 0
        L_0x0003:
            int[] r1 = r6.f1776a
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00fc
            int r1 = r6.I(r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.f1776a
            r4 = r4[r0]
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r1 = r1 & r5
            int r1 = r1 >>> 20
            switch(r1) {
                case 0: goto L_0x00e8;
                case 1: goto L_0x00d8;
                case 2: goto L_0x00ca;
                case 3: goto L_0x00c3;
                case 4: goto L_0x00b3;
                case 5: goto L_0x00ac;
                case 6: goto L_0x00a5;
                case 7: goto L_0x0095;
                case 8: goto L_0x0087;
                case 9: goto L_0x0082;
                case 10: goto L_0x007b;
                case 11: goto L_0x0074;
                case 12: goto L_0x006d;
                case 13: goto L_0x0066;
                case 14: goto L_0x005e;
                case 15: goto L_0x0053;
                case 16: goto L_0x004b;
                case 17: goto L_0x0082;
                case 18: goto L_0x0044;
                case 19: goto L_0x0044;
                case 20: goto L_0x0044;
                case 21: goto L_0x0044;
                case 22: goto L_0x0044;
                case 23: goto L_0x0044;
                case 24: goto L_0x0044;
                case 25: goto L_0x0044;
                case 26: goto L_0x0044;
                case 27: goto L_0x0044;
                case 28: goto L_0x0044;
                case 29: goto L_0x0044;
                case 30: goto L_0x0044;
                case 31: goto L_0x0044;
                case 32: goto L_0x0044;
                case 33: goto L_0x0044;
                case 34: goto L_0x0044;
                case 35: goto L_0x0044;
                case 36: goto L_0x0044;
                case 37: goto L_0x0044;
                case 38: goto L_0x0044;
                case 39: goto L_0x0044;
                case 40: goto L_0x0044;
                case 41: goto L_0x0044;
                case 42: goto L_0x0044;
                case 43: goto L_0x0044;
                case 44: goto L_0x0044;
                case 45: goto L_0x0044;
                case 46: goto L_0x0044;
                case 47: goto L_0x0044;
                case 48: goto L_0x0044;
                case 49: goto L_0x0044;
                case 50: goto L_0x003d;
                case 51: goto L_0x002b;
                case 52: goto L_0x002b;
                case 53: goto L_0x002b;
                case 54: goto L_0x002b;
                case 55: goto L_0x002b;
                case 56: goto L_0x002b;
                case 57: goto L_0x002b;
                case 58: goto L_0x002b;
                case 59: goto L_0x002b;
                case 60: goto L_0x0026;
                case 61: goto L_0x001f;
                case 62: goto L_0x001f;
                case 63: goto L_0x001f;
                case 64: goto L_0x001f;
                case 65: goto L_0x001f;
                case 66: goto L_0x001f;
                case 67: goto L_0x001f;
                case 68: goto L_0x0026;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00f8
        L_0x001f:
            boolean r1 = r6.w(r8, r4, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x0031
        L_0x0026:
            r6.E(r7, r8, r0)
            goto L_0x00f8
        L_0x002b:
            boolean r1 = r6.w(r8, r4, r0)
            if (r1 == 0) goto L_0x00f8
        L_0x0031:
            java.lang.Object r1 = a.d.a.a.h.g.n8.r(r8, r2)
            a.d.a.a.h.g.n8.f(r7, r2, r1)
            r6.C(r7, r4, r0)
            goto L_0x00f8
        L_0x003d:
            a.d.a.a.h.g.b7 r1 = r6.o
            a.d.a.a.h.g.w7.l(r1, r7, r8, r2)
            goto L_0x00f8
        L_0x0044:
            a.d.a.a.h.g.s6 r1 = r6.l
            r1.a(r7, r8, r2)
            goto L_0x00f8
        L_0x004b:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x00d0
        L_0x0053:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            int r1 = a.d.a.a.h.g.n8.b(r8, r2)
            goto L_0x00bd
        L_0x005e:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x00d0
        L_0x0066:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x00b9
        L_0x006d:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x00b9
        L_0x0074:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x00b9
        L_0x007b:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x008d
        L_0x0082:
            r6.u(r7, r8, r0)
            goto L_0x00f8
        L_0x0087:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
        L_0x008d:
            java.lang.Object r1 = a.d.a.a.h.g.n8.r(r8, r2)
            a.d.a.a.h.g.n8.f(r7, r2, r1)
            goto L_0x00f5
        L_0x0095:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            boolean r1 = a.d.a.a.h.g.n8.m(r8, r2)
            a.d.a.a.h.g.n8$d r4 = a.d.a.a.h.g.n8.f
            r4.g(r7, r2, r1)
            goto L_0x00f5
        L_0x00a5:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x00b9
        L_0x00ac:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x00d0
        L_0x00b3:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
        L_0x00b9:
            int r1 = a.d.a.a.h.g.n8.b(r8, r2)
        L_0x00bd:
            a.d.a.a.h.g.n8$d r4 = a.d.a.a.h.g.n8.f
            r4.e(r7, r2, r1)
            goto L_0x00f5
        L_0x00c3:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            goto L_0x00d0
        L_0x00ca:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
        L_0x00d0:
            long r4 = a.d.a.a.h.g.n8.i(r8, r2)
            a.d.a.a.h.g.n8.e(r7, r2, r4)
            goto L_0x00f5
        L_0x00d8:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            float r1 = a.d.a.a.h.g.n8.n(r8, r2)
            a.d.a.a.h.g.n8$d r4 = a.d.a.a.h.g.n8.f
            r4.d(r7, r2, r1)
            goto L_0x00f5
        L_0x00e8:
            boolean r1 = r6.v(r8, r0)
            if (r1 == 0) goto L_0x00f8
            double r4 = a.d.a.a.h.g.n8.q(r8, r2)
            a.d.a.a.h.g.n8.d(r7, r2, r4)
        L_0x00f5:
            r6.B(r7, r0)
        L_0x00f8:
            int r0 = r0 + 3
            goto L_0x0003
        L_0x00fc:
            a.d.a.a.h.g.h8<?, ?> r0 = r6.m
            a.d.a.a.h.g.w7.m(r0, r7, r8)
            boolean r0 = r6.f
            if (r0 == 0) goto L_0x010a
            a.d.a.a.h.g.n5<?> r0 = r6.n
            a.d.a.a.h.g.w7.k(r0, r7, r8)
        L_0x010a:
            return
        L_0x010b:
            r7 = 0
            goto L_0x010e
        L_0x010d:
            throw r7
        L_0x010e:
            goto L_0x010d
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.i(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0139, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0146, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014a, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0159, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0169, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016e, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int j(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, a.d.a.a.h.g.v4 r29) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = q
            int[] r7 = r0.f1776a
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 3
            r15 = 1
            switch(r25) {
                case 51: goto L_0x015f;
                case 52: goto L_0x014e;
                case 53: goto L_0x013e;
                case 54: goto L_0x013e;
                case 55: goto L_0x0131;
                case 56: goto L_0x0126;
                case 57: goto L_0x011a;
                case 58: goto L_0x0105;
                case 59: goto L_0x00d6;
                case 60: goto L_0x00b1;
                case 61: goto L_0x00a6;
                case 62: goto L_0x0131;
                case 63: goto L_0x0073;
                case 64: goto L_0x011a;
                case 65: goto L_0x0126;
                case 66: goto L_0x0065;
                case 67: goto L_0x0057;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0172
        L_0x0028:
            if (r5 != r7) goto L_0x0172
            r2 = r2 & -8
            r7 = r2 | 4
            a.d.a.a.h.g.v7 r2 = r0.o(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = a.c.a.f.b.R0(r2, r3, r4, r5, r6, r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004a
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004b
        L_0x004a:
            r15 = 0
        L_0x004b:
            java.lang.Object r3 = r11.f1983c
            if (r15 != 0) goto L_0x0051
            goto L_0x014a
        L_0x0051:
            java.lang.Object r3 = a.d.a.a.h.g.a6.e(r15, r3)
            goto L_0x014a
        L_0x0057:
            if (r5 != 0) goto L_0x0172
            int r2 = a.c.a.f.b.r1(r3, r4, r11)
            long r3 = r11.f1982b
            long r3 = a.d.a.a.h.g.g5.a(r3)
            goto L_0x0146
        L_0x0065:
            if (r5 != 0) goto L_0x0172
            int r2 = a.c.a.f.b.U0(r3, r4, r11)
            int r3 = r11.f1981a
            int r3 = a.d.a.a.h.g.g5.b(r3)
            goto L_0x0139
        L_0x0073:
            if (r5 != 0) goto L_0x0172
            int r3 = a.c.a.f.b.U0(r3, r4, r11)
            int r4 = r11.f1981a
            java.lang.Object[] r5 = r0.f1777b
            int r6 = r6 / r7
            int r6 = r6 << r15
            int r6 = r6 + r15
            r5 = r5[r6]
            a.d.a.a.h.g.e6 r5 = (a.d.a.a.h.g.e6) r5
            if (r5 == 0) goto L_0x009c
            boolean r5 = r5.f(r4)
            if (r5 == 0) goto L_0x008d
            goto L_0x009c
        L_0x008d:
            a.d.a.a.h.g.k8 r1 = M(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.a(r2, r4)
            r2 = r3
            goto L_0x0173
        L_0x009c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x016e
        L_0x00a6:
            r2 = 2
            if (r5 != r2) goto L_0x0172
            int r2 = a.c.a.f.b.A1(r3, r4, r11)
            java.lang.Object r3 = r11.f1983c
            goto L_0x014a
        L_0x00b1:
            r2 = 2
            if (r5 != r2) goto L_0x0172
            a.d.a.a.h.g.v7 r2 = r0.o(r6)
            r5 = r20
            int r2 = a.c.a.f.b.S0(r2, r3, r4, r5, r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00c9
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00ca
        L_0x00c9:
            r15 = 0
        L_0x00ca:
            java.lang.Object r3 = r11.f1983c
            if (r15 != 0) goto L_0x00d0
            goto L_0x014a
        L_0x00d0:
            java.lang.Object r3 = a.d.a.a.h.g.a6.e(r15, r3)
            goto L_0x014a
        L_0x00d6:
            r2 = 2
            if (r5 != r2) goto L_0x0172
            int r2 = a.c.a.f.b.U0(r3, r4, r11)
            int r4 = r11.f1981a
            if (r4 != 0) goto L_0x00e4
            java.lang.String r3 = ""
            goto L_0x014a
        L_0x00e4:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x00f8
            int r5 = r2 + r4
            boolean r5 = a.d.a.a.h.g.q8.d(r3, r2, r5)
            if (r5 == 0) goto L_0x00f3
            goto L_0x00f8
        L_0x00f3:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.f()
            throw r1
        L_0x00f8:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = a.d.a.a.h.g.a6.f1596a
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
            goto L_0x016e
        L_0x0105:
            if (r5 != 0) goto L_0x0172
            int r2 = a.c.a.f.b.r1(r3, r4, r11)
            long r3 = r11.f1982b
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r15 = 0
        L_0x0115:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x014a
        L_0x011a:
            r2 = 5
            if (r5 != r2) goto L_0x0172
            int r2 = a.c.a.f.b.T0(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0159
        L_0x0126:
            if (r5 != r15) goto L_0x0172
            long r2 = a.c.a.f.b.s1(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0169
        L_0x0131:
            if (r5 != 0) goto L_0x0172
            int r2 = a.c.a.f.b.U0(r3, r4, r11)
            int r3 = r11.f1981a
        L_0x0139:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x014a
        L_0x013e:
            if (r5 != 0) goto L_0x0172
            int r2 = a.c.a.f.b.r1(r3, r4, r11)
            long r3 = r11.f1982b
        L_0x0146:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x014a:
            r12.putObject(r1, r9, r3)
            goto L_0x016e
        L_0x014e:
            r2 = 5
            if (r5 != r2) goto L_0x0172
            float r2 = a.c.a.f.b.y1(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x0159:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x016e
        L_0x015f:
            if (r5 != r15) goto L_0x0172
            double r2 = a.c.a.f.b.w1(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
        L_0x0169:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x016e:
            r12.putInt(r1, r13, r8)
            goto L_0x0173
        L_0x0172:
            r2 = r4
        L_0x0173:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.j(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, a.d.a.a.h.g.v4):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0276, code lost:
        if (r7.f1982b != 0) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0279, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x027a, code lost:
        r11.d(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x027d, code lost:
        if (r4 >= r5) goto L_0x03d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x027f, code lost:
        r6 = a.c.a.f.b.U0(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0285, code lost:
        if (r2 != r7.f1981a) goto L_0x03d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0287, code lost:
        r4 = a.c.a.f.b.r1(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x028f, code lost:
        if (r7.f1982b == 0) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0291, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0144, code lost:
        if (r4 == 0) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0147, code lost:
        r11.add(a.d.a.a.h.g.w4.l(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014f, code lost:
        if (r1 >= r5) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0151, code lost:
        r4 = a.c.a.f.b.U0(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0157, code lost:
        if (r2 != r7.f1981a) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0159, code lost:
        r1 = a.c.a.f.b.U0(r3, r4, r7);
        r4 = r7.f1981a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015f, code lost:
        if (r4 < 0) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0163, code lost:
        if (r4 > (r3.length - r1)) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0165, code lost:
        if (r4 != 0) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0167, code lost:
        r11.add(a.d.a.a.h.g.w4.f2000b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0171, code lost:
        throw a.d.a.a.h.g.i6.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0176, code lost:
        throw a.d.a.a.h.g.i6.b();
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int k(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, a.d.a.a.h.g.v4 r30) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = q
            java.lang.Object r11 = r11.getObject(r1, r9)
            a.d.a.a.h.g.f6 r11 = (a.d.a.a.h.g.f6) r11
            boolean r12 = r11.a()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            a.d.a.a.h.g.f6 r11 = r11.f(r12)
            sun.misc.Unsafe r12 = q
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r10 = 2
            r14 = 0
            r12 = 3
            switch(r27) {
                case 18: goto L_0x0398;
                case 19: goto L_0x035d;
                case 20: goto L_0x0325;
                case 21: goto L_0x0325;
                case 22: goto L_0x030b;
                case 23: goto L_0x02cf;
                case 24: goto L_0x0293;
                case 25: goto L_0x0242;
                case 26: goto L_0x019b;
                case 27: goto L_0x0181;
                case 28: goto L_0x0136;
                case 29: goto L_0x030b;
                case 30: goto L_0x00fa;
                case 31: goto L_0x0293;
                case 32: goto L_0x02cf;
                case 33: goto L_0x00ba;
                case 34: goto L_0x007a;
                case 35: goto L_0x0398;
                case 36: goto L_0x035d;
                case 37: goto L_0x0325;
                case 38: goto L_0x0325;
                case 39: goto L_0x030b;
                case 40: goto L_0x02cf;
                case 41: goto L_0x0293;
                case 42: goto L_0x0242;
                case 43: goto L_0x030b;
                case 44: goto L_0x00fa;
                case 45: goto L_0x0293;
                case 46: goto L_0x02cf;
                case 47: goto L_0x00ba;
                case 48: goto L_0x007a;
                case 49: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x03d3
        L_0x0040:
            if (r6 != r12) goto L_0x03d3
            a.d.a.a.h.g.v7 r1 = r0.o(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = a.c.a.f.b.R0(r22, r23, r24, r25, r26, r27)
        L_0x005a:
            java.lang.Object r8 = r7.f1983c
            r11.add(r8)
            if (r4 >= r5) goto L_0x03d3
            int r8 = a.c.a.f.b.U0(r3, r4, r7)
            int r9 = r7.f1981a
            if (r2 != r9) goto L_0x03d3
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = a.c.a.f.b.R0(r22, r23, r24, r25, r26, r27)
            goto L_0x005a
        L_0x007a:
            if (r6 != r10) goto L_0x009e
            a.d.a.a.h.g.w6 r11 = (a.d.a.a.h.g.w6) r11
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r2 = r7.f1981a
            int r2 = r2 + r1
        L_0x0085:
            if (r1 >= r2) goto L_0x0095
            int r1 = a.c.a.f.b.r1(r3, r1, r7)
            long r4 = r7.f1982b
            long r4 = a.d.a.a.h.g.g5.a(r4)
            r11.d(r4)
            goto L_0x0085
        L_0x0095:
            if (r1 != r2) goto L_0x0099
            goto L_0x03d4
        L_0x0099:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x009e:
            if (r6 != 0) goto L_0x03d3
            a.d.a.a.h.g.w6 r11 = (a.d.a.a.h.g.w6) r11
        L_0x00a2:
            int r1 = a.c.a.f.b.r1(r3, r4, r7)
            long r8 = r7.f1982b
            long r8 = a.d.a.a.h.g.g5.a(r8)
            r11.d(r8)
            if (r1 >= r5) goto L_0x03d4
            int r4 = a.c.a.f.b.U0(r3, r1, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x03d4
            goto L_0x00a2
        L_0x00ba:
            if (r6 != r10) goto L_0x00de
            a.d.a.a.h.g.b6 r11 = (a.d.a.a.h.g.b6) r11
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r2 = r7.f1981a
            int r2 = r2 + r1
        L_0x00c5:
            if (r1 >= r2) goto L_0x00d5
            int r1 = a.c.a.f.b.U0(r3, r1, r7)
            int r4 = r7.f1981a
            int r4 = a.d.a.a.h.g.g5.b(r4)
            r11.h(r4)
            goto L_0x00c5
        L_0x00d5:
            if (r1 != r2) goto L_0x00d9
            goto L_0x03d4
        L_0x00d9:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x00de:
            if (r6 != 0) goto L_0x03d3
            a.d.a.a.h.g.b6 r11 = (a.d.a.a.h.g.b6) r11
        L_0x00e2:
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r4 = r7.f1981a
            int r4 = a.d.a.a.h.g.g5.b(r4)
            r11.h(r4)
            if (r1 >= r5) goto L_0x03d4
            int r4 = a.c.a.f.b.U0(r3, r1, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x03d4
            goto L_0x00e2
        L_0x00fa:
            if (r6 != r10) goto L_0x0101
            int r2 = a.c.a.f.b.V0(r3, r4, r11, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x03d3
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = a.c.a.f.b.M0(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1
            a.d.a.a.h.g.k8 r3 = r1.zzb
            a.d.a.a.h.g.k8 r4 = a.d.a.a.h.g.k8.f
            if (r3 != r4) goto L_0x011b
            r3 = 0
        L_0x011b:
            java.lang.Object[] r4 = r0.f1777b
            int r5 = r8 / 3
            int r5 = r5 << r13
            int r5 = r5 + r13
            r4 = r4[r5]
            a.d.a.a.h.g.e6 r4 = (a.d.a.a.h.g.e6) r4
            a.d.a.a.h.g.h8<?, ?> r5 = r0.m
            r6 = r22
            java.lang.Object r3 = a.d.a.a.h.g.w7.g(r6, r11, r4, r3, r5)
            a.d.a.a.h.g.k8 r3 = (a.d.a.a.h.g.k8) r3
            if (r3 == 0) goto L_0x0133
            r1.zzb = r3
        L_0x0133:
            r1 = r2
            goto L_0x03d4
        L_0x0136:
            if (r6 != r10) goto L_0x03d3
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r4 = r7.f1981a
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x0147
            goto L_0x0167
        L_0x0147:
            a.d.a.a.h.g.w4 r6 = a.d.a.a.h.g.w4.l(r3, r1, r4)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x014f:
            if (r1 >= r5) goto L_0x03d4
            int r4 = a.c.a.f.b.U0(r3, r1, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x03d4
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r4 = r7.f1981a
            if (r4 < 0) goto L_0x0172
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x016d
            if (r4 != 0) goto L_0x0147
        L_0x0167:
            a.d.a.a.h.g.w4 r4 = a.d.a.a.h.g.w4.f2000b
            r11.add(r4)
            goto L_0x014f
        L_0x016d:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x0172:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.b()
            throw r1
        L_0x0177:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x017c:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.b()
            throw r1
        L_0x0181:
            if (r6 != r10) goto L_0x03d3
            a.d.a.a.h.g.v7 r1 = r0.o(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = a.c.a.f.b.Q0(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x03d4
        L_0x019b:
            if (r6 != r10) goto L_0x03d3
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            int r4 = a.c.a.f.b.U0(r3, r4, r7)
            if (r6 != 0) goto L_0x01e8
            int r6 = r7.f1981a
            if (r6 < 0) goto L_0x01e3
            if (r6 != 0) goto L_0x01b3
            goto L_0x01d2
        L_0x01b3:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = a.d.a.a.h.g.a6.f1596a
            r8.<init>(r3, r4, r6, r9)
        L_0x01ba:
            r11.add(r8)
            int r4 = r4 + r6
        L_0x01be:
            if (r4 >= r5) goto L_0x03d3
            int r6 = a.c.a.f.b.U0(r3, r4, r7)
            int r8 = r7.f1981a
            if (r2 != r8) goto L_0x03d3
            int r4 = a.c.a.f.b.U0(r3, r6, r7)
            int r6 = r7.f1981a
            if (r6 < 0) goto L_0x01de
            if (r6 != 0) goto L_0x01d6
        L_0x01d2:
            r11.add(r1)
            goto L_0x01be
        L_0x01d6:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = a.d.a.a.h.g.a6.f1596a
            r8.<init>(r3, r4, r6, r9)
            goto L_0x01ba
        L_0x01de:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.b()
            throw r1
        L_0x01e3:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.b()
            throw r1
        L_0x01e8:
            int r6 = r7.f1981a
            if (r6 < 0) goto L_0x023d
            if (r6 != 0) goto L_0x01f0
        L_0x01ee:
            r8 = r4
            goto L_0x0217
        L_0x01f0:
            int r8 = r4 + r6
            boolean r9 = a.d.a.a.h.g.q8.d(r3, r4, r8)
            if (r9 == 0) goto L_0x0238
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = a.d.a.a.h.g.a6.f1596a
            r9.<init>(r3, r4, r6, r10)
        L_0x01ff:
            r11.add(r9)
        L_0x0202:
            if (r8 >= r5) goto L_0x0235
            int r4 = a.c.a.f.b.U0(r3, r8, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x0235
            int r4 = a.c.a.f.b.U0(r3, r4, r7)
            int r6 = r7.f1981a
            if (r6 < 0) goto L_0x0230
            if (r6 != 0) goto L_0x021b
            goto L_0x01ee
        L_0x0217:
            r11.add(r1)
            goto L_0x0202
        L_0x021b:
            int r8 = r4 + r6
            boolean r9 = a.d.a.a.h.g.q8.d(r3, r4, r8)
            if (r9 == 0) goto L_0x022b
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = a.d.a.a.h.g.a6.f1596a
            r9.<init>(r3, r4, r6, r10)
            goto L_0x01ff
        L_0x022b:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.f()
            throw r1
        L_0x0230:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.b()
            throw r1
        L_0x0235:
            r4 = r8
            goto L_0x03d3
        L_0x0238:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.f()
            throw r1
        L_0x023d:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.b()
            throw r1
        L_0x0242:
            r1 = 0
            if (r6 != r10) goto L_0x026a
            a.d.a.a.h.g.u4 r11 = (a.d.a.a.h.g.u4) r11
            int r2 = a.c.a.f.b.U0(r3, r4, r7)
            int r4 = r7.f1981a
            int r4 = r4 + r2
        L_0x024e:
            if (r2 >= r4) goto L_0x0261
            int r2 = a.c.a.f.b.r1(r3, r2, r7)
            long r5 = r7.f1982b
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x025c
            r5 = 1
            goto L_0x025d
        L_0x025c:
            r5 = 0
        L_0x025d:
            r11.d(r5)
            goto L_0x024e
        L_0x0261:
            if (r2 != r4) goto L_0x0265
            goto L_0x0133
        L_0x0265:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x026a:
            if (r6 != 0) goto L_0x03d3
            a.d.a.a.h.g.u4 r11 = (a.d.a.a.h.g.u4) r11
            int r4 = a.c.a.f.b.r1(r3, r4, r7)
            long r8 = r7.f1982b
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0279
            goto L_0x0291
        L_0x0279:
            r6 = 0
        L_0x027a:
            r11.d(r6)
            if (r4 >= r5) goto L_0x03d3
            int r6 = a.c.a.f.b.U0(r3, r4, r7)
            int r8 = r7.f1981a
            if (r2 != r8) goto L_0x03d3
            int r4 = a.c.a.f.b.r1(r3, r6, r7)
            long r8 = r7.f1982b
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0279
        L_0x0291:
            r6 = 1
            goto L_0x027a
        L_0x0293:
            if (r6 != r10) goto L_0x02b3
            a.d.a.a.h.g.b6 r11 = (a.d.a.a.h.g.b6) r11
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r2 = r7.f1981a
            int r2 = r2 + r1
        L_0x029e:
            if (r1 >= r2) goto L_0x02aa
            int r4 = a.c.a.f.b.T0(r3, r1)
            r11.h(r4)
            int r1 = r1 + 4
            goto L_0x029e
        L_0x02aa:
            if (r1 != r2) goto L_0x02ae
            goto L_0x03d4
        L_0x02ae:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x02b3:
            if (r6 != r9) goto L_0x03d3
            a.d.a.a.h.g.b6 r11 = (a.d.a.a.h.g.b6) r11
            int r1 = a.c.a.f.b.T0(r18, r19)
        L_0x02bb:
            r11.h(r1)
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d4
            int r4 = a.c.a.f.b.U0(r3, r1, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x03d4
            int r1 = a.c.a.f.b.T0(r3, r4)
            goto L_0x02bb
        L_0x02cf:
            if (r6 != r10) goto L_0x02ef
            a.d.a.a.h.g.w6 r11 = (a.d.a.a.h.g.w6) r11
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r2 = r7.f1981a
            int r2 = r2 + r1
        L_0x02da:
            if (r1 >= r2) goto L_0x02e6
            long r4 = a.c.a.f.b.s1(r3, r1)
            r11.d(r4)
            int r1 = r1 + 8
            goto L_0x02da
        L_0x02e6:
            if (r1 != r2) goto L_0x02ea
            goto L_0x03d4
        L_0x02ea:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x02ef:
            if (r6 != r13) goto L_0x03d3
            a.d.a.a.h.g.w6 r11 = (a.d.a.a.h.g.w6) r11
            long r8 = a.c.a.f.b.s1(r18, r19)
        L_0x02f7:
            r11.d(r8)
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03d4
            int r4 = a.c.a.f.b.U0(r3, r1, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x03d4
            long r8 = a.c.a.f.b.s1(r3, r4)
            goto L_0x02f7
        L_0x030b:
            if (r6 != r10) goto L_0x0313
            int r1 = a.c.a.f.b.V0(r3, r4, r11, r7)
            goto L_0x03d4
        L_0x0313:
            if (r6 != 0) goto L_0x03d3
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = a.c.a.f.b.M0(r21, r22, r23, r24, r25, r26)
            goto L_0x03d4
        L_0x0325:
            if (r6 != r10) goto L_0x0345
            a.d.a.a.h.g.w6 r11 = (a.d.a.a.h.g.w6) r11
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r2 = r7.f1981a
            int r2 = r2 + r1
        L_0x0330:
            if (r1 >= r2) goto L_0x033c
            int r1 = a.c.a.f.b.r1(r3, r1, r7)
            long r4 = r7.f1982b
            r11.d(r4)
            goto L_0x0330
        L_0x033c:
            if (r1 != r2) goto L_0x0340
            goto L_0x03d4
        L_0x0340:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x0345:
            if (r6 != 0) goto L_0x03d3
            a.d.a.a.h.g.w6 r11 = (a.d.a.a.h.g.w6) r11
        L_0x0349:
            int r1 = a.c.a.f.b.r1(r3, r4, r7)
            long r8 = r7.f1982b
            r11.d(r8)
            if (r1 >= r5) goto L_0x03d4
            int r4 = a.c.a.f.b.U0(r3, r1, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x03d4
            goto L_0x0349
        L_0x035d:
            if (r6 != r10) goto L_0x037c
            a.d.a.a.h.g.x5 r11 = (a.d.a.a.h.g.x5) r11
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r2 = r7.f1981a
            int r2 = r2 + r1
        L_0x0368:
            if (r1 >= r2) goto L_0x0374
            float r4 = a.c.a.f.b.y1(r3, r1)
            r11.d(r4)
            int r1 = r1 + 4
            goto L_0x0368
        L_0x0374:
            if (r1 != r2) goto L_0x0377
            goto L_0x03d4
        L_0x0377:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x037c:
            if (r6 != r9) goto L_0x03d3
            a.d.a.a.h.g.x5 r11 = (a.d.a.a.h.g.x5) r11
            float r1 = a.c.a.f.b.y1(r18, r19)
        L_0x0384:
            r11.d(r1)
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d4
            int r4 = a.c.a.f.b.U0(r3, r1, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x03d4
            float r1 = a.c.a.f.b.y1(r3, r4)
            goto L_0x0384
        L_0x0398:
            if (r6 != r10) goto L_0x03b7
            a.d.a.a.h.g.j5 r11 = (a.d.a.a.h.g.j5) r11
            int r1 = a.c.a.f.b.U0(r3, r4, r7)
            int r2 = r7.f1981a
            int r2 = r2 + r1
        L_0x03a3:
            if (r1 >= r2) goto L_0x03af
            double r4 = a.c.a.f.b.w1(r3, r1)
            r11.d(r4)
            int r1 = r1 + 8
            goto L_0x03a3
        L_0x03af:
            if (r1 != r2) goto L_0x03b2
            goto L_0x03d4
        L_0x03b2:
            a.d.a.a.h.g.i6 r1 = a.d.a.a.h.g.i6.a()
            throw r1
        L_0x03b7:
            if (r6 != r13) goto L_0x03d3
            a.d.a.a.h.g.j5 r11 = (a.d.a.a.h.g.j5) r11
            double r8 = a.c.a.f.b.w1(r18, r19)
        L_0x03bf:
            r11.d(r8)
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03d4
            int r4 = a.c.a.f.b.U0(r3, r1, r7)
            int r6 = r7.f1981a
            if (r2 != r6) goto L_0x03d4
            double r8 = a.c.a.f.b.w1(r3, r4)
            goto L_0x03bf
        L_0x03d3:
            r1 = r4
        L_0x03d4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.k(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, a.d.a.a.h.g.v4):int");
    }

    public final <K, V> int l(T t, byte[] bArr, int i2, int i3, int i4, long j2, v4 v4Var) {
        Unsafe unsafe = q;
        Object obj = this.f1777b[(i4 / 3) << 1];
        Object object = unsafe.getObject(t, j2);
        if (this.o.e(object)) {
            Object h2 = this.o.h(obj);
            this.o.d(h2, object);
            unsafe.putObject(t, j2, h2);
            object = h2;
        }
        this.o.g(obj);
        this.o.b(object);
        int U0 = b.U0(bArr, i2, v4Var);
        int i5 = v4Var.f1981a;
        if (i5 < 0 || i5 > i3 - U0) {
            throw i6.a();
        }
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v69, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v97, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02d7, code lost:
        r9.putInt(r14, r2, r1);
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02fd, code lost:
        r9.putLong(r30, r2, r23);
        r13 = r13 | r21;
        r0 = r7;
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x030c, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x034c, code lost:
        r0 = r10 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x034e, code lost:
        r13 = r13 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0351, code lost:
        r4 = r12;
        r6 = r13;
        r5 = r19;
        r13 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0358, code lost:
        r6 = r34;
        r16 = r8;
        r27 = r9;
        r2 = r10;
        r26 = r22;
        r10 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0416, code lost:
        if (r0 == r15) goto L_0x046f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x046d, code lost:
        if (r0 == r15) goto L_0x046f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x046f, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c8, code lost:
        r6 = r33;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0196, code lost:
        r6 = r33;
        r22 = r8;
        r8 = r5;
        r28 = r4;
        r4 = r1;
        r1 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01c6, code lost:
        r6 = r33;
        r22 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01cd, code lost:
        r8 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0262, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x027f, code lost:
        r1 = r13 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0281, code lost:
        r3 = r5;
        r13 = r6;
        r2 = r8;
        r4 = r12;
        r5 = r19;
        r16 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0289, code lost:
        r6 = r1;
        r1 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02b5, code lost:
        r7 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02b7, code lost:
        r22 = r8;
        r8 = r5;
        r1 = r7;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v5, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m(T r30, byte[] r31, int r32, int r33, int r34, a.d.a.a.h.g.v4 r35) {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r35
            sun.misc.Unsafe r9 = q
            r0 = r32
            r1 = r34
            r4 = r12
            r2 = -1
            r3 = 0
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = 0
            r16 = 0
        L_0x0019:
            r17 = 0
            if (r0 >= r13) goto L_0x051c
            int r10 = r0 + 1
            byte r0 = r4[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = a.c.a.f.b.O0(r0, r4, r10, r11)
            int r10 = r11.f1981a
            r28 = r10
            r10 = r0
            r0 = r28
        L_0x002e:
            int r8 = r0 >>> 3
            r7 = r0 & 7
            r16 = r0
            r0 = 3
            if (r8 <= r2) goto L_0x0049
            int r3 = r3 / r0
            int r2 = r15.f1778c
            if (r8 < r2) goto L_0x0045
            int r2 = r15.f1779d
            if (r8 > r2) goto L_0x0045
            int r2 = r15.z(r8, r3)
            goto L_0x0046
        L_0x0045:
            r2 = -1
        L_0x0046:
            r0 = -1
            r3 = 0
            goto L_0x005b
        L_0x0049:
            int r2 = r15.f1778c
            if (r8 < r2) goto L_0x0058
            int r2 = r15.f1779d
            if (r8 > r2) goto L_0x0058
            r3 = 0
            int r2 = r15.z(r8, r3)
            r0 = -1
            goto L_0x005b
        L_0x0058:
            r3 = 0
            r0 = -1
            r2 = -1
        L_0x005b:
            if (r2 != r0) goto L_0x0072
            r19 = r5
            r13 = r6
            r26 = r8
            r27 = r9
            r2 = r10
            r10 = r16
            r16 = 0
            r18 = 0
            r20 = 1
            r22 = -1
            r6 = r1
            goto L_0x0477
        L_0x0072:
            int[] r1 = r15.f1776a
            int r20 = r2 + 1
            r21 = r4
            r4 = r1[r20]
            r20 = 267386880(0xff00000, float:2.3665827E-29)
            r20 = r4 & r20
            int r3 = r20 >>> 20
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r4 & r13
            long r13 = (long) r0
            r0 = 17
            r23 = r13
            if (r3 > r0) goto L_0x0368
            int r0 = r2 + 2
            r0 = r1[r0]
            int r1 = r0 >>> 20
            r14 = 1
            int r21 = r14 << r1
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r14
            if (r0 == r5) goto L_0x00b3
            if (r5 == r14) goto L_0x00a6
            long r13 = (long) r5
            r5 = r30
            r25 = r23
            r9.putInt(r5, r13, r6)
            goto L_0x00aa
        L_0x00a6:
            r5 = r30
            r25 = r23
        L_0x00aa:
            long r13 = (long) r0
            int r6 = r9.getInt(r5, r13)
            r14 = r5
            r13 = r6
            r6 = r0
            goto L_0x00b9
        L_0x00b3:
            r14 = r30
            r25 = r23
            r13 = r6
            r6 = r5
        L_0x00b9:
            r0 = 5
            switch(r3) {
                case 0: goto L_0x0330;
                case 1: goto L_0x030e;
                case 2: goto L_0x02dd;
                case 3: goto L_0x02dd;
                case 4: goto L_0x02bd;
                case 5: goto L_0x028e;
                case 6: goto L_0x0264;
                case 7: goto L_0x0237;
                case 8: goto L_0x020e;
                case 9: goto L_0x01d0;
                case 10: goto L_0x01a5;
                case 11: goto L_0x02bd;
                case 12: goto L_0x0160;
                case 13: goto L_0x0264;
                case 14: goto L_0x028e;
                case 15: goto L_0x0148;
                case 16: goto L_0x011f;
                case 17: goto L_0x00d0;
                default: goto L_0x00bd;
            }
        L_0x00bd:
            r19 = r6
            r22 = r8
            r1 = r16
            r0 = 1
            r16 = -1
            r18 = 0
        L_0x00c8:
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            r8 = r2
            goto L_0x0358
        L_0x00d0:
            r3 = 3
            if (r7 != r3) goto L_0x0112
            int r0 = r8 << 3
            r4 = r0 | 4
            a.d.a.a.h.g.v7 r0 = r15.o(r2)
            r7 = r16
            r16 = -1
            r1 = r31
            r5 = r2
            r2 = r10
            r18 = 0
            r3 = r33
            r10 = r5
            r5 = r35
            int r0 = a.c.a.f.b.R0(r0, r1, r2, r3, r4, r5)
            r1 = r13 & r21
            if (r1 != 0) goto L_0x00f7
            java.lang.Object r1 = r11.f1983c
            r2 = r25
            goto L_0x0103
        L_0x00f7:
            r2 = r25
            java.lang.Object r1 = r9.getObject(r14, r2)
            java.lang.Object r4 = r11.f1983c
            java.lang.Object r1 = a.d.a.a.h.g.a6.e(r1, r4)
        L_0x0103:
            r9.putObject(r14, r2, r1)
            r1 = r13 | r21
            r13 = r33
            r5 = r6
            r16 = r7
            r2 = r8
            r3 = r10
            r4 = r12
            goto L_0x0289
        L_0x0112:
            r7 = r16
            r16 = -1
            r18 = 0
            r19 = r6
            r1 = r7
            r22 = r8
            r0 = 1
            goto L_0x00c8
        L_0x011f:
            r5 = r2
            r1 = r16
            r2 = r25
            r16 = -1
            r18 = 0
            if (r7 != 0) goto L_0x0144
            int r0 = a.c.a.f.b.r1(r12, r10, r11)
            r19 = r6
            long r6 = r11.f1982b
            long r6 = a.d.a.a.h.g.g5.a(r6)
            r4 = r1
            r23 = r6
            r22 = r8
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            r7 = r0
            r8 = r5
            goto L_0x02fd
        L_0x0144:
            r19 = r6
            goto L_0x01c6
        L_0x0148:
            r5 = r2
            r19 = r6
            r1 = r16
            r2 = r25
            r16 = -1
            r18 = 0
            if (r7 != 0) goto L_0x01c6
            int r0 = a.c.a.f.b.U0(r12, r10, r11)
            int r4 = r11.f1981a
            int r4 = a.d.a.a.h.g.g5.b(r4)
            goto L_0x0196
        L_0x0160:
            r5 = r2
            r19 = r6
            r1 = r16
            r2 = r25
            r16 = -1
            r18 = 0
            if (r7 != 0) goto L_0x01c6
            int r0 = a.c.a.f.b.U0(r12, r10, r11)
            int r4 = r11.f1981a
            a.d.a.a.h.g.e6 r6 = r15.G(r5)
            if (r6 == 0) goto L_0x0196
            boolean r6 = r6.f(r4)
            if (r6 == 0) goto L_0x0180
            goto L_0x0196
        L_0x0180:
            a.d.a.a.h.g.k8 r2 = M(r30)
            long r3 = (long) r4
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.a(r1, r3)
            r6 = r33
            r22 = r8
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r5
            goto L_0x0351
        L_0x0196:
            r6 = r33
            r22 = r8
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r5
            r28 = r4
            r4 = r1
            r1 = r28
            goto L_0x02d7
        L_0x01a5:
            r5 = r2
            r19 = r6
            r1 = r16
            r2 = r25
            r0 = 2
            r16 = -1
            r18 = 0
            if (r7 != r0) goto L_0x01c6
            int r0 = a.c.a.f.b.A1(r12, r10, r11)
            java.lang.Object r4 = r11.f1983c
            r9.putObject(r14, r2, r4)
            r6 = r33
            r22 = r8
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r5
            goto L_0x034e
        L_0x01c6:
            r6 = r33
            r22 = r8
            r20 = 1048575(0xfffff, float:1.469367E-39)
        L_0x01cd:
            r8 = r5
            goto L_0x032e
        L_0x01d0:
            r5 = r2
            r19 = r6
            r1 = r16
            r2 = r25
            r0 = 2
            r16 = -1
            r18 = 0
            if (r7 != r0) goto L_0x0206
            a.d.a.a.h.g.v7 r0 = r15.o(r5)
            r6 = r33
            r20 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = a.c.a.f.b.S0(r0, r12, r10, r6, r11)
            r4 = r13 & r21
            if (r4 != 0) goto L_0x01f2
            java.lang.Object r4 = r11.f1983c
            goto L_0x01fc
        L_0x01f2:
            java.lang.Object r4 = r9.getObject(r14, r2)
            java.lang.Object r7 = r11.f1983c
            java.lang.Object r4 = a.d.a.a.h.g.a6.e(r4, r7)
        L_0x01fc:
            r9.putObject(r14, r2, r4)
            r2 = r13 | r21
            r22 = r1
            r1 = r2
            goto L_0x0281
        L_0x0206:
            r6 = r33
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r22 = r8
            goto L_0x01cd
        L_0x020e:
            r5 = r2
            r19 = r6
            r1 = r16
            r2 = r25
            r0 = 2
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            if (r7 != r0) goto L_0x0262
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x022b
            int r0 = a.c.a.f.b.x1(r12, r10, r11)
            goto L_0x022f
        L_0x022b:
            int r0 = a.c.a.f.b.z1(r12, r10, r11)
        L_0x022f:
            java.lang.Object r4 = r11.f1983c
            r9.putObject(r14, r2, r4)
            r22 = r1
            goto L_0x027f
        L_0x0237:
            r5 = r2
            r19 = r6
            r1 = r16
            r2 = r25
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            if (r7 != 0) goto L_0x0262
            int r0 = a.c.a.f.b.r1(r12, r10, r11)
            r4 = r0
            r22 = r1
            long r0 = r11.f1982b
            r23 = 0
            int r7 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r7 == 0) goto L_0x025a
            r10 = 1
            goto L_0x025b
        L_0x025a:
            r10 = 0
        L_0x025b:
            a.d.a.a.h.g.n8$d r0 = a.d.a.a.h.g.n8.f
            r0.g(r14, r2, r10)
            r0 = r4
            goto L_0x027f
        L_0x0262:
            r7 = r1
            goto L_0x02b7
        L_0x0264:
            r5 = r2
            r19 = r6
            r22 = r16
            r2 = r25
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            if (r7 != r0) goto L_0x02b5
            int r0 = a.c.a.f.b.T0(r12, r10)
            r9.putInt(r14, r2, r0)
            int r0 = r10 + 4
        L_0x027f:
            r1 = r13 | r21
        L_0x0281:
            r3 = r5
            r13 = r6
            r2 = r8
            r4 = r12
            r5 = r19
            r16 = r22
        L_0x0289:
            r6 = r1
            r1 = r34
            goto L_0x0019
        L_0x028e:
            r5 = r2
            r19 = r6
            r22 = r16
            r2 = r25
            r0 = 1
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            if (r7 != r0) goto L_0x02b5
            long r23 = a.c.a.f.b.s1(r12, r10)
            r0 = r9
            r7 = r22
            r1 = r30
            r22 = r8
            r8 = r5
            r4 = r23
            r0.putLong(r1, r2, r4)
            r1 = r7
            goto L_0x034c
        L_0x02b5:
            r7 = r22
        L_0x02b7:
            r22 = r8
            r8 = r5
            r1 = r7
            goto L_0x032e
        L_0x02bd:
            r19 = r6
            r22 = r8
            r4 = r16
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            r8 = r2
            r2 = r25
            if (r7 != 0) goto L_0x030c
            int r0 = a.c.a.f.b.U0(r12, r10, r11)
            int r1 = r11.f1981a
        L_0x02d7:
            r9.putInt(r14, r2, r1)
            r1 = r4
            goto L_0x034e
        L_0x02dd:
            r19 = r6
            r22 = r8
            r4 = r16
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            r8 = r2
            r2 = r25
            if (r7 != 0) goto L_0x030c
            int r0 = a.c.a.f.b.r1(r12, r10, r11)
            r32 = r0
            long r0 = r11.f1982b
            r7 = r32
            r23 = r0
        L_0x02fd:
            r0 = r9
            r1 = r30
            r10 = r4
            r4 = r23
            r0.putLong(r1, r2, r4)
            r0 = r13 | r21
            r13 = r0
            r0 = r7
            r1 = r10
            goto L_0x0351
        L_0x030c:
            r1 = r4
            goto L_0x032e
        L_0x030e:
            r19 = r6
            r22 = r8
            r1 = r16
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            r8 = r2
            r2 = r25
            if (r7 != r0) goto L_0x032e
            float r0 = a.c.a.f.b.y1(r12, r10)
            a.d.a.a.h.g.n8$d r4 = a.d.a.a.h.g.n8.f
            r4.d(r14, r2, r0)
            int r0 = r10 + 4
            goto L_0x034e
        L_0x032e:
            r0 = 1
            goto L_0x0358
        L_0x0330:
            r19 = r6
            r22 = r8
            r1 = r16
            r0 = 1
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r33
            r8 = r2
            r2 = r25
            if (r7 != r0) goto L_0x0358
            double r4 = a.c.a.f.b.w1(r12, r10)
            a.d.a.a.h.g.n8.d(r14, r2, r4)
        L_0x034c:
            int r0 = r10 + 8
        L_0x034e:
            r2 = r13 | r21
            r13 = r2
        L_0x0351:
            r4 = r12
            r6 = r13
            r5 = r19
            r13 = r1
            goto L_0x03bb
        L_0x0358:
            r6 = r34
            r16 = r8
            r27 = r9
            r2 = r10
            r26 = r22
            r20 = 1
            r22 = -1
            r10 = r1
            goto L_0x0477
        L_0x0368:
            r14 = r30
            r22 = r8
            r13 = r16
            r11 = r23
            r0 = 1
            r16 = -1
            r18 = 0
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r2
            r2 = 27
            if (r3 != r2) goto L_0x03dd
            r1 = 2
            if (r7 != r1) goto L_0x03ca
            java.lang.Object r0 = r9.getObject(r14, r11)
            a.d.a.a.h.g.f6 r0 = (a.d.a.a.h.g.f6) r0
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x039e
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0395
            r1 = 10
            goto L_0x0397
        L_0x0395:
            int r1 = r1 << 1
        L_0x0397:
            a.d.a.a.h.g.f6 r0 = r0.f(r1)
            r9.putObject(r14, r11, r0)
        L_0x039e:
            r7 = r0
            a.d.a.a.h.g.v7 r0 = r15.o(r8)
            r1 = r13
            r2 = r31
            r3 = r10
            r12 = r21
            r4 = r33
            r19 = r5
            r5 = r7
            r21 = r6
            r6 = r35
            int r0 = a.c.a.f.b.Q0(r0, r1, r2, r3, r4, r5, r6)
            r4 = r12
            r5 = r19
            r6 = r21
        L_0x03bb:
            r12 = r31
            r1 = r34
            r11 = r35
            r3 = r8
            r16 = r13
            r2 = r22
            r13 = r33
            goto L_0x0019
        L_0x03ca:
            r19 = r5
            r21 = r6
            r16 = r8
            r27 = r9
            r15 = r10
            r25 = r13
            r26 = r22
            r20 = 1
            r22 = -1
            goto L_0x0440
        L_0x03dd:
            r19 = r5
            r21 = r6
            r2 = 49
            if (r3 > r2) goto L_0x0426
            long r5 = (long) r4
            r23 = 1
            r0 = r29
            r1 = r30
            r2 = r31
            r4 = r3
            r3 = r10
            r32 = r4
            r4 = r33
            r24 = r5
            r5 = r13
            r6 = r22
            r16 = r8
            r26 = r22
            r22 = -1
            r27 = r9
            r15 = r10
            r20 = 1
            r9 = r24
            r23 = r11
            r12 = r35
            r11 = r32
            r25 = r13
            r12 = r23
            r14 = r35
            int r0 = r0.k(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x041a
            goto L_0x046f
        L_0x041a:
            r7 = r29
            r11 = r30
            r8 = r35
            r10 = r25
            r9 = r26
            goto L_0x0509
        L_0x0426:
            r32 = r3
            r16 = r8
            r27 = r9
            r15 = r10
            r23 = r11
            r25 = r13
            r26 = r22
            r20 = 1
            r22 = -1
            r0 = 50
            r9 = r32
            if (r9 != r0) goto L_0x0455
            r0 = 2
            if (r7 == r0) goto L_0x0442
        L_0x0440:
            r10 = r15
            goto L_0x0470
        L_0x0442:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r16
            r6 = r23
            r8 = r35
            r0.l(r1, r2, r3, r4, r5, r6, r8)
            throw r17
        L_0x0455:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r8 = r4
            r4 = r33
            r5 = r25
            r6 = r26
            r10 = r23
            r12 = r16
            r13 = r35
            int r0 = r0.j(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x041a
        L_0x046f:
            r10 = r0
        L_0x0470:
            r6 = r34
            r2 = r10
            r13 = r21
            r10 = r25
        L_0x0477:
            if (r10 != r6) goto L_0x0487
            if (r6 != 0) goto L_0x047c
            goto L_0x0487
        L_0x047c:
            r7 = r29
            r11 = r30
            r0 = r2
            r1 = r6
            r6 = r13
            r5 = r19
            goto L_0x0528
        L_0x0487:
            r7 = r29
            boolean r0 = r7.f
            if (r0 == 0) goto L_0x04df
            r8 = r35
            a.d.a.a.h.g.l5 r0 = r8.f1984d
            a.d.a.a.h.g.l5 r1 = a.d.a.a.h.g.l5.a()
            if (r0 == r1) goto L_0x04dc
            a.d.a.a.h.g.i7 r0 = r7.f1780e
            a.d.a.a.h.g.l5 r1 = r8.f1984d
            java.util.Map<a.d.a.a.h.g.l5$a, a.d.a.a.h.g.y5$f<?, ?>> r1 = r1.f1804a
            a.d.a.a.h.g.l5$a r3 = new a.d.a.a.h.g.l5$a
            r9 = r26
            r3.<init>(r0, r9)
            java.lang.Object r0 = r1.get(r3)
            a.d.a.a.h.g.y5$f r0 = (a.d.a.a.h.g.y5.f) r0
            if (r0 != 0) goto L_0x04ce
            a.d.a.a.h.g.k8 r4 = M(r30)
            r0 = r10
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = a.c.a.f.b.N0(r0, r1, r2, r3, r4, r5)
            r14 = r30
            r4 = r31
            r12 = r4
            r1 = r6
            r15 = r7
            r11 = r8
            r2 = r9
            r6 = r13
            r3 = r16
            r5 = r19
            r9 = r27
            r13 = r33
            goto L_0x0505
        L_0x04ce:
            r11 = r30
            r0 = r11
            a.d.a.a.h.g.y5$d r0 = (a.d.a.a.h.g.y5.d) r0
            r0.s()
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x04dc:
            r11 = r30
            goto L_0x04e3
        L_0x04df:
            r11 = r30
            r8 = r35
        L_0x04e3:
            r9 = r26
            a.d.a.a.h.g.k8 r4 = M(r30)
            r0 = r10
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = a.c.a.f.b.N0(r0, r1, r2, r3, r4, r5)
            r4 = r31
            r12 = r4
            r1 = r6
            r15 = r7
            r2 = r9
            r14 = r11
            r6 = r13
            r3 = r16
            r5 = r19
            r9 = r27
            r13 = r33
        L_0x0504:
            r11 = r8
        L_0x0505:
            r16 = r10
            goto L_0x0019
        L_0x0509:
            r4 = r31
            r12 = r4
            r13 = r33
            r1 = r34
            r15 = r7
            r2 = r9
            r14 = r11
            r3 = r16
            r5 = r19
            r6 = r21
            r9 = r27
            goto L_0x0504
        L_0x051c:
            r19 = r5
            r21 = r6
            r27 = r9
            r11 = r14
            r7 = r15
            r20 = 1
            r10 = r16
        L_0x0528:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r5 == r2) goto L_0x0533
            long r3 = (long) r5
            r5 = r27
            r5.putInt(r11, r3, r6)
        L_0x0533:
            int r3 = r7.i
        L_0x0535:
            int r4 = r7.j
            if (r3 >= r4) goto L_0x05a1
            int[] r4 = r7.h
            r4 = r4[r3]
            a.d.a.a.h.g.h8<?, ?> r5 = r7.m
            int[] r6 = r7.f1776a
            r8 = r6[r4]
            int r8 = r4 + 1
            r6 = r6[r8]
            r6 = r6 & r2
            long r8 = (long) r6
            java.lang.Object r6 = a.d.a.a.h.g.n8.r(r11, r8)
            if (r6 != 0) goto L_0x0550
            goto L_0x059e
        L_0x0550:
            java.lang.Object[] r8 = r7.f1777b
            int r4 = r4 / 3
            int r4 = r4 << 1
            int r9 = r4 + 1
            r8 = r8[r9]
            a.d.a.a.h.g.e6 r8 = (a.d.a.a.h.g.e6) r8
            if (r8 != 0) goto L_0x055f
            goto L_0x059e
        L_0x055f:
            a.d.a.a.h.g.b7 r9 = r7.o
            java.util.Map r6 = r9.b(r6)
            a.d.a.a.h.g.b7 r9 = r7.o
            java.lang.Object[] r12 = r7.f1777b
            r4 = r12[r4]
            r9.g(r4)
            java.util.Set r4 = r6.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0576:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x059e
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r9 = r6.getValue()
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            boolean r9 = r8.f(r9)
            if (r9 != 0) goto L_0x0576
            a.d.a.a.h.g.j8 r5 = (a.d.a.a.h.g.j8) r5
            if (r5 == 0) goto L_0x059d
            r6.getKey()
            r6.getValue()
            throw r17
        L_0x059d:
            throw r17
        L_0x059e:
            int r3 = r3 + 1
            goto L_0x0535
        L_0x05a1:
            if (r1 != 0) goto L_0x05ad
            r2 = r33
            if (r0 != r2) goto L_0x05a8
            goto L_0x05b3
        L_0x05a8:
            a.d.a.a.h.g.i6 r0 = a.d.a.a.h.g.i6.e()
            throw r0
        L_0x05ad:
            r2 = r33
            if (r0 > r2) goto L_0x05b4
            if (r10 != r1) goto L_0x05b4
        L_0x05b3:
            return r0
        L_0x05b4:
            a.d.a.a.h.g.i6 r0 = a.d.a.a.h.g.i6.e()
            goto L_0x05ba
        L_0x05b9:
            throw r0
        L_0x05ba:
            goto L_0x05b9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.k7.m(java.lang.Object, byte[], int, int, int, a.d.a.a.h.g.v4):int");
    }

    public final v7 o(int i2) {
        int i3 = (i2 / 3) << 1;
        Object[] objArr = this.f1777b;
        v7 v7Var = (v7) objArr[i3];
        if (v7Var != null) {
            return v7Var;
        }
        v7 a2 = r7.f1920c.a((Class) objArr[i3 + 1]);
        this.f1777b[i3] = a2;
        return a2;
    }

    public final <K, V> void t(d9 d9Var, int i2, Object obj, int i3) {
        if (obj != null) {
            this.o.g(this.f1777b[(i3 / 3) << 1]);
            Map<?, ?> f2 = this.o.f(obj);
            k5 k5Var = (k5) d9Var;
            if (k5Var != null) {
                Iterator<Map.Entry<?, ?>> it = f2.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    ((i5.b) k5Var.f1770a).o((i2 << 3) | 2);
                    next.getKey();
                    next.getValue();
                    throw null;
                }
                return;
            }
            throw null;
        }
    }

    public final void u(T t, T t2, int i2) {
        long j2 = (long) (this.f1776a[i2 + 1] & 1048575);
        if (v(t2, i2)) {
            Object r = n8.r(t, j2);
            Object r2 = n8.r(t2, j2);
            if (r != null && r2 != null) {
                n8.f(t, j2, a6.e(r, r2));
                B(t, i2);
            } else if (r2 != null) {
                n8.f(t, j2, r2);
                B(t, i2);
            }
        }
    }

    public final boolean v(T t, int i2) {
        int[] iArr = this.f1776a;
        int i3 = iArr[i2 + 2];
        long j2 = (long) (i3 & 1048575);
        if (j2 == 1048575) {
            int i4 = iArr[i2 + 1];
            long j3 = (long) (i4 & 1048575);
            switch ((i4 & 267386880) >>> 20) {
                case 0:
                    return n8.q(t, j3) != 0.0d;
                case 1:
                    return n8.n(t, j3) != 0.0f;
                case 2:
                    return n8.i(t, j3) != 0;
                case 3:
                    return n8.i(t, j3) != 0;
                case 4:
                    return n8.b(t, j3) != 0;
                case 5:
                    return n8.i(t, j3) != 0;
                case 6:
                    return n8.b(t, j3) != 0;
                case 7:
                    return n8.m(t, j3);
                case 8:
                    Object r = n8.r(t, j3);
                    if (r instanceof String) {
                        return !((String) r).isEmpty();
                    }
                    if (r instanceof w4) {
                        return !w4.f2000b.equals(r);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return n8.r(t, j3) != null;
                case 10:
                    return !w4.f2000b.equals(n8.r(t, j3));
                case 11:
                    return n8.b(t, j3) != 0;
                case 12:
                    return n8.b(t, j3) != 0;
                case 13:
                    return n8.b(t, j3) != 0;
                case 14:
                    return n8.i(t, j3) != 0;
                case 15:
                    return n8.b(t, j3) != 0;
                case 16:
                    return n8.i(t, j3) != 0;
                case 17:
                    return n8.r(t, j3) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (n8.b(t, j2) & (1 << (i3 >>> 20))) != 0;
        }
    }

    public final boolean w(T t, int i2, int i3) {
        return n8.b(t, (long) (this.f1776a[i3 + 2] & 1048575)) == i2;
    }

    public final boolean x(T t, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? v(t, i2) : (i4 & i5) != 0;
    }

    public final int z(int i2, int i3) {
        int length = (this.f1776a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f1776a[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }
}

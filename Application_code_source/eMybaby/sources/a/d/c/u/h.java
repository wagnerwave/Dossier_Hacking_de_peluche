package a.d.c.u;

import a.d.c.e;
import a.d.c.f;
import a.d.c.i;
import a.d.c.l;
import a.d.c.n;
import a.d.c.r.a;
import java.util.Map;

public final class h extends k {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f3060b = {44, 24, 20, 18, 16, 14, 12, 10, 8, 6};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f3061c = {1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3062d = {1, 1, 3};

    /* renamed from: e  reason: collision with root package name */
    public static final int[][] f3063e = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a  reason: collision with root package name */
    public int f3064a = -1;

    public static int g(int[] iArr) {
        int length = f3063e.length;
        int i = 107;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            int d2 = k.d(iArr, f3063e[i3], 204);
            if (d2 < i) {
                i2 = i3;
                i = d2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw i.f2874a;
    }

    public static int[] h(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i2 = aVar.f2965b;
        int i3 = i;
        boolean z = false;
        int i4 = 0;
        while (i < i2) {
            if (aVar.a(i) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else if (k.d(iArr2, iArr, 204) < 107) {
                    return new int[]{i3, i};
                } else {
                    i3 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i++;
        }
        throw i.f2874a;
    }

    /* JADX INFO: finally extract failed */
    public l b(int i, a aVar, Map<e, ?> map) {
        boolean z;
        a aVar2 = aVar;
        Map<e, ?> map2 = map;
        int i2 = aVar2.f2965b;
        int i3 = 0;
        int b2 = aVar2.b(0);
        if (b2 != i2) {
            int[] h = h(aVar2, b2, f3061c);
            this.f3064a = (h[1] - h[0]) >> 2;
            i(aVar2, h[0]);
            aVar.e();
            try {
                int i4 = aVar2.f2965b;
                int b3 = aVar2.b(0);
                if (b3 != i4) {
                    int[] h2 = h(aVar2, b3, f3062d);
                    i(aVar2, h2[0]);
                    int i5 = h2[0];
                    h2[0] = aVar2.f2965b - h2[1];
                    h2[1] = aVar2.f2965b - i5;
                    aVar.e();
                    StringBuilder sb = new StringBuilder(20);
                    int i6 = h[1];
                    int i7 = h2[0];
                    int[] iArr = new int[10];
                    int[] iArr2 = new int[5];
                    int[] iArr3 = new int[5];
                    while (i6 < i7) {
                        k.e(aVar2, i6, iArr);
                        while (i3 < 5) {
                            int i8 = i3 << 1;
                            iArr2[i3] = iArr[i8];
                            iArr3[i3] = iArr[i8 + 1];
                            i3++;
                        }
                        sb.append((char) (g(iArr2) + 48));
                        sb.append((char) (g(iArr3) + 48));
                        for (int i9 = 0; i9 < 10; i9++) {
                            i6 += iArr[i9];
                        }
                        i3 = 0;
                    }
                    String sb2 = sb.toString();
                    int[] iArr4 = map2 != null ? (int[]) map2.get(e.ALLOWED_LENGTHS) : null;
                    if (iArr4 == null) {
                        iArr4 = f3060b;
                    }
                    int length = sb2.length();
                    int length2 = iArr4.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            z = false;
                            break;
                        } else if (length == iArr4[i10]) {
                            z = true;
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (z) {
                        float f = (float) i;
                        return new l(sb2, (byte[]) null, new n[]{new n((float) h[1], f), new n((float) h2[0], f)}, a.d.c.a.ITF);
                    }
                    throw f.f2869a;
                }
                throw i.f2874a;
            } catch (Throwable th) {
                aVar.e();
                throw th;
            }
        } else {
            throw i.f2874a;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(a.d.c.r.a r3, int r4) {
        /*
            r2 = this;
            int r0 = r2.f3064a
            int r0 = r0 * 10
        L_0x0004:
            int r4 = r4 + -1
            if (r0 <= 0) goto L_0x0014
            if (r4 < 0) goto L_0x0014
            boolean r1 = r3.a(r4)
            if (r1 == 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            int r0 = r0 + -1
            goto L_0x0004
        L_0x0014:
            if (r0 != 0) goto L_0x0017
            return
        L_0x0017:
            a.d.c.i r3 = a.d.c.i.f2874a
            goto L_0x001b
        L_0x001a:
            throw r3
        L_0x001b:
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.h.i(a.d.c.r.a, int):void");
    }
}

package a.d.c.v.c;

import a.d.c.n;
import a.d.c.r.b;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f3134a = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f3135b = {3, 1, 1, 1, 1, 1, 1, 8};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f3136c = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3137d = {1, 2, 1, 1, 1, 3, 1, 1, 7};

    public static void a(n[] nVarArr, boolean z) {
        float f = nVarArr[4].f2886b - nVarArr[6].f2886b;
        if (z) {
            f = -f;
        }
        if (f > 2.0f) {
            nVarArr[4] = new n(nVarArr[4].f2885a, nVarArr[4].f2886b + (((nVarArr[6].f2886b - nVarArr[0].f2886b) * (nVarArr[4].f2885a - nVarArr[0].f2885a)) / (nVarArr[6].f2885a - nVarArr[0].f2885a)));
        } else if ((-f) > 2.0f) {
            nVarArr[6] = new n(nVarArr[6].f2885a, nVarArr[6].f2886b - (((nVarArr[2].f2886b - nVarArr[4].f2886b) * (nVarArr[2].f2885a - nVarArr[6].f2885a)) / (nVarArr[2].f2885a - nVarArr[4].f2885a)));
        }
        float f2 = nVarArr[7].f2886b - nVarArr[5].f2886b;
        if (z) {
            f2 = -f2;
        }
        if (f2 > 2.0f) {
            nVarArr[5] = new n(nVarArr[5].f2885a, nVarArr[5].f2886b + (((nVarArr[7].f2886b - nVarArr[1].f2886b) * (nVarArr[5].f2885a - nVarArr[1].f2885a)) / (nVarArr[7].f2885a - nVarArr[1].f2885a)));
        } else if ((-f2) > 2.0f) {
            nVarArr[7] = new n(nVarArr[7].f2885a, nVarArr[7].f2886b - (((nVarArr[3].f2886b - nVarArr[5].f2886b) * (nVarArr[3].f2885a - nVarArr[7].f2885a)) / (nVarArr[3].f2885a - nVarArr[5].f2885a)));
        }
    }

    public static int[] b(b bVar, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        int i4;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        Arrays.fill(iArr4, 0, iArr4.length, 0);
        int length = iArr3.length;
        int i5 = i;
        int i6 = i5;
        boolean z2 = z;
        int i7 = 0;
        while (i5 < i + i3) {
            if (bVar.a(i5, i2) ^ z2) {
                iArr4[i7] = iArr4[i7] + 1;
            } else {
                int i8 = length - 1;
                if (i7 == i8) {
                    int length2 = iArr4.length;
                    int i9 = 0;
                    int i10 = 0;
                    for (int i11 = 0; i11 < length2; i11++) {
                        i9 += iArr4[i11];
                        i10 += iArr3[i11];
                    }
                    if (i9 >= i10) {
                        int i12 = (i9 << 8) / i10;
                        int i13 = (i12 * 204) >> 8;
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            if (i14 >= length2) {
                                i4 = i15 / i9;
                                break;
                            }
                            int i16 = iArr4[i14] << 8;
                            int i17 = iArr3[i14] * i12;
                            int i18 = i16 > i17 ? i16 - i17 : i17 - i16;
                            if (i18 > i13) {
                                break;
                            }
                            i15 += i18;
                            i14++;
                            iArr3 = iArr;
                        }
                    }
                    i4 = Integer.MAX_VALUE;
                    if (i4 < 107) {
                        return new int[]{i6, i5};
                    }
                    i6 += iArr4[0] + iArr4[1];
                    int i19 = length - 2;
                    System.arraycopy(iArr4, 2, iArr4, 0, i19);
                    iArr4[i19] = 0;
                    iArr4[i8] = 0;
                    i7--;
                } else {
                    i7++;
                }
                iArr4[i7] = 1;
                z2 = !z2;
            }
            i5++;
            iArr3 = iArr;
        }
        return null;
    }
}

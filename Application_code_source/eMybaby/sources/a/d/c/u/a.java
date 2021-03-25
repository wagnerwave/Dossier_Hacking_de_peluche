package a.d.c.u;

import a.d.c.e;
import a.d.c.i;
import a.d.c.l;
import a.d.c.n;
import java.util.Map;

public final class a extends k {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3046a = "0123456789-$:/.+ABCDTN".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f3047b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14, 26, 41};

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f3048c = {'E', '*', 'A', 'B', 'C', 'D', 'T', 'N'};

    public static boolean g(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char h(int[] iArr) {
        int length = iArr.length;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (iArr[i3] < i) {
                i = iArr[i3];
            }
            if (iArr[i3] > i2) {
                i2 = iArr[i3];
            }
        }
        do {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (iArr[i6] > i2) {
                    i5 |= 1 << ((length - 1) - i6);
                    i4++;
                }
            }
            if (i4 == 2 || i4 == 3) {
                int i7 = 0;
                while (true) {
                    int[] iArr2 = f3047b;
                    if (i7 >= iArr2.length) {
                        break;
                    } else if (iArr2[i7] == i5) {
                        return f3046a[i7];
                    } else {
                        i7++;
                    }
                }
            }
            i2--;
        } while (i2 > i);
        return '!';
    }

    public l b(int i, a.d.c.r.a aVar, Map<e, ?> map) {
        int i2;
        int i3 = aVar.f2965b;
        int b2 = aVar.b(0);
        int[] iArr = new int[7];
        int i4 = b2;
        boolean z = false;
        int i5 = 0;
        while (b2 < i3) {
            if (aVar.a(b2) ^ z) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 == 6) {
                    try {
                        if (g(f3048c, h(iArr)) && aVar.d(Math.max(0, i4 - ((b2 - i4) / 2)), i4, false)) {
                            int[] iArr2 = {i4, b2};
                            iArr2[1] = 0;
                            int b3 = aVar.b(iArr2[1]);
                            int i6 = aVar.f2965b;
                            StringBuilder sb = new StringBuilder();
                            int[] iArr3 = new int[7];
                            while (true) {
                                for (int i7 = 0; i7 < 7; i7++) {
                                    iArr3[i7] = 0;
                                }
                                k.e(aVar, b3, iArr3);
                                char h = h(iArr3);
                                if (h != '!') {
                                    sb.append(h);
                                    int i8 = b3;
                                    for (int i9 = 0; i9 < 7; i9++) {
                                        i8 += iArr3[i9];
                                    }
                                    int b4 = aVar.b(i8);
                                    if (b4 >= i6) {
                                        int i10 = 0;
                                        for (int i11 = 0; i11 < 7; i11++) {
                                            i10 += iArr3[i11];
                                        }
                                        int i12 = (b4 - b3) - i10;
                                        if (b4 != i6 && i12 / 2 < i10) {
                                            throw i.f2874a;
                                        } else if (sb.length() >= 2) {
                                            char charAt = sb.charAt(0);
                                            if (g(f3048c, charAt)) {
                                                int i13 = 1;
                                                while (true) {
                                                    if (i13 < sb.length()) {
                                                        if (sb.charAt(i13) == charAt && (i2 = i13 + 1) != sb.length()) {
                                                            sb.delete(i2, sb.length() - 1);
                                                            break;
                                                        }
                                                        i13++;
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                if (sb.length() > 6) {
                                                    sb.deleteCharAt(sb.length() - 1);
                                                    sb.deleteCharAt(0);
                                                    float f = (float) i;
                                                    return new l(sb.toString(), (byte[]) null, new n[]{new n(((float) (iArr2[1] + iArr2[0])) / 2.0f, f), new n(((float) (b4 + b3)) / 2.0f, f)}, a.d.c.a.CODABAR);
                                                }
                                                throw i.f2874a;
                                            }
                                            throw i.f2874a;
                                        } else {
                                            throw i.f2874a;
                                        }
                                    } else {
                                        b3 = b4;
                                    }
                                } else {
                                    throw i.f2874a;
                                }
                            }
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                    i4 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 5);
                    iArr[5] = 0;
                    iArr[6] = 0;
                    i5--;
                } else {
                    i5++;
                }
                iArr[i5] = 1;
                z = !z;
            }
            b2++;
        }
        throw i.f2874a;
    }
}

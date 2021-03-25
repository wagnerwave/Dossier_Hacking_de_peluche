package a.d.c.u;

import a.d.c.d;
import a.d.c.e;
import a.d.c.f;
import a.d.c.i;
import a.d.c.k;
import a.d.c.l;
import a.d.c.m;
import a.d.c.o;
import a.d.c.r.a;
import java.util.Arrays;
import java.util.Map;

public abstract class n extends k {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3071d = {1, 1, 1};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f3072e = {1, 1, 1, 1, 1};
    public static final int[][] f;
    public static final int[][] g;

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f3073a = new StringBuilder(20);

    /* renamed from: b  reason: collision with root package name */
    public final m f3074b = new m();

    /* renamed from: c  reason: collision with root package name */
    public final g f3075c = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f = iArr;
        int[][] iArr2 = new int[20][];
        g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = f[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            g[i] = iArr4;
        }
    }

    public static int h(a aVar, int[] iArr, int i, int[][] iArr2) {
        k.e(aVar, i, iArr);
        int length = iArr2.length;
        int i2 = 122;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            int d2 = k.d(iArr, iArr2[i4], 179);
            if (d2 < i2) {
                i3 = i4;
                i2 = d2;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw i.f2874a;
    }

    public static int[] l(a aVar, int i, boolean z, int[] iArr) {
        return m(aVar, i, z, iArr, new int[iArr.length]);
    }

    public static int[] m(a aVar, int i, boolean z, int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i2 = aVar.f2965b;
        int c2 = z ? aVar.c(i) : aVar.b(i);
        boolean z2 = z;
        int i3 = 0;
        int i4 = c2;
        while (c2 < i2) {
            if (aVar.a(c2) ^ z2) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i5 = length - 1;
                if (i3 != i5) {
                    i3++;
                } else if (k.d(iArr2, iArr, 179) < 122) {
                    return new int[]{i4, c2};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z2 = !z2;
            }
            c2++;
        }
        throw i.f2874a;
    }

    public static int[] n(a aVar) {
        int[] iArr = new int[f3071d.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f3071d.length, 0);
            iArr2 = m(aVar, i, false, f3071d, iArr);
            int i2 = iArr2[0];
            int i3 = iArr2[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                z = aVar.d(i4, i2, false);
            }
            i = i3;
        }
        return iArr2;
    }

    public l b(int i, a aVar, Map<e, ?> map) {
        return k(i, aVar, n(aVar), map);
    }

    public boolean g(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int charAt = str.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw f.f2869a;
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int charAt2 = str.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw f.f2869a;
            }
            i3 += charAt2;
        }
        if (i3 % 10 == 0) {
            return true;
        }
        return false;
    }

    public int[] i(a aVar, int i) {
        return l(aVar, i, false, f3071d);
    }

    public abstract int j(a aVar, int[] iArr, StringBuilder sb);

    public l k(int i, a aVar, int[] iArr, Map<e, ?> map) {
        String str = null;
        o oVar = map == null ? null : (o) map.get(e.NEED_RESULT_POINT_CALLBACK);
        if (oVar != null) {
            oVar.a(new a.d.c.n(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder sb = this.f3073a;
        sb.setLength(0);
        int j = j(aVar, iArr, sb);
        if (oVar != null) {
            oVar.a(new a.d.c.n((float) j, (float) i));
        }
        int[] i2 = i(aVar, j);
        if (oVar != null) {
            oVar.a(new a.d.c.n(((float) (i2[0] + i2[1])) / 2.0f, (float) i));
        }
        int i3 = i2[1];
        int i4 = (i3 - i2[0]) + i3;
        if (i4 >= aVar.f2965b || !aVar.d(i3, i4, false)) {
            throw i.f2874a;
        }
        String sb2 = sb.toString();
        if (g(sb2)) {
            a.d.c.a o = o();
            float f2 = (float) i;
            l lVar = new l(sb2, (byte[]) null, new a.d.c.n[]{new a.d.c.n(((float) (iArr[1] + iArr[0])) / 2.0f, f2), new a.d.c.n(((float) (i2[1] + i2[0])) / 2.0f, f2)}, o);
            try {
                l a2 = this.f3074b.a(i, aVar, i2[1]);
                Map<m, Object> map2 = a2.f2879e;
                if (map2 != null) {
                    Map<m, Object> map3 = lVar.f2879e;
                    if (map3 == null) {
                        lVar.f2879e = map2;
                    } else {
                        map3.putAll(map2);
                    }
                }
                a.d.c.n[] nVarArr = a2.f2877c;
                a.d.c.n[] nVarArr2 = lVar.f2877c;
                if (nVarArr2 == null) {
                    lVar.f2877c = nVarArr;
                } else if (nVarArr != null && nVarArr.length > 0) {
                    a.d.c.n[] nVarArr3 = new a.d.c.n[(nVarArr2.length + nVarArr.length)];
                    System.arraycopy(nVarArr2, 0, nVarArr3, 0, nVarArr2.length);
                    System.arraycopy(nVarArr, 0, nVarArr3, nVarArr2.length, nVarArr.length);
                    lVar.f2877c = nVarArr3;
                }
            } catch (k unused) {
            }
            if (o == a.d.c.a.EAN_13 || o == a.d.c.a.UPC_A) {
                g gVar = this.f3075c;
                gVar.b();
                int parseInt = Integer.parseInt(sb2.substring(0, 3));
                int size = gVar.f3058a.size();
                int i5 = 0;
                while (true) {
                    if (i5 < size) {
                        int[] iArr2 = gVar.f3058a.get(i5);
                        int i6 = iArr2[0];
                        if (parseInt < i6) {
                            break;
                        }
                        if (iArr2.length != 1) {
                            i6 = iArr2[1];
                        }
                        if (parseInt <= i6) {
                            str = gVar.f3059b.get(i5);
                            break;
                        }
                        i5++;
                    } else {
                        break;
                    }
                }
                if (str != null) {
                    lVar.a(m.POSSIBLE_COUNTRY, str);
                }
            }
            return lVar;
        }
        throw d.f2863a;
    }

    public abstract a.d.c.a o();
}

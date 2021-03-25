package a.d.c.u;

import a.d.c.c;
import a.d.c.e;
import a.d.c.g;
import a.d.c.i;
import a.d.c.j;
import a.d.c.l;
import a.d.c.m;
import a.d.c.n;
import a.d.c.r.a;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class k implements j {
    public static int d(int[] iArr, int[] iArr2, int i) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Integer.MAX_VALUE;
        }
        int i5 = (i2 << 8) / i3;
        int i6 = (i * i5) >> 8;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = iArr[i8] << 8;
            int i10 = iArr2[i8] * i5;
            int i11 = i9 > i10 ? i9 - i10 : i10 - i9;
            if (i11 > i6) {
                return Integer.MAX_VALUE;
            }
            i7 += i11;
        }
        return i7 / i2;
    }

    public static void e(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i3 = aVar.f2965b;
        if (i < i3) {
            boolean z = !aVar.a(i);
            while (i < i3) {
                if (aVar.a(i) ^ z) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    iArr[i2] = 1;
                    z = !z;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != i3) {
                throw i.f2874a;
            }
            return;
        }
        throw i.f2874a;
    }

    public static void f(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        boolean a2 = aVar.a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.a(i) != a2) {
                length--;
                a2 = !a2;
            }
        }
        if (length < 0) {
            e(aVar, i + 1, iArr);
            return;
        }
        throw i.f2874a;
    }

    public l a(c cVar, Map<e, ?> map) {
        try {
            return c(cVar, map);
        } catch (i e2) {
            if (!(map != null && map.containsKey(e.TRY_HARDER)) || cVar.f2861a.f2860a != null) {
                throw e2;
            }
            throw null;
        }
    }

    public abstract l b(int i, a aVar, Map<e, ?> map);

    public final l c(c cVar, Map<e, ?> map) {
        Map<e, ?> map2;
        e eVar;
        c cVar2 = cVar;
        EnumMap enumMap = map;
        e eVar2 = e.NEED_RESULT_POINT_CALLBACK;
        g gVar = cVar2.f2861a.f2860a;
        int i = gVar.f2870a;
        int i2 = gVar.f2871b;
        a aVar = new a(i);
        int i3 = i2 >> 1;
        int i4 = 1;
        boolean z = enumMap != null && enumMap.containsKey(e.TRY_HARDER);
        int max = Math.max(1, i2 >> (z ? 8 : 5));
        int i5 = z ? i2 : 15;
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i6 + 1;
            int i8 = i7 >> 1;
            if (!((i6 & 1) == 0)) {
                i8 = -i8;
            }
            int i9 = (i8 * max) + i3;
            if (i9 < 0 || i9 >= i2) {
                break;
            }
            try {
                aVar = cVar2.f2861a.b(i9, aVar);
                int i10 = 0;
                while (i10 < 2) {
                    if (i10 == i4) {
                        aVar.e();
                        if (enumMap != null && enumMap.containsKey(eVar2)) {
                            EnumMap enumMap2 = new EnumMap(e.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(eVar2);
                            enumMap = enumMap2;
                        }
                    }
                    try {
                        l b2 = b(i9, aVar, enumMap);
                        if (i10 == i4) {
                            b2.a(m.ORIENTATION, 180);
                            n[] nVarArr = b2.f2877c;
                            if (nVarArr != null) {
                                float f = (float) i;
                                map2 = enumMap;
                                try {
                                    eVar = eVar2;
                                    try {
                                        nVarArr[0] = new n((f - nVarArr[0].f2885a) - 1.0f, nVarArr[0].f2886b);
                                        try {
                                            nVarArr[1] = new n((f - nVarArr[1].f2885a) - 1.0f, nVarArr[1].f2886b);
                                        } catch (a.d.c.k unused) {
                                            continue;
                                        }
                                    } catch (a.d.c.k unused2) {
                                        i10++;
                                        c cVar3 = cVar;
                                        enumMap = map2;
                                        eVar2 = eVar;
                                        i4 = 1;
                                    }
                                } catch (a.d.c.k unused3) {
                                    eVar = eVar2;
                                    i10++;
                                    c cVar32 = cVar;
                                    enumMap = map2;
                                    eVar2 = eVar;
                                    i4 = 1;
                                }
                            }
                        }
                        return b2;
                    } catch (a.d.c.k unused4) {
                        map2 = enumMap;
                        eVar = eVar2;
                        i10++;
                        c cVar322 = cVar;
                        enumMap = map2;
                        eVar2 = eVar;
                        i4 = 1;
                    }
                }
                continue;
            } catch (i unused5) {
            }
            cVar2 = cVar;
            i6 = i7;
            eVar2 = eVar2;
            i4 = 1;
        }
        throw i.f2874a;
    }

    public void reset() {
    }
}

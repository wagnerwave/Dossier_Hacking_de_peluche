package a.d.c.t;

import a.d.c.e;
import a.d.c.f;
import a.d.c.i;
import a.d.c.j;
import a.d.c.l;
import a.d.c.m;
import a.d.c.n;
import a.d.c.r.b;
import a.d.c.t.b.c;
import java.util.Map;

public final class a implements j {

    /* renamed from: b  reason: collision with root package name */
    public static final n[] f3039b = new n[0];

    /* renamed from: a  reason: collision with root package name */
    public final c f3040a = new c();

    public l a(a.d.c.c cVar, Map<e, ?> map) {
        int i;
        Map<e, ?> map2 = map;
        if (map2 == null || !map2.containsKey(e.PURE_BARCODE)) {
            throw i.f2874a;
        }
        b a2 = cVar.a();
        int i2 = a2.f2966a;
        int i3 = a2.f2967b;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < a2.f2967b; i6++) {
            int i7 = 0;
            while (true) {
                int i8 = a2.f2968c;
                if (i7 >= i8) {
                    break;
                }
                int i9 = a2.f2969d[(i8 * i6) + i7];
                if (i9 != 0) {
                    if (i6 < i3) {
                        i3 = i6;
                    }
                    if (i6 > i5) {
                        i5 = i6;
                    }
                    int i10 = i7 * 32;
                    if (i10 < i2) {
                        int i11 = 0;
                        while ((i9 << (31 - i11)) == 0) {
                            i11++;
                        }
                        int i12 = i11 + i10;
                        if (i12 < i2) {
                            i2 = i12;
                        }
                    }
                    if (i10 + 31 > i4) {
                        int i13 = 31;
                        while ((i9 >>> i13) == 0) {
                            i13--;
                        }
                        int i14 = i10 + i13;
                        if (i14 > i4) {
                            i4 = i14;
                        }
                    }
                }
                i7++;
            }
        }
        int i15 = i4 - i2;
        int i16 = i5 - i3;
        int[] iArr = (i15 < 0 || i16 < 0) ? null : new int[]{i2, i3, i15, i16};
        if (iArr != null) {
            int i17 = iArr[0];
            int i18 = iArr[1];
            int i19 = iArr[2];
            int i20 = iArr[3];
            int i21 = (30 + 31) >> 5;
            int[] iArr2 = new int[(i21 * 33)];
            for (int i22 = 0; i22 < 33; i22++) {
                int i23 = (((i20 / 2) + (i22 * i20)) / 33) + i18;
                for (int i24 = 0; i24 < 30; i24++) {
                    if (a2.a((((((i22 & 1) * i19) / 2) + ((i19 / 2) + (i24 * i19))) / 30) + i17, i23)) {
                        int i25 = (i22 * i21) + (i24 >> 5);
                        iArr2[i25] = (1 << (i24 & 31)) | iArr2[i25];
                    }
                }
            }
            c cVar2 = this.f3040a;
            if (cVar2 != null) {
                byte[] bArr = new byte[144];
                for (int i26 = 0; i26 < 33; i26++) {
                    int[] iArr3 = a.d.c.t.b.a.f3041a[i26];
                    for (int i27 = 0; i27 < 30; i27++) {
                        int i28 = iArr3[i27];
                        if (i28 >= 0) {
                            if (((iArr2[(i26 * i21) + (i27 >> 5)] >>> (i27 & 31)) & 1) != 0) {
                                int i29 = i28 / 6;
                                bArr[i29] = (byte) (((byte) (1 << (5 - (i28 % 6)))) | bArr[i29]);
                            }
                        }
                    }
                }
                cVar2.a(bArr, 0, 10, 10, 0);
                byte b2 = bArr[0] & 15;
                if (b2 == 2 || b2 == 3 || b2 == 4) {
                    c cVar3 = cVar2;
                    byte[] bArr2 = bArr;
                    cVar3.a(bArr2, 20, 84, 40, 1);
                    cVar3.a(bArr2, 20, 84, 40, 2);
                    i = 94;
                } else if (b2 == 5) {
                    c cVar4 = cVar2;
                    byte[] bArr3 = bArr;
                    cVar4.a(bArr3, 20, 68, 56, 1);
                    cVar4.a(bArr3, 20, 68, 56, 2);
                    i = 78;
                } else {
                    throw f.f2869a;
                }
                byte[] bArr4 = new byte[i];
                System.arraycopy(bArr, 0, bArr4, 0, 10);
                System.arraycopy(bArr, 20, bArr4, 10, i - 10);
                a.d.c.r.e a3 = a.d.c.t.b.b.a(bArr4, b2);
                l lVar = new l(a3.f2979b, a3.f2978a, f3039b, a.d.c.a.MAXICODE);
                String str = a3.f2981d;
                if (str != null) {
                    lVar.a(m.ERROR_CORRECTION_LEVEL, str);
                }
                return lVar;
            }
            throw null;
        }
        throw i.f2874a;
    }

    public void reset() {
    }
}

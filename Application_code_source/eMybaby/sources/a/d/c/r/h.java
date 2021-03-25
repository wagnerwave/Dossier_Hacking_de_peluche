package a.d.c.r;

import a.d.c.b;
import a.d.c.g;
import a.d.c.i;
import com.tutk.IOTC.AVFrame;
import java.lang.reflect.Array;

public final class h extends b {

    /* renamed from: b  reason: collision with root package name */
    public byte[] f2985b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    public final int[] f2986c = new int[32];

    /* renamed from: d  reason: collision with root package name */
    public b f2987d;

    public h(g gVar) {
        super(gVar);
    }

    public static int c(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 <= i5) {
            int i10 = i3;
            i3 = i5;
            i5 = i10;
        }
        if (i3 - i5 > (length >> 4)) {
            int i11 = i3 - 1;
            int i12 = i11;
            int i13 = -1;
            while (i11 > i5) {
                int i14 = i11 - i5;
                int i15 = (i2 - iArr[i11]) * (i3 - i11) * i14 * i14;
                if (i15 > i13) {
                    i12 = i11;
                    i13 = i15;
                }
                i11--;
            }
            return i12 << 3;
        }
        throw i.f2874a;
    }

    public b a() {
        b bVar;
        b bVar2 = this.f2987d;
        if (bVar2 != null) {
            return bVar2;
        }
        g gVar = this.f2860a;
        if (gVar.f2870a < 40 || gVar.f2871b < 40) {
            g gVar2 = this.f2860a;
            int i = gVar2.f2870a;
            int i2 = gVar2.f2871b;
            bVar = new b(i, i2);
            d(i);
            int[] iArr = this.f2986c;
            for (int i3 = 1; i3 < 5; i3++) {
                byte[] b2 = gVar2.b((i2 * i3) / 5, this.f2985b);
                int i4 = (i << 2) / 5;
                for (int i5 = i / 5; i5 < i4; i5++) {
                    int i6 = (b2[i5] & AVFrame.FRM_STATE_UNKOWN) >> 3;
                    iArr[i6] = iArr[i6] + 1;
                }
            }
            int c2 = c(iArr);
            byte[] a2 = gVar2.a();
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i7 * i;
                for (int i9 = 0; i9 < i; i9++) {
                    if ((a2[i8 + i9] & AVFrame.FRM_STATE_UNKOWN) < c2) {
                        bVar.d(i9, i7);
                    }
                }
            }
        } else {
            byte[] a3 = gVar.a();
            int i10 = gVar.f2870a;
            int i11 = gVar.f2871b;
            int i12 = i10 >> 3;
            if ((i10 & 7) != 0) {
                i12++;
            }
            int i13 = i11 >> 3;
            if ((i11 & 7) != 0) {
                i13++;
            }
            int[] iArr2 = new int[2];
            iArr2[1] = i12;
            iArr2[0] = i13;
            int[][] iArr3 = (int[][]) Array.newInstance(int.class, iArr2);
            int i14 = 0;
            while (true) {
                int i15 = 8;
                if (i14 >= i13) {
                    break;
                }
                int i16 = i14 << 3;
                if (i16 + 8 >= i11) {
                    i16 = i11 - 8;
                }
                int i17 = 0;
                while (i17 < i12) {
                    int i18 = i17 << 3;
                    if (i18 + 8 >= i10) {
                        i18 = i10 - 8;
                    }
                    int i19 = (i16 * i10) + i18;
                    byte b3 = AVFrame.FRM_STATE_UNKOWN;
                    int i20 = 0;
                    int i21 = 0;
                    byte b4 = 0;
                    while (i20 < i15) {
                        byte b5 = b4;
                        int i22 = 0;
                        while (i22 < i15) {
                            int i23 = i16;
                            byte b6 = a3[i19 + i22] & AVFrame.FRM_STATE_UNKOWN;
                            i21 += b6;
                            if (b6 < b3) {
                                b3 = b6;
                            }
                            if (b6 > b5) {
                                b5 = b6;
                            }
                            i22++;
                            i16 = i23;
                            i15 = 8;
                        }
                        int i24 = i16;
                        i20++;
                        i19 += i10;
                        b4 = b5;
                        i15 = 8;
                    }
                    int i25 = i16;
                    int i26 = i21 >> 6;
                    if (b4 - b3 <= 24) {
                        i26 = b3 >> 1;
                        if (i14 > 0 && i17 > 0) {
                            int i27 = i14 - 1;
                            int i28 = i17 - 1;
                            int i29 = (((iArr3[i14][i28] * 2) + iArr3[i27][i17]) + iArr3[i27][i28]) >> 2;
                            if (b3 < i29) {
                                i26 = i29;
                            }
                        }
                    }
                    iArr3[i14][i17] = i26;
                    i17++;
                    i16 = i25;
                    i15 = 8;
                }
                i14++;
            }
            bVar = new b(i10, i11);
            int i30 = 0;
            while (i30 < i13) {
                int i31 = i30 << 3;
                if (i31 + 8 >= i11) {
                    i31 = i11 - 8;
                }
                int i32 = 0;
                while (i32 < i12) {
                    int i33 = i32 << 3;
                    if (i33 + 8 >= i10) {
                        i33 = i10 - 8;
                    }
                    int i34 = i32 > 1 ? i32 : 2;
                    if (i34 >= i12 - 2) {
                        i34 = i12 - 3;
                    }
                    int i35 = i30 > 1 ? i30 : 2;
                    if (i35 >= i13 - 2) {
                        i35 = i13 - 3;
                    }
                    int i36 = -2;
                    int i37 = i11;
                    int i38 = 0;
                    for (int i39 = 2; i36 <= i39; i39 = 2) {
                        int[] iArr4 = iArr3[i35 + i36];
                        i38 = iArr4[i34 - 2] + iArr4[i34 - 1] + iArr4[i34] + iArr4[i34 + 1] + iArr4[i34 + 2] + i38;
                        i36++;
                    }
                    int i40 = i38 / 25;
                    int i41 = (i31 * i10) + i33;
                    int i42 = 0;
                    while (true) {
                        if (i42 >= 8) {
                            break;
                        }
                        int i43 = 0;
                        for (int i44 = 8; i43 < i44; i44 = 8) {
                            byte[] bArr = a3;
                            if ((a3[i41 + i43] & AVFrame.FRM_STATE_UNKOWN) <= i40) {
                                bVar.d(i33 + i43, i31 + i42);
                            }
                            i43++;
                            a3 = bArr;
                        }
                        byte[] bArr2 = a3;
                        i42++;
                        i41 += i10;
                    }
                    byte[] bArr3 = a3;
                    i32++;
                    i11 = i37;
                }
                int i45 = i11;
                byte[] bArr4 = a3;
                i30++;
            }
        }
        this.f2987d = bVar;
        return this.f2987d;
    }

    public a b(int i, a aVar) {
        g gVar = this.f2860a;
        int i2 = gVar.f2870a;
        if (aVar == null || aVar.f2965b < i2) {
            aVar = new a(i2);
        } else {
            int length = aVar.f2964a.length;
            for (int i3 = 0; i3 < length; i3++) {
                aVar.f2964a[i3] = 0;
            }
        }
        d(i2);
        byte[] b2 = gVar.b(i, this.f2985b);
        int[] iArr = this.f2986c;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = (b2[i4] & AVFrame.FRM_STATE_UNKOWN) >> 3;
            iArr[i5] = iArr[i5] + 1;
        }
        int c2 = c(iArr);
        byte b3 = b2[0] & AVFrame.FRM_STATE_UNKOWN;
        int i6 = 1;
        byte b4 = b3;
        byte b5 = b2[1] & AVFrame.FRM_STATE_UNKOWN;
        while (i6 < i2 - 1) {
            int i7 = i6 + 1;
            byte b6 = b2[i7] & AVFrame.FRM_STATE_UNKOWN;
            if (((((b5 << 2) - b4) - b6) >> 1) < c2) {
                aVar.f(i6);
            }
            b4 = b5;
            i6 = i7;
            b5 = b6;
        }
        return aVar;
    }

    public final void d(int i) {
        if (this.f2985b.length < i) {
            this.f2985b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f2986c[i2] = 0;
        }
    }
}

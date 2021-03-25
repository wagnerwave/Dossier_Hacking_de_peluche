package a.d.c.r.k;

import a.d.c.i;
import a.d.c.n;
import a.d.c.r.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f2995a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2996b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2997c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2998d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2999e;
    public final int f;
    public final int g;

    public a(b bVar) {
        this.f2995a = bVar;
        int i = bVar.f2967b;
        this.f2996b = i;
        int i2 = bVar.f2966a;
        this.f2997c = i2;
        int i3 = (i2 - 30) >> 1;
        this.f2998d = i3;
        int i4 = (i2 + 30) >> 1;
        this.f2999e = i4;
        int i5 = (i - 30) >> 1;
        this.g = i5;
        int i6 = (i + 30) >> 1;
        this.f = i6;
        if (i5 < 0 || i3 < 0 || i6 >= i || i4 >= i2) {
            throw i.f2874a;
        }
    }

    public static int d(float f2) {
        return (int) (f2 + 0.5f);
    }

    public final boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f2995a.a(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f2995a.a(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public n[] b() {
        boolean z;
        int i = this.f2998d;
        int i2 = this.f2999e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            if (!z2) {
                z = false;
                break;
            }
            boolean z4 = true;
            boolean z5 = false;
            while (z4 && i2 < this.f2997c) {
                z4 = a(i3, i4, i2, false);
                if (z4) {
                    i2++;
                    z5 = true;
                }
            }
            if (i2 >= this.f2997c) {
                break;
            }
            boolean z6 = true;
            while (z6 && i4 < this.f2996b) {
                z6 = a(i, i2, i4, true);
                if (z6) {
                    i4++;
                    z5 = true;
                }
            }
            if (i4 >= this.f2996b) {
                break;
            }
            boolean z7 = true;
            while (z7 && i >= 0) {
                z7 = a(i3, i4, i, false);
                if (z7) {
                    i--;
                    z5 = true;
                }
            }
            if (i < 0) {
                break;
            }
            z2 = z5;
            boolean z8 = true;
            while (z8 && i3 >= 0) {
                z8 = a(i, i2, i3, true);
                if (z8) {
                    i3--;
                    z2 = true;
                }
            }
            if (i3 < 0) {
                break;
            } else if (z2) {
                z3 = true;
            }
        }
        z = true;
        if (z || !z3) {
            throw i.f2874a;
        }
        int i5 = i2 - i;
        n nVar = null;
        n nVar2 = null;
        for (int i6 = 1; i6 < i5; i6++) {
            nVar2 = c((float) i, (float) (i4 - i6), (float) (i + i6), (float) i4);
            if (nVar2 != null) {
                break;
            }
        }
        if (nVar2 != null) {
            n nVar3 = null;
            for (int i7 = 1; i7 < i5; i7++) {
                nVar3 = c((float) i, (float) (i3 + i7), (float) (i + i7), (float) i3);
                if (nVar3 != null) {
                    break;
                }
            }
            if (nVar3 != null) {
                n nVar4 = null;
                for (int i8 = 1; i8 < i5; i8++) {
                    nVar4 = c((float) i2, (float) (i3 + i8), (float) (i2 - i8), (float) i3);
                    if (nVar4 != null) {
                        break;
                    }
                }
                if (nVar4 != null) {
                    for (int i9 = 1; i9 < i5; i9++) {
                        nVar = c((float) i2, (float) (i4 - i9), (float) (i2 - i9), (float) i4);
                        if (nVar != null) {
                            break;
                        }
                    }
                    if (nVar != null) {
                        float f2 = nVar.f2885a;
                        float f3 = nVar.f2886b;
                        float f4 = nVar2.f2885a;
                        float f5 = nVar2.f2886b;
                        float f6 = nVar4.f2885a;
                        float f7 = nVar4.f2886b;
                        float f8 = nVar3.f2885a;
                        float f9 = nVar3.f2886b;
                        if (f2 < ((float) (this.f2997c / 2))) {
                            return new n[]{new n(f8 - 1.0f, f9 + 1.0f), new n(f4 + 1.0f, f5 + 1.0f), new n(f6 - 1.0f, f7 - 1.0f), new n(f2 + 1.0f, f3 - 1.0f)};
                        }
                        return new n[]{new n(f8 + 1.0f, f9 + 1.0f), new n(f4 + 1.0f, f5 - 1.0f), new n(f6 - 1.0f, f7 + 1.0f), new n(f2 - 1.0f, f3 - 1.0f)};
                    }
                    throw i.f2874a;
                }
                throw i.f2874a;
            }
            throw i.f2874a;
        }
        throw i.f2874a;
    }

    public final n c(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        int d2 = d((float) Math.sqrt((double) ((f7 * f7) + (f6 * f6))));
        float f8 = (float) d2;
        float f9 = (f4 - f2) / f8;
        float f10 = (f5 - f3) / f8;
        for (int i = 0; i < d2; i++) {
            float f11 = (float) i;
            int d3 = d((f11 * f9) + f2);
            int d4 = d((f11 * f10) + f3);
            if (this.f2995a.a(d3, d4)) {
                return new n((float) d3, (float) d4);
            }
        }
        return null;
    }

    public a(b bVar, int i, int i2, int i3) {
        this.f2995a = bVar;
        int i4 = bVar.f2967b;
        this.f2996b = i4;
        int i5 = bVar.f2966a;
        this.f2997c = i5;
        int i6 = i >> 1;
        int i7 = i2 - i6;
        this.f2998d = i7;
        int i8 = i2 + i6;
        this.f2999e = i8;
        int i9 = i3 - i6;
        this.g = i9;
        int i10 = i3 + i6;
        this.f = i10;
        if (i9 < 0 || i7 < 0 || i10 >= i4 || i8 >= i5) {
            throw i.f2874a;
        }
    }
}

package a.d.c.p.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final a.d.c.r.b f2900a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2901b;

    /* renamed from: c  reason: collision with root package name */
    public int f2902c;

    /* renamed from: d  reason: collision with root package name */
    public int f2903d;

    /* renamed from: e  reason: collision with root package name */
    public int f2904e;
    public int f;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f2905a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2906b;

        public b(int i, int i2, C0070a aVar) {
            this.f2905a = i;
            this.f2906b = i2;
        }
    }

    public a(a.d.c.r.b bVar) {
        this.f2900a = bVar;
    }

    public static float a(b bVar, b bVar2) {
        int i = bVar.f2905a;
        int i2 = bVar2.f2905a;
        int i3 = i - i2;
        int i4 = bVar.f2906b;
        int i5 = bVar2.f2906b;
        return (float) Math.sqrt((double) (((i4 - i5) * (i4 - i5)) + ((i - i2) * i3)));
    }

    public static int e(float f2) {
        return (int) (f2 + 0.5f);
    }

    public final int b(b bVar, b bVar2) {
        float a2 = a(bVar, bVar2);
        int i = bVar2.f2905a;
        int i2 = bVar.f2905a;
        float f2 = ((float) (i - i2)) / a2;
        int i3 = bVar2.f2906b;
        int i4 = bVar.f2906b;
        float f3 = ((float) (i3 - i4)) / a2;
        float f4 = (float) i2;
        float f5 = (float) i4;
        boolean a3 = this.f2900a.a(i2, i4);
        int i5 = 0;
        for (int i6 = 0; ((float) i6) < a2; i6++) {
            f4 += f2;
            f5 += f3;
            if (this.f2900a.a(e(f4), e(f5)) != a3) {
                i5++;
            }
        }
        double d2 = (double) (((float) i5) / a2);
        if (d2 <= 0.1d || d2 >= 0.9d) {
            return d2 <= 0.1d ? a3 ? 1 : -1 : a3 ? -1 : 1;
        }
        return 0;
    }

    public final b c(b bVar, boolean z, int i, int i2) {
        int i3 = bVar.f2905a + i;
        int i4 = bVar.f2906b;
        while (true) {
            i4 += i2;
            if (!d(i3, i4) || this.f2900a.a(i3, i4) != z) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
            } else {
                i3 += i;
            }
        }
        int i52 = i3 - i;
        int i62 = i4 - i2;
        while (d(i52, i62) && this.f2900a.a(i52, i62) == z) {
            i52 += i;
        }
        int i7 = i52 - i;
        while (d(i7, i62) && this.f2900a.a(i7, i62) == z) {
            i62 += i2;
        }
        return new b(i7, i62 - i2, (C0070a) null);
    }

    public final boolean d(int i, int i2) {
        if (i >= 0) {
            a.d.c.r.b bVar = this.f2900a;
            return i < bVar.f2966a && i2 > 0 && i2 < bVar.f2967b;
        }
    }

    public final boolean[] f(b bVar, b bVar2, int i) {
        boolean[] zArr = new boolean[i];
        float a2 = a(bVar, bVar2);
        float f2 = a2 / ((float) (i - 1));
        int i2 = bVar2.f2905a;
        int i3 = bVar.f2905a;
        float f3 = (((float) (i2 - i3)) * f2) / a2;
        int i4 = bVar2.f2906b;
        int i5 = bVar.f2906b;
        float f4 = (f2 * ((float) (i4 - i5))) / a2;
        float f5 = (float) i3;
        float f6 = (float) i5;
        for (int i6 = 0; i6 < i; i6++) {
            zArr[i6] = this.f2900a.a(e(f5), e(f6));
            f5 += f3;
            f6 += f4;
        }
        return zArr;
    }
}

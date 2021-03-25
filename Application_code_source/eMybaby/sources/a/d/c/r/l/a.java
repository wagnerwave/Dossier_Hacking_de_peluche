package a.d.c.r.l;

public final class a {
    public static final a h = new a(4201, 4096);
    public static final a i = new a(1033, 1024);
    public static final a j = new a(67, 64);
    public static final a k = new a(19, 16);
    public static final a l = new a(285, 256);
    public static final a m;
    public static final a n;
    public static final a o = j;

    /* renamed from: a  reason: collision with root package name */
    public int[] f3000a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f3001b;

    /* renamed from: c  reason: collision with root package name */
    public b f3002c;

    /* renamed from: d  reason: collision with root package name */
    public b f3003d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3004e;
    public final int f;
    public boolean g = false;

    static {
        a aVar = new a(301, 256);
        m = aVar;
        n = aVar;
    }

    public a(int i2, int i3) {
        this.f = i2;
        this.f3004e = i3;
        if (i3 <= 0) {
            d();
        }
    }

    public static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    public b b(int i2, int i3) {
        c();
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.f3002c;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new b(this, iArr);
        }
    }

    public final void c() {
        if (!this.g) {
            d();
        }
    }

    public final void d() {
        int i2 = this.f3004e;
        this.f3000a = new int[i2];
        this.f3001b = new int[i2];
        int i3 = 0;
        int i4 = 1;
        while (true) {
            int i5 = this.f3004e;
            if (i3 >= i5) {
                break;
            }
            this.f3000a[i3] = i4;
            i4 <<= 1;
            if (i4 >= i5) {
                i4 = (i4 ^ this.f) & (i5 - 1);
            }
            i3++;
        }
        for (int i6 = 0; i6 < this.f3004e - 1; i6++) {
            this.f3001b[this.f3000a[i6]] = i6;
        }
        this.f3002c = new b(this, new int[]{0});
        this.f3003d = new b(this, new int[]{1});
        this.g = true;
    }

    public int e(int i2) {
        c();
        if (i2 != 0) {
            return this.f3000a[(this.f3004e - this.f3001b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int f(int i2, int i3) {
        int i4;
        c();
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        if (i2 < 0 || i3 < 0 || i2 >= (i4 = this.f3004e) || i3 >= i4) {
            i2++;
        }
        int[] iArr = this.f3001b;
        int i5 = iArr[i2] + iArr[i3];
        int[] iArr2 = this.f3000a;
        int i6 = this.f3004e;
        return iArr2[(i5 / i6) + (i5 % i6)];
    }
}

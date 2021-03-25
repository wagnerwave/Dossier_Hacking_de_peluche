package a.d.c.q.a;

import a.a.a.a.a;
import a.d.c.g;

public final class j extends g {

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f2942c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2943d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2944e;
    public final int f;
    public final int g;

    public j(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f2942c = bArr;
        this.f2943d = i;
        this.f2944e = i2;
        this.f = i3;
        this.g = i4;
        if (z) {
            int i7 = (i4 * i) + i3;
            int i8 = 0;
            while (i8 < i6) {
                int i9 = (i5 / 2) + i7;
                int i10 = (i7 + i5) - 1;
                int i11 = i7;
                while (i11 < i9) {
                    byte b2 = bArr[i11];
                    bArr[i11] = bArr[i10];
                    bArr[i10] = b2;
                    i11++;
                    i10--;
                }
                i8++;
                i7 += this.f2943d;
            }
        }
    }

    public byte[] a() {
        int i = this.f2870a;
        int i2 = this.f2871b;
        if (i == this.f2943d && i2 == this.f2944e) {
            return this.f2942c;
        }
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = this.g;
        int i5 = this.f2943d;
        int i6 = (i4 * i5) + this.f;
        if (i == i5) {
            System.arraycopy(this.f2942c, i6, bArr, 0, i3);
            return bArr;
        }
        byte[] bArr2 = this.f2942c;
        for (int i7 = 0; i7 < i2; i7++) {
            System.arraycopy(bArr2, i6, bArr, i7 * i, i);
            i6 += this.f2943d;
        }
        return bArr;
    }

    public byte[] b(int i, byte[] bArr) {
        if (i < 0 || i >= this.f2871b) {
            throw new IllegalArgumentException(a.h("Requested row is outside the image: ", i));
        }
        int i2 = this.f2870a;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.f2942c, ((i + this.g) * this.f2943d) + this.f, bArr, 0, i2);
        return bArr;
    }
}

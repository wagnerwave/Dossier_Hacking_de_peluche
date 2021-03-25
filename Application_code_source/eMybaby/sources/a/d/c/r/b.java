package a.d.c.r;

import com.tuya.sdk.timer.bean.DpTimerBean;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f2966a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2967b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2968c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f2969d;

    public b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f2966a = i;
        this.f2967b = i2;
        int i3 = (i + 31) >> 5;
        this.f2968c = i3;
        this.f2969d = new int[(i3 * i2)];
    }

    public boolean a(int i, int i2) {
        return ((this.f2969d[(i2 * this.f2968c) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public int[] b() {
        int length = this.f2969d.length - 1;
        while (length >= 0 && this.f2969d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.f2968c;
        int i2 = length / i;
        int i3 = (length % i) << 5;
        int i4 = 31;
        while ((this.f2969d[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int[] c() {
        int i = 0;
        while (true) {
            int[] iArr = this.f2969d;
            if (i >= iArr.length || iArr[i] != 0) {
                int[] iArr2 = this.f2969d;
            } else {
                i++;
            }
        }
        int[] iArr22 = this.f2969d;
        if (i == iArr22.length) {
            return null;
        }
        int i2 = this.f2968c;
        int i3 = i / i2;
        int i4 = (i % i2) << 5;
        int i5 = iArr22[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public void d(int i, int i2) {
        int i3 = (i2 * this.f2968c) + (i >> 5);
        int[] iArr = this.f2969d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void e(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f2967b || i5 > this.f2966a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f2968c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f2969d;
                    int i9 = (i8 >> 5) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2966a != bVar.f2966a || this.f2967b != bVar.f2967b || this.f2968c != bVar.f2968c || this.f2969d.length != bVar.f2969d.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f2969d;
            if (i >= iArr.length) {
                return true;
            }
            if (iArr[i] != bVar.f2969d[i]) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        int i = this.f2966a;
        int i2 = (((((i * 31) + i) * 31) + this.f2967b) * 31) + this.f2968c;
        for (int i3 : this.f2969d) {
            i2 = (i2 * 31) + i3;
        }
        return i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f2966a + 1) * this.f2967b);
        for (int i = 0; i < this.f2967b; i++) {
            for (int i2 = 0; i2 < this.f2966a; i2++) {
                sb.append(a(i2, i) ? "X " : DpTimerBean.FILL);
            }
            sb.append(10);
        }
        return sb.toString();
    }
}

package a.d.c.r;

import com.tutk.IOTC.AVFrame;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2970a;

    /* renamed from: b  reason: collision with root package name */
    public int f2971b;

    /* renamed from: c  reason: collision with root package name */
    public int f2972c;

    public c(byte[] bArr) {
        this.f2970a = bArr;
    }

    public int a() {
        return ((this.f2970a.length - this.f2971b) * 8) - this.f2972c;
    }

    public int b(int i) {
        if (i < 1 || i > 32) {
            throw new IllegalArgumentException();
        }
        int i2 = this.f2972c;
        byte b2 = 0;
        if (i2 > 0) {
            int i3 = 8 - i2;
            int i4 = i < i3 ? i : i3;
            int i5 = i3 - i4;
            byte[] bArr = this.f2970a;
            int i6 = this.f2971b;
            int i7 = (((255 >> (8 - i4)) << i5) & bArr[i6]) >> i5;
            i -= i4;
            int i8 = this.f2972c + i4;
            this.f2972c = i8;
            if (i8 == 8) {
                this.f2972c = 0;
                this.f2971b = i6 + 1;
            }
            b2 = i7;
        }
        if (i <= 0) {
            return b2;
        }
        while (i >= 8) {
            int i9 = b2 << 8;
            byte[] bArr2 = this.f2970a;
            int i10 = this.f2971b;
            b2 = (bArr2[i10] & AVFrame.FRM_STATE_UNKOWN) | i9;
            this.f2971b = i10 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return b2;
        }
        int i11 = 8 - i;
        int i12 = (b2 << i) | ((((255 >> i11) << i11) & this.f2970a[this.f2971b]) >> i11);
        this.f2972c += i;
        return i12;
    }
}

package a.f.a.d;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3321a = new byte[4096];

    /* renamed from: b  reason: collision with root package name */
    public int f3322b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f3323c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f3324d = 0;

    public synchronized void a(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f3321a[this.f3322b] = bArr[i + i4];
            int i5 = this.f3322b + 1;
            this.f3322b = i5;
            if (i5 >= 4096) {
                this.f3322b = 0;
            }
            if (this.f3324d <= 4096) {
                this.f3324d++;
            } else {
                int i6 = this.f3323c + 1;
                this.f3323c = i6;
                if (i6 >= 4096) {
                    this.f3323c = 0;
                }
            }
        }
    }

    public final byte b(int i) {
        return this.f3321a[i % 4096];
    }
}

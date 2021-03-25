package a.d.a.a.h.g;

public final class b5 extends d5 {

    /* renamed from: e  reason: collision with root package name */
    public final int f1615e;
    public final int f;

    public b5(byte[] bArr, int i, int i2) {
        super(bArr);
        w4.n(i, i + i2, bArr.length);
        this.f1615e = i;
        this.f = i2;
    }

    public final byte c(int i) {
        int i2 = this.f;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.f1665d[this.f1615e + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    public final int d() {
        return this.f;
    }

    public final byte m(int i) {
        return this.f1665d[this.f1615e + i];
    }

    public final int q() {
        return this.f1615e;
    }
}

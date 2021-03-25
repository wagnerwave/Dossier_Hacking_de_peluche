package a.d.a.a.h.g;

public final class c5 {

    /* renamed from: a  reason: collision with root package name */
    public final i5 f1642a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f1643b;

    public c5(int i, y4 y4Var) {
        byte[] bArr = new byte[i];
        this.f1643b = bArr;
        this.f1642a = i5.d(bArr);
    }

    public final w4 a() {
        if (this.f1642a.a() == 0) {
            return new d5(this.f1643b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }
}

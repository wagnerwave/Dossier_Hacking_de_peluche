package a.d.a.a.h.g;

public class d5 extends w4 {

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f1665d;

    public d5(byte[] bArr) {
        if (bArr != null) {
            this.f1665d = bArr;
            return;
        }
        throw null;
    }

    public byte c(int i) {
        return this.f1665d[i];
    }

    public int d() {
        return this.f1665d.length;
    }

    public final w4 e(int i, int i2) {
        int n = w4.n(0, i2, d());
        return n == 0 ? w4.f2000b : new b5(this.f1665d, q(), n);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w4) || d() != ((w4) obj).d()) {
            return false;
        }
        if (d() == 0) {
            return true;
        }
        if (!(obj instanceof d5)) {
            return obj.equals(this);
        }
        d5 d5Var = (d5) obj;
        int i = this.f2002a;
        int i2 = d5Var.f2002a;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int d2 = d();
        if (d2 > d5Var.d()) {
            int d3 = d();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(d2);
            sb.append(d3);
            throw new IllegalArgumentException(sb.toString());
        } else if (d2 <= d5Var.d()) {
            byte[] bArr = this.f1665d;
            byte[] bArr2 = d5Var.f1665d;
            int q = q() + d2;
            int q2 = q();
            int q3 = d5Var.q();
            while (q2 < q) {
                if (bArr[q2] != bArr2[q3]) {
                    return false;
                }
                q2++;
                q3++;
            }
            return true;
        } else {
            int d4 = d5Var.d();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(d2);
            sb2.append(", ");
            sb2.append(d4);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public byte m(int i) {
        return this.f1665d[i];
    }

    public int q() {
        return 0;
    }
}

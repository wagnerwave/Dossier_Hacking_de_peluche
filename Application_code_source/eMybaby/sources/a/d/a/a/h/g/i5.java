package a.d.a.a.h.g;

import com.tuya.smart.android.common.utils.Base64;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class i5 extends x4 {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f1736b = Logger.getLogger(i5.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f1737c = n8.h;

    /* renamed from: a  reason: collision with root package name */
    public k5 f1738a;

    public static class a extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.i5.a.<init>(java.lang.String, java.lang.Throwable):void");
        }

        public a(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public static class b extends i5 {

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f1739d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1740e;
        public int f;

        public b(byte[] bArr, int i) {
            super((h5) null);
            if ((i | 0 | (bArr.length - i)) >= 0) {
                this.f1739d = bArr;
                this.f = 0;
                this.f1740e = i;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i)}));
        }

        public final void W(int i, int i2) {
            o((i << 3) | i2);
        }

        public final void X(int i, w4 w4Var) {
            o((i << 3) | 2);
            Y(w4Var);
        }

        public final void Y(w4 w4Var) {
            o(w4Var.d());
            d5 d5Var = (d5) w4Var;
            c0(d5Var.f1665d, d5Var.q(), d5Var.d());
        }

        public final void Z(i7 i7Var) {
            o(i7Var.c());
            i7Var.e(this);
        }

        public final int a() {
            return this.f1740e - this.f;
        }

        public final void a0(String str) {
            int i = this.f;
            try {
                int I = i5.I(str.length() * 3);
                int I2 = i5.I(str.length());
                if (I2 == I) {
                    int i2 = i + I2;
                    this.f = i2;
                    int b2 = q8.f1900a.b(str, this.f1739d, i2, a());
                    this.f = i;
                    o((b2 - i) - I2);
                    this.f = b2;
                    return;
                }
                o(q8.c(str));
                this.f = q8.f1900a.b(str, this.f1739d, this.f, a());
            } catch (s8 e2) {
                this.f = i;
                i5.f1736b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", e2);
                byte[] bytes = str.getBytes(a6.f1596a);
                try {
                    o(bytes.length);
                    c0(bytes, 0, bytes.length);
                } catch (IndexOutOfBoundsException e3) {
                    throw new a(e3);
                } catch (a e4) {
                    throw e4;
                }
            } catch (IndexOutOfBoundsException e5) {
                throw new a(e5);
            }
        }

        public final void b0(int i, int i2) {
            o((i << 3) | 0);
            o(i2);
        }

        public final void c0(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f1739d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.f1740e), Integer.valueOf(i2)}), e2);
            }
        }

        public final void e(byte b2) {
            try {
                byte[] bArr = this.f1739d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.f1740e), 1}), e2);
            }
        }

        public final void f(int i) {
            if (i >= 0) {
                o(i);
            } else {
                g((long) i);
            }
        }

        public final void g(long j) {
            if (!i5.f1737c || a() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f1739d;
                    int i = this.f;
                    this.f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f1739d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.f1740e), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f1739d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    n8.g(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f1739d;
                int i4 = this.f;
                this.f = i4 + 1;
                n8.g(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void o(int i) {
            if (!i5.f1737c || t4.a() || a() < 5) {
                while ((i & Base64.SIGN) != 0) {
                    byte[] bArr = this.f1739d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f1739d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.f1740e), 1}), e2);
                }
            } else if ((i & Base64.SIGN) == 0) {
                byte[] bArr3 = this.f1739d;
                int i4 = this.f;
                this.f = i4 + 1;
                n8.g(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.f1739d;
                int i5 = this.f;
                this.f = i5 + 1;
                n8.g(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & Base64.SIGN) == 0) {
                    byte[] bArr5 = this.f1739d;
                    int i7 = this.f;
                    this.f = i7 + 1;
                    n8.g(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.f1739d;
                int i8 = this.f;
                this.f = i8 + 1;
                n8.g(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & Base64.SIGN) == 0) {
                    byte[] bArr7 = this.f1739d;
                    int i10 = this.f;
                    this.f = i10 + 1;
                    n8.g(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.f1739d;
                int i11 = this.f;
                this.f = i11 + 1;
                n8.g(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & Base64.SIGN) == 0) {
                    byte[] bArr9 = this.f1739d;
                    int i13 = this.f;
                    this.f = i13 + 1;
                    n8.g(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.f1739d;
                int i14 = this.f;
                this.f = i14 + 1;
                n8.g(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.f1739d;
                int i15 = this.f;
                this.f = i15 + 1;
                n8.g(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void p(int i, int i2) {
            o((i << 3) | 0);
            if (i2 >= 0) {
                o(i2);
            } else {
                g((long) i2);
            }
        }

        public final void x(long j) {
            try {
                byte[] bArr = this.f1739d;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.f1739d;
                int i3 = i2 + 1;
                this.f = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f1739d;
                int i4 = i3 + 1;
                this.f = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f1739d;
                int i5 = i4 + 1;
                this.f = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f1739d;
                int i6 = i5 + 1;
                this.f = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f1739d;
                int i7 = i6 + 1;
                this.f = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f1739d;
                int i8 = i7 + 1;
                this.f = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f1739d;
                this.f = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.f1740e), 1}), e2);
            }
        }

        public final void z(int i) {
            try {
                byte[] bArr = this.f1739d;
                int i2 = this.f;
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.f1739d;
                int i4 = i3 + 1;
                this.f = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.f1739d;
                int i5 = i4 + 1;
                this.f = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.f1739d;
                this.f = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.f1740e), 1}), e2);
            }
        }
    }

    public i5() {
    }

    public i5(h5 h5Var) {
    }

    public static int A(int i) {
        return I(i << 3);
    }

    public static int B(int i, long j) {
        return C(j) + I(i << 3);
    }

    public static int C(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int D(int i) {
        if (i >= 0) {
            return I(i);
        }
        return 10;
    }

    public static int E(int i, int i2) {
        return D(i2) + I(i << 3);
    }

    public static int F(int i, long j) {
        return C(Q(j)) + I(i << 3);
    }

    public static int G(long j) {
        return C(Q(j));
    }

    public static int H() {
        return 8;
    }

    public static int I(int i) {
        if ((i & Base64.SIGN) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int J(int i, int i2) {
        return I(i2) + I(i << 3);
    }

    public static int K(int i) {
        return I(i << 3) + 8;
    }

    public static int L() {
        return 8;
    }

    public static int M(int i) {
        return I(V(i));
    }

    public static int N(int i, int i2) {
        return I(V(i2)) + I(i << 3);
    }

    public static int O(int i) {
        return I(i << 3) + 8;
    }

    public static int P() {
        return 4;
    }

    public static long Q(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int R(int i) {
        return I(i << 3) + 4;
    }

    public static int S() {
        return 4;
    }

    public static int T(int i) {
        return I(i << 3) + 4;
    }

    public static int U(int i, int i2) {
        return D(i2) + I(i << 3);
    }

    public static int V(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int b(n6 n6Var) {
        int a2 = n6Var.a();
        return I(a2) + a2;
    }

    public static int c(i7 i7Var, v7 v7Var) {
        o4 o4Var = (o4) i7Var;
        int i = ((y5) o4Var).zzc;
        if (i == -1) {
            i = v7Var.f(o4Var);
            ((y5) o4Var).zzc = i;
        }
        return I(i) + i;
    }

    public static i5 d(byte[] bArr) {
        return new b(bArr, bArr.length);
    }

    public static int h() {
        return 4;
    }

    public static int i(int i) {
        return I(i << 3) + 4;
    }

    public static int j(int i, String str) {
        return m(str) + I(i << 3);
    }

    public static int k(w4 w4Var) {
        int d2 = w4Var.d();
        return I(d2) + d2;
    }

    public static int l(i7 i7Var) {
        int c2 = i7Var.c();
        return I(c2) + c2;
    }

    public static int m(String str) {
        int i;
        try {
            i = q8.c(str);
        } catch (s8 unused) {
            i = str.getBytes(a6.f1596a).length;
        }
        return I(i) + i;
    }

    public static int n(byte[] bArr) {
        int length = bArr.length;
        return I(length) + length;
    }

    public static int q() {
        return 8;
    }

    public static int r(int i) {
        return I(i << 3) + 8;
    }

    public static int s() {
        return 1;
    }

    public static int t(int i) {
        return I(i << 3) + 1;
    }

    public static int u(int i, w4 w4Var) {
        int I = I(i << 3);
        int d2 = w4Var.d();
        return I(d2) + d2 + I;
    }

    @Deprecated
    public static int v(int i, i7 i7Var, v7 v7Var) {
        int I = I(i << 3) << 1;
        o4 o4Var = (o4) i7Var;
        int i2 = ((y5) o4Var).zzc;
        if (i2 == -1) {
            i2 = v7Var.f(o4Var);
            ((y5) o4Var).zzc = i2;
        }
        return I + i2;
    }

    @Deprecated
    public static int w(i7 i7Var) {
        return i7Var.c();
    }

    public static int y(int i, long j) {
        return C(j) + I(i << 3);
    }

    public abstract int a();

    public abstract void e(byte b2);

    public abstract void f(int i);

    public abstract void g(long j);

    public abstract void o(int i);

    public abstract void p(int i, int i2);

    public abstract void x(long j);

    public abstract void z(int i);
}

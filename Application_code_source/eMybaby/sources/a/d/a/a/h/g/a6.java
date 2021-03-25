package a.d.a.a.h.g;

import a.d.a.a.h.g.y5;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class a6 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f1596a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f1597b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f1597b = bArr;
        ByteBuffer.wrap(bArr);
        int length = f1597b.length;
        int i = length + 0;
        if (length < 0) {
            throw i6.b();
        } else if ((0 - 0) + length <= Integer.MAX_VALUE) {
            int i2 = i + 0 + 0;
        } else {
            try {
                throw i6.a();
            } catch (i6 e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    public static int a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static int b(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    public static <T> T d(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static Object e(Object obj, Object obj2) {
        i7 i7Var = (i7) obj2;
        q4 q4Var = (q4) ((i7) obj).d();
        if (q4Var != null) {
            y5.b bVar = (y5.b) q4Var;
            if (bVar.f2046a.getClass().isInstance(i7Var)) {
                bVar.i((y5) ((o4) i7Var));
                return bVar.l();
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        throw null;
    }

    public static <T> T f(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static String g(byte[] bArr) {
        return new String(bArr, f1596a);
    }

    public static int h(byte[] bArr) {
        int length = bArr.length;
        int i = length;
        for (int i2 = 0; i2 < 0 + length; i2++) {
            i = (i * 31) + bArr[i2];
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}

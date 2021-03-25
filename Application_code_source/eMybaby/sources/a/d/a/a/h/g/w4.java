package a.d.a.a.h.g;

import a.c.a.f.b;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

public abstract class w4 implements Serializable, Iterable<Byte> {

    /* renamed from: b  reason: collision with root package name */
    public static final w4 f2000b = new d5(a6.f1597b);

    /* renamed from: c  reason: collision with root package name */
    public static final a5 f2001c = (t4.a() ? new e5((y4) null) : new z4((y4) null));

    /* renamed from: a  reason: collision with root package name */
    public int f2002a = 0;

    public static w4 h(String str) {
        return new d5(str.getBytes(a6.f1596a));
    }

    public static w4 l(byte[] bArr, int i, int i2) {
        n(i, i + i2, bArr.length);
        return new d5(f2001c.a(bArr, i, i2));
    }

    public static int n(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public static c5 p(int i) {
        return new c5(i, (y4) null);
    }

    public abstract byte c(int i);

    public abstract int d();

    public abstract w4 e(int i, int i2);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f2002a;
        if (i == 0) {
            int d2 = d();
            d5 d5Var = (d5) this;
            i = a6.a(d2, d5Var.f1665d, d5Var.q(), d2);
            if (i == 0) {
                i = 1;
            }
            this.f2002a = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new y4(this);
    }

    public abstract byte m(int i);

    public final String o() {
        Charset charset = a6.f1596a;
        if (d() == 0) {
            return "";
        }
        d5 d5Var = (d5) this;
        return new String(d5Var.f1665d, d5Var.q(), d5Var.d(), charset);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(d());
        objArr[2] = d() <= 50 ? b.a1(this) : String.valueOf(b.a1(e(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}

package a.d.a.a.h.g;

import a.c.a.d.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class d4<E> extends u3<E> {
    public static final d4<Object> h = new d4(new Object[0], 0, (Object[]) null, 0, 0);

    /* renamed from: c  reason: collision with root package name */
    public final transient Object[] f1662c;

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f1663d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f1664e;
    public final transient int f;
    public final transient int g;

    public d4(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f1662c = objArr;
        this.f1663d = objArr2;
        this.f1664e = i2;
        this.f = i;
        this.g = i3;
    }

    public final boolean a() {
        return true;
    }

    public final int c(Object[] objArr, int i) {
        System.arraycopy(this.f1662c, 0, objArr, i, this.g);
        return i + this.g;
    }

    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.f1663d;
        if (obj == null || objArr == null) {
            return false;
        }
        int t = a.t(obj);
        while (true) {
            int i = t & this.f1664e;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            t = i + 1;
        }
    }

    /* renamed from: d */
    public final e4<E> iterator() {
        return (e4) o().iterator();
    }

    public final Object[] e() {
        return this.f1662c;
    }

    public final int h() {
        return 0;
    }

    public final int hashCode() {
        return this.f;
    }

    public final int l() {
        return this.g;
    }

    public final boolean m() {
        return false;
    }

    public final m3<E> p() {
        return m3.q(this.f1662c, this.g);
    }

    public final int size() {
        return this.g;
    }
}

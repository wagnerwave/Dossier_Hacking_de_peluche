package a.d.a.a.h.g;

public final class f4<E> extends u3<E> {

    /* renamed from: c  reason: collision with root package name */
    public final transient E f1697c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f1698d;

    public f4(E e2) {
        if (e2 != null) {
            this.f1697c = e2;
            return;
        }
        throw null;
    }

    public f4(E e2, int i) {
        this.f1697c = e2;
        this.f1698d = i;
    }

    public final boolean a() {
        return this.f1698d != 0;
    }

    public final int c(Object[] objArr, int i) {
        objArr[i] = this.f1697c;
        return i + 1;
    }

    public final boolean contains(Object obj) {
        return this.f1697c.equals(obj);
    }

    /* renamed from: d */
    public final e4<E> iterator() {
        return new v3(this.f1697c);
    }

    public final int hashCode() {
        int i = this.f1698d;
        if (i != 0) {
            return i;
        }
        int hashCode = this.f1697c.hashCode();
        this.f1698d = hashCode;
        return hashCode;
    }

    public final boolean m() {
        return false;
    }

    public final m3<E> p() {
        return m3.o(this.f1697c);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.f1697c.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}

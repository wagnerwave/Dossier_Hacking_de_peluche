package a.d.a.a.h.g;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class w6 extends r4<Long> implements g6, s7, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final w6 f2005d;

    /* renamed from: b  reason: collision with root package name */
    public long[] f2006b;

    /* renamed from: c  reason: collision with root package name */
    public int f2007c;

    static {
        w6 w6Var = new w6(new long[0], 0);
        f2005d = w6Var;
        w6Var.f1915a = false;
    }

    public w6() {
        this.f2006b = new long[10];
        this.f2007c = 0;
    }

    public w6(long[] jArr, int i) {
        this.f2006b = jArr;
        this.f2007c = i;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        c();
        if (i < 0 || i > (i2 = this.f2007c)) {
            throw new IndexOutOfBoundsException(m(i));
        }
        long[] jArr = this.f2006b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f2006b, i, jArr2, i + 1, this.f2007c - i);
            this.f2006b = jArr2;
        }
        this.f2006b[i] = longValue;
        this.f2007c++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        d(((Long) obj).longValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        a6.d(collection);
        if (!(collection instanceof w6)) {
            return super.addAll(collection);
        }
        w6 w6Var = (w6) collection;
        int i = w6Var.f2007c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f2007c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f2006b;
            if (i3 > jArr.length) {
                this.f2006b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(w6Var.f2006b, 0, this.f2006b, this.f2007c, w6Var.f2007c);
            this.f2007c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(long j) {
        c();
        int i = this.f2007c;
        long[] jArr = this.f2006b;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f2006b = jArr2;
        }
        long[] jArr3 = this.f2006b;
        int i2 = this.f2007c;
        this.f2007c = i2 + 1;
        jArr3[i2] = j;
    }

    public final long e(int i) {
        l(i);
        return this.f2006b[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w6)) {
            return super.equals(obj);
        }
        w6 w6Var = (w6) obj;
        if (this.f2007c != w6Var.f2007c) {
            return false;
        }
        long[] jArr = w6Var.f2006b;
        for (int i = 0; i < this.f2007c; i++) {
            if (this.f2006b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i) {
        l(i);
        return Long.valueOf(this.f2006b[i]);
    }

    /* renamed from: h */
    public final g6 f(int i) {
        if (i >= this.f2007c) {
            return new w6(Arrays.copyOf(this.f2006b, i), this.f2007c);
        }
        throw new IllegalArgumentException();
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f2007c; i2++) {
            i = (i * 31) + a6.b(this.f2006b[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i = this.f2007c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f2006b[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    public final void l(int i) {
        if (i < 0 || i >= this.f2007c) {
            throw new IndexOutOfBoundsException(m(i));
        }
    }

    public final String m(int i) {
        int i2 = this.f2007c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object remove(int i) {
        c();
        l(i);
        long[] jArr = this.f2006b;
        long j = jArr[i];
        int i2 = this.f2007c;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f2007c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.f2007c; i++) {
            if (obj.equals(Long.valueOf(this.f2006b[i]))) {
                long[] jArr = this.f2006b;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f2007c - i) - 1);
                this.f2007c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        c();
        if (i2 >= i) {
            long[] jArr = this.f2006b;
            System.arraycopy(jArr, i2, jArr, i, this.f2007c - i2);
            this.f2007c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        l(i);
        long[] jArr = this.f2006b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.f2007c;
    }
}

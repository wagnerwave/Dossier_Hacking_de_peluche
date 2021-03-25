package a.d.a.a.h.g;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class b6 extends r4<Integer> implements d6, s7, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final b6 f1616d;

    /* renamed from: b  reason: collision with root package name */
    public int[] f1617b;

    /* renamed from: c  reason: collision with root package name */
    public int f1618c;

    static {
        b6 b6Var = new b6(new int[0], 0);
        f1616d = b6Var;
        b6Var.f1915a = false;
    }

    public b6() {
        this.f1617b = new int[10];
        this.f1618c = 0;
    }

    public b6(int[] iArr, int i) {
        this.f1617b = iArr;
        this.f1618c = i;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        c();
        if (i < 0 || i > (i2 = this.f1618c)) {
            throw new IndexOutOfBoundsException(m(i));
        }
        int[] iArr = this.f1617b;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f1617b, i, iArr2, i + 1, this.f1618c - i);
            this.f1617b = iArr2;
        }
        this.f1617b[i] = intValue;
        this.f1618c++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        h(((Integer) obj).intValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        a6.d(collection);
        if (!(collection instanceof b6)) {
            return super.addAll(collection);
        }
        b6 b6Var = (b6) collection;
        int i = b6Var.f1618c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f1618c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f1617b;
            if (i3 > iArr.length) {
                this.f1617b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(b6Var.f1617b, 0, this.f1617b, this.f1618c, b6Var.f1618c);
            this.f1618c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: d */
    public final d6 f(int i) {
        if (i >= this.f1618c) {
            return new b6(Arrays.copyOf(this.f1617b, i), this.f1618c);
        }
        throw new IllegalArgumentException();
    }

    public final int e(int i) {
        l(i);
        return this.f1617b[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b6)) {
            return super.equals(obj);
        }
        b6 b6Var = (b6) obj;
        if (this.f1618c != b6Var.f1618c) {
            return false;
        }
        int[] iArr = b6Var.f1617b;
        for (int i = 0; i < this.f1618c; i++) {
            if (this.f1617b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i) {
        l(i);
        return Integer.valueOf(this.f1617b[i]);
    }

    public final void h(int i) {
        c();
        int i2 = this.f1618c;
        int[] iArr = this.f1617b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f1617b = iArr2;
        }
        int[] iArr3 = this.f1617b;
        int i3 = this.f1618c;
        this.f1618c = i3 + 1;
        iArr3[i3] = i;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f1618c; i2++) {
            i = (i * 31) + this.f1617b[i2];
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i = this.f1618c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f1617b[i2] == intValue) {
                return i2;
            }
        }
        return -1;
    }

    public final void l(int i) {
        if (i < 0 || i >= this.f1618c) {
            throw new IndexOutOfBoundsException(m(i));
        }
    }

    public final String m(int i) {
        int i2 = this.f1618c;
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
        int[] iArr = this.f1617b;
        int i2 = iArr[i];
        int i3 = this.f1618c;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f1618c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.f1618c; i++) {
            if (obj.equals(Integer.valueOf(this.f1617b[i]))) {
                int[] iArr = this.f1617b;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f1618c - i) - 1);
                this.f1618c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        c();
        if (i2 >= i) {
            int[] iArr = this.f1617b;
            System.arraycopy(iArr, i2, iArr, i, this.f1618c - i2);
            this.f1618c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        l(i);
        int[] iArr = this.f1617b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.f1618c;
    }
}

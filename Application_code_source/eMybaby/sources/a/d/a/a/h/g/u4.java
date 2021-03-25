package a.d.a.a.h.g;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class u4 extends r4<Boolean> implements f6<Boolean>, s7, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public boolean[] f1959b;

    /* renamed from: c  reason: collision with root package name */
    public int f1960c;

    static {
        new u4(new boolean[0], 0).f1915a = false;
    }

    public u4() {
        this.f1959b = new boolean[10];
        this.f1960c = 0;
    }

    public u4(boolean[] zArr, int i) {
        this.f1959b = zArr;
        this.f1960c = i;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i < 0 || i > (i2 = this.f1960c)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        boolean[] zArr = this.f1959b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f1959b, i, zArr2, i + 1, this.f1960c - i);
            this.f1959b = zArr2;
        }
        this.f1959b[i] = booleanValue;
        this.f1960c++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        d(((Boolean) obj).booleanValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        a6.d(collection);
        if (!(collection instanceof u4)) {
            return super.addAll(collection);
        }
        u4 u4Var = (u4) collection;
        int i = u4Var.f1960c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f1960c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f1959b;
            if (i3 > zArr.length) {
                this.f1959b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(u4Var.f1959b, 0, this.f1959b, this.f1960c, u4Var.f1960c);
            this.f1960c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(boolean z) {
        c();
        int i = this.f1960c;
        boolean[] zArr = this.f1959b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f1959b = zArr2;
        }
        boolean[] zArr3 = this.f1959b;
        int i2 = this.f1960c;
        this.f1960c = i2 + 1;
        zArr3[i2] = z;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f1960c) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u4)) {
            return super.equals(obj);
        }
        u4 u4Var = (u4) obj;
        if (this.f1960c != u4Var.f1960c) {
            return false;
        }
        boolean[] zArr = u4Var.f1959b;
        for (int i = 0; i < this.f1960c; i++) {
            if (this.f1959b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ f6 f(int i) {
        if (i >= this.f1960c) {
            return new u4(Arrays.copyOf(this.f1959b, i), this.f1960c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        e(i);
        return Boolean.valueOf(this.f1959b[i]);
    }

    public final String h(int i) {
        int i2 = this.f1960c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f1960c; i2++) {
            i = (i * 31) + a6.c(this.f1959b[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i = this.f1960c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f1959b[i2] == booleanValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        c();
        e(i);
        boolean[] zArr = this.f1959b;
        boolean z = zArr[i];
        int i2 = this.f1960c;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.f1960c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.f1960c; i++) {
            if (obj.equals(Boolean.valueOf(this.f1959b[i]))) {
                boolean[] zArr = this.f1959b;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f1960c - i) - 1);
                this.f1960c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        c();
        if (i2 >= i) {
            boolean[] zArr = this.f1959b;
            System.arraycopy(zArr, i2, zArr, i, this.f1960c - i2);
            this.f1960c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        e(i);
        boolean[] zArr = this.f1959b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.f1960c;
    }
}

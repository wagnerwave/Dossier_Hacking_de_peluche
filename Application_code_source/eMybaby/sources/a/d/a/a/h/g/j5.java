package a.d.a.a.h.g;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class j5 extends r4<Double> implements f6<Double>, s7, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public double[] f1748b;

    /* renamed from: c  reason: collision with root package name */
    public int f1749c;

    static {
        new j5(new double[0], 0).f1915a = false;
    }

    public j5() {
        this.f1748b = new double[10];
        this.f1749c = 0;
    }

    public j5(double[] dArr, int i) {
        this.f1748b = dArr;
        this.f1749c = i;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i < 0 || i > (i2 = this.f1749c)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        double[] dArr = this.f1748b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f1748b, i, dArr2, i + 1, this.f1749c - i);
            this.f1748b = dArr2;
        }
        this.f1748b[i] = doubleValue;
        this.f1749c++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        d(((Double) obj).doubleValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        a6.d(collection);
        if (!(collection instanceof j5)) {
            return super.addAll(collection);
        }
        j5 j5Var = (j5) collection;
        int i = j5Var.f1749c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f1749c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f1748b;
            if (i3 > dArr.length) {
                this.f1748b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(j5Var.f1748b, 0, this.f1748b, this.f1749c, j5Var.f1749c);
            this.f1749c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(double d2) {
        c();
        int i = this.f1749c;
        double[] dArr = this.f1748b;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f1748b = dArr2;
        }
        double[] dArr3 = this.f1748b;
        int i2 = this.f1749c;
        this.f1749c = i2 + 1;
        dArr3[i2] = d2;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f1749c) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j5)) {
            return super.equals(obj);
        }
        j5 j5Var = (j5) obj;
        if (this.f1749c != j5Var.f1749c) {
            return false;
        }
        double[] dArr = j5Var.f1748b;
        for (int i = 0; i < this.f1749c; i++) {
            if (Double.doubleToLongBits(this.f1748b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ f6 f(int i) {
        if (i >= this.f1749c) {
            return new j5(Arrays.copyOf(this.f1748b, i), this.f1749c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        e(i);
        return Double.valueOf(this.f1748b[i]);
    }

    public final String h(int i) {
        int i2 = this.f1749c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f1749c; i2++) {
            i = (i * 31) + a6.b(Double.doubleToLongBits(this.f1748b[i2]));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i = this.f1749c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f1748b[i2] == doubleValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        c();
        e(i);
        double[] dArr = this.f1748b;
        double d2 = dArr[i];
        int i2 = this.f1749c;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.f1749c--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.f1749c; i++) {
            if (obj.equals(Double.valueOf(this.f1748b[i]))) {
                double[] dArr = this.f1748b;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f1749c - i) - 1);
                this.f1749c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        c();
        if (i2 >= i) {
            double[] dArr = this.f1748b;
            System.arraycopy(dArr, i2, dArr, i, this.f1749c - i2);
            this.f1749c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        c();
        e(i);
        double[] dArr = this.f1748b;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    public final int size() {
        return this.f1749c;
    }
}

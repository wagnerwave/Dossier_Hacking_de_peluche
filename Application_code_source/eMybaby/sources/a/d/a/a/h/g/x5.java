package a.d.a.a.h.g;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class x5 extends r4<Float> implements f6<Float>, s7, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public float[] f2025b;

    /* renamed from: c  reason: collision with root package name */
    public int f2026c;

    static {
        new x5(new float[0], 0).f1915a = false;
    }

    public x5() {
        this.f2025b = new float[10];
        this.f2026c = 0;
    }

    public x5(float[] fArr, int i) {
        this.f2025b = fArr;
        this.f2026c = i;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        c();
        if (i < 0 || i > (i2 = this.f2026c)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        float[] fArr = this.f2025b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f2025b, i, fArr2, i + 1, this.f2026c - i);
            this.f2025b = fArr2;
        }
        this.f2025b[i] = floatValue;
        this.f2026c++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        d(((Float) obj).floatValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        a6.d(collection);
        if (!(collection instanceof x5)) {
            return super.addAll(collection);
        }
        x5 x5Var = (x5) collection;
        int i = x5Var.f2026c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f2026c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f2025b;
            if (i3 > fArr.length) {
                this.f2025b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(x5Var.f2025b, 0, this.f2025b, this.f2026c, x5Var.f2026c);
            this.f2026c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(float f) {
        c();
        int i = this.f2026c;
        float[] fArr = this.f2025b;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f2025b = fArr2;
        }
        float[] fArr3 = this.f2025b;
        int i2 = this.f2026c;
        this.f2026c = i2 + 1;
        fArr3[i2] = f;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.f2026c) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x5)) {
            return super.equals(obj);
        }
        x5 x5Var = (x5) obj;
        if (this.f2026c != x5Var.f2026c) {
            return false;
        }
        float[] fArr = x5Var.f2025b;
        for (int i = 0; i < this.f2026c; i++) {
            if (Float.floatToIntBits(this.f2025b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ f6 f(int i) {
        if (i >= this.f2026c) {
            return new x5(Arrays.copyOf(this.f2025b, i), this.f2026c);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        e(i);
        return Float.valueOf(this.f2025b[i]);
    }

    public final String h(int i) {
        int i2 = this.f2026c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f2026c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f2025b[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i = this.f2026c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f2025b[i2] == floatValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        c();
        e(i);
        float[] fArr = this.f2025b;
        float f = fArr[i];
        int i2 = this.f2026c;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f2026c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.f2026c; i++) {
            if (obj.equals(Float.valueOf(this.f2025b[i]))) {
                float[] fArr = this.f2025b;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f2026c - i) - 1);
                this.f2026c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        c();
        if (i2 >= i) {
            float[] fArr = this.f2025b;
            System.arraycopy(fArr, i2, fArr, i, this.f2026c - i2);
            this.f2026c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        c();
        e(i);
        float[] fArr = this.f2025b;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.f2026c;
    }
}

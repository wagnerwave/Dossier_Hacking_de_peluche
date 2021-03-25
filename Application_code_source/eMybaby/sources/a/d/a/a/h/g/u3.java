package a.d.a.a.h.g;

import a.c.a.d.a;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class u3<E> extends n3<E> implements Set<E> {
    @NullableDecl

    /* renamed from: b  reason: collision with root package name */
    public transient m3<E> f1958b;

    public static int n(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d2 = (double) highestOneBit;
                Double.isNaN(d2);
                Double.isNaN(d2);
                if (d2 * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            if (z) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
    }

    public boolean a() {
        return false;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof u3) && a() && ((u3) obj).a() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                return size() == set.size() && containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    public int hashCode() {
        return a.u(this);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public m3<E> o() {
        m3<E> m3Var = this.f1958b;
        if (m3Var != null) {
            return m3Var;
        }
        m3<E> p = p();
        this.f1958b = p;
        return p;
    }

    public m3<E> p() {
        return m3.p(toArray());
    }
}

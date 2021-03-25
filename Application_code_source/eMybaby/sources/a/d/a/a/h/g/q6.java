package a.d.a.a.h.g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class q6 extends r4<String> implements p6, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public static final q6 f1896c;

    /* renamed from: b  reason: collision with root package name */
    public final List<Object> f1897b;

    static {
        q6 q6Var = new q6(10);
        f1896c = q6Var;
        q6Var.f1915a = false;
    }

    public q6(int i) {
        this.f1897b = new ArrayList(i);
    }

    public q6(ArrayList<Object> arrayList) {
        this.f1897b = arrayList;
    }

    public static String d(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof w4 ? ((w4) obj).o() : a6.g((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        c();
        this.f1897b.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        c();
        if (collection instanceof p6) {
            collection = ((p6) collection).b();
        }
        boolean addAll = this.f1897b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final List<?> b() {
        return Collections.unmodifiableList(this.f1897b);
    }

    public final void clear() {
        c();
        this.f1897b.clear();
        this.modCount++;
    }

    public final /* synthetic */ f6 f(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f1897b);
            return new q6((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void g(w4 w4Var) {
        c();
        this.f1897b.add(w4Var);
        this.modCount++;
    }

    public final Object get(int i) {
        Object obj = this.f1897b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof w4) {
            w4 w4Var = (w4) obj;
            String o = w4Var.o();
            d5 d5Var = (d5) w4Var;
            int q = d5Var.q();
            if (q8.d(d5Var.f1665d, q, d5Var.d() + q)) {
                this.f1897b.set(i, o);
            }
            return o;
        }
        byte[] bArr = (byte[]) obj;
        String g = a6.g(bArr);
        boolean z = false;
        if (q8.f1900a.a(0, bArr, 0, bArr.length) == 0) {
            z = true;
        }
        if (z) {
            this.f1897b.set(i, g);
        }
        return g;
    }

    public final p6 i() {
        return this.f1915a ? new m8(this) : this;
    }

    public final Object j(int i) {
        return this.f1897b.get(i);
    }

    public final /* synthetic */ Object remove(int i) {
        c();
        Object remove = this.f1897b.remove(i);
        this.modCount++;
        return d(remove);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        c();
        return d(this.f1897b.set(i, (String) obj));
    }

    public final int size() {
        return this.f1897b.size();
    }
}

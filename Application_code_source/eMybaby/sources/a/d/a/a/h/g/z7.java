package a.d.a.a.h.g;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class z7<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final int f2057a;

    /* renamed from: b  reason: collision with root package name */
    public List<c8> f2058b = Collections.emptyList();

    /* renamed from: c  reason: collision with root package name */
    public Map<K, V> f2059c = Collections.emptyMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f2060d;

    /* renamed from: e  reason: collision with root package name */
    public volatile e8 f2061e;
    public Map<K, V> f = Collections.emptyMap();

    public z7(int i, y7 y7Var) {
        this.f2057a = i;
    }

    public static <FieldDescriptorType extends t5<FieldDescriptorType>> z7<FieldDescriptorType, Object> b(int i) {
        return new y7(i);
    }

    public final int a(K k) {
        int size = this.f2058b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f2058b.get(size).f1646a);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.f2058b.get(i2).f1646a);
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: c */
    public final V put(K k, V v) {
        j();
        int a2 = a(k);
        if (a2 >= 0) {
            c8 c8Var = this.f2058b.get(a2);
            c8Var.f1648c.j();
            V v2 = c8Var.f1647b;
            c8Var.f1647b = v;
            return v2;
        }
        j();
        if (this.f2058b.isEmpty() && !(this.f2058b instanceof ArrayList)) {
            this.f2058b = new ArrayList(this.f2057a);
        }
        int i = -(a2 + 1);
        if (i >= this.f2057a) {
            return k().put(k, v);
        }
        int size = this.f2058b.size();
        int i2 = this.f2057a;
        if (size == i2) {
            c8 remove = this.f2058b.remove(i2 - 1);
            k().put(remove.f1646a, remove.f1647b);
        }
        this.f2058b.add(i, new c8(this, k, v));
        return null;
    }

    public void clear() {
        j();
        if (!this.f2058b.isEmpty()) {
            this.f2058b.clear();
        }
        if (!this.f2059c.isEmpty()) {
            this.f2059c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f2059c.containsKey(comparable);
    }

    public void d() {
        if (!this.f2060d) {
            this.f2059c = this.f2059c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f2059c);
            this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
            this.f2060d = true;
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f2061e == null) {
            this.f2061e = new e8(this, (y7) null);
        }
        return this.f2061e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z7)) {
            return super.equals(obj);
        }
        z7 z7Var = (z7) obj;
        int size = size();
        if (size != z7Var.size()) {
            return false;
        }
        int g = g();
        if (g != z7Var.g()) {
            return entrySet().equals(z7Var.entrySet());
        }
        for (int i = 0; i < g; i++) {
            if (!f(i).equals(z7Var.f(i))) {
                return false;
            }
        }
        if (g != size) {
            return this.f2059c.equals(z7Var.f2059c);
        }
        return true;
    }

    public final Map.Entry<K, V> f(int i) {
        return this.f2058b.get(i);
    }

    public final int g() {
        return this.f2058b.size();
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f2058b.get(a2).f1647b;
        }
        return this.f2059c.get(comparable);
    }

    public final V h(int i) {
        j();
        V v = this.f2058b.remove(i).f1647b;
        if (!this.f2059c.isEmpty()) {
            Iterator it = k().entrySet().iterator();
            this.f2058b.add(new c8(this, (Map.Entry) it.next()));
            it.remove();
        }
        return v;
    }

    public int hashCode() {
        int g = g();
        int i = 0;
        for (int i2 = 0; i2 < g; i2++) {
            i += this.f2058b.get(i2).hashCode();
        }
        return this.f2059c.size() > 0 ? i + this.f2059c.hashCode() : i;
    }

    public final Iterable<Map.Entry<K, V>> i() {
        if (this.f2059c.isEmpty()) {
            return b8.f1620b;
        }
        return this.f2059c.entrySet();
    }

    public final void j() {
        if (this.f2060d) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> k() {
        j();
        if (this.f2059c.isEmpty() && !(this.f2059c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2059c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.f2059c;
    }

    public V remove(Object obj) {
        j();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return h(a2);
        }
        if (this.f2059c.isEmpty()) {
            return null;
        }
        return this.f2059c.remove(comparable);
    }

    public int size() {
        return this.f2059c.size() + this.f2058b.size();
    }
}

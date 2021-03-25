package e.b.a.a.a.w;

import e.b.a.a.a.k;
import e.b.a.a.a.p;
import java.util.Enumeration;
import java.util.Hashtable;

public class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public Hashtable f5353a;

    public void clear() {
        this.f5353a.clear();
    }

    public void close() {
        this.f5353a.clear();
    }

    public boolean containsKey(String str) {
        return this.f5353a.containsKey(str);
    }

    public p get(String str) {
        return (p) this.f5353a.get(str);
    }

    public Enumeration keys() {
        return this.f5353a.keys();
    }

    public void open(String str, String str2) {
        this.f5353a = new Hashtable();
    }

    public void put(String str, p pVar) {
        this.f5353a.put(str, pVar);
    }

    public void remove(String str) {
        this.f5353a.remove(str);
    }
}

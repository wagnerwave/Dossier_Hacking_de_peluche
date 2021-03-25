package e.a.a;

import e.a.a.l0.b;
import java.io.Serializable;
import java.util.Locale;

public final class j implements Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f5170a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5171b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5172c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5173d;

    public j(String str, int i, String str2) {
        if (str != null) {
            this.f5170a = str;
            this.f5171b = str.toLowerCase(Locale.ENGLISH);
            this.f5173d = str2 != null ? str2.toLowerCase(Locale.ENGLISH) : "http";
            this.f5172c = i;
            return;
        }
        throw new IllegalArgumentException("Host name may not be null");
    }

    public String b() {
        if (this.f5172c == -1) {
            return this.f5170a;
        }
        b bVar = new b(this.f5170a.length() + 6);
        bVar.b(this.f5170a);
        bVar.b(":");
        bVar.b(Integer.toString(this.f5172c));
        return bVar.toString();
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f5171b.equals(jVar.f5171b) && this.f5172c == jVar.f5172c && this.f5173d.equals(jVar.f5173d);
    }

    public int hashCode() {
        return a.e.a.a.r.b.G((a.e.a.a.r.b.G(17, this.f5171b) * 37) + this.f5172c, this.f5173d);
    }

    public String toString() {
        b bVar = new b(32);
        bVar.b(this.f5173d);
        bVar.b("://");
        bVar.b(this.f5170a);
        if (this.f5172c != -1) {
            bVar.a(':');
            bVar.b(Integer.toString(this.f5172c));
        }
        return bVar.toString();
    }
}

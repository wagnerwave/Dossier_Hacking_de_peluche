package e.a.a.i0;

import e.a.a.c;
import e.a.a.d;
import java.io.Serializable;

public class b implements c, Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f5127a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5128b;

    public b(String str, String str2) {
        this.f5127a = str;
        this.f5128b = str2;
    }

    public d[] c() {
        String str = this.f5128b;
        if (str == null) {
            return new d[0];
        }
        if (str != null) {
            e eVar = e.f5137a;
            e.a.a.l0.b bVar = new e.a.a.l0.b(str.length());
            bVar.b(str);
            return eVar.b(bVar, new t(0, str.length()));
        }
        throw new IllegalArgumentException("Value to parse may not be null");
    }

    public Object clone() {
        return super.clone();
    }

    public String getName() {
        return this.f5127a;
    }

    public String getValue() {
        return this.f5128b;
    }

    public String toString() {
        return h.f5144a.c((e.a.a.l0.b) null, this).toString();
    }
}

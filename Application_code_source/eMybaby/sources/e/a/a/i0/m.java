package e.a.a.i0;

import e.a.a.l0.b;
import e.a.a.w;
import e.a.a.z;
import java.io.Serializable;

public class m implements z, Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final w f5156a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5157b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5158c;

    public m(w wVar, int i, String str) {
        if (wVar == null) {
            throw new IllegalArgumentException("Protocol version may not be null.");
        } else if (i >= 0) {
            this.f5156a = wVar;
            this.f5157b = i;
            this.f5158c = str;
        } else {
            throw new IllegalArgumentException("Status code may not be negative.");
        }
    }

    public Object clone() {
        return super.clone();
    }

    public String toString() {
        h hVar = h.f5144a;
        b e2 = hVar.e((b) null);
        int b2 = hVar.b(this.f5156a) + 1 + 3 + 1;
        String str = this.f5158c;
        if (str != null) {
            b2 += str.length();
        }
        e2.e(b2);
        hVar.a(e2, this.f5156a);
        e2.a(' ');
        e2.b(Integer.toString(this.f5157b));
        e2.a(' ');
        if (str != null) {
            e2.b(str);
        }
        return e2.toString();
    }
}

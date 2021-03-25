package e.a.a.i0;

import e.a.a.l0.b;
import e.a.a.w;
import e.a.a.y;
import java.io.Serializable;

public class l implements y, Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final w f5153a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5154b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5155c;

    public l(String str, String str2, w wVar) {
        if (str == null) {
            throw new IllegalArgumentException("Method must not be null.");
        } else if (str2 == null) {
            throw new IllegalArgumentException("URI must not be null.");
        } else if (wVar != null) {
            this.f5154b = str;
            this.f5155c = str2;
            this.f5153a = wVar;
        } else {
            throw new IllegalArgumentException("Protocol version must not be null.");
        }
    }

    public Object clone() {
        return super.clone();
    }

    public String toString() {
        return h.f5144a.d((b) null, this).toString();
    }
}

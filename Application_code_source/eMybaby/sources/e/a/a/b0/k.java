package e.a.a.b0;

import a.e.a.a.r.b;
import java.io.Serializable;
import java.security.Principal;

public class k implements h, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f4845a;

    public String a() {
        return null;
    }

    public Principal b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        return b.m((Object) null, (Object) null) && b.m((Object) null, ((k) obj).f4845a);
    }

    public int hashCode() {
        return b.G(b.G(17, (Object) null), (Object) null);
    }

    public String toString() {
        return "[principal: null][workstation: null]";
    }
}

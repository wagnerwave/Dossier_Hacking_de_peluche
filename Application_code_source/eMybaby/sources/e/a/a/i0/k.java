package e.a.a.i0;

import a.e.a.a.r.b;
import com.tuya.smart.common.o0ooo00oo;
import e.a.a.s;
import java.io.Serializable;

public class k implements s, Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f5151a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5152b;

    public k(String str, String str2) {
        if (str != null) {
            this.f5151a = str;
            this.f5152b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f5151a.equals(kVar.f5151a) && b.m(this.f5152b, kVar.f5152b);
    }

    public String getName() {
        return this.f5151a;
    }

    public String getValue() {
        return this.f5152b;
    }

    public int hashCode() {
        return b.G(b.G(17, this.f5151a), this.f5152b);
    }

    public String toString() {
        if (this.f5152b == null) {
            return this.f5151a;
        }
        e.a.a.l0.b bVar = new e.a.a.l0.b(this.f5152b.length() + this.f5151a.length() + 1);
        bVar.b(this.f5151a);
        bVar.b(o0ooo00oo.O0000Oo0);
        bVar.b(this.f5152b);
        return bVar.toString();
    }
}

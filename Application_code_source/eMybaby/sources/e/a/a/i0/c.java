package e.a.a.i0;

import a.e.a.a.r.b;
import com.tuya.smart.common.o0ooo00oo;
import e.a.a.d;
import e.a.a.s;

public class c implements d, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final String f5129a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5130b;

    /* renamed from: c  reason: collision with root package name */
    public final s[] f5131c;

    public c(String str, String str2, s[] sVarArr) {
        if (str != null) {
            this.f5129a = str;
            this.f5130b = str2;
            if (sVarArr != null) {
                this.f5131c = sVarArr;
            } else {
                this.f5131c = new s[0];
            }
        } else {
            throw new IllegalArgumentException("Name may not be null");
        }
    }

    public s b(String str) {
        int i = 0;
        while (true) {
            s[] sVarArr = this.f5131c;
            if (i >= sVarArr.length) {
                return null;
            }
            s sVar = sVarArr[i];
            if (sVar.getName().equalsIgnoreCase(str)) {
                return sVar;
            }
            i++;
        }
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5129a.equals(cVar.f5129a) && b.m(this.f5130b, cVar.f5130b) && b.n(this.f5131c, cVar.f5131c);
    }

    public String getName() {
        return this.f5129a;
    }

    public s[] getParameters() {
        return (s[]) this.f5131c.clone();
    }

    public String getValue() {
        return this.f5130b;
    }

    public int hashCode() {
        int G = b.G(b.G(17, this.f5129a), this.f5130b);
        int i = 0;
        while (true) {
            s[] sVarArr = this.f5131c;
            if (i >= sVarArr.length) {
                return G;
            }
            G = b.G(G, sVarArr[i]);
            i++;
        }
    }

    public String toString() {
        e.a.a.l0.b bVar = new e.a.a.l0.b(64);
        bVar.b(this.f5129a);
        if (this.f5130b != null) {
            bVar.b(o0ooo00oo.O0000Oo0);
            bVar.b(this.f5130b);
        }
        for (s valueOf : this.f5131c) {
            bVar.b("; ");
            bVar.b(String.valueOf(valueOf));
        }
        return bVar.toString();
    }
}

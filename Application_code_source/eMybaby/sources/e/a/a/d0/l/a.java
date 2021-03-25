package e.a.a.d0.l;

import a.e.a.a.r.b;
import e.a.a.j;
import java.net.InetAddress;

public final class a implements Cloneable {
    public static final j[] g = new j[0];

    /* renamed from: a  reason: collision with root package name */
    public final j f4864a;

    /* renamed from: b  reason: collision with root package name */
    public final InetAddress f4865b;

    /* renamed from: c  reason: collision with root package name */
    public final j[] f4866c;

    /* renamed from: d  reason: collision with root package name */
    public final c f4867d;

    /* renamed from: e  reason: collision with root package name */
    public final b f4868e;
    public final boolean f;

    public a(InetAddress inetAddress, j jVar, j[] jVarArr, boolean z, c cVar, b bVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Target host may not be null.");
        } else if (cVar == c.TUNNELLED && jVarArr.length == 0) {
            throw new IllegalArgumentException("Proxy required if tunnelled.");
        } else {
            cVar = cVar == null ? c.PLAIN : cVar;
            bVar = bVar == null ? b.PLAIN : bVar;
            this.f4864a = jVar;
            this.f4865b = inetAddress;
            this.f4866c = jVarArr;
            this.f = z;
            this.f4867d = cVar;
            this.f4868e = bVar;
        }
    }

    public final int b() {
        return this.f4866c.length + 1;
    }

    public final j c(int i) {
        if (i >= 0) {
            int b2 = b();
            if (i < b2) {
                return i < b2 + -1 ? this.f4866c[i] : this.f4864a;
            }
            throw new IllegalArgumentException("Hop index " + i + " exceeds route length " + b2);
        }
        throw new IllegalArgumentException(a.a.a.a.a.h("Hop index must not be negative: ", i));
    }

    public Object clone() {
        return super.clone();
    }

    public final j d() {
        j[] jVarArr = this.f4866c;
        if (jVarArr.length == 0) {
            return null;
        }
        return jVarArr[0];
    }

    public final boolean e() {
        return this.f4868e == b.LAYERED;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f == aVar.f && this.f4867d == aVar.f4867d && this.f4868e == aVar.f4868e && b.m(this.f4864a, aVar.f4864a) && b.m(this.f4865b, aVar.f4865b) && b.n(this.f4866c, aVar.f4866c);
    }

    public final boolean f() {
        return this.f4867d == c.TUNNELLED;
    }

    public final int hashCode() {
        int G = b.G(b.G(17, this.f4864a), this.f4865b);
        int i = 0;
        while (true) {
            j[] jVarArr = this.f4866c;
            if (i >= jVarArr.length) {
                return b.G(b.G((G * 37) + (this.f ? 1 : 0), this.f4867d), this.f4868e);
            }
            G = b.G(G, jVarArr[i]);
            i++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((b() * 30) + 50);
        sb.append("HttpRoute[");
        InetAddress inetAddress = this.f4865b;
        if (inetAddress != null) {
            sb.append(inetAddress);
            sb.append("->");
        }
        sb.append('{');
        if (this.f4867d == c.TUNNELLED) {
            sb.append('t');
        }
        if (this.f4868e == b.LAYERED) {
            sb.append('l');
        }
        if (this.f) {
            sb.append('s');
        }
        sb.append("}->");
        for (j append : this.f4866c) {
            sb.append(append);
            sb.append("->");
        }
        sb.append(this.f4864a);
        sb.append(']');
        return sb.toString();
    }
}

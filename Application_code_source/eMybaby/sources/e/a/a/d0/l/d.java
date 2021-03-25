package e.a.a.d0.l;

import a.e.a.a.r.b;
import e.a.a.j;
import java.net.InetAddress;

public final class d implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final j f4875a;

    /* renamed from: b  reason: collision with root package name */
    public final InetAddress f4876b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4877c;

    /* renamed from: d  reason: collision with root package name */
    public j[] f4878d;

    /* renamed from: e  reason: collision with root package name */
    public c f4879e;
    public b f;
    public boolean g;

    public d(a aVar) {
        j jVar = aVar.f4864a;
        InetAddress inetAddress = aVar.f4865b;
        if (jVar != null) {
            this.f4875a = jVar;
            this.f4876b = inetAddress;
            this.f4879e = c.PLAIN;
            this.f = b.PLAIN;
            return;
        }
        throw new IllegalArgumentException("Target host may not be null.");
    }

    public final int b() {
        if (!this.f4877c) {
            return 0;
        }
        j[] jVarArr = this.f4878d;
        if (jVarArr == null) {
            return 1;
        }
        return 1 + jVarArr.length;
    }

    public final boolean c() {
        return this.f == b.LAYERED;
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean d() {
        return this.f4879e == c.TUNNELLED;
    }

    public final a e() {
        j[] jVarArr;
        if (!this.f4877c) {
            return null;
        }
        j jVar = this.f4875a;
        InetAddress inetAddress = this.f4876b;
        j[] jVarArr2 = this.f4878d;
        boolean z = this.g;
        c cVar = this.f4879e;
        b bVar = this.f;
        if (jVarArr2 == null || jVarArr2.length < 1) {
            jVarArr = a.g;
        } else {
            int length = jVarArr2.length;
            int i = 0;
            while (i < length) {
                if (jVarArr2[i] != null) {
                    i++;
                } else {
                    throw new IllegalArgumentException("Proxy chain may not contain null elements.");
                }
            }
            jVarArr = new j[jVarArr2.length];
            System.arraycopy(jVarArr2, 0, jVarArr, 0, jVarArr2.length);
        }
        return new a(inetAddress, jVar, jVarArr, z, cVar, bVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4877c == dVar.f4877c && this.g == dVar.g && this.f4879e == dVar.f4879e && this.f == dVar.f && b.m(this.f4875a, dVar.f4875a) && b.m(this.f4876b, dVar.f4876b) && b.n(this.f4878d, dVar.f4878d);
    }

    public final int hashCode() {
        int G = b.G(b.G(17, this.f4875a), this.f4876b);
        if (this.f4878d != null) {
            int i = 0;
            while (true) {
                j[] jVarArr = this.f4878d;
                if (i >= jVarArr.length) {
                    break;
                }
                G = b.G(G, jVarArr[i]);
                i++;
            }
        }
        return b.G(b.G((((G * 37) + (this.f4877c ? 1 : 0)) * 37) + (this.g ? 1 : 0), this.f4879e), this.f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((b() * 30) + 50);
        sb.append("RouteTracker[");
        InetAddress inetAddress = this.f4876b;
        if (inetAddress != null) {
            sb.append(inetAddress);
            sb.append("->");
        }
        sb.append('{');
        if (this.f4877c) {
            sb.append('c');
        }
        if (this.f4879e == c.TUNNELLED) {
            sb.append('t');
        }
        if (this.f == b.LAYERED) {
            sb.append('l');
        }
        if (this.g) {
            sb.append('s');
        }
        sb.append("}->");
        if (this.f4878d != null) {
            int i = 0;
            while (true) {
                j[] jVarArr = this.f4878d;
                if (i >= jVarArr.length) {
                    break;
                }
                sb.append(jVarArr[i]);
                sb.append("->");
                i++;
            }
        }
        sb.append(this.f4875a);
        sb.append(']');
        return sb.toString();
    }
}

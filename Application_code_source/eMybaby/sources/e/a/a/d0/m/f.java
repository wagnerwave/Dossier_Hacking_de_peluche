package e.a.a.d0.m;

import a.a.a.a.a;
import a.e.a.a.r.b;
import java.util.Locale;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f4882a;

    /* renamed from: b  reason: collision with root package name */
    public final h f4883b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4884c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4885d;

    /* renamed from: e  reason: collision with root package name */
    public String f4886e;

    public f(String str, int i, h hVar) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException(a.h("Port is invalid: ", i));
        }
        this.f4882a = str.toLowerCase(Locale.ENGLISH);
        this.f4883b = hVar;
        this.f4884c = i;
        this.f4885d = hVar instanceof b;
    }

    @Deprecated
    public f(String str, j jVar, int i) {
        boolean z;
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException(a.h("Port is invalid: ", i));
        }
        this.f4882a = str.toLowerCase(Locale.ENGLISH);
        if (jVar instanceof d) {
            this.f4883b = new c((d) jVar);
            z = true;
        } else {
            this.f4883b = new i(jVar);
            z = false;
        }
        this.f4885d = z;
        this.f4884c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f4882a.equals(fVar.f4882a) && this.f4884c == fVar.f4884c && this.f4885d == fVar.f4885d;
    }

    public int hashCode() {
        return (b.G(629 + this.f4884c, this.f4882a) * 37) + (this.f4885d ? 1 : 0);
    }

    public final String toString() {
        if (this.f4886e == null) {
            this.f4886e = this.f4882a + ':' + Integer.toString(this.f4884c);
        }
        return this.f4886e;
    }
}

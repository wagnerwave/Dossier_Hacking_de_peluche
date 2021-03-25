package e.a.a.g0.f;

import e.a.a.b0.h;
import e.a.a.c;
import e.a.a.i0.o;
import e.a.a.m;
import org.apache.commons.codec.binary.Base64;

public class b extends l {

    /* renamed from: c  reason: collision with root package name */
    public boolean f4948c = false;

    public void b(c cVar) {
        super.b(cVar);
        this.f4948c = true;
    }

    public c c(h hVar, m mVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("Credentials may not be null");
        } else if (mVar != null) {
            String t = a.e.a.a.r.b.t(mVar.getParams());
            boolean z = this.f4947a;
            StringBuilder sb = new StringBuilder();
            sb.append(hVar.b().getName());
            sb.append(":");
            sb.append(hVar.a() == null ? "null" : hVar.a());
            byte[] encodeBase64 = Base64.encodeBase64(a.e.a.a.r.b.r(sb.toString(), t));
            e.a.a.l0.b bVar = new e.a.a.l0.b(32);
            bVar.b(z ? "Proxy-Authorization" : "Authorization");
            bVar.b(": Basic ");
            bVar.c(encodeBase64, 0, encodeBase64.length);
            return new o(bVar);
        } else {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return this.f4948c;
    }

    public String g() {
        return "basic";
    }
}

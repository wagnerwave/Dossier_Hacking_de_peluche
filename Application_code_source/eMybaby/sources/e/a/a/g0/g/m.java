package e.a.a.g0.g;

import e.a.a.b0.a;
import e.a.a.b0.e;
import e.a.a.b0.h;
import java.security.Principal;

public class m {
    public static Principal a(e eVar) {
        h hVar;
        a aVar = eVar.f4842a;
        if (aVar == null || !aVar.f() || !aVar.e() || (hVar = eVar.f4844c) == null) {
            return null;
        }
        return hVar.b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        r3 = r3.h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(e.a.a.k0.c r3) {
        /*
            r2 = this;
            java.lang.String r0 = "http.auth.target-scope"
            java.lang.Object r0 = r3.b(r0)
            e.a.a.b0.e r0 = (e.a.a.b0.e) r0
            if (r0 == 0) goto L_0x001d
            java.security.Principal r0 = a(r0)
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = "http.auth.proxy-scope"
            java.lang.Object r0 = r3.b(r0)
            e.a.a.b0.e r0 = (e.a.a.b0.e) r0
            java.security.Principal r0 = a(r0)
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 != 0) goto L_0x0038
            java.lang.String r1 = "http.connection"
            java.lang.Object r3 = r3.b(r1)
            e.a.a.d0.j r3 = (e.a.a.d0.j) r3
            boolean r1 = r3.isOpen()
            if (r1 == 0) goto L_0x0038
            javax.net.ssl.SSLSession r3 = r3.h()
            if (r3 == 0) goto L_0x0038
            java.security.Principal r0 = r3.getLocalPrincipal()
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.g.m.b(e.a.a.k0.c):java.lang.Object");
    }
}

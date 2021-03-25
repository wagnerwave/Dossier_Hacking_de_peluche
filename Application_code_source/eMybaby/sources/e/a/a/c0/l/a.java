package e.a.a.c0.l;

import e.a.a.c0.e;
import e.a.a.c0.k.g;
import e.a.a.e0.b;
import e.a.a.e0.h;
import e.a.a.e0.i;
import e.a.a.e0.j;
import e.a.a.i0.l;
import e.a.a.k0.c;
import e.a.a.m;
import e.a.a.n;
import e.a.a.v;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class a implements n {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4849a = LogFactory.getLog(a.class);

    public void b(m mVar, c cVar) {
        URI uri;
        e.a.a.c e2;
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (cVar == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        } else if (!((l) mVar.f()).f5154b.equalsIgnoreCase("CONNECT")) {
            e eVar = (e) cVar.b("http.cookie-store");
            if (eVar == null) {
                this.f4849a.debug("Cookie store not specified in HTTP context");
                return;
            }
            j jVar = (j) cVar.b("http.cookiespec-registry");
            if (jVar == null) {
                this.f4849a.debug("CookieSpec registry not specified in HTTP context");
                return;
            }
            e.a.a.j jVar2 = (e.a.a.j) cVar.b("http.target_host");
            if (jVar2 == null) {
                this.f4849a.debug("Target host not set in the context");
                return;
            }
            e.a.a.d0.j jVar3 = (e.a.a.d0.j) cVar.b("http.connection");
            if (jVar3 == null) {
                this.f4849a.debug("HTTP connection not set in the context");
                return;
            }
            e.a.a.j0.c params = mVar.getParams();
            if (params != null) {
                String str = (String) params.e("http.protocol.cookie-policy");
                if (str == null) {
                    str = "best-match";
                }
                if (this.f4849a.isDebugEnabled()) {
                    Log log = this.f4849a;
                    log.debug("CookieSpec selected: " + str);
                }
                if (mVar instanceof g) {
                    uri = ((g) mVar).i();
                } else {
                    try {
                        uri = new URI(((l) mVar.f()).f5155c);
                    } catch (URISyntaxException e3) {
                        StringBuilder n = a.a.a.a.a.n("Invalid request URI: ");
                        n.append(((l) mVar.f()).f5155c);
                        throw new v(n.toString(), e3);
                    }
                }
                String str2 = jVar2.f5170a;
                int i = jVar2.f5172c;
                boolean z = false;
                if (i < 0) {
                    if (jVar3.g().b() == 1) {
                        i = jVar3.getRemotePort();
                    } else {
                        String str3 = jVar2.f5173d;
                        i = str3.equalsIgnoreCase("http") ? 80 : str3.equalsIgnoreCase("https") ? 443 : 0;
                    }
                }
                e.a.a.e0.e eVar2 = new e.a.a.e0.e(str2, i, uri.getPath(), jVar3.c());
                e.a.a.j0.c params2 = mVar.getParams();
                i iVar = jVar.f4901a.get(str.toLowerCase(Locale.ENGLISH));
                if (iVar != null) {
                    h a2 = iVar.a(params2);
                    ArrayList arrayList = new ArrayList(eVar.a());
                    ArrayList arrayList2 = new ArrayList();
                    Date date = new Date();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) it.next();
                        if (!bVar.f(date)) {
                            if (a2.b(bVar, eVar2)) {
                                if (this.f4849a.isDebugEnabled()) {
                                    Log log2 = this.f4849a;
                                    log2.debug("Cookie " + bVar + " match " + eVar2);
                                }
                                arrayList2.add(bVar);
                            }
                        } else if (this.f4849a.isDebugEnabled()) {
                            Log log3 = this.f4849a;
                            log3.debug("Cookie " + bVar + " expired");
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        for (e.a.a.c h : a2.f(arrayList2)) {
                            mVar.h(h);
                        }
                    }
                    int d2 = a2.d();
                    if (d2 > 0) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = (b) it2.next();
                            if (d2 != bVar2.d() || !(bVar2 instanceof e.a.a.e0.l)) {
                                z = true;
                            }
                        }
                        if (z && (e2 = a2.e()) != null) {
                            mVar.h(e2);
                        }
                    }
                    cVar.e("http.cookie-spec", a2);
                    cVar.e("http.cookie-origin", eVar2);
                    return;
                }
                throw new IllegalStateException(a.a.a.a.a.k("Unsupported cookie spec: ", str));
            }
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }
}

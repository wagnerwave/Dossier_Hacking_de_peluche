package e.a.a.g0.g;

import e.a.a.b0.f;
import e.a.a.d0.b;
import e.a.a.g0.h.a;
import e.a.a.g0.h.g;
import e.a.a.h;
import e.a.a.i;
import e.a.a.i0.l;
import e.a.a.j;
import e.a.a.j0.c;
import e.a.a.k0.d;
import e.a.a.k0.e;
import e.a.a.m;
import e.a.a.o;
import e.a.a.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4991a;

    /* renamed from: b  reason: collision with root package name */
    public final b f4992b;

    /* renamed from: c  reason: collision with root package name */
    public final g f4993c;

    /* renamed from: d  reason: collision with root package name */
    public final e.a.a.g0.b f4994d;

    /* renamed from: e  reason: collision with root package name */
    public final f f4995e;
    public final e f;
    public final d g;
    public final h h;
    public final j i;
    public final e.a.a.c0.b j;
    public final e.a.a.c0.b k;
    public final m l;
    public final c m;
    public a n;
    public final e.a.a.b0.e o;
    public final e.a.a.b0.e p;
    public int q;
    public int r;
    public int s;
    public j t;

    public k(Log log, e eVar, b bVar, e.a.a.g0.b bVar2, f fVar, g gVar, d dVar, h hVar, j jVar, e.a.a.c0.b bVar3, e.a.a.c0.b bVar4, m mVar, c cVar) {
        if (log == null) {
            throw new IllegalArgumentException("Log may not be null.");
        } else if (eVar == null) {
            throw new IllegalArgumentException("Request executor may not be null.");
        } else if (bVar == null) {
            throw new IllegalArgumentException("Client connection manager may not be null.");
        } else if (bVar2 == null) {
            throw new IllegalArgumentException("Connection reuse strategy may not be null.");
        } else if (fVar == null) {
            throw new IllegalArgumentException("Connection keep alive strategy may not be null.");
        } else if (gVar == null) {
            throw new IllegalArgumentException("Route planner may not be null.");
        } else if (dVar == null) {
            throw new IllegalArgumentException("HTTP protocol processor may not be null.");
        } else if (hVar == null) {
            throw new IllegalArgumentException("HTTP request retry handler may not be null.");
        } else if (jVar == null) {
            throw new IllegalArgumentException("Redirect strategy may not be null.");
        } else if (bVar3 == null) {
            throw new IllegalArgumentException("Target authentication handler may not be null.");
        } else if (bVar4 == null) {
            throw new IllegalArgumentException("Proxy authentication handler may not be null.");
        } else if (mVar == null) {
            throw new IllegalArgumentException("User token handler may not be null.");
        } else if (cVar != null) {
            this.f4991a = log;
            this.f = eVar;
            this.f4992b = bVar;
            this.f4994d = bVar2;
            this.f4995e = fVar;
            this.f4993c = gVar;
            this.g = dVar;
            this.h = hVar;
            this.i = jVar;
            this.j = bVar3;
            this.k = bVar4;
            this.l = mVar;
            this.m = cVar;
            this.n = null;
            this.q = 0;
            this.r = 0;
            this.s = cVar.b("http.protocol.max-redirects", 100);
            this.o = new e.a.a.b0.e();
            this.p = new e.a.a.b0.e();
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    public final void a() {
        a aVar = this.n;
        if (aVar != null) {
            this.n = null;
            try {
                aVar.i();
            } catch (IOException e2) {
                if (this.f4991a.isDebugEnabled()) {
                    this.f4991a.debug(e2.getMessage(), e2);
                }
            }
            try {
                aVar.l();
            } catch (IOException e3) {
                this.f4991a.debug("Error releasing connection", e3);
            }
        }
    }

    public e.a.a.d0.l.a b(j jVar, m mVar, e.a.a.k0.c cVar) {
        e.a.a.d0.l.a aVar;
        if (jVar == null) {
            jVar = (j) ((e.a.a.i0.a) mVar).getParams().e("http.default-host");
        }
        j jVar2 = jVar;
        if (jVar2 != null) {
            g gVar = this.f4993c;
            j jVar3 = null;
            if (gVar != null) {
                e.a.a.d0.l.b bVar = e.a.a.d0.l.b.PLAIN;
                e.a.a.d0.l.c cVar2 = e.a.a.d0.l.c.PLAIN;
                e.a.a.i0.a aVar2 = (e.a.a.i0.a) mVar;
                e.a.a.d0.l.a a2 = e.a.a.d0.k.c.a(aVar2.getParams());
                if (a2 != null) {
                    return a2;
                }
                c params = aVar2.getParams();
                if (params != null) {
                    InetAddress inetAddress = (InetAddress) params.e("http.route.local-address");
                    c params2 = aVar2.getParams();
                    if (params2 != null) {
                        j jVar4 = (j) params2.e("http.route.default-proxy");
                        if (jVar4 == null || !e.a.a.d0.k.c.f4862a.equals(jVar4)) {
                            jVar3 = jVar4;
                        }
                        try {
                            boolean z = gVar.f5017a.a(jVar2.f5173d).f4885d;
                            if (jVar3 == null) {
                                InetAddress inetAddress2 = inetAddress;
                                j[] jVarArr = e.a.a.d0.l.a.g;
                            } else {
                                j[] jVarArr2 = {jVar3};
                                if (z) {
                                    cVar2 = e.a.a.d0.l.c.TUNNELLED;
                                }
                                if (z) {
                                    bVar = e.a.a.d0.l.b.LAYERED;
                                }
                                new e.a.a.d0.l.a(inetAddress, jVar2, jVarArr2, z, cVar2, bVar);
                            }
                            return aVar;
                        } catch (IllegalStateException e2) {
                            throw new i(e2.getMessage());
                        }
                    } else {
                        throw new IllegalArgumentException("Parameters must not be null.");
                    }
                } else {
                    throw new IllegalArgumentException("Parameters must not be null.");
                }
            } else {
                throw null;
            }
        } else {
            throw new IllegalStateException("Target host must not be null, or set in parameters.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0098, code lost:
        if (r8.f != r0.f) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00be, code lost:
        if (r1.equals(r0.f4865b) == false) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0333 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(e.a.a.d0.l.a r17, e.a.a.k0.c r18) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            r9 = r18
        L_0x0006:
            e.a.a.g0.h.a r0 = r7.n
            e.a.a.d0.l.a r0 = r0.g()
            if (r8 == 0) goto L_0x03f3
            r10 = 1
            if (r0 == 0) goto L_0x00c6
            int r1 = r0.b()
            if (r1 >= r10) goto L_0x0019
            goto L_0x00c6
        L_0x0019:
            int r1 = r17.b()
            if (r1 <= r10) goto L_0x009b
            int r1 = r0.b()
            if (r1 > r10) goto L_0x0027
            goto L_0x00c0
        L_0x0027:
            e.a.a.j r1 = r8.f4864a
            e.a.a.j r2 = r0.f4864a
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0033
            goto L_0x00c0
        L_0x0033:
            int r1 = r17.b()
            int r2 = r0.b()
            if (r1 >= r2) goto L_0x003f
            goto L_0x00c0
        L_0x003f:
            r3 = 0
        L_0x0040:
            int r4 = r2 + -1
            if (r3 >= r4) goto L_0x0057
            e.a.a.j r4 = r8.c(r3)
            e.a.a.j r5 = r0.c(r3)
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0054
            goto L_0x00c0
        L_0x0054:
            int r3 = r3 + 1
            goto L_0x0040
        L_0x0057:
            if (r1 <= r2) goto L_0x005d
            r1 = 4
            r11 = 4
            goto L_0x00d0
        L_0x005d:
            boolean r1 = r0.f()
            if (r1 == 0) goto L_0x0069
            boolean r1 = r17.f()
            if (r1 == 0) goto L_0x00c0
        L_0x0069:
            boolean r1 = r0.e()
            if (r1 == 0) goto L_0x0076
            boolean r1 = r17.e()
            if (r1 != 0) goto L_0x0076
            goto L_0x00c0
        L_0x0076:
            boolean r1 = r17.f()
            if (r1 == 0) goto L_0x0085
            boolean r1 = r0.f()
            if (r1 != 0) goto L_0x0085
            r1 = 3
            r11 = 3
            goto L_0x00d0
        L_0x0085:
            boolean r1 = r17.e()
            if (r1 == 0) goto L_0x0094
            boolean r1 = r0.e()
            if (r1 != 0) goto L_0x0094
            r1 = 5
            r11 = 5
            goto L_0x00d0
        L_0x0094:
            boolean r1 = r8.f
            boolean r2 = r0.f
            if (r1 == r2) goto L_0x00c3
            goto L_0x00c0
        L_0x009b:
            int r1 = r0.b()
            if (r1 <= r10) goto L_0x00a2
            goto L_0x00c0
        L_0x00a2:
            e.a.a.j r1 = r8.f4864a
            e.a.a.j r2 = r0.f4864a
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00ad
            goto L_0x00c0
        L_0x00ad:
            boolean r1 = r8.f
            boolean r2 = r0.f
            if (r1 == r2) goto L_0x00b4
            goto L_0x00c0
        L_0x00b4:
            java.net.InetAddress r1 = r8.f4865b
            if (r1 == 0) goto L_0x00c3
            java.net.InetAddress r2 = r0.f4865b
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00c3
        L_0x00c0:
            r1 = -1
            r11 = -1
            goto L_0x00d0
        L_0x00c3:
            r1 = 0
            r11 = 0
            goto L_0x00d0
        L_0x00c6:
            int r1 = r17.b()
            if (r1 <= r10) goto L_0x00ce
            r1 = 2
            goto L_0x00cf
        L_0x00ce:
            r1 = 1
        L_0x00cf:
            r11 = r1
        L_0x00d0:
            java.lang.String r12 = "Connection not open."
            java.lang.String r13 = "Parameters must not be null."
            r14 = 0
            switch(r11) {
                case -1: goto L_0x03d4;
                case 0: goto L_0x03d1;
                case 1: goto L_0x03ca;
                case 2: goto L_0x03ca;
                case 3: goto L_0x01c8;
                case 4: goto L_0x01bd;
                case 5: goto L_0x00f4;
                default: goto L_0x00d8;
            }
        L_0x00d8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown step indicator "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r2 = " from RouteDirector."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00f4:
            e.a.a.g0.h.a r0 = r7.n
            e.a.a.j0.c r1 = r7.m
            e.a.a.g0.h.c r0 = (e.a.a.g0.h.c) r0
            e.a.a.g0.h.b r2 = r0.o()
            r0.m(r2)
            if (r1 == 0) goto L_0x01b7
            e.a.a.d0.l.d r0 = r2.f5014e
            if (r0 == 0) goto L_0x01b1
            e.a.a.d0.l.d r0 = r2.f5014e
            boolean r0 = r0.f4877c
            if (r0 == 0) goto L_0x01b1
            e.a.a.d0.l.d r0 = r2.f5014e
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x01a9
            e.a.a.d0.l.d r0 = r2.f5014e
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x01a1
            e.a.a.d0.l.d r0 = r2.f5014e
            e.a.a.j r3 = r0.f4875a
            e.a.a.g0.h.f r0 = r2.f5010a
            e.a.a.g0.h.e r4 = r2.f5011b
            if (r0 == 0) goto L_0x01a0
            if (r4 == 0) goto L_0x0198
            if (r3 == 0) goto L_0x0190
            boolean r5 = r4.i
            if (r5 == 0) goto L_0x0188
            e.a.a.d0.m.g r5 = r0.f5016b
            java.lang.String r6 = r3.f5173d
            e.a.a.d0.m.f r5 = r5.a(r6)
            e.a.a.d0.m.h r6 = r5.f4883b
            boolean r12 = r6 instanceof e.a.a.d0.m.b
            if (r12 == 0) goto L_0x0174
            e.a.a.d0.m.b r6 = (e.a.a.d0.m.b) r6
            java.net.Socket r5 = r4.n     // Catch:{ ConnectException -> 0x016d }
            java.lang.String r12 = r3.f5170a     // Catch:{ ConnectException -> 0x016d }
            int r13 = r3.f5172c     // Catch:{ ConnectException -> 0x016d }
            java.net.Socket r5 = r6.g(r5, r12, r13, r10)     // Catch:{ ConnectException -> 0x016d }
            r0.a(r5, r1)
            boolean r0 = r6.a(r5)
            r4.n(r5, r3, r0, r1)
            e.a.a.d0.l.d r0 = r2.f5014e
            e.a.a.g0.h.e r1 = r2.f5011b
            boolean r1 = r1.o
            boolean r2 = r0.f4877c
            if (r2 == 0) goto L_0x0165
            e.a.a.d0.l.b r2 = e.a.a.d0.l.b.LAYERED
            r0.f = r2
            r0.g = r1
            goto L_0x03d1
        L_0x0165:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No layered protocol unless connected."
            r0.<init>(r1)
            throw r0
        L_0x016d:
            r0 = move-exception
            e.a.a.d0.i r1 = new e.a.a.d0.i
            r1.<init>(r3, r0)
            throw r1
        L_0x0174:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Target scheme ("
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            java.lang.String r2 = r5.f4882a
            java.lang.String r3 = ") must have layered socket factory."
            java.lang.String r1 = a.a.a.a.a.m(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x0188:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Connection must be open"
            r0.<init>(r1)
            throw r0
        L_0x0190:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Target host may not be null"
            r0.<init>(r1)
            throw r0
        L_0x0198:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Connection may not be null"
            r0.<init>(r1)
            throw r0
        L_0x01a0:
            throw r14
        L_0x01a1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Multiple protocol layering not supported."
            r0.<init>(r1)
            throw r0
        L_0x01a9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Protocol layering without a tunnel not supported."
            r0.<init>(r1)
            throw r0
        L_0x01b1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r12)
            throw r0
        L_0x01b7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r13)
            throw r0
        L_0x01bd:
            r0.b()
            e.a.a.i r0 = new e.a.a.i
            java.lang.String r1 = "Proxy chains are not supported."
            r0.<init>(r1)
            throw r0
        L_0x01c8:
            e.a.a.j r0 = r17.d()
            e.a.a.j r15 = r8.f4864a
            r1 = 0
            r2 = r14
        L_0x01d0:
            if (r1 != 0) goto L_0x0327
            e.a.a.g0.h.a r1 = r7.n
            boolean r1 = r1.isOpen()
            if (r1 != 0) goto L_0x01e1
            e.a.a.g0.h.a r1 = r7.n
            e.a.a.j0.c r2 = r7.m
            r1.k(r8, r9, r2)
        L_0x01e1:
            e.a.a.j r1 = r8.f4864a
            java.lang.String r2 = r1.f5170a
            int r3 = r1.f5172c
            if (r3 >= 0) goto L_0x01f7
            e.a.a.d0.b r3 = r7.f4992b
            e.a.a.d0.m.g r3 = r3.a()
            java.lang.String r1 = r1.f5173d
            e.a.a.d0.m.f r1 = r3.a(r1)
            int r3 = r1.f4884c
        L_0x01f7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = r2.length()
            int r4 = r4 + 6
            r1.<init>(r4)
            r1.append(r2)
            r2 = 58
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toString(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            e.a.a.j0.c r2 = r7.m
            e.a.a.w r2 = a.e.a.a.r.b.E(r2)
            e.a.a.i0.f r3 = new e.a.a.i0.f
            java.lang.String r4 = "CONNECT"
            r3.<init>(r4, r1, r2)
            e.a.a.j0.c r1 = r7.m
            r3.d(r1)
            java.lang.String r1 = "http.target_host"
            r9.e(r1, r15)
            java.lang.String r1 = "http.proxy_host"
            r9.e(r1, r0)
            e.a.a.g0.h.a r1 = r7.n
            java.lang.String r2 = "http.connection"
            r9.e(r2, r1)
            e.a.a.b0.e r1 = r7.o
            java.lang.String r2 = "http.auth.target-scope"
            r9.e(r2, r1)
            e.a.a.b0.e r1 = r7.p
            java.lang.String r2 = "http.auth.proxy-scope"
            r9.e(r2, r1)
            java.lang.String r1 = "http.request"
            r9.e(r1, r3)
            e.a.a.k0.e r1 = r7.f
            e.a.a.k0.d r2 = r7.g
            r1.f(r3, r2, r9)
            e.a.a.k0.e r1 = r7.f
            e.a.a.g0.h.a r2 = r7.n
            e.a.a.o r6 = r1.d(r3, r2, r9)
            e.a.a.j0.c r1 = r7.m
            r6.d(r1)
            e.a.a.k0.e r1 = r7.f
            e.a.a.k0.d r2 = r7.g
            r1.e(r6, r2, r9)
            e.a.a.z r1 = r6.s()
            e.a.a.i0.m r1 = (e.a.a.i0.m) r1
            int r1 = r1.f5157b
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 < r2) goto L_0x030f
            java.lang.String r1 = "http.auth.credentials-provider"
            java.lang.Object r1 = r9.b(r1)
            r5 = r1
            e.a.a.c0.f r5 = (e.a.a.c0.f) r5
            if (r5 == 0) goto L_0x0308
            e.a.a.j0.c r1 = r7.m
            if (r1 == 0) goto L_0x0300
            java.lang.String r2 = "http.protocol.handle-authentication"
            boolean r1 = r1.c(r2, r10)
            if (r1 == 0) goto L_0x0308
            e.a.a.c0.b r1 = r7.k
            boolean r1 = r1.a(r6, r9)
            if (r1 == 0) goto L_0x02f9
            org.apache.commons.logging.Log r1 = r7.f4991a
            java.lang.String r2 = "Proxy requested authentication"
            r1.debug(r2)
            e.a.a.c0.b r1 = r7.k
            java.util.Map r2 = r1.b(r6, r9)
            e.a.a.b0.e r3 = r7.p     // Catch:{ f -> 0x02d7 }
            e.a.a.c0.b r4 = r7.k     // Catch:{ f -> 0x02d7 }
            r1 = r16
            r10 = r5
            r5 = r6
            r14 = r6
            r6 = r18
            r1.g(r2, r3, r4, r5, r6)     // Catch:{ f -> 0x02d5 }
            e.a.a.b0.e r1 = r7.p
            r7.l(r1, r0, r10)
            e.a.a.b0.e r1 = r7.p
            e.a.a.b0.h r1 = r1.f4844c
            if (r1 == 0) goto L_0x0309
            e.a.a.g0.b r1 = r7.f4994d
            boolean r1 = r1.a(r14, r9)
            if (r1 == 0) goto L_0x02ce
            org.apache.commons.logging.Log r1 = r7.f4991a
            java.lang.String r2 = "Connection kept alive"
            r1.debug(r2)
            e.a.a.g r1 = r14.b()
            a.e.a.a.r.b.f(r1)
            goto L_0x02d3
        L_0x02ce:
            e.a.a.g0.h.a r1 = r7.n
            r1.close()
        L_0x02d3:
            r1 = 0
            goto L_0x030a
        L_0x02d5:
            r0 = move-exception
            goto L_0x02d9
        L_0x02d7:
            r0 = move-exception
            r14 = r6
        L_0x02d9:
            org.apache.commons.logging.Log r1 = r7.f4991a
            boolean r1 = r1.isWarnEnabled()
            if (r1 == 0) goto L_0x02f7
            org.apache.commons.logging.Log r1 = r7.f4991a
            java.lang.String r2 = "Authentication error: "
            java.lang.StringBuilder r2 = a.a.a.a.a.n(r2)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.warn(r0)
        L_0x02f7:
            r2 = r14
            goto L_0x0327
        L_0x02f9:
            r14 = r6
            e.a.a.b0.e r1 = r7.p
            r2 = 0
            r1.f4843b = r2
            goto L_0x0309
        L_0x0300:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "HTTP parameters may not be null"
            r0.<init>(r1)
            throw r0
        L_0x0308:
            r14 = r6
        L_0x0309:
            r1 = 1
        L_0x030a:
            r2 = r14
            r10 = 1
            r14 = 0
            goto L_0x01d0
        L_0x030f:
            r14 = r6
            e.a.a.i r0 = new e.a.a.i
            java.lang.String r1 = "Unexpected response to CONNECT request: "
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            e.a.a.z r2 = r14.s()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0327:
            e.a.a.z r0 = r2.s()
            e.a.a.i0.m r0 = (e.a.a.i0.m) r0
            int r0 = r0.f5157b
            r1 = 299(0x12b, float:4.19E-43)
            if (r0 <= r1) goto L_0x035d
            e.a.a.g r0 = r2.b()
            if (r0 == 0) goto L_0x0341
            e.a.a.f0.c r1 = new e.a.a.f0.c
            r1.<init>(r0)
            r2.q(r1)
        L_0x0341:
            e.a.a.g0.h.a r0 = r7.n
            r0.close()
            e.a.a.g0.g.r r0 = new e.a.a.g0.g.r
            java.lang.String r1 = "CONNECT refused by proxy: "
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            e.a.a.z r3 = r2.s()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r2)
            throw r0
        L_0x035d:
            e.a.a.g0.h.a r0 = r7.n
            r1 = 1
            r0.f5007c = r1
            org.apache.commons.logging.Log r0 = r7.f4991a
            java.lang.String r1 = "Tunnel to target created."
            r0.debug(r1)
            e.a.a.g0.h.a r0 = r7.n
            e.a.a.j0.c r1 = r7.m
            e.a.a.g0.h.c r0 = (e.a.a.g0.h.c) r0
            e.a.a.g0.h.b r2 = r0.o()
            r0.m(r2)
            if (r1 == 0) goto L_0x03c4
            e.a.a.d0.l.d r0 = r2.f5014e
            if (r0 == 0) goto L_0x03be
            e.a.a.d0.l.d r0 = r2.f5014e
            boolean r0 = r0.f4877c
            if (r0 == 0) goto L_0x03be
            e.a.a.d0.l.d r0 = r2.f5014e
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x03b6
            e.a.a.g0.h.e r0 = r2.f5011b
            e.a.a.d0.l.d r3 = r2.f5014e
            e.a.a.j r3 = r3.f4875a
            r4 = 0
            r5 = 0
            r0.n(r5, r3, r4, r1)
            e.a.a.d0.l.d r0 = r2.f5014e
            boolean r1 = r0.f4877c
            if (r1 == 0) goto L_0x03ae
            e.a.a.j[] r1 = r0.f4878d
            if (r1 == 0) goto L_0x03a6
            e.a.a.d0.l.c r1 = e.a.a.d0.l.c.TUNNELLED
            r0.f4879e = r1
            r0.g = r4
            goto L_0x03d1
        L_0x03a6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No tunnel without proxy."
            r0.<init>(r1)
            throw r0
        L_0x03ae:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No tunnel unless connected."
            r0.<init>(r1)
            throw r0
        L_0x03b6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Connection is already tunnelled."
            r0.<init>(r1)
            throw r0
        L_0x03be:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r12)
            throw r0
        L_0x03c4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r13)
            throw r0
        L_0x03ca:
            e.a.a.g0.h.a r0 = r7.n
            e.a.a.j0.c r1 = r7.m
            r0.k(r8, r9, r1)
        L_0x03d1:
            if (r11 > 0) goto L_0x0006
            return
        L_0x03d4:
            e.a.a.i r1 = new e.a.a.i
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unable to establish route: planned = "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = "; current = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x03f3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Planned route may not be null."
            r0.<init>(r1)
            goto L_0x03fc
        L_0x03fb:
            throw r0
        L_0x03fc:
            goto L_0x03fb
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.g.k.c(e.a.a.d0.l.a, e.a.a.k0.c):void");
    }

    public o d(j jVar, m mVar, e.a.a.k0.c cVar) {
        String str;
        int i2;
        j jVar2 = jVar;
        m mVar2 = mVar;
        e.a.a.k0.c cVar2 = cVar;
        p nVar = mVar2 instanceof h ? new n((h) mVar2) : new p(mVar2);
        nVar.d(this.m);
        e.a.a.d0.l.a b2 = b(jVar2, nVar, cVar2);
        j jVar3 = (j) mVar.getParams().e("http.virtual-host");
        this.t = jVar3;
        if (!(jVar3 == null || jVar3.f5172c != -1 || (i2 = jVar2.f5172c) == -1)) {
            this.t = new j(jVar3.f5170a, i2, jVar3.f5173d);
        }
        q qVar = new q(nVar, b2);
        boolean z = false;
        boolean z2 = false;
        o oVar = null;
        while (!z) {
            try {
                p pVar = qVar.f5002a;
                e.a.a.d0.l.a aVar = qVar.f5003b;
                Object b3 = cVar2.b("http.user-token");
                if (this.n == null) {
                    e.a.a.d0.d c2 = this.f4992b.c(aVar, b3);
                    if (mVar2 instanceof e.a.a.c0.k.a) {
                        ((e.a.a.c0.k.a) mVar2).u(c2);
                    }
                    this.n = c2.a(e.a.a.d0.k.a.a(this.m), TimeUnit.MILLISECONDS);
                    if (a.e.a.a.r.b.M(this.m) && this.n.isOpen()) {
                        this.f4991a.debug("Stale connection check");
                        if (this.n.isStale()) {
                            this.f4991a.debug("Stale connection detected");
                            this.n.close();
                        }
                    }
                }
                if (mVar2 instanceof e.a.a.c0.k.a) {
                    ((e.a.a.c0.k.a) mVar2).k(this.n);
                }
                try {
                    j(qVar, cVar2);
                    pVar.x();
                    i(pVar, aVar);
                    j jVar4 = this.t;
                    if (jVar4 == null) {
                        jVar4 = aVar.f4864a;
                    }
                    j d2 = aVar.d();
                    cVar2.e("http.target_host", jVar4);
                    cVar2.e("http.proxy_host", d2);
                    cVar2.e("http.connection", this.n);
                    cVar2.e("http.auth.target-scope", this.o);
                    cVar2.e("http.auth.proxy-scope", this.p);
                    this.f.f(pVar, this.g, cVar2);
                    oVar = k(qVar, cVar2);
                    if (oVar != null) {
                        oVar.d(this.m);
                        this.f.e(oVar, this.g, cVar2);
                        z2 = this.f4994d.a(oVar, cVar2);
                        if (z2) {
                            long a2 = this.f4995e.a(oVar);
                            if (this.f4991a.isDebugEnabled()) {
                                if (a2 > 0) {
                                    str = "for " + a2 + " " + TimeUnit.MILLISECONDS;
                                } else {
                                    str = "indefinitely";
                                }
                                this.f4991a.debug("Connection can be kept alive " + str);
                            }
                            a aVar2 = this.n;
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            if (aVar2 != null) {
                                aVar2.f5009e = a2 > 0 ? timeUnit.toMillis(a2) : -1;
                            } else {
                                throw null;
                            }
                        }
                        q e2 = e(qVar, oVar, cVar2);
                        if (e2 == null) {
                            z = true;
                        } else {
                            if (z2) {
                                a.e.a.a.r.b.f(oVar.b());
                                this.n.f5007c = true;
                            } else {
                                this.n.close();
                                f(this.p);
                                f(this.o);
                            }
                            if (!e2.f5003b.equals(qVar.f5003b)) {
                                h();
                            }
                            qVar = e2;
                        }
                        if (this.n != null && b3 == null) {
                            Object b4 = this.l.b(cVar2);
                            cVar2.e("http.user-token", b4);
                            if (b4 != null) {
                                e.a.a.g0.h.c cVar3 = (e.a.a.g0.h.c) this.n;
                                e.a.a.g0.h.b o2 = cVar3.o();
                                cVar3.m(o2);
                                o2.f5013d = b4;
                            }
                        }
                    }
                } catch (r e3) {
                    r rVar = e3;
                    if (this.f4991a.isDebugEnabled()) {
                        this.f4991a.debug(rVar.getMessage());
                    }
                    oVar = rVar.f5004a;
                }
            } catch (InterruptedException e4) {
                InterruptedIOException interruptedIOException = new InterruptedIOException();
                interruptedIOException.initCause(e4);
                throw interruptedIOException;
            } catch (e.a.a.g0.h.d e5) {
                e.a.a.g0.h.d dVar = e5;
                InterruptedIOException interruptedIOException2 = new InterruptedIOException("Connection has been shut down");
                interruptedIOException2.initCause(dVar);
                throw interruptedIOException2;
            } catch (i e6) {
                i iVar = e6;
                a();
                throw iVar;
            } catch (IOException e7) {
                IOException iOException = e7;
                a();
                throw iOException;
            } catch (RuntimeException e8) {
                RuntimeException runtimeException = e8;
                a();
                throw runtimeException;
            }
        }
        if (!(oVar == null || oVar.b() == null)) {
            if (oVar.b().isStreaming()) {
                oVar.q(new e.a.a.d0.a(oVar.b(), this.n, z2));
                return oVar;
            }
        }
        if (z2) {
            this.n.f5007c = true;
        }
        h();
        return oVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        if (r10.equalsIgnoreCase("HEAD") == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        if (r12 == null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r10.equalsIgnoreCase("HEAD") == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r16 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.a.a.g0.g.q e(e.a.a.g0.g.q r23, e.a.a.o r24, e.a.a.k0.c r25) {
        /*
            r22 = this;
            r7 = r22
            r0 = r23
            r5 = r24
            r6 = r25
            e.a.a.d0.l.a r1 = r0.f5003b
            e.a.a.g0.g.p r2 = r0.f5002a
            e.a.a.j0.c r3 = r2.getParams()
            if (r3 == 0) goto L_0x0373
            java.lang.String r4 = "http.protocol.handle-redirects"
            r8 = 1
            boolean r4 = r3.c(r4, r8)
            java.lang.String r9 = "http.target_host"
            if (r4 == 0) goto L_0x02a4
            e.a.a.g0.g.j r4 = r7.i
            if (r4 == 0) goto L_0x02a2
            e.a.a.z r4 = r24.s()
            e.a.a.i0.m r4 = (e.a.a.i0.m) r4
            int r4 = r4.f5157b
            e.a.a.y r10 = r2.f()
            e.a.a.i0.l r10 = (e.a.a.i0.l) r10
            java.lang.String r10 = r10.f5154b
            java.lang.String r11 = "location"
            e.a.a.c r12 = r5.l(r11)
            r13 = 307(0x133, float:4.3E-43)
            java.lang.String r14 = "GET"
            java.lang.String r15 = "HEAD"
            if (r4 == r13) goto L_0x0052
            switch(r4) {
                case 301: goto L_0x0052;
                case 302: goto L_0x0043;
                case 303: goto L_0x0062;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x005f
        L_0x0043:
            boolean r4 = r10.equalsIgnoreCase(r14)
            if (r4 != 0) goto L_0x004f
            boolean r4 = r10.equalsIgnoreCase(r15)
            if (r4 == 0) goto L_0x005f
        L_0x004f:
            if (r12 == 0) goto L_0x005f
            goto L_0x0062
        L_0x0052:
            boolean r4 = r10.equalsIgnoreCase(r14)
            if (r4 != 0) goto L_0x0062
            boolean r4 = r10.equalsIgnoreCase(r15)
            if (r4 == 0) goto L_0x005f
            goto L_0x0062
        L_0x005f:
            r16 = 0
            goto L_0x0065
        L_0x0062:
            r4 = 1
            r16 = 1
        L_0x0065:
            if (r16 == 0) goto L_0x02a4
            int r0 = r7.r
            int r4 = r7.s
            if (r0 >= r4) goto L_0x0288
            int r0 = r0 + r8
            r7.r = r0
            r0 = 0
            r7.t = r0
            e.a.a.g0.g.j r0 = r7.i
            if (r0 == 0) goto L_0x0286
            e.a.a.c r4 = r5.l(r11)
            if (r4 == 0) goto L_0x026a
            java.lang.String r4 = r4.getValue()
            org.apache.commons.logging.Log r10 = r0.f4990a
            boolean r10 = r10.isDebugEnabled()
            java.lang.String r11 = "'"
            if (r10 == 0) goto L_0x00a4
            org.apache.commons.logging.Log r0 = r0.f4990a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "Redirect requested to location '"
            r10.append(r12)
            r10.append(r4)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r0.debug(r10)
        L_0x00a4:
            java.net.URI r0 = new java.net.URI     // Catch:{ URISyntaxException -> 0x025d }
            r0.<init>(r4)     // Catch:{ URISyntaxException -> 0x025d }
            e.a.a.j0.c r4 = r24.getParams()
            boolean r5 = r0.isAbsolute()
            if (r5 != 0) goto L_0x0108
            java.lang.String r5 = "http.protocol.reject-relative-redirect"
            boolean r5 = r4.f(r5)
            if (r5 != 0) goto L_0x00ec
            java.lang.Object r5 = r6.b(r9)
            e.a.a.j r5 = (e.a.a.j) r5
            if (r5 == 0) goto L_0x00e4
            java.net.URI r9 = new java.net.URI     // Catch:{ URISyntaxException -> 0x00d9 }
            e.a.a.y r10 = r2.f()     // Catch:{ URISyntaxException -> 0x00d9 }
            e.a.a.i0.l r10 = (e.a.a.i0.l) r10     // Catch:{ URISyntaxException -> 0x00d9 }
            java.lang.String r10 = r10.f5155c     // Catch:{ URISyntaxException -> 0x00d9 }
            r9.<init>(r10)     // Catch:{ URISyntaxException -> 0x00d9 }
            java.net.URI r5 = a.e.a.a.r.b.Y(r9, r5, r8)     // Catch:{ URISyntaxException -> 0x00d9 }
            java.net.URI r0 = a.e.a.a.r.b.W(r5, r0)     // Catch:{ URISyntaxException -> 0x00d9 }
            goto L_0x0108
        L_0x00d9:
            r0 = move-exception
            e.a.a.v r1 = new e.a.a.v
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x00e4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Target host not available in the HTTP context"
            r0.<init>(r1)
            throw r0
        L_0x00ec:
            e.a.a.v r1 = new e.a.a.v
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Relative redirect location '"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "' not allowed"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0108:
            java.lang.String r5 = "http.protocol.allow-circular-redirects"
            boolean r4 = r4.d(r5)
            if (r4 == 0) goto L_0x019e
            java.lang.String r4 = "http.protocol.redirect-locations"
            java.lang.Object r5 = r6.b(r4)
            e.a.a.g0.g.o r5 = (e.a.a.g0.g.o) r5
            if (r5 != 0) goto L_0x0122
            e.a.a.g0.g.o r5 = new e.a.a.g0.g.o
            r5.<init>()
            r6.e(r4, r5)
        L_0x0122:
            java.lang.String r4 = r0.getFragment()
            if (r4 == 0) goto L_0x0170
            java.lang.String r4 = r0.getHost()     // Catch:{ URISyntaxException -> 0x0165 }
            int r18 = r0.getPort()     // Catch:{ URISyntaxException -> 0x0165 }
            java.lang.String r8 = r0.getScheme()     // Catch:{ URISyntaxException -> 0x0165 }
            if (r4 == 0) goto L_0x015d
            java.util.Locale r9 = java.util.Locale.ENGLISH     // Catch:{ URISyntaxException -> 0x0165 }
            r4.toLowerCase(r9)     // Catch:{ URISyntaxException -> 0x0165 }
            if (r8 == 0) goto L_0x0144
            java.util.Locale r9 = java.util.Locale.ENGLISH     // Catch:{ URISyntaxException -> 0x0165 }
            java.lang.String r8 = r8.toLowerCase(r9)     // Catch:{ URISyntaxException -> 0x0165 }
            goto L_0x0146
        L_0x0144:
            java.lang.String r8 = "http"
        L_0x0146:
            r16 = r8
            r21 = 0
            java.lang.String r8 = r0.getRawPath()     // Catch:{ URISyntaxException -> 0x0165 }
            java.lang.String r19 = a.e.a.a.r.b.Q(r8)     // Catch:{ URISyntaxException -> 0x0165 }
            java.lang.String r20 = r0.getRawQuery()     // Catch:{ URISyntaxException -> 0x0165 }
            r17 = r4
            java.net.URI r4 = a.e.a.a.r.b.i(r16, r17, r18, r19, r20, r21)     // Catch:{ URISyntaxException -> 0x0165 }
            goto L_0x0171
        L_0x015d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ URISyntaxException -> 0x0165 }
            java.lang.String r1 = "Host name may not be null"
            r0.<init>(r1)     // Catch:{ URISyntaxException -> 0x0165 }
            throw r0     // Catch:{ URISyntaxException -> 0x0165 }
        L_0x0165:
            r0 = move-exception
            e.a.a.v r1 = new e.a.a.v
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L_0x0170:
            r4 = r0
        L_0x0171:
            java.util.Set<java.net.URI> r8 = r5.f4997a
            boolean r8 = r8.contains(r4)
            if (r8 != 0) goto L_0x0184
            java.util.Set<java.net.URI> r8 = r5.f4997a
            r8.add(r4)
            java.util.List<java.net.URI> r5 = r5.f4998b
            r5.add(r4)
            goto L_0x019e
        L_0x0184:
            e.a.a.c0.c r0 = new e.a.a.c0.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Circular redirect to '"
            r1.append(r2)
            r1.append(r4)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x019e:
            e.a.a.y r4 = r2.f()
            e.a.a.i0.l r4 = (e.a.a.i0.l) r4
            java.lang.String r4 = r4.f5154b
            boolean r4 = r4.equalsIgnoreCase(r15)
            if (r4 == 0) goto L_0x01b2
            e.a.a.c0.k.d r4 = new e.a.a.c0.k.d
            r4.<init>((java.net.URI) r0)
            goto L_0x01b7
        L_0x01b2:
            e.a.a.c0.k.c r4 = new e.a.a.c0.k.c
            r4.<init>((java.net.URI) r0)
        L_0x01b7:
            e.a.a.m r0 = r2.f4999c
            e.a.a.c[] r0 = r0.m()
            r4.r(r0)
            java.net.URI r0 = r4.i()
            java.lang.String r2 = r0.getHost()
            if (r2 == 0) goto L_0x0246
            e.a.a.j r2 = new e.a.a.j
            java.lang.String r5 = r0.getHost()
            int r8 = r0.getPort()
            java.lang.String r9 = r0.getScheme()
            r2.<init>(r5, r8, r9)
            e.a.a.b0.e r5 = r7.o
            r8 = 0
            r5.f4843b = r8
            e.a.a.b0.e r5 = r7.p
            r5.f4843b = r8
            e.a.a.j r1 = r1.f4864a
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0202
            e.a.a.b0.e r1 = r7.o
            r1.a()
            e.a.a.b0.e r1 = r7.p
            e.a.a.b0.a r1 = r1.f4842a
            if (r1 == 0) goto L_0x0202
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0202
            e.a.a.b0.e r1 = r7.p
            r1.a()
        L_0x0202:
            boolean r1 = r4 instanceof e.a.a.h
            if (r1 == 0) goto L_0x020e
            e.a.a.g0.g.n r1 = new e.a.a.g0.g.n
            e.a.a.h r4 = (e.a.a.h) r4
            r1.<init>(r4)
            goto L_0x0213
        L_0x020e:
            e.a.a.g0.g.p r1 = new e.a.a.g0.g.p
            r1.<init>(r4)
        L_0x0213:
            r1.d(r3)
            e.a.a.d0.l.a r2 = r7.b(r2, r1, r6)
            e.a.a.g0.g.q r3 = new e.a.a.g0.g.q
            r3.<init>(r1, r2)
            org.apache.commons.logging.Log r1 = r7.f4991a
            boolean r1 = r1.isDebugEnabled()
            if (r1 == 0) goto L_0x0245
            org.apache.commons.logging.Log r1 = r7.f4991a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Redirecting to '"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = "' via "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r1.debug(r0)
        L_0x0245:
            return r3
        L_0x0246:
            e.a.a.v r1 = new e.a.a.v
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Redirect URI does not specify a valid host name: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x025d:
            r0 = move-exception
            e.a.a.v r1 = new e.a.a.v
            java.lang.String r2 = "Invalid redirect URI: "
            java.lang.String r2 = a.a.a.a.a.k(r2, r4)
            r1.<init>(r2, r0)
            throw r1
        L_0x026a:
            e.a.a.v r0 = new e.a.a.v
            java.lang.String r1 = "Received redirect response "
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            e.a.a.z r2 = r24.s()
            r1.append(r2)
            java.lang.String r2 = " but no location header"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0286:
            r0 = 0
            throw r0
        L_0x0288:
            e.a.a.c0.i r0 = new e.a.a.c0.i
            java.lang.String r1 = "Maximum redirects ("
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            int r2 = r7.s
            r1.append(r2)
            java.lang.String r2 = ") exceeded"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x02a2:
            r0 = 0
            throw r0
        L_0x02a4:
            java.lang.String r2 = "http.auth.credentials-provider"
            java.lang.Object r2 = r6.b(r2)
            r10 = r2
            e.a.a.c0.f r10 = (e.a.a.c0.f) r10
            if (r10 == 0) goto L_0x0371
            java.lang.String r2 = "http.protocol.handle-authentication"
            boolean r2 = r3.c(r2, r8)
            if (r2 == 0) goto L_0x0371
            e.a.a.c0.b r2 = r7.j
            boolean r2 = r2.a(r5, r6)
            java.lang.String r8 = "Authentication error: "
            if (r2 == 0) goto L_0x0313
            java.lang.Object r2 = r6.b(r9)
            e.a.a.j r2 = (e.a.a.j) r2
            if (r2 != 0) goto L_0x02cb
            e.a.a.j r2 = r1.f4864a
        L_0x02cb:
            r9 = r2
            org.apache.commons.logging.Log r1 = r7.f4991a
            java.lang.String r2 = "Target requested authentication"
            r1.debug(r2)
            e.a.a.c0.b r1 = r7.j
            java.util.Map r2 = r1.b(r5, r6)
            e.a.a.b0.e r3 = r7.o     // Catch:{ f -> 0x02f4 }
            e.a.a.c0.b r4 = r7.j     // Catch:{ f -> 0x02f4 }
            r1 = r22
            r5 = r24
            r6 = r25
            r1.g(r2, r3, r4, r5, r6)     // Catch:{ f -> 0x02f4 }
            e.a.a.b0.e r1 = r7.o
            r7.l(r1, r9, r10)
            e.a.a.b0.e r1 = r7.o
            e.a.a.b0.h r1 = r1.f4844c
            if (r1 == 0) goto L_0x02f2
            return r0
        L_0x02f2:
            r0 = 0
            return r0
        L_0x02f4:
            r0 = move-exception
            org.apache.commons.logging.Log r1 = r7.f4991a
            boolean r1 = r1.isWarnEnabled()
            if (r1 == 0) goto L_0x0311
            org.apache.commons.logging.Log r1 = r7.f4991a
            java.lang.StringBuilder r2 = a.a.a.a.a.n(r8)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.warn(r0)
        L_0x0311:
            r0 = 0
            return r0
        L_0x0313:
            r2 = 0
            e.a.a.b0.e r3 = r7.o
            r3.f4843b = r2
            e.a.a.c0.b r2 = r7.k
            boolean r2 = r2.a(r5, r6)
            if (r2 == 0) goto L_0x036b
            e.a.a.j r9 = r1.d()
            org.apache.commons.logging.Log r1 = r7.f4991a
            java.lang.String r2 = "Proxy requested authentication"
            r1.debug(r2)
            e.a.a.c0.b r1 = r7.k
            java.util.Map r2 = r1.b(r5, r6)
            e.a.a.b0.e r3 = r7.p     // Catch:{ f -> 0x034c }
            e.a.a.c0.b r4 = r7.k     // Catch:{ f -> 0x034c }
            r1 = r22
            r5 = r24
            r6 = r25
            r1.g(r2, r3, r4, r5, r6)     // Catch:{ f -> 0x034c }
            e.a.a.b0.e r1 = r7.p
            r7.l(r1, r9, r10)
            e.a.a.b0.e r1 = r7.p
            e.a.a.b0.h r1 = r1.f4844c
            if (r1 == 0) goto L_0x034a
            return r0
        L_0x034a:
            r0 = 0
            return r0
        L_0x034c:
            r0 = move-exception
            org.apache.commons.logging.Log r1 = r7.f4991a
            boolean r1 = r1.isWarnEnabled()
            if (r1 == 0) goto L_0x0369
            org.apache.commons.logging.Log r1 = r7.f4991a
            java.lang.StringBuilder r2 = a.a.a.a.a.n(r8)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.warn(r0)
        L_0x0369:
            r0 = 0
            return r0
        L_0x036b:
            r0 = 0
            e.a.a.b0.e r1 = r7.p
            r1.f4843b = r0
            goto L_0x0372
        L_0x0371:
            r0 = 0
        L_0x0372:
            return r0
        L_0x0373:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "HTTP parameters may not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.g.k.e(e.a.a.g0.g.q, e.a.a.o, e.a.a.k0.c):e.a.a.g0.g.q");
    }

    public final void f(e.a.a.b0.e eVar) {
        e.a.a.b0.a aVar = eVar.f4842a;
        if (aVar != null && aVar.e() && aVar.f() && eVar.f4844c != null) {
            eVar.a();
        }
    }

    public final void g(Map<String, e.a.a.c> map, e.a.a.b0.e eVar, e.a.a.c0.b bVar, o oVar, e.a.a.k0.c cVar) {
        e.a.a.b0.a aVar = eVar.f4842a;
        if (aVar == null) {
            a aVar2 = (a) bVar;
            aVar = null;
            if (aVar2 != null) {
                e.a.a.b0.c cVar2 = (e.a.a.b0.c) cVar.b("http.authscheme-registry");
                if (cVar2 != null) {
                    List<String> c2 = aVar2.c(oVar, cVar);
                    if (c2 == null) {
                        c2 = a.f4974b;
                    }
                    if (aVar2.f4975a.isDebugEnabled()) {
                        Log log = aVar2.f4975a;
                        log.debug("Authentication schemes in the order of preference: " + c2);
                    }
                    Iterator<String> it = c2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (map.get(next.toLowerCase(Locale.ENGLISH)) != null) {
                            if (aVar2.f4975a.isDebugEnabled()) {
                                Log log2 = aVar2.f4975a;
                                log2.debug(next + " authentication scheme selected");
                            }
                            try {
                                aVar = cVar2.a(next, oVar.getParams());
                                break;
                            } catch (IllegalStateException unused) {
                                if (aVar2.f4975a.isWarnEnabled()) {
                                    Log log3 = aVar2.f4975a;
                                    log3.warn("Authentication scheme " + next + " not supported");
                                }
                            }
                        } else if (aVar2.f4975a.isDebugEnabled()) {
                            Log log4 = aVar2.f4975a;
                            log4.debug("Challenge for " + next + " authentication scheme not available");
                        }
                    }
                    if (aVar != null) {
                        eVar.f4842a = aVar;
                    } else {
                        throw new f("Unable to respond to any of these challenges: " + map);
                    }
                } else {
                    throw new IllegalStateException("AuthScheme registry not set in HTTP context");
                }
            } else {
                throw null;
            }
        }
        String g2 = aVar.g();
        e.a.a.c cVar3 = map.get(g2.toLowerCase(Locale.ENGLISH));
        if (cVar3 != null) {
            aVar.b(cVar3);
            this.f4991a.debug("Authorization challenge processed");
            return;
        }
        throw new f(a.a.a.a.a.k(g2, " authorization challenge expected, but not found"));
    }

    public void h() {
        try {
            this.n.l();
        } catch (IOException e2) {
            this.f4991a.debug("IOException releasing connection", e2);
        }
        this.n = null;
    }

    public void i(p pVar, e.a.a.d0.l.a aVar) {
        URI uri;
        try {
            URI uri2 = pVar.f5000d;
            if (aVar.d() == null || aVar.f()) {
                if (uri2.isAbsolute()) {
                    uri = a.e.a.a.r.b.Y(uri2, (j) null, false);
                } else {
                    return;
                }
            } else if (!uri2.isAbsolute()) {
                uri = a.e.a.a.r.b.Y(uri2, aVar.f4864a, false);
            } else {
                return;
            }
            pVar.f5000d = uri;
        } catch (URISyntaxException e2) {
            StringBuilder n2 = a.a.a.a.a.n("Invalid URI: ");
            n2.append(((l) pVar.f()).f5155c);
            throw new v(n2.toString(), e2);
        }
    }

    public final void j(q qVar, e.a.a.k0.c cVar) {
        e.a.a.d0.l.a aVar = qVar.f5003b;
        cVar.e("http.request", qVar.f5002a);
        int i2 = 0;
        while (true) {
            i2++;
            try {
                if (!this.n.isOpen()) {
                    this.n.k(aVar, cVar, this.m);
                } else {
                    this.n.setSocketTimeout(a.e.a.a.r.b.C(this.m));
                }
                c(aVar, cVar);
                return;
            } catch (IOException e2) {
                try {
                    this.n.close();
                } catch (IOException unused) {
                }
                if (this.h.a(e2, i2, cVar)) {
                    if (this.f4991a.isInfoEnabled()) {
                        Log log = this.f4991a;
                        StringBuilder n2 = a.a.a.a.a.n("I/O exception (");
                        n2.append(e2.getClass().getName());
                        n2.append(") caught when connecting to the target host: ");
                        n2.append(e2.getMessage());
                        log.info(n2.toString());
                    }
                    if (this.f4991a.isDebugEnabled()) {
                        this.f4991a.debug(e2.getMessage(), e2);
                    }
                    this.f4991a.info("Retrying connect");
                } else {
                    throw e2;
                }
            }
        }
    }

    public final o k(q qVar, e.a.a.k0.c cVar) {
        e.a.a.c0.h hVar;
        p pVar = qVar.f5002a;
        e.a.a.d0.l.a aVar = qVar.f5003b;
        IOException e2 = null;
        while (true) {
            this.q++;
            pVar.g++;
            if (!pVar.w()) {
                this.f4991a.debug("Cannot retry non-repeatable request");
                if (e2 != null) {
                    throw hVar;
                }
                hVar = new e.a.a.c0.h("Cannot retry request with a non-repeatable request entity.");
                throw hVar;
            }
            try {
                if (!this.n.isOpen()) {
                    if (!aVar.f()) {
                        this.f4991a.debug("Reopening the direct connection.");
                        this.n.k(aVar, cVar, this.m);
                    } else {
                        this.f4991a.debug("Proxied connection. Need to start over.");
                        return null;
                    }
                }
                if (this.f4991a.isDebugEnabled()) {
                    this.f4991a.debug("Attempt " + this.q + " to execute request");
                }
                return this.f.d(pVar, this.n, cVar);
            } catch (IOException e3) {
                e2 = e3;
                this.f4991a.debug("Closing the connection.");
                try {
                    this.n.close();
                } catch (IOException unused) {
                }
                if (this.h.a(e2, pVar.g, cVar)) {
                    if (this.f4991a.isInfoEnabled()) {
                        Log log = this.f4991a;
                        StringBuilder n2 = a.a.a.a.a.n("I/O exception (");
                        n2.append(e2.getClass().getName());
                        n2.append(") caught when processing request: ");
                        n2.append(e2.getMessage());
                        log.info(n2.toString());
                    }
                    if (this.f4991a.isDebugEnabled()) {
                        this.f4991a.debug(e2.getMessage(), e2);
                    }
                    this.f4991a.info("Retrying request");
                } else {
                    throw e2;
                }
            }
        }
    }

    public final void l(e.a.a.b0.e eVar, j jVar, e.a.a.c0.f fVar) {
        String str;
        Log log;
        if (eVar.f4842a != null) {
            String str2 = jVar.f5170a;
            int i2 = jVar.f5172c;
            e.a.a.b0.h hVar = null;
            if (i2 < 0) {
                e.a.a.d0.m.g a2 = this.f4992b.a();
                if (a2 != null) {
                    i2 = a2.a(jVar.f5173d).f4884c;
                } else {
                    throw null;
                }
            }
            e.a.a.b0.a aVar = eVar.f4842a;
            e.a.a.b0.d dVar = new e.a.a.b0.d(str2, i2, aVar.d(), aVar.g());
            if (this.f4991a.isDebugEnabled()) {
                Log log2 = this.f4991a;
                log2.debug("Authentication scope: " + dVar);
            }
            e.a.a.b0.h hVar2 = eVar.f4844c;
            if (hVar2 == null) {
                hVar = fVar.a(dVar);
                if (this.f4991a.isDebugEnabled()) {
                    log = this.f4991a;
                    str = hVar != null ? "Found credentials" : "Credentials not found";
                    log.debug(str);
                }
            } else {
                if (aVar.f()) {
                    log = this.f4991a;
                    str = "Authentication failed";
                    log.debug(str);
                }
                eVar.f4843b = dVar;
                eVar.f4844c = hVar2;
            }
            hVar2 = hVar;
            eVar.f4843b = dVar;
            eVar.f4844c = hVar2;
        }
    }
}

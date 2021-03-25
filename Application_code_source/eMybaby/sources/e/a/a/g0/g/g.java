package e.a.a.g0.g;

import a.a.a.a.a;
import e.a.a.d0.b;
import e.a.a.d0.m.h;
import e.a.a.d0.n.d;
import e.a.a.e0.j;
import e.a.a.g0.f.i;
import e.a.a.g0.f.k;
import e.a.a.g0.h.m;
import e.a.a.g0.i.f0;
import e.a.a.g0.i.r;
import e.a.a.g0.i.v;
import e.a.a.g0.i.y;
import e.a.a.j0.c;
import e.a.a.k0.e;
import e.a.a.k0.f;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class g implements e.a.a.c0.g {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4983a;

    /* renamed from: b  reason: collision with root package name */
    public c f4984b;

    /* renamed from: c  reason: collision with root package name */
    public e f4985c;

    /* renamed from: d  reason: collision with root package name */
    public b f4986d;

    /* renamed from: e  reason: collision with root package name */
    public e.a.a.g0.b f4987e;
    public f f;
    public j g;
    public e.a.a.b0.c h;
    public e.a.a.k0.b i;
    public f j;
    public h k;
    public j l;
    public e.a.a.c0.b m;
    public e.a.a.c0.b n;
    public e.a.a.c0.e o;
    public e.a.a.c0.f p;
    public e.a.a.g0.h.g q;
    public m r;

    public g() {
        this.f4983a = LogFactory.getLog(g.class);
        this.f4984b = null;
        this.f4986d = null;
    }

    public e.a.a.b0.c a() {
        e.a.a.b0.c cVar = new e.a.a.b0.c();
        cVar.b("Basic", new e.a.a.g0.f.c());
        cVar.b("Digest", new e.a.a.g0.f.e());
        cVar.b("NTLM", new i());
        cVar.b("negotiate", new k());
        return cVar;
    }

    public b b() {
        e.a.a.d0.m.g gVar = new e.a.a.d0.m.g();
        gVar.b(new e.a.a.d0.m.f("http", 80, (h) new e.a.a.d0.m.e()));
        gVar.b(new e.a.a.d0.m.f("https", 443, (h) new d()));
        c i2 = i();
        e.a.a.d0.c cVar = null;
        String str = (String) i2.e("http.connection-manager.factory-class-name");
        if (str != null) {
            try {
                cVar = (e.a.a.d0.c) Class.forName(str).newInstance();
            } catch (ClassNotFoundException unused) {
                throw new IllegalStateException(a.k("Invalid class name: ", str));
            } catch (IllegalAccessException e2) {
                throw new IllegalAccessError(e2.getMessage());
            } catch (InstantiationException e3) {
                throw new InstantiationError(e3.getMessage());
            }
        }
        return cVar != null ? cVar.a(i2, gVar) : new m(gVar);
    }

    public j c() {
        j jVar = new j();
        jVar.a("best-match", new e.a.a.g0.i.k());
        jVar.a("compatibility", new e.a.a.g0.i.m());
        jVar.a("netscape", new v());
        jVar.a("rfc2109", new y());
        jVar.a("rfc2965", new f0());
        jVar.a("ignoreCookies", new r());
        return jVar;
    }

    public e.a.a.k0.c d() {
        e.a.a.b0.c cVar;
        j jVar;
        e.a.a.c0.e eVar;
        e.a.a.c0.f fVar;
        e.a.a.k0.a aVar = new e.a.a.k0.a();
        aVar.e("http.scheme-registry", h().a());
        synchronized (this) {
            if (this.h == null) {
                this.h = a();
            }
            cVar = this.h;
        }
        aVar.e("http.authscheme-registry", cVar);
        synchronized (this) {
            if (this.g == null) {
                this.g = c();
            }
            jVar = this.g;
        }
        aVar.e("http.cookiespec-registry", jVar);
        synchronized (this) {
            if (this.o == null) {
                this.o = new c();
            }
            eVar = this.o;
        }
        aVar.e("http.cookie-store", eVar);
        synchronized (this) {
            if (this.p == null) {
                this.p = new d();
            }
            fVar = this.p;
        }
        aVar.e("http.auth.credentials-provider", fVar);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.a.a.j0.c e() {
        /*
            r10 = this;
            e.a.a.j0.d r0 = new e.a.a.j0.d
            r0.<init>()
            e.a.a.q r1 = e.a.a.q.f
            java.lang.String r2 = "http.protocol.version"
            r0.setParameter(r2, r1)
            java.lang.String r1 = "http.protocol.content-charset"
            java.lang.String r2 = "ISO-8859-1"
            r0.setParameter(r1, r2)
            r1 = 1
            java.lang.String r2 = "http.tcp.nodelay"
            r0.g(r2, r1)
            r2 = 8192(0x2000, float:1.14794E-41)
            java.lang.String r3 = "http.socket.buffer-size"
            r0.h(r3, r2)
            java.lang.String r5 = "org.apache.http.client"
            java.lang.Class<e.a.a.g0.g.g> r2 = e.a.a.g0.g.g.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            if (r2 != 0) goto L_0x0032
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r2 = r2.getContextClassLoader()
        L_0x0032:
            r3 = 0
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x006a }
            r4.<init>()     // Catch:{ IOException -> 0x006a }
            r6 = 46
            r7 = 47
            java.lang.String r6 = r5.replace(r6, r7)     // Catch:{ IOException -> 0x006a }
            r4.append(r6)     // Catch:{ IOException -> 0x006a }
            java.lang.String r6 = "/"
            r4.append(r6)     // Catch:{ IOException -> 0x006a }
            java.lang.String r6 = "version.properties"
            r4.append(r6)     // Catch:{ IOException -> 0x006a }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x006a }
            java.io.InputStream r4 = r2.getResourceAsStream(r4)     // Catch:{ IOException -> 0x006a }
            if (r4 == 0) goto L_0x006a
            java.util.Properties r6 = new java.util.Properties     // Catch:{ all -> 0x0065 }
            r6.<init>()     // Catch:{ all -> 0x0065 }
            r6.load(r4)     // Catch:{ all -> 0x0065 }
            r4.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x006b
        L_0x0063:
            goto L_0x006b
        L_0x0065:
            r6 = move-exception
            r4.close()     // Catch:{ IOException -> 0x006a }
            throw r6     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            r6 = r3
        L_0x006b:
            if (r6 == 0) goto L_0x00c8
            java.lang.String r4 = "info.module"
            java.lang.Object r4 = r6.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x007f
            int r7 = r4.length()
            if (r7 >= r1) goto L_0x007f
            r7 = r3
            goto L_0x0080
        L_0x007f:
            r7 = r4
        L_0x0080:
            java.lang.String r4 = "info.release"
            java.lang.Object r4 = r6.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x009a
            int r8 = r4.length()
            if (r8 < r1) goto L_0x0098
            java.lang.String r8 = "${pom.version}"
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto L_0x009a
        L_0x0098:
            r8 = r3
            goto L_0x009b
        L_0x009a:
            r8 = r4
        L_0x009b:
            java.lang.String r4 = "info.timestamp"
            java.lang.Object r4 = r6.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00b5
            int r6 = r4.length()
            if (r6 < r1) goto L_0x00b3
            java.lang.String r1 = "${mvn.timestamp}"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x00b5
        L_0x00b3:
            r1 = r3
            goto L_0x00b6
        L_0x00b5:
            r1 = r4
        L_0x00b6:
            if (r2 == 0) goto L_0x00be
            java.lang.String r2 = r2.toString()
            r9 = r2
            goto L_0x00bf
        L_0x00be:
            r9 = r3
        L_0x00bf:
            e.a.a.l0.d r3 = new e.a.a.l0.d
            r4 = r3
            r6 = r7
            r7 = r8
            r8 = r1
            r4.<init>(r5, r6, r7, r8, r9)
        L_0x00c8:
            if (r3 == 0) goto L_0x00cd
            java.lang.String r1 = r3.f5189c
            goto L_0x00cf
        L_0x00cd:
            java.lang.String r1 = "UNAVAILABLE"
        L_0x00cf:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Apache-HttpClient/"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " (java 1.5)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "http.useragent"
            r0.setParameter(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.g.g.e():e.a.a.j0.c");
    }

    public e.a.a.k0.b f() {
        e.a.a.k0.b bVar = new e.a.a.k0.b();
        bVar.d(new e.a.a.c0.l.d());
        bVar.d(new e.a.a.k0.g());
        bVar.d(new e.a.a.k0.i());
        bVar.d(new e.a.a.c0.l.c());
        bVar.d(new e.a.a.k0.j());
        bVar.d(new e.a.a.k0.h());
        bVar.d(new e.a.a.c0.l.a());
        bVar.f5178b.add(new e.a.a.c0.l.h());
        bVar.d(new e.a.a.c0.l.b());
        bVar.f5178b.add(new e.a.a.c0.l.g());
        bVar.d(new e.a.a.c0.l.f());
        bVar.d(new e.a.a.c0.l.e());
        return bVar;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    public final e.a.a.o g(e.a.a.c0.k.g r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.net.URI r2 = r23.i()
            boolean r3 = r2.isAbsolute()
            if (r3 == 0) goto L_0x0080
            boolean r3 = r2.isAbsolute()
            if (r3 == 0) goto L_0x0065
            int r3 = r2.getPort()
            java.lang.String r5 = r2.getHost()
            if (r5 != 0) goto L_0x0059
            java.lang.String r5 = r2.getAuthority()
            if (r5 == 0) goto L_0x0059
            r6 = 64
            int r6 = r5.indexOf(r6)
            if (r6 < 0) goto L_0x003a
            int r7 = r5.length()
            int r6 = r6 + 1
            if (r7 <= r6) goto L_0x0039
            java.lang.String r5 = r5.substring(r6)
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            if (r5 == 0) goto L_0x0059
            r6 = 58
            int r6 = r5.indexOf(r6)
            if (r6 < 0) goto L_0x0059
            int r7 = r6 + 1
            int r8 = r5.length()
            if (r7 >= r8) goto L_0x0054
            java.lang.String r3 = r5.substring(r7)
            int r3 = java.lang.Integer.parseInt(r3)
        L_0x0054:
            r7 = 0
            java.lang.String r5 = r5.substring(r7, r6)
        L_0x0059:
            java.lang.String r6 = r2.getScheme()
            if (r5 == 0) goto L_0x0065
            e.a.a.j r7 = new e.a.a.j
            r7.<init>(r5, r3, r6)
            goto L_0x0066
        L_0x0065:
            r7 = 0
        L_0x0066:
            if (r7 == 0) goto L_0x0069
            goto L_0x0081
        L_0x0069:
            e.a.a.c0.d r0 = new e.a.a.c0.d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "URI does not specify a valid host name: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x0080:
            r7 = 0
        L_0x0081:
            monitor-enter(r22)
            e.a.a.k0.c r2 = r22.d()     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.k0.e r3 = r1.f4985c     // Catch:{ all -> 0x016d }
            if (r3 != 0) goto L_0x0092
            e.a.a.k0.e r3 = new e.a.a.k0.e     // Catch:{ all -> 0x016d }
            r3.<init>()     // Catch:{ all -> 0x016d }
            r1.f4985c = r3     // Catch:{ all -> 0x016d }
        L_0x0092:
            e.a.a.k0.e r10 = r1.f4985c     // Catch:{ all -> 0x016d }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.d0.b r11 = r22.h()     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.g0.b r3 = r1.f4987e     // Catch:{ all -> 0x016a }
            if (r3 != 0) goto L_0x00a5
            e.a.a.g0.b r3 = new e.a.a.g0.b     // Catch:{ all -> 0x016a }
            r3.<init>()     // Catch:{ all -> 0x016a }
            r1.f4987e = r3     // Catch:{ all -> 0x016a }
        L_0x00a5:
            e.a.a.g0.b r12 = r1.f4987e     // Catch:{ all -> 0x016a }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.g0.g.f r3 = r1.f     // Catch:{ all -> 0x0167 }
            if (r3 != 0) goto L_0x00b4
            e.a.a.g0.g.f r3 = new e.a.a.g0.g.f     // Catch:{ all -> 0x0167 }
            r3.<init>()     // Catch:{ all -> 0x0167 }
            r1.f = r3     // Catch:{ all -> 0x0167 }
        L_0x00b4:
            e.a.a.g0.g.f r13 = r1.f     // Catch:{ all -> 0x0167 }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.g0.h.g r3 = r1.q     // Catch:{ all -> 0x0164 }
            if (r3 != 0) goto L_0x00cb
            e.a.a.g0.h.g r3 = new e.a.a.g0.h.g     // Catch:{ all -> 0x0164 }
            e.a.a.d0.b r5 = r22.h()     // Catch:{ all -> 0x0164 }
            e.a.a.d0.m.g r5 = r5.a()     // Catch:{ all -> 0x0164 }
            r3.<init>(r5)     // Catch:{ all -> 0x0164 }
            r1.q = r3     // Catch:{ all -> 0x0164 }
        L_0x00cb:
            e.a.a.g0.h.g r14 = r1.q     // Catch:{ all -> 0x0164 }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.k0.d r15 = r22.j()     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.g0.g.h r3 = r1.k     // Catch:{ all -> 0x0161 }
            if (r3 != 0) goto L_0x00de
            e.a.a.g0.g.h r3 = new e.a.a.g0.g.h     // Catch:{ all -> 0x0161 }
            r3.<init>()     // Catch:{ all -> 0x0161 }
            r1.k = r3     // Catch:{ all -> 0x0161 }
        L_0x00de:
            e.a.a.g0.g.h r3 = r1.k     // Catch:{ all -> 0x0161 }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.g0.g.j r5 = r1.l     // Catch:{ all -> 0x015e }
            if (r5 != 0) goto L_0x00ed
            e.a.a.g0.g.j r5 = new e.a.a.g0.g.j     // Catch:{ all -> 0x015e }
            r5.<init>()     // Catch:{ all -> 0x015e }
            r1.l = r5     // Catch:{ all -> 0x015e }
        L_0x00ed:
            e.a.a.g0.g.j r5 = r1.l     // Catch:{ all -> 0x015e }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.c0.b r6 = r1.m     // Catch:{ all -> 0x015b }
            if (r6 != 0) goto L_0x00fc
            e.a.a.g0.g.l r6 = new e.a.a.g0.g.l     // Catch:{ all -> 0x015b }
            r6.<init>()     // Catch:{ all -> 0x015b }
            r1.m = r6     // Catch:{ all -> 0x015b }
        L_0x00fc:
            e.a.a.c0.b r6 = r1.m     // Catch:{ all -> 0x015b }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.c0.b r8 = r1.n     // Catch:{ all -> 0x0158 }
            if (r8 != 0) goto L_0x010b
            e.a.a.g0.g.i r8 = new e.a.a.g0.g.i     // Catch:{ all -> 0x0158 }
            r8.<init>()     // Catch:{ all -> 0x0158 }
            r1.n = r8     // Catch:{ all -> 0x0158 }
        L_0x010b:
            e.a.a.c0.b r9 = r1.n     // Catch:{ all -> 0x0158 }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            monitor-enter(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.g0.g.m r8 = r1.r     // Catch:{ all -> 0x0155 }
            if (r8 != 0) goto L_0x011a
            e.a.a.g0.g.m r8 = new e.a.a.g0.g.m     // Catch:{ all -> 0x0155 }
            r8.<init>()     // Catch:{ all -> 0x0155 }
            r1.r = r8     // Catch:{ all -> 0x0155 }
        L_0x011a:
            e.a.a.g0.g.m r8 = r1.r     // Catch:{ all -> 0x0155 }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            e.a.a.g0.g.e r4 = new e.a.a.g0.g.e     // Catch:{ all -> 0x0170 }
            r17 = r8
            e.a.a.j0.c r8 = r22.i()     // Catch:{ all -> 0x0170 }
            r18 = r0
            e.a.a.i0.a r18 = (e.a.a.i0.a) r18
            r19 = r9
            e.a.a.j0.c r9 = r18.getParams()     // Catch:{ all -> 0x0170 }
            r0 = 0
            r4.<init>(r0, r8, r9, r0)     // Catch:{ all -> 0x0170 }
            e.a.a.g0.g.k r0 = new e.a.a.g0.g.k     // Catch:{ all -> 0x0170 }
            org.apache.commons.logging.Log r9 = r1.f4983a     // Catch:{ all -> 0x0170 }
            r20 = r17
            r8 = r0
            r16 = r3
            r17 = r5
            r18 = r6
            r21 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0170 }
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            r3 = r23
            e.a.a.o r0 = r0.d(r7, r3, r2)     // Catch:{ i -> 0x014d }
            return r0
        L_0x014d:
            r0 = move-exception
            r2 = r0
            e.a.a.c0.d r0 = new e.a.a.c0.d
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0155:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x0158:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x015b:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x015e:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x0161:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x0164:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x0167:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x016a:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x016d:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0     // Catch:{ all -> 0x0170 }
        L_0x0170:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0170 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.g.g.g(e.a.a.c0.k.g):e.a.a.o");
    }

    public final synchronized b h() {
        if (this.f4986d == null) {
            this.f4986d = b();
        }
        return this.f4986d;
    }

    public final synchronized c i() {
        if (this.f4984b == null) {
            this.f4984b = e();
        }
        return this.f4984b;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized e.a.a.k0.d j() {
        /*
            r7 = this;
            monitor-enter(r7)
            e.a.a.k0.f r0 = r7.j     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0067
            monitor-enter(r7)     // Catch:{ all -> 0x006b }
            e.a.a.k0.b r0 = r7.i     // Catch:{ all -> 0x0064 }
            if (r0 != 0) goto L_0x0010
            e.a.a.k0.b r0 = r7.f()     // Catch:{ all -> 0x0064 }
            r7.i = r0     // Catch:{ all -> 0x0064 }
        L_0x0010:
            e.a.a.k0.b r0 = r7.i     // Catch:{ all -> 0x0064 }
            monitor-exit(r7)     // Catch:{ all -> 0x006b }
            java.util.List r1 = r0.f5177a     // Catch:{ all -> 0x006b }
            int r1 = r1.size()     // Catch:{ all -> 0x006b }
            e.a.a.n[] r2 = new e.a.a.n[r1]     // Catch:{ all -> 0x006b }
            r3 = 0
            r4 = 0
        L_0x001d:
            r5 = 0
            if (r4 >= r1) goto L_0x0038
            if (r4 < 0) goto L_0x0033
            java.util.List r6 = r0.f5177a     // Catch:{ all -> 0x006b }
            int r6 = r6.size()     // Catch:{ all -> 0x006b }
            if (r4 < r6) goto L_0x002b
            goto L_0x0033
        L_0x002b:
            java.util.List r5 = r0.f5177a     // Catch:{ all -> 0x006b }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x006b }
            e.a.a.n r5 = (e.a.a.n) r5     // Catch:{ all -> 0x006b }
        L_0x0033:
            r2[r4] = r5     // Catch:{ all -> 0x006b }
            int r4 = r4 + 1
            goto L_0x001d
        L_0x0038:
            java.util.List r1 = r0.f5178b     // Catch:{ all -> 0x006b }
            int r1 = r1.size()     // Catch:{ all -> 0x006b }
            e.a.a.p[] r4 = new e.a.a.p[r1]     // Catch:{ all -> 0x006b }
        L_0x0040:
            if (r3 >= r1) goto L_0x005c
            if (r3 < 0) goto L_0x0056
            java.util.List r6 = r0.f5178b     // Catch:{ all -> 0x006b }
            int r6 = r6.size()     // Catch:{ all -> 0x006b }
            if (r3 < r6) goto L_0x004d
            goto L_0x0056
        L_0x004d:
            java.util.List r6 = r0.f5178b     // Catch:{ all -> 0x006b }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ all -> 0x006b }
            e.a.a.p r6 = (e.a.a.p) r6     // Catch:{ all -> 0x006b }
            goto L_0x0057
        L_0x0056:
            r6 = r5
        L_0x0057:
            r4[r3] = r6     // Catch:{ all -> 0x006b }
            int r3 = r3 + 1
            goto L_0x0040
        L_0x005c:
            e.a.a.k0.f r0 = new e.a.a.k0.f     // Catch:{ all -> 0x006b }
            r0.<init>(r2, r4)     // Catch:{ all -> 0x006b }
            r7.j = r0     // Catch:{ all -> 0x006b }
            goto L_0x0067
        L_0x0064:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x006b }
            throw r0     // Catch:{ all -> 0x006b }
        L_0x0067:
            e.a.a.k0.f r0 = r7.j     // Catch:{ all -> 0x006b }
            monitor-exit(r7)
            return r0
        L_0x006b:
            r0 = move-exception
            monitor-exit(r7)
            goto L_0x006f
        L_0x006e:
            throw r0
        L_0x006f:
            goto L_0x006e
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.g.g.j():e.a.a.k0.d");
    }

    public g(b bVar, c cVar) {
        this.f4983a = LogFactory.getLog(g.class);
        this.f4984b = cVar;
        this.f4986d = bVar;
    }
}

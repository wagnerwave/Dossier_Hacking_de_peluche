package e.a.a.g0.h;

import e.a.a.d0.d;
import e.a.a.d0.m.g;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class m implements e.a.a.d0.b {

    /* renamed from: a  reason: collision with root package name */
    public final Log f5026a = LogFactory.getLog(m.class);

    /* renamed from: b  reason: collision with root package name */
    public final g f5027b;

    /* renamed from: c  reason: collision with root package name */
    public final f f5028c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5029d;

    /* renamed from: e  reason: collision with root package name */
    public volatile c f5030e;
    public volatile b f;
    public volatile long g;
    public volatile long h;
    public volatile boolean i;

    public class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.a.a.d0.l.a f5031a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f5032b;

        public a(e.a.a.d0.l.a aVar, Object obj) {
            this.f5031a = aVar;
            this.f5032b = obj;
        }

        public a a(long j, TimeUnit timeUnit) {
            boolean z;
            b bVar;
            m mVar = m.this;
            e.a.a.d0.l.a aVar = this.f5031a;
            if (mVar == null) {
                throw null;
            } else if (aVar != null) {
                mVar.d();
                if (mVar.f5026a.isDebugEnabled()) {
                    Log log = mVar.f5026a;
                    log.debug("Get connection for route " + aVar);
                }
                synchronized (mVar) {
                    if (mVar.f == null) {
                        mVar.e();
                        boolean z2 = false;
                        boolean z3 = true;
                        if (mVar.f5030e.f5011b.i) {
                            e.a.a.d0.l.d dVar = mVar.f5030e.f5014e;
                            z2 = dVar == null || !dVar.e().equals(aVar);
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z2) {
                            try {
                                c cVar = mVar.f5030e;
                                cVar.a();
                                if (cVar.f5011b.i) {
                                    cVar.f5011b.shutdown();
                                }
                            } catch (IOException e2) {
                                mVar.f5026a.debug("Problem shutting down connection.", e2);
                            }
                        } else {
                            z3 = z;
                        }
                        if (z3) {
                            mVar.f5030e = new c();
                        }
                        mVar.f = new b(mVar.f5030e, aVar);
                        bVar = mVar.f;
                    } else {
                        throw new IllegalStateException("Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
                    }
                }
                return bVar;
            } else {
                throw new IllegalArgumentException("Route may not be null.");
            }
        }
    }

    public class b extends c {
        public b(c cVar, e.a.a.d0.l.a aVar) {
            super(m.this, cVar);
            this.f5007c = true;
            cVar.f5012c = aVar;
        }
    }

    public class c extends b {
        public c() {
            super(m.this.f5028c, (e.a.a.d0.l.a) null);
        }
    }

    public m(g gVar) {
        this.f5027b = gVar;
        this.f5028c = new f(gVar);
        this.f5030e = new c();
        this.f = null;
        this.g = -1;
        this.f5029d = false;
        this.i = false;
    }

    public g a() {
        return this.f5027b;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0065=Splitter:B:30:0x0065, B:59:0x00b5=Splitter:B:59:0x00b5, B:50:0x0098=Splitter:B:50:0x0098} */
    public void b(e.a.a.g0.h.a r9, long r10, java.util.concurrent.TimeUnit r12) {
        /*
            r8 = this;
            r8.d()
            boolean r0 = r9 instanceof e.a.a.g0.h.m.b
            if (r0 == 0) goto L_0x00de
            org.apache.commons.logging.Log r0 = r8.f5026a
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0025
            org.apache.commons.logging.Log r0 = r8.f5026a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Releasing connection "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.debug(r1)
        L_0x0025:
            e.a.a.g0.h.m$b r9 = (e.a.a.g0.h.m.b) r9
            monitor-enter(r9)
            e.a.a.g0.h.b r0 = r9.f     // Catch:{ all -> 0x00db }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r9)     // Catch:{ all -> 0x00db }
            return
        L_0x002e:
            e.a.a.d0.b r0 = r9.f5005a     // Catch:{ all -> 0x00db }
            if (r0 == 0) goto L_0x003d
            if (r0 != r8) goto L_0x0035
            goto L_0x003d
        L_0x0035:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00db }
            java.lang.String r11 = "Connection not obtained from this manager."
            r10.<init>(r11)     // Catch:{ all -> 0x00db }
            throw r10     // Catch:{ all -> 0x00db }
        L_0x003d:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r2 = 0
            r4 = 0
            boolean r5 = r9.isOpen()     // Catch:{ IOException -> 0x0088 }
            if (r5 == 0) goto L_0x0065
            boolean r5 = r8.f5029d     // Catch:{ IOException -> 0x0088 }
            if (r5 != 0) goto L_0x0053
            boolean r5 = r9.f5007c     // Catch:{ IOException -> 0x0088 }
            if (r5 != 0) goto L_0x0065
        L_0x0053:
            org.apache.commons.logging.Log r5 = r8.f5026a     // Catch:{ IOException -> 0x0088 }
            boolean r5 = r5.isDebugEnabled()     // Catch:{ IOException -> 0x0088 }
            if (r5 == 0) goto L_0x0062
            org.apache.commons.logging.Log r5 = r8.f5026a     // Catch:{ IOException -> 0x0088 }
            java.lang.String r6 = "Released connection open but not reusable."
            r5.debug(r6)     // Catch:{ IOException -> 0x0088 }
        L_0x0062:
            r9.shutdown()     // Catch:{ IOException -> 0x0088 }
        L_0x0065:
            r9.n()     // Catch:{ all -> 0x00db }
            monitor-enter(r8)     // Catch:{ all -> 0x00db }
            r8.f = r4     // Catch:{ all -> 0x0083 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0083 }
            r8.g = r4     // Catch:{ all -> 0x0083 }
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x007f
            long r10 = r12.toMillis(r10)     // Catch:{ all -> 0x0083 }
            long r0 = r8.g     // Catch:{ all -> 0x0083 }
            long r10 = r10 + r0
            r8.h = r10     // Catch:{ all -> 0x0083 }
            goto L_0x0081
        L_0x007f:
            r8.h = r0     // Catch:{ all -> 0x0083 }
        L_0x0081:
            monitor-exit(r8)     // Catch:{ all -> 0x0083 }
            goto L_0x00b5
        L_0x0083:
            r10 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0083 }
            throw r10     // Catch:{ all -> 0x00db }
        L_0x0086:
            r5 = move-exception
            goto L_0x00ba
        L_0x0088:
            r5 = move-exception
            org.apache.commons.logging.Log r6 = r8.f5026a     // Catch:{ all -> 0x0086 }
            boolean r6 = r6.isDebugEnabled()     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x0098
            org.apache.commons.logging.Log r6 = r8.f5026a     // Catch:{ all -> 0x0086 }
            java.lang.String r7 = "Exception shutting down released connection."
            r6.debug(r7, r5)     // Catch:{ all -> 0x0086 }
        L_0x0098:
            r9.n()     // Catch:{ all -> 0x00db }
            monitor-enter(r8)     // Catch:{ all -> 0x00db }
            r8.f = r4     // Catch:{ all -> 0x00b7 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b7 }
            r8.g = r4     // Catch:{ all -> 0x00b7 }
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b2
            long r10 = r12.toMillis(r10)     // Catch:{ all -> 0x00b7 }
            long r0 = r8.g     // Catch:{ all -> 0x00b7 }
            long r10 = r10 + r0
            r8.h = r10     // Catch:{ all -> 0x00b7 }
            goto L_0x00b4
        L_0x00b2:
            r8.h = r0     // Catch:{ all -> 0x00b7 }
        L_0x00b4:
            monitor-exit(r8)     // Catch:{ all -> 0x00b7 }
        L_0x00b5:
            monitor-exit(r9)     // Catch:{ all -> 0x00db }
            return
        L_0x00b7:
            r10 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00b7 }
            throw r10     // Catch:{ all -> 0x00db }
        L_0x00ba:
            r9.n()     // Catch:{ all -> 0x00db }
            monitor-enter(r8)     // Catch:{ all -> 0x00db }
            r8.f = r4     // Catch:{ all -> 0x00d8 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d8 }
            r8.g = r6     // Catch:{ all -> 0x00d8 }
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d4
            long r10 = r12.toMillis(r10)     // Catch:{ all -> 0x00d8 }
            long r0 = r8.g     // Catch:{ all -> 0x00d8 }
            long r10 = r10 + r0
            r8.h = r10     // Catch:{ all -> 0x00d8 }
            goto L_0x00d6
        L_0x00d4:
            r8.h = r0     // Catch:{ all -> 0x00d8 }
        L_0x00d6:
            monitor-exit(r8)     // Catch:{ all -> 0x00d8 }
            throw r5     // Catch:{ all -> 0x00db }
        L_0x00d8:
            r10 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00d8 }
            throw r10     // Catch:{ all -> 0x00db }
        L_0x00db:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00db }
            throw r10
        L_0x00de:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Connection class mismatch, connection not obtained from this manager."
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.m.b(e.a.a.g0.h.a, long, java.util.concurrent.TimeUnit):void");
    }

    public final d c(e.a.a.d0.l.a aVar, Object obj) {
        return new a(aVar, obj);
    }

    public final void d() {
        if (this.i) {
            throw new IllegalStateException("Manager is shut down.");
        }
    }

    public void e() {
        if (System.currentTimeMillis() >= this.h) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            d();
            if (timeUnit != null) {
                synchronized (this) {
                    if (this.f == null && this.f5030e.f5011b.i) {
                        if (this.g <= System.currentTimeMillis() - timeUnit.toMillis(0)) {
                            try {
                                c cVar = this.f5030e;
                                cVar.a();
                                if (cVar.f5011b.i) {
                                    cVar.f5011b.close();
                                }
                            } catch (IOException e2) {
                                this.f5026a.debug("Problem closing idle connection.", e2);
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Time unit must not be null.");
        }
    }

    public void f() {
        this.i = true;
        b bVar = this.f;
        if (bVar != null) {
            bVar.n();
        }
        synchronized (this) {
            try {
                if (this.f5030e != null) {
                    c cVar = this.f5030e;
                    cVar.a();
                    if (cVar.f5011b.i) {
                        cVar.f5011b.shutdown();
                    }
                }
            } catch (IOException e2) {
                try {
                    this.f5026a.debug("Problem while shutting down manager.", e2);
                } catch (Throwable th) {
                    this.f5030e = null;
                    this.f = null;
                    throw th;
                }
            }
            this.f5030e = null;
            this.f = null;
        }
    }

    public void finalize() {
        try {
            f();
        } finally {
            super.finalize();
        }
    }
}

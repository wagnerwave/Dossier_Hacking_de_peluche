package e.a.a.g0.h.o;

import e.a.a.d0.b;
import e.a.a.d0.d;
import e.a.a.d0.m.g;
import e.a.a.g0.h.f;
import e.a.a.j0.c;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Log f5049a;

    /* renamed from: b  reason: collision with root package name */
    public final g f5050b;

    /* renamed from: c  reason: collision with root package name */
    public final e f5051c;

    /* renamed from: d  reason: collision with root package name */
    public final f f5052d;

    public class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5053a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e.a.a.d0.l.a f5054b;

        public a(f fVar, e.a.a.d0.l.a aVar) {
            this.f5053a = fVar;
            this.f5054b = aVar;
        }

        public e.a.a.g0.h.a a(long j, TimeUnit timeUnit) {
            g g;
            i iVar;
            if (this.f5054b != null) {
                if (h.this.f5049a.isDebugEnabled()) {
                    Log log = h.this.f5049a;
                    StringBuilder n = a.a.a.a.a.n("Get connection: ");
                    n.append(this.f5054b);
                    n.append(", timeout = ");
                    n.append(j);
                    log.debug(n.toString());
                }
                d dVar = (d) this.f5053a;
                e eVar = dVar.f5040d;
                e.a.a.d0.l.a aVar = dVar.f5038b;
                Object obj = dVar.f5039c;
                j jVar = dVar.f5037a;
                if (eVar != null) {
                    Date date = j > 0 ? new Date(timeUnit.toMillis(j) + System.currentTimeMillis()) : null;
                    eVar.f5042d.lock();
                    try {
                        g = eVar.g(aVar, true);
                        b bVar = null;
                        iVar = null;
                        while (true) {
                            if (bVar != null) {
                                break;
                            } else if (!eVar.m) {
                                if (eVar.f5041c.isDebugEnabled()) {
                                    Log log2 = eVar.f5041c;
                                    log2.debug("[" + aVar + "] total kept alive: " + eVar.h.size() + ", total issued: " + eVar.g.size() + ", total allocated: " + eVar.o + " out of " + eVar.n);
                                }
                                bVar = eVar.f(g, obj);
                                if (bVar != null) {
                                    break;
                                }
                                boolean z = g.d() > 0;
                                if (eVar.f5041c.isDebugEnabled()) {
                                    Log log3 = eVar.f5041c;
                                    log3.debug("Available capacity: " + g.d() + " out of " + g.f5046c + " [" + aVar + "][" + obj + "]");
                                }
                                if (!z || eVar.o >= eVar.n) {
                                    if (!z || eVar.h.isEmpty()) {
                                        if (eVar.f5041c.isDebugEnabled()) {
                                            Log log4 = eVar.f5041c;
                                            log4.debug("Need to wait for connection [" + aVar + "][" + obj + "]");
                                        }
                                        if (iVar == null) {
                                            i iVar2 = new i(eVar.f5042d.newCondition(), g);
                                            if (jVar != null) {
                                                iVar = iVar2;
                                            } else {
                                                throw null;
                                            }
                                        }
                                        g.f.add(iVar);
                                        eVar.i.add(iVar);
                                        boolean a2 = iVar.a(date);
                                        g.f.remove(iVar);
                                        eVar.i.remove(iVar);
                                        if (!a2 && date != null) {
                                            if (date.getTime() <= System.currentTimeMillis()) {
                                                throw new e.a.a.d0.f("Timeout waiting for connection");
                                            }
                                        }
                                    } else {
                                        eVar.d();
                                        g = eVar.g(aVar, true);
                                    }
                                }
                                bVar = eVar.b(g, eVar.f5043e);
                            } else {
                                throw new IllegalStateException("Connection pool shut down");
                            }
                        }
                        eVar.f5042d.unlock();
                        return new c(h.this, bVar);
                    } catch (Throwable th) {
                        eVar.f5042d.unlock();
                        throw th;
                    }
                } else {
                    throw null;
                }
            } else {
                throw new IllegalArgumentException("Route may not be null.");
            }
        }
    }

    @Deprecated
    public h(c cVar, g gVar) {
        if (gVar != null) {
            this.f5049a = LogFactory.getLog(h.class);
            this.f5050b = gVar;
            new ConcurrentHashMap();
            f fVar = new f(gVar);
            this.f5052d = fVar;
            this.f5051c = new e(fVar, cVar);
            return;
        }
        throw new IllegalArgumentException("Scheme registry may not be null");
    }

    public g a() {
        return this.f5050b;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x002e=Splitter:B:20:0x002e, B:36:0x005f=Splitter:B:36:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(e.a.a.g0.h.a r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof e.a.a.g0.h.o.c
            if (r0 == 0) goto L_0x00a8
            e.a.a.g0.h.o.c r8 = (e.a.a.g0.h.o.c) r8
            e.a.a.g0.h.b r0 = r8.f
            if (r0 == 0) goto L_0x0017
            e.a.a.d0.b r0 = r8.f5005a
            if (r0 != r7) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Connection not obtained from this manager."
            r8.<init>(r9)
            throw r8
        L_0x0017:
            monitor-enter(r8)
            e.a.a.g0.h.b r0 = r8.f     // Catch:{ all -> 0x00a5 }
            r2 = r0
            e.a.a.g0.h.o.b r2 = (e.a.a.g0.h.o.b) r2     // Catch:{ all -> 0x00a5 }
            if (r2 != 0) goto L_0x0021
            monitor-exit(r8)     // Catch:{ all -> 0x00a5 }
            return
        L_0x0021:
            boolean r0 = r8.isOpen()     // Catch:{ IOException -> 0x004f }
            if (r0 == 0) goto L_0x002e
            boolean r0 = r8.f5007c     // Catch:{ IOException -> 0x004f }
            if (r0 != 0) goto L_0x002e
            r8.shutdown()     // Catch:{ IOException -> 0x004f }
        L_0x002e:
            boolean r0 = r8.f5007c     // Catch:{ all -> 0x00a5 }
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x0046
            if (r0 == 0) goto L_0x003f
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Released connection is reusable."
            goto L_0x0043
        L_0x003f:
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Released connection is not reusable."
        L_0x0043:
            r1.debug(r3)     // Catch:{ all -> 0x00a5 }
        L_0x0046:
            r8.n()     // Catch:{ all -> 0x00a5 }
        L_0x0049:
            e.a.a.g0.h.o.e r1 = r7.f5051c     // Catch:{ all -> 0x00a5 }
            r3 = r0
            goto L_0x007b
        L_0x004d:
            r0 = move-exception
            goto L_0x0082
        L_0x004f:
            r0 = move-exception
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x004d }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x005f
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "Exception shutting down released connection."
            r1.debug(r3, r0)     // Catch:{ all -> 0x004d }
        L_0x005f:
            boolean r0 = r8.f5007c     // Catch:{ all -> 0x00a5 }
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0070
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Released connection is reusable."
            goto L_0x0074
        L_0x0070:
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Released connection is not reusable."
        L_0x0074:
            r1.debug(r3)     // Catch:{ all -> 0x00a5 }
        L_0x0077:
            r8.n()     // Catch:{ all -> 0x00a5 }
            goto L_0x0049
        L_0x007b:
            r4 = r9
            r6 = r11
            r1.e(r2, r3, r4, r6)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r8)     // Catch:{ all -> 0x00a5 }
            return
        L_0x0082:
            boolean r3 = r8.f5007c     // Catch:{ all -> 0x00a5 }
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x009a
            if (r3 == 0) goto L_0x0093
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = "Released connection is reusable."
            goto L_0x0097
        L_0x0093:
            org.apache.commons.logging.Log r1 = r7.f5049a     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = "Released connection is not reusable."
        L_0x0097:
            r1.debug(r4)     // Catch:{ all -> 0x00a5 }
        L_0x009a:
            r8.n()     // Catch:{ all -> 0x00a5 }
            e.a.a.g0.h.o.e r1 = r7.f5051c     // Catch:{ all -> 0x00a5 }
            r4 = r9
            r6 = r11
            r1.e(r2, r3, r4, r6)     // Catch:{ all -> 0x00a5 }
            throw r0     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a5 }
            throw r9
        L_0x00a8:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Connection class mismatch, connection not obtained from this manager."
            r8.<init>(r9)
            goto L_0x00b1
        L_0x00b0:
            throw r8
        L_0x00b1:
            goto L_0x00b0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.o.h.b(e.a.a.g0.h.a, long, java.util.concurrent.TimeUnit):void");
    }

    public d c(e.a.a.d0.l.a aVar, Object obj) {
        e eVar = this.f5051c;
        if (eVar != null) {
            return new a(new d(eVar, new j(), aVar, obj), aVar);
        }
        throw null;
    }

    public void d() {
        this.f5049a.debug("Shutting down");
        e eVar = this.f5051c;
        eVar.f5042d.lock();
        try {
            if (!eVar.m) {
                eVar.m = true;
                Iterator<b> it = eVar.g.iterator();
                while (it.hasNext()) {
                    it.remove();
                    eVar.a(it.next());
                }
                Iterator it2 = eVar.h.iterator();
                while (it2.hasNext()) {
                    b bVar = (b) it2.next();
                    it2.remove();
                    if (eVar.f5041c.isDebugEnabled()) {
                        Log log = eVar.f5041c;
                        log.debug("Closing connection [" + bVar.f5012c + "][" + bVar.f5013d + "]");
                    }
                    eVar.a(bVar);
                }
                Iterator it3 = eVar.i.iterator();
                while (it3.hasNext()) {
                    i iVar = (i) it3.next();
                    it3.remove();
                    if (iVar.f5057b != null) {
                        iVar.f5056a.signalAll();
                    } else {
                        throw new IllegalStateException("Nobody waiting on this object.");
                    }
                }
                eVar.j.clear();
            }
        } finally {
            eVar.f5042d.unlock();
        }
    }

    public void finalize() {
        try {
            d();
        } finally {
            super.finalize();
        }
    }
}

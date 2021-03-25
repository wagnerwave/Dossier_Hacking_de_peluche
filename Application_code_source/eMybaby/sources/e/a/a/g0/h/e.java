package e.a.a.g0.h;

import e.a.a.g0.a;
import e.a.a.i0.s;
import e.a.a.j;
import e.a.a.k;
import e.a.a.k0.c;
import e.a.a.m;
import e.a.a.o;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class e extends a implements c, e.a.a.e, k {
    public volatile boolean i;
    public volatile Socket j = null;
    public final Log k = LogFactory.getLog(e.class);
    public final Log l = LogFactory.getLog("org.apache.http.headers");
    public final Log m = LogFactory.getLog("org.apache.http.wire");
    public volatile Socket n;
    public boolean o;
    public volatile boolean p;
    public final Map<String, Object> q = new HashMap();

    public Object b(String str) {
        return this.q.get(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:4|5|6|7|8|9|10|11|12) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r3 = this;
            boolean r0 = r3.i     // Catch:{ IOException -> 0x0020 }
            if (r0 != 0) goto L_0x0005
            goto L_0x0018
        L_0x0005:
            r0 = 0
            r3.i = r0     // Catch:{ IOException -> 0x0020 }
            java.net.Socket r0 = r3.j     // Catch:{ IOException -> 0x0020 }
            e.a.a.h0.d r1 = r3.f4940d     // Catch:{ all -> 0x0022 }
            r1.flush()     // Catch:{ all -> 0x0022 }
            r0.shutdownOutput()     // Catch:{ IOException -> 0x0012 }
        L_0x0012:
            r0.shutdownInput()     // Catch:{ UnsupportedOperationException -> 0x0015, UnsupportedOperationException -> 0x0015 }
        L_0x0015:
            r0.close()     // Catch:{ IOException -> 0x0020 }
        L_0x0018:
            org.apache.commons.logging.Log r0 = r3.k     // Catch:{ IOException -> 0x0020 }
            java.lang.String r1 = "Connection closed"
            r0.debug(r1)     // Catch:{ IOException -> 0x0020 }
            goto L_0x002e
        L_0x0020:
            r0 = move-exception
            goto L_0x0027
        L_0x0022:
            r1 = move-exception
            r0.close()     // Catch:{ IOException -> 0x0020 }
            throw r1     // Catch:{ IOException -> 0x0020 }
        L_0x0027:
            org.apache.commons.logging.Log r1 = r3.k
            java.lang.String r2 = "I/O error closing connection"
            r1.debug(r2, r0)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.e.close():void");
    }

    public void e(String str, Object obj) {
        this.q.put(str, obj);
    }

    public o f() {
        o f = super.f();
        if (this.k.isDebugEnabled()) {
            Log log = this.k;
            StringBuilder n2 = a.a.a.a.a.n("Receiving response: ");
            n2.append(f.s());
            log.debug(n2.toString());
        }
        if (this.l.isDebugEnabled()) {
            Log log2 = this.l;
            StringBuilder n3 = a.a.a.a.a.n("<< ");
            n3.append(f.s().toString());
            log2.debug(n3.toString());
            for (e.a.a.c obj : f.m()) {
                Log log3 = this.l;
                StringBuilder n4 = a.a.a.a.a.n("<< ");
                n4.append(obj.toString());
                log3.debug(n4.toString());
            }
        }
        return f;
    }

    public InetAddress getRemoteAddress() {
        if (this.j != null) {
            return this.j.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        if (this.j != null) {
            return this.j.getPort();
        }
        return -1;
    }

    public void i() {
        if (!this.i) {
            throw new IllegalStateException("Connection is not open");
        }
    }

    public boolean isOpen() {
        return this.i;
    }

    public e.a.a.g0.k.a j(e.a.a.h0.c cVar, e.a.a.g0.c cVar2, e.a.a.j0.c cVar3) {
        return new h(cVar, (s) null, cVar2, cVar3);
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [e.a.a.g0.h.k] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(java.net.Socket r8, e.a.a.j0.c r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x007f
            r7.j = r8
            r0 = -1
            java.lang.String r1 = "http.socket.buffer-size"
            int r1 = r9.b(r1, r0)
            r2 = 8192(0x2000, float:1.14794E-41)
            if (r1 != r0) goto L_0x0012
            r3 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0013
        L_0x0012:
            r3 = r1
        L_0x0013:
            e.a.a.g0.k.l r4 = new e.a.a.g0.k.l
            r4.<init>(r8, r3, r9)
            org.apache.commons.logging.Log r3 = r7.m
            boolean r3 = r3.isDebugEnabled()
            if (r3 == 0) goto L_0x0031
            e.a.a.g0.h.k r3 = new e.a.a.g0.h.k
            e.a.a.g0.h.n r5 = new e.a.a.g0.h.n
            org.apache.commons.logging.Log r6 = r7.m
            r5.<init>(r6)
            java.lang.String r6 = a.e.a.a.r.b.y(r9)
            r3.<init>(r4, r5, r6)
            r4 = r3
        L_0x0031:
            if (r1 != r0) goto L_0x0035
            r1 = 8192(0x2000, float:1.14794E-41)
        L_0x0035:
            e.a.a.g0.k.m r0 = new e.a.a.g0.k.m
            r0.<init>(r8, r1, r9)
            org.apache.commons.logging.Log r8 = r7.m
            boolean r8 = r8.isDebugEnabled()
            if (r8 == 0) goto L_0x0053
            e.a.a.g0.h.l r8 = new e.a.a.g0.h.l
            e.a.a.g0.h.n r1 = new e.a.a.g0.h.n
            org.apache.commons.logging.Log r2 = r7.m
            r1.<init>(r2)
            java.lang.String r2 = a.e.a.a.r.b.y(r9)
            r8.<init>(r0, r1, r2)
            r0 = r8
        L_0x0053:
            r7.f4939c = r4
            r7.f4940d = r0
            r7.f4941e = r4
            e.a.a.g0.c r8 = new e.a.a.g0.c
            r8.<init>()
            e.a.a.g0.k.a r8 = r7.j(r4, r8, r9)
            r7.f = r8
            e.a.a.g0.k.h r8 = new e.a.a.g0.k.h
            r1 = 0
            r8.<init>(r0, r1, r9)
            r7.g = r8
            e.a.a.g0.k.i r8 = r4.a()
            e.a.a.g0.k.i r9 = r0.a()
            e.a.a.g0.e r0 = new e.a.a.g0.e
            r0.<init>(r8, r9)
            r7.h = r0
            r8 = 1
            r7.i = r8
            return
        L_0x007f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Socket may not be null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.e.k(java.net.Socket, e.a.a.j0.c):void");
    }

    public void l(boolean z, e.a.a.j0.c cVar) {
        if (!this.i) {
            this.o = z;
            k(this.n, cVar);
            return;
        }
        throw new IllegalStateException("Connection is already open");
    }

    public void m(Socket socket, j jVar) {
        if (!this.i) {
            this.n = socket;
            if (this.p) {
                socket.close();
                throw new IOException("Connection already shutdown");
            }
            return;
        }
        throw new IllegalStateException("Connection is already open");
    }

    public void n(Socket socket, j jVar, boolean z, e.a.a.j0.c cVar) {
        i();
        if (jVar != null) {
            if (socket != null) {
                this.n = socket;
                k(socket, cVar);
            }
            this.o = z;
            return;
        }
        throw new IllegalArgumentException("Target host must not be null.");
    }

    public void sendRequestHeader(m mVar) {
        if (this.k.isDebugEnabled()) {
            Log log = this.k;
            StringBuilder n2 = a.a.a.a.a.n("Sending request: ");
            n2.append(mVar.f());
            log.debug(n2.toString());
        }
        super.sendRequestHeader(mVar);
        if (this.l.isDebugEnabled()) {
            Log log2 = this.l;
            StringBuilder n3 = a.a.a.a.a.n(">> ");
            n3.append(mVar.f().toString());
            log2.debug(n3.toString());
            for (e.a.a.c obj : mVar.m()) {
                Log log3 = this.l;
                StringBuilder n4 = a.a.a.a.a.n(">> ");
                n4.append(obj.toString());
                log3.debug(n4.toString());
            }
        }
    }

    public void setSocketTimeout(int i2) {
        i();
        if (this.j != null) {
            try {
                this.j.setSoTimeout(i2);
            } catch (SocketException unused) {
            }
        }
    }

    public void shutdown() {
        this.p = true;
        try {
            this.i = false;
            Socket socket = this.j;
            if (socket != null) {
                socket.close();
            }
            this.k.debug("Connection shut down");
            Socket socket2 = this.n;
            if (socket2 != null) {
                socket2.close();
            }
        } catch (IOException e2) {
            this.k.debug("I/O error shutting down connection", e2);
        }
    }
}

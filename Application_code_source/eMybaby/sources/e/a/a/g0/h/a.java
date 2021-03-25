package e.a.a.g0.h;

import androidx.recyclerview.widget.RecyclerView;
import e.a.a.d0.b;
import e.a.a.d0.g;
import e.a.a.d0.j;
import e.a.a.e;
import e.a.a.h;
import e.a.a.k0.c;
import e.a.a.m;
import e.a.a.o;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public abstract class a implements c, e, j, g {

    /* renamed from: a  reason: collision with root package name */
    public final b f5005a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f5006b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5007c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5008d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f5009e = RecyclerView.FOREVER_NS;

    public a(b bVar, e eVar) {
        this.f5005a = bVar;
        this.f5006b = eVar;
    }

    public void a(o oVar) {
        e eVar = this.f5006b;
        j(eVar);
        this.f5007c = false;
        eVar.a(oVar);
    }

    public Object b(String str) {
        e eVar = this.f5006b;
        j(eVar);
        return eVar.b(str);
    }

    public boolean c() {
        e eVar = this.f5006b;
        j(eVar);
        return eVar.o;
    }

    public boolean d(int i) {
        e eVar = this.f5006b;
        j(eVar);
        eVar.i();
        return eVar.f4939c.d(i);
    }

    public void e(String str, Object obj) {
        e eVar = this.f5006b;
        j(eVar);
        eVar.e(str, obj);
    }

    public o f() {
        e eVar = this.f5006b;
        j(eVar);
        this.f5007c = false;
        return eVar.f();
    }

    public void flush() {
        e eVar = this.f5006b;
        j(eVar);
        eVar.flush();
    }

    public abstract e.a.a.d0.l.a g();

    public InetAddress getRemoteAddress() {
        e eVar = this.f5006b;
        j(eVar);
        if (eVar.j != null) {
            return eVar.j.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        e eVar = this.f5006b;
        j(eVar);
        return eVar.getRemotePort();
    }

    public SSLSession h() {
        e eVar = this.f5006b;
        j(eVar);
        if (!isOpen()) {
            return null;
        }
        Socket socket = eVar.n;
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getSession();
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|8|9|10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void i() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f5008d     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            r0 = 1
            r4.f5008d = r0     // Catch:{ all -> 0x001b }
            r0 = 0
            r4.f5007c = r0     // Catch:{ all -> 0x001b }
            r4.shutdown()     // Catch:{ IOException -> 0x0010 }
        L_0x0010:
            e.a.a.d0.b r0 = r4.f5005a     // Catch:{ all -> 0x001b }
            long r1 = r4.f5009e     // Catch:{ all -> 0x001b }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x001b }
            r0.b(r4, r1, r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r4)
            return
        L_0x001b:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.a.i():void");
    }

    public boolean isOpen() {
        e eVar = this.f5006b;
        if (eVar == null) {
            return false;
        }
        return eVar.i;
    }

    public boolean isStale() {
        e eVar;
        if (!this.f5008d && (eVar = this.f5006b) != null) {
            return eVar.isStale();
        }
        return true;
    }

    public final void j(e eVar) {
        if (this.f5008d || eVar == null) {
            throw new d();
        }
    }

    public abstract void k(e.a.a.d0.l.a aVar, c cVar, e.a.a.j0.c cVar2);

    public synchronized void l() {
        if (!this.f5008d) {
            this.f5008d = true;
            this.f5005a.b(this, this.f5009e, TimeUnit.MILLISECONDS);
        }
    }

    public void sendRequestEntity(h hVar) {
        e eVar = this.f5006b;
        j(eVar);
        this.f5007c = false;
        eVar.sendRequestEntity(hVar);
    }

    public void sendRequestHeader(m mVar) {
        e eVar = this.f5006b;
        j(eVar);
        this.f5007c = false;
        eVar.sendRequestHeader(mVar);
    }

    public void setSocketTimeout(int i) {
        e eVar = this.f5006b;
        j(eVar);
        eVar.i();
        if (eVar.j != null) {
            try {
                eVar.j.setSoTimeout(i);
            } catch (SocketException unused) {
            }
        }
    }
}

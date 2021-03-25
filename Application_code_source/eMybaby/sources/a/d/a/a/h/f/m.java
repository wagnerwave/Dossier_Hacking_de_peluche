package a.d.a.a.h.f;

import a.c.a.f.b;
import android.content.ComponentName;
import android.content.ServiceConnection;

public final class m implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public volatile o0 f1528a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f1529b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f1530c;

    public m(k kVar) {
        this.f1530c = kVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:14|(1:16)(1:17)|18|19|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|(3:11|12|(6:14|(1:16)(1:17)|18|19|25|26)(3:20|21|22))|(3:28|29|(1:31)(1:32))(3:33|34|(1:36)(1:37))|38|39|40|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0048 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0082 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r3, android.os.IBinder r4) {
        /*
            r2 = this;
            java.lang.String r3 = "AnalyticsServiceConnection.onServiceConnected"
            a.c.a.f.b.g(r3)
            monitor-enter(r2)
            if (r4 != 0) goto L_0x0017
            a.d.a.a.h.f.k r3 = r2.f1530c     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = "Service connected with null binder"
            r3.q(r4)     // Catch:{ all -> 0x0014 }
            r2.notifyAll()     // Catch:{ all -> 0x008b }
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            return
        L_0x0014:
            r3 = move-exception
            goto L_0x0087
        L_0x0017:
            r3 = 0
            java.lang.String r0 = r4.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0047 }
            java.lang.String r1 = "com.google.android.gms.analytics.internal.IAnalyticsService"
            boolean r1 = r1.equals(r0)     // Catch:{ RemoteException -> 0x0047 }
            if (r1 == 0) goto L_0x003e
            java.lang.String r0 = "com.google.android.gms.analytics.internal.IAnalyticsService"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)     // Catch:{ RemoteException -> 0x0047 }
            boolean r1 = r0 instanceof a.d.a.a.h.f.o0     // Catch:{ RemoteException -> 0x0047 }
            if (r1 == 0) goto L_0x0031
            a.d.a.a.h.f.o0 r0 = (a.d.a.a.h.f.o0) r0     // Catch:{ RemoteException -> 0x0047 }
            goto L_0x0036
        L_0x0031:
            a.d.a.a.h.f.p0 r0 = new a.d.a.a.h.f.p0     // Catch:{ RemoteException -> 0x0047 }
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x0047 }
        L_0x0036:
            a.d.a.a.h.f.k r4 = r2.f1530c     // Catch:{ RemoteException -> 0x0048 }
            java.lang.String r1 = "Bound to IAnalyticsService interface"
            r4.o(r1)     // Catch:{ RemoteException -> 0x0048 }
            goto L_0x004f
        L_0x003e:
            a.d.a.a.h.f.k r4 = r2.f1530c     // Catch:{ RemoteException -> 0x0047 }
            java.lang.String r1 = "Got binder with a wrong descriptor"
            r4.n(r1, r0)     // Catch:{ RemoteException -> 0x0047 }
            r0 = r3
            goto L_0x004f
        L_0x0047:
            r0 = r3
        L_0x0048:
            a.d.a.a.h.f.k r4 = r2.f1530c     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "Service connect failed to get IAnalyticsService"
            r4.q(r1)     // Catch:{ all -> 0x0014 }
        L_0x004f:
            if (r0 != 0) goto L_0x0066
            a.d.a.a.e.p.a r4 = a.d.a.a.e.p.a.a()     // Catch:{ IllegalArgumentException -> 0x0082 }
            a.d.a.a.h.f.k r0 = r2.f1530c     // Catch:{ IllegalArgumentException -> 0x0082 }
            a.d.a.a.h.f.h r0 = r0.f1490a     // Catch:{ IllegalArgumentException -> 0x0082 }
            android.content.Context r0 = r0.f1503a     // Catch:{ IllegalArgumentException -> 0x0082 }
            a.d.a.a.h.f.k r1 = r2.f1530c     // Catch:{ IllegalArgumentException -> 0x0082 }
            a.d.a.a.h.f.m r1 = r1.f1518c     // Catch:{ IllegalArgumentException -> 0x0082 }
            if (r4 == 0) goto L_0x0065
            r0.unbindService(r1)     // Catch:{ IllegalArgumentException -> 0x0082 }
            goto L_0x0082
        L_0x0065:
            throw r3     // Catch:{ IllegalArgumentException -> 0x0082 }
        L_0x0066:
            boolean r3 = r2.f1529b     // Catch:{ all -> 0x0014 }
            if (r3 != 0) goto L_0x0080
            a.d.a.a.h.f.k r3 = r2.f1530c     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = "onServiceConnected received after the timeout limit"
            r3.p(r4)     // Catch:{ all -> 0x0014 }
            a.d.a.a.h.f.k r3 = r2.f1530c     // Catch:{ all -> 0x0014 }
            a.d.a.a.b.f r3 = r3.h()     // Catch:{ all -> 0x0014 }
            a.d.a.a.h.f.n r4 = new a.d.a.a.h.f.n     // Catch:{ all -> 0x0014 }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x0014 }
            r3.a(r4)     // Catch:{ all -> 0x0014 }
            goto L_0x0082
        L_0x0080:
            r2.f1528a = r0     // Catch:{ all -> 0x0014 }
        L_0x0082:
            r2.notifyAll()     // Catch:{ all -> 0x008b }
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            return
        L_0x0087:
            r2.notifyAll()     // Catch:{ all -> 0x008b }
            throw r3     // Catch:{ all -> 0x008b }
        L_0x008b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x008b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.m.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        b.g("AnalyticsServiceConnection.onServiceDisconnected");
        this.f1530c.h().a(new o(this, componentName));
    }
}

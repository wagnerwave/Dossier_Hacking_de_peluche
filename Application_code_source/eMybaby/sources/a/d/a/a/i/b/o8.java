package a.d.a.a.i.b;

import a.d.a.a.e.m.b;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class o8 implements ServiceConnection, b.a, b.C0060b {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2439a;

    /* renamed from: b  reason: collision with root package name */
    public volatile u3 f2440b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u7 f2441c;

    public o8(u7 u7Var) {
        this.f2441c = u7Var;
    }

    @MainThread
    public final void e(int i) {
        a.c.a.f.b.g("MeasurementServiceConnection.onConnectionSuspended");
        this.f2441c.i().m.a("Service connection suspended");
        this.f2441c.f().v(new s8(this));
    }

    @MainThread
    public final void g(@NonNull ConnectionResult connectionResult) {
        a.c.a.f.b.g("MeasurementServiceConnection.onConnectionFailed");
        c5 c5Var = this.f2441c.f2563a;
        x3 x3Var = c5Var.i;
        x3 x3Var2 = (x3Var == null || !x3Var.r()) ? null : c5Var.i;
        if (x3Var2 != null) {
            x3Var2.i.b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f2439a = false;
            this.f2440b = null;
        }
        this.f2441c.f().v(new r8(this));
    }

    @MainThread
    public final void h(@Nullable Bundle bundle) {
        a.c.a.f.b.g("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f2441c.f().v(new p8(this, (p3) this.f2440b.p()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f2440b = null;
                this.f2439a = false;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|(1:15)(1:16)|17|18|24|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005a */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            a.c.a.f.b.g(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001d
            r3.f2439a = r4     // Catch:{ all -> 0x001a }
            a.d.a.a.i.b.u7 r4 = r3.f2441c     // Catch:{ all -> 0x001a }
            a.d.a.a.i.b.x3 r4 = r4.i()     // Catch:{ all -> 0x001a }
            a.d.a.a.i.b.z3 r4 = r4.f     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "Service connected with null binder"
            r4.a(r5)     // Catch:{ all -> 0x001a }
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            return
        L_0x001a:
            r4 = move-exception
            goto L_0x0090
        L_0x001d:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0059 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0059 }
            if (r2 == 0) goto L_0x004a
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0059 }
            boolean r2 = r1 instanceof a.d.a.a.i.b.p3     // Catch:{ RemoteException -> 0x0059 }
            if (r2 == 0) goto L_0x0037
            a.d.a.a.i.b.p3 r1 = (a.d.a.a.i.b.p3) r1     // Catch:{ RemoteException -> 0x0059 }
            goto L_0x003c
        L_0x0037:
            a.d.a.a.i.b.r3 r1 = new a.d.a.a.i.b.r3     // Catch:{ RemoteException -> 0x0059 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0059 }
        L_0x003c:
            a.d.a.a.i.b.u7 r5 = r3.f2441c     // Catch:{ RemoteException -> 0x005a }
            a.d.a.a.i.b.x3 r5 = r5.i()     // Catch:{ RemoteException -> 0x005a }
            a.d.a.a.i.b.z3 r5 = r5.n     // Catch:{ RemoteException -> 0x005a }
            java.lang.String r2 = "Bound to IMeasurementService interface"
            r5.a(r2)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x0067
        L_0x004a:
            a.d.a.a.i.b.u7 r5 = r3.f2441c     // Catch:{ RemoteException -> 0x0059 }
            a.d.a.a.i.b.x3 r5 = r5.i()     // Catch:{ RemoteException -> 0x0059 }
            a.d.a.a.i.b.z3 r5 = r5.f     // Catch:{ RemoteException -> 0x0059 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.b(r2, r1)     // Catch:{ RemoteException -> 0x0059 }
            r1 = r0
            goto L_0x0067
        L_0x0059:
            r1 = r0
        L_0x005a:
            a.d.a.a.i.b.u7 r5 = r3.f2441c     // Catch:{ all -> 0x001a }
            a.d.a.a.i.b.x3 r5 = r5.i()     // Catch:{ all -> 0x001a }
            a.d.a.a.i.b.z3 r5 = r5.f     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "Service connect failed to get IMeasurementService"
            r5.a(r2)     // Catch:{ all -> 0x001a }
        L_0x0067:
            if (r1 != 0) goto L_0x0080
            r3.f2439a = r4     // Catch:{ all -> 0x001a }
            a.d.a.a.e.p.a r4 = a.d.a.a.e.p.a.a()     // Catch:{ IllegalArgumentException -> 0x008e }
            a.d.a.a.i.b.u7 r5 = r3.f2441c     // Catch:{ IllegalArgumentException -> 0x008e }
            a.d.a.a.i.b.c5 r5 = r5.f2563a     // Catch:{ IllegalArgumentException -> 0x008e }
            android.content.Context r5 = r5.f2123a     // Catch:{ IllegalArgumentException -> 0x008e }
            a.d.a.a.i.b.u7 r1 = r3.f2441c     // Catch:{ IllegalArgumentException -> 0x008e }
            a.d.a.a.i.b.o8 r1 = r1.f2548c     // Catch:{ IllegalArgumentException -> 0x008e }
            if (r4 == 0) goto L_0x007f
            r5.unbindService(r1)     // Catch:{ IllegalArgumentException -> 0x008e }
            goto L_0x008e
        L_0x007f:
            throw r0     // Catch:{ IllegalArgumentException -> 0x008e }
        L_0x0080:
            a.d.a.a.i.b.u7 r4 = r3.f2441c     // Catch:{ all -> 0x001a }
            a.d.a.a.i.b.v4 r4 = r4.f()     // Catch:{ all -> 0x001a }
            a.d.a.a.i.b.n8 r5 = new a.d.a.a.i.b.n8     // Catch:{ all -> 0x001a }
            r5.<init>(r3, r1)     // Catch:{ all -> 0x001a }
            r4.v(r5)     // Catch:{ all -> 0x001a }
        L_0x008e:
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            return
        L_0x0090:
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o8.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        a.c.a.f.b.g("MeasurementServiceConnection.onServiceDisconnected");
        this.f2441c.i().m.a("Service disconnected");
        this.f2441c.f().v(new q8(this, componentName));
    }
}

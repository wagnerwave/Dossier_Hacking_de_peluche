package a.d.a.a.i.b;

import a.d.a.a.h.g.od;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzar;

public final class g8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzar f2224a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ od f2226c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u7 f2227d;

    public g8(u7 u7Var, zzar zzar, String str, od odVar) {
        this.f2227d = u7Var;
        this.f2224a = zzar;
        this.f2225b = str;
        this.f2226c = odVar;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            p3 p3Var = this.f2227d.f2549d;
            if (p3Var == null) {
                this.f2227d.i().f.a("Discarding data. Failed to send event to service to bundle");
            } else {
                bArr = p3Var.z(this.f2224a, this.f2225b);
                this.f2227d.H();
            }
        } catch (RemoteException e2) {
            this.f2227d.i().f.b("Failed to send event to the service to bundle", e2);
        } catch (Throwable th) {
            this.f2227d.e().P(this.f2226c, bArr);
            throw th;
        }
        this.f2227d.e().P(this.f2226c, bArr);
    }
}

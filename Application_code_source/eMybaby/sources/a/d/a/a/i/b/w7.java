package a.d.a.a.i.b;

import a.d.a.a.h.g.od;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

public final class w7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2597a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f2599c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ zzn f2600d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ od f2601e;
    public final /* synthetic */ u7 f;

    public w7(u7 u7Var, String str, String str2, boolean z, zzn zzn, od odVar) {
        this.f = u7Var;
        this.f2597a = str;
        this.f2598b = str2;
        this.f2599c = z;
        this.f2600d = zzn;
        this.f2601e = odVar;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            p3 p3Var = this.f.f2549d;
            if (p3Var == null) {
                this.f.i().f.c("Failed to get user properties; not connected to service", this.f2597a, this.f2598b);
            } else {
                bundle = v9.A(p3Var.j(this.f2597a, this.f2598b, this.f2599c, this.f2600d));
                this.f.H();
            }
        } catch (RemoteException e2) {
            this.f.i().f.c("Failed to get user properties; remote exception", this.f2597a, e2);
        } catch (Throwable th) {
            this.f.e().L(this.f2601e, bundle);
            throw th;
        }
        this.f.e().L(this.f2601e, bundle);
    }
}

package a.d.a.a.i.b;

import a.d.a.a.h.g.od;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;

public final class m8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2381a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2382b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ zzn f2383c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ od f2384d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u7 f2385e;

    public m8(u7 u7Var, String str, String str2, zzn zzn, od odVar) {
        this.f2385e = u7Var;
        this.f2381a = str;
        this.f2382b = str2;
        this.f2383c = zzn;
        this.f2384d = odVar;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            p3 p3Var = this.f2385e.f2549d;
            if (p3Var == null) {
                this.f2385e.i().f.c("Failed to get conditional properties; not connected to service", this.f2381a, this.f2382b);
            } else {
                arrayList = v9.i0(p3Var.S(this.f2381a, this.f2382b, this.f2383c));
                this.f2385e.H();
            }
        } catch (RemoteException e2) {
            this.f2385e.i().f.d("Failed to get conditional properties; remote exception", this.f2381a, this.f2382b, e2);
        } catch (Throwable th) {
            this.f2385e.e().N(this.f2384d, arrayList);
            throw th;
        }
        this.f2385e.e().N(this.f2384d, arrayList);
    }
}

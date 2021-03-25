package a.d.a.a.i.b;

import android.os.RemoteException;

public final class b8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m7 f2107a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u7 f2108b;

    public b8(u7 u7Var, m7 m7Var) {
        this.f2108b = u7Var;
        this.f2107a = m7Var;
    }

    public final void run() {
        long j;
        String str;
        String str2;
        String packageName;
        u7 u7Var = this.f2108b;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Failed to send current screen to service");
            return;
        }
        try {
            if (this.f2107a == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = u7Var.f2563a.f2123a.getPackageName();
            } else {
                j = this.f2107a.f2378c;
                str = this.f2107a.f2376a;
                str2 = this.f2107a.f2377b;
                packageName = u7Var.f2563a.f2123a.getPackageName();
            }
            p3Var.N(j, str, str2, packageName);
            this.f2108b.H();
        } catch (RemoteException e2) {
            this.f2108b.i().f.b("Failed to send current screen to the service", e2);
        }
    }
}

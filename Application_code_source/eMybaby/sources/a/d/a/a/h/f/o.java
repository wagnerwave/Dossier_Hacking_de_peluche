package a.d.a.a.h.f;

import a.d.a.a.b.f;
import android.content.ComponentName;

public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentName f1543a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1544b;

    public o(m mVar, ComponentName componentName) {
        this.f1544b = mVar;
        this.f1543a = componentName;
    }

    public final void run() {
        k kVar = this.f1544b.f1530c;
        ComponentName componentName = this.f1543a;
        if (kVar != null) {
            f.b();
            if (kVar.f1519d != null) {
                kVar.f1519d = null;
                kVar.b("Disconnected from device AnalyticsService", componentName);
                b i = kVar.i();
                i.u();
                f.b();
                s sVar = i.f1473c;
                f.b();
                sVar.u();
                sVar.o("Service disconnected");
                return;
            }
            return;
        }
        throw null;
    }
}

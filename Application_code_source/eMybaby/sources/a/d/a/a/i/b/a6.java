package a.d.a.a.i.b;

import a.d.a.a.h.g.od;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

public final class a6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ od f2082a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f2083b;

    public a6(AppMeasurementDynamiteService appMeasurementDynamiteService, od odVar) {
        this.f2083b = appMeasurementDynamiteService;
        this.f2082a = odVar;
    }

    public final void run() {
        u7 x = this.f2083b.f4269a.x();
        od odVar = this.f2082a;
        x.b();
        x.u();
        x.B(new z7(x, x.K(false), odVar));
    }
}

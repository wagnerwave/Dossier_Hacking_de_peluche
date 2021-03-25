package a.d.a.a.i.b;

import a.d.a.a.h.g.od;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

public final class y9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ od f2647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2649c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f2650d;

    public y9(AppMeasurementDynamiteService appMeasurementDynamiteService, od odVar, String str, String str2) {
        this.f2650d = appMeasurementDynamiteService;
        this.f2647a = odVar;
        this.f2648b = str;
        this.f2649c = str2;
    }

    public final void run() {
        u7 x = this.f2650d.f4269a.x();
        od odVar = this.f2647a;
        String str = this.f2648b;
        String str2 = this.f2649c;
        x.b();
        x.u();
        x.B(new m8(x, str, str2, x.K(false), odVar));
    }
}

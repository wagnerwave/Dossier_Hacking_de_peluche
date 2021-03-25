package a.d.a.a.i.b;

import a.d.a.a.e.d;
import a.d.a.a.e.g;
import a.d.a.a.h.g.od;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzar;

public final class y7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ od f2641a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzar f2642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2643c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f2644d;

    public y7(AppMeasurementDynamiteService appMeasurementDynamiteService, od odVar, zzar zzar, String str) {
        this.f2644d = appMeasurementDynamiteService;
        this.f2641a = odVar;
        this.f2642b = zzar;
        this.f2643c = str;
    }

    public final void run() {
        u7 x = this.f2644d.f4269a.x();
        od odVar = this.f2641a;
        zzar zzar = this.f2642b;
        String str = this.f2643c;
        x.b();
        x.u();
        v9 e2 = x.e();
        if (e2 == null) {
            throw null;
        } else if (d.f1239b.b(e2.f2563a.f2123a, g.f1241a) != 0) {
            x.i().i.a("Not bundling data. Service unavailable or out of date");
            x.e().P(odVar, new byte[0]);
        } else {
            x.B(new g8(x, zzar, str, odVar));
        }
    }
}

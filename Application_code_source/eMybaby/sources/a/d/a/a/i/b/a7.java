package a.d.a.a.i.b;

import a.d.a.a.h.g.od;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

public final class a7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ od f2084a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2085b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2086c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f2087d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f2088e;

    public a7(AppMeasurementDynamiteService appMeasurementDynamiteService, od odVar, String str, String str2, boolean z) {
        this.f2088e = appMeasurementDynamiteService;
        this.f2084a = odVar;
        this.f2085b = str;
        this.f2086c = str2;
        this.f2087d = z;
    }

    public final void run() {
        u7 x = this.f2088e.f4269a.x();
        od odVar = this.f2084a;
        String str = this.f2085b;
        String str2 = this.f2086c;
        boolean z = this.f2087d;
        x.b();
        x.u();
        x.B(new w7(x, str, str2, z, x.K(false), odVar));
    }
}

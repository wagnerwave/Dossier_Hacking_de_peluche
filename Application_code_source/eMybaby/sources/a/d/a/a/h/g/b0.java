package a.d.a.a.h.g;

import a.d.a.a.f.b;
import a.d.a.a.h.g.f;
import android.app.Activity;
import android.os.Bundle;

public final class b0 extends f.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Bundle f1608e;
    public final /* synthetic */ Activity f;
    public final /* synthetic */ f.b g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(f.b bVar, Bundle bundle, Activity activity) {
        super(true);
        this.g = bVar;
        this.f1608e = bundle;
        this.f = activity;
    }

    public final void a() {
        Bundle bundle;
        if (this.f1608e != null) {
            bundle = new Bundle();
            if (this.f1608e.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f1608e.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        f.this.h.onActivityCreated(new b(this.f), bundle, this.f1687b);
    }
}

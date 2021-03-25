package a.d.a.a.i.b;

import a.c.a.f.b;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzae;

public final class g6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2214a;

    /* renamed from: b  reason: collision with root package name */
    public String f2215b;

    /* renamed from: c  reason: collision with root package name */
    public String f2216c;

    /* renamed from: d  reason: collision with root package name */
    public String f2217d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f2218e;
    public long f;
    public zzae g;
    public boolean h = true;
    public Long i;

    public g6(Context context, zzae zzae, Long l) {
        b.k(context);
        Context applicationContext = context.getApplicationContext();
        b.k(applicationContext);
        this.f2214a = applicationContext;
        this.i = l;
        if (zzae != null) {
            this.g = zzae;
            this.f2215b = zzae.f;
            this.f2216c = zzae.f4261e;
            this.f2217d = zzae.f4260d;
            this.h = zzae.f4259c;
            this.f = zzae.f4258b;
            Bundle bundle = zzae.g;
            if (bundle != null) {
                this.f2218e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}

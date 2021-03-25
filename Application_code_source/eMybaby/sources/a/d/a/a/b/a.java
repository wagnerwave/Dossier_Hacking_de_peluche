package a.d.a.a.b;

import a.c.a.f.b;
import a.d.a.a.h.f.e1;
import android.content.BroadcastReceiver;
import android.content.Context;

public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f1178a;

    public static boolean a(Context context) {
        b.k(context);
        Boolean bool = f1178a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean a2 = e1.a(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        f1178a = Boolean.valueOf(a2);
        return a2;
    }
}

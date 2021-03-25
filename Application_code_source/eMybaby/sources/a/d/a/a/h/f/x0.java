package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.k.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresPermission;

public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    public static Object f1578a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static a f1579b;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f1580c;

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static void a(Context context, Intent intent) {
        r0 c2 = h.b(context).c();
        if (intent == null) {
            c2.p("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        c2.b("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean c3 = y0.c(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (f1578a) {
                context.startService(intent2);
                if (c3) {
                    try {
                        if (f1579b == null) {
                            a aVar = new a(context, 1, "Analytics WakeLock");
                            f1579b = aVar;
                            aVar.f2684b.setReferenceCounted(false);
                            aVar.h = false;
                        }
                        f1579b.a(1000);
                    } catch (SecurityException unused) {
                        c2.p("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }

    public static boolean b(Context context) {
        b.k(context);
        Boolean bool = f1580c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean a2 = e1.a(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        f1580c = Boolean.valueOf(a2);
        return a2;
    }
}

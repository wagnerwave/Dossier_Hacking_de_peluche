package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.h.f.c1;
import a.d.a.a.k.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import androidx.annotation.RequiresPermission;

public final class y0<T extends Context & c1> {

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f1581c;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1582a = new j1();

    /* renamed from: b  reason: collision with root package name */
    public final T f1583b;

    public y0(T t) {
        b.k(t);
        this.f1583b = t;
    }

    public static boolean c(Context context) {
        b.k(context);
        Boolean bool = f1581c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                z = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        f1581c = Boolean.valueOf(z);
        return z;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int a(Intent intent, int i) {
        try {
            synchronized (x0.f1578a) {
                a aVar = x0.f1579b;
                if (aVar != null && aVar.f2684b.isHeld()) {
                    aVar.b();
                }
            }
        } catch (SecurityException unused) {
        }
        r0 c2 = h.b(this.f1583b).c();
        if (intent == null) {
            c2.p("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        c2.a(2, "Local AnalyticsService called. startId, action", Integer.valueOf(i), action, (Object) null);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            b(new z0(this, i, c2));
        }
        return 2;
    }

    public final void b(Runnable runnable) {
        b e2 = h.b(this.f1583b).e();
        b1 b1Var = new b1(this, runnable);
        e2.u();
        e2.h().a(new d(e2, b1Var));
    }
}

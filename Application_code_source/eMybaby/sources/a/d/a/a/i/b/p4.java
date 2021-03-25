package a.d.a.a.i.b;

import a.d.a.a.e.p.a;
import a.d.a.a.e.r.b;
import a.d.a.a.e.r.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.annotation.WorkerThread;
import java.util.List;

public final class p4 {

    /* renamed from: a  reason: collision with root package name */
    public final c5 f2455a;

    public p4(c5 c5Var) {
        this.f2455a = c5Var;
    }

    @WorkerThread
    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            this.f2455a.i().j.a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f2455a.f().b();
        if (!b()) {
            this.f2455a.i().l.a("Install Referrer Reporter is not available");
            return;
        }
        s4 s4Var = new s4(this, str);
        this.f2455a.f().b();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f2455a.f2123a.getPackageManager();
        if (packageManager == null) {
            this.f2455a.i().j.a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f2455a.i().l.a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !b()) {
                this.f2455a.i().i.a("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            Intent intent2 = new Intent(intent);
            try {
                a a2 = a.a();
                Context context = this.f2455a.f2123a;
                if (a2 != null) {
                    context.getClass().getName();
                    this.f2455a.i().n.b("Install Referrer Service is", a2.b(context, intent2, s4Var, 1) ? "available" : "not available");
                    return;
                }
                throw null;
            } catch (Exception e2) {
                this.f2455a.i().f.b("Exception occurred while binding to Install Referrer Service", e2.getMessage());
            }
        }
    }

    public final boolean b() {
        try {
            b a2 = c.a(this.f2455a.f2123a);
            if (a2 == null) {
                this.f2455a.i().n.a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (a2.f1443a.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e2) {
            this.f2455a.i().n.b("Failed to retrieve Play Store version for Install Referrer", e2);
            return false;
        }
    }
}

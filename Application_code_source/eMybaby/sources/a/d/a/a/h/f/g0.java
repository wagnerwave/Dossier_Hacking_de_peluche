package a.d.a.a.h.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public final class g0 extends f {

    /* renamed from: c  reason: collision with root package name */
    public boolean f1497c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1498d;

    /* renamed from: e  reason: collision with root package name */
    public final AlarmManager f1499e = ((AlarmManager) this.f1490a.f1503a.getSystemService(NotificationCompat.CATEGORY_ALARM));
    public Integer f;

    public g0(h hVar) {
        super(hVar);
    }

    public final void t() {
        try {
            v();
            if (b0.b() > 0) {
                Context context = this.f1490a.f1503a;
                ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo != null && receiverInfo.enabled) {
                    o("Receiver registered for local dispatch.");
                    this.f1497c = true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void v() {
        this.f1498d = false;
        this.f1499e.cancel(x());
        if (Build.VERSION.SDK_INT >= 24) {
            int w = w();
            b("Cancelling job. JobID", Integer.valueOf(w));
            ((JobScheduler) this.f1490a.f1503a.getSystemService("jobscheduler")).cancel(w);
        }
    }

    public final int w() {
        if (this.f == null) {
            String valueOf = String.valueOf(this.f1490a.f1503a.getPackageName());
            this.f = Integer.valueOf((valueOf.length() != 0 ? "analytics".concat(valueOf) : new String("analytics")).hashCode());
        }
        return this.f.intValue();
    }

    public final PendingIntent x() {
        Context context = this.f1490a.f1503a;
        return PendingIntent.getBroadcast(context, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }
}

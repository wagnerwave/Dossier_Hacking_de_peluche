package a.d.a.a.i.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public final class l9 extends m9 {

    /* renamed from: d  reason: collision with root package name */
    public final AlarmManager f2360d = ((AlarmManager) this.f2563a.f2123a.getSystemService(NotificationCompat.CATEGORY_ALARM));

    /* renamed from: e  reason: collision with root package name */
    public final i f2361e;
    public Integer f;

    public l9(o9 o9Var) {
        super(o9Var);
        this.f2361e = new k9(this, o9Var.j, o9Var);
    }

    public final boolean p() {
        this.f2360d.cancel(u());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        ((JobScheduler) this.f2563a.f2123a.getSystemService("jobscheduler")).cancel(t());
        return false;
    }

    public final void s() {
        n();
        i().n.a("Unscheduling upload");
        this.f2360d.cancel(u());
        this.f2361e.c();
        if (Build.VERSION.SDK_INT >= 24) {
            ((JobScheduler) this.f2563a.f2123a.getSystemService("jobscheduler")).cancel(t());
        }
    }

    public final int t() {
        if (this.f == null) {
            String valueOf = String.valueOf(this.f2563a.f2123a.getPackageName());
            this.f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f.intValue();
    }

    public final PendingIntent u() {
        Context context = this.f2563a.f2123a;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }
}

package com.google.android.gms.measurement;

import a.d.a.a.i.b.c5;
import a.d.a.a.i.b.o9;
import a.d.a.a.i.b.t8;
import a.d.a.a.i.b.v8;
import a.d.a.a.i.b.x3;
import a.d.a.a.i.b.x8;
import a.d.a.a.i.b.y8;
import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzae;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements x8 {

    /* renamed from: a  reason: collision with root package name */
    public t8<AppMeasurementJobService> f4266a;

    @TargetApi(24)
    public final void a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final void b(Intent intent) {
    }

    public final t8<AppMeasurementJobService> c() {
        if (this.f4266a == null) {
            this.f4266a = new t8<>(this);
        }
        return this.f4266a;
    }

    public final boolean f(int i) {
        throw new UnsupportedOperationException();
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        c5.a(c().f2534a, (zzae) null, (Long) null).i().n.a("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void onDestroy() {
        c5.a(c().f2534a, (zzae) null, (Long) null).i().n.a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @MainThread
    public final void onRebind(Intent intent) {
        c().c(intent);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        t8<AppMeasurementJobService> c2 = c();
        x3 i = c5.a(c2.f2534a, (zzae) null, (Long) null).i();
        String string = jobParameters.getExtras().getString("action");
        i.n.b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        v8 v8Var = new v8(c2, i, jobParameters);
        o9 b2 = o9.b(c2.f2534a);
        b2.f().v(new y8(b2, v8Var));
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        c().a(intent);
        return true;
    }
}

package com.google.android.gms.analytics;

import a.d.a.a.h.f.a1;
import a.d.a.a.h.f.c1;
import a.d.a.a.h.f.h;
import a.d.a.a.h.f.r0;
import a.d.a.a.h.f.y0;
import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.RequiresPermission;

@TargetApi(24)
public final class AnalyticsJobService extends JobService implements c1 {

    /* renamed from: a  reason: collision with root package name */
    public y0<AnalyticsJobService> f4163a;

    @TargetApi(24)
    public final void a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final boolean b(int i) {
        return stopSelfResult(i);
    }

    public final y0<AnalyticsJobService> c() {
        if (this.f4163a == null) {
            this.f4163a = new y0<>(this);
        }
        return this.f4163a;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        h.b(c().f1583b).c().o("Local AnalyticsService is starting up");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        h.b(c().f1583b).c().o("Local AnalyticsService is shutting down");
        super.onDestroy();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        c().a(intent, i2);
        return 2;
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        y0<AnalyticsJobService> c2 = c();
        r0 c3 = h.b(c2.f1583b).c();
        String string = jobParameters.getExtras().getString("action");
        c3.b("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        c2.b(new a1(c2, c3, jobParameters));
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}

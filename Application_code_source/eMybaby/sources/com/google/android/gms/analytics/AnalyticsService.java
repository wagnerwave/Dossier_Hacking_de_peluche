package com.google.android.gms.analytics;

import a.d.a.a.h.f.c1;
import a.d.a.a.h.f.h;
import a.d.a.a.h.f.y0;
import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RequiresPermission;

public final class AnalyticsService extends Service implements c1 {

    /* renamed from: a  reason: collision with root package name */
    public y0<AnalyticsService> f4165a;

    public final void a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final boolean b(int i) {
        return stopSelfResult(i);
    }

    public final y0<AnalyticsService> c() {
        if (this.f4165a == null) {
            this.f4165a = new y0<>(this);
        }
        return this.f4165a;
    }

    public final IBinder onBind(Intent intent) {
        c();
        return null;
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
}

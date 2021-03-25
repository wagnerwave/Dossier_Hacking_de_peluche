package com.google.android.gms.measurement;

import a.d.a.a.i.b.c5;
import a.d.a.a.i.b.d5;
import a.d.a.a.i.b.o9;
import a.d.a.a.i.b.t8;
import a.d.a.a.i.b.w8;
import a.d.a.a.i.b.x3;
import a.d.a.a.i.b.x8;
import a.d.a.a.i.b.y8;
import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.measurement.zzae;

public final class AppMeasurementService extends Service implements x8 {

    /* renamed from: a  reason: collision with root package name */
    public t8<AppMeasurementService> f4268a;

    public final void a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void b(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final t8<AppMeasurementService> c() {
        if (this.f4268a == null) {
            this.f4268a = new t8<>(this);
        }
        return this.f4268a;
    }

    public final boolean f(int i) {
        return stopSelfResult(i);
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        t8<AppMeasurementService> c2 = c();
        if (c2 == null) {
            throw null;
        } else if (intent == null) {
            c2.b().f.a("onBind called with null intent");
            return null;
        } else {
            String action = intent.getAction();
            if ("com.google.android.gms.measurement.START".equals(action)) {
                return new d5(o9.b(c2.f2534a));
            }
            c2.b().i.b("onBind received unknown action", action);
            return null;
        }
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

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        t8<AppMeasurementService> c2 = c();
        x3 i3 = c5.a(c2.f2534a, (zzae) null, (Long) null).i();
        if (intent == null) {
            i3.i.a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        i3.n.c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        w8 w8Var = new w8(c2, i2, i3, intent);
        o9 b2 = o9.b(c2.f2534a);
        b2.f().v(new y8(b2, w8Var));
        return 2;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        c().a(intent);
        return true;
    }
}

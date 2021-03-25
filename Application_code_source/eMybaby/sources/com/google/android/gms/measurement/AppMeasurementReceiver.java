package com.google.android.gms.measurement;

import a.d.a.a.i.b.c5;
import a.d.a.a.i.b.t4;
import a.d.a.a.i.b.u4;
import a.d.a.a.i.b.x3;
import a.d.a.a.i.b.z3;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.measurement.zzae;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements t4 {

    /* renamed from: a  reason: collision with root package name */
    public u4 f4267a;

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        String str;
        z3 z3Var;
        if (this.f4267a == null) {
            this.f4267a = new u4(this);
        }
        u4 u4Var = this.f4267a;
        if (u4Var != null) {
            x3 i = c5.a(context, (zzae) null, (Long) null).i();
            if (intent == null) {
                z3Var = i.i;
                str = "Receiver called with null intent";
            } else {
                String action = intent.getAction();
                i.n.b("Local receiver got", action);
                if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                    Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
                    className.setAction("com.google.android.gms.measurement.UPLOAD");
                    i.n.a("Starting wakeful intent.");
                    if (((AppMeasurementReceiver) u4Var.f2540a) != null) {
                        WakefulBroadcastReceiver.startWakefulService(context, className);
                        return;
                    }
                    throw null;
                } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                    z3Var = i.i;
                    str = "Install Referrer Broadcasts are deprecated";
                } else {
                    return;
                }
            }
            z3Var.a(str);
            return;
        }
        throw null;
    }
}

package com.google.android.gms.analytics;

import a.d.a.a.h.f.x0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresPermission;

public final class AnalyticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public x0 f4164a;

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onReceive(Context context, Intent intent) {
        if (this.f4164a == null) {
            this.f4164a = new x0();
        }
        x0.a(context, intent);
    }
}

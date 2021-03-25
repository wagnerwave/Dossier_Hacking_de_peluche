package com.google.android.gms.measurement.module;

import a.c.a.f.b;
import a.d.a.a.i.b.c5;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.internal.measurement.zzae;

public class Analytics {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Analytics f4295a;

    public Analytics(c5 c5Var) {
        b.k(c5Var);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static Analytics getInstance(Context context) {
        if (f4295a == null) {
            synchronized (Analytics.class) {
                if (f4295a == null) {
                    f4295a = new Analytics(c5.a(context, (zzae) null, (Long) null));
                }
            }
        }
        return f4295a;
    }
}

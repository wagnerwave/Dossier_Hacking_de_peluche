package a.d.a.a.e.q;

import a.c.a.f.b;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final IntentFilter f1438a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: b  reason: collision with root package name */
    public static long f1439b;

    /* renamed from: c  reason: collision with root package name */
    public static float f1440c = Float.NaN;

    @TargetApi(20)
    public static int a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f1438a);
        int i = 0;
        int intExtra = registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0);
        int i2 = 3;
        int i3 = 1;
        if (Build.VERSION.SDK_INT >= 17) {
            i2 = 7;
        }
        if ((intExtra & i2) == 0) {
            i3 = 0;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (b.N() ? powerManager.isInteractive() : powerManager.isScreenOn()) {
            i = 2;
        }
        return i | i3;
    }
}

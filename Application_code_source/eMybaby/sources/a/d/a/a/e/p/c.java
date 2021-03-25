package a.d.a.a.e.p;

import a.d.a.a.e.q.i;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.List;
import okhttp3.internal.ws.RealWebSocket;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f1428a;

    public static void a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        float f;
        int i3 = i;
        List<String> list2 = list;
        if (f1428a == null) {
            f1428a = Boolean.FALSE;
        }
        if (f1428a.booleanValue()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
            } else if (7 == i3 || 8 == i3 || 10 == i3 || 11 == i3) {
                long currentTimeMillis = System.currentTimeMillis();
                List<String> list3 = (list2 == null || list.size() != 1 || !"com.google.android.gms".equals(list2.get(0))) ? list2 : null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int a2 = i.a(context);
                String packageName = context.getPackageName();
                String str5 = "com.google.android.gms".equals(packageName) ? null : packageName;
                synchronized (i.class) {
                    if (SystemClock.elapsedRealtime() - i.f1439b >= RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS || Float.isNaN(i.f1440c)) {
                        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, i.f1438a);
                        if (registerReceiver != null) {
                            i.f1440c = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                        }
                        i.f1439b = SystemClock.elapsedRealtime();
                    }
                    f = i.f1440c;
                }
                WakeLockEvent wakeLockEvent = r1;
                WakeLockEvent wakeLockEvent2 = new WakeLockEvent(2, currentTimeMillis, i, str2, i2, list3, str, elapsedRealtime, a2, str3, str5, f, j, str4, false);
                try {
                    context.startService(new Intent().setComponent(b.f1427a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
                } catch (Exception e2) {
                    Log.wtf("WakeLockTracker", e2);
                }
            }
        }
    }
}

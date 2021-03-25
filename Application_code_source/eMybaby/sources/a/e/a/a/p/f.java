package a.e.a.a.p;

import a.e.a.a.p.i.g;
import a.e.a.a.p.i.h;
import a.e.a.a.r.b;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.Arrays;
import java.util.List;

public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f3269c = {"android.bluetooth.adapter.action.STATE_CHANGED"};

    /* renamed from: b  reason: collision with root package name */
    public LocalBroadcastManager f3270b;

    public f(h hVar) {
        super(hVar);
    }

    public List<String> a() {
        return Arrays.asList(f3269c);
    }

    public boolean c(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 0);
        Log.v("miio-bluetooth", b.o("state changed: %s -> %s", d(intExtra2), d(intExtra)));
        for (g invoke : b(h.class)) {
            invoke.invoke(Integer.valueOf(intExtra2), Integer.valueOf(intExtra));
        }
        this.f3270b = LocalBroadcastManager.getInstance(context);
        Intent intent2 = new Intent();
        intent2.setAction("com.tuya.smart.bluetooth.received");
        intent2.putExtra("state", intExtra);
        this.f3270b.sendBroadcast(intent2);
        return true;
    }

    public final String d(int i) {
        switch (i) {
            case 10:
                return "state_off";
            case 11:
                return "state_turning_on";
            case 12:
                return "state_on";
            case 13:
                return "state_turning_off";
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }
}

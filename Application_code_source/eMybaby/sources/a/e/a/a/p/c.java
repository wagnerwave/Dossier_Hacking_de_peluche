package a.e.a.a.p;

import a.e.a.a.p.i.g;
import a.e.a.a.r.b;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.Arrays;
import java.util.List;

public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3261b = {"action.connect_status_changed"};

    public c(h hVar) {
        super(hVar);
    }

    public List<String> a() {
        return Arrays.asList(f3261b);
    }

    public boolean c(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("extra.mac");
        int intExtra = intent.getIntExtra("extra.status", 0);
        Log.v("miio-bluetooth", b.o("onConnectStatusChanged for %s, status = %d", stringExtra, Integer.valueOf(intExtra)));
        for (g invoke : b(a.e.a.a.p.i.c.class)) {
            invoke.invoke(stringExtra, Integer.valueOf(intExtra));
        }
        return true;
    }
}

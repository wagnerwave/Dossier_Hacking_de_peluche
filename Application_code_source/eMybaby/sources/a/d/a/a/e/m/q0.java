package a.d.a.a.e.m;

import a.d.a.a.e.r.c;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;

public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    public static Object f1409a = new Object();
    @GuardedBy("sLock")

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1410b;

    /* renamed from: c  reason: collision with root package name */
    public static String f1411c;

    /* renamed from: d  reason: collision with root package name */
    public static int f1412d;

    public static void a(Context context) {
        synchronized (f1409a) {
            if (!f1410b) {
                f1410b = true;
                try {
                    Bundle bundle = c.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f1411c = bundle.getString("com.google.app.id");
                        f1412d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e2);
                }
            }
        }
    }
}

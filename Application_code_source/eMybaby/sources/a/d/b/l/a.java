package a.d.b.l;

import a.d.b.h.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2845a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f2846b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f2847c;

    public a(Context context, String str, c cVar) {
        ApplicationInfo applicationInfo;
        this.f2845a = (Build.VERSION.SDK_INT < 24 || ContextCompat.isDeviceProtectedStorage(context)) ? context : ContextCompat.createDeviceProtectedStorageContext(context);
        this.f2846b = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        boolean z = true;
        if (this.f2846b.contains("firebase_data_collection_default_enabled")) {
            z = this.f2846b.getBoolean("firebase_data_collection_default_enabled", true);
        } else {
            try {
                PackageManager packageManager = this.f2845a.getPackageManager();
                if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f2845a.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled"))) {
                    z = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        this.f2847c = new AtomicBoolean(z);
    }
}

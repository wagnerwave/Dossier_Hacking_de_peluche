package a.d.a.a.a.a;

import a.d.a.a.e.g;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f1177a;

    public c(Context context) {
        try {
            Context c2 = g.c(context);
            this.f1177a = c2 == null ? null : c2.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f1177a = null;
        }
    }

    public final boolean a(String str) {
        try {
            if (this.f1177a == null) {
                return false;
            }
            return this.f1177a.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}

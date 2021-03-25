package a.d.b.i;

import android.content.Context;
import android.content.SharedPreferences;

public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f2784b;

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f2785a;

    public d(Context context) {
        this.f2785a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    public synchronized boolean a(String str, long j) {
        if (!this.f2785a.contains(str)) {
            this.f2785a.edit().putLong(str, j).apply();
            return true;
        } else if (j - this.f2785a.getLong(str, -1) < 86400000) {
            return false;
        } else {
            this.f2785a.edit().putLong(str, j).apply();
            return true;
        }
    }
}

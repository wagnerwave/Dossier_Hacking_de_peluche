package a.d.a.a.h.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Map;

public final class m2 implements t1 {
    @GuardedBy("SharedPreferencesLoader.class")

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, m2> f1823e = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f1824a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences.OnSharedPreferenceChangeListener f1825b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f1826c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Map<String, ?> f1827d;

    public static m2 a(Context context) {
        m2 m2Var;
        if (!n1.a()) {
            synchronized (m2.class) {
                m2Var = f1823e.get((Object) null);
                if (m2Var == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return m2Var;
        }
        throw null;
    }

    public static synchronized void b() {
        synchronized (m2.class) {
            for (m2 next : f1823e.values()) {
                next.f1824a.unregisterOnSharedPreferenceChangeListener(next.f1825b);
            }
            f1823e.clear();
        }
    }

    /* JADX INFO: finally extract failed */
    public final Object g(String str) {
        Map<String, ?> map = this.f1827d;
        if (map == null) {
            synchronized (this.f1826c) {
                map = this.f1827d;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f1824a.getAll();
                        this.f1827d = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}

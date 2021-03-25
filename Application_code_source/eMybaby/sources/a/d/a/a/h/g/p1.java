package a.d.a.a.h.g;

import a.c.a.f.b;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.app.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class p1 implements t1 {
    @GuardedBy("ConfigurationContentLoader.class")
    public static final Map<Uri, p1> g = new ArrayMap();
    public static final String[] h = {Person.KEY_KEY, "value"};

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f1876a;

    /* renamed from: b  reason: collision with root package name */
    public final Uri f1877b;

    /* renamed from: c  reason: collision with root package name */
    public final ContentObserver f1878c = new r1(this);

    /* renamed from: d  reason: collision with root package name */
    public final Object f1879d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile Map<String, String> f1880e;
    @GuardedBy("this")
    public final List<u1> f = new ArrayList();

    public p1(ContentResolver contentResolver, Uri uri) {
        this.f1876a = contentResolver;
        this.f1877b = uri;
        contentResolver.registerContentObserver(uri, false, this.f1878c);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a.d.a.a.h.g.p1 a(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            java.lang.Class<a.d.a.a.h.g.p1> r0 = a.d.a.a.h.g.p1.class
            monitor-enter(r0)
            java.util.Map<android.net.Uri, a.d.a.a.h.g.p1> r1 = g     // Catch:{ all -> 0x001a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x001a }
            a.d.a.a.h.g.p1 r1 = (a.d.a.a.h.g.p1) r1     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            a.d.a.a.h.g.p1 r2 = new a.d.a.a.h.g.p1     // Catch:{ SecurityException -> 0x0018 }
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x0018 }
            java.util.Map<android.net.Uri, a.d.a.a.h.g.p1> r3 = g     // Catch:{ SecurityException -> 0x0017 }
            r3.put(r4, r2)     // Catch:{ SecurityException -> 0x0017 }
        L_0x0017:
            r1 = r2
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r1
        L_0x001a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.p1.a(android.content.ContentResolver, android.net.Uri):a.d.a.a.h.g.p1");
    }

    public static synchronized void c() {
        synchronized (p1.class) {
            for (p1 next : g.values()) {
                next.f1876a.unregisterContentObserver(next.f1878c);
            }
            g.clear();
        }
    }

    /* JADX INFO: finally extract failed */
    public final Map<String, String> b() {
        Map<String, String> map;
        Map<String, String> map2 = this.f1880e;
        if (map2 == null) {
            synchronized (this.f1879d) {
                map2 = this.f1880e;
                if (map2 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        map = (Map) b.X0(new s1(this));
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        try {
                            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            map = null;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                    }
                    this.f1880e = map;
                    map2 = map;
                }
            }
        }
        return map2 != null ? map2 : Collections.emptyMap();
    }

    public final /* synthetic */ Object g(String str) {
        return b().get(str);
    }
}

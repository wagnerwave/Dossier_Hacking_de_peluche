package a.d.c.q.a;

import a.d.c.a;
import a.d.c.e;
import a.d.c.o;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.google.zxing.client.android.CaptureActivity;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public final class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final CaptureActivity f2927a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<e, Object> f2928b = new EnumMap(e.class);

    /* renamed from: c  reason: collision with root package name */
    public Handler f2929c;

    /* renamed from: d  reason: collision with root package name */
    public final CountDownLatch f2930d = new CountDownLatch(1);

    public f(CaptureActivity captureActivity, Collection<a> collection, String str, o oVar) {
        this.f2927a = captureActivity;
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(captureActivity);
            collection = EnumSet.noneOf(a.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D", false)) {
                collection.addAll(d.f2920c);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", false)) {
                collection.addAll(d.f2921d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", false)) {
                collection.addAll(d.f2922e);
            }
        }
        this.f2928b.put(e.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f2928b.put(e.CHARACTER_SET, str);
        }
        this.f2928b.put(e.NEED_RESULT_POINT_CALLBACK, oVar);
    }

    public Handler a() {
        try {
            this.f2930d.await();
        } catch (InterruptedException unused) {
        }
        return this.f2929c;
    }

    public void run() {
        Looper.prepare();
        this.f2929c = new e(this.f2927a, this.f2928b);
        this.f2930d.countDown();
        Looper.loop();
    }
}

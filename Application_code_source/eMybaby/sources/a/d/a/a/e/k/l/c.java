package a.d.a.a.e.k.l;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    public static final c f1269e = new c();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f1270a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f1271b = new AtomicBoolean();
    @GuardedBy("sInstance")

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<a> f1272c = new ArrayList<>();
    @GuardedBy("sInstance")

    /* renamed from: d  reason: collision with root package name */
    public boolean f1273d = false;

    public interface a {
        void a(boolean z);
    }

    public static void a(Application application) {
        synchronized (f1269e) {
            if (!f1269e.f1273d) {
                application.registerActivityLifecycleCallbacks(f1269e);
                application.registerComponentCallbacks(f1269e);
                f1269e.f1273d = true;
            }
        }
    }

    public final void b(boolean z) {
        synchronized (f1269e) {
            ArrayList<a> arrayList = this.f1272c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                a aVar = arrayList.get(i);
                i++;
                aVar.a(z);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f1270a.compareAndSet(true, false);
        this.f1271b.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f1270a.compareAndSet(true, false);
        this.f1271b.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.f1270a.compareAndSet(false, true)) {
            this.f1271b.set(true);
            b(true);
        }
    }
}

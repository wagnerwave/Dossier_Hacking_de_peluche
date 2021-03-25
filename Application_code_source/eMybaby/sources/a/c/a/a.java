package a.c.a;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import java.util.Hashtable;

public abstract class a extends Application implements Application.ActivityLifecycleCallbacks {
    public static a f;

    /* renamed from: a  reason: collision with root package name */
    public Hashtable<String, Hashtable<String, String>> f0a;

    /* renamed from: b  reason: collision with root package name */
    public String f1b;

    /* renamed from: c  reason: collision with root package name */
    public String f2c;

    /* renamed from: d  reason: collision with root package name */
    public int f3d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4e = false;

    public String a() {
        if (this.f2c == null) {
            try {
                this.f2c = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return this.f2c;
    }

    public final String b() {
        if (b.b() == null) {
            return null;
        }
        return b.b().c();
    }

    public String c(String str) {
        String str2;
        Hashtable hashtable = this.f0a.get(this.f1b);
        if (!(hashtable == null || (str2 = (String) hashtable.get(str)) == null)) {
            str = str2;
        }
        return str.replace("\\n", "\n");
    }

    public abstract void d();

    public final void e(String str) {
        b.b().j(str);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @CallSuper
    public void onActivityStarted(Activity activity) {
        int i = this.f3d + 1;
        this.f3d = i;
        if (i == 1) {
            boolean z = this.f4e;
        }
    }

    @CallSuper
    public void onActivityStopped(Activity activity) {
        this.f4e = activity.isChangingConfigurations();
        this.f3d--;
    }

    public void onCreate() {
        f = this;
        d();
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
    }
}

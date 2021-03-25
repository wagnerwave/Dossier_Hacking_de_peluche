package a.d.a.a.h.g;

import a.c.a.f.b;
import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

public final class x1 implements t1 {
    @GuardedBy("GservicesLoader.class")

    /* renamed from: c  reason: collision with root package name */
    public static x1 f2019c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Context f2020a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final ContentObserver f2021b;

    public x1() {
        this.f2020a = null;
        this.f2021b = null;
    }

    public x1(Context context) {
        this.f2020a = context;
        this.f2021b = new z1();
        context.getContentResolver().registerContentObserver(l1.f1791a, true, this.f2021b);
    }

    public static x1 a(Context context) {
        x1 x1Var;
        synchronized (x1.class) {
            if (f2019c == null) {
                f2019c = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new x1(context) : new x1();
            }
            x1Var = f2019c;
        }
        return x1Var;
    }

    public static synchronized void b() {
        synchronized (x1.class) {
            if (!(f2019c == null || f2019c.f2020a == null || f2019c.f2021b == null)) {
                f2019c.f2020a.getContentResolver().unregisterContentObserver(f2019c.f2021b);
            }
            f2019c = null;
        }
    }

    public final Object g(String str) {
        if (this.f2020a == null) {
            return null;
        }
        try {
            return (String) b.X0(new w1(this, str));
        } catch (IllegalStateException | SecurityException e2) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }
}

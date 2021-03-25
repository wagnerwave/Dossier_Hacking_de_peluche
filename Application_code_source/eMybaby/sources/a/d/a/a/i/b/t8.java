package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.i.b.x8;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzae;

public final class t8<T extends Context & x8> {

    /* renamed from: a  reason: collision with root package name */
    public final T f2534a;

    public t8(T t) {
        b.k(t);
        this.f2534a = t;
    }

    @MainThread
    public final boolean a(Intent intent) {
        if (intent == null) {
            b().f.a("onUnbind called with null intent");
            return true;
        }
        b().n.b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final x3 b() {
        return c5.a(this.f2534a, (zzae) null, (Long) null).i();
    }

    @MainThread
    public final void c(Intent intent) {
        if (intent == null) {
            b().f.a("onRebind called with null intent");
            return;
        }
        b().n.b("onRebind called. action", intent.getAction());
    }
}

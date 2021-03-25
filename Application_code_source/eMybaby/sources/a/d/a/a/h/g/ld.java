package a.d.a.a.h.g;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class ld extends rd {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<Bundle> f1814a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f1815b;

    public static <T> T g(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            String canonicalName = cls.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            Log.w("AM", String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), new Object[]{canonicalName, canonicalName2}), e2);
            throw e2;
        }
    }

    public final Bundle U(long j) {
        Bundle bundle;
        synchronized (this.f1814a) {
            if (!this.f1815b) {
                try {
                    this.f1814a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f1814a.get();
        }
        return bundle;
    }

    public final void f(Bundle bundle) {
        synchronized (this.f1814a) {
            try {
                this.f1814a.set(bundle);
                this.f1815b = true;
                this.f1814a.notify();
            } catch (Throwable th) {
                this.f1814a.notify();
                throw th;
            }
        }
    }

    public final String h(long j) {
        return (String) g(U(j), String.class);
    }
}

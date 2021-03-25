package com.google.firebase.analytics;

import a.c.a.f.b;
import a.d.a.a.h.g.f;
import a.d.a.a.h.g.l;
import a.d.a.a.i.b.f7;
import a.d.b.k.c;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class FirebaseAnalytics {

    /* renamed from: b  reason: collision with root package name */
    public static volatile FirebaseAnalytics f4304b;

    /* renamed from: a  reason: collision with root package name */
    public final f f4305a;

    public FirebaseAnalytics(f fVar) {
        b.k(fVar);
        this.f4305a = fVar;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f4304b == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f4304b == null) {
                    f4304b = new FirebaseAnalytics(f.a(context, (String) null, (String) null, (String) null, (Bundle) null));
                }
            }
        }
        return f4304b;
    }

    @Keep
    public static f7 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        f a2 = f.a(context, (String) null, (String) null, (String) null, bundle);
        if (a2 == null) {
            return null;
        }
        return new a.d.b.f.b(a2);
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) b.a(c.e().d(), 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        } catch (InterruptedException e3) {
            throw new IllegalStateException(e3);
        }
    }

    @MainThread
    @Deprecated
    @Keep
    public final void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        f fVar = this.f4305a;
        if (fVar != null) {
            fVar.f1683c.execute(new l(fVar, activity, str, str2));
            return;
        }
        throw null;
    }
}

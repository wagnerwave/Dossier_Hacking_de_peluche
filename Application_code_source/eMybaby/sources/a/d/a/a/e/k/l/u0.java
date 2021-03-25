package a.d.a.a.e.k.l;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public final class u0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f1334a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1335b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v0 f1336c;

    public u0(v0 v0Var, LifecycleCallback lifecycleCallback, String str) {
        this.f1336c = v0Var;
        this.f1334a = lifecycleCallback;
        this.f1335b = str;
    }

    public final void run() {
        v0 v0Var = this.f1336c;
        if (v0Var.f1340b > 0) {
            LifecycleCallback lifecycleCallback = this.f1334a;
            Bundle bundle = v0Var.f1341c;
            lifecycleCallback.d(bundle != null ? bundle.getBundle(this.f1335b) : null);
        }
        if (this.f1336c.f1340b >= 2) {
            this.f1334a.g();
        }
        if (this.f1336c.f1340b >= 3) {
            this.f1334a.e();
        }
        if (this.f1336c.f1340b >= 4) {
            this.f1334a.h();
        }
        if (this.f1336c.f1340b >= 5 && this.f1334a == null) {
            throw null;
        }
    }
}

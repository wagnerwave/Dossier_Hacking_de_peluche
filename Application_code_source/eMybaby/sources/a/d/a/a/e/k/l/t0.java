package a.d.a.a.e.k.l;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public final class t0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f1330a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1331b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s0 f1332c;

    public t0(s0 s0Var, LifecycleCallback lifecycleCallback, String str) {
        this.f1332c = s0Var;
        this.f1330a = lifecycleCallback;
        this.f1331b = str;
    }

    public final void run() {
        s0 s0Var = this.f1332c;
        if (s0Var.f1327b > 0) {
            LifecycleCallback lifecycleCallback = this.f1330a;
            Bundle bundle = s0Var.f1328c;
            lifecycleCallback.d(bundle != null ? bundle.getBundle(this.f1331b) : null);
        }
        if (this.f1332c.f1327b >= 2) {
            this.f1330a.g();
        }
        if (this.f1332c.f1327b >= 3) {
            this.f1330a.e();
        }
        if (this.f1332c.f1327b >= 4) {
            this.f1330a.h();
        }
        if (this.f1332c.f1327b >= 5 && this.f1330a == null) {
            throw null;
        }
    }
}

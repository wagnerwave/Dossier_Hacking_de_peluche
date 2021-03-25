package a.d.a.a.i.b;

import android.os.Bundle;
import java.util.List;

public final class o7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bundle f2434a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m7 f2435b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m7 f2436c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f2437d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l7 f2438e;

    public o7(l7 l7Var, Bundle bundle, m7 m7Var, m7 m7Var2, long j) {
        this.f2438e = l7Var;
        this.f2434a = bundle;
        this.f2435b = m7Var;
        this.f2436c = m7Var2;
        this.f2437d = j;
    }

    public final void run() {
        l7 l7Var = this.f2438e;
        Bundle bundle = this.f2434a;
        m7 m7Var = this.f2435b;
        m7 m7Var2 = this.f2436c;
        long j = this.f2437d;
        if (l7Var != null) {
            if (bundle != null) {
                bundle.remove("screen_name");
                bundle.remove("screen_class");
            }
            l7Var.D(m7Var, m7Var2, j, true, l7Var.e().z((String) null, "screen_view", bundle, (List<String>) null, true, true));
            return;
        }
        throw null;
    }
}

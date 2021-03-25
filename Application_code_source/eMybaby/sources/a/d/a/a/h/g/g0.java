package a.d.a.a.h.g;

import a.d.a.a.f.b;
import a.d.a.a.h.g.f;
import android.app.Activity;

public final class g0 extends f.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Activity f1711e;
    public final /* synthetic */ f.b f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(f.b bVar, Activity activity) {
        super(true);
        this.f = bVar;
        this.f1711e = activity;
    }

    public final void a() {
        f.this.h.onActivityDestroyed(new b(this.f1711e), this.f1687b);
    }
}

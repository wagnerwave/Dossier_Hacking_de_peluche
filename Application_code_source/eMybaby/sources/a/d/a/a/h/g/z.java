package a.d.a.a.h.g;

import a.d.a.a.h.g.f;
import android.os.Bundle;

public final class z extends f.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Long f2054e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Bundle h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ f k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(f fVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(true);
        this.k = fVar;
        this.f2054e = l;
        this.f = str;
        this.g = str2;
        this.h = bundle;
        this.i = z;
        this.j = z2;
    }

    public final void a() {
        Long l = this.f2054e;
        this.k.h.logEvent(this.f, this.g, this.h, this.i, this.j, l == null ? this.f1686a : l.longValue());
    }
}

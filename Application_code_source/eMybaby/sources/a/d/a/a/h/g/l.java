package a.d.a.a.h.g;

import a.d.a.a.f.b;
import a.d.a.a.h.g.f;
import android.app.Activity;

public final class l extends f.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Activity f1790e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ f h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(f fVar, Activity activity, String str, String str2) {
        super(true);
        this.h = fVar;
        this.f1790e = activity;
        this.f = str;
        this.g = str2;
    }

    public final void a() {
        this.h.h.setCurrentScreen(new b(this.f1790e), this.f, this.g, this.f1686a);
    }
}

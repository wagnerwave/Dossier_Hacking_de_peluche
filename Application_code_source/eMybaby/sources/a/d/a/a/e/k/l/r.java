package a.d.a.a.e.k.l;

import a.d.a.a.e.k.l.c;
import android.os.Handler;

public final class r implements c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f1321a;

    public r(f fVar) {
        this.f1321a = fVar;
    }

    public final void a(boolean z) {
        Handler handler = this.f1321a.m;
        handler.sendMessage(handler.obtainMessage(1, Boolean.valueOf(z)));
    }
}

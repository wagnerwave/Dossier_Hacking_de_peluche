package a.d.a.a.h.f;

import android.os.Looper;

public final class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f1491a;

    public e0(d0 d0Var) {
        this.f1491a = d0Var;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f1491a.f1485a.d().a(this);
            return;
        }
        boolean d2 = this.f1491a.d();
        this.f1491a.f1487c = 0;
        if (d2) {
            this.f1491a.c();
        }
    }
}

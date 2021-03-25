package a.d.a.a.h.g;

import android.database.ContentObserver;
import android.os.Handler;

public final class r1 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p1 f1910a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r1(p1 p1Var) {
        super((Handler) null);
        this.f1910a = p1Var;
    }

    public final void onChange(boolean z) {
        p1 p1Var = this.f1910a;
        synchronized (p1Var.f1879d) {
            p1Var.f1880e = null;
            c2.j.incrementAndGet();
        }
        synchronized (p1Var) {
            for (u1 a2 : p1Var.f) {
                a2.a();
            }
        }
    }
}

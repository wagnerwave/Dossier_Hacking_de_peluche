package a.d.a.a.l;

import a.c.a.f.b;
import androidx.annotation.NonNull;
import javax.annotation.concurrent.GuardedBy;

public final class p<TResult> extends p<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2708a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final n<TResult> f2709b = new n<>();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    public boolean f2710c;
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    public TResult f2711d;
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    public Exception f2712e;

    public final TResult a() {
        TResult tresult;
        synchronized (this.f2708a) {
            b.o(this.f2710c, "Task is not yet complete");
            if (this.f2712e == null) {
                tresult = this.f2711d;
            } else {
                throw new d(this.f2712e);
            }
        }
        return tresult;
    }

    public final <X extends Throwable> TResult b(@NonNull Class<X> cls) {
        TResult tresult;
        synchronized (this.f2708a) {
            b.o(this.f2710c, "Task is not yet complete");
            if (cls.isInstance(this.f2712e)) {
                throw ((Throwable) cls.cast(this.f2712e));
            } else if (this.f2712e == null) {
                tresult = this.f2711d;
            } else {
                throw new d(this.f2712e);
            }
        }
        return tresult;
    }

    public final boolean c() {
        boolean z;
        synchronized (this.f2708a) {
            z = this.f2710c && this.f2712e == null;
        }
        return z;
    }

    public final void d(@NonNull Exception exc) {
        b.l(exc, "Exception must not be null");
        synchronized (this.f2708a) {
            b.o(!this.f2710c, "Task is already complete");
            this.f2710c = true;
            this.f2712e = exc;
        }
        this.f2709b.b(this);
    }

    public final void e(TResult tresult) {
        synchronized (this.f2708a) {
            b.o(!this.f2710c, "Task is already complete");
            this.f2710c = true;
            this.f2711d = tresult;
        }
        this.f2709b.b(this);
    }

    public final void f() {
        synchronized (this.f2708a) {
            if (this.f2710c) {
                this.f2709b.b(this);
            }
        }
    }
}

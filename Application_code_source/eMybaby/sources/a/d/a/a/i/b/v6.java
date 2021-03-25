package a.d.a.a.i.b;

import java.util.concurrent.atomic.AtomicReference;

public final class v6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2564a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2565b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2566c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f2567d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ f6 f2568e;

    public v6(f6 f6Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f2568e = f6Var;
        this.f2564a = atomicReference;
        this.f2565b = str;
        this.f2566c = str2;
        this.f2567d = str3;
    }

    public final void run() {
        u7 x = this.f2568e.f2563a.x();
        AtomicReference atomicReference = this.f2564a;
        String str = this.f2565b;
        String str2 = this.f2566c;
        String str3 = this.f2567d;
        x.b();
        x.u();
        x.B(new j8(x, atomicReference, str, str2, str3, x.K(false)));
    }
}

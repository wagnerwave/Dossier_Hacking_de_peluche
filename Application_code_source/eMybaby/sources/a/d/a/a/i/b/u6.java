package a.d.a.a.i.b;

import java.util.concurrent.atomic.AtomicReference;

public final class u6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2543a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2544b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2545c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f2546d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f2547e;
    public final /* synthetic */ f6 f;

    public u6(f6 f6Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f = f6Var;
        this.f2543a = atomicReference;
        this.f2544b = str;
        this.f2545c = str2;
        this.f2546d = str3;
        this.f2547e = z;
    }

    public final void run() {
        u7 x = this.f.f2563a.x();
        AtomicReference atomicReference = this.f2543a;
        String str = this.f2544b;
        String str2 = this.f2545c;
        String str3 = this.f2546d;
        boolean z = this.f2547e;
        x.b();
        x.u();
        x.B(new l8(x, atomicReference, str, str2, str3, z, x.K(false)));
    }
}

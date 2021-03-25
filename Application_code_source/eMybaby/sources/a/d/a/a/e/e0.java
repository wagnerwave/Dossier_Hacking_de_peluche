package a.d.a.a.e;

import java.util.concurrent.Callable;

public final class e0 extends c0 {

    /* renamed from: e  reason: collision with root package name */
    public final Callable<String> f1240e;

    public e0(Callable callable, f0 f0Var) {
        super(false, (String) null, (Throwable) null);
        this.f1240e = callable;
    }

    public final String a() {
        try {
            return this.f1240e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}

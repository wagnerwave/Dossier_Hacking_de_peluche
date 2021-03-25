package a.d.a.a.i.b;

import a.c.a.f.b;
import java.lang.Thread;

public final class x4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final String f2620a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v4 f2621b;

    public x4(v4 v4Var, String str) {
        this.f2621b = v4Var;
        b.k(str);
        this.f2620a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f2621b.i().f.b(this.f2620a, th);
    }
}

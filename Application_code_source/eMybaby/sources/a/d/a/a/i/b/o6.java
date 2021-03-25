package a.d.a.a.i.b;

import android.os.Bundle;

public final class o6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2429a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2430b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f2431c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bundle f2432d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f2433e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ String h = null;
    public final /* synthetic */ f6 i;

    public o6(f6 f6Var, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.i = f6Var;
        this.f2429a = str;
        this.f2430b = str2;
        this.f2431c = j;
        this.f2432d = bundle;
        this.f2433e = z;
        this.f = z2;
        this.g = z3;
    }

    public final void run() {
        this.i.F(this.f2429a, this.f2430b, this.f2431c, this.f2432d, this.f2433e, this.f, this.g, this.h);
    }
}

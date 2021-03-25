package a.d.a.a.i.b;

import android.content.Intent;

public final /* synthetic */ class w8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final t8 f2602a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2603b;

    /* renamed from: c  reason: collision with root package name */
    public final x3 f2604c;

    /* renamed from: d  reason: collision with root package name */
    public final Intent f2605d;

    public w8(t8 t8Var, int i, x3 x3Var, Intent intent) {
        this.f2602a = t8Var;
        this.f2603b = i;
        this.f2604c = x3Var;
        this.f2605d = intent;
    }

    public final void run() {
        t8 t8Var = this.f2602a;
        int i = this.f2603b;
        x3 x3Var = this.f2604c;
        Intent intent = this.f2605d;
        if (((x8) t8Var.f2534a).f(i)) {
            x3Var.n.b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            t8Var.b().n.a("Completed wakeful intent.");
            ((x8) t8Var.f2534a).b(intent);
        }
    }
}

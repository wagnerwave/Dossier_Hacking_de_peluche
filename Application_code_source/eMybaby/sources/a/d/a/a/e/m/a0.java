package a.d.a.a.e.m;

import a.c.a.f.b;
import a.d.a.a.e.k.e;
import a.d.a.a.e.k.i;
import a.d.a.a.e.m.p;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.concurrent.TimeUnit;

public final class a0 implements e.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f1351a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.d.a.a.l.e f1352b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.a f1353c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ p.b f1354d;

    public a0(e eVar, a.d.a.a.l.e eVar2, p.a aVar, p.b bVar) {
        this.f1351a = eVar;
        this.f1352b = eVar2;
        this.f1353c = aVar;
        this.f1354d = bVar;
    }

    public final void a(Status status) {
        if (status.e()) {
            e eVar = this.f1351a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            BasePendingResult basePendingResult = (BasePendingResult) eVar;
            if (basePendingResult != null) {
                b.o(!basePendingResult.i, "Result has already been consumed.");
                b.o(true, "Cannot await if then() has been called.");
                try {
                    if (!basePendingResult.f4212c.await(0, timeUnit)) {
                        basePendingResult.h(Status.h);
                    }
                } catch (InterruptedException unused) {
                    basePendingResult.h(Status.f);
                }
                b.o(basePendingResult.d(), "Result is not ready.");
                i c2 = basePendingResult.c();
                a.d.a.a.l.e eVar2 = this.f1352b;
                eVar2.f2689a.e(this.f1353c.a(c2));
                return;
            }
            throw null;
        }
        a.d.a.a.l.e eVar3 = this.f1352b;
        if (((z) this.f1354d) != null) {
            eVar3.f2689a.d(b.C(status));
            return;
        }
        throw null;
    }
}

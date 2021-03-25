package a.d.b.f.a.c;

import a.c.a.f.b;
import a.d.a.a.h.g.f;
import a.d.b.c;
import a.d.b.g.e;
import a.d.b.g.h;
import a.d.b.g.x;
import a.d.b.h.d;
import android.content.Context;
import android.os.Bundle;

public final /* synthetic */ class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f2731a = new a();

    public final Object a(e eVar) {
        x xVar = (x) eVar;
        c cVar = (c) xVar.a(c.class);
        Context context = (Context) xVar.a(Context.class);
        d dVar = (d) xVar.a(d.class);
        b.k(cVar);
        b.k(context);
        b.k(dVar);
        b.k(context.getApplicationContext());
        if (a.d.b.f.a.b.f2729b == null) {
            synchronized (a.d.b.f.a.b.class) {
                if (a.d.b.f.a.b.f2729b == null) {
                    Bundle bundle = new Bundle(1);
                    if (cVar.f()) {
                        dVar.a(a.d.b.a.class, a.d.b.f.a.e.f2733a, a.d.b.f.a.d.f2732a);
                        cVar.a();
                        bundle.putBoolean("dataCollectionDefaultEnabled", cVar.g.get().f2847c.get());
                    }
                    a.d.b.f.a.b.f2729b = new a.d.b.f.a.b(f.a(context, (String) null, (String) null, (String) null, bundle).f1684d);
                }
            }
        }
        return a.d.b.f.a.b.f2729b;
    }
}

package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.h.g.x0;
import a.d.a.a.h.g.y5;
import a.d.a.a.h.g.z0;
import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Iterator;

public final /* synthetic */ class g5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final d5 f2211a;

    /* renamed from: b  reason: collision with root package name */
    public final zzn f2212b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f2213c;

    public g5(d5 d5Var, zzn zzn, Bundle bundle) {
        this.f2211a = d5Var;
        this.f2212b = zzn;
        this.f2213c = bundle;
    }

    public final void run() {
        zzam zzam;
        d5 d5Var = this.f2211a;
        zzn zzn = this.f2212b;
        Bundle bundle = this.f2213c;
        d J = d5Var.f2148a.J();
        String str = zzn.f4285a;
        J.b();
        J.n();
        c5 c5Var = J.f2563a;
        b.h(str);
        b.h("dep");
        TextUtils.isEmpty("");
        if (bundle == null || bundle.isEmpty()) {
            zzam = new zzam(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2 == null) {
                    c5Var.i().f.a("Param name can't be null");
                } else {
                    Object D = c5Var.t().D(str2, bundle2.get(str2));
                    if (D == null) {
                        c5Var.i().i.b("Param value can't be null", c5Var.u().x(str2));
                    } else {
                        c5Var.t().I(bundle2, str2, D);
                    }
                }
                it.remove();
            }
            zzam = new zzam(bundle2);
        }
        s9 l = J.l();
        x0.a C = x0.C();
        C.v(0);
        for (String str3 : zzam.f4275a.keySet()) {
            z0.a E = z0.E();
            E.q(str3);
            l.F(E, zzam.e(str3));
            C.p(E);
        }
        byte[] j = ((x0) ((y5) C.m())).j();
        J.i().n.c("Saving default event parameters, appId, data size", J.d().u(str), Integer.valueOf(j.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", j);
        try {
            if (J.t().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                J.i().f.b("Failed to insert default event parameters (got -1). appId", x3.s(str));
            }
        } catch (SQLiteException e2) {
            J.i().f.c("Error storing default event parameters. appId", x3.s(str), e2);
        }
    }
}

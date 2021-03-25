package a.d.a.a.i.b;

import a.d.a.a.h.g.kb;
import android.os.Bundle;
import java.util.Iterator;
import java.util.TreeSet;

public final /* synthetic */ class i6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final f6 f2268a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f2269b;

    public i6(f6 f6Var, Bundle bundle) {
        this.f2268a = f6Var;
        this.f2269b = bundle;
    }

    public final void run() {
        boolean z;
        f6 f6Var = this.f2268a;
        Bundle bundle = this.f2269b;
        if (kb.b() && f6Var.f2563a.g.o(q.H0)) {
            if (bundle == null) {
                f6Var.k().C.b(new Bundle());
                return;
            }
            Bundle a2 = f6Var.k().C.a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    f6Var.e();
                    if (v9.U(obj)) {
                        f6Var.e().f0(27, (String) null, (String) null, 0);
                    }
                    f6Var.i().k.c("Invalid default event parameter type. Name, value", str, obj);
                } else if (v9.s0(str)) {
                    f6Var.i().k.b("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    a2.remove(str);
                } else if (f6Var.e().Z("param", str, 100, obj)) {
                    f6Var.e().I(a2, str, obj);
                }
            }
            f6Var.e();
            int s = f6Var.f2563a.g.s();
            if (a2.size() <= s) {
                z = false;
            } else {
                Iterator it = new TreeSet(a2.keySet()).iterator();
                int i = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    i++;
                    if (i > s) {
                        a2.remove(str2);
                    }
                }
                z = true;
            }
            if (z) {
                f6Var.e().f0(26, (String) null, (String) null, 0);
                f6Var.i().k.a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            f6Var.k().C.b(a2);
            u7 q = f6Var.q();
            q.b();
            q.u();
            q.B(new e8(q, a2, q.K(false)));
        }
    }
}

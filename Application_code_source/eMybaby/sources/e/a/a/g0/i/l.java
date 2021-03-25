package e.a.a.g0.i;

import a.a.a.a.a;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.o0ooo00oo;
import e.a.a.c;
import e.a.a.d;
import e.a.a.e0.b;
import e.a.a.e0.e;
import e.a.a.e0.k;
import e.a.a.i0.o;
import e.a.a.i0.t;
import java.util.ArrayList;
import java.util.List;

public class l extends n {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f5070c = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};

    /* renamed from: b  reason: collision with root package name */
    public final String[] f5071b;

    public l(String[] strArr) {
        if (strArr != null) {
            this.f5071b = (String[]) strArr.clone();
        } else {
            this.f5071b = f5070c;
        }
        i("path", new h());
        i("domain", new e());
        i("max-age", new g());
        i("secure", new i());
        i("comment", new d());
        i(BusinessResponse.KEY_EXPIRES, new f(this.f5071b));
    }

    public List<b> c(c cVar, e eVar) {
        t tVar;
        e.a.a.l0.b bVar;
        if (cVar == null) {
            throw new IllegalArgumentException("Header may not be null");
        } else if (eVar == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        } else if (cVar.getName().equalsIgnoreCase("Set-Cookie")) {
            d[] c2 = cVar.c();
            boolean z = false;
            boolean z2 = false;
            for (d dVar : c2) {
                if (dVar.b("version") != null) {
                    z2 = true;
                }
                if (dVar.b(BusinessResponse.KEY_EXPIRES) != null) {
                    z = true;
                }
            }
            if (z || !z2) {
                if (cVar instanceof e.a.a.b) {
                    e.a.a.b bVar2 = (e.a.a.b) cVar;
                    bVar = bVar2.b();
                    tVar = new t(bVar2.d(), bVar.f5184b);
                } else {
                    String value = cVar.getValue();
                    if (value != null) {
                        bVar = new e.a.a.l0.b(value.length());
                        bVar.b(value);
                        tVar = new t(0, bVar.f5184b);
                    } else {
                        throw new k("Header value is null");
                    }
                }
                c2 = new d[]{t.a(bVar, tVar)};
            }
            return h(c2, eVar);
        } else {
            StringBuilder n = a.n("Unrecognized cookie header '");
            n.append(cVar.toString());
            n.append("'");
            throw new k(n.toString());
        }
    }

    public int d() {
        return 0;
    }

    public c e() {
        return null;
    }

    public List<c> f(List<b> list) {
        if (!list.isEmpty()) {
            e.a.a.l0.b bVar = new e.a.a.l0.b(list.size() * 20);
            bVar.b("Cookie");
            bVar.b(": ");
            for (int i = 0; i < list.size(); i++) {
                b bVar2 = list.get(i);
                if (i > 0) {
                    bVar.b("; ");
                }
                bVar.b(bVar2.getName());
                bVar.b(o0ooo00oo.O0000Oo0);
                String value = bVar2.getValue();
                if (value != null) {
                    bVar.b(value);
                }
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new o(bVar));
            return arrayList;
        }
        throw new IllegalArgumentException("List of cookies may not be empty");
    }

    public String toString() {
        return "compatibility";
    }
}

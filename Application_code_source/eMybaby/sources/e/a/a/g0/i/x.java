package e.a.a.g0.i;

import a.a.a.a.a;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.o0ooo00oo;
import e.a.a.c;
import e.a.a.e0.b;
import e.a.a.e0.e;
import e.a.a.e0.f;
import e.a.a.e0.g;
import e.a.a.e0.k;
import e.a.a.i0.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class x extends n {

    /* renamed from: d  reason: collision with root package name */
    public static final f f5078d = new f();

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f5079e = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};

    /* renamed from: b  reason: collision with root package name */
    public final String[] f5080b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5081c;

    public x(String[] strArr, boolean z) {
        if (strArr != null) {
            this.f5080b = (String[]) strArr.clone();
        } else {
            this.f5080b = f5079e;
        }
        this.f5081c = z;
        i("version", new z());
        i("path", new h());
        i("domain", new w());
        i("max-age", new g());
        i("secure", new i());
        i("comment", new d());
        i(BusinessResponse.KEY_EXPIRES, new f(this.f5080b));
    }

    public void a(b bVar, e eVar) {
        if (bVar != null) {
            String name = bVar.getName();
            if (name.indexOf(32) != -1) {
                throw new g("Cookie name may not contain blanks");
            } else if (!name.startsWith("$")) {
                super.a(bVar, eVar);
            } else {
                throw new g("Cookie name may not start with $");
            }
        } else {
            throw new IllegalArgumentException("Cookie may not be null");
        }
    }

    public List<b> c(c cVar, e eVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Header may not be null");
        } else if (eVar == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        } else if (cVar.getName().equalsIgnoreCase("Set-Cookie")) {
            return h(cVar.c(), eVar);
        } else {
            StringBuilder n = a.n("Unrecognized cookie header '");
            n.append(cVar.toString());
            n.append("'");
            throw new k(n.toString());
        }
    }

    public int d() {
        return 1;
    }

    public c e() {
        return null;
    }

    public List<c> f(List<b> list) {
        if (!list.isEmpty()) {
            if (list.size() > 1) {
                ArrayList arrayList = new ArrayList(list);
                Collections.sort(arrayList, f5078d);
                list = arrayList;
            }
            if (this.f5081c) {
                int i = Integer.MAX_VALUE;
                for (b next : list) {
                    if (next.d() < i) {
                        i = next.d();
                    }
                }
                e.a.a.l0.b bVar = new e.a.a.l0.b(list.size() * 40);
                bVar.b("Cookie");
                bVar.b(": ");
                bVar.b("$Version=");
                bVar.b(Integer.toString(i));
                for (b j : list) {
                    bVar.b("; ");
                    j(bVar, j, i);
                }
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(new o(bVar));
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(list.size());
            for (b next2 : list) {
                int d2 = next2.d();
                e.a.a.l0.b bVar2 = new e.a.a.l0.b(40);
                bVar2.b("Cookie: ");
                bVar2.b("$Version=");
                bVar2.b(Integer.toString(d2));
                bVar2.b("; ");
                j(bVar2, next2, d2);
                arrayList3.add(new o(bVar2));
            }
            return arrayList3;
        }
        throw new IllegalArgumentException("List of cookies may not be empty");
    }

    public void j(e.a.a.l0.b bVar, b bVar2, int i) {
        k(bVar, bVar2.getName(), bVar2.getValue(), i);
        if (bVar2.g() != null && (bVar2 instanceof e.a.a.e0.a) && ((e.a.a.e0.a) bVar2).e("path")) {
            bVar.b("; ");
            k(bVar, "$Path", bVar2.g(), i);
        }
        if (bVar2.h() != null && (bVar2 instanceof e.a.a.e0.a) && ((e.a.a.e0.a) bVar2).e("domain")) {
            bVar.b("; ");
            k(bVar, "$Domain", bVar2.h(), i);
        }
    }

    public void k(e.a.a.l0.b bVar, String str, String str2, int i) {
        bVar.b(str);
        bVar.b(o0ooo00oo.O0000Oo0);
        if (str2 == null) {
            return;
        }
        if (i > 0) {
            bVar.a('\"');
            bVar.b(str2);
            bVar.a('\"');
            return;
        }
        bVar.b(str2);
    }

    public String toString() {
        return "rfc2109";
    }
}

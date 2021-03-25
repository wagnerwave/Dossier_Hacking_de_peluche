package e.a.a.f0.g;

import e.a.a.f0.g.h.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f4910a;

    /* renamed from: b  reason: collision with root package name */
    public final b f4911b;

    /* renamed from: c  reason: collision with root package name */
    public final b f4912c;

    public a(String str, b bVar) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (bVar != null) {
            this.f4910a = str;
            this.f4912c = bVar;
            this.f4911b = new b();
            StringBuilder n = a.a.a.a.a.n("form-data; name=\"");
            n.append(this.f4910a);
            n.append("\"");
            if (bVar.c() != null) {
                n.append("; filename=\"");
                n.append(bVar.c());
                n.append("\"");
            }
            a("Content-Disposition", n.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(((e.a.a.f0.g.h.a) bVar).f4931a);
            if (bVar.b() != null) {
                sb.append("; charset=");
                sb.append(bVar.b());
            }
            a("Content-Type", sb.toString());
            a("Content-Transfer-Encoding", bVar.a());
        } else {
            throw new IllegalArgumentException("Body may not be null");
        }
    }

    public void a(String str, String str2) {
        b bVar = this.f4911b;
        f fVar = new f(str, str2);
        if (bVar != null) {
            String lowerCase = fVar.f4924a.toLowerCase(Locale.US);
            List list = bVar.f4914b.get(lowerCase);
            if (list == null) {
                list = new LinkedList();
                bVar.f4914b.put(lowerCase, list);
            }
            list.add(fVar);
            bVar.f4913a.add(fVar);
            return;
        }
        throw null;
    }
}

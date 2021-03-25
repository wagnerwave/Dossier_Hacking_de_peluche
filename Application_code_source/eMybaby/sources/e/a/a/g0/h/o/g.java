package e.a.a.g0.h.o;

import e.a.a.d0.k.b;
import e.a.a.d0.l.a;
import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Log f5044a = LogFactory.getLog(g.class);

    /* renamed from: b  reason: collision with root package name */
    public final a f5045b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public final int f5046c;

    /* renamed from: d  reason: collision with root package name */
    public final b f5047d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<b> f5048e;
    public final Queue<i> f;
    public int g;

    public g(a aVar, b bVar) {
        this.f5045b = aVar;
        this.f5047d = bVar;
        this.f5046c = bVar.a(aVar);
        this.f5048e = new LinkedList<>();
        this.f = new LinkedList();
        this.g = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.a.a.g0.h.o.b a(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.LinkedList<e.a.a.g0.h.o.b> r0 = r3.f5048e
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x002e
            java.util.LinkedList<e.a.a.g0.h.o.b> r0 = r3.f5048e
            int r1 = r0.size()
            java.util.ListIterator r0 = r0.listIterator(r1)
        L_0x0012:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.previous()
            e.a.a.g0.h.o.b r1 = (e.a.a.g0.h.o.b) r1
            java.lang.Object r2 = r1.f5013d
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r1.f5013d
            boolean r2 = a.e.a.a.r.b.m(r4, r2)
            if (r2 == 0) goto L_0x0012
        L_0x002a:
            r0.remove()
            return r1
        L_0x002e:
            int r4 = r3.d()
            if (r4 != 0) goto L_0x0056
            java.util.LinkedList<e.a.a.g0.h.o.b> r4 = r3.f5048e
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0056
            java.util.LinkedList<e.a.a.g0.h.o.b> r4 = r3.f5048e
            java.lang.Object r4 = r4.remove()
            e.a.a.g0.h.o.b r4 = (e.a.a.g0.h.o.b) r4
            r4.a()
            e.a.a.g0.h.e r0 = r4.f5011b
            r0.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0055
        L_0x004d:
            r0 = move-exception
            org.apache.commons.logging.Log r1 = r3.f5044a
            java.lang.String r2 = "I/O error closing connection"
            r1.debug(r2, r0)
        L_0x0055:
            return r4
        L_0x0056:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.o.g.a(java.lang.Object):e.a.a.g0.h.o.b");
    }

    public void b(b bVar) {
        if (this.f5045b.equals(bVar.f5012c)) {
            this.g++;
            return;
        }
        StringBuilder n = a.a.a.a.a.n("Entry not planned for this pool.\npool: ");
        n.append(this.f5045b);
        n.append("\nplan: ");
        n.append(bVar.f5012c);
        throw new IllegalArgumentException(n.toString());
    }

    public void c(b bVar) {
        int i = this.g;
        if (i < 1) {
            StringBuilder n = a.a.a.a.a.n("No entry created for this pool. ");
            n.append(this.f5045b);
            throw new IllegalStateException(n.toString());
        } else if (i > this.f5048e.size()) {
            this.f5048e.add(bVar);
        } else {
            StringBuilder n2 = a.a.a.a.a.n("No entry allocated from this pool. ");
            n2.append(this.f5045b);
            throw new IllegalStateException(n2.toString());
        }
    }

    public int d() {
        return this.f5047d.a(this.f5045b) - this.g;
    }
}

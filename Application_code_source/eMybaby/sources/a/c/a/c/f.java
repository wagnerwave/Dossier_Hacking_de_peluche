package a.c.a.c;

import a.c.a.f.d;
import a.c.a.f.e;
import e.a.a.c;
import e.a.a.c0.g;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class f implements Callable<Long> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c> f19a;

    public f(ArrayList<c> arrayList) {
        this.f19a = arrayList;
    }

    public Object call() {
        long j;
        g a2 = d.a();
        Iterator<c> it = this.f19a.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            c next = it.next();
            Long l = null;
            if (next != null) {
                try {
                    c l2 = ((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.d(next.f9a)).l("Content-Length");
                    Long valueOf = l2 == null ? null : Long.valueOf(Long.parseLong(l2.getValue()));
                    if (valueOf != null) {
                        j = valueOf.longValue();
                    } else {
                        try {
                            URLConnection openConnection = new URL(next.f9a).openConnection();
                            openConnection.connect();
                            l = Long.valueOf((long) openConnection.getContentLength());
                        } catch (Exception e2) {
                            e.d(e2);
                        }
                        if (l != null) {
                            j = l.longValue();
                        }
                    }
                    j2 += j;
                } catch (Exception e3) {
                    e.d(e3);
                }
            } else {
                throw null;
            }
        }
        return Long.valueOf(j2);
    }
}

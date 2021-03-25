package a.d.c.q.a;

import a.d.c.n;
import a.d.c.o;
import com.google.zxing.client.android.ViewfinderView;
import java.util.List;

public final class s implements o {

    /* renamed from: a  reason: collision with root package name */
    public final ViewfinderView f2948a;

    public s(ViewfinderView viewfinderView) {
        this.f2948a = viewfinderView;
    }

    public void a(n nVar) {
        List<n> list = this.f2948a.j;
        synchronized (list) {
            list.add(nVar);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }
}

package a.c.d.m;

import a.c.d.m.a;
import a.c.d.s.e.f.a.c;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.MainActivity;

public class b implements a.c.d.s.e.f.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f332a;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f333a;

        public a(c cVar) {
            this.f333a = cVar;
        }

        public void run() {
            if (this.f333a.f42a.booleanValue()) {
                AppMiniland.f().i().setBirthDate(b.this.f332a.i.getTime());
                a.i iVar = b.this.f332a.f314a;
                if (iVar != null) {
                    ((MainActivity) iVar).t();
                    return;
                }
                return;
            }
            a.c.a.f.b.j0(b.this.f332a.getActivity(), this.f333a.f43b);
        }
    }

    public b(a aVar) {
        this.f332a = aVar;
    }

    public void f(c cVar) {
        this.f332a.getActivity().runOnUiThread(new a(cVar));
    }
}

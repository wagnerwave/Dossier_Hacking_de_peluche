package a.c.d.s.e.d.d.c;

import a.c.d.m.i.k.a0;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.list.MamaMyBellyListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1058b = "https://emybaby.com/api/mitripita.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaMyBellyListRequest f1059a;

        /* renamed from: b  reason: collision with root package name */
        public a f1060b;

        public a(MamaMyBellyListRequest mamaMyBellyListRequest, a aVar) {
            this.f1059a = mamaMyBellyListRequest;
            this.f1060b = aVar;
        }

        public void run() {
            try {
                g a2 = a.c.a.f.d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1059a != null) {
                    hashMap.put("verentradas", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("id", String.valueOf(this.f1059a.f4141a));
                    hashMap.put("pass", this.f1059a.f4142b);
                    ((a0) this.f1060b).E(new c().a(b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(d.this.f1058b, hashMap))).b())));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                a0 a0Var = (a0) this.f1060b;
                a0Var.getActivity().runOnUiThread(new a0.a(bVar));
            }
        }
    }

    public d() {
        super("MAMA_MY_BELLY_LIST");
    }
}

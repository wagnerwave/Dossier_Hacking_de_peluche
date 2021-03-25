package a.c.d.s.e.d.d.d;

import a.c.a.f.d;
import a.c.d.m.i.k.a0;
import a.c.d.m.i.k.b0;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.remove.MamaMyBellyRemoveRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1062b = "https://emybaby.com/api/mitripita.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaMyBellyRemoveRequest f1063a;

        /* renamed from: b  reason: collision with root package name */
        public a f1064b;

        public a(MamaMyBellyRemoveRequest mamaMyBellyRemoveRequest, a aVar) {
            this.f1063a = mamaMyBellyRemoveRequest;
            this.f1064b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1063a != null) {
                    hashMap.put("eliminarmitripita", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("idMiTripita", String.valueOf(this.f1063a.f4143a));
                    b bVar = new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1062b, hashMap))).b())));
                    a0 a0Var = (a0) this.f1064b;
                    a0Var.getActivity().runOnUiThread(new b0(a0Var, bVar));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                a0 a0Var2 = (a0) this.f1064b;
                a0Var2.getActivity().runOnUiThread(new b0(a0Var2, bVar2));
            }
        }
    }

    public c() {
        super("MAMA_MY_BELLY_REMOVE");
    }
}

package a.c.d.s.e.d.e.b;

import a.c.a.f.d;
import a.c.d.m.i.k.h0;
import a.c.d.m.i.k.i0;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.delete.MamaWeightDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1071b = "https://emybaby.com/api/pesoembarazo.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaWeightDeleteRequest f1072a;

        /* renamed from: b  reason: collision with root package name */
        public a f1073b;

        public a(MamaWeightDeleteRequest mamaWeightDeleteRequest, a aVar) {
            this.f1072a = mamaWeightDeleteRequest;
            this.f1073b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1072a != null) {
                    hashMap.put("eliminapeso", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("idPeso", String.valueOf(this.f1072a.f4146a));
                    b bVar = new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1071b, hashMap))).b())));
                    h0 h0Var = (h0) this.f1073b;
                    h0Var.getActivity().runOnUiThread(new i0(h0Var, bVar));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                h0 h0Var2 = (h0) this.f1073b;
                h0Var2.getActivity().runOnUiThread(new i0(h0Var2, bVar2));
            }
        }
    }

    public c() {
        super("MAMA_WEIGHT_DELETE");
    }
}

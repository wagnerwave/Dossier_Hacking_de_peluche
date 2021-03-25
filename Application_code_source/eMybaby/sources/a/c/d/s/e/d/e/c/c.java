package a.c.d.s.e.d.e.c;

import a.c.a.f.d;
import a.c.d.m.i.k.f0;
import a.c.d.m.i.k.g0;
import a.c.d.r.j;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.edit.MamaWeightEditRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1076b = "https://emybaby.com/api/pesoembarazo.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaWeightEditRequest f1077a;

        /* renamed from: b  reason: collision with root package name */
        public a f1078b;

        public a(MamaWeightEditRequest mamaWeightEditRequest, a aVar) {
            this.f1077a = mamaWeightEditRequest;
            this.f1078b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                hashMap.put("editarpeso", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.j.format(this.f1077a.f4147a));
                hashMap.put("titulo", this.f1077a.f4148b);
                hashMap.put("peso", String.valueOf(this.f1077a.f4149c));
                hashMap.put("idPeso", String.valueOf(this.f1077a.f4150d));
                b bVar = new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1076b, hashMap))).b())));
                g0 g0Var = (g0) this.f1078b;
                g0Var.f586c.getActivity().runOnUiThread(new f0(g0Var, bVar));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                g0 g0Var2 = (g0) this.f1078b;
                g0Var2.f586c.getActivity().runOnUiThread(new f0(g0Var2, bVar2));
            }
        }
    }

    public c() {
        super("MAMA_WEIGHT_EDIT");
    }
}

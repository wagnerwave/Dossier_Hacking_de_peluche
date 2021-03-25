package a.c.d.s.e.d.e.a;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.add.MamaWeightAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1067b = "https://emybaby.com/api/pesoembarazo.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaWeightAddRequest f1068a;

        /* renamed from: b  reason: collision with root package name */
        public a f1069b;

        public a(MamaWeightAddRequest mamaWeightAddRequest, a aVar) {
            this.f1068a = mamaWeightAddRequest;
            this.f1069b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1068a != null) {
                    hashMap.put("anadirpeso", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("fecha", this.f1068a.f4145b);
                    hashMap.put("peso", String.valueOf(this.f1068a.f4144a));
                    this.f1069b.a(new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1067b, hashMap))).b()))));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                this.f1069b.a(bVar);
            }
        }
    }

    public c() {
        super("MAMA_ADD_WEIGHT");
    }
}

package a.c.d.s.e.f.b;

import a.c.a.f.d;
import a.e.a.a.r.b;
import a.h.a.h;
import com.cuatroochenta.miniland.webservices.pregnancy.savedate.get.PregnancyDateGetRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.MainActivity;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1110b = "https://emybaby.com/api/fechaparto.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1111a;

        public a(PregnancyDateGetRequest pregnancyDateGetRequest, a aVar) {
            this.f1111a = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                hashMap.put("obtenerfechaparto", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1110b, hashMap))).b());
                a aVar = this.f1111a;
                MainActivity.b bVar = (MainActivity.b) aVar;
                MainActivity.this.runOnUiThread(new h(bVar, new b(c0)));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b("");
                bVar2.f42a = Boolean.FALSE;
                MainActivity.b bVar3 = (MainActivity.b) this.f1111a;
                MainActivity.this.runOnUiThread(new h(bVar3, bVar2));
            }
        }
    }

    public c() {
        super("PREGNANCY_GET");
    }
}

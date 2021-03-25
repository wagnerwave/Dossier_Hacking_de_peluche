package a.c.d.s.e.b.c;

import a.c.a.f.d;
import com.cuatroochenta.miniland.pregnancy.contraction.PregnancyContractionListActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.contraction.list.PregnancyContractionListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;
import org.json.JSONArray;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f971b = "https://emybaby.com/api/contracciones.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f972a;

        public a(PregnancyContractionListRequest pregnancyContractionListRequest, a aVar) {
            this.f972a = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("vercontracciones", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                String c0 = a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(b.this.f971b, hashMap))).b());
                PregnancyContractionListActivity pregnancyContractionListActivity = (PregnancyContractionListActivity) this.f972a;
                pregnancyContractionListActivity.runOnUiThread(new a.c.d.m.g.b(pregnancyContractionListActivity, new c(new JSONArray(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                c cVar = new c();
                cVar.f42a = Boolean.FALSE;
                PregnancyContractionListActivity pregnancyContractionListActivity2 = (PregnancyContractionListActivity) this.f972a;
                pregnancyContractionListActivity2.runOnUiThread(new a.c.d.m.g.b(pregnancyContractionListActivity2, cVar));
            }
        }
    }

    public b() {
        super("PREGNANCY_CONTRACTION_LIST");
    }
}

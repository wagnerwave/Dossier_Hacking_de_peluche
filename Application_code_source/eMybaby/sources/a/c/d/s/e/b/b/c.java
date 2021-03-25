package a.c.d.s.e.b.b;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.pregnancy.contraction.PregnancyContractionListActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.contraction.delete.PregnancyContractionDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f967b = "https://emybaby.com/api/contracciones.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f968a;

        /* renamed from: b  reason: collision with root package name */
        public PregnancyContractionDeleteRequest f969b;

        public a(PregnancyContractionDeleteRequest pregnancyContractionDeleteRequest, a aVar) {
            this.f968a = aVar;
            this.f969b = pregnancyContractionDeleteRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("eliminacontraccion", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                hashMap.put("idContraccion", this.f969b.f4112a);
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f967b, hashMap))).b());
                PregnancyContractionListActivity pregnancyContractionListActivity = (PregnancyContractionListActivity) this.f968a;
                pregnancyContractionListActivity.runOnUiThread(new a.c.d.m.g.c(pregnancyContractionListActivity, new b(new JSONObject(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                PregnancyContractionListActivity pregnancyContractionListActivity2 = (PregnancyContractionListActivity) this.f968a;
                pregnancyContractionListActivity2.runOnUiThread(new a.c.d.m.g.c(pregnancyContractionListActivity2, bVar));
            }
        }
    }

    public c() {
        super("PREGNANCY_CONTRACTION_DELETE");
    }
}

package a.c.d.s.e.b.a;

import a.c.a.f.d;
import a.c.d.r.j;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.pregnancy.contraction.PregnancyContractionListActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.contraction.add.PregnancyContractionAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f963b = "https://emybaby.com/api/contracciones.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f964a;

        /* renamed from: b  reason: collision with root package name */
        public PregnancyContractionAddRequest f965b;

        public a(PregnancyContractionAddRequest pregnancyContractionAddRequest, a aVar) {
            this.f964a = aVar;
            this.f965b = pregnancyContractionAddRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("anadircontraccion", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                hashMap.put("fecha", j.j.format(Calendar.getInstance().getTime()));
                hashMap.put("segundos", String.valueOf(this.f965b.f4111a));
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f963b, hashMap))).b());
                PregnancyContractionListActivity pregnancyContractionListActivity = (PregnancyContractionListActivity) this.f964a;
                pregnancyContractionListActivity.runOnUiThread(new a.c.d.m.g.a(pregnancyContractionListActivity, new b(new JSONObject(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                PregnancyContractionListActivity pregnancyContractionListActivity2 = (PregnancyContractionListActivity) this.f964a;
                pregnancyContractionListActivity2.runOnUiThread(new a.c.d.m.g.a(pregnancyContractionListActivity2, bVar));
            }
        }
    }

    public c() {
        super("PREGNANCY_CONTRACTION_ADD");
    }
}

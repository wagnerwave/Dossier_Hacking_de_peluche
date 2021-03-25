package a.c.d.s.b.b;

import a.c.a.f.d;
import a.c.d.h.f;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.emyscale.MyScaleStatisticsActivity;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.k.c;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class e extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f871b;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f872a;

        /* renamed from: b  reason: collision with root package name */
        public b f873b;

        public a(b bVar, a aVar) {
            this.f872a = aVar;
            this.f873b = bVar;
        }

        public void run() {
            c cVar;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("eliminarpeso", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                if (this.f873b.f869a != null) {
                    hashMap.put("idPeso", String.valueOf(this.f873b.f869a.getIdCrecimiento()));
                }
                cVar = new d().a(new JSONObject(b.c0(((g) d.a()).g(new c(a.c.a.d.a.c(e.this.f871b, hashMap))).b())));
                if (cVar == null) {
                    cVar = new c();
                    cVar.f42a = Boolean.FALSE;
                }
            } catch (Exception unused) {
                cVar = new c();
                cVar.f42a = Boolean.FALSE;
            }
            MyScaleStatisticsActivity myScaleStatisticsActivity = (MyScaleStatisticsActivity) this.f872a;
            myScaleStatisticsActivity.runOnUiThread(new f(myScaleStatisticsActivity, cVar));
        }
    }

    public e() {
        super("WEIGHT_DELETE");
    }
}

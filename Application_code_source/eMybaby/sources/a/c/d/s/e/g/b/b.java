package a.c.d.s.e.g.b;

import a.c.a.f.d;
import a.c.a.f.e;
import com.cuatroochenta.miniland.pregnancy.sounds.PregnancySoundsListActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.sonidos.list.PregnancySoundListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;
import org.json.JSONArray;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1117b = "https://emybaby.com/api/sonidosembarazo.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1118a;

        public a(PregnancySoundListRequest pregnancySoundListRequest, a aVar) {
            this.f1118a = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("versonidos", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                String c0 = a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(b.this.f1117b, hashMap))).b());
                e.b("Result:" + c0);
                PregnancySoundsListActivity pregnancySoundsListActivity = (PregnancySoundsListActivity) this.f1118a;
                pregnancySoundsListActivity.runOnUiThread(new a.c.d.m.l.a(pregnancySoundsListActivity, new c(new JSONArray(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                c cVar = new c();
                cVar.f42a = Boolean.FALSE;
                PregnancySoundsListActivity pregnancySoundsListActivity2 = (PregnancySoundsListActivity) this.f1118a;
                pregnancySoundsListActivity2.runOnUiThread(new a.c.d.m.l.a(pregnancySoundsListActivity2, cVar));
            }
        }
    }

    public b() {
        super("PREGNANCY_SOUND_LIST");
    }
}

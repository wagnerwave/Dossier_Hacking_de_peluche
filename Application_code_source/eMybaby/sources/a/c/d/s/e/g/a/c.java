package a.c.d.s.e.g.a;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.pregnancy.sounds.PregnancySoundsListActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.sonidos.delete.PregnancySoundDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1113b = "https://emybaby.com/api/sonidosembarazo.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1114a;

        /* renamed from: b  reason: collision with root package name */
        public PregnancySoundDeleteRequest f1115b;

        public a(PregnancySoundDeleteRequest pregnancySoundDeleteRequest, a aVar) {
            this.f1114a = aVar;
            this.f1115b = pregnancySoundDeleteRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                Iterator<String> it = this.f1115b.f4156a.iterator();
                while (it.hasNext()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("eliminasonido", "1");
                    Usuario i = AppMiniland.f().i();
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("id", i.getId());
                    hashMap.put("pass", i.getPass());
                    hashMap.put("idSonido", it.next());
                    if (!Boolean.TRUE.equals(new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1113b, hashMap))).b()))).f42a)) {
                        throw new RuntimeException("");
                    }
                }
                PregnancySoundsListActivity pregnancySoundsListActivity = (PregnancySoundsListActivity) this.f1114a;
                pregnancySoundsListActivity.runOnUiThread(new a.c.d.m.l.b(pregnancySoundsListActivity, new b(true)));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                PregnancySoundsListActivity pregnancySoundsListActivity2 = (PregnancySoundsListActivity) this.f1114a;
                pregnancySoundsListActivity2.runOnUiThread(new a.c.d.m.l.b(pregnancySoundsListActivity2, bVar));
            }
        }
    }

    public c() {
        super("PREGNANCY_SOUND_DELETE");
    }
}

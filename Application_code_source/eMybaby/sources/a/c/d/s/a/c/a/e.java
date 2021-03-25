package a.c.d.s.a.c.a;

import a.c.a.f.d;
import a.c.d.g.i;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.k.c;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class e extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f832b;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f833a;

        /* renamed from: b  reason: collision with root package name */
        public b f834b;

        public a(b bVar, a aVar) {
            this.f833a = aVar;
            this.f834b = bVar;
        }

        public void run() {
            c cVar;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("eliminacancion", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                if (this.f834b.f829a != null) {
                    hashMap.put("idCancion", this.f834b.f829a.getId());
                }
                cVar = new d().a(new JSONObject(b.c0(((g) d.a()).g(new c(a.c.a.d.a.c(e.this.f832b, hashMap))).b())));
                if (cVar == null) {
                    cVar = new c();
                    cVar.f42a = Boolean.FALSE;
                }
                if (cVar.f42a.booleanValue() && this.f834b.f829a != null) {
                    cVar.f830c = this.f834b.f829a;
                }
            } catch (Exception unused) {
                cVar = new c();
                cVar.f42a = Boolean.FALSE;
            }
            BuddyPlayerActivity buddyPlayerActivity = (BuddyPlayerActivity) this.f833a;
            buddyPlayerActivity.runOnUiThread(new i(buddyPlayerActivity, cVar));
        }
    }

    public e() {
        super("SONG_DELETE");
    }
}

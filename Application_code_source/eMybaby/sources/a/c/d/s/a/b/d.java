package a.c.d.s.a.b;

import a.e.a.a.r.b;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.model.Song;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.oOO0O0O0;
import e.a.a.c0.k.c;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f825b;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public e f826a;

        /* renamed from: b  reason: collision with root package name */
        public a f827b;

        public a(a aVar, e eVar) {
            this.f826a = eVar;
            this.f827b = aVar;
        }

        public void run() {
            b bVar;
            String str = "1";
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("marcarfavorita", str);
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                if (this.f827b.f822a != null) {
                    hashMap.put("idCancion", this.f827b.f822a.getId());
                    if (this.f827b.f822a.isFavourite()) {
                        str = oOO0O0O0.O0000oO0;
                    }
                    hashMap.put("favorite", str);
                }
                bVar = new c().a(new JSONObject(b.c0(((g) a.c.a.f.d.a()).g(new c(a.c.a.d.a.c(d.this.f825b, hashMap))).b())));
                if (bVar == null) {
                    bVar = new b();
                    bVar.f42a = Boolean.FALSE;
                }
                if (bVar.f42a.booleanValue() && this.f827b.f822a != null) {
                    Song song = this.f827b.f822a;
                    song.setFavourite(!song.isFavourite());
                    bVar.f823c = this.f827b.f822a;
                }
            } catch (Exception unused) {
                bVar = new b();
                bVar.f42a = Boolean.FALSE;
            }
            ((BuddyPlayerActivity) this.f826a).x(bVar);
        }
    }

    public d() {
        super("BUDDY_MANAGE_FAVORITE");
    }
}

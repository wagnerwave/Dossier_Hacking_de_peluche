package a.c.d.s.a.c.b;

import a.c.a.f.d;
import a.c.d.g.h;
import a.e.a.a.r.b;
import androidx.core.app.NotificationCompatJellybean;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.model.Song;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.k.c;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class e extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f840b;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f841a;

        /* renamed from: b  reason: collision with root package name */
        public b f842b;

        public a(b bVar, a aVar) {
            this.f841a = aVar;
            this.f842b = bVar;
        }

        public void run() {
            c cVar;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("cambiarnombre", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                if (this.f842b.f836a != null) {
                    hashMap.put("idCancion", this.f842b.f836a.getId());
                }
                if (!a.c.a.d.a.j(this.f842b.f837b)) {
                    hashMap.put(NotificationCompatJellybean.KEY_TITLE, this.f842b.f837b);
                }
                cVar = new d().a(new JSONObject(b.c0(((g) d.a()).g(new c(a.c.a.d.a.c(e.this.f840b, hashMap))).b())));
                if (cVar == null) {
                    cVar = new c();
                    cVar.f42a = Boolean.FALSE;
                }
                if (cVar.f42a.booleanValue() && this.f842b.f836a != null) {
                    Song song = this.f842b.f836a;
                    song.setTitle(this.f842b.f837b);
                    cVar.f838c = song;
                }
            } catch (Exception unused) {
                cVar = new c();
                cVar.f42a = Boolean.FALSE;
            }
            BuddyPlayerActivity buddyPlayerActivity = (BuddyPlayerActivity) this.f841a;
            buddyPlayerActivity.runOnUiThread(new h(buddyPlayerActivity, cVar));
        }
    }

    public e() {
        super("SONG_EDIT");
    }
}

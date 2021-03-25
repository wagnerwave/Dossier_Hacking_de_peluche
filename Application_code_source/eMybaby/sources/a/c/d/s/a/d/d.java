package a.c.d.s.a.d;

import a.e.a.a.r.b;
import com.cuatroochenta.miniland.emybuddy.BuddyActivateActivity;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.android.network.TuyaApiParams;
import e.a.a.c0.k.c;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class d extends a.c.a.g.a {

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public e f861a;

        /* renamed from: b  reason: collision with root package name */
        public a f862b;

        public a(a aVar, e eVar) {
            this.f861a = eVar;
            this.f862b = aVar;
        }

        public void run() {
            b bVar;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("acceso", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                hashMap.put(TuyaApiParams.KEY_APP_LANG, ((AppMiniland) a.c.a.a.f).f1b);
                hashMap.put("validationcode", this.f862b.f859a);
                bVar = new c().a(new JSONObject(b.c0(((g) a.c.a.f.d.a()).g(new c(a.c.a.d.a.c(d.this.f41a, hashMap))).b())));
                if (bVar == null) {
                    bVar = new b();
                    bVar.f42a = Boolean.TRUE;
                }
            } catch (Exception unused) {
                bVar = new b();
                bVar.f42a = Boolean.TRUE;
            }
            BuddyActivateActivity buddyActivateActivity = (BuddyActivateActivity) this.f861a;
            buddyActivateActivity.runOnUiThread(new a.c.d.g.d(buddyActivateActivity, bVar));
        }
    }

    public d() {
        super("BUDDY_VALIDATE");
    }
}

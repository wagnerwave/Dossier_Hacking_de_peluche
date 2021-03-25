package a.c.d.s.a.a;

import a.c.a.f.d;
import a.c.d.g.e;
import a.c.d.g.f;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.emybuddy.info.BuddyInfoRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.android.network.TuyaApiParams;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f819b;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public d f820a;

        public a(BuddyInfoRequest buddyInfoRequest, d dVar) {
            this.f820a = dVar;
        }

        public void run() {
            a aVar;
            String str = "";
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("canciones", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass() == null ? str : i.getPass());
                hashMap.put(TuyaApiParams.KEY_APP_LANG, ((AppMiniland) a.c.a.a.f).f1b);
                str = a.c.a.d.a.c(c.this.f819b, hashMap);
                String c0 = b.c0(((g) d.a()).g(new e.a.a.c0.k.c(str)).b());
                aVar = new b().a(new JSONObject(c0));
                if (aVar == null || !aVar.f42a.booleanValue()) {
                    aVar = c.a(c.this, a.c.a.f.b.c(str));
                } else {
                    HashMap<String, String> r = a.c.d.a.l().r();
                    r.put(a.c.a.f.b.c(str), c0);
                    a.c.d.a.l().u(r);
                }
            } catch (Exception unused) {
                aVar = c.a(c.this, a.c.a.f.b.c(str));
            }
            e eVar = (e) this.f820a;
            if (eVar.getActivity() != null) {
                eVar.getActivity().runOnUiThread(new f(eVar, aVar));
            }
        }
    }

    public c() {
        super("BUDDY_INFO");
    }

    public static a a(c cVar, String str) {
        if (cVar != null) {
            HashMap<String, String> r = a.c.d.a.l().r();
            if (r.containsKey(str)) {
                try {
                    return new b().a(new JSONObject(r.get(str)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            a aVar = new a();
            aVar.f42a = Boolean.FALSE;
            return aVar;
        }
        throw null;
    }
}

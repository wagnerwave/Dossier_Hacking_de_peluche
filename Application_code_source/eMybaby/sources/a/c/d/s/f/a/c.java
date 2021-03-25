package a.c.d.s.f.a;

import a.c.a.f.d;
import a.e.a.a.r.b;
import a.h.a.o;
import com.cuatroochenta.miniland.webservices.profile.get.MyProfileGetRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.MyProfileActivity;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1138b = "https://emybaby.com/api/perfilusuario.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1139a;

        public a(MyProfileGetRequest myProfileGetRequest, a aVar) {
            this.f1139a = aVar;
        }

        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("verperfil", "1");
                hashMap.put("bdpre", AppMiniland.f().i().getBdpre());
                String c0 = b.c0(((g) d.a()).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1138b, hashMap))).b());
                MyProfileActivity myProfileActivity = (MyProfileActivity) this.f1139a;
                myProfileActivity.runOnUiThread(new o(myProfileActivity, new b(new JSONObject(c0))));
            } catch (Exception unused) {
                b bVar = new b();
                MyProfileActivity myProfileActivity2 = (MyProfileActivity) this.f1139a;
                myProfileActivity2.runOnUiThread(new o(myProfileActivity2, bVar));
            }
        }
    }

    public c() {
        super("MY_PROFILE_GET_SERVICE");
    }
}

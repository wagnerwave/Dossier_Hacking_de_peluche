package a.c.d.s.f.b;

import a.e.a.a.r.b;
import a.h.a.p;
import com.cuatroochenta.miniland.webservices.profile.post.MyProfilePostRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.MyProfileActivity;
import e.a.a.c0.k.e;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1142b = "https://emybaby.com/api/perfilusuario.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1143a;

        /* renamed from: b  reason: collision with root package name */
        public MyProfilePostRequest f1144b;

        public a(MyProfilePostRequest myProfilePostRequest, a aVar) {
            this.f1143a = aVar;
            this.f1144b = myProfilePostRequest;
        }

        public void run() {
            b bVar;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("editarperfil", "1");
                hashMap.put("bdpre", AppMiniland.f().i().getBdpre());
                hashMap.put("nombre", this.f1144b.f4157a.getName());
                hashMap.put("apellidos", this.f1144b.f4157a.getSurname());
                hashMap.put("fechanacimiento", this.f1144b.f4157a.getBirthDate());
                hashMap.put("pais", this.f1144b.f4157a.getCountryCode());
                hashMap.put("hijos", this.f1144b.f4157a.getChildren());
                hashMap.put("telefono", this.f1144b.f4157a.getPhone());
                hashMap.put("direccion", this.f1144b.f4157a.getAddress());
                hashMap.put("codigopostal", this.f1144b.f4157a.getPostalCode());
                hashMap.put("localidad", this.f1144b.f4157a.getTown());
                hashMap.put("provincia", this.f1144b.f4157a.getProvince());
                bVar = new c().a(new JSONObject(b.c0(((g) a.c.a.f.d.a()).g(new e(a.c.a.d.a.c(d.this.f1142b, hashMap))).b())));
                if (bVar == null) {
                    bVar = new b();
                    bVar.f42a = Boolean.FALSE;
                }
            } catch (Exception unused) {
                bVar = new b();
                bVar.f42a = Boolean.FALSE;
            }
            MyProfileActivity myProfileActivity = (MyProfileActivity) this.f1143a;
            myProfileActivity.runOnUiThread(new p(myProfileActivity, bVar));
        }
    }

    public d() {
        super("MY_PROFILE_POST_SERVICE");
    }
}

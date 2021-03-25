package a.c.d.s.e.c;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f975b = "https://emybaby.com/api/datosembarazo.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f976a;

        public a(a aVar) {
            this.f976a = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("borrardatos", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("email", i.getCorreo());
                hashMap.put("pass", i.getPass());
                this.f976a.a(new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f975b, hashMap))).b()))));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                this.f976a.a(bVar);
            }
        }
    }

    public c() {
        super("PREGNANCY_DELETE_SERVICE");
    }
}

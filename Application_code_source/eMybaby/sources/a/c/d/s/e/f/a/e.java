package a.c.d.s.e.f.a;

import a.c.a.f.d;
import a.c.d.r.j;
import a.e.a.a.r.b;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.k.c;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class e extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1105b = "https://emybaby.com/api/fechaparto.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1106a;

        /* renamed from: b  reason: collision with root package name */
        public b f1107b;

        public a(b bVar, a aVar) {
            this.f1106a = aVar;
            this.f1107b = bVar;
        }

        public void run() {
            c cVar;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("guardarfecha", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.f.format(this.f1107b.f1103a));
                cVar = new d().a(new JSONObject(b.c0(((g) d.a()).g(new c(a.c.a.d.a.c(e.this.f1105b, hashMap))).b())));
                if (cVar == null) {
                    cVar = new c();
                    cVar.f42a = Boolean.FALSE;
                }
            } catch (Exception unused) {
                cVar = new c();
                cVar.f42a = Boolean.FALSE;
            }
            this.f1106a.f(cVar);
        }
    }

    public e() {
        super("PREGNANCY_SAVE_DATE_SERVICE");
    }
}

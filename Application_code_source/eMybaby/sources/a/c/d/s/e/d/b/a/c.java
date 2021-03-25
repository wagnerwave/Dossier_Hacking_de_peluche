package a.c.d.s.e.d.b.a;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.add.MamaFetalMovAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f999b = "https://emybaby.com/api/movimientofetal.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaFetalMovAddRequest f1000a;

        /* renamed from: b  reason: collision with root package name */
        public a f1001b;

        public a(MamaFetalMovAddRequest mamaFetalMovAddRequest, a aVar) {
            this.f1000a = mamaFetalMovAddRequest;
            this.f1001b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1000a != null) {
                    hashMap.put("anadirmovimiento", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("fecha", this.f1000a.f4121a);
                    hashMap.put("active1", this.f1000a.f4122b ? String.valueOf(1) : String.valueOf(0));
                    hashMap.put("active2", this.f1000a.f4123c ? String.valueOf(1) : String.valueOf(0));
                    this.f1001b.g(new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f999b, hashMap))).b()))));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f1001b.g(new b());
            }
        }
    }

    public c() {
        super("MAMA_FETAL_MOVEMENTS");
    }
}

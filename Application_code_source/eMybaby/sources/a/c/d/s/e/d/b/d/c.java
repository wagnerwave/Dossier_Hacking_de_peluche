package a.c.d.s.e.d.b.d;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.remove.MamaFetalMovRemoveRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1014b = "https://emybaby.com/api/movimientofetal.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaFetalMovRemoveRequest f1015a;

        /* renamed from: b  reason: collision with root package name */
        public a f1016b;

        public a(MamaFetalMovRemoveRequest mamaFetalMovRemoveRequest, a aVar) {
            this.f1015a = mamaFetalMovRemoveRequest;
            this.f1016b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1015a != null) {
                    hashMap.put("eliminamovimiento", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("idMovimientoFetal", String.valueOf(this.f1015a.f4127a));
                    this.f1016b.c(new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1014b, hashMap))).b()))));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                this.f1016b.c(bVar);
            }
        }
    }

    public c() {
        super("MAMA_BLOOD_PRESSURE_DELETE");
    }
}

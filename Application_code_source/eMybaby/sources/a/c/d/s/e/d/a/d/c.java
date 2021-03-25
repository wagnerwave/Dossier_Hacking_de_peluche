package a.c.d.s.e.d.a.d;

import a.c.a.f.d;
import a.c.d.m.i.k.k;
import a.c.d.m.i.k.o;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.remove.MamaBloodPressureDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f994b = "https://emybaby.com/api/medidatension.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaBloodPressureDeleteRequest f995a;

        /* renamed from: b  reason: collision with root package name */
        public a f996b;

        public a(MamaBloodPressureDeleteRequest mamaBloodPressureDeleteRequest, a aVar) {
            this.f995a = mamaBloodPressureDeleteRequest;
            this.f996b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f995a != null) {
                    hashMap.put("eliminamedida", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("idMedidaTension", String.valueOf(this.f995a.f4120a));
                    b bVar = new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f994b, hashMap))).b())));
                    k kVar = (k) this.f996b;
                    kVar.getActivity().runOnUiThread(new o(kVar, bVar));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                k kVar2 = (k) this.f996b;
                kVar2.getActivity().runOnUiThread(new o(kVar2, bVar2));
            }
        }
    }

    public c() {
        super("MAMA_BLOOD_PRESSURE_DELETE");
    }
}

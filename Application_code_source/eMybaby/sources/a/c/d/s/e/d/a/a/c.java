package a.c.d.s.e.d.a.a;

import a.c.a.f.d;
import a.c.d.m.i.k.k;
import a.c.d.m.i.k.l;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.add.MamaBloodPressureAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f979b = "https://emybaby.com/api/medidatension.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaBloodPressureAddRequest f980a;

        /* renamed from: b  reason: collision with root package name */
        public a f981b;

        public a(MamaBloodPressureAddRequest mamaBloodPressureAddRequest, a aVar) {
            this.f980a = mamaBloodPressureAddRequest;
            this.f981b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f980a != null) {
                    hashMap.put("anadirmedida", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("fecha", this.f980a.f4113a);
                    hashMap.put("titulo", this.f980a.f4114b);
                    hashMap.put("sistolica", String.valueOf(this.f980a.f4115c));
                    hashMap.put("distolica", String.valueOf(this.f980a.f4116d));
                    b bVar = new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f979b, hashMap))).b())));
                    k kVar = (k) this.f981b;
                    kVar.getActivity().runOnUiThread(new l(kVar, bVar));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b();
                k kVar2 = (k) this.f981b;
                kVar2.getActivity().runOnUiThread(new l(kVar2, bVar2));
            }
        }
    }

    public c() {
        super("MAMA_ADD_BLOOD_PRESSURE_VALUE");
    }
}

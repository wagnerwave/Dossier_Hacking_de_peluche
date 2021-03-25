package a.c.d.s.e.a.b.b;

import a.c.a.f.d;
import a.c.d.m.e.k.h;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.delete.MedicalDataEntryDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f921b = "https://emybaby.com/api/datosmedicos.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f922a;

        /* renamed from: b  reason: collision with root package name */
        public MedicalDataEntryDeleteRequest f923b;

        public a(MedicalDataEntryDeleteRequest medicalDataEntryDeleteRequest, a aVar) {
            this.f922a = aVar;
            this.f923b = medicalDataEntryDeleteRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("eliminadatomedico", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("idDatoMedico", String.valueOf(this.f923b.f4100a));
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f921b, hashMap))).b());
                a aVar = this.f922a;
                h hVar = (h) aVar;
                hVar.f378c.getActivity().runOnUiThread(new a.c.d.m.e.k.g(hVar, new b(new JSONObject(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                h hVar2 = (h) this.f922a;
                hVar2.f378c.getActivity().runOnUiThread(new a.c.d.m.e.k.g(hVar2, bVar));
            }
        }
    }

    public c() {
        super("PREGNANCY_CONTRACTION_DELETE");
    }
}

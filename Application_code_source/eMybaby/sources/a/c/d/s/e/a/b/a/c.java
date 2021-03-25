package a.c.d.s.e.a.b.a;

import a.c.a.f.d;
import a.c.d.r.j;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.add.MedicalDataEntryDataAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f917b = "https://emybaby.com/api/datosmedicos.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f918a;

        /* renamed from: b  reason: collision with root package name */
        public MedicalDataEntryDataAddRequest f919b;

        public a(MedicalDataEntryDataAddRequest medicalDataEntryDataAddRequest, a aVar) {
            this.f918a = aVar;
            this.f919b = medicalDataEntryDataAddRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("anadirdatomedico", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.j.format(this.f919b.f4099a.getDate()));
                hashMap.put("fl", String.valueOf(this.f919b.f4099a.getFL()));
                hashMap.put("hc", String.valueOf(this.f919b.f4099a.getHC()));
                hashMap.put("ac", String.valueOf(this.f919b.f4099a.getAC()));
                hashMap.put("efw", String.valueOf(this.f919b.f4099a.getEFW()));
                b bVar = new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f917b, hashMap))).b())));
                bVar.f42a = Boolean.TRUE;
                this.f918a.a(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                this.f918a.a(bVar2);
            }
        }
    }

    public c() {
        super("PREGNANCY_MEDICAL_DATA_ADD");
    }

    public void a(MedicalDataEntryDataAddRequest medicalDataEntryDataAddRequest, a aVar) {
        new a(medicalDataEntryDataAddRequest, aVar).start();
    }
}

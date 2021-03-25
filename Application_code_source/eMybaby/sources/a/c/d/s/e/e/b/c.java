package a.c.d.s.e.e.b;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.delete.MedicalAppointmentDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1090b = "https://emybaby.com/api/citamedica.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1091a;

        /* renamed from: b  reason: collision with root package name */
        public MedicalAppointmentDeleteRequest f1092b;

        public a(MedicalAppointmentDeleteRequest medicalAppointmentDeleteRequest, a aVar) {
            this.f1091a = aVar;
            this.f1092b = medicalAppointmentDeleteRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("eliminacitamedica", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("idCitaMedica", String.valueOf(this.f1092b.f4154a.getId()));
                this.f1091a.a(new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1090b, hashMap))).b()))));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                this.f1091a.a(bVar);
            }
        }
    }

    public c() {
        super("MEDICAL_APPOINTMENT_ADD");
    }

    public void a(MedicalAppointmentDeleteRequest medicalAppointmentDeleteRequest, a aVar) {
        new a(medicalAppointmentDeleteRequest, aVar).start();
    }
}

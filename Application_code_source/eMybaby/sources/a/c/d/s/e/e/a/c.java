package a.c.d.s.e.e.a;

import a.c.a.f.d;
import a.c.d.m.j.f;
import a.c.d.r.j;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.add.MedicalAppointmentAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1086b = "https://emybaby.com/api/citamedica.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1087a;

        /* renamed from: b  reason: collision with root package name */
        public MedicalAppointmentAddRequest f1088b;

        public a(MedicalAppointmentAddRequest medicalAppointmentAddRequest, a aVar) {
            this.f1087a = aVar;
            this.f1088b = medicalAppointmentAddRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("anadircitamedica", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.j.format(this.f1088b.f4153a.getDate()));
                hashMap.put("doctor", this.f1088b.f4153a.getDoctor());
                hashMap.put("lugar", this.f1088b.f4153a.getPlace());
                hashMap.put("tipo", String.valueOf(this.f1088b.f4153a.getType()));
                hashMap.put("hora", j.l.format(this.f1088b.f4153a.getDate()));
                hashMap.put("observaciones", this.f1088b.f4153a.getObservation());
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1086b, hashMap))).b());
                a aVar = this.f1087a;
                a.c.d.m.j.g gVar = (a.c.d.m.j.g) aVar;
                gVar.f685c.runOnUiThread(new f(gVar, new b(new JSONObject(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                a.c.d.m.j.g gVar2 = (a.c.d.m.j.g) this.f1087a;
                gVar2.f685c.runOnUiThread(new f(gVar2, bVar));
            }
        }
    }

    public c() {
        super("MEDICAL_APPOINTMENT_ADD");
    }
}

package a.c.d.s.e.e.c;

import a.c.a.f.d;
import a.c.d.m.j.h;
import a.c.d.r.j;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.edit.MedicalAppointmentEditRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1094b = "https://emybaby.com/api/citamedica.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1095a;

        /* renamed from: b  reason: collision with root package name */
        public MedicalAppointmentEditRequest f1096b;

        public a(MedicalAppointmentEditRequest medicalAppointmentEditRequest, a aVar) {
            this.f1095a = aVar;
            this.f1096b = medicalAppointmentEditRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("editacitamedica", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.j.format(this.f1096b.f4155a.getDate()));
                hashMap.put("doctor", this.f1096b.f4155a.getDoctor());
                hashMap.put("lugar", this.f1096b.f4155a.getPlace());
                hashMap.put("tipo", String.valueOf(this.f1096b.f4155a.getType()));
                hashMap.put("hora", j.l.format(this.f1096b.f4155a.getDate()));
                hashMap.put("observaciones", this.f1096b.f4155a.getObservation());
                hashMap.put("idCitaMedica", String.valueOf(this.f1096b.f4155a.getId()));
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1094b, hashMap))).b());
                ((h) this.f1095a).a(new b(new JSONObject(c0)));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                ((h) this.f1095a).a(bVar);
            }
        }
    }

    public c() {
        super("MEDICAL_APPOINTMENT_EDIT");
    }
}

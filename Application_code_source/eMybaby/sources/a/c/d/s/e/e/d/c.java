package a.c.d.s.e.e.d;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AppointmentListActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.list.MedicalAppointmentListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.android.network.TuyaApiParams;
import e.a.a.c0.g;
import java.text.ParseException;
import java.util.HashMap;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1099b = "https://emybaby.com/api/citamedica.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1100a;

        public a(MedicalAppointmentListRequest medicalAppointmentListRequest, a aVar) {
            this.f1100a = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                hashMap.put("vercitasmedicas", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", ((AppMiniland) a.c.a.a.f).i().getId());
                hashMap.put("pass", ((AppMiniland) a.c.a.a.f).i().getPass());
                hashMap.put(TuyaApiParams.KEY_APP_LANG, ((AppMiniland) a.c.a.a.f).f1b);
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1099b, hashMap))).b());
                b bVar = new b();
                d dVar = new d();
                bVar.f1098a = dVar;
                dVar.f42a = Boolean.FALSE;
                if (c0.equals("null")) {
                    bVar.f1098a.f42a = Boolean.TRUE;
                } else {
                    try {
                        bVar.a(c0);
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                    }
                }
                ((AppointmentListActivity.a) this.f1100a).a(bVar.f1098a);
            } catch (Exception e3) {
                e3.printStackTrace();
                d dVar2 = new d();
                dVar2.f42a = Boolean.FALSE;
                AppointmentListActivity.a aVar = (AppointmentListActivity.a) this.f1100a;
                AppointmentListActivity.this.runOnUiThread(new AppointmentListActivity.a.C0092a(dVar2));
            }
        }
    }

    public c() {
        super("MEDICAL_APPOINTMENT_LIST");
    }
}

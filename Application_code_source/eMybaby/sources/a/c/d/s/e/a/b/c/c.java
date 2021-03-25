package a.c.d.s.e.a.b.c;

import a.c.a.f.d;
import a.c.d.m.e.k.k;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.edit.MedicalDataEditRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f926b = "https://emybaby.com/api/datosmedicos.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MedicalDataEditRequest f927a;

        /* renamed from: b  reason: collision with root package name */
        public a f928b;

        public a(MedicalDataEditRequest medicalDataEditRequest, a aVar) {
            this.f927a = medicalDataEditRequest;
            this.f928b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f927a != null) {
                    hashMap.put("editardatomedico", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("fecha", this.f927a.f4102b);
                    hashMap.put("fl", String.valueOf(this.f927a.f4103c));
                    hashMap.put("hc", String.valueOf(this.f927a.f4104d));
                    hashMap.put("ac", String.valueOf(this.f927a.f4105e));
                    hashMap.put("efw", String.valueOf((float) this.f927a.f));
                    hashMap.put("idDatoMedico", String.valueOf(this.f927a.f4101a));
                    ((k.a) this.f928b).a(new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f926b, hashMap))).b()))));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                ((k.a) this.f928b).a(bVar);
            }
        }
    }

    public c() {
        super("MEDICAL_DATA_EDIT");
    }
}

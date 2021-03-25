package a.c.d.s.e.a.b.d;

import a.c.d.m.e.k.b;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.list.MedicalDataListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.text.ParseException;
import java.util.HashMap;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f932b = "https://emybaby.com/api/datosmedicos.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f933a;

        /* renamed from: b  reason: collision with root package name */
        public MedicalDataListRequest f934b;

        public a(MedicalDataListRequest medicalDataListRequest, a aVar) {
            this.f933a = aVar;
            this.f934b = medicalDataListRequest;
        }

        public void run() {
            try {
                g a2 = a.c.a.f.d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                hashMap.put("verdatosmedicos", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", this.f934b.f4106a);
                hashMap.put("pass", this.f934b.f4107b);
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(d.this.f932b, hashMap))).b());
                c cVar = new c();
                b bVar = new b();
                cVar.f931a = bVar;
                bVar.f42a = Boolean.FALSE;
                if (c0.equals("null")) {
                    cVar.f931a.f42a = Boolean.TRUE;
                } else {
                    try {
                        cVar.a(c0);
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                    }
                }
                ((a.c.d.m.e.k.b) this.f933a).a(cVar.f931a);
            } catch (Exception e3) {
                e3.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                a aVar = this.f933a;
                if (aVar != null) {
                    a.c.d.m.e.k.b bVar3 = (a.c.d.m.e.k.b) aVar;
                    bVar3.f364b.getActivity().runOnUiThread(new b.a(bVar2));
                }
            }
        }
    }

    public d() {
        super("MEDICAL_DATA_LIST");
    }
}

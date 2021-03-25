package a.c.d.s.e.d.a.b;

import a.c.a.f.d;
import a.c.d.m.i.k.m;
import a.c.d.m.i.k.n;
import a.c.d.r.j;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.edit.BloodPressureEditRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;
import org.json.JSONObject;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f984b = "https://emybaby.com/api/medidatension.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public BloodPressureEditRequest f985a;

        /* renamed from: b  reason: collision with root package name */
        public c f986b;

        public a(BloodPressureEditRequest bloodPressureEditRequest, c cVar) {
            this.f985a = bloodPressureEditRequest;
            this.f986b = cVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                MeasureWithTwoValues<Integer, Integer> measureWithTwoValues = this.f985a.f4117a;
                hashMap.put("editarmedida", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.j.format(measureWithTwoValues.getDate()));
                hashMap.put("titulo", measureWithTwoValues.getTitle());
                hashMap.put("sistolica", String.valueOf(measureWithTwoValues.getFirstValue()));
                hashMap.put("distolica", String.valueOf(measureWithTwoValues.getSecondValue()));
                hashMap.put("idMedida", String.valueOf(measureWithTwoValues.getId()));
                a aVar = new a(new JSONObject(a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(b.this.f984b, hashMap))).b())));
                n nVar = (n) this.f986b;
                nVar.f635b.getActivity().runOnUiThread(new m(nVar, aVar));
            } catch (Exception e2) {
                e2.printStackTrace();
                a aVar2 = new a();
                aVar2.f42a = Boolean.FALSE;
                n nVar2 = (n) this.f986b;
                nVar2.f635b.getActivity().runOnUiThread(new m(nVar2, aVar2));
            }
        }
    }

    public b() {
        super("BLOOD_PRESSURE_EDIT");
    }
}

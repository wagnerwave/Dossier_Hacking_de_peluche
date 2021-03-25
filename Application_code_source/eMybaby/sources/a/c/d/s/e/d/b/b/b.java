package a.c.d.s.e.d.b.b;

import a.c.a.f.d;
import a.c.d.r.j;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.edit.FetalMovementEditRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1004b = "https://emybaby.com/api/movimientofetal.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public FetalMovementEditRequest f1005a;

        /* renamed from: b  reason: collision with root package name */
        public c f1006b;

        public a(FetalMovementEditRequest fetalMovementEditRequest, c cVar) {
            this.f1005a = fetalMovementEditRequest;
            this.f1006b = cVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                MeasureWithTwoValues<Boolean, Boolean> measureWithTwoValues = this.f1005a.f4124a;
                Usuario i = AppMiniland.f().i();
                hashMap.put("editarmovimiento", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.j.format(new Date(measureWithTwoValues.getDate().longValue())));
                hashMap.put("titulo", measureWithTwoValues.getTitle());
                hashMap.put("active1", measureWithTwoValues.getFirstValue().booleanValue() ? String.valueOf(1) : String.valueOf(0));
                hashMap.put("active2", measureWithTwoValues.getSecondValue().booleanValue() ? String.valueOf(1) : String.valueOf(0));
                hashMap.put("idMovimientoFetal", String.valueOf(measureWithTwoValues.getId()));
                a aVar = new a(new JSONObject(a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(b.this.f1004b, hashMap))).b())));
                a.c.d.m.i.k.d dVar = (a.c.d.m.i.k.d) this.f1006b;
                dVar.f551d.getActivity().runOnUiThread(new a.c.d.m.i.k.c(dVar, aVar));
            } catch (Exception e2) {
                e2.printStackTrace();
                a aVar2 = new a();
                aVar2.f42a = Boolean.FALSE;
                a.c.d.m.i.k.d dVar2 = (a.c.d.m.i.k.d) this.f1006b;
                dVar2.f551d.getActivity().runOnUiThread(new a.c.d.m.i.k.c(dVar2, aVar2));
            }
        }
    }

    public b() {
        super("FETAL_MOVEMENT_EDIT");
    }
}

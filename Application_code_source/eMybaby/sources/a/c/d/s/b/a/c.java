package a.c.d.s.b.a;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.emyscale.MyScaleBabyActivity;
import com.cuatroochenta.miniland.model.Measure;
import com.cuatroochenta.miniland.webservices.emyscale.addweight.AddWeightRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f865b;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public d f866a;

        /* renamed from: b  reason: collision with root package name */
        public AddWeightRequest f867b;

        public a(AddWeightRequest addWeightRequest, d dVar) {
            this.f866a = dVar;
            this.f867b = addWeightRequest;
        }

        public void run() {
            a aVar;
            try {
                g a2 = d.a();
                Measure measure = this.f867b.f4092a;
                HashMap hashMap = new HashMap();
                hashMap.put("anadircrecimiento2", "1");
                hashMap.put("idBebe", String.valueOf(this.f867b.f4093b));
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecharevision", measure.getWebseviceStringDate());
                hashMap.put("peso", measure.getWebserviceWeight());
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f865b, hashMap))).b());
                b bVar = new b();
                try {
                    a aVar2 = new a();
                    bVar.f864a = aVar2;
                    aVar2.f42a = Boolean.FALSE;
                    bVar.a(c0);
                    aVar = bVar.f864a;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    aVar = null;
                }
                ((MyScaleBabyActivity) this.f866a).y(aVar);
            } catch (Exception e3) {
                e3.printStackTrace();
                a aVar3 = new a();
                aVar3.f42a = Boolean.FALSE;
                MyScaleBabyActivity myScaleBabyActivity = (MyScaleBabyActivity) this.f866a;
                myScaleBabyActivity.runOnUiThread(new MyScaleBabyActivity.c(aVar3));
            }
        }
    }

    public c() {
        super("ADD_WEIGHT");
    }
}

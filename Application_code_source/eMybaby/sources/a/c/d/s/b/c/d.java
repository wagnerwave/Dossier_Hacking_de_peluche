package a.c.d.s.b.c;

import a.e.a.a.r.b;
import com.cuatroochenta.miniland.emyscale.MyScaleStatisticsActivity;
import com.cuatroochenta.miniland.webservices.emyscale.weightlist.WeightListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f877b;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f878a;

        /* renamed from: b  reason: collision with root package name */
        public WeightListRequest f879b;

        public a(WeightListRequest weightListRequest, a aVar) {
            this.f878a = aVar;
            this.f879b = weightListRequest;
        }

        public void run() {
            b bVar;
            try {
                g a2 = a.c.a.f.d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("verpeso", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("idBebe", String.valueOf(this.f879b.f4094a));
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(d.this.f877b, hashMap))).b());
                c cVar = new c();
                try {
                    b bVar2 = new b();
                    cVar.f876a = bVar2;
                    bVar2.f42a = Boolean.FALSE;
                    if ("null".equals(c0)) {
                        cVar.f876a.f42a = Boolean.TRUE;
                    } else {
                        cVar.a(c0);
                    }
                    bVar = cVar.f876a;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bVar = null;
                }
                ((MyScaleStatisticsActivity) this.f878a).q(bVar);
            } catch (Exception e3) {
                e3.printStackTrace();
                b bVar3 = new b();
                bVar3.f42a = Boolean.FALSE;
                MyScaleStatisticsActivity myScaleStatisticsActivity = (MyScaleStatisticsActivity) this.f878a;
                myScaleStatisticsActivity.runOnUiThread(new MyScaleStatisticsActivity.c(bVar3));
            }
        }
    }

    public d() {
        super("WEIGHT_LIST");
    }
}

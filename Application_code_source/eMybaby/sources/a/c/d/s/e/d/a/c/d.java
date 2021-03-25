package a.c.d.s.e.d.a.c;

import a.c.d.m.i.k.k;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.list.MamaBloodPressureListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f990b = "https://emybaby.com/api/medidatension.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaBloodPressureListRequest f991a;

        /* renamed from: b  reason: collision with root package name */
        public a f992b;

        public a(MamaBloodPressureListRequest mamaBloodPressureListRequest, a aVar) {
            this.f991a = mamaBloodPressureListRequest;
            this.f992b = aVar;
        }

        public void run() {
            try {
                g a2 = a.c.a.f.d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f991a != null) {
                    hashMap.put("vermedidas", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("id", String.valueOf(this.f991a.f4118a));
                    hashMap.put("pass", this.f991a.f4119b);
                    ((k) this.f992b).F(new c().a(b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(d.this.f990b, hashMap))).b())));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                k kVar = (k) this.f992b;
                kVar.getActivity().runOnUiThread(new k.d(bVar));
            }
        }
    }

    public d() {
        super("MAMA_BLOOD_PRESSURE_LIST");
    }
}

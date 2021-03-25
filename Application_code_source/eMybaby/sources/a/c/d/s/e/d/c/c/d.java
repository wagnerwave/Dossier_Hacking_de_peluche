package a.c.d.s.e.d.c.c;

import a.c.d.m.i.k.s;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.list.MamaFundHeightListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1030b = "https://emybaby.com/api/alturautero.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaFundHeightListRequest f1031a;

        /* renamed from: b  reason: collision with root package name */
        public a f1032b;

        public a(MamaFundHeightListRequest mamaFundHeightListRequest, a aVar) {
            this.f1031a = mamaFundHeightListRequest;
            this.f1032b = aVar;
        }

        public void run() {
            try {
                g a2 = a.c.a.f.d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1031a != null) {
                    hashMap.put("veralturas", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("id", String.valueOf(this.f1031a.f4134a));
                    hashMap.put("pass", this.f1031a.f4135b);
                    ((s) this.f1032b).D(new c().a(b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(d.this.f1030b, hashMap))).b())));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                s sVar = (s) this.f1032b;
                sVar.getActivity().runOnUiThread(new s.d(bVar));
            }
        }
    }

    public d() {
        super("MAMA_FUNDAL_HEIGHT_LIST");
    }
}

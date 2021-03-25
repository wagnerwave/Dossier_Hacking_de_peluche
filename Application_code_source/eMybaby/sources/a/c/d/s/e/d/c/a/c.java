package a.c.d.s.e.d.c.a;

import a.c.a.f.d;
import a.c.d.m.i.k.s;
import a.c.d.m.i.k.t;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.add.MamaFundHeightAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1019b = "https://emybaby.com/api/alturautero.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaFundHeightAddRequest f1020a;

        /* renamed from: b  reason: collision with root package name */
        public a f1021b;

        public a(MamaFundHeightAddRequest mamaFundHeightAddRequest, a aVar) {
            this.f1020a = mamaFundHeightAddRequest;
            this.f1021b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1020a != null) {
                    hashMap.put("anadiraltura", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("fecha", this.f1020a.f4128a);
                    hashMap.put("altura", String.valueOf(this.f1020a.f4129b));
                    b bVar = new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1019b, hashMap))).b())));
                    s sVar = (s) this.f1021b;
                    sVar.getActivity().runOnUiThread(new t(sVar, bVar));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b();
                s sVar2 = (s) this.f1021b;
                sVar2.getActivity().runOnUiThread(new t(sVar2, bVar2));
            }
        }
    }

    public c() {
        super("MAMA_FUNDAL_HEIGHT_ADD");
    }
}

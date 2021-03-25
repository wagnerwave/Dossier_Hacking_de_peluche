package a.c.d.s.e.d.c.d;

import a.c.a.f.d;
import a.c.d.m.i.k.s;
import a.c.d.m.i.k.u;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.remove.MamaFundHeightRemoveRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1034b = "https://emybaby.com/api/alturautero.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaFundHeightRemoveRequest f1035a;

        /* renamed from: b  reason: collision with root package name */
        public a f1036b;

        public a(MamaFundHeightRemoveRequest mamaFundHeightRemoveRequest, a aVar) {
            this.f1035a = mamaFundHeightRemoveRequest;
            this.f1036b = aVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1035a != null) {
                    hashMap.put("eliminaraltura", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("idAlturaUtero", String.valueOf(this.f1035a.f4136a));
                    b bVar = new b(new JSONObject(b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f1034b, hashMap))).b())));
                    s sVar = (s) this.f1036b;
                    sVar.getActivity().runOnUiThread(new u(sVar, bVar));
                    return;
                }
                throw null;
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                s sVar2 = (s) this.f1036b;
                sVar2.getActivity().runOnUiThread(new u(sVar2, bVar2));
            }
        }
    }

    public c() {
        super("MAMA_FOUND_HEIGHT_REMOVE");
    }
}

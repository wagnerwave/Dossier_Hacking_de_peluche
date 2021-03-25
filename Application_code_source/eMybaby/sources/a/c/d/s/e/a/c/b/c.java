package a.c.d.s.e.a.c.b;

import a.c.a.f.d;
import a.c.d.m.e.l.k;
import a.c.d.m.e.l.l;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.delete.UltrasoundDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f945b = "https://emybaby.com/api/ecografia.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f946a;

        /* renamed from: b  reason: collision with root package name */
        public UltrasoundDeleteRequest f947b;

        public a(UltrasoundDeleteRequest ultrasoundDeleteRequest, a aVar) {
            this.f946a = aVar;
            this.f947b = ultrasoundDeleteRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("eliminaecografia", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("idEcografia", String.valueOf(this.f947b.f4109a));
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new e.a.a.c0.k.c(a.c.a.d.a.c(c.this.f945b, hashMap))).b());
                a aVar = this.f946a;
                l lVar = (l) aVar;
                lVar.f422b.getActivity().runOnUiThread(new k(lVar, new b(new JSONObject(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                l lVar2 = (l) this.f946a;
                lVar2.f422b.getActivity().runOnUiThread(new k(lVar2, bVar));
            }
        }
    }

    public c() {
        super("ULTRASOUND_DELETE");
    }
}

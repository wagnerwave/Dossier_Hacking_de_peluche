package a.c.d.s.e.d.c.b;

import a.c.a.f.d;
import a.c.d.m.i.k.y;
import a.c.d.m.i.k.z;
import a.c.d.r.j;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.edit.FundalHeightEditRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;
import org.json.JSONObject;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1024b = "https://emybaby.com/api/alturautero.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public FundalHeightEditRequest f1025a;

        /* renamed from: b  reason: collision with root package name */
        public c f1026b;

        public a(FundalHeightEditRequest fundalHeightEditRequest, c cVar) {
            this.f1025a = fundalHeightEditRequest;
            this.f1026b = cVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                hashMap.put("editaraltura", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.j.format(this.f1025a.f4130a));
                hashMap.put("altura", String.valueOf(this.f1025a.f4132c));
                hashMap.put("idAlturaUtero", String.valueOf(this.f1025a.f4133d));
                hashMap.put("titulo", this.f1025a.f4131b);
                a aVar = new a(new JSONObject(a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(b.this.f1024b, hashMap))).b())));
                z zVar = (z) this.f1026b;
                zVar.f672c.getActivity().runOnUiThread(new y(zVar, aVar));
            } catch (Exception e2) {
                e2.printStackTrace();
                a aVar2 = new a();
                aVar2.f42a = Boolean.FALSE;
                z zVar2 = (z) this.f1026b;
                zVar2.f672c.getActivity().runOnUiThread(new y(zVar2, aVar2));
            }
        }
    }

    public b() {
        super("FUNDAL_HEIGHT_EDIT");
    }
}

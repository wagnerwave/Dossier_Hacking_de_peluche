package a.c.d.s.e.d.e.d;

import a.c.d.m.i.k.h0;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.list.MamaWeightListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.text.ParseException;
import java.util.HashMap;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1082b = "https://emybaby.com/api/pesoembarazo.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1083a;

        /* renamed from: b  reason: collision with root package name */
        public MamaWeightListRequest f1084b;

        public a(MamaWeightListRequest mamaWeightListRequest, a aVar) {
            this.f1083a = aVar;
            this.f1084b = mamaWeightListRequest;
        }

        public void run() {
            try {
                g a2 = a.c.a.f.d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                if (this.f1084b != null) {
                    hashMap.put("verpesos", "1");
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("id", this.f1084b.f4151a);
                    hashMap.put("pass", this.f1084b.f4152b);
                    String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(d.this.f1082b, hashMap))).b());
                    c cVar = new c();
                    b bVar = new b();
                    cVar.f1081a = bVar;
                    bVar.f42a = Boolean.FALSE;
                    if (c0.equals("null")) {
                        cVar.f1081a.f42a = Boolean.TRUE;
                    } else {
                        try {
                            cVar.a(c0);
                        } catch (ParseException e2) {
                            e2.printStackTrace();
                        }
                    }
                    ((h0) this.f1083a).G(cVar.f1081a);
                    return;
                }
                throw null;
            } catch (Exception e3) {
                e3.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                h0 h0Var = (h0) this.f1083a;
                h0Var.getActivity().runOnUiThread(new h0.c(bVar2));
            }
        }
    }

    public d() {
        super("MAMA_WEIGHT_LIST");
    }
}

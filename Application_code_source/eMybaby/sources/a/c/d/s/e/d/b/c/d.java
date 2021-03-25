package a.c.d.s.e.d.b.c;

import a.c.d.m.i.k.e;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.list.MamaFetalMovListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1010b = "https://emybaby.com/api/movimientofetal.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MamaFetalMovListRequest f1011a;

        /* renamed from: b  reason: collision with root package name */
        public a f1012b;

        public a(MamaFetalMovListRequest mamaFetalMovListRequest, a aVar) {
            this.f1011a = mamaFetalMovListRequest;
            this.f1012b = aVar;
        }

        public void run() {
            try {
                g a2 = a.c.a.f.d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                hashMap.put("vermovimientos", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", String.valueOf(this.f1011a.f4125a));
                hashMap.put("pass", this.f1011a.f4126b);
                ((e) this.f1012b).F(new c().a(b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(d.this.f1010b, hashMap))).b())));
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = new b();
                bVar.f42a = Boolean.FALSE;
                e eVar = (e) this.f1012b;
                eVar.getActivity().runOnUiThread(new e.f(bVar));
            }
        }
    }

    public d() {
        super("MAMA_FETAL_MOVEMENTS_LIST");
    }
}

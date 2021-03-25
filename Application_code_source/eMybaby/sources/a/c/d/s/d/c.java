package a.c.d.s.d;

import a.c.a.f.d;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.login.GoogleLoginPostRequest;
import com.sozpic.miniland.LoginActivity;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.k.e;
import e.a.a.g0.g.g;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f886b = "https://emybaby.com/api/login.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public d f887a;

        /* renamed from: b  reason: collision with root package name */
        public GoogleLoginPostRequest f888b;

        public a(GoogleLoginPostRequest googleLoginPostRequest, d dVar) {
            this.f887a = dVar;
            this.f888b = googleLoginPostRequest;
        }

        public void run() {
            a aVar;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("googlelogin", "1");
                hashMap.put("googletoken", this.f888b.f4095a);
                String c0 = b.c0(((g) d.a()).g(new e(a.c.a.d.a.c(c.this.f886b, hashMap))).b());
                new b();
                JSONObject jSONObject = new JSONObject(c0);
                aVar = new a();
                aVar.f42a = Boolean.FALSE;
                Usuario U = b.U(jSONObject, (String) null, (String) null);
                if (U != null) {
                    aVar.f885c = U;
                    aVar.f42a = Boolean.TRUE;
                }
            } catch (Exception unused) {
                aVar = new a();
                aVar.f42a = Boolean.FALSE;
            }
            LoginActivity loginActivity = (LoginActivity) this.f887a;
            loginActivity.runOnUiThread(new a.h.a.g(loginActivity, aVar));
        }
    }

    public c() {
        super("LOGIN_POST_SERVICE");
    }
}

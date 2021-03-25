package a.c.d.s.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class b extends a.c.a.g.b {

    /* renamed from: a  reason: collision with root package name */
    public a f864a;

    public final void a(String str) {
        try {
            this.f864a.f42a = Boolean.valueOf(Long.valueOf(new JSONObject(str).getLong("idCrecimiento")) != null);
            if (this.f864a == null) {
                throw null;
            }
        } catch (JSONException e2) {
            a aVar = this.f864a;
            aVar.f42a = Boolean.FALSE;
            aVar.f43b = e2.getMessage();
            e2.printStackTrace();
        }
    }
}

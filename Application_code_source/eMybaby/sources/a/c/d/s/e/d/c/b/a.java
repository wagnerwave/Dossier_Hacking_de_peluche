package a.c.d.s.e.d.c.b;

import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public Long f1023c;

    public a() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_EDITAR_PESO);
    }

    public a(JSONObject jSONObject) {
        Long valueOf = Long.valueOf(jSONObject.optLong("idAlturaUtero", -1));
        this.f1023c = valueOf;
        this.f42a = Boolean.valueOf(valueOf.longValue() != -1);
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_EDITAR_PESO);
    }
}

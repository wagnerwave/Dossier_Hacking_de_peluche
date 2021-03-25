package a.c.d.s.e.d.a.b;

import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public Long f983c;

    public a() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_PESO);
    }

    public a(JSONObject jSONObject) {
        Long valueOf = Long.valueOf(jSONObject.optLong("idMedida", -1));
        this.f983c = valueOf;
        this.f42a = Boolean.valueOf(valueOf.longValue() != -1);
        this.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_PESO);
    }
}

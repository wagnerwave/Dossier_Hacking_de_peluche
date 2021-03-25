package a.c.d.s.e.d.a.a;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public Long f978c;

    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_MEDIDA_TENSION_ARTERIAL);
    }

    public b(JSONObject jSONObject) {
        this.f43b = a.h(R.string.TR_ERROR_GUARDAR_MEDIDA_TENSION_ARTERIAL);
        Long valueOf = Long.valueOf(jSONObject.optLong("idMedida", -1));
        this.f978c = valueOf;
        this.f42a = Boolean.valueOf(valueOf.longValue() != -1);
    }
}

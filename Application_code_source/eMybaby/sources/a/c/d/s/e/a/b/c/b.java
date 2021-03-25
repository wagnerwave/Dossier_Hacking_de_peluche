package a.c.d.s.e.a.b.c;

import a.c.a.d.a;
import a.c.a.g.c;
import com.sozpic.miniland.R;
import org.json.JSONObject;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public Long f925c;

    public b() {
        this.f42a = Boolean.FALSE;
        this.f43b = a.h(R.string.TR_ERROR_EDITAR_ENTRADA);
    }

    public b(JSONObject jSONObject) {
        Long valueOf = Long.valueOf(jSONObject.optLong("idDatoMedico", -1));
        this.f925c = valueOf;
        this.f42a = Boolean.valueOf(valueOf.longValue() != -1);
        this.f43b = a.h(R.string.TR_ERROR_EDITAR_ENTRADA);
    }
}
